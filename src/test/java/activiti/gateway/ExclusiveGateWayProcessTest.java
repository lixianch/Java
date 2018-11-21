package activiti.gateway;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;

/**
 * Created by lixianch on 2018/9/30.
 */
public class ExclusiveGateWayProcessTest {
    private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    @Test
    public void testDeploy() {
        Deployment deploy = processEngine.getRepositoryService()
                .createDeployment().addClasspathResource("GatewayProcess.bpmn20.xml")
                .key("ExclusiveGateWay").name("ExclusiveGateway")
                .deploy();
        System.out.println("发布流程,Id: " + deploy.getId() + ",key: " + deploy.getKey() + ",name: " + deploy.getName());
    }

    @Test
    public void startProcess() {
        processEngine.getRuntimeService().startProcessInstanceByKey("GatewayProcess");
    }

    @Test
    public void processTask() {
        String taskId = "77505";
        processEngine.getTaskService().setVariableLocal(taskId,"localcount",30);
        processEngine.getTaskService().setVariable(taskId,"money",250);
        processEngine.getTaskService().complete(taskId);
    }
}
