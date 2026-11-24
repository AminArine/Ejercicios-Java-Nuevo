import java.util.Scanner;

public class Mcd {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int num=0,num1=0;
        System.out.println("Introduce el primer numero :");
        num=sc.nextInt();
        System.out.println("Introduce el primer numero :");
        num1=sc.nextInt();
        MCD(num,num1);
    }
    public static void MCD(int num,int num1){
        int resto=-1;
        if(num1>num){
            while(resto!=0){
                resto=num1%num;
                num1=num;
                num=resto;
            }
            System.out.println("El MCD es :"+num1);
                
        }else{
             while(resto!=0){
                resto=num%num1;
                num=num1;
                num1=resto;
            }
            System.out.println("El MCD es :"+num);
        }
    }
    
}
