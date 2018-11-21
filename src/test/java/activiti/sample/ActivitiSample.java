package activiti.sample;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by lixianch on 2018/9/28.
 */
public class ActivitiSample {
    static ProcessEngine processEngine;

    @BeforeClass
    public static void setup(){
        processEngine = ProcessEngines.getDefaultProcessEngine();
    }

    @Test
    public void testProcessEngine(){
        System.out.println("获取流程引擎：" + processEngine);
    }

    @Test
    public void testDeployment(){
        RepositoryService repositoryService = processEngine.getRepositoryService();
        repositoryService.createDeployment().key("workorder").name("工单").addClasspathResource("workorder.bpmn20.xml").deploy();
        long count = repositoryService.createDeploymentQuery().count();
        System.out.println("已发布" + count + "个流程");
    }

    @Test
    public void testQueryDeployment(){
        RepositoryService repositoryService = processEngine.getRepositoryService();
        List<Deployment> list = repositoryService.createDeploymentQuery().list();
        list.stream().forEach(d -> {
            System.out.println("流程部署Id：" + d.getId());
            System.out.println("流程部署key：" + d.getKey());
            System.out.println("流程部署名称：" + d.getName());
            System.out.println("####################");
        });
    }

    @Test
    public void testStartProcess() {
        String processKey = "workorder";
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance pi = runtimeService.startProcessInstanceByKey(processKey);
        System.out.println("启动流程实例" + processKey + ",id:" + pi.getId());
    }

    @Test
    public void testQueryTask() {
        TaskService taskService = processEngine.getTaskService();
        List<Task> list = taskService.createTaskQuery().taskCandidateOrAssigned("客服").orderByTaskCreateTime().asc().list();
        list.stream().forEach(t -> {
            System.out.println("任务Id：" + t.getId());
            System.out.println("任务key：" + t.getTaskDefinitionKey());
            System.out.println("任务名称：" + t.getName());
            System.out.println("######################");
        });
    }

    @Test
    public void testViewPic() {
        String deployId = "5001";
        RepositoryService repositoryService = processEngine.getRepositoryService();
        List<String> deploymentResourceNames = repositoryService.getDeploymentResourceNames(deployId);
        deploymentResourceNames.stream().forEach(d -> {
            if(d.endsWith(".png")){
                InputStream resourceAsStream = processEngine.getRepositoryService().getResourceAsStream(deployId, d);
                File destFile = new File("D:\\" + d);
                try {
                    FileUtils.copyInputStreamToFile(resourceAsStream, destFile);
                    System.out.println("导出流程图成功！");
                } catch (IOException e) {
                    System.out.println("导出流程图失败！");
                }
            }
        });
    }

    @Test
    public void testCompleteTask() {
        String taskId = "10002";
        TaskService taskService = processEngine.getTaskService();
        taskService.complete(taskId);
        System.out.println("完成任务：" + taskId);
    }
    @Test
    public void testDelDeployment() {
        String deploymentId = "2501";
        RepositoryService repositoryService = processEngine.getRepositoryService();
        repositoryService.deleteDeployment(deploymentId);
        System.out.println("删除流程部署成功！");
    }
    @AfterClass
    public static void tearDown() {
        processEngine.close();
    }
}
