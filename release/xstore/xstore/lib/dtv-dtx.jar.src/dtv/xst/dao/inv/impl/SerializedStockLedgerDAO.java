/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.SerializedStockLedgerId;
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
/*     */ public class SerializedStockLedgerDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 313200603L;
/*  23 */   private static final Logger _logger = Logger.getLogger(SerializedStockLedgerDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _invLocationId;
/*     */   private String _itemId;
/*     */   private String _serialNumber;
/*     */   private String _bucketId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
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
/*     */   public String getInvLocationId() {
/*  57 */     return this._invLocationId;
/*     */   }
/*     */   
/*     */   public void setInvLocationId(String argInvLocationId) {
/*  61 */     if (changed(argInvLocationId, this._invLocationId, "invLocationId")) {
/*  62 */       this._invLocationId = (argInvLocationId != null && MANAGE_CASE) ? argInvLocationId.toUpperCase() : argInvLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getItemId() {
/*  67 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  71 */     if (changed(argItemId, this._itemId, "itemId")) {
/*  72 */       this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSerialNumber() {
/*  77 */     return this._serialNumber;
/*     */   }
/*     */   
/*     */   public void setSerialNumber(String argSerialNumber) {
/*  81 */     if (changed(argSerialNumber, this._serialNumber, "serialNumber")) {
/*  82 */       this._serialNumber = (argSerialNumber != null && MANAGE_CASE) ? argSerialNumber.toUpperCase() : argSerialNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getBucketId() {
/*  87 */     return this._bucketId;
/*     */   }
/*     */   
/*     */   public void setBucketId(String argBucketId) {
/*  91 */     if (changed(argBucketId, this._bucketId, "bucketId")) {
/*  92 */       this._bucketId = (argBucketId != null && MANAGE_CASE) ? argBucketId.toUpperCase() : argBucketId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  97 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/* 101 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/* 102 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/* 108 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/* 112 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/* 113 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 118 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 122 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 123 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 129 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 133 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 134 */       this._updateUserId = argUpdateUserId;
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
/* 149 */     if (getInvLocationId() != null) {
/* 150 */       buf.append("invLocationId").append("=").append(getInvLocationId()).append(" ");
/*     */     }
/* 152 */     if (getItemId() != null) {
/* 153 */       buf.append("itemId").append("=").append(getItemId()).append(" ");
/*     */     }
/* 155 */     if (getSerialNumber() != null) {
/* 156 */       buf.append("serialNumber").append("=").append(getSerialNumber()).append(" ");
/*     */     }
/* 158 */     if (getBucketId() != null) {
/* 159 */       buf.append("bucketId").append("=").append(getBucketId()).append(" ");
/*     */     }
/* 161 */     if (getCreateDate() != null) {
/* 162 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 164 */     if (getCreateUserId() != null) {
/* 165 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 167 */     if (getUpdateDate() != null) {
/* 168 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 170 */     if (getUpdateUserId() != null) {
/* 171 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/*     */     
/* 174 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 178 */     SerializedStockLedgerId id = new SerializedStockLedgerId();
/* 179 */     id.setOrganizationId(getOrganizationId());
/* 180 */     id.setRetailLocationId(getRetailLocationId());
/* 181 */     id.setInvLocationId(getInvLocationId());
/* 182 */     id.setItemId(getItemId());
/* 183 */     id.setSerialNumber(getSerialNumber());
/* 184 */     id.setBucketId(getBucketId());
/* 185 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 189 */     setOrganizationId(((SerializedStockLedgerId)argObjectId).getOrganizationId());
/* 190 */     setRetailLocationId(((SerializedStockLedgerId)argObjectId).getRetailLocationId());
/* 191 */     setInvLocationId(((SerializedStockLedgerId)argObjectId).getInvLocationId());
/* 192 */     setItemId(((SerializedStockLedgerId)argObjectId).getItemId());
/* 193 */     setSerialNumber(((SerializedStockLedgerId)argObjectId).getSerialNumber());
/* 194 */     setBucketId(((SerializedStockLedgerId)argObjectId).getBucketId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 198 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 202 */     StringBuilder buf = new StringBuilder(500);
/* 203 */     buf.append("<").append("dao").append(" name=\"SerializedStockLedger\" cmd=\"" + getObjectStateString() + "\">");
/* 204 */     getFieldsAsXml(buf);
/* 205 */     buf.append("</").append("dao").append(">");
/*     */     
/* 207 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 211 */     Map<String, String> values = super.getValues();
/* 212 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 213 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 214 */     if (this._invLocationId != null) values.put("InvLocationId", DaoUtils.getXmlSafeFieldValue(12, this._invLocationId)); 
/* 215 */     if (this._itemId != null) values.put("ItemId", DaoUtils.getXmlSafeFieldValue(12, this._itemId)); 
/* 216 */     if (this._serialNumber != null) values.put("SerialNumber", DaoUtils.getXmlSafeFieldValue(12, this._serialNumber)); 
/* 217 */     if (this._bucketId != null) values.put("BucketId", DaoUtils.getXmlSafeFieldValue(12, this._bucketId)); 
/* 218 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 219 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 220 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 221 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 222 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 227 */     super.setValues(argValues);
/* 228 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 230 */       String fieldName = field.getKey();
/* 231 */       String fieldValue = field.getValue();
/* 232 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 236 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 237 */             setOrganizationId((Long)value);
/* 238 */           } catch (Exception ee) {
/* 239 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 245 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 246 */             setRetailLocationId((Long)value);
/* 247 */           } catch (Exception ee) {
/* 248 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InvLocationId":
/*     */           try {
/* 254 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 255 */             setInvLocationId((String)value);
/* 256 */           } catch (Exception ee) {
/* 257 */             throw new DtxException("An exception occurred while calling setInvLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ItemId":
/*     */           try {
/* 263 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 264 */             setItemId((String)value);
/* 265 */           } catch (Exception ee) {
/* 266 */             throw new DtxException("An exception occurred while calling setItemId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SerialNumber":
/*     */           try {
/* 272 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 273 */             setSerialNumber((String)value);
/* 274 */           } catch (Exception ee) {
/* 275 */             throw new DtxException("An exception occurred while calling setSerialNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BucketId":
/*     */           try {
/* 281 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 282 */             setBucketId((String)value);
/* 283 */           } catch (Exception ee) {
/* 284 */             throw new DtxException("An exception occurred while calling setBucketId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 290 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 291 */             setCreateDate((Date)value);
/* 292 */           } catch (Exception ee) {
/* 293 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 299 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 300 */             setCreateUserId((String)value);
/* 301 */           } catch (Exception ee) {
/* 302 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 308 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 309 */             setUpdateDate((Date)value);
/* 310 */           } catch (Exception ee) {
/* 311 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 317 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 318 */             setUpdateUserId((String)value);
/* 319 */           } catch (Exception ee) {
/* 320 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\SerializedStockLedgerDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */