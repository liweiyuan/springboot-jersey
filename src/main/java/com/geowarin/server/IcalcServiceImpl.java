package com.geowarin.server;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by tingyun on 2018/1/18.
 */
public class IcalcServiceImpl extends UnicastRemoteObject implements ICalcService {

    private static final long serialVersionUID = -271947229644133464L;

    protected IcalcServiceImpl() throws RemoteException {
    }

    public int add(int a, int b) throws RemoteException {
        int result = a + b;
        System.out.printf("%d + %d = %d %n", a, b, result);
        return result;
    }

    public int minus(int a, int b) throws RemoteException {
        int result = a - b;
        System.out.printf("%d - %d = %d %n", a, b, result);
        return result;
    }
}
