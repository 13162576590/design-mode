package composite.safe;

/**
 * 项目名称：design.mode
 * 类 名 称：File
 * 类 描 述：TODO
 * 创建时间：2020/10/11 7:44 下午
 * 创 建 人：chenyouhong
 */
public class File extends Directory {

    public File(String name) {
        super(name);
    }

    @Override
    public void show() {
        System.out.println(this.name);
    }

}
