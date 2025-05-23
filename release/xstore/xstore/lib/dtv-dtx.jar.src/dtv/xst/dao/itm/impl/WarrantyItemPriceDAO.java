/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.WarrantyItemPriceId;
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
/*     */ public class WarrantyItemPriceDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 231273530L;
/*  23 */   private static final Logger _logger = Logger.getLogger(WarrantyItemPriceDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _itemId;
/*     */   private Long _warrantyPriceSeq;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _minItemPriceAmt;
/*     */   private BigDecimal _maxItemPriceAmt;
/*     */   private BigDecimal _priceAmt;
/*     */   private BigDecimal _pricePercentage;
/*     */   private BigDecimal _minPriceAmt;
/*     */   private String _refItemId;
/*     */   
/*     */   public Long getOrganizationId() {
/*  42 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  46 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  47 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getItemId() {
/*  52 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  56 */     if (changed(argItemId, this._itemId, "itemId")) {
/*  57 */       this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWarrantyPriceSeq() {
/*  62 */     return this._warrantyPriceSeq;
/*     */   }
/*     */   
/*     */   public void setWarrantyPriceSeq(Long argWarrantyPriceSeq) {
/*  66 */     if (changed(argWarrantyPriceSeq, this._warrantyPriceSeq, "warrantyPriceSeq")) {
/*  67 */       this._warrantyPriceSeq = argWarrantyPriceSeq;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/*  72 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/*  76 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/*  77 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/*  82 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/*  86 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/*  87 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  92 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  96 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  97 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 103 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 107 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 108 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 113 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 117 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 118 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 124 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 128 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 129 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getMinItemPriceAmt() {
/* 134 */     return this._minItemPriceAmt;
/*     */   }
/*     */   
/*     */   public void setMinItemPriceAmt(BigDecimal argMinItemPriceAmt) {
/* 138 */     if (changed(argMinItemPriceAmt, this._minItemPriceAmt, "minItemPriceAmt")) {
/* 139 */       this._minItemPriceAmt = argMinItemPriceAmt;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getMaxItemPriceAmt() {
/* 144 */     return this._maxItemPriceAmt;
/*     */   }
/*     */   
/*     */   public void setMaxItemPriceAmt(BigDecimal argMaxItemPriceAmt) {
/* 148 */     if (changed(argMaxItemPriceAmt, this._maxItemPriceAmt, "maxItemPriceAmt")) {
/* 149 */       this._maxItemPriceAmt = argMaxItemPriceAmt;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getPriceAmt() {
/* 154 */     return this._priceAmt;
/*     */   }
/*     */   
/*     */   public void setPriceAmt(BigDecimal argPriceAmt) {
/* 158 */     if (changed(argPriceAmt, this._priceAmt, "priceAmt")) {
/* 159 */       this._priceAmt = argPriceAmt;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getPricePercentage() {
/* 164 */     return this._pricePercentage;
/*     */   }
/*     */   
/*     */   public void setPricePercentage(BigDecimal argPricePercentage) {
/* 168 */     if (changed(argPricePercentage, this._pricePercentage, "pricePercentage")) {
/* 169 */       this._pricePercentage = argPricePercentage;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getMinPriceAmt() {
/* 174 */     return this._minPriceAmt;
/*     */   }
/*     */   
/*     */   public void setMinPriceAmt(BigDecimal argMinPriceAmt) {
/* 178 */     if (changed(argMinPriceAmt, this._minPriceAmt, "minPriceAmt")) {
/* 179 */       this._minPriceAmt = argMinPriceAmt;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getRefItemId() {
/* 184 */     return this._refItemId;
/*     */   }
/*     */   
/*     */   public void setRefItemId(String argRefItemId) {
/* 188 */     if (changed(argRefItemId, this._refItemId, "refItemId")) {
/* 189 */       this._refItemId = argRefItemId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 196 */     StringBuilder buf = new StringBuilder(512);
/* 197 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 198 */     if (getOrganizationId() != null) {
/* 199 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 201 */     if (getItemId() != null) {
/* 202 */       buf.append("itemId").append("=").append(getItemId()).append(" ");
/*     */     }
/* 204 */     if (getWarrantyPriceSeq() != null) {
/* 205 */       buf.append("warrantyPriceSeq").append("=").append(getWarrantyPriceSeq()).append(" ");
/*     */     }
/* 207 */     if (getOrgCode() != null) {
/* 208 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 210 */     if (getOrgValue() != null) {
/* 211 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 213 */     if (getCreateDate() != null) {
/* 214 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 216 */     if (getCreateUserId() != null) {
/* 217 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 219 */     if (getUpdateDate() != null) {
/* 220 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 222 */     if (getUpdateUserId() != null) {
/* 223 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 225 */     if (getMinItemPriceAmt() != null) {
/* 226 */       buf.append("minItemPriceAmt").append("=").append(getMinItemPriceAmt()).append(" ");
/*     */     }
/* 228 */     if (getMaxItemPriceAmt() != null) {
/* 229 */       buf.append("maxItemPriceAmt").append("=").append(getMaxItemPriceAmt()).append(" ");
/*     */     }
/* 231 */     if (getPriceAmt() != null) {
/* 232 */       buf.append("priceAmt").append("=").append(getPriceAmt()).append(" ");
/*     */     }
/* 234 */     if (getPricePercentage() != null) {
/* 235 */       buf.append("pricePercentage").append("=").append(getPricePercentage()).append(" ");
/*     */     }
/* 237 */     if (getMinPriceAmt() != null) {
/* 238 */       buf.append("minPriceAmt").append("=").append(getMinPriceAmt()).append(" ");
/*     */     }
/* 240 */     if (getRefItemId() != null) {
/* 241 */       buf.append("refItemId").append("=").append(getRefItemId()).append(" ");
/*     */     }
/*     */     
/* 244 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 248 */     WarrantyItemPriceId id = new WarrantyItemPriceId();
/* 249 */     id.setOrganizationId(getOrganizationId());
/* 250 */     id.setItemId(getItemId());
/* 251 */     id.setWarrantyPriceSeq(getWarrantyPriceSeq());
/* 252 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 256 */     setOrganizationId(((WarrantyItemPriceId)argObjectId).getOrganizationId());
/* 257 */     setItemId(((WarrantyItemPriceId)argObjectId).getItemId());
/* 258 */     setWarrantyPriceSeq(((WarrantyItemPriceId)argObjectId).getWarrantyPriceSeq());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 262 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 266 */     StringBuilder buf = new StringBuilder(750);
/* 267 */     buf.append("<").append("dao").append(" name=\"WarrantyItemPrice\" cmd=\"" + getObjectStateString() + "\">");
/* 268 */     getFieldsAsXml(buf);
/* 269 */     buf.append("</").append("dao").append(">");
/*     */     
/* 271 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 275 */     Map<String, String> values = super.getValues();
/* 276 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 277 */     if (this._itemId != null) values.put("ItemId", DaoUtils.getXmlSafeFieldValue(12, this._itemId)); 
/* 278 */     if (this._warrantyPriceSeq != null) values.put("WarrantyPriceSeq", DaoUtils.getXmlSafeFieldValue(-5, this._warrantyPriceSeq)); 
/* 279 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 280 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 281 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 282 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 283 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 284 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 285 */     if (this._minItemPriceAmt != null) values.put("MinItemPriceAmt", DaoUtils.getXmlSafeFieldValue(3, this._minItemPriceAmt)); 
/* 286 */     if (this._maxItemPriceAmt != null) values.put("MaxItemPriceAmt", DaoUtils.getXmlSafeFieldValue(3, this._maxItemPriceAmt)); 
/* 287 */     if (this._priceAmt != null) values.put("PriceAmt", DaoUtils.getXmlSafeFieldValue(3, this._priceAmt)); 
/* 288 */     if (this._pricePercentage != null) values.put("PricePercentage", DaoUtils.getXmlSafeFieldValue(3, this._pricePercentage)); 
/* 289 */     if (this._minPriceAmt != null) values.put("MinPriceAmt", DaoUtils.getXmlSafeFieldValue(3, this._minPriceAmt)); 
/* 290 */     if (this._refItemId != null) values.put("RefItemId", DaoUtils.getXmlSafeFieldValue(12, this._refItemId)); 
/* 291 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 296 */     super.setValues(argValues);
/* 297 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 299 */       String fieldName = field.getKey();
/* 300 */       String fieldValue = field.getValue();
/* 301 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 305 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 306 */             setOrganizationId((Long)value);
/* 307 */           } catch (Exception ee) {
/* 308 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemId":
/*     */           try {
/* 314 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 315 */             setItemId((String)value);
/* 316 */           } catch (Exception ee) {
/* 317 */             throw new DtxException("An exception occurred while calling setItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyPriceSeq":
/*     */           try {
/* 323 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 324 */             setWarrantyPriceSeq((Long)value);
/* 325 */           } catch (Exception ee) {
/* 326 */             throw new DtxException("An exception occurred while calling setWarrantyPriceSeq() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 332 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 333 */             setOrgCode((String)value);
/* 334 */           } catch (Exception ee) {
/* 335 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 341 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 342 */             setOrgValue((String)value);
/* 343 */           } catch (Exception ee) {
/* 344 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 350 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 351 */             setCreateDate((Date)value);
/* 352 */           } catch (Exception ee) {
/* 353 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 359 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 360 */             setCreateUserId((String)value);
/* 361 */           } catch (Exception ee) {
/* 362 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 368 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 369 */             setUpdateDate((Date)value);
/* 370 */           } catch (Exception ee) {
/* 371 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 377 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 378 */             setUpdateUserId((String)value);
/* 379 */           } catch (Exception ee) {
/* 380 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MinItemPriceAmt":
/*     */           try {
/* 386 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 387 */             setMinItemPriceAmt((BigDecimal)value);
/* 388 */           } catch (Exception ee) {
/* 389 */             throw new DtxException("An exception occurred while calling setMinItemPriceAmt() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MaxItemPriceAmt":
/*     */           try {
/* 395 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 396 */             setMaxItemPriceAmt((BigDecimal)value);
/* 397 */           } catch (Exception ee) {
/* 398 */             throw new DtxException("An exception occurred while calling setMaxItemPriceAmt() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PriceAmt":
/*     */           try {
/* 404 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 405 */             setPriceAmt((BigDecimal)value);
/* 406 */           } catch (Exception ee) {
/* 407 */             throw new DtxException("An exception occurred while calling setPriceAmt() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PricePercentage":
/*     */           try {
/* 413 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 414 */             setPricePercentage((BigDecimal)value);
/* 415 */           } catch (Exception ee) {
/* 416 */             throw new DtxException("An exception occurred while calling setPricePercentage() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MinPriceAmt":
/*     */           try {
/* 422 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 423 */             setMinPriceAmt((BigDecimal)value);
/* 424 */           } catch (Exception ee) {
/* 425 */             throw new DtxException("An exception occurred while calling setMinPriceAmt() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RefItemId":
/*     */           try {
/* 431 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 432 */             setRefItemId((String)value);
/* 433 */           } catch (Exception ee) {
/* 434 */             throw new DtxException("An exception occurred while calling setRefItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\WarrantyItemPriceDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */