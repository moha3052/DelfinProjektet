import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Formand {

    Scanner scanner = new Scanner(System.in);
    DataBase dataBase = new DataBase();


    public void printFormand() {
        System.out.println("Formand: ");
        System.out.println("_________________");
        System.out.println("1. Opret medlemmere");
        System.out.println("2. Vis alle medlemmer");
        System.out.println("3. Redigere medlemmet udfra id");
        System.out.println("4. Tilbage til menu");
    }


    public void handleFormand() {
        boolean formandRunning = true;

        while (formandRunning) {
            printFormand();
            int formandChoice = scanner.nextInt();


            switch (formandChoice) {
                case 1:
                    opretMedlem();
                    break;
                case 2:
                    visMedlemmer();
                    break;
                case 3:
                    redigerMedlem();
                    break;
                case 4:
                    formandRunning = false;
                    break;
                default:
                    System.out.println("Ugyldigt valg. Prøv igen.");
                    break;
            }
        }
    }


    private void opretMedlem() {
        System.out.println();
        System.out.println("Fulde navn");
        scanner.nextLine();
        String fullName = dataBase.readString();


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

                if (age <= 17) {
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

        String email;
        while (true) {
            System.out.println("E-mail");
            email = scanner.nextLine();

            if (isValidEmail(email)) {
                break;
            } else {
                System.out.println("Ugyldig e-mail, prøv igen.");
            }
        }

        System.out.println("_________________");

        System.out.println("Mobilnummer");
        int phoneNumber = dataBase.readInt();
        System.out.println("_________________");

        System.out.println("Adresse");
        String adress = dataBase.readString();
        System.out.println("_________________");


        System.out.println("Er medlemmet konkurrencesvømmer (ja/nej)?");
        String CompetitionSwimmer = dataBase.readString();
        System.out.println("_________________");

        if (CompetitionSwimmer.equals("ja")) {

        } else if (CompetitionSwimmer.equals("nej")) {

        } else {
            System.out.println("Ugyldigt svar. Indtast enten 'ja' eller 'nej'.");
        }

        System.out.println();
        System.out.println(fullName + " " + "er blevet registreret i klubben");
        System.out.println();
        int idNumber = dataBase.getMedlemsListe().size() + 1;
        System.out.println("Medlemmets ID nummer." + idNumber );
        System.out.println();
        dataBase.tilføjMedlemTilArray(new Medlem(birthdate, fullName, gender, idNumber, email, phoneNumber, adress, CompetitionSwimmer));
        dataBase.gemMedlemlistTilCSV();
    }

    public void visMedlemmer() {
        System.out.println("Her er medlemmerne i delfinsvømmeklubben: ");
        System.out.println();
        System.out.println("_________________");
        System.out.println();
        dataBase.printMedlemsList();
    }

    public void redigerMedlem() {
        System.out.println("Indtast medlemmets ID:");
        int id = dataBase.readInt();
        Medlem medlem = dataBase.findMedlemById(id);

        if (medlem != null) {
            System.out.println("Vælg hvad du vil redigere:");
            System.out.println("1. Navn");
            System.out.println("2. Fødselsdato");
            System.out.println("3. Email");
            System.out.println("4. Indtast nyt mobilnummer");
            System.out.println("5. Er medlemmets aktivitetsstatus ændret?");
            System.out.println("6. Er medlemmets stadigvæk aktiv?");

            int valg = dataBase.readInt();
            switch (valg) {
                case 1:
                    System.out.println("Indtast nyt navn:");
                    String nytNavn = dataBase.readString();
                    medlem.setFullName(nytNavn);
                    break;
                case 2:
                    System.out.println("Indtast ny fødselsdag");
                    String nytFødselsdag = dataBase.readString();
                    medlem.setBirthdate(nytFødselsdag);
                    break;
                case 3:
                    System.out.println("Indtast ny E-mail");
                    String nytEmail = dataBase.readString();
                    medlem.setEmail(nytEmail);
                    break;
                case 4:
                    System.out.println("Indtast nyt mobilnummer");
                    int nytPhonenumber = dataBase.readInt();
                    medlem.setPhoneNumber(nytPhonenumber);
                    break;
                case 5:
                    System.out.println("Er medlemmets aktivitetsstatus ændret?");
                    String newCompetitionSwimmer = dataBase.readString();
                    medlem.setCompetitionSwimmer(newCompetitionSwimmer);
                    break;

                case 6:
                    System.out.println("Er medlemmets stadigvæk aktiv?");
                    boolean passiv = dataBase.readBoolean();
                    medlem.setisaktiv(passiv);
                default:
                    System.out.println("Ugyldigt valg.");
            }
            dataBase.opdaterMedlemIDatabase(medlem);
            System.out.println();
            System.out.println("Medlemmet er opdateret.");
            System.out.println();
        } else {
            System.out.println("Medlem med ID " + id + " blev ikke fundet.");
        }
    }



    public static boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }
}
