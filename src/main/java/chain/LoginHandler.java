package chain;


import org.apache.commons.lang3.StringUtils;

/**
 * 项目名称：design.mode
 * 类 名 称：ValidateHandler
 * 类 描 述：TODO
 * 创建时间：2020/10/12 9:38 下午
 * 创 建 人：chenyouhong
 */
public class LoginHandler extends Handler {

    public void doHandler(Member member) {
        System.out.println("登录成功！");
        member.setRoleName("管理员");
        if(null != next) {
            next.doHandler(member);
        }
    }


}
