package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.User;
import com.utils.DBconn;

public class UserDao {

    public boolean register(User user) throws SQLException {
        boolean flag = false;
        DBconn.init();
        ResultSet rs = DBconn.selectSql("select * from user where phone='"+user.getPhone()+"'");
        if (!rs.next()){//判断用户手机号是否注册   若未注册
            int i =DBconn.addUpdDel("insert into user(u_name,pwd,sex,phone,u_type) " +
                    "values('"+user.getU_name()+"','"+user.getPwd()+"','"+user.getSex()+"','"+user.getPhone()+"','"+user.getU_type()+"')");
            if(i>0){
                flag = true;
            }
        }

        DBconn.closeConn();
        return flag;
    }
    public boolean login(String phone, String pwd) {
        boolean flag = false;
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from user where phone='"+phone+"' and pwd='"+pwd+"'");
            while(rs.next()){
                if(rs.getString("phone").equals(phone) && rs.getString("pwd").equals(pwd)){
                    flag = true;
                }
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    public User getUser(String phone, String pwd) {
        User user=new User();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from user where phone='"+phone+"' and pwd='"+pwd+"'");
            while(rs.next()){
                user.setU_id(rs.getInt("u_id"));
                user.setU_name(rs.getString("u_name"));
                user.setPwd(rs.getString("pwd"));
                user.setSex(rs.getString("sex"));
                user.setPhone(rs.getString("phone"));
                user.setU_type(rs.getInt("u_type"));
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public List<User> getUserAll() {
        List<User> list = new ArrayList<User>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from user");
            while(rs.next()){
                User user = new User();
                user.setU_id(rs.getInt("u_id"));
                user.setU_name(rs.getString("u_name"));
                user.setPwd(rs.getString("pwd"));
                user.setSex(rs.getString("sex"));
                user.setPhone(rs.getString("phone"));
                user.setU_type(rs.getInt("u_type"));
                list.add(user);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean update(User user) {
        boolean flag = false;
        DBconn.init();
        String sql ="update user set u_name ='"+user.getU_name()
                +"' , pwd ='"+user.getPwd()
                +"' , sex ='"+user.getSex()
                +"' , phone ='"+user.getPhone()+"' where u_id='"+user.getU_id()
                +"'"
                ;

        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }
    public boolean delete(int id) {
        boolean flag = false;
        DBconn.init();
        String sql = "delete  from user where u_id="+id;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

}