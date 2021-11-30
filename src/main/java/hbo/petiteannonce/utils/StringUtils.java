package hbo.petiteannonce.utils;

import lombok.experimental.UtilityClass;

import java.util.Objects;

@UtilityClass
public final class StringUtils {

    /**
     * Concatenates <code>times</code> times the <code>word</code> and returns it.
     * If <code>times</code> equals 0, empty word is returned.
     * If the word is null, then null is returned.
     * @param word the word to repeat
     * @param times the number of times
     * @return the repeated word
     * @throws IllegalArgumentException if <code>times</code> < 0
     */
    public static String repeat(final String word, final int times) throws IllegalArgumentException{
        if(times<0)
            throw new IllegalArgumentException("Times cannot be negative");

        if(Objects.isNull(word))
            return null;

        if("".equals(word))
            return "";

        String repeatedWord = "";
        for(int i =1; i<= times; i++) {
            repeatedWord = repeatedWord.concat(word);
        }

        return repeatedWord;
    }
}
