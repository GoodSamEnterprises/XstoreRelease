/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.CustomerAccountPlanId;
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
/*     */ public class CustomerAccountPlanDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1544725528L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CustomerAccountPlanDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _custAccountCode;
/*     */   private String _planId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private String _planDescription;
/*     */   private DtvDate _effectiveDate;
/*     */   private DtvDate _expirationDate;
/*     */   private Integer _displayOrder;
/*     */   
/*     */   public Long getOrganizationId() {
/*  40 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  44 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  45 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustAccountCode() {
/*  50 */     return this._custAccountCode;
/*     */   }
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/*  54 */     if (changed(argCustAccountCode, this._custAccountCode, "custAccountCode")) {
/*  55 */       this._custAccountCode = (argCustAccountCode != null && MANAGE_CASE) ? argCustAccountCode.toUpperCase() : argCustAccountCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPlanId() {
/*  60 */     return this._planId;
/*     */   }
/*     */   
/*     */   public void setPlanId(String argPlanId) {
/*  64 */     if (changed(argPlanId, this._planId, "planId")) {
/*  65 */       this._planId = (argPlanId != null && MANAGE_CASE) ? argPlanId.toUpperCase() : argPlanId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  70 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  74 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  75 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  81 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  85 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  86 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  91 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  95 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  96 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 102 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 106 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 107 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/* 112 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 116 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/* 117 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/* 122 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 126 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/* 127 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPlanDescription() {
/* 132 */     return this._planDescription;
/*     */   }
/*     */   
/*     */   public void setPlanDescription(String argPlanDescription) {
/* 136 */     if (changed(argPlanDescription, this._planDescription, "planDescription")) {
/* 137 */       this._planDescription = argPlanDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/* 142 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 146 */     if (changed(argEffectiveDate, this._effectiveDate, "effectiveDate")) {
/* 147 */       this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getExpirationDate() {
/* 153 */     return (Date)this._expirationDate;
/*     */   }
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 157 */     if (changed(argExpirationDate, this._expirationDate, "expirationDate")) {
/* 158 */       this._expirationDate = (argExpirationDate == null || argExpirationDate instanceof DtvDate) ? (DtvDate)argExpirationDate : new DtvDate(argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Integer getDisplayOrder() {
/* 164 */     return this._displayOrder;
/*     */   }
/*     */   
/*     */   public void setDisplayOrder(Integer argDisplayOrder) {
/* 168 */     if (changed(argDisplayOrder, this._displayOrder, "displayOrder")) {
/* 169 */       this._displayOrder = argDisplayOrder;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 176 */     StringBuilder buf = new StringBuilder(512);
/* 177 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 178 */     if (getOrganizationId() != null) {
/* 179 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 181 */     if (getCustAccountCode() != null) {
/* 182 */       buf.append("custAccountCode").append("=").append(getCustAccountCode()).append(" ");
/*     */     }
/* 184 */     if (getPlanId() != null) {
/* 185 */       buf.append("planId").append("=").append(getPlanId()).append(" ");
/*     */     }
/* 187 */     if (getCreateDate() != null) {
/* 188 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 190 */     if (getCreateUserId() != null) {
/* 191 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 193 */     if (getUpdateDate() != null) {
/* 194 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 196 */     if (getUpdateUserId() != null) {
/* 197 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 199 */     if (getOrgCode() != null) {
/* 200 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 202 */     if (getOrgValue() != null) {
/* 203 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 205 */     if (getPlanDescription() != null) {
/* 206 */       buf.append("planDescription").append("=").append(getPlanDescription()).append(" ");
/*     */     }
/* 208 */     if (getEffectiveDate() != null) {
/* 209 */       buf.append("effectiveDate").append("=").append(getEffectiveDate()).append(" ");
/*     */     }
/* 211 */     if (getExpirationDate() != null) {
/* 212 */       buf.append("expirationDate").append("=").append(getExpirationDate()).append(" ");
/*     */     }
/* 214 */     if (getDisplayOrder() != null) {
/* 215 */       buf.append("displayOrder").append("=").append(getDisplayOrder()).append(" ");
/*     */     }
/*     */     
/* 218 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 222 */     CustomerAccountPlanId id = new CustomerAccountPlanId();
/* 223 */     id.setOrganizationId(getOrganizationId());
/* 224 */     id.setCustAccountCode(getCustAccountCode());
/* 225 */     id.setPlanId(getPlanId());
/* 226 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 230 */     setOrganizationId(((CustomerAccountPlanId)argObjectId).getOrganizationId());
/* 231 */     setCustAccountCode(((CustomerAccountPlanId)argObjectId).getCustAccountCode());
/* 232 */     setPlanId(((CustomerAccountPlanId)argObjectId).getPlanId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 236 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 240 */     StringBuilder buf = new StringBuilder(650);
/* 241 */     buf.append("<").append("dao").append(" name=\"CustomerAccountPlan\" cmd=\"" + getObjectStateString() + "\">");
/* 242 */     getFieldsAsXml(buf);
/* 243 */     buf.append("</").append("dao").append(">");
/*     */     
/* 245 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 249 */     Map<String, String> values = super.getValues();
/* 250 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 251 */     if (this._custAccountCode != null) values.put("CustAccountCode", DaoUtils.getXmlSafeFieldValue(12, this._custAccountCode)); 
/* 252 */     if (this._planId != null) values.put("PlanId", DaoUtils.getXmlSafeFieldValue(12, this._planId)); 
/* 253 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 254 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 255 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 256 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 257 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 258 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 259 */     if (this._planDescription != null) values.put("PlanDescription", DaoUtils.getXmlSafeFieldValue(12, this._planDescription)); 
/* 260 */     if (this._effectiveDate != null) values.put("EffectiveDate", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDate)); 
/* 261 */     if (this._expirationDate != null) values.put("ExpirationDate", DaoUtils.getXmlSafeFieldValue(91, this._expirationDate)); 
/* 262 */     if (this._displayOrder != null) values.put("DisplayOrder", DaoUtils.getXmlSafeFieldValue(4, this._displayOrder)); 
/* 263 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 268 */     super.setValues(argValues);
/* 269 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 271 */       String fieldName = field.getKey();
/* 272 */       String fieldValue = field.getValue();
/* 273 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 277 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 278 */             setOrganizationId((Long)value);
/* 279 */           } catch (Exception ee) {
/* 280 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountCode":
/*     */           try {
/* 286 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 287 */             setCustAccountCode((String)value);
/* 288 */           } catch (Exception ee) {
/* 289 */             throw new DtxException("An exception occurred while calling setCustAccountCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PlanId":
/*     */           try {
/* 295 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 296 */             setPlanId((String)value);
/* 297 */           } catch (Exception ee) {
/* 298 */             throw new DtxException("An exception occurred while calling setPlanId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 304 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 305 */             setCreateDate((Date)value);
/* 306 */           } catch (Exception ee) {
/* 307 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 313 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 314 */             setCreateUserId((String)value);
/* 315 */           } catch (Exception ee) {
/* 316 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 322 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 323 */             setUpdateDate((Date)value);
/* 324 */           } catch (Exception ee) {
/* 325 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 331 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 332 */             setUpdateUserId((String)value);
/* 333 */           } catch (Exception ee) {
/* 334 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 340 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 341 */             setOrgCode((String)value);
/* 342 */           } catch (Exception ee) {
/* 343 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 349 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 350 */             setOrgValue((String)value);
/* 351 */           } catch (Exception ee) {
/* 352 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PlanDescription":
/*     */           try {
/* 358 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 359 */             setPlanDescription((String)value);
/* 360 */           } catch (Exception ee) {
/* 361 */             throw new DtxException("An exception occurred while calling setPlanDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EffectiveDate":
/*     */           try {
/* 367 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 368 */             setEffectiveDate((Date)value);
/* 369 */           } catch (Exception ee) {
/* 370 */             throw new DtxException("An exception occurred while calling setEffectiveDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpirationDate":
/*     */           try {
/* 376 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 377 */             setExpirationDate((Date)value);
/* 378 */           } catch (Exception ee) {
/* 379 */             throw new DtxException("An exception occurred while calling setExpirationDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DisplayOrder":
/*     */           try {
/* 385 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 386 */             setDisplayOrder((Integer)value);
/* 387 */           } catch (Exception ee) {
/* 388 */             throw new DtxException("An exception occurred while calling setDisplayOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerAccountPlanDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */