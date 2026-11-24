import java.util.Scanner;

public class RectanguloTotal {
    public static void rectanguloTotal(double base, double altura) {
        System.out.println("Perimetro: " + (2 * (base + altura)));
        System.out.println("Area: " + (base * altura));

        for (int fila = 0; fila < altura; fila++) {
            for (int columna = 0; columna < base; columna++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double base=0,altura=0;
        System.out.println("Introduce la  base del rectangulo ");
        base=sc.nextInt();
        System.out.println("Introduce la altura del rectangulo ");
        altura=sc.nextInt();

        rectanguloTotal(base,altura);

    }
}
