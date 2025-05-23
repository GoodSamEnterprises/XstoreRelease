/*     */ package dtv.xst.dao.ttr.impl;
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
/*     */ public class SendCheckTenderLineItemDAO
/*     */   extends TenderLineItemDAO
/*     */ {
/*     */   private static final long serialVersionUID = -1307877765L;
/*  23 */   private static final Logger _logger = Logger.getLogger(SendCheckTenderLineItemDAO.class);
/*     */   
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
/*     */   private String _country;
/*     */   private String _payableToName;
/*     */   private String _postalCode;
/*     */   private String _state;
/*     */   private String _sendCheckReasonCode;
/*     */   private String _neighborhood;
/*     */   private String _county;
/*     */   
/*     */   public Date getCreateDate() {
/*  44 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  48 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  49 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  55 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  59 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  60 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  65 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  69 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  70 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  76 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  80 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  81 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAddress1() {
/*  86 */     return this._address1;
/*     */   }
/*     */   
/*     */   public void setAddress1(String argAddress1) {
/*  90 */     if (changed(argAddress1, this._address1, "address1")) {
/*  91 */       this._address1 = argAddress1;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAddress2() {
/*  96 */     return this._address2;
/*     */   }
/*     */   
/*     */   public void setAddress2(String argAddress2) {
/* 100 */     if (changed(argAddress2, this._address2, "address2")) {
/* 101 */       this._address2 = argAddress2;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAddress3() {
/* 106 */     return this._address3;
/*     */   }
/*     */   
/*     */   public void setAddress3(String argAddress3) {
/* 110 */     if (changed(argAddress3, this._address3, "address3")) {
/* 111 */       this._address3 = argAddress3;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAddress4() {
/* 116 */     return this._address4;
/*     */   }
/*     */   
/*     */   public void setAddress4(String argAddress4) {
/* 120 */     if (changed(argAddress4, this._address4, "address4")) {
/* 121 */       this._address4 = argAddress4;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getApartment() {
/* 126 */     return this._apartment;
/*     */   }
/*     */   
/*     */   public void setApartment(String argApartment) {
/* 130 */     if (changed(argApartment, this._apartment, "apartment")) {
/* 131 */       this._apartment = argApartment;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCity() {
/* 136 */     return this._city;
/*     */   }
/*     */   
/*     */   public void setCity(String argCity) {
/* 140 */     if (changed(argCity, this._city, "city")) {
/* 141 */       this._city = argCity;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCountry() {
/* 146 */     return this._country;
/*     */   }
/*     */   
/*     */   public void setCountry(String argCountry) {
/* 150 */     if (changed(argCountry, this._country, "country")) {
/* 151 */       this._country = argCountry;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPayableToName() {
/* 156 */     return this._payableToName;
/*     */   }
/*     */   
/*     */   public void setPayableToName(String argPayableToName) {
/* 160 */     if (changed(argPayableToName, this._payableToName, "payableToName")) {
/* 161 */       this._payableToName = argPayableToName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPostalCode() {
/* 166 */     return this._postalCode;
/*     */   }
/*     */   
/*     */   public void setPostalCode(String argPostalCode) {
/* 170 */     if (changed(argPostalCode, this._postalCode, "postalCode")) {
/* 171 */       this._postalCode = argPostalCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getState() {
/* 176 */     return this._state;
/*     */   }
/*     */   
/*     */   public void setState(String argState) {
/* 180 */     if (changed(argState, this._state, "state")) {
/* 181 */       this._state = argState;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getSendCheckReasonCode() {
/* 186 */     return this._sendCheckReasonCode;
/*     */   }
/*     */   
/*     */   public void setSendCheckReasonCode(String argSendCheckReasonCode) {
/* 190 */     if (changed(argSendCheckReasonCode, this._sendCheckReasonCode, "sendCheckReasonCode")) {
/* 191 */       this._sendCheckReasonCode = argSendCheckReasonCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getNeighborhood() {
/* 196 */     return this._neighborhood;
/*     */   }
/*     */   
/*     */   public void setNeighborhood(String argNeighborhood) {
/* 200 */     if (changed(argNeighborhood, this._neighborhood, "neighborhood")) {
/* 201 */       this._neighborhood = argNeighborhood;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCounty() {
/* 206 */     return this._county;
/*     */   }
/*     */   
/*     */   public void setCounty(String argCounty) {
/* 210 */     if (changed(argCounty, this._county, "county")) {
/* 211 */       this._county = argCounty;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 218 */     StringBuilder buf = new StringBuilder(512);
/* 219 */     buf.append(super.toString());
/* 220 */     if (getCreateDate() != null) {
/* 221 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 223 */     if (getCreateUserId() != null) {
/* 224 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 226 */     if (getUpdateDate() != null) {
/* 227 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 229 */     if (getUpdateUserId() != null) {
/* 230 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 232 */     if (getAddress1() != null) {
/* 233 */       buf.append("address1").append("=").append(getAddress1()).append(" ");
/*     */     }
/* 235 */     if (getAddress2() != null) {
/* 236 */       buf.append("address2").append("=").append(getAddress2()).append(" ");
/*     */     }
/* 238 */     if (getAddress3() != null) {
/* 239 */       buf.append("address3").append("=").append(getAddress3()).append(" ");
/*     */     }
/* 241 */     if (getAddress4() != null) {
/* 242 */       buf.append("address4").append("=").append(getAddress4()).append(" ");
/*     */     }
/* 244 */     if (getApartment() != null) {
/* 245 */       buf.append("apartment").append("=").append(getApartment()).append(" ");
/*     */     }
/* 247 */     if (getCity() != null) {
/* 248 */       buf.append("city").append("=").append(getCity()).append(" ");
/*     */     }
/* 250 */     if (getCountry() != null) {
/* 251 */       buf.append("country").append("=").append(getCountry()).append(" ");
/*     */     }
/* 253 */     if (getPayableToName() != null) {
/* 254 */       buf.append("payableToName").append("=").append(getPayableToName()).append(" ");
/*     */     }
/* 256 */     if (getPostalCode() != null) {
/* 257 */       buf.append("postalCode").append("=").append(getPostalCode()).append(" ");
/*     */     }
/* 259 */     if (getState() != null) {
/* 260 */       buf.append("state").append("=").append(getState()).append(" ");
/*     */     }
/* 262 */     if (getSendCheckReasonCode() != null) {
/* 263 */       buf.append("sendCheckReasonCode").append("=").append(getSendCheckReasonCode()).append(" ");
/*     */     }
/* 265 */     if (getNeighborhood() != null) {
/* 266 */       buf.append("neighborhood").append("=").append(getNeighborhood()).append(" ");
/*     */     }
/* 268 */     if (getCounty() != null) {
/* 269 */       buf.append("county").append("=").append(getCounty()).append(" ");
/*     */     }
/*     */     
/* 272 */     return buf.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXmlString() {
/* 277 */     StringBuilder buf = new StringBuilder(2500);
/* 278 */     buf.append("<").append("dao").append(" name=\"SendCheckTenderLineItem\" cmd=\"" + getObjectStateString() + "\">");
/* 279 */     getFieldsAsXml(buf);
/* 280 */     buf.append("</").append("dao").append(">");
/*     */     
/* 282 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 286 */     Map<String, String> values = super.getValues();
/* 287 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 288 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 289 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 290 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 291 */     if (this._address1 != null) values.put("Address1", DaoUtils.getXmlSafeFieldValue(12, this._address1)); 
/* 292 */     if (this._address2 != null) values.put("Address2", DaoUtils.getXmlSafeFieldValue(12, this._address2)); 
/* 293 */     if (this._address3 != null) values.put("Address3", DaoUtils.getXmlSafeFieldValue(12, this._address3)); 
/* 294 */     if (this._address4 != null) values.put("Address4", DaoUtils.getXmlSafeFieldValue(12, this._address4)); 
/* 295 */     if (this._apartment != null) values.put("Apartment", DaoUtils.getXmlSafeFieldValue(12, this._apartment)); 
/* 296 */     if (this._city != null) values.put("City", DaoUtils.getXmlSafeFieldValue(12, this._city)); 
/* 297 */     if (this._country != null) values.put("Country", DaoUtils.getXmlSafeFieldValue(12, this._country)); 
/* 298 */     if (this._payableToName != null) values.put("PayableToName", DaoUtils.getXmlSafeFieldValue(12, this._payableToName)); 
/* 299 */     if (this._postalCode != null) values.put("PostalCode", DaoUtils.getXmlSafeFieldValue(12, this._postalCode)); 
/* 300 */     if (this._state != null) values.put("State", DaoUtils.getXmlSafeFieldValue(12, this._state)); 
/* 301 */     if (this._sendCheckReasonCode != null) values.put("SendCheckReasonCode", DaoUtils.getXmlSafeFieldValue(12, this._sendCheckReasonCode)); 
/* 302 */     if (this._neighborhood != null) values.put("Neighborhood", DaoUtils.getXmlSafeFieldValue(12, this._neighborhood)); 
/* 303 */     if (this._county != null) values.put("County", DaoUtils.getXmlSafeFieldValue(12, this._county)); 
/* 304 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 309 */     super.setValues(argValues);
/* 310 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 312 */       String fieldName = field.getKey();
/* 313 */       String fieldValue = field.getValue();
/* 314 */       switch (fieldName) {
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 318 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 319 */             setCreateDate((Date)value);
/* 320 */           } catch (Exception ee) {
/* 321 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 327 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 328 */             setCreateUserId((String)value);
/* 329 */           } catch (Exception ee) {
/* 330 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 336 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 337 */             setUpdateDate((Date)value);
/* 338 */           } catch (Exception ee) {
/* 339 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 345 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 346 */             setUpdateUserId((String)value);
/* 347 */           } catch (Exception ee) {
/* 348 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Address1":
/*     */           try {
/* 354 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 355 */             setAddress1((String)value);
/* 356 */           } catch (Exception ee) {
/* 357 */             throw new DtxException("An exception occurred while calling setAddress1() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Address2":
/*     */           try {
/* 363 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 364 */             setAddress2((String)value);
/* 365 */           } catch (Exception ee) {
/* 366 */             throw new DtxException("An exception occurred while calling setAddress2() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Address3":
/*     */           try {
/* 372 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 373 */             setAddress3((String)value);
/* 374 */           } catch (Exception ee) {
/* 375 */             throw new DtxException("An exception occurred while calling setAddress3() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Address4":
/*     */           try {
/* 381 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 382 */             setAddress4((String)value);
/* 383 */           } catch (Exception ee) {
/* 384 */             throw new DtxException("An exception occurred while calling setAddress4() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Apartment":
/*     */           try {
/* 390 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 391 */             setApartment((String)value);
/* 392 */           } catch (Exception ee) {
/* 393 */             throw new DtxException("An exception occurred while calling setApartment() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "City":
/*     */           try {
/* 399 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 400 */             setCity((String)value);
/* 401 */           } catch (Exception ee) {
/* 402 */             throw new DtxException("An exception occurred while calling setCity() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Country":
/*     */           try {
/* 408 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 409 */             setCountry((String)value);
/* 410 */           } catch (Exception ee) {
/* 411 */             throw new DtxException("An exception occurred while calling setCountry() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PayableToName":
/*     */           try {
/* 417 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 418 */             setPayableToName((String)value);
/* 419 */           } catch (Exception ee) {
/* 420 */             throw new DtxException("An exception occurred while calling setPayableToName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PostalCode":
/*     */           try {
/* 426 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 427 */             setPostalCode((String)value);
/* 428 */           } catch (Exception ee) {
/* 429 */             throw new DtxException("An exception occurred while calling setPostalCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "State":
/*     */           try {
/* 435 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 436 */             setState((String)value);
/* 437 */           } catch (Exception ee) {
/* 438 */             throw new DtxException("An exception occurred while calling setState() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "SendCheckReasonCode":
/*     */           try {
/* 444 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 445 */             setSendCheckReasonCode((String)value);
/* 446 */           } catch (Exception ee) {
/* 447 */             throw new DtxException("An exception occurred while calling setSendCheckReasonCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Neighborhood":
/*     */           try {
/* 453 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 454 */             setNeighborhood((String)value);
/* 455 */           } catch (Exception ee) {
/* 456 */             throw new DtxException("An exception occurred while calling setNeighborhood() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "County":
/*     */           try {
/* 462 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 463 */             setCounty((String)value);
/* 464 */           } catch (Exception ee) {
/* 465 */             throw new DtxException("An exception occurred while calling setCounty() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ttr\impl\SendCheckTenderLineItemDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */