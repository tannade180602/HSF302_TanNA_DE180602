package hsf301.fe.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
    private static final Logger logger = LogManager.getLogger(LoggingAspect.class);

    @Before("execution(* hsf301.fe.services.StudentServiceImpl.save(..))")
    public void logBefore() {
        System.out.println("LoggingAspect: Before method Save Student()");
        logger.info("LoggingAspect: Before method Save Student()");
    }

    @After("execution(* hsf301.fe.services.StudentServiceImpl.save(..))")
    public void logAfter() {
        System.out.println("LoggingAspect: After method Save Student()");
        logger.info("LoggingAspect: After method Save Student()");
    }
}
