package com.servlet;
import com.bean.Demand;
import com.bean.Order;
import com.bean.User;
import com.dao.DemandDao;
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

@WebServlet("/Visitor_payServlet")
public class Visitor_payServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id=request.getParameter("findOrder_id");
        int order_id=Integer.parseInt(id);
        OrderDao od=new OrderDao();
        Order order=od.getOneOrder(order_id);//获得需要进行支付的订单

        order.setIsPay(1);
        od.update(order);//更新数据库中的订单

        HttpSession session=request.getSession();//更新session中的订单
        session.setAttribute("findOrder",order);

        PrintWriter pw=response.getWriter();
        pw.write("<script>");
        pw.write("alert(\"Confirm Payment\");");
        pw.write("window.location.href='visitor_showOrder.jsp'");
        pw.write("</script>");
        pw.flush();
        pw.close();
    }
}
