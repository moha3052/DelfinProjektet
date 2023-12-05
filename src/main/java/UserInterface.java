import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    DataBase dataBase = new DataBase();
    Kasseren kasseren = new Kasseren();
    Træner træner = new Træner();
    Formand formand = new Formand();

    public void printMenu() {
        System.out.println();
        System.out.println("Velkommen til Svømmeklubben Delfinen");
        System.out.println("Vælge imellem disse personer: ");
        System.out.println();
        System.out.println("1. Formand");
        System.out.println("2. Kassere");
        System.out.println("3. Træner");
        System.out.println("4. Afslut");
    }


    public void StartProgram() {
        boolean keepRunning = true;

        while (keepRunning) {
            printMenu();
            try {
                int valgAfMuligheder = scanner.nextInt();

                switch (valgAfMuligheder) {
                    case 1:
                        formand.handleFormand();
                        break;
                    case 2:
                        kasseren.handleKassere();
                        break;
                    case 3:
                        træner.handletræner();
                        break;
                    case 4:
                        keepRunning = false;
                        dataBase.gemMedlemlistTilCSV();
                        System.out.println("Programmet er afsluttet");
                        break;
                    default:
                        System.out.println("Ugyldigt valg. Prøv igen.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Ugyldig indtastning. Indtast venligst et heltal.");

                scanner.nextLine();
            }
        }
        scanner.close();
    }


}

