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
public class Permission {

    private Permissible subject;
    boolean[] privileges = new boolean[4];/* 0-SELECT 1-INSERT 2-DELETE 3-UPDATE IF PROCEDURE THEN ONLY 0-EXECUT.*/


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

    public void setPrivileges(boolean select, boolean update) {//For a Column
        privileges[0] = select;
        privileges[1] = update;
    }

}
