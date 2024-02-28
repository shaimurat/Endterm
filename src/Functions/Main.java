package Functions;

import Classes.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Weapon> weapons = Weapons();
        ArrayList<Mobs> enemies = Enemies();
        while (true) {
            System.out.println("\nFunctions.Main Menu:\n1.Start game\n2.Exit\n" );
            int user_inp= sc.nextInt();
            if (user_inp==1){
            Player player = startGame.GameStart();
            Weapon playerWeapon = weapons.get(0);
            System.out.println("\nYou've entered the world of Middle-earth! Your goal is to defeat your enemies and become the King of Elden.");
            System.out.println("\nYou started on your way to the castle of Middle-earth when suddenly you were attacked by a bandit with sword! \nFunctions.Fight started!");
            FightRes.fightRes(player,enemies.get(0),playerWeapon,100);
            while (menu.Menu(player,playerWeapon)){}
            System.out.println("\nYou continued on your way to the castle. On the way you met a knight who could not solve the riddle.\nHe was standing in front of the door with the riddle. \nOn the door was written \n\"I am an odd number. Take away a letter and I become even. What number am I?\"");
            System.out.println("\nWrite your answer:\n");
            int a= sc.nextInt();
            while(a!=7){
                System.out.println("\nWRONG, try again\n");
                a= sc.nextInt();
            }
            System.out.println("\nThat's right! The wizard was very pleased and gave you the Sword as a thank you.");
            System.out.println("\nYou got the sword!");
            playerWeapon=weapons.get(1);
            while (menu.Menu(player,playerWeapon)){};
            System.out.println("You continued on your way. After a couple of hours you came to the castle. \nThe castle was guarded by a knight with ice sword. He immediately attacked you.");
            System.out.println("\nFight started");
            FightRes.fightRes(player,enemies.get(1),playerWeapon,500);
            System.out.println(("\nYou received Ice Sword! Ability:Freezing enemy, one more move"));
            playerWeapon=weapons.get(2);
            while (menu.Menu(player,playerWeapon)){}
            System.out.println("\nAfter your victory, you entered the castle courtyard where you were met by a dragon hunter. \nHe had spent his life searching for a rival who could give him the pleasure of battle. He offered you a duel.\n");
            System.out.println("Fight started!");
            FightRes.fightRes(player,enemies.get(2),playerWeapon,1000);
            System.out.println("\nYou received Dragon Killer");
            playerWeapon=weapons.get(3);
            while (menu.Menu(player,playerWeapon)){}
            System.out.println("\nAfter a difficult fight with a dragon slayer, you went to the roof of the castle. \nSuddenly, you heard a loud roar from afar. \nA huge fire dragon flew in and took you to a huge field that was completely burned.\n");
            System.out.println("Fight started!\n");
            dragonFight.DragonFight(player, (Dragon) enemies.get(3),playerWeapon);
            while (menu.Menu(player,playerWeapon)){}
            System.out.println("\nTurns out it was a wizard who had been following you from the beginning of your journey! \nHe knew it was your destiny to become king of Middle-earth.\n");
            System.out.println("You have sat on a throne that has long awaited its new master. Since then," + player.getName()+ "\'s era has dawned in Middle-earth" );
            System.out.println("\nCongratulations, you completed my stupid game!");

            break;
            }
            else{break;}
        }
    }
    static ArrayList<Mobs> Enemies(){
        ArrayList<Mobs> enemies = new ArrayList<>();
        enemies.add(new Bandits(5,250,400,"Bandit",1));
        enemies.add(new Bandits(7,250,500,"Knight",2));
        enemies.add(new Bandits(10,350,750,"Classes.Dragon Hunter",2));
        enemies.add(new Dragon(10,800,3500,"Fire Classes.Dragon",1));
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
