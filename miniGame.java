import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class miniGame {

    static class Room {
        String name;
        String description;
        Map<String, Integer> exits = new HashMap<>();

        Room(String name, String description) {
            this.name = name;
            this.description = description;
        }
    }

    public static void main(String[] args) {
        // Create rooms
        Room[] rooms = new Room[11];
        rooms[1] = new Room("Beginning",
                "You are standing at the end of a road before a dark and dank cave. The forest is covering the road lending a dark and spooky aspect to the road. You hear a low wailing that seems to be coming from the cave.");
        rooms[2] = new Room("Entrance",
                "You have entered a dark, low cave that seems to lead to a slightly larger cavern to the west. Strangely you see a faint glow coming from the east.");
        rooms[3] = new Room("Cavern",
                "You enter a large cavern. You are surprised to find that the walls of the cave are glowing so you have no problem seeing the large stalactites that have formed. To the south you hear the sound of rushing water. To the north you hear strange sounds that sound like someone with a broken heart. You see as set of stairs at the west end of the cavern.");
        rooms[4] = new Room("Spooky Cave",
                "You have entered a dark twisting, tunnel that seems to wind around the Cavern. The low wailing you heard before has risen to a screech that is making your hair stand on end. You see a sign that says 'Proceed at your own risk. Anyone entering this area will be eaten.'");
        rooms[5] = new Room("Rushing River",
                "You have entered a wet, slippery cave. You are standing on a narrow ledge. As you slip toward the rushing river, you think, 'I shouldn't be here.'");
        rooms[6] = new Room("Second Level",
                "At the bottom of the stairs you see a skeleton from a previous adventurer. You really wish you had some good weapons.");
        rooms[7] = new Room("Dead End",
                "As you enter this dark and forbidding cavern you hear the roar of some enormous monster. You decide that leaving this place would be a great idea.");
        rooms[8] = new Room("Cavern of Bones", "This room is covered with the bones of previous adventurers.");
        rooms[9] = new Room("Impending Doom",
                "You feel very frightened by this room. Perhaps you need to leave quickly.");
        rooms[10] = new Room("Finish", "Congratulations!!! You have completed the journey through my maze");

        // Define exits
        rooms[1].exits.put("WEST", 2);
        rooms[2].exits.put("EAST", 1);
        rooms[2].exits.put("WEST", 3);
        rooms[3].exits.put("EAST", 2);
        rooms[3].exits.put("NORTH", 4);
        rooms[3].exits.put("DOWN", 6);
        rooms[4].exits.put("SOUTH", 3);
        rooms[4].exits.put("NORTH", 5);
        rooms[5].exits.put("SOUTH", 3);
        rooms[6].exits.put("UP", 3);
        rooms[6].exits.put("NORTH", 7);
        rooms[6].exits.put("SOUTH", 8);
        rooms[6].exits.put("WEST", 9);
        rooms[7].exits.put("SOUTH", 6);
        rooms[8].exits.put("NORTH", 6);
        rooms[9].exits.put("EAST", 6);
        rooms[9].exits.put("NORTH", 10);

        boolean[] visited = new boolean[11]; // To keep track of visited rooms
        int currentRoom = 1;
        visited[currentRoom] = true;

        Scanner scanner = new Scanner(System.in);

        // System.out.println("Welcome to the Text Adventure Game!");

        while (currentRoom != 10) {
            Room room = rooms[currentRoom];
            System.out.println(room.name);
            System.out.println(room.description);
            System.out.print("You can exit: \n");
            for (String exit : room.exits.keySet()) {
                System.out.print(exit + " ");
            }
            System.out.println();
            System.out.print("Enter direction (or type 'X' to exit): ");
            String input = scanner.nextLine().toUpperCase();
            if (input.equals("X")) {
                System.out.println("Game over!!!!");
                break;
            }
            if (room.exits.containsKey(input)) {
                int nextRoom = room.exits.get(input);
                if (!visited[nextRoom]) {
                    currentRoom = nextRoom;
                    visited[currentRoom] = true;
                } else {
                    System.out.println("This room has been visited already.");
                }
            } else {
                System.out.println("Invalid entry");
            }
        }

        scanner.close();
    }
}
