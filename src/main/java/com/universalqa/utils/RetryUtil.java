package com.universalqa.utils;
import org.apache.logging.log4j.Logger;
import java.util.concurrent.Callable;

public class RetryUtil {
    public static <T> T retry(Callable<T> action, String actionName, String locator, Logger logger) {
        int attempts = 0;
        int maxRetries = 2;
        Exception lastException = null;

        while (attempts <= maxRetries) {
            try {
                return action.call();
            } catch (Exception e) {
                lastException = e;
                logger.warn("Attempt {} failed for {} on '{}': {}", attempts + 1, actionName, locator, e.getMessage());
                attempts++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {}
            }
        }

        logger.error("All retry attempts failed for {} on '{}'", actionName, locator, lastException);
        throw new RuntimeException("Retry failed for " + actionName + " on " + locator, lastException);
    }
}