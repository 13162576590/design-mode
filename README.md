Java代理模式其实就是字节码重组，以满足相应的需求。

一、代理应用场景，主要是3个条件:

1.需要2个角色，被代理对象及执行者

2.被代理对象一定需要做某件事，但是本身没时间做或者不够专业

3.执行者需要持有被代理对象的相关资料


二、jdk动态代理

1.jdk代理

    // 实现InvocationHandler接口
    public class Exector implements InvocationHandler {
	//执行者持有被代理对象的引用
    private SurrogateObjectI surrogateObject;

    public Object getInstance(SurrogateObjectI surrogateObject) {
        this.surrogateObject = surrogateObject;
        Class clazz = surrogateObject.getClass();
        //通过Proxy类的静态方法创建代理对象
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }
	//回调方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是执行这,我来做这件事");
        method.invoke(surrogateObject, args);
        System.out.println("我是执行这,这件事做完了");
        return null;
    }
    }

	//测试方法
    public static void main(String[] args) {
        SurrogateObjectI surrogateObject = (SurrogateObjectI)new Exector().getInstance(new SurrogateObject());
        surrogateObject.doSth();
    }


2.自定义jdk动态代理

自定义jdk动态代理，需要CustomInvocationHandler接口、以及CustomClassLoader、CustomExector、CustomProxy等类。

	//目标对象的方法会转发由InvocationHandle这个接口的invoke方法来调用
	public interface CustomInvocationHandler {
	
		Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
		
	}

	/自定义/Proxy类的作用及时动态创建一个代理对象的类
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

	//自定义类加载器
	public class CustomClassLoader extends ClassLoader {
	
	    private File baseDir;
	
	    public CustomClassLoader() {
	        String basePath = CustomClassLoader.class.getResource("").getPath();
	        this.baseDir = new java.io.File(basePath);
	    }
	
	    protected Class<?> findClass(String name) throws ClassNotFoundException {
	        String className = CustomClassLoader.class.getPackage().getName() + "." + name;
	        if (baseDir != null) {
	            File classFile = new File(baseDir,name.replaceAll("\\.", "/") + ".class");
	            if (classFile.exists()) {
	                FileInputStream in = null;
	                ByteArrayOutputStream out = null;
	                try {
	                    in = new FileInputStream(classFile);
	                    out = new ByteArrayOutputStream();
	                    byte[] buff = new byte[1024];
	                    int len;
	                    while ((len = in.read(buff)) != -1) {
	                        out.write(buff, 0, len);
	                    }
	                    return defineClass(className, out.toByteArray(), 0, out.size());
	                } catch (Exception e) {
	                    e.printStackTrace();
	                } finally {
	                    if (in != null) {
	                        try {
	                            in.close();
	                        } catch (IOException e) {
	                            e.printStackTrace();
	                        }
	                    }
	
	                    if (out != null) {
	                        try {
	                            out.close();
	                        } catch (IOException e) {
	                            e.printStackTrace();
	                        }
	                    }
	                    classFile.delete();
	                }
	            }
	        }
	
	        return null;
	    }
	
	}

	//执行者
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


3.cglib代理

	cglib代理实现MethodInterceptor接口即可，cglib代理是生成一个新的子类，并实现父类方法，由于拿到父类的class字节码，所以在创建子类时，也创建父类。
	
	public class CglibProxy implements MethodInterceptor {
	
	    public Object getInstance(Class clazz) throws Exception {
	        Enhancer enhancer = new Enhancer();
	
			//设置父类
	        enhancer.setSuperclass(clazz);
	        //设置回调
	        enhancer.setCallback(this);
	
	        return enhancer.create();
	    }
	
	    @Override
	    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
	        System.out.println("cglib proxy before");
			// proxy.invoker(obj, args); 会造成死循环，因为自己调用自己
	        proxy.invokeSuper(obj, args);
	
	        System.out.println("cglib proxy after");
	
	        return null;
	    }
	
	}

4.demo地址

https://github.com/13162576590/design-mode
	