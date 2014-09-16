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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getMaxLvl(){
        return listPerm.stream()
                .map((x)->x.getSubject().getPrivLevel().getLevelNo())
                .max(Integer::max).get();//CHECK IF THIS WORKS. (Pretty sure it does)
    }
    
}
