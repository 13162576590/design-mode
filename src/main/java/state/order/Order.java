package state.order;

import lombok.Data;

/**
 * 项目名称：design.mode
 * 类 名 称：Order
 * 类 描 述：TODO
 * 创建时间：2020/10/14 2:45 下午
 * 创 建 人：chenyouhong
 */
@Data
public class Order {

    private int id;

    private OrderStatus status;

}
