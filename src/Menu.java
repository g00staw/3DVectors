import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {

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
                    "____________________________" +
                            "\n--- Opcje:" +
                            "\n--- 1. Uruchom kalkulator." +
                            "\n--- 2. Zamknij program." +
                            "\n____________________________" +
                            "\n--- Wybor:");
            choice=inputStr();
            switch (choice){
                case "1":
                    //System.out.print("\033[H\033[2J");
                    //System.out.flush();
                    modes();
                    break;
                case "2":
                    System.out.println("Trwa zamykanie programu.");
                    try {
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException e){
                        Thread.currentThread().interrupt();
                    }
                    System.exit(0);
                    break;
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


    }
    private String inputStr(){
        Scanner scanner = new Scanner(System.in);
        String var = scanner.nextLine();
        return var;
    }

}
