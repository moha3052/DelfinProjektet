import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class UserInterface {

    public void StartProgram() {


        Scanner scanner = new Scanner(System.in);
        DataBase dataBase = new DataBase();
        boolean keepRunning = true;

        while (keepRunning) {
            printMenu();

            int choise = scanner.nextInt();

            switch (choise) {
                case 1:
                    boolean formandRunning = true;
                    while (formandRunning) {
                        printFormand();

                        int formandChoice = scanner.nextInt();

                        switch (FormandChoice) {

                            case 1:
                                System.out.println();
                                System.out.println("Fulde navn");
                                scanner.nextLine();
                                String fullName = readString();


                                System.out.println("_________________");

                                boolean validDate = false;
                                System.out.println("Fødselsdato (dd-MM-yyyy)");
                                String birthday = scanner.nextLine();
                                while (!validDate) {
                                    birthdate = scanner.nextLine();
                                    try {
                                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

                                        LocalDate birthdate = LocalDate.parse(birthday, formatter);
                                        LocalDate currentDate = LocalDate.now();
                                        int age = Period.between(birthday, currentDate).getYears();

                                        if (age < 18) {
                                            System.out.println(fullName + " er " + age + " år gammel " + "og er derfor juniorsvømmer.");
                                        } else {
                                            System.out.println(fullName + " er " + age + " år gammel " + "og er derfor seniorsvømmer.");
                                        }

                                    } catch (Exception e) {
                                        System.out.println("Der opstod en fejl. Prøv igen.");
                                    }
                                }
                                System.out.println("_________________");

                                System.out.println("Køn (Dreng/Mand/Pige/Kvinde)");
                                String gender = "";
                                while (!gender.equalsIgnoreCase("Dreng") && !gender.equalsIgnoreCase("Mand") &&
                                        !gender.equalsIgnoreCase("Pige") && !gender.equalsIgnoreCase("Kvinde")) {
                                    System.out.println("Køn (Dreng/Mand/Pige/Kvinde)");
                                    gender = scanner.nextLine();

                                    if (!gender.equalsIgnoreCase("Dreng") && !gender.equalsIgnoreCase("Mand") &&
                                            !gender.equalsIgnoreCase("Pige") && !gender.equalsIgnoreCase("Kvinde")) {
                                        System.out.println("Ugyldigt input. \nPrøv igen");
                                    }
                                    System.out.println("_________________");
                                }

                                System.out.println("E-mail");
                                String email = readString();
                                System.out.println("_________________");

                                System.out.println("Mobilnummer");
                                int phoneNumber = readInt();
                                System.out.println("_________________");

                                System.out.println("Adresse");
                                scanner.nextLine();
                                String adress = readString();
                                System.out.println("_________________");


                                System.out.println("Er medlemmet konkurrencesvømmer (ja/nej)?");
                                String CompetitionSwimmer = scanner.nextLine();

                                if (CompetitionSwimmer.equals("ja")) {

                                } else if (CompetitionSwimmer.equals("nej")) {

                                } else {
                                    System.out.println("Ugyldigt svar. Indtast enten 'ja' eller 'nej'.");
                                }
                                System.out.println("_________________");
                                System.out.println(fullName + " " + "er blevet registreret i klubben");
                                System.out.println();
                                int idNumber = dataBase.getMedlemsListe().size()+1;
                                System.out.println("Dette " + idNumber + " er" + " er medlemmets ID nummer.");
                                dataBase.tilføjMedlem(birthdate, fullName, gender, idNumber, email, phoneNumber, adress, CompetitionSwimmer);
                                dataBase.gemOplysningerICSV(birthdate, fullName, gender, idNumber, email, phoneNumber, adress, CompetitionSwimmer);
                                break;

                            case 2:
                                System.out.println("Her er medlemmerne i delfinsvømmeklubben: ");
                                System.out.println();
                                System.out.println("_________________");
                                System.out.println();
                                dataBase.printMedlemsList();
                                break;

                            case 3:
                                formandRunning = false;
                                break;

                        }

                    }
                    break;


                case 2:
                    boolean KassereRunning = true;
                    while (KassereRunning) {
                        System.out.println("Kassere: ");
                        System.out.println("_________________");
                        System.out.println("3. Tilbage til menu");
                        System.out.println();

                        int KassereChoise = scanner.nextInt();
                        switch (KassereChoise) {
                            case 3:
                                KassereRunning = false;
                        }
                    }
                break;


                case 3:
                    boolean TrænerRuning = true;
                    while (TrænerRuning) {
                        System.out.println("Træner: ");
                        System.out.println("_________________");
                        System.out.println("3. Tilbage til menu");
                        System.out.println();

                        int TrænerChoise = scanner.nextInt();
                        switch (TrænerChoise) {
                            case 3:
                                TrænerRuning = false;
                        }
                    }
                break;

                case 4:
                    keepRunning = false;
                    System.out.println("Programmet er afsluttet");
                    break;
            }

        }


    }

    public void printFormand() {
        System.out.println("Formand: ");
        System.out.println("_________________");
        System.out.println("1. Opret medlemmere");
        System.out.println("2. Vis alle medlemmer");
        System.out.println("3. Tilbage til menu");
    }

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

    private String readString() {
        String readString;
        do {
            readString = scanner.nextLine();
            if (readString.isEmpty()) {
                System.out.println("Ugyldigt input.");
            }
        }
        while (readString.isEmpty());
        return readString;
    }

    private int readInt() {
        while (!scanner.hasNextInt()) {
            String text = scanner.nextLine();
            System.out.println(text + " er ugyldigt input. Prøv igen.");
        }
        int result;
        result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }

    private double readDouble() {
        while (!scanner.hasNextDouble()) {
            String text = scanner.nextLine();
            System.out.println(text + " er ugyldigt input. Prøv igen.");
        }
        double result;
        result = scanner.nextDouble();
        scanner.nextLine();
        return result;
    }
}

