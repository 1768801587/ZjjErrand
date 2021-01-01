package com.servlet;
   import java.io.IOException;
   import java.io.PrintWriter;
   import java.sql.SQLException;
   import javax.servlet.ServletException;
   import javax.servlet.annotation.WebServlet;
   import javax.servlet.http.HttpServlet;
   import javax.servlet.http.HttpServletRequest;
   import javax.servlet.http.HttpServletResponse;
   import javax.servlet.http.HttpSession;
   import com.dao.UserDao;
   import com.bean.User;
@WebServlet("/UpdatePerInfoServlet")
public class UpdatePerInfoServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //设置response查询的码表
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //先查到要修改的用户   在进行修改
        HttpSession session=request.getSession();
        User user;
        user= (User) session.getAttribute("loginUser");//获得当前登录用户，未修改的

        String u_name = request.getParameter("u_name");//获得参数
        String pwd = request.getParameter("pwd");
        String sex = request.getParameter("sex");
        String phone = request.getParameter("phone");

        user.setPhone(phone);//封装成一个对象
        user.setU_name(u_name);
        user.setPwd(pwd);
        user.setSex(sex);

        UserDao ud = new UserDao();
        PrintWriter pw=response.getWriter();
        if(ud.update(user)){//修改个人信息
            pw.write("<script>");
            pw.write("alert(\"Modify Successfully!\");");
            pw.write("window.location.href='PersonalCenter.jsp'");
            pw.write("</script>");

        }else{
            pw.write("<script>");
            pw.write("alert(\"Modify Failed!\");");
            pw.write("window.location.href='PersonalCenter.jsp'");
            pw.write("</script>");

        }

        pw.flush();
        pw.close();
        session.setAttribute("loginUser",ud.getUser(phone,pwd));//将修改过的 user对象  写进session
        request.getRequestDispatcher("/PersonalCenter.jsp").forward(request, response);


    }
}
