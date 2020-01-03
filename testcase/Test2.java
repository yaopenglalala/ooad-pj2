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

import static org.junit.Assert.assertEquals;

/**
 * 用户查看可做的任务和任务的状态（已完成，或者待完成）
 */
public class Test2 {
    @Before
    public void setUp() throws Exception {
        System.out.println(" Test 2 begin! Good Luck!\n");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("\nTest 2 end! Are you satisfied?");
    }

    @Test
    public void testUserCheckTask(){
        AdminService service = new AdminService();
        service.addUser("MoonBird");

        TaskDef taskDef1 = new TaskDef("Task1");
        UserTask task1 = service.createTask(taskDef1, new FixPointStrategy(10), new TotalCountDownLifeCycleStrategy(100));
        service.publishTask(task1 , "MoonBird");

        TaskDef taskDef2 = new TaskDef("Task2");
        UserTask task2 = service.createTask(taskDef2, new FixPointStrategy(100), new DailyCountDownLifeCycleStrategy());
        service.publishTask(task2 , "MoonBird");

        TaskPerformer performer = service.getPerformerGroup().getPerformer("MoonBird");

        String expectedOut = "Type:TOTAL_COUNT Name:Task1 Point:10 Status:Active\nType:DAILY Name:Task2 Point:100 Status:Active\n";
        String realOut = performer.getTasksInfo();
        System.out.print(realOut);
        assertEquals(expectedOut, realOut);
    }
}
