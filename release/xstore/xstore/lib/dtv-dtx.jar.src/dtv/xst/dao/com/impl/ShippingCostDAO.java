/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.ShippingCostId;
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
/*     */ public class ShippingCostDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -234631493L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ShippingCostDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _category;
/*     */   private BigDecimal _beginRange;
/*     */   private BigDecimal _endRange;
/*     */   private BigDecimal _cost;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private BigDecimal _minimumCost;
/*     */   private BigDecimal _maximumCost;
/*     */   private String _itemId;
/*     */   
/*     */   public Long getOrganizationId() {
/*  41 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  45 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  46 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCategory() {
/*  51 */     return this._category;
/*     */   }
/*     */   
/*     */   public void setCategory(String argCategory) {
/*  55 */     if (changed(argCategory, this._category, "category")) {
/*  56 */       this._category = (argCategory != null && MANAGE_CASE) ? argCategory.toUpperCase() : argCategory;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getBeginRange() {
/*  61 */     return this._beginRange;
/*     */   }
/*     */   
/*     */   public void setBeginRange(BigDecimal argBeginRange) {
/*  65 */     if (changed(argBeginRange, this._beginRange, "beginRange")) {
/*  66 */       this._beginRange = argBeginRange;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getEndRange() {
/*  71 */     return this._endRange;
/*     */   }
/*     */   
/*     */   public void setEndRange(BigDecimal argEndRange) {
/*  75 */     if (changed(argEndRange, this._endRange, "endRange")) {
/*  76 */       this._endRange = argEndRange;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getCost() {
/*  81 */     return this._cost;
/*     */   }
/*     */   
/*     */   public void setCost(BigDecimal argCost) {
/*  85 */     if (changed(argCost, this._cost, "cost")) {
/*  86 */       this._cost = argCost;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  91 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  95 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  96 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 102 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 106 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 107 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 112 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 116 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 117 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 123 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 127 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 128 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/* 133 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 137 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/* 138 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/* 143 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 147 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/* 148 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getMinimumCost() {
/* 153 */     return this._minimumCost;
/*     */   }
/*     */   
/*     */   public void setMinimumCost(BigDecimal argMinimumCost) {
/* 157 */     if (changed(argMinimumCost, this._minimumCost, "minimumCost")) {
/* 158 */       this._minimumCost = argMinimumCost;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getMaximumCost() {
/* 163 */     return this._maximumCost;
/*     */   }
/*     */   
/*     */   public void setMaximumCost(BigDecimal argMaximumCost) {
/* 167 */     if (changed(argMaximumCost, this._maximumCost, "maximumCost")) {
/* 168 */       this._maximumCost = argMaximumCost;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getItemId() {
/* 173 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 177 */     if (changed(argItemId, this._itemId, "itemId")) {
/* 178 */       this._itemId = argItemId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 185 */     StringBuilder buf = new StringBuilder(512);
/* 186 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 187 */     if (getOrganizationId() != null) {
/* 188 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 190 */     if (getCategory() != null) {
/* 191 */       buf.append("category").append("=").append(getCategory()).append(" ");
/*     */     }
/* 193 */     if (getBeginRange() != null) {
/* 194 */       buf.append("beginRange").append("=").append(getBeginRange()).append(" ");
/*     */     }
/* 196 */     if (getEndRange() != null) {
/* 197 */       buf.append("endRange").append("=").append(getEndRange()).append(" ");
/*     */     }
/* 199 */     if (getCost() != null) {
/* 200 */       buf.append("cost").append("=").append(getCost()).append(" ");
/*     */     }
/* 202 */     if (getCreateDate() != null) {
/* 203 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 205 */     if (getCreateUserId() != null) {
/* 206 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 208 */     if (getUpdateDate() != null) {
/* 209 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 211 */     if (getUpdateUserId() != null) {
/* 212 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 214 */     if (getOrgCode() != null) {
/* 215 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 217 */     if (getOrgValue() != null) {
/* 218 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 220 */     if (getMinimumCost() != null) {
/* 221 */       buf.append("minimumCost").append("=").append(getMinimumCost()).append(" ");
/*     */     }
/* 223 */     if (getMaximumCost() != null) {
/* 224 */       buf.append("maximumCost").append("=").append(getMaximumCost()).append(" ");
/*     */     }
/* 226 */     if (getItemId() != null) {
/* 227 */       buf.append("itemId").append("=").append(getItemId()).append(" ");
/*     */     }
/*     */     
/* 230 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 234 */     ShippingCostId id = new ShippingCostId();
/* 235 */     id.setOrganizationId(getOrganizationId());
/* 236 */     id.setCategory(getCategory());
/* 237 */     id.setBeginRange(getBeginRange());
/* 238 */     id.setEndRange(getEndRange());
/* 239 */     id.setCost(getCost());
/* 240 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 244 */     setOrganizationId(((ShippingCostId)argObjectId).getOrganizationId());
/* 245 */     setCategory(((ShippingCostId)argObjectId).getCategory());
/* 246 */     setBeginRange(((ShippingCostId)argObjectId).getBeginRange());
/* 247 */     setEndRange(((ShippingCostId)argObjectId).getEndRange());
/* 248 */     setCost(((ShippingCostId)argObjectId).getCost());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 252 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 256 */     StringBuilder buf = new StringBuilder(700);
/* 257 */     buf.append("<").append("dao").append(" name=\"ShippingCost\" cmd=\"" + getObjectStateString() + "\">");
/* 258 */     getFieldsAsXml(buf);
/* 259 */     buf.append("</").append("dao").append(">");
/*     */     
/* 261 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 265 */     Map<String, String> values = super.getValues();
/* 266 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 267 */     if (this._category != null) values.put("Category", DaoUtils.getXmlSafeFieldValue(12, this._category)); 
/* 268 */     if (this._beginRange != null) values.put("BeginRange", DaoUtils.getXmlSafeFieldValue(3, this._beginRange)); 
/* 269 */     if (this._endRange != null) values.put("EndRange", DaoUtils.getXmlSafeFieldValue(3, this._endRange)); 
/* 270 */     if (this._cost != null) values.put("Cost", DaoUtils.getXmlSafeFieldValue(3, this._cost)); 
/* 271 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 272 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 273 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 274 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 275 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 276 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 277 */     if (this._minimumCost != null) values.put("MinimumCost", DaoUtils.getXmlSafeFieldValue(3, this._minimumCost)); 
/* 278 */     if (this._maximumCost != null) values.put("MaximumCost", DaoUtils.getXmlSafeFieldValue(3, this._maximumCost)); 
/* 279 */     if (this._itemId != null) values.put("ItemId", DaoUtils.getXmlSafeFieldValue(12, this._itemId)); 
/* 280 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 285 */     super.setValues(argValues);
/* 286 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 288 */       String fieldName = field.getKey();
/* 289 */       String fieldValue = field.getValue();
/* 290 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 294 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 295 */             setOrganizationId((Long)value);
/* 296 */           } catch (Exception ee) {
/* 297 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Category":
/*     */           try {
/* 303 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 304 */             setCategory((String)value);
/* 305 */           } catch (Exception ee) {
/* 306 */             throw new DtxException("An exception occurred while calling setCategory() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BeginRange":
/*     */           try {
/* 312 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 313 */             setBeginRange((BigDecimal)value);
/* 314 */           } catch (Exception ee) {
/* 315 */             throw new DtxException("An exception occurred while calling setBeginRange() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EndRange":
/*     */           try {
/* 321 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 322 */             setEndRange((BigDecimal)value);
/* 323 */           } catch (Exception ee) {
/* 324 */             throw new DtxException("An exception occurred while calling setEndRange() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Cost":
/*     */           try {
/* 330 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 331 */             setCost((BigDecimal)value);
/* 332 */           } catch (Exception ee) {
/* 333 */             throw new DtxException("An exception occurred while calling setCost() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 339 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 340 */             setCreateDate((Date)value);
/* 341 */           } catch (Exception ee) {
/* 342 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 348 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 349 */             setCreateUserId((String)value);
/* 350 */           } catch (Exception ee) {
/* 351 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 357 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 358 */             setUpdateDate((Date)value);
/* 359 */           } catch (Exception ee) {
/* 360 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 366 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 367 */             setUpdateUserId((String)value);
/* 368 */           } catch (Exception ee) {
/* 369 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 375 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 376 */             setOrgCode((String)value);
/* 377 */           } catch (Exception ee) {
/* 378 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 384 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 385 */             setOrgValue((String)value);
/* 386 */           } catch (Exception ee) {
/* 387 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MinimumCost":
/*     */           try {
/* 393 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 394 */             setMinimumCost((BigDecimal)value);
/* 395 */           } catch (Exception ee) {
/* 396 */             throw new DtxException("An exception occurred while calling setMinimumCost() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "MaximumCost":
/*     */           try {
/* 402 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 403 */             setMaximumCost((BigDecimal)value);
/* 404 */           } catch (Exception ee) {
/* 405 */             throw new DtxException("An exception occurred while calling setMaximumCost() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemId":
/*     */           try {
/* 411 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 412 */             setItemId((String)value);
/* 413 */           } catch (Exception ee) {
/* 414 */             throw new DtxException("An exception occurred while calling setItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\ShippingCostDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */