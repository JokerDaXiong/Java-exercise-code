package demo01;

/**
 * @author Joker大雄
 * @data 2022/8/11 - 10:59
 **/
public class User {

    public static void main(String[] args) {
        // 类是模板，对象是具体的
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();

        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(user3.hashCode());

        Class<? extends User> aClass1 = user1.getClass();
        // AppClassLoader
        ClassLoader classLoader = aClass1.getClassLoader();

        System.out.println(classLoader);// AppClassLoader
        System.out.println(classLoader.getParent());// ExtClassLoader \jre\lib\ext
        System.out.println(classLoader.getParent().getParent());// null rt.jar







//        Class<? extends User> aClass2 = user2.getClass();
//        Class<? extends User> aClass3 = user3.getClass();
//
//        System.out.println(aClass1.hashCode());
//        System.out.println(aClass2.hashCode());
//        System.out.println(aClass3.hashCode());

    }
}
