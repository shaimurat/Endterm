package Classes;

public class Bandits extends Mobs implements getAbility {
    int ability; // 1:sword 2:katana - gives bleeding after two hits
    public Bandits(){
        super();
    }
    public Bandits(int intelligence,int damage,int health, String name,int ability){
        super(intelligence, damage, health, name);
        setAbility(ability);
    }
    public void setAbility(int ability) {
        this.ability = ability;
    }
    public int ability(){
        return ability;
    }

    @Override
    public String getAbilityName() {
        if (ability == 1){
            return "Sword";
        }
        else {
            return "Katana-bleeds opponent after two hits";
        }
    }

    @Override
    public String toString() {
        return super.toString()+" " + getAbilityName();
    }
}
