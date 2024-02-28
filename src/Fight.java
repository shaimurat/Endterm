import java.util.Random;
import java.util.Scanner;

public class Fight {
    static Scanner sc=new Scanner(System.in);
    static Random rand = new Random();
    static boolean IntelTest(Player player, Mobs mob){
        int randNum= rand.nextInt(6);
        if(player.getIntelligence() > mob.getIntelligence()){
            return randNum <= 3; //if randomizer gets number less than 3, player will move first
        }
        else{return randNum >= 3;}//if randomizer gets number less than 3, enemy will move first
    }
    static void fightReal(Player player, Mobs mob, Weapon weapon, int xp){
        while (true){
            if(fight(player, (Bandits) mob, weapon)){
                System.out.println("\nYou have won\nYou got "+xp+"xp\n");
                int c = LevelUp.levelUp(player, xp);
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
    static boolean fight(Player player, Bandits mob, Weapon weapon){
        int mob_hit=0;
        if (IntelTest(player, mob)){
            System.out.println("\nYou have won intelligence battle, you're moving first");
            while(mob.getHealth()>0){
                fightChoice.FightChoice(player, mob, weapon);
                if(mob.getHealth()<=0){break;}
                int randNum= rand.nextInt(6);
                System.out.println("\nEnemy Attacks");
                if(randNum>=4) {
                    System.out.println("\nYou dodged attack");
                    fightChoice.FightChoice(player, mob, weapon);
                    System.out.println("\nEnemy Attacks");
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
                    player.takenDamage(mob.getDamage(),player);
                    System.out.println("\n-" + mob.getDamage()+"\n You have:"+player.getHealth()+"hp");
                    if (mob_hit==2){
                        System.out.println("\nYou're bleeding: -100HP"+"\nYou have:"+player.getHealth()+"hp");
                        player.takenDamage(100,player);
                        mob_hit=0;
                    }
                    if (player.getHealth()<=0){
                        player.restoreHp(player);
                        mob.restoreHp(mob);
                        System.out.println("\nYou died,try again");
                        return false;
                    }
                }
            }
            return true;
        }
        else {
            System.out.println("\nYou lost intelligence battle");
            while(mob.getHealth()>0){
                int randNum2= rand.nextInt(6);
                System.out.println("\nEnemy Attacks");
                if(randNum2>=4) {
                    System.out.println("\nYou dodged attack");
                    fightChoice.FightChoice(player, mob, weapon);
                    if(mob.getHealth()<=0){break;}
                }
                else {
                    player.takenDamage(mob.getDamage(),player);
                    System.out.println("\n-" + mob.getDamage()+"\n You have:"+player.getHealth()+"hp");
                    if (player.getHealth()<=0){
                        player.restoreHp(player);
                        mob.restoreHp(player);
                        System.out.println("\nYou died,try again");
                        return false;
                    }
                    fightChoice.FightChoice(player, mob, weapon);
                }
            }
        }
        return true;
    }
}
