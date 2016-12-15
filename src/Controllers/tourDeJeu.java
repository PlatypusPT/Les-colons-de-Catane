package Controllers;

import Models.ModelDe;
import Models.Partie;

/**
 * Created by alex on 13/12/16.
 */
public class tourDeJeu {

    public static int lancerDeProduction(){
        return ModelDe.lanceDe();
    }

    public static String lanceDeEvenement(){
        return ModelDe.getAction();
    }

    public static void tireCarteFondation(){
        //code
    }

    public static void tireCarteEvenement(int index){
        Partie.piocheCarteEvenement(index);
    }

    public static void tireCarteDeveloppement(int index, int numeroPioche){
        Partie.piocheCarteDeveloppement(index, numeroPioche);
    }
}
