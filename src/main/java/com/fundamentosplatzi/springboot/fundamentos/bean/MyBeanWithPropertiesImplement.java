package com.fundamentosplatzi.springboot.fundamentos.bean;

public class MyBeanWithPropertiesImplement implements MyBeanWithProperties {
    private  String nombre;
    private String ramdon;

    public MyBeanWithPropertiesImplement(String nombre, String ramdon) {
        this.nombre = nombre;
        this.ramdon = ramdon;
    }

    @Override
    public String funtion() {
        return nombre+"-"+ramdon;
    }
}
