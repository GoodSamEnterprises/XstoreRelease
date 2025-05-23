/*     */ package dtv.xst.dao.crm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.crm.PartyEmailId;
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
/*     */ public class PartyEmailDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1846281098L;
/*  23 */   private static final Logger _logger = Logger.getLogger(PartyEmailDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _partyId;
/*     */   private Integer _sequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _emailAddress;
/*     */   private String _emailType;
/*     */   private String _emailFormat;
/*  35 */   private Boolean _contact = Boolean.FALSE;
/*  36 */   private Boolean _primary = Boolean.FALSE;
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
/*     */   public Date getCreateDate() {
/*  69 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  73 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  74 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  80 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  84 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  85 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  90 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  94 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  95 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 101 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 105 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 106 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getEmailAddress() {
/* 111 */     return this._emailAddress;
/*     */   }
/*     */   
/*     */   public void setEmailAddress(String argEmailAddress) {
/* 115 */     if (changed(argEmailAddress, this._emailAddress, "emailAddress")) {
/* 116 */       this._emailAddress = argEmailAddress;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getEmailType() {
/* 121 */     return this._emailType;
/*     */   }
/*     */   
/*     */   public void setEmailType(String argEmailType) {
/* 125 */     if (changed(argEmailType, this._emailType, "emailType")) {
/* 126 */       this._emailType = argEmailType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getEmailFormat() {
/* 131 */     return this._emailFormat;
/*     */   }
/*     */   
/*     */   public void setEmailFormat(String argEmailFormat) {
/* 135 */     if (changed(argEmailFormat, this._emailFormat, "emailFormat")) {
/* 136 */       this._emailFormat = argEmailFormat;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getContact() {
/* 141 */     return this._contact;
/*     */   }
/*     */   
/*     */   public void setContact(Boolean argContact) {
/* 145 */     if (changed(argContact, this._contact, "contact")) {
/* 146 */       this._contact = argContact;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getPrimary() {
/* 151 */     return this._primary;
/*     */   }
/*     */   
/*     */   public void setPrimary(Boolean argPrimary) {
/* 155 */     if (changed(argPrimary, this._primary, "primary")) {
/* 156 */       this._primary = argPrimary;
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
/* 168 */     if (getPartyId() != null) {
/* 169 */       buf.append("partyId").append("=").append(getPartyId()).append(" ");
/*     */     }
/* 171 */     if (getSequence() != null) {
/* 172 */       buf.append("sequence").append("=").append(getSequence()).append(" ");
/*     */     }
/* 174 */     if (getCreateDate() != null) {
/* 175 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 177 */     if (getCreateUserId() != null) {
/* 178 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 180 */     if (getUpdateDate() != null) {
/* 181 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 183 */     if (getUpdateUserId() != null) {
/* 184 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 186 */     if (getEmailAddress() != null) {
/* 187 */       buf.append("emailAddress").append("=").append(getEmailAddress()).append(" ");
/*     */     }
/* 189 */     if (getEmailType() != null) {
/* 190 */       buf.append("emailType").append("=").append(getEmailType()).append(" ");
/*     */     }
/* 192 */     if (getEmailFormat() != null) {
/* 193 */       buf.append("emailFormat").append("=").append(getEmailFormat()).append(" ");
/*     */     }
/* 195 */     if (getContact() != null && getContact().booleanValue()) {
/* 196 */       buf.append("contact").append("=").append(getContact()).append(" ");
/*     */     }
/* 198 */     if (getPrimary() != null && getPrimary().booleanValue()) {
/* 199 */       buf.append("primary").append("=").append(getPrimary()).append(" ");
/*     */     }
/*     */     
/* 202 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 206 */     PartyEmailId id = new PartyEmailId();
/* 207 */     id.setOrganizationId(getOrganizationId());
/* 208 */     id.setPartyId(getPartyId());
/* 209 */     id.setSequence(getSequence());
/* 210 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 214 */     setOrganizationId(((PartyEmailId)argObjectId).getOrganizationId());
/* 215 */     setPartyId(((PartyEmailId)argObjectId).getPartyId());
/* 216 */     setSequence(((PartyEmailId)argObjectId).getSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 220 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 224 */     StringBuilder buf = new StringBuilder(600);
/* 225 */     buf.append("<").append("dao").append(" name=\"PartyEmail\" cmd=\"" + getObjectStateString() + "\">");
/* 226 */     getFieldsAsXml(buf);
/* 227 */     buf.append("</").append("dao").append(">");
/*     */     
/* 229 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 233 */     Map<String, String> values = super.getValues();
/* 234 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 235 */     if (this._partyId != null) values.put("PartyId", DaoUtils.getXmlSafeFieldValue(-5, this._partyId)); 
/* 236 */     if (this._sequence != null) values.put("Sequence", DaoUtils.getXmlSafeFieldValue(4, this._sequence)); 
/* 237 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 238 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 239 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 240 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 241 */     if (this._emailAddress != null) values.put("EmailAddress", DaoUtils.getXmlSafeFieldValue(12, this._emailAddress)); 
/* 242 */     if (this._emailType != null) values.put("EmailType", DaoUtils.getXmlSafeFieldValue(12, this._emailType)); 
/* 243 */     if (this._emailFormat != null) values.put("EmailFormat", DaoUtils.getXmlSafeFieldValue(12, this._emailFormat)); 
/* 244 */     if (this._contact != null) values.put("Contact", DaoUtils.getXmlSafeFieldValue(-7, this._contact)); 
/* 245 */     if (this._primary != null) values.put("Primary", DaoUtils.getXmlSafeFieldValue(-7, this._primary)); 
/* 246 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 251 */     super.setValues(argValues);
/* 252 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 254 */       String fieldName = field.getKey();
/* 255 */       String fieldValue = field.getValue();
/* 256 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 260 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 261 */             setOrganizationId((Long)value);
/* 262 */           } catch (Exception ee) {
/* 263 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PartyId":
/*     */           try {
/* 269 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 270 */             setPartyId((Long)value);
/* 271 */           } catch (Exception ee) {
/* 272 */             throw new DtxException("An exception occurred while calling setPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Sequence":
/*     */           try {
/* 278 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 279 */             setSequence((Integer)value);
/* 280 */           } catch (Exception ee) {
/* 281 */             throw new DtxException("An exception occurred while calling setSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 287 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 288 */             setCreateDate((Date)value);
/* 289 */           } catch (Exception ee) {
/* 290 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 296 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 297 */             setCreateUserId((String)value);
/* 298 */           } catch (Exception ee) {
/* 299 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 305 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 306 */             setUpdateDate((Date)value);
/* 307 */           } catch (Exception ee) {
/* 308 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 314 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 315 */             setUpdateUserId((String)value);
/* 316 */           } catch (Exception ee) {
/* 317 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EmailAddress":
/*     */           try {
/* 323 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 324 */             setEmailAddress((String)value);
/* 325 */           } catch (Exception ee) {
/* 326 */             throw new DtxException("An exception occurred while calling setEmailAddress() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EmailType":
/*     */           try {
/* 332 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 333 */             setEmailType((String)value);
/* 334 */           } catch (Exception ee) {
/* 335 */             throw new DtxException("An exception occurred while calling setEmailType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EmailFormat":
/*     */           try {
/* 341 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 342 */             setEmailFormat((String)value);
/* 343 */           } catch (Exception ee) {
/* 344 */             throw new DtxException("An exception occurred while calling setEmailFormat() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Contact":
/*     */           try {
/* 350 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 351 */             setContact((Boolean)value);
/* 352 */           } catch (Exception ee) {
/* 353 */             throw new DtxException("An exception occurred while calling setContact() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Primary":
/*     */           try {
/* 359 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 360 */             setPrimary((Boolean)value);
/* 361 */           } catch (Exception ee) {
/* 362 */             throw new DtxException("An exception occurred while calling setPrimary() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\PartyEmailDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */