import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;


public class jfx extends Application{
    private Scene theScene;
    private  Scene menuScene;

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

        Button play = new Button("Play");
        play.setLayoutY(365);
        play.setLayoutX(50);
        play.setPrefSize(600,25);
        play.setOnAction(e ->{
            theStage.setScene(theScene);
            themesong.stop();
            quote.play(.2);
            theStage.centerOnScreen();
        });
        play.setStyle(" -fx-background-color: \n" +
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
                        "House Martel",
                        "House Tully"
                );
        ObservableList<String> numberOfPlayers =
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

        ComboBox numberPlayersCombo = new ComboBox(numberOfPlayers);
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

        menuRoot.getChildren().addAll(logo,play, familyCombo, familyLabel, numberPlayersCombo, numberPlayersLabel, quitButton);
        //MainMenu ************************


        //Board ************************
        final double initWidth = 1480;
        final double initHeight = 920;

        theStage.setTitle("RiskGOT");
        Group root = new Group();
        Canvas canvas = new Canvas( initWidth, initHeight );
        root.getChildren().add( canvas );
        theScene = new Scene(root, initWidth, initHeight);
        theStage.setScene(menuScene);
        theStage.initStyle(StageStyle.UNDECORATED);
        Image backGround = new Image(getClass().getResourceAsStream("westerosMap.jpg"));
        GraphicsContext mainMenuGc = canvas.getGraphicsContext2D();
        mainMenuGc.drawImage( backGround, 0, 0, initWidth, initHeight );

        Button attackButton = new Button("Attack");
        Button endTurnButton = new Button("End Turn");

        attackButton.setStyle("-fx-background-color: \n" +
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
        endTurnButton.setStyle("-fx-background-color: \n" +
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

        attackButton.setLayoutX(100);
        attackButton.setLayoutY(800);
        attackButton.setOnAction(e -> {
            System.out.println("clickedAttack");
            URL u = getClass().getResource("sword.aif");
            AudioClip sword = new AudioClip(u.toString());
            sword.setVolume(999999999);
            sword.play();
            da.roll();
            da2.roll();
            da3.roll();
        });

        endTurnButton.setLayoutX(210);
        endTurnButton.setLayoutY(800);
        endTurnButton.setOnAction(e -> {
            System.out.println("clickedDefend");
            URL end = getClass().getResource("horn.mp3");
            AudioClip horn = new AudioClip(end.toString());
            horn.setVolume(999999999);
            horn.play();
        });

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
        ((Group)theScene.getRoot()).getChildren().addAll(attackButton, endTurnButton, menuBar, da,da2,da3);
        //Board ************************





        //init territories**********************
        theWall = new Territory("theWall");
        initButton(theWall, 320, 95);
        skagos = new Territory("skagos");
        initButton(skagos, 390, 95);
        theGrevCliffs = new Territory("theGrevCliffs");
        initButton(theGrevCliffs, 360, 160);

        winterfell = new Territory("winterfell");
        initButton(winterfell, 300, 230);

        theNeck = new Territory("theNeck");
        initButton(theNeck, 240, 300);

        theFlintCliff = new Territory("theFlintCliff");
        initButton(theFlintCliff, 190, 335);

        theRills = new Territory("theRills");
        initButton(theRills, 140, 260);

        wolfsrvood = new Territory("wolfsrvood");
        initButton(wolfsrvood, 180, 190);

        theVale = new Territory("theVale");
        initButton(theVale, 320, 420);

        crorvnlands = new Territory("crorvnlands");
        initButton(crorvnlands, 300, 495);

        westerlands = new Territory("westerlands");
        initButton(westerlands, 170, 500);

        riverlands = new Territory("riverlands");
        initButton(riverlands, 140, 425);

        ironIslands = new Territory("ironIslands");
        initButton(ironIslands, 80, 395);

        theReach = new Territory("theReach");
        initButton(theReach, 250, 515);

        stormlands = new Territory("stormlands");
        initButton(stormlands, 320, 580);

        dorne = new Territory("dorne");
        initButton(dorne, 320, 680);

        redMountains = new Territory("redMountains");
        initButton(redMountains, 205, 655);

        whisperingSound = new Territory("whisperingSound");
        initButton(whisperingSound, 145, 655);

        shieldLands = new Territory("shieldLands");
        initButton(shieldLands, 145, 580);

        braavosianCoastland = new Territory("braavosianCoastland");
        initButton(braavosianCoastland, 525, 370);

        hillsOfNorvos = new Territory("hillsOfNorvos");
        initButton(hillsOfNorvos, 595, 465);

        qhoyneLands = new Territory("qhoyneLands");
        initButton(qhoyneLands, 655, 505);

        forrestOfQohor = new Territory("forrestOfQohor");
        initButton(forrestOfQohor, 770, 490);

        theGoldenFields = new Territory("theGoldenFields");
        initButton(theGoldenFields, 595, 600);

        theDisputedLands = new Territory("theDisputedLands");
        initButton(theDisputedLands, 595, 670);

        andalos = new Territory("andalos");
        initButton(andalos, 545, 495);

        rhoynianVeld = new Territory("rhoynianVeld");
        initButton(rhoynianVeld, 715, 565);

        westernWaste = new Territory("westernWaste");
        initButton(westernWaste, 770, 620);

        seaOfsighs = new Territory("seaOfsighs");
        initButton(seaOfsighs, 820, 640);

        elyria = new Territory("elyria");
        initButton(elyria, 840, 710);

        valyria = new Territory("valyria");
        initButton(valyria, 815, 805);

        sarMell = new Territory("sarMell");
        initButton(sarMell, 710, 665);

        sarnor = new Territory("sarnor");
        initButton(sarnor, 860, 430);

        abandonedLand = new Territory("abandonedLand");
        initButton(abandonedLand, 970, 470);

        kingdomsOfTheIfeqevron = new Territory("kingdomsOfTheIfeqevron");
        initButton(kingdomsOfTheIfeqevron, 1095, 485);

        theFootprint = new Territory("theFootprint");
        initButton(theFootprint, 1200, 395);

        jbben = new Territory("theFootprint");
        initButton(jbben, 1200, 215);

        realmsOfShogran = new Territory("realmsOfShogran");
        initButton(realmsOfShogran, 1360, 370);

        vaesDothrak = new Territory("vaesDothrak");
        initButton(vaesDothrak, 1240, 465);

        easternGrassSea = new Territory("easternGrassSea");
        initButton(easternGrassSea, 1190, 550);

        westernGrassSea = new Territory("westernGrassSea");
        initButton(westernGrassSea, 1030, 540);

        parchedFields = new Territory("parchedFields");
        initButton(parchedFields, 890, 560);

        paintedMountains = new Territory("paintedMountains");
        initButton(paintedMountains, 890, 610);

        slaversBay = new Territory("slaversBay");
        initButton(slaversBay, 1040, 690);

        lhazar = new Territory("lhazar");
        initButton(lhazar, 1110, 650);

        samyrianHills = new Territory("samyrianHills");
        initButton(samyrianHills, 1280, 595);

        bayasabhad = new Territory("bayasabhad");
        initButton(bayasabhad, 1285, 675);

        qarth = new Territory("qarth");
        initButton(qarth, 1285, 745);

        redWaste = new Territory("redWaste");
        initButton(redWaste, 1170, 735);

        ghiscar = new Territory("ghiscar");
        initButton(ghiscar, 1060, 785);

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

    public void initButton(Territory territory, int x, int y){

        territory.setStyle("  -fx-padding: 1 5 5 5;\n" +
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


        territory.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        territory.setStyle("  -fx-padding: 1 5 5 5;\n" +
                                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                                "    -fx-background-radius: 10;\n" +
                                "    -fx-background-color: \n" +
                                "        linear-gradient(from 0% 93% to 0% 100%, #02a300 0%, #34fa0c 100%),\n" +
                                "        #1d9d33,\n" +
                                "        #32d836,\n" +
                                "        radial-gradient(center 50% 50%, radius 100%, #35d8ca, #c54e2c);\n" +
                                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                                "    -fx-font-weight: bold;\n" +
                                "    -fx-font-size: 1.1em;");
                    }
                });

        territory.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        territory.setStyle("-fx-padding: 1 5 5 5;\n" +
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
                    }
                });

        territory.setLayoutX(x);
        territory.setLayoutY(y);
        territory.setOnAction(e -> {
            System.out.println("clicked");
            URL swordClash = getClass().getResource("swordClash.mp3");
            AudioClip swords = new AudioClip(swordClash.toString());
            swords.play();
        });
        ((Group)theScene.getRoot()).getChildren().add(territory);
    }



}