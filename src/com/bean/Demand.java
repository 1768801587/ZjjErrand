package com.bean;

import java.sql.Date;

public class Demand {
    private int demand_id;//需求id
    private int order_id;//订单id
    private int u_id;//发布需求的用户id
    private String u_name;//用户姓名
    private String dem_content;//需求内容
    private String dem_contentType;//需求种类
    private String dem_time;
    private double price;

    public Demand(int demand_id, int order_id, int u_id, String u_name, String dem_content, String dem_contentType, String dem_time, double price) {
        this.demand_id = demand_id;
        this.order_id = order_id;
        this.u_id = u_id;
        this.u_name = u_name;
        this.dem_content = dem_content;
        this.dem_contentType = dem_contentType;
        this.dem_time = dem_time;
        this.price = price;
    }

    public Demand(){}

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDemand_id() {
        return demand_id;
    }

    public void setDemand_id(int demand_id) {
        this.demand_id = demand_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getDem_content() {
        return dem_content;
    }

    public void setDem_content(String dem_content) {
        this.dem_content = dem_content;
    }

    public String getDem_contentType() {
        return dem_contentType;
    }

    public void setDem_contentType(String dem_contentType) {
        this.dem_contentType = dem_contentType;
    }

    public String getDem_time() {
        return dem_time;
    }

    public void setDem_time(String dem_time) {
        this.dem_time = dem_time;
    }

    @Override
    public String toString() {
        return "Demand{" +
                "demand_id=" + demand_id +
                ", order_id=" + order_id +
                ", u_id=" + u_id +
                ", u_name='" + u_name + '\'' +
                ", dem_content='" + dem_content + '\'' +
                ", dem_contentType='" + dem_contentType + '\'' +
                ", dem_time='" + dem_time + '\'' +
                ", price=" + price +
                '}';
    }
}
