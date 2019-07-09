package com.team.house.test;

public class Test {
    public static void main(String[] args) {
        int i=2<<3;
        System.out.println(i);
        String str1="aa";
        Test test = new Test();
        test.change(str1);
        System.out.println(str1);

    }
    public  void change(String str){
        str="bb";
    }
}
