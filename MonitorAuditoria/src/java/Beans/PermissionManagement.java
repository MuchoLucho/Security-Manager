/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.ArrayList;

/**
 *
 * @author Javier
 */
public class PermissionManagement {

    private ArrayList<User> listUsers = new ArrayList<>();
    private ArrayList<Role> listRoles = new ArrayList<>();
    private ArrayList<PrivLevel> listPrivL = new ArrayList<>();
    private InfoSensibility infoSens = null;

    public PermissionManagement(InfoSensibility info) {
        this.getFromDatabase();
        infoSens = info;
    }

    public User getUser(String name) {
        return listUsers.stream()
                .filter((x) -> x.getName().equals(name))
                .findFirst()
                .get();
    }

    public boolean insertUser(String name) {
        if (!listUsers.stream().anyMatch(((x) -> x.getName().equals(name)))) {
            return listUsers.add(new User(name));
        }
        return false;
    }

    public boolean insertUser(User u) {
        if (!listUsers.stream().anyMatch(((x) -> x.getName().equals(u.getName())))) {
            return listUsers.add(u);
        }
        return false;
    }

    public String toStringUsers() {
        StringBuilder str = new StringBuilder();
        listUsers.stream()
                .forEach((usr) -> str.append(usr.toString()).append(";"));
        return str.toString();
    }

    public Role getRole(String roleName) {
        return listRoles.stream()
                .filter((x) -> x.getName().equals(roleName))
                .findFirst()
                .orElse(null);
    }

    public boolean insertRole(String name) {
        if (!listRoles.stream().anyMatch(((x) -> x.getName().equals(name)))) {
            return listRoles.add(new Role(name));
        }
        return false;
    }

     //Manage Table Permissions 
    public boolean addPermission(String levelName, String tableSpaceName, String tableName, boolean select, boolean insert, boolean delete, boolean update) {//For a table
        Table t = this.infoSens.getTable(tableSpaceName, tableName);
        PrivLevel p = this.getPrivLevel(levelName);
        return (t != null && p != null) ? p.addPermission(new Permission(t, select, insert, delete, update)) : false;
    }

    public boolean editPermission(String levelName, String tableSpaceName, String tableName, boolean select, boolean insert, boolean delete, boolean update) {//For a table
        Table t = this.infoSens.getTable(tableSpaceName, tableName);
        PrivLevel p = this.getPrivLevel(levelName);
        return (t != null && p != null) ? p.editPermission(t, select, insert, delete, update) : false;
    }

    //Manage Column Permissions
    public boolean addPermission(String levelName, String tableSpaceName, String tableName, String colName, boolean select, boolean update) {//For a column
        Column c = this.infoSens.getColumn(tableSpaceName, tableName, colName);
        PrivLevel p = this.getPrivLevel(levelName);
        return (c != null && p != null) ? p.addPermission(new Permission(c, select, update)) : false;
    }

    public boolean editPermission(String levelName, String tableSpaceName, String tableName, String colName, boolean select, boolean update) {//For a column
        Column c = this.infoSens.getColumn(tableSpaceName, tableName, colName);
        PrivLevel p = this.getPrivLevel(levelName);
        return (c != null && p != null) ? p.editPermission(c, select, update) : false;
    }
    
    
    
//    //Manage Table Permissions 
//    public boolean addPermission(String roleName, String tableSpaceName, String tableName, boolean select, boolean insert, boolean delete, boolean update) {//For a table
//        Table t = this.infoSens.getTable(tableSpaceName, tableName);
//        Role r = this.getRole(roleName);
//        return (t != null && r != null) ? r.addPermission(new Permission(t, select, insert, delete, update)) : false;
//    }
//
//    public boolean editPermission(String roleName, String tableSpaceName, String tableName, boolean select, boolean insert, boolean delete, boolean update) {//For a table
//        Table t = this.infoSens.getTable(tableSpaceName, tableName);
//        Role r = this.getRole(roleName);
//        return (t != null && r != null) ? this.getRole(roleName).editPermission(t, select, insert, delete, update) : false;
//    }
//
//    //Manage Column Permissions
//    public boolean addPermission(String roleName, String tableSpaceName, String tableName, String colName, boolean select, boolean update) {//For a table
//        Column c = this.infoSens.getColumn(tableSpaceName, tableName, colName);
//        Role r = this.getRole(roleName);
//        return (c != null && r != null) ? this.getRole(roleName).addPermission(new Permission(c, select, update)) : false;
//    }
//
//    public boolean editPermission(String roleName, String tableSpaceName, String tableName, String colName, boolean select, boolean update) {//For a table
//        Column c = this.infoSens.getColumn(tableSpaceName, tableName, colName);
//        Role r = this.getRole(roleName);
//        return (c != null && r != null) ? this.getRole(roleName).editPermission(c, select, update) : false;
//    }
    
    
    
    
    
    
    
    
    
    
    

    //Manage Function/Procedure Permissions
    //Not implemented yet.  
    private void getFromDatabase() {
        System.out.println("YOU CANT GET USERS OR ROLE FROM DATABASE YET.");
    }
    ////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////
    //Manage PrivLevels
//        public PrivLevel getPrivLevel(int n) {
//            return listPermissions.containsKey(n) ? listPermissions.get(n) : null;
//    }

    
    
    public boolean existsPrivilege(String d){
        return listPrivL.stream().anyMatch(x->x.getDesc().equals(d));
    }
    
    public PrivLevel getPrivLevel(String levelName) {
        return listPrivL.stream()
                .filter((x) -> x.getDesc().equals(levelName))
                .findFirst()
                .orElse(null);
    }
    
    public PrivLevel createPrivLevel(String d) {
        PrivLevel privlvl = !existsPrivilege(d) ? (new PrivLevel(d)):null;
        listPrivL.add(privlvl);
        return privlvl;
    }

//    public PrivLevel createPrivLevelFunctional(int n, String d) {//A little test.
//        if (!listPermissions.containsKey(n) && listPermissions.size() >= n - 1) {
//            if (n > 0 && n <= listPermissions.size()) {
//                for (int i = n; i < listPermissions.size() + 1; i++) {
//                    listPermissions.replace(i + 1, listPermissions.get(i)).setLevelNo(i + 1);
//                }
//            }
//            return listPermissions.put(n, new PrivLevel(n, d));
//        }
//        return null;
//    }

    public boolean editPrivLevel(String oldDesc,String newDesc) {
        PrivLevel lev = listPrivL.stream()
                .filter((lvl) -> lvl.getDesc().equals(oldDesc))
                .findFirst().orElse(null);
        if (lev != null) {
            lev.setDesc(newDesc);
            return true;
        }
        return false;
    }

    public int listPermissionSize() {//How many levels currently in map.
        return listPrivL.size();
    }

    public String toStringPrivLevels() {
        StringBuilder str = new StringBuilder();
        listPrivL.forEach(null);
        listPrivL.stream().forEach((p) -> {
            str.append(p.toString()).append("\n");
        });
        return str.toString();
    }
    
    

}
