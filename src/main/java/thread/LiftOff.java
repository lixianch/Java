package thread;

/**
 * Created by lixianch on 2016/10/27.
 */
public class LiftOff implements Runnable {
    private static Integer taskId=0;
    protected Integer countDown = 10;
    private final Integer id = taskId++;
    public LiftOff(){}
    public LiftOff(Integer countDown){
        this.countDown = countDown;
    }
    public String status(){
        return "#"+id+"("+(countDown > 0? countDown : "LiftOff")+")";
    }
    @Override
    public void run() {
        while(countDown-- > 0){
            System.out.println(status());
            Thread.yield();
        }
    }
}
