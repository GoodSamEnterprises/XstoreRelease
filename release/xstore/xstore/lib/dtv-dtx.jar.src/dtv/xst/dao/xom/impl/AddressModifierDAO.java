/*     */ package dtv.xst.dao.xom.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.xom.AddressModifierId;
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
/*     */ public class AddressModifierDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1732016437L;
/*  23 */   private static final Logger _logger = Logger.getLogger(AddressModifierDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _orderId;
/*     */   private Long _sequence;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _address1;
/*     */   private String _address2;
/*     */   private String _address3;
/*     */   private String _address4;
/*     */   private String _apartment;
/*     */   private String _city;
/*     */   private String _state;
/*     */   private String _postalCode;
/*     */   private String _country;
/*     */   private String _neighborhood;
/*     */   private String _county;
/*     */   
/*     */   public Long getOrganizationId() {
/*  45 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  49 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  50 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrderId() {
/*  55 */     return this._orderId;
/*     */   }
/*     */   
/*     */   public void setOrderId(String argOrderId) {
/*  59 */     if (changed(argOrderId, this._orderId, "orderId")) {
/*  60 */       this._orderId = (argOrderId != null && MANAGE_CASE) ? argOrderId.toUpperCase() : argOrderId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Long getSequence() {
/*  65 */     return this._sequence;
/*     */   }
/*     */   
/*     */   public void setSequence(Long argSequence) {
/*  69 */     if (changed(argSequence, this._sequence, "sequence")) {
/*  70 */       this._sequence = argSequence;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  75 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  79 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  80 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  86 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  90 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  91 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  96 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 100 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 101 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 107 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 111 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 112 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAddress1() {
/* 117 */     return this._address1;
/*     */   }
/*     */   
/*     */   public void setAddress1(String argAddress1) {
/* 121 */     if (changed(argAddress1, this._address1, "address1")) {
/* 122 */       this._address1 = argAddress1;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAddress2() {
/* 127 */     return this._address2;
/*     */   }
/*     */   
/*     */   public void setAddress2(String argAddress2) {
/* 131 */     if (changed(argAddress2, this._address2, "address2")) {
/* 132 */       this._address2 = argAddress2;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAddress3() {
/* 137 */     return this._address3;
/*     */   }
/*     */   
/*     */   public void setAddress3(String argAddress3) {
/* 141 */     if (changed(argAddress3, this._address3, "address3")) {
/* 142 */       this._address3 = argAddress3;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAddress4() {
/* 147 */     return this._address4;
/*     */   }
/*     */   
/*     */   public void setAddress4(String argAddress4) {
/* 151 */     if (changed(argAddress4, this._address4, "address4")) {
/* 152 */       this._address4 = argAddress4;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getApartment() {
/* 157 */     return this._apartment;
/*     */   }
/*     */   
/*     */   public void setApartment(String argApartment) {
/* 161 */     if (changed(argApartment, this._apartment, "apartment")) {
/* 162 */       this._apartment = argApartment;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCity() {
/* 167 */     return this._city;
/*     */   }
/*     */   
/*     */   public void setCity(String argCity) {
/* 171 */     if (changed(argCity, this._city, "city")) {
/* 172 */       this._city = argCity;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getState() {
/* 177 */     return this._state;
/*     */   }
/*     */   
/*     */   public void setState(String argState) {
/* 181 */     if (changed(argState, this._state, "state")) {
/* 182 */       this._state = argState;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPostalCode() {
/* 187 */     return this._postalCode;
/*     */   }
/*     */   
/*     */   public void setPostalCode(String argPostalCode) {
/* 191 */     if (changed(argPostalCode, this._postalCode, "postalCode")) {
/* 192 */       this._postalCode = argPostalCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCountry() {
/* 197 */     return this._country;
/*     */   }
/*     */   
/*     */   public void setCountry(String argCountry) {
/* 201 */     if (changed(argCountry, this._country, "country")) {
/* 202 */       this._country = argCountry;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getNeighborhood() {
/* 207 */     return this._neighborhood;
/*     */   }
/*     */   
/*     */   public void setNeighborhood(String argNeighborhood) {
/* 211 */     if (changed(argNeighborhood, this._neighborhood, "neighborhood")) {
/* 212 */       this._neighborhood = argNeighborhood;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCounty() {
/* 217 */     return this._county;
/*     */   }
/*     */   
/*     */   public void setCounty(String argCounty) {
/* 221 */     if (changed(argCounty, this._county, "county")) {
/* 222 */       this._county = argCounty;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 229 */     StringBuilder buf = new StringBuilder(512);
/* 230 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 231 */     if (getOrganizationId() != null) {
/* 232 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 234 */     if (getOrderId() != null) {
/* 235 */       buf.append("orderId").append("=").append(getOrderId()).append(" ");
/*     */     }
/* 237 */     if (getSequence() != null) {
/* 238 */       buf.append("sequence").append("=").append(getSequence()).append(" ");
/*     */     }
/* 240 */     if (getCreateDate() != null) {
/* 241 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 243 */     if (getCreateUserId() != null) {
/* 244 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 246 */     if (getUpdateDate() != null) {
/* 247 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 249 */     if (getUpdateUserId() != null) {
/* 250 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 252 */     if (getAddress1() != null) {
/* 253 */       buf.append("address1").append("=").append(getAddress1()).append(" ");
/*     */     }
/* 255 */     if (getAddress2() != null) {
/* 256 */       buf.append("address2").append("=").append(getAddress2()).append(" ");
/*     */     }
/* 258 */     if (getAddress3() != null) {
/* 259 */       buf.append("address3").append("=").append(getAddress3()).append(" ");
/*     */     }
/* 261 */     if (getAddress4() != null) {
/* 262 */       buf.append("address4").append("=").append(getAddress4()).append(" ");
/*     */     }
/* 264 */     if (getApartment() != null) {
/* 265 */       buf.append("apartment").append("=").append(getApartment()).append(" ");
/*     */     }
/* 267 */     if (getCity() != null) {
/* 268 */       buf.append("city").append("=").append(getCity()).append(" ");
/*     */     }
/* 270 */     if (getState() != null) {
/* 271 */       buf.append("state").append("=").append(getState()).append(" ");
/*     */     }
/* 273 */     if (getPostalCode() != null) {
/* 274 */       buf.append("postalCode").append("=").append(getPostalCode()).append(" ");
/*     */     }
/* 276 */     if (getCountry() != null) {
/* 277 */       buf.append("country").append("=").append(getCountry()).append(" ");
/*     */     }
/* 279 */     if (getNeighborhood() != null) {
/* 280 */       buf.append("neighborhood").append("=").append(getNeighborhood()).append(" ");
/*     */     }
/* 282 */     if (getCounty() != null) {
/* 283 */       buf.append("county").append("=").append(getCounty()).append(" ");
/*     */     }
/*     */     
/* 286 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 290 */     AddressModifierId id = new AddressModifierId();
/* 291 */     id.setOrganizationId(getOrganizationId());
/* 292 */     id.setOrderId(getOrderId());
/* 293 */     id.setSequence(getSequence());
/* 294 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 298 */     setOrganizationId(((AddressModifierId)argObjectId).getOrganizationId());
/* 299 */     setOrderId(((AddressModifierId)argObjectId).getOrderId());
/* 300 */     setSequence(((AddressModifierId)argObjectId).getSequence());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 304 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 308 */     StringBuilder buf = new StringBuilder(900);
/* 309 */     buf.append("<").append("dao").append(" name=\"AddressModifier\" cmd=\"" + getObjectStateString() + "\">");
/* 310 */     getFieldsAsXml(buf);
/* 311 */     buf.append("</").append("dao").append(">");
/*     */     
/* 313 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 317 */     Map<String, String> values = super.getValues();
/* 318 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 319 */     if (this._orderId != null) values.put("OrderId", DaoUtils.getXmlSafeFieldValue(12, this._orderId)); 
/* 320 */     if (this._sequence != null) values.put("Sequence", DaoUtils.getXmlSafeFieldValue(-5, this._sequence)); 
/* 321 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 322 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 323 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 324 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 325 */     if (this._address1 != null) values.put("Address1", DaoUtils.getXmlSafeFieldValue(12, this._address1)); 
/* 326 */     if (this._address2 != null) values.put("Address2", DaoUtils.getXmlSafeFieldValue(12, this._address2)); 
/* 327 */     if (this._address3 != null) values.put("Address3", DaoUtils.getXmlSafeFieldValue(12, this._address3)); 
/* 328 */     if (this._address4 != null) values.put("Address4", DaoUtils.getXmlSafeFieldValue(12, this._address4)); 
/* 329 */     if (this._apartment != null) values.put("Apartment", DaoUtils.getXmlSafeFieldValue(12, this._apartment)); 
/* 330 */     if (this._city != null) values.put("City", DaoUtils.getXmlSafeFieldValue(12, this._city)); 
/* 331 */     if (this._state != null) values.put("State", DaoUtils.getXmlSafeFieldValue(12, this._state)); 
/* 332 */     if (this._postalCode != null) values.put("PostalCode", DaoUtils.getXmlSafeFieldValue(12, this._postalCode)); 
/* 333 */     if (this._country != null) values.put("Country", DaoUtils.getXmlSafeFieldValue(12, this._country)); 
/* 334 */     if (this._neighborhood != null) values.put("Neighborhood", DaoUtils.getXmlSafeFieldValue(12, this._neighborhood)); 
/* 335 */     if (this._county != null) values.put("County", DaoUtils.getXmlSafeFieldValue(12, this._county)); 
/* 336 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 341 */     super.setValues(argValues);
/* 342 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 344 */       String fieldName = field.getKey();
/* 345 */       String fieldValue = field.getValue();
/* 346 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 350 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 351 */             setOrganizationId((Long)value);
/* 352 */           } catch (Exception ee) {
/* 353 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrderId":
/*     */           try {
/* 359 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 360 */             setOrderId((String)value);
/* 361 */           } catch (Exception ee) {
/* 362 */             throw new DtxException("An exception occurred while calling setOrderId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Sequence":
/*     */           try {
/* 368 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 369 */             setSequence((Long)value);
/* 370 */           } catch (Exception ee) {
/* 371 */             throw new DtxException("An exception occurred while calling setSequence() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 377 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 378 */             setCreateDate((Date)value);
/* 379 */           } catch (Exception ee) {
/* 380 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 386 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 387 */             setCreateUserId((String)value);
/* 388 */           } catch (Exception ee) {
/* 389 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 395 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 396 */             setUpdateDate((Date)value);
/* 397 */           } catch (Exception ee) {
/* 398 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 404 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 405 */             setUpdateUserId((String)value);
/* 406 */           } catch (Exception ee) {
/* 407 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Address1":
/*     */           try {
/* 413 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 414 */             setAddress1((String)value);
/* 415 */           } catch (Exception ee) {
/* 416 */             throw new DtxException("An exception occurred while calling setAddress1() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Address2":
/*     */           try {
/* 422 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 423 */             setAddress2((String)value);
/* 424 */           } catch (Exception ee) {
/* 425 */             throw new DtxException("An exception occurred while calling setAddress2() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Address3":
/*     */           try {
/* 431 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 432 */             setAddress3((String)value);
/* 433 */           } catch (Exception ee) {
/* 434 */             throw new DtxException("An exception occurred while calling setAddress3() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Address4":
/*     */           try {
/* 440 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 441 */             setAddress4((String)value);
/* 442 */           } catch (Exception ee) {
/* 443 */             throw new DtxException("An exception occurred while calling setAddress4() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Apartment":
/*     */           try {
/* 449 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 450 */             setApartment((String)value);
/* 451 */           } catch (Exception ee) {
/* 452 */             throw new DtxException("An exception occurred while calling setApartment() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "City":
/*     */           try {
/* 458 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 459 */             setCity((String)value);
/* 460 */           } catch (Exception ee) {
/* 461 */             throw new DtxException("An exception occurred while calling setCity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "State":
/*     */           try {
/* 467 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 468 */             setState((String)value);
/* 469 */           } catch (Exception ee) {
/* 470 */             throw new DtxException("An exception occurred while calling setState() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PostalCode":
/*     */           try {
/* 476 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 477 */             setPostalCode((String)value);
/* 478 */           } catch (Exception ee) {
/* 479 */             throw new DtxException("An exception occurred while calling setPostalCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Country":
/*     */           try {
/* 485 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 486 */             setCountry((String)value);
/* 487 */           } catch (Exception ee) {
/* 488 */             throw new DtxException("An exception occurred while calling setCountry() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Neighborhood":
/*     */           try {
/* 494 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 495 */             setNeighborhood((String)value);
/* 496 */           } catch (Exception ee) {
/* 497 */             throw new DtxException("An exception occurred while calling setNeighborhood() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "County":
/*     */           try {
/* 503 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 504 */             setCounty((String)value);
/* 505 */           } catch (Exception ee) {
/* 506 */             throw new DtxException("An exception occurred while calling setCounty() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\impl\AddressModifierDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */