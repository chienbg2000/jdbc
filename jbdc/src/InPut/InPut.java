package InPut;

import java.util.Scanner;

public class InPut {
    private static Scanner  scanner = new Scanner(System.in);

    public static int nextInt(){

        try {
            return  Integer.parseInt(scanner.nextLine());
        }
        catch (Exception e){
            System.err.println(e);
            System.out.println("Dữ liệu không hợp lệ!");
            return nextInt();
        }
    }

    public static String nextLine(){
        String str = scanner.nextLine();
        if (str.length() > 0)
        {
            return str;
        }
        else {
            System.out.println("Chuổi không hợp lệ!");
            return nextLine();
        }
    }

    public static Boolean nextBool(){
        try{
            Boolean b = scanner.nextBoolean();
            scanner.nextLine();//Xóa bộ đẹm bàn phím
            return b;
        }
        catch (Exception ex){
            System.err.println(ex);
            System.out.println("Dữ liệu phải có dạng boolean");
            scanner.nextLine();
            return nextBool();
        }

    }

}
