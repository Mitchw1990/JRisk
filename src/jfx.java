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

        Image board = new Image(getClass().getResourceAsStream("westerosMap.jpg"));
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage( board, 0, 0, initWidth, initHeight );


        alaska = new Territory("alaska");
        initButton(alaska, 100, 90);

        northWestTerritory = new Territory("northWestTerritory");
        initButton(northWestTerritory, 225, 130);

        alberta = new Territory("alberta");
        initButton(alberta, 225, 210);

        westernUnitedStates = new Territory("westernUnitedStates");
        initButton(westernUnitedStates, 225, 315);

        ontario = new Territory("ontario");
        initButton(ontario, 325, 220);

        quebec = new Territory("quebec");
        initButton(quebec, 395, 220);

        greenland = new Territory("greenland");
        initButton(greenland, 505, 90);

        easternUnitedStates = new Territory("easternUnitedStates");
        initButton(easternUnitedStates, 325, 290);

        centralAmerica = new Territory("centralAmerica");
        initButton(centralAmerica, 240, 405);

        venezuela = new Territory("venezuela");
        initButton(venezuela, 330, 510);

        peru = new Territory("peru");
        initButton(peru, 380, 620);

        brazil = new Territory("brazil");
        initButton(brazil, 450, 600);

        argentina = new Territory("argentina");
        initButton(argentina, 380, 730);

        iceland = new Territory("iceland");
        initButton(iceland, 625, 170);

        greatBritain = new Territory("greatBritain");
        initButton(greatBritain, 620, 275);

        scandanavia = new Territory("scandanavia");
        initButton(scandanavia, 725, 170);

        ukraine = new Territory("ukraine");
        initButton(ukraine, 860, 245);

        northernEurope = new Territory("northernEurope");
        initButton(northernEurope, 735, 300);

        southernEurope = new Territory("southernEurope");
        initButton(southernEurope, 770, 380);

        westernEurope = new Territory("westernEurope");
        initButton(westernEurope, 620, 425);

        northAfrica = new Territory("northAfrica");
        initButton(northAfrica, 665, 550);

        egypt = new Territory("egypt");
        initButton(egypt, 785, 520);

        eastAfrica = new Territory("eastAfrica");
        initButton(eastAfrica, 850, 590);

        congo = new Territory("congo");
        initButton(congo, 795, 680);

        southAfrica = new Territory("southAfrica");
        initButton(southAfrica, 795, 795);

        madagascar = new Territory("madagascar");
        initButton(madagascar, 915, 795);

        middleEast = new Territory("middleEast");
        initButton(middleEast, 900, 465);

        afganistan = new Territory("afganistan");
        initButton(afganistan, 985, 335);

        ural = new Territory("ural");
        //missing initButton

        siberia = new Territory("siberia");
        initButton(siberia, 1080, 155);

        yakutsk = new Territory("yakutsk");
        initButton(yakutsk, 1190, 110);

        kamchatka = new Territory("kamchatka");
        initButton(kamchatka, 1325, 120);

        irkutsk = new Territory("irkutsk");
        initButton(irkutsk, 1180, 220);

        mongolia = new Territory("mongolia");
        initButton(mongolia, 1195, 310);

        china = new Territory("china");
        initButton(china, 1170, 405);

        siam = new Territory("siam");
        initButton(siam, 1195, 510);

        india = new Territory("india");
        initButton(india, 1070, 475);

        japan = new Territory("japan");
        initButton(japan, 1335, 325);

        indonesia = new Territory("indonesia");
        initButton(indonesia, 1200, 640);

        newGuinea = new Territory("newGuinea");
        initButton(newGuinea, 1330, 635);

        westernAustralia = new Territory("westernAustralia");
        initButton(westernAustralia, 1275, 800);

        easternAustralia = new Territory("easternAustralia");
        initButton(easternAustralia, 1385, 780);

        Player p1 = new Player("Attacker");
        Player p2 = new Player("Defender");

        alaska.updateTroopCount(15);
        eastAfrica.updateTroopCount(20);

        System.out.println("Alaska troops before battle: " + alaska.getTroopCount());
        System.out.println("East Africa troops before battle: " + eastAfrica.getTroopCount());

        Battle battle = new Battle(p1, 1, alaska, p2, 2, eastAfrica);
        battle.engage();

        System.out.println("Alaska troops after battle: " + alaska.getTroopCount());
        System.out.println("East Africa troops after battle: " + eastAfrica.getTroopCount());

        theStage.show();
    }


    public void initButton(Territory territory, int x, int y){

        territory.setStyle("  -fx-padding: 8 10 10 10;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #a34313 0%, #903b12 100%),\n" +
                "        #9d4024,\n" +
                "        #d86e3a,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #d86e3a, #c54e2c);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;");
        //territory.setStyle("-fx-background-radius: 30;");
        //territory.setStyle("-fx-background-insets: 0;");
        //territory.setStyle("-fx-text-fill: white;");

        //territory.setStyle("-fx-font: 0 arial; -fx-base: #8cea37;");
        //territory.setPrefWidth(30);
        //territory.setPrefHeight(30);
        //territory.setEffect(new DropShadow());
        //territory.setEffect(new GaussianBlur(10.0));
        territory.setLayoutX(x);
        territory.setLayoutY(y);
        territory.setOnAction(e -> System.out.println("clicked"));
        ((Group)theScene.getRoot()).getChildren().add(territory);
    }



}