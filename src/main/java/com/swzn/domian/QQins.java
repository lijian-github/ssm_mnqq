package com.swzn.domian;

public class QQins {
    Integer id;
    String name;
    String sex;
    Integer age;
    String xin;
    String addr;
    String mail;
    String state;
    String img;
    String pwd;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getXin() {
        return xin;
    }

    public void setXin(String xin) {
        this.xin = xin;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "QQins{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", xin='" + xin + '\'' +
                ", addr='" + addr + '\'' +
                ", mail='" + mail + '\'' +
                ", state='" + state + '\'' +
                ", img='" + img + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
