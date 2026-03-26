import java.util.Scanner;

public class Exercice2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Saisre la premier nomber");
        int a=sc.nextInt();
        System.out.println("Saisre la deuseme nomber");
        int b=sc.nextInt();
        System.out.println("Saisre la troiseme nomber");
        int c=sc.nextInt();
       if(a>b & a>c){
          System.out.printf("le nomber plus grand est %d",a);
       }
       else if(b>a & b>c){
           System.out.printf("le nomber plus grand est %d",b);
       }
       else{}
    }
}