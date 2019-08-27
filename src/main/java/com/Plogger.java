package com;

import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.*;
import org.apache.log4j.helpers.NullEnumeration;

import java.io.IOException;


public class Plogger {
    public static Logger getLogger(String loggerName) {
        Logger logger = Logger.getLogger(loggerName);
        PatternLayout layout = new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n");
       // logger.getAllAppenders();
        Object obj = logger.getAllAppenders();
        //只有appender为空的时候，才创建RollingFileAppender
        if ( (obj == NullEnumeration.getInstance())) {
            System.out.println("appender is null");
            try {
                // 指定文件名，每个测试用例指定不同的文件
                RollingFileAppender fileAppender = new RollingFileAppender(layout, "./logs/" + loggerName + ".log");
                logger.addAppender(fileAppender);
            } catch (IOException e) {
                System.out.println("Failed to add appender!!");
            }
        }
        return logger;
    }
}
