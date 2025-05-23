/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.impl.PosTransactionDAO;
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
/*     */ public class EscrowTransactionDAO
/*     */   extends PosTransactionDAO
/*     */ {
/*     */   private static final long serialVersionUID = 1213959481L;
/*  23 */   private static final Logger _logger = Logger.getLogger(EscrowTransactionDAO.class);
/*     */   
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _custAccountId;
/*     */   private Long _activitySequenceNumber;
/*     */   private BigDecimal _escrowAmount;
/*     */   private Long _customerPartyId;
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
/*     */   public String getCustAccountId() {
/*  77 */     return this._custAccountId;
/*     */   }
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/*  81 */     if (changed(argCustAccountId, this._custAccountId, "custAccountId")) {
/*  82 */       this._custAccountId = argCustAccountId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getActivitySequenceNumber() {
/*  87 */     return this._activitySequenceNumber;
/*     */   }
/*     */   
/*     */   public void setActivitySequenceNumber(Long argActivitySequenceNumber) {
/*  91 */     if (changed(argActivitySequenceNumber, this._activitySequenceNumber, "activitySequenceNumber")) {
/*  92 */       this._activitySequenceNumber = argActivitySequenceNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getEscrowAmount() {
/*  97 */     return this._escrowAmount;
/*     */   }
/*     */   
/*     */   public void setEscrowAmount(BigDecimal argEscrowAmount) {
/* 101 */     if (changed(argEscrowAmount, this._escrowAmount, "escrowAmount")) {
/* 102 */       this._escrowAmount = argEscrowAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getCustomerPartyId() {
/* 107 */     return this._customerPartyId;
/*     */   }
/*     */   
/*     */   public void setCustomerPartyId(Long argCustomerPartyId) {
/* 111 */     if (changed(argCustomerPartyId, this._customerPartyId, "customerPartyId")) {
/* 112 */       this._customerPartyId = argCustomerPartyId;
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
/* 133 */     if (getCustAccountId() != null) {
/* 134 */       buf.append("custAccountId").append("=").append(getCustAccountId()).append(" ");
/*     */     }
/* 136 */     if (getActivitySequenceNumber() != null) {
/* 137 */       buf.append("activitySequenceNumber").append("=").append(getActivitySequenceNumber()).append(" ");
/*     */     }
/* 139 */     if (getEscrowAmount() != null) {
/* 140 */       buf.append("escrowAmount").append("=").append(getEscrowAmount()).append(" ");
/*     */     }
/* 142 */     if (getCustomerPartyId() != null) {
/* 143 */       buf.append("customerPartyId").append("=").append(getCustomerPartyId()).append(" ");
/*     */     }
/*     */     
/* 146 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 151 */     StringBuilder buf = new StringBuilder(1850);
/* 152 */     buf.append("<").append("dao").append(" name=\"EscrowTransaction\" cmd=\"" + getObjectStateString() + "\">");
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
/* 165 */     if (this._custAccountId != null) values.put("CustAccountId", DaoUtils.getXmlSafeFieldValue(12, this._custAccountId)); 
/* 166 */     if (this._activitySequenceNumber != null) values.put("ActivitySequenceNumber", DaoUtils.getXmlSafeFieldValue(-5, this._activitySequenceNumber)); 
/* 167 */     if (this._escrowAmount != null) values.put("EscrowAmount", DaoUtils.getXmlSafeFieldValue(3, this._escrowAmount)); 
/* 168 */     if (this._customerPartyId != null) values.put("CustomerPartyId", DaoUtils.getXmlSafeFieldValue(-5, this._customerPartyId)); 
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
/*     */         case "CustAccountId":
/*     */           try {
/* 219 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 220 */             setCustAccountId((String)value);
/* 221 */           } catch (Exception ee) {
/* 222 */             throw new DtxException("An exception occurred while calling setCustAccountId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActivitySequenceNumber":
/*     */           try {
/* 228 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 229 */             setActivitySequenceNumber((Long)value);
/* 230 */           } catch (Exception ee) {
/* 231 */             throw new DtxException("An exception occurred while calling setActivitySequenceNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EscrowAmount":
/*     */           try {
/* 237 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 238 */             setEscrowAmount((BigDecimal)value);
/* 239 */           } catch (Exception ee) {
/* 240 */             throw new DtxException("An exception occurred while calling setEscrowAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustomerPartyId":
/*     */           try {
/* 246 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 247 */             setCustomerPartyId((Long)value);
/* 248 */           } catch (Exception ee) {
/* 249 */             throw new DtxException("An exception occurred while calling setCustomerPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\EscrowTransactionDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */