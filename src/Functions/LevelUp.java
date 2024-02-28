package Functions;

import Classes.Player;

public class LevelUp {
    static void LevelUp(Player player, int userInp){
        if(userInp==1){
            player.setIntelligence(player.getIntelligence()+1);
            System.out.println("\nYour intelligence has been upgraded");
        }
        else if (userInp==2) {
            player.setStrength(player.getStrength()+1);
            System.out.println("\nYour strength has been upgraded");
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
}
