package com.example.demo.design;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Reflect 反射
 *
 * @author zhbin
 * @date 2020-06-06
 */
public class Reflect {
    public static void main(String[]args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> t = Class.forName("com.example.demo.design.Responsibility");
        Responsibility o = (Responsibility)t.newInstance();
        Method[] declaredMethods = t.getDeclaredMethods();

        Method handleRequest = t.getDeclaredMethod("handleRequest", String.class);

        handleRequest.invoke(o, "test");

        Field handler = t.getDeclaredField("handler");
        handler.setAccessible(true);
        handler.set(o, "ddd");

        

    }
}
