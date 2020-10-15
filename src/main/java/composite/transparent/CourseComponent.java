package composite.transparent;

/**
 * 项目名称：design.mode
 * 类 名 称：CourseComponent
 * 类 描 述：TODO
 * 创建时间：2020/10/11 7:23 下午
 * 创 建 人：chenyouhong
 */
public abstract class CourseComponent {

    public void addChild(CourseComponent catalogComponent){
        throw new UnsupportedOperationException("不支持添加操作");
    }

    public void removeChild(CourseComponent catalogComponent){
        throw new UnsupportedOperationException("不支持删除操作");
    }


    public String getName(CourseComponent catalogComponent){
        throw new UnsupportedOperationException("不支持获取名称操作");
    }


    public double getPrice(CourseComponent catalogComponent){
        throw new UnsupportedOperationException("不支持获取价格操作");
    }


    public void print(){
        throw new UnsupportedOperationException("不支持打印操作");
    }

}
