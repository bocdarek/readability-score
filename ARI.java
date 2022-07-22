package readability;

public class ARI extends Algorithm {

    public static String name = "Automated Readability Index";

    public ARI() {
        super(name);
    }

    @Override
    public double calculateScore() {
        double characters = getText().characters();
        double words = getText().words();
        double sentences = getText().sentences();

        return 4.71 * (characters / words)
                + 0.5 * (words / sentences) - 21.43;
    }

}
