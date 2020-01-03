import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.AdminService;
import task.TaskDef;
import task.TaskPerformer;
import task.UserTask;
import task.point.FixPointStrategy;
import task.taskLife.DailyCountDownLifeCycleStrategy;
import task.taskLife.TotalCountDownLifeCycleStrategy;

/**
 * 用户可以查看当前积分总额和流水（即查看这些积分是如何获取的）
 */
public class Test3 {
    @Before
    public void setUp() throws Exception {
        System.out.println(" Test 3 begin! Good Luck!\n");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("\nTest 3 end! Are you satisfied?");
    }

    @Test
    public void testFlow() {
        AdminService service = new AdminService();
        service.addUser("MoonBird");

        TaskDef taskDef1 = new TaskDef("Task1");
        UserTask task1 = service.createTask(taskDef1, new FixPointStrategy(10), new TotalCountDownLifeCycleStrategy(100));
        service.publishTask(task1 , "MoonBird");

        TaskDef taskDef2 = new TaskDef("Task2");
        UserTask task2 = service.createTask(taskDef2, new FixPointStrategy(100), new DailyCountDownLifeCycleStrategy());
        service.publishTask(task2 , "MoonBird");

        TaskPerformer performer = service.getPerformerGroup().getPerformer("MoonBird");
        performer.completeTask(task1, "Complete Task1");
        performer.completeTask(task2, "Complete Task2");

        String realOut = performer.getAccount().getFlow().toString();
        System.out.print(realOut);
    }
}
