package com;

import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Logger logger = null;
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        for(int i= 0; i<100; i++) {
            logger = Plogger.getLogger(String.valueOf(i));
            logger.info("Case" + String.valueOf(i));
        }

        for(int i= 0; i<100; i++) {
            logger = Plogger.getLogger(String.valueOf(i));
            logger.info("Case--" + String.valueOf(i));
        }



        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i= 0; i<100; i++) {
                    Logger logger = Plogger.getLogger(String.valueOf(i));
                    logger.info("thread1-" + String.valueOf(i));
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i= 0; i<100; i++) {
                    Logger logger2 = Plogger.getLogger(String.valueOf(i));
                    logger2.info("thread2-" + String.valueOf(i));
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i= 0; i<100; i++) {
                    Logger logger2 = Plogger.getLogger(String.valueOf(i));
                    logger2.info("thread3-" + String.valueOf(i));
                }
            }
        }).start();
   }
}
