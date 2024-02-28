import java.util.Scanner;

public class fightChoice {
    static void FightChoice(Player player, Mobs mob, Weapon weapon){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n1.Just attack\n2.Ability\n");
        int playerChoice = sc.nextInt();
        int PlayerDamage= weapon.getDamage()+10* player.getStrength();
        if (playerChoice==1){
            mob.takenDamage(PlayerDamage,mob);
            System.out.println("\n-"+PlayerDamage+" for enemy\n Enemy's HP:"+mob.getHealth());
        }
        else {
            if(weapon.getAbility()==0){
                System.out.println("\nYour weapon has no ability,only damage");
                mob.takenDamage(PlayerDamage,mob);
                System.out.println("\n-"+PlayerDamage+" for enemy\n Enemy's HP:"+mob.getHealth());
            }
            else if (weapon.getAbility()==1) {
                System.out.println("\nThe enemy got a little burned up and took some extra damage");
                mob.takenDamage(PlayerDamage+500,mob);
                System.out.println("\n-"+(PlayerDamage+500)+" for enemy\n Enemy's HP:"+mob.getHealth());
            }
            else if (weapon.getAbility()==2) {
                System.out.println("\n-"+PlayerDamage+" for enemy\n Enemy's HP:"+mob.getHealth());
                mob.takenDamage(PlayerDamage,mob);
                System.out.println("\nEnemy frozen, you can do one more move");
                System.out.println("\n1.Just attack\n");
                int playerChoice2 = sc.nextInt();
                if (playerChoice2==1){
                    mob.takenDamage(PlayerDamage,mob);
                    System.out.println("\n-"+PlayerDamage+" for enemy\n Enemy's HP:"+mob.getHealth());
                }
            }
        }
    }
}
