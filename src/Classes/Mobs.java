package Classes;

public class Mobs extends Character{
    private int id;
    private static int idgen=1;
    private int saveHealth;
    private int damage;
    private int givenxp;
    public Mobs(){
        this.id = idgen++;
    }
    public Mobs(int intelligence,int damage,int health, String name, int givenxp){
        super(name,intelligence,health);
        this.id = idgen++;
        setHealth(health);
        setIntelligence(intelligence);
        setDamage(damage);
        setName(name);
        setSaveHealth(health);
        setGivenxp(givenxp);
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getDamage() {
        return damage;
    }

    public void setGivenxp(int givenxp) {
        this.givenxp = givenxp;
    }

    public int getGivenxp() {
        return givenxp;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return getId() + "." + getName() + "-" + getHealth()+" health";
    }
}
