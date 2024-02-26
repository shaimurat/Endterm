import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    static String RESET = "\u001B[0m";
    static String RED = "\u001B[31m";
    static String GREEN = "\u001B[32m";
    static String YELLOW = "\u001B[33m";
    static Scanner sc=new Scanner(System.in);
    static Random rand = new Random();
    public static void main(String[] args) {
        ArrayList<Weapon> weapons = Weapons();
        ArrayList<Mobs> enemies = Enemies();
        while (true) {
            System.out.println(YELLOW+"\nMain Menu:\n1.Start game\n2.Exit\n" +RESET);
            int user_inp= sc.nextInt();
            if (user_inp==1){
            Player player = GameStart();
            Weapon playerWeapon = weapons.get(0);
            System.out.println(YELLOW+"\nYou've entered the world of Middle-earth! Your goal is to defeat your enemies and become the King of Elden."+RESET);
            System.out.println(RED+"\nYou started on your way to the castle of Middle-earth when suddenly you were attacked by a bandit with sword! \nFight started!"+RESET);
            fightReal(player,enemies.get(0),playerWeapon,100);
            while (Menu(player,playerWeapon)){}
            System.out.println(YELLOW+"\nYou continued on your way to the castle. On the way you met a knight who could not solve the riddle.\nHe was standing in front of the door with the riddle. \nOn the door was written \n\"I am an odd number. Take away a letter and I become even. What number am I?\""+RESET);
            System.out.println(YELLOW+"\nWrite your answer:\n"+RESET);
            int a= sc.nextInt();
            while(a!=7){
                System.out.println(RED+"\nWRONG, try again\n"+RESET);
                a= sc.nextInt();
            }
            System.out.println(GREEN+"\nThat's right! The wizard was very pleased and gave you the Sword as a thank you."+RESET);
            System.out.println(GREEN+"\nYou got the sword!"+RESET);
            playerWeapon=weapons.get(1);
            while (Menu(player,playerWeapon)){};
            System.out.println(YELLOW+"You continued on your way. After a couple of hours you came to the castle. \nThe castle was guarded by a knight with ice sword. He immediately attacked you."+RESET);
            System.out.println(RED+"\nFight started"+RESET);
            fightReal(player,enemies.get(1),playerWeapon,500);
            System.out.println(GREEN+("\nYou received Ice Sword! Ability:Freezing enemy, one more move"));
            playerWeapon=weapons.get(2);
            while (Menu(player,playerWeapon)){}
            System.out.println(YELLOW+"\nAfter your victory, you entered the castle courtyard where you were met by a dragon hunter. \nHe had spent his life searching for a rival who could give him the pleasure of battle. He offered you a duel.\n"+RESET);
            System.out.println(RED+"Fight started!"+RESET);
            fightReal(player,enemies.get(2),playerWeapon,1000);
            System.out.println(GREEN+"\nYou received Dragon Killer"+RESET);
            playerWeapon=weapons.get(3);
            while (Menu(player,playerWeapon)){}
            System.out.println(YELLOW+"\nAfter a difficult fight with a dragon slayer, you went to the roof of the castle. \nSuddenly, you heard a loud roar from afar. \nA huge fire dragon flew in and took you to a huge field that was completely burned.\n"+RESET);
            System.out.println(RED+"Fight started!\n"+RESET);
            DragonFight(player, (Dragon) enemies.get(3),playerWeapon);
            while (Menu(player,playerWeapon)){}
            System.out.println(YELLOW+"\nTurns out it was a wizard who had been following you from the beginning of your journey! \nHe knew it was your destiny to become king of Middle-earth.\n"+RESET);
            System.out.println(YELLOW+"You have sat on a throne that has long awaited its new master. Since then," + player.getName()+ "\'s era has dawned in Middle-earth" +RESET);
            System.out.println(GREEN+"\nCongratulations, you completed my stupid game!");

            break;
            }
            else{break;}
        }
    }
    static Player GameStart(){
        System.out.println(YELLOW+"Welcome to the game Tarnished. Write Your name:"+RESET);
        String player_name = sc.next();
        System.out.println(YELLOW+"\n"+"You Have 10 points to set your abilities");
        System.out.println("\nWrite number of points for intelligence(if your intelligence is more you have more chance to do move first):\n");
        Scanner sc=new Scanner(System.in);
        int intelligence= sc.nextInt();
        System.out.println("\nWrite number of points for strength(gives more damage for you weapon):\n");
        int strength= sc.nextInt();
        if((intelligence+strength)>10) {
            System.out.println(RED+"\nYou set more than 10 points"+RESET);
            return GameStart();
        }
        else {
            return new Player(player_name,intelligence,strength);
    }
    }
    static void LevelUp(Player player, int userInp){
        if(userInp==1){
            player.setIntelligence(player.getIntelligence()+1);
            System.out.println(GREEN+"\nYour intelligence has been upgraded"+RESET);
        }
        else if (userInp==2) {
            player.setStrength(player.getStrength()+1);
            System.out.println(GREEN+"\nYour strength has been upgraded"+RESET);
        }
    }
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
                System.out.println(GREEN+"\nYou have won\nYou got "+xp+"xp\n");
                int c = levelUp(player, xp);
                System.out.println("You've raised your level by "+c+RESET);
                for(int i=1;i<=c;i++){
                    System.out.println("\nChoose stat to upgrade:\n1.Intelligence\n2.Strength\n");
                    int d = sc.nextInt();
                    LevelUp(player, d);
                }
                break;
            }
        }
    }
    public static int levelUp(Player player, int xp_plus) {
        player.setXp(player.getXp()+xp_plus);
        int count = 0;
        while(player.getXp()>=player.getUp()){
            player.setLevel(player.getLevel()+1);
            count += 1;
            player.setXp(player.getXp()-player.getUp());
            player.setUp(player.getUp()+(10*player.getLevel()));
        }
        return count;
    }
    static boolean mobAttack(Player player, Bandits mob, int mob_hit){
        if(mob.ability()==2){
            mob_hit+=1;
        }
        player.takenDamage(mob.getDamage(),player);
        System.out.println(RED+"\n-" + mob.getDamage()+"\n You have:"+player.getHealth()+"hp"+RESET);
        if (mob_hit==2){
            System.out.println(RED+"\nYou're bleeding: -100HP"+"\nYou have:"+player.getHealth()+"hp"+RESET);
            player.takenDamage(100,player);
        }
        if (player.getHealth()<=0){
            player.restoreHp(player);
            mob.restoreHp(player);
            System.out.println(RED+"\nYou died,try again"+RESET);
            return false;
        }
        return true;
    }
    static boolean fight(Player player, Bandits mob, Weapon weapon){
        int mob_hit=0;
        if (IntelTest(player, mob)){
            System.out.println(GREEN+"\nYou have won intelligence battle, you're moving first"+RESET);
            while(mob.getHealth()>0){
                FightChoice(player, mob, weapon);
                if(mob.getHealth()<=0){break;}
                int randNum= rand.nextInt(6);
                System.out.println(RED+"\nEnemy Attacks"+RESET);
                if(randNum>=4) {
                    System.out.println(GREEN+"\nYou dodged attack"+RESET);
                    FightChoice(player, mob, weapon);
                    System.out.println(RED+"\nEnemy Attacks"+RESET);
                    int randNum2= rand.nextInt(6);
                    if(randNum2>=4) {
                        System.out.println(GREEN+"\nYou dodged attack"+RESET);
                    }
                    else {
                        boolean b = mobAttack(player, mob, mob_hit);
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
                    System.out.println(RED+"\n-" + mob.getDamage()+"\n You have:"+player.getHealth()+"hp"+RESET);
                    if (mob_hit==2){
                        System.out.println(RED+"\nYou're bleeding: -100HP"+"\nYou have:"+player.getHealth()+"hp"+RESET);
                        player.takenDamage(100,player);
                        mob_hit=0;
                    }
                    if (player.getHealth()<=0){
                        player.restoreHp(player);
                        mob.restoreHp(mob);
                        System.out.println(RED+"\nYou died,try again"+RESET);
                        return false;
                    }
                }
            }
            return true;
        }
        else {
            System.out.println(RED+"\nYou lost intelligence battle"+RESET);
            while(mob.getHealth()>0){
                int randNum2= rand.nextInt(6);
                System.out.println(RED+"\nEnemy Attacks"+RESET);
                if(randNum2>=4) {
                    System.out.println(GREEN+"\nYou dodged attack"+RESET);
                    FightChoice(player, mob, weapon);
                    if(mob.getHealth()<=0){break;}
                }
                else {
                    player.takenDamage(mob.getDamage(),player);
                    System.out.println(RED+"\n-" + mob.getDamage()+"\n You have:"+player.getHealth()+"hp"+RESET);
                    if (player.getHealth()<=0){
                        player.restoreHp(player);
                        mob.restoreHp(player);
                        System.out.println(RED+"\nYou died,try again"+RESET);
                        return false;
                    }
                    FightChoice(player, mob, weapon);
                }
            }
        }
        return true;
    }
    static void DragonFight(Player player, Dragon mob, Weapon weapon){
        System.out.println(RED+"\nThe dragon started exhaling fire"+RESET);
        System.out.println(GREEN+"\nLuckily you were saved by your dragon sword\nYou're making your move!\n"+RESET);
        FightChoice(player,mob,weapon);
        System.out.println(RED+"\nThe dragon grabbed you with its mouth and did a lot of damage."+RESET);
        player.takenDamage(mob.getDamage(),player);
        System.out.println(RED+"\n-" + mob.getDamage()+"\n You have:"+player.getHealth()+"hp"+RESET);
        System.out.println(GREEN+"\nYou hit him in the eye and inflicted critical damage!!\n"+RESET);
        mob.takenDamage(2500,mob);
        System.out.println(GREEN+"\n-"+2500+" for enemy\n Enemy's HP:"+mob.getHealth()+RESET);
        System.out.println(GREEN+"\nThe dragon is dead! You won and something sent you back to the castle."+RESET);
        System.out.println(GREEN+"\nYou have won\n");

    }
    static void FightChoice(Player player, Mobs mob, Weapon weapon){
        System.out.println(GREEN+"\n1.Just attack\n2.Ability\n"+RESET);
        int playerChoice = sc.nextInt();
        int PlayerDamage= weapon.getDamage()+10* player.getStrength();
        if (playerChoice==1){
            mob.takenDamage(PlayerDamage,mob);
            System.out.println(GREEN+"\n-"+PlayerDamage+" for enemy\n Enemy's HP:"+mob.getHealth()+RESET);
        }
        else {
            if(weapon.getAbility()==0){
                System.out.println(GREEN+"\nYour weapon has no ability,only damage");
                mob.takenDamage(PlayerDamage,mob);
                System.out.println("\n-"+PlayerDamage+" for enemy\n Enemy's HP:"+mob.getHealth()+RESET);
            }
            else if (weapon.getAbility()==1) {
                System.out.println(GREEN+"\nThe enemy got a little burned up and took some extra damage");
                mob.takenDamage(PlayerDamage+500,mob);
                System.out.println("\n-"+(PlayerDamage+500)+" for enemy\n Enemy's HP:"+mob.getHealth()+RESET);
            }
            else if (weapon.getAbility()==2) {
                System.out.println("\n-"+PlayerDamage+" for enemy\n Enemy's HP:"+mob.getHealth()+RESET);
                mob.takenDamage(PlayerDamage,mob);
                System.out.println(GREEN+"\nEnemy frozen, you can do one more move");
                System.out.println(GREEN+"\n1.Just attack\n"+RESET);
                int playerChoice2 = sc.nextInt();
                if (playerChoice2==1){
                    mob.takenDamage(PlayerDamage,mob);
                    System.out.println(GREEN+"\n-"+PlayerDamage+" for enemy\n Enemy's HP:"+mob.getHealth()+RESET);
                }
            }
        }
    }
    static ArrayList<Mobs> Enemies(){
        ArrayList<Mobs> enemies = new ArrayList<>();
        enemies.add(new Bandits(5,250,400,"Bandit",1));
        enemies.add(new Bandits(7,250,500,"Knight",2));
        enemies.add(new Bandits(10,350,750,"Dragon Hunter",2));
        enemies.add(new Dragon(10,800,3500,"Fire Dragon",1));
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
    static boolean Menu(Player player, Weapon weapon){
        System.out.println(YELLOW+"\n1.Move on\n2.Have a rest and eat(HP recovery)\n3.Show stats\n"+RESET);
        int a=sc.nextInt();
        if(a==3){
            System.out.println(player.toString());
            System.out.println("\n"+weapon.toString());
            return true;
        }
        else if (a==2) {
            player.restoreHp(player);
            return true;
        }
        return false;
    }
}
