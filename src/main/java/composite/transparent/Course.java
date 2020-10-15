package composite.transparent;

/**
 * 项目名称：design.mode
 * 类 名 称：Course
 * 类 描 述：TODO
 * 创建时间：2020/10/11 7:24 下午
 * 创 建 人：chenyouhong
 */
public class Course extends CourseComponent {

    private String name;
    private double price;

    public Course(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName(CourseComponent catalogComponent) {
        return this.name;
    }

    @Override
    public double getPrice(CourseComponent catalogComponent) {
        return this.price;
    }

    @Override
    public void print() {
        System.out.println(name + " (￥" + price + "元)");
    }

}