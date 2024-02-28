package Functions;

import Classes.Bandits;
import Classes.Mobs;
import Classes.Player;
import Classes.Weapon;

import java.util.Scanner;

public class FightRes {
    static Scanner sc=new Scanner(System.in);
    static void fightRes(Player player, Mobs mob, Weapon weapon){
        while (true){
            if(Fight.fight(player, (Bandits) mob, weapon)){
                System.out.println("\nYou have won\nYou got "+ mob.getGivenxp()+"xp\n");
                int c = LevelUp.levelUp(player, mob.getGivenxp());
                System.out.println("You've raised your level by "+c);
                for(int i=1;i<=c;i++){
                    System.out.println("\nChoose stat to upgrade:\n1.Intelligence\n2.Strength\n");
                    int d = sc.nextInt();
                    LevelUp.LevelUp(player, d);
                }
                break;
            }
        }
    }
}
