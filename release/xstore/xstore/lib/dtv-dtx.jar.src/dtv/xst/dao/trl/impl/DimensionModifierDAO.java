/*     */ package dtv.xst.dao.trl.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.DimensionModifierId;
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
/*     */ public class DimensionModifierDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -734966211L;
/*  23 */   private static final Logger _logger = Logger.getLogger(DimensionModifierDAO.class);
/*     */   
/*     */   private DtvDate _businessDate;
/*     */   private String _dimensionCode;
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Integer _retailTransactionLineItemSequence;
/*     */   private Long _transactionSequence;
/*     */   private Long _workstationId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _value;
/*     */   
/*     */   public Date getBusinessDate() {
/*  39 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  43 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  44 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDimensionCode() {
/*  50 */     return this._dimensionCode;
/*     */   }
/*     */   
/*     */   public void setDimensionCode(String argDimensionCode) {
/*  54 */     if (changed(argDimensionCode, this._dimensionCode, "dimensionCode")) {
/*  55 */       this._dimensionCode = (argDimensionCode != null && MANAGE_CASE) ? argDimensionCode.toUpperCase() : argDimensionCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getOrganizationId() {
/*  60 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  64 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  65 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  70 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  74 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  75 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getRetailTransactionLineItemSequence() {
/*  80 */     return this._retailTransactionLineItemSequence;
/*     */   }
/*     */   
/*     */   public void setRetailTransactionLineItemSequence(Integer argRetailTransactionLineItemSequence) {
/*  84 */     if (changed(argRetailTransactionLineItemSequence, this._retailTransactionLineItemSequence, "retailTransactionLineItemSequence")) {
/*  85 */       this._retailTransactionLineItemSequence = argRetailTransactionLineItemSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getTransactionSequence() {
/*  90 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  94 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/*  95 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getWorkstationId() {
/* 100 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/* 104 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/* 105 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/* 110 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 114 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 115 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 121 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 125 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 126 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 131 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 135 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 136 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 142 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 146 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 147 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getValue() {
/* 152 */     return this._value;
/*     */   }
/*     */   
/*     */   public void setValue(String argValue) {
/* 156 */     if (changed(argValue, this._value, "value")) {
/* 157 */       this._value = argValue;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 164 */     StringBuilder buf = new StringBuilder(512);
/* 165 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 166 */     if (getBusinessDate() != null) {
/* 167 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 169 */     if (getDimensionCode() != null) {
/* 170 */       buf.append("dimensionCode").append("=").append(getDimensionCode()).append(" ");
/*     */     }
/* 172 */     if (getOrganizationId() != null) {
/* 173 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 175 */     if (getRetailLocationId() != null) {
/* 176 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 178 */     if (getRetailTransactionLineItemSequence() != null) {
/* 179 */       buf.append("retailTransactionLineItemSequence").append("=").append(getRetailTransactionLineItemSequence()).append(" ");
/*     */     }
/* 181 */     if (getTransactionSequence() != null) {
/* 182 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 184 */     if (getWorkstationId() != null) {
/* 185 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 187 */     if (getCreateDate() != null) {
/* 188 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 190 */     if (getCreateUserId() != null) {
/* 191 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 193 */     if (getUpdateDate() != null) {
/* 194 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 196 */     if (getUpdateUserId() != null) {
/* 197 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 199 */     if (getValue() != null) {
/* 200 */       buf.append("value").append("=").append(getValue()).append(" ");
/*     */     }
/*     */     
/* 203 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 207 */     DimensionModifierId id = new DimensionModifierId();
/* 208 */     id.setBusinessDate(getBusinessDate());
/* 209 */     id.setDimensionCode(getDimensionCode());
/* 210 */     id.setOrganizationId(getOrganizationId());
/* 211 */     id.setRetailLocationId(getRetailLocationId());
/* 212 */     id.setRetailTransactionLineItemSequence(getRetailTransactionLineItemSequence());
/* 213 */     id.setTransactionSequence(getTransactionSequence());
/* 214 */     id.setWorkstationId(getWorkstationId());
/* 215 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 219 */     setBusinessDate(((DimensionModifierId)argObjectId).getBusinessDate());
/* 220 */     setDimensionCode(((DimensionModifierId)argObjectId).getDimensionCode());
/* 221 */     setOrganizationId(((DimensionModifierId)argObjectId).getOrganizationId());
/* 222 */     setRetailLocationId(((DimensionModifierId)argObjectId).getRetailLocationId());
/* 223 */     setRetailTransactionLineItemSequence(((DimensionModifierId)argObjectId).getRetailTransactionLineItemSequence());
/* 224 */     setTransactionSequence(((DimensionModifierId)argObjectId).getTransactionSequence());
/* 225 */     setWorkstationId(((DimensionModifierId)argObjectId).getWorkstationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 229 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 233 */     StringBuilder buf = new StringBuilder(600);
/* 234 */     buf.append("<").append("dao").append(" name=\"DimensionModifier\" cmd=\"" + getObjectStateString() + "\">");
/* 235 */     getFieldsAsXml(buf);
/* 236 */     buf.append("</").append("dao").append(">");
/*     */     
/* 238 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 242 */     Map<String, String> values = super.getValues();
/* 243 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 244 */     if (this._dimensionCode != null) values.put("DimensionCode", DaoUtils.getXmlSafeFieldValue(12, this._dimensionCode)); 
/* 245 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 246 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 247 */     if (this._retailTransactionLineItemSequence != null) values.put("RetailTransactionLineItemSequence", DaoUtils.getXmlSafeFieldValue(4, this._retailTransactionLineItemSequence)); 
/* 248 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 249 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 250 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 251 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 252 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 253 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 254 */     if (this._value != null) values.put("Value", DaoUtils.getXmlSafeFieldValue(12, this._value)); 
/* 255 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 260 */     super.setValues(argValues);
/* 261 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 263 */       String fieldName = field.getKey();
/* 264 */       String fieldValue = field.getValue();
/* 265 */       switch (fieldName) {
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 269 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 270 */             setBusinessDate((Date)value);
/* 271 */           } catch (Exception ee) {
/* 272 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DimensionCode":
/*     */           try {
/* 278 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 279 */             setDimensionCode((String)value);
/* 280 */           } catch (Exception ee) {
/* 281 */             throw new DtxException("An exception occurred while calling setDimensionCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 287 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 288 */             setOrganizationId((Long)value);
/* 289 */           } catch (Exception ee) {
/* 290 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 296 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 297 */             setRetailLocationId((Long)value);
/* 298 */           } catch (Exception ee) {
/* 299 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailTransactionLineItemSequence":
/*     */           try {
/* 305 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 306 */             setRetailTransactionLineItemSequence((Integer)value);
/* 307 */           } catch (Exception ee) {
/* 308 */             throw new DtxException("An exception occurred while calling setRetailTransactionLineItemSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 314 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 315 */             setTransactionSequence((Long)value);
/* 316 */           } catch (Exception ee) {
/* 317 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 323 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 324 */             setWorkstationId((Long)value);
/* 325 */           } catch (Exception ee) {
/* 326 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 332 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 333 */             setCreateDate((Date)value);
/* 334 */           } catch (Exception ee) {
/* 335 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 341 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 342 */             setCreateUserId((String)value);
/* 343 */           } catch (Exception ee) {
/* 344 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 350 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 351 */             setUpdateDate((Date)value);
/* 352 */           } catch (Exception ee) {
/* 353 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 359 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 360 */             setUpdateUserId((String)value);
/* 361 */           } catch (Exception ee) {
/* 362 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Value":
/*     */           try {
/* 368 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 369 */             setValue((String)value);
/* 370 */           } catch (Exception ee) {
/* 371 */             throw new DtxException("An exception occurred while calling setValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\impl\DimensionModifierDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */