package decorator;

/**
 * 项目名称：design.mode
 * 类 名 称：EggDecorator
 * 类 描 述：TODO
 * 创建时间：2020/10/11 6:43 下午
 * 创 建 人：chenyouhong
 */
public class EggDecorator extends PancakeDecorator {

    public EggDecorator(IPancake pancake) {
        super(pancake);
    }

    @Override
    public String getName() {
        return super.getName() + "加1个鸡蛋";
    }

    @Override
    public Double getPrince() {
        return super.getPrince() + 1;
    }

}
