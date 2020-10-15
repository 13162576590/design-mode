package decorator;

/**
 * 项目名称：design.mode
 * 类 名 称：AbstractPancake
 * 类 描 述：TODO
 * 创建时间：2020/10/11 4:43 下午
 * 创 建 人：chenyouhong
 */
public class PancakeDecorator implements IPancake {

    private IPancake pancake;

    public PancakeDecorator(IPancake pancake) {
        this.pancake = pancake;
    }

    @Override
    public String getName() {
        return pancake.getName();
    }

    @Override
    public Double getPrince() {
        return pancake.getPrince();
    }

}
