/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cat.PaymentScheduleId;
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
/*     */ public class PaymentScheduleDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1798863517L;
/*  23 */   private static final Logger _logger = Logger.getLogger(PaymentScheduleDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private DtvDate _beginDate;
/*     */   private String _intervalTypeEnum;
/*     */   private Integer _intervalCount;
/*     */   private BigDecimal _totalPaymentAmount;
/*     */   private Integer _paymentCount;
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
/*     */   public String getCustAccountId() {
/*  49 */     return this._custAccountId;
/*     */   }
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/*  53 */     if (changed(argCustAccountId, this._custAccountId, "custAccountId")) {
/*  54 */       this._custAccountId = (argCustAccountId != null && MANAGE_CASE) ? argCustAccountId.toUpperCase() : argCustAccountId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustAccountCode() {
/*  59 */     return this._custAccountCode;
/*     */   }
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/*  63 */     if (changed(argCustAccountCode, this._custAccountCode, "custAccountCode")) {
/*  64 */       this._custAccountCode = (argCustAccountCode != null && MANAGE_CASE) ? argCustAccountCode.toUpperCase() : argCustAccountCode;
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
/*     */   public Date getBeginDate() {
/* 111 */     return (Date)this._beginDate;
/*     */   }
/*     */   
/*     */   public void setBeginDate(Date argBeginDate) {
/* 115 */     if (changed(argBeginDate, this._beginDate, "beginDate")) {
/* 116 */       this._beginDate = (argBeginDate == null || argBeginDate instanceof DtvDate) ? (DtvDate)argBeginDate : new DtvDate(argBeginDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getIntervalTypeEnum() {
/* 122 */     return this._intervalTypeEnum;
/*     */   }
/*     */   
/*     */   public void setIntervalTypeEnum(String argIntervalTypeEnum) {
/* 126 */     if (changed(argIntervalTypeEnum, this._intervalTypeEnum, "intervalTypeEnum")) {
/* 127 */       this._intervalTypeEnum = argIntervalTypeEnum;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getIntervalCount() {
/* 132 */     return this._intervalCount;
/*     */   }
/*     */   
/*     */   public void setIntervalCount(Integer argIntervalCount) {
/* 136 */     if (changed(argIntervalCount, this._intervalCount, "intervalCount")) {
/* 137 */       this._intervalCount = argIntervalCount;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getTotalPaymentAmount() {
/* 142 */     return this._totalPaymentAmount;
/*     */   }
/*     */   
/*     */   public void setTotalPaymentAmount(BigDecimal argTotalPaymentAmount) {
/* 146 */     if (changed(argTotalPaymentAmount, this._totalPaymentAmount, "totalPaymentAmount")) {
/* 147 */       this._totalPaymentAmount = argTotalPaymentAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getPaymentCount() {
/* 152 */     return this._paymentCount;
/*     */   }
/*     */   
/*     */   public void setPaymentCount(Integer argPaymentCount) {
/* 156 */     if (changed(argPaymentCount, this._paymentCount, "paymentCount")) {
/* 157 */       this._paymentCount = argPaymentCount;
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
/* 169 */     if (getCustAccountId() != null) {
/* 170 */       buf.append("custAccountId").append("=").append(getCustAccountId()).append(" ");
/*     */     }
/* 172 */     if (getCustAccountCode() != null) {
/* 173 */       buf.append("custAccountCode").append("=").append(getCustAccountCode()).append(" ");
/*     */     }
/* 175 */     if (getCreateDate() != null) {
/* 176 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 178 */     if (getCreateUserId() != null) {
/* 179 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 181 */     if (getUpdateDate() != null) {
/* 182 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 184 */     if (getUpdateUserId() != null) {
/* 185 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 187 */     if (getBeginDate() != null) {
/* 188 */       buf.append("beginDate").append("=").append(getBeginDate()).append(" ");
/*     */     }
/* 190 */     if (getIntervalTypeEnum() != null) {
/* 191 */       buf.append("intervalTypeEnum").append("=").append(getIntervalTypeEnum()).append(" ");
/*     */     }
/* 193 */     if (getIntervalCount() != null) {
/* 194 */       buf.append("intervalCount").append("=").append(getIntervalCount()).append(" ");
/*     */     }
/* 196 */     if (getTotalPaymentAmount() != null) {
/* 197 */       buf.append("totalPaymentAmount").append("=").append(getTotalPaymentAmount()).append(" ");
/*     */     }
/* 199 */     if (getPaymentCount() != null) {
/* 200 */       buf.append("paymentCount").append("=").append(getPaymentCount()).append(" ");
/*     */     }
/*     */     
/* 203 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 207 */     PaymentScheduleId id = new PaymentScheduleId();
/* 208 */     id.setOrganizationId(getOrganizationId());
/* 209 */     id.setCustAccountId(getCustAccountId());
/* 210 */     id.setCustAccountCode(getCustAccountCode());
/* 211 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 215 */     setOrganizationId(((PaymentScheduleId)argObjectId).getOrganizationId());
/* 216 */     setCustAccountId(((PaymentScheduleId)argObjectId).getCustAccountId());
/* 217 */     setCustAccountCode(((PaymentScheduleId)argObjectId).getCustAccountCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 221 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 225 */     StringBuilder buf = new StringBuilder(600);
/* 226 */     buf.append("<").append("dao").append(" name=\"PaymentSchedule\" cmd=\"" + getObjectStateString() + "\">");
/* 227 */     getFieldsAsXml(buf);
/* 228 */     buf.append("</").append("dao").append(">");
/*     */     
/* 230 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 234 */     Map<String, String> values = super.getValues();
/* 235 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 236 */     if (this._custAccountId != null) values.put("CustAccountId", DaoUtils.getXmlSafeFieldValue(12, this._custAccountId)); 
/* 237 */     if (this._custAccountCode != null) values.put("CustAccountCode", DaoUtils.getXmlSafeFieldValue(12, this._custAccountCode)); 
/* 238 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 239 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 240 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 241 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 242 */     if (this._beginDate != null) values.put("BeginDate", DaoUtils.getXmlSafeFieldValue(91, this._beginDate)); 
/* 243 */     if (this._intervalTypeEnum != null) values.put("IntervalTypeEnum", DaoUtils.getXmlSafeFieldValue(12, this._intervalTypeEnum)); 
/* 244 */     if (this._intervalCount != null) values.put("IntervalCount", DaoUtils.getXmlSafeFieldValue(4, this._intervalCount)); 
/* 245 */     if (this._totalPaymentAmount != null) values.put("TotalPaymentAmount", DaoUtils.getXmlSafeFieldValue(3, this._totalPaymentAmount)); 
/* 246 */     if (this._paymentCount != null) values.put("PaymentCount", DaoUtils.getXmlSafeFieldValue(4, this._paymentCount)); 
/* 247 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 252 */     super.setValues(argValues);
/* 253 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 255 */       String fieldName = field.getKey();
/* 256 */       String fieldValue = field.getValue();
/* 257 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 261 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 262 */             setOrganizationId((Long)value);
/* 263 */           } catch (Exception ee) {
/* 264 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountId":
/*     */           try {
/* 270 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 271 */             setCustAccountId((String)value);
/* 272 */           } catch (Exception ee) {
/* 273 */             throw new DtxException("An exception occurred while calling setCustAccountId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountCode":
/*     */           try {
/* 279 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 280 */             setCustAccountCode((String)value);
/* 281 */           } catch (Exception ee) {
/* 282 */             throw new DtxException("An exception occurred while calling setCustAccountCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 288 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 289 */             setCreateDate((Date)value);
/* 290 */           } catch (Exception ee) {
/* 291 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 297 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 298 */             setCreateUserId((String)value);
/* 299 */           } catch (Exception ee) {
/* 300 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 306 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 307 */             setUpdateDate((Date)value);
/* 308 */           } catch (Exception ee) {
/* 309 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 315 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 316 */             setUpdateUserId((String)value);
/* 317 */           } catch (Exception ee) {
/* 318 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BeginDate":
/*     */           try {
/* 324 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 325 */             setBeginDate((Date)value);
/* 326 */           } catch (Exception ee) {
/* 327 */             throw new DtxException("An exception occurred while calling setBeginDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "IntervalTypeEnum":
/*     */           try {
/* 333 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 334 */             setIntervalTypeEnum((String)value);
/* 335 */           } catch (Exception ee) {
/* 336 */             throw new DtxException("An exception occurred while calling setIntervalTypeEnum() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "IntervalCount":
/*     */           try {
/* 342 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 343 */             setIntervalCount((Integer)value);
/* 344 */           } catch (Exception ee) {
/* 345 */             throw new DtxException("An exception occurred while calling setIntervalCount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TotalPaymentAmount":
/*     */           try {
/* 351 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 352 */             setTotalPaymentAmount((BigDecimal)value);
/* 353 */           } catch (Exception ee) {
/* 354 */             throw new DtxException("An exception occurred while calling setTotalPaymentAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PaymentCount":
/*     */           try {
/* 360 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 361 */             setPaymentCount((Integer)value);
/* 362 */           } catch (Exception ee) {
/* 363 */             throw new DtxException("An exception occurred while calling setPaymentCount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\PaymentScheduleDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */