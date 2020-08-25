import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.google.common.collect.HashMultimap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by lixianch on 2020/4/20
 */
public class HashMultiMapObjectDeserializer implements ObjectDeserializer {
    private static final Logger LOGGER = LoggerFactory.getLogger(HashMultiMapObjectDeserializer.class);
    @Override
    public HashMultimap<Long, Person> deserialze(DefaultJSONParser defaultJSONParser, Type type, Object o) {
        HashMultimap<Long, Person> storeRecordsMap = HashMultimap.create();
        try {
            JSONObject jsonObject = defaultJSONParser.parseObject();
            if(jsonObject == null){
                return storeRecordsMap;
            }
            for (String k : jsonObject.keySet()) {
                Long skuId = Long.parseLong(k);
                JSONArray json = jsonObject.getJSONArray(k);
                List<Person> list = json.toJavaList(Person.class);
                for (Person person : list) {
                    storeRecordsMap.put(skuId, person);
                }
            }
        } catch (Exception e) {
            LOGGER.error("storeStockRecords 反序列化失败", e);
        }
        return storeRecordsMap;
    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }
}
