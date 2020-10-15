package adapter;

/**
 * 项目名称：design.mode
 * 类 名 称：PassportForThirdAdapter
 * 类 描 述：TODO
 * 创建时间：2020/10/11 9:20 下午
 * 创 建 人：chenyouhong
 */
public class PassportForThirdAdapter implements IPassportForThird  {

    public ResultMsg loginForQQ(String openId) {
        return processLogin(openId, LoginForQQAdapter.class);
    }

    public ResultMsg loginForWechat(String openId) {

        return processLogin(openId, LoginForWechatAdapter.class);

    }

    public ResultMsg loginForToken(String token) {

        return processLogin(token, LoginForTokenAdapter.class);
    }

    public ResultMsg loginForTelphone(String phone, String code) {
        return processLogin(phone, LoginForTelAdapter.class);
    }


    private ResultMsg processLogin(String id,Class<? extends ILoginAdapter> clazz){
        try {
            ILoginAdapter adapter = clazz.getDeclaredConstructor().newInstance();
            if (adapter.support(adapter)){
                return adapter.login(id,adapter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
