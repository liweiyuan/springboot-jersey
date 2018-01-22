package com.geowarin.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by tingyun on 2018/1/18.
 */
public interface ICalcService extends Remote {

    int add(int a, int b) throws RemoteException;

    int minus(int a, int b) throws RemoteException;
}
