import java.util.Random;
import java.util.Scanner;


public class Main {

    static Characters player = new Characters(1);
    //The program starts by creating a player character.
    static Characters enemy;
    //Creating an enemy character.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

//        TEST Level up.
//        int BaseATK = 0; //calculator state.
//        int ATK = 0;
//        int def = 0;
//        System.out.println("what your level: ");
//        int level = scanner.nextInt();
//        System.out.println("what sword level: ");
//        int Swordlevel = scanner.nextInt();
//        System.out.println("what shiled level: ");
//        int Shieldlevel = scanner.nextInt();
//
//        for(int i = 1 ; i <= level ;i++) {
//            BaseATK = i;
//            ATK = (Swordlevel * 2) + (BaseATK *2 );
//            def = (Shieldlevel * 3) + (BaseATK);
//            System.out.println("BaseAtk: " +BaseATK +"ATK: " + ATK +"def: " + def);
//        }

        System.out.println("What your name?");
        String Name = scanner.nextLine();
        //The program prompts the user to input their name
        System.out.println("Choose your character type: ");
        System.out.println("1) Warrior");
        System.out.println("2) Mage");
        System.out.println("3) Assassin");
        int type = scanner.nextInt();
        //choose a character type.
        Characters SelectedPlayer;

        switch (type){
            case 1:
                SelectedPlayer = new Characters.Warrior(1);
                break;
            case 2:
                SelectedPlayer = new Characters.Mage(1);
                break;
            case 3:
                SelectedPlayer = new Characters.Assassin(1);
                break;
            default:
                System.out.println("Invalid choice. Exiting the game");
                return;
        }

        System.out.println("player: "+ Name);
        System.out.println(SelectedPlayer.getCharacterInfo());


        System.out.println("Do you want to equip a Sword (1), Shield (2), or Nothing (3)?");
        int choice = scanner.nextInt();
        //The user is prompted to choose to chosen equipment is then applied to the player character.

        switch (choice) {
            case 1 :
                System.out.println("Equipping Sword!!!");
                Sword sword = new Sword(1);
                // create Weapon Sword level 1.
                SelectedPlayer.equippedSword(sword);
                //EquippedSword.
                System.out.println(SelectedPlayer.getCharacterInfo());

                break;
            case 2:
                System.out.println("Equipping Shield!!!");
                Shield shield = new Shield(1);
                //create weapon Shield level 1.
                SelectedPlayer.equippedShield(shield);
                //EquippedShield.
                System.out.println(SelectedPlayer.getCharacterInfo());

                break;
            case 3:
                System.out.println("You chose not to equip anything.");

                break;
            default:
                System.out.println("Invalid choice. You chose not to equip anything.");

        }

        System.out.println("Do you want to equip an accessory?");
        //Asked user if they want to equip an accessory.
        //If chosen, the program creates an instance of the selected accessory type and applies it to the player character.
        System.out.println("1) Ring");
        System.out.println("2) Necklace");
        System.out.println("3) Boots");
        System.out.println("4) No, I don't want to equip anything");
        int accessoryChoice = scanner.nextInt();

        switch (accessoryChoice) {
            case 1:
                Accessory.Ring ring = new Accessory.Ring();
                SelectedPlayer.equipRing(ring);
                break;
            case 2:
                Accessory.Necklace necklace = new Accessory.Necklace();
                SelectedPlayer.equipNecklace(necklace);
                break;
            case 3:
                Accessory.Boots boots = new Accessory.Boots();
                SelectedPlayer.equipBoots(boots);
                break;
            default:
                System.out.println("You chose not to equip anything.");
        }

        System.out.println("Player after equipping accessory: " + SelectedPlayer.getCharacterInfo());
        //The program displays information about the player character, including equipped items and accessories.

        int enemyLevel = random.nextInt(2) +SelectedPlayer.level;
        int enemyWeaponType = random.nextInt(2);
        enemy = new Characters(enemyLevel);
        //An enemy character is created with a random level and weapon type.

        switch (enemyWeaponType) {
            case 1:
                System.out.println("\nEnemy has Sword (Level " + enemyLevel + ")");
                Sword enemySword = new Sword(enemyLevel);
                enemy.equippedSword(enemySword);
                break;
            case 2:
                System.out.println("\nEnemy has Shield (Level " + enemyLevel + ")");
                Shield enemyShield = new Shield(enemyLevel);
                enemy.equippedShield(enemyShield);
                break;
            default:
                System.out.println("\nEnemy has no weapon.");
        }

        System.out.println("\n          Enemy Level: " + enemyLevel +
        "\nEnemy HP: " + enemy.getCurrentHP() + "/" + enemy.getMaxHP()
        +"   Enemy Mana: " + enemy.getCurrentMana() + "/" + enemy.getMaxMana()
        +"\nEnemy ATK: " + enemy.getATK()
        +"   Enemy DEF: " + enemy.getDEF()
        +"   Enemy Speed: " + enemy.getSpeed());
        //The program displays information about the enemy character and enemy weapon.
    }
}
