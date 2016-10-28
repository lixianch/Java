package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by lixianch on 2016/10/27.
 */
public class CallableDemo {


    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<String>> results = new ArrayList<Future<String>>();
        for(int i = 0; i < 5; i++){
            results.add(exec.submit(new TaskWithResult(i)));
        }

        try {
            for(Future<String> r : results){
                System.out.println(r.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            exec.shutdown();
        }
    }
}

class TaskWithResult implements Callable<String>{
    private Integer id;
    public TaskWithResult(Integer id){
        this.id = id;
    }
    @Override
    public String call() throws Exception {
        return "TaskWithResult-"+id+" result";
    }
}
