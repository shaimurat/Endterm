package Classes;

public class Weapon implements getAbility {
    private String name;
    private int damage;
    private int ability; //ability 1: Fire damage, ability 2: Freezing ability, ability 0: nothing
    public Weapon(){
    }
    public Weapon(String name, int damage,int ability){
        this();
        setAbility(ability);
        setDamage(damage);
        setName(name);
    }
    public void setAbility(int ability) {
        this.ability = ability;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAbility() {
        return ability;
    }
    @Override
    public String getAbilityName(){
        if(ability==0){
            return "No Ability";
        } else if (ability == 1) {
            return "Fire Damage";
        }
        else {
            return "Freezing ability";
        }
    }
    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName() +
                ", damage=" + getDamage() + " " + getAbilityName();
    }
}
