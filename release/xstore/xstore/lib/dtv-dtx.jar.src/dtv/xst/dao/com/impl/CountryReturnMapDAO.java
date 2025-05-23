/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.CountryReturnMapId;
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
/*     */ public class CountryReturnMapDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 926734134L;
/*  23 */   private static final Logger _logger = Logger.getLogger(CountryReturnMapDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _purchasedFrom;
/*     */   private String _returnTo;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*  32 */   private Boolean _disallowCrossBorderFlag = Boolean.FALSE;
/*     */   
/*     */   public Long getOrganizationId() {
/*  35 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  39 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  40 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getPurchasedFrom() {
/*  45 */     return this._purchasedFrom;
/*     */   }
/*     */   
/*     */   public void setPurchasedFrom(String argPurchasedFrom) {
/*  49 */     if (changed(argPurchasedFrom, this._purchasedFrom, "purchasedFrom")) {
/*  50 */       this._purchasedFrom = (argPurchasedFrom != null && MANAGE_CASE) ? argPurchasedFrom.toUpperCase() : argPurchasedFrom;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getReturnTo() {
/*  55 */     return this._returnTo;
/*     */   }
/*     */   
/*     */   public void setReturnTo(String argReturnTo) {
/*  59 */     if (changed(argReturnTo, this._returnTo, "returnTo")) {
/*  60 */       this._returnTo = (argReturnTo != null && MANAGE_CASE) ? argReturnTo.toUpperCase() : argReturnTo;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  65 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  69 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  70 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  76 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  80 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  81 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  86 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  90 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  91 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  97 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 101 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 102 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Boolean getDisallowCrossBorderFlag() {
/* 107 */     return this._disallowCrossBorderFlag;
/*     */   }
/*     */   
/*     */   public void setDisallowCrossBorderFlag(Boolean argDisallowCrossBorderFlag) {
/* 111 */     if (changed(argDisallowCrossBorderFlag, this._disallowCrossBorderFlag, "disallowCrossBorderFlag")) {
/* 112 */       this._disallowCrossBorderFlag = argDisallowCrossBorderFlag;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 119 */     StringBuilder buf = new StringBuilder(512);
/* 120 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 121 */     if (getOrganizationId() != null) {
/* 122 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 124 */     if (getPurchasedFrom() != null) {
/* 125 */       buf.append("purchasedFrom").append("=").append(getPurchasedFrom()).append(" ");
/*     */     }
/* 127 */     if (getReturnTo() != null) {
/* 128 */       buf.append("returnTo").append("=").append(getReturnTo()).append(" ");
/*     */     }
/* 130 */     if (getCreateDate() != null) {
/* 131 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 133 */     if (getCreateUserId() != null) {
/* 134 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 136 */     if (getUpdateDate() != null) {
/* 137 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 139 */     if (getUpdateUserId() != null) {
/* 140 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 142 */     if (getDisallowCrossBorderFlag() != null && getDisallowCrossBorderFlag().booleanValue()) {
/* 143 */       buf.append("disallowCrossBorderFlag").append("=").append(getDisallowCrossBorderFlag()).append(" ");
/*     */     }
/*     */     
/* 146 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 150 */     CountryReturnMapId id = new CountryReturnMapId();
/* 151 */     id.setOrganizationId(getOrganizationId());
/* 152 */     id.setPurchasedFrom(getPurchasedFrom());
/* 153 */     id.setReturnTo(getReturnTo());
/* 154 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 158 */     setOrganizationId(((CountryReturnMapId)argObjectId).getOrganizationId());
/* 159 */     setPurchasedFrom(((CountryReturnMapId)argObjectId).getPurchasedFrom());
/* 160 */     setReturnTo(((CountryReturnMapId)argObjectId).getReturnTo());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 164 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 168 */     StringBuilder buf = new StringBuilder(400);
/* 169 */     buf.append("<").append("dao").append(" name=\"CountryReturnMap\" cmd=\"" + getObjectStateString() + "\">");
/* 170 */     getFieldsAsXml(buf);
/* 171 */     buf.append("</").append("dao").append(">");
/*     */     
/* 173 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 177 */     Map<String, String> values = super.getValues();
/* 178 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 179 */     if (this._purchasedFrom != null) values.put("PurchasedFrom", DaoUtils.getXmlSafeFieldValue(12, this._purchasedFrom)); 
/* 180 */     if (this._returnTo != null) values.put("ReturnTo", DaoUtils.getXmlSafeFieldValue(12, this._returnTo)); 
/* 181 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 182 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 183 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 184 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 185 */     if (this._disallowCrossBorderFlag != null) values.put("DisallowCrossBorderFlag", DaoUtils.getXmlSafeFieldValue(-7, this._disallowCrossBorderFlag)); 
/* 186 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 191 */     super.setValues(argValues);
/* 192 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 194 */       String fieldName = field.getKey();
/* 195 */       String fieldValue = field.getValue();
/* 196 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 200 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 201 */             setOrganizationId((Long)value);
/* 202 */           } catch (Exception ee) {
/* 203 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "PurchasedFrom":
/*     */           try {
/* 209 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 210 */             setPurchasedFrom((String)value);
/* 211 */           } catch (Exception ee) {
/* 212 */             throw new DtxException("An exception occurred while calling setPurchasedFrom() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ReturnTo":
/*     */           try {
/* 218 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 219 */             setReturnTo((String)value);
/* 220 */           } catch (Exception ee) {
/* 221 */             throw new DtxException("An exception occurred while calling setReturnTo() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 227 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 228 */             setCreateDate((Date)value);
/* 229 */           } catch (Exception ee) {
/* 230 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 236 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 237 */             setCreateUserId((String)value);
/* 238 */           } catch (Exception ee) {
/* 239 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 245 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 246 */             setUpdateDate((Date)value);
/* 247 */           } catch (Exception ee) {
/* 248 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 254 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 255 */             setUpdateUserId((String)value);
/* 256 */           } catch (Exception ee) {
/* 257 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DisallowCrossBorderFlag":
/*     */           try {
/* 263 */             Object value = DaoUtils.getFieldValueForXmlString(-7, fieldValue);
/* 264 */             setDisallowCrossBorderFlag((Boolean)value);
/* 265 */           } catch (Exception ee) {
/* 266 */             throw new DtxException("An exception occurred while calling setDisallowCrossBorderFlag() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\CountryReturnMapDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */