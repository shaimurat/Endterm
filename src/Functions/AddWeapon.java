package Functions;

import Classes.Weapon;

import java.util.ArrayList;
import java.util.Scanner;

public class AddWeapon {
    public static void addWeapon(ArrayList<Weapon> weapons){
        Scanner sc = new Scanner(System.in);
        System.out.println("Write name of weapon:");
        String name = sc.next();
        System.out.println("Write damage of weapon:");
        int damage = sc.nextInt();
        System.out.println("Write ability of weapon(1: Fire damage, 2: Freezing ability, 0: nothing):");
        int ability = sc.nextInt();
        weapons.add(new Weapon(name,damage,ability));
    }
}
