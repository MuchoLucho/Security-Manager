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
    public boolean addPermission(String roleName, String tableSpaceName, String tableName, boolean select, boolean insert, boolean delete, boolean update) {//For a table
        Table t = this.infoSens.getTable(tableSpaceName, tableName);
        Role r = this.getRole(roleName);
        return (t != null && r != null) ? r.addPermission(new Permission(t, select, insert, delete, update)) : false;
    }

    public boolean editPermission(String roleName, String tableSpaceName, String tableName, boolean select, boolean insert, boolean delete, boolean update) {//For a table
        Table t = this.infoSens.getTable(tableSpaceName, tableName);
        Role r = this.getRole(roleName);
        return (t != null && r != null) ? this.getRole(roleName).editPermission(t, select, insert, delete, update) : false;
    }

    //Manage Column Permissions
    public boolean addPermission(String roleName, String tableSpaceName, String tableName, String colName, boolean select, boolean update) {//For a table
        Column c = this.infoSens.getColumn(tableSpaceName, tableName, colName);
        Role r = this.getRole(roleName);
        return (c != null && r != null) ? this.getRole(roleName).addPermission(new Permission(c, select, update)) : false;
    }

    public boolean editPermission(String roleName, String tableSpaceName, String tableName, String colName, boolean select, boolean update) {//For a table
        Column c = this.infoSens.getColumn(tableSpaceName, tableName, colName);
        Role r = this.getRole(roleName);
        return (c != null && r != null) ? this.getRole(roleName).editPermission(c, select, update) : false;
    }

    //Manage Function/Procedure Permissions
    //Not implemented yet.  
    private void getFromDatabase() {
        System.out.println("YOU CANT GET USERS OR ROLE FROM DATABASE YET.");
    }

}
