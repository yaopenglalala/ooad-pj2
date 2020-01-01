import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.AdminService;
import task.TaskDef;
import task.UserTask;
import task.point.FixPointStrategy;
import task.taskLife.TotalCountDownLifeCycleStrategy;

import static org.junit.Assert.*;

/**
 * 运营方在系统中发布一个任务。第一个难度级别只需要考虑任务的类型是不限次数的（消费，推荐用户等）
 * 可以在用户的任务列表中查询到这个任务
 */
public class Test1 {
    @Before
    public void setUp() throws Exception {
        System.out.println(" Test 1 begin! Good Luck!\n");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("\nTest 1 end! Are you satisfied?");
    }

    @Test
    public void testPublish(){
        AdminService service = new AdminService();
        service.addUser("MoonBird");
        assertEquals("MoonBird", service.getUserGroup().getUser("MoonBird").getName());

        TaskDef taskDef = new TaskDef("Task1");
        UserTask task = service.createTask(taskDef, new FixPointStrategy(10), new TotalCountDownLifeCycleStrategy(100));
        service.publishTask(task , "MoonBird");
        assertEquals(task, service.getPerformerGroup().getPerformer("MoonBird").getTask(taskDef));
    }
}
