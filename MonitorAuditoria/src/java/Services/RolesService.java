package Services;

import Beans.Logs;
import Beans.Model;
import Beans.PermissionManagement;
import Beans.ReadJSON;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RolesService extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PermissionManagement perman = Model.permMan;
        
        try (PrintWriter out = response.getWriter()) {
            if (request.getParameter("call") != null) {
                String str = request.getParameter("call");
                switch (str) {
                    /*Call for Sens*/
                    case "sens":
                        //out.print("[{\"name\": \"luis\", \"selected\": true}, {\"name\": \"jota\", \"selected\": false}]");
                        //[name: asdasd,sName:asdasd,sName:]
                        String seed = request.getParameter("element") ;
                        String sensAndRole = perman.toJSONRolesPrivs(seed);
                        out.print(sensAndRole);
                        break;
                    case "roles":
                        //out.print("[{\"name\": \"admin\"}, {\"name\": \"peasant\"}]");
                        String sumRoles = perman.toStringRolesGeneral();
                        out.print(sumRoles);
                        break;
                }
            } else if (request.getParameter("new") != null) {
               perman.insertRole(request.getParameter("name")); //WATCH OUT IF YOU HAVE TO DO SMETHING ELSE TO CREATE IN DB.
               perman.writeRoles();
               Logs.logCreation("rol");
               response.sendRedirect("roles.jsp");
                /*getParameter("name")-->Nombre de nuevo rol*/
            } else if (request.getParameter("delete") != null) {
                String paramDelete = request.getParameter("delete");
                perman.removeRole(paramDelete);
                perman.writeRoles();
                Logs.logDelete("rol");
                response.sendRedirect("roles.jsp");
                //(request.getParameter("delete"));  rol a eliminar
            } else if (request.getParameter("set") != null) {
                String roleName = request.getParameter("set");
                String jsonPerms = request.getParameter("element");
                ReadJSON.setSens(perman,roleName, jsonPerms);
                perman.writeRoles();
                Logs.logEdit("rol");
                response.sendRedirect("roles.jsp");
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
