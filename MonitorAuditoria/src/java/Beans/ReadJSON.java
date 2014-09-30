package Beans;

import com.google.gson.Gson;
import java.io.Serializable;

public class ReadJSON implements Serializable {

    public static void setTables(PermissionManagement perMan,String json,String levelName) {
        JSONTable[] t = new Gson().fromJson(json, JSONTable[].class);
        for (JSONTable tt : t) {
            perMan.editPermission(levelName, tt.tablespace, tt.tName, tt.select, tt.insert, tt.delete, tt.update);
        }
    }

    public static void setColumns(PermissionManagement perman,String json, String level) {
        JSONColumn[] c = new Gson().fromJson(json, JSONColumn[].class);
        Tablespace aux;
        for (JSONColumn cc : c) {
                aux = perman.getInfoSens().belongsTablespace(cc.tName);
                perman.editPermission(level,aux.getName(), cc.tName, cc.cName,true,cc.update);           
        }
    }

    public static void setRsrc(String json, String level) {
        JSONRsrc[] r = new Gson().fromJson(json, JSONRsrc[].class);
        for (JSONRsrc rr : r) {
            //rr.rName;
            //rr.type;
            //rr.selected;
        }
    }

    public static void setSens(PermissionManagement perman, String rol, String json) {//updates the damn privileges.
        JSONSens[] s = new Gson().fromJson(json, JSONSens[].class);
        Role r = perman.getRole(rol);
        if (r != null) {
            for (JSONSens ss : s) {
                if(r.hasPriv(ss.name)&&!ss.selected){
                    perman.removePrivFromRole(rol,ss.name);
                }
                else{
                    if(!r.hasPriv(ss.name)&&ss.selected){
                        perman.givePrivsToRole(rol, ss.name);
                    }
                }
            }
        }

    }

    public static void setRoles(PermissionManagement perman, String user, String json) {
        JSONRole[] r = new Gson().fromJson(json, JSONRole[].class);
        User u = perman.getUser(user);
        if(u!=null){
            for (JSONRole rr : r) {
                if(u.hasRole(rr.name)&&!rr.selected){
                    perman.removeRoleFromUser(user,rr.name);
                }
                 else{
                    if(!u.hasRole(rr.name)&&rr.selected){
                        perman.grantRole(user,rr.name);
                    }
                }
            //rr.name;
            //rr.selected;
            }
        }
        
    }
};

/*Dummy Classes for extracting info from JSON as Java Objects*/
class JSONTable {

    public String tName;
    public String tablespace;
    public boolean insert;
    public boolean select;
    public boolean delete;
    public boolean update;
};

class JSONColumn {

    public String tName;
    public String cName;
    public boolean update;
};

class JSONRsrc {

    public String rName;
    public String type;
    public boolean selected;
};

class JSONSens {

    public String name;
    public boolean selected;
};

class JSONRole {

    public String name;
    public boolean selected;
};
