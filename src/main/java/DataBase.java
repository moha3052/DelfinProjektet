import java.util.ArrayList;
import java.util.Scanner;

public class DataBase {

    private ArrayList<Medlem> medlemsListe;
    private ArrayList<Resultater> resultaterList;
    private FileHandler fileHandler;
    Scanner scan = new Scanner(System.in);

    public DataBase(){
        this.fileHandler = new FileHandler();
        this.medlemsListe = new ArrayList<Medlem>();
        this.resultaterList = new ArrayList<Resultater>();
        loadResultater();
        loadMedlemmerFraCSV();
    }

    public DataBase(boolean loadmedlemmer){
        this();
        if (loadmedlemmer){
            loadMedlemmerFraCSV();
        }
    }

    public void loadMedlemmerFraCSV(){
        this.medlemsListe = fileHandler.loadMedlemmer();
    }

    public void loadResultater(){
        this.resultaterList = fileHandler.loadResultater();
    }

    public ArrayList<Medlem> getMedlemmer(){
        return medlemsListe;
    }


    public ArrayList<Resultater> getResultater(){
        return resultaterList;
    }


    public void printMedlemsList(){
        for (Medlem medlem :  medlemsListe) {
            System.out.println(medlem.toString());
        }
    }

    public void printResultater(){
        for(Resultater training : resultaterList){
            System.out.println(training.toString());
        }
    }

    public ArrayList<Medlem> getMedlemsListe(){
        return medlemsListe;
    }


    public Medlem findMedlemById(int id) {
        for(Medlem medlem: medlemsListe){
            if(id == medlem.getIdNumber()){
                return medlem;
            }
        }
        System.out.println("kunne ikke finde id nummer");
        return null;
    }



    public void opdaterMedlemIDatabase(Medlem updateretMedlem){
        for (int i = 0; i < medlemsListe.size(); i++) {
            if (medlemsListe.get(i).getIdNumber() == updateretMedlem.getIdNumber()){
                medlemsListe.set(i, updateretMedlem);
            }
        }
    }


    public void tilføjMedlemTilArray(Medlem medlem){
        medlemsListe.add(medlem);
    }


    public void tilføjResultaterTilArray(Resultater training) {
        if (resultaterList != null) {
            resultaterList.add(training);
        } else {
            System.out.println("Fejl: resultaterList er ikke initialiseret.");
        }
    }


    public void gemMedlemlistTilCSV(){
        fileHandler.gemMedlemslisteTilCSV(medlemsListe);
    }

    public void gemResultattilCsv(){
        fileHandler.gemResultaterICsv(resultaterList);
    }

    public void opdaterResultatIDatabase(Resultater updateretResultat){
        for (int i = 0; i < resultaterList.size(); i++) {
            if (medlemsListe.get(i).getFullName() == updateretResultat.getmedlem()){
                resultaterList.set(i, updateretResultat);
            }
        }
    }

    public Medlem findMedlemByName(String navn) {
        for(Medlem medlem: medlemsListe){
            if(navn == medlem.getFullName()){
                return medlem;
            }
        }
        System.out.println("Kunne ikke finde medlemmets navn");
        return null;
    }

    String readString() {
        String readString;
        do {
            readString = scan.nextLine();
            if (readString.isEmpty()) {
                System.out.println("prøv igen");
            }
        }
        while (readString.isEmpty());
        return readString;
    }

    int readInt() {
        while (!scan.hasNextInt()) {
            String text = scan.nextLine();
            System.out.println(text + " er ugyldigt input. Prøv igen.");
        }
        int result;
        result = scan.nextInt();
        scan.nextLine();
        return result;
    }

    private double readDouble() {
        while (!scan.hasNextDouble()) {
            String text = scan.nextLine();
            System.out.println(text + " er ugyldigt input. Prøv igen.");
        }
        double result;
        result = scan.nextDouble();
        scan.nextLine();
        return result;
    }

    public boolean readBoolean() {
        while (true) {
            System.out.print("Indtast 'ja' eller 'nej': ");
            String input = scan.nextLine().trim().toLowerCase();


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
