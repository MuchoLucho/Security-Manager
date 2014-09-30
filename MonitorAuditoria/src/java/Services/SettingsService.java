package Services;

import Beans.DBConnector;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SettingsService extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if (request.getParameter("ask") != null) {
                out.print("{\"state\":\"" + (DBConnector.AuditActivo() ? "true\"" : "false\"") + "}");
            } else if (request.getParameter("suspend") != null) {
                DBConnector.ReiniciarBase("XE");//revisar session
            } else if (request.getParameter("enable") != null) {
                DBConnector.ReiniciarBase("XE");//revisar session
            } else {
                String user = request.getParameter("user");
                int modo = Integer.parseInt(request.getParameter("select"));
                if (!user.equals("")) {
                    DBConnector.AuditarSesUsr(modo, user);
                } else {
                    DBConnector.AuditarSesUsr(modo);
                }
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
