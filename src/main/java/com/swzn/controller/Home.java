package com.swzn.controller;

import com.swzn.domian.*;
import com.swzn.service.InsServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import sun.rmi.runtime.Log;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class Home {

    @Autowired
    InsServiceDao insServiceDao;
    @RequestMapping("/login")
    @ResponseBody
    public Login login(int id, String pwd){
        return insServiceDao.Loginbydd(id,pwd);
    }
    @RequestMapping("/findqq")
    @ResponseBody
    public QQins findqq(int id){
        return insServiceDao.findInsById(id);
    };
    @RequestMapping("/register")
    @ResponseBody
    public Register register(int id, String pwd){
        return insServiceDao.Rgisterbyqq(id,pwd);
    };
    //编辑信息
    @RequestMapping("/editins")
    @ResponseBody
    public EditIns editins(QQins qQins){
        return insServiceDao.Editins(qQins);
    };
    //新建qq群
    @RequestMapping("/addqun")
    @ResponseBody
    public QQun addqun(QQun qQins){
        return insServiceDao.AddQun(qQins);
    };
    //查找qq群
    @RequestMapping("/findqun")
    @ResponseBody
    public QQun findqun(int qid){
        return insServiceDao.findQunByid(qid);
    };
    //添加好友
    @RequestMapping("/addqqfriend")
    @ResponseBody
    public Qcon addqqfriend(Qcon qc){
        return insServiceDao.addqqfriend(qc);
    };
    //自己的所有好友
    @RequestMapping("/findallqf")
    @ResponseBody
    public List<QQins> findAllqfById(int id){
        return insServiceDao.findAllqfById(id);
    };
    //删除好友
    @RequestMapping("/delqqfriend")
    @ResponseBody
    public Qcon delqqfriend(Qcon qcon){
        return insServiceDao.delqqfriend(qcon);
    }
    //加入qq群
    @RequestMapping("/addqunmen")
    @ResponseBody
    public Qunmen addqunmen(Qunmen qunmen){
        return insServiceDao.addqunmen(qunmen);
    };
    //退出qq群
    @RequestMapping("/exitqun")
    @ResponseBody
    public Qunmen exitqun(Qunmen qunmen){
        return insServiceDao.exitqun(qunmen);
    };
    //你加入的所有群
    @RequestMapping("/findallyourqun")
    @ResponseBody
    public List<QQun> findAllyourqun(int id){
        return insServiceDao.findAllyourqun(id);
    };

    //群所有成员
    @RequestMapping("/findqunallmen")
    @ResponseBody
    public List<QQins> findQunAllmen(int qid){
        return insServiceDao.findQunAllmen(qid);
    }

    //删除群
    @RequestMapping("/delqun")
    @ResponseBody
    public QQun delqun(int qid){
        return insServiceDao.delqun(qid);
    }
    //添加分组
    @RequestMapping("/addgroup")
    @ResponseBody
    public Qgroup addgroup(Qgroup qgroup) {
        return insServiceDao.addgroup(qgroup);
    }
    //移动到分组
    @RequestMapping("/movetogroup")
    @ResponseBody
    public Qcon movetogroup(Qcon qcon) {
        return insServiceDao.movetogroup(qcon);
    }
    //删除到分组
    @RequestMapping("/delgroup")
    @ResponseBody
    public Qgroup delgroup(Qgroup qgroup){
        return insServiceDao.delgroup(qgroup);
    }
    //所有分组
    @RequestMapping("/findallgroud")
    @ResponseBody
    List<Qgroup> findallgroud(int id){
        return insServiceDao.findallgroud(id);
    }
    //添加动态
    @RequestMapping("/insertdyn")
    @ResponseBody
    public Qdyn insertdyn(Qdyn qdyn) {
        return insServiceDao.insertdyn(qdyn);
    }

    //删除动态
    @RequestMapping("/deldyn")
    @ResponseBody
    public Qdyn deldyn(Qdyn qdyn) {
        return insServiceDao.deldyn(qdyn);
    }
    //所有好友动态
    @RequestMapping("/findallfdy")
    @ResponseBody
    public List<Qdyn> findallfdy(int id) {
        return insServiceDao.findallfdy(id);
    }

    //上传文件
    @RequestMapping("/onefile")
    @ResponseBody
    public Filemess oneFileUpload(@ModelAttribute FileDomain fileDomain, HttpServletRequest request) {
     return insServiceDao.FileUpload(fileDomain,request);
    }



}
