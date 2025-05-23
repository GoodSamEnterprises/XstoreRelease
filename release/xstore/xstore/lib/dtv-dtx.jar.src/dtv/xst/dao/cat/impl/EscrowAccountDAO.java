/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.EscrowAccountId;
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
/*     */ public class EscrowAccountDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -878204408L;
/*  23 */   private static final Logger _logger = Logger.getLogger(EscrowAccountDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _accountBalance;
/*     */   private String _custAccountStateCode;
/*     */   private DtvDate _accountSetupDate;
/*     */   private DtvDate _lastActivityDate;
/*     */   private Long _partyId;
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
/*     */   public String getCustAccountId() {
/*  48 */     return this._custAccountId;
/*     */   }
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/*  52 */     if (changed(argCustAccountId, this._custAccountId, "custAccountId")) {
/*  53 */       this._custAccountId = (argCustAccountId != null && MANAGE_CASE) ? argCustAccountId.toUpperCase() : argCustAccountId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  58 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  62 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  63 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  69 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  73 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  74 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  79 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  83 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  84 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  90 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  94 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  95 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getAccountBalance() {
/* 100 */     return this._accountBalance;
/*     */   }
/*     */   
/*     */   public void setAccountBalance(BigDecimal argAccountBalance) {
/* 104 */     if (changed(argAccountBalance, this._accountBalance, "accountBalance")) {
/* 105 */       this._accountBalance = argAccountBalance;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustAccountStateCode() {
/* 110 */     return this._custAccountStateCode;
/*     */   }
/*     */   
/*     */   public void setCustAccountStateCode(String argCustAccountStateCode) {
/* 114 */     if (changed(argCustAccountStateCode, this._custAccountStateCode, "custAccountStateCode")) {
/* 115 */       this._custAccountStateCode = argCustAccountStateCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getAccountSetupDate() {
/* 120 */     return (Date)this._accountSetupDate;
/*     */   }
/*     */   
/*     */   public void setAccountSetupDate(Date argAccountSetupDate) {
/* 124 */     if (changed(argAccountSetupDate, this._accountSetupDate, "accountSetupDate")) {
/* 125 */       this._accountSetupDate = (argAccountSetupDate == null || argAccountSetupDate instanceof DtvDate) ? (DtvDate)argAccountSetupDate : new DtvDate(argAccountSetupDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Date getLastActivityDate() {
/* 131 */     return (Date)this._lastActivityDate;
/*     */   }
/*     */   
/*     */   public void setLastActivityDate(Date argLastActivityDate) {
/* 135 */     if (changed(argLastActivityDate, this._lastActivityDate, "lastActivityDate")) {
/* 136 */       this._lastActivityDate = (argLastActivityDate == null || argLastActivityDate instanceof DtvDate) ? (DtvDate)argLastActivityDate : new DtvDate(argLastActivityDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getPartyId() {
/* 142 */     return this._partyId;
/*     */   }
/*     */   
/*     */   public void setPartyId(Long argPartyId) {
/* 146 */     if (changed(argPartyId, this._partyId, "partyId")) {
/* 147 */       this._partyId = argPartyId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 154 */     StringBuilder buf = new StringBuilder(512);
/* 155 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 156 */     if (getOrganizationId() != null) {
/* 157 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 159 */     if (getCustAccountId() != null) {
/* 160 */       buf.append("custAccountId").append("=").append(getCustAccountId()).append(" ");
/*     */     }
/* 162 */     if (getCreateDate() != null) {
/* 163 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 165 */     if (getCreateUserId() != null) {
/* 166 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 168 */     if (getUpdateDate() != null) {
/* 169 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 171 */     if (getUpdateUserId() != null) {
/* 172 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 174 */     if (getAccountBalance() != null) {
/* 175 */       buf.append("accountBalance").append("=").append(getAccountBalance()).append(" ");
/*     */     }
/* 177 */     if (getCustAccountStateCode() != null) {
/* 178 */       buf.append("custAccountStateCode").append("=").append(getCustAccountStateCode()).append(" ");
/*     */     }
/* 180 */     if (getAccountSetupDate() != null) {
/* 181 */       buf.append("accountSetupDate").append("=").append(getAccountSetupDate()).append(" ");
/*     */     }
/* 183 */     if (getLastActivityDate() != null) {
/* 184 */       buf.append("lastActivityDate").append("=").append(getLastActivityDate()).append(" ");
/*     */     }
/* 186 */     if (getPartyId() != null) {
/* 187 */       buf.append("partyId").append("=").append(getPartyId()).append(" ");
/*     */     }
/*     */     
/* 190 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 194 */     EscrowAccountId id = new EscrowAccountId();
/* 195 */     id.setOrganizationId(getOrganizationId());
/* 196 */     id.setCustAccountId(getCustAccountId());
/* 197 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 201 */     setOrganizationId(((EscrowAccountId)argObjectId).getOrganizationId());
/* 202 */     setCustAccountId(((EscrowAccountId)argObjectId).getCustAccountId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 206 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 210 */     StringBuilder buf = new StringBuilder(550);
/* 211 */     buf.append("<").append("dao").append(" name=\"EscrowAccount\" cmd=\"" + getObjectStateString() + "\">");
/* 212 */     getFieldsAsXml(buf);
/* 213 */     buf.append("</").append("dao").append(">");
/*     */     
/* 215 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 219 */     Map<String, String> values = super.getValues();
/* 220 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 221 */     if (this._custAccountId != null) values.put("CustAccountId", DaoUtils.getXmlSafeFieldValue(12, this._custAccountId)); 
/* 222 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 223 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 224 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 225 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 226 */     if (this._accountBalance != null) values.put("AccountBalance", DaoUtils.getXmlSafeFieldValue(3, this._accountBalance)); 
/* 227 */     if (this._custAccountStateCode != null) values.put("CustAccountStateCode", DaoUtils.getXmlSafeFieldValue(12, this._custAccountStateCode)); 
/* 228 */     if (this._accountSetupDate != null) values.put("AccountSetupDate", DaoUtils.getXmlSafeFieldValue(91, this._accountSetupDate)); 
/* 229 */     if (this._lastActivityDate != null) values.put("LastActivityDate", DaoUtils.getXmlSafeFieldValue(91, this._lastActivityDate)); 
/* 230 */     if (this._partyId != null) values.put("PartyId", DaoUtils.getXmlSafeFieldValue(-5, this._partyId)); 
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
/*     */         case "CustAccountId":
/*     */           try {
/* 254 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 255 */             setCustAccountId((String)value);
/* 256 */           } catch (Exception ee) {
/* 257 */             throw new DtxException("An exception occurred while calling setCustAccountId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 263 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 264 */             setCreateDate((Date)value);
/* 265 */           } catch (Exception ee) {
/* 266 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 272 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 273 */             setCreateUserId((String)value);
/* 274 */           } catch (Exception ee) {
/* 275 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 281 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 282 */             setUpdateDate((Date)value);
/* 283 */           } catch (Exception ee) {
/* 284 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 290 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 291 */             setUpdateUserId((String)value);
/* 292 */           } catch (Exception ee) {
/* 293 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AccountBalance":
/*     */           try {
/* 299 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 300 */             setAccountBalance((BigDecimal)value);
/* 301 */           } catch (Exception ee) {
/* 302 */             throw new DtxException("An exception occurred while calling setAccountBalance() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountStateCode":
/*     */           try {
/* 308 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 309 */             setCustAccountStateCode((String)value);
/* 310 */           } catch (Exception ee) {
/* 311 */             throw new DtxException("An exception occurred while calling setCustAccountStateCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AccountSetupDate":
/*     */           try {
/* 317 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 318 */             setAccountSetupDate((Date)value);
/* 319 */           } catch (Exception ee) {
/* 320 */             throw new DtxException("An exception occurred while calling setAccountSetupDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LastActivityDate":
/*     */           try {
/* 326 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 327 */             setLastActivityDate((Date)value);
/* 328 */           } catch (Exception ee) {
/* 329 */             throw new DtxException("An exception occurred while calling setLastActivityDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PartyId":
/*     */           try {
/* 335 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 336 */             setPartyId((Long)value);
/* 337 */           } catch (Exception ee) {
/* 338 */             throw new DtxException("An exception occurred while calling setPartyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\EscrowAccountDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */