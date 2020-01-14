package proxy.exector;

import proxy.jdk.SurrogateObjectI;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Exector implements InvocationHandler {

    private SurrogateObjectI surrogateObject;

    public Object getInstance(SurrogateObjectI surrogateObject) {
        this.surrogateObject = surrogateObject;
        Class clazz = surrogateObject.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是执行这,我来做这件事");
        method.invoke(surrogateObject, args);
        System.out.println("我是执行这,这件事做完了");
        return null;
    }

}
