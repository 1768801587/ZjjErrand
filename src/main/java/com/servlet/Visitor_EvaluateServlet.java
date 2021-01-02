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
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/Visitor_EvaluateServlet")
public class Visitor_EvaluateServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String s=request.getParameter("step");
        int step=Integer.parseInt(s);

        if(step==1){//判断是从哪里进当前servlet的，如果是从订单页面,则跳评论页进行评论
//            String id=request.getParameter("findOrder_id");//获得订单ID
//           int order_id=Integer.parseInt(id);
//           OrderDao od=new OrderDao();
//          Order order=od.getOneOrder(order_id);//获得需要进行支付的订单
//
//           HttpSession session=request.getSession();//更新session中的订单
//            session.setAttribute("findOrder",order);//不需要重新写,之前写过了

            request.getRequestDispatcher("/visitor_evaluate.jsp").forward(request, response);

        }else if(step==2){//如果是从评论页，跳对应DAO 存 数据  在跳有查看订单按钮的页  看有没有增加评论

            HttpSession session=request.getSession();

            String eva_content= request.getParameter("eva_content");//获取评论内容
            Order order=(Order)session.getAttribute("findOrder");//获取订单

            Evaluate eva=new Evaluate();//封装Evaluate对象 存储到数据库
            eva.setDemand_id(order.getDemand_id());
            eva.setEva_content(eva_content);

            java.util.Date date = new java.util.Date();//获取当前时间对象
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String time= sdf.format(date);//获取格式化日期，带有时分
            eva.setEva_time(time);

            eva.setOrder_id(order.getOrder_id());
            eva.setU_id(order.getF_id());
            eva.setU_name(order.getF_name());


            EvaluateDao ed=new EvaluateDao();
            try {
                ed.addEvaluate(eva);
            } catch (SQLException e) {
                e.printStackTrace();
            }

              order.setIsEva(1);
              OrderDao od=new OrderDao();
              od.update(order);//更新数据库中的订单

            List<Evaluate> orderAllEva = ed.getOrderAllEva(order.getOrder_id());
            session.setAttribute("orderAllEva",orderAllEva);//更新session中的  eva评论
//

            request.getRequestDispatcher("visitor_showOrder.jsp").forward(request, response);       //有问题
        }




    }
}
