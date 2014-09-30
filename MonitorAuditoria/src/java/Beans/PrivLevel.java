/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Javier
 */
class PrivLevel implements Serializable {
    //private int levelNo;
    private String desc;
    private ArrayList<Permission> listPermissions =  new ArrayList<>();
    //public static HashMap<Integer,PrivLevel> mapNiveles = new HashMap<>();

    public PrivLevel() {
    }

    public PrivLevel(String desc) {
        //this.levelNo = levelNo;
        this.desc = desc;
    }

//    public int getLevelNo() {
//        return levelNo;
//    }
//
//    public void setLevelNo(int levelNo) {
//        this.levelNo = levelNo;
//    }
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Permission getPerm(Permissible p) {
        return listPermissions.stream()
                .filter((priv) -> priv.getSubject().equals(p))
                .findFirst().orElse(null);
    }

    public boolean editPermission(Table t, boolean select, boolean insert, boolean delete, boolean update) {
        Permission p = this.getPerm(t);
        if (p != null) {
            p.setPrivileges(select, insert, delete, update);
            return true;
        } else {
            p = new Permission(t, select, insert, delete, update);
            this.listPermissions.add(p);
            return true;
        }
    }

    public boolean editPermission(Column c, boolean select, boolean update) {
        Permission p = this.getPerm(c);
        if (p != null) {
            p.setPrivileges(select, update);
            return true;
        }
        return false;
    }

    public boolean editPermission(Column c, boolean update) {
        Permission p = this.getPerm(c);
        if (p != null) {
            p.setPrivileges(update);
            return true;
        } else {
            this.listPermissions.add(new Permission(c, false, update));//2nd param does nothing
        }
        return false;
    }

    public boolean addPermission(Permission perm) {
        return !listPermissions.stream().anyMatch((p) -> p.getSubject().equals(perm.getSubject())) ? listPermissions.add(perm) : false;
    }

    public ArrayList<Permission> getAllPermissions() {
        return listPermissions;
    }

//    public String toString(){
//        StringBuilder str = new StringBuilder();
//        str.append(Integer.toString(levelNo)).append(";").append(desc);
//        return str.toString();
//    }
//    public String toString() {
//        StringBuilder str = new StringBuilder();
//        str.append(desc).append(";");
//        listPermissions.stream().forEach((p) -> {
//            str.append(p.toString()).append("\n");
//        });
//        return str.toString();
//    }
    public String toString(boolean s) {
        StringBuilder json = new StringBuilder();
        //json.append("{\"sName\":\"").append(desc).append("\",");
        //json.append("{");
        if (s) {
            listPermissions.stream().filter(x -> x.getSubject() instanceof Table).forEach((p) -> {
                json.append("{").append(p.toString()).append("},");
            });
        } else {
            listPermissions.stream().filter(x -> x.getSubject() instanceof Column).forEach((p) -> {
                json.append("{").append(p.toString()).append("},");
            });
        }
        //json.append("},");

        return json.toString();
    }

    public String toStringSummary() {
        StringBuilder json = new StringBuilder();
        json.append("{\"sName\":\"").append(desc).append("\"},");
        return json.toString();
    }
    
   
//    public void write() throws FileNotFoundException, IOException
//    {
//        FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrador\\Documents\\NetBeansProjects\\Security-Manager\\MonitorAuditoria\\archivos\\PrivLevel.bin");
//        ObjectOutputStream out = new ObjectOutputStream(fos);
//        
//        out.writeObject(listPermissions);
//    }
//    
//    public ArrayList read () throws FileNotFoundException, IOException, ClassNotFoundException
//    {
//        FileInputStream fis = new FileInputStream("C:\\Users\\Administrador\\Documents\\NetBeansProjects\\Security-Manager\\MonitorAuditoria\\archivos\\PrivLevel.bin");
//        ObjectInputStream in = new ObjectInputStream(fis);
//        
//        ArrayList<Permission> aux = new ArrayList<>();
//        aux = (ArrayList)in.readObject();
//
//        return aux;
//    }

    ///////////////STATIC METHODS.
//    public static PrivLevel getPrivLevel(int n) {
//        return mapNiveles.containsKey(n) ? mapNiveles.get(n) : null;
//    }
//
//    public static PrivLevel createPrivLevel(int n, String d) {
//        if (!mapNiveles.containsKey(n) && mapNiveles.size() >= n - 1) {
//            if (n > 0 && n <= mapNiveles.size()) {
//                for (int i = n; i < mapNiveles.size() + 1; i++) {
//                    mapNiveles.replace(i + 1, mapNiveles.get(i)).setLevelNo(i + 1);
//                }
//            }
//            return mapNiveles.put(n, new PrivLevel(n, d));
//        }
//        return null;
//    }
//
//    public static PrivLevel createPrivLevelFunctional(int n, String d) {//A little test.
//        if (!mapNiveles.containsKey(n) && mapNiveles.size() >= n - 1) {
//            if (n > 0 && n <= mapNiveles.size()) {
//                for (int i = n; i < mapNiveles.size() + 1; i++) {
//                    mapNiveles.replace(i + 1, mapNiveles.get(i)).setLevelNo(i + 1);
//                }
//            }
//            return mapNiveles.put(n, new PrivLevel(n, d));
//        }
//        return null;
//    }
//
//    public static boolean editPrivLevel(int num, String newDesc) {
//        PrivLevel lev = mapNiveles.values().stream()
//                .filter((lvl) -> lvl.getLevelNo() == num)
//                .findFirst().orElse(null);
//        if (lev != null) {
//            lev.setDesc(newDesc);
//            return true;
//        }
//        return false;
//    }
//
//    public static int hashMapSize() {//How many levels currently in map.
//        return mapNiveles.size();
//    }
//
//    public static String toStringPrivLevels() {
//        StringBuilder str = new StringBuilder();
//        mapNiveles.forEach(null);
//        mapNiveles.values().stream().forEach((p) -> {
//            str.append(p.toString()).append("\n");
//        });
//        return str.toString();
//    }
}
