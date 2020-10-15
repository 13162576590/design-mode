package chain;

/**
 * 项目名称：design.mode
 * 类 名 称：MemberService
 * 类 描 述：TODO
 * 创建时间：2020/10/12 9:44 下午
 * 创 建 人：chenyouhong
 */
public class MemberService {

    public void login(String loginName,String loginPass){

        Handler.Builder builder = new Handler.Builder();

        builder.addHandler(new ValidateHandler())
                .addHandler(new LoginHandler())
                .addHandler(new AuthHandler());

        builder.build().doHandler(new Member(loginName,loginPass));
    }

}
