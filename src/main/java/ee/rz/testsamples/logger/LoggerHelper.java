package ee.rz.testsamples.logger;

import java.io.IOException;
import org.apache.log4j.*;

public class LoggerHelper {

    /**
     * Method for creating custom log4j logger
     *
     * @param foldername folder name where the log file is created
     * @param classname class name of the test
     * @return log4j logger
     */

    public Logger setAppLogger(String foldername, String classname){
        Logger rootLogger = Logger.getLogger(LoggerHelper.class.getCanonicalName());
        Layout pattern = new PatternLayout("%d{MM-dd-yyyy HH:mm:ss,SSS} %-5p %c:%m%n");
        String path = foldername +"/" + classname + ".log";
        Appender newAppender = null;
        try {
            newAppender = new FileAppender(pattern, path, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        rootLogger.setAdditivity(false);
        rootLogger.setLevel(Level.INFO);
        rootLogger.addAppender(newAppender);
        return rootLogger;
    }
}

