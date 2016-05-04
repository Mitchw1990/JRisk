import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.Random;

public class DiceAnimation extends ImageView {
    // images shared amongst all instances of dice
    static private Image[] images = null;

    // position used for dragging die around
    private Double anchorX, anchorY;

    // used to remember if being dragged or not
    private boolean dragging = false;

    // animation used to spin the die
    private RotateTransition rotateAnimation;
    // animation used to change the image on the die and finally pick a new value
    private Timeline animation;

    // effects to display on the control
    private DropShadow shadow; // normal shadow for die
    private DropShadow longShadow; // shadow for when dragging
    private GaussianBlur blur; // blur for when spinning

    // face value displayed on the die
    private IntegerProperty value = new SimpleIntegerProperty(0);

    public int getValue() {
        return value.get();
    }

    public IntegerProperty valueProperty() {
        return value;
    }

    public DiceAnimation() {
        super();

        // load images
        loadImages();

        // attach listener to value so that image can be adjusted
        //attachImageUpdateBehaviour();

        // add drop shadow effect to die
        createEffects();

        // set the initial effect to the drop shadow
        setEffect(shadow);

        // make the die draggable
        attachDraggingBehaviour();

        // if double-left click die, then roll it
        attachClickingBehaviour();

        // create the animations that will be played when rolling the die
        createAnimations();

        // set initial value (and update image)
        roll();
    }

    private void createEffects() {
        // create drop shadow
        shadow = new DropShadow();
        shadow.setRadius(10);
        shadow.setOffsetX(5);
        shadow.setOffsetY(5);
        shadow.setColor(new Color(0, 0, 0, 0.5));

        // create long drop shadow
        longShadow = new DropShadow();
        longShadow.setRadius(10);
        longShadow.setOffsetX(10);
        longShadow.setOffsetY(10);
        longShadow.setColor(new Color(0, 0, 0, 0.5));

        // create blur
        blur = new GaussianBlur();
        blur.setRadius(4);
    }

    private void loadImages() {
        // have the images been loaded already (by another die)?
        if (images == null) {
            // the images have not been loaded yet, so load them
            images = new Image[6];

            for (int i = 1; i <= 6; i++) {
                Image image = new Image(Die.class.getResourceAsStream(i + ".png"));
                images[i - 1] = image;
            }
        }
    }

//    private void attachImageUpdateBehaviour() {
//        value.addListener((observable, oldValue, newValue) -> {
//            if ((newValue.intValue() >= 1) && (newValue.intValue() <= 6)) {
//                setImage(images[newValue.intValue() - 1]);
//            } else {
//                // invalid value, so set to 1 rather
//                value.setValue(1);
//            }
//        });
//    }

    private void attachClickingBehaviour() {
        setOnMouseClicked(event -> {
            if ((event.getButton() == MouseButton.PRIMARY) && (event.getClickCount() == 2)) {
                roll();
            }
        });
    }

    private void attachDraggingBehaviour() {
        // add event handling to allow the dialog to be dragged around by the title bar
        setOnMousePressed(event -> {
            // remember offset/displacement/anchor relative to top left corner
            if (event.getButton() == MouseButton.PRIMARY) {
                anchorX = event.getScreenX() - getX();
                anchorY = event.getScreenY() - getY();

                // bring this die to the top, i.e. won't be drawn underneath other die while moving
                toFront();
            }
        });

        setOnMouseDragged(event -> {
            // set top left corner of die so looks like moving at cursor
            if (event.getButton() == MouseButton.PRIMARY) {
                setX(event.getScreenX() - anchorX);
                setY(event.getScreenY() - anchorY);

                // if first time started dragging, change look of die
                if (!dragging) {
                    // make it look like die further away from screen
                    setEffect(longShadow);

                    setScaleX(1.1);
                    setScaleY(1.1);
                }
                dragging = true;
            }
        });

        setOnMouseReleased(event -> {
            // no longer being dragged
            if (dragging && (event.getButton() == MouseButton.PRIMARY)) {
                // so make it look closer to screen again
                setEffect(shadow);

                setScaleX(1);
                setScaleY(1);

                // no longer being dragged
                dragging = false;
            }
        });
    }

    private RotateTransition rotationAnimation = null;

    public void roll() {
        // start the animations
        rotationAnimation.playFromStart();
        animation.playFromStart();
    }

    public void setFaceValue(int i){
        setImage(images[i]);
    }

    private void createAnimations() {
        // set up a roll animation
        rotationAnimation = new RotateTransition();
        rotationAnimation.setDuration(new Duration(1000)); // 1 second
        rotationAnimation.setNode(this); // animate the Die itself
        rotationAnimation.setFromAngle(0); // starting angle
        rotationAnimation.setToAngle(360 * 3); // ending angle, i.e. rotate twice
        rotationAnimation.setAutoReverse(false); // don't want to reverse the animation
        rotationAnimation.setCycleCount(1); // only want to do the animation once
        rotationAnimation.setInterpolator(Interpolator.EASE_BOTH); // slowly start spinning, get faster, then slow down again

        animation = new Timeline();
        animation.getKeyFrames().add(new KeyFrame(new Duration(0), event -> {
            // at time zero, switch off the drop shadow add the blur instead
            setEffect(blur);
        }));
        for (int i = 0; i < 8; i++) {
            KeyFrame keyFrame = new KeyFrame(new Duration(i * 100), event -> {
                Random random = new Random();
                setImage(images[random.nextInt(6)]);
            });
            animation.getKeyFrames().add(keyFrame);
        }
        animation.getKeyFrames().add(new KeyFrame(new Duration(1000), event -> {
            // at time 1s, switch on the drop shadow remove the blur
            setEffect(shadow);
        }));

        // listen for when the animation is done, then pick a new number
        animation.setOnFinished(event -> {
            // rolls a new value for the die
            Random random = new Random();
            value.set(random.nextInt(6) + 1);
        });


    }
}

