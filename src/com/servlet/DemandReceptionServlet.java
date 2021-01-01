package com.servlet;

import com.bean.Demand;
import com.dao.DemandDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
@WebServlet("/DemandReceptionServlet")
public class DemandReceptionServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id=request.getParameter("demand_id");

        int demand_id=Integer.parseInt(id);


        DemandDao dd=new DemandDao();
        Demand demand=dd.getOneDemand(demand_id);//根据需求ID查到整个需求

        request.setAttribute("demand",demand);//将选中的需求传入

        java.util.Date date = new java.util.Date();//获取当前时间对象

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time= sdf.format(date);//获取格式化日期，带有时分
        request.setAttribute("reception_time",time);

        request.getRequestDispatcher("/Errand_reception.jsp").forward(request, response);

    }
}
