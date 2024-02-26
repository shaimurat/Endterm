public class CharacterFunctions {
    public void restoreHp(Character character){
        character.setHealth(character.getSaveHealth());
    }
    public void takenDamage(int damage,Character character) {
        character.setHealth(character.getHealth()-damage);
    }
}
