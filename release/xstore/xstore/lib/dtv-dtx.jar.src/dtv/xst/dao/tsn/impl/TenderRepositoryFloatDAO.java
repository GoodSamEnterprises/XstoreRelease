/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tsn.TenderRepositoryFloatId;
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
/*     */ public class TenderRepositoryFloatDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 921069470L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TenderRepositoryFloatDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _tenderRepositoryId;
/*     */   private String _currencyId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private BigDecimal _defaultCashFloat;
/*     */   private BigDecimal _lastClosingCashAmt;
/*     */   
/*     */   public Long getOrganizationId() {
/*  37 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  41 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  42 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  47 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  51 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  52 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTenderRepositoryId() {
/*  57 */     return this._tenderRepositoryId;
/*     */   }
/*     */   
/*     */   public void setTenderRepositoryId(String argTenderRepositoryId) {
/*  61 */     if (changed(argTenderRepositoryId, this._tenderRepositoryId, "tenderRepositoryId")) {
/*  62 */       this._tenderRepositoryId = (argTenderRepositoryId != null && MANAGE_CASE) ? argTenderRepositoryId.toUpperCase() : argTenderRepositoryId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCurrencyId() {
/*  67 */     return this._currencyId;
/*     */   }
/*     */   
/*     */   public void setCurrencyId(String argCurrencyId) {
/*  71 */     if (changed(argCurrencyId, this._currencyId, "currencyId")) {
/*  72 */       this._currencyId = (argCurrencyId != null && MANAGE_CASE) ? argCurrencyId.toUpperCase() : argCurrencyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  77 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  81 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  82 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  88 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  92 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  93 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  98 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 102 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 103 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 109 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 113 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 114 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getDefaultCashFloat() {
/* 119 */     return this._defaultCashFloat;
/*     */   }
/*     */   
/*     */   public void setDefaultCashFloat(BigDecimal argDefaultCashFloat) {
/* 123 */     if (changed(argDefaultCashFloat, this._defaultCashFloat, "defaultCashFloat")) {
/* 124 */       this._defaultCashFloat = argDefaultCashFloat;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getLastClosingCashAmt() {
/* 129 */     return this._lastClosingCashAmt;
/*     */   }
/*     */   
/*     */   public void setLastClosingCashAmt(BigDecimal argLastClosingCashAmt) {
/* 133 */     if (changed(argLastClosingCashAmt, this._lastClosingCashAmt, "lastClosingCashAmt")) {
/* 134 */       this._lastClosingCashAmt = argLastClosingCashAmt;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 141 */     StringBuilder buf = new StringBuilder(512);
/* 142 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 143 */     if (getOrganizationId() != null) {
/* 144 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 146 */     if (getRetailLocationId() != null) {
/* 147 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 149 */     if (getTenderRepositoryId() != null) {
/* 150 */       buf.append("tenderRepositoryId").append("=").append(getTenderRepositoryId()).append(" ");
/*     */     }
/* 152 */     if (getCurrencyId() != null) {
/* 153 */       buf.append("currencyId").append("=").append(getCurrencyId()).append(" ");
/*     */     }
/* 155 */     if (getCreateDate() != null) {
/* 156 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 158 */     if (getCreateUserId() != null) {
/* 159 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 161 */     if (getUpdateDate() != null) {
/* 162 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 164 */     if (getUpdateUserId() != null) {
/* 165 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 167 */     if (getDefaultCashFloat() != null) {
/* 168 */       buf.append("defaultCashFloat").append("=").append(getDefaultCashFloat()).append(" ");
/*     */     }
/* 170 */     if (getLastClosingCashAmt() != null) {
/* 171 */       buf.append("lastClosingCashAmt").append("=").append(getLastClosingCashAmt()).append(" ");
/*     */     }
/*     */     
/* 174 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 178 */     TenderRepositoryFloatId id = new TenderRepositoryFloatId();
/* 179 */     id.setOrganizationId(getOrganizationId());
/* 180 */     id.setRetailLocationId(getRetailLocationId());
/* 181 */     id.setTenderRepositoryId(getTenderRepositoryId());
/* 182 */     id.setCurrencyId(getCurrencyId());
/* 183 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 187 */     setOrganizationId(((TenderRepositoryFloatId)argObjectId).getOrganizationId());
/* 188 */     setRetailLocationId(((TenderRepositoryFloatId)argObjectId).getRetailLocationId());
/* 189 */     setTenderRepositoryId(((TenderRepositoryFloatId)argObjectId).getTenderRepositoryId());
/* 190 */     setCurrencyId(((TenderRepositoryFloatId)argObjectId).getCurrencyId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 194 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 198 */     StringBuilder buf = new StringBuilder(500);
/* 199 */     buf.append("<").append("dao").append(" name=\"TenderRepositoryFloat\" cmd=\"" + getObjectStateString() + "\">");
/* 200 */     getFieldsAsXml(buf);
/* 201 */     buf.append("</").append("dao").append(">");
/*     */     
/* 203 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 207 */     Map<String, String> values = super.getValues();
/* 208 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 209 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 210 */     if (this._tenderRepositoryId != null) values.put("TenderRepositoryId", DaoUtils.getXmlSafeFieldValue(12, this._tenderRepositoryId)); 
/* 211 */     if (this._currencyId != null) values.put("CurrencyId", DaoUtils.getXmlSafeFieldValue(12, this._currencyId)); 
/* 212 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 213 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 214 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 215 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 216 */     if (this._defaultCashFloat != null) values.put("DefaultCashFloat", DaoUtils.getXmlSafeFieldValue(3, this._defaultCashFloat)); 
/* 217 */     if (this._lastClosingCashAmt != null) values.put("LastClosingCashAmt", DaoUtils.getXmlSafeFieldValue(3, this._lastClosingCashAmt)); 
/* 218 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 223 */     super.setValues(argValues);
/* 224 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 226 */       String fieldName = field.getKey();
/* 227 */       String fieldValue = field.getValue();
/* 228 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 232 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 233 */             setOrganizationId((Long)value);
/* 234 */           } catch (Exception ee) {
/* 235 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 241 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 242 */             setRetailLocationId((Long)value);
/* 243 */           } catch (Exception ee) {
/* 244 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TenderRepositoryId":
/*     */           try {
/* 250 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 251 */             setTenderRepositoryId((String)value);
/* 252 */           } catch (Exception ee) {
/* 253 */             throw new DtxException("An exception occurred while calling setTenderRepositoryId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CurrencyId":
/*     */           try {
/* 259 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 260 */             setCurrencyId((String)value);
/* 261 */           } catch (Exception ee) {
/* 262 */             throw new DtxException("An exception occurred while calling setCurrencyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 268 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 269 */             setCreateDate((Date)value);
/* 270 */           } catch (Exception ee) {
/* 271 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 277 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 278 */             setCreateUserId((String)value);
/* 279 */           } catch (Exception ee) {
/* 280 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 286 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 287 */             setUpdateDate((Date)value);
/* 288 */           } catch (Exception ee) {
/* 289 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 295 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 296 */             setUpdateUserId((String)value);
/* 297 */           } catch (Exception ee) {
/* 298 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DefaultCashFloat":
/*     */           try {
/* 304 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 305 */             setDefaultCashFloat((BigDecimal)value);
/* 306 */           } catch (Exception ee) {
/* 307 */             throw new DtxException("An exception occurred while calling setDefaultCashFloat() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LastClosingCashAmt":
/*     */           try {
/* 313 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 314 */             setLastClosingCashAmt((BigDecimal)value);
/* 315 */           } catch (Exception ee) {
/* 316 */             throw new DtxException("An exception occurred while calling setLastClosingCashAmt() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\TenderRepositoryFloatDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */