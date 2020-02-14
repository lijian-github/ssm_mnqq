package socket.server;


import com.swzn.dao.InsDao;
import com.swzn.domian.QQins;
import com.swzn.domian.Qunmen;
import com.swzn.service.InsServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import socket.handle.Findqunmen;
import socket.model.Messages;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Server{
    @Autowired
    InsDao insDao;
    ServerSocket serverSocket=null;
    Socket Ssocket=null;
    HashMap<Integer, ObjectOutputStream> allOut;
    public Server() {
        // TODO 自动生成的构造函数存根

        allOut=new HashMap<Integer, ObjectOutputStream>();//建立输出流链表，存储向每一个客户端的输出流
        while(true) {
            try {
                serverSocket=new ServerSocket(2018);
            } catch (IOException e) {
                // TODO 自动生成的 catch 块
                System.out.println("正在监听");
            }
            try {
                System.out.println("等待客户端呼叫");
                Ssocket=serverSocket.accept();
                System.out.println("客户端ip"+Ssocket.getInetAddress());
            } catch (IOException e) {
                // TODO 自动生成的 catch 块
                System.out.println("等待客户端");
            }
            if (Ssocket!=null) {
                new Thread(new ServerThread(Ssocket)).start();
            }

        }
    }

    class ServerThread extends Thread{
        Socket socket;
        ObjectInputStream ois;
        ObjectOutputStream oos;
        FileOutputStream fos=null;
        Integer key=null;
        //String result=null;
        public ServerThread(Socket s) {
            // TODO 自动生成的构造函数存根
            socket=s;
            try {
                oos=new ObjectOutputStream(socket.getOutputStream());
                ois=new ObjectInputStream(socket.getInputStream());
            } catch (Exception e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }

        }

        @Override
        public void run() {
            // TODO 自动生成的方法存根
            while(true) {
//                DataBag result=null;
                Messages result=null;
                try {
                    result=(Messages) ois.readObject();

                    if (result.getType().equals("login")) {
                        System.out.println("login");
//					String pass=result.getStringdatas()[1];
//                        System.out.println(login);
//                        HandleLogin handleLogin=new HandleLogin();
                        int id=result.getFromid();
                        this.key= id;
                        if (allOut.containsKey(key)) {
                            Messages relogin=new Messages();
                            relogin.setType("twoline");
                            allOut.get(key).writeObject(relogin);
                        }else {
                            allOut.put(key, oos);//登录成功加入列表
                            Messages relogin=new Messages();
                            relogin.setType("true");
                            allOut.get(key).writeObject(relogin);
                        }

                    }

                    if (result.getType().startsWith("file")) {
                        int toid=result.getToid();
                        allOut.get(toid).writeObject(result);
                        System.out.println(result.getFromid()+"发送给"+result.getToid()+"："+result.getMes());

                    }


                    if (result.getType().equals("primessage")) {
                        int toid=result.getToid();
                        allOut.get(toid).writeObject(result);
                        System.out.println(result.getFromid()+"发送给"+result.getToid()+"："+result.getMes());
                    }

                    if (result.getType().equals("qunmessage")) {
                        int toid=result.getToid();
                        List<Integer> list=new Findqunmen().Query(toid);
//                        List<QQins> list=insDao.findQunAllmen(toid);
                        for (int qm:list){
                            if (qm!=key){
                                allOut.get(qm).writeObject(result);
                            }
                        }
                        System.out.println(result.getFromid()+"发送给群"+result.getToid()+"："+result.getMes());
                    }


                } catch (IOException | ClassNotFoundException e) {
                    // TODO 自动生成的 catch 块
                    System.out.println(key+" 断开");
                    System.out.println(e);
                    allOut.remove(key,oos);
                    break;
                }

            }

        }
    }


}


