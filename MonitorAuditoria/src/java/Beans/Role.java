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
public class Role {

    private String name;
    private ArrayList<Permission> listPerm = new ArrayList<>();

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxLvl() {
        return listPerm.stream()
                .mapToInt((x) -> x.getSubject().getPrivLevel().getLevelNo())
                .max().getAsInt();
    }

    public boolean addPermission(Permission perm) {
        return !listPerm.stream().anyMatch((p) -> p.getSubject().equals(perm.getSubject())) ? listPerm.add(perm) : false;
    }

    public Permission getPerm(Permissible p) {
        return listPerm.stream()
                .filter((priv) -> priv.getSubject().equals(p))
                .findFirst().orElse(null);
    }

    public boolean editPermission(Table t, boolean select, boolean insert, boolean delete, boolean update) {
        Permission p = this.getPerm(t);
        if (p != null) {
            p.setPrivileges(select, insert, delete, update);
            return true;
        }
        return false;
    }

    public boolean editPermission(Column c, boolean select, boolean update) {
        Permission p = this.getPerm(c);
        if (p != null) {
            p.setPrivileges(select, update);
            return true;
        }
        return false;
    }

    public static boolean createOReplaceRole() {
        return false;//THIS IS SUPPOSED TO CREATE A ROLE IN THE DATABASE.
    }

    public static Role createFromDatabase() {
        return null;//Should somehow get a role already created and represent it as a logical object.
    }
}
