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
public class InfoSensibility {
    ArrayList<Tablespace> tbsList = new ArrayList<>();
    
    public Tablespace getTableSpace(String name){
        for(Tablespace t:tbsList){
            if(t.getName().equals(name))
                return t;
        }
        return null;
    }
    
    public boolean setSensibiltiy(String tablespace,String table, String column,int sens){
        Tablespace tbsp = this.getTableSpace(tablespace);
        if(tbsp!=null)
            return tbsp.setSensibility(table,column,sens);
        return false;
    }
    public boolean setSensibiltiy(String tablespace,String table,int sens){
        Tablespace tbsp = this.getTableSpace(tablespace);
        if(tbsp!=null)
            return tbsp.setSensibility(table,sens);
        return false;
    }
    public boolean createLevel(int num,String desc){
        return PrivLevel.createPrivLevel(num, desc)!=null;
    }
    public String toStringLevels(){
       return PrivLevel.toStringPrivLevels();
    }  
    
}
