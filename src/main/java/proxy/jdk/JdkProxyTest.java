package proxy.jdk;

import proxy.exector.Exector;
import proxy.model.SurrogateObject;

public class JdkProxyTest {

    public static void main(String[] args) {
        SurrogateObjectI surrogateObject = (SurrogateObjectI)new Exector().getInstance(new SurrogateObject());
        surrogateObject.doSth();
    }

}
