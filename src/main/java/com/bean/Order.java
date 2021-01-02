package com.bean;

public class Order {
    private int order_id;
    private int demand_id;
    private String ord_content;
    private String ord_contentType;
    private int j_id;
    private int f_id;
    private String ord_time;
    private String f_name;
    private String j_name;
    private String finished_time;
    private int isPay;
    private int isEva;
    private int eva_id;
    private String dem_time;
    private double price;

    public Order(int order_id, int demand_id, String ord_content, String ord_contentType, int j_id, int f_id, String ord_time, String f_name, String j_name, String finished_time, int isPay, int isEva, int eva_id, String dem_time, double price) {
        this.order_id = order_id;
        this.demand_id = demand_id;
        this.ord_content = ord_content;
        this.ord_contentType = ord_contentType;
        this.j_id = j_id;
        this.f_id = f_id;
        this.ord_time = ord_time;
        this.f_name = f_name;
        this.j_name = j_name;
        this.finished_time = finished_time;
        this.isPay = isPay;
        this.isEva = isEva;
        this.eva_id = eva_id;
        this.dem_time = dem_time;
        this.price = price;
    }

    public Order(){}
    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getDemand_id() {
        return demand_id;
    }

    public void setDemand_id(int demand_id) {
        this.demand_id = demand_id;
    }

    public String getOrd_content() {
        return ord_content;
    }

    public void setOrd_content(String ord_content) {
        this.ord_content = ord_content;
    }

    public String getOrd_contentType() {
        return ord_contentType;
    }

    public void setOrd_contentType(String ord_contentType) {
        this.ord_contentType = ord_contentType;
    }

    public int getJ_id() {
        return j_id;
    }

    public void setJ_id(int j_id) {
        this.j_id = j_id;
    }

    public int getF_id() {
        return f_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }

    public String getOrd_time() {
        return ord_time;
    }

    public void setOrd_time(String ord_time) {
        this.ord_time = ord_time;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String u_name) {
        this.f_name = u_name;
    }

    public String getJ_name() {
        return j_name;
    }

    public void setJ_name(String j_name) {
        this.j_name = j_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFinished_time() {
        return finished_time;
    }

    public void setFinished_time(String finished_time) {
        this.finished_time = finished_time;
    }

    public int getIsPay() {
        return isPay;
    }

    public void setIsPay(int isPay) {
        this.isPay = isPay;
    }

    public int getIsEva() {
        return isEva;
    }

    public void setIsEva(int isEva) {
        this.isEva = isEva;
    }

    public int getEva_id() {
        return eva_id;
    }

    public void setEva_id(int eva_id) {
        this.eva_id = eva_id;
    }

    public String getDem_time() {
        return dem_time;
    }

    public void setDem_time(String dem_time) {
        this.dem_time = dem_time;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", demand_id=" + demand_id +
                ", ord_content='" + ord_content + '\'' +
                ", ord_contentType='" + ord_contentType + '\'' +
                ", j_id=" + j_id +
                ", f_id=" + f_id +
                ", ord_time='" + ord_time + '\'' +
                ", f_name='" + f_name + '\'' +
                ", j_name='" + j_name + '\'' +
                ", finished_time='" + finished_time + '\'' +
                ", isPay=" + isPay +
                ", isEva=" + isEva +
                ", eva_id=" + eva_id +
                ", dem_time='" + dem_time + '\'' +
                ", price=" + price +
                '}';
    }
}
