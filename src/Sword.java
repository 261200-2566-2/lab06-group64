public class Sword {
    private int level;
    //Represents the level of the sword.
    private int damage;
    //Represents the damage dealt by the sword, calculated as level * 2.
    private int defense;
    //Represents the defensive capabilities of the sword, set to the level.
    private int weight;
    //Represents the weight of the sword, calculated as level * 4.


    public Sword(int level){
        this.level = level;
        this.damage = level * 2;
        this.weight = level *4;
        this.defense = level;
// It calculates and sets the initial values for damage, weight, and defense based on the provided level. //
    }

    public int getLevel() {
        //Returns the level of the sword.
        return level;
    }

    public int getDamage() {
        //Returns the damage dealt by the sword.
        return damage;
    }

    public int getDefense() {
        //Returns the defense of the sword.
        return defense;
    }

    public int getWeight() {
        //Returns the weight of the sword.
        return weight;
    }

    public void levelUp() {
        //Updates the damage, weight, and defense based on the new level.
        level++;
        damage = level *2;
        weight = level *2;
        defense = level;
    }
}
