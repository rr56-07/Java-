import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class TimeoutTest {
    @Test
    @Timeout(value = 5,unit = TimeUnit.SECONDS)
    void testLongRunningTask() throws InterruptedException{
        TaskRunner task = new TaskRunner();
        String res = task.TaskRunnerTask();
        assertEquals("Task Completed",res);
    }
}