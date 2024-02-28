package Functions;

import Classes.Bandits;
import Classes.Mobs;
import Classes.Weapon;

import java.util.ArrayList;
import java.util.Scanner;

public class AddMob {
    public static void addMob(ArrayList<Mobs> enemies){
        Scanner sc = new Scanner(System.in);
        System.out.println("Write name of mob:");
        String name = sc.next();
        System.out.println("Write Intelligence of mob:");
        int intelligence = sc.nextInt();
        System.out.println("Write damage of mob:");
        int damage = sc.nextInt();
        System.out.println("Write health of mob:");
        int health = sc.nextInt();
        System.out.println("Write weapon of mob(1:sword 2:katana):");
        int weapon = sc.nextInt();
        System.out.println("Write given xp of mob:");
        int givenxp = sc.nextInt();
        enemies.add(new Bandits(intelligence, damage, health,name,weapon,givenxp));
    }
}
