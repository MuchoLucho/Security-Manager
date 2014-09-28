/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Javier
 */
public class BitacoraLuis {
    /*Declaration*/

    private static final StringBuilder log = new StringBuilder();

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
    public static void addEncryptedEvent(String event) {
        log.append(new SimpleDateFormat("yyyyMMdd").format(new Date())).append(event).append(";");
    }

    private static void logAction(String accion, String padre) {
        String codif = null;
        if (padre.equals("rol")) {
            switch (accion) {
                case "create":
                    codif = "R01";
                    break;
                case "edit":
                    codif = "R02";
                    break;
                case "delete":
                    codif = "R03";
                    break;
            }
        } else if (padre.equals("usuario")) {
            switch (accion) {
                case "create":
                    codif = "U01";
                    break;
                case "edit":
                    codif = "U02";
                    break;
                case "delete":
                    codif = "U03";
                    break;
            }
        } else if (padre.equals("sensibilidad")) {
            switch (accion) {
                case "create":
                    codif = "S01";
                    break;
                case "edit":
                    codif = "S02";
                    break;
                case "delete":
                    codif = "S03";
                    break;
            }
        } else if (padre.equals("auditoria")) {
            switch (accion) {
                case "activate":
                    codif = "A01";
                    break;
                case "deactivate":
                    codif = "A02";
                    break;
                case "consult":
                    codif = "A03";
                    break;
            }
        }
        addEncryptedEvent(codif);
    }
    
    public static void logCreation(String subject){
        logAction("create", subject);
    }
    public static void logEdit(String subject){
        logAction("edit", subject);
    }
    public static void logDelete(String subject){
        logAction("delete", subject);
    }
    public static void logAudit(String action){
        logAction(action,"audit");
    }
}
