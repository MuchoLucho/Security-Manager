package Services;

import Beans.Logs;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LastEvents extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {            
            if ("events".equals(request.getParameter("call"))) {
                String s;
                if (Beans.DBConnector.conectDB()) {
                    s = Beans.DBConnector.ResumenAudit();
                } else {
                    s = "[{\"User\":\"No data\", \"Statement\":\"No data\", \"SQL\":\"No data\",\"Date\":\"No data\",\"State\":\"No data\"}]";
                }
                Logs.logAudit("consult");
                out.print(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LastEvents.class.getName()).log(Level.SEVERE, null, ex);
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
