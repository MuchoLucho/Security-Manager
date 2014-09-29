package Beans;

public class Column implements Permissible {

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
    public String getDBDir() {//THIS WONT ACTUALLY WORK        
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
//    public Column(String nombre, PrivLevel nivel) {
//        this.name = nombre;
//        this.nivel = nivel;
//    }
