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
