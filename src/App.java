import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner tangentbord = new Scanner(System.in);
        int val;
        boolean running = true;

        while (running) {
            System.out.println("1. Lediga Platser");
            System.out.println("2. Boka plats");
            System.out.println("0. Avsluta");

            val = tangentbord.nextInt();

            switch (val) {
                case 1:
                    val1(tangentbord);
                    break;
                case 2:
                    val2(tangentbord);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Ogiltigt val. Vänligen välj igen.");
            }
        }

        tangentbord.close();
    }

    public static void val1(Scanner scanner) {
        boolean val1Startar = true;

        while (val1Startar) {
            System.out.println("Lediga Platser");
            System.out.println("0 är en ledig plats");
            System.out.println("X är en upptagen plats");
            System.out.println("Tryck 0 för att gå tillbaka till huvudmenyn.");

            System.out.println("--------------");
            System.out.println("| 0 0   0 0 |");
            System.out.println("| 0 0   0 0 |");
            System.out.println("| 0 0   0 0 |");
            System.out.println("| 0 0   0 0 |");
            System.out.println("| 0 0   0 0 |");
            System.out.println("--------------");

            int input = scanner.nextInt();

            if (input == 0) {
                val1Startar = false;
            }
        }
    }

    public static void val2(Scanner scanner) 
    {
        System.out.println("Boka Platser");

        boolean val2startar = true;

        while (val2startar) 
        {
            
        }
    }
}
