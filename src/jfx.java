import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;


public class jfx extends Application{

    public enum phaseType {ATTACK, PLACE_TROOPS, FORTIFY};
    public phaseType currentPhase;
    private int numberOfPlayers;
    private Player selectedCharacter;
    private Player currentPlayer;
    private ArrayList<Player> players;
    int playerIndex;
    private ArrayList<Territory> allTerritories;
    private boolean gameOver;
    private int numberOfArmiesToRecieveCurrent;
    private Label numberOfArmiesToPlaceLabel;
    private Button rollButton;
    private Button doneButton;
    private Button chargeButton;
    private Button plusButton;
    private Button minusButton;
    private Button checkButton;
    private boolean buttonsActive;
    private ImageView crestViewAttacker;
    private ImageView crestViewDefender;

    private Image d;
    private Image d2;
    private Image d3;
    private Image d4;
    private Image d5;
    private Image d6;

    private DiceAnimation da;
    private DiceAnimation da2;
    private DiceAnimation da3;
    private DiceAnimation da4;
    private DiceAnimation da5;

    private ImageView bannerView;
    
    private Scene boardScene;
    private Scene menuScene;

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
    private Territory jbben;
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

    private Continent theNorth;
    private Continent theKingsLands;
    private Continent theSouth;
    private Continent theFreeCities;
    private Continent valyrianFreehold;
    private Continent theDothrakiSea;
    private Continent Ghiscar;

    private Image[] dieImages;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage theStage)
    {


        d = new Image(getClass().getResourceAsStream("1.png"));
        d2 = new Image(getClass().getResourceAsStream("2.png"));
        d3 = new Image(getClass().getResourceAsStream("3.png"));
        d4 = new Image(getClass().getResourceAsStream("4.png"));
        d5 = new Image(getClass().getResourceAsStream("5.png"));
        d6 = new Image(getClass().getResourceAsStream("6.png"));

        dieImages = new Image[]{d,d2,d3,d4,d5,d6};




        numberOfArmiesToRecieveCurrent = 0;
        playerIndex = 0;
        buttonsActive = true;


        URL url = getClass().getResource("got.mp3");
        AudioClip themesong = new AudioClip(url.toString());

        URL url2 = getClass().getResource("gotQuote.mp3");
        AudioClip quote = new AudioClip(url2.toString());


        //Dice *************************

        da = new DiceAnimation();
        da.setFitHeight(40);
        da.setFitWidth(40);
        da.setLayoutX(600);
        da.setLayoutY(220);

        da2 = new DiceAnimation();
        da2.setFitHeight(40);
        da2.setFitWidth(40);
        da2.setLayoutX(650);
        da2.setLayoutY(220);

        da3 = new DiceAnimation();
        da3.setFitHeight(40);
        da3.setFitWidth(40);
        da3.setLayoutX(625);
        da3.setLayoutY(270);

        da4 = new DiceAnimation();
        da4.setFitHeight(40);
        da4.setFitWidth(40);
        da4.setLayoutX(970);
        da4.setLayoutY(270);

        da5 = new DiceAnimation();
        da5.setFitHeight(40);
        da5.setFitWidth(40);
        da5.setLayoutX(970);
        da5.setLayoutY(220);



        //Dice *************************

        //MainMenu ************************
        Canvas canvasMainMenu = new Canvas(700, 600);
        Image board = new Image(getClass().getResourceAsStream("menuBackground.jpg"));
        GraphicsContext gc = canvasMainMenu.getGraphicsContext2D();
        gc.drawImage( board, 0, 0, 700, 600 );
        Group menuRoot = new Group();
        menuRoot.getChildren().add(canvasMainMenu);
        Scene menuScene = new Scene(menuRoot,700,600);
        ImageView logo = new ImageView("logo.jpg");
        logo.setFitWidth(600);
        logo.setFitHeight(100);
        logo.setLayoutX(50);

        Label familyLabel = new Label("Family");
        familyLabel.setLayoutY(95);
        familyLabel.setLayoutX(50);
        familyLabel.setPrefSize(600,25);
        familyLabel.setStyle(" -fx-background-color: \n" +
                "        linear-gradient(#393e68 0%, #0c1f27 25%, #373837 75%, #4c5675 100%),\n" +
                "        linear-gradient(#020b02, #334a6b),\n" +
                "        linear-gradient(#425d9e 0%, #334a6b 20%, #323e77 80%, #4c5675 100%),\n" +
                "        linear-gradient(#365c8a 0%, #2e446b 20%, #425d9e 80%, #4c5675 100%),\n" +
                "        linear-gradient(#323e77 0%, #252660 50%, #425d9e 51%, #252660 100%);\n" +
                "    -fx-background-insets: 0,1,4,5,6;\n" +
                "    -fx-background-radius: 9,8,5,4,3;\n" +
                "    -fx-padding: 15 30 15 30;\n" +
                "    -fx-font-family: \"Helvetica\";\n" +
                "    -fx-font-size: 12px;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");


        Label numberPlayersLabel = new Label("Number of Players");
        numberPlayersLabel.setLayoutY(215);
        numberPlayersLabel.setLayoutX(50);
        numberPlayersLabel.setPrefSize(600,25);
        numberPlayersLabel.setStyle(" -fx-background-color: \n" +
                "        linear-gradient(#393e68 0%, #0c1f27 25%, #373837 75%, #4c5675 100%),\n" +
                "        linear-gradient(#020b02, #334a6b),\n" +
                "        linear-gradient(#425d9e 0%, #334a6b 20%, #323e77 80%, #4c5675 100%),\n" +
                "        linear-gradient(#365c8a 0%, #2e446b 20%, #425d9e 80%, #4c5675 100%),\n" +
                "        linear-gradient(#323e77 0%, #252660 50%, #425d9e 51%, #252660 100%);\n" +
                "    -fx-background-insets: 0,1,4,5,6;\n" +
                "    -fx-background-radius: 9,8,5,4,3;\n" +
                "    -fx-padding: 15 30 15 30;\n" +
                "    -fx-font-family: \"Helvetica\";\n" +
                "    -fx-font-size: 12px;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");

        Button playButton = new Button("Play");
        playButton.setLayoutY(365);
        playButton.setLayoutX(50);
        playButton.setPrefSize(600,25);
        playButton.setOnAction(e ->{
            initControlButtons();
            ((Group) boardScene.getRoot()).getChildren().addAll(rollButton, doneButton, numberOfArmiesToPlaceLabel, bannerView, checkButton,
                    plusButton, minusButton, crestViewAttacker, crestViewDefender);
            doneButton.setVisible(true);
            rollButton.setVisible(true);
            theStage.setScene(boardScene);
            themesong.stop();
            quote.play(.2);
            theStage.centerOnScreen();
            testGame();
            numberOfArmiesToPlaceLabel.setVisible(true);
            updateNumberOfArmiesToPlaceLabel();
            placeBanner();
        });

        playButton.setStyle(" -fx-background-color: \n" +
                "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\n" +
                "        linear-gradient(#020b02, #3a3a3a),\n" +
                "        linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),\n" +
                "        linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%),\n" +
                "        linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%);\n" +
                "    -fx-background-insets: 0,1,4,5,6;\n" +
                "    -fx-background-radius: 9,8,5,4,3;\n" +
                "    -fx-padding: 15 30 15 30;\n" +
                "    -fx-font-family: \"Helvetica\";\n" +
                "    -fx-font-size: 18px;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");


        Button quitButton = new Button("Quit");
        quitButton.setLayoutX(50);
        quitButton.setLayoutY(425);
        quitButton.setPrefSize(600,25);
        quitButton.setOnAction(e-> Platform.exit());
        quitButton.setStyle(" -fx-background-color: \n" +
                "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\n" +
                "        linear-gradient(#020b02, #3a3a3a),\n" +
                "        linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),\n" +
                "        linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%),\n" +
                "        linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%);\n" +
                "    -fx-background-insets: 0,1,4,5,6;\n" +
                "    -fx-background-radius: 9,8,5,4,3;\n" +
                "    -fx-padding: 15 30 15 30;\n" +
                "    -fx-font-family: \"Helvetica\";\n" +
                "    -fx-font-size: 18px;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");


        ObservableList<String> houseOptions =
                FXCollections.observableArrayList(
                        "House Targaryen",
                        "House Lannister",
                        "House Baratheon",
                        "House Greyjoy",
                        "House Martell",
                        "House Tully"
                );
        ObservableList<String> numberOfPlayersList =
                FXCollections.observableArrayList(
                        "2",
                        "3",
                        "4",
                        "5",
                        "6"
                );
        ComboBox familyCombo = new ComboBox(houseOptions);
        familyCombo.setStyle(" -fx-background-color: \n" +
                "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\n" +
                "        linear-gradient(#020b02, #3a3a3a),\n" +
                "        linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),\n" +
                "        linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%),\n" +
                "        linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%);\n" +
                "    -fx-background-insets: 0,1,4,5,6;\n" +
                "    -fx-background-radius: 9,8,5,4,3;\n" +
                "    -fx-padding: 15 30 15 30;\n" +
                "    -fx-font-family: \"Helvetica\";\n" +
                "    -fx-font-size: 18px;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");

        familyCombo.setLayoutY(140);
        familyCombo.setLayoutX(50);
        familyCombo.setPrefSize(600,25);

        ComboBox numberPlayersCombo = new ComboBox(numberOfPlayersList);
        numberPlayersCombo.setStyle(" -fx-background-color: \n" +
                "        linear-gradient(#686868 0%, #232723 25%, #373837 75%, #757575 100%),\n" +
                "        linear-gradient(#020b02, #3a3a3a),\n" +
                "        linear-gradient(#9d9e9d 0%, #6b6a6b 20%, #343534 80%, #242424 100%),\n" +
                "        linear-gradient(#8a8a8a 0%, #6b6a6b 20%, #343534 80%, #262626 100%),\n" +
                "        linear-gradient(#777777 0%, #606060 50%, #505250 51%, #2a2b2a 100%);\n" +
                "    -fx-background-insets: 0,1,4,5,6;\n" +
                "    -fx-background-radius: 9,8,5,4,3;\n" +
                "    -fx-padding: 15 30 15 30;\n" +
                "    -fx-font-family: \"Helvetica\";\n" +
                "    -fx-font-size: 18px;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(255,255,255,0.2) , 1, 0.0 , 0 , 1);");
        numberPlayersCombo.setLayoutY(260);
        numberPlayersCombo.setLayoutX(50);
        numberPlayersCombo.setPrefSize(600,25);

        menuRoot.getChildren().addAll(logo,playButton, familyCombo, familyLabel, numberPlayersCombo, numberPlayersLabel, quitButton);
        //MainMenu ************************


        //Board ************************
        final double initWidth = 1480;
        final double initHeight = 920;

        theStage.setTitle("RiskGOT");
        Group root = new Group();
        Canvas canvas = new Canvas( initWidth, initHeight );
        root.getChildren().add( canvas );
        boardScene = new Scene(root, initWidth, initHeight);
        theStage.setScene(menuScene);
        theStage.initStyle(StageStyle.UNDECORATED);
        Image backGround = new Image(getClass().getResourceAsStream("westerosMap.jpg"));
        GraphicsContext mainMenuGc = canvas.getGraphicsContext2D();
        mainMenuGc.drawImage( backGround, 0, 0, initWidth, initHeight );



        MenuBar menuBar = new MenuBar();
        menuBar.setStyle("-fx-font-size: 9pt;\n" +
                "    -fx-font-family: \"Segoe UI Semibold\";\n" +
                "    -fx-text-fill: green;\n" +
                "    -fx-background-color : darkslategrey;\n" +
                "    -fx-opacity: .9;");
        Menu menu = new Menu("Options");
        MenuItem menuPause = new MenuItem("Pause");
        MenuItem menuQuit = new MenuItem("Forfeit");
        menuQuit.setOnAction(e-> Platform.exit());
        //menuBar.prefWidthProperty().bind(theStage.widthProperty());
        menu.getItems().addAll(menuPause, menuQuit);
        menuBar.getMenus().addAll(menu);
        ((Group) boardScene.getRoot()).getChildren().addAll( menuBar, da,da2,da3,da4,da5);


        //Board ************************


        //init territories**********************
        theWall = new Territory("theWall");
        initTerritoryButton(theWall, 320, 95);
        theWall.setTroopCount(5);

        skagos = new Territory("skagos");
        initTerritoryButton(skagos, 390, 95);
        skagos.setTroopCount(5);

        theGrevCliffs = new Territory("theGrevCliffs");
        initTerritoryButton(theGrevCliffs, 360, 160);
        theGrevCliffs.setTroopCount(5);


        winterfell = new Territory("winterfell");
        initTerritoryButton(winterfell, 300, 230);
        winterfell.setTroopCount(5);


        theNeck = new Territory("theNeck");
        initTerritoryButton(theNeck, 240, 300);
        theNeck.setTroopCount(5);


        theFlintCliff = new Territory("theFlintCliff");
        initTerritoryButton(theFlintCliff, 190, 335);
        theFlintCliff.setTroopCount(5);


        theRills = new Territory("theRills");
        initTerritoryButton(theRills, 140, 260);
        theRills.setTroopCount(5);


        wolfsrvood = new Territory("wolfsrvood");
        initTerritoryButton(wolfsrvood, 180, 190);
        wolfsrvood.setTroopCount(5);

        theVale = new Territory("theVale");
        initTerritoryButton(theVale, 320, 420);
        theVale.setTroopCount(5);

        crorvnlands = new Territory("crorvnlands");
        initTerritoryButton(crorvnlands, 300, 495);
        crorvnlands.setTroopCount(5);


        westerlands = new Territory("westerlands");
        initTerritoryButton(westerlands, 170, 500);
        westerlands.setTroopCount(5);


        riverlands = new Territory("riverlands");
        initTerritoryButton(riverlands, 140, 425);
        riverlands.setTroopCount(5);


        ironIslands = new Territory("ironIslands");
        initTerritoryButton(ironIslands, 80, 395);
        ironIslands.setTroopCount(5);


        theReach = new Territory("theReach");
        initTerritoryButton(theReach, 250, 515);
        theReach.setTroopCount(5);


        stormlands = new Territory("stormlands");
        initTerritoryButton(stormlands, 320, 580);
        stormlands.setTroopCount(5);


        dorne = new Territory("dorne");
        initTerritoryButton(dorne, 320, 680);
        dorne.setTroopCount(5);


        redMountains = new Territory("redMountains");
        initTerritoryButton(redMountains, 205, 655);
        redMountains.setTroopCount(5);


        whisperingSound = new Territory("whisperingSound");
        initTerritoryButton(whisperingSound, 145, 655);
        whisperingSound.setTroopCount(5);


        shieldLands = new Territory("shieldLands");
        initTerritoryButton(shieldLands, 145, 580);
        shieldLands.setTroopCount(5);


        braavosianCoastland = new Territory("braavosianCoastland");
        initTerritoryButton(braavosianCoastland, 525, 370);
        braavosianCoastland.setTroopCount(5);


        hillsOfNorvos = new Territory("hillsOfNorvos");
        initTerritoryButton(hillsOfNorvos, 595, 465);
        hillsOfNorvos.setTroopCount(5);


        qhoyneLands = new Territory("qhoyneLands");
        initTerritoryButton(qhoyneLands, 655, 505);
        qhoyneLands.setTroopCount(5);


        forrestOfQohor = new Territory("forrestOfQohor");
        initTerritoryButton(forrestOfQohor, 770, 490);
        forrestOfQohor.setTroopCount(5);


        theGoldenFields = new Territory("theGoldenFields");
        initTerritoryButton(theGoldenFields, 595, 600);
        theGoldenFields.setTroopCount(5);


        theDisputedLands = new Territory("theDisputedLands");
        initTerritoryButton(theDisputedLands, 595, 670);
        theDisputedLands.setTroopCount(5);


        andalos = new Territory("andalos");
        initTerritoryButton(andalos, 545, 495);
        andalos.setTroopCount(5);


        rhoynianVeld = new Territory("rhoynianVeld");
        initTerritoryButton(rhoynianVeld, 715, 565);
        rhoynianVeld.setTroopCount(5);


        westernWaste = new Territory("westernWaste");
        initTerritoryButton(westernWaste, 770, 620);
        westernWaste.setTroopCount(5);


        seaOfsighs = new Territory("seaOfsighs");
        initTerritoryButton(seaOfsighs, 820, 640);
        seaOfsighs.setTroopCount(5);


        elyria = new Territory("elyria");
        initTerritoryButton(elyria, 840, 710);
        elyria.setTroopCount(5);


        valyria = new Territory("valyria");
        initTerritoryButton(valyria, 815, 805);
        valyria.setTroopCount(5);


        sarMell = new Territory("sarMell");
        initTerritoryButton(sarMell, 710, 665);
        sarMell.setTroopCount(5);


        sarnor = new Territory("sarnor");
        initTerritoryButton(sarnor, 860, 430);
        sarnor.setTroopCount(5);


        abandonedLand = new Territory("abandonedLand");
        initTerritoryButton(abandonedLand, 970, 470);
        abandonedLand.setTroopCount(5);


        kingdomsOfTheIfeqevron = new Territory("kingdomsOfTheIfeqevron");
        initTerritoryButton(kingdomsOfTheIfeqevron, 1095, 485);
        kingdomsOfTheIfeqevron.setTroopCount(5);


        theFootprint = new Territory("theFootprint");
        initTerritoryButton(theFootprint, 1200, 395);
        theFootprint.setTroopCount(5);


        jbben = new Territory("theFootprint");
        initTerritoryButton(jbben, 1200, 215);
        jbben.setTroopCount(5);


        realmsOfShogran = new Territory("realmsOfShogran");
        initTerritoryButton(realmsOfShogran, 1360, 370);
        realmsOfShogran.setTroopCount(5);


        vaesDothrak = new Territory("vaesDothrak");
        initTerritoryButton(vaesDothrak, 1240, 465);
        vaesDothrak.setTroopCount(5);


        easternGrassSea = new Territory("easternGrassSea");
        initTerritoryButton(easternGrassSea, 1190, 550);
        easternGrassSea.setTroopCount(5);


        westernGrassSea = new Territory("westernGrassSea");
        initTerritoryButton(westernGrassSea, 1030, 540);
        westernGrassSea.setTroopCount(5);


        parchedFields = new Territory("parchedFields");
        initTerritoryButton(parchedFields, 890, 560);
        parchedFields.setTroopCount(5);


        paintedMountains = new Territory("paintedMountains");
        initTerritoryButton(paintedMountains, 890, 610);
        paintedMountains.setTroopCount(5);


        slaversBay = new Territory("slaversBay");
        initTerritoryButton(slaversBay, 1040, 690);
        slaversBay.setTroopCount(5);


        lhazar = new Territory("lhazar");
        initTerritoryButton(lhazar, 1110, 650);
        lhazar.setTroopCount(5);


        samyrianHills = new Territory("samyrianHills");
        initTerritoryButton(samyrianHills, 1280, 595);
        samyrianHills.setTroopCount(5);


        bayasabhad = new Territory("bayasabhad");
        initTerritoryButton(bayasabhad, 1285, 675);
        bayasabhad.setTroopCount(5);


        qarth = new Territory("qarth");
        initTerritoryButton(qarth, 1285, 745);
        qarth.setTroopCount(5);


        redWaste = new Territory("redWaste");
        initTerritoryButton(redWaste, 1170, 735);
        redWaste.setTroopCount(5);


        ghiscar = new Territory("ghiscar");
        initTerritoryButton(ghiscar, 1060, 785);
        ghiscar.setTroopCount(5);


        allTerritories = new ArrayList<Territory>();
        Territory[] tArray = new Territory[] {
                theWall, skagos, theGrevCliffs, winterfell,
                theNeck, theFlintCliff, theRills, wolfsrvood, theVale,
                crorvnlands, westerlands, riverlands,ironIslands, theReach,
                stormlands, dorne, redMountains, whisperingSound, shieldLands,
                braavosianCoastland, hillsOfNorvos, qhoyneLands, forrestOfQohor,
                theGoldenFields, theDisputedLands, andalos, rhoynianVeld,
                westernWaste, seaOfsighs, elyria, valyria, sarMell,sarnor,
                abandonedLand, kingdomsOfTheIfeqevron, theFootprint, jbben,
                realmsOfShogran, vaesDothrak, easternGrassSea, westernGrassSea,
                parchedFields,paintedMountains,slaversBay, lhazar, samyrianHills,
                bayasabhad,qarth, redWaste,ghiscar};
        allTerritories.addAll(Arrays.asList(tArray));

        //init territories**********************

        //define borders**********************
        theWall.addBorderTerritory(skagos, theGrevCliffs, wolfsrvood);
        skagos.addBorderTerritory(theWall, theGrevCliffs);
        theGrevCliffs.addBorderTerritory(theWall, skagos, winterfell, wolfsrvood);
        theNeck.addBorderTerritory(theFlintCliff, theRills, theVale, winterfell, wolfsrvood);
        theFlintCliff.addBorderTerritory(ironIslands, theNeck, theVale);
        theRills.addBorderTerritory(theNeck, wolfsrvood);
        wolfsrvood.addBorderTerritory(theNeck, theRills, theGrevCliffs, theWall, winterfell);
        theVale.addBorderTerritory(crorvnlands, riverlands, theFlintCliff, theNeck);
        crorvnlands.addBorderTerritory(andalos, riverlands, stormlands, theReach, theVale, westerlands);
        westerlands.addBorderTerritory(crorvnlands, shieldLands, riverlands, theReach);
        riverlands.addBorderTerritory(crorvnlands, ironIslands, realmsOfShogran, theVale, westerlands);
        ironIslands.addBorderTerritory(riverlands, theFlintCliff);
        theReach.addBorderTerritory(crorvnlands, redMountains, shieldLands, stormlands, westerlands, whisperingSound);
        stormlands.addBorderTerritory(andalos, crorvnlands, redMountains, theReach);
        dorne.addBorderTerritory(redMountains, theDisputedLands);
        redMountains.addBorderTerritory(dorne, stormlands, theReach, whisperingSound);
        whisperingSound.addBorderTerritory(redMountains, shieldLands, theReach);
        shieldLands.addBorderTerritory(theReach, westerlands, whisperingSound);
        braavosianCoastland.addBorderTerritory(andalos, hillsOfNorvos);
        hillsOfNorvos.addBorderTerritory(andalos, braavosianCoastland, theGoldenFields, qhoyneLands);
        qhoyneLands.addBorderTerritory(forrestOfQohor, hillsOfNorvos, rhoynianVeld, theGoldenFields);
        forrestOfQohor.addBorderTerritory(parchedFields, qhoyneLands, rhoynianVeld, sarnor);
        theGoldenFields.addBorderTerritory(andalos, hillsOfNorvos, qhoyneLands, rhoynianVeld, sarMell,
                theDisputedLands);
        theDisputedLands.addBorderTerritory(dorne, sarMell, theGoldenFields);
        andalos.addBorderTerritory(braavosianCoastland, crorvnlands, hillsOfNorvos, stormlands, theGoldenFields);
        rhoynianVeld.addBorderTerritory(forrestOfQohor, parchedFields, qhoyneLands, sarMell, theGoldenFields,
                westernWaste);
        westernWaste.addBorderTerritory(paintedMountains, parchedFields, rhoynianVeld, sarMell, seaOfsighs);
        seaOfsighs.addBorderTerritory(elyria, sarMell, valyria, westernWaste);
        elyria.addBorderTerritory(paintedMountains, seaOfsighs, valyria);
        valyria.addBorderTerritory(elyria, seaOfsighs);
        sarMell.addBorderTerritory(theDisputedLands, theGoldenFields, rhoynianVeld, seaOfsighs, westernWaste);
        sarnor.addBorderTerritory(abandonedLand, forrestOfQohor, parchedFields);
        abandonedLand.addBorderTerritory(kingdomsOfTheIfeqevron, parchedFields, sarnor, westernGrassSea);
        kingdomsOfTheIfeqevron.addBorderTerritory(abandonedLand, easternGrassSea, theFootprint, vaesDothrak,
                westernGrassSea);
        theFootprint.addBorderTerritory(kingdomsOfTheIfeqevron, realmsOfShogran, vaesDothrak, jbben);
        jbben.addBorderTerritory(theFootprint);
        realmsOfShogran.addBorderTerritory( theFootprint, riverlands, vaesDothrak);
        vaesDothrak.addBorderTerritory(easternGrassSea, kingdomsOfTheIfeqevron, realmsOfShogran, theFootprint,
                samyrianHills);
        easternGrassSea.addBorderTerritory(kingdomsOfTheIfeqevron, lhazar, samyrianHills, vaesDothrak, westernGrassSea);
        westernGrassSea.addBorderTerritory(abandonedLand, easternGrassSea, kingdomsOfTheIfeqevron, paintedMountains,
                parchedFields, lhazar);
        parchedFields.addBorderTerritory(abandonedLand, forrestOfQohor, rhoynianVeld, paintedMountains, sarnor,
                westernGrassSea, westernWaste);
        paintedMountains.addBorderTerritory(elyria, lhazar, parchedFields, slaversBay, westernGrassSea, westernWaste);
        slaversBay.addBorderTerritory(ghiscar, lhazar, paintedMountains, redWaste);
        lhazar.addBorderTerritory(bayasabhad, easternGrassSea, paintedMountains, redWaste, samyrianHills, slaversBay,
                westernGrassSea);
        samyrianHills.addBorderTerritory(bayasabhad, easternGrassSea, lhazar, vaesDothrak);
        bayasabhad.addBorderTerritory(lhazar, redWaste, qarth, samyrianHills);
        qarth.addBorderTerritory(bayasabhad, redWaste);
        redWaste.addBorderTerritory(bayasabhad, ghiscar, lhazar, qarth, slaversBay);
        ghiscar.addBorderTerritory(redWaste, slaversBay);
        //define borders **********************

        //init continents **********************
        theNorth = new Continent("theNorth", 4, skagos, theFlintCliff, theGrevCliffs,
                theNeck, theRills, theWall, wolfsrvood, winterfell);
        theKingsLands = new Continent("the King's Lands", 3, crorvnlands, ironIslands, riverlands, theVale,
                westerlands);
        theSouth = new Continent("the South", 3, dorne, redMountains, shieldLands, stormlands,
                whisperingSound);
        theFreeCities = new Continent("the Free Cities", 4, andalos, braavosianCoastland, forrestOfQohor, hillsOfNorvos,
                theDisputedLands, theGoldenFields);
        valyrianFreehold = new Continent("Valyrian Freehold", 3, elyria, rhoynianVeld, sarMell, seaOfsighs, valyria,
                westernWaste);
        theDothrakiSea = new Continent("the Dothraki Sea", 5, abandonedLand, easternGrassSea, jbben,
                kingdomsOfTheIfeqevron, parchedFields, realmsOfShogran, sarnor,  theFootprint,
                vaesDothrak, westernGrassSea);
        Ghiscar = new Continent("Ghiscar", 4, bayasabhad, ghiscar, lhazar, paintedMountains, qarth, redWaste,
                samyrianHills, slaversBay);
        //init continents **********************

        theStage.show();
        themesong.setVolume(.3);
        themesong.play();
    }

    public void testGame(){
        Player player1 = new Player("Tully");
        Player player2 = new Player("Martell");
        Player player3 = new Player("Targaryen");
        Player player4 = new Player("Lannister");
        Player player5 = new Player("Greyjoy");
        Player player6 = new Player("Baratheon");


        Territory[] terrPlayerOne = new Territory[] {bayasabhad, ghiscar, lhazar, paintedMountains, qarth, redWaste,
                samyrianHills, slaversBay, skagos, theFlintCliff, theGrevCliffs,
                theNeck, theRills, theWall, wolfsrvood, winterfell};
        Territory[] terrPlayerTwo = new Territory[] {abandonedLand, easternGrassSea, jbben,
                kingdomsOfTheIfeqevron, parchedFields, realmsOfShogran, sarnor,  theFootprint,
                vaesDothrak, westernGrassSea};

        Territory[] terrPlayerThree = new Territory[]{elyria, rhoynianVeld, sarMell, seaOfsighs, valyria,
                westernWaste};
        Territory[] terrPlayerFour = new Territory[]{andalos, braavosianCoastland, forrestOfQohor, hillsOfNorvos,
                theDisputedLands, theGoldenFields};
        Territory[] terrPlayerFive = new Territory[]{dorne, redMountains, shieldLands, stormlands,
                whisperingSound};
        Territory[] terrPlayerSix = new Territory[]{crorvnlands, ironIslands, riverlands, theVale,
                westerlands};

        player1.setConqueredTerritories(terrPlayerOne);
        player2.setConqueredTerritories(terrPlayerTwo);
        player3.setConqueredTerritories(terrPlayerThree);
        player4.setConqueredTerritories(terrPlayerFour);
        player5.setConqueredTerritories(terrPlayerFive);
        player6.setConqueredTerritories(terrPlayerSix);

        player1.addContinent(Ghiscar);
        player1.addContinent(theNorth);
        player2.addContinent(theDothrakiSea);
        player3.addContinent(valyrianFreehold);
        player4.addContinent(theFreeCities);
        player5.addContinent(theSouth);
        player6.addContinent(theKingsLands);


        player1.setTerritoryColors();
        player2.setTerritoryColors();
        player3.setTerritoryColors();
        player4.setTerritoryColors();
        player5.setTerritoryColors();
        player6.setTerritoryColors();


        players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        players.add(player6);

        numberOfPlayers = 6;
        setCurrentPlayer();
        setBoard(phaseType.PLACE_TROOPS);
    }

    public void initTerritoryButton(Territory territory, int x, int y){

        territory.setStyle(" -fx-padding: 1 5 5 5;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 10;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #a34313 0%, #903b12 100%),\n" +
                "        #9d4024,\n" +
                "        #d86e3a,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #d86e3a, #c54e2c);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;");


//        territory.addEventHandler(MouseEvent.MOUSE_ENTERED,
//                new EventHandler<MouseEvent>() {
//                    @Override public void handle(MouseEvent e) {
//                        territory.setStyle("  -fx-padding: 1 5 5 5;\n" +
//                                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
//                                "    -fx-background-radius: 10;\n" +
//                                "    -fx-background-color: \n" +
//                                "        linear-gradient(from 0% 93% to 0% 100%, #02a300 0%, #34fa0c 100%),\n" +
//                                "        #1d9d33,\n" +
//                                "        #32d836,\n" +
//                                "        radial-gradient(center 50% 50%, radius 100%, #35d8ca, #c54e2c);\n" +
//                                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
//                                "    -fx-font-weight: bold;\n" +
//                                "    -fx-font-size: 1.1em;");
//                    }
//                });
//
//        territory.addEventHandler(MouseEvent.MOUSE_EXITED,
//                new EventHandler<MouseEvent>() {
//                    @Override public void handle(MouseEvent e) {
//                        territory.setStyle(" -fx-padding: 1 5 5 5;\n" +
//                                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
//                                "    -fx-background-radius: 10;\n" +
//                                "    -fx-background-color: \n" +
//                                "        linear-gradient(from 0% 93% to 0% 100%, #a34313 0%, #903b12 100%),\n" +
//                                "        #9d4024,\n" +
//                                "        #d86e3a,\n" +
//                                "        radial-gradient(center 50% 50%, radius 100%, #d86e3a, #c54e2c);\n" +
//                                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
//                                "    -fx-font-weight: bold;\n" +
//                                "    -fx-font-size: 1.1em;");
//                    }
//                });

        territory.setLayoutX(x);
        territory.setLayoutY(y);
        territory.setOnAction(e -> {
            URL swordClash = getClass().getResource("swordClash.mp3");
            AudioClip swords = new AudioClip(swordClash.toString());
            swords.play();
            System.out.println(territory.getCurrentOccupant().getName());
            if(buttonsActive) {
                switch (currentPhase) {
                    case PLACE_TROOPS:
                        if (currentPlayer.ownsTerritory(territory) && numberOfArmiesToRecieveCurrent > 0) {
                            territory.incrementTroopCount();
                            numberOfArmiesToRecieveCurrent--;
                            updateNumberOfArmiesToPlaceLabel();
                        }
                        break;
                    case ATTACK:

                        if (currentPlayer.getConqueredTerritories().contains(territory)) {
                            if (currentPlayer.getCurrentTerritory() != null) {
                                if (currentPlayer.getCurrentTerritory() == territory) {
                                    territory.deSelect();
                                    currentPlayer.resetCurrentTerritory();
                                    if (currentPlayer.getCurrentTerritoryToAttack() != null) {
                                        crestViewDefender.setVisible(false);
                                        currentPlayer.getCurrentTerritoryToAttack().deSelect();
                                        currentPlayer.resetCurrentTerritoryToAttack();
                                    }
                                }
                            } else {
                                currentPlayer.setCurrentTerritory(territory);
                                territory.select();
                            }
                        }
                        if (territory.canAttack(currentPlayer) && currentPlayer.getCurrentTerritory() != null) {
                            if (currentPlayer.getCurrentTerritoryToAttack() != null) {
                                if (currentPlayer.getCurrentTerritoryToAttack() == territory) {
                                    crestViewDefender.setVisible(false);
                                    territory.deselectForAttack();
                                    currentPlayer.resetCurrentTerritoryToAttack();
                                }
                            } else {
                                currentPlayer.setCurrentTerritoryToAttack(territory);
                                territory.selectForAttack();
                                setDefendCrest();
                            }
                        }
                        break;
                    case FORTIFY:

                        if (currentPlayer.ownsTerritory(territory)) {
                            if (currentPlayer.getCurrentTerritory() != null) {
                                if (currentPlayer.getCurrentTerritory() == territory) {
                                    currentPlayer.getCurrentTerritory().deSelect();
                                    currentPlayer.resetCurrentTerritory();
                                    if (currentPlayer.getCurrentTerritoryFortifyTo() != null) {
                                        currentPlayer.getCurrentTerritoryFortifyTo().deSelect();
                                        currentPlayer.resetCurrentTerritoryFortifyTo();
                                    }
                                } else {
                                    if (currentPlayer.getCurrentTerritory().sharesBorder(territory)) {
                                        if (currentPlayer.getCurrentTerritory().getTroopCount() > 1) {
                                            currentPlayer.getCurrentTerritory().decrementTroopCount();
                                            territory.incrementTroopCount();
                                            if (currentPlayer.getCurrentTerritory().getTroopCount() < 2) {
                                                currentPlayer.getCurrentTerritory().deSelect();
                                                currentPlayer.resetCurrentTerritory();
                                            }
                                        }
                                    } else {
                                        String tName = territory.getName();
                                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                        alert.setTitle("Fortify");
                                        alert.setHeaderText("'I'm afraid " + tName + " is out of reach, my lord'");
                                        alert.setContentText("Only territories which share a border with " +
                                                currentPlayer.getCurrentTerritory().getName() + " may be fortified.");
                                        alert.showAndWait();
                                    }
                                }
                            } else {
                                currentPlayer.setCurrentTerritory(territory);
                                territory.select();
                            }
                        }
                        break;
                }
            }
        });
        ((Group) boardScene.getRoot()).getChildren().add(territory);
    }

    public void initControlButtons(){

        crestViewAttacker = new ImageView();
        crestViewAttacker.setFitHeight(100);
        crestViewAttacker.setFitWidth(90);
        crestViewAttacker.setVisible(false);
        crestViewAttacker.setLayoutX(485);
        crestViewAttacker.setLayoutY(220);

        crestViewDefender = new ImageView();
        crestViewDefender.setFitHeight(100);
        crestViewDefender.setFitWidth(90);
        crestViewDefender.setVisible(false);
        crestViewDefender.setLayoutX(1035);
        crestViewDefender.setLayoutY(220);

        Image imagePlus = new Image(getClass().getResourceAsStream("plus.png"));
        Image imageMinus = new Image(getClass().getResourceAsStream("minus.png"));
        Image imageCheck = new Image(getClass().getResourceAsStream("check.png"));

        ImageView pView = new ImageView(imagePlus);
        ImageView mView = new ImageView(imageMinus);
        ImageView cView = new ImageView(imageCheck);

        pView.setFitHeight(10);
        pView.setFitWidth(10);
        mView.setFitHeight(10);
        mView.setFitWidth(10);
        cView.setFitHeight(10);
        cView.setFitWidth(10);

        plusButton = new Button("",pView);
        minusButton = new Button("",mView);
        checkButton = new Button("", cView);
        checkButton = new Button("", cView);

        plusButton.setPrefSize(10,10);
        minusButton.setPrefSize(10,10);
        checkButton.setPrefSize(10,10);

        setMoveTroopsButtonsVisible(false);

        plusButton.setOnAction(e-> {
            if(currentPlayer.getCurrentTerritory().getTroopCount() > 1) {
                currentPlayer.getCurrentTerritory().decrementTroopCount();
                currentPlayer.getCurrentTerritoryToAttack().incrementTroopCount();
            }
        });

        minusButton.setOnAction(e-> {
            if(currentPlayer.getCurrentTerritoryToAttack().getTroopCount() > 1) {
                currentPlayer.getCurrentTerritoryToAttack().decrementTroopCount();
                currentPlayer.getCurrentTerritory().incrementTroopCount();
            }
        });

        checkButton.setOnAction(e-> {
            minusButton.setVisible(false);
            plusButton.setVisible(false);
            checkButton.setVisible(false);
            buttonsActive = true;
            currentPlayer.resetCurrentTerritory();
            currentPlayer.resetCurrentTerritoryToAttack();
            rollButton.setVisible(true);
        });






        rollButton = new Button("Roll");
        doneButton = new Button("Done");
        chargeButton = new Button("Charge");
        bannerView = new ImageView();
        numberOfArmiesToPlaceLabel = new Label("Armies: " + String.valueOf(numberOfArmiesToRecieveCurrent));

        numberOfArmiesToPlaceLabel.setStyle(" -fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #434252 0%, #2b2b35 100%),\n" +
                "        #4b4b5d,\n" +
                "        #63637a,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #8484a3, #4b4b5d);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 3em;");

        numberOfArmiesToPlaceLabel.setLayoutX(700);
        numberOfArmiesToPlaceLabel.setLayoutY(210);
        //numberOfArmiesToPlaceLabel.setPrefSize(50,50);

        rollButton.setStyle("-fx-background-color: \n" +
                "        #090a0c,\n" +
                "        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" +
                "        linear-gradient(#20262b, #191d22),\n" +
                "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
                "    -fx-background-radius: 5,4,3,5;\n" +
                "    -fx-background-insets: 0,1,2,0;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
                "    -fx-font-family: \"Helvetica\";\n" +
                "    -fx-text-fill: linear-gradient(#ff3440, #d0d0d0);\n" +
                "    -fx-font-size: 20px;\n" +
                "    -fx-padding: 10 20 10 20;");
        doneButton.setStyle("-fx-background-color: \n" +
                "        #090a0c,\n" +
                "        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" +
                "        linear-gradient(#20262b, #191d22),\n" +
                "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
                "    -fx-background-radius: 5,4,3,5;\n" +
                "    -fx-background-insets: 0,1,2,0;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
                "    -fx-font-family: \"Helvetica\";\n" +
                "    -fx-text-fill: linear-gradient(#437aff, #d0d0d0);\n" +
                "    -fx-font-size: 20px;\n" +
                "    -fx-padding: 10 20 10 20;");

        rollButton.setLayoutX(100);
        rollButton.setLayoutY(800);
        rollButton.setOnAction(e -> {
            URL u = getClass().getResource("sword.aif");
            AudioClip sword = new AudioClip(u.toString());
            sword.setVolume(999999999);
            sword.play();
            if(currentPlayer.getCurrentTerritory() != null && currentPlayer.getCurrentTerritoryToAttack() != null) {
                if (currentPlayer.getCurrentTerritory().getTroopCount() > 1) {
                    Battle battle = new Battle(currentPlayer, 3, currentPlayer.getCurrentTerritory(),
                            currentPlayer.getCurrentTerritoryToAttack().getCurrentOccupant(), 2,
                            currentPlayer.getCurrentTerritoryToAttack());
                    battle.engage();

                    DiceAnimation[] attackerDice = new DiceAnimation[]{da,da2,da3};
                    ArrayList<Die> resultDiceAttacker = currentPlayer.getPlayerDice();

                    int index = 0;

                    for(DiceAnimation d : attackerDice){
                        int result = resultDiceAttacker.get(index).getFaceValue();
                        System.out.println("Attacker: " + result);
                        d.setFaceValue(result - 1);
                        index++;
                    }
                    DiceAnimation[] defenderDice = new DiceAnimation[]{da4,da5};
                    ArrayList<Die> resultDiceDefender = currentPlayer.getPlayerDice();

                    index = 0;

                    for(DiceAnimation d : defenderDice){
                        int result = resultDiceDefender.get(index).getFaceValue();
                        System.out.println("Defender: " + result);
                        d.setFaceValue(result - 1);
                        index++;
                    }
                    da.roll();
                    da2.roll();
                    da3.roll();
                    da4.roll();
                    da5.roll();
                }
            }

                if (currentPlayer.getCurrentTerritoryToAttack().getTroopCount() == 0) {

                    int offSetY = 25;

                    setMoveTroopsButtonsVisible(true);
                    rollButton.setVisible(false);
                    buttonsActive = false;

                    plusButton.setLayoutX(currentPlayer.getCurrentTerritoryToAttack().getLayoutX());
                    plusButton.setLayoutY(currentPlayer.getCurrentTerritoryToAttack().getLayoutY() - offSetY);

                    minusButton.setLayoutX(currentPlayer.getCurrentTerritoryToAttack().getLayoutX() - 30);
                    minusButton.setLayoutY(currentPlayer.getCurrentTerritoryToAttack().getLayoutY() - offSetY);

                    checkButton.setLayoutX(currentPlayer.getCurrentTerritoryToAttack().getLayoutX() + 30);
                    checkButton.setLayoutY(currentPlayer.getCurrentTerritoryToAttack().getLayoutY() - offSetY);
                    currentPlayer.getCurrentTerritoryToAttack().incrementTroopCount();
                    currentPlayer.getCurrentTerritory().decrementTroopCount();

                    currentPlayer.getCurrentTerritoryToAttack().getCurrentOccupant().removeTerritory(currentPlayer.getCurrentTerritoryToAttack());
                    currentPlayer.addTerritory(currentPlayer.getCurrentTerritoryToAttack());
                    currentPlayer.getCurrentTerritory().deSelect();
                    currentPlayer.getCurrentTerritoryToAttack().deSelect();
                    currentPlayer.setTerritoryColors();
                }

                if(currentPlayer.getCurrentTerritory().getTroopCount() < 2 && currentPlayer.getCurrentTerritoryToAttack().getTroopCount() != 0){
                    if(currentPlayer.getCurrentTerritory().getTroopCount() < 1)
                        currentPlayer.getCurrentTerritory().setTroopCount(1);
                    currentPlayer.getCurrentTerritory().deSelect();
                    currentPlayer.getCurrentTerritoryToAttack().deSelect();
                    currentPlayer.resetCurrentTerritory();
                    currentPlayer.resetCurrentTerritoryToAttack();

                }

        });

        doneButton.setLayoutX(210);
        doneButton.setLayoutY(800);
        doneButton.setOnAction(e -> {
            URL end = getClass().getResource("horn.mp3");
            AudioClip horn = new AudioClip(end.toString());
            horn.setVolume(999999999);
            horn.play();

            switch(currentPhase){
                case PLACE_TROOPS:
                    placeBanner();
                    if(numberOfArmiesToRecieveCurrent == 0){
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Choose Action");
                        alert.setHeaderText("Awaiting your decision, my lord.");
                        alert.setContentText("Attack or fortify?");

                        ButtonType attack = new ButtonType("Attack");
                        ButtonType fortify = new ButtonType("Fortify");

                        alert.getButtonTypes().setAll(attack, fortify);

                        Optional<ButtonType> result = alert.showAndWait();
                        if (result.get() == attack) {
                            setBoard(phaseType.ATTACK);

                        } else {
                            setBoard(phaseType.FORTIFY);
                        }
                        if(currentPhase == phaseType.PLACE_TROOPS){
                            System.out.println("Error: Failed to switch from PLACE_TROOPS.");
                        }
                    }else{
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Place Armies");
                        alert.setHeaderText("'The troops are awaiting your orders, my lord.'");
                        alert.setContentText("All armies must be placed to proceed!");
                        alert.showAndWait();
                    }
                    System.out.println("Phase: " + currentPhase.toString() +
                            "\nCurrent Player: " + currentPlayer.getName());
                    break;
                case ATTACK:
                    setBoard(phaseType.FORTIFY);
                    System.out.println("Phase: " + currentPhase.toString() +
                            "\nCurrent Player: " + currentPlayer.getName());
                    setMoveTroopsButtonsVisible(false);
                    crestViewAttacker.setVisible(false);
                    crestViewDefender.setVisible(false);
                    break;
                case FORTIFY:
                    setBoard(phaseType.PLACE_TROOPS);
                    moveToNextPlayer();
                    System.out.println("Phase: " + currentPhase.toString() +
                            "\nCurrent Player: " + currentPlayer.getName());
                    System.out.println("Turn Complete.");
                    placeBanner();
                    break;
                default:
                    System.out.println("Error: Phase not set.");
            }

        });
    }


    
    public void setBoard(phaseType phase){

        currentPhase = phase;
        currentPlayer.resetAllSelections();
        for(Territory t : allTerritories){
            if(t.getCurrentOccupant() != null)
                t.setColorStandard();
        }

        switch(currentPhase){
            case PLACE_TROOPS:
                numberOfArmiesToRecieveCurrent = currentPlayer.getNumberOfArmiesToRecieve();
                updateNumberOfArmiesToPlaceLabel();
                numberOfArmiesToPlaceLabel.setVisible(true);
                doneButton.setText("Done");
                rollButton.setVisible(false);
                chargeButton.setVisible(false);
                break;
            case ATTACK:
                rollButton.setVisible(true);
                System.out.println(rollButton.isVisible());
                numberOfArmiesToPlaceLabel.setVisible(false);
                doneButton.setText("End Turn");
                rollButton.setVisible(true);
                chargeButton.setVisible(true);
                setAttackCrest();
                break;
            case FORTIFY:
                rollButton.setVisible(false);
                numberOfArmiesToPlaceLabel.setVisible(false);
                doneButton.setText("Done");
                rollButton.setVisible(false);
                chargeButton.setVisible(false);
                break;
        }
    }

    public void fortify(){
        for(Territory t : allTerritories){
            if(!currentPlayer.getConqueredTerritories().contains(t)){
                t.setAvailable(false);
            }
        }

    }

    public void setAllTerritoriesInvisible(){
        for(Territory t : allTerritories){
            t.setAvailable(false);
        }
    }

    public void setAllTerritoriesVisible(){
        for(Territory t : allTerritories){
            t.setAvailable(true);
        }
    }

    public void updateNumberOfArmiesToPlaceLabel(){
        numberOfArmiesToPlaceLabel.setText("Armies: " + String.valueOf(numberOfArmiesToRecieveCurrent));
    }

    public void incrementPlayerIndex(){

        if(playerIndex + 1 == players.size())
            playerIndex = 0;
        else
            playerIndex++;
    }

    public void setCurrentPlayer(){
        currentPlayer = players.get(playerIndex);
    }

    public void moveToNextPlayer(){
        incrementPlayerIndex();
        setCurrentPlayer();
    }

    public void placeBanner(){
        currentPlayer.setBanner(bannerView);
    }

    public void setMoveTroopsButtonsVisible(boolean b){
        plusButton.setVisible(b);
        minusButton.setVisible(b);
        checkButton.setVisible(b);
    }

    public void setAttackCrest(){
        crestViewAttacker.setVisible(true);
        setCrest(currentPlayer.getName(), crestViewAttacker);
    }

    public void setDefendCrest(){
        crestViewDefender.setVisible(true);
        setCrest(currentPlayer.getCurrentTerritoryToAttack().getCurrentOccupant().getName(), crestViewDefender);
    }

    public void setCrest(String attackerName, ImageView crest){
        if(attackerName == "Baratheon"){
            Image imageBaratheon = new Image(getClass().getResourceAsStream("Baratheon.jpg"));
            crest.setImage(imageBaratheon);
        }else if(attackerName == "Greyjoy"){
            Image imageGreyjoy = new Image(getClass().getResourceAsStream("Greyjoy.jpg"));
            crest.setImage(imageGreyjoy);
        }else if(attackerName == "Lannister"){
            Image imageLannister = new Image(getClass().getResourceAsStream("Lannister.jpg"));
            crest.setImage(imageLannister);
        }else if(attackerName == "Martell"){
            Image imageMartell = new Image(getClass().getResourceAsStream("Martell.jpg"));
            crest.setImage(imageMartell);
        }else if(attackerName == "Tully"){
            Image imageTully = new Image(getClass().getResourceAsStream("Tully.jpg"));
            crest.setImage(imageTully);
        }else if(attackerName == "Targaryen"){
            Image imageTargaryen = new Image(getClass().getResourceAsStream("Targaryen.jpg"));
            crest.setImage(imageTargaryen);
        }
    }
}