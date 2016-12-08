package Views;

import Models.Carte;
import Models.Model;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by yhaffner on 08/12/16.
 */
public class Game_View {
    public static int IMG_SMALL_SIZE = 65;
    public static int IMG_MEDIUM_SIZE = 100;
    public static int IMG_HUGE_SIZE = 400;


    private Model model;
    private Stage stage;
    private Menu_View menu_view;

    private VBox gameSection;
    private GridPane bluePlayerLayout;
    private GridPane piocheLayout;
    private GridPane redPlayerLayout;

    private ArrayList<ImageView> bluePlayerCards;
    private ArrayList<ImageView> piocheCards;
    private ArrayList<ImageView> redPlayerCards;

    public Game_View(Model model, Stage stage, Menu_View menu_view) {
        this.model = model;
        this.stage = stage;
        this.menu_view = menu_view;
    }

    public void initAttributs() {
        gameSection = new VBox();
        bluePlayerLayout = new GridPane();
        piocheLayout = new GridPane();
        redPlayerLayout = new GridPane();

        bluePlayerCards = new ArrayList<ImageView>();
        // for(int i=0;i<model.getBluePlayerCards().length;i++) {
        //     ImageView imageView = new ImageView(model.getBluePlayerCards()[i].image);
        //     bluePlayerCards.add(i,imageView);
        // }
        piocheCards = new ArrayList<ImageView>();
        // for(int i=0;i<model.getLayoutPlayerCards().length;i++) {
        //     ImageView imageView = new ImageView(model.getLayoutCards()[i].image);
        //     bluePlayerCards.add(i,imageView);
        // }
        redPlayerCards = new ArrayList<ImageView>();
        // for(int i=0;i<model.getRedPlayerCards().length;i++) {
        //     ImageView imageView = new ImageView(model.getRedPlayerCards()[i].image);
        //     bluePlayerCards.add(i,imageView);
        // }
        System.out.println(model.ASSETS_PATH+"/img/cards/card_dos.png");
        Image dos = new Image(model.ASSETS_PATH+"/img/cards/card_dos.png",IMG_SMALL_SIZE,IMG_SMALL_SIZE,true,true);
        Image emplacement = new Image(model.ASSETS_PATH+"/img/cards/no_card.png",IMG_SMALL_SIZE,IMG_SMALL_SIZE,true,true);

        bluePlayerLayout.add(new ImageView(dos),0,0);
        bluePlayerLayout.add(new ImageView(emplacement),0,1);
        bluePlayerLayout.add(new ImageView(dos),0,2);
        bluePlayerLayout.add(new ImageView(emplacement),0,3);
        bluePlayerLayout.add(new ImageView(dos),0,4);
        bluePlayerLayout.add(new ImageView(emplacement),1,0);
        bluePlayerLayout.add(new ImageView(dos),1,1);
        bluePlayerLayout.add(new ImageView(dos),1,2);
        bluePlayerLayout.add(new ImageView(dos),1,3);
        bluePlayerLayout.add(new ImageView(emplacement),1,4);
        bluePlayerLayout.add(new ImageView(dos),2,0);
        bluePlayerLayout.add(new ImageView(emplacement),2,1);
        bluePlayerLayout.add(new ImageView(dos),2,2);
        bluePlayerLayout.add(new ImageView(emplacement),2,3);
        bluePlayerLayout.add(new ImageView(dos),2,4);

        for(int i=0;i<10;i++) piocheLayout.add(new ImageView(dos),i,0);

        redPlayerLayout.add(new ImageView(dos),0,0);
        redPlayerLayout.add(new ImageView(emplacement),0,1);
        redPlayerLayout.add(new ImageView(dos),0,2);
        redPlayerLayout.add(new ImageView(emplacement),0,3);
        redPlayerLayout.add(new ImageView(dos),0,4);
        redPlayerLayout.add(new ImageView(emplacement),1,0);
        redPlayerLayout.add(new ImageView(dos),1,1);
        redPlayerLayout.add(new ImageView(dos),1,2);
        redPlayerLayout.add(new ImageView(dos),1,3);
        redPlayerLayout.add(new ImageView(emplacement),1,4);
        redPlayerLayout.add(new ImageView(dos),2,0);
        redPlayerLayout.add(new ImageView(emplacement),2,1);
        redPlayerLayout.add(new ImageView(dos),2,2);
        redPlayerLayout.add(new ImageView(emplacement),2,3);
        redPlayerLayout.add(new ImageView(dos),2,4);
    }

    public void setPartyView() {
        stage.hide();

        ((BorderPane) stage.getScene().getRoot()).getChildren().clear();
        gameSection.getChildren().clear();

        // Game content
        gameSection.getChildren().add(bluePlayerLayout);
        gameSection.getChildren().add(piocheLayout);
        gameSection.getChildren().add(redPlayerLayout);
        ((BorderPane) stage.getScene().getRoot()).setCenter(gameSection);

        stage.show();
    }
}
