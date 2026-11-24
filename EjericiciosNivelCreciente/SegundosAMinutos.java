import java.util.Scanner;

public class SegundosAMinutos {
     public static void main(String []args){
    Scanner sc=new Scanner(System.in);
    int num=0;
    System.out.println("Introduce los segundos a convertir ...");
    num=sc.nextInt();
    System.out.println("Son "+segundosAMinutos(num)+" minutos.");
    }
    public static int segundosAMinutos(int num) {
        return num / 60;
    }
}
