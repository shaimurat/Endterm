public class Dragon extends Mobs implements getAbility{
    int ability; // 1:Fire
    public Dragon(){
        super();
    }
    public Dragon(int intelligence,int damage,int health, String name,int ability){
        super(intelligence, damage, health, name);
        setAbility(ability);
    }
    public void setAbility(int ability) {
        this.ability = ability;
    }

    @Override
    public String getAbilityName(){
        return "Fire";
     }

    @Override
    public String toString() {
        return super.toString()+" "+ getAbilityName();
    }
}
