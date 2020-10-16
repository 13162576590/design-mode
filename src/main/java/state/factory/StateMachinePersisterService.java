package state.factory;

import org.springframework.context.annotation.Primary;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.stereotype.Service;

/**
 * 项目名称：design.mode
 * 类 名 称：StateMachinePersisterService
 * 类 描 述：TODO
 * 创建时间：2020/10/16 1:41 下午
 * 创 建 人：chenyouhong
 */
@Service
public class StateMachinePersisterService implements  StateMachinePersist<OrderStatus, OrderStatusChangeEvent, Order> {


    @Override
    public void write(StateMachineContext<OrderStatus, OrderStatusChangeEvent> context, Order order) throws Exception {
        //此处并没有进行持久化操作
        order.setStatus(context.getState());
    }

    @Override
    public StateMachineContext<OrderStatus, OrderStatusChangeEvent> read(Order order) throws Exception {
        //此处直接获取order中的状态，其实并没有进行持久化读取操作
        StateMachineContext<OrderStatus, OrderStatusChangeEvent> result =new DefaultStateMachineContext<>(order.getStatus(), null, null, null, null, "orderStateMachineId");
        return result;
    }

}
