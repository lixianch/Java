package concurrency;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by lixianch on 2016/9/18.
 */
class TaskWithResult implements Callable<String>{
    private int id;

    public TaskWithResult(int id){
        this.id = id;
    }
    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> result = new ArrayList<Future<String>>();
        for(int i = 0; i < 10; i++){
            result.add(exec.submit(new TaskWithResult(i)));
        }

        for(Future<String> f : result){
            try {
                System.out.println(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                exec.shutdown();
            }
        }
    }
}
