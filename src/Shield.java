public class Shield {
    private int level;
    //Represents the level of the shield.
    private int damage;
    //Represents the damage dealt by the shield, set to the level.
    private int defend;
    //Represents the defensive capabilities of the shield, calculated as level * 3.
    private int weight;
    //Represents the weight of the shield, calculated as level * 5.

    public Shield(int level){
        //It sets the initial values for damage, defend, and weight based on the provided level.
        this.level = level;
        this.damage = level;
        this.defend = level *3;
        this.weight = level *5;
    }

    public int getLevel() {
        return level;
    }
    //Returns the level of the shield.

    public int getDamage() {
        return damage;
    }
    // Returns the damage dealt by the shield.

    public int getDefend(){
        return defend;
    }
    //Returns the defense provided by the shield.

    public int getWeight() {
        return weight;
    }
    //Returns the weight of the shield.

    public void levelup(){
        //Updates the damage, defend, and weight based on the new level.
        level++;
        damage = level;
        defend = level*3;
        weight = level *2;
    }
}
