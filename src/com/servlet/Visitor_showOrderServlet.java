package com.servlet;
import com.bean.Demand;
import com.bean.Evaluate;
import com.bean.Order;
import com.bean.User;
import com.dao.DemandDao;
import com.dao.EvaluateDao;
import com.dao.OrderDao;
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

@WebServlet("/Visitor_showOrderServlet")
public class Visitor_showOrderServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();

        String id=request.getParameter("demand_id");//获得需要查看的订单的需求ID
        int demand_id=Integer.parseInt(id);

        OrderDao od=new OrderDao();
        Order order=od.getOneOrderfromDemID(demand_id);//根据需求id找到订单

        if(order.getIsEva()==1){//如果有评论
            EvaluateDao ed=new EvaluateDao();
            List<Evaluate> orderAllEva = ed.getOrderAllEva(order.getOrder_id());
            session.setAttribute("orderAllEva",orderAllEva);//更新session中的  eva评论


        }

        session.setAttribute("findOrder",order);

       request.getRequestDispatcher("/visitor_showOrder.jsp").forward(request, response);



    }
}
