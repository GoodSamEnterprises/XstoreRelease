/*     */ package dtv.xst.dao.ctl.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.ctl.VersionPropertyId;
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
/*     */ public class VersionPropertyDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1930542765L;
/*  23 */   private static final Logger _logger = Logger.getLogger(VersionPropertyDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _propertyCode;
/*     */   private String _type;
/*     */   private String _stringValue;
/*     */   private DtvDate _dateValue;
/*     */   private BigDecimal _decimalValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
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
/*     */   public String getPropertyCode() {
/*  47 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  51 */     if (changed(argPropertyCode, this._propertyCode, "propertyCode")) {
/*  52 */       this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getType() {
/*  57 */     return this._type;
/*     */   }
/*     */   
/*     */   public void setType(String argType) {
/*  61 */     if (changed(argType, this._type, "type")) {
/*  62 */       this._type = argType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStringValue() {
/*  67 */     return this._stringValue;
/*     */   }
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/*  71 */     if (changed(argStringValue, this._stringValue, "stringValue")) {
/*  72 */       this._stringValue = argStringValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getDateValue() {
/*  77 */     return (Date)this._dateValue;
/*     */   }
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/*  81 */     if (changed(argDateValue, this._dateValue, "dateValue")) {
/*  82 */       this._dateValue = (argDateValue == null || argDateValue instanceof DtvDate) ? (DtvDate)argDateValue : new DtvDate(argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/*  88 */     return this._decimalValue;
/*     */   }
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/*  92 */     if (changed(argDecimalValue, this._decimalValue, "decimalValue")) {
/*  93 */       this._decimalValue = argDecimalValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  98 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 102 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 103 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 109 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 113 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 114 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 119 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 123 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 124 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 130 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 134 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 135 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 142 */     StringBuilder buf = new StringBuilder(512);
/* 143 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 144 */     if (getOrganizationId() != null) {
/* 145 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 147 */     if (getPropertyCode() != null) {
/* 148 */       buf.append("propertyCode").append("=").append(getPropertyCode()).append(" ");
/*     */     }
/* 150 */     if (getType() != null) {
/* 151 */       buf.append("type").append("=").append(getType()).append(" ");
/*     */     }
/* 153 */     if (getStringValue() != null) {
/* 154 */       buf.append("stringValue").append("=").append(getStringValue()).append(" ");
/*     */     }
/* 156 */     if (getDateValue() != null) {
/* 157 */       buf.append("dateValue").append("=").append(getDateValue()).append(" ");
/*     */     }
/* 159 */     if (getDecimalValue() != null) {
/* 160 */       buf.append("decimalValue").append("=").append(getDecimalValue()).append(" ");
/*     */     }
/* 162 */     if (getCreateDate() != null) {
/* 163 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 165 */     if (getCreateUserId() != null) {
/* 166 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 168 */     if (getUpdateDate() != null) {
/* 169 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 171 */     if (getUpdateUserId() != null) {
/* 172 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/*     */     
/* 175 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 179 */     VersionPropertyId id = new VersionPropertyId();
/* 180 */     id.setOrganizationId(getOrganizationId());
/* 181 */     id.setPropertyCode(getPropertyCode());
/* 182 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 186 */     setOrganizationId(((VersionPropertyId)argObjectId).getOrganizationId());
/* 187 */     setPropertyCode(((VersionPropertyId)argObjectId).getPropertyCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 191 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 195 */     StringBuilder buf = new StringBuilder(500);
/* 196 */     buf.append("<").append("dao").append(" name=\"VersionProperty\" cmd=\"" + getObjectStateString() + "\">");
/* 197 */     getFieldsAsXml(buf);
/* 198 */     buf.append("</").append("dao").append(">");
/*     */     
/* 200 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 204 */     Map<String, String> values = super.getValues();
/* 205 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 206 */     if (this._propertyCode != null) values.put("PropertyCode", DaoUtils.getXmlSafeFieldValue(12, this._propertyCode)); 
/* 207 */     if (this._type != null) values.put("Type", DaoUtils.getXmlSafeFieldValue(12, this._type)); 
/* 208 */     if (this._stringValue != null) values.put("StringValue", DaoUtils.getXmlSafeFieldValue(12, this._stringValue)); 
/* 209 */     if (this._dateValue != null) values.put("DateValue", DaoUtils.getXmlSafeFieldValue(91, this._dateValue)); 
/* 210 */     if (this._decimalValue != null) values.put("DecimalValue", DaoUtils.getXmlSafeFieldValue(3, this._decimalValue)); 
/* 211 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 212 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 213 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 214 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 215 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 220 */     super.setValues(argValues);
/* 221 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 223 */       String fieldName = field.getKey();
/* 224 */       String fieldValue = field.getValue();
/* 225 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 229 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 230 */             setOrganizationId((Long)value);
/* 231 */           } catch (Exception ee) {
/* 232 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PropertyCode":
/*     */           try {
/* 238 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 239 */             setPropertyCode((String)value);
/* 240 */           } catch (Exception ee) {
/* 241 */             throw new DtxException("An exception occurred while calling setPropertyCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Type":
/*     */           try {
/* 247 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 248 */             setType((String)value);
/* 249 */           } catch (Exception ee) {
/* 250 */             throw new DtxException("An exception occurred while calling setType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StringValue":
/*     */           try {
/* 256 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 257 */             setStringValue((String)value);
/* 258 */           } catch (Exception ee) {
/* 259 */             throw new DtxException("An exception occurred while calling setStringValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DateValue":
/*     */           try {
/* 265 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 266 */             setDateValue((Date)value);
/* 267 */           } catch (Exception ee) {
/* 268 */             throw new DtxException("An exception occurred while calling setDateValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DecimalValue":
/*     */           try {
/* 274 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 275 */             setDecimalValue((BigDecimal)value);
/* 276 */           } catch (Exception ee) {
/* 277 */             throw new DtxException("An exception occurred while calling setDecimalValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 283 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 284 */             setCreateDate((Date)value);
/* 285 */           } catch (Exception ee) {
/* 286 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 292 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 293 */             setCreateUserId((String)value);
/* 294 */           } catch (Exception ee) {
/* 295 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 301 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 302 */             setUpdateDate((Date)value);
/* 303 */           } catch (Exception ee) {
/* 304 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 310 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 311 */             setUpdateUserId((String)value);
/* 312 */           } catch (Exception ee) {
/* 313 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\impl\VersionPropertyDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */