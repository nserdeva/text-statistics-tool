package com.example.statistics.text;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Text analysis utility class for statistical purposes.
 *
 * <p>See <a href="https://gist.github.com/bnjns/d6f4ca4c43eb86ffd1acb12b94a95f1e">Text Statistics
 * Tool Specification</a>
 *
 * @author Natali Serdeva <natali.serdeva@example.com>
 * @since 06-Jun-22 - 10:29
 */
public final class TextAnalyzer {

  /** Regex defining how the texts should be split into separate words. */
  private static final String REGEX_SPLIT_WORDS = "[ .]+";

  /**
   * Retrieves the number of separate words in a given text.
   *
   * @param str Input text, always valid {@code String}.
   * @return Number of words.
   */
  public static int getWordsCount(final String str) {
    final String[] arrWords = getWords(str);
    return arrWords.length;
  }

  /**
   * Retrieves the top most frequent words in a given text.
   *
   * @param n Number of top most frequent words to be retrieved.
   * @param str Input text, always valid {@code String}.
   * @return Always valid {@code List} containing the {@code n} most frequent words in provided
   *     text, ordered by number of occurrences.
   */
  public static List<String> getMostFrequentWords(final int n, final String str) {
    final HashMap<String, Integer> mapWordOccurrences = getWordsOccurrences(str);

    final LinkedHashMap<String, Integer> mapWordOccurrencesSorted =
        mapWordOccurrences.entrySet().stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .collect(
                Collectors.toMap(
                    Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

    final List<String> listMostFrequentWords =
        mapWordOccurrencesSorted.keySet().stream().limit(n).collect(Collectors.toList());
    return listMostFrequentWords;
  }

  /**
   * Calculates the percentage of words corresponding to a requested number of occurrences in a
   * given text.
   *
   * @param occurrencesCount How many times a word should be present in the given text in order to
   *     be eligible for the result calculation.
   * @param str Input text, always valid {@code String}.
   * @return The rounded percentage {@code (0-100%)} of all the words in the given text which
   *     correspond to the requested number of occurrences.
   */
  public static int getWordsFrequencyPercentage(final int occurrencesCount, final String str) {
    final HashMap<String, Integer> mapWordOccurrences = getWordsOccurrences(str);

    final int totalWordsCount = mapWordOccurrences.size();

    final Set<String> wordsDesiredFrequency =
        mapWordOccurrences.entrySet().stream()
            .filter(entry -> occurrencesCount == entry.getValue())
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue))
            .keySet();

    final int wordsDesiredFrequencyCount = wordsDesiredFrequency.size();

    final int wordsFrequencyPercentage = wordsDesiredFrequencyCount * 100 / totalWordsCount;
    return wordsFrequencyPercentage;
  }

  /**
   * Internal helper method for retrieving the separate words in a given text.
   *
   * @param str Input text, always valid {@code String}.
   * @return {@code String} array representation of the words in the given text.
   */
  private static String[] getWords(final String str) {
    final String[] arrWords = str.split(REGEX_SPLIT_WORDS);
    return arrWords;
  }

  /**
   * Internal helper method for retrieving the number of occurrences of each word in a given text.
   *
   * @param str Input text, always valid {@code String}.
   * @return {@link HashMap} with words as keys, whereas the value indicates how many times a word
   *     is present in the given text.
   */
  private static HashMap<String, Integer> getWordsOccurrences(final String str) {
    final String[] arrWords = getWords(str);
    final HashMap<String, Integer> mapWordOccurrences = new HashMap<>();
    for (final String word : arrWords) {
      mapWordOccurrences.merge(word, 1, Integer::sum);
    }
    return mapWordOccurrences;
  }
}
