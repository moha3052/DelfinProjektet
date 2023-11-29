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
                printMenu();
                int valgAfMuligheder = scanner.nextInt();

                switch (valgAfMuligheder) {
                    case 1:
                        handleFormand();
                        break;
                    case 2:
                        handleKassere();
                        break;
                    case 3:
                        handletræner();
                        break;
                    case 4:
                        keepRunning = false;
                        dataBase.gemMedlemlistTilCSV();
                        System.out.println("Programmet er afsluttet");
                        break;
                    default:
                        System.out.println("Ugyldigt valg. Prøv igen.");
                }
            }
        }

        private void handleFormand(){
            boolean formandRunning = true;

            while (formandRunning){
                printFormand();
                int formandChoice = scanner.nextInt();

                switch (formandChoice){
                    case 1:
                        opretMedlem();
                        break;
                    case 2:
                        visMedlemmer();
                        break;
                    case 3:
                        redigerMedlem();
                    case 4:
                        formandRunning = false;
                        break;
                    default:
                        System.out.println("Ugyldigt valg. Prøv igen.");
                        break;
                }
            }
        }

        private void handleKassere(){
            boolean kassereRunning = true;

            while (kassereRunning){
                printKassere();
                int kassereChoice = scanner.nextInt();

                switch (kassereChoice){
                    case 3:
                        kassereRunning = false;
                        break;
                    default:
                        System.out.println("Ugyldigt valg. Prøv igen.");
                        break;
                }
            }
        }

        private void handletræner(){
            boolean trænerRunning = true;

            while (trænerRunning){
                printTræner();
                int trænerChoice = scanner.nextInt();

                switch (trænerChoice){
                    case 3:
                        trænerRunning = false;
                        break;
                    default:
                        System.out.println("Ugyldigt valg. Prøv igen.");
                        break;
                }
            }
        }


        public void printTræner() {
            System.out.println("Træner: ");
            System.out.println("_________________");
            System.out.println("3. Tilbage til menu");
            System.out.println();
        }

        public void printKassere() {
            System.out.println("Kassere: ");
            System.out.println("_________________");
            System.out.println("3. Tilbage til menu");
            System.out.println();
        }



        public void printFormand() {
            System.out.println("Formand: ");
            System.out.println("_________________");
            System.out.println("1. Opret medlemmere");
            System.out.println("2. Vis alle medlemmer");
            System.out.println("3. Redigere medlemmet udfra id");
            System.out.println("4. Tilbage til menu");
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

        private void opretMedlem() {
            System.out.println();
            System.out.println("Fulde navn");
            scanner.nextLine();
            String fullName = readString();


            System.out.println("_________________");

            boolean validDate = false;
            String birthdate = null;
            System.out.println("Fødselsdato (dd-MM-yyyy)");
            while (!validDate) {
                birthdate = scanner.nextLine();
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

                    LocalDate birthday = LocalDate.parse(birthdate, formatter);
                    LocalDate currentDate = LocalDate.now();
                    int age = Period.between(birthday, currentDate).getYears();

                    if (age < 18) {
                        System.out.println(fullName + " er " + age + " år gammel " + "og er derfor juniorsvømmer.");
                        validDate = true;
                    } else if (age >= 18 && age <= 59) {
                        System.out.println(fullName + " er " + age + " år gammel " + "og er derfor seniorsvømmer.");
                        validDate = true;
                    } else if (age >= 60) {
                        System.out.println(fullName + " er " + age + " år gammel " + "og er derfor pensionist.");
                        validDate = true;
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
            String adress = readString();
            System.out.println("_________________");


            System.out.println("Er medlemmet konkurrencesvømmer (ja/nej)?");
            String CompetitionSwimmer = readString();
            System.out.println("_________________");

            if (CompetitionSwimmer.equals("ja")) {

            } else if (CompetitionSwimmer.equals("nej")) {

            } else {
                System.out.println("Ugyldigt svar. Indtast enten 'ja' eller 'nej'.");
            }
            System.out.println(fullName + " " + "er blevet registreret i klubben");
            System.out.println();
            int idNumber = dataBase.getMedlemsListe().size() + 1;
            System.out.println("Dette " + idNumber + " er" + " er medlemmets ID nummer.");
            dataBase.tilføjMedlem(birthdate, fullName, gender, idNumber, email, phoneNumber, adress, CompetitionSwimmer);
            dataBase.gemOplysningerICSV(birthdate, fullName, gender, idNumber, email, phoneNumber, adress, CompetitionSwimmer);
        }

        private void visMedlemmer() {
            System.out.println("Her er medlemmerne i delfinsvømmeklubben: ");
            System.out.println();
            System.out.println("_________________");
            System.out.println();
            dataBase.printMedlemsList();
        }

        public void redigerMedlem() {
            System.out.println("Indtast medlemmets ID:");
            int id = readInt();
            Medlem medlem = dataBase.findMedlemById(id);

            if (medlem != null) {
                System.out.println("Vælg hvad du vil redigere:");
                System.out.println("1. Navn");
                System.out.println("2. Fødselsdato");
                System.out.println("3. Email");

                int valg = readInt();
                switch (valg) {
                    case 1:
                        System.out.println("Indtast nyt navn:");
                        String nytNavn = readString();
                        medlem.setFullName(nytNavn);
                        break;
                    case 2:
                        System.out.println("Indtast ny fødselsdag");
                        String nytFødselsdag = readString();
                        medlem.setBirthdate(nytFødselsdag);
                        break;
                    case 3:
                        System.out.println("Indtast ny E-mail");
                        String nytEmail = readString();
                        medlem.setEmail(nytEmail);
                        break;
                    default:
                        System.out.println("Ugyldigt valg.");
                }
                dataBase.opdaterMedlemIDatabase(medlem);
                System.out.println();
                System.out.println("Medlemmet er opdateret.");
            } else {
                System.out.println("Medlem med ID " + id + " blev ikke fundet.");
            }
        }


    }

