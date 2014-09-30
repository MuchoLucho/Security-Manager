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

public class UsersService extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PermissionManagement perman = Model.permMan;
        try (PrintWriter out = response.getWriter()) {
            if (request.getParameter("call") != null) {
                String str = request.getParameter("call");
                switch (str) {
                    /*Call for Sens*/
                    case "users":
                        //out.print("[{\"name\": \"admin\"}, {\"name\": \"peasant\"}]");
                        out.print(perman.toStringUsersGeneral());
                        //perman.toStringUsers()
                        //out. todos los roles
                        break;
                    case "roles":
                        //out.print("[{\"name\": \"luis\", \"selected\": true}, {\"name\": \"jota\", \"selected\": false}]");
                        String seed = request.getParameter("element");
                        out.print(perman.toJSONUserRoles(seed));
                        //request.getParameter("element") // User Seed                        
                        break;
                }
            } else if (request.getParameter("new") != null) { /*New User*/
                String user = request.getParameter("name");
                String pass = request.getParameter("pass");
                perman.insertUser(user, pass);
                perman.writeUsers();
                response.sendRedirect("users.jsp");
                /*getParameter("name") --> new user*/

            } else if (request.getParameter("delete") != null) {
                String user = request.getParameter("delete");
                perman.removeUser(user);
                perman.writeUsers();
                response.sendRedirect("users.jsp");
                //(request.getParameter("delete")); user to delete
            } else if (request.getParameter("set") != null) {
                String user = request.getParameter("set");
                String jsonPerms = request.getParameter("element");
                ReadJSON.setRoles(perman,user,jsonPerms);
                perman.writeUsers();
                response.sendRedirect("roles.jsp");
                //(request.getParameter("set")); //Selected User
                //(request.getParameter("element")); //JSON
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods.">
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
