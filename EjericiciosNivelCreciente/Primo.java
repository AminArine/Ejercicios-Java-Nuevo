import java.util.Scanner;
public class Primo {
    public static void main(String[] args) {
        int num=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce un numero : ");
        num=sc.nextInt();
        System.out.println("¿Es "+num+" un numero primo?");
        System.out.println(esPrimo(num));

    }
    public static boolean esPrimo(int num){
        
        if (num == 2) {
            return true;
        }

        if (num < 2 || num % 2 == 0) {
            return false;
        }

        for (int i = 3; i < num; i += 2) {

            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
    
}
