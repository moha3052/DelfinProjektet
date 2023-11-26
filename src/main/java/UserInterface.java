import javax.sound.sampled.Control;
import javax.sound.sampled.FloatControl;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    public void StartProgram() {


        Scanner scanner = new Scanner(System.in);
        Input input = new Input();
        DataBase dataBase = new DataBase();
        FileHandler fileHandler = new FileHandler();

        boolean keepRunning = true;

        while (keepRunning) {

            System.out.println("Velkommen til Svømmeklubben Delfinen");
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
                                System.out.println("Fulde navn");
                                String fullName = input.inputString();
                                System.out.println("_________________");

                                boolean validDate = false;
                                System.out.println("Fødselsdato (dd-MM-yyyy)");
                                String birthday = input.inputString();
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
                                    gender = input.inputString();

                                    if (!gender.equalsIgnoreCase("Dreng") && !gender.equalsIgnoreCase("Mand") &&
                                            !gender.equalsIgnoreCase("Pige") && !gender.equalsIgnoreCase("Kvinde")) {
                                        System.out.println("Ugyldigt input. \nPrøv igen");
                                    }
                                    System.out.println("_________________");
                                }


                                System.out.println("E-mail");
                                String email = input.inputString();
                                System.out.println("_________________");

                                System.out.println("ID Nummer");
                                int idNumber = input.inputInt();
                                System.out.println("_________________");

                                System.out.println("Mobilnummer");
                                int phoneNumber = input.inputInt();
                                System.out.println("+45" + " " + phoneNumber);
                                System.out.println("_________________");

                                System.out.println("Adresse");
                                String adress = input.inputString();
                                System.out.println("_________________");


                                System.out.println("Er medlemmet konkurrencesvømmer (ja/nej)?");
                                String CompetitionSwimmer = input.inputString();

                                if (CompetitionSwimmer.equals("ja")) {

                                } else if (CompetitionSwimmer.equals("nej")) {

                                } else {
                                    System.out.println("Ugyldigt svar. Indtast enten 'ja' eller 'nej'.");
                                }
                                System.out.println("_________________");
                                System.out.println(fullName + " " + "er blevet registreret i klubben");
                                fileHandler.gemOplysningerICSV(fullName, birthday, gender, idNumber, email, phoneNumber, adress, CompetitionSwimmer);
                                break;

                            case 2:
                                System.out.println("Her er medlemmerne i delfinsvømmeklubben: ");
                                System.out.println(dataBase.getMedlemsArrayList());
                                System.out.println("_________________");
                                System.out.println();
                                break;

                            case 3:
                                formandRunning = false;
                                break;
                        }
                    }
                case 2:
                    System.out.println("Kassere: ");
                    System.out.println("_________________");
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Træner: ");
                    System.out.println("_________________");
                    System.out.println();
                    break;

                case 4:
                    keepRunning = false;
                    System.out.println("Programmet er afsluttet");
                    break;
            }
        }
    }
}