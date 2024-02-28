package Functions;

import Classes.Character;

public class CharacterDamage{
        public static void takenDamage(int damage, Character character) {
            character.setHealth(character.getHealth()-damage);
        }
    }

