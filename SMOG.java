package readability;

public class SMOG extends Algorithm {

    public static String name = "Simple Measure of Gobbledygook";

    public SMOG() {
        super(name);
    }

    @Override
    public double calculateScore() {
        double sentences = getText().sentences();
        double polysyllables = getText().polysyllables();

        return 1.043 * Math.sqrt(polysyllables * 30.0 / sentences) + 3.1291;
    }
}
