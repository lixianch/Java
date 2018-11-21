package activiti.sequenceFlow;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

import java.util.Map;

/**
 * Created by lixianch on 2018/9/29.
 */
public class VariableProcessTest {
    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    @Test
    public void testDeployment() {
        Deployment deploy = processEngine.getRepositoryService().createDeployment().addClasspathResource("variableProcess.bpmn20.xml").deploy();
        System.out.println("流程发布，id：" + deploy.getId() + ",key:" + deploy.getKey() + ",name:" + deploy.getName());
    }

    @Test
    public void testStartProcess() {
        String procDefId = "variablProcess:1:15004";
        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceById(procDefId);
        System.out.println("流程实例，id:" + processInstance.getId());
    }

    @Test
    public void testCompleteTask() {
        String taskId = "25005";
//        processEngine.getTaskService().setVariable(taskId,"days",Integer.valueOf(7));
//        processEngine.getTaskService().setVariable(taskId,"msg","回家探亲");
//        processEngine.getTaskService().setVariable(taskId,"staff","小王");
        processEngine.getTaskService().complete(taskId);
    }

    @Test
    public void testGetVariable() {
        String taskId = "25005";
        Map<String, Object> variables = processEngine.getTaskService().getVariables(taskId);
        Integer days = (Integer)variables.get("days");
        String msg = (String) variables.get("msg");
        String staff = (String) variables.get("staff");
        System.out.println("请假事由：" + msg + ",请假天数：" + days + ",请假人：" + staff);
    }
}
