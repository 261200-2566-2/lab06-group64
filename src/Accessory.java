public class Accessory {
    protected String name;
    //Represents the name of the accessory.
    protected double ATKModifier;
    //Modifier for Attack (ATK) attribute.
    protected double DEFModifier;
    //Modifier for Defense (DEF) attribute.
    protected double ManaModifier;
    //Modifier for Mana attribute.
    protected double HpModifier;
    //Modifier for HP attribute.
    protected double SpeedModifier;
    //Modifier for Speed attribute.

    public Accessory(String name, double ATKModifier, double DEFModifier, double ManaModifier, double HpModifier, double SpeedModifier){
        //The constructor initializes an Accessory object with the specified modifiers for ATK, DEF, Mana, HP, and Speed.
        this.name = name;
        this.ATKModifier = ATKModifier;
        this.DEFModifier =DEFModifier;
        this.ManaModifier = ManaModifier;
        this.HpModifier = HpModifier;
        this.SpeedModifier = SpeedModifier;
    }

    public String getName() {
        return name;
    }

    public double getATKModifier() {
        return ATKModifier;
    }

    public double getDEFModifier() {
        return DEFModifier;
    }

    public double getHpModifier() {
        return HpModifier;
    }

    public double getManaModifier() {
        return ManaModifier;
    }

    public double getSpeedModifier() {
        return SpeedModifier;
    }

    public static class Ring extends Accessory{
        //specific default of ring
        public Ring(){
            super("Ring",0.2 ,0.1,-0.05,0,0);
        }
    }

    public static class Necklace extends Accessory{
        //specific default of necklace
        public Necklace(){
            super("Necklace",0,0.1,0,0.2,-20);
        }
    }

    public static class Boots extends Accessory{
        //specific default of boots
        public Boots(){
            super("Boots",0,0.1,0,-0.05,20);
        }
    }

}
