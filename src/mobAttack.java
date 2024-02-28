public class mobAttack {
    static boolean mobAttack(Player player, Bandits mob, int mob_hit){
        if(mob.ability()==2){
            mob_hit+=1;
        }
        player.takenDamage(mob.getDamage(),player);
        System.out.println("\n-" + mob.getDamage()+"\n You have:"+player.getHealth()+"hp");
        if (mob_hit==2){
            System.out.println("\nYou're bleeding: -100HP"+"\nYou have:"+player.getHealth()+"hp");
            player.takenDamage(100,player);
        }
        if (player.getHealth()<=0){
            player.restoreHp(player);
            mob.restoreHp(player);
            System.out.println("\nYou died,try again");
            return false;
        }
        return true;
    }
}
