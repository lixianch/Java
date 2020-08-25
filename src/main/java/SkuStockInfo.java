
import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

/**
 * Created by zd on 2017/9/1.
 */
public class SkuStockInfo {
    //商品SKU
    private Long originSkuId;
    //原SKU预占操作数量
    private BigDecimal originOperNum;
    //同步数量
    private Map<Integer, BigDecimal> syncNum;
    /** 需要补全的字段 **/
    //SKU是否经过转换
    private Boolean converted = false;
    //目标门店ID
    private Integer destShopId;
    //实际操作目标商品的库存数量
    private BigDecimal realOperNum;
    //目标门店ID
    private Long destSkuId;
    //原SKU消耗目标SKU的比例
    private BigDecimal specNum = BigDecimal.ONE;
    //毛重比例
    private Integer weightNum = 1;
    //系统仓库ID
    private Integer depotId;
    //仓库类型 1:门店仓 2：大仓
    private Integer depotType;
    //库存地编码
    private Integer stockStore;
    //是否缓存预占 （默认:1）
    private Integer cacheOccupy = 1;
    //商家仓库编号
    private String depotNo;
    //实际核销数量
    private BigDecimal realEffectNum;
    //查找仓逻辑，是否走店的默认仓
    private Boolean storeDefaultDepot = false;
    //uuid
    private String uuid = UUID.randomUUID().toString();

    public String getDepotNo() {
        return depotNo;
    }

    public void setDepotNo(String depotNo) {
        this.depotNo = depotNo;
    }

    public BigDecimal getOriginOperNum() {
        return originOperNum;
    }

    public void setOriginOperNum(BigDecimal originOperNum) {
        this.originOperNum = originOperNum;
    }

    public BigDecimal getRealOperNum() {
        return realOperNum;
    }

    public void setRealOperNum(BigDecimal realOperNum) {
        this.realOperNum = realOperNum;
    }

    public Map<Integer, BigDecimal> getSyncNum() {
        return syncNum;
    }

    public void setSyncNum(Map<Integer, BigDecimal> syncNum) {
        this.syncNum = syncNum;
    }

    public Integer getDepotId() {
        return depotId;
    }

    public void setDepotId(Integer depotId) {
        this.depotId = depotId;
    }

    public Long getOriginSkuId() {
        return originSkuId;
    }

    public void setOriginSkuId(Long originSkuId) {
        this.originSkuId = originSkuId;
    }

    public Integer getDestShopId() {
        return destShopId;
    }

    public void setDestShopId(Integer destShopId) {
        this.destShopId = destShopId;
    }

    public Long getDestSkuId() {
        return destSkuId;
    }

    public void setDestSkuId(Long destSkuId) {
        this.destSkuId = destSkuId;
    }

    public BigDecimal getSpecNum() {
        return specNum;
    }

    public void setSpecNum(BigDecimal specNum) {
        this.specNum = specNum;
    }

    public Boolean getConverted() {
        return converted;
    }

    public void setConverted(Boolean converted) {
        this.converted = converted;
    }

    public Integer getStockStore() {
        return stockStore;
    }

    public void setStockStore(Integer stockStore) {
        this.stockStore = stockStore;
    }

    public Integer getWeightNum() {
        return weightNum;
    }

    public void setWeightNum(Integer weightNum) {
        this.weightNum = weightNum;
    }

    public Integer getCacheOccupy() {
        return cacheOccupy;
    }

    public void setCacheOccupy(Integer cacheOccupy) {
        this.cacheOccupy = cacheOccupy;
    }

    public BigDecimal getRealEffectNum() {
        return realEffectNum;
    }

    public void setRealEffectNum(BigDecimal realEffectNum) {
        this.realEffectNum = realEffectNum;
    }

    public Integer getDepotType() {
        return depotType;
    }

    public void setDepotType(Integer depotType) {
        this.depotType = depotType;
    }

    public Boolean getStoreDefaultDepot() {
        return storeDefaultDepot;
    }

    public void setStoreDefaultDepot(Boolean storeDefaultDepot) {
        this.storeDefaultDepot = storeDefaultDepot;
    }

    public String getUuid() {
        return uuid;
    }
}
