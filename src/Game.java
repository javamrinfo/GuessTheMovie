import java.util.Scanner;
import java.util.regex.Pattern;


public class Game {

    private int numGuess = 0;
    private int numLoops = 0;
    private Boolean alreadyGuessedThatLetter = false;


    public void Start(String selectedMovie) {
        String hidden = new String(new char[selectedMovie.length()]).replace('\0', '_');
        String lettersGuessed = "";
        String fixedMovie = selectedMovie;


        //Start the game
        System.out.println("Zgadnij tytul filmu?");



        //fix movie title to remove colons, spaces, etc...
        char[] unwantedCharacters = {':', ' '};
        fixedMovie = fixedMovie.replace(":", "_");
        fixedMovie = fixedMovie.replace(" ", "_");
        fixedMovie = fixedMovie.replace(", ", "_");

        Scanner scanner = new Scanner(System.in);

        //Initial game loop
        for (int i = 20; i > 0; i--) {
            System.out.println("Pozostalo Ci  " + i + " strzalow. Probuj ponownie: ");
            System.out.println("Wprowadz litere. Liczy sie tylko pierwsza wprowadzona litera.");
            System.out.println("Do tej pory odgadles " + lettersGuessed);
            System.out.println("wykonales na ta chwile " + numGuess + " zgadywan.");
            System.out.println("Biezace slowo " + hidden);

            //System.out.println(selectedMovie);
            //System.out.println("Fixed movie: " + fixedMovie);
            String guess = scanner.nextLine();
            char currentGuess = guess.charAt(0);

            if (Pattern.matches("[a-zA-Z]+", guess)) {
                //If you already guessed once check to make sure its not the same letter.
                for (int x = 1; x <= numLoops; x++) {
                    if (currentGuess == lettersGuessed.charAt(x - 1)) {
                        System.out.println("Odgadles litere " + currentGuess);
                        i++;
                        numGuess++;
                        alreadyGuessedThatLetter = true;
                        break;
                    } else {
                        alreadyGuessedThatLetter = false;
                    }


                }
                //If this is not a letter that was already guessed
                //Check the logic to see where it is and reveal the letter in the word
                if (!alreadyGuessedThatLetter) {


                    for (int r = 0; r <= selectedMovie.length() - 1; r++) {
                        char current = selectedMovie.charAt(r);


                        //Convert answer to lowercase
                        currentGuess = Character.toLowerCase(currentGuess);
                        if (current == currentGuess) {
                            System.out.println("Odgadles prawidlowa litere");
                            char[] charHidden = hidden.toCharArray();
                            charHidden[r] = current;
                            hidden = String.valueOf(charHidden);

                        }

                        //Convert answer to uppercase
                        currentGuess = Character.toUpperCase(currentGuess);
                        if (current == currentGuess) {
                            System.out.println("Odgadles prawidlowa litere");
                            char[] charHidden = hidden.toCharArray();
                            charHidden[r] = current;
                            hidden = String.valueOf(charHidden);

                        }


                    }
                    lettersGuessed = lettersGuessed + currentGuess + ", ";
                    numGuess++;
                    numLoops++;
                }

                if (fixedMovie.equals(hidden)) {
                    System.out.println("Wygrales!");
                    System.out.println("Tytul filmu to " + selectedMovie);
                    break;
            }
            } else {
                System.out.println("Wprowadz litere.");
                i++;
            }



            }

        if (!fixedMovie.equals(hidden)) {
            System.out.println("Przegrales... :( ");

        }



    }
}
















