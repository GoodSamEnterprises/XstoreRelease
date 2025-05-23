/*     */ package dtv.xst.dao.inv.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.inv.ShipperId;
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
/*     */ public class ShipperDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -568756927L;
/*  23 */   private static final Logger _logger = Logger.getLogger(ShipperDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _shipperId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _shipperDesc;
/*     */   private Integer _displayOrder;
/*  35 */   private Boolean _trackingNumberEnabled = Boolean.FALSE;
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
/*     */   public String getShipperId() {
/*  48 */     return this._shipperId;
/*     */   }
/*     */   
/*     */   public void setShipperId(String argShipperId) {
/*  52 */     if (changed(argShipperId, this._shipperId, "shipperId")) {
/*  53 */       this._shipperId = (argShipperId != null && MANAGE_CASE) ? argShipperId.toUpperCase() : argShipperId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/*  58 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/*  62 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/*  63 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/*  68 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/*  72 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/*  73 */       this._orgValue = argOrgValue;
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
/*     */   public String getShipperDesc() {
/* 120 */     return this._shipperDesc;
/*     */   }
/*     */   
/*     */   public void setShipperDesc(String argShipperDesc) {
/* 124 */     if (changed(argShipperDesc, this._shipperDesc, "shipperDesc")) {
/* 125 */       this._shipperDesc = argShipperDesc;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getDisplayOrder() {
/* 130 */     return this._displayOrder;
/*     */   }
/*     */   
/*     */   public void setDisplayOrder(Integer argDisplayOrder) {
/* 134 */     if (changed(argDisplayOrder, this._displayOrder, "displayOrder")) {
/* 135 */       this._displayOrder = argDisplayOrder;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getTrackingNumberEnabled() {
/* 140 */     return this._trackingNumberEnabled;
/*     */   }
/*     */   
/*     */   public void setTrackingNumberEnabled(Boolean argTrackingNumberEnabled) {
/* 144 */     if (changed(argTrackingNumberEnabled, this._trackingNumberEnabled, "trackingNumberEnabled")) {
/* 145 */       this._trackingNumberEnabled = argTrackingNumberEnabled;
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
/* 157 */     if (getShipperId() != null) {
/* 158 */       buf.append("shipperId").append("=").append(getShipperId()).append(" ");
/*     */     }
/* 160 */     if (getOrgCode() != null) {
/* 161 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 163 */     if (getOrgValue() != null) {
/* 164 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
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
/* 178 */     if (getShipperDesc() != null) {
/* 179 */       buf.append("shipperDesc").append("=").append(getShipperDesc()).append(" ");
/*     */     }
/* 181 */     if (getDisplayOrder() != null) {
/* 182 */       buf.append("displayOrder").append("=").append(getDisplayOrder()).append(" ");
/*     */     }
/* 184 */     if (getTrackingNumberEnabled() != null && getTrackingNumberEnabled().booleanValue()) {
/* 185 */       buf.append("trackingNumberEnabled").append("=").append(getTrackingNumberEnabled()).append(" ");
/*     */     }
/*     */     
/* 188 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 192 */     ShipperId id = new ShipperId();
/* 193 */     id.setOrganizationId(getOrganizationId());
/* 194 */     id.setShipperId(getShipperId());
/* 195 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 199 */     setOrganizationId(((ShipperId)argObjectId).getOrganizationId());
/* 200 */     setShipperId(((ShipperId)argObjectId).getShipperId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 204 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 208 */     StringBuilder buf = new StringBuilder(550);
/* 209 */     buf.append("<").append("dao").append(" name=\"Shipper\" cmd=\"" + getObjectStateString() + "\">");
/* 210 */     getFieldsAsXml(buf);
/* 211 */     buf.append("</").append("dao").append(">");
/*     */     
/* 213 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 217 */     Map<String, String> values = super.getValues();
/* 218 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 219 */     if (this._shipperId != null) values.put("ShipperId", DaoUtils.getXmlSafeFieldValue(12, this._shipperId)); 
/* 220 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 221 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 222 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 223 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 224 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 225 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 226 */     if (this._shipperDesc != null) values.put("ShipperDesc", DaoUtils.getXmlSafeFieldValue(12, this._shipperDesc)); 
/* 227 */     if (this._displayOrder != null) values.put("DisplayOrder", DaoUtils.getXmlSafeFieldValue(4, this._displayOrder)); 
/* 228 */     if (this._trackingNumberEnabled != null) values.put("TrackingNumberEnabled", DaoUtils.getXmlSafeFieldValue(-7, this._trackingNumberEnabled)); 
/* 229 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 234 */     super.setValues(argValues);
/* 235 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 237 */       String fieldName = field.getKey();
/* 238 */       String fieldValue = field.getValue();
/* 239 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 243 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 244 */             setOrganizationId((Long)value);
/* 245 */           } catch (Exception ee) {
/* 246 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ShipperId":
/*     */           try {
/* 252 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 253 */             setShipperId((String)value);
/* 254 */           } catch (Exception ee) {
/* 255 */             throw new DtxException("An exception occurred while calling setShipperId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 261 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 262 */             setOrgCode((String)value);
/* 263 */           } catch (Exception ee) {
/* 264 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 270 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 271 */             setOrgValue((String)value);
/* 272 */           } catch (Exception ee) {
/* 273 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 279 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 280 */             setCreateDate((Date)value);
/* 281 */           } catch (Exception ee) {
/* 282 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 288 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 289 */             setCreateUserId((String)value);
/* 290 */           } catch (Exception ee) {
/* 291 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 297 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 298 */             setUpdateDate((Date)value);
/* 299 */           } catch (Exception ee) {
/* 300 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 306 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 307 */             setUpdateUserId((String)value);
/* 308 */           } catch (Exception ee) {
/* 309 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ShipperDesc":
/*     */           try {
/* 315 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 316 */             setShipperDesc((String)value);
/* 317 */           } catch (Exception ee) {
/* 318 */             throw new DtxException("An exception occurred while calling setShipperDesc() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DisplayOrder":
/*     */           try {
/* 324 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 325 */             setDisplayOrder((Integer)value);
/* 326 */           } catch (Exception ee) {
/* 327 */             throw new DtxException("An exception occurred while calling setDisplayOrder() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TrackingNumberEnabled":
/*     */           try {
/* 333 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 334 */             setTrackingNumberEnabled((Boolean)value);
/* 335 */           } catch (Exception ee) {
/* 336 */             throw new DtxException("An exception occurred while calling setTrackingNumberEnabled() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\impl\ShipperDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */