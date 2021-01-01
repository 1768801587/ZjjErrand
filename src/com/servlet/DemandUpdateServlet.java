package com.servlet;

import com.dao.DemandDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DemandUpdateServlet")
public class DemandUpdateServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id=request.getParameter("demand_id");
        int demand_id=Integer.parseInt(id);

        String type = request.getParameter("dem_contentType");
        String content = request.getParameter("dem_content");
        String pr=request.getParameter("price");
        double price=Double.parseDouble(pr);

        DemandDao dd = new DemandDao();

        if(dd.update(demand_id, type, content,price)){
            request.getRequestDispatcher("/visitor_showDemServlet").forward(request, response);
        }else{
            PrintWriter pw=response.getWriter();
            pw.write("<script>");
            pw.write("alert(\"Update Failed!\");");
            pw.write("</script>");
            pw.flush();
            pw.close();

            response.sendRedirect("/visitor_showDemServlet");
        }
    }

}
