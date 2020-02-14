package com.swzn.service.impl;

import com.swzn.dao.InsDao;
import com.swzn.domian.*;
import com.swzn.service.InsServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.List;

@Service
public class InsServiceImp implements InsServiceDao {
    @Autowired
    InsDao insDao;

    @Override
    public QQins findInsById(int id) {
        QQins qQins=insDao.findInsById(id);
        if (qQins!=null){
            qQins.setPwd(null);
        }
        return qQins;
    }

    public  QQun findQunByid(int qid){

        return insDao.findQunById(qid);
    }

    @Override
    public Login Loginbydd(int id, String pwd) {
        QQins qQins=insDao.findInsById(id);
        Login login=new Login();
        if (qQins==null){
            login.setIflogin(false);
            login.setMess("账号不存在");
        }else if(!qQins.getPwd().equals(pwd)){
            login.setIflogin(false);
            login.setMess("密码错误");
        }else{
            qQins.setPwd(null);
            login.setqQins(qQins);
            login.setIflogin(true);
            login.setMess("登录成功");
        }
        return login;
    }

    @Override
    public Register Rgisterbyqq(int id, String pwd) {
        Register register=new Register();
        QQins qQins=insDao.findInsById(id);
        if (qQins==null){
            QQins qQins1=new QQins();
            qQins1.setId(id);
            qQins1.setPwd(pwd);
            qQins1.setName("mnqq"+id);
            int i=insDao.insertIns(qQins1);
            if (i==1){
                register.setIfregister(true);
                register.setMess("注册成功");
                register.setId(id);
            }else if(i==0){
                register.setIfregister(false);
                register.setMess("数据库报错");
            }
        }else {
            register.setIfregister(false);
            register.setMess("账号已经存在");
        }
        return register;
    }

    @Override
    public EditIns Editins(QQins qQins) {
        EditIns mess=new EditIns();
        int id=qQins.getId();
        QQins q=insDao.findInsById(id);
        if (q!=null){
            int i=insDao.updateIns(qQins);
            if (i==1){
                mess.setIfsuccess(true);
                mess.setMess("更新成功");
            }else{
                mess.setIfsuccess(false);
                mess.setMess("出错");
            }
        }else {
            mess.setIfsuccess(false);
            mess.setMess("没有该账号");
        }
        return mess;
    }

    @Override
    public QQun AddQun(QQun qQun) {
        int ui= (int) (new Date().getTime()/1000);
        qQun.setQid(ui);
        QQun re=new QQun();
        QQun qun=insDao.findQunById(ui);
        if (qun==null){
            int i =insDao.addqun(qQun);
            if (i==1){
                re=insDao.findQunById(ui);
                re.setIfsuccess(true);
                re.setMess("新建qq群成功");
                Qunmen qunmen=new Qunmen();
                qunmen.setQid(qQun.getQid());
                qunmen.setId(qQun.getQcid());
                insDao.addqunmen(qunmen);
            }else{
                re.setIfsuccess(false);
                re.setMess("出错");
            }
        }else{
            re.setIfsuccess(false);
            re.setMess("已有该群");
        }
        return re;
    }

    @Override
    public Qcon addqqfriend(Qcon qcon) {
        QQins qQins=insDao.findInsById(qcon.getQconid());
        if (qQins!=null){
            int i=insDao.addqqfriend(qcon);
            if (i==1){
                qcon.setIfsuccess(true);
                qcon.setMess("添加好友成功");
            }else {
                qcon.setIfsuccess(false);
                qcon.setMess("出错");
            }
        }else{
            qcon.setIfsuccess(false);
            qcon.setMess("没有找到该账户");
        }

        return qcon;
    }

    @Override
    public List<QQins> findAllqfById(int id) {
        return insDao.findAllqfById(id);
    }

    @Override
    public Qunmen addqunmen(Qunmen qunmen) {
        QQun qQun=insDao.findQunById(qunmen.getQid());
        if (qQun!=null){
            int i=insDao.addqunmen(qunmen);
            if (i==1){
                qunmen.setIfsuccess(true);
                qunmen.setMess("加群成功");
            }else {
                qunmen.setIfsuccess(false);
                qunmen.setMess("出错");
            }

        }else {
            qunmen.setIfsuccess(false);
            qunmen.setMess("没有该群");
        }
        return qunmen;
    }

    @Override
    public Qunmen exitqun(Qunmen qunmen) {
        int i=insDao.exitqun(qunmen);
        if (i==1){
            qunmen.setIfsuccess(true);
            qunmen.setMess("退群成功");
        }else {
            qunmen.setIfsuccess(false);
            qunmen.setMess("出错");
        }
        return qunmen;
    }

    @Override
    public List<QQun> findAllyourqun(int id) {
        return insDao.findAllyourqun(id);
    }

    @Override
    public List<QQins> findQunAllmen(int qid) {
        return insDao.findQunAllmen(qid);
    }

    @Override
    public Qcon delqqfriend(Qcon qcon) {
        int i=insDao.delqqfriend(qcon);
        if (i==1){
            qcon.setIfsuccess(true);
            qcon.setMess("删除好友成功");
        }else{
            qcon.setIfsuccess(false);
            qcon.setMess("删除好友失败");
        }
        return qcon;
    }

    @Override
    public QQun delqun(int qid) {
        QQun qQun=new QQun();
        int i=insDao.delqunallmen(qid);
        insDao.delqun(qid);
        qQun.setQid(qid);
        qQun.setIfsuccess(true);
        qQun.setMess("删除群成功");
        return qQun;
    }

    @Override
    public Qgroup addgroup(Qgroup qgroup) {
        int gi=(int) (new Date().getTime() / 1000);
        qgroup.setQgid(gi);
        if (insDao.addgroup(qgroup)==1){
            qgroup.setIfsuccess(true);
            qgroup.setMess("建立分组成功");
        }else {
            qgroup.setIfsuccess(false);
            qgroup.setMess("建立分组失败");
        }
        return qgroup;
    }

    @Override
    public Qcon movetogroup(Qcon qcon) {
        if (insDao.movetogroup(qcon)==1){
            qcon.setIfsuccess(true);
            qcon.setMess("移动成功");
        }else {
            qcon.setIfsuccess(false);
            qcon.setMess("移动失败");
        }
        return qcon;
    }

    @Override
    public Qgroup delgroup(Qgroup qgroup) {
        insDao.moveoutgroup(qgroup.getQgid());
        if(insDao.delgroup(qgroup)==1){
            qgroup.setIfsuccess(true);
            qgroup.setMess("删除分组成功");
        }
        else {
            qgroup.setIfsuccess(false);
            qgroup.setMess("删除分组失败");
        }
        return qgroup;
    }

    @Override
    public List<Qgroup> findallgroud(int id) {
        return insDao.findallgroud(id);
    }

    @Override
    public Qdyn insertdyn(Qdyn qdyn) {
        int gi=(int) (new Date().getTime() / 1000);
        qdyn.setQdid(gi);
        if (insDao.insertdyn(qdyn)==1){
            qdyn.setIfsuccese(true);
            qdyn.setMess("添加动态成功");
        }else{
            qdyn.setIfsuccese(false);
            qdyn.setMess("添加动态失败");
        }
        return qdyn;
    }

    @Override
    public Qdyn deldyn(Qdyn qdyn) {
        if (insDao.deldyn(qdyn)==1){
            qdyn.setIfsuccese(true);
            qdyn.setMess("删除动态成功");
        }else{
            qdyn.setIfsuccese(false);
            qdyn.setMess("删除动态失败");
        }
        return qdyn;
    }

    @Override
    public List<Qdyn> findallfdy(int id) {
        List<Qdyn> dyl=insDao.finddybyid(id);
        List<QQins> fl=insDao.findAllqfById(id);
        for (QQins fq:fl){
            dyl.addAll(insDao.finddybyid(fq.getId()));
        }
        return dyl;
    }

    @Override
    public Filemess FileUpload(FileDomain fileDomain, HttpServletRequest request) {
        String realpath = request.getSession().getServletContext().getRealPath("uploadfiles");
        String line= request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
//        System.out.println(fileDomain.getMyfile());
        String fileName = new Date().getTime()+fileDomain.getMyfile().getOriginalFilename();
        File targetFile = new File(realpath, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        //上传
        try {
            fileDomain.getMyfile().transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
      		@ModelAttribute FileDomain fileDomain这就话有这样一个功能：
      		model.addAttribute("fileDomain",fileDomain)所以此处不需要
         */
        Filemess filemess=new Filemess();
        filemess.setUrl(line+"/uploadfiles/"+fileName);
        filemess.setIfsuccess(true);
        return filemess;

    }


}
