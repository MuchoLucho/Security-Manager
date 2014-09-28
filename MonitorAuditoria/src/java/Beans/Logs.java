package Beans;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logs {

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
    public static void add(String event, String object) {
        log.append(new SimpleDateFormat("yyyyMMdd").format(new Date())).append(object).append(event).append(";");
    }
}
