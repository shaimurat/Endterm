public class Player extends Character{
    private int up = 100;
    private int xp;
    private int level = 1;
    private int strength;

    public Player(){
    }
    public Player(String name, int intelligence, int strength){
        super(name,intelligence,1000);
        setStrength(strength);
        setIntelligence(intelligence);
        setSaveHealth(1000);
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getXp() {
        return xp;
    }

    public int getUp() {
        return up;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }
    @Override
    public String toString() {
        return  getName()+ " stats:\n" +
                "level: "+getLevel()+
                "\nintelligence: " + getIntelligence() +
                ",\nstrength: " + getStrength() +
                ",\nhealth: " + getHealth()+
                "\n" +(up-xp) + "xp needed to level up";
    }
}
