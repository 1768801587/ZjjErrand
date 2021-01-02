package com.servlet;
import com.bean.Demand;
import com.bean.Order;
import com.bean.User;
import com.dao.DemandDao;
import com.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/OrderAddServlet")
public class OrderAddServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置response查询的码表
        response.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=UTF-8");

        User user;
        HttpSession session=request.getSession();
        user=(User) session.getAttribute("loginUser");//获取当前登录的用户

        String ord_contentType = request.getParameter("dem_contentType"); //得到jsp页面传过来的参数
        String ord_contentDescription = request.getParameter("dem_contentDescription");
        String f_name=request.getParameter("visitor_name");
        String dem_time=request.getParameter("dem_time");
        String pr=request.getParameter("price");
        double price=Double.parseDouble(pr);
        String did=request.getParameter("demand_id");
        int demand_id=Integer.parseInt(did);
        String id=request.getParameter("visitor_id");
        int f_id=Integer.parseInt(id);


        Order order=new Order(); //实例化一个对象，组装属性
        order.setDem_time(dem_time);
        order.setDemand_id(demand_id);
        order.setF_id(f_id);
        order.setF_name(f_name);
        order.setJ_id(user.getU_id());
        order.setJ_name(user.getU_name());
        order.setOrd_content(ord_contentDescription);
        order.setOrd_contentType(ord_contentType);
        order.setPrice(price);

        Date currentDate = new Date(System.currentTimeMillis());//获取当前时间
        java.util.Date date = new java.util.Date();//获取当前时间对象，也可以直接传入Date的对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time= sdf.format(date);//获取格式化日期，带有时分

        order.setOrd_time(time);

        OrderDao od=new OrderDao();
        PrintWriter pw=response.getWriter();
        try {
            if(od.addOrder(order)){
                pw.print("<script language='javascript'>alert('Receive Successfully');window.location.href='Errand_reception.jsp';</script>");
            }else {
                pw.print("<script language='javascript'>alert('Receive Failed');window.location.href='Errand_reception.jsp';</script>");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
