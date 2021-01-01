package com.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.UserDao;
import com.bean.User;
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("userName"); //获取jsp页面传过来的参数
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String userType = request.getParameter("userType");

        User user = new User(); //实例化一个对象，组装属性
        user.setU_name(name);
        user.setPhone(phone);
        user.setPwd(password);
        user.setSex(sex);
        user.setU_type(Integer.parseInt(userType));


        UserDao ud = new UserDao();

        try {
            if(ud.register(user)){
                request.setAttribute("username", name);  //向request域中放置参数

                request.getRequestDispatcher("/login.jsp").forward(request, response);  //转发到登录页面
            }else{

                response.sendRedirect("index.jsp");//重定向到首页
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}