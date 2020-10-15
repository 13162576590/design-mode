package decorator;

/**
 * 项目名称：design.mode
 * 类 名 称：BasePancake
 * 类 描 述：TODO
 * 创建时间：2020/10/11 4:39 下午
 * 创 建 人：chenyouhong
 */
public class BasePancake implements IPancake {

    @Override
    public String getName() {
        return "煎饼";
    }

    @Override
    public Double getPrince() {
        return 5d;
    }

}
