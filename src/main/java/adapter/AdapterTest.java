package adapter;

/**
 * 项目名称：design.mode
 * 类 名 称：AdapterTest
 * 类 描 述：TODO
 * 创建时间：2020/10/11 9:23 下午
 * 创 建 人：chenyouhong
 */
public class AdapterTest {

    public static void main(String[] args) {
        IPassportForThird adapter = new PassportForThirdAdapter();
        adapter.loginForQQ("123");
    }

}
