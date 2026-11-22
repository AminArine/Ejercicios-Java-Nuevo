package EjericiciosNivelCreciente;

import java.util.Scanner;

public class Saludo {
    
    public static void main(String []args){
    Scanner sc=new Scanner(System.in);
    char letra='a';
    System.out.println("Introduce la letra  ...");
    letra=sc.next().charAt(0);
    saludar(letra);
    } 
    public static void saludar(char inicial){
        System.out.println("Hola ..."+inicial);
    }
}
