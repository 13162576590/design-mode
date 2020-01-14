package proxy.custom;

import proxy.exector.Exector;
import proxy.jdk.SurrogateObjectI;

import java.lang.reflect.Method;

public class CustomExector implements CustomInvocationHandler {

    private SurrogateObjectI surrogateObject;

    //获取被代理人的个人资料
    public Object getInstance(SurrogateObjectI surrogateObject) throws Exception {
        this.surrogateObject = surrogateObject;
        Class<? extends SurrogateObjectI> clazz = surrogateObject.getClass();
        return CustomProxy.newProxyInstance(new CustomClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("自定义，我是执行这,我来做这件事");
        method.invoke(surrogateObject, args);
        System.out.println("自定义，我是执行这,这件事做完了");
        return null;
    }

}
