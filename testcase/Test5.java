import commodity.Commodity;
import commodity.CommoditySpecification;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.AdminService;
import service.ConsumerService;
import task.TaskDef;
import task.TaskPerformer;
import task.UserTask;
import task.point.Account;
import task.point.FixPointStrategy;
import task.taskLife.*;
import user.UserGroup;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * App用户可以使用他账户中积分完成兑换，获取相关的商品，比如一杯可乐。
 */
public class Test5 {
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

        TaskPerformer performer = service.getPerformerGroup().getPerformer("GuiTenBay");
        System.out.println(performer.getTasksInfo());

        performer.completeTask(oneLifeTask, "一次性任务完成");

        CommoditySpecification specification = new CommoditySpecification(75, 25, "百事可乐");
        Commodity commodity1 = new Commodity(specification);
        List<Commodity> commodities = new ArrayList<>();
        commodities.add(commodity1);
        ConsumerService consumerService = new ConsumerService();
        consumerService.consumeCommodities("GuiTenBay", commodities, "买了一杯百事可乐");

        Account account = UserGroup.getUserGroup().getUser("GuiTenBay").getAccount();

        System.out.println(account.getFlow().toString());

        assertEquals(25, account.getPoint());
    }
}
