package chain;


import org.apache.commons.lang3.StringUtils;

/**
 * 项目名称：design.mode
 * 类 名 称：ValidateHandler
 * 类 描 述：TODO
 * 创建时间：2020/10/12 9:38 下午
 * 创 建 人：chenyouhong
 */
public class ValidateHandler extends Handler {

    public void doHandler(Member member) {
        if(StringUtils.isEmpty(member.getLoginName()) ||
                StringUtils.isEmpty(member.getLoginPass())){
            System.out.println("用户名和密码为空");
            return;
        }
        System.out.println("用户名和密码不为空，可以往下执行");
        if(null != next) {
            next.doHandler(member);
        }
    }


}
