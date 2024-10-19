package com.lk.interview.algorithm.bitwiseOperation;

/**
 * 位运算探究：
 * &（与）运算，都为1则结果为1，否则结果为0;
 * |（或）运算，只要由一个为1结果就位1；
 * ^（异或）运算，两个值相同就为0，不同为1；
 * ~（取反）运算，将每一位上的1变成0、0变成1；
 *
 * << 左移，缺的位补0，左移n位相当于乘以2的n次方
 * >> 带符号右移，
 * >>> 不带符号右移，
 *
 * 整数的最高位是符号位，1表示为负，具体负几为后面位取反+1
 * 取反+1等于加负号
 */
public class A {

    /**
     * 将n的32位是啥完整打印出来，依次是第31位、第30位...第0位
     * @param n
     */
    public static void print(int n){
        //1.将1左移31位，则由00000000000000000000000000000001变为10000000000000000000000000000000
        //2.然后将左移后的结果与原数进行&运算，由于1左移完后面31位数都为0，则&运算结果中，后31位必然为0.且第31位原数若为0，那么&运算结果中第31位必然也为0
        //3.若32位均为0，则原数十进制表示就为0.否则原数第31位为1
        for (int i = 31; i >=0 ; i--) {
            System.out.print(((n<<i)&n)==0?"0":"1");
        }
        System.out.println();
    }

    /**
     * 负数的表示，最高位为符号位，负几是后面位取反+1
     */
    public static void negativeExpress(){
        print(-1);
        //负一打印出来是11111111111111111111111111111111
        //从左往右，第一位是最高位，1表示为负，后面数取反，则全为0，然后加1，那就是0000000000000000000000000000001。所以最终为负一
    }

    public static void main(String[] args) {
        print(1);

        //1左移6位，相当于1*2的6次方
        System.out.println(1<<6);

        //int一共32位，但最高位是符号位，故只有31位来表示数值，所以最大是21亿而不是42亿
        System.out.println(Integer.MAX_VALUE);
        print(Integer.MAX_VALUE);

        negativeExpress();
    }
}
