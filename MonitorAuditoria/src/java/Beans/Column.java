package Beans;

import java.io.Serializable;

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

    @Override
    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    @Override
    public String getDBDir() {
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
    }
}
