/*     */ package dtv.xst.dao.ctl.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.ctl.VersionId;
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
/*     */ public class VersionDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 2016261304L;
/*  23 */   private static final Logger _logger = Logger.getLogger(VersionDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _baseSchemaVersion;
/*     */   private String _customerSchemaVersion;
/*     */   private String _customer;
/*     */   private DtvDate _baseSchemaDate;
/*     */   private DtvDate _customerSchemaDate;
/*     */   
/*     */   public Long getOrganizationId() {
/*  37 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  41 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  42 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  47 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  51 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  52 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  58 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  62 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  63 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  68 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  72 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  73 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  79 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  83 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  84 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getBaseSchemaVersion() {
/*  89 */     return this._baseSchemaVersion;
/*     */   }
/*     */   
/*     */   public void setBaseSchemaVersion(String argBaseSchemaVersion) {
/*  93 */     if (changed(argBaseSchemaVersion, this._baseSchemaVersion, "baseSchemaVersion")) {
/*  94 */       this._baseSchemaVersion = argBaseSchemaVersion;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustomerSchemaVersion() {
/*  99 */     return this._customerSchemaVersion;
/*     */   }
/*     */   
/*     */   public void setCustomerSchemaVersion(String argCustomerSchemaVersion) {
/* 103 */     if (changed(argCustomerSchemaVersion, this._customerSchemaVersion, "customerSchemaVersion")) {
/* 104 */       this._customerSchemaVersion = argCustomerSchemaVersion;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustomer() {
/* 109 */     return this._customer;
/*     */   }
/*     */   
/*     */   public void setCustomer(String argCustomer) {
/* 113 */     if (changed(argCustomer, this._customer, "customer")) {
/* 114 */       this._customer = argCustomer;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBaseSchemaDate() {
/* 119 */     return (Date)this._baseSchemaDate;
/*     */   }
/*     */   
/*     */   public void setBaseSchemaDate(Date argBaseSchemaDate) {
/* 123 */     if (changed(argBaseSchemaDate, this._baseSchemaDate, "baseSchemaDate")) {
/* 124 */       this._baseSchemaDate = (argBaseSchemaDate == null || argBaseSchemaDate instanceof DtvDate) ? (DtvDate)argBaseSchemaDate : new DtvDate(argBaseSchemaDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getCustomerSchemaDate() {
/* 130 */     return (Date)this._customerSchemaDate;
/*     */   }
/*     */   
/*     */   public void setCustomerSchemaDate(Date argCustomerSchemaDate) {
/* 134 */     if (changed(argCustomerSchemaDate, this._customerSchemaDate, "customerSchemaDate")) {
/* 135 */       this._customerSchemaDate = (argCustomerSchemaDate == null || argCustomerSchemaDate instanceof DtvDate) ? (DtvDate)argCustomerSchemaDate : new DtvDate(argCustomerSchemaDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 143 */     StringBuilder buf = new StringBuilder(512);
/* 144 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 145 */     if (getOrganizationId() != null) {
/* 146 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 148 */     if (getCreateDate() != null) {
/* 149 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 151 */     if (getCreateUserId() != null) {
/* 152 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 154 */     if (getUpdateDate() != null) {
/* 155 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 157 */     if (getUpdateUserId() != null) {
/* 158 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 160 */     if (getBaseSchemaVersion() != null) {
/* 161 */       buf.append("baseSchemaVersion").append("=").append(getBaseSchemaVersion()).append(" ");
/*     */     }
/* 163 */     if (getCustomerSchemaVersion() != null) {
/* 164 */       buf.append("customerSchemaVersion").append("=").append(getCustomerSchemaVersion()).append(" ");
/*     */     }
/* 166 */     if (getCustomer() != null) {
/* 167 */       buf.append("customer").append("=").append(getCustomer()).append(" ");
/*     */     }
/* 169 */     if (getBaseSchemaDate() != null) {
/* 170 */       buf.append("baseSchemaDate").append("=").append(getBaseSchemaDate()).append(" ");
/*     */     }
/* 172 */     if (getCustomerSchemaDate() != null) {
/* 173 */       buf.append("customerSchemaDate").append("=").append(getCustomerSchemaDate()).append(" ");
/*     */     }
/*     */     
/* 176 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 180 */     VersionId id = new VersionId();
/* 181 */     id.setOrganizationId(getOrganizationId());
/* 182 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 186 */     setOrganizationId(((VersionId)argObjectId).getOrganizationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 190 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 194 */     StringBuilder buf = new StringBuilder(500);
/* 195 */     buf.append("<").append("dao").append(" name=\"Version\" cmd=\"" + getObjectStateString() + "\">");
/* 196 */     getFieldsAsXml(buf);
/* 197 */     buf.append("</").append("dao").append(">");
/*     */     
/* 199 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 203 */     Map<String, String> values = super.getValues();
/* 204 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 205 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 206 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 207 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 208 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 209 */     if (this._baseSchemaVersion != null) values.put("BaseSchemaVersion", DaoUtils.getXmlSafeFieldValue(12, this._baseSchemaVersion)); 
/* 210 */     if (this._customerSchemaVersion != null) values.put("CustomerSchemaVersion", DaoUtils.getXmlSafeFieldValue(12, this._customerSchemaVersion)); 
/* 211 */     if (this._customer != null) values.put("Customer", DaoUtils.getXmlSafeFieldValue(12, this._customer)); 
/* 212 */     if (this._baseSchemaDate != null) values.put("BaseSchemaDate", DaoUtils.getXmlSafeFieldValue(91, this._baseSchemaDate)); 
/* 213 */     if (this._customerSchemaDate != null) values.put("CustomerSchemaDate", DaoUtils.getXmlSafeFieldValue(91, this._customerSchemaDate)); 
/* 214 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 219 */     super.setValues(argValues);
/* 220 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 222 */       String fieldName = field.getKey();
/* 223 */       String fieldValue = field.getValue();
/* 224 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 228 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 229 */             setOrganizationId((Long)value);
/* 230 */           } catch (Exception ee) {
/* 231 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 237 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 238 */             setCreateDate((Date)value);
/* 239 */           } catch (Exception ee) {
/* 240 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 246 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 247 */             setCreateUserId((String)value);
/* 248 */           } catch (Exception ee) {
/* 249 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 255 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 256 */             setUpdateDate((Date)value);
/* 257 */           } catch (Exception ee) {
/* 258 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 264 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 265 */             setUpdateUserId((String)value);
/* 266 */           } catch (Exception ee) {
/* 267 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BaseSchemaVersion":
/*     */           try {
/* 273 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 274 */             setBaseSchemaVersion((String)value);
/* 275 */           } catch (Exception ee) {
/* 276 */             throw new DtxException("An exception occurred while calling setBaseSchemaVersion() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustomerSchemaVersion":
/*     */           try {
/* 282 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 283 */             setCustomerSchemaVersion((String)value);
/* 284 */           } catch (Exception ee) {
/* 285 */             throw new DtxException("An exception occurred while calling setCustomerSchemaVersion() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Customer":
/*     */           try {
/* 291 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 292 */             setCustomer((String)value);
/* 293 */           } catch (Exception ee) {
/* 294 */             throw new DtxException("An exception occurred while calling setCustomer() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BaseSchemaDate":
/*     */           try {
/* 300 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 301 */             setBaseSchemaDate((Date)value);
/* 302 */           } catch (Exception ee) {
/* 303 */             throw new DtxException("An exception occurred while calling setBaseSchemaDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustomerSchemaDate":
/*     */           try {
/* 309 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 310 */             setCustomerSchemaDate((Date)value);
/* 311 */           } catch (Exception ee) {
/* 312 */             throw new DtxException("An exception occurred while calling setCustomerSchemaDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\impl\VersionDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */