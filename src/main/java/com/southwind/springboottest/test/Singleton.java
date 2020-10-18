package com.southwind.springboottest.test;

public class Singleton {

    //添加volatile的修饰，禁止指令重排
    private volatile  static Singleton singleton = null;

    private  Singleton(){

    }

    public Singleton getSingleton(){
        ////先检查实例是否存在，如果不存在才进入下面的同步块
        if(singleton == null){
            synchronized(Singleton.class){
                //再次检查实例是否存在，如果不存在才真的创建实例
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
