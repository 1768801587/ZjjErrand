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
import java.util.List;

@WebServlet("/visitor_showDemServlet")
public class visitor_showDemServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
        User user=(User)session.getAttribute("loginUser");//获得当前登录用户
        DemandDao dd = new DemandDao();
        List<Demand> personalAllDemand = dd.getPersonalDemandAll(user.getU_id());//通过DemandDao对象从数据库中找到当前用户发布的需求
        session.setAttribute("personalAllDemand", personalAllDemand);

        request.getRequestDispatcher("/visitor_showDemand.jsp").forward(request, response);



    }
}
