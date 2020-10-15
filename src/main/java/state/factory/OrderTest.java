package state.factory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 项目名称：design.mode
 * 类 名 称：OrderTest
 * 类 描 述：TODO
 * 创建时间：2020/10/14 4:29 下午
 * 创 建 人：chenyouhong
 */
@SpringBootApplication
public class OrderTest {

//    @Bean
//    public StateMachine orderStateMachine() {}

    public static void main(String[] args) throws Exception {

        Thread.currentThread().setName("主线程");

        ConfigurableApplicationContext context = SpringApplication.run(OrderTest.class,args);

        IOrderService orderService = context.getBean(IOrderService.class);
        orderService.create();
        orderService.create();
        orderService.pay(1);

        new Thread( "客户线程"){
            @Override
            public void run() {
                orderService.deliver(1);
                orderService.receive(1);
            }
        }.start();



        orderService.pay(2);
        orderService.deliver(2);
        orderService.receive(2);


//        for (int i=1; i<8; i++) {
//            orderService.create();
//        }
//
//        for (int i=1; i<8; i++) {
//            final int s = i;
//            new Thread(i + ""){
//                @Override
//                public void run() {
//                    orderService.deliver(s);
//                    orderService.receive(s);
//                }
//            }.start();
//        }



//        orderService.pay(2);
//        orderService.deliver(2);
//        orderService.receive(2);

//        Thread.sleep(20000);
        System.out.println("全部订单状态：" + orderService.getOrders());

    }

}
