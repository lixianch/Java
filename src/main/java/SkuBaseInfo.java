import java.math.BigDecimal;

/**
 * Created by zd on 2018/5/10.
 */
public class SkuBaseInfo {
    //目标SKU商家ID
    private Integer venderId;
    //目标SKU商品ID
    private Long wareId;
    //目标商品业态
    private Integer business;
    //目标商品三方分类编码
    private String mccode;
    //目标商品称重类型
    private Integer weight;
    //目标商品毛重
    private BigDecimal brgew;
    //目标是商品称重上限（0-0.5）
    private BigDecimal weightLimitRatio;

    public Integer getVenderId() {
        return venderId;
    }

    public void setVenderId(Integer venderId) {
        this.venderId = venderId;
    }

    public Long getWareId() {
        return wareId;
    }

    public void setWareId(Long wareId) {
        this.wareId = wareId;
    }

    public Integer getBusiness() {
        return business;
    }

    public void setBusiness(Integer business) {
        this.business = business;
    }

    public String getMccode() {
        return mccode;
    }

    public void setMccode(String mccode) {
        this.mccode = mccode;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public BigDecimal getBrgew() {
        return brgew;
    }

    public void setBrgew(BigDecimal brgew) {
        this.brgew = brgew;
    }

    public BigDecimal getWeightLimitRatio() {
        return weightLimitRatio;
    }

    public void setWeightLimitRatio(BigDecimal weightLimitRatio) {
        this.weightLimitRatio = weightLimitRatio;
    }
}
