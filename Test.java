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
