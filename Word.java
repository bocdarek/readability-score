package readability;

public class Word {

    private final String vowels = "aeiouy";
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public int countSyllables() {
        if (word.charAt(word.length() - 1) == 'e') {
            word = word.substring(0, word.length() - 1) + "x";
        }
        char[] chars = word.toCharArray();
        int counter = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            if (vowels.contains(chars[i] + "") && !vowels.contains(chars[i + 1] + "")) {
                counter++;
            }
        }
        return counter == 0 ? 1 : counter;
    }

    public boolean isPolysyllable() {
        return countSyllables() > 2;
    }
}
