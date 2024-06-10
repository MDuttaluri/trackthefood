package com.inhouse.trackthefood.Helpers;

public class LoggerFactory {
    private static Logger logger;

    public static Logger getLogger(){
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }
}
