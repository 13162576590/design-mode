package proxy.model;

import proxy.exector.Exector;
import proxy.jdk.SurrogateObjectI;

public class SurrogateObject implements SurrogateObjectI {

    @Override
    public void doSth() {
        System.out.println("我是被代理对象,我需要做一些事,但是又无法做到");
    }

}
