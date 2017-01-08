package Controllers;

import Models.ModelDe;
import Models.Partie;

/**
 * Created by alex on 13/12/16.
 */
public class TourDeJeu {

    /*
    Déroulement du tour de jeu :

    1) Lancé du dé événement
    2) Événement
    3) Lancé du dé de production
    4) Incrémenter les bonnes ressources
    5) Construction (colonies, villes, bâtiments)
    6) Échange de ressources
    7) Cartes Actions
     */

    public static int lancerDeProduction(){
        return ModelDe.lancerDeProduction();
    }

    /*public static void tireCarteEvenement(int index){
        Partie.piocheCarteEvenement(index);
    }

    public static void tireCarteDeveloppement(int index, int numeroPioche){
        Partie.piocheCarteDeveloppement(index, numeroPioche);
    }*/
}
