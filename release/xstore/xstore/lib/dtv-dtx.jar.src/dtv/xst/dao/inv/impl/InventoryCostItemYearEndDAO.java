/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryCostItemYearEndId;
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
/*     */ public class InventoryCostItemYearEndDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1083488738L;
/*  23 */   private static final Logger _logger = Logger.getLogger(InventoryCostItemYearEndDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Integer _fiscalYear;
/*     */   private Long _retailLocationId;
/*     */   private String _itemId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _wacQuantityReceived;
/*     */   private BigDecimal _wacValueReceived;
/*     */   private BigDecimal _pwacQuantityOnhandEndofyear;
/*     */   private BigDecimal _pwacValueOnhandEndofyear;
/*     */   
/*     */   public Long getOrganizationId() {
/*  39 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  43 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  44 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getFiscalYear() {
/*  49 */     return this._fiscalYear;
/*     */   }
/*     */   
/*     */   public void setFiscalYear(Integer argFiscalYear) {
/*  53 */     if (changed(argFiscalYear, this._fiscalYear, "fiscalYear")) {
/*  54 */       this._fiscalYear = argFiscalYear;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  59 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  63 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  64 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getItemId() {
/*  69 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  73 */     if (changed(argItemId, this._itemId, "itemId")) {
/*  74 */       this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  79 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  83 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  84 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  90 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  94 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  95 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 100 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 104 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 105 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 111 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 115 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 116 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getWacQuantityReceived() {
/* 121 */     return this._wacQuantityReceived;
/*     */   }
/*     */   
/*     */   public void setWacQuantityReceived(BigDecimal argWacQuantityReceived) {
/* 125 */     if (changed(argWacQuantityReceived, this._wacQuantityReceived, "wacQuantityReceived")) {
/* 126 */       this._wacQuantityReceived = argWacQuantityReceived;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getWacValueReceived() {
/* 131 */     return this._wacValueReceived;
/*     */   }
/*     */   
/*     */   public void setWacValueReceived(BigDecimal argWacValueReceived) {
/* 135 */     if (changed(argWacValueReceived, this._wacValueReceived, "wacValueReceived")) {
/* 136 */       this._wacValueReceived = argWacValueReceived;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getPwacQuantityOnhandEndofyear() {
/* 141 */     return this._pwacQuantityOnhandEndofyear;
/*     */   }
/*     */   
/*     */   public void setPwacQuantityOnhandEndofyear(BigDecimal argPwacQuantityOnhandEndofyear) {
/* 145 */     if (changed(argPwacQuantityOnhandEndofyear, this._pwacQuantityOnhandEndofyear, "pwacQuantityOnhandEndofyear")) {
/* 146 */       this._pwacQuantityOnhandEndofyear = argPwacQuantityOnhandEndofyear;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getPwacValueOnhandEndofyear() {
/* 151 */     return this._pwacValueOnhandEndofyear;
/*     */   }
/*     */   
/*     */   public void setPwacValueOnhandEndofyear(BigDecimal argPwacValueOnhandEndofyear) {
/* 155 */     if (changed(argPwacValueOnhandEndofyear, this._pwacValueOnhandEndofyear, "pwacValueOnhandEndofyear")) {
/* 156 */       this._pwacValueOnhandEndofyear = argPwacValueOnhandEndofyear;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 163 */     StringBuilder buf = new StringBuilder(512);
/* 164 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 165 */     if (getOrganizationId() != null) {
/* 166 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 168 */     if (getFiscalYear() != null) {
/* 169 */       buf.append("fiscalYear").append("=").append(getFiscalYear()).append(" ");
/*     */     }
/* 171 */     if (getRetailLocationId() != null) {
/* 172 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 174 */     if (getItemId() != null) {
/* 175 */       buf.append("itemId").append("=").append(getItemId()).append(" ");
/*     */     }
/* 177 */     if (getCreateDate() != null) {
/* 178 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 180 */     if (getCreateUserId() != null) {
/* 181 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 183 */     if (getUpdateDate() != null) {
/* 184 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 186 */     if (getUpdateUserId() != null) {
/* 187 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 189 */     if (getWacQuantityReceived() != null) {
/* 190 */       buf.append("wacQuantityReceived").append("=").append(getWacQuantityReceived()).append(" ");
/*     */     }
/* 192 */     if (getWacValueReceived() != null) {
/* 193 */       buf.append("wacValueReceived").append("=").append(getWacValueReceived()).append(" ");
/*     */     }
/* 195 */     if (getPwacQuantityOnhandEndofyear() != null) {
/* 196 */       buf.append("pwacQuantityOnhandEndofyear").append("=").append(getPwacQuantityOnhandEndofyear()).append(" ");
/*     */     }
/* 198 */     if (getPwacValueOnhandEndofyear() != null) {
/* 199 */       buf.append("pwacValueOnhandEndofyear").append("=").append(getPwacValueOnhandEndofyear()).append(" ");
/*     */     }
/*     */     
/* 202 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 206 */     InventoryCostItemYearEndId id = new InventoryCostItemYearEndId();
/* 207 */     id.setOrganizationId(getOrganizationId());
/* 208 */     id.setFiscalYear(getFiscalYear());
/* 209 */     id.setRetailLocationId(getRetailLocationId());
/* 210 */     id.setItemId(getItemId());
/* 211 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 215 */     setOrganizationId(((InventoryCostItemYearEndId)argObjectId).getOrganizationId());
/* 216 */     setFiscalYear(((InventoryCostItemYearEndId)argObjectId).getFiscalYear());
/* 217 */     setRetailLocationId(((InventoryCostItemYearEndId)argObjectId).getRetailLocationId());
/* 218 */     setItemId(((InventoryCostItemYearEndId)argObjectId).getItemId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 222 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 226 */     StringBuilder buf = new StringBuilder(600);
/* 227 */     buf.append("<").append("dao").append(" name=\"InventoryCostItemYearEnd\" cmd=\"" + getObjectStateString() + "\">");
/* 228 */     getFieldsAsXml(buf);
/* 229 */     buf.append("</").append("dao").append(">");
/*     */     
/* 231 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 235 */     Map<String, String> values = super.getValues();
/* 236 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 237 */     if (this._fiscalYear != null) values.put("FiscalYear", DaoUtils.getXmlSafeFieldValue(4, this._fiscalYear)); 
/* 238 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 239 */     if (this._itemId != null) values.put("ItemId", DaoUtils.getXmlSafeFieldValue(12, this._itemId)); 
/* 240 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 241 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 242 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 243 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 244 */     if (this._wacQuantityReceived != null) values.put("WacQuantityReceived", DaoUtils.getXmlSafeFieldValue(3, this._wacQuantityReceived)); 
/* 245 */     if (this._wacValueReceived != null) values.put("WacValueReceived", DaoUtils.getXmlSafeFieldValue(3, this._wacValueReceived)); 
/* 246 */     if (this._pwacQuantityOnhandEndofyear != null) values.put("PwacQuantityOnhandEndofyear", DaoUtils.getXmlSafeFieldValue(3, this._pwacQuantityOnhandEndofyear)); 
/* 247 */     if (this._pwacValueOnhandEndofyear != null) values.put("PwacValueOnhandEndofyear", DaoUtils.getXmlSafeFieldValue(3, this._pwacValueOnhandEndofyear)); 
/* 248 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 253 */     super.setValues(argValues);
/* 254 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 256 */       String fieldName = field.getKey();
/* 257 */       String fieldValue = field.getValue();
/* 258 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 262 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 263 */             setOrganizationId((Long)value);
/* 264 */           } catch (Exception ee) {
/* 265 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FiscalYear":
/*     */           try {
/* 271 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 272 */             setFiscalYear((Integer)value);
/* 273 */           } catch (Exception ee) {
/* 274 */             throw new DtxException("An exception occurred while calling setFiscalYear() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 280 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 281 */             setRetailLocationId((Long)value);
/* 282 */           } catch (Exception ee) {
/* 283 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemId":
/*     */           try {
/* 289 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 290 */             setItemId((String)value);
/* 291 */           } catch (Exception ee) {
/* 292 */             throw new DtxException("An exception occurred while calling setItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 298 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 299 */             setCreateDate((Date)value);
/* 300 */           } catch (Exception ee) {
/* 301 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 307 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 308 */             setCreateUserId((String)value);
/* 309 */           } catch (Exception ee) {
/* 310 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 316 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 317 */             setUpdateDate((Date)value);
/* 318 */           } catch (Exception ee) {
/* 319 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 325 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 326 */             setUpdateUserId((String)value);
/* 327 */           } catch (Exception ee) {
/* 328 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WacQuantityReceived":
/*     */           try {
/* 334 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 335 */             setWacQuantityReceived((BigDecimal)value);
/* 336 */           } catch (Exception ee) {
/* 337 */             throw new DtxException("An exception occurred while calling setWacQuantityReceived() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WacValueReceived":
/*     */           try {
/* 343 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 344 */             setWacValueReceived((BigDecimal)value);
/* 345 */           } catch (Exception ee) {
/* 346 */             throw new DtxException("An exception occurred while calling setWacValueReceived() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PwacQuantityOnhandEndofyear":
/*     */           try {
/* 352 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 353 */             setPwacQuantityOnhandEndofyear((BigDecimal)value);
/* 354 */           } catch (Exception ee) {
/* 355 */             throw new DtxException("An exception occurred while calling setPwacQuantityOnhandEndofyear() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PwacValueOnhandEndofyear":
/*     */           try {
/* 361 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 362 */             setPwacValueOnhandEndofyear((BigDecimal)value);
/* 363 */           } catch (Exception ee) {
/* 364 */             throw new DtxException("An exception occurred while calling setPwacValueOnhandEndofyear() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryCostItemYearEndDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */