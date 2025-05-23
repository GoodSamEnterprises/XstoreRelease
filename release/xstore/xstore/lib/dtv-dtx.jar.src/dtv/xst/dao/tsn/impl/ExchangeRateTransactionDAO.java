/*     */ package dtv.xst.dao.tsn.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.trn.impl.PosTransactionDAO;
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
/*     */ public class ExchangeRateTransactionDAO
/*     */   extends PosTransactionDAO
/*     */ {
/*     */   private static final long serialVersionUID = 988281115L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ExchangeRateTransactionDAO.class);
/*     */   
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   
/*     */   public Date getCreateDate() {
/*  31 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  35 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  36 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  42 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  46 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  47 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  52 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  56 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  57 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  63 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  67 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  68 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  75 */     StringBuilder buf = new StringBuilder(512);
/*  76 */     buf.append(super.toString());
/*  77 */     if (getCreateDate() != null) {
/*  78 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/*  80 */     if (getCreateUserId() != null) {
/*  81 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/*  83 */     if (getUpdateDate() != null) {
/*  84 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/*  86 */     if (getUpdateUserId() != null) {
/*  87 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/*     */     
/*  90 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/*  95 */     StringBuilder buf = new StringBuilder(1650);
/*  96 */     buf.append("<").append("dao").append(" name=\"ExchangeRateTransaction\" cmd=\"" + getObjectStateString() + "\">");
/*  97 */     getFieldsAsXml(buf);
/*  98 */     buf.append("</").append("dao").append(">");
/*     */     
/* 100 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 104 */     Map<String, String> values = super.getValues();
/* 105 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 106 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 107 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 108 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 109 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 114 */     super.setValues(argValues);
/* 115 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 117 */       String fieldName = field.getKey();
/* 118 */       String fieldValue = field.getValue();
/* 119 */       switch (fieldName) {
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 123 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 124 */             setCreateDate((Date)value);
/* 125 */           } catch (Exception ee) {
/* 126 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 132 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 133 */             setCreateUserId((String)value);
/* 134 */           } catch (Exception ee) {
/* 135 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 141 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 142 */             setUpdateDate((Date)value);
/* 143 */           } catch (Exception ee) {
/* 144 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 150 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 151 */             setUpdateUserId((String)value);
/* 152 */           } catch (Exception ee) {
/* 153 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\impl\ExchangeRateTransactionDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */