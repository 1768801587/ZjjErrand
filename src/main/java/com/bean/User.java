package com.bean;

public class User {
    private int u_id;
    private String sex;
    private String u_name;
    private String pwd;
    private String phone;
    private int u_type;
    public User() {
    }

    public User(int u_id, String sex, String u_name, String pwd, String phone, int u_type) {
        this.u_id = u_id;
        this.sex = sex;
        this.u_name = u_name;
        this.pwd = pwd;
        this.phone = phone;
        this.u_type = u_type;
    }

    public int getU_type() {
        return u_type;
    }

    public void setU_type(int u_type) {
        this.u_type = u_type;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", sex='" + sex + '\'' +
                ", u_name='" + u_name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", phone='" + phone + '\'' +
                ", u_type='" + u_type + '\'' +
                '}';
    }
}
