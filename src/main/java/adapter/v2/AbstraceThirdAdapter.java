package adapter.v2;

import adapter.ILoginAdapter;
import adapter.PassportService;
import adapter.ResultMsg;

/**
 * 项目名称：design.mode
 * 类 名 称：Directory
 * 类 描 述：TODO
 * 创建时间：2020/10/11 21:37 下午
 * 创 建 人：chenyouhong
 */
public abstract class AbstraceThirdAdapter extends PassportService implements ILoginAdapter, IThirdLogin {

//    protected ResultMsg loginForRegist(String username, String password){
//        if(null == password){
//            password = "THIRD_EMPTY";
//        }
//        super.regist(username,password);
//        return super.login(username,password);
//    }

    public ResultMsg login(String openId) {

        return null;
    }


}
