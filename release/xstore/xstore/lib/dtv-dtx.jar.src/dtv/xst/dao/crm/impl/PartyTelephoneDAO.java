/*     */ package dtv.xst.dao.crm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.crm.PartyTelephoneId;
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
/*     */ public class PartyTelephoneDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -158832674L;
/*  23 */   private static final Logger _logger = Logger.getLogger(PartyTelephoneDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _partyId;
/*     */   private String _telephoneType;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _contactType;
/*  33 */   private Boolean _contact = Boolean.FALSE;
/*  34 */   private Boolean _primary = Boolean.FALSE;
/*     */   private String _telephoneNumber;
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
/*     */   public Long getPartyId() {
/*  48 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/*  52 */     if (changed(argPartyId, this._partyId, "partyId")) {
/*  53 */       this._partyId = argPartyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTelephoneType() {
/*  58 */     return this._telephoneType;
/*     */   }
/*     */   
/*     */   public void setTelephoneType(String argTelephoneType) {
/*  62 */     if (changed(argTelephoneType, this._telephoneType, "telephoneType")) {
/*  63 */       this._telephoneType = (argTelephoneType != null && MANAGE_CASE) ? argTelephoneType.toUpperCase() : argTelephoneType;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  68 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  72 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  73 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  79 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  83 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  84 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  89 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  93 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  94 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 100 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 104 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 105 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getContactType() {
/* 110 */     return this._contactType;
/*     */   }
/*     */   
/*     */   public void setContactType(String argContactType) {
/* 114 */     if (changed(argContactType, this._contactType, "contactType")) {
/* 115 */       this._contactType = argContactType;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getContact() {
/* 120 */     return this._contact;
/*     */   }
/*     */   
/*     */   public void setContact(Boolean argContact) {
/* 124 */     if (changed(argContact, this._contact, "contact")) {
/* 125 */       this._contact = argContact;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getPrimary() {
/* 130 */     return this._primary;
/*     */   }
/*     */   
/*     */   public void setPrimary(Boolean argPrimary) {
/* 134 */     if (changed(argPrimary, this._primary, "primary")) {
/* 135 */       this._primary = argPrimary;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTelephoneNumber() {
/* 140 */     return this._telephoneNumber;
/*     */   }
/*     */   
/*     */   public void setTelephoneNumber(String argTelephoneNumber) {
/* 144 */     if (changed(argTelephoneNumber, this._telephoneNumber, "telephoneNumber")) {
/* 145 */       this._telephoneNumber = argTelephoneNumber;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 152 */     StringBuilder buf = new StringBuilder(512);
/* 153 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 154 */     if (getOrganizationId() != null) {
/* 155 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 157 */     if (getPartyId() != null) {
/* 158 */       buf.append("partyId").append("=").append(getPartyId()).append(" ");
/*     */     }
/* 160 */     if (getTelephoneType() != null) {
/* 161 */       buf.append("telephoneType").append("=").append(getTelephoneType()).append(" ");
/*     */     }
/* 163 */     if (getCreateDate() != null) {
/* 164 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 166 */     if (getCreateUserId() != null) {
/* 167 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 169 */     if (getUpdateDate() != null) {
/* 170 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 172 */     if (getUpdateUserId() != null) {
/* 173 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 175 */     if (getContactType() != null) {
/* 176 */       buf.append("contactType").append("=").append(getContactType()).append(" ");
/*     */     }
/* 178 */     if (getContact() != null && getContact().booleanValue()) {
/* 179 */       buf.append("contact").append("=").append(getContact()).append(" ");
/*     */     }
/* 181 */     if (getPrimary() != null && getPrimary().booleanValue()) {
/* 182 */       buf.append("primary").append("=").append(getPrimary()).append(" ");
/*     */     }
/* 184 */     if (getTelephoneNumber() != null) {
/* 185 */       buf.append("telephoneNumber").append("=").append(getTelephoneNumber()).append(" ");
/*     */     }
/*     */     
/* 188 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 192 */     PartyTelephoneId id = new PartyTelephoneId();
/* 193 */     id.setOrganizationId(getOrganizationId());
/* 194 */     id.setPartyId(getPartyId());
/* 195 */     id.setTelephoneType(getTelephoneType());
/* 196 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 200 */     setOrganizationId(((PartyTelephoneId)argObjectId).getOrganizationId());
/* 201 */     setPartyId(((PartyTelephoneId)argObjectId).getPartyId());
/* 202 */     setTelephoneType(((PartyTelephoneId)argObjectId).getTelephoneType());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 206 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 210 */     StringBuilder buf = new StringBuilder(550);
/* 211 */     buf.append("<").append("dao").append(" name=\"PartyTelephone\" cmd=\"" + getObjectStateString() + "\">");
/* 212 */     getFieldsAsXml(buf);
/* 213 */     buf.append("</").append("dao").append(">");
/*     */     
/* 215 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 219 */     Map<String, String> values = super.getValues();
/* 220 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 221 */     if (this._partyId != null) values.put("PartyId", DaoUtils.getXmlSafeFieldValue(-5, this._partyId)); 
/* 222 */     if (this._telephoneType != null) values.put("TelephoneType", DaoUtils.getXmlSafeFieldValue(12, this._telephoneType)); 
/* 223 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 224 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 225 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 226 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 227 */     if (this._contactType != null) values.put("ContactType", DaoUtils.getXmlSafeFieldValue(12, this._contactType)); 
/* 228 */     if (this._contact != null) values.put("Contact", DaoUtils.getXmlSafeFieldValue(-7, this._contact)); 
/* 229 */     if (this._primary != null) values.put("Primary", DaoUtils.getXmlSafeFieldValue(-7, this._primary)); 
/* 230 */     if (this._telephoneNumber != null) values.put("TelephoneNumber", DaoUtils.getXmlSafeFieldValue(12, this._telephoneNumber)); 
/* 231 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 236 */     super.setValues(argValues);
/* 237 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 239 */       String fieldName = field.getKey();
/* 240 */       String fieldValue = field.getValue();
/* 241 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 245 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 246 */             setOrganizationId((Long)value);
/* 247 */           } catch (Exception ee) {
/* 248 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PartyId":
/*     */           try {
/* 254 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 255 */             setPartyId((Long)value);
/* 256 */           } catch (Exception ee) {
/* 257 */             throw new DtxException("An exception occurred while calling setPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TelephoneType":
/*     */           try {
/* 263 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 264 */             setTelephoneType((String)value);
/* 265 */           } catch (Exception ee) {
/* 266 */             throw new DtxException("An exception occurred while calling setTelephoneType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 272 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 273 */             setCreateDate((Date)value);
/* 274 */           } catch (Exception ee) {
/* 275 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 281 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 282 */             setCreateUserId((String)value);
/* 283 */           } catch (Exception ee) {
/* 284 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 290 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 291 */             setUpdateDate((Date)value);
/* 292 */           } catch (Exception ee) {
/* 293 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 299 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 300 */             setUpdateUserId((String)value);
/* 301 */           } catch (Exception ee) {
/* 302 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ContactType":
/*     */           try {
/* 308 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 309 */             setContactType((String)value);
/* 310 */           } catch (Exception ee) {
/* 311 */             throw new DtxException("An exception occurred while calling setContactType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Contact":
/*     */           try {
/* 317 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 318 */             setContact((Boolean)value);
/* 319 */           } catch (Exception ee) {
/* 320 */             throw new DtxException("An exception occurred while calling setContact() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Primary":
/*     */           try {
/* 326 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 327 */             setPrimary((Boolean)value);
/* 328 */           } catch (Exception ee) {
/* 329 */             throw new DtxException("An exception occurred while calling setPrimary() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TelephoneNumber":
/*     */           try {
/* 335 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 336 */             setTelephoneNumber((String)value);
/* 337 */           } catch (Exception ee) {
/* 338 */             throw new DtxException("An exception occurred while calling setTelephoneNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\PartyTelephoneDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */