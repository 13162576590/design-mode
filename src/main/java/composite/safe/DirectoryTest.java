package composite.safe;

/**
 * 项目名称：design.mode
 * 类 名 称：DirectoryTest
 * 类 描 述：TODO
 * 创建时间：2020/10/11 7:51 下午
 * 创 建 人：chenyouhong
 */
public class DirectoryTest {

    public static void main(String[] args) {

        System.out.println("============安全组合模式===========");

        File qq = new File("QQ.exe");
        File wx = new File("微信.exe");

        Folder office = new Folder("办公软件",2);

        File word = new File("Word.exe");
        File ppt = new File("PowerPoint.exe");
        File excel = new File("Excel.exe");

        office.add(word);
        office.add(ppt);
        office.add(excel);

        Folder wps = new Folder("金山软件",3);
        wps.add(new File("WPS.exe"));
        office.add(wps);

        Folder root = new Folder("根目录",1);
        root.add(qq);
        root.add(wx);
        root.add(office);

        System.out.println("----------show()方法效果-----------");
        root.show();

        System.out.println("----------list()方法效果-----------");
        root.list();

        //符合最少知道原则
        qq.show();
    }

}
