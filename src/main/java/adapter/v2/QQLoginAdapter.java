package adapter.v2;

import adapter.AbstraceAdapter;
import adapter.ResultMsg;

/**
 * 项目名称：design.mode
 * 类 名 称：Directory
 * 类 描 述：TODO
 * 创建时间：2020/10/11 21:37 下午
 * 创 建 人：chenyouhong
 */
public class QQLoginAdapter extends AbstraceThirdAdapter {
    public boolean support(Object adapter) {
        return adapter instanceof QQLoginAdapter;
    }

    public ResultMsg login(String id, Object adapter) {
        if(!support(adapter)){return null;}
        //accesseToken
        //time
        return super.login(id);

    }

}
