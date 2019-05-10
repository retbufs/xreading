package com.zhenio.xreading.annotation;

import ch.qos.logback.core.util.ExecutorServiceUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    private List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService service = Executors.newFixedThreadPool(1000);

        for(int i = 0;i<10000;i++){
            Callable callable;
        }

        service.execute(new Runnable() {
            @Override
            public void run() {
                for(int i =0;i<1000000;i++){
                    if(i%2 ==0){
                    }
                }
            }
        });
        String path = "";
        int tests = 0;
        int passed = 0;
        try {
            Class<?> zCls = Class.forName("com.zhenio.xreading.annotation.TestMain");
            for (Method method : zCls.getDeclaredMethods()) {
                //需要按照不同key值来处理url
                if (method.isAnnotationPresent(Route.class)) {
                   String [] as=  getPath(method, Route.class);
                   for (String aa:as){
                       System.out.println("::"+aa);
                   }
                    String[] s = zCls.getAnnotation(Route.class).value();
                    for (String ss : s) {
                        path += ss;
                    }
                    System.out.println("class:" + s);
                    String typeName = method.getGenericReturnType().getTypeName();
                    System.out.println(typeName);
                    System.out.println(method.getAnnotation(Route.class).value()[0]);
                    for (String ss : method.getAnnotation(Route.class).value()) {
                        path += ss;
                    }
                    System.out.println(path);
                    Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                    for (Annotation[] a : parameterAnnotations) {
                        for (Annotation j : a
                        ) {
                            System.out.println(a);
                        }
                    }
                    System.out.println(method.getName());
                    System.out.println(method.getDefaultValue());
                    System.out.println(method.getAnnotatedReturnType().getType());
                    System.out.println();
                    AnnotatedType[] annotatedParameterTypes = method.getAnnotatedParameterTypes();
                    for (AnnotatedType a : annotatedParameterTypes
                    ) {
                        System.out.println(a.getType());
                    }

                    tests++;
                    //  method.invoke(null);
                    passed++;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(tests + "::::" + passed);
    }

    public static String []  getPath(Method method, Class<Route> annotationClass) {
        //读取value数组中的path
        //请求的方法
        if (method.isAnnotationPresent(annotationClass)) return method.getAnnotation(annotationClass).value();
        return null;
    }
}
