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
public class User {
    private String name;
    private PrivLevel userLevel;
    private ArrayList<Role> listRoles = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }
    
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole(String name) {
        return listRoles.stream()
                .filter((r)->r.getName().equals(name))
                .findFirst()
                .get();
    }

    public void setRole(Role rol) {
        if((!listRoles.stream().anyMatch((r)->r.getName().equals(rol.getName())))&&rol.getMaxLvl()<=userLevel.getLevelNo())
            listRoles.add(rol);
    }
    
    
    
    
}
