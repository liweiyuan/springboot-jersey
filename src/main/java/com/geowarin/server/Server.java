package com.geowarin.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by tingyun on 2018/1/18.
 */
public class Server {

    public static final String SERVICE_NAME="calc";

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException {
        //创建服务
        ICalcService service=new IcalcServiceImpl();
        LocateRegistry.createRegistry(9999);
        //把远程对象注册到RMI注册服务器上
        Naming.bind("rmi://localhost:9999/HelloRmi",service);
        System.out.println("server：对象绑定成功");
    }
}
