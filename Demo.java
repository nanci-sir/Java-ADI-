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
