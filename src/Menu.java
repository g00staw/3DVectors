import org.apache.commons.math3.stat.descriptive.summary.Sum;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.zip.DataFormatException;

public class Menu{

    private void printLogo(){
        try{
            File logoTXT = new File("logo.txt");
            Scanner scanLogo = new Scanner(logoTXT);
            while (scanLogo.hasNextLine()){
                String var = scanLogo.nextLine();
                System.out.println(var);
            }
            scanLogo.close();
        }
        catch (FileNotFoundException e){
            System.out.println("BŁĄD: Nie można wczytać logo!");
            e.printStackTrace();
        }
    }
    public void menu() {
        String choice;
        while (true) {
            printLogo();
            System.out.println(
                    "_____________________________________________________________" +
                            "\n--- Opcje:" +
                            "\n--- 1. Uruchom kalkulator." +
                            "\n--- 2. Przegladaj dostepne bazy danych wektorow." +
                            "\n--- 3. Zamknij program." +
                            "\n_____________________________________________________________" +
                            "\n--- Wybor:");
            choice=inputStr();
            switch (choice){
                case "1":
                    //System.out.print("\033[H\033[2J");
                    //System.out.flush();
                    modes();
                    break;
                case "2":
                    searchDatabases();
                    break;
                case "3":
                    System.out.println("Trwa zamykanie programu.");
                    try {
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException e){
                        Thread.currentThread().interrupt();
                    }
                    System.exit(0);
                    break;
                case "4":
                    String database1Path = "database/3dVecCordREALNUM.xlsx";
                    InjectDatabase database1 = new InjectDatabase(database1Path);
                    System.out.println(database1.getVector());

                default:
                    //System.out.print("\033[H\033[2J");
                    //System.out.flush();
                    System.out.println("\t-. Podana opcja nie jest dostępna.");
                    try {
                        Thread.sleep(3000);
                    }
                    catch (InterruptedException e){
                        Thread.currentThread().interrupt();
                    }

            }
        }
    }
    private void modes(){
        while (true){
            System.out.println("--1. Suma wektorow.");
            String choice = inputStr();
            switch (choice){
                case "1":
                    SumOfVectors sum = new SumOfVectors();
                    sum.sumOfVectorsFromDatabase();
                    break;
            }
        }

    }
    private void searchDatabases(){
        String exit;
        ShowAvailableDatabases databases = new ShowAvailableDatabases();
        databases.showDatabases();

        String database1Path = "database/3dVecCordREALNUM.xlsx";
        InjectDatabase database1 = new InjectDatabase(database1Path);
        List<Vector3D> vectorsFromDatabase1 = database1.readVectorsFromDatabase();
        if (vectorsFromDatabase1 != null) {
            System.out.println("Wektory z bazy danych 1:");
            for (Vector3D vector : vectorsFromDatabase1) {
                System.out.println(vector);
            }
        }

        System.out.println("\nAby wrocic do menu wcisnij dowolna wartosc.");
        exit=inputStr();
    }
    private String inputStr(){
        Scanner scanner = new Scanner(System.in);
        String var = scanner.nextLine();
        return var;
    }

}
