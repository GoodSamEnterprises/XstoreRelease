/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.itm.VendorId;
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
/*     */ public class VendorDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = -1736208024L;
/*  23 */   private static final Logger _logger = Logger.getLogger(VendorDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _vendorId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _orgCode;
/*     */   private String _orgValue;
/*     */   private String _name;
/*     */   private String _typeCode;
/*     */   private String _telephone;
/*     */   private String _fax;
/*     */   private String _contact;
/*     */   private String _contactTelephone;
/*     */   private String _buyer;
/*     */   private String _status;
/*     */   private String _addressId;
/*     */   
/*     */   public Long getOrganizationId() {
/*  44 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  48 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  49 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getVendorId() {
/*  54 */     return this._vendorId;
/*     */   }
/*     */   
/*     */   public void setVendorId(String argVendorId) {
/*  58 */     if (changed(argVendorId, this._vendorId, "vendorId")) {
/*  59 */       this._vendorId = (argVendorId != null && MANAGE_CASE) ? argVendorId.toUpperCase() : argVendorId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  64 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  68 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  69 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  75 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  79 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  80 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  85 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  89 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  90 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  96 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 100 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 101 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgCode() {
/* 106 */     return this._orgCode;
/*     */   }
/*     */   
/*     */   public void setOrgCode(String argOrgCode) {
/* 110 */     if (changed(argOrgCode, this._orgCode, "orgCode")) {
/* 111 */       this._orgCode = argOrgCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOrgValue() {
/* 116 */     return this._orgValue;
/*     */   }
/*     */   
/*     */   public void setOrgValue(String argOrgValue) {
/* 120 */     if (changed(argOrgValue, this._orgValue, "orgValue")) {
/* 121 */       this._orgValue = argOrgValue;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getName() {
/* 126 */     return this._name;
/*     */   }
/*     */   
/*     */   public void setName(String argName) {
/* 130 */     if (changed(argName, this._name, "name")) {
/* 131 */       this._name = argName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTypeCode() {
/* 136 */     return this._typeCode;
/*     */   }
/*     */   
/*     */   public void setTypeCode(String argTypeCode) {
/* 140 */     if (changed(argTypeCode, this._typeCode, "typeCode")) {
/* 141 */       this._typeCode = argTypeCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getTelephone() {
/* 146 */     return this._telephone;
/*     */   }
/*     */   
/*     */   public void setTelephone(String argTelephone) {
/* 150 */     if (changed(argTelephone, this._telephone, "telephone")) {
/* 151 */       this._telephone = argTelephone;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getFax() {
/* 156 */     return this._fax;
/*     */   }
/*     */   
/*     */   public void setFax(String argFax) {
/* 160 */     if (changed(argFax, this._fax, "fax")) {
/* 161 */       this._fax = argFax;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getContact() {
/* 166 */     return this._contact;
/*     */   }
/*     */   
/*     */   public void setContact(String argContact) {
/* 170 */     if (changed(argContact, this._contact, "contact")) {
/* 171 */       this._contact = argContact;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getContactTelephone() {
/* 176 */     return this._contactTelephone;
/*     */   }
/*     */   
/*     */   public void setContactTelephone(String argContactTelephone) {
/* 180 */     if (changed(argContactTelephone, this._contactTelephone, "contactTelephone")) {
/* 181 */       this._contactTelephone = argContactTelephone;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getBuyer() {
/* 186 */     return this._buyer;
/*     */   }
/*     */   
/*     */   public void setBuyer(String argBuyer) {
/* 190 */     if (changed(argBuyer, this._buyer, "buyer")) {
/* 191 */       this._buyer = argBuyer;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getStatus() {
/* 196 */     return this._status;
/*     */   }
/*     */   
/*     */   public void setStatus(String argStatus) {
/* 200 */     if (changed(argStatus, this._status, "status")) {
/* 201 */       this._status = argStatus;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAddressId() {
/* 206 */     return this._addressId;
/*     */   }
/*     */   
/*     */   public void setAddressId(String argAddressId) {
/* 210 */     if (changed(argAddressId, this._addressId, "addressId")) {
/* 211 */       this._addressId = argAddressId;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 218 */     StringBuilder buf = new StringBuilder(512);
/* 219 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 220 */     if (getOrganizationId() != null) {
/* 221 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 223 */     if (getVendorId() != null) {
/* 224 */       buf.append("vendorId").append("=").append(getVendorId()).append(" ");
/*     */     }
/* 226 */     if (getCreateDate() != null) {
/* 227 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 229 */     if (getCreateUserId() != null) {
/* 230 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 232 */     if (getUpdateDate() != null) {
/* 233 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 235 */     if (getUpdateUserId() != null) {
/* 236 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 238 */     if (getOrgCode() != null) {
/* 239 */       buf.append("orgCode").append("=").append(getOrgCode()).append(" ");
/*     */     }
/* 241 */     if (getOrgValue() != null) {
/* 242 */       buf.append("orgValue").append("=").append(getOrgValue()).append(" ");
/*     */     }
/* 244 */     if (getName() != null) {
/* 245 */       buf.append("name").append("=").append(getName()).append(" ");
/*     */     }
/* 247 */     if (getTypeCode() != null) {
/* 248 */       buf.append("typeCode").append("=").append(getTypeCode()).append(" ");
/*     */     }
/* 250 */     if (getTelephone() != null) {
/* 251 */       buf.append("telephone").append("=").append(getTelephone()).append(" ");
/*     */     }
/* 253 */     if (getFax() != null) {
/* 254 */       buf.append("fax").append("=").append(getFax()).append(" ");
/*     */     }
/* 256 */     if (getContact() != null) {
/* 257 */       buf.append("contact").append("=").append(getContact()).append(" ");
/*     */     }
/* 259 */     if (getContactTelephone() != null) {
/* 260 */       buf.append("contactTelephone").append("=").append(getContactTelephone()).append(" ");
/*     */     }
/* 262 */     if (getBuyer() != null) {
/* 263 */       buf.append("buyer").append("=").append(getBuyer()).append(" ");
/*     */     }
/* 265 */     if (getStatus() != null) {
/* 266 */       buf.append("status").append("=").append(getStatus()).append(" ");
/*     */     }
/* 268 */     if (getAddressId() != null) {
/* 269 */       buf.append("addressId").append("=").append(getAddressId()).append(" ");
/*     */     }
/*     */     
/* 272 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 276 */     VendorId id = new VendorId();
/* 277 */     id.setOrganizationId(getOrganizationId());
/* 278 */     id.setVendorId(getVendorId());
/* 279 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 283 */     setOrganizationId(((VendorId)argObjectId).getOrganizationId());
/* 284 */     setVendorId(((VendorId)argObjectId).getVendorId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 288 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 292 */     StringBuilder buf = new StringBuilder(850);
/* 293 */     buf.append("<").append("dao").append(" name=\"Vendor\" cmd=\"" + getObjectStateString() + "\">");
/* 294 */     getFieldsAsXml(buf);
/* 295 */     buf.append("</").append("dao").append(">");
/*     */     
/* 297 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 301 */     Map<String, String> values = super.getValues();
/* 302 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 303 */     if (this._vendorId != null) values.put("VendorId", DaoUtils.getXmlSafeFieldValue(12, this._vendorId)); 
/* 304 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 305 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 306 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 307 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 308 */     if (this._orgCode != null) values.put("OrgCode", DaoUtils.getXmlSafeFieldValue(12, this._orgCode)); 
/* 309 */     if (this._orgValue != null) values.put("OrgValue", DaoUtils.getXmlSafeFieldValue(12, this._orgValue)); 
/* 310 */     if (this._name != null) values.put("Name", DaoUtils.getXmlSafeFieldValue(12, this._name)); 
/* 311 */     if (this._typeCode != null) values.put("TypeCode", DaoUtils.getXmlSafeFieldValue(12, this._typeCode)); 
/* 312 */     if (this._telephone != null) values.put("Telephone", DaoUtils.getXmlSafeFieldValue(12, this._telephone)); 
/* 313 */     if (this._fax != null) values.put("Fax", DaoUtils.getXmlSafeFieldValue(12, this._fax)); 
/* 314 */     if (this._contact != null) values.put("Contact", DaoUtils.getXmlSafeFieldValue(12, this._contact)); 
/* 315 */     if (this._contactTelephone != null) values.put("ContactTelephone", DaoUtils.getXmlSafeFieldValue(12, this._contactTelephone)); 
/* 316 */     if (this._buyer != null) values.put("Buyer", DaoUtils.getXmlSafeFieldValue(12, this._buyer)); 
/* 317 */     if (this._status != null) values.put("Status", DaoUtils.getXmlSafeFieldValue(12, this._status)); 
/* 318 */     if (this._addressId != null) values.put("AddressId", DaoUtils.getXmlSafeFieldValue(12, this._addressId)); 
/* 319 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 324 */     super.setValues(argValues);
/* 325 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 327 */       String fieldName = field.getKey();
/* 328 */       String fieldValue = field.getValue();
/* 329 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 333 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 334 */             setOrganizationId((Long)value);
/* 335 */           } catch (Exception ee) {
/* 336 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "VendorId":
/*     */           try {
/* 342 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 343 */             setVendorId((String)value);
/* 344 */           } catch (Exception ee) {
/* 345 */             throw new DtxException("An exception occurred while calling setVendorId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 351 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 352 */             setCreateDate((Date)value);
/* 353 */           } catch (Exception ee) {
/* 354 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 360 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 361 */             setCreateUserId((String)value);
/* 362 */           } catch (Exception ee) {
/* 363 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 369 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 370 */             setUpdateDate((Date)value);
/* 371 */           } catch (Exception ee) {
/* 372 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 378 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 379 */             setUpdateUserId((String)value);
/* 380 */           } catch (Exception ee) {
/* 381 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgCode":
/*     */           try {
/* 387 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 388 */             setOrgCode((String)value);
/* 389 */           } catch (Exception ee) {
/* 390 */             throw new DtxException("An exception occurred while calling setOrgCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OrgValue":
/*     */           try {
/* 396 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 397 */             setOrgValue((String)value);
/* 398 */           } catch (Exception ee) {
/* 399 */             throw new DtxException("An exception occurred while calling setOrgValue() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Name":
/*     */           try {
/* 405 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 406 */             setName((String)value);
/* 407 */           } catch (Exception ee) {
/* 408 */             throw new DtxException("An exception occurred while calling setName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "TypeCode":
/*     */           try {
/* 414 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 415 */             setTypeCode((String)value);
/* 416 */           } catch (Exception ee) {
/* 417 */             throw new DtxException("An exception occurred while calling setTypeCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Telephone":
/*     */           try {
/* 423 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 424 */             setTelephone((String)value);
/* 425 */           } catch (Exception ee) {
/* 426 */             throw new DtxException("An exception occurred while calling setTelephone() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Fax":
/*     */           try {
/* 432 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 433 */             setFax((String)value);
/* 434 */           } catch (Exception ee) {
/* 435 */             throw new DtxException("An exception occurred while calling setFax() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Contact":
/*     */           try {
/* 441 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 442 */             setContact((String)value);
/* 443 */           } catch (Exception ee) {
/* 444 */             throw new DtxException("An exception occurred while calling setContact() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ContactTelephone":
/*     */           try {
/* 450 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 451 */             setContactTelephone((String)value);
/* 452 */           } catch (Exception ee) {
/* 453 */             throw new DtxException("An exception occurred while calling setContactTelephone() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Buyer":
/*     */           try {
/* 459 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 460 */             setBuyer((String)value);
/* 461 */           } catch (Exception ee) {
/* 462 */             throw new DtxException("An exception occurred while calling setBuyer() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Status":
/*     */           try {
/* 468 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 469 */             setStatus((String)value);
/* 470 */           } catch (Exception ee) {
/* 471 */             throw new DtxException("An exception occurred while calling setStatus() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AddressId":
/*     */           try {
/* 477 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 478 */             setAddressId((String)value);
/* 479 */           } catch (Exception ee) {
/* 480 */             throw new DtxException("An exception occurred while calling setAddressId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\VendorDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */