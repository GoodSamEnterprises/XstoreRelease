/*     */ package dtv.xst.dao.cwo.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trl.impl.SaleReturnLineItemDAO;
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
/*     */ public class WorkOrderLineItemDAO
/*     */   extends SaleReturnLineItemDAO
/*     */ {
/*     */   private static final long serialVersionUID = -2040221980L;
/*  23 */   private static final Logger _logger = Logger.getLogger(WorkOrderLineItemDAO.class);
/*     */   
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _priceStatus;
/*     */   private String _instructions;
/*     */   
/*     */   public Date getCreateDate() {
/*  33 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  37 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  38 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  44 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  48 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  49 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  54 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  58 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  59 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  65 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  69 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  70 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPriceStatus() {
/*  75 */     return this._priceStatus;
/*     */   }
/*     */   
/*     */   public void setPriceStatus(String argPriceStatus) {
/*  79 */     if (changed(argPriceStatus, this._priceStatus, "priceStatus")) {
/*  80 */       this._priceStatus = argPriceStatus;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInstructions() {
/*  85 */     return this._instructions;
/*     */   }
/*     */   
/*     */   public void setInstructions(String argInstructions) {
/*  89 */     if (changed(argInstructions, this._instructions, "instructions")) {
/*  90 */       this._instructions = argInstructions;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder buf = new StringBuilder(512);
/*  98 */     buf.append(super.toString());
/*  99 */     if (getCreateDate() != null) {
/* 100 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 102 */     if (getCreateUserId() != null) {
/* 103 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 105 */     if (getUpdateDate() != null) {
/* 106 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 108 */     if (getUpdateUserId() != null) {
/* 109 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 111 */     if (getPriceStatus() != null) {
/* 112 */       buf.append("priceStatus").append("=").append(getPriceStatus()).append(" ");
/*     */     }
/* 114 */     if (getInstructions() != null) {
/* 115 */       buf.append("instructions").append("=").append(getInstructions()).append(" ");
/*     */     }
/*     */     
/* 118 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 123 */     StringBuilder buf = new StringBuilder(3950);
/* 124 */     buf.append("<").append("dao").append(" name=\"WorkOrderLineItem\" cmd=\"" + getObjectStateString() + "\">");
/* 125 */     getFieldsAsXml(buf);
/* 126 */     buf.append("</").append("dao").append(">");
/*     */     
/* 128 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 132 */     Map<String, String> values = super.getValues();
/* 133 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 134 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 135 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 136 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 137 */     if (this._priceStatus != null) values.put("PriceStatus", DaoUtils.getXmlSafeFieldValue(12, this._priceStatus)); 
/* 138 */     if (this._instructions != null) values.put("Instructions", DaoUtils.getXmlSafeFieldValue(12, this._instructions)); 
/* 139 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 144 */     super.setValues(argValues);
/* 145 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 147 */       String fieldName = field.getKey();
/* 148 */       String fieldValue = field.getValue();
/* 149 */       switch (fieldName) {
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 153 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 154 */             setCreateDate((Date)value);
/* 155 */           } catch (Exception ee) {
/* 156 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 162 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 163 */             setCreateUserId((String)value);
/* 164 */           } catch (Exception ee) {
/* 165 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 171 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 172 */             setUpdateDate((Date)value);
/* 173 */           } catch (Exception ee) {
/* 174 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 180 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 181 */             setUpdateUserId((String)value);
/* 182 */           } catch (Exception ee) {
/* 183 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PriceStatus":
/*     */           try {
/* 189 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 190 */             setPriceStatus((String)value);
/* 191 */           } catch (Exception ee) {
/* 192 */             throw new DtxException("An exception occurred while calling setPriceStatus() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Instructions":
/*     */           try {
/* 198 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 199 */             setInstructions((String)value);
/* 200 */           } catch (Exception ee) {
/* 201 */             throw new DtxException("An exception occurred while calling setInstructions() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cwo\impl\WorkOrderLineItemDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */