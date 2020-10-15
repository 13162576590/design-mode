package chain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 项目名称：design.mode
 * 类 名 称：Member
 * 类 描 述：TODO
 * 创建时间：2020/10/12 9:16 下午
 * 创 建 人：chenyouhong
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private String loginName;
    private String loginPass;
    private String roleName;

    public Member(String loginName, String loginPass) {
        this.loginName = loginName;
        this.loginPass = loginPass;
    }
//
//    public String getLoginName() {
//        return loginName;
//    }
//
//    public void setLoginName(String loginName) {
//        this.loginName = loginName;
//    }
//
//    public String getLoginPass() {
//        return loginPass;
//    }
//
//    public void setLoginPass(String loginPass) {
//        this.loginPass = loginPass;
//    }
//
//    public String getRoleName() {
//        return roleName;
//    }
//
//    public void setRoleName(String roleName) {
//        this.roleName = roleName;
//    }
}
