package com.team.house.test;

public class Test {
   static   Dog dog=new Dog();
   static Dog dog1=new Dog("小明");
   static Dog dog2=new Dog("小红");
   /*
值传递和引用传递的区别  值传递不改变实参的值
就相当于 实参 把值扔给形参就行了 自己不受影响



    */


    public static void main(String[] args) {
        int i=2<<3;
        System.out.println(i);
        String str1="aa";
        Test test = new Test();
        test.change(str1);
        System.out.println(str1);
        /*test.change(dog);
        System.out.println(dog.getName());
        System.out.println(dog1);
        System.out.println(dog2);*/

        /*Dog temp=dog1;
        System.out.println(temp);
        dog1=dog2;
        dog2=temp;
        System.out.println(dog1);
        System.out.println(dog2);
        System.out.println(temp);
        System.out.println(temp.getName());
        System.out.println(dog1.getName());
        System.out.println(dog2.getName());
*/
        System.out.println(dog1);
        System.out.println(dog2);
        test.test(dog1,dog2);
        System.out.println(dog1.getName());
        System.out.println(dog1);
        System.out.println(dog2.getName());
        System.out.println(dog2);

    }
    public  void change(String str){
        str="bb";
    }
    public void change(Dog dog){
        dog.setName("炸炸");
        dog.setAge(23);
    }
    public void test(Dog d1,Dog d2){
            Dog temp=d1;
            d1=d2;
            d2=temp;
    }
}
