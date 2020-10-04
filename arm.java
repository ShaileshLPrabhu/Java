import java.util.*;
 class arm{
public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int x=sc.nextInt(),rem=0,s=0;
    int temp=x;
    while(x>0){
        rem=x%10;
        x=x/10;
        s=s+(rem*rem*rem);
    }
    if (temp==s) {
        System.out.println("Armstrong");
    }else{
        System.out.println("Nope");
    }
}}