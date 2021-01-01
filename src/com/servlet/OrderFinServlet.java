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
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/OrderFinServlet")
public class OrderFinServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id=request.getParameter("order_id");
        int order_id=Integer.parseInt(id);

        OrderDao od=new OrderDao();
        Order order=od.getOneOrder(order_id);//根据订单ID查到整个订单

        java.util.Date date = new java.util.Date();//获取当前时间对象

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time= sdf.format(date);//获取格式化日期，带有时分
        order.setFinished_time(time);
        od.update(order);
        //request.setAttribute("order",order);//将找到的订单传入session

        request.getRequestDispatcher("/Errand_showOrdServlet?step=1").forward(request, response);

    }
}
