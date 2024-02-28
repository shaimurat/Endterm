package Classes;

public class Mobs extends Character{
    private int saveHealth;
    private int damage;
    public Mobs(){
    }
    public Mobs(int intelligence,int damage,int health, String name){
        super(name,intelligence,health);
        setHealth(health);
        setIntelligence(intelligence);
        setDamage(damage);
        setName(name);
        setSaveHealth(health);
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return getName() + "-" + getHealth()+" health";
    }
}
