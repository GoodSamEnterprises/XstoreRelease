/*     */ package dtv.xst.dao.trn.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
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
/*     */ 
/*     */ public class GiftRegistryTransactionDAO
/*     */   extends PosTransactionDAO
/*     */ {
/*     */   private static final long serialVersionUID = -1801815311L;
/*  23 */   private static final Logger _logger = Logger.getLogger(GiftRegistryTransactionDAO.class);
/*     */   
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private Long _registryId;
/*     */   
/*     */   public Date getCreateDate() {
/*  32 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  36 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  37 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  43 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  47 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  48 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  53 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  57 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  58 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  64 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  68 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  69 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRegistryId() {
/*  74 */     return this._registryId;
/*     */   }
/*     */   
/*     */   public void setRegistryId(Long argRegistryId) {
/*  78 */     if (changed(argRegistryId, this._registryId, "registryId")) {
/*  79 */       this._registryId = argRegistryId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  86 */     StringBuilder buf = new StringBuilder(512);
/*  87 */     buf.append(super.toString());
/*  88 */     if (getCreateDate() != null) {
/*  89 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/*  91 */     if (getCreateUserId() != null) {
/*  92 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/*  94 */     if (getUpdateDate() != null) {
/*  95 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/*  97 */     if (getUpdateUserId() != null) {
/*  98 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 100 */     if (getRegistryId() != null) {
/* 101 */       buf.append("registryId").append("=").append(getRegistryId()).append(" ");
/*     */     }
/*     */     
/* 104 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 109 */     StringBuilder buf = new StringBuilder(1700);
/* 110 */     buf.append("<").append("dao").append(" name=\"GiftRegistryTransaction\" cmd=\"" + getObjectStateString() + "\">");
/* 111 */     getFieldsAsXml(buf);
/* 112 */     buf.append("</").append("dao").append(">");
/*     */     
/* 114 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 118 */     Map<String, String> values = super.getValues();
/* 119 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 120 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 121 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 122 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 123 */     if (this._registryId != null) values.put("RegistryId", DaoUtils.getXmlSafeFieldValue(-5, this._registryId)); 
/* 124 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 129 */     super.setValues(argValues);
/* 130 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 132 */       String fieldName = field.getKey();
/* 133 */       String fieldValue = field.getValue();
/* 134 */       switch (fieldName) {
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 138 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 139 */             setCreateDate((Date)value);
/* 140 */           } catch (Exception ee) {
/* 141 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 147 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 148 */             setCreateUserId((String)value);
/* 149 */           } catch (Exception ee) {
/* 150 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 156 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 157 */             setUpdateDate((Date)value);
/* 158 */           } catch (Exception ee) {
/* 159 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 165 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 166 */             setUpdateUserId((String)value);
/* 167 */           } catch (Exception ee) {
/* 168 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RegistryId":
/*     */           try {
/* 174 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 175 */             setRegistryId((Long)value);
/* 176 */           } catch (Exception ee) {
/* 177 */             throw new DtxException("An exception occurred while calling setRegistryId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trn\impl\GiftRegistryTransactionDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */