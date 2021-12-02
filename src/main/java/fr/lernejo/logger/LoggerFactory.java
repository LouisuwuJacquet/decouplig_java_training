package fr.lernejo.logger;
import java.nio.file.Paths;

public class LoggerFactory {
    public static Logger getLogger(String name){
        return new CompositeLogger(new ContextualLogger(name,new ConsoleLogger()), new ContextualLogger(name,new FileLogger(Paths.get("captain.log").toString())));
    }
}
