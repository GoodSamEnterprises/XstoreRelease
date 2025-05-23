/*     */ package dtv.xst.dao.tax.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tax.PostalCodeMappingId;
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
/*     */ public class PostalCodeMappingDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1218085834L;
/*  23 */   private static final Logger _logger = Logger.getLogger(PostalCodeMappingDAO.class);
/*     */   
/*     */   private String _city;
/*     */   private Long _organizationId;
/*     */   private String _postalCode;
/*     */   private String _taxLocationId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   
/*     */   public String getCity() {
/*  35 */     return this._city;
/*     */   }
/*     */   
/*     */   public void setCity(String argCity) {
/*  39 */     if (changed(argCity, this._city, "city")) {
/*  40 */       this._city = (argCity != null && MANAGE_CASE) ? argCity.toUpperCase() : argCity;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  45 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  49 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  50 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPostalCode() {
/*  55 */     return this._postalCode;
/*     */   }
/*     */   
/*     */   public void setPostalCode(String argPostalCode) {
/*  59 */     if (changed(argPostalCode, this._postalCode, "postalCode")) {
/*  60 */       this._postalCode = (argPostalCode != null && MANAGE_CASE) ? argPostalCode.toUpperCase() : argPostalCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTaxLocationId() {
/*  65 */     return this._taxLocationId;
/*     */   }
/*     */   
/*     */   public void setTaxLocationId(String argTaxLocationId) {
/*  69 */     if (changed(argTaxLocationId, this._taxLocationId, "taxLocationId")) {
/*  70 */       this._taxLocationId = (argTaxLocationId != null && MANAGE_CASE) ? argTaxLocationId.toUpperCase() : argTaxLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  75 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  79 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  80 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  86 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  90 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  91 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  96 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 100 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 101 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 107 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 111 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 112 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 119 */     StringBuilder buf = new StringBuilder(512);
/* 120 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 121 */     if (getCity() != null) {
/* 122 */       buf.append("city").append("=").append(getCity()).append(" ");
/*     */     }
/* 124 */     if (getOrganizationId() != null) {
/* 125 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 127 */     if (getPostalCode() != null) {
/* 128 */       buf.append("postalCode").append("=").append(getPostalCode()).append(" ");
/*     */     }
/* 130 */     if (getTaxLocationId() != null) {
/* 131 */       buf.append("taxLocationId").append("=").append(getTaxLocationId()).append(" ");
/*     */     }
/* 133 */     if (getCreateDate() != null) {
/* 134 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 136 */     if (getCreateUserId() != null) {
/* 137 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 139 */     if (getUpdateDate() != null) {
/* 140 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 142 */     if (getUpdateUserId() != null) {
/* 143 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/*     */     
/* 146 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 150 */     PostalCodeMappingId id = new PostalCodeMappingId();
/* 151 */     id.setCity(getCity());
/* 152 */     id.setOrganizationId(getOrganizationId());
/* 153 */     id.setPostalCode(getPostalCode());
/* 154 */     id.setTaxLocationId(getTaxLocationId());
/* 155 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 159 */     setCity(((PostalCodeMappingId)argObjectId).getCity());
/* 160 */     setOrganizationId(((PostalCodeMappingId)argObjectId).getOrganizationId());
/* 161 */     setPostalCode(((PostalCodeMappingId)argObjectId).getPostalCode());
/* 162 */     setTaxLocationId(((PostalCodeMappingId)argObjectId).getTaxLocationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 166 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 170 */     StringBuilder buf = new StringBuilder(400);
/* 171 */     buf.append("<").append("dao").append(" name=\"PostalCodeMapping\" cmd=\"" + getObjectStateString() + "\">");
/* 172 */     getFieldsAsXml(buf);
/* 173 */     buf.append("</").append("dao").append(">");
/*     */     
/* 175 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 179 */     Map<String, String> values = super.getValues();
/* 180 */     if (this._city != null) values.put("City", DaoUtils.getXmlSafeFieldValue(12, this._city)); 
/* 181 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 182 */     if (this._postalCode != null) values.put("PostalCode", DaoUtils.getXmlSafeFieldValue(12, this._postalCode)); 
/* 183 */     if (this._taxLocationId != null) values.put("TaxLocationId", DaoUtils.getXmlSafeFieldValue(12, this._taxLocationId)); 
/* 184 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 185 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 186 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 187 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 188 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 193 */     super.setValues(argValues);
/* 194 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 196 */       String fieldName = field.getKey();
/* 197 */       String fieldValue = field.getValue();
/* 198 */       switch (fieldName) {
/*     */         
/*     */         case "City":
/*     */           try {
/* 202 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 203 */             setCity((String)value);
/* 204 */           } catch (Exception ee) {
/* 205 */             throw new DtxException("An exception occurred while calling setCity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 211 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 212 */             setOrganizationId((Long)value);
/* 213 */           } catch (Exception ee) {
/* 214 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PostalCode":
/*     */           try {
/* 220 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 221 */             setPostalCode((String)value);
/* 222 */           } catch (Exception ee) {
/* 223 */             throw new DtxException("An exception occurred while calling setPostalCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TaxLocationId":
/*     */           try {
/* 229 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 230 */             setTaxLocationId((String)value);
/* 231 */           } catch (Exception ee) {
/* 232 */             throw new DtxException("An exception occurred while calling setTaxLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 238 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 239 */             setCreateDate((Date)value);
/* 240 */           } catch (Exception ee) {
/* 241 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 247 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 248 */             setCreateUserId((String)value);
/* 249 */           } catch (Exception ee) {
/* 250 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 256 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 257 */             setUpdateDate((Date)value);
/* 258 */           } catch (Exception ee) {
/* 259 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 265 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 266 */             setUpdateUserId((String)value);
/* 267 */           } catch (Exception ee) {
/* 268 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tax\impl\PostalCodeMappingDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */