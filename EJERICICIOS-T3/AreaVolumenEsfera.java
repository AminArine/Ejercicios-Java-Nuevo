import java.util.Scanner;

public class AreaVolumenEsfera {

    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el radio de la esfera:");
        double radio = sc.nextDouble();

        esfera(radio);
    }
    public static void esfera(double radio) {

        double superficie = 4 * Math.PI * Math.pow(radio, 2);

        double volumen = (4 * Math.PI / 3) * Math.pow(radio, 3);

        System.out.println("Superficie: " + superficie);
        System.out.println("Volumen: " + volumen);
    }

}
