package Functions;

import Classes.Mobs;
import Classes.Weapon;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    public static void admin(ArrayList<Mobs> enemies, ArrayList<Weapon> weapons){
        Scanner sc = new Scanner(System.in);
        while (true){
        System.out.println("1.Add Weapon\n2.Add Enemy\n3.Exit");
        int choice = sc.nextInt();
        if (choice == 1){
            AddWeapon.addWeapon(weapons);
        }
        else if (choice == 2) {
            AddMob.addMob(enemies);
        }
        else {
            break;
        }

        }
        }
        }

