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

    public boolean insertUser(String name, String pass) {
        if (!listUsers.stream().anyMatch(((x) -> x.getName().equals(name)))) {
            DBConnector.createUser(name, pass);
            BitacoraLuis.logCreation("user");
            return listUsers.add(new User(name));
        }
        return false;
    }

    public boolean insertUser(User u, String pass) {
        if (!listUsers.stream().anyMatch(((x) -> x.getName().equals(u.getName())))) {
            DBConnector.createUser(u.getName(), pass);
            BitacoraLuis.logCreation("user");
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

    public String toStringRoles() {
        StringBuilder str = new StringBuilder();
        listRoles.stream().forEach(x -> str.append(x.toString()));
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
            BitacoraLuis.logCreation("role");
            return listRoles.add(new Role(name));
        }
        return false;
    }

    public boolean grantRole(String user, String roleName) {
        Role r = this.getRole(roleName);
        User u = this.getUser(user);
        if (r != null && u != null) {
            u.setRole(r);
            DBConnector.GrantRoles(roleName, user);
            return true;
        }
        return false;
    }

    //Manage Table Permissions 
    public boolean addPermission(String levelName, String tableSpaceName, String tableName, boolean select, boolean insert, boolean delete, boolean update) {//For a table
        Table t = this.infoSens.getTable(tableSpaceName, tableName);
        PrivLevel p = this.getPrivLevel(levelName);
        if (t != null && p != null) {
            BitacoraLuis.logCreation("permission");
            return p.addPermission(new Permission(t, select, insert, delete, update));
        }
        return false;
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
        DBConnector con = new DBConnector();
        //LEER DE ARCHIVO.
        DBConnector.Usuarios(listUsers);
        DBConnector.getAllRoles(listRoles);
    }
    ////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////
    //Manage PrivLevels
//        public PrivLevel getPrivLevel(int n) {
//            return listPermissions.containsKey(n) ? listPermissions.get(n) : null;
//    }

    private void createTrash(String privlvl) {
        ArrayList<Tablespace> lista = infoSens.tbsList;
        for (Tablespace tbs : lista) {
            for (Table tab : tbs.getTabs()) {
                this.addPermission(privlvl, tbs.getName(), tab.getName(), false, false, false, false);
                for (Column col : tab.getCols()) {
                    this.addPermission(privlvl, tbs.getName(), tab.getName(), col.getName(), false, false);
                }
            }
        }

    }

    public boolean existsPrivilege(String d) {
        return listPrivL.stream().anyMatch(x -> x.getDesc().equals(d));
    }

    public PrivLevel getPrivLevel(String levelName) {
        return listPrivL.stream()
                .filter((x) -> x.getDesc().equals(levelName))
                .findFirst()
                .orElse(null);
    }

    public String getAllPrivLevels() {
        StringBuilder str = new StringBuilder();
        listPrivL.stream().forEach(x -> str.append(x.toString()));
        return str.toString();
    }

    public PrivLevel createPrivLevel(String d) {
        PrivLevel privlvl = !existsPrivilege(d) ? (new PrivLevel(d)) : null;
        
        if (privlvl != null) {
            this.listPrivL.add(privlvl);
            this.createTrash(privlvl.getDesc());
        }
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
    public boolean editPrivLevel(String oldDesc, String newDesc) {
        PrivLevel lev = listPrivL.stream()
                .filter((lvl) -> lvl.getDesc().equals(oldDesc))
                .findFirst().orElse(null);
        if (lev != null) {
            lev.setDesc(newDesc);
            return true;
        }
        return false;
    }

    public boolean editPrivLevelPermissionsTable(String lvlDesc, String tablespace, String table, boolean select, boolean insert, boolean update, boolean delete) {
        PrivLevel lev = this.getPrivLevel(lvlDesc);
        Table tab = this.infoSens.getTable(tablespace, table);
        return lev.editPermission(tab, select, insert, delete, update);
    }

    public boolean editPrivLevelPermissionsColumn(String lvlDesc, String tablespace, String table, String column, boolean update) {
        PrivLevel lev = this.getPrivLevel(lvlDesc);
        Column col = this.infoSens.getTable(tablespace, table).getColumn(column);
        return lev.editPermission(col, update);
    }

    public int listPermissionSize() {//How many levels currently in map.
        return listPrivL.size();
    }

    public String toStringAllPrivLevels() {
        StringBuilder str = new StringBuilder("[");
        if(!listPrivL.isEmpty()){
            listPrivL.stream().forEach((p) -> {
                str.append(p.toStringSummary());//names only
             });
        }
        else{
            str.append("[{\"sName\":\"No Data\"}]");
        }
        str.replace(str.length() - 1, str.length(), "]");
        return str.toString();
    }

    public String toStringPrivLevelTables(String privLevel) {
        StringBuilder str = new StringBuilder("[");
        PrivLevel p = this.listPrivL.stream().filter(x -> x.getDesc().equals(privLevel)).findFirst().get();
        str.append(p.toString(true))
                .replace(str.length() - 1, str.length(), "]");
        return str.toString();
    }

    public String toStringPrivLevelColumns(String privLevel) {
        StringBuilder str = new StringBuilder("[");
        PrivLevel p = this.listPrivL.stream().filter(x -> x.getDesc().equals(privLevel)).findFirst().get();
        str.append(p.toString(false))
                .replace(str.length() - 1, str.length(), "]");

        return str.toString();
    }

    public String toStringRolesSpecific(String roles) {
        StringBuilder str = new StringBuilder("\"[");
        Role p = this.listRoles.stream().filter(x -> x.getName().equals(roles)).findFirst().get();
        str.append(p.toString())
                .replace(str.length() - 1, str.length(), "]\"");
        return str.toString();
    }

    public String toStringRolesGeneral() {
        StringBuilder str = new StringBuilder("\"[");

        listRoles.stream().forEach((p) -> {
            str.append(p.toStringSummary());
        });
        str.replace(str.length() - 1, str.length(), "]\"");
        return str.toString();
    }

    public String toStringUsersSpecific(String userName) {
        StringBuilder str = new StringBuilder("\"[");
        User u = this.listUsers.stream().filter(x -> x.getName().equals(userName)).findFirst().get();
        str.append(u.toString())
                .replace(str.length() - 1, str.length(), "]\"");

        return str.toString();
    }

    public String toStringUsersGeneral() {
        StringBuilder str = new StringBuilder("\"[");

        listUsers.stream().forEach((p) -> {
            str.append(p.toStringSummary());
        });
        str.replace(str.length() - 1, str.length(), "]\"");
        return str.toString();
    }

}
