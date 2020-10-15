package chain;

/**
 * 项目名称：design.mode
 * 类 名 称：AuthHandler
 * 类 描 述：TODO
 * 创建时间：2020/10/12 9:43 下午
 * 创 建 人：chenyouhong
 */
public class AuthHandler extends Handler {
    public void doHandler(Member member) {
        if(!"管理员".equals(member.getRoleName())){
            System.out.println("您不是管理员，没有操作权限");
            return;
        }
        System.out.println("允许操作");
    }
}
