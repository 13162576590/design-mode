package adapter;


/**
 * 项目名称：design.mode
 * 类 名 称：Directory
 * 类 描 述：TODO
 * 创建时间：2020/10/11 21:37 下午
 * 创 建 人：chenyouhong
 */
public interface ILoginAdapter {
    boolean support(Object object);
    ResultMsg login(String id,Object adapter);
}
