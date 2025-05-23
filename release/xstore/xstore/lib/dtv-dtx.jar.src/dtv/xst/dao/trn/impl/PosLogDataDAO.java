/*     */ package dtv.xst.dao.trn.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.PosLogDataId;
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
/*     */ public class PosLogDataDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1034551238L;
/*  23 */   private static final Logger _logger = Logger.getLogger(PosLogDataDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private Long _workstationId;
/*     */   private DtvDate _businessDate;
/*     */   private Long _transactionSequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _poslogData;
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
/*     */   public Long getWorkstationId() {
/*  57 */     return this._workstationId;
/*     */   }
/*     */   
/*     */   public void setWorkstationId(Long argWorkstationId) {
/*  61 */     if (changed(argWorkstationId, this._workstationId, "workstationId")) {
/*  62 */       this._workstationId = argWorkstationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getBusinessDate() {
/*  67 */     return (Date)this._businessDate;
/*     */   }
/*     */   
/*     */   public void setBusinessDate(Date argBusinessDate) {
/*  71 */     if (changed(argBusinessDate, this._businessDate, "businessDate")) {
/*  72 */       this._businessDate = (argBusinessDate == null || argBusinessDate instanceof DtvDate) ? (DtvDate)argBusinessDate : new DtvDate(argBusinessDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Long getTransactionSequence() {
/*  78 */     return this._transactionSequence;
/*     */   }
/*     */   
/*     */   public void setTransactionSequence(Long argTransactionSequence) {
/*  82 */     if (changed(argTransactionSequence, this._transactionSequence, "transactionSequence")) {
/*  83 */       this._transactionSequence = argTransactionSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  88 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  92 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  93 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  99 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 103 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 104 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 109 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 113 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 114 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 120 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 124 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 125 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPoslogData() {
/* 130 */     return this._poslogData;
/*     */   }
/*     */   
/*     */   public void setPoslogData(String argPoslogData) {
/* 134 */     if (changed(argPoslogData, this._poslogData, "poslogData")) {
/* 135 */       this._poslogData = argPoslogData;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 142 */     StringBuilder buf = new StringBuilder(512);
/* 143 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 144 */     if (getOrganizationId() != null) {
/* 145 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 147 */     if (getRetailLocationId() != null) {
/* 148 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 150 */     if (getWorkstationId() != null) {
/* 151 */       buf.append("workstationId").append("=").append(getWorkstationId()).append(" ");
/*     */     }
/* 153 */     if (getBusinessDate() != null) {
/* 154 */       buf.append("businessDate").append("=").append(getBusinessDate()).append(" ");
/*     */     }
/* 156 */     if (getTransactionSequence() != null) {
/* 157 */       buf.append("transactionSequence").append("=").append(getTransactionSequence()).append(" ");
/*     */     }
/* 159 */     if (getCreateDate() != null) {
/* 160 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 162 */     if (getCreateUserId() != null) {
/* 163 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 165 */     if (getUpdateDate() != null) {
/* 166 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 168 */     if (getUpdateUserId() != null) {
/* 169 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 171 */     if (getPoslogData() != null) {
/* 172 */       buf.append("poslogData").append("=").append(getPoslogData()).append(" ");
/*     */     }
/*     */     
/* 175 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 179 */     PosLogDataId id = new PosLogDataId();
/* 180 */     id.setOrganizationId(getOrganizationId());
/* 181 */     id.setRetailLocationId(getRetailLocationId());
/* 182 */     id.setWorkstationId(getWorkstationId());
/* 183 */     id.setBusinessDate(getBusinessDate());
/* 184 */     id.setTransactionSequence(getTransactionSequence());
/* 185 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 189 */     setOrganizationId(((PosLogDataId)argObjectId).getOrganizationId());
/* 190 */     setRetailLocationId(((PosLogDataId)argObjectId).getRetailLocationId());
/* 191 */     setWorkstationId(((PosLogDataId)argObjectId).getWorkstationId());
/* 192 */     setBusinessDate(((PosLogDataId)argObjectId).getBusinessDate());
/* 193 */     setTransactionSequence(((PosLogDataId)argObjectId).getTransactionSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 197 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 201 */     StringBuilder buf = new StringBuilder(500);
/* 202 */     buf.append("<").append("dao").append(" name=\"PosLogData\" cmd=\"" + getObjectStateString() + "\">");
/* 203 */     getFieldsAsXml(buf);
/* 204 */     buf.append("</").append("dao").append(">");
/*     */     
/* 206 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 210 */     Map<String, String> values = super.getValues();
/* 211 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 212 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 213 */     if (this._workstationId != null) values.put("WorkstationId", DaoUtils.getXmlSafeFieldValue(-5, this._workstationId)); 
/* 214 */     if (this._businessDate != null) values.put("BusinessDate", DaoUtils.getXmlSafeFieldValue(91, this._businessDate)); 
/* 215 */     if (this._transactionSequence != null) values.put("TransactionSequence", DaoUtils.getXmlSafeFieldValue(-5, this._transactionSequence)); 
/* 216 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 217 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 218 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 219 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 220 */     if (this._poslogData != null) values.put("PoslogData", DaoUtils.getXmlSafeFieldValue(2005, this._poslogData)); 
/* 221 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 226 */     super.setValues(argValues);
/* 227 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 229 */       String fieldName = field.getKey();
/* 230 */       String fieldValue = field.getValue();
/* 231 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 235 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 236 */             setOrganizationId((Long)value);
/* 237 */           } catch (Exception ee) {
/* 238 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 244 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 245 */             setRetailLocationId((Long)value);
/* 246 */           } catch (Exception ee) {
/* 247 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "WorkstationId":
/*     */           try {
/* 253 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 254 */             setWorkstationId((Long)value);
/* 255 */           } catch (Exception ee) {
/* 256 */             throw new DtxException("An exception occurred while calling setWorkstationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BusinessDate":
/*     */           try {
/* 262 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 263 */             setBusinessDate((Date)value);
/* 264 */           } catch (Exception ee) {
/* 265 */             throw new DtxException("An exception occurred while calling setBusinessDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TransactionSequence":
/*     */           try {
/* 271 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 272 */             setTransactionSequence((Long)value);
/* 273 */           } catch (Exception ee) {
/* 274 */             throw new DtxException("An exception occurred while calling setTransactionSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 280 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 281 */             setCreateDate((Date)value);
/* 282 */           } catch (Exception ee) {
/* 283 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 289 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 290 */             setCreateUserId((String)value);
/* 291 */           } catch (Exception ee) {
/* 292 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 298 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 299 */             setUpdateDate((Date)value);
/* 300 */           } catch (Exception ee) {
/* 301 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 307 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 308 */             setUpdateUserId((String)value);
/* 309 */           } catch (Exception ee) {
/* 310 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PoslogData":
/*     */           try {
/* 316 */             Object value = DaoUtils.getFieldValueForXmlString(2005, fieldValue);
/* 317 */             setPoslogData((String)value);
/* 318 */           } catch (Exception ee) {
/* 319 */             throw new DtxException("An exception occurred while calling setPoslogData() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\PosLogDataDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */