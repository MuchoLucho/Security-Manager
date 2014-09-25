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
    //private ArrayList<Permission> listPerm = new ArrayList<>();
    private ArrayList<PrivLevel> listAssignedLevels = new ArrayList<>();

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public int getMaxLvl() {
//        return listPerm.stream()
//                .mapToInt((x) -> x.getSubject().getPrivLevel().getLevelNo())
//                .max().getAsInt();
//    }
// EXPORTED TO PRIVLEVEL
//    public boolean addPermission(Permission perm) {
//        return !listPerm.stream().anyMatch((p) -> p.getSubject().equals(perm.getSubject())) ? listPerm.add(perm) : false;
//    }
//
//    public Permission getPerm(Permissible p) {
//        return listPerm.stream()
//                .filter((priv) -> priv.getSubject().equals(p))
//                .findFirst().orElse(null);
//    }
//    
    public boolean addAssignedLevel(PrivLevel pr) {
        return !listAssignedLevels.stream().anyMatch((p) -> p.getDesc().equals(pr.getDesc())) ? listAssignedLevels.add(pr) : false;
    }

    public PrivLevel getAssignedLevel(String name) {
        return listAssignedLevels.stream()
                .filter((priv) -> priv.getDesc().equals(name))
                .findFirst().orElse(null);
    }

    public boolean removeLevel(String name) {
        return listAssignedLevels.remove(this.getAssignedLevel(name));
    }

//Exported to PrivLevel which owns permissions now.
//    public boolean editPermission(Table t, boolean select, boolean insert, boolean delete, boolean update) {
//        Permission p = this.getPerm(t);
//        if (p != null) {
//            p.setPrivileges(select, insert, delete, update);
//            return true;
//        }
//        return false;
//    }
//
//    public boolean editPermission(Column c, boolean select, boolean update) {
//        Permission p = this.getPerm(c);
//        if (p != null) {
//            p.setPrivileges(select, update);
//            return true;
//        }
//        return false;
//    }
    public static boolean createOReplaceRole() {
        return false;//THIS IS SUPPOSED TO CREATE A ROLE IN THE DATABASE.
    }

    public static Role createFromDatabase() {
        return null;//Should somehow get a role already created and represent it as a logical object.
    }

    public ArrayList<Permission> getUnifiedPermissions() {//This with more lambdas would be nice.
        ArrayList<Permission> allPerms = new ArrayList<>();
        ArrayList<Permission> distinctPerms = new ArrayList<>();
        listAssignedLevels.stream()
                .forEach(p->allPerms.addAll(p.getAllPermissions()));
        allPerms.stream()
                .sorted()
                .forEach(x->System.out.println(x.getSubject().getName()));
        //Watch out!
        Permission a;
        Permission b;
        Permission aux = null;
        for(int i=0;i<allPerms.size()-1;i++){
            a=allPerms.get(i);
            b=allPerms.get(i+1);
            if(a.compareTo(b)==0){
                if(aux==null)
                    aux = Permission.mergePermissions(a, b);
                else
                    aux = Permission.mergePermissions(b, aux);
            }else{
                if(aux==null) 
                    distinctPerms.add(a);
                else {
                    distinctPerms.add(aux);
                    aux = null;
                }  
            }
        }
        return distinctPerms;
    }
    public String generateDBRoles(){
        StringBuilder str = new StringBuilder();
        this.getUnifiedPermissions().stream().forEach(x->str.append(x.toQuery()).append("\n"));//THIS WONT ACTUALLY WORK CAUSE COLUMN CANT YET GET TABLE NAME.
        return str.toString();
    }
}
