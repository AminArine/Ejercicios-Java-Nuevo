import java.util.Scanner;

public class Cuadrado {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int num=0;
        System.out.println("Introduce un numero para sacar su cuadrado :");
        num=sc.nextInt();
        System.out.println("EL cuadrado de "+num+" es : ");
        System.out.println(Cuadrado(num));
	}
    public static int  Cuadrado(int num){
        return num*num;
    }
}

