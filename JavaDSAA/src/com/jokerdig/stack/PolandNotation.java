package com.jokerdig.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Joker大雄
 * @data 2022/10/4 - 14:05
 **/

public class PolandNotation {
    public static void main(String[] args) {
        // 先定义逆波兰表达式，为了方便我们使用空格隔开
        // String suffixExpression = "3 4 + 5 x 6 -";
        // 获取集合
        // List<String> rpnList = getListString(suffixExpression);
        // int res = calculate(rpnList);
        // System.out.printf("表达式%s的计算结果为：%d",suffixExpression,res);

        /*
            实现中缀表达是转后缀表达式，并计算结果
            1. 举例表达式：1+((2+3)×4)-5 -> 1 2 3 + 4 × + 5 -
            2. 因为直接对字符串操作不方便，我们将其放入ArrayList
            // 即：1+((2+3)×4)-5 -> [1,+,(,(,2,+,3,),×,4,),-,5]
            3. 将得到的中缀表达式List转为->后缀表达式对应的List

        */
        String suffixExpression = "1+((2+3)×4)-5";
        // 将中缀表达式放入ArrayList
        List<String> infixExpressionList = toInfixExpressionList(suffixExpression);
        System.out.println("中缀表达式对应的List："+infixExpressionList);
        // 将中缀表达式转为后缀表达式，并返回
        List<String> suffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        System.out.println("中缀表达式转后缀表达式对应的List："+suffixExpressionList);
        // 计算后缀表达式，并返回结果
        int result = calculate(suffixExpressionList);
        System.out.printf("%s=%d",suffixExpression,result);
    }
    // 将得到的中缀表达式List转为->后缀表达式对应的List
    public static List<String> parseSuffixExpressionList(List<String>  ls){
        // 定义s1栈和s2栈
        Stack<String> s1 = new Stack<>(); // 符号栈
        // 因为s2栈一直放入值，但是没有pop()值，可以使用ArrayList代替该栈
        List<String> s2 = new ArrayList<>();
        // 遍历ls
        for (String item : ls) {
            // 如果是一个数，就加入到s2
            if(item.matches("\\d+")){
                // 如果是数，放入s2
                s2.add(item);
            }else if(item.equals("(")){
                // 如果是左括号`(`，则直接入s1栈；
                s1.push(item);
            }else if(item.equals(")")){
                // 如果是右括号`)`，则依次弹出s1栈顶的运算符，并入s2栈，直到遇到左括号为止，此时丢弃这一对括号
                while(!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop(); // 将括号弹出s1,来消除括号
            }else{
                /*
                 当item的优先级小于等于栈顶运算符的优先级，
                 将s1栈顶的运算符弹出并压入到s2中，再将当前运算符与s1中新的栈顶运算符进行比较
                 */
                while(s1.size()!=0 && Operation.getValue(s1.peek())>=Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                // 将item压入栈
                s1.push(item);
            }
        }
        // 将s1中所有运算符依次加入s2
        while(s1.size() != 0){
            s2.add(s1.pop());
        }
        // 返回s2，就是对应的后缀表达式
        return s2;
    }

    // 将中缀表达式转为对应的List
    public static List<String> toInfixExpressionList(String str){
        // 定义一个List，存放中缀表达式对应内容
        List<String> ls = new ArrayList<String>();
        int i = 0; // 指针，用于遍历中缀表达式字符串
        String s; // 做多位数拼接
        char c; // 没遍历一个字符，就放入到c
        do{
            // 如果c是非数字，就需要加入到ls
            if((c=str.charAt(i)) < 48 || (c=str.charAt(i)) > 57 ){
                ls.add(""+c);
                i++; // i后移
            } else {
                // 如果是数字，需要考虑多位数问题
                s = ""; //将string为空 0[48]->9[57]
                while(i < str.length() && (c=str.charAt(i))>=48 && (c=str.charAt(i))<=57){
                    s +=c; //拼接
                    i++;
                }
                ls.add(s);
            }
        }while(i<str.length());
        // 返回list
        return ls;
    }
    // 将逆波兰表达式依次放入ArrayList
    public static List<String> getListString(String suffixExpression){
        // 将suffixExpression分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String str : split) {
            list.add(str);
        }
        return list;
    }
    // 完成对逆波兰表达式的运算
    public static int calculate(List<String> ls){
        // 创建一个栈
        Stack<String> stack = new Stack<>();
        // 遍历ls
        for (String item : ls) {
            // 使用正则表达式取出数,\\d+ 匹配多为数
            if(item.matches("\\d+")){
                // 入栈
                stack.push(item);
            }else{
                // 从栈中pop出两个数进行运算，结果入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0; //存放结果
                // 进行运算
                if(item.equals("+")) {
                    res = num1 + num2;
                }else if(item.equals("-")){
                    res = num1 - num2;
                }else if(item.equals("×")){
                    res = num1 * num2;
                }else if(item.equals("/")){
                    res = num1 / num2;
                }
                // 把结果入栈
                stack.push(""+res);
            }
        }
        // 最后再栈中就是运算结果
        return Integer.parseInt(stack.pop());
    }
}

// 编写一个类Operation，返回运算符的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    // 写一个方法，返回优先级对应的数字
    public static int getValue(String operation){
        int result = 0;
        switch (operation){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "×":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                break;

        }
        return result;
    }
}

