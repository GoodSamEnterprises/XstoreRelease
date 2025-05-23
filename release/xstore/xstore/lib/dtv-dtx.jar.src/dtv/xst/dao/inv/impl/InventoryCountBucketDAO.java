/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryCountBucketId;
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
/*     */ public class InventoryCountBucketDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 8376573L;
/*  23 */   private static final Logger _logger = Logger.getLogger(InventoryCountBucketDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _inventoryCountId;
/*     */   private String _inventoryBucketId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private Integer _countCycle;
/*     */   private String _bucketStatus;
/*     */   private String _inventoryBucketName;
/*     */   
/*     */   public Long getOrganizationId() {
/*  38 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  42 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  43 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  48 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  52 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  53 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInventoryCountId() {
/*  58 */     return this._inventoryCountId;
/*     */   }
/*     */   
/*     */   public void setInventoryCountId(String argInventoryCountId) {
/*  62 */     if (changed(argInventoryCountId, this._inventoryCountId, "inventoryCountId")) {
/*  63 */       this._inventoryCountId = (argInventoryCountId != null && MANAGE_CASE) ? argInventoryCountId.toUpperCase() : argInventoryCountId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInventoryBucketId() {
/*  68 */     return this._inventoryBucketId;
/*     */   }
/*     */   
/*     */   public void setInventoryBucketId(String argInventoryBucketId) {
/*  72 */     if (changed(argInventoryBucketId, this._inventoryBucketId, "inventoryBucketId")) {
/*  73 */       this._inventoryBucketId = (argInventoryBucketId != null && MANAGE_CASE) ? argInventoryBucketId.toUpperCase() : argInventoryBucketId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  78 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  82 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  83 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  89 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  93 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  94 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  99 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 103 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 104 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 110 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 114 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 115 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getCountCycle() {
/* 120 */     return this._countCycle;
/*     */   }
/*     */   
/*     */   public void setCountCycle(Integer argCountCycle) {
/* 124 */     if (changed(argCountCycle, this._countCycle, "countCycle")) {
/* 125 */       this._countCycle = argCountCycle;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getBucketStatus() {
/* 130 */     return this._bucketStatus;
/*     */   }
/*     */   
/*     */   public void setBucketStatus(String argBucketStatus) {
/* 134 */     if (changed(argBucketStatus, this._bucketStatus, "bucketStatus")) {
/* 135 */       this._bucketStatus = argBucketStatus;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getInventoryBucketName() {
/* 140 */     return this._inventoryBucketName;
/*     */   }
/*     */   
/*     */   public void setInventoryBucketName(String argInventoryBucketName) {
/* 144 */     if (changed(argInventoryBucketName, this._inventoryBucketName, "inventoryBucketName")) {
/* 145 */       this._inventoryBucketName = argInventoryBucketName;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 152 */     StringBuilder buf = new StringBuilder(512);
/* 153 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 154 */     if (getOrganizationId() != null) {
/* 155 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 157 */     if (getRetailLocationId() != null) {
/* 158 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 160 */     if (getInventoryCountId() != null) {
/* 161 */       buf.append("inventoryCountId").append("=").append(getInventoryCountId()).append(" ");
/*     */     }
/* 163 */     if (getInventoryBucketId() != null) {
/* 164 */       buf.append("inventoryBucketId").append("=").append(getInventoryBucketId()).append(" ");
/*     */     }
/* 166 */     if (getCreateDate() != null) {
/* 167 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 169 */     if (getCreateUserId() != null) {
/* 170 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 172 */     if (getUpdateDate() != null) {
/* 173 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 175 */     if (getUpdateUserId() != null) {
/* 176 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 178 */     if (getCountCycle() != null) {
/* 179 */       buf.append("countCycle").append("=").append(getCountCycle()).append(" ");
/*     */     }
/* 181 */     if (getBucketStatus() != null) {
/* 182 */       buf.append("bucketStatus").append("=").append(getBucketStatus()).append(" ");
/*     */     }
/* 184 */     if (getInventoryBucketName() != null) {
/* 185 */       buf.append("inventoryBucketName").append("=").append(getInventoryBucketName()).append(" ");
/*     */     }
/*     */     
/* 188 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 192 */     InventoryCountBucketId id = new InventoryCountBucketId();
/* 193 */     id.setOrganizationId(getOrganizationId());
/* 194 */     id.setRetailLocationId(getRetailLocationId());
/* 195 */     id.setInventoryCountId(getInventoryCountId());
/* 196 */     id.setInventoryBucketId(getInventoryBucketId());
/* 197 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 201 */     setOrganizationId(((InventoryCountBucketId)argObjectId).getOrganizationId());
/* 202 */     setRetailLocationId(((InventoryCountBucketId)argObjectId).getRetailLocationId());
/* 203 */     setInventoryCountId(((InventoryCountBucketId)argObjectId).getInventoryCountId());
/* 204 */     setInventoryBucketId(((InventoryCountBucketId)argObjectId).getInventoryBucketId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 208 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 212 */     StringBuilder buf = new StringBuilder(550);
/* 213 */     buf.append("<").append("dao").append(" name=\"InventoryCountBucket\" cmd=\"" + getObjectStateString() + "\">");
/* 214 */     getFieldsAsXml(buf);
/* 215 */     buf.append("</").append("dao").append(">");
/*     */     
/* 217 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 221 */     Map<String, String> values = super.getValues();
/* 222 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 223 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 224 */     if (this._inventoryCountId != null) values.put("InventoryCountId", DaoUtils.getXmlSafeFieldValue(12, this._inventoryCountId)); 
/* 225 */     if (this._inventoryBucketId != null) values.put("InventoryBucketId", DaoUtils.getXmlSafeFieldValue(12, this._inventoryBucketId)); 
/* 226 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 227 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 228 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 229 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 230 */     if (this._countCycle != null) values.put("CountCycle", DaoUtils.getXmlSafeFieldValue(4, this._countCycle)); 
/* 231 */     if (this._bucketStatus != null) values.put("BucketStatus", DaoUtils.getXmlSafeFieldValue(12, this._bucketStatus)); 
/* 232 */     if (this._inventoryBucketName != null) values.put("InventoryBucketName", DaoUtils.getXmlSafeFieldValue(12, this._inventoryBucketName)); 
/* 233 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 238 */     super.setValues(argValues);
/* 239 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 241 */       String fieldName = field.getKey();
/* 242 */       String fieldValue = field.getValue();
/* 243 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 247 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 248 */             setOrganizationId((Long)value);
/* 249 */           } catch (Exception ee) {
/* 250 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 256 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 257 */             setRetailLocationId((Long)value);
/* 258 */           } catch (Exception ee) {
/* 259 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryCountId":
/*     */           try {
/* 265 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 266 */             setInventoryCountId((String)value);
/* 267 */           } catch (Exception ee) {
/* 268 */             throw new DtxException("An exception occurred while calling setInventoryCountId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryBucketId":
/*     */           try {
/* 274 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 275 */             setInventoryBucketId((String)value);
/* 276 */           } catch (Exception ee) {
/* 277 */             throw new DtxException("An exception occurred while calling setInventoryBucketId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 283 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 284 */             setCreateDate((Date)value);
/* 285 */           } catch (Exception ee) {
/* 286 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 292 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 293 */             setCreateUserId((String)value);
/* 294 */           } catch (Exception ee) {
/* 295 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 301 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 302 */             setUpdateDate((Date)value);
/* 303 */           } catch (Exception ee) {
/* 304 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 310 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 311 */             setUpdateUserId((String)value);
/* 312 */           } catch (Exception ee) {
/* 313 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CountCycle":
/*     */           try {
/* 319 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 320 */             setCountCycle((Integer)value);
/* 321 */           } catch (Exception ee) {
/* 322 */             throw new DtxException("An exception occurred while calling setCountCycle() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BucketStatus":
/*     */           try {
/* 328 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 329 */             setBucketStatus((String)value);
/* 330 */           } catch (Exception ee) {
/* 331 */             throw new DtxException("An exception occurred while calling setBucketStatus() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "InventoryBucketName":
/*     */           try {
/* 337 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 338 */             setInventoryBucketName((String)value);
/* 339 */           } catch (Exception ee) {
/* 340 */             throw new DtxException("An exception occurred while calling setInventoryBucketName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryCountBucketDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */