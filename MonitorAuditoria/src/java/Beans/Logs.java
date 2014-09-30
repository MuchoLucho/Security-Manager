package Beans;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logs {

    private static StringBuilder log = new StringBuilder();

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
            str.replace(str.length() - 2, str.length() - 1, "]");
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
    public static void addEncryptedEvent(String event) {
        log.append(new SimpleDateFormat("yyyyMMdd-HHmmss-").format(new Date())).append(event).append(";");
    }

    private static void logAction(String accion, String padre) {
        String codif = "";
        switch (padre) {
            case "rol":
                codif += "R-";
                break;
            case "usuario":
                codif += "U-";
                break;
            case "sensibilidad":
                codif += "S-";
                break;
            case "auditoria":
                codif += "A-";
                break;
            default:
                break;
        }
        switch (accion) {
            case "create":
                codif += "01";
                break;
            case "edit":
                codif += "02";
                break;
            case "delete":
                codif += "03";
                break;
            case "activate":
                codif += "01";
                break;
            case "deactivate":
                codif += "02";
                break;
            case "consult":
                codif += "03";
                break;
            default:
                break;
        }
        addEncryptedEvent(codif);
    }

    /*Use them*/
    public static void logCreation(String subject) {
        logAction("create", subject);
    }

    public static void logEdit(String subject) {
        logAction("edit", subject);
    }

    public static void logDelete(String subject) {
        logAction("delete", subject);
    }

    public static void logAudit(String action) {
        logAction(action, "audit");
    }

    public void write() throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream("/Logs.bin");
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.writeObject(log);
    }

    public void read() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("/Logs.bin");
        ObjectInputStream in = new ObjectInputStream(fis);
        StringBuilder aux = (StringBuilder) in.readObject();
        log = aux;
    }
}
