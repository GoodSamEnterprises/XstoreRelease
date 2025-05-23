/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryLocationBucketId;
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
/*     */ public class InventoryLocationBucketDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 415344219L;
/*  23 */   private static final Logger _logger = Logger.getLogger(InventoryLocationBucketDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _locationId;
/*     */   private String _bucketId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _trackingMethod;
/*     */   
/*     */   public Long getOrganizationId() {
/*  36 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  40 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  41 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getRetailLocationId() {
/*  46 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  50 */     if (changed(argRetailLocationId, this._retailLocationId, "retailLocationId")) {
/*  51 */       this._retailLocationId = argRetailLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLocationId() {
/*  56 */     return this._locationId;
/*     */   }
/*     */   
/*     */   public void setLocationId(String argLocationId) {
/*  60 */     if (changed(argLocationId, this._locationId, "locationId")) {
/*  61 */       this._locationId = (argLocationId != null && MANAGE_CASE) ? argLocationId.toUpperCase() : argLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getBucketId() {
/*  66 */     return this._bucketId;
/*     */   }
/*     */   
/*     */   public void setBucketId(String argBucketId) {
/*  70 */     if (changed(argBucketId, this._bucketId, "bucketId")) {
/*  71 */       this._bucketId = (argBucketId != null && MANAGE_CASE) ? argBucketId.toUpperCase() : argBucketId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  76 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  80 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  81 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  87 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  91 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  92 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  97 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 101 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 102 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 108 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 112 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 113 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTrackingMethod() {
/* 118 */     return this._trackingMethod;
/*     */   }
/*     */   
/*     */   public void setTrackingMethod(String argTrackingMethod) {
/* 122 */     if (changed(argTrackingMethod, this._trackingMethod, "trackingMethod")) {
/* 123 */       this._trackingMethod = argTrackingMethod;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuilder buf = new StringBuilder(512);
/* 131 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 132 */     if (getOrganizationId() != null) {
/* 133 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 135 */     if (getRetailLocationId() != null) {
/* 136 */       buf.append("retailLocationId").append("=").append(getRetailLocationId()).append(" ");
/*     */     }
/* 138 */     if (getLocationId() != null) {
/* 139 */       buf.append("locationId").append("=").append(getLocationId()).append(" ");
/*     */     }
/* 141 */     if (getBucketId() != null) {
/* 142 */       buf.append("bucketId").append("=").append(getBucketId()).append(" ");
/*     */     }
/* 144 */     if (getCreateDate() != null) {
/* 145 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 147 */     if (getCreateUserId() != null) {
/* 148 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 150 */     if (getUpdateDate() != null) {
/* 151 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 153 */     if (getUpdateUserId() != null) {
/* 154 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 156 */     if (getTrackingMethod() != null) {
/* 157 */       buf.append("trackingMethod").append("=").append(getTrackingMethod()).append(" ");
/*     */     }
/*     */     
/* 160 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 164 */     InventoryLocationBucketId id = new InventoryLocationBucketId();
/* 165 */     id.setOrganizationId(getOrganizationId());
/* 166 */     id.setRetailLocationId(getRetailLocationId());
/* 167 */     id.setLocationId(getLocationId());
/* 168 */     id.setBucketId(getBucketId());
/* 169 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 173 */     setOrganizationId(((InventoryLocationBucketId)argObjectId).getOrganizationId());
/* 174 */     setRetailLocationId(((InventoryLocationBucketId)argObjectId).getRetailLocationId());
/* 175 */     setLocationId(((InventoryLocationBucketId)argObjectId).getLocationId());
/* 176 */     setBucketId(((InventoryLocationBucketId)argObjectId).getBucketId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 180 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 184 */     StringBuilder buf = new StringBuilder(450);
/* 185 */     buf.append("<").append("dao").append(" name=\"InventoryLocationBucket\" cmd=\"" + getObjectStateString() + "\">");
/* 186 */     getFieldsAsXml(buf);
/* 187 */     buf.append("</").append("dao").append(">");
/*     */     
/* 189 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 193 */     Map<String, String> values = super.getValues();
/* 194 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 195 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 196 */     if (this._locationId != null) values.put("LocationId", DaoUtils.getXmlSafeFieldValue(12, this._locationId)); 
/* 197 */     if (this._bucketId != null) values.put("BucketId", DaoUtils.getXmlSafeFieldValue(12, this._bucketId)); 
/* 198 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 199 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 200 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 201 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 202 */     if (this._trackingMethod != null) values.put("TrackingMethod", DaoUtils.getXmlSafeFieldValue(12, this._trackingMethod)); 
/* 203 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 208 */     super.setValues(argValues);
/* 209 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 211 */       String fieldName = field.getKey();
/* 212 */       String fieldValue = field.getValue();
/* 213 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 217 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 218 */             setOrganizationId((Long)value);
/* 219 */           } catch (Exception ee) {
/* 220 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 226 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 227 */             setRetailLocationId((Long)value);
/* 228 */           } catch (Exception ee) {
/* 229 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LocationId":
/*     */           try {
/* 235 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 236 */             setLocationId((String)value);
/* 237 */           } catch (Exception ee) {
/* 238 */             throw new DtxException("An exception occurred while calling setLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "BucketId":
/*     */           try {
/* 244 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 245 */             setBucketId((String)value);
/* 246 */           } catch (Exception ee) {
/* 247 */             throw new DtxException("An exception occurred while calling setBucketId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 253 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 254 */             setCreateDate((Date)value);
/* 255 */           } catch (Exception ee) {
/* 256 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 262 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 263 */             setCreateUserId((String)value);
/* 264 */           } catch (Exception ee) {
/* 265 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 271 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 272 */             setUpdateDate((Date)value);
/* 273 */           } catch (Exception ee) {
/* 274 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 280 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 281 */             setUpdateUserId((String)value);
/* 282 */           } catch (Exception ee) {
/* 283 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TrackingMethod":
/*     */           try {
/* 289 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 290 */             setTrackingMethod((String)value);
/* 291 */           } catch (Exception ee) {
/* 292 */             throw new DtxException("An exception occurred while calling setTrackingMethod() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryLocationBucketDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */