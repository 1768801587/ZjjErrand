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
public class DemandReleaseServlet extends HttpServlet {  //��Ҫ�̳�HttpServlet  ����дdoGet  doPost����
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);  //����Ϣʹ��doPost����ִ��   ��Ӧjspҳ���е�form���е�method
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //����response��ѯ�����
        response.setCharacterEncoding("UTF-8");

        response.setContentType("text/html;charset=UTF-8");
        User user;
        HttpSession session=request.getSession();
        user=(User) session.getAttribute("loginUser");//��ȡ��ǰ��¼���û�

        String dem_contentType = request.getParameter("dem_contentType"); //�õ�jspҳ�洫�����Ĳ���
        String dem_contentDescription = request.getParameter("dem_contentDescription");
        String pr=request.getParameter("price");

        double price=Double.parseDouble(pr);
        Demand demand=new Demand(); //ʵ����һ��������װ����
        demand.setDem_content(dem_contentDescription);
        demand.setDem_contentType(dem_contentType);
        demand.setPrice(price);

        Date currentDate = new Date(System.currentTimeMillis());//��ȡ��ǰʱ��


        java.util.Date date = new java.util.Date();//��ȡ��ǰʱ�����Ҳ����ֱ�Ӵ���Date�Ķ���

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        String time= sdf.format(date);//��ȡ��ʽ�����ڣ�����ʱ��

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
            //request.getRequestDispatcher("visitor_release.jsp").forward(request, response);//ת�����ο��û�ҳ��
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}