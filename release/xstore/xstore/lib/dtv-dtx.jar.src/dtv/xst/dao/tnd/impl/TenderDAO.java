/*     */ package dtv.xst.dao.tnd.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.tnd.TenderId;
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
/*     */ public class TenderDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1793466636L;
/*  23 */   private static final Logger _logger = Logger.getLogger(TenderDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _tenderId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _currencyId;
/*     */   private String _description;
/*     */   private Integer _displayOrder;
/*     */   private Integer _flashSalesDisplayOrder;
/*     */   private String _tenderTypecode;
/*  36 */   private Boolean _disabled = Boolean.FALSE;
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
/*     */   public String getTenderId() {
/*  49 */     return this._tenderId;
/*     */   }
/*     */   
/*     */   public void setTenderId(String argTenderId) {
/*  53 */     if (changed(argTenderId, this._tenderId, "tenderId")) {
/*  54 */       this._tenderId = (argTenderId != null && MANAGE_CASE) ? argTenderId.toUpperCase() : argTenderId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  59 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  63 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  64 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  70 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  74 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  75 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  80 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  84 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  85 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  91 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  95 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  96 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCurrencyId() {
/* 101 */     return this._currencyId;
/*     */   }
/*     */   
/*     */   public void setCurrencyId(String argCurrencyId) {
/* 105 */     if (changed(argCurrencyId, this._currencyId, "currencyId")) {
/* 106 */       this._currencyId = argCurrencyId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 111 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 115 */     if (changed(argDescription, this._description, "description")) {
/* 116 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getDisplayOrder() {
/* 121 */     return this._displayOrder;
/*     */   }
/*     */   
/*     */   public void setDisplayOrder(Integer argDisplayOrder) {
/* 125 */     if (changed(argDisplayOrder, this._displayOrder, "displayOrder")) {
/* 126 */       this._displayOrder = argDisplayOrder;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getFlashSalesDisplayOrder() {
/* 131 */     return this._flashSalesDisplayOrder;
/*     */   }
/*     */   
/*     */   public void setFlashSalesDisplayOrder(Integer argFlashSalesDisplayOrder) {
/* 135 */     if (changed(argFlashSalesDisplayOrder, this._flashSalesDisplayOrder, "flashSalesDisplayOrder")) {
/* 136 */       this._flashSalesDisplayOrder = argFlashSalesDisplayOrder;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTenderTypecode() {
/* 141 */     return this._tenderTypecode;
/*     */   }
/*     */   
/*     */   public void setTenderTypecode(String argTenderTypecode) {
/* 145 */     if (changed(argTenderTypecode, this._tenderTypecode, "tenderTypecode")) {
/* 146 */       this._tenderTypecode = argTenderTypecode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getDisabled() {
/* 151 */     return this._disabled;
/*     */   }
/*     */   
/*     */   public void setDisabled(Boolean argDisabled) {
/* 155 */     if (changed(argDisabled, this._disabled, "disabled")) {
/* 156 */       this._disabled = argDisabled;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 163 */     StringBuilder buf = new StringBuilder(512);
/* 164 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 165 */     if (getOrganizationId() != null) {
/* 166 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 168 */     if (getTenderId() != null) {
/* 169 */       buf.append("tenderId").append("=").append(getTenderId()).append(" ");
/*     */     }
/* 171 */     if (getCreateDate() != null) {
/* 172 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 174 */     if (getCreateUserId() != null) {
/* 175 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 177 */     if (getUpdateDate() != null) {
/* 178 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 180 */     if (getUpdateUserId() != null) {
/* 181 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 183 */     if (getCurrencyId() != null) {
/* 184 */       buf.append("currencyId").append("=").append(getCurrencyId()).append(" ");
/*     */     }
/* 186 */     if (getDescription() != null) {
/* 187 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 189 */     if (getDisplayOrder() != null) {
/* 190 */       buf.append("displayOrder").append("=").append(getDisplayOrder()).append(" ");
/*     */     }
/* 192 */     if (getFlashSalesDisplayOrder() != null) {
/* 193 */       buf.append("flashSalesDisplayOrder").append("=").append(getFlashSalesDisplayOrder()).append(" ");
/*     */     }
/* 195 */     if (getTenderTypecode() != null) {
/* 196 */       buf.append("tenderTypecode").append("=").append(getTenderTypecode()).append(" ");
/*     */     }
/* 198 */     if (getDisabled() != null && getDisabled().booleanValue()) {
/* 199 */       buf.append("disabled").append("=").append(getDisabled()).append(" ");
/*     */     }
/*     */     
/* 202 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 206 */     TenderId id = new TenderId();
/* 207 */     id.setOrganizationId(getOrganizationId());
/* 208 */     id.setTenderId(getTenderId());
/* 209 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 213 */     setOrganizationId(((TenderId)argObjectId).getOrganizationId());
/* 214 */     setTenderId(((TenderId)argObjectId).getTenderId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 218 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 222 */     StringBuilder buf = new StringBuilder(600);
/* 223 */     buf.append("<").append("dao").append(" name=\"Tender\" cmd=\"" + getObjectStateString() + "\">");
/* 224 */     getFieldsAsXml(buf);
/* 225 */     buf.append("</").append("dao").append(">");
/*     */     
/* 227 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 231 */     Map<String, String> values = super.getValues();
/* 232 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 233 */     if (this._tenderId != null) values.put("TenderId", DaoUtils.getXmlSafeFieldValue(12, this._tenderId)); 
/* 234 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 235 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 236 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 237 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 238 */     if (this._currencyId != null) values.put("CurrencyId", DaoUtils.getXmlSafeFieldValue(12, this._currencyId)); 
/* 239 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 240 */     if (this._displayOrder != null) values.put("DisplayOrder", DaoUtils.getXmlSafeFieldValue(4, this._displayOrder)); 
/* 241 */     if (this._flashSalesDisplayOrder != null) values.put("FlashSalesDisplayOrder", DaoUtils.getXmlSafeFieldValue(4, this._flashSalesDisplayOrder)); 
/* 242 */     if (this._tenderTypecode != null) values.put("TenderTypecode", DaoUtils.getXmlSafeFieldValue(12, this._tenderTypecode)); 
/* 243 */     if (this._disabled != null) values.put("Disabled", DaoUtils.getXmlSafeFieldValue(-7, this._disabled)); 
/* 244 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 249 */     super.setValues(argValues);
/* 250 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 252 */       String fieldName = field.getKey();
/* 253 */       String fieldValue = field.getValue();
/* 254 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 258 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 259 */             setOrganizationId((Long)value);
/* 260 */           } catch (Exception ee) {
/* 261 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TenderId":
/*     */           try {
/* 267 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 268 */             setTenderId((String)value);
/* 269 */           } catch (Exception ee) {
/* 270 */             throw new DtxException("An exception occurred while calling setTenderId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 276 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 277 */             setCreateDate((Date)value);
/* 278 */           } catch (Exception ee) {
/* 279 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 285 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 286 */             setCreateUserId((String)value);
/* 287 */           } catch (Exception ee) {
/* 288 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 294 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 295 */             setUpdateDate((Date)value);
/* 296 */           } catch (Exception ee) {
/* 297 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 303 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 304 */             setUpdateUserId((String)value);
/* 305 */           } catch (Exception ee) {
/* 306 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CurrencyId":
/*     */           try {
/* 312 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 313 */             setCurrencyId((String)value);
/* 314 */           } catch (Exception ee) {
/* 315 */             throw new DtxException("An exception occurred while calling setCurrencyId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 321 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 322 */             setDescription((String)value);
/* 323 */           } catch (Exception ee) {
/* 324 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DisplayOrder":
/*     */           try {
/* 330 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 331 */             setDisplayOrder((Integer)value);
/* 332 */           } catch (Exception ee) {
/* 333 */             throw new DtxException("An exception occurred while calling setDisplayOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FlashSalesDisplayOrder":
/*     */           try {
/* 339 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 340 */             setFlashSalesDisplayOrder((Integer)value);
/* 341 */           } catch (Exception ee) {
/* 342 */             throw new DtxException("An exception occurred while calling setFlashSalesDisplayOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TenderTypecode":
/*     */           try {
/* 348 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 349 */             setTenderTypecode((String)value);
/* 350 */           } catch (Exception ee) {
/* 351 */             throw new DtxException("An exception occurred while calling setTenderTypecode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Disabled":
/*     */           try {
/* 357 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 358 */             setDisabled((Boolean)value);
/* 359 */           } catch (Exception ee) {
/* 360 */             throw new DtxException("An exception occurred while calling setDisabled() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\impl\TenderDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */