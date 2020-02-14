package com.swzn.domian;


public class Qcon {
    Integer qconid;
    Integer id;
    Integer qgid;
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

    public Integer getQconid() {
        return qconid;
    }

    public void setQconid(Integer qconid) {
        this.qconid = qconid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQgid() {
        return qgid;
    }

    public void setQgid(Integer qgid) {
        this.qgid = qgid;
    }
}
