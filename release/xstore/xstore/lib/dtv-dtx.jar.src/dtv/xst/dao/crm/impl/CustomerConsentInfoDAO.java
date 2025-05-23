/*     */ package dtv.xst.dao.crm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.crm.CustomerConsentInfoId;
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
/*     */ public class CustomerConsentInfoDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1453591286L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CustomerConsentInfoDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private DtvDate _effectiveDate;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _termsAndConditions;
/*     */   private String _consent1Text;
/*     */   private String _consent2Text;
/*     */   private String _consent3Text;
/*     */   private String _consent4Text;
/*     */   private String _consent5Text;
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
/*     */   public Date getEffectiveDate() {
/*  49 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/*  53 */     if (changed(argEffectiveDate, this._effectiveDate, "effectiveDate")) {
/*  54 */       this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getCreateDate() {
/*  60 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  64 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  65 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  71 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  75 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  76 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  81 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  85 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  86 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  92 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  96 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  97 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTermsAndConditions() {
/* 102 */     return this._termsAndConditions;
/*     */   }
/*     */   
/*     */   public void setTermsAndConditions(String argTermsAndConditions) {
/* 106 */     if (changed(argTermsAndConditions, this._termsAndConditions, "termsAndConditions")) {
/* 107 */       this._termsAndConditions = argTermsAndConditions;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getConsent1Text() {
/* 112 */     return this._consent1Text;
/*     */   }
/*     */   
/*     */   public void setConsent1Text(String argConsent1Text) {
/* 116 */     if (changed(argConsent1Text, this._consent1Text, "consent1Text")) {
/* 117 */       this._consent1Text = argConsent1Text;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getConsent2Text() {
/* 122 */     return this._consent2Text;
/*     */   }
/*     */   
/*     */   public void setConsent2Text(String argConsent2Text) {
/* 126 */     if (changed(argConsent2Text, this._consent2Text, "consent2Text")) {
/* 127 */       this._consent2Text = argConsent2Text;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getConsent3Text() {
/* 132 */     return this._consent3Text;
/*     */   }
/*     */   
/*     */   public void setConsent3Text(String argConsent3Text) {
/* 136 */     if (changed(argConsent3Text, this._consent3Text, "consent3Text")) {
/* 137 */       this._consent3Text = argConsent3Text;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getConsent4Text() {
/* 142 */     return this._consent4Text;
/*     */   }
/*     */   
/*     */   public void setConsent4Text(String argConsent4Text) {
/* 146 */     if (changed(argConsent4Text, this._consent4Text, "consent4Text")) {
/* 147 */       this._consent4Text = argConsent4Text;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getConsent5Text() {
/* 152 */     return this._consent5Text;
/*     */   }
/*     */   
/*     */   public void setConsent5Text(String argConsent5Text) {
/* 156 */     if (changed(argConsent5Text, this._consent5Text, "consent5Text")) {
/* 157 */       this._consent5Text = argConsent5Text;
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
/* 169 */     if (getEffectiveDate() != null) {
/* 170 */       buf.append("effectiveDate").append("=").append(getEffectiveDate()).append(" ");
/*     */     }
/* 172 */     if (getCreateDate() != null) {
/* 173 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 175 */     if (getCreateUserId() != null) {
/* 176 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 178 */     if (getUpdateDate() != null) {
/* 179 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 181 */     if (getUpdateUserId() != null) {
/* 182 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 184 */     if (getTermsAndConditions() != null) {
/* 185 */       buf.append("termsAndConditions").append("=").append(getTermsAndConditions()).append(" ");
/*     */     }
/* 187 */     if (getConsent1Text() != null) {
/* 188 */       buf.append("consent1Text").append("=").append(getConsent1Text()).append(" ");
/*     */     }
/* 190 */     if (getConsent2Text() != null) {
/* 191 */       buf.append("consent2Text").append("=").append(getConsent2Text()).append(" ");
/*     */     }
/* 193 */     if (getConsent3Text() != null) {
/* 194 */       buf.append("consent3Text").append("=").append(getConsent3Text()).append(" ");
/*     */     }
/* 196 */     if (getConsent4Text() != null) {
/* 197 */       buf.append("consent4Text").append("=").append(getConsent4Text()).append(" ");
/*     */     }
/* 199 */     if (getConsent5Text() != null) {
/* 200 */       buf.append("consent5Text").append("=").append(getConsent5Text()).append(" ");
/*     */     }
/*     */     
/* 203 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 207 */     CustomerConsentInfoId id = new CustomerConsentInfoId();
/* 208 */     id.setOrganizationId(getOrganizationId());
/* 209 */     id.setEffectiveDate(getEffectiveDate());
/* 210 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 214 */     setOrganizationId(((CustomerConsentInfoId)argObjectId).getOrganizationId());
/* 215 */     setEffectiveDate(((CustomerConsentInfoId)argObjectId).getEffectiveDate());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 219 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 223 */     StringBuilder buf = new StringBuilder(600);
/* 224 */     buf.append("<").append("dao").append(" name=\"CustomerConsentInfo\" cmd=\"" + getObjectStateString() + "\">");
/* 225 */     getFieldsAsXml(buf);
/* 226 */     buf.append("</").append("dao").append(">");
/*     */     
/* 228 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 232 */     Map<String, String> values = super.getValues();
/* 233 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 234 */     if (this._effectiveDate != null) values.put("EffectiveDate", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDate)); 
/* 235 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 236 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 237 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 238 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 239 */     if (this._termsAndConditions != null) values.put("TermsAndConditions", DaoUtils.getXmlSafeFieldValue(12, this._termsAndConditions)); 
/* 240 */     if (this._consent1Text != null) values.put("Consent1Text", DaoUtils.getXmlSafeFieldValue(12, this._consent1Text)); 
/* 241 */     if (this._consent2Text != null) values.put("Consent2Text", DaoUtils.getXmlSafeFieldValue(12, this._consent2Text)); 
/* 242 */     if (this._consent3Text != null) values.put("Consent3Text", DaoUtils.getXmlSafeFieldValue(12, this._consent3Text)); 
/* 243 */     if (this._consent4Text != null) values.put("Consent4Text", DaoUtils.getXmlSafeFieldValue(12, this._consent4Text)); 
/* 244 */     if (this._consent5Text != null) values.put("Consent5Text", DaoUtils.getXmlSafeFieldValue(12, this._consent5Text)); 
/* 245 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 250 */     super.setValues(argValues);
/* 251 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 253 */       String fieldName = field.getKey();
/* 254 */       String fieldValue = field.getValue();
/* 255 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 259 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 260 */             setOrganizationId((Long)value);
/* 261 */           } catch (Exception ee) {
/* 262 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EffectiveDate":
/*     */           try {
/* 268 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 269 */             setEffectiveDate((Date)value);
/* 270 */           } catch (Exception ee) {
/* 271 */             throw new DtxException("An exception occurred while calling setEffectiveDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 277 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 278 */             setCreateDate((Date)value);
/* 279 */           } catch (Exception ee) {
/* 280 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 286 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 287 */             setCreateUserId((String)value);
/* 288 */           } catch (Exception ee) {
/* 289 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 295 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 296 */             setUpdateDate((Date)value);
/* 297 */           } catch (Exception ee) {
/* 298 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 304 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 305 */             setUpdateUserId((String)value);
/* 306 */           } catch (Exception ee) {
/* 307 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TermsAndConditions":
/*     */           try {
/* 313 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 314 */             setTermsAndConditions((String)value);
/* 315 */           } catch (Exception ee) {
/* 316 */             throw new DtxException("An exception occurred while calling setTermsAndConditions() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Consent1Text":
/*     */           try {
/* 322 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 323 */             setConsent1Text((String)value);
/* 324 */           } catch (Exception ee) {
/* 325 */             throw new DtxException("An exception occurred while calling setConsent1Text() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Consent2Text":
/*     */           try {
/* 331 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 332 */             setConsent2Text((String)value);
/* 333 */           } catch (Exception ee) {
/* 334 */             throw new DtxException("An exception occurred while calling setConsent2Text() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Consent3Text":
/*     */           try {
/* 340 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 341 */             setConsent3Text((String)value);
/* 342 */           } catch (Exception ee) {
/* 343 */             throw new DtxException("An exception occurred while calling setConsent3Text() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Consent4Text":
/*     */           try {
/* 349 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 350 */             setConsent4Text((String)value);
/* 351 */           } catch (Exception ee) {
/* 352 */             throw new DtxException("An exception occurred while calling setConsent4Text() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Consent5Text":
/*     */           try {
/* 358 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 359 */             setConsent5Text((String)value);
/* 360 */           } catch (Exception ee) {
/* 361 */             throw new DtxException("An exception occurred while calling setConsent5Text() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\crm\impl\CustomerConsentInfoDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */