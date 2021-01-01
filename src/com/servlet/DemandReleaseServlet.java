package com.servlet;

import com.bean.Demand;
import com.bean.User;
import com.dao.DemandDao;
import com.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/DemandReleaseServlet")
public class DemandReleaseServlet extends HttpServlet {  //需要继承HttpServlet  并重写doGet  doPost方法
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置response查询的码表
        response.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=UTF-8");
        User user;
        HttpSession session=request.getSession();
        user=(User) session.getAttribute("loginUser");//获取当前登录的用户

        String dem_contentType = request.getParameter("dem_contentType"); //得到jsp页面传过来的参数
        String dem_contentDescription = request.getParameter("dem_contentDescription");
        String pr=request.getParameter("price");

        double price=Double.parseDouble(pr);
        Demand demand=new Demand(); //实例化一个对象，组装属性
        demand.setDem_content(dem_contentDescription);
        demand.setDem_contentType(dem_contentType);
        demand.setPrice(price);

        Date currentDate = new Date(System.currentTimeMillis());//获取当前时间


        java.util.Date date = new java.util.Date();//获取当前时间对象，也可以直接传入Date的对象

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        String time= sdf.format(date);//获取格式化日期，带有时分

        demand.setDem_time(time);
        demand.setU_id(user.getU_id());
        demand.setU_name(user.getU_name());

        DemandDao dd = new DemandDao();

        PrintWriter pw=response.getWriter();

        try {
            if(dd.addDemand(demand)){

                pw.write("<script>");
                pw.write("alert(\"Published Successfully!\");");
                pw.write("window.location.href='visitor_release.jsp'");
                pw.write("</script>");

            }else{
                pw.write("<script>");
                pw.write("alert(\"Published Failed!\");");
                pw.write("window.location.href='visitor_release.jsp'");
                pw.write("</script>");
            }
            pw.flush();
            pw.close();
            //request.getRequestDispatcher("visitor_release.jsp").forward(request, response);//转发到游客用户页面
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}