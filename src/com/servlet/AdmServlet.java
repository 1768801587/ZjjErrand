package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Demand;
import com.bean.Evaluate;
import com.bean.Order;
import com.dao.DemandDao;
import com.dao.EvaluateDao;
import com.dao.OrderDao;
import com.dao.UserDao;
import com.bean.User;
@WebServlet("/AdmServlet")
public class AdmServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String  f=request.getParameter("flag");
        int flag=Integer.parseInt(f);

        if(flag==1){//获取所有未接单的需求
            DemandDao dd=new DemandDao();
            List<Demand> list = dd.getAllDemand();
            request.setAttribute("list",list);//写进request域
            request.getRequestDispatcher("/adm_allDemand.jsp").forward(request, response);


        }else if(flag==2){//获取所有订单
            OrderDao od=new OrderDao();
            List<Order> orderList=od.getAllOrder();
            request.setAttribute("orderList",orderList);

            request.getRequestDispatcher("/adm_allOrder.jsp").forward(request, response);


        }else if(flag==3){//个人中心
            request.getRequestDispatcher("/PersonalCenter.jsp").forward(request, response);

        }else if(flag==4){//获取所有评论
            EvaluateDao ed=new EvaluateDao();
            List<Evaluate> evaluateList=ed.getAllEvaluate();
            request.setAttribute("evaluateList",evaluateList);
            request.getRequestDispatcher("/adm_allEvaluate.jsp").forward(request, response);

        }else if(flag==5){//删除需求
            String  id=request.getParameter("demand_id");
            int demand_id=Integer.parseInt(id);//获取需求ID
            DemandDao dd=new DemandDao();
            if(dd.delete(demand_id)){
                System.out.println("Deleted Demand Successfully!!");
                request.getRequestDispatcher("AdmServlet?flag=1").forward(request, response);
            }

        }else if(flag==6){//删除订单
            String  id=request.getParameter("order_id");
            int order_id=Integer.parseInt(id);//获取订单ID
            OrderDao od=new OrderDao();
            if(od.delete(order_id)){
                System.out.println("Deleted Order Successfully!!");
                request.getRequestDispatcher("AdmServlet?flag=2").forward(request, response);
            }

        }else if(flag==7){//查看订单详情
            String  id=request.getParameter("order_id");
            int order_id=Integer.parseInt(id);//获取订单ID

            HttpSession session=request.getSession();
            OrderDao od=new OrderDao();
            Order order=od.getOneOrder(order_id);

            if(order.getIsEva()==1){//如果有评论
                EvaluateDao ed=new EvaluateDao();
                List<Evaluate> orderAllEva = ed.getOrderAllEva(order_id);
                session.setAttribute("orderAllEva",orderAllEva);//更新session中的  eva评论
            }
            session.setAttribute("findOrder",order);

            request.getRequestDispatcher("/adm_OrderDetails.jsp").forward(request, response);
        }else if(flag==8){//删除评论
            String  id=request.getParameter("eva_id");
            int eva_id=Integer.parseInt(id);//获取评论ID

            EvaluateDao ed=new EvaluateDao();
            if(ed.delete(eva_id)){
                System.out.println("Deleted Evaluation Successfully!!");
                request.getRequestDispatcher("AdmServlet?flag=4").forward(request, response);

            }
        }


    }
}