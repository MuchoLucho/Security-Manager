package Beans;

import com.google.gson.Gson;

public class ReadJSON {

    public void setTables(String json, String level) {
        Tables[] t = new Gson().fromJson(json, Tables[].class);
        for (Tables tt : t) {
//            tt.tName;
//             tt.tablespace;
//             tt.insert;
//             tt.select;
//             tt.delte;
//             tt.update;
        }
    }

    public void setColumns(String json, String level) {
        Columns[] c = new Gson().fromJson(json, Columns[].class);
        //Then you can loop "t" and get attributes like "tName" or "delete"    
        for (Columns cc : c) {
//            cc.cName;
//             cc.tName;
//             cc.update;
        }
    }

    public void setRsrc(String json, String level) {
        Rsrc[] r = new Gson().fromJson(json, Rsrc[].class);
        for (Rsrc rr : r) {
            //rr.rName;
            //rr.type;
            //rr.selected;
        }
    }

    public void setSens(String json, String rol) {
        Sens[] s = new Gson().fromJson(json, Sens[].class);
        for (Sens ss : s) {
            //ss.name;
            //ss.selected;
        }
    }

    public void setRoles(String json, String user) {
        Roles[] r = new Gson().fromJson(json, Roles[].class);
        for (Roles rr : r) {
            //rr.name;
            //rr.selected;
        }
    }
};

/*Dummy Classes for extracting info from JSON as Java Objects*/
class Tables {

    public String tName;
    public String tablespace;
    public boolean insert;
    public boolean select;
    public boolean delte;
    public boolean update;
};

class Columns {

    public String tName;
    public String cName;
    public boolean update;
};

class Rsrc {

    public String rName;
    public String type;
    public boolean selected;
};

class Sens {

    public String name;
    public boolean selected;
};

class Roles {

    public String name;
    public boolean selected;
};