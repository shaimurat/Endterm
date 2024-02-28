package Functions;

import Classes.Mobs;
import Classes.Player;
import Classes.Weapon;

import java.util.ArrayList;
import java.util.Scanner;


public class Game {
    static Scanner sc=new Scanner(System.in);
    public static void game(ArrayList<Mobs> enemies, ArrayList<Weapon> weapons){

        Player player = startGame.GameStart();
        Weapon playerWeapon = weapons.get(0);
        while (true) {
            System.out.println("1.Stats\n2.Show Mobs\n3.My Weapon\n4.Exit");
            int choice = sc.nextInt();
            if (choice == 1){
                System.out.println(player.toString());
            }
            else if (choice == 2) {
                playerWeapon = ChooseEnemy.chooseEnemy(enemies,weapons,player,playerWeapon);
                System.out.println("You got " + playerWeapon.toString());
            }
            else if (choice == 3) {
                System.out.println(playerWeapon.toString());
            }
            else {break;}
        }
    }
}
