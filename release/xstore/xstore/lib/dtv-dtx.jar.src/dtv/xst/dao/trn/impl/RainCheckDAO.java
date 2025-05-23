/*     */ package dtv.xst.dao.trn.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.RainCheckId;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RainCheckDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1279387060L;
/*  23 */   private static final Logger _logger = Logger.getLogger(RainCheckDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _rainCheckId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _itemId;
/*     */   private BigDecimal _salePrice;
/*     */   private DtvDate _expirationBusinessDate;
/*  34 */   private Boolean _redeemedFlag = Boolean.FALSE;
/*     */   private Long _retailLocationId;
/*     */   
/*     */   public Long getOrganizationId() {
/*  38 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  42 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  43 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getRainCheckId() {
/*  48 */     return this._rainCheckId;
/*     */   }
/*     */   
/*     */   public void setRainCheckId(String argRainCheckId) {
/*  52 */     if (changed(argRainCheckId, this._rainCheckId, "rainCheckId")) {
/*  53 */       this._rainCheckId = (argRainCheckId != null && MANAGE_CASE) ? argRainCheckId.toUpperCase() : argRainCheckId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  58 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  62 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  63 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  69 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  73 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  74 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  79 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  83 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  84 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  90 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  94 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  95 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getItemId() {
/* 100 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 104 */     if (changed(argItemId, this._itemId, "itemId")) {
/* 105 */       this._itemId = argItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getSalePrice() {
/* 110 */     return this._salePrice;
/*     */   }
/*     */   
/*     */   public void setSalePrice(BigDecimal argSalePrice) {
/* 114 */     if (changed(argSalePrice, this._salePrice, "salePrice")) {
/* 115 */       this._salePrice = argSalePrice;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getExpirationBusinessDate() {
/* 120 */     return (Date)this._expirationBusinessDate;
/*     */   }
/*     */   
/*     */   public void setExpirationBusinessDate(Date argExpirationBusinessDate) {
/* 124 */     if (changed(argExpirationBusinessDate, this._expirationBusinessDate, "expirationBusinessDate")) {
/* 125 */       this._expirationBusinessDate = (argExpirationBusinessDate == null || argExpirationBusinessDate instanceof DtvDate) ? (DtvDate)argExpirationBusinessDate : new DtvDate(argExpirationBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Boolean getRedeemedFlag() {
/* 131 */     return this._redeemedFlag;
/*     */   }
/*     */   
/*     */   public void setRedeemedFlag(Boolean argRedeemedFlag) {
/* 135 */     if (changed(argRedeemedFlag, this._redeemedFlag, "redeemedFlag")) {
/* 136 */       this._redeemedFlag = argRedeemedFlag;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/* 141 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/* 145 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/* 146 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 153 */     StringBuilder buf = new StringBuilder(512);
/* 154 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 155 */     if (getOrganizationId() != null) {
/* 156 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 158 */     if (getRainCheckId() != null) {
/* 159 */       buf.append("rainCheckId").append("=").append(getRainCheckId()).append(" ");
/*     */     }
/* 161 */     if (getCreateDate() != null) {
/* 162 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 164 */     if (getCreateUserId() != null) {
/* 165 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 167 */     if (getUpdateDate() != null) {
/* 168 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 170 */     if (getUpdateUserId() != null) {
/* 171 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 173 */     if (getItemId() != null) {
/* 174 */       buf.append("itemId").append("=").append(getItemId()).append(" ");
/*     */     }
/* 176 */     if (getSalePrice() != null) {
/* 177 */       buf.append("salePrice").append("=").append(getSalePrice()).append(" ");
/*     */     }
/* 179 */     if (getExpirationBusinessDate() != null) {
/* 180 */       buf.append("expirationBusinessDate").append("=").append(getExpirationBusinessDate()).append(" ");
/*     */     }
/* 182 */     if (getRedeemedFlag() != null && getRedeemedFlag().booleanValue()) {
/* 183 */       buf.append("redeemedFlag").append("=").append(getRedeemedFlag()).append(" ");
/*     */     }
/* 185 */     if (getRetailLocationId() != null) {
/* 186 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/*     */     
/* 189 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 193 */     RainCheckId id = new RainCheckId();
/* 194 */     id.setOrganizationId(getOrganizationId());
/* 195 */     id.setRainCheckId(getRainCheckId());
/* 196 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 200 */     setOrganizationId(((RainCheckId)argObjectId).getOrganizationId());
/* 201 */     setRainCheckId(((RainCheckId)argObjectId).getRainCheckId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 205 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 209 */     StringBuilder buf = new StringBuilder(550);
/* 210 */     buf.append("<").append("dao").append(" name=\"RainCheck\" cmd=\"" + getObjectStateString() + "\">");
/* 211 */     getFieldsAsXml(buf);
/* 212 */     buf.append("</").append("dao").append(">");
/*     */     
/* 214 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 218 */     Map<String, String> values = super.getValues();
/* 219 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 220 */     if (this._rainCheckId != null) values.put("RainCheckId", DaoUtils.getXmlSafeFieldValue(12, this._rainCheckId)); 
/* 221 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 222 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 223 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 224 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 225 */     if (this._itemId != null) values.put("ItemId", DaoUtils.getXmlSafeFieldValue(12, this._itemId)); 
/* 226 */     if (this._salePrice != null) values.put("SalePrice", DaoUtils.getXmlSafeFieldValue(3, this._salePrice)); 
/* 227 */     if (this._expirationBusinessDate != null) values.put("ExpirationBusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._expirationBusinessDate)); 
/* 228 */     if (this._redeemedFlag != null) values.put("RedeemedFlag", DaoUtils.getXmlSafeFieldValue(-7, this._redeemedFlag)); 
/* 229 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 230 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 235 */     super.setValues(argValues);
/* 236 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 238 */       String fieldName = field.getKey();
/* 239 */       String fieldValue = field.getValue();
/* 240 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 244 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 245 */             setOrganizationId((Long)value);
/* 246 */           } catch (Exception ee) {
/* 247 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RainCheckId":
/*     */           try {
/* 253 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 254 */             setRainCheckId((String)value);
/* 255 */           } catch (Exception ee) {
/* 256 */             throw new DtxException("An exception occurred while calling setRainCheckId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 262 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 263 */             setCreateDate((Date)value);
/* 264 */           } catch (Exception ee) {
/* 265 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 271 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 272 */             setCreateUserId((String)value);
/* 273 */           } catch (Exception ee) {
/* 274 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 280 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 281 */             setUpdateDate((Date)value);
/* 282 */           } catch (Exception ee) {
/* 283 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 289 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 290 */             setUpdateUserId((String)value);
/* 291 */           } catch (Exception ee) {
/* 292 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemId":
/*     */           try {
/* 298 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 299 */             setItemId((String)value);
/* 300 */           } catch (Exception ee) {
/* 301 */             throw new DtxException("An exception occurred while calling setItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SalePrice":
/*     */           try {
/* 307 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 308 */             setSalePrice((BigDecimal)value);
/* 309 */           } catch (Exception ee) {
/* 310 */             throw new DtxException("An exception occurred while calling setSalePrice() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpirationBusinessDate":
/*     */           try {
/* 316 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 317 */             setExpirationBusinessDate((Date)value);
/* 318 */           } catch (Exception ee) {
/* 319 */             throw new DtxException("An exception occurred while calling setExpirationBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RedeemedFlag":
/*     */           try {
/* 325 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 326 */             setRedeemedFlag((Boolean)value);
/* 327 */           } catch (Exception ee) {
/* 328 */             throw new DtxException("An exception occurred while calling setRedeemedFlag() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 334 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 335 */             setRetailLocationId((Long)value);
/* 336 */           } catch (Exception ee) {
/* 337 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\RainCheckDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */