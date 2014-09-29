package Services;

import Beans.Model;
import Beans.PermissionManagement;
import Beans.ReadJSON;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SensibilityService extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PermissionManagement perman = Model.permMan;
        try (PrintWriter out = response.getWriter()) {
            if (request.getParameter("call") != null) {
                String str = request.getParameter("call");
                switch (str) {
                    /*Call for Tables*/
                    case "tables":
                        String tbsName = request.getParameter("element");
                        //out.print("[{\"tName\": \"t1\", \"tablespace\":\"swag\", \"insert\": \"false\", \"select\": \"true\", \"delete\": \"true\", \"update\": \"true\"}, {\"tName\": \"t2\", \"tablespace\":\"swag\", \"insert\": \"false\", \"select\": \"true\", \"delete\": \"false\", \"update\": \"true\"}]");
                        String debugeandoA = perman.toStringPrivLevelTables(tbsName);
                        out.print(debugeandoA);
                        break;
                    /*Call for columns*/
                    case "columns":
                        String tabName = request.getParameter("element");
                        //out.print("[{\"cName\": \"t1C\", \"tName\": \"t1\", \"select\": \"true\", \"delete\": \"true\", \"update\": \"true\"}, {\"cName\": \"t2C\", \"tName\": \"t2\", \"insert\": \"false\", \"select\": \"true\", \"delete\": \"false\", \"update\": \"true\"}]");
                        String debugeando = perman.toStringPrivLevelColumns(tabName);
                        out.print(debugeando);
                        break;
                    /*Call for resources*/
                    case "rsrc":
                        //request.getParameter("element")
                        out.print("[{\"rName\": \"p1\", \"type\": \"procedure\", \"selected\": \"false\"}, {\"rName\": \"p2\", \"type\": \"function\", \"selected\": \"true\"}]");
                        break;
                    /*Call for sensibilities*/
                    case "sens":
                        //out.print("[{\"sName\": \"admin\"}, {\"sName\": \"peasant\"}]");
                        out.print(perman.toStringAllPrivLevels());
                        break;
                }
            } else if (request.getParameter("new") != null) { /*New Level*/
                String name = request.getParameter("name");//-->Nombre de nuevo nivel
                perman.createPrivLevel(name);
                response.sendRedirect("sensibility.jsp");
            } else /*Delete Level*/ if (request.getParameter("delete") != null) {
                //(request.getParameter("delete")); Devuelve sensibilidad a eliminar
                System.err.println("NOT YET SORRY");
            } else {
                String str = request.getParameter("set");
                switch (str) {
                    case "tables":
                        String jeisonk = request.getParameter("element");//JSON
                        String senlev = request.getParameter("sens");//Selected level
                        ReadJSON.setTables(jeisonk, perman, senlev);          
                        break;
                    case "columns":
                        System.out.println("CANT YET SEND COLUMNS");
                        //(request.getParameter("element"));//JSON
                        //(request.getParameter("sens")); // Selected Level
                        break;
                    case "rsrc":
                        //(request.getParameter("element"));//JSON
                        //(request.getParameter("sens")); // Selected Level
                        break;
                    default:
                        break;
                }
                response.sendRedirect("sensibility.jsp");
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
