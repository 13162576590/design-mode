package bridge;

/**
 * 项目名称：design.mode
 * 类 名 称：IMessage
 * 类 描 述：TODO
 * 创建时间：2020/10/12 7:46 上午
 * 创 建 人：chenyouhong
 */
public class UrgentMessage extends AbsrtactMessage {

    public UrgentMessage(IMessage message) {
        super(message);
    }

    //发送消息的内容和接收人
    void send(String msg,String toUser) {
        msg = "【加急】" + msg;
        super.send(msg, toUser);
    }

}
