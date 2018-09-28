package hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

import java.util.concurrent.TimeUnit;

/**
 * Created by lixianch on 2018/9/12.
 */
public class UserInfoCommand extends HystrixCommand<String> {
    protected UserInfoCommand() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("UserInfoGroup"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(200)));
    }

    protected String run() throws Exception {
        UserInfo userInfo = new UserInfo();
//        throw new Exception();
        try {
            TimeUnit.MILLISECONDS.sleep(400);
        } catch (InterruptedException e) {
        }
        String desc = userInfo.getDesc();
        return desc;
    }

    @Override
    protected String getFallback() {
        return "fallback invoke return";
    }
}
