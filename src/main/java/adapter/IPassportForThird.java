package adapter;

/**
 * 项目名称：design.mode
 * 类 名 称：IPassportForThird
 * 类 描 述：TODO
 * 创建时间：2020/10/11 9:21 下午
 * 创 建 人：chenyouhong
 */
public interface IPassportForThird {

    ResultMsg loginForQQ(String openId);

    ResultMsg loginForWechat(String openId);

    ResultMsg loginForToken(String token);

    ResultMsg loginForTelphone(String phone, String code);

}
