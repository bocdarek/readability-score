package readability;

public class CL extends Algorithm {

    public static String name = "Coleman–Liau index";

    public CL() {
        super(name);
    }

    @Override
    public double calculateScore() {
        double characters = getText().characters();
        double words = getText().words();
        double sentences = getText().sentences();

        double L = characters / words * 100;
        double S = sentences / words * 100;

        return 0.0588 * L - 0.296 * S - 15.8;
    }
}
