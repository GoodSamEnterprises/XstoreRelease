/*     */ package dtv.xst.dao.xom.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.xom.SourceModifierId;
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
/*     */ public class SourceModifierDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1313951794L;
/*  23 */   private static final Logger _logger = Logger.getLogger(SourceModifierDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _orderId;
/*     */   private Integer _sequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _locationId;
/*     */   private String _locationType;
/*     */   private String _locationName1;
/*     */   private String _locationName2;
/*     */   private String _telephone1;
/*     */   private String _emailAddress;
/*     */   private Long _addressSequence;
/*     */   
/*     */   public Long getOrganizationId() {
/*  41 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  45 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  46 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrderId() {
/*  51 */     return this._orderId;
/*     */   }
/*     */   
/*     */   public void setOrderId(String argOrderId) {
/*  55 */     if (changed(argOrderId, this._orderId, "orderId")) {
/*  56 */       this._orderId = (argOrderId != null && MANAGE_CASE) ? argOrderId.toUpperCase() : argOrderId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Integer getSequence() {
/*  61 */     return this._sequence;
/*     */   }
/*     */   
/*     */   public void setSequence(Integer argSequence) {
/*  65 */     if (changed(argSequence, this._sequence, "sequence")) {
/*  66 */       this._sequence = argSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  71 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  75 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  76 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  82 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  86 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  87 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  92 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  96 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  97 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 103 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 107 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 108 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLocationId() {
/* 113 */     return this._locationId;
/*     */   }
/*     */   
/*     */   public void setLocationId(String argLocationId) {
/* 117 */     if (changed(argLocationId, this._locationId, "locationId")) {
/* 118 */       this._locationId = argLocationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLocationType() {
/* 123 */     return this._locationType;
/*     */   }
/*     */   
/*     */   public void setLocationType(String argLocationType) {
/* 127 */     if (changed(argLocationType, this._locationType, "locationType")) {
/* 128 */       this._locationType = argLocationType;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLocationName1() {
/* 133 */     return this._locationName1;
/*     */   }
/*     */   
/*     */   public void setLocationName1(String argLocationName1) {
/* 137 */     if (changed(argLocationName1, this._locationName1, "locationName1")) {
/* 138 */       this._locationName1 = argLocationName1;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getLocationName2() {
/* 143 */     return this._locationName2;
/*     */   }
/*     */   
/*     */   public void setLocationName2(String argLocationName2) {
/* 147 */     if (changed(argLocationName2, this._locationName2, "locationName2")) {
/* 148 */       this._locationName2 = argLocationName2;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTelephone1() {
/* 153 */     return this._telephone1;
/*     */   }
/*     */   
/*     */   public void setTelephone1(String argTelephone1) {
/* 157 */     if (changed(argTelephone1, this._telephone1, "telephone1")) {
/* 158 */       this._telephone1 = argTelephone1;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getEmailAddress() {
/* 163 */     return this._emailAddress;
/*     */   }
/*     */   
/*     */   public void setEmailAddress(String argEmailAddress) {
/* 167 */     if (changed(argEmailAddress, this._emailAddress, "emailAddress")) {
/* 168 */       this._emailAddress = argEmailAddress;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getAddressSequence() {
/* 173 */     return this._addressSequence;
/*     */   }
/*     */   
/*     */   public void setAddressSequence(Long argAddressSequence) {
/* 177 */     if (changed(argAddressSequence, this._addressSequence, "addressSequence")) {
/* 178 */       this._addressSequence = argAddressSequence;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 185 */     StringBuilder buf = new StringBuilder(512);
/* 186 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 187 */     if (getOrganizationId() != null) {
/* 188 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 190 */     if (getOrderId() != null) {
/* 191 */       buf.append("orderId").append("=").append(getOrderId()).append(" ");
/*     */     }
/* 193 */     if (getSequence() != null) {
/* 194 */       buf.append("sequence").append("=").append(getSequence()).append(" ");
/*     */     }
/* 196 */     if (getCreateDate() != null) {
/* 197 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 199 */     if (getCreateUserId() != null) {
/* 200 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 202 */     if (getUpdateDate() != null) {
/* 203 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 205 */     if (getUpdateUserId() != null) {
/* 206 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 208 */     if (getLocationId() != null) {
/* 209 */       buf.append("locationId").append("=").append(getLocationId()).append(" ");
/*     */     }
/* 211 */     if (getLocationType() != null) {
/* 212 */       buf.append("locationType").append("=").append(getLocationType()).append(" ");
/*     */     }
/* 214 */     if (getLocationName1() != null) {
/* 215 */       buf.append("locationName1").append("=").append(getLocationName1()).append(" ");
/*     */     }
/* 217 */     if (getLocationName2() != null) {
/* 218 */       buf.append("locationName2").append("=").append(getLocationName2()).append(" ");
/*     */     }
/* 220 */     if (getTelephone1() != null) {
/* 221 */       buf.append("telephone1").append("=").append(getTelephone1()).append(" ");
/*     */     }
/* 223 */     if (getEmailAddress() != null) {
/* 224 */       buf.append("emailAddress").append("=").append(getEmailAddress()).append(" ");
/*     */     }
/* 226 */     if (getAddressSequence() != null) {
/* 227 */       buf.append("addressSequence").append("=").append(getAddressSequence()).append(" ");
/*     */     }
/*     */     
/* 230 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 234 */     SourceModifierId id = new SourceModifierId();
/* 235 */     id.setOrganizationId(getOrganizationId());
/* 236 */     id.setOrderId(getOrderId());
/* 237 */     id.setSequence(getSequence());
/* 238 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 242 */     setOrganizationId(((SourceModifierId)argObjectId).getOrganizationId());
/* 243 */     setOrderId(((SourceModifierId)argObjectId).getOrderId());
/* 244 */     setSequence(((SourceModifierId)argObjectId).getSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 248 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 252 */     StringBuilder buf = new StringBuilder(700);
/* 253 */     buf.append("<").append("dao").append(" name=\"SourceModifier\" cmd=\"" + getObjectStateString() + "\">");
/* 254 */     getFieldsAsXml(buf);
/* 255 */     buf.append("</").append("dao").append(">");
/*     */     
/* 257 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 261 */     Map<String, String> values = super.getValues();
/* 262 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 263 */     if (this._orderId != null) values.put("OrderId", DaoUtils.getXmlSafeFieldValue(12, this._orderId)); 
/* 264 */     if (this._sequence != null) values.put("Sequence", DaoUtils.getXmlSafeFieldValue(4, this._sequence)); 
/* 265 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 266 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 267 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 268 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 269 */     if (this._locationId != null) values.put("LocationId", DaoUtils.getXmlSafeFieldValue(12, this._locationId)); 
/* 270 */     if (this._locationType != null) values.put("LocationType", DaoUtils.getXmlSafeFieldValue(12, this._locationType)); 
/* 271 */     if (this._locationName1 != null) values.put("LocationName1", DaoUtils.getXmlSafeFieldValue(12, this._locationName1)); 
/* 272 */     if (this._locationName2 != null) values.put("LocationName2", DaoUtils.getXmlSafeFieldValue(12, this._locationName2)); 
/* 273 */     if (this._telephone1 != null) values.put("Telephone1", DaoUtils.getXmlSafeFieldValue(12, this._telephone1)); 
/* 274 */     if (this._emailAddress != null) values.put("EmailAddress", DaoUtils.getXmlSafeFieldValue(12, this._emailAddress)); 
/* 275 */     if (this._addressSequence != null) values.put("AddressSequence", DaoUtils.getXmlSafeFieldValue(-5, this._addressSequence)); 
/* 276 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 281 */     super.setValues(argValues);
/* 282 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 284 */       String fieldName = field.getKey();
/* 285 */       String fieldValue = field.getValue();
/* 286 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 290 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 291 */             setOrganizationId((Long)value);
/* 292 */           } catch (Exception ee) {
/* 293 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrderId":
/*     */           try {
/* 299 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 300 */             setOrderId((String)value);
/* 301 */           } catch (Exception ee) {
/* 302 */             throw new DtxException("An exception occurred while calling setOrderId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Sequence":
/*     */           try {
/* 308 */             Object value = DaoUtils.getFieldValueForXmlString(4, fieldValue);
/* 309 */             setSequence((Integer)value);
/* 310 */           } catch (Exception ee) {
/* 311 */             throw new DtxException("An exception occurred while calling setSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 317 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 318 */             setCreateDate((Date)value);
/* 319 */           } catch (Exception ee) {
/* 320 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 326 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 327 */             setCreateUserId((String)value);
/* 328 */           } catch (Exception ee) {
/* 329 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 335 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 336 */             setUpdateDate((Date)value);
/* 337 */           } catch (Exception ee) {
/* 338 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 344 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 345 */             setUpdateUserId((String)value);
/* 346 */           } catch (Exception ee) {
/* 347 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LocationId":
/*     */           try {
/* 353 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 354 */             setLocationId((String)value);
/* 355 */           } catch (Exception ee) {
/* 356 */             throw new DtxException("An exception occurred while calling setLocationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LocationType":
/*     */           try {
/* 362 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 363 */             setLocationType((String)value);
/* 364 */           } catch (Exception ee) {
/* 365 */             throw new DtxException("An exception occurred while calling setLocationType() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LocationName1":
/*     */           try {
/* 371 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 372 */             setLocationName1((String)value);
/* 373 */           } catch (Exception ee) {
/* 374 */             throw new DtxException("An exception occurred while calling setLocationName1() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "LocationName2":
/*     */           try {
/* 380 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 381 */             setLocationName2((String)value);
/* 382 */           } catch (Exception ee) {
/* 383 */             throw new DtxException("An exception occurred while calling setLocationName2() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Telephone1":
/*     */           try {
/* 389 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 390 */             setTelephone1((String)value);
/* 391 */           } catch (Exception ee) {
/* 392 */             throw new DtxException("An exception occurred while calling setTelephone1() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "EmailAddress":
/*     */           try {
/* 398 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 399 */             setEmailAddress((String)value);
/* 400 */           } catch (Exception ee) {
/* 401 */             throw new DtxException("An exception occurred while calling setEmailAddress() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AddressSequence":
/*     */           try {
/* 407 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 408 */             setAddressSequence((Long)value);
/* 409 */           } catch (Exception ee) {
/* 410 */             throw new DtxException("An exception occurred while calling setAddressSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\SourceModifierDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */