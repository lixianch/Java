import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import zookeeper.StoreVO;

import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static sun.misc.Version.println;

//class School{
//    @JSONField(serializeUsing = HashMultiMapObjectSerializer.class, deserializeUsing = HashMultiMapObjectDeserializer.class)
//    private HashMultimap<Long, Person> skuStoreStockRecords = HashMultimap.create();
//    private String name;
//
//    public HashMultimap<Long, Person> getSkuStoreStockRecords() {
//        return skuStoreStockRecords;
//    }
//
//    public void setSkuStoreStockRecords(HashMultimap<Long, Person> skuStoreStockRecords) {
//        this.skuStoreStockRecords = skuStoreStockRecords;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//    public void add(Long l, Person person){
//        this.skuStoreStockRecords.put(l, person);
//    }
//}
class Person{
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
//        School school = new School();
//        school.setName("卡萨丁福建省");
//        Person p1 = new Person();
//        p1.setId(1);
//        p1.setName("胜多负少");
//        school.add(1L, p1);
//        Person p2 = new Person();
//        p2.setId(2);
//        p2.setName("name2");
//        school.add(1L, p2);
//        String s = JSONObject.toJSONString(school);
//        System.out.println(s);
//        School school1 = JSONObject.parseObject(s, School.class);
//        System.out.println(UUID.randomUUID());
//        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3,2,7,4);
//        Collections.sort(integers, (n1, n2)->n1.compareTo(n2));
//        System.out.println(integers);
//        int count = 1999;
//        int PAGESIZE = 1000;
//        int pageCount = count % PAGESIZE == 0 ? count / PAGESIZE : count / PAGESIZE + 1;
//        System.out.println(pageCount);
//        List<Integer> storeIds = Lists.newArrayList(12620,12625,12627,12630,12634,12636,12637,12638,12640,12644,12648,13336,13337,13340,13342,13344,13346,13390,13536,14073,14833,14834,15506,15508,15604,15605,15606,15608,15884,16418,18377,38241,65732);
//        List<StoreVO> stores = Lists.newArrayList();
//        for (Integer storeId : storeIds) {
//            stores.add(new StoreVO(storeId));
//        }
//        System.out.println(JSONArray.toJSONString(stores));
//        try {
//            String data = FileUtils.readFileToString(new File("C:\\Users\\dmall\\Desktop\\temp (2).log"));
//            List<WareLabst> wareLabstList = JSONObject.parseArray(data, WareLabst.class);
//            for (WareLabst wareLabst : wareLabstList) {
//                if (wareLabst.getLabst() == null) {
//                    System.out.println(JSONObject.toJSONString(wareLabst));
//                }
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        Map<String, Object> map = Maps.newHashMap();
        map.put("111", null);
        Person p = (Person)map.get("111");
        System.out.println(p);
    }



}
