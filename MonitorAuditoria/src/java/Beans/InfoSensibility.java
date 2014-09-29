package Beans;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class InfoSensibility implements Serializable {

    public ArrayList<Tablespace> tbsList = new ArrayList<>();

    public InfoSensibility() {
        // PrivLevel.createPrivLevel(-1, "Indefinido");
        this.getFromDatabase();
    }

    public Tablespace getTableSpace(String name) {
        return tbsList.stream()
                .filter((t) -> t.getName().equals(name))
                .findFirst().orElse(null);
    }

    public Table getTable(String tablespace, String table) {
        Tablespace aux = this.getTableSpace(tablespace);
        return aux!=null ? aux.getTable(table):null;
    }

    public Column getColumn(String tablespace, String table, String col) {
        return this.getTable(tablespace, table).getColumn(col);
    }

    public String toStringTablespaces() {
        StringBuilder str = new StringBuilder();
        tbsList.stream()
                .forEach((tbs) -> str.append(tbs.getName()));
        return str.toString();
        //return tbs!=null ? tbs.toString():"";
    }

    public String toStringTables(String name) {
        Tablespace aux = this.getTableSpace(name);
        return aux != null ? aux.toStringTables() : "";
    }

    public String toStringColumns(String tbs, String table) {
        Tablespace aux = this.getTableSpace(tbs);
        Table tAux = aux != null ? aux.getTable(table) : null;
        return tAux != null ? tAux.toStringCols() : "";
    }

    private void getFromDatabase() {
        System.out.println("GETTING TABLES AND STUFF FROM DATABASE.");
        DBConnector.getDatabaseElements(tbsList);
    }

//DEPRECATED
//    public boolean setSensibiltiy(String tablespace, String table, String column, int sens) {//CHANGE A COLUMN'S SENSITIVITY
//        Tablespace tbsp = this.getTableSpace(tablespace);
//        return tbsp != null ? tbsp.setSensibility(table, column, sens):false;
//    }
//
//    public boolean setSensibiltiy(String tablespace, String table, int sens) {//CHANGEE WHOLE TABLE SENSITIBITY.
//        Tablespace tbsp = this.getTableSpace(tablespace);
//        return tbsp!=null ? tbsp.setSensibility(table, sens):false;
//    }
//
//    public boolean createLevel(int num, String desc) {
//        return PrivLevel.createPrivLevel(num, desc) != null;
//    }
//    public boolean editLevel(int num,String newDesc){
//        return PrivLevel.editPrivLevel(num,newDesc);
//    }
//
//    public String toStringLevels() {
//        return PrivLevel.toStringPrivLevels();
//    }
    
//    public void write() throws FileNotFoundException, IOException
//    {
//        FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrador\\Documents\\NetBeansProjects\\Security-Manager\\MonitorAuditoria\\archivos\\InfoSensibility.bin");
//        ObjectOutputStream out = new ObjectOutputStream(fos);
//        
//        out.writeObject(tbsList);
//    }
//    
//    public ArrayList read () throws FileNotFoundException, IOException, ClassNotFoundException
//    {
//        FileInputStream fis = new FileInputStream("C:\\Users\\Administrador\\Documents\\NetBeansProjects\\Security-Manager\\MonitorAuditoria\\archivos\\InfoSensibility.bin");
//        ObjectInputStream in = new ObjectInputStream(fis);
//        
//        ArrayList<Tablespace> aux = new ArrayList<>();
//        aux = (ArrayList)in.readObject();
//
//        return aux;
//    }
}
