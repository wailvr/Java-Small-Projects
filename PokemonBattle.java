import java.util.Scanner;

class Pokemon {

    String name;
    int level;
    int hp;
    String type;
    int attack;

    // Constructor
    Pokemon(String name, int level, int hp, String type, int attack) {

        this.name = name;
        this.level = level;
        this.hp = hp;
        this.type = type;
        this.attack = attack;
    }

    // Display information
    void displayInfo() {

        System.out.println("\n================================");
        System.out.println("         POKÉMON INFO");
        System.out.println("================================");

        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("HP: " + hp);
        System.out.println("Type: " + type);
        System.out.println("Attack: " + attack);
    }

    // Attack another Pokémon
    void attackPokemon(Pokemon opponent) {
        int damage = attack;

        if (opponent.hp <= 0){
                        System.out.print("-> "+ opponent.name + " has fainted!\n");
                    } else {
                        System.out.println("-> "+ opponent.name + " still has " + opponent.hp + " HP.");
                    }

        if (type == "Fire" && opponent.type == "Water"){
            damage = (int)(attack * 1.5);
            System.out.println("-> Bye Bye Water!!");
        } else if (type == "Water" && opponent.type == "Fire"){
            damage = (int)(attack * 1.5);
            System.out.println("-> ENNGKKK");
        } else {
            damage = attack;
            System.out.println("-> Normal Damage!");
        }

        opponent.hp = opponent.hp - damage;

        System.out.println("-> "+ name + " attacks " + opponent.name + "!");
    }
}


public class PokemonBattle {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Create Pokémon objects

        Pokemon pokemon1 = new Pokemon("Bulbasaur", 100, 300, "Grass", 67);

        Pokemon pokemon2 = new Pokemon("Charmander ", 100, 260, "Fire", 67);


        int choice = 0;

        while (choice != 7) {

            System.out.println("\n----------BATTLE MENU");

            System.out.println("Pick a Pokémon (1 for Luan) & (2 for Genesis)");
            System.out.println("Press 3 to make Pokémon 1 attack Pokémon 2");
            System.out.println("Press 4 to make Pokémon 2 attack Pokémon 1");
            System.out.println("Press 5 to View Pokémon Info");
            System.out.println("Press 6 to Check Pokémon Type");
            System.out.println("Press 7 to run");

            System.out.print("Choose an action: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("-> You picked Bulbasaur!");
                    break;

                case 2:
                    System.out.println("-> You picked Charmander!");

                case 3:

                    pokemon1.attackPokemon(pokemon2);
                    break;

                case 4:
                    pokemon2.attackPokemon(pokemon1);
                    break;

                case 5:

                    pokemon1.displayInfo();
                    pokemon2.displayInfo();

                    break;

                case 6:

                    System.out.println("-> "+ pokemon1.name + " type is " + pokemon1.type + "!");
                    System.out.println("-> "+ pokemon2.name + " type is " + pokemon2.type + "!");

                    break;

                case 7:

                    System.out.println(
                        "-> You ran away from the battle!"
                    );

                    break;

                default:

                    System.out.println(
                        "-> Invalid choice!"
                    );
                    continue;

            }
        }

        input.close();
    }
}