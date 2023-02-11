package com.jokerdig.stack;


/**
 * @author Joker大雄
 * @data 2022/10/3 - 11:17
 **/
public class Calculator {
    public static void main(String[] args) {
        // 完成中缀表达式7*2*2-5+1-5*3-3的运算
        // 24-15-3
        String expression = "7*2*2-5+1-5*3-3";
        // 创建数栈、符号栈和数中转栈，注意：如果你的表达式很长，可以适当修改这里的栈大小
        CalculatorStack numStack = new CalculatorStack(20);
        CalculatorStack operStack = new CalculatorStack(20);
        CalculatorStack transferStack = new CalculatorStack(20);
        // 定义需要的变量
        int index = 0; // 用于扫描
        // 定义两个运算的数字，运算符和结果
        int num1 = 0,num2 = 0,oper=0,res = 0;
        // 将每次扫描得到的char
        char ch = ' ';
        // 用于拼接多位数
        String keepNum = "";
        // 开始扫描
        while(true){
            // 依次得到expression的每一个字符
            ch = expression.substring(index,index+1).charAt(0);
            // 判断ch是什么，然后做响应的处理
            if(operStack.isOper(ch)){
                // 如果时运算符，首先判断当前符号栈是否为空
                if(!operStack.isEmpty()){
                    // 如果不为空有操作符，就进行比较，如果当前操作符的优先级小于或者等于栈中的操作符，
                    // 就需要从数栈中pop出两个数，然后从符号栈中pop出一个符号，进行运算，将运算得到的结果入数栈，然后再将当前的操作符入符号栈；
                    if(operStack.priority(ch)<= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1,num2,oper);
                        // 把运算那结果入数栈
                        numStack.push(res);
                        // 把当前运算符放入符号栈
                        operStack.push(ch);
                    }else{
                        // 当前的运算符优先级大于栈中的运算符，就直接放入栈
                        operStack.push(ch);
                    }
                }else{
                    // 如果为空，直接入栈
                    operStack.push(ch);
                }
            }else{
                // 如果是数，需要判断是是单位数还是多位数
                // 注意，字符和数字之间相差48，例如字符1实际是49
                // umStack.push(ch - 48);
                // 处理多位数
                keepNum += ch;
                // 判断下一个字符是不是数字，如果是就继续扫描,若是运算符就出栈
                // 如果ch已经是expression的最后一位，就直接入栈
                if(index == expression.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else{
                    if(operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        // 如果后一位是运算符，则入栈
                        numStack.push(Integer.parseInt(keepNum));
                        // 重要！清空keepNum
                        keepNum = "";
                    }
                }
            }
            // 让index+1，并判断是否扫描到最后
            index++;
            if(index>=expression.length()){
                break;
            }
        }
        /*
            当表达式扫描完毕，因为运算到最后一定是从前向后依次运算，所以先将数栈中的值依次放入数中转栈，
            然后将符号栈中的值依次放入数栈，最后按顺序的从数中转栈和数栈中pop出相应的数和符号，并运算，将最后的结果放入数中转栈中；
            数中转栈中只有一个数字，就是表达式的运算结果；
         */
        // 把数栈所有值都放入数中转栈
        while(!numStack.isEmpty()){
            transferStack.push(numStack.pop());
        }
        // 把符号栈所有值都放入数栈
        while(!operStack.isEmpty()){
            numStack.push(operStack.pop());
        }
        while(true){
            // 如果数栈为空，则计算到最后的结果
            if(numStack.isEmpty()){
                break;
            }
            // 注意，数中转栈和原本栈刚好相反，所以注意赋值的顺序
            num1 = transferStack.pop(); // 先弹出，在这里反而是大的值
            num2 = transferStack.pop(); // 后弹出，在这里是小的值
            oper = numStack.pop();
            res = transferStack.cal(num2,num1,oper);
            // 把运算那结果放入数中转栈
            transferStack.push(res);
        }
        System.out.printf("表达式%s运算结果: = %d",expression,transferStack.pop());
    }
}

// 先创建一个栈
class CalculatorStack {
    private int maxSize; // 栈的大小
    private int[] stack; // 使用数组模拟栈，数据存放在该数组
    private int top = -1; // 栈顶，没有数据为-1

    // 构造器
    public CalculatorStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize]; // 初始化
    }

    // 栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }

    // 入栈
    public void push(int value) {
        // 先判断栈是否满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    // 出栈
    public int pop() {
        // 先判断栈是否空
        if (isEmpty()) {
            // 抛出异常
            throw new RuntimeException("栈空");
        }
        int value = stack[top];
        top--;
        return value;
    }

    // 返回运算符的优先级，我们假定数字越大，优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1; // 假定目前的表达式只有加减乘除
        }
    }

    // 返回当前栈顶的值，且不出栈
    public int peek(){
        return stack[top];
    }

    // 判断是否为运算符
    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val =='/';
    }

    // 计算方法
    public int cal(int num1,int num2,int oper){
        int res = 0; //存放计算结果
        switch(oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1; //注意相减顺序
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1; //注意相除顺序
                break;
            default:
                break;
        }
        return res;
    }
}