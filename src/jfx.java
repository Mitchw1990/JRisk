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
    private DiceAnimation da;
    private DiceAnimation da2;
    private DiceAnimation da3;
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

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage theStage)
    {
        numberOfArmiesToRecieveCurrent = 0;
        playerIndex = 0;

        URL url = getClass().getResource("got.mp3");
        AudioClip themesong = new AudioClip(url.toString());

        URL url2 = getClass().getResource("gotQuote.mp3");
        AudioClip quote = new AudioClip(url2.toString());


        //Dice *************************

        DiceAnimation da = new DiceAnimation();
        da.setFitHeight(80);
        da.setFitWidth(80);
        da.setLayoutX(400);
        da.setLayoutY(775);

        DiceAnimation da2 = new DiceAnimation();
        da2.setFitHeight(80);
        da2.setFitWidth(80);
        da2.setLayoutX(490);
        da2.setLayoutY(775);

        DiceAnimation da3 = new DiceAnimation();
        da3.setFitHeight(80);
        da3.setFitWidth(80);
        da3.setLayoutX(580);
        da3.setLayoutY(775);

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
            ((Group) boardScene.getRoot()).getChildren().addAll(rollButton, doneButton, numberOfArmiesToPlaceLabel, bannerView);
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
        ((Group) boardScene.getRoot()).getChildren().addAll( menuBar, da,da2,da3);


        //Board ************************


        //init territories**********************
        theWall = new Territory("theWall");
        initTerritoryButton(theWall, 320, 95);

        skagos = new Territory("skagos");
        initTerritoryButton(skagos, 390, 95);

        theGrevCliffs = new Territory("theGrevCliffs");
        initTerritoryButton(theGrevCliffs, 360, 160);

        winterfell = new Territory("winterfell");
        initTerritoryButton(winterfell, 300, 230);

        theNeck = new Territory("theNeck");
        initTerritoryButton(theNeck, 240, 300);

        theFlintCliff = new Territory("theFlintCliff");
        initTerritoryButton(theFlintCliff, 190, 335);

        theRills = new Territory("theRills");
        initTerritoryButton(theRills, 140, 260);

        wolfsrvood = new Territory("wolfsrvood");
        initTerritoryButton(wolfsrvood, 180, 190);

        theVale = new Territory("theVale");
        initTerritoryButton(theVale, 320, 420);

        crorvnlands = new Territory("crorvnlands");
        initTerritoryButton(crorvnlands, 300, 495);

        westerlands = new Territory("westerlands");
        initTerritoryButton(westerlands, 170, 500);

        riverlands = new Territory("riverlands");
        initTerritoryButton(riverlands, 140, 425);

        ironIslands = new Territory("ironIslands");
        initTerritoryButton(ironIslands, 80, 395);

        theReach = new Territory("theReach");
        initTerritoryButton(theReach, 250, 515);

        stormlands = new Territory("stormlands");
        initTerritoryButton(stormlands, 320, 580);

        dorne = new Territory("dorne");
        initTerritoryButton(dorne, 320, 680);

        redMountains = new Territory("redMountains");
        initTerritoryButton(redMountains, 205, 655);

        whisperingSound = new Territory("whisperingSound");
        initTerritoryButton(whisperingSound, 145, 655);

        shieldLands = new Territory("shieldLands");
        initTerritoryButton(shieldLands, 145, 580);

        braavosianCoastland = new Territory("braavosianCoastland");
        initTerritoryButton(braavosianCoastland, 525, 370);

        hillsOfNorvos = new Territory("hillsOfNorvos");
        initTerritoryButton(hillsOfNorvos, 595, 465);

        qhoyneLands = new Territory("qhoyneLands");
        initTerritoryButton(qhoyneLands, 655, 505);

        forrestOfQohor = new Territory("forrestOfQohor");
        initTerritoryButton(forrestOfQohor, 770, 490);

        theGoldenFields = new Territory("theGoldenFields");
        initTerritoryButton(theGoldenFields, 595, 600);

        theDisputedLands = new Territory("theDisputedLands");
        initTerritoryButton(theDisputedLands, 595, 670);

        andalos = new Territory("andalos");
        initTerritoryButton(andalos, 545, 495);

        rhoynianVeld = new Territory("rhoynianVeld");
        initTerritoryButton(rhoynianVeld, 715, 565);

        westernWaste = new Territory("westernWaste");
        initTerritoryButton(westernWaste, 770, 620);

        seaOfsighs = new Territory("seaOfsighs");
        initTerritoryButton(seaOfsighs, 820, 640);

        elyria = new Territory("elyria");
        initTerritoryButton(elyria, 840, 710);

        valyria = new Territory("valyria");
        initTerritoryButton(valyria, 815, 805);

        sarMell = new Territory("sarMell");
        initTerritoryButton(sarMell, 710, 665);

        sarnor = new Territory("sarnor");
        initTerritoryButton(sarnor, 860, 430);

        abandonedLand = new Territory("abandonedLand");
        initTerritoryButton(abandonedLand, 970, 470);

        kingdomsOfTheIfeqevron = new Territory("kingdomsOfTheIfeqevron");
        initTerritoryButton(kingdomsOfTheIfeqevron, 1095, 485);

        theFootprint = new Territory("theFootprint");
        initTerritoryButton(theFootprint, 1200, 395);

        jbben = new Territory("theFootprint");
        initTerritoryButton(jbben, 1200, 215);

        realmsOfShogran = new Territory("realmsOfShogran");
        initTerritoryButton(realmsOfShogran, 1360, 370);

        vaesDothrak = new Territory("vaesDothrak");
        initTerritoryButton(vaesDothrak, 1240, 465);

        easternGrassSea = new Territory("easternGrassSea");
        initTerritoryButton(easternGrassSea, 1190, 550);

        westernGrassSea = new Territory("westernGrassSea");
        initTerritoryButton(westernGrassSea, 1030, 540);

        parchedFields = new Territory("parchedFields");
        initTerritoryButton(parchedFields, 890, 560);

        paintedMountains = new Territory("paintedMountains");
        initTerritoryButton(paintedMountains, 890, 610);

        slaversBay = new Territory("slaversBay");
        initTerritoryButton(slaversBay, 1040, 690);

        lhazar = new Territory("lhazar");
        initTerritoryButton(lhazar, 1110, 650);

        samyrianHills = new Territory("samyrianHills");
        initTerritoryButton(samyrianHills, 1280, 595);

        bayasabhad = new Territory("bayasabhad");
        initTerritoryButton(bayasabhad, 1285, 675);

        qarth = new Territory("qarth");
        initTerritoryButton(qarth, 1285, 745);

        redWaste = new Territory("redWaste");
        initTerritoryButton(redWaste, 1170, 735);

        ghiscar = new Territory("ghiscar");
        initTerritoryButton(ghiscar, 1060, 785);

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
            System.out.println("clicked");
            URL swordClash = getClass().getResource("swordClash.mp3");
            AudioClip swords = new AudioClip(swordClash.toString());
            swords.play();

            switch(currentPhase){
                case PLACE_TROOPS:
                    if(currentPlayer.ownsTerritory(territory) && numberOfArmiesToRecieveCurrent > 0){
                            territory.incrementTroopCount();
                            numberOfArmiesToRecieveCurrent--;
                            updateNumberOfArmiesToPlaceLabel();
                        }
                    break;
                case ATTACK:
                   if(currentPlayer.ownsTerritory(territory)){
                       if(currentPlayer.getCurrentTerritory() != null){
                           if(currentPlayer.getCurrentTerritory() == territory) {
                               territory.deSelect();
                               currentPlayer.resetCurrentTerritory();
                               if(currentPlayer.getCurrentTerritoryToAttack() != null){
                                   currentPlayer.getCurrentTerritoryToAttack().deSelect();
                                   currentPlayer.resetCurrentTerritoryToAttack();
                               }
                           }
                       }else {
                           currentPlayer.setCurrentTerritory(territory);
                           territory.select();
                       }
                   }
                    if(territory.canAttack(currentPlayer) && currentPlayer.getCurrentTerritory() != null){
                        if(currentPlayer.getCurrentTerritoryToAttack() != null){
                            if(currentPlayer.getCurrentTerritoryToAttack() == territory) {
                                territory.deselectForAttack();
                                currentPlayer.resetCurrentTerritoryToAttack();
                            }
                        }else {
                            currentPlayer.setCurrentTerritoryToAttack(territory);
                            territory.selectForAttack();
                        }
                    }
                    break;
                case FORTIFY:

                    if(currentPlayer.ownsTerritory(territory)){
                        if(currentPlayer.getCurrentTerritory() != null){
                            if(currentPlayer.getCurrentTerritory() == territory){
                                currentPlayer.getCurrentTerritory().deSelect();
                                currentPlayer.resetCurrentTerritory();
                                if(currentPlayer.getCurrentTerritoryFortifyTo() != null){
                                    currentPlayer.getCurrentTerritoryFortifyTo().deSelect();
                                    currentPlayer.resetCurrentTerritoryFortifyTo();
                                }
                            }else{
                                if(currentPlayer.getCurrentTerritory().sharesBorder(territory)){
                                    if(currentPlayer.getCurrentTerritory().getTroopCount() > 1){
                                        currentPlayer.getCurrentTerritory().decrementTroopCount();
                                        territory.incrementTroopCount();
                                        if(currentPlayer.getCurrentTerritory().getTroopCount() < 2){
                                            currentPlayer.getCurrentTerritory().deSelect();
                                            currentPlayer.resetCurrentTerritory();
                                        }
                                    }
                                }else {
                                    String tName = territory.getName();
                                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                    alert.setTitle("Fortify");
                                    alert.setHeaderText("'I'm afraid " + tName + " is out of reach, my lord'");
                                    alert.setContentText("Only territories which share a border with " +
                                            currentPlayer.getCurrentTerritory().getName() + " may be fortified.");
                                    alert.showAndWait();
                                }
                            }
                        }else{
                            currentPlayer.setCurrentTerritory(territory);
                            territory.select();
                        }
                    }
                    break;
            }
        });
        ((Group) boardScene.getRoot()).getChildren().add(territory);
    }

    public void initControlButtons(){
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
            System.out.println("clickedAttack");
            URL u = getClass().getResource("sword.aif");
            AudioClip sword = new AudioClip(u.toString());
            sword.setVolume(999999999);
            sword.play();
            if(currentPlayer.getCurrentTerritory() != null && currentPlayer.getCurrentTerritoryToAttack() != null) {
                if (currentPlayer.getCurrentTerritory().getTroopCount() > 2) {
                    Battle battle = new Battle(currentPlayer, 3, currentPlayer.getCurrentTerritory(),
                            currentPlayer.getCurrentTerritoryToAttack().getCurrentOccupant(), 2,
                            currentPlayer.getCurrentTerritoryToAttack());
                    battle.engage();
                }

                if (currentPlayer.getCurrentTerritoryToAttack().getTroopCount() == 0) {
                    currentPlayer.getCurrentTerritoryToAttack().incrementTroopCount();
                    currentPlayer.getCurrentTerritory().decrementTroopCount();
                    currentPlayer.addTerritory(currentPlayer.getCurrentTerritoryToAttack());
                    currentPlayer.getCurrentTerritoryToAttack().getCurrentOccupant().removeTerritory(currentPlayer.getCurrentTerritoryToAttack());
                    currentPlayer.getCurrentTerritory().deSelect();
                    currentPlayer.resetCurrentTerritory();
                    currentPlayer.getCurrentTerritoryToAttack().deSelect();
                    currentPlayer.resetCurrentTerritoryToAttack();
                    currentPlayer.setTerritoryColors();
                }
            }

        });

        doneButton.setLayoutX(210);
        doneButton.setLayoutY(800);
        doneButton.setOnAction(e -> {
            System.out.println("clickedDone");
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
}