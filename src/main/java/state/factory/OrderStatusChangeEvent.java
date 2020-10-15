package state.factory;

/**
 * 项目名称：design.mode
 * 类 名 称：OrderStatusChangeEvent
 * 类 描 述：TODO
 * 创建时间：2020/10/14 2:48 下午
 * 创 建 人：chenyouhong
 */
public enum OrderStatusChangeEvent {

    // 待支付，待发货，待收货，订单结束
//    WAIT_PAYMENT, WAIT_DELIVER, WAIT_RECEIVE, FINISH;

    // 支付，发货，确认收货
    PAYED, DELIVERY, RECEIVED;

}
