import java.util.regex.Pattern;

public class CheckAlpha {
    void checkalpha(String guess) {
        if(!Pattern.matches("[a-zA-Z]+", guess ))
        {
            System.out.println("Wprowadz litere.");
        }
    }
}
