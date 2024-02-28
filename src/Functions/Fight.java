package Functions;

import Classes.Bandits;
import Classes.Mobs;
import Classes.Player;
import Classes.Weapon;

import java.util.Random;
import java.util.Scanner;

public class Fight {
    static Scanner sc=new Scanner(System.in);
    static Random rand = new Random();

    static boolean fight(Player player, Bandits mob, Weapon weapon){
        int mob_hit=0;
        if (IntelTest.IntelTest(player, mob)){
            System.out.println("\nYou have won intelligence battle, you're moving first");
            while(mob.getHealth()>0){
                fightChoice.FightChoice(player, mob, weapon);
                if(mob.getHealth()<=0){break;}
                int randNum= rand.nextInt(6);
                System.out.println("\n" + mob.getName() + " attacks");
                if(randNum>=4) {
                    System.out.println("\nYou dodged attack");
                    fightChoice.FightChoice(player, mob, weapon);
                    System.out.println("\n" + mob.getName() + " attacks");
                    int randNum2= rand.nextInt(6);
                    if(randNum2>=4) {
                        System.out.println("\nYou dodged attack");
                    }
                    else {
                        boolean b = mobAttack.mobAttack(player, mob, mob_hit);
                        if (!b) {
                            fight(player, mob, weapon);
                        }
                    }
                    if(mob.getHealth()<=0){break;}
                }
                else {
                    if(mob.ability()==2){
                        mob_hit+=1;
                    }
                    CharacterDamage.takenDamage(mob.getDamage(),player);
                    System.out.println("\n-" + mob.getDamage()+"\n You have:"+player.getHealth()+"hp");
                    if (mob_hit==2){
                        System.out.println("\nYou're bleeding: -100HP"+"\nYou have:"+player.getHealth()+"hp");
                        CharacterDamage.takenDamage(100,player);
                        mob_hit=0;
                    }
                    if (player.getHealth()<=0){
                        CharacterRestoreHp.restoreHp(player);
                        CharacterRestoreHp.restoreHp(mob);
                        System.out.println("\nYou died,try again");
                        return false;
                    }
                }
            }
            CharacterRestoreHp.restoreHp(player);
            CharacterRestoreHp.restoreHp(mob);
            return true;
        }
        else {
            System.out.println("\nYou lost intelligence battle");
            while(mob.getHealth()>0){
                int randNum2= rand.nextInt(6);
                System.out.println("\n" + mob.getName() + " attacks");
                if(randNum2>=4) {
                    System.out.println("\nYou dodged attack");
                    fightChoice.FightChoice(player, mob, weapon);
                    if(mob.getHealth()<=0){break;}
                }
                else {
                    CharacterDamage.takenDamage(mob.getDamage(),player);
                    System.out.println("\n-" + mob.getDamage()+"\n You have:"+player.getHealth()+"hp");
                    if (player.getHealth()<=0){
                        CharacterRestoreHp.restoreHp(player);
                        CharacterRestoreHp.restoreHp(player);
                        System.out.println("\nYou died,try again");
                        return false;
                    }
                    fightChoice.FightChoice(player, mob, weapon);
                }
            }
        }
        CharacterRestoreHp.restoreHp(player);
        CharacterRestoreHp.restoreHp(mob);
        return true;
    }
}
