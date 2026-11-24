import java.util.Scanner;

public class Promedio {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    double  a=0,b=0,c=0;
    System.out.println("Introduce la primera nota  ...");
    a=sc.nextDouble();
    System.out.println("Introduce la segunda nota  ...");
    b=sc.nextDouble();
    System.out.println("Introduce la tercera nota  ...");
    c=sc.nextDouble();
   double media = promedio(a, b, c);
   if (media >= 9) {
      System.out.println("Excelente");
   } else if (media >= 7) {
      System.out.println("Notable");
   } else if (media >= 6) {
      System.out.println("Bien");
   } else if (media >= 5) {
      System.out.println("Aprobado");
   } else {
      System.out.println("Suspenso");
   }
    }
     public static double promedio(double a, double b, double c){
        double media=(a+b+c)/3;
        return media;
     }
}
