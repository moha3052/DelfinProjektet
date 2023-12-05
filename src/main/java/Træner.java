import java.util.ArrayList;
import java.util.Scanner;

public class Træner {

    Scanner scanner = new Scanner(System.in);
    Formand formand = new Formand();
    DataBase dataBase = new DataBase();



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
        dataBase.printResultater();
    }


    public void registreTid() {
        formand.visMedlemmer();
        System.out.println();
        System.out.println("Indtaste navn på det medlem du gerne vil give resultat:");
        scanner.nextLine();
        String navn = dataBase.readString();


        ArrayList<Medlem> medlemmer = dataBase.getMedlemsListe();
        if (medlemmer == null || medlemmer.isEmpty()) {
            System.out.println("Ingen medlemmer at søge i.");
            return;
        }
        Medlem medlemFundet = null;
        for (Medlem medlem : medlemmer) {
            if (navn.equals(medlem.getFullName())) {
                System.out.println();
                System.out.println("Medlemmet blev fundet: " + medlem.getFullName());
                medlemFundet = medlem;
                break;
            }
        }
        int medlemsId = dataBase.readInt();

        if (medlemFundet != null) {
            String type = "";
            while (!type.equals("træning") && !type.equals("stævne")) {
                System.out.println("Indtast 'træning' eller 'stævne':");
                type = scanner.nextLine().toLowerCase();

                if (type.equals("træning")) {
                    System.out.println("Du har valgt træning.");
                } else if (type.equals("stævne")) {
                    System.out.println("Du har valgt stævne.");
                } else {
                    System.out.println("Ugyldigt valg, prøv igen.");
                }
            }

            System.out.println();
            System.out.println("Indtast dato:");
            String dato = dataBase.readString();
            System.out.println();

            System.out.println("Indtast diciplin indenfor (butterfly, crawl, rygcrawl og brystsvømning)");
            String disciplin = "";

            while (!disciplin.equals("butterfly") && !disciplin.equals("crawl") && !disciplin.equals("rygcrawl") &&
                    !disciplin.equals("brystsvømning")) {
                disciplin = scanner.nextLine().toLowerCase();

                if (disciplin.equals("butterfly")) {
                    System.out.println("Du har valgt butterfly.");
                } else if (disciplin.equals("crawl")) {
                    System.out.println("Du har valgt crawl.");
                } else if (disciplin.equals("rygcrawl")) {
                    System.out.println("Du har valgt rygcrawl.");
                } else if (disciplin.equals("brystsvømning")) {
                    System.out.println("Du har valgt brystsvømning.");
                } else {
                    System.out.println("Ugyldigt valg, prøv igen.");
                }
            }


            System.out.println();
            System.out.println("Indsæt tid (målt i minutter og sekundere)");
            String tid = dataBase.readString();
            System.out.println();

            dataBase.tilføjResultaterTilArray(new Resultater(type, dato, disciplin, medlemFundet.getFullName(), medlemsId, tid));
            System.out.println("Resultaterne er blevet oprettet.");
            dataBase.gemResultattilCsv();
        } else {
            System.out.println("Medlem blev ikke fundet");
        }
    }

    public void redigerResultat() {
        System.out.println("Indtast medlemmets navn:");
        String navn = dataBase.readString();
        Resultater resultater = findResultatPåNavn(navn);

        if (resultater != null) {
            System.out.println("Vælg hvad du vil redigere:");
            System.out.println("1. Øvelse (Træning eller stævne) ");
            System.out.println("2. Dato");
            System.out.println("3. diciplin indenfor (butterfly, crawl, rygcrawl og brystsvømning)");
            System.out.println("4. tid");


            int valgMuligheder = dataBase.readInt();
            switch (valgMuligheder) {
                case 1:
                    System.out.println("Indtast ny øvelse:");
                    String nyØvelse = dataBase.readString();
                    resultater.setType(nyØvelse);
                    break;
                case 2:
                    System.out.println("Indtast ny dato");
                    String nytDato = dataBase.readString();
                    resultater.setDato(nytDato);
                    break;
                case 3:
                    System.out.println("Indtast ny diciplin indenfor (butterfly, crawl, rygcrawl og brystsvømning)");
                    String nytDiciplin = dataBase.readString();
                    resultater.setDisciplin(nytDiciplin);
                    break;
                case 4:
                    System.out.println("Indtast ny tid");
                    String nytTid = dataBase.readString();
                    resultater.setTid(nytTid);
                    break;
                default:
                    System.out.println("Ugyldigt valg.");
            }
            dataBase.opdaterResultatIDatabase(resultater);
            System.out.println();
            System.out.println("Resultaterne er opdateret.");
        } else {
            System.out.println("Medlem: " + navn + " blev ikke fundet.");
        }
    }

    public void registredisciplin() {
        System.out.println("Registre medlemmets resultat indenfor Øvelse, Datoer, Diciplin og Tid:");
        registreTid();
    }

    public Resultater findResultatPåNavn(String navn) {
        ArrayList<Resultater> midleretideResultat = new ArrayList<>();

        for (Resultater resultat : dataBase.getResultater()) {
            if (resultat.getmedlem().equals(navn)) {
                midleretideResultat.add(resultat);
            }
        }
        System.out.println("hvilket resultat vil du tjekke");
        for (int i = 0; i < midleretideResultat.size(); i++) {
            System.out.println("#" + (i + 1) + midleretideResultat.get(i).toString());
        }
        System.out.println("indtast nummeret på resultatet du vil ændre");
        int numberInList = scanner.nextInt();

        return midleretideResultat.get(numberInList);
    }
}
