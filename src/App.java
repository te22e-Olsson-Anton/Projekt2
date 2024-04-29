import java.util.Scanner;

public class App {
    static int[][] platser = new int[5][4];
    static String[][] bokadePassagerare = new String[5][4];

    public static void main(String[] args) throws Exception {
        Scanner tangentbord = new Scanner(System.in);
        int val;
        boolean running = true;

        while (running) {
            
            System.out.println("1. Lediga Platser");
            System.out.println("2. Boka Plats");
            System.out.println("3. Kolla Total Kostnad");
            System.out.println("0. Avsluta");
            System.out.println(" ");
            System.out.println("Pris per biljett är 299.90 kr");

            val = tangentbord.nextInt();

            switch (val) {
                case 1:
                    val1(tangentbord);
                    break;
                case 2:
                    laggaTillPassagerare(tangentbord);
                    break;
                case 3:
                    kollaTotalKostnad();
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

            System.out.println("-----------------");
            for (int k = 0; k < 20; k++) {
                int i = k / 4;
                int j = k % 4;
                if (platser[i][j] == 0) {
                    System.out.print("| 0 ");
                } else {
                    System.out.print("| X ");
                }
                if (j == 3) {
                    System.out.println("|");
                }
            }
            System.out.println("-----------------");
            

            int input = scanner.nextInt();

            if (input == 0) {
                val1Startar = false;
            }
        }
    }

    static void laggaTillPassagerare(Scanner scanner) {
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
            System.out.print("Ange passagerarens personnummer ÅÅÅÅMMDD: ");
            String personnummer = scanner.next(); 
            platser[rad - 1][plats - 1] = 1;
            bokadePassagerare[rad - 1][plats - 1] = personnummer;
            System.out.println("Passageraren med personnummer " + personnummer + " har bokats på plats " + rad + "-" + plats);
        }
    }



    static void kollaTotalKostnad() {
        int totalBokningar = 0;
        double biljettPris = 299.90;
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                if (bokadePassagerare[i][j] != null) {
                    totalBokningar++;
                }
            }
        }

        
        double totalKostnad = totalBokningar * biljettPris;

        
        System.out.println("Den totala kostnaden för alla bokade platser är: " + totalKostnad + " kr");
    }

}       