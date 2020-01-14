package proxy.custom;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.*;

public class CustomProxy {

    private static String ln = "\r\n";

    public static Object newProxyInstance(CustomClassLoader classLoader,
                                          Class<?>[] interfaces,
                                          CustomInvocationHandler h) throws IllegalArgumentException {
        try {
            //1、生成源码
            String proxySrc = generateSrc(interfaces[0]);

            //2、将生成的源代码输出到磁盘，保存为.java文件
            String filePath = CustomProxy.class.getResource("").getPath();
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(proxySrc);
            fw.flush();
            fw.close();

            //3、编译源代码，并且生成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> iterable = manager.getJavaFileObjects(f);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();

            //4.将class文件中的内容，动态加载到JVM中来
            Class<?> proxyClass = classLoader.findClass("$Proxy0");
            Constructor<?> c = proxyClass.getConstructor(CustomInvocationHandler.class);

            f.delete();

            //5.返回被代理后的代理对象
            return c.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?> interfaces) {
        StringBuffer src = new StringBuffer();
        src.append("package proxy.custom;" + ln);
        src.append("import java.lang.reflect.Method;" + ln);
        src.append("public class $Proxy0 implements " + interfaces.getName() + "{" + ln);
        src.append("private CustomInvocationHandler h;" + ln);

        src.append("public $Proxy0(CustomInvocationHandler h) {" + ln);
        src.append("this.h = h;" + ln);
        src.append("}" + ln);

        for (Method m: interfaces.getMethods()) {
            src.append("public " + m.getReturnType() + " " + m.getName() + "() {" + ln);
            src.append("try {" + ln);
            src.append("Method m = " + interfaces.getName() + ".class.getMethod(\"" + m.getName()+ "\", new Class[]{});" + ln);

            src.append("this.h.invoke(this, m, null);" + ln);

            src.append("}catch(Throwable e){e.printStackTrace();}" + ln);
            src.append("}" + ln);
        }

        src.append("}");

        return src.toString();
    }

}
