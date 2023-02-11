package com.jokerdig.huffmanCode;

import java.util.*;

/**
 * @author Joker大雄
 * @data 2022/11/8 - 15:12
 **/
public class HuffmanCode {
    public static void main(String[] args) {
        String str = "java javascript spring mybatis";
        byte[] contentBytes = str.getBytes();
        // System.out.println("初始长度："+contentBytes.length);
        // 分步过程
        /*
        List<Node> nodes = getNodes(contentBytes);
        // 测试赫夫曼树
        System.out.println("======创建的赫夫曼树======");
        Node huffmanTree = createHuffmanTree(nodes);
        // 前序遍历赫夫曼树
        huffmanTree.preOrder();
        // 测试生成对应的赫夫曼编码
        getCodes(huffmanTree);
        System.out.println("======生成的赫夫曼编码表======");
        System.out.println(huffmanCodes);

        // 测试
        byte[] huffmanCodeByte = zipData(contentBytes,huffmanCodes);
        System.out.println("======通过赫夫曼编码表压缩数据=======");
        System.out.println(Arrays.toString(huffmanCodeByte));
         */
        byte[] huffmanCodeByte = huffmanZip(contentBytes);
        System.out.println("======通过赫夫曼编码表压缩数据=======");
        System.out.println(Arrays.toString(huffmanCodeByte));
        // 测试解码
        System.out.println("======解压后的数据======");
        byte[] source = decode(huffmanCodes, huffmanCodeByte);
        System.out.println(new String(source));
    }
    // 完成数据解压
    // 1. 先将huffmanCodeBytes数组重新转为赫夫曼编码对应二进制字符串
    /**
     *
     * @param flag 标识是否需要补高位，如果是最后一个字节，不需要补高位
     * @param bt 传入的字节
     * @return 返回对应二进制字符串
     */
    private static String byteToBitString(boolean flag,byte bt){
        // 使用变量保存bt
        int temp = bt; // 将bt转为int
        if(flag){
            // 如果传入的是正数，还存在补高位的问题
            temp |= 256; // temp=1 ->100000001
        }
        String str = Integer.toBinaryString(temp);
        if(flag){
            return str.substring(str.length()-8); // 这里返回的temp对应的二进制的补码
        }else{
            return str;
        }
    }
    // 2. 将赫夫曼编码对应的二进制字符串对照赫夫曼编码转为原本的字符串

    /**
     *
     * @param huffmanCodes 赫夫曼编码
     * @param huffmanBytes 赫夫曼编码处理过的数组
     * @return 解码后的字符串对应的数组
     */
    private static byte[] decode(Map<Byte,String> huffmanCodes,byte[] huffmanBytes){
        // 先得到huffmanBytes对应的二进制的字符串
        StringBuilder stringBuilder = new StringBuilder();
        // 将byte数组转称二进制的字符串
        for (int i = 0; i < huffmanBytes.length-1; i++) {
            stringBuilder.append(byteToBitString(true,huffmanBytes[i]));
        }
        // 字节数组的最后一个字节另做处理，如果是负数，flag为true；
        // 如果是正数，flag为false，拼接后长度与原先相等不做处理，若小于原先长度则先补0后拼接，使其与原先长度相等
        if(huffmanBytes[huffmanBytes.length-1]<0){
            stringBuilder.append(byteToBitString(true,huffmanBytes[huffmanBytes.length-1]));
        }else{
            String str = byteToBitString(false,huffmanBytes[huffmanBytes.length-1]);
            while(str.length()+stringBuilder.length()<huffmanStr.length()){
                // 补位
                stringBuilder.append(0);
            }
            stringBuilder.append(str);
        }

        // 把字符串按照指定的赫夫曼编码进行解码
        // 把赫夫曼编码表进行调换，来反向查询
        Map<String,Byte> map = new HashMap<String,Byte>();
        for (Map.Entry<Byte,String> entry:huffmanCodes.entrySet()){
            // 反向存放
            map.put(entry.getValue(),entry.getKey());
        }

        // 创建集合，存放byte
        List<Byte> byteList = new ArrayList<>();
        // i是索引，扫描stringBuilder
        for(int i = 0;i<stringBuilder.length();){
            int count = 1; // 计数器
            Byte b = null;
            boolean flag = true;
            while(flag){
                String key = stringBuilder.substring(i,i+count);
                b = map.get(key);
                if(b==null){ // 说明没有匹配到
                    count++;
                }else{
                    flag = false;
                }
            }
            byteList.add(b);
            i+=count; // 把i移动到count
        }
        // 把byteList中的输入放入到byte[]数组并返回
        byte[] bts = new byte[byteList.size()];
        for (int i = 0; i < bts.length; i++) {
            bts[i] = byteList.get(i);
        }
        return bts;
    }
    // 编写一个方法，封装下面的所有方便调用
    /**
     *
     * @param bytes 原始字符串对应的数组
     * @return  经过赫夫曼编码处理后的数组
     */
    private static byte[] huffmanZip(byte[] bytes){
        List<Node> nodes = getNodes(bytes);
        // 根据nodes创建赫夫曼树
        Node huffmanTree = createHuffmanTree(nodes);
        // 生成对应的赫夫曼编码
        Map<Byte,String> huffmanCodes = getCodes(huffmanTree);
        // 根据赫夫曼编码表压缩数据
        byte[] huffmanCodeByte = zipData(bytes,huffmanCodes);
        return huffmanCodeByte;
    }
    /***
     *
     * @param bytes 接收字节数组
     * @return 返回值
     */
    private static List<Node> getNodes(byte[] bytes){
        // 创建ArrayList
        List<Node> nodeList = new ArrayList<Node>();

        // 存储每个byte出现的次数 -> map
        Map<Byte,Integer> counts = new HashMap<>();
        for(byte b:bytes){
            Integer count = counts.get(b);
            if(count==null){
                // Map还没有字符数据
                counts.put(b,1);
            }else{
                counts.put(b,count+1);
            }
        }

        // 把每个键值对转换为一个Node对象，并加入到Nodes集合
        // 遍历Map并把键值对放到Node中
        for(Map.Entry<Byte,Integer> entry:counts.entrySet()){
            nodeList.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodeList;
    }

    // 通过NodeList创建对应的赫夫曼树
    private static Node createHuffmanTree(List<Node> node){
        while(node.size()>1){
            // 排序 从小到大
            Collections.sort(node);
            // 取出前两棵最小二叉树
            Node leftNode = node.get(0);
            Node rightNode = node.get(1);
            // 创建一棵新的二叉树，根节点没有data，只有权值
            Node parent = new Node(null,leftNode.weight+rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            // 将已经处理的两棵二叉树移除
            node.remove(leftNode);
            node.remove(rightNode);
            // 把生成的新二叉树加入到NodeList中去
            node.add(parent);
        }
        // node最后的节点就是赫夫曼树根节点
        return node.get(0);
    }

    // 编写一个方法，将字符串对应的byte[]数组，通过生成的赫夫曼编码表进行处理，返回处理过后的字节数组
    static StringBuilder huffmanStr = new StringBuilder();//存储赫夫曼编码对应的字符串，在解码的时候使用
    /**
     *
     * @param bytes 原始字符串对应的byte数组
     * @param huffmanCodes 生成的赫夫曼编码
     * @return 返回处理后的byte数组，8位为一组
     * huffmanCodeBytes[0] = 10011111(补码) =>10011111-1 => 10011110(反码)=>11100001(原码)
     */
    private static byte[] zipData(byte[] bytes,Map<Byte,String> huffmanCodes){

        // 1. 利用huffmanCodes将bytes转成赫夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        // 遍历bytes数组
        for (byte b:bytes){
            stringBuilder.append(huffmanCodes.get(b));
        }
        huffmanStr = stringBuilder; // 记录赫夫曼编码对应字符串
        // 字符串转成byte数组
        // 统计返回的byte[] huffmanCodeBytes长度
        // 一句代码写法： int len = (stringBuilder.length()+7)/8;
        int len;
        if(stringBuilder.length()%8==0){// 是整数
            len = stringBuilder.length()/8;
        }else{
            len = stringBuilder.length()/8+1;
        }
        // 创建存储压缩后的byte数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;// 记录byte次数
        for (int i = 0; i < stringBuilder.length(); i+=8) {// 步长为8
            String strByte;
            if(i+8>stringBuilder.length()){
                // 长度不够8位
                strByte = stringBuilder.substring(i);
            }else{
                // 每次取8位
                strByte = stringBuilder.substring(i,i+8);
            }
            // 将strByte，转成byte数组，放入huffmanCodeBytes
            huffmanCodeBytes[index] = (byte)Integer.parseInt(strByte,2); // radix 进制
            index++;
        }
        return huffmanCodeBytes;
    }
    // 生成赫夫曼树对应的赫夫曼编码
    // 1. 将赫夫曼编码表存放在Map<Byte,String>
    static Map<Byte,String> huffmanCodes = new HashMap<Byte,String>();
    // 2. 在生成赫夫曼编码表时，需要去拼接路径，定义StringBuilder存储叶子节点的路径
    static StringBuilder stringBuilder = new StringBuilder();
    // 重载getCodes
    private static Map<Byte,String> getCodes(Node root){
        if(root==null){
            return null;
        }
        // 处理root左子树
        getCodes(root.left,"0",stringBuilder);
        // 处理root右子树
        getCodes(root.right,"1",stringBuilder);
        return huffmanCodes;
    }
    /**
     *
     * @param node 节点
     * @param code  路径
     * @param stringBuilder 拼接叶子节点路径
     */
    private static void getCodes(Node node,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        // 将传入的code加入stringBuilder1
        stringBuilder1.append(code);
        if(node!=null){// 如果node为空，不处理
            // 判断当前node是否为叶子节点
            if(node.data == null){
                // 非叶子节点,递归处理
                // 向左递归,我们规定向左为"0"
                getCodes(node.left,"0",stringBuilder1);
                // 向右递归,,我们规定向右为"1"
                getCodes(node.right,"1",stringBuilder1);
            }else{
                // 是叶子节点
                huffmanCodes.put(node.data,stringBuilder1.toString());
            }
        }
    }

    // 前序遍历
    private static void preOrder(Node root){
        if(root!=null){
            root.preOrder();
        }else{
            System.out.println("赫夫曼树为空");
        }
    }
}
// 创建Node，带数据和权值
class Node implements Comparable<Node>{
    Byte data; // 存放数据本身,比如' ' =>32 ,通过ascii编码来存放
    int weight; // 权值，表示字符出现的次数
    Node left;
    Node right;
    // 构造器
    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight-o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
    // 前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }
}