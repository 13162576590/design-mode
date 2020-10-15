package state.order;

/**
 * 项目名称：design.mode
 * 类 名 称：OrderStatus
 * 类 描 述：TODO
 * 创建时间：2020/10/14 2:46 下午
 * 创 建 人：chenyouhong
 */
public enum OrderStatus {

    // 待支付，待发货，待收货，订单结束
    WAIT_PAYMENT, WAIT_DELIVER, WAIT_RECEIVE, FINISH;

}
