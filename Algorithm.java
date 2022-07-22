package readability;

import java.util.Map;

import static java.util.Map.entry;

abstract class Algorithm {

    private Text text;
    private String name;
    private final Map<Integer, String> scoreAge = Map.ofEntries(
            entry(1, "5-6"),
            entry(2, "6-7"),
            entry(3, "7-9"),
            entry(4, "9-10"),
            entry(5, "10-11"),
            entry(6, "11-12"),
            entry(7, "12-13"),
            entry(8, "13-14"),
            entry(9, "14-15"),
            entry(10, "15-16"),
            entry(11, "16-17"),
            entry(12, "17-18"),
            entry(13, "18-24"),
            entry(14, "24+")
    );

    public Algorithm(String name) {
        this.name = name;
    }

    public static Algorithm getAlgorithm(String string) {
        switch (string) {
            case "ari":
                return new ARI();
            case "fk":
                return new FK();
            case "smog":
                return new SMOG();
            case "cl":
                return new CL();
            default:
                return null;
        }
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public abstract double calculateScore();

    public String evaluateAgeRange() {
        double score = calculateScore();
        int intScore = (int) score + 1;
        return scoreAge.get(intScore);
    }

    public double getAverageAge() {
        double score = calculateScore();
        int intScore = (int) score + 1;
        if (intScore >= 14) {
            return 24.0;
        }
        String[] range = scoreAge.get(intScore).split("-");
        int total = 0;
        for (String s : range) {
            total += Integer.parseInt(s);
        }
        return total / (double) range.length;
    }

    public void printScore() {
        double score = calculateScore();
        int intScore = (int) score + 1;
        System.out.printf("%s: %.2f (about %s-year-olds).%n", name, score, scoreAge.get(intScore));
    }
}
