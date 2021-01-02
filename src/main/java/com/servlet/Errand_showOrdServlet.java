package com.servlet;

import com.bean.Demand;
import com.bean.Evaluate;
import com.bean.Order;
import com.bean.User;
import com.dao.DemandDao;
import com.dao.EvaluateDao;
import com.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/Errand_showOrdServlet")
public class Errand_showOrdServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String st=request.getParameter("step");
        int step=Integer.parseInt(st);
        if(step==1){//查看所有与当前用户相关的订单

            HttpSession session=request.getSession();
            User user=(User)session.getAttribute("loginUser");//获得当前登录用户
            OrderDao od = new OrderDao();

            // od.updateOrdIdInDemand();接单一次,修改一条
            List<Order> personalAllOrder = od.getPersonalOrder(user.getU_id());//通过DemandDao对象从数据库中找到所有当前用户接收的需求
            session.setAttribute("personalAllOrder", personalAllOrder);

            request.getRequestDispatcher("/Errand_showOrder.jsp").forward(request, response);
        }else if(step==2){//查看单个订单
            String id=request.getParameter("order_id");
            int order_id=Integer.parseInt(id);
            OrderDao od = new OrderDao();
            Order order=od.getOneOrder(order_id);

            HttpSession session=request.getSession();
            session.setAttribute("oneOrder",order);//将需查看的订单  写进session

            if(order.getIsEva()==1){//如果有评论
                EvaluateDao ed=new EvaluateDao();
                List<Evaluate> oneOrderAllEva = ed.getOrderAllEva(order.getOrder_id());
                session.setAttribute("oneOrderAllEva",oneOrderAllEva);//更新session中的  eva评论

            }

            request.getRequestDispatcher("Errand_showOneOrder.jsp").forward(request,response);

        }



    }
}