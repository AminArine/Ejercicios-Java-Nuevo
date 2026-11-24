import java.util.Scanner;

public class esVocal {
    
    public static void main(String []args){
    Scanner sc=new Scanner(System.in);
    char letra='a';
    System.out.println("Introduce la letra a comprobar ...");
    letra=sc.next().charAt(0);
    System.out.println("¿Es "+letra+" auna vocal ?"
        +"\n"+ esVocal(letra));
   
    } 
    public static boolean esVocal(char letra){
        String vocal=" "+letra;
        if(vocal.toLowerCase().contains("a")|| vocal.toLowerCase().contains("e")||vocal.toLowerCase().contains("i")||vocal.toLowerCase().contains("o")||vocal.toLowerCase().contains("u")){
            return true;
        }else{
            return false;
        }
        
    }
}
