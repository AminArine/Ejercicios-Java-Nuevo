package EjericiciosFunciones;

import java.util.Scanner;

public class Cuadrado {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
            int base=0,exponente=0;
            System.out.print("Introduce un numero base..");
            base=sc.nextInt();
            System.out.println(Cuadrado(base));
    }
    public static int  Cuadrado(int base){
       return base*base;
    }
    
}
