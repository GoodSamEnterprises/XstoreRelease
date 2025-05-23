/*     */ package dtv.xst.dao.crm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.crm.PartyEmailPropertyId;
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
/*     */ public class PartyEmailPropertyDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1818978411L;
/*  23 */   private static final Logger _logger = Logger.getLogger(PartyEmailPropertyDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _partyId;
/*     */   private Integer _sequence;
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
/*  39 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  43 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  44 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getPartyId() {
/*  49 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/*  53 */     if (changed(argPartyId, this._partyId, "partyId")) {
/*  54 */       this._partyId = argPartyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSequence() {
/*  59 */     return this._sequence;
/*     */   }
/*     */   
/*     */   public void setSequence(Integer argSequence) {
/*  63 */     if (changed(argSequence, this._sequence, "sequence")) {
/*  64 */       this._sequence = argSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  69 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  73 */     if (changed(argPropertyCode, this._propertyCode, "propertyCode")) {
/*  74 */       this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getType() {
/*  79 */     return this._type;
/*     */   }
/*     */   
/*     */   public void setType(String argType) {
/*  83 */     if (changed(argType, this._type, "type")) {
/*  84 */       this._type = argType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStringValue() {
/*  89 */     return this._stringValue;
/*     */   }
/*     */   
/*     */   public void setStringValue(String argStringValue) {
/*  93 */     if (changed(argStringValue, this._stringValue, "stringValue")) {
/*  94 */       this._stringValue = argStringValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getDateValue() {
/*  99 */     return (Date)this._dateValue;
/*     */   }
/*     */   
/*     */   public void setDateValue(Date argDateValue) {
/* 103 */     if (changed(argDateValue, this._dateValue, "dateValue")) {
/* 104 */       this._dateValue = (argDateValue == null || argDateValue instanceof DtvDate) ? (DtvDate)argDateValue : new DtvDate(argDateValue);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getDecimalValue() {
/* 110 */     return this._decimalValue;
/*     */   }
/*     */   
/*     */   public void setDecimalValue(BigDecimal argDecimalValue) {
/* 114 */     if (changed(argDecimalValue, this._decimalValue, "decimalValue")) {
/* 115 */       this._decimalValue = argDecimalValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 120 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 124 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 125 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 131 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 135 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 136 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 141 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 145 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 146 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 152 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 156 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 157 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 164 */     StringBuilder buf = new StringBuilder(512);
/* 165 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 166 */     if (getOrganizationId() != null) {
/* 167 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 169 */     if (getPartyId() != null) {
/* 170 */       buf.append("partyId").append("=").append(getPartyId()).append(" ");
/*     */     }
/* 172 */     if (getSequence() != null) {
/* 173 */       buf.append("sequence").append("=").append(getSequence()).append(" ");
/*     */     }
/* 175 */     if (getPropertyCode() != null) {
/* 176 */       buf.append("propertyCode").append("=").append(getPropertyCode()).append(" ");
/*     */     }
/* 178 */     if (getType() != null) {
/* 179 */       buf.append("type").append("=").append(getType()).append(" ");
/*     */     }
/* 181 */     if (getStringValue() != null) {
/* 182 */       buf.append("stringValue").append("=").append(getStringValue()).append(" ");
/*     */     }
/* 184 */     if (getDateValue() != null) {
/* 185 */       buf.append("dateValue").append("=").append(getDateValue()).append(" ");
/*     */     }
/* 187 */     if (getDecimalValue() != null) {
/* 188 */       buf.append("decimalValue").append("=").append(getDecimalValue()).append(" ");
/*     */     }
/* 190 */     if (getCreateDate() != null) {
/* 191 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 193 */     if (getCreateUserId() != null) {
/* 194 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 196 */     if (getUpdateDate() != null) {
/* 197 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 199 */     if (getUpdateUserId() != null) {
/* 200 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/*     */     
/* 203 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 207 */     PartyEmailPropertyId id = new PartyEmailPropertyId();
/* 208 */     id.setOrganizationId(getOrganizationId());
/* 209 */     id.setPartyId(getPartyId());
/* 210 */     id.setSequence(getSequence());
/* 211 */     id.setPropertyCode(getPropertyCode());
/* 212 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 216 */     setOrganizationId(((PartyEmailPropertyId)argObjectId).getOrganizationId());
/* 217 */     setPartyId(((PartyEmailPropertyId)argObjectId).getPartyId());
/* 218 */     setSequence(((PartyEmailPropertyId)argObjectId).getSequence());
/* 219 */     setPropertyCode(((PartyEmailPropertyId)argObjectId).getPropertyCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 223 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 227 */     StringBuilder buf = new StringBuilder(600);
/* 228 */     buf.append("<").append("dao").append(" name=\"PartyEmailProperty\" cmd=\"" + getObjectStateString() + "\">");
/* 229 */     getFieldsAsXml(buf);
/* 230 */     buf.append("</").append("dao").append(">");
/*     */     
/* 232 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 236 */     Map<String, String> values = super.getValues();
/* 237 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 238 */     if (this._partyId != null) values.put("PartyId", DaoUtils.getXmlSafeFieldValue(-5, this._partyId)); 
/* 239 */     if (this._sequence != null) values.put("Sequence", DaoUtils.getXmlSafeFieldValue(4, this._sequence)); 
/* 240 */     if (this._propertyCode != null) values.put("PropertyCode", DaoUtils.getXmlSafeFieldValue(12, this._propertyCode)); 
/* 241 */     if (this._type != null) values.put("Type", DaoUtils.getXmlSafeFieldValue(12, this._type)); 
/* 242 */     if (this._stringValue != null) values.put("StringValue", DaoUtils.getXmlSafeFieldValue(12, this._stringValue)); 
/* 243 */     if (this._dateValue != null) values.put("DateValue", DaoUtils.getXmlSafeFieldValue(91, this._dateValue)); 
/* 244 */     if (this._decimalValue != null) values.put("DecimalValue", DaoUtils.getXmlSafeFieldValue(3, this._decimalValue)); 
/* 245 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 246 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 247 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 248 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 249 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 254 */     super.setValues(argValues);
/* 255 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 257 */       String fieldName = field.getKey();
/* 258 */       String fieldValue = field.getValue();
/* 259 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 263 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 264 */             setOrganizationId((Long)value);
/* 265 */           } catch (Exception ee) {
/* 266 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PartyId":
/*     */           try {
/* 272 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 273 */             setPartyId((Long)value);
/* 274 */           } catch (Exception ee) {
/* 275 */             throw new DtxException("An exception occurred while calling setPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Sequence":
/*     */           try {
/* 281 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 282 */             setSequence((Integer)value);
/* 283 */           } catch (Exception ee) {
/* 284 */             throw new DtxException("An exception occurred while calling setSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PropertyCode":
/*     */           try {
/* 290 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 291 */             setPropertyCode((String)value);
/* 292 */           } catch (Exception ee) {
/* 293 */             throw new DtxException("An exception occurred while calling setPropertyCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Type":
/*     */           try {
/* 299 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 300 */             setType((String)value);
/* 301 */           } catch (Exception ee) {
/* 302 */             throw new DtxException("An exception occurred while calling setType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "StringValue":
/*     */           try {
/* 308 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 309 */             setStringValue((String)value);
/* 310 */           } catch (Exception ee) {
/* 311 */             throw new DtxException("An exception occurred while calling setStringValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DateValue":
/*     */           try {
/* 317 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 318 */             setDateValue((Date)value);
/* 319 */           } catch (Exception ee) {
/* 320 */             throw new DtxException("An exception occurred while calling setDateValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DecimalValue":
/*     */           try {
/* 326 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 327 */             setDecimalValue((BigDecimal)value);
/* 328 */           } catch (Exception ee) {
/* 329 */             throw new DtxException("An exception occurred while calling setDecimalValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 335 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 336 */             setCreateDate((Date)value);
/* 337 */           } catch (Exception ee) {
/* 338 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 344 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 345 */             setCreateUserId((String)value);
/* 346 */           } catch (Exception ee) {
/* 347 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 353 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 354 */             setUpdateDate((Date)value);
/* 355 */           } catch (Exception ee) {
/* 356 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 362 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 363 */             setUpdateUserId((String)value);
/* 364 */           } catch (Exception ee) {
/* 365 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\PartyEmailPropertyDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */