package java.lang;

/**
 * @author Joker大雄
 * @data 2022/8/11 - 11:15
 **/
public class String {
    /*  双亲委派机制：安全
        App-->EXC-->BOOT(最终执行跟加载器里的)
        如果BOOT没有，就在EXC中找
        如果EXC没有，就在App中找
     */

    public String toString(){
        return "Jokerdig";
    }

    public static void main(String[] args) {
        String str = new String();
        //会报错 因为它最终执行的是BOOT里的，并非我们上方定义的
        str.toString();
    }
}
