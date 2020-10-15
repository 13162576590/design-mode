package bridge;

/**
 * 项目名称：design.mode
 * 类 名 称：MessageTest
 * 类 描 述：TODO
 * 创建时间：2020/10/12 7:57 上午
 * 创 建 人：chenyouhong
 */
public class MessageTest {

    public static void main(String[] args) {
        IMessage message = new SmsMessage();
        AbsrtactMessage absrtactMessage = new NoramlMessage(message);
        absrtactMessage.send("赶紧批", "张三");

        message = new SmsMessage();
        absrtactMessage = new UrgentMessage(message);
        absrtactMessage.send("赶紧批", "张三");

    }

}
