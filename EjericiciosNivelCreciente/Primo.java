import java.util.Scanner;
public class Primo {
    public static void main(String[] args) {
        int num=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce un numero ");
        num=sc.nextInt();
        System.out.println("¿Es "+num+" un numero primo?");
        System.out.println(esPrimo(num));

    }
    public static boolean esPrimo(int num){
        if(num==2){
            return true;
        }
        for(int i=3;i<=num;i+=2){
            if(num%i==0){
                System.out.println(" "+i+" / ");
                return true;
            }
        }
        return false;
    }
    
}
