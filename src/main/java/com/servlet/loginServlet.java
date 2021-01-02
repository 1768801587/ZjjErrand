package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.User;
import com.dao.UserDao;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {  //需要继承HttpServlet  并重写doGet  doPost方法
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String phone = request.getParameter("phone"); //得到jsp页面传过来的参数
        String pwd = request.getParameter("password");

        UserDao ud = new UserDao();
        User user=new User();
        if(ud.login(phone, pwd)){
            //向request域中放置信息
            user=ud.getUser(phone,pwd);//登录成功后，获得这个对象
           // request.setAttribute("user",user);
            if(user.getU_type()==1){//登录判断  如果为发单用户  则跳转到发单界面    否则跳转到接单界面
                HttpSession session = request.getSession();
                session.setAttribute("loginUser",user);
                request.getRequestDispatcher("visitor.jsp").forward(request, response);//转发到游客用户页面
            }
            else if(user.getU_type()==2){
                HttpSession session = request.getSession();
                session.setAttribute("loginUser",user);
                request.getRequestDispatcher("errand.jsp").forward(request, response);//转发到跑腿用户页面
            }else if(user.getU_type()==3){//如果为管理员登录
                HttpSession session = request.getSession();
                session.setAttribute("loginUser",user);
                request.getRequestDispatcher("admUser.jsp").forward(request, response);//转发到跑腿用户页面
            }



        }else{

            response.sendRedirect("register.jsp"); //重定向到首页
        }
    }

}