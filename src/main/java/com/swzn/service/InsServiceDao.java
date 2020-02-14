package com.swzn.service;

import com.swzn.domian.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface InsServiceDao {
    QQins findInsById(int id);
    Login Loginbydd(int id,String pwd);
    Register Rgisterbyqq(int id,String pwd);
    EditIns Editins(QQins qQins);
    QQun AddQun(QQun qQun);
    QQun findQunByid(int qid);
    Qcon addqqfriend(Qcon qcon);
    List<QQins> findAllqfById(int id);
    Qunmen addqunmen(Qunmen qunmen);
    Qunmen exitqun(Qunmen qunmen);
    List<QQun> findAllyourqun(int id);
    List<QQins> findQunAllmen(int qid);
    Qcon delqqfriend(Qcon qcon);
    QQun delqun(int qid);
    Qgroup addgroup(Qgroup qgroup);
    Qcon movetogroup(Qcon qcon);
    Qgroup delgroup(Qgroup qgroup);
    List<Qgroup> findallgroud(int id);
    Qdyn insertdyn(Qdyn qdyn);
    Qdyn deldyn(Qdyn qdyn);
    List<Qdyn> findallfdy(int id);
    Filemess FileUpload(FileDomain fileDomain, HttpServletRequest request);
}
