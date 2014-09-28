package Services;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RolesService extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (request.getParameter("call") != null) {
                String str = request.getParameter("call");
                switch (str) {
                    /*Call for Sens*/
                    case "sens":
                        out.print("[{\"name\": \"luis\", \"selected\": true}, {\"name\": \"jota\", \"selected\": false}]");
                        //request.getParameter("element") // Role Seed
                        break;
                    case "roles":
                        out.print("[{\"name\": \"admin\"}, {\"name\": \"peasant\"}]");
                        //out. todos los roles
                        break;
                }
            } else if (request.getParameter("new") != null) { /*New Level*/
                /*getParameter("name")-->Nombre de nuevo rol*/
            } else if (request.getParameter("delete") != null) {
                //(request.getParameter("delete"));  rol a eliminar
            } else if (request.getParameter("set") != null) {
                //(request.getParameter("set")); //Rol seleccionado
                //(request.getParameter("element")); //JSON
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
