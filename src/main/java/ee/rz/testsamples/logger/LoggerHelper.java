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

       public Logger setAppLogger(String foldername, String folderdate, String classname){
        Logger rootLogger = Logger.getLogger(LoggerHelper.class.getCanonicalName());
        Layout filePattern = new PatternLayout("%d{MM-dd-yyyy HH:mm:ss,SSS} %-5p %c:%m%n");
        Layout consolePattern = new PatternLayout("%m%n");
        String path = foldername + "/" + folderdate + "/" + classname + ".log";
        Appender fileAppender = null, consoleAppender = null;
        try {
            fileAppender = new FileAppender(filePattern, path, true);
            consoleAppender = new ConsoleAppender(consolePattern);
        } catch (IOException e) {
            e.printStackTrace();
        }
        rootLogger.setAdditivity(true);
        rootLogger.setLevel(Level.INFO);
        rootLogger.addAppender(fileAppender);
        rootLogger.addAppender(consoleAppender);
        return rootLogger;
    }
}
