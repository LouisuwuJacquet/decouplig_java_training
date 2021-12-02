
package fr.lernejo.guessgame;
import fr.lernejo.logger.*;
import java.util.Scanner;
import java.security.SecureRandom;

public class ComputerPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("computer");

    @Override
    public long askNextGuess() {
        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextLong(1000);
        logger.log(""+randomNumber);
        return randomNumber;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        //cd n'est pas une question de savoir si il est dans l'interval, mais si il est trop petit(cas1) ou trop grand(cas2)

    }


}
