/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Javier
 */
public class Permission implements Comparable<Permission>{

    private Permissible subject;
    boolean[] privileges = new boolean[4];/* 0-select 1-insert 2-delete 3-update IF PROCEDURE THEN ONLY 0-EXECUT.*/
    //FOR COLUMN 2 update

    public Permission(Permissible p, boolean select, boolean insert, boolean delete, boolean update) {//For a table
        subject = p;
        privileges[0] = select;
        privileges[1] = insert;
        privileges[2] = update;
        privileges[3] = delete;
    }

    public Permission(Permissible p, boolean select, boolean update) {//For a column
        subject = p;
        privileges[0] = select;
        privileges[1] = update;

    }

    public Permission() {
        for (int i = 0; i < 4; i++) {
            privileges[i] = false;
        }
    }
    public Permission(Permissible p) {
        subject = p;
        for (int i = 0; i < 4; i++) {
            privileges[i] = false;
        }
    }
    
    
    public Permissible getSubject() {
        return subject;
    }

    public void setSubject(Permissible subject) {
        this.subject = subject;
    }

    public boolean getPrivileges(int i) {
        return i > 0 && i < 4 ? privileges[i] : false;
    }

    public void setPrivileges(boolean priv, int i) {
        if (i > 0 && i < 4) {
            privileges[i] = priv;
        }
    }

    public void setPrivileges(boolean select, boolean insert, boolean delete, boolean update) {//For a table
        privileges[0] = select;
        privileges[1] = insert;
        privileges[2] = update;
        privileges[3] = delete;
    }

    public void setPrivileges(boolean update) {//For a Column
        privileges[0] = update;
    }

    public void setPrivileges(boolean select, boolean update) {//For a Column //DEPRECATED
        privileges[0] = select;
        privileges[1] = update;
    }

    public static Permission mergePermissions(Permission a, Permission b) {//Returns an temporary 
        //Permission, product of an OR operation between the privileges of the two parameters.
        if (a.getSubject().equals(b.getSubject())) {
            if (a.getSubject() instanceof Column) {
                return new Permission(a.getSubject(), a.privileges[0] || b.privileges[0], a.privileges[1] || b.privileges[1]);
            }
            if (a.getSubject() instanceof Table){
                return new Permission(a.getSubject(), a.privileges[0] || b.privileges[0], a.privileges[1] || b.privileges[1], a.privileges[2] || b.privileges[2], a.privileges[3] || b.privileges[3]);
            }
        }
        return null;
    }

    @Override
    public int compareTo(Permission o) {
           if(o.subject.equals(null)||this.subject.equals(null))return -1;
           return this.subject.getName().compareTo(o.subject.getName());

    }

    public String toQuery() {
        StringBuilder str = new StringBuilder();
        if(subject instanceof Table){
                if(privileges[0])str.append("select").append(";");
                if(privileges[1])str.append("insert").append(";");
                if(privileges[2])str.append("update").append(";");
                if(privileges[3])str.append("delete").append(";");
        }
        else{
            if(privileges[0])str.append("select").append(";");
            if(privileges[0])str.append("update").append(";");
        }
        return str.toString();
    }
    
    public String toString() {
		
            StringBuilder json=new StringBuilder();
            
           
            if(subject instanceof Table)
            {
                String[] tbsdottb = this.subject.getDBDir().split("\\.");
                json.append("\"tName\":\"").append(tbsdottb[1]).append("\",");
                json.append("\"tablespace\":\"").append(tbsdottb[0]).append("\",");
                /*if(privileges[0])*/json.append("\"select\":\"").append(privileges[0] ? "true":"false").append("\",");
                /*if(privileges[1])*/json.append("\"insert\":\"").append(privileges[1] ? "true":"false").append("\",");
                /*if(privileges[2])*/json.append("\"update\":\"").append(privileges[2] ? "true":"false").append("\",");
                /*if(privileges[3])*/json.append("\"delete\":\"").append(privileges[3] ? "true":"false").append("\"");
            } else {
                    String aux = this.subject.getDBDir();
                    String tName = aux.split("\\.")[0];
                    json.append("\"tName\":\"").append(tName).append("\",");
                    json.append("\"cName\":\"").append(this.subject.getName()).append("\",");
                    /*if(privileges[1])*/json.append("\"update\":\"").append(privileges[2] ? "true":"false").append("\"");
                }
            return json.toString();
	}
    

}
