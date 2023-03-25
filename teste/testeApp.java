package teste;
import app.*;
import app.PatternHandler.Instrument;

import org.jfugue.player.Player;

import java.util.ArrayList;

import org.jfugue.pattern.Pattern;

public class testeApp {
    public static void main (String[] args) {
        Player player = new Player();
        // Cria um array de patterns 
        Pattern p1 = new Pattern("I[ACOUSTIC_BASS] X[Volume]=2000 A A A A B C C").setTempo(150);
        Pattern p2 = new Pattern("I[TROMBONE] X[Volume]=20 C A").setTempo(60);
        Pattern p3 = new Pattern("I[PIANO] X[Volume]=12200 C D E F G A B").setTempo(80);
        ArrayList<Pattern> patternsList = new ArrayList<Pattern>();
        patternsList.add(p1);
        patternsList.add(p2);
        patternsList.add(p3);
        // Cria um PatternHandler
        PatternHandler fullSound = new PatternHandler(100, 80, Instrument.PIANO, 0);
        Pattern musica = new Pattern();
        // A música é o resultado de todos os patterns juntos
        musica = fullSound.convertArrayOfPatternsToPattern(patternsList);
        player.play(musica);  
        // Salva o arquivo em .midi
        fullSound.savePatternToMidiFile(musica);   
    }
}
