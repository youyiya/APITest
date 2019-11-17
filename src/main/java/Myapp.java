import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;


/**
 * Created by Cuiping.ma on 2019/11/16 3:35 下午
 */
public class Myapp {

    // Define a static logger variable so that it references the
    // Logger instance named "MyApp".
    private static final Logger logger = LoggerFactory.getLogger(Myapp.class);

    @Test
    public void test1() {

        // Set up a simple configuration that logs on the console.
        logger.info("Entering application.");
        int a=3;
        if (a>2) {
            logger.error("Didn't do it.");
        }
        logger.info("Exiting application.");
    }
}
