package com.geowarin.controller;


import com.geowarin.server.ICalcService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by tingyun on 2018/1/18.
 */
@RestController
public class RmiController {

    @RequestMapping("/rmi")
    public String rmi() throws RemoteException, NotBoundException, MalformedURLException {
        ICalcService calcService= (ICalcService) Naming.lookup("rmi://localhost:9999/HelloRmi");
        System.out.println("client:");
        System.out.println(calcService.add(3,5));
        System.out.println(calcService.minus(4,6));

        return calcService.toString();
    }
}
