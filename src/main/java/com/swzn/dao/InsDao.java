package com.swzn.dao;

import com.swzn.domian.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsDao {
    @Insert("insert into qqins(id,name,pwd) values(#{id},#{name},#{pwd})")
    int insertIns(QQins qQins);
    @Select("select * from qqins where id=#{id}")
    QQins findInsById(int id);
    @Update("update qqins set name=#{name},sex=#{sex},age=#{age},xin=#{xin},addr=#{addr},mail=#{mail},state=#{state},img=#{img} where id=#{id}")
    int updateIns(QQins qQins);
    @Insert("insert into qcon values(#{qconid},#{id},#{qgid})")
    int addqqfriend(Qcon qcon);
    @Delete("delete from qcon where qconid=#{qconid} and id=#{id}")
    int delqqfriend(Qcon qcon);
    @Select("select * from qcon where qconid=#{qconid}")
    Qcon findQconById(int qconid);
    @Select("select qqins.id,qqins.name,qqins.img,qqins.sex,qqins.age,qqins.xin,qqins.mail,qqins.state from qcon,qqins where qcon.qconid=qqins.id and qcon.id=#{id}")
    List<QQins> findAllqfById(int id);
    @Insert("insert into qqun(qid,qname,qunimg,qcid) values(#{qid},#{qname},#{qunimg},#{qcid})")
    int addqun(QQun qQun);
    @Select("select * from qqun where qid=#{qid}")
    QQun findQunById(int qid);
    @Insert("insert into qunmen values(#{qid},#{id})")
    int addqunmen(Qunmen qunmen);
    @Delete("delete from qunmen where qid=#{qid} and id=#{id}")
    int exitqun(Qunmen qunmen);
    @Select("select qqun.qid,qqun.qname,qqun.qctime,qqun.qunimg,qqun.qctime from qunmen,qqun where qunmen.qid=qqun.qid and qunmen.id=#{qid}")
    List<QQun> findAllyourqun(int id);
    @Select("SELECT qqun.qid,qqun.qname,qqun.qcid,qunmen.id,qqins.name,qqins.sex,qqins.age,qqins.xin,qqins.addr,qqins.mail,qqins.state,qqins.img FROM qqun,qunmen,qqins where qqun.qid=qunmen.qid and qunmen.id=qqins.id and qqun.qid=#{qid}")
    List<QQins> findQunAllmen(int qid);
    @Delete("delete from qunmen where qid=#{qid}")
    int delqunallmen(int qid);
    @Delete("delete from qqun where qid=#{qid}")
    int delqun(int qid);
    @Insert("insert into qgroup values(#{qgid},#{id},#{qgname})")
    int addgroup(Qgroup qgroup);
    @Update("update qcon set qgid=#{qgid} where qconid=#{qconid}")
    int movetogroup(Qcon qcon);
    @Update("update qcon set qgid=NULL where qgid=#{qgid}")
    int moveoutgroup(int qgid);
    @Delete("delete from qgroup where qgid=#{qgid} and id=#{id}")
    int delgroup(Qgroup qgroup);
    @Select("select * from qgroup where id=#{id}")
    List<Qgroup> findallgroud(int id);
    @Insert("insert into qdyn(qdid,id,qdcontext,qdpic) values(#{qdid},#{id},#{qdcontext},#{qdpic})")
    int insertdyn(Qdyn qdyn);
    @Delete("delete from qdyn where qdid=#{qdid} and id=#{id}")
    int deldyn(Qdyn qdyn);
    @Select("select * from qdyn where id=#{id}")
    List<Qdyn> finddybyid(int id);
}
