package Functions;

import Classes.Dragon;
import Classes.Player;
import Classes.Weapon;

public class dragonFight {
    static void DragonFight(Player player, Dragon mob, Weapon weapon){
        System.out.println("\nThe dragon started exhaling fire");
        System.out.println("\nLuckily you were saved by your dragon sword\nYou're making your move!\n");
        fightChoice.FightChoice(player,mob,weapon);
        System.out.println("\nThe dragon grabbed you with its mouth and did a lot of damage.");
        CharacterDamage.takenDamage(mob.getDamage(),player);
        System.out.println("\n-" + mob.getDamage()+"\n You have:"+player.getHealth()+"hp");
        System.out.println("\nYou hit him in the eye and inflicted critical damage!!\n");
        CharacterDamage.takenDamage(2500,mob);
        System.out.println("\n-"+2500+" for enemy\n Enemy's HP:"+mob.getHealth());
        System.out.println("\nThe dragon is dead! You won and something sent you back to the castle.");
        System.out.println("\nYou have won\n");
    }
}
