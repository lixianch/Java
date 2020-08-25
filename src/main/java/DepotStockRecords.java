import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * @author lixianch
 * @version 1.0
 * @since 1.0
 * @date 2019-11-20
 */
public class DepotStockRecords implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	private static Logger LOGGER = LoggerFactory.getLogger(DepotStockRecords.class);
	//
	private Long id;
	//
	private String uuid;
	//商家id
	private Integer venderId;
	//仓库id
	private Integer depotId;
	//门店编号
	private Integer storeId;
	//商家门店编号;商家系统中的门店编号
	private String sapId;
	//门店名称
	private String storeName;
	//sku
	private Long skuId;
	//商品物料编码
	private String matnr;
	//商品名称 
	private String wareName;
	//库存地编码
	private Integer stockStore;
	//库存地名称
	private String stockStoreName;
	//库存基本单位描述
	private String stockUnit;
	//业务类型编码
	private String businessTypeCode;
	//业务类型描述
	private String businessTypeDec;
	//业务发生数量
	private BigDecimal num;
	//业务发生单位描述
	private String unit;
	//批次号
	private String batchNo;
	//业务凭证编码
	private String businessVoucherCode;
	//凭证行项目编码
	private String creditRowCode;
	//业务单据编码;会是采购（退）单号、销售（退）单号、库调单号、盘点单号等
	private String businessDocCode;
	//参考业务凭证编码
	private String businessVoucherRef;
	//参考业务单据编码
	private String businessDocRef;
	//记账日期;业务单据中记录的业务发生日期
	private Date accountTime;
	//
	private Date created;
	//
	private Date modified;
	//
	private Long orderNum;
	//商品相关信息
	private String wareInfo;
	//库存数信息
	private String stockInfo;
	//
	private Integer yn;

	private String tableName;
	private Map<String, Object> data = Maps.newHashMap();
	//查询条件
	private Date startAccountTime;
	private Date endAccountTime;
	private Date startCreateTime;
	private Date endCreateTime;

	public void setId(Long value) {
		this.id = value;
	}
	
	public Long getId() {
		return this.id;
	}
	public void setUuid(String value) {
		this.uuid = value;
	}
	
	public String getUuid() {
		return this.uuid;
	}

	public Integer getVenderId() {
		return venderId;
	}

	public void setVenderId(Integer venderId) {
		this.venderId = venderId;
	}

	public void setDepotId(Integer value) {
		this.depotId = value;
	}
	
	public Integer getDepotId() {
		return this.depotId;
	}
	public void setStoreId(Integer value) {
		this.storeId = value;
	}
	
	public Integer getStoreId() {
		return this.storeId;
	}
	public void setSapId(String value) {
		this.sapId = value;
	}
	
	public String getSapId() {
		return this.sapId;
	}
	public void setStoreName(String value) {
		this.storeName = value;
	}
	
	public String getStoreName() {
		return this.storeName;
	}
	public void setSkuId(Long value) {
		this.skuId = value;
	}
	
	public Long getSkuId() {
		return this.skuId;
	}
	public void setMatnr(String value) {
		this.matnr = value;
	}
	
	public String getMatnr() {
		return this.matnr;
	}
	public void setWareName(String value) {
		this.wareName = value;
	}
	
	public String getWareName() {
		return this.wareName;
	}
	public void setStockStore(Integer value) {
		this.stockStore = value;
	}
	
	public Integer getStockStore() {
		return this.stockStore;
	}
	public void setStockStoreName(String value) {
		this.stockStoreName = value;
	}
	
	public String getStockStoreName() {
		return this.stockStoreName;
	}
	public void setStockUnit(String value) {
		this.stockUnit = value;
	}
	
	public String getStockUnit() {
		return this.stockUnit;
	}
	public void setBusinessTypeCode(String value) {
		this.businessTypeCode = value;
	}
	
	public String getBusinessTypeCode() {
		return this.businessTypeCode;
	}
	public void setBusinessTypeDec(String value) {
		this.businessTypeDec = value;
	}
	
	public String getBusinessTypeDec() {
		return this.businessTypeDec;
	}
	public void setNum(BigDecimal value) {
		this.num = value;
	}
	
	public BigDecimal getNum() {
		return this.num;
	}
	public void setUnit(String value) {
		this.unit = value;
	}
	
	public String getUnit() {
		return this.unit;
	}
	public void setBatchNo(String value) {
		this.batchNo = value;
	}
	
	public String getBatchNo() {
		return this.batchNo;
	}
	public void setBusinessVoucherCode(String value) {
		this.businessVoucherCode = value;
	}
	
	public String getBusinessVoucherCode() {
		return this.businessVoucherCode;
	}
	public void setCreditRowCode(String value) {
		this.creditRowCode = value;
	}
	
	public String getCreditRowCode() {
		return this.creditRowCode;
	}
	public void setBusinessDocCode(String value) {
		this.businessDocCode = value;
	}
	
	public String getBusinessDocCode() {
		return this.businessDocCode;
	}
	public void setBusinessVoucherRef(String value) {
		this.businessVoucherRef = value;
	}
	
	public String getBusinessVoucherRef() {
		return this.businessVoucherRef;
	}
	public void setBusinessDocRef(String value) {
		this.businessDocRef = value;
	}
	
	public String getBusinessDocRef() {
		return this.businessDocRef;
	}
	public void setAccountTime(Date value) {
		this.accountTime = value;
	}
	
	public Date getAccountTime() {
		return this.accountTime;
	}
	public void setCreated(Date value) {
		this.created = value;
	}
	
	public Date getCreated() {
		return this.created;
	}
	public void setModified(Date value) {
		this.modified = value;
	}
	
	public Date getModified() {
		return this.modified;
	}
	public void setOrderNum(Long value) {
		this.orderNum = value;
	}
	
	public Long getOrderNum() {
		return this.orderNum;
	}
	public void setWareInfo(String value) {
		this.wareInfo = value;
	}
	
	public String getWareInfo() {
		return this.wareInfo;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public JSONObject getWareInfoJson(){
		JSONObject jsonObject = new JSONObject();;
		if(StringUtils.isBlank(this.wareInfo)){
			return jsonObject;
		}
		try{
			return JSONObject.parseObject(this.wareInfo);
		}catch (Exception e){
			LOGGER.error("解析商品信息json出错", e);
		}
		return jsonObject;
	}
	public void setStockInfo(String value) {
		this.stockInfo = value;
	}
	
	public Object getStockInfo() {
		return this.stockInfo;
	}
	public JSONObject getStockInfoJson(){
		JSONObject jsonObject = new JSONObject();;
		if(StringUtils.isBlank(this.stockInfo)){
			return jsonObject;
		}
		try{
			return JSONObject.parseObject(this.stockInfo);
		}catch (Exception e){
			LOGGER.error("解析商品库存信息json出错", e);
		}
		return jsonObject;
	}
	public void setYn(Integer value) {
		this.yn = value;
	}
	
	public Integer getYn() {
		return this.yn;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public void addData(String key, Object obj){
		data.put(key, obj);
	}

	public Date getStartAccountTime() {
		return startAccountTime;
	}

	public void setStartAccountTime(Date startAccountTime) {
		this.startAccountTime = startAccountTime;
	}

	public Date getEndAccountTime() {
		return endAccountTime;
	}

	public void setEndAccountTime(Date endAccountTime) {
		this.endAccountTime = endAccountTime;
	}

	public Date getStartCreateTime() {
		return startCreateTime;
	}

	public void setStartCreateTime(Date startCreateTime) {
		this.startCreateTime = startCreateTime;
	}

	public Date getEndCreateTime() {
		return endCreateTime;
	}

	public void setEndCreateTime(Date endCreateTime) {
		this.endCreateTime = endCreateTime;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
}

