package readability;

public class FK extends Algorithm {

    public static String name = "Flesch–Kincaid readability tests";

    public FK() {
        super(name);
    }

    @Override
    public double calculateScore() {
        double words = getText().words();
        double sentences = getText().sentences();
        double syllables = getText().syllables();

        return 0.39 * (words / sentences)
                + 11.8 * (syllables / words) - 15.59;
    }
}
