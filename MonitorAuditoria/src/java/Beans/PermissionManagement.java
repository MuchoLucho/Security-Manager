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
    
    public User getUser(String name){
            return listUsers.stream()
                    .filter((x)->x.getName().equals(name))
                    .findFirst()
                    .get();
    }
    public boolean insertUser(String name){
        if(!listUsers.stream().anyMatch(((x)->x.getName().equals(name))))return listUsers.add(new User(name));
        return false;
    }
    
    public boolean insertUser(User u){
        if(!listUsers.stream().anyMatch(((x)->x.getName().equals(u.getName()))))return listUsers.add(u);
        return false;
    }
    
}
