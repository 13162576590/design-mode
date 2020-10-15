package decorator;

/**
 * 项目名称：design.mode
 * 类 名 称：DecoratorTest
 * 类 描 述：TODO
 * 创建时间：2020/10/11 6:46 下午
 * 创 建 人：chenyouhong
 */
public class DecoratorTest {

    public static void main(String[] args) {

        IPancake pancake = new BasePancake();

//        pancake = new PancakeDecorator(pancake);
        pancake = new EggDecorator(pancake);

        pancake = new SauageDecorator(pancake);

        System.out.println(pancake.getName() + "\t" + pancake.getPrince());

    }

}


