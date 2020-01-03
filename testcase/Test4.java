import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.AdminService;
import task.TaskDef;
import task.TaskPerformer;
import task.UserTask;
import task.UserTaskStatus;
import task.point.FixPointStrategy;
import task.taskLife.*;

import static org.junit.Assert.assertEquals;

/**
 * 任务的类型可以是一次性的，每日限制次数的和不限次数的（比如活动现场签到为一次性，每日签到为每天限制一次）
 */
public class Test4 {
    @Before
    public void setUp() throws Exception {
        System.out.println(" Test 4 begin! Good Luck!\n");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("\nTest 4 end! Are you satisfied?");
    }

    @Test
    public void testPublish(){
        AdminService service = new AdminService();
        service.addUser("GuiTenBay");

        TaskDef oneLifeTaskDef = new TaskDef("一次性任务");
        UserTask oneLifeTask = service.createTask(oneLifeTaskDef, new FixPointStrategy(100), new OnceLifeCycleStrategy());
        service.publishTask(oneLifeTask, "GuiTenBay");

        TaskDef dailyTaskDef = new TaskDef("每日任务");
        UserTask dailyTask = service.createTask(dailyTaskDef, new FixPointStrategy(200), new DailyCountDownLifeCycleStrategy());
        service.publishTask(dailyTask, "GuiTenBay");

        TaskDef unlimitedTaskDef = new TaskDef("不限次任务");
        UserTask unlimitedTask = service.createTask(unlimitedTaskDef, new FixPointStrategy(300), new TotalCountDownLifeCycleStrategy());
        service.publishTask(unlimitedTask, "GuiTenBay");

        TaskPerformer performer = service.getPerformerGroup().getPerformer("GuiTenBay");
        System.out.println(performer.getTasksInfo());

        performer.completeTask(oneLifeTask, "一次性任务完成");
        performer.completeTask(dailyTask, "每日任务完成");
        performer.completeTask(unlimitedTask, "不限次任务完成");
        assertEquals(UserTaskStatus.Finished, performer.getTask(oneLifeTaskDef).getStatus());
        assertEquals(UserTaskStatus.Finished, performer.getTask(dailyTaskDef).getStatus());
        assertEquals(UserTaskStatus.Active, performer.getTask(unlimitedTaskDef).getStatus());

        performer.updateTasks();
        assertEquals(UserTaskStatus.Finished, performer.getTask(oneLifeTaskDef).getStatus());
        assertEquals(UserTaskStatus.Active, performer.getTask(dailyTaskDef).getStatus());
        assertEquals(UserTaskStatus.Active, performer.getTask(unlimitedTaskDef).getStatus());
    }
}
