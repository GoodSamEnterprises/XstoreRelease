/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.CustomerLoyaltyCardId;
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
/*     */ public class CustomerLoyaltyCardDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1934498200L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CustomerLoyaltyCardDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _cardNumber;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private Long _partyId;
/*     */   private DtvDate _effectiveDate;
/*     */   private DtvDate _expirationDate;
/*     */   
/*     */   public Long getOrganizationId() {
/*  36 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  40 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  41 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCardNumber() {
/*  46 */     return this._cardNumber;
/*     */   }
/*     */   
/*     */   public void setCardNumber(String argCardNumber) {
/*  50 */     if (changed(argCardNumber, this._cardNumber, "cardNumber")) {
/*  51 */       this._cardNumber = (argCardNumber != null && MANAGE_CASE) ? argCardNumber.toUpperCase() : argCardNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  56 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  60 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  61 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  67 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  71 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  72 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  77 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  81 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  82 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  88 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  92 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  93 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getPartyId() {
/*  98 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/* 102 */     if (changed(argPartyId, this._partyId, "partyId")) {
/* 103 */       this._partyId = argPartyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/* 108 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/* 112 */     if (changed(argEffectiveDate, this._effectiveDate, "effectiveDate")) {
/* 113 */       this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getExpirationDate() {
/* 119 */     return (Date)this._expirationDate;
/*     */   }
/*     */   
/*     */   public void setExpirationDate(Date argExpirationDate) {
/* 123 */     if (changed(argExpirationDate, this._expirationDate, "expirationDate")) {
/* 124 */       this._expirationDate = (argExpirationDate == null || argExpirationDate instanceof DtvDate) ? (DtvDate)argExpirationDate : new DtvDate(argExpirationDate);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 132 */     StringBuilder buf = new StringBuilder(512);
/* 133 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 134 */     if (getOrganizationId() != null) {
/* 135 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 137 */     if (getCardNumber() != null) {
/* 138 */       buf.append("cardNumber").append("=").append(getCardNumber()).append(" ");
/*     */     }
/* 140 */     if (getCreateDate() != null) {
/* 141 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 143 */     if (getCreateUserId() != null) {
/* 144 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 146 */     if (getUpdateDate() != null) {
/* 147 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 149 */     if (getUpdateUserId() != null) {
/* 150 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 152 */     if (getPartyId() != null) {
/* 153 */       buf.append("partyId").append("=").append(getPartyId()).append(" ");
/*     */     }
/* 155 */     if (getEffectiveDate() != null) {
/* 156 */       buf.append("effectiveDate").append("=").append(getEffectiveDate()).append(" ");
/*     */     }
/* 158 */     if (getExpirationDate() != null) {
/* 159 */       buf.append("expirationDate").append("=").append(getExpirationDate()).append(" ");
/*     */     }
/*     */     
/* 162 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 166 */     CustomerLoyaltyCardId id = new CustomerLoyaltyCardId();
/* 167 */     id.setOrganizationId(getOrganizationId());
/* 168 */     id.setCardNumber(getCardNumber());
/* 169 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 173 */     setOrganizationId(((CustomerLoyaltyCardId)argObjectId).getOrganizationId());
/* 174 */     setCardNumber(((CustomerLoyaltyCardId)argObjectId).getCardNumber());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 178 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 182 */     StringBuilder buf = new StringBuilder(450);
/* 183 */     buf.append("<").append("dao").append(" name=\"CustomerLoyaltyCard\" cmd=\"" + getObjectStateString() + "\">");
/* 184 */     getFieldsAsXml(buf);
/* 185 */     buf.append("</").append("dao").append(">");
/*     */     
/* 187 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 191 */     Map<String, String> values = super.getValues();
/* 192 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 193 */     if (this._cardNumber != null) values.put("CardNumber", DaoUtils.getXmlSafeFieldValue(12, this._cardNumber)); 
/* 194 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 195 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 196 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 197 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 198 */     if (this._partyId != null) values.put("PartyId", DaoUtils.getXmlSafeFieldValue(-5, this._partyId)); 
/* 199 */     if (this._effectiveDate != null) values.put("EffectiveDate", DaoUtils.getXmlSafeFieldValue(91, this._effectiveDate)); 
/* 200 */     if (this._expirationDate != null) values.put("ExpirationDate", DaoUtils.getXmlSafeFieldValue(91, this._expirationDate)); 
/* 201 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 206 */     super.setValues(argValues);
/* 207 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 209 */       String fieldName = field.getKey();
/* 210 */       String fieldValue = field.getValue();
/* 211 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 215 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 216 */             setOrganizationId((Long)value);
/* 217 */           } catch (Exception ee) {
/* 218 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CardNumber":
/*     */           try {
/* 224 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 225 */             setCardNumber((String)value);
/* 226 */           } catch (Exception ee) {
/* 227 */             throw new DtxException("An exception occurred while calling setCardNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 233 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 234 */             setCreateDate((Date)value);
/* 235 */           } catch (Exception ee) {
/* 236 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 242 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 243 */             setCreateUserId((String)value);
/* 244 */           } catch (Exception ee) {
/* 245 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 251 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 252 */             setUpdateDate((Date)value);
/* 253 */           } catch (Exception ee) {
/* 254 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 260 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 261 */             setUpdateUserId((String)value);
/* 262 */           } catch (Exception ee) {
/* 263 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
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
/*     */         case "EffectiveDate":
/*     */           try {
/* 278 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 279 */             setEffectiveDate((Date)value);
/* 280 */           } catch (Exception ee) {
/* 281 */             throw new DtxException("An exception occurred while calling setEffectiveDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ExpirationDate":
/*     */           try {
/* 287 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 288 */             setExpirationDate((Date)value);
/* 289 */           } catch (Exception ee) {
/* 290 */             throw new DtxException("An exception occurred while calling setExpirationDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerLoyaltyCardDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */