public class Characters {
    protected int level;
    protected int maxHP;
    protected int maxMana;
    protected int currentHP;
    protected int currentMana;
    protected int ATK;
    protected int DEF;
    protected int Speed;
    protected Sword equippedSword;
    protected Shield equippedShield;
    protected Accessory equippedRing;
    protected Accessory equippedNecklace;
    protected Accessory equippedBoots;

    public Characters(int level) {
        //Initializes the character with default attributes based on the provided level.
        this.level = level;
        this.maxHP = level * 10;
        this.maxMana = level * 5;
        this.currentHP = maxHP;
        this.currentMana = maxMana;
        this.ATK = level;
        this.DEF = level;
        this.Speed = 100;
    }

    public static class Warrior extends Characters {
        public Warrior(int level) {
            super(level);
            setCharacterTypeAttributes();
        }

        protected void setCharacterTypeAttributes() {
            //The method sets specific attributes for a warrior character
            this.ATK = 3 * level;
            this.maxHP = 8 * level;
            this.currentHP = maxHP;
            this.DEF = 8 * level;
            this.maxMana = 5 * level;
            this.currentMana = maxMana;
            this.Speed = 80;
        }
        public String getCharacterInfo(){
            return super.getCharacterInfo() + "\nType: Warrior";
        }
        //The getCharacterInfo method is also overridden in the Warrior class.
    }

    public static class Mage extends Characters {
        public Mage(int level) {
            super(level);
            setCharacterTypeAttributes();
        }

        protected void setCharacterTypeAttributes() {
            //The method sets specific attributes for a Mage character.
            this.ATK = 5 * level;
            this.maxHP = 5 * level;
            this.currentHP = maxHP;
            this.DEF = 3 * level;
            this.maxMana = 8 * level;
            this.currentMana = maxMana;
            this.Speed = 100;
        }

        public String getCharacterInfo() {
            return super.getCharacterInfo() + "\nType: Mage";
        }
        //The getCharacterInfo method is also overridden in the Mage class.
    }

    public static class Assassin extends Characters {
        public Assassin(int level) {
            super(level);
            setCharacterTypeAttributes();
        }

        protected void setCharacterTypeAttributes() {
            //The method sets specific attributes for an Assassin character.
            this.ATK = 8 * level;
            this.maxHP = 5 * level;
            this.currentHP = maxHP;
            this.DEF = 3 * level;
            this.maxMana = 5 * level;
            this.currentMana = maxMana;
            this.Speed = 120;
        }

        public String getCharacterInfo() {
            return super.getCharacterInfo() + "\nType: Assassin";
        }
        //The getCharacterInfo method is also overridden in the Assassin class.
    }


    protected int getLevel() {
        return level;
    }

    protected int getMaxHP() {
        return maxHP;
    }

    protected int getMaxMana() {
        return maxMana;
    }

    protected int getCurrentHP() {
        return currentHP;
    }

    protected int getCurrentMana() {
        return currentMana;
    }

    protected int getATK() {
        return ATK;
    }

    protected int getDEF() {
        return DEF;
    }

    protected int getSpeed() {
        return Speed;
    }

    protected Sword getEquippedSword() {
        return equippedSword;
    }

    public void equippedSword(Sword sword) {
        //Equips the character with a sword, updating attributes accordingly.
        equippedSword = sword;
        ATK += sword.getDamage();
        DEF += sword.getDefense();
        Speed -= sword.getWeight();
    }

    protected Shield getEquippedShield() {
        return equippedShield;
    }

    public void equippedShield(Shield shield) {
        //Equips the character with a shield, updating attributes accordingly.
        equippedShield = shield;
        ATK += shield.getDamage();
        DEF += shield.getDefend();
        Speed -= shield.getWeight();
    }

    public void equipRing(Accessory.Ring ring){
        //Equips the character with a ring accessory, applying modifiers.
        equippedRing = ring;
        applyAccessoryModifiers(ring);
    }

    public void equipNecklace(Accessory.Necklace necklace) {
        //Equips the character with a necklace accessory, applying modifiers.
        equippedNecklace = necklace;
        applyAccessoryModifiers(necklace);
    }

    public void equipBoots(Accessory.Boots boots) {
        //Equips the character with boots accessory, applying modifiers.
        equippedBoots = boots;
        applyAccessoryModifiers(boots);
    }

    private void applyAccessoryModifiers(Accessory accessory){
        //Applies the modifiers of a given accessory.
        ATK += (int) (ATK * accessory.getATKModifier());
        DEF += (int) (DEF * accessory.getDEFModifier());
        maxHP += (int) (maxHP * accessory.getHpModifier());
        maxMana += (int) (maxMana * accessory.getManaModifier());
        Speed += (int) accessory.getSpeedModifier();
    }

    private void removeAccessoryModifiers(Accessory accessory) {
        //Removes the modifiers of a given accessory.
        ATK -= (int) (ATK * accessory.getATKModifier());
        DEF -= (int) (DEF * accessory.getDEFModifier());
        maxHP -= (int) (maxHP * accessory.getHpModifier());
        maxMana -= (int) (maxMana * accessory.getManaModifier());
        Speed -= (int) accessory.getSpeedModifier();
    }

    public void unequipRing() {
        //Unequipped the ring accessory, removing modifiers.
        if (equippedRing != null) {
            removeAccessoryModifiers(equippedRing);
            equippedRing = null;
        }
    }

    public void unequipNecklace() {
        //Unequipped the necklace accessory, removing modifiers.
        if (equippedNecklace != null) {
            removeAccessoryModifiers(equippedNecklace);
            equippedNecklace = null;
        }
    }

    public void unequipBoots() {
        //Unequipped the boots accessory, removing modifiers.
        if (equippedBoots != null) {
            removeAccessoryModifiers(equippedBoots);
            equippedBoots = null;
        }
    }

    public void attack(Characters target) {
        //
        //Can attack other characters, considering equipped weapons and defense.
        int playerATK = ATK;
        int damage = 0;
        int defense = DEF;

        if (equippedSword != null) {
            playerATK += equippedSword.getDamage();
        } else if (equippedShield != null) {
            playerATK += equippedShield.getDamage();
        }

        if (playerATK > defense) {
            damage = playerATK - defense;
        }

        currentHP -= damage;
        reduceMana(20);
        target.takeDamage(Math.max(0, damage - defense));
    }

    private void reduceMana(int amount) {
        //Reduces the character's mana points by a specified amount.
        currentMana -= 20;
        if (currentMana <= 0) {
            currentMana = 0;
            System.out.println("Mana: " + currentMana);
        }
    }

    public void takeDamage(int damage) {
        //Tracks health points
        int baseDefense = level;
        int effectiveDefense;

        if (equippedShield != null) {
            effectiveDefense = equippedShield.getDefend() + (baseDefense);
        } else {
            effectiveDefense = baseDefense;
        }

        damage = Math.max(0, damage - effectiveDefense);

        currentHP -= damage;

        if (currentHP <= 0) {
            System.out.println("YOU ARE DEAD!!!");
        } else {
            System.out.println("HP: " + currentHP + "/" + maxHP + "  Mana: " + currentMana + "/" + maxMana);
        }
    }

    public String getCharacterInfo() {
        //Returns a formatted string with the character's information.
        return String.format("Level: %d\nHP: %d/%d\nMana: %d/%d\nATK: %d\nDEF: %d\nSpeed: %d",
                level, currentHP, maxHP, currentMana, maxMana, ATK, DEF, Speed);
    }
}
