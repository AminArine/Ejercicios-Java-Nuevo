import java.util.Scanner;

public class ContarDigitos {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int numero=0;
        System.out.println("Introduce un numero...");
        numero=sc.nextInt();
        System.out.println("Son :"+contarDigitos(numero)+" digitos.");
    }
     public static int contarDigitos(int n){
        int contador=0;
        for(int i=0;i<=n;i++){
            if(n>=Math.pow(10,i)){
                contador++;
            }
        }
        return contador;
     }
}
