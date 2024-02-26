public class Character extends CharacterFunctions{
    private String name;
    private int health;
    private int intelligence;
    private int saveHealth;
    public Character(){
    }
    public Character(String name, int intelligence, int health){
        setName(name);
        setIntelligence(intelligence);
        setHealth(health);
        }
    public String getName() {
        return name;
    }
    public void setSaveHealth(int saveHealth) {
        this.saveHealth = saveHealth;
    }

    public int getSaveHealth() {
        return saveHealth;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public int getHealth() {
        return health;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    public int getIntelligence() {
        return intelligence;
    }
    public void restoreHp(){
        setHealth(getSaveHealth());
    }
    public void takenDamage(int damage) {
        setHealth(getHealth()-damage);
    }
}
