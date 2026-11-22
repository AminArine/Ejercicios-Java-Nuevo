package EjericiciosNivelCreciente;

public class RectanguloTotal {
    public static void rectanguloTotal(double base, double alturan) {
        System.out.println("Perimetro: " + (2 * (base + alturan)));
        System.out.println("Area: " + (base * alturan));

        for (int fila = 0; fila < alturan; fila++) {
            for (int columna = 0; columna < base; columna++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
