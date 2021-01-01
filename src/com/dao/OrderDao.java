package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bean.Demand;
import com.bean.Order;
import com.bean.User;
import com.utils.DBconn;

public class OrderDao {

    public boolean addOrdIdToDemand(Order order){//接单后给需求表中增加order_id
        boolean flag = false;
        DBconn.init();
        //String sql="insert into `demand`(order_id)"+"values('"+order.getOrder_id()+"')";
        String sql =" update demand set order_id ='"+order.getDemand_id()
                +"' where demand_id='"+order.getDemand_id()+"' "
                ;
        int i=DBconn.addUpdDel(sql);
        if(i>0){
            flag=true;
        }

        DBconn.closeConn();

        return flag;
    }
    public boolean addOrder(Order order) throws SQLException {//发布需求  增加
        boolean flag = false;
        DBconn.init();

        String sql="insert into `order`(demand_id,ord_content,ord_contentType,price,j_id,f_id,ord_time,j_name,f_name,dem_time) " + "values('" +order.getDemand_id()+"','"+order.getOrd_content()+"','"+order.getOrd_contentType()+"','"+order.getPrice()+"','"+order.getJ_id() +"','"+order.getF_id()+"','"+order.getOrd_time()+"','"+order.getJ_name()+"','"+order.getF_name()+"','"+order.getDem_time()+"')";
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        if(flag==true){
            flag=addOrdIdToDemand(order);
        }
        return flag;
    }
    public boolean updateOrdIdInDemand() {//更新需求表中的order_id
        List<Order> list = this.getAllOrder();
        DemandDao dd=new DemandDao();
        int i=0;
        boolean flag = false;

        List<Demand>demandList= dd.getAllDemand();
        for (int j = 0; j < list.size(); j++) {
            for(int k=0;k<demandList.size();k++){
                if(list.get(j).getDemand_id()==demandList.get(k).getDemand_id()&&demandList.get(k).getOrder_id()!=0&&list.get(j).getOrder_id()!=demandList.get(k).getOrder_id()){
                    demandList.get(k).setOrder_id(list.get(j).getOrder_id());
                    DBconn.init();
                    String sql =" update `demand` set order_id ='"+demandList.get(k).getOrder_id()
                            +"' where demand_id='"+demandList.get(k).getDemand_id()+"' "
                            ;
                    i +=DBconn.addUpdDel(sql);
                    break;
                }
            }
        }

        if(i>0){
            flag=true;
        }
            DBconn.closeConn();

        return flag;
    }

    public Order getOneOrderfromDemID(int id) {
        Order order=new Order();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from `order` where demand_id='"+id+"'");
            while(rs.next()){
                order.setPrice(rs.getDouble("price"));
                order.setOrd_contentType(rs.getString("ord_contentType"));
                order.setOrd_content(rs.getString("ord_content"));
                order.setOrd_time(rs.getString("ord_time"));
                order.setDem_time(rs.getString("dem_time"));
                order.setJ_name(rs.getString("j_name"));
                order.setOrder_id(rs.getInt("order_id"));
                order.setF_name(rs.getString("f_name"));
                order.setDemand_id(rs.getInt("demand_id"));
                order.setJ_id(rs.getInt("j_id"));
                order.setF_id(rs.getInt("f_id"));
                order.setEva_id(rs.getInt("eva_id"));
                order.setFinished_time(rs.getString("finished_time"));
                order.setIsEva(rs.getInt("isEva"));
                order.setIsPay(rs.getInt("isPay"));
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    public Order getOneOrder(int id) {
        Order order=new Order();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from `order` where order_id='"+id+"'");
            while(rs.next()){
                order.setPrice(rs.getDouble("price"));
                order.setOrd_contentType(rs.getString("ord_contentType"));
                order.setOrd_content(rs.getString("ord_content"));
                order.setOrd_time(rs.getString("ord_time"));
                order.setDem_time(rs.getString("dem_time"));
                order.setJ_name(rs.getString("j_name"));
                order.setOrder_id(rs.getInt("order_id"));
                order.setF_name(rs.getString("f_name"));
                order.setDemand_id(rs.getInt("demand_id"));
                order.setJ_id(rs.getInt("j_id"));
                order.setF_id(rs.getInt("f_id"));
                order.setEva_id(rs.getInt("eva_id"));
                order.setFinished_time(rs.getString("finished_time"));
                order.setIsEva(rs.getInt("isEva"));
                order.setIsPay(rs.getInt("isPay"));
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }
    public List<Order> getAllOrder() {//获取所有用户发布的所有订单
        List<Order> list = new ArrayList<Order>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from `order` ");
            while(rs.next()){
                Order order = new Order();
                order.setPrice(rs.getDouble("price"));
                order.setOrd_contentType(rs.getString("ord_contentType"));
                order.setOrd_content(rs.getString("ord_content"));
                order.setOrd_time(rs.getString("ord_time"));
                order.setDem_time(rs.getString("dem_time"));
                order.setJ_name(rs.getString("j_name"));
                order.setOrder_id(rs.getInt("order_id"));
                order.setF_name(rs.getString("f_name"));
                order.setDemand_id(rs.getInt("demand_id"));
                order.setJ_id(rs.getInt("j_id"));
                order.setF_id(rs.getInt("f_id"));
                order.setEva_id(rs.getInt("eva_id"));
                order.setFinished_time(rs.getString("finished_time"));
                order.setIsEva(rs.getInt("isEva"));
                order.setIsPay(rs.getInt("isPay"));
                list.add(order);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Order> getPersonalOrder(int id) {//获取所有当前用户发布的所有需求
        List<Order> list = new ArrayList<Order>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from `order` where j_id='"+id+"'");
            while(rs.next()){
                Order order = new Order();
                order.setPrice(rs.getDouble("price"));
                order.setOrd_contentType(rs.getString("ord_contentType"));
                order.setOrd_content(rs.getString("ord_content"));
                order.setOrd_time(rs.getString("ord_time"));
                order.setDem_time(rs.getString("dem_time"));
                order.setJ_name(rs.getString("j_name"));
                order.setOrder_id(rs.getInt("order_id"));
                order.setF_name(rs.getString("f_name"));
                order.setDemand_id(rs.getInt("demand_id"));
                order.setJ_id(rs.getInt("j_id"));
                order.setF_id(rs.getInt("f_id"));
                order.setEva_id(rs.getInt("eva_id"));
                order.setFinished_time(rs.getString("finished_time"));
                order.setIsEva(rs.getInt("isEva"));
                order.setIsPay(rs.getInt("isPay"));
                list.add(order);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean update(Order order) {
        boolean flag = false;
        DBconn.init();
        String sql =" update `order` set finished_time ='"+order.getFinished_time()
                +"' , isPay ='"+order.getIsPay()
                +"' , isEva ='"+order.getIsEva()
                +"' where order_id='"+order.getOrder_id()+"' "
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
        String sql = "delete  from demand where demand_id="+id;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

}