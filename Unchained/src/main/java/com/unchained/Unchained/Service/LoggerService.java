package com.unchained.Unchained.Service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

//Copied from https://github.com/MathisHermann/TimBan

@Service
public class LoggerService {

    protected static final Logger logger = Logger.getLogger("MyLog");


    public static void logSystem(String level, String msg) {
        FileHandler fh = null;

        try {
            fh = new FileHandler("system_logs.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            if (msg.length() > 0) {
                switch (level) {
                    case "info":
                        logger.log(Level.INFO, msg);
                        break;
                    case "warning":
                        logger.log(Level.WARNING, msg);
                        break;
                    case "fine":
                        logger.log(Level.FINE, msg);
                        break;
                    case "finer":
                        logger.log(Level.FINER, msg);
                        break;
                    case "finest":
                        logger.log(Level.FINEST, msg);
                        break;
                    default:
                        logger.log(Level.CONFIG, msg);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fh != null)
                fh.close();
        }

    }



}
