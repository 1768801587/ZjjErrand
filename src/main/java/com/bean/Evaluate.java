package com.bean;

public class Evaluate {
    private int eva_id;
    private String u_name;
    private String eva_content;
    private String eva_time;
    private int demand_id;
    private int u_id;
    private int order_id;

    public Evaluate(int eva_id, String u_name, String eva_content, String eva_time, int demand_id, int u_id, int order_id) {
        this.eva_id = eva_id;
        this.u_name = u_name;
        this.eva_content = eva_content;
        this.eva_time = eva_time;
        this.demand_id = demand_id;
        this.u_id = u_id;
        this.order_id = order_id;
    }

    public Evaluate() {
    }

    public int getEva_id() {
        return eva_id;
    }

    public void setEva_id(int eva_id) {
        this.eva_id = eva_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getEva_content() {
        return eva_content;
    }

    public void setEva_content(String eva_content) {
        this.eva_content = eva_content;
    }

    public String getEva_time() {
        return eva_time;
    }

    public void setEva_time(String eva_time) {
        this.eva_time = eva_time;
    }

    public int getDemand_id() {
        return demand_id;
    }

    public void setDemand_id(int demand_id) {
        this.demand_id = demand_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    @Override
    public String toString() {
        return "Evaluate{" +
                "eva_id=" + eva_id +
                ", u_name='" + u_name + '\'' +
                ", eva_content='" + eva_content + '\'' +
                ", eva_time='" + eva_time + '\'' +
                ", demand_id=" + demand_id +
                ", u_id=" + u_id +
                ", order_id=" + order_id +
                '}';
    }
}
