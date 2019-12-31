import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.TaskService;
import task.TaskDef;
import task.UserTask;
import task.point.FixPointStrategy;
import task.taskLife.TaskLifeCycleStrategy;
import task.taskLife.TotalCountDownLifeCycleStrategy;
import user.User;

import static org.junit.Assert.*;

public class Test1 {
    @Before
    public void setUp() throws Exception {
        System.out.println(" Test 1 begin! Good Luck!");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Test 1 end! Are you satisfied?");
    }

    @Test
    public void testPublish(){
        TaskService service = new TaskService();
        service.addUser("MoonBird");
        assertEquals("MoonBird", service.getUserGroup().getUser("MoonBird").getName());

        TaskDef taskDef = new TaskDef("Task1");
        UserTask task = service.createTask(taskDef, new FixPointStrategy(10), new TotalCountDownLifeCycleStrategy(100));
        service.publishTask(task , "MoonBird");
        assertEquals(task, service.getPerformerGroup().getPerformer("MoonBird").getTask(taskDef));
    }
}
