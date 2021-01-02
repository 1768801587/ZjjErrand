package com.dao;

import com.bean.Evaluate;
import com.bean.Order;
import com.utils.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EvaluateDao {
    public boolean addEvaluate(Evaluate eva) throws SQLException {//评论  增加
        boolean flag = false;
        DBconn.init();

        String sql="insert into `evaluate`(demand_id,eva_content,eva_time,u_name,u_id,order_id) " +
                "values('" +eva.getDemand_id()+"','"+eva.getEva_content()+"','"+eva.getEva_time()+"','"+eva.getU_name()+
                "','"+eva.getU_id() +"','"+eva.getOrder_id()+"')";
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();

        return flag;
    }

    public Evaluate getOneEva(int id) {//根据订单号查评论
        Evaluate eva=new Evaluate();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from `evaluate` where order_id='"+id+"'");
            while(rs.next()){
                eva.setU_name(rs.getString("u_name"));
                eva.setU_id(rs.getInt("u_id"));
                eva.setOrder_id(rs.getInt("order_id"));
                eva.setEva_time(rs.getString("eva_time"));
                eva.setEva_content(rs.getString("eva_content"));
                eva.setDemand_id(rs.getInt("demand_id"));
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eva;
    }

    public List<Evaluate> getOrderAllEva(int order_id) {//获取当前订单下的所有评论
        List<Evaluate> list = new ArrayList<Evaluate>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from `evaluate` where order_id='"+order_id+"'");
            while(rs.next()){
                Evaluate eva = new Evaluate();
                eva.setU_name(rs.getString("u_name"));
                eva.setU_id(rs.getInt("u_id"));
                eva.setOrder_id(rs.getInt("order_id"));
                eva.setEva_time(rs.getString("eva_time"));
                eva.setEva_content(rs.getString("eva_content"));
                eva.setDemand_id(rs.getInt("demand_id"));
                list.add(eva);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Evaluate> getAllEvaluate() {//获取所有用户发布的所有评论
        List<Evaluate> list = new ArrayList<Evaluate>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from `evaluate` ");
            while(rs.next()){
                Evaluate eva = new Evaluate();
                eva.setEva_id(rs.getInt("eva_id"));
                eva.setU_name(rs.getString("u_name"));
                eva.setU_id(rs.getInt("u_id"));
                eva.setOrder_id(rs.getInt("order_id"));
                eva.setEva_time(rs.getString("eva_time"));
                eva.setEva_content(rs.getString("eva_content"));
                eva.setDemand_id(rs.getInt("demand_id"));
                list.add(eva);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean delete(int id) {
        boolean flag = false;
        DBconn.init();
        String sql = "delete  from `evaluate`e where eva_id="+id;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }
}
