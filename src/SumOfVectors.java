import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SumOfVectors {
    private InputData varInt;

    public SumOfVectors(){
        varInt = new InputData();
    }
    public double sumOfVectorsFromDatabase(){
        int i=0;
        int next=1;
        double result[][] = new double[1][3];
        Vector3D vector;
        String database1Path = "database/3dVecCordREALNUM.xlsx";
        InjectDatabase database1 = new InjectDatabase(database1Path);

        while(next!=2){
            System.out.println("-- Podaj id wektora, ktorego chcesz dodac: \n");
            vector=database1.getVector();

                result[0][0]+=vector.getX();
                result[0][1]+=vector.getY();
                result[0][2]+=vector.getZ();


            //selectedVectors.addAll(database1.getVector());
            i++;

            System.out.println("\n-- Czy chcesz dodac kolejny wektor? \n-- 1. Tak. \n-- 2. Nie. \n-- Wybor: ");
            next = varInt.getInt();
            if(next!=1 && next !=2) System.out.println("-- Podana opcja nie jest dostepna. Praca programu trwa dalej.");
        }
        //System.out.println(selectedVectors);
        System.out.println("X: "+result[0][0]+"Y: "+result[0][1]+"Z: "+result[0][2]);
        return 0;
    }
}
