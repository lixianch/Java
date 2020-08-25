import com.google.common.collect.HashMultimap;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 库存操作命令（预占、释放预占、预占核销）
 * Created by zd on 2017/8/23.
 */
public class StockCommand implements Serializable{
    //命令编码
    private String cmd;
    //操作SKU库存信息列表
    private List<SkuStockInfo> stockInfo;
    //库存操作来源
    private String source;
    //当前是否为恢复操作
    private boolean isRecover = false;
    //恢复记录ID
    private Integer recoverId;
    //门店ID
    private Integer shopId;
    //父单ID，有可能是采购凭证号
    private String parentOrderId;
    //订单ID，有可能是采购凭证号
    private String orderId;
    //订单交易类型,对应OrderSourceEnum 枚举
    private Integer orderTradeType;
    //判断线上线下单 true 线上单 false 线下单
    //private boolean isOnlineOrder = true;
    //当前恢复的位置点
    private Integer failFlag;
    //商品信息
    Map<Long, SkuBaseInfo> skuBaseInfos;
    //是否防重开关 默认为true 需要防重
    private boolean isNeedFc = true;
    //是否走同步,默认走异步（redis处理后写队列）[同步异步指持久化操作]
    private boolean isSync = false;
    //是否判断库存数（针对预占库存时，不卡库存，直接预占成功）
    private boolean judgeStock = true;
    //是否从主redis查询缓存
    private boolean readMaster = true;

    private HashMultimap<Long, DepotStockRecords> skuDepotStockRecords = HashMultimap.create();

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<SkuStockInfo> getStockInfo() {
        return stockInfo;
    }

    public void setStockInfo(List<SkuStockInfo> stockInfo) {
        this.stockInfo = stockInfo;
    }

    public boolean isRecover() {
        return isRecover;
    }

    public void setRecover(boolean isRecover) {
        this.isRecover = isRecover;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getFailFlag() {
        return failFlag;
    }

    public void setFailFlag(Integer failFlag) {
        this.failFlag = failFlag;
    }

    public Integer getRecoverId() {
        return recoverId;
    }

    public void setRecoverId(Integer recoverId) {
        this.recoverId = recoverId;
    }

    public Integer getOrderTradeType() {
        return orderTradeType;
    }

    public void setOrderTradeType(Integer orderTradeType) {
        this.orderTradeType = orderTradeType;
    }

    public String getParentOrderId() {
        return parentOrderId;
    }

    public void setParentOrderId(String parentOrderId) {
        this.parentOrderId = parentOrderId;
    }

    public Map<Long, SkuBaseInfo> getSkuBaseInfos() {
        return skuBaseInfos;
    }

    public void setSkuBaseInfos(Map<Long, SkuBaseInfo> skuBaseInfos) {
        this.skuBaseInfos = skuBaseInfos;
    }

    public boolean isNeedFc() {
        return isNeedFc;
    }

    public void setNeedFc(boolean isNeedFc) {
        this.isNeedFc = isNeedFc;
    }

    public boolean isSync() {
        return isSync;
    }

    public void setSync(boolean isSync) {
        this.isSync = isSync;
    }

    public boolean isJudgeStock() {
        return judgeStock;
    }

    public void setJudgeStock(boolean judgeStock) {
        this.judgeStock = judgeStock;
    }

    public boolean isReadMaster() {
        return readMaster;
    }

    public void setReadMaster(boolean readMaster) {
        this.readMaster = readMaster;
    }

    public HashMultimap<Long, DepotStockRecords> getSkuDepotStockRecords() {
        return skuDepotStockRecords;
    }

    public void setSkuDepotStockRecords(HashMultimap<Long, DepotStockRecords> skuDepotStockRecords) {
        this.skuDepotStockRecords = skuDepotStockRecords;
    }
}
