package readability;

public class Text {

    private String text;

    public Text(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int words() {
        return text.trim().split("\\s+").length;
    }

    public int sentences() {
        return text.trim().split("[.!?]").length;
    }

    public int characters() {
        return text.replaceAll("\\s+", "").length();
    }

    public int syllables() {
        String[] words = text.trim().split("\\s+");
        int counter = 0;
        for (String word : words) {
            Word wordObj = new Word(word);
            counter += wordObj.countSyllables();
        }
        return counter;
    }

    public int polysyllables() {
        String[] words = text.trim().split("\\s+");
        int counter = 0;
        for (String word : words) {
            Word wordObj = new Word(word);
            if (wordObj.isPolysyllable()) {
                counter++;
            }
        }
        return counter;
    }
}
