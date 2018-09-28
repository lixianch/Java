package hystrix;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by lixianch on 2018/9/12.
 */
public class UserInfoCommandTest {
    public static void main(String[] args) {
//        Future<String> userInfoTask = new UserInfoCommand().queue();
//        try {
//            TimeUnit.MILLISECONDS.sleep(5000);
//            String desc = userInfoTask.get(800, TimeUnit.MILLISECONDS);
            String desc = new UserInfoCommand().execute();
            System.out.println(desc);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        }

    }
}
