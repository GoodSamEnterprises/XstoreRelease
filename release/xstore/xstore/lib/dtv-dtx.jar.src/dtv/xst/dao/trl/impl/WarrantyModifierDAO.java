/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.WarrantyModifierId;
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
/*     */ public class WarrantyModifierDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 154202131L;
/*  23 */   private static final Logger _logger = Logger.getLogger(WarrantyModifierDAO.class);
/*     */   
/*     */   private DtvDate _businessDate;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private Integer _warrantyModifierSequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _warrantyNbr;
/*     */   private String _warrantyTypeCode;
/*     */   
/*     */   public Date getBusinessDate() {
/*  40 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  44 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  45 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getOrganizationId() {
/*  51 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  55 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  56 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  61 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  65 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  66 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getRetailTransactionLineItemSequence() {
/*  71 */     return this._retailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(Integer argRetailTransactionLineItemSequence) {
/*  75 */     if (changed(argRetailTransactionLineItemSequence, this._retailTransactionLineItemSequence, "retailTransactionLineItemSequence")) {
/*  76 */       this._retailTransactionLineItemSequence = argRetailTransactionLineItemSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/*  81 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  85 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/*  86 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/*  91 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  95 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/*  96 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getWarrantyModifierSequence() {
/* 101 */     return this._warrantyModifierSequence;
/*     */   }
/*     */   
/*     */   public void setWarrantyModifierSequence(Integer argWarrantyModifierSequence) {
/* 105 */     if (changed(argWarrantyModifierSequence, this._warrantyModifierSequence, "warrantyModifierSequence")) {
/* 106 */       this._warrantyModifierSequence = argWarrantyModifierSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 111 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 115 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 116 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 122 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 126 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 127 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 132 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 136 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 137 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 143 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 147 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 148 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getWarrantyNbr() {
/* 153 */     return this._warrantyNbr;
/*     */   }
/*     */   
/*     */   public void setWarrantyNbr(String argWarrantyNbr) {
/* 157 */     if (changed(argWarrantyNbr, this._warrantyNbr, "warrantyNbr")) {
/* 158 */       this._warrantyNbr = argWarrantyNbr;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getWarrantyTypeCode() {
/* 163 */     return this._warrantyTypeCode;
/*     */   }
/*     */   
/*     */   public void setWarrantyTypeCode(String argWarrantyTypeCode) {
/* 167 */     if (changed(argWarrantyTypeCode, this._warrantyTypeCode, "warrantyTypeCode")) {
/* 168 */       this._warrantyTypeCode = argWarrantyTypeCode;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 175 */     StringBuilder buf = new StringBuilder(512);
/* 176 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 177 */     if (getBusinessDate() != null) {
/* 178 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 180 */     if (getOrganizationId() != null) {
/* 181 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 183 */     if (getRetailLocationId() != null) {
/* 184 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 186 */     if (getRetailTransactionLineItemSequence() != null) {
/* 187 */       buf.append("retailTransactionLineItemSequence").append("=").append(getRetailTransactionLineItemSequence()).append(" ");
/*     */     }
/* 189 */     if (getTransactionSequence() != null) {
/* 190 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 192 */     if (getWorkstationId() != null) {
/* 193 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 195 */     if (getWarrantyModifierSequence() != null) {
/* 196 */       buf.append("warrantyModifierSequence").append("=").append(getWarrantyModifierSequence()).append(" ");
/*     */     }
/* 198 */     if (getCreateDate() != null) {
/* 199 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 201 */     if (getCreateUserId() != null) {
/* 202 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 204 */     if (getUpdateDate() != null) {
/* 205 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 207 */     if (getUpdateUserId() != null) {
/* 208 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 210 */     if (getWarrantyNbr() != null) {
/* 211 */       buf.append("warrantyNbr").append("=").append(getWarrantyNbr()).append(" ");
/*     */     }
/* 213 */     if (getWarrantyTypeCode() != null) {
/* 214 */       buf.append("warrantyTypeCode").append("=").append(getWarrantyTypeCode()).append(" ");
/*     */     }
/*     */     
/* 217 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 221 */     WarrantyModifierId id = new WarrantyModifierId();
/* 222 */     id.setBusinessDate(getBusinessDate());
/* 223 */     id.setOrganizationId(getOrganizationId());
/* 224 */     id.setRetailLocationId(getRetailLocationId());
/* 225 */     id.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 226 */     id.setTransactionSequence(getTransactionSequence());
/* 227 */     id.setWorkstationId(getWorkstationId());
/* 228 */     id.setWarrantyModifierSequence(getWarrantyModifierSequence());
/* 229 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 233 */     setBusinessDate(((WarrantyModifierId)argObjectId).getBusinessDate());
/* 234 */     setOrganizationId(((WarrantyModifierId)argObjectId).getOrganizationId());
/* 235 */     setRetailLocationId(((WarrantyModifierId)argObjectId).getRetailLocationId());
/* 236 */     setRetailTransactionLineItemSequence(((WarrantyModifierId)argObjectId).getRetailTransactionLineItemSequence());
/* 237 */     setTransactionSequence(((WarrantyModifierId)argObjectId).getTransactionSequence());
/* 238 */     setWorkstationId(((WarrantyModifierId)argObjectId).getWorkstationId());
/* 239 */     setWarrantyModifierSequence(((WarrantyModifierId)argObjectId).getWarrantyModifierSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 243 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 247 */     StringBuilder buf = new StringBuilder(650);
/* 248 */     buf.append("<").append("dao").append(" name=\"WarrantyModifier\" cmd=\"" + getObjectStateString() + "\">");
/* 249 */     getFieldsAsXml(buf);
/* 250 */     buf.append("</").append("dao").append(">");
/*     */     
/* 252 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 256 */     Map<String, String> values = super.getValues();
/* 257 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 258 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 259 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 260 */     if (this._retailTransactionLineItemSequence != null) values.put("RetailTransactionLineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._retailTransactionLineItemSequence)); 
/* 261 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 262 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 263 */     if (this._warrantyModifierSequence != null) values.put("WarrantyModifierSequence", DaoUtils.getXmlSafeFieldValue(4, this._warrantyModifierSequence)); 
/* 264 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 265 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 266 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 267 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 268 */     if (this._warrantyNbr != null) values.put("WarrantyNbr", DaoUtils.getXmlSafeFieldValue(12, this._warrantyNbr)); 
/* 269 */     if (this._warrantyTypeCode != null) values.put("WarrantyTypeCode", DaoUtils.getXmlSafeFieldValue(12, this._warrantyTypeCode)); 
/* 270 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 275 */     super.setValues(argValues);
/* 276 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 278 */       String fieldName = field.getKey();
/* 279 */       String fieldValue = field.getValue();
/* 280 */       switch (fieldName) {
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 284 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 285 */             setBusinessDate((Date)value);
/* 286 */           } catch (Exception ee) {
/* 287 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 293 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 294 */             setOrganizationId((Long)value);
/* 295 */           } catch (Exception ee) {
/* 296 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 302 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 303 */             setRetailLocationId((Long)value);
/* 304 */           } catch (Exception ee) {
/* 305 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailTransactionLineItemSequence":
/*     */           try {
/* 311 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 312 */             setRetailTransactionLineItemSequence((Integer)value);
/* 313 */           } catch (Exception ee) {
/* 314 */             throw new DtxException("An exception occurred while calling setRetailTransactionLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 320 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 321 */             setTransactionSequence((Long)value);
/* 322 */           } catch (Exception ee) {
/* 323 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 329 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 330 */             setWorkstationId((Long)value);
/* 331 */           } catch (Exception ee) {
/* 332 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyModifierSequence":
/*     */           try {
/* 338 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 339 */             setWarrantyModifierSequence((Integer)value);
/* 340 */           } catch (Exception ee) {
/* 341 */             throw new DtxException("An exception occurred while calling setWarrantyModifierSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 347 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 348 */             setCreateDate((Date)value);
/* 349 */           } catch (Exception ee) {
/* 350 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 356 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 357 */             setCreateUserId((String)value);
/* 358 */           } catch (Exception ee) {
/* 359 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 365 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 366 */             setUpdateDate((Date)value);
/* 367 */           } catch (Exception ee) {
/* 368 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 374 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 375 */             setUpdateUserId((String)value);
/* 376 */           } catch (Exception ee) {
/* 377 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyNbr":
/*     */           try {
/* 383 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 384 */             setWarrantyNbr((String)value);
/* 385 */           } catch (Exception ee) {
/* 386 */             throw new DtxException("An exception occurred while calling setWarrantyNbr() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WarrantyTypeCode":
/*     */           try {
/* 392 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 393 */             setWarrantyTypeCode((String)value);
/* 394 */           } catch (Exception ee) {
/* 395 */             throw new DtxException("An exception occurred while calling setWarrantyTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\WarrantyModifierDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */