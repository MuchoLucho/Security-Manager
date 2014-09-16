package Beans;

import java.util.ArrayList;

public class Table implements Permissible{

    private PrivLevel level;
    private String name;
    ArrayList<Column> cols;

    public Table(String name) {
        this.name = name;
    }

    public Table() {
    }

    public Table(PrivLevel nivel) {
        this.level = nivel;
    }

    public PrivLevel getPrivLevel() {
        return level;
    }

    public void setPrivLevel(PrivLevel nivel) {
        this.level = nivel;
        cols.stream().forEach((c) -> {
            c.setPrivLevel(nivel);
        });
    }

    public Column getColumn(String n) {
        for (Column c : cols) {
            if (c.getName().equals(n)) {
                return c;
            }
        }
        return null;
    }

    public boolean containsColumn(String name) {
        if (cols.stream().anyMatch((x) -> (x.getName().equals(name)))) {
            return true;
        }
        return false;
    }

    public boolean setColumn(String name) {
        if (!containsColumn(name)) {
            return cols.add(new Column(name));
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
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(name).append(";").append(level.toString()).append("\n");
        cols.stream().forEach((c) -> str.append(c.toString()).append("\n"));
        return str.toString();
    }

    public boolean setSensibility(String column, int lvl) {
        Column aux = this.getColumn(name);
        PrivLevel privs = PrivLevel.getPrivLevel(lvl);
        if (aux != null && privs != null) {
            aux.setPrivLevel(privs);
            return true;
        }
        return false;
    }

    public boolean setSensibility(int lvl) {
        PrivLevel privs = PrivLevel.getPrivLevel(lvl);
        if (privs != null) {
            this.setPrivLevel(level);
            return true;
        }
        return false;
    }
}
