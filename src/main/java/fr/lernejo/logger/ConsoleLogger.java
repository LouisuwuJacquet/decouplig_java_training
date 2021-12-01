package fr.lernejo.logger;

import java.util.function.BiFunction;
import java.util.*;

public class ConsoleLogger implements Logger {
    @Override
    public void log(String message){
        System.out.println(message);
    }


}
