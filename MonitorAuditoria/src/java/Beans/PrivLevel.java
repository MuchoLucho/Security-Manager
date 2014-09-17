/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.HashMap;

/**
 *
 * @author Javier
 */
class PrivLevel {
    private int levelNo;
    private String desc;
    public static HashMap<Integer,PrivLevel> mapNiveles = new HashMap<>();

    public PrivLevel(int levelNo, String desc) {
        this.levelNo = levelNo;
        this.desc = desc;
    }
    
    public PrivLevel() {
    }

    public int getLevelNo() {
        return levelNo;
    }

    public void setLevelNo(int levelNo) {
        this.levelNo = levelNo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    

    
    ///////////////STATIC METHODS.
    public static PrivLevel getPrivLevel(int n){
         return mapNiveles.containsKey(n)? mapNiveles.get(n):null;
    }
    
    public static PrivLevel createPrivLevel(int n,String d){
        if(!mapNiveles.containsKey(n)&&mapNiveles.size()>=n-1){
            if(n>0&&n<=mapNiveles.size()){
                for(int i=n;i<mapNiveles.size()+1;i++){
                    mapNiveles.replace(i+1,mapNiveles.get(i)).setLevelNo(i+1);
                }
            }
            return mapNiveles.put(n,new PrivLevel(n,d));
        } 
        return null;
    }
    
    public static PrivLevel createPrivLevelFunctional(int n,String d){//A little test.
        if(!mapNiveles.containsKey(n)&&mapNiveles.size()>=n-1){
            if(n>0&&n<=mapNiveles.size()){
                for(int i=n;i<mapNiveles.size()+1;i++){
                    mapNiveles.replace(i+1,mapNiveles.get(i)).setLevelNo(i+1);
                }
            }
            return mapNiveles.put(n,new PrivLevel(n,d));
        } 
        return null;
    }
    
    
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(Integer.toString(levelNo)).append(";").append(desc);
        return str.toString();
    }
    
    public static int hashMapSize(){//How many levels currently in map.
        return mapNiveles.size();
    }
    public static String toStringPrivLevels(){
        StringBuilder str = new StringBuilder();
        mapNiveles.forEach(null);
        mapNiveles.values().stream().forEach((p) -> {
            str.append(p.toString()).append("\n");
        });
        return str.toString();
    }

}
