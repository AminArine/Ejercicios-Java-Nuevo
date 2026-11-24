import java.util.Scanner;

public class esPar{
    public static void main(String []args){
    Scanner sc=new Scanner(System.in);
    int num=0;
    System.out.println("Introduce el numero a comprobar ...");
    num=sc.nextInt();
    esPar(num);
    }
    public static void esPar(int num){
        if(num%2==0){
            System.out.println("Es un numero par");
        }else{
            System.out.println("Es un numero impar");
        }
    }
}
