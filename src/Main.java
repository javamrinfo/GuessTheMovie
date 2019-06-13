import java.util.Scanner;
import java.io.File;


public class Main {


    public static void main(String[] args) throws Exception {

        //Declare global variables
        int numOfMovies = 0;
        int randomMovie = 0;
        String selectedMovie ="";
        String movies = "";


        //Initialize classes
        File movieFile = new File("movies.txt");
        Scanner scanner = new Scanner(movieFile);

        //Get number of movies
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            movies += (line + "\n");
            numOfMovies++;
        }


        //Print test number of movies
        System.out.println("Liczba  filmow: " + numOfMovies);


        //Get random movie number based on text file
        randomMovie = (int) (Math.random() * numOfMovies);

        //Print test random movie number
        System.out.println("Losowy numer filmu: " + randomMovie);


        //Get selected Movie
        File movieFile2 = new File("movies.txt");
        Scanner scanner2 = new Scanner(movieFile2);
        int i = 0;
        while(i <= randomMovie) {
            selectedMovie = scanner2.nextLine();
            i++;
        }

        //System.out.println(selectedMovie);

        Game game = new Game();
        game.Start(selectedMovie);

    }

}

