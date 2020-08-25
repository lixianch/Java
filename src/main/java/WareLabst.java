import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * 中百库存vo
 * Created by fei on 2017/10/9.
 */
public class WareLabst implements Serializable {

    private static final long serialVersionUID = 6659248678586853112L;
    //物料编码
    private String wareCode;
    //商品条码
    private String barCode;
    //当前库存
    private Double labst;
    //库存单位
    private String meins;
    //更新日志
    private Long date;

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getWareCode() {
        return wareCode;
    }

    public void setWareCode(String wareCode) {
        this.wareCode = wareCode;
    }

    public Double getLabst() {
        return labst;
    }

    public void setLabst(Double labst) {
        this.labst = labst;
    }

    public String getMeins() {
        return meins;
    }

    public void setMeins(String meins) {
        this.meins = meins;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
