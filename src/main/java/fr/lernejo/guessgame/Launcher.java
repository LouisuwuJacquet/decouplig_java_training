package fr.lernejo.guessgame;
import fr.lernejo.logger.*;
import java.security.SecureRandom;

public class Launcher {
    private static final Logger logger = LoggerFactory.getLogger("launcher");
    public static void main(String[] args) {
        if(args.length==0){
            logger.log("Haha, tu n'a pas de args");
        }
        else if (args[0].equals("-interactive")) {
            Player player = new HumanPlayer();
            Simulation simulation = new Simulation(player);
            SecureRandom random = new SecureRandom();
            long randomNumber = random.nextInt(100);
            simulation.initialize(randomNumber);
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
        }
        else if(args.length==1){
            System.out.println("Haha, tu n'a que 1 args");
        }
        else if (args[0].equals("-auto") && args[1].matches("[-+]?\\d*\\.?\\d+")) {
            Player player = new ComputerPlayer();
            Simulation simulation = new Simulation(player);
            simulation.initialize(Long.parseLong(args[1]));
            simulation.loopUntilPlayerSucceed(1000);
        }
        else{
            logger.log(""+"Please use either an interactive or an auto option");
        }
    }
}
