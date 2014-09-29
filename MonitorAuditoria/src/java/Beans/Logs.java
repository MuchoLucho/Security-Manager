package Beans;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Logs implements Serializable {

    /*Declaration*/
    private static /*final*/ StringBuilder log = new StringBuilder();

    public static String getLog() {
        return log.toString();
    }

    public static String toJSON(String s) {
        StringBuilder str = new StringBuilder("[");
        if (!s.equals("")) {
            String[] ar = s.split(";");
            for (String ss : ar) {
                str.append("{\"log\":\"").append(ss).append("\"}, ");
            }
            str.append(str.substring(0, str.length() - 1)).append("]");
        } else {
            str.append("{\"log\":\"No Data\"}]");
        }
        return str.toString();
    }

    /*Use it to get them*/
    public static String logsJSON() {
        return toJSON(getLog());
    }

    /*Use it to add events to log*/
    public static void add(String event, String object) {
        log.append(new SimpleDateFormat("yyyyMMdd").format(new Date())).append(object).append(event).append(";");
    }
    
    public void write() throws FileNotFoundException, IOException
    {
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrador\\Documents\\NetBeansProjects\\Security-Manager\\MonitorAuditoria\\archivos\\Logs.bin");
        ObjectOutputStream out = new ObjectOutputStream(fos);
        
        out.writeObject(log);
    }
    
    public void read () throws FileNotFoundException, IOException, ClassNotFoundException
    {
        FileInputStream fis = new FileInputStream("C:\\Users\\Administrador\\Documents\\NetBeansProjects\\Security-Manager\\MonitorAuditoria\\archivos\\Logs.bin");
        ObjectInputStream in = new ObjectInputStream(fis);
        
        StringBuilder aux = new StringBuilder();
        aux = (StringBuilder)in.readObject();

        log = aux;
    }
}
