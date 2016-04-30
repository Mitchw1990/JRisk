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

    private Territory theWall ;
    private Territory skagos;
    private Territory theGrevCliffs;
    private Territory winterfell;
    private Territory theNeck;
    private Territory theFlintCliff;
    private Territory theRills;
    private Territory wolfsrvood;


    private Territory theVale;
    private Territory crorvnlands;
    private Territory westerlands;
    private Territory riverlands;
    private Territory ironIslands;

    private Territory theReach;
    private Territory stormlands;
    private Territory dorne;
    private Territory redMountains;
    private Territory whisperingSound;
    private Territory shieldLands;


    private Territory braavosianCoastland;
    private Territory hillsOfNorvos;
    private Territory qhoyneLands;
    private Territory forrestOfQohor;
    private Territory theGoldenFields;
    private Territory theDisputedLands;
    private Territory andalos;

    private Territory rhoynianVeld;
    private Territory westernWaste;
    private Territory seaOfsighs;
    private Territory elyria;
    private Territory valyria;
    private Territory sarMell;

    private Territory sarnor;
    private Territory abandonedLand;
    private Territory kingdomsOfTheIfeqevron;
    private Territory theFootprint;
    private Territory realmsOfShogran;
    private Territory vaesDothrak;
    private Territory easternGrassSea;
    private Territory westernGrassSea;
    private Territory parchedFields;

    private Territory paintedMountains;
    private Territory slaversBay;
    private Territory lhazar;
    private Territory samyrianHills;
    private Territory bayasabhad;
    private Territory qarth;
    private Territory redWaste;
    private Territory ghiscar;



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


        theWall = new Territory("theWall");
        initButton(theWall, 100, 90);

        skagos = new Territory("skagos");
        initButton(skagos, 225, 130);

        theGrevCliffs = new Territory("theGrevCliffs");
        initButton(theGrevCliffs, 225, 210);

        winterfell = new Territory("winterfell");
        initButton(winterfell, 225, 315);

        theNeck = new Territory("theNeck");
        initButton(theNeck, 325, 220);

        theFlintCliff = new Territory("theFlintCliff");
        initButton(theFlintCliff, 395, 220);

        theRills = new Territory("theRills");
        initButton(theRills, 505, 90);

        wolfsrvood = new Territory("wolfsrvood");
        initButton(wolfsrvood, 325, 290);

        theVale = new Territory("theVale");
        initButton(theVale, 240, 405);

        crorvnlands = new Territory("crorvnlands");
        initButton(crorvnlands, 330, 510);

        westerlands = new Territory("westerlands");
        initButton(westerlands, 380, 620);

        riverlands = new Territory("riverlands");
        initButton(riverlands, 450, 600);

        ironIslands = new Territory("ironIslands");
        initButton(ironIslands, 380, 730);

        theReach = new Territory("theReach");
        initButton(theReach, 625, 170);

        stormlands = new Territory("stormlands");
        initButton(stormlands, 620, 275);

        dorne = new Territory("dorne");
        initButton(dorne, 725, 170);

        redMountains = new Territory("redMountains");
        initButton(redMountains, 860, 245);

        whisperingSound = new Territory("whisperingSound");
        initButton(whisperingSound, 735, 300);

        shieldLands = new Territory("shieldLands");
        initButton(shieldLands, 770, 380);

        braavosianCoastland = new Territory("braavosianCoastland");
        initButton(braavosianCoastland, 620, 425);

        hillsOfNorvos = new Territory("hillsOfNorvos");
        initButton(hillsOfNorvos, 665, 550);

        qhoyneLands = new Territory("qhoyneLands");
        initButton(qhoyneLands, 785, 520);

        forrestOfQohor = new Territory("forrestOfQohor");
        initButton(forrestOfQohor, 850, 590);

        theGoldenFields = new Territory("theGoldenFields");
        initButton(theGoldenFields, 795, 680);

        theDisputedLands = new Territory("theDisputedLands");
        initButton(theDisputedLands, 795, 795);

        andalos = new Territory("andalos");
        initButton(andalos, 915, 795);

        rhoynianVeld = new Territory("rhoynianVeld");
        initButton(rhoynianVeld, 900, 465);

        westernWaste = new Territory("westernWaste");
        initButton(westernWaste, 985, 335);

        seaOfsighs = new Territory("seaOfsighs");
        initButton(seaOfsighs, 995, 350);

        elyria = new Territory("elyria");
        initButton(elyria, 1080, 155);

        valyria = new Territory("valyria");
        initButton(valyria, 1190, 110);

        sarMell = new Territory("sarMell");
        initButton(sarMell, 1325, 120);

        sarnor = new Territory("sarnor");
        initButton(sarnor, 1180, 220);

        abandonedLand = new Territory("abandonedLand");
        initButton(abandonedLand, 1195, 310);

        kingdomsOfTheIfeqevron = new Territory("kingdomsOfTheIfeqevron");
        initButton(kingdomsOfTheIfeqevron, 1170, 405);

        theFootprint = new Territory("theFootprint");
        initButton(theFootprint, 1195, 510);

        realmsOfShogran = new Territory("realmsOfShogran");
        initButton(realmsOfShogran, 1070, 475);

        vaesDothrak = new Territory("vaesDothrak");
        initButton(vaesDothrak, 1335, 325);

        easternGrassSea = new Territory("easternGrassSea");
        initButton(easternGrassSea, 1200, 640);

        westernGrassSea = new Territory("westernGrassSea");
        initButton(westernGrassSea, 1330, 635);

        parchedFields = new Territory("parchedFields");
        initButton(parchedFields, 1275, 800);

        paintedMountains = new Territory("paintedMountains");
        initButton(paintedMountains, 1385, 780);

        slaversBay = new Territory("slaversBay");
        initButton(slaversBay, 1385, 780);

        lhazar = new Territory("lhazar");
        initButton(lhazar, 1385, 780);

        samyrianHills = new Territory("samyrianHills");
        initButton(samyrianHills, 1385, 780);

        bayasabhad = new Territory("bayasabhad");
        initButton(bayasabhad, 1385, 780);

        qarth = new Territory("qarth");
        initButton(qarth, 1385, 780);

        redWaste = new Territory("redWaste");
        initButton(redWaste, 1385, 780);

        ghiscar = new Territory("ghiscar");
        initButton(ghiscar, 1385, 780);

        Player p1 = new Player("Attacker");
        Player p2 = new Player("Defender");

        theWall.updateTroopCount(15);
        westerlands.updateTroopCount(20);

        System.out.println("Alaska troops before battle: " + theWall.getTroopCount());
        System.out.println("East Africa troops before battle: " + westerlands.getTroopCount());

        Battle battle = new Battle(p1, 1, theWall, p2, 2, westerlands);
        battle.engage();

        System.out.println("Alaska troops after battle: " + theWall.getTroopCount());
        System.out.println("East Africa troops after battle: " + westerlands.getTroopCount());

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