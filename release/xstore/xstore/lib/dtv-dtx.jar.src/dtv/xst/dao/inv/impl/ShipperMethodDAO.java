/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.ShipperMethodId;
/*     */ import java.util.Date;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ShipperMethodDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1477279106L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ShipperMethodDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _shipperMethodId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _shipperMethodDesc;
/*     */   private String _shipperId;
/*     */   private String _domesticServiceCode;
/*     */   private String _intlServiceCode;
/*     */   private Integer _displayOrder;
/*     */   private Integer _priority;
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
/*     */   public String getShipperMethodId() {
/*  51 */     return this._shipperMethodId;
/*     */   }
/*     */   
/*     */   public void setShipperMethodId(String argShipperMethodId) {
/*  55 */     if (changed(argShipperMethodId, this._shipperMethodId, "shipperMethodId")) {
/*  56 */       this._shipperMethodId = (argShipperMethodId != null && MANAGE_CASE) ? argShipperMethodId.toUpperCase() : argShipperMethodId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/*  61 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/*  65 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/*  66 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/*  71 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/*  75 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/*  76 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  81 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  85 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  86 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  92 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  96 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  97 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 102 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 106 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 107 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 113 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 117 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 118 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getShipperMethodDesc() {
/* 123 */     return this._shipperMethodDesc;
/*     */   }
/*     */   
/*     */   public void setShipperMethodDesc(String argShipperMethodDesc) {
/* 127 */     if (changed(argShipperMethodDesc, this._shipperMethodDesc, "shipperMethodDesc")) {
/* 128 */       this._shipperMethodDesc = argShipperMethodDesc;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getShipperId() {
/* 133 */     return this._shipperId;
/*     */   }
/*     */   
/*     */   public void setShipperId(String argShipperId) {
/* 137 */     if (changed(argShipperId, this._shipperId, "shipperId")) {
/* 138 */       this._shipperId = argShipperId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDomesticServiceCode() {
/* 143 */     return this._domesticServiceCode;
/*     */   }
/*     */   
/*     */   public void setDomesticServiceCode(String argDomesticServiceCode) {
/* 147 */     if (changed(argDomesticServiceCode, this._domesticServiceCode, "domesticServiceCode")) {
/* 148 */       this._domesticServiceCode = argDomesticServiceCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getIntlServiceCode() {
/* 153 */     return this._intlServiceCode;
/*     */   }
/*     */   
/*     */   public void setIntlServiceCode(String argIntlServiceCode) {
/* 157 */     if (changed(argIntlServiceCode, this._intlServiceCode, "intlServiceCode")) {
/* 158 */       this._intlServiceCode = argIntlServiceCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getDisplayOrder() {
/* 163 */     return this._displayOrder;
/*     */   }
/*     */   
/*     */   public void setDisplayOrder(Integer argDisplayOrder) {
/* 167 */     if (changed(argDisplayOrder, this._displayOrder, "displayOrder")) {
/* 168 */       this._displayOrder = argDisplayOrder;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getPriority() {
/* 173 */     return this._priority;
/*     */   }
/*     */   
/*     */   public void setPriority(Integer argPriority) {
/* 177 */     if (changed(argPriority, this._priority, "priority")) {
/* 178 */       this._priority = argPriority;
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
/* 190 */     if (getShipperMethodId() != null) {
/* 191 */       buf.append("shipperMethodId").append("=").append(getShipperMethodId()).append(" ");
/*     */     }
/* 193 */     if (getOrgCode() != null) {
/* 194 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 196 */     if (getOrgValue() != null) {
/* 197 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 199 */     if (getCreateDate() != null) {
/* 200 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 202 */     if (getCreateUserId() != null) {
/* 203 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 205 */     if (getUpdateDate() != null) {
/* 206 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 208 */     if (getUpdateUserId() != null) {
/* 209 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 211 */     if (getShipperMethodDesc() != null) {
/* 212 */       buf.append("shipperMethodDesc").append("=").append(getShipperMethodDesc()).append(" ");
/*     */     }
/* 214 */     if (getShipperId() != null) {
/* 215 */       buf.append("shipperId").append("=").append(getShipperId()).append(" ");
/*     */     }
/* 217 */     if (getDomesticServiceCode() != null) {
/* 218 */       buf.append("domesticServiceCode").append("=").append(getDomesticServiceCode()).append(" ");
/*     */     }
/* 220 */     if (getIntlServiceCode() != null) {
/* 221 */       buf.append("intlServiceCode").append("=").append(getIntlServiceCode()).append(" ");
/*     */     }
/* 223 */     if (getDisplayOrder() != null) {
/* 224 */       buf.append("displayOrder").append("=").append(getDisplayOrder()).append(" ");
/*     */     }
/* 226 */     if (getPriority() != null) {
/* 227 */       buf.append("priority").append("=").append(getPriority()).append(" ");
/*     */     }
/*     */     
/* 230 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 234 */     ShipperMethodId id = new ShipperMethodId();
/* 235 */     id.setOrganizationId(getOrganizationId());
/* 236 */     id.setShipperMethodId(getShipperMethodId());
/* 237 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 241 */     setOrganizationId(((ShipperMethodId)argObjectId).getOrganizationId());
/* 242 */     setShipperMethodId(((ShipperMethodId)argObjectId).getShipperMethodId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 246 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 250 */     StringBuilder buf = new StringBuilder(700);
/* 251 */     buf.append("<").append("dao").append(" name=\"ShipperMethod\" cmd=\"" + getObjectStateString() + "\">");
/* 252 */     getFieldsAsXml(buf);
/* 253 */     buf.append("</").append("dao").append(">");
/*     */     
/* 255 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 259 */     Map<String, String> values = super.getValues();
/* 260 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 261 */     if (this._shipperMethodId != null) values.put("ShipperMethodId", DaoUtils.getXmlSafeFieldValue(12, this._shipperMethodId)); 
/* 262 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 263 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 264 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 265 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 266 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 267 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 268 */     if (this._shipperMethodDesc != null) values.put("ShipperMethodDesc", DaoUtils.getXmlSafeFieldValue(12, this._shipperMethodDesc)); 
/* 269 */     if (this._shipperId != null) values.put("ShipperId", DaoUtils.getXmlSafeFieldValue(12, this._shipperId)); 
/* 270 */     if (this._domesticServiceCode != null) values.put("DomesticServiceCode", DaoUtils.getXmlSafeFieldValue(12, this._domesticServiceCode)); 
/* 271 */     if (this._intlServiceCode != null) values.put("IntlServiceCode", DaoUtils.getXmlSafeFieldValue(12, this._intlServiceCode)); 
/* 272 */     if (this._displayOrder != null) values.put("DisplayOrder", DaoUtils.getXmlSafeFieldValue(4, this._displayOrder)); 
/* 273 */     if (this._priority != null) values.put("Priority", DaoUtils.getXmlSafeFieldValue(4, this._priority)); 
/* 274 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 279 */     super.setValues(argValues);
/* 280 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 282 */       String fieldName = field.getKey();
/* 283 */       String fieldValue = field.getValue();
/* 284 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 288 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 289 */             setOrganizationId((Long)value);
/* 290 */           } catch (Exception ee) {
/* 291 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ShipperMethodId":
/*     */           try {
/* 297 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 298 */             setShipperMethodId((String)value);
/* 299 */           } catch (Exception ee) {
/* 300 */             throw new DtxException("An exception occurred while calling setShipperMethodId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 306 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 307 */             setOrgCode((String)value);
/* 308 */           } catch (Exception ee) {
/* 309 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 315 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 316 */             setOrgValue((String)value);
/* 317 */           } catch (Exception ee) {
/* 318 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 324 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 325 */             setCreateDate((Date)value);
/* 326 */           } catch (Exception ee) {
/* 327 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 333 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 334 */             setCreateUserId((String)value);
/* 335 */           } catch (Exception ee) {
/* 336 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 342 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 343 */             setUpdateDate((Date)value);
/* 344 */           } catch (Exception ee) {
/* 345 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 351 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 352 */             setUpdateUserId((String)value);
/* 353 */           } catch (Exception ee) {
/* 354 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ShipperMethodDesc":
/*     */           try {
/* 360 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 361 */             setShipperMethodDesc((String)value);
/* 362 */           } catch (Exception ee) {
/* 363 */             throw new DtxException("An exception occurred while calling setShipperMethodDesc() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ShipperId":
/*     */           try {
/* 369 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 370 */             setShipperId((String)value);
/* 371 */           } catch (Exception ee) {
/* 372 */             throw new DtxException("An exception occurred while calling setShipperId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DomesticServiceCode":
/*     */           try {
/* 378 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 379 */             setDomesticServiceCode((String)value);
/* 380 */           } catch (Exception ee) {
/* 381 */             throw new DtxException("An exception occurred while calling setDomesticServiceCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "IntlServiceCode":
/*     */           try {
/* 387 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 388 */             setIntlServiceCode((String)value);
/* 389 */           } catch (Exception ee) {
/* 390 */             throw new DtxException("An exception occurred while calling setIntlServiceCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DisplayOrder":
/*     */           try {
/* 396 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 397 */             setDisplayOrder((Integer)value);
/* 398 */           } catch (Exception ee) {
/* 399 */             throw new DtxException("An exception occurred while calling setDisplayOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Priority":
/*     */           try {
/* 405 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 406 */             setPriority((Integer)value);
/* 407 */           } catch (Exception ee) {
/* 408 */             throw new DtxException("An exception occurred while calling setPriority() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\ShipperMethodDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */