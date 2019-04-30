package com.zhenio.xreading.annotation;

@Route("/user/")
public class TestMain {
    @Route("api")
    public String route(){
        System.out.println("");
        return "type";
    }
}
