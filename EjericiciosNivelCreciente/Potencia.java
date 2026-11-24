import java.util.Scanner;

public class Potencia {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int base=0,exponente=0;
    System.out.println("Introduce la base ...");
    base=sc.nextInt();
    System.out.println("Introduce el exponente ...");
    exponente=sc.nextInt();
    System.out.println("La valor de la potencia es : "+potencia(base, exponente));
    }
    public static int potencia(int base, int exponente) {
        if(base>0){
        int resultado=(int)Math.pow(base,exponente); 
        return resultado;
        }else{
            System.out.println("La base no puede ser 0 o negativa");
            return 0;
        }
    }
}
