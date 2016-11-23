package exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Created by lixianch on 2016/11/22.
 */
class LoggingException extends Exception{
    private static Logger logger = Logger.getLogger("LoggingException");
    public LoggingException(){
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
public class LoggingExceptions {
    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Catch :" + e);
        }

        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Catch " + e);
        }
    }
}
