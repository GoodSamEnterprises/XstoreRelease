/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.AwardAccountId;
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
/*     */ public class AwardAccountDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1907951920L;
/*  23 */   private static final Logger _logger = Logger.getLogger(AwardAccountDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _cardNumber;
/*     */   private String _accountId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   
/*     */   public Long getOrganizationId() {
/*  34 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  38 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  39 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCardNumber() {
/*  44 */     return this._cardNumber;
/*     */   }
/*     */   
/*     */   public void setCardNumber(String argCardNumber) {
/*  48 */     if (changed(argCardNumber, this._cardNumber, "cardNumber")) {
/*  49 */       this._cardNumber = (argCardNumber != null && MANAGE_CASE) ? argCardNumber.toUpperCase() : argCardNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAccountId() {
/*  54 */     return this._accountId;
/*     */   }
/*     */   
/*     */   public void setAccountId(String argAccountId) {
/*  58 */     if (changed(argAccountId, this._accountId, "accountId")) {
/*  59 */       this._accountId = (argAccountId != null && MANAGE_CASE) ? argAccountId.toUpperCase() : argAccountId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  64 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  68 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  69 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  75 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  79 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  80 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  85 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  89 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  90 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  96 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 100 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 101 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 108 */     StringBuilder buf = new StringBuilder(512);
/* 109 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 110 */     if (getOrganizationId() != null) {
/* 111 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 113 */     if (getCardNumber() != null) {
/* 114 */       buf.append("cardNumber").append("=").append(getCardNumber()).append(" ");
/*     */     }
/* 116 */     if (getAccountId() != null) {
/* 117 */       buf.append("accountId").append("=").append(getAccountId()).append(" ");
/*     */     }
/* 119 */     if (getCreateDate() != null) {
/* 120 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 122 */     if (getCreateUserId() != null) {
/* 123 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 125 */     if (getUpdateDate() != null) {
/* 126 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 128 */     if (getUpdateUserId() != null) {
/* 129 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/*     */     
/* 132 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 136 */     AwardAccountId id = new AwardAccountId();
/* 137 */     id.setOrganizationId(getOrganizationId());
/* 138 */     id.setCardNumber(getCardNumber());
/* 139 */     id.setAccountId(getAccountId());
/* 140 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 144 */     setOrganizationId(((AwardAccountId)argObjectId).getOrganizationId());
/* 145 */     setCardNumber(((AwardAccountId)argObjectId).getCardNumber());
/* 146 */     setAccountId(((AwardAccountId)argObjectId).getAccountId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 150 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 154 */     StringBuilder buf = new StringBuilder(350);
/* 155 */     buf.append("<").append("dao").append(" name=\"AwardAccount\" cmd=\"" + getObjectStateString() + "\">");
/* 156 */     getFieldsAsXml(buf);
/* 157 */     buf.append("</").append("dao").append(">");
/*     */     
/* 159 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 163 */     Map<String, String> values = super.getValues();
/* 164 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 165 */     if (this._cardNumber != null) values.put("CardNumber", DaoUtils.getXmlSafeFieldValue(12, this._cardNumber)); 
/* 166 */     if (this._accountId != null) values.put("AccountId", DaoUtils.getXmlSafeFieldValue(12, this._accountId)); 
/* 167 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 168 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 169 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 170 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 171 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 176 */     super.setValues(argValues);
/* 177 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 179 */       String fieldName = field.getKey();
/* 180 */       String fieldValue = field.getValue();
/* 181 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 185 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 186 */             setOrganizationId((Long)value);
/* 187 */           } catch (Exception ee) {
/* 188 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CardNumber":
/*     */           try {
/* 194 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 195 */             setCardNumber((String)value);
/* 196 */           } catch (Exception ee) {
/* 197 */             throw new DtxException("An exception occurred while calling setCardNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AccountId":
/*     */           try {
/* 203 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 204 */             setAccountId((String)value);
/* 205 */           } catch (Exception ee) {
/* 206 */             throw new DtxException("An exception occurred while calling setAccountId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 212 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 213 */             setCreateDate((Date)value);
/* 214 */           } catch (Exception ee) {
/* 215 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 221 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 222 */             setCreateUserId((String)value);
/* 223 */           } catch (Exception ee) {
/* 224 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 230 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 231 */             setUpdateDate((Date)value);
/* 232 */           } catch (Exception ee) {
/* 233 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 239 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 240 */             setUpdateUserId((String)value);
/* 241 */           } catch (Exception ee) {
/* 242 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\AwardAccountDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */