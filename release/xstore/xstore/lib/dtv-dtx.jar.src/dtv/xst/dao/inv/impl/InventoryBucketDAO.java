/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryBucketId;
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
/*     */ public class InventoryBucketDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1441305158L;
/*  23 */   private static final Logger _logger = Logger.getLogger(InventoryBucketDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _bucketId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _name;
/*     */   private String _functionCode;
/*     */   private String _adjustmentAction;
/*     */   private String _defaultLocationId;
/*  36 */   private Boolean _systemBucket = Boolean.FALSE;
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
/*     */   public Long getRetailLocationId() {
/*  49 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  53 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  54 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getBucketId() {
/*  59 */     return this._bucketId;
/*     */   }
/*     */   
/*     */   public void setBucketId(String argBucketId) {
/*  63 */     if (changed(argBucketId, this._bucketId, "bucketId")) {
/*  64 */       this._bucketId = (argBucketId != null && MANAGE_CASE) ? argBucketId.toUpperCase() : argBucketId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  69 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  73 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  74 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  80 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  84 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  85 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  90 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  94 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  95 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 101 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 105 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 106 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getName() {
/* 111 */     return this._name;
/*     */   }
/*     */   
/*     */   public void setName(String argName) {
/* 115 */     if (changed(argName, this._name, "name")) {
/* 116 */       this._name = argName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getFunctionCode() {
/* 121 */     return this._functionCode;
/*     */   }
/*     */   
/*     */   public void setFunctionCode(String argFunctionCode) {
/* 125 */     if (changed(argFunctionCode, this._functionCode, "functionCode")) {
/* 126 */       this._functionCode = argFunctionCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAdjustmentAction() {
/* 131 */     return this._adjustmentAction;
/*     */   }
/*     */   
/*     */   public void setAdjustmentAction(String argAdjustmentAction) {
/* 135 */     if (changed(argAdjustmentAction, this._adjustmentAction, "adjustmentAction")) {
/* 136 */       this._adjustmentAction = argAdjustmentAction;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDefaultLocationId() {
/* 141 */     return this._defaultLocationId;
/*     */   }
/*     */   
/*     */   public void setDefaultLocationId(String argDefaultLocationId) {
/* 145 */     if (changed(argDefaultLocationId, this._defaultLocationId, "defaultLocationId")) {
/* 146 */       this._defaultLocationId = argDefaultLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getSystemBucket() {
/* 151 */     return this._systemBucket;
/*     */   }
/*     */   
/*     */   public void setSystemBucket(Boolean argSystemBucket) {
/* 155 */     if (changed(argSystemBucket, this._systemBucket, "systemBucket")) {
/* 156 */       this._systemBucket = argSystemBucket;
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
/* 168 */     if (getRetailLocationId() != null) {
/* 169 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 171 */     if (getBucketId() != null) {
/* 172 */       buf.append("bucketId").append("=").append(getBucketId()).append(" ");
/*     */     }
/* 174 */     if (getCreateDate() != null) {
/* 175 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 177 */     if (getCreateUserId() != null) {
/* 178 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 180 */     if (getUpdateDate() != null) {
/* 181 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 183 */     if (getUpdateUserId() != null) {
/* 184 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 186 */     if (getName() != null) {
/* 187 */       buf.append("name").append("=").append(getName()).append(" ");
/*     */     }
/* 189 */     if (getFunctionCode() != null) {
/* 190 */       buf.append("functionCode").append("=").append(getFunctionCode()).append(" ");
/*     */     }
/* 192 */     if (getAdjustmentAction() != null) {
/* 193 */       buf.append("adjustmentAction").append("=").append(getAdjustmentAction()).append(" ");
/*     */     }
/* 195 */     if (getDefaultLocationId() != null) {
/* 196 */       buf.append("defaultLocationId").append("=").append(getDefaultLocationId()).append(" ");
/*     */     }
/* 198 */     if (getSystemBucket() != null && getSystemBucket().booleanValue()) {
/* 199 */       buf.append("systemBucket").append("=").append(getSystemBucket()).append(" ");
/*     */     }
/*     */     
/* 202 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 206 */     InventoryBucketId id = new InventoryBucketId();
/* 207 */     id.setOrganizationId(getOrganizationId());
/* 208 */     id.setRetailLocationId(getRetailLocationId());
/* 209 */     id.setBucketId(getBucketId());
/* 210 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 214 */     setOrganizationId(((InventoryBucketId)argObjectId).getOrganizationId());
/* 215 */     setRetailLocationId(((InventoryBucketId)argObjectId).getRetailLocationId());
/* 216 */     setBucketId(((InventoryBucketId)argObjectId).getBucketId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 220 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 224 */     StringBuilder buf = new StringBuilder(600);
/* 225 */     buf.append("<").append("dao").append(" name=\"InventoryBucket\" cmd=\"" + getObjectStateString() + "\">");
/* 226 */     getFieldsAsXml(buf);
/* 227 */     buf.append("</").append("dao").append(">");
/*     */     
/* 229 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 233 */     Map<String, String> values = super.getValues();
/* 234 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 235 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 236 */     if (this._bucketId != null) values.put("BucketId", DaoUtils.getXmlSafeFieldValue(12, this._bucketId)); 
/* 237 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 238 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 239 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 240 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 241 */     if (this._name != null) values.put("Name", DaoUtils.getXmlSafeFieldValue(12, this._name)); 
/* 242 */     if (this._functionCode != null) values.put("FunctionCode", DaoUtils.getXmlSafeFieldValue(12, this._functionCode)); 
/* 243 */     if (this._adjustmentAction != null) values.put("AdjustmentAction", DaoUtils.getXmlSafeFieldValue(12, this._adjustmentAction)); 
/* 244 */     if (this._defaultLocationId != null) values.put("DefaultLocationId", DaoUtils.getXmlSafeFieldValue(12, this._defaultLocationId)); 
/* 245 */     if (this._systemBucket != null) values.put("SystemBucket", DaoUtils.getXmlSafeFieldValue(-7, this._systemBucket)); 
/* 246 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 251 */     super.setValues(argValues);
/* 252 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 254 */       String fieldName = field.getKey();
/* 255 */       String fieldValue = field.getValue();
/* 256 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 260 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 261 */             setOrganizationId((Long)value);
/* 262 */           } catch (Exception ee) {
/* 263 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 269 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 270 */             setRetailLocationId((Long)value);
/* 271 */           } catch (Exception ee) {
/* 272 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BucketId":
/*     */           try {
/* 278 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 279 */             setBucketId((String)value);
/* 280 */           } catch (Exception ee) {
/* 281 */             throw new DtxException("An exception occurred while calling setBucketId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 287 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 288 */             setCreateDate((Date)value);
/* 289 */           } catch (Exception ee) {
/* 290 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 296 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 297 */             setCreateUserId((String)value);
/* 298 */           } catch (Exception ee) {
/* 299 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 305 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 306 */             setUpdateDate((Date)value);
/* 307 */           } catch (Exception ee) {
/* 308 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 314 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 315 */             setUpdateUserId((String)value);
/* 316 */           } catch (Exception ee) {
/* 317 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Name":
/*     */           try {
/* 323 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 324 */             setName((String)value);
/* 325 */           } catch (Exception ee) {
/* 326 */             throw new DtxException("An exception occurred while calling setName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FunctionCode":
/*     */           try {
/* 332 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 333 */             setFunctionCode((String)value);
/* 334 */           } catch (Exception ee) {
/* 335 */             throw new DtxException("An exception occurred while calling setFunctionCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AdjustmentAction":
/*     */           try {
/* 341 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 342 */             setAdjustmentAction((String)value);
/* 343 */           } catch (Exception ee) {
/* 344 */             throw new DtxException("An exception occurred while calling setAdjustmentAction() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DefaultLocationId":
/*     */           try {
/* 350 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 351 */             setDefaultLocationId((String)value);
/* 352 */           } catch (Exception ee) {
/* 353 */             throw new DtxException("An exception occurred while calling setDefaultLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SystemBucket":
/*     */           try {
/* 359 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 360 */             setSystemBucket((Boolean)value);
/* 361 */           } catch (Exception ee) {
/* 362 */             throw new DtxException("An exception occurred while calling setSystemBucket() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryBucketDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */