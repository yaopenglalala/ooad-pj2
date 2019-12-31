package transaction;


import task.TaskDef;

import java.util.Date;

/**
 * 用户完成一次任务的交易
 */
public class PerformTaskTransaction extends Transaction {
    private TaskDef definition;

    public PerformTaskTransaction(TaskDef definition, Date time, int amount, String commit) {
        super(time, amount, commit);
        this.definition = definition;
    }

    public TaskDef getDefinition() {
        return definition;
    }
}
