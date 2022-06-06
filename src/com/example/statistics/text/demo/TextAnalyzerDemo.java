package com.example.statistics.text.demo;

import com.example.statistics.text.TextAnalyzer;
import java.util.List;

/**
 * Class for demonstration purposes regarding the functionality of the {@link TextAnalyzer}.
 *
 * @author Natali Serdeva <natali.serdeva@example.com>
 * @since 06-Jun-22 - 16:48
 */
public class TextAnalyzerDemo {

  public static void main(String[] args) {
    final String str =
        "lorem ipsum dolor sit amet consectetur lorem ipsum et mihi quoniam et adipiscing elit.sed quoniam et advesperascit et mihi ad villam revertendum est nunc quidem hactenus ex rebus enim timiditas non ex vocabulis nascitur.nummus in croesi divitiis obscuratur pars est tamen divitiarum.nam quibus rebus efficiuntur voluptates eae non sunt in potestate sapientis.hoc mihi cum tuo fratre convenit.qui ita affectus beatum esse numquam probabis duo reges constructio interrete.de hominibus dici non necesse est.eam si varietatem diceres intellegerem ut etiam non dicente te intellego parvi enim primo ortu sic iacent tamquam omnino sine animo sint.ea possunt paria non esse.quamquam tu hanc copiosiorem etiam soles dicere.de quibus cupio scire quid sentias.universa enim illorum ratione cum tota vestra confligendum puto.ut nemo dubitet eorum omnia officia quo spectare quid sequi quid fugere debeant nunc vero a primo quidem mirabiliter occulta natura est nec perspici nec cognosci potest.videmusne ut pueri ne verberibus quidem a contemplandis rebus perquirendisque deterreantur sunt enim prima elementa naturae quibus auctis virtutis quasi germen efficitur.nam ut sint illa vendibiliora haec uberiora certe sunt.cur deinde metrodori liberos commendas.mihi inquam qui te id ipsum rogavi nam adhuc meo fortasse vitio quid ego quaeram non perspicis.quibus ego vehementer assentior.cur iustitia laudatur mihi enim satis est ipsis non satis.quid est enim aliud esse versutum nobis heracleotes ille dionysius flagitiose descivisse videtur a stoicis propter oculorum dolorem.diodorus eius auditor adiungit ad honestatem vacuitatem doloris.nos quidem virtutes sic natae sumus ut tibi serviremus aliud negotii nihil habemus.";

    // 1. How many words are there in the text (including duplicates)?
    final int wordsCount = TextAnalyzer.getWordsCount(str);
    System.out.println("Total words count: " + wordsCount);

    // 2. Which six words occur the most in the text?
    final List<String> listMostFrequentWords = TextAnalyzer.getMostFrequentWords(6, str); // 260
    System.out.println(
        "Top 6 most frequent words: "
            + listMostFrequentWords); // [non, est, enim, quid, ut, mihi]

    // 3. What percentage of the words only occur once?
    final float wordsFrequencyPercentage = TextAnalyzer.getWordsFrequencyPercentage(1, str);
    System.out.println(
        "Total percentage of words occurring once: " + wordsFrequencyPercentage + "%"); // 82.0%
  }
}
