package fr.lernejo.guessgame;
import fr.lernejo.logger.*;
import java.util.concurrent.TimeUnit;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {

        long number = player.askNextGuess();
        if (number == numberToGuess){
            logger.log("End");
            return true;
        }
        else {
            player.respond(number < numberToGuess);
            return false;
        }
    }

    public void loopUntilPlayerSucceed(long max) {
        boolean fin = false;
        long begin = System.currentTimeMillis();
        for(int i = 0; i<=max;i++)
        {
            fin = nextRound();
            if(fin)
                break;
        }
        long time = System.currentTimeMillis() - begin;
        String format = String.format("%02d:%02d.%02d",
            TimeUnit.MILLISECONDS.toMinutes(time),
            TimeUnit.MILLISECONDS.toSeconds(time),
            TimeUnit.MILLISECONDS.toMillis(time));
        if(!fin)
            logger.log("The player has lost");
        logger.log("Time taken : "+format);

    }
}

