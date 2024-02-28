package Functions;

import Classes.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Weapon> weapons = Weapons();
        ArrayList<Mobs> enemies = Enemies();
        while (true) {
            System.out.println("Main Menu:\n1.Start game\n2.Admin\n3.Show All Mobs\n4.Show All Weapons\n5.Exit\n" );
            int user_inp= sc.nextInt();
            if (user_inp==1){
                Game.game(enemies, weapons);
            } else if (user_inp == 2) {
                System.out.println("Write password:");
                String pass = sc.next();
                if (Objects.equals(pass, "Danial")){
                    Admin.admin(enemies,weapons);
                }
                else{
                    System.out.println("Wrong!");
                }
            }
            else if (user_inp == 3){
                for (Mobs mob: enemies){
                    System.out.println(mob.toString());
                }
            }
            else if (user_inp == 4){
                for (Weapon weapon: weapons){
                    System.out.println(weapon.toString());
                }
            }
            else{break;}
        }
    }
    static ArrayList<Mobs> Enemies(){
        ArrayList<Mobs> enemies = new ArrayList<>();
        enemies.add(new Bandits(5,250,400,"Bandit",1,100));
        enemies.add(new Bandits(7,250,500,"Knight",2,300));
        enemies.add(new Bandits(10,350,750,"Dragon Hunter",2,500));
        return enemies;
    }
    static ArrayList<Weapon> Weapons(){
        ArrayList<Weapon> weapons= new ArrayList<>();
        weapons.add(new Weapon("Stick",100,0));
        weapons.add(new Weapon("Sword",200,0));
        weapons.add(new Weapon("Frozen Sword",200,2));
        weapons.add(new Weapon("DragonKiller",1000,1));
        return weapons;
    }
}
