package proxy.custom;

import proxy.jdk.SurrogateObjectI;
import proxy.model.SurrogateObject;

public class CustomProxyTest {

    public static void main(String[] args) throws Exception {
        SurrogateObjectI surrogateObject = (SurrogateObjectI)new CustomExector().getInstance(new SurrogateObject());
        surrogateObject.doSth();
    }

}
