package composite.safe;

/**
 * 项目名称：design.mode
 * 类 名 称：Directory
 * 类 描 述：TODO
 * 创建时间：2020/10/11 7:37 下午
 * 创 建 人：chenyouhong
 */
public abstract class Directory {

    protected String name;

    public Directory(String name) {
        this.name = name;
    }

    public abstract void show();

}
