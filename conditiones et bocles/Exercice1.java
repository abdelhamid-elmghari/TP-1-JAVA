import java.util.Scanner;

public class Exercice1 {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Saisir un nomber:");
    int n=sc.nextInt();
    if(n>0){
      System.out.println("le nomber est positif");
    }
    else if(n<0){
      System.out.println("le nomber est negatif");
    }
    else{
      System.out.println("le nomber est null");
    }
  }}