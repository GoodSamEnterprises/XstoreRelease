/*     */ package dtv.xst.dao.trl.impl;
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
/*     */ public class RetailTransactionDealLineItemDAO
/*     */   extends RetailTransactionLineItemDAO
/*     */ {
/*     */   private static final long serialVersionUID = -1110874354L;
/*  23 */   private static final Logger _logger = Logger.getLogger(RetailTransactionDealLineItemDAO.class);
/*     */   
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _amount;
/*     */   private String _dealId;
/*     */   private String _reasonCode;
/*     */   
/*     */   public Date getCreateDate() {
/*  34 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  38 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  39 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  45 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  49 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  50 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  55 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  59 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  60 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  66 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  70 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  71 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getAmount() {
/*  76 */     return this._amount;
/*     */   }
/*     */   
/*     */   public void setAmount(BigDecimal argAmount) {
/*  80 */     if (changed(argAmount, this._amount, "amount")) {
/*  81 */       this._amount = argAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDealId() {
/*  86 */     return this._dealId;
/*     */   }
/*     */   
/*     */   public void setDealId(String argDealId) {
/*  90 */     if (changed(argDealId, this._dealId, "dealId")) {
/*  91 */       this._dealId = argDealId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getReasonCode() {
/*  96 */     return this._reasonCode;
/*     */   }
/*     */   
/*     */   public void setReasonCode(String argReasonCode) {
/* 100 */     if (changed(argReasonCode, this._reasonCode, "reasonCode")) {
/* 101 */       this._reasonCode = argReasonCode;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 108 */     StringBuilder buf = new StringBuilder(512);
/* 109 */     buf.append(super.toString());
/* 110 */     if (getCreateDate() != null) {
/* 111 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 113 */     if (getCreateUserId() != null) {
/* 114 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 116 */     if (getUpdateDate() != null) {
/* 117 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 119 */     if (getUpdateUserId() != null) {
/* 120 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 122 */     if (getAmount() != null) {
/* 123 */       buf.append("amount").append("=").append(getAmount()).append(" ");
/*     */     }
/* 125 */     if (getDealId() != null) {
/* 126 */       buf.append("dealId").append("=").append(getDealId()).append(" ");
/*     */     }
/* 128 */     if (getReasonCode() != null) {
/* 129 */       buf.append("reasonCode").append("=").append(getReasonCode()).append(" ");
/*     */     }
/*     */     
/* 132 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 137 */     StringBuilder buf = new StringBuilder(1400);
/* 138 */     buf.append("<").append("dao").append(" name=\"RetailTransactionDealLineItem\" cmd=\"" + getObjectStateString() + "\">");
/* 139 */     getFieldsAsXml(buf);
/* 140 */     buf.append("</").append("dao").append(">");
/*     */     
/* 142 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 146 */     Map<String, String> values = super.getValues();
/* 147 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 148 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 149 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 150 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 151 */     if (this._amount != null) values.put("Amount", DaoUtils.getXmlSafeFieldValue(3, this._amount)); 
/* 152 */     if (this._dealId != null) values.put("DealId", DaoUtils.getXmlSafeFieldValue(12, this._dealId)); 
/* 153 */     if (this._reasonCode != null) values.put("ReasonCode", DaoUtils.getXmlSafeFieldValue(12, this._reasonCode)); 
/* 154 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 159 */     super.setValues(argValues);
/* 160 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 162 */       String fieldName = field.getKey();
/* 163 */       String fieldValue = field.getValue();
/* 164 */       switch (fieldName) {
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 168 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 169 */             setCreateDate((Date)value);
/* 170 */           } catch (Exception ee) {
/* 171 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 177 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 178 */             setCreateUserId((String)value);
/* 179 */           } catch (Exception ee) {
/* 180 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 186 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 187 */             setUpdateDate((Date)value);
/* 188 */           } catch (Exception ee) {
/* 189 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 195 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 196 */             setUpdateUserId((String)value);
/* 197 */           } catch (Exception ee) {
/* 198 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Amount":
/*     */           try {
/* 204 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 205 */             setAmount((BigDecimal)value);
/* 206 */           } catch (Exception ee) {
/* 207 */             throw new DtxException("An exception occurred while calling setAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DealId":
/*     */           try {
/* 213 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 214 */             setDealId((String)value);
/* 215 */           } catch (Exception ee) {
/* 216 */             throw new DtxException("An exception occurred while calling setDealId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReasonCode":
/*     */           try {
/* 222 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 223 */             setReasonCode((String)value);
/* 224 */           } catch (Exception ee) {
/* 225 */             throw new DtxException("An exception occurred while calling setReasonCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\RetailTransactionDealLineItemDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */