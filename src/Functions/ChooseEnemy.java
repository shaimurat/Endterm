package Functions;

import Classes.Mobs;
import Classes.Player;
import Classes.Weapon;

import java.util.ArrayList;
import java.util.Scanner;

public class ChooseEnemy{
    static Scanner sc = new Scanner(System.in);
    public static Weapon chooseEnemy(ArrayList<Mobs> enemies, ArrayList<Weapon> weapons, Player player, Weapon playerWeapon){
        for (Mobs mob: enemies){
            System.out.println(mob.toString());
        }
        System.out.println("Choose your enemy:");
        int enemyId = sc.nextInt();
        FightRes.fightRes(player, enemies.get(enemyId - 1),playerWeapon);
        return weapons.get(enemyId-1);
    }
}
