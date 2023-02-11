package demo02;

import java.util.ArrayList;

/**
 * @author Joker大雄
 * @data 2022/8/13 - 10:50
 **/
public class Demo03 {
    byte[]array = new byte[1*1024*1024]; //1m

    public static void main(String[] args) {
        ArrayList<Demo03> list = new ArrayList<>();
        int count = 0;

        try {
            while(true){
                list.add(new Demo03());
                count+=1;
            }
        } catch (Exception e) {
            System.out.println("count:"+count);
            e.printStackTrace();
        }
    }
}
