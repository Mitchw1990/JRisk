import sun.audio.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class jfx extends Application{

    private Scene theScene;

    private Territory alaska ;
    private Territory northWestTerritory;
    private Territory alberta;
    private Territory ontario;
    private Territory westernUnitedStates;
    private Territory easternUnitedStates;
    private Territory centralAmerica;
    private Territory greenland;
    private Territory quebec;

    private Territory venezuela;
    private Territory peru;
    private Territory brazil;
    private Territory argentina;

    private Territory iceland;
    private Territory greatBritain;
    private Territory scandanavia;
    private Territory westernEurope;
    private Territory northernEurope;
    private Territory southernEurope;
    private Territory ukraine;

    private Territory northAfrica;
    private Territory egypt;
    private Territory eastAfrica;
    private Territory congo;
    private Territory southAfrica;
    private Territory madagascar;

    private Territory middleEast;
    private Territory afganistan;
    private Territory ural;
    private Territory siberia;
    private Territory yakutsk;
    private Territory kamchatka;
    private Territory irkutsk;
    private Territory mongolia;
    private Territory china;
    private Territory siam;
    private Territory india;
    private Territory japan;

    private Territory indonesia;
    private Territory newGuinea;
    private Territory westernAustralia;
    private Territory easternAustralia;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage theStage)
    {

        final double initWidth = 1480;
        final double initHeight = 920;

        theStage.setTitle("Timeline Example");
        Group root = new Group();


        theScene = new Scene(root, initWidth, initHeight);
        theStage.setScene( theScene );


        Canvas canvas = new Canvas( initWidth, initHeight );
        root.getChildren().add( canvas );

        Image board = new Image(getClass().getResourceAsStream("board.jpg"));
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage( board, 0, 0, initWidth, initHeight );


        alaska = new Territory();
        initButton(alaska, 100, 90);
        alaska.setStyle("-fx-font: 0 arial; -fx-base: yellow;");

        northWestTerritory = new Territory();
        initButton(northWestTerritory, 225, 130);
        northWestTerritory.setStyle("-fx-font: 0 arial; -fx-base: yellow;");

        alberta = new Territory();
        initButton(alberta, 225, 210);
        alberta.setStyle("-fx-font: 0 arial; -fx-base: yellow;");

        westernUnitedStates = new Territory();
        initButton(westernUnitedStates, 225, 315);
        westernUnitedStates.setStyle("-fx-font: 0 arial; -fx-base: yellow;");

        ontario = new Territory();
        initButton(ontario, 325, 220);
        ontario.setStyle("-fx-font: 0 arial; -fx-base: yellow;");

        quebec = new Territory();
        initButton(quebec, 395, 220);
        quebec.setStyle("-fx-font: 0 arial; -fx-base: yellow;");

        greenland = new Territory();
        initButton(greenland, 505, 90);
        greenland.setStyle("-fx-font: 0 arial; -fx-base: yellow;");

        easternUnitedStates = new Territory();
        initButton(easternUnitedStates, 325, 290);
        easternUnitedStates.setStyle("-fx-font: 0 arial; -fx-base: yellow;");

        centralAmerica = new Territory();
        initButton(centralAmerica, 240, 405);
        centralAmerica.setStyle("-fx-font: 0 arial; -fx-base: yellow;");

        venezuela = new Territory();
        initButton(venezuela, 330, 510);
        venezuela.setStyle("-fx-font: 0 arial; -fx-base: red;");

        peru = new Territory();
        initButton(peru, 380, 620);
        peru.setStyle("-fx-font: 0 arial; -fx-base: red;");

        brazil = new Territory();
        initButton(brazil, 450, 600);
        brazil.setStyle("-fx-font: 0 arial; -fx-base: red;");

        argentina = new Territory();
        initButton(argentina, 380, 730);
        argentina.setStyle("-fx-font: 0 arial; -fx-base: red;");

        iceland = new Territory();
        initButton(iceland, 625, 170);
        iceland.setStyle("-fx-font: 0 arial; -fx-base: cyan;");

        greatBritain = new Territory();
        initButton(greatBritain, 620, 275);
        greatBritain.setStyle("-fx-font: 0 arial; -fx-base: cyan;");

        scandanavia = new Territory();
        initButton(scandanavia, 725, 170);
        scandanavia.setStyle("-fx-font: 0 arial; -fx-base: cyan;");

        ukraine = new Territory();
        initButton(ukraine, 860, 245);
        ukraine.setStyle("-fx-font: 0 arial; -fx-base: cyan;");

        northernEurope = new Territory();
        initButton(northernEurope, 735, 300);
        northernEurope.setStyle("-fx-font: 0 arial; -fx-base: cyan;");

        southernEurope = new Territory();
        initButton(southernEurope, 770, 380);
        southernEurope.setStyle("-fx-font: 0 arial; -fx-base: cyan;");

        westernEurope = new Territory();
        initButton(westernEurope, 620, 425);
        westernEurope.setStyle("-fx-font: 0 arial; -fx-base: cyan;");

        northAfrica = new Territory();
        initButton(northAfrica, 665, 550);
        northAfrica.setStyle("-fx-font: 0 arial; -fx-base: goldenrod;");

        egypt = new Territory();
        initButton(egypt, 785, 520);
        egypt.setStyle("-fx-font: 0 arial; -fx-base: goldenrod;");

        eastAfrica = new Territory();
        initButton(eastAfrica, 850, 590);
        eastAfrica.setStyle("-fx-font: 0 arial; -fx-base: goldenrod;");

        congo = new Territory();
        initButton(congo, 795, 680);
        congo.setStyle("-fx-font: 0 arial; -fx-base: goldenrod;");

        southAfrica = new Territory();
        initButton(southAfrica, 795, 795);
        southAfrica.setStyle("-fx-font: 0 arial; -fx-base: goldenrod;");

        madagascar = new Territory();
        initButton(madagascar, 915, 795);
        madagascar.setStyle("-fx-font: 0 arial; -fx-base: goldenrod;");

        middleEast = new Territory();
        initButton(middleEast, 900, 465);
        middleEast.setStyle("-fx-font: 0 arial; -fx-base: green;");

        afganistan = new Territory();
        initButton(afganistan, 985, 335);
        afganistan.setStyle("-fx-font: 0 arial; -fx-base: green;");

        ural = new Territory();
        initButton(ural, 1005, 205);
        ural.setStyle("-fx-font: 0 arial; -fx-base: green;");

        siberia = new Territory();
        initButton(siberia, 1080, 155);
        siberia.setStyle("-fx-font: 0 arial; -fx-base: green;");

        yakutsk = new Territory();
        initButton(yakutsk, 1190, 110);
        yakutsk.setStyle("-fx-font: 0 arial; -fx-base: green;");

        kamchatka = new Territory();
        initButton(kamchatka, 1325, 120);
        kamchatka.setStyle("-fx-font: 0 arial; -fx-base: green;");

        irkutsk = new Territory();
        initButton(irkutsk, 1180, 220);
        irkutsk.setStyle("-fx-font: 0 arial; -fx-base: green;");

        mongolia = new Territory();
        initButton(mongolia, 1195, 310);
        mongolia.setStyle("-fx-font: 0 arial; -fx-base: green;");

        china = new Territory();
        initButton(china, 1170, 405);
        china.setStyle("-fx-font: 0 arial; -fx-base: green;");

        siam = new Territory();
        initButton(siam, 1195, 510);
        siam.setStyle("-fx-font: 0 arial; -fx-base: green;");

        india = new Territory();
        initButton(india, 1070, 475);
        india.setStyle("-fx-font: 0 arial; -fx-base: green;");

        japan = new Territory();
        initButton(japan, 1335, 325);
        japan.setStyle("-fx-font: 0 arial; -fx-base: green;");

        indonesia = new Territory();
        initButton(indonesia, 1200, 640);
        indonesia.setStyle("-fx-font: 0 arial; -fx-base: purple;");

        newGuinea = new Territory();
        initButton(newGuinea, 1330, 635);
        newGuinea.setStyle("-fx-font: 0 arial; -fx-base: purple;");

        westernAustralia = new Territory();
        initButton(westernAustralia, 1275, 800);
        westernAustralia.setStyle("-fx-font: 0 arial; -fx-base: purple;");

        easternAustralia = new Territory();
        initButton(easternAustralia, 1385, 780);
        easternAustralia.setStyle("-fx-font: 0 arial; -fx-base: purple;");






        theStage.show();
    }


    public void initButton(Territory territory, int x, int y){

        territory.setStyle("-fx-font: 0 arial; -fx-base: red;");
        territory.setPrefWidth(20);
        territory.setPrefHeight(20);
        territory.setEffect(new DropShadow());
        territory.setEffect(new GaussianBlur(10.0));
        territory.setLayoutX(x);
        territory.setLayoutY(y);
        territory.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                System.out.println("clicked");
            }
        });

        ((Group)theScene.getRoot()).getChildren().add(territory);
    }



}