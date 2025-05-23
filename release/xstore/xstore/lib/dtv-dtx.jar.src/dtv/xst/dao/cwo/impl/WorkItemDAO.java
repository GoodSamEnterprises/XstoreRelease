/*     */ package dtv.xst.dao.cwo.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.cwo.WorkItemId;
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
/*     */ public class WorkItemDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 99166692L;
/*  23 */   private static final Logger _logger = Logger.getLogger(WorkItemDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _custAccountId;
/*     */   private String _custAccountCode;
/*     */   private Integer _workItemSequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _itemId;
/*     */   private String _description;
/*     */   private BigDecimal _valueAmount;
/*     */   private String _warrantyNumber;
/*     */   private String _workItemSerialNumber;
/*  38 */   private Boolean _void = Boolean.FALSE;
/*     */   
/*     */   public Long getOrganizationId() {
/*  41 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  45 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  46 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustAccountId() {
/*  51 */     return this._custAccountId;
/*     */   }
/*     */   
/*     */   public void setCustAccountId(String argCustAccountId) {
/*  55 */     if (changed(argCustAccountId, this._custAccountId, "custAccountId")) {
/*  56 */       this._custAccountId = (argCustAccountId != null && MANAGE_CASE) ? argCustAccountId.toUpperCase() : argCustAccountId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCustAccountCode() {
/*  61 */     return this._custAccountCode;
/*     */   }
/*     */   
/*     */   public void setCustAccountCode(String argCustAccountCode) {
/*  65 */     if (changed(argCustAccountCode, this._custAccountCode, "custAccountCode")) {
/*  66 */       this._custAccountCode = (argCustAccountCode != null && MANAGE_CASE) ? argCustAccountCode.toUpperCase() : argCustAccountCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getWorkItemSequence() {
/*  71 */     return this._workItemSequence;
/*     */   }
/*     */   
/*     */   public void setWorkItemSequence(Integer argWorkItemSequence) {
/*  75 */     if (changed(argWorkItemSequence, this._workItemSequence, "workItemSequence")) {
/*  76 */       this._workItemSequence = argWorkItemSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  81 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  85 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  86 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  92 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  96 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  97 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 102 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 106 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 107 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 113 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 117 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 118 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getItemId() {
/* 123 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/* 127 */     if (changed(argItemId, this._itemId, "itemId")) {
/* 128 */       this._itemId = argItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 133 */     return this._description;
/*     */   }
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 137 */     if (changed(argDescription, this._description, "description")) {
/* 138 */       this._description = argDescription;
/*     */     }
/*     */   }
/*     */   
/*     */   public BigDecimal getValueAmount() {
/* 143 */     return this._valueAmount;
/*     */   }
/*     */   
/*     */   public void setValueAmount(BigDecimal argValueAmount) {
/* 147 */     if (changed(argValueAmount, this._valueAmount, "valueAmount")) {
/* 148 */       this._valueAmount = argValueAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getWarrantyNumber() {
/* 153 */     return this._warrantyNumber;
/*     */   }
/*     */   
/*     */   public void setWarrantyNumber(String argWarrantyNumber) {
/* 157 */     if (changed(argWarrantyNumber, this._warrantyNumber, "warrantyNumber")) {
/* 158 */       this._warrantyNumber = argWarrantyNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getWorkItemSerialNumber() {
/* 163 */     return this._workItemSerialNumber;
/*     */   }
/*     */   
/*     */   public void setWorkItemSerialNumber(String argWorkItemSerialNumber) {
/* 167 */     if (changed(argWorkItemSerialNumber, this._workItemSerialNumber, "workItemSerialNumber")) {
/* 168 */       this._workItemSerialNumber = argWorkItemSerialNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getVoid() {
/* 173 */     return this._void;
/*     */   }
/*     */   
/*     */   public void setVoid(Boolean argVoid) {
/* 177 */     if (changed(argVoid, this._void, "void")) {
/* 178 */       this._void = argVoid;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 185 */     StringBuilder buf = new StringBuilder(512);
/* 186 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 187 */     if (getOrganizationId() != null) {
/* 188 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 190 */     if (getCustAccountId() != null) {
/* 191 */       buf.append("custAccountId").append("=").append(getCustAccountId()).append(" ");
/*     */     }
/* 193 */     if (getCustAccountCode() != null) {
/* 194 */       buf.append("custAccountCode").append("=").append(getCustAccountCode()).append(" ");
/*     */     }
/* 196 */     if (getWorkItemSequence() != null) {
/* 197 */       buf.append("workItemSequence").append("=").append(getWorkItemSequence()).append(" ");
/*     */     }
/* 199 */     if (getCreateDate() != null) {
/* 200 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 202 */     if (getCreateUserId() != null) {
/* 203 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 205 */     if (getUpdateDate() != null) {
/* 206 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 208 */     if (getUpdateUserId() != null) {
/* 209 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 211 */     if (getItemId() != null) {
/* 212 */       buf.append("itemId").append("=").append(getItemId()).append(" ");
/*     */     }
/* 214 */     if (getDescription() != null) {
/* 215 */       buf.append("description").append("=").append(getDescription()).append(" ");
/*     */     }
/* 217 */     if (getValueAmount() != null) {
/* 218 */       buf.append("valueAmount").append("=").append(getValueAmount()).append(" ");
/*     */     }
/* 220 */     if (getWarrantyNumber() != null) {
/* 221 */       buf.append("warrantyNumber").append("=").append(getWarrantyNumber()).append(" ");
/*     */     }
/* 223 */     if (getWorkItemSerialNumber() != null) {
/* 224 */       buf.append("workItemSerialNumber").append("=").append(getWorkItemSerialNumber()).append(" ");
/*     */     }
/* 226 */     if (getVoid() != null && getVoid().booleanValue()) {
/* 227 */       buf.append("void").append("=").append(getVoid()).append(" ");
/*     */     }
/*     */     
/* 230 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 234 */     WorkItemId id = new WorkItemId();
/* 235 */     id.setOrganizationId(getOrganizationId());
/* 236 */     id.setCustAccountId(getCustAccountId());
/* 237 */     id.setCustAccountCode(getCustAccountCode());
/* 238 */     id.setWorkItemSequence(getWorkItemSequence());
/* 239 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 243 */     setOrganizationId(((WorkItemId)argObjectId).getOrganizationId());
/* 244 */     setCustAccountId(((WorkItemId)argObjectId).getCustAccountId());
/* 245 */     setCustAccountCode(((WorkItemId)argObjectId).getCustAccountCode());
/* 246 */     setWorkItemSequence(((WorkItemId)argObjectId).getWorkItemSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 250 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 254 */     StringBuilder buf = new StringBuilder(700);
/* 255 */     buf.append("<").append("dao").append(" name=\"WorkItem\" cmd=\"" + getObjectStateString() + "\">");
/* 256 */     getFieldsAsXml(buf);
/* 257 */     buf.append("</").append("dao").append(">");
/*     */     
/* 259 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 263 */     Map<String, String> values = super.getValues();
/* 264 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 265 */     if (this._custAccountId != null) values.put("CustAccountId", DaoUtils.getXmlSafeFieldValue(12, this._custAccountId)); 
/* 266 */     if (this._custAccountCode != null) values.put("CustAccountCode", DaoUtils.getXmlSafeFieldValue(12, this._custAccountCode)); 
/* 267 */     if (this._workItemSequence != null) values.put("WorkItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._workItemSequence)); 
/* 268 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 269 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 270 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 271 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 272 */     if (this._itemId != null) values.put("ItemId", DaoUtils.getXmlSafeFieldValue(12, this._itemId)); 
/* 273 */     if (this._description != null) values.put("Description", DaoUtils.getXmlSafeFieldValue(12, this._description)); 
/* 274 */     if (this._valueAmount != null) values.put("ValueAmount", DaoUtils.getXmlSafeFieldValue(3, this._valueAmount)); 
/* 275 */     if (this._warrantyNumber != null) values.put("WarrantyNumber", DaoUtils.getXmlSafeFieldValue(12, this._warrantyNumber)); 
/* 276 */     if (this._workItemSerialNumber != null) values.put("WorkItemSerialNumber", DaoUtils.getXmlSafeFieldValue(12, this._workItemSerialNumber)); 
/* 277 */     if (this._void != null) values.put("Void", DaoUtils.getXmlSafeFieldValue(-7, this._void)); 
/* 278 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 283 */     super.setValues(argValues);
/* 284 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 286 */       String fieldName = field.getKey();
/* 287 */       String fieldValue = field.getValue();
/* 288 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 292 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 293 */             setOrganizationId((Long)value);
/* 294 */           } catch (Exception ee) {
/* 295 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountId":
/*     */           try {
/* 301 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 302 */             setCustAccountId((String)value);
/* 303 */           } catch (Exception ee) {
/* 304 */             throw new DtxException("An exception occurred while calling setCustAccountId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CustAccountCode":
/*     */           try {
/* 310 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 311 */             setCustAccountCode((String)value);
/* 312 */           } catch (Exception ee) {
/* 313 */             throw new DtxException("An exception occurred while calling setCustAccountCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkItemSequence":
/*     */           try {
/* 319 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 320 */             setWorkItemSequence((Integer)value);
/* 321 */           } catch (Exception ee) {
/* 322 */             throw new DtxException("An exception occurred while calling setWorkItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 328 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 329 */             setCreateDate((Date)value);
/* 330 */           } catch (Exception ee) {
/* 331 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 337 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 338 */             setCreateUserId((String)value);
/* 339 */           } catch (Exception ee) {
/* 340 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 346 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 347 */             setUpdateDate((Date)value);
/* 348 */           } catch (Exception ee) {
/* 349 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 355 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 356 */             setUpdateUserId((String)value);
/* 357 */           } catch (Exception ee) {
/* 358 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemId":
/*     */           try {
/* 364 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 365 */             setItemId((String)value);
/* 366 */           } catch (Exception ee) {
/* 367 */             throw new DtxException("An exception occurred while calling setItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Description":
/*     */           try {
/* 373 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 374 */             setDescription((String)value);
/* 375 */           } catch (Exception ee) {
/* 376 */             throw new DtxException("An exception occurred while calling setDescription() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ValueAmount":
/*     */           try {
/* 382 */             Object value = DaoUtils.getFieldValueForXmlString(3, fieldValue);
/* 383 */             setValueAmount((BigDecimal)value);
/* 384 */           } catch (Exception ee) {
/* 385 */             throw new DtxException("An exception occurred while calling setValueAmount() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyNumber":
/*     */           try {
/* 391 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 392 */             setWarrantyNumber((String)value);
/* 393 */           } catch (Exception ee) {
/* 394 */             throw new DtxException("An exception occurred while calling setWarrantyNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkItemSerialNumber":
/*     */           try {
/* 400 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 401 */             setWorkItemSerialNumber((String)value);
/* 402 */           } catch (Exception ee) {
/* 403 */             throw new DtxException("An exception occurred while calling setWorkItemSerialNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Void":
/*     */           try {
/* 409 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 410 */             setVoid((Boolean)value);
/* 411 */           } catch (Exception ee) {
/* 412 */             throw new DtxException("An exception occurred while calling setVoid() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\impl\WorkItemDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */