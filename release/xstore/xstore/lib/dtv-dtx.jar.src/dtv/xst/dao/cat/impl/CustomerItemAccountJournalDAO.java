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
/*     */ public class CustomerItemAccountJournalDAO
/*     */   extends CustomerAccountJournalDAO
/*     */ {
/*     */   private static final long serialVersionUID = -654891301L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CustomerItemAccountJournalDAO.class);
/*     */   
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _custAccountStateCode;
/*     */   private DtvDate _accountSetupDate;
/*     */   private DtvDate _lastActivityDate;
/*     */   private BigDecimal _accountTotal;
/*     */   private BigDecimal _accountPayments;
/*     */   private BigDecimal _activeAccountPayments;
/*     */   private BigDecimal _activeAccountTotal;
/*     */   
/*     */   public Date getCreateDate() {
/*  38 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  42 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  43 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  49 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  53 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  54 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  59 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  63 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  64 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  70 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  74 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  75 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustAccountStateCode() {
/*  80 */     return this._custAccountStateCode;
/*     */   }
/*     */   
/*     */   public void setCustAccountStateCode(String argCustAccountStateCode) {
/*  84 */     if (changed(argCustAccountStateCode, this._custAccountStateCode, "custAccountStateCode")) {
/*  85 */       this._custAccountStateCode = argCustAccountStateCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getAccountSetupDate() {
/*  90 */     return (Date)this._accountSetupDate;
/*     */   }
/*     */   
/*     */   public void setAccountSetupDate(Date argAccountSetupDate) {
/*  94 */     if (changed(argAccountSetupDate, this._accountSetupDate, "accountSetupDate")) {
/*  95 */       this._accountSetupDate = (argAccountSetupDate == null || argAccountSetupDate instanceof DtvDate) ? (DtvDate)argAccountSetupDate : new DtvDate(argAccountSetupDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getLastActivityDate() {
/* 101 */     return (Date)this._lastActivityDate;
/*     */   }
/*     */   
/*     */   public void setLastActivityDate(Date argLastActivityDate) {
/* 105 */     if (changed(argLastActivityDate, this._lastActivityDate, "lastActivityDate")) {
/* 106 */       this._lastActivityDate = (argLastActivityDate == null || argLastActivityDate instanceof DtvDate) ? (DtvDate)argLastActivityDate : new DtvDate(argLastActivityDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getAccountTotal() {
/* 112 */     return this._accountTotal;
/*     */   }
/*     */   
/*     */   public void setAccountTotal(BigDecimal argAccountTotal) {
/* 116 */     if (changed(argAccountTotal, this._accountTotal, "accountTotal")) {
/* 117 */       this._accountTotal = argAccountTotal;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getAccountPayments() {
/* 122 */     return this._accountPayments;
/*     */   }
/*     */   
/*     */   public void setAccountPayments(BigDecimal argAccountPayments) {
/* 126 */     if (changed(argAccountPayments, this._accountPayments, "accountPayments")) {
/* 127 */       this._accountPayments = argAccountPayments;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getActiveAccountPayments() {
/* 132 */     return this._activeAccountPayments;
/*     */   }
/*     */   
/*     */   public void setActiveAccountPayments(BigDecimal argActiveAccountPayments) {
/* 136 */     if (changed(argActiveAccountPayments, this._activeAccountPayments, "activeAccountPayments")) {
/* 137 */       this._activeAccountPayments = argActiveAccountPayments;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getActiveAccountTotal() {
/* 142 */     return this._activeAccountTotal;
/*     */   }
/*     */   
/*     */   public void setActiveAccountTotal(BigDecimal argActiveAccountTotal) {
/* 146 */     if (changed(argActiveAccountTotal, this._activeAccountTotal, "activeAccountTotal")) {
/* 147 */       this._activeAccountTotal = argActiveAccountTotal;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 154 */     StringBuilder buf = new StringBuilder(512);
/* 155 */     buf.append(super.toString());
/* 156 */     if (getCreateDate() != null) {
/* 157 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 159 */     if (getCreateUserId() != null) {
/* 160 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 162 */     if (getUpdateDate() != null) {
/* 163 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 165 */     if (getUpdateUserId() != null) {
/* 166 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 168 */     if (getCustAccountStateCode() != null) {
/* 169 */       buf.append("custAccountStateCode").append("=").append(getCustAccountStateCode()).append(" ");
/*     */     }
/* 171 */     if (getAccountSetupDate() != null) {
/* 172 */       buf.append("accountSetupDate").append("=").append(getAccountSetupDate()).append(" ");
/*     */     }
/* 174 */     if (getLastActivityDate() != null) {
/* 175 */       buf.append("lastActivityDate").append("=").append(getLastActivityDate()).append(" ");
/*     */     }
/* 177 */     if (getAccountTotal() != null) {
/* 178 */       buf.append("accountTotal").append("=").append(getAccountTotal()).append(" ");
/*     */     }
/* 180 */     if (getAccountPayments() != null) {
/* 181 */       buf.append("accountPayments").append("=").append(getAccountPayments()).append(" ");
/*     */     }
/* 183 */     if (getActiveAccountPayments() != null) {
/* 184 */       buf.append("activeAccountPayments").append("=").append(getActiveAccountPayments()).append(" ");
/*     */     }
/* 186 */     if (getActiveAccountTotal() != null) {
/* 187 */       buf.append("activeAccountTotal").append("=").append(getActiveAccountTotal()).append(" ");
/*     */     }
/*     */     
/* 190 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 195 */     StringBuilder buf = new StringBuilder(1400);
/* 196 */     buf.append("<").append("dao").append(" name=\"CustomerItemAccountJournal\" cmd=\"" + getObjectStateString() + "\">");
/* 197 */     getFieldsAsXml(buf);
/* 198 */     buf.append("</").append("dao").append(">");
/*     */     
/* 200 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 204 */     Map<String, String> values = super.getValues();
/* 205 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 206 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 207 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 208 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 209 */     if (this._custAccountStateCode != null) values.put("CustAccountStateCode", DaoUtils.getXmlSafeFieldValue(12, this._custAccountStateCode)); 
/* 210 */     if (this._accountSetupDate != null) values.put("AccountSetupDate", DaoUtils.getXmlSafeFieldValue(91, this._accountSetupDate)); 
/* 211 */     if (this._lastActivityDate != null) values.put("LastActivityDate", DaoUtils.getXmlSafeFieldValue(91, this._lastActivityDate)); 
/* 212 */     if (this._accountTotal != null) values.put("AccountTotal", DaoUtils.getXmlSafeFieldValue(3, this._accountTotal)); 
/* 213 */     if (this._accountPayments != null) values.put("AccountPayments", DaoUtils.getXmlSafeFieldValue(3, this._accountPayments)); 
/* 214 */     if (this._activeAccountPayments != null) values.put("ActiveAccountPayments", DaoUtils.getXmlSafeFieldValue(3, this._activeAccountPayments)); 
/* 215 */     if (this._activeAccountTotal != null) values.put("ActiveAccountTotal", DaoUtils.getXmlSafeFieldValue(3, this._activeAccountTotal)); 
/* 216 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 221 */     super.setValues(argValues);
/* 222 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 224 */       String fieldName = field.getKey();
/* 225 */       String fieldValue = field.getValue();
/* 226 */       switch (fieldName) {
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 230 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 231 */             setCreateDate((Date)value);
/* 232 */           } catch (Exception ee) {
/* 233 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 239 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 240 */             setCreateUserId((String)value);
/* 241 */           } catch (Exception ee) {
/* 242 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 248 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 249 */             setUpdateDate((Date)value);
/* 250 */           } catch (Exception ee) {
/* 251 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 257 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 258 */             setUpdateUserId((String)value);
/* 259 */           } catch (Exception ee) {
/* 260 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountStateCode":
/*     */           try {
/* 266 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 267 */             setCustAccountStateCode((String)value);
/* 268 */           } catch (Exception ee) {
/* 269 */             throw new DtxException("An exception occurred while calling setCustAccountStateCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AccountSetupDate":
/*     */           try {
/* 275 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 276 */             setAccountSetupDate((Date)value);
/* 277 */           } catch (Exception ee) {
/* 278 */             throw new DtxException("An exception occurred while calling setAccountSetupDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LastActivityDate":
/*     */           try {
/* 284 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 285 */             setLastActivityDate((Date)value);
/* 286 */           } catch (Exception ee) {
/* 287 */             throw new DtxException("An exception occurred while calling setLastActivityDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AccountTotal":
/*     */           try {
/* 293 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 294 */             setAccountTotal((BigDecimal)value);
/* 295 */           } catch (Exception ee) {
/* 296 */             throw new DtxException("An exception occurred while calling setAccountTotal() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AccountPayments":
/*     */           try {
/* 302 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 303 */             setAccountPayments((BigDecimal)value);
/* 304 */           } catch (Exception ee) {
/* 305 */             throw new DtxException("An exception occurred while calling setAccountPayments() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActiveAccountPayments":
/*     */           try {
/* 311 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 312 */             setActiveAccountPayments((BigDecimal)value);
/* 313 */           } catch (Exception ee) {
/* 314 */             throw new DtxException("An exception occurred while calling setActiveAccountPayments() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ActiveAccountTotal":
/*     */           try {
/* 320 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 321 */             setActiveAccountTotal((BigDecimal)value);
/* 322 */           } catch (Exception ee) {
/* 323 */             throw new DtxException("An exception occurred while calling setActiveAccountTotal() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerItemAccountJournalDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */