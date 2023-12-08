package View;

import Database.DataBase;
import Logik.KasserLogik;
import Model.Medlem;
import Model.Resultater;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    DataBase dataBase = new DataBase();
    KasserLogik kasseren = new KasserLogik();





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
            } catch (java.util.InputMismatchException e) {
                System.out.println("Ugyldig indtastning. Indtast venligst et heltal.");

                scanner.nextLine();
            }
        }
        scanner.close();
    }


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

    //==============================================================================
//==============================Formand==========================================
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

        System.out.println("Køn (Mand/Kvinde)");
        String gender = "";
        while (!gender.equalsIgnoreCase("Mand") && !gender.equalsIgnoreCase("Kvinde")) {
            gender = scanner.nextLine();

            if (!gender.equalsIgnoreCase("Mand") && !gender.equalsIgnoreCase("Kvinde")) {
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


        System.out.println();
        System.out.println(fullName + " " + "er blevet registreret i klubben");
        System.out.println();
        int idNumber = dataBase.getMedlemsListe().size() + 1;
        System.out.println("Medlemmets ID nummer er " + idNumber );
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
        visMedlemmer();
        System.out.println("Indtast medlemmets ID:");
        int id = readInt();
        Medlem medlem = dataBase.findMedlemById(id);

        if (medlem != null) {
            System.out.println("Vælg hvad du vil redigere:");
            System.out.println("1. Navn");
            System.out.println("2. Fødselsdato");
            System.out.println("3. Email");
            System.out.println("4. Indtast nyt mobilnummer");
            System.out.println("5. Er medlemmets aktivitetsstatus ændret?");
            System.out.println("6. Hvor meget har medlemmet betalt?");
            System.out.println("7. Er medlemmets stadigvæk aktiv?");

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
                case 4:
                    System.out.println("Indtast nyt mobilnummer");
                    int nytPhonenumber = readInt();
                    medlem.setPhoneNumber(nytPhonenumber);
                    break;
                case 5:
                    System.out.println("Er medlemmets aktivitetsstatus ændret? tast, 'Ja' eller 'nej'");
                    String newCompetitionSwimmer = readString();
                    medlem.setCompetitionSwimmer(newCompetitionSwimmer);
                    break;
                case 6:
                    System.out.println("Hvor meget har medlemmet betalt?");
                    int nytRestance = readInt();
                    medlem.setBeløbBetalt(nytRestance);
                    break;

                case 7:
                    System.out.println("Er medlemmets stadig aktiv? tast, 'Ja' eller 'nej'");
                    boolean passiv = readBoolean();
                    medlem.setisaktiv(passiv);
                default:
                    System.out.println("Ugyldigt valg.");
            }
            dataBase.opdaterMedlemIDatabase(medlem);
            System.out.println();
            System.out.println("Medlemmet er opdateret.");
            System.out.println();
        } else {
            System.out.println("Model.Medlem med ID " + id + " blev ikke fundet.");
        }
    }
    public static boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

//==============================================================================
//==============================TRÆNER==========================================



    public void printTræner() {
        System.out.println();
        System.out.println("Træner: ");
        System.out.println("_________________");
        System.out.println("1. Registrere resultater");
        System.out.println("2. Redigere i resultaterne");
        System.out.println("3. vis alle resultater");
        System.out.println("4. Tilbage til menu");
        System.out.println();
    }


    public void handletræner() {
        boolean trænerRunning = true;

        while (trænerRunning) {
            printTræner();
            int trænerChoice = scanner.nextInt();

            switch (trænerChoice) {
                case 1:
                    registredisciplin();
                    break;
                case 2:
                    redigerResultat();
                    break;
                case 3:
                    visResultater();
                    break;
                case 4:
                    trænerRunning = false;
                    break;
                default:
                    System.out.println("Ugyldigt valg. Prøv igen.");
                    break;
            }
        }
    }


    public void visResultater() {
        dataBase.printResultaterList();
    }

    public void visMedlemmersResultater() {
        System.out.println("Her er medlemmerne i delfinsvømmeklubben: ");
        System.out.println();
        System.out.println("_________________");
        System.out.println();
        visResultater();
    }


    public void registreTid() {
        try {
            visMedlemmer();
            System.out.println("\nIndtast medlemmets ID:");
            int id = readInt();
            Medlem medlem = dataBase.findMedlemById(id);

                if (medlem != null) {
                    String type = "";
                    while (!type.equals("træning") && !type.equals("stævne")) {
                        System.out.println("Indtast 'træning' eller 'stævne':");
                        type = scanner.nextLine().toLowerCase();

                        switch (type) {
                            case "træning":
                                System.out.println("Du har valgt træning.");
                                break;
                            case "stævne":
                                System.out.println("Du har valgt stævne.");
                                break;
                            default:
                                System.out.println("Ugyldigt valg, prøv igen.");
                                break;
                        }
                    }

                    System.out.println("\nIndtast dato (f.eks. dd-mm-yyyy):");
                    String dato = null;
                    boolean validDate = false;
                    while (!validDate) {
                        try {
                            dato = readString();
                            validDate = true;
                            System.out.println("Du har valgt datoen.");
                        } catch (Exception e) {
                            System.out.println("Der opstod en fejl. Prøv igen.");
                        }
                    }





                    System.out.println("\nIndtast disciplin indenfor (butterfly, crawl, rygcrawl, brystsvømning)");
                    String disciplin = "";
                    while (!Arrays.asList("butterfly", "crawl", "rygcrawl", "brystsvømning").contains(disciplin)) {
                        disciplin = scanner.nextLine().toLowerCase();

                        if (Arrays.asList("butterfly", "crawl", "rygcrawl", "brystsvømning").contains(disciplin)) {
                            System.out.println("Du har valgt " + disciplin + ".");
                        } else {
                            System.out.println("Ugyldigt valg, prøv igen.");
                        }
                    }

                    String tid;
                    Pattern pattern = Pattern.compile("^([0-5]?\\d)m([0-5]?\\d)s$");

                    while (true) {
                        System.out.println("\nIndsæt tid (målt i minutter og sekunder, f.eks. 5m30s):");
                        tid = scanner.nextLine();
                        Matcher matcher = pattern.matcher(tid);

                        if (matcher.find()) {
                            System.out.println("Du har indtastet: " + matcher.group(1) + " minutter og " + matcher.group(2) + " sekunder.");
                            break;
                        } else {
                            System.out.println("Ugyldigt format. Prøv igen.");
                        }
                    }



                    int idNumber = dataBase.getResultaterList().size() + 1;
                    System.out.println();
                    System.out.println(medlem.getFullName() + " " + "har fået oprettet sine resultater.");
                    dataBase.tilføjResultaterTilArray(new Resultater(type, dato, disciplin, medlem.getFullName(), medlem.getIdNumber(), tid));
                    dataBase.gemResultattilCsv();
                } else {
                    System.out.println("Model.Medlem blev ikke fundet");
                }
            } catch (Exception e) {
                System.out.println("Der opstod en fejl: " + e.getMessage());
        }



    }

    public void redigerResultat() {
        visMedlemmersResultater();
        System.out.println();
        System.out.println("Indtast medlemmets ID:");
        int id = readInt();
        System.out.println();
        ArrayList<Resultater> resultater = findResultatPåId(id);
        dataBase.findMedlemById(id);


        if (resultater != null) {
            int input = 0;
            if(resultater.size() == 1){
                input = 1;
            }else {
                System.out.println("vælg mellem disse:");
                System.out.println();
                for (int i = 0; i < resultater.size(); i++) {
                    System.out.print(i + 1);
                    System.out.println(resultater.get(i));
                }
                input = readInt();
            }


            Resultater r = resultater.get(input -1);
            System.out.println("Vælg hvad du vil redigere:");
            System.out.println("1. Øvelse (Træning eller stævne) ");
            System.out.println("2. Dato");
            System.out.println("3. diciplin indenfor (butterfly, crawl, rygcrawl og brystsvømning)");
            System.out.println("4. tid");

            int valgMuligheder = readInt();
            switch (valgMuligheder) {
                case 1:
                    System.out.println("Indtast ny øvelse:");
                    String nyØvelse = readString();
                    r.setType(nyØvelse);
                    break;
                case 2:
                    System.out.println("Indtast ny dato (f.eks. dd-mm-yyyy):");
                    boolean validDate = false;
                    LocalDate nytDato =null;
                    while (!validDate) {
                        try {
                            String day = readString();

                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                            LocalDate localDate = LocalDate.parse(day, formatter);
                            nytDato = localDate;
                            validDate = true;
                            System.out.println("Du har valgt datoen.");
                        } catch (Exception e) {
                            System.out.println("Der opstod en fejl. Prøv igen.");
                        }

                    }
                    r.setDato(nytDato);
                    break;
                case 3:
                    System.out.println("Indtast ny diciplin indenfor (butterfly, crawl, rygcrawl og brystsvømning)");
                    String nytDiciplin = readString();
                    r.setDisciplin(nytDiciplin);
                    break;
                case 4:
                    System.out.println("Indtast ny tid");
                    String nytTid = readString();
                    r.setTid(nytTid);
                    break;
                default:
                    System.out.println("Ugyldigt valg.");
            }
            dataBase.opdaterResultatIDatabase(r);
            System.out.println();
            System.out.println("Resultaterne er opdateret.");
            dataBase.gemResultattilCsv();
        } else {
            System.out.println("Model.Medlem: " + id + " blev ikke fundet.");
        }
    }

    public void registredisciplin() {
        System.out.println("Registre medlemmets resultat indenfor Øvelse, Datoer, Diciplin og Tid:");
        registreTid();
    }

    public ArrayList<Resultater> findResultatPåId(int id) {
        ArrayList<Resultater> midleretideResultat = new ArrayList<>();

        for (Resultater resultat : dataBase.getResultaterList()) {
            if (resultat.getMedlemsId() == id) {
                midleretideResultat.add(resultat);
            }
        }
        return midleretideResultat;
    }

 //==============================================================================
//==============================kasseren==========================================

    public void printKassere() {
        System.out.println();
        System.out.println("Kassere: ");
        System.out.println("_________________");
        System.out.println("1. Oversigt over årlig indbetaling");
        System.out.println("2. Oversigt over medlemmer");
        System.out.println("3. Oversigt over medlemmer i restance");
        System.out.println("4. Tilbage til menu");
        System.out.println();
    }

    public void handleKassere () {
        boolean kassereRunning = true;

        while (kassereRunning) {
            printKassere();
            int kassereChoice = scanner.nextInt();

            switch (kassereChoice) {
                case 1:
                    System.out.println("Årlig indbetaling: ");
                    OversigtOverKontingent();
                    break;
                case 2:
                    visMedlemmer();
                    System.out.println("Venligst indtast et medlemsID for at se en oversigt over medlemmets navn, samt kontigent:");
                    int id = readInt();
                    Medlem medlem = dataBase.findMedlemById(id);
                    System.out.println(medlem.getFullName() + " betaler " + KasserLogik.medlemsKontingent(medlem)+ "DKK om året");
                    break;
                case 3:
                    visMedlemmer();
                    System.out.println("Her er en oversigt over medlemmer med manglende betaling:");
                    System.out.println("Venligst indtast et medlemsID for at se en oversigt over medlemmers stamoplysninger, samt Restance:");
                    int id1 = readInt();
                    Medlem medlem1 = dataBase.findMedlemById(id1);
                    System.out.println(medlem1.getFullName() + " skylder " + kasseren.medlemRestance()+ "DKK.");
                    break;
                case 4:
                    kassereRunning = false;
                    break;
                default:
                    System.out.println("Ugyldigt valg. Prøv igen.");
                    break;
            }
        }
    }

    public void OversigtOverKontingent() {
        System.out.println("Oversigt over årlig indbetaling:");
        System.out.println(kasseren.oversigtOverKontingent() + "DKK");
    }






//==============================================================================
//==============================Metoder til at håndter fejl==========================================

    String readString() {
        String readString;
        do {
            readString = scanner.nextLine();
            if (readString.isEmpty()) {
                System.out.println("prøv igen");
            }
        }
        while (readString.isEmpty());
        return readString;
    }

    int readInt() {
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

    public boolean readBoolean() {
        while (true) {
            System.out.print("Indtast 'ja' eller 'nej': ");
            String input = scanner.nextLine().trim().toLowerCase();


            if (input.equals("ja")) {
                System.out.println("Du svarede 'ja'.");
                return true;
            } else if (input.equals("nej")) {
                System.out.println("Du svarede 'nej'.");
                return false;
            } else {
                System.out.println("Ugyldigt input. Prøv igen.");
            }
        }
    }


}

