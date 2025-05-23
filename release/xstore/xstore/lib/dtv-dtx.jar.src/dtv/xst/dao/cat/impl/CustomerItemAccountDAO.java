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
/*     */ public class CustomerItemAccountDAO
/*     */   extends CustomerAccountDAO
/*     */ {
/*     */   private static final long serialVersionUID = -1032547140L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CustomerItemAccountDAO.class);
/*     */   
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _accountTotal;
/*     */   private BigDecimal _accountPayments;
/*     */   private BigDecimal _activeAccountPayments;
/*     */   private BigDecimal _activeAccountTotal;
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
/*     */   public BigDecimal getAccountTotal() {
/*  77 */     return this._accountTotal;
/*     */   }
/*     */   
/*     */   public void setAccountTotal(BigDecimal argAccountTotal) {
/*  81 */     if (changed(argAccountTotal, this._accountTotal, "accountTotal")) {
/*  82 */       this._accountTotal = argAccountTotal;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getAccountPayments() {
/*  87 */     return this._accountPayments;
/*     */   }
/*     */   
/*     */   public void setAccountPayments(BigDecimal argAccountPayments) {
/*  91 */     if (changed(argAccountPayments, this._accountPayments, "accountPayments")) {
/*  92 */       this._accountPayments = argAccountPayments;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getActiveAccountPayments() {
/*  97 */     return this._activeAccountPayments;
/*     */   }
/*     */   
/*     */   public void setActiveAccountPayments(BigDecimal argActiveAccountPayments) {
/* 101 */     if (changed(argActiveAccountPayments, this._activeAccountPayments, "activeAccountPayments")) {
/* 102 */       this._activeAccountPayments = argActiveAccountPayments;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getActiveAccountTotal() {
/* 107 */     return this._activeAccountTotal;
/*     */   }
/*     */   
/*     */   public void setActiveAccountTotal(BigDecimal argActiveAccountTotal) {
/* 111 */     if (changed(argActiveAccountTotal, this._activeAccountTotal, "activeAccountTotal")) {
/* 112 */       this._activeAccountTotal = argActiveAccountTotal;
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
/* 133 */     if (getAccountTotal() != null) {
/* 134 */       buf.append("accountTotal").append("=").append(getAccountTotal()).append(" ");
/*     */     }
/* 136 */     if (getAccountPayments() != null) {
/* 137 */       buf.append("accountPayments").append("=").append(getAccountPayments()).append(" ");
/*     */     }
/* 139 */     if (getActiveAccountPayments() != null) {
/* 140 */       buf.append("activeAccountPayments").append("=").append(getActiveAccountPayments()).append(" ");
/*     */     }
/* 142 */     if (getActiveAccountTotal() != null) {
/* 143 */       buf.append("activeAccountTotal").append("=").append(getActiveAccountTotal()).append(" ");
/*     */     }
/*     */     
/* 146 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 151 */     StringBuilder buf = new StringBuilder(1250);
/* 152 */     buf.append("<").append("dao").append(" name=\"CustomerItemAccount\" cmd=\"" + getObjectStateString() + "\">");
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
/* 165 */     if (this._accountTotal != null) values.put("AccountTotal", DaoUtils.getXmlSafeFieldValue(3, this._accountTotal)); 
/* 166 */     if (this._accountPayments != null) values.put("AccountPayments", DaoUtils.getXmlSafeFieldValue(3, this._accountPayments)); 
/* 167 */     if (this._activeAccountPayments != null) values.put("ActiveAccountPayments", DaoUtils.getXmlSafeFieldValue(3, this._activeAccountPayments)); 
/* 168 */     if (this._activeAccountTotal != null) values.put("ActiveAccountTotal", DaoUtils.getXmlSafeFieldValue(3, this._activeAccountTotal)); 
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
/*     */         case "AccountTotal":
/*     */           try {
/* 219 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 220 */             setAccountTotal((BigDecimal)value);
/* 221 */           } catch (Exception ee) {
/* 222 */             throw new DtxException("An exception occurred while calling setAccountTotal() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AccountPayments":
/*     */           try {
/* 228 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 229 */             setAccountPayments((BigDecimal)value);
/* 230 */           } catch (Exception ee) {
/* 231 */             throw new DtxException("An exception occurred while calling setAccountPayments() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActiveAccountPayments":
/*     */           try {
/* 237 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 238 */             setActiveAccountPayments((BigDecimal)value);
/* 239 */           } catch (Exception ee) {
/* 240 */             throw new DtxException("An exception occurred while calling setActiveAccountPayments() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActiveAccountTotal":
/*     */           try {
/* 246 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 247 */             setActiveAccountTotal((BigDecimal)value);
/* 248 */           } catch (Exception ee) {
/* 249 */             throw new DtxException("An exception occurred while calling setActiveAccountTotal() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerItemAccountDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */