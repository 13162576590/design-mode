package bridge;

/**
 * 项目名称：design.mode
 * 类 名 称：SmsMessage
 * 类 描 述：TODO
 * 创建时间：2020/10/12 7:56 上午
 * 创 建 人：chenyouhong
 */
public class SmsMessage implements IMessage {

    public void send(String message, String toUser) {
        System.out.println("使用短信消息发送" + message + "给" + toUser);
    }

}
