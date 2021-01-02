package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Demand;
import com.bean.User;
import com.utils.DBconn;

public class DemandDao {

    public boolean addDemand(Demand demand) throws SQLException {//发布需求  增加
        boolean flag = false;
        DBconn.init();

            int i =DBconn.addUpdDel("insert into `demand` (u_name,u_id,dem_content,dem_time,dem_contentType,price) " +//demand.getDem_time()+"','"+demand.getDem_contentType()+"')");
                    "values('"+demand.getU_name()+"','"+demand.getU_id()+"','"+demand.getDem_content()+"','"+demand.getDem_time()+"','"+demand.getDem_contentType()+"','"+demand.getPrice()+"')");
            if(i>0){
                flag = true;
            }


        DBconn.closeConn();
        return flag;
    }

    public Demand getOneDemand(int id) {
        Demand demand=new Demand();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from `demand` where demand_id='"+id+"'");
            while(rs.next()){
                demand.setDemand_id(rs.getInt("demand_id"));
                demand.setU_id(rs.getInt("u_id"));
                demand.setU_name(rs.getString("u_name"));
                demand.setDem_contentType(rs.getString("dem_contentType"));
                demand.setDem_time(rs.getString("dem_time"));
                demand.setDem_content(rs.getString("dem_content"));
                demand.setOrder_id(rs.getInt("order_id"));
                demand.setPrice(rs.getDouble("price"));
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return demand;
    }
    public List<Demand> getAllDemand() {//获取所有用户发布的所有需求
        List<Demand> list = new ArrayList<Demand>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from `demand` ");
            while(rs.next()){
                Demand demand = new Demand();
                demand.setDemand_id(rs.getInt("demand_id"));
                demand.setU_id(rs.getInt("u_id"));
                demand.setU_name(rs.getString("u_name"));
                demand.setDem_contentType(rs.getString("dem_contentType"));
                demand.setDem_time(rs.getString("dem_time"));
                demand.setDem_content(rs.getString("dem_content"));
                demand.setOrder_id(rs.getInt("order_id"));
                demand.setPrice(rs.getDouble("price"));
                list.add(demand);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Demand> getPersonalDemandAll(int u_id) {//获取所有当前用户发布的所有需求
        List<Demand> list = new ArrayList<Demand>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from `demand` where u_id='"+u_id+"'");
            while(rs.next()){
                Demand demand = new Demand();
                demand.setDemand_id(rs.getInt("demand_id"));
                demand.setU_id(rs.getInt("u_id"));
                demand.setU_name(rs.getString("u_name"));
                demand.setDem_contentType(rs.getString("dem_contentType"));
                demand.setDem_time(rs.getString("dem_time"));
                demand.setDem_content(rs.getString("dem_content"));
                demand.setOrder_id(rs.getInt("order_id"));
                demand.setPrice(rs.getDouble("price"));
                list.add(demand);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean update(int demand_id,String type, String content,double price) {
        boolean flag = false;
        DBconn.init();
        String sql =" update `demand` set dem_contentType ='"+type
                +"' , dem_content ='"+content
                +"' , price ='"+price
                 +"' where demand_id='"+demand_id+"' "
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
        String sql = "delete  from `demand` where demand_id="+id;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

}