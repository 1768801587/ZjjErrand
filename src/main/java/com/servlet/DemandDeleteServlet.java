package com.servlet;

import com.bean.Demand;
import com.dao.DemandDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/DemandDeleteServlet")
public class DemandDeleteServlet extends HttpServlet {//删除需求
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("demand_id");
        int demand_id = Integer.parseInt(id);

        DemandDao dd = new DemandDao();

        if(dd.delete(demand_id)){
            request.getRequestDispatcher("/visitor_showDemServlet").forward(request, response);
        }else{
            response.sendRedirect("index.jsp");
        }
    }

}
