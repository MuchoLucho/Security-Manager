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

    public Permission() {
        for(int i=0;i<4;i++)privileges[i]=false;
    }

    public Permissible getSubject() {
        return subject;
    }

    public void setSubject(Permissible subject) {
        this.subject = subject;
    }
    public boolean getPrivileges(int i) {
        return i>0&&i<4 ? privileges[i]:false;
    }

    public void setPrivileges(boolean priv,int i) {
        if(i>0&&i<4) privileges[i]=priv;
    }

}
