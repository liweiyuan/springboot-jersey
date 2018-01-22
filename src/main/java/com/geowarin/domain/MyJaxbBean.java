package com.geowarin.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by tingyun on 2018/1/18.
 */
@XmlRootElement
public class MyJaxbBean {
    private String name;
    private int age;

    public MyJaxbBean(){

    }

    public MyJaxbBean(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
