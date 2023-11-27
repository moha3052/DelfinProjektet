import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserInterface {

    public void StartProgram() {


        Scanner scanner = new Scanner(System.in);
        DataBase dataBase = new DataBase();
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println();
            System.out.println("Velkommen til Svømmeklubben Delfinen");
            System.out.println("Vælge imellem disse personer: ");
            System.out.println();
            System.out.println("1. Formand");
            System.out.println("2. Kassere");
            System.out.println("3. Træner");
            System.out.println("4. Afslut");

            int Choises = scanner.nextInt();

            switch (Choises) {
                case 1:
                    boolean formandRunning = true;
                    while (formandRunning) {
                        System.out.println("Formand: ");
                        System.out.println("_________________");
                        System.out.println("1. Opret medlemmere");
                        System.out.println("2. Vis alle medlemmer");
                        System.out.println("3. Tilbage til menu");

                        int FormandChoice = scanner.nextInt();

                        switch (FormandChoice) {

                            case 1:
                                System.out.println();
                                System.out.println("Fulde navn");
                                String fullName = scanner.nextLine();
                                scanner.nextLine();
                                System.out.println("_________________");

                                boolean validDate = false;
                                System.out.println("Fødselsdato (dd-MM-yyyy)");
                                String birthday = scanner.nextLine();
                                while (!validDate) {
                                    try {
                                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

                                        LocalDate birthdate = LocalDate.parse(birthday, formatter);
                                        LocalDate currentDate = LocalDate.now();
                                        int age = Period.between(birthdate, currentDate).getYears();

                                        if (age < 18) {
                                            System.out.println(fullName + " er " + age + " år gammel " + "og er derfor juniorsvømmer.");
                                        } else {
                                            System.out.println(fullName + " er " + age + " år gammel " + "og er derfor seniorsvømmer.");
                                        }
                                        validDate = true;
                                    } catch (Exception e) {
                                        System.out.println("Ugyldigt datoformat. Brug formatet dd-MM-yyyy. Prøv igen.");
                                    }
                                }
                                System.out.println("_________________");

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
                                String email = scanner.nextLine();
                                System.out.println("_________________");

                                System.out.println("ID Nummer");
                                int idNumber = scanner.nextInt();
                                System.out.println("_________________");

                                System.out.println("Mobilnummer");
                                int phoneNumber = scanner.nextInt();
                                System.out.println("_________________");

                                System.out.println("Adresse");
                                String adress = scanner.nextLine();
                                System.out.println("_________________");


                                System.out.println("Er medlemmet konkurrencesvømmer (ja/nej)?");
                                String CompetitionSwimmer = scanner.nextLine();

                                if (CompetitionSwimmer.equals("ja")) {

                                } else if (CompetitionSwimmer.equals("nej")) {

                                } else {
                                    System.out.println("Ugyldigt svar. Indtast enten 'ja' eller 'nej'.");
                                }
                                System.out.println("_________________");
                                System.out.println(birthday + " " + "er blevet registreret i klubben");
                                System.out.println();
                                fileHandler.gemOplysningerICSV(fullName, birthday, gender, idNumber, email, phoneNumber, adress, CompetitionSwimmer);
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
}
