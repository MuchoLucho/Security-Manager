/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 *
 * @author Javier
 */
public class Column implements Permissible, Serializable {

    private String name;
    //private PrivLevel nivel;
    private Table table;

    public Column() {
    }

    public Column(String nombre) {
        this.name = nombre;
    }

    public Column(Table t, String nombre) {
        this.table = t;
        this.name = nombre;
    }

//    public Column(String nombre, PrivLevel nivel) {
//        this.name = nombre;
//        this.nivel = nivel;
//    }

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

//    public PrivLevel getPrivLevel() {
//        return nivel;
//    }
//
//    public void setPrivLevel(PrivLevel nivel) {
//        this.nivel = nivel;
//    }

//    @Override
//    public String toString() {
//        StringBuilder str = new StringBuilder();
//        str.append(name).append(";").append(nivel.toString());
//        return str.toString();
//    }

    @Override
    public String getDBDir(){//THIS WONT ACTUALLY WORK
        
        return new StringBuilder()
                .append(table.getName())
                .append(".")
                .append(name).toString();
    }
    
    @Override
    public String toString() {
        StringBuilder json = new StringBuilder();        
        json.append("[{\"tName\":\"").append(name).append("}]");        
        return json.toString();        
        /*StringBuilder str = new StringBuilder();
        str.append(name).append(";").append(nivel.toString());
        return str.toString();*/
    }
    
    
}
