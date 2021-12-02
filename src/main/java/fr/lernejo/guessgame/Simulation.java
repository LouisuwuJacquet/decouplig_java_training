package fr.lernejo.guessgame;
import fr.lernejo.logger.*;

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
            return true;
        }
        else {
            if (number < numberToGuess) {
                player.respond(true);
                logger.log("The number must be greater");
            }
            else {
                player.respond(false);
                logger.log("The number must be lower");
            }
            return false;
        }
    }

    public void loopUntilPlayerSucceed() {
        boolean end = this.nextRound();
        while(!end) {
            end=this.nextRound();
        }
    }
}

