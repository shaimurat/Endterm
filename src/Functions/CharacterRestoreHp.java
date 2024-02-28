package Functions;

import Classes.Character;

public class CharacterRestoreHp {
    public static void restoreHp(Character character){
        character.setHealth(character.getSaveHealth());
    }
}

