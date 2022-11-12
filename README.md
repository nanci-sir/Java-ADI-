# Java-ADI-
Java 常用API


# 常用API

## 1. API概述

什么是API?

API(Application Programming interface)  应用程序编程接口。
简单来说：就是Java帮我们已经写好的一些方法，我们直接拿过来用就可以了。

## 2. Object类：toString方法

public String toString() 默认是返回当前对象在堆内存中的地址信息:类的全限名@内存地址

toString存在的意义
父类toString()方法存在的意义就是为了被子类重写，以便返回对象的内容信息，而不是地址信息！！  

```java
package API;

import java.util.Objects;

public class Student {//extends Object
    private  String name;
    private  char sex;
    private  int age;

    public Student() {
    }

    public Student(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;

    }
//toS 回车回车
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
    //自己重写equeals 内容一样返回ture


    @Override
    public boolean equals(Object o) {
        //判断是否是一个对象
        if (this == o) return true;
        //如果o 是null 返回false   Student !=  ..Pig
        if (o == null || getClass() != o.getClass()) return false;
        //说明o一定是学生类型不是null
        Student student = (Student) o;
        return sex == student.sex &&
                age == student.age &&
                Objects.equals( name, student.name );
    }

    @Override
    public int hashCode() {
        return Objects.hash( name, sex, age );

    }
}

```

```java
package API;

public class Test {
    public static void main(String[] args) {
        Student s = new Student( "张三",'男',19 );
     String rs =  s.toString();
        System.out.println(rs);
        System.out.println(s.toString());
        System.out.println(s);
        //返回当前对象的地址
        //直接输出对象变量，默认toString可以不写
        //API.Student@2d98a335
        //API.Student@2d98a335
        //API.Student@2d98a335
    }
}
```

Object的toString方法的基本作用是什么，存在的意义是什么？
基本作用：给子类继承，子类对象调用可以返回自己的地址。
意义：让子类重写，以便返回子类对象的内容。

## 3. Object类：equals方法

public boolean equals(Object o)  默认是比较当前对象与另一个对象的地址是否相同，相同返回true，不同返回false

```java
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
}
```

3.1 Object的equals方法的基本作用，存在的意义是什么？
基本作用：默认是与另一个对象比较地址是否一样
存在的意义：让子类重写，以便比较对象的内容是否相同。

## 4. Objects

Objects是一个工具类，提供了一些方法去完成一些功能。

使用Objects的equals方法在进行对象的比较会更安全。

public static boolean equals(Object a, Object b) 比较两个对象的，底层会先进行非空判断，从而可以避免空指针异常。再进行equals比较

```java
package Objects;

import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        String s1 = null;
        String s2= new String( "ma" );
       // System.out.println( s1.equals( s2 ) );//留下了隐患 空指针异常
        System.out.println( Objects.equals( s1,s2 ) );//更安全准确
        //false

        System.out.println( Objects.isNull( s1 ) );//true
        System.out.println( s1 == null );//true

        System.out.println( Objects.isNull( s2 ) );//false
        System.out.println( s2 == null );//false


    }}

```

4.1 对象进行内容比较的时候建议使用什么？为什么？
建议使用Objects提供的equals方法。
比较的结果是一样的，但是更安全。



## 5. StringBuilder

性能好

StringBuilder是一个可变的字符串的操作类，我们可以把它看成是一个对象容器

使用StringBuilder的核心作用：操作字符串的性能比String要更高（如拼接、修改等）。

StringBuilder 构造器

| 名称                              | 说明                                           |
| --------------------------------- | ---------------------------------------------- |
| public  StringBuilder()           | 创建一个空白的可变的字符串对象，不包含任何内容 |
| public  StringBuilder(String str) | 创建一个指定字符串内容的可变字符串对象         |

StringBuilder常用方法

| 方法名称                              | 说明                                                |
| ------------------------------------- | --------------------------------------------------- |
| public StringBuilder append(任意类型) | 添加数据并返回StringBuilder对象本身                 |
| public StringBuilder reverse()        | 将对象的内容反转                                    |
| public int length()                   | 返回对象内容长度                                    |
| public String toString()              | 通过toString()就可以实现把StringBuilder转换为String |

```java
package StringBuilder;

public class Demo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(  );
        sb.append( "a");
        sb.append( "a");
        sb.append("$%" );
        sb.append( "32489");
        sb.append( "健康");
        sb.append( "21212");
        System.out.println( sb );

        StringBuilder sb1= new StringBuilder(  );
        //链式
        sb1.append( "a" ).append( "b" ).append( "c" );
        System.out.println( sb1 );//abc
        //反转
        sb1.reverse().append( "110" );
        System.out.println( sb1 );//cba110

        System.out.println( sb1.length() );

        //最终结果还是String
        StringBuilder sb2= new StringBuilder(  );
        sb2.append( "123" ).append("abc" );
        //恢复成String
        String rs = sb2.toString();
        check(rs);//6
    }
    public static  void check(String data){

    }

}
```

5.1 为什么拼接、反转字符串建议使用StringBuilder?
StringBuilder：内容是可变的、拼接字符串性能好、代码优雅。只创建一个对象(堆中)
String ：内容是不可变的、拼接字符串性能差。需要一直创造对象

定义字符串使用String
拼接、修改等操作字符串使用StringBuilder

## 6. 打印整型数组内容

```java
package StringBuilder;

public class Test2 {
    public static void main(String[] args) {
        int[] arr1 = null;
        System.out.println(toString( arr1 ));

        int[] arr2 = {10,53,45};
        System.out.println(toString( arr2));
    }
        public static String toString(int[] arr){
            if(arr != null){
                //拼接
                StringBuilder sb = new StringBuilder( "[" );
                //遍历
                for (int i = 0; i < arr.length; i++) {
                    sb.append( arr[i] ).append( i == arr.length-1 ? "": ",");
                }
                sb.append( "]" );
                return  sb.toString();
            }else{
                return null;
            }
        }
    }
```
