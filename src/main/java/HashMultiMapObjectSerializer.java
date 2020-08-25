import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.google.common.collect.HashMultimap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by lixianch on 2020/4/20
 */
public class HashMultiMapObjectSerializer implements ObjectSerializer {
    public static final Logger LOGGER = LoggerFactory.getLogger(HashMultiMapObjectSerializer.class);
    @Override
    public void write(JSONSerializer jsonSerializer, Object o, Object o1, Type type, int i) throws IOException {
        try {
            HashMultimap<Long, Person> personsMap = (HashMultimap<Long, Person>) o;
            jsonSerializer.write(personsMap);
        } catch (Exception e) {
            LOGGER.error("storeStockRecords 序列化失败", e);
        }
    }
}
