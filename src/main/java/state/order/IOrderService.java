package state.order;

import java.util.Map;

/**
 * 项目名称：design.mode
 * 类 名 称：IOrderService
 * 类 描 述：TODO
 * 创建时间：2020/10/14 2:47 下午
 * 创 建 人：chenyouhong
 */
public interface IOrderService {

    //创建新订单
    Order create();
    //发起支付
    Order pay(int id);
    //订单发货
    Order deliver(int id);
    //订单收货
    Order receive(int id);
    //获取所有订单信息
    Map<Integer, Order> getOrders();

}
