package proxy.cglib;

import proxy.model.SurrogateObject;

public class CglibProxyTest {

    public static void main(String[] args)  throws Exception {
        SurrogateObject surrogateObject = (SurrogateObject)new CglibProxy().getInstance(SurrogateObject.class);
        surrogateObject.doSth();
    }

}
