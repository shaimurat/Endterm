package Functions;

import Classes.Mobs;
import Classes.Player;

import java.util.Random;

public class IntelTest {
    static boolean IntelTest(Player player, Mobs mob){
        Random rand = new Random();
        int randNum= rand.nextInt(6);
        if(player.getIntelligence() > mob.getIntelligence()){
            return randNum <= 3; //if randomizer gets number less than 3, player will move first
        }
        else{return randNum >= 3;}//if randomizer gets number less than 3, enemy will move first
    }
}
