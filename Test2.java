package API;

import java.util.Objects;

public class Test2 {
    public static void main(String[] args) {
        Student s1 = new Student( "张三",'男',19 );
        Student s2= new Student( "张三",'男',19 );
        //Object
        //equals 比较两个对象地址
        System.out.println( s1.equals( s2 ) );//通过重写eauals可以比较内容是否一样
        System.out.println( s1 == s2 );//地址
        System.out.println( Objects.equals( s1, s2 ) );
        //true
        //false
        //true

    }
}
