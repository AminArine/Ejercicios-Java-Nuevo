package EjericiciosNivelCreciente;

import java.util.Scanner;

public class ContarDigitos {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int numero=0;
        System.out.println("Introduce un numero...");
        numero=sc.nextInt();
        contarDigitos(numero);
    }
     public static int contarDigitos(int n){
        int contador=1;
        for(int i=1;i<=contador;i++){
            if(n<Math.pow(10,i)){
                contador++;
            }
        }
        return contador-1;
     }
}
