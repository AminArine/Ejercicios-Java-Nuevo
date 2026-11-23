import java.util.Scanner;

public class Mcd {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int num=0,num1=0;
        System.out.println("Introduce el primer numero :");
        num=sc.nextInt();
        System.out.println("Introduce el primer numero :");
        num=sc.nextInt();
        MCD(num,num1);
    }
    public static void MCD(int num,int num1){
        if(num1>num){
            int [] divisores=new int[num1];
            int [] divisores1=new int[num1];
            int j=0;
            System.out.println("Divisores de :"+num);
            for(int i=1;i<num;i++){
                if(num%i==0){
                    divisores[j]=i;
                    System.out.print(divisores[j]+" / ");
                    j++;
                }
            }
            j=0;
             System.out.println("Divisores de :"+num1);
            for(int i=1;i<num1;i++){
                if(num1%i==0){
                    divisores1[j]=i;
                    System.out.print(divisores1[j]+" / ");
                    j++;
                }
            }
        }else{
            int [] divisores=new int[num];
            int [] divisores1=new int[num];
            int j=0;
            System.out.println("Divisores de :"+num);
            for(int i=1;i<num;i++){
                if(num%i==0){
                    divisores[j]=i;
                    System.out.print(divisores[j]+" / ");
                    j++;
                }
            }
            j=0;
            System.out.println("Divisores de :"+num1);
            for(int i=1;i<num1;i++){
                if(num1%i==0){
                    divisores1[j]=i;
                    System.out.print(divisores1[j]+" / ");
                    j++;
                }
            }
        }  
        
    }
}
