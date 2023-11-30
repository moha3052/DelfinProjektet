package datasource;

import java.util.ArrayList;

public class DataBase {

    private ArrayList<Medlem> medlemsListe;
    private ArrayList<Resultater> resultaterList;
    private FileHandler fileHandler;


    public void loadMedlemmerFraCSV(){
        this.medlemsListe = fileHandler.loadMedlemmer();
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

    public DataBase(){
        this.fileHandler = new FileHandler();
        loadMedlemmerFraCSV();
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

    public void tilføjResultaterTilArray(Resultater training){
        resultaterList.add(training);
    }

    public void gemMedlemlistTilCSV(){
        fileHandler.gemMedlemslisteTilCSV(medlemsListe);
    }

}
