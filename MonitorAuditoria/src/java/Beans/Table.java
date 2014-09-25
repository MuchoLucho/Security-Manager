package Beans;

import java.util.ArrayList;

public class Table implements Permissible{
    //private PrivLevel level;
    private String name;
    ArrayList<Column> cols;

    public Table(String name) {
        this.name = name;
    }

    public Table() {
    }

//    public Table(PrivLevel nivel) {
//        this.level = nivel;
//    }
//
//    public PrivLevel getPrivLevel() {
//        return level;
//    }

//    public void setPrivLevel(PrivLevel nivel) {
//        //this.level = nivel;
//        cols.stream().forEach((c) -> {
//            c.setPrivLevel(nivel);
//        });
//    }

    public Column getColumn(String n) {
        return cols.stream()
                .filter((c)->c.getName().equals(n))
                .findFirst().orElse(null);
    }

    public boolean containsColumn(String name) {
        return cols.stream()
                .anyMatch((x) -> (x.getName().equals(name)));
    }

    public boolean setColumn(String name) {
        if (!containsColumn(name)) {
            return cols.add(new Column(this,name));
        }
        return false;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {//Name;Sensitivity\n
        StringBuilder str = new StringBuilder();
        str.append(name).append(";");
        //cols.stream().forEach((c) -> str.append(c.toString()).append("\n"));
        return str.toString();
    }
    
    public String toStringCols() {//Name;Sensitivity\nCol\nCol\nCol(...)
        StringBuilder str = new StringBuilder();
        str.append(name).append(";").append("\n");
        cols.stream().forEach((c) -> str.append(c.toString()).append("\n"));
        return str.toString();
    }

//    public boolean setSensibility(String column, int lvl) {
//        Column aux = this.getColumn(name);
//        PrivLevel privs = PrivLevel.getPrivLevel(lvl);
//        if (aux != null && privs != null) {
//            aux.setPrivLevel(privs);
//            return true;
//        }
//        return false;
//    }
//
//    public boolean setSensibility(int lvl) {//THIS OVERWRITES ALL COLUMNS
//        PrivLevel privs = PrivLevel.getPrivLevel(lvl);
//        if (privs != null) {
//            this.setPrivLevel(level);
//            this.cols.stream()
//                    .forEach((col)->col.setPrivLevel(privs));
//            return true;
//        }
//        return false;
//    }

    @Override
    public String getDBDir() {//Might have to include a reference to tablespace to put complete name.
        return name;
    }
}
