import java.util.Scanner;

public class startGame {
    static Scanner sc=new Scanner(System.in);
    static Player GameStart(){
        System.out.println("Welcome to the game Tarnished. Write Your name:");
        String player_name = sc.next();
        System.out.println("\n"+"You Have 10 points to set your abilities");
        System.out.println("\nWrite number of points for intelligence(if your intelligence is more you have more chance to do move first):\n");
        Scanner sc=new Scanner(System.in);
        int intelligence= sc.nextInt();
        System.out.println("\nWrite number of points for strength(gives more damage for you weapon):\n");
        int strength= sc.nextInt();
        if((intelligence+strength)>10) {
            System.out.println("\nYou set more than 10 points");
            return GameStart();
        }
        else {
            return new Player(player_name,intelligence,strength);
        }
    }
}
