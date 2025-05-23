/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CustomerConsumerChargeAccountDAO
/*     */   extends CustomerAccountDAO
/*     */ {
/*     */   private static final long serialVersionUID = 424808229L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CustomerConsumerChargeAccountDAO.class);
/*     */   
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _creditLimit;
/*  30 */   private Boolean _poRequired = Boolean.FALSE;
/*  31 */   private Boolean _onHold = Boolean.FALSE;
/*  32 */   private Boolean _isCorporateAccount = Boolean.FALSE;
/*     */   
/*     */   public Date getCreateDate() {
/*  35 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  39 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  40 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  46 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  50 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  51 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  56 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  60 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  61 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  67 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  71 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  72 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getCreditLimit() {
/*  77 */     return this._creditLimit;
/*     */   }
/*     */   
/*     */   public void setCreditLimit(BigDecimal argCreditLimit) {
/*  81 */     if (changed(argCreditLimit, this._creditLimit, "creditLimit")) {
/*  82 */       this._creditLimit = argCreditLimit;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getPoRequired() {
/*  87 */     return this._poRequired;
/*     */   }
/*     */   
/*     */   public void setPoRequired(Boolean argPoRequired) {
/*  91 */     if (changed(argPoRequired, this._poRequired, "poRequired")) {
/*  92 */       this._poRequired = argPoRequired;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getOnHold() {
/*  97 */     return this._onHold;
/*     */   }
/*     */   
/*     */   public void setOnHold(Boolean argOnHold) {
/* 101 */     if (changed(argOnHold, this._onHold, "onHold")) {
/* 102 */       this._onHold = argOnHold;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getIsCorporateAccount() {
/* 107 */     return this._isCorporateAccount;
/*     */   }
/*     */   
/*     */   public void setIsCorporateAccount(Boolean argIsCorporateAccount) {
/* 111 */     if (changed(argIsCorporateAccount, this._isCorporateAccount, "isCorporateAccount")) {
/* 112 */       this._isCorporateAccount = argIsCorporateAccount;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 119 */     StringBuilder buf = new StringBuilder(512);
/* 120 */     buf.append(super.toString());
/* 121 */     if (getCreateDate() != null) {
/* 122 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 124 */     if (getCreateUserId() != null) {
/* 125 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 127 */     if (getUpdateDate() != null) {
/* 128 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 130 */     if (getUpdateUserId() != null) {
/* 131 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 133 */     if (getCreditLimit() != null) {
/* 134 */       buf.append("creditLimit").append("=").append(getCreditLimit()).append(" ");
/*     */     }
/* 136 */     if (getPoRequired() != null && getPoRequired().booleanValue()) {
/* 137 */       buf.append("poRequired").append("=").append(getPoRequired()).append(" ");
/*     */     }
/* 139 */     if (getOnHold() != null && getOnHold().booleanValue()) {
/* 140 */       buf.append("onHold").append("=").append(getOnHold()).append(" ");
/*     */     }
/* 142 */     if (getIsCorporateAccount() != null && getIsCorporateAccount().booleanValue()) {
/* 143 */       buf.append("isCorporateAccount").append("=").append(getIsCorporateAccount()).append(" ");
/*     */     }
/*     */     
/* 146 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 151 */     StringBuilder buf = new StringBuilder(1250);
/* 152 */     buf.append("<").append("dao").append(" name=\"CustomerConsumerChargeAccount\" cmd=\"" + getObjectStateString() + "\">");
/* 153 */     getFieldsAsXml(buf);
/* 154 */     buf.append("</").append("dao").append(">");
/*     */     
/* 156 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 160 */     Map<String, String> values = super.getValues();
/* 161 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 162 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 163 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 164 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 165 */     if (this._creditLimit != null) values.put("CreditLimit", DaoUtils.getXmlSafeFieldValue(3, this._creditLimit)); 
/* 166 */     if (this._poRequired != null) values.put("PoRequired", DaoUtils.getXmlSafeFieldValue(-7, this._poRequired)); 
/* 167 */     if (this._onHold != null) values.put("OnHold", DaoUtils.getXmlSafeFieldValue(-7, this._onHold)); 
/* 168 */     if (this._isCorporateAccount != null) values.put("IsCorporateAccount", DaoUtils.getXmlSafeFieldValue(-7, this._isCorporateAccount)); 
/* 169 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 174 */     super.setValues(argValues);
/* 175 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 177 */       String fieldName = field.getKey();
/* 178 */       String fieldValue = field.getValue();
/* 179 */       switch (fieldName) {
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 183 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 184 */             setCreateDate((Date)value);
/* 185 */           } catch (Exception ee) {
/* 186 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 192 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 193 */             setCreateUserId((String)value);
/* 194 */           } catch (Exception ee) {
/* 195 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 201 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 202 */             setUpdateDate((Date)value);
/* 203 */           } catch (Exception ee) {
/* 204 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 210 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 211 */             setUpdateUserId((String)value);
/* 212 */           } catch (Exception ee) {
/* 213 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreditLimit":
/*     */           try {
/* 219 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 220 */             setCreditLimit((BigDecimal)value);
/* 221 */           } catch (Exception ee) {
/* 222 */             throw new DtxException("An exception occurred while calling setCreditLimit() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PoRequired":
/*     */           try {
/* 228 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 229 */             setPoRequired((Boolean)value);
/* 230 */           } catch (Exception ee) {
/* 231 */             throw new DtxException("An exception occurred while calling setPoRequired() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OnHold":
/*     */           try {
/* 237 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 238 */             setOnHold((Boolean)value);
/* 239 */           } catch (Exception ee) {
/* 240 */             throw new DtxException("An exception occurred while calling setOnHold() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "IsCorporateAccount":
/*     */           try {
/* 246 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 247 */             setIsCorporateAccount((Boolean)value);
/* 248 */           } catch (Exception ee) {
/* 249 */             throw new DtxException("An exception occurred while calling setIsCorporateAccount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerConsumerChargeAccountDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */