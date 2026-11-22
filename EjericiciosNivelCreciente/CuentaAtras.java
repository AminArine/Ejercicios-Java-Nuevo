package EjericiciosNivelCreciente;

import java.util.Scanner;

public class CuentaAtras {
    public static void cuentaAtras(int n){
        for(int i=n;i>=0;i--){
        System.out.println("/n"+n+" ");
        }
    }
    public static void main(String[] args) {
        
        int num=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce un numero ...." );
        num=sc.nextInt();
        cuentaAtras(num);
       
    }
}
