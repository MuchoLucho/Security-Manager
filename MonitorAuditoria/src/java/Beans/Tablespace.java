/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Javier
 */
public class Tablespace implements Serializable{

    private String name;
    ArrayList<Table> tabs = new ArrayList<>();

    public ArrayList<Table> getTabs() {
        return tabs;
    }

    public Tablespace(String name) {
        this.name = name;
    }

    public Tablespace() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Table getTable(String n) {
        return tabs.stream().
                filter((t)->t.getName().equals(n))
                .findFirst().orElse(null);
    }

    public boolean containsTable(String name) {
        return tabs.stream()
                .anyMatch( (x) -> x.getName().equals(name) );
    }

    public boolean setTable(String name) {
        if (!containsTable(name)) {
            return tabs.add(new Table(this,name));
        }
        return false;
    }

//    public boolean setSensibility(String table, String column, int lvl) {
//        Table aux = getTable(table);
//        if (aux != null) {
//            return aux.setSensibility(column, lvl);
//        }
//        return false;
//    }
//
//    public boolean setSensibility(String table, int lvl) {
//        Table aux = getTable(table);
//        return aux != null ? aux.setSensibility(lvl):false;
//    }

    
    public String toStringTables() {//Tablespace_name\nTable\nTable\n(...).
        StringBuilder str = new StringBuilder();
        str.append(name).append("\n");
        tabs.stream().forEach((c) -> str.append(c.toString()).append("\n"));
        return str.toString();
    }

//    public void write() throws FileNotFoundException, IOException
//    {
//        FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrador\\Documents\\NetBeansProjects\\Security-Manager\\MonitorAuditoria\\archivos\\Tablespace.bin");
//        ObjectOutputStream out = new ObjectOutputStream(fos);
//        
//        out.writeObject(tabs);
//    }
//    
//    public ArrayList read () throws FileNotFoundException, IOException, ClassNotFoundException
//    {
//        FileInputStream fis = new FileInputStream("C:\\Users\\Administrador\\Documents\\NetBeansProjects\\Security-Manager\\MonitorAuditoria\\archivos\\Tablespace.bin");
//        ObjectInputStream in = new ObjectInputStream(fis);
//        
//        ArrayList<Table> aux = new ArrayList<>();
//        aux = (ArrayList)in.readObject();
//
//        return aux;
//    }
}
