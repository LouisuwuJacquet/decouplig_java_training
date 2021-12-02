package fr.lernejo.guessgame;
import fr.lernejo.logger.*;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("player");

    @Override
    public long askNextGuess() {
        Scanner myLong = new Scanner(System.in);  // Create a Scanner object
        long nbr = myLong.nextLong();
        logger.log("" + nbr);
        return nbr;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        //cd n'est pas une question de savoir si il est dans l'interval, mais si il est trop petit(cas1) ou trop grand(cas2)
        if(lowerOrGreater){
            logger.log("Please, choose a greater number");
        }
        else{
            logger.log("Please, choose a lesser number");
        }

    }


}
