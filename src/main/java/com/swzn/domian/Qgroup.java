package com.swzn.domian;

public class Qgroup {
    Integer qgid;
    Integer id;
    String qgname;
    Boolean ifsuccess;
    String mess;

    public Boolean getIfsuccess() {
        return ifsuccess;
    }

    public void setIfsuccess(Boolean ifsuccess) {
        this.ifsuccess = ifsuccess;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public Integer getQgid() {
        return qgid;
    }

    public void setQgid(Integer qgid) {
        this.qgid = qgid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQgname() {
        return qgname;
    }

    public void setQgname(String qgname) {
        this.qgname = qgname;
    }
}
