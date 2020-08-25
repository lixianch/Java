package zookeeper;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by lixianch on 2020/6/22
 */
public class StoreVO {
    private Boolean isSupported = true;
    private Integer storeId;
    private List<Integer> supportedTaskSubTypeList = Lists.newArrayList(100002, 100003, 101001, 102001);
//    private List<Integer> supportedTaskSubTypeList = Lists.newArrayList(100001, 100002, 100003, 101001, 102001);
    public StoreVO(Integer storeId){
        this.storeId = storeId;
    }

    public Boolean getIsSupported() {
        return isSupported;
    }

    public void setIsSupported(Boolean supported) {
        isSupported = supported;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public List<Integer> getSupportedTaskSubTypeList() {
        return supportedTaskSubTypeList;
    }

    public void setSupportedTaskSubTypeList(List<Integer> supportedTaskSubTypeList) {
        this.supportedTaskSubTypeList = supportedTaskSubTypeList;
    }
}
