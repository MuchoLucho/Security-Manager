package Beans;

import java.util.ArrayList;

public class Role {
    private String name;
    //private ArrayList<Permission> listPerm = new ArrayList<>();
    private final ArrayList<PrivLevel> listAssignedLevels = new ArrayList<>();

    public Role(String name) {
        this.name = name;
        DBConnector.createRole(name); //Si Si Si, No No No
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addAssignedLevel(PrivLevel pr) {
            if(!listAssignedLevels.stream().anyMatch((p) -> p.getDesc().equals(pr.getDesc()))){
                listAssignedLevels.add(pr);
                this.generateGrants(pr);
            }
            return !listAssignedLevels.stream().anyMatch((p) -> p.getDesc().equals(pr.getDesc())) ? listAssignedLevels.add(pr) : false;
    }
    private void generateGrants(PrivLevel pr){
        ArrayList<Permission> lPerm = pr.getAllPermissions();
        lPerm.stream().forEach(per->{
            if(per.getSubject() instanceof Table){
                DBConnector.grantToRoles(Permission.getPrivilegeString(Permission.SELECT),per.getSubject().getName(),this.name);
                DBConnector.grantToRoles(Permission.getPrivilegeString(Permission.INSERT),per.getSubject().getName(),this.name);
                DBConnector.grantToRoles(Permission.getPrivilegeString(Permission.DELETE),per.getSubject().getName(),this.name);
                DBConnector.grantToRoles(Permission.getPrivilegeString(Permission.UPDATE),per.getSubject().getName(),this.name);
            }
            else{
                String table = per.getSubject().getDBDir().split("\\.")[0];
                DBConnector.grantColToRole(per.getSubject().getName(),table,Permission.getPrivilegeString(Permission.UPDATE),this.name);
            }
        });
        
        
    }

    public PrivLevel getAssignedLevel(String name) {
        return listAssignedLevels.stream()
                .filter((priv) -> priv.getDesc().equals(name))
                .findFirst().orElse(null);
    }

    public boolean removeLevel(String name) {
        return listAssignedLevels.remove(this.getAssignedLevel(name));
    }
   
    public static Role createFromDatabase() {
        return null;//Should somehow get a role already created and represent it as a logical object.
    }

    public ArrayList<Permission> getUnifiedPermissions() {//This with more lambdas would be nice.
        ArrayList<Permission> allPerms = new ArrayList<>();
        ArrayList<Permission> distinctPerms = new ArrayList<>();
        listAssignedLevels.stream()
                .forEach(p -> allPerms.addAll(p.getAllPermissions()));
        allPerms.stream()
                .sorted()
                .forEach(x -> System.out.println(x.getSubject().getName()));
        //Watch out!
        Permission a;
        Permission b;
        Permission aux = null;
        for (int i = 0; i < allPerms.size() - 1; i++) {
            a = allPerms.get(i);
            b = allPerms.get(i + 1);
            if (a.compareTo(b) == 0) {
                if (aux == null) {
                    aux = Permission.mergePermissions(a, b);
                } else {
                    aux = Permission.mergePermissions(b, aux);
                }
            } else {
                if (aux == null) {
                    distinctPerms.add(a);
                } else {
                    distinctPerms.add(aux);
                    aux = null;
                }
            }
        }
        return distinctPerms;
    }

    public void generateDBRoles() {
        this.getUnifiedPermissions().stream().forEach(
                x -> {
                    DBConnector.GrantRoles(x.toQuery(), this.name);
                }
        );
    }

    public String toString() {
        StringBuilder json = new StringBuilder();
        json.append("{\"name\":\"").append(this.name).append("\",");
        listAssignedLevels.stream().forEach((p) -> {
            json.append(p.toStringSummary());
        });
        json.append("},");
        return json.toString();
    }

    public String toStringSummary() {
        StringBuilder json = new StringBuilder();
        json.append("{\"name\":\"").append(this.name).append("\"},");
        return json.toString();
    }

    public boolean hasPriv(String desc) {
        boolean success = this.listAssignedLevels.stream().anyMatch(x->x.getDesc().equals(desc));
            return success;
    }
}

//Exported to PrivLevel which owns  permissions now.
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

//    public String generateDBRoles(){
//        StringBuilder str = new StringBuilder();
//        this.getUnifiedPermissions().stream().forEach(x->str.append(x.toQuery()).append("\n"));//THIS WONT ACTUALLY WORK CAUSE COLUMN CANT YET GET TABLE NAME.
//        return str.toString();
//    }

//
//    public String toStringRoleSens() {
//        StringBuilder json = new StringBuilder("");
//         listAssignedLevels.stream().forEach((p) -> {
//            if()
//        });
//         json.toString();
//    }

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
