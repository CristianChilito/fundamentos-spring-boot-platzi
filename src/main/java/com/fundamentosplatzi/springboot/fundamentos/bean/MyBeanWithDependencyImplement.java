package com.fundamentosplatzi.springboot.fundamentos.bean;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{
    private MyOperation myOperation;
    Log LOGGER= LogFactory.getLog(MyBeanWithDependencyImplement.class);
    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("INGRESANDO AL METODO printWithDependency ");
        int numero=1;
        LOGGER.debug("El número de Dependency es: "+numero);
        System.out.println(myOperation.sum(numero));
        System.out.println("bean con dependencia");
    }
}
