package Services;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SensibilityService extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (request.getParameter("call") != null) {
                String str = request.getParameter("call");
                switch (str) {
                    /*Call for Tables*/
                    case "tables":
                        //request.getParameter("element")
                        out.print("[{\"tName\": \"t1\", \"tablespace\":\"swag\", \"insert\": \"false\", \"select\": \"true\", \"delete\": \"true\", \"update\": \"true\"}, {\"tName\": \"t2\", \"tablespace\":\"swag\", \"insert\": \"false\", \"select\": \"true\", \"delete\": \"false\", \"update\": \"true\"}]");
                        break;
                    /*Call for columns*/
                    case "columns":
                        //request.getParameter("element")
                        out.print("[{\"cName\": \"t1C\", \"tName\": \"t1\", \"select\": \"true\", \"delete\": \"true\", \"update\": \"true\"}, {\"cName\": \"t2C\", \"tName\": \"t2\", \"insert\": \"false\", \"select\": \"true\", \"delete\": \"false\", \"update\": \"true\"}]");
                        break;
                    /*Call for resources*/
                    case "rsrc":
                        //request.getParameter("element")
                        out.print("[{\"rName\": \"p1\", \"type\": \"procedure\", \"selected\": \"false\"}, {\"rName\": \"p2\", \"type\": \"function\", \"selected\": \"true\"}]");
                        break;
                    /*Call for sensibilities*/
                    case "sens":
                        out.print("[{\"sName\": \"admin\"}, {\"sName\": \"peasant\"}]");
                        break;
                }
            } else if (request.getParameter("new") != null) { /*New Level*/
                /*getParameter("name")-->Nombre de nuevo nivel*/

            } else /*Delete Level*/ if (request.getParameter("delete") != null) {
                //(request.getParameter("delete")); Devuelve sensibilidad a eliminar
            } else {
                String str = request.getParameter("set");
                switch (str) {
                    case "tables":
                        //(request.getParameter("element")); //JSON
                        //(request.getParameter("sens")); // Selected Level
                        break;
                    case "columns":
                        //(request.getParameter("element"));
                        //(request.getParameter("sens")); // Selected Level
                        break;
                    case "rsrc":
                        //(request.getParameter("element"));
                        //(request.getParameter("sens")); // Selected Level
                        break;
                    default:
                        break;
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
