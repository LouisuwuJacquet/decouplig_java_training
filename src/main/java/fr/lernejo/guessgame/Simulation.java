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

    public void loopUntilPlayerSucceed(long max) {
        boolean end = this.nextRound();
        long limite = 0;
        long init = System.currentTimeMillis();
        while(!end && limite<max) {
            end=this.nextRound();
            limite++;
        }
        long timing = System.currentTimeMillis() - init;
        String time = String.format("%02d:%02d.%02d",
            TimeUnit.MILLISECONDS.toMinutes(timing),
            TimeUnit.MILLISECONDS.toSeconds(timing),
            TimeUnit.MILLISECONDS.toMillis(timing));
        if(end){
            System.out.println("You have won: "+numberToGuess+" was the solution. \n");
        }
        else{
            System.out.println("Even with "+limite+" attempts, you have lost! What a looser. The solution was : "+numberToGuess+".\n");
        }
        System.out.println("Time taken : " + time);
    }
}

