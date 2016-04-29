public class Die{

    private int MAX = 6; //max face value
    private int faceValue; // current value showing on the die

    public Die() {
        faceValue = 0;
    }

    public int roll() {
        faceValue = (int) (Math.random() * MAX) + 1;
        return faceValue;
    }

    public void setFaceValue(int value) {
        if (value > 0 && value <= MAX)
            faceValue = value;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public String toString() {
        String result = Integer.toString(faceValue);
        return result;
    }
}