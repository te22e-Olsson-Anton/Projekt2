import java.util.Scanner;

public class App {
    static int[][] platser = new int[5][4];

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
                    laggaTillPassagerare();
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
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 4; j++) {
                    if (platser[i][j] == 0) {
                        System.out.print("| 0 ");
                    } else {
                        System.out.print("| X ");
                    }
                }
                System.out.println("|");
            }
            System.out.println("--------------");

            int input = scanner.nextInt();

            if (input == 0) {
                val1Startar = false;
            }
        }
    }

    static void laggaTillPassagerare() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ange rad för passageraren att boka (1-5): ");
        int rad = scanner.nextInt();
        System.out.print("Ange platsnummer för passageraren att boka (1-4): ");
        int plats = scanner.nextInt();

        if (rad < 1 || rad > 5 || plats < 1 || plats > 4) {
            System.out.println("Ogiltig rad eller platsnummer. Vänligen ange ett radnummer mellan 1 och 5 och ett platsnummer mellan 1 och 4.");
            return;
        }
        
        if (platser[rad - 1][plats - 1] != 0) {
            System.out.println("Platsen är redan bokad.");
        } else {
            platser[rad - 1][plats - 1] = 1;
            System.out.println("Passageraren har bokats på plats " + rad + "-" + plats);
        }
    }
}
