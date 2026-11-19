import java.util.Scanner;

public class FuncionesConExcepciones {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int MIN, MAX;
        int dato=0;
        do{
        System.out.println("Introduce el maximo de los aleatorios ...");
        MAX = sc.nextInt();
        System.out.println("Introduce el minimo de los aleatorios ...");
        MIN = sc.nextInt();
        pedirEntero(MAX,MIN);
        }while(MAX<MIN);

	}

	public static void pedirEntero(int MAX,int MIN) {
        int num1, num2;
        num1=(int) (Math.random() * (MAX - MIN + 1)) + MIN;
        num2=(int) (Math.random() * (MAX - MIN + 1)) + MIN;

        System.out.println("Numeros aleatorios: " + num1 + " y " + num2
            +"\n -->La suma es de: "+(num1+num2));
        System.out.println("La media de ambos numero es de "+media(num1,num2));
	}
    public static double  media(int num1,int num2){
        return (num2+num1)/2;
    }

    
}
