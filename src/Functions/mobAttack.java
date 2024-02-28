package Functions;

import Classes.Bandits;
import Classes.Player;

public class mobAttack {
    static boolean mobAttack(Player player, Bandits mob, int mob_hit){
        if(mob.ability()==2){
            mob_hit+=1;
        }
        CharacterDamage.takenDamage(mob.getDamage(),player);
        System.out.println("\n-" + mob.getDamage()+"\n You have:"+player.getHealth()+"hp");
        if (mob_hit==2){
            System.out.println("\nYou're bleeding: -100HP"+"\nYou have:"+player.getHealth()+"hp");
            CharacterDamage.takenDamage(100,player);
        }
        if (player.getHealth()<=0){
            CharacterRestoreHp.restoreHp(player);
            CharacterRestoreHp.restoreHp(mob);
            System.out.println("\nYou died,try again");
            return false;
        }
        return true;
    }
}
