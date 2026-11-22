package EjericiciosNivelCreciente;

import java.util.Scanner;

public class esVocal {
    
    public static void main(String []args){
    Scanner sc=new Scanner(System.in);
    char letra='a';
    System.out.println("Introduce la letra a comprobar ...");
    letra=sc.next().charAt(0);
    esVocal(letra);
    } 
    public static boolean esVocal(char letra){
        char [] vocales =new char[5];
        vocales [0]='a';
        vocales [1]='e';
        vocales [2]='i';
        vocales [3]='o';
        vocales [4]='u';
        for(int i=0;i<vocales.length;i++){
            if(vocales[i]==letra){
                return true;
            }
        }
        return false;
    }
}
