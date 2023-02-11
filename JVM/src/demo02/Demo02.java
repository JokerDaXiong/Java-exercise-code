package demo02;

/**
 * @author Joker大雄
 * @data 2022/8/13 - 9:45
 **/
public class Demo02 {
    public static void main(String[] args) {
        // 返回虚拟机使用的最大内存
        long max = Runtime.getRuntime().maxMemory();
        // 返回JVM使用的初始化总内存
        long total= Runtime.getRuntime().totalMemory();
        System.out.println("max:"+max+"字节 "+max/1024/1024+"MB");
        System.out.println("total:"+total+"字节 "+total/1024/1024+"MB");
        // 默认：分配的总内存是电脑内存的1/4,而初始化的内存：1/65
    }
}
