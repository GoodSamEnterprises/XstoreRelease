/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.InventoryLocationId;
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
/*     */ public class InventoryLocationDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1324171537L;
/*  23 */   private static final Logger _logger = Logger.getLogger(InventoryLocationDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private Long _retailLocationId;
/*     */   private String _locationId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _name;
/*  33 */   private Boolean _systemLocation = Boolean.FALSE;
/*  34 */   private Boolean _active = Boolean.FALSE;
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
/*     */   public String getLocationId() {
/*  57 */     return this._locationId;
/*     */   }
/*     */   
/*     */   public void setLocationId(String argLocationId) {
/*  61 */     if (changed(argLocationId, this._locationId, "locationId")) {
/*  62 */       this._locationId = (argLocationId != null && MANAGE_CASE) ? argLocationId.toUpperCase() : argLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  67 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  71 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  72 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  78 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  82 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  83 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  88 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  92 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  93 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  99 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 103 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 104 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getName() {
/* 109 */     return this._name;
/*     */   }
/*     */   
/*     */   public void setName(String argName) {
/* 113 */     if (changed(argName, this._name, "name")) {
/* 114 */       this._name = argName;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getSystemLocation() {
/* 119 */     return this._systemLocation;
/*     */   }
/*     */   
/*     */   public void setSystemLocation(Boolean argSystemLocation) {
/* 123 */     if (changed(argSystemLocation, this._systemLocation, "systemLocation")) {
/* 124 */       this._systemLocation = argSystemLocation;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getActive() {
/* 129 */     return this._active;
/*     */   }
/*     */   
/*     */   public void setActive(Boolean argActive) {
/* 133 */     if (changed(argActive, this._active, "active")) {
/* 134 */       this._active = argActive;
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
/* 149 */     if (getLocationId() != null) {
/* 150 */       buf.append("locationId").append("=").append(getLocationId()).append(" ");
/*     */     }
/* 152 */     if (getCreateDate() != null) {
/* 153 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 155 */     if (getCreateUserId() != null) {
/* 156 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 158 */     if (getUpdateDate() != null) {
/* 159 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 161 */     if (getUpdateUserId() != null) {
/* 162 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 164 */     if (getName() != null) {
/* 165 */       buf.append("name").append("=").append(getName()).append(" ");
/*     */     }
/* 167 */     if (getSystemLocation() != null && getSystemLocation().booleanValue()) {
/* 168 */       buf.append("systemLocation").append("=").append(getSystemLocation()).append(" ");
/*     */     }
/* 170 */     if (getActive() != null && getActive().booleanValue()) {
/* 171 */       buf.append("active").append("=").append(getActive()).append(" ");
/*     */     }
/*     */     
/* 174 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 178 */     InventoryLocationId id = new InventoryLocationId();
/* 179 */     id.setOrganizationId(getOrganizationId());
/* 180 */     id.setRetailLocationId(getRetailLocationId());
/* 181 */     id.setLocationId(getLocationId());
/* 182 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 186 */     setOrganizationId(((InventoryLocationId)argObjectId).getOrganizationId());
/* 187 */     setRetailLocationId(((InventoryLocationId)argObjectId).getRetailLocationId());
/* 188 */     setLocationId(((InventoryLocationId)argObjectId).getLocationId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 192 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 196 */     StringBuilder buf = new StringBuilder(500);
/* 197 */     buf.append("<").append("dao").append(" name=\"InventoryLocation\" cmd=\"" + getObjectStateString() + "\">");
/* 198 */     getFieldsAsXml(buf);
/* 199 */     buf.append("</").append("dao").append(">");
/*     */     
/* 201 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 205 */     Map<String, String> values = super.getValues();
/* 206 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 207 */     if (this._retailLocationId != null) values.put("RetailLocationId", DaoUtils.getXmlSafeFieldValue(-5, this._retailLocationId)); 
/* 208 */     if (this._locationId != null) values.put("LocationId", DaoUtils.getXmlSafeFieldValue(12, this._locationId)); 
/* 209 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 210 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 211 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 212 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 213 */     if (this._name != null) values.put("Name", DaoUtils.getXmlSafeFieldValue(12, this._name)); 
/* 214 */     if (this._systemLocation != null) values.put("SystemLocation", DaoUtils.getXmlSafeFieldValue(-7, this._systemLocation)); 
/* 215 */     if (this._active != null) values.put("Active", DaoUtils.getXmlSafeFieldValue(-7, this._active)); 
/* 216 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 221 */     super.setValues(argValues);
/* 222 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 224 */       String fieldName = field.getKey();
/* 225 */       String fieldValue = field.getValue();
/* 226 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 230 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 231 */             setOrganizationId((Long)value);
/* 232 */           } catch (Exception ee) {
/* 233 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "RetailLocationId":
/*     */           try {
/* 239 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 240 */             setRetailLocationId((Long)value);
/* 241 */           } catch (Exception ee) {
/* 242 */             throw new DtxException("An exception occurred while calling setRetailLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LocationId":
/*     */           try {
/* 248 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 249 */             setLocationId((String)value);
/* 250 */           } catch (Exception ee) {
/* 251 */             throw new DtxException("An exception occurred while calling setLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 257 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 258 */             setCreateDate((Date)value);
/* 259 */           } catch (Exception ee) {
/* 260 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 266 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 267 */             setCreateUserId((String)value);
/* 268 */           } catch (Exception ee) {
/* 269 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 275 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 276 */             setUpdateDate((Date)value);
/* 277 */           } catch (Exception ee) {
/* 278 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 284 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 285 */             setUpdateUserId((String)value);
/* 286 */           } catch (Exception ee) {
/* 287 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Name":
/*     */           try {
/* 293 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 294 */             setName((String)value);
/* 295 */           } catch (Exception ee) {
/* 296 */             throw new DtxException("An exception occurred while calling setName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SystemLocation":
/*     */           try {
/* 302 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 303 */             setSystemLocation((Boolean)value);
/* 304 */           } catch (Exception ee) {
/* 305 */             throw new DtxException("An exception occurred while calling setSystemLocation() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Active":
/*     */           try {
/* 311 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 312 */             setActive((Boolean)value);
/* 313 */           } catch (Exception ee) {
/* 314 */             throw new DtxException("An exception occurred while calling setActive() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\InventoryLocationDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */