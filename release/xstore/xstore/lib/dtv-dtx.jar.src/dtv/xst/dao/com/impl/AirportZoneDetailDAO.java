/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.AirportZoneDetailId;
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
/*     */ public class AirportZoneDetailDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 1260580392L;
/*  23 */   private static final Logger _logger = Logger.getLogger(AirportZoneDetailDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _zoneId;
/*     */   private String _destinationZoneId;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _taxCalculationMode;
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
/*     */   public String getZoneId() {
/*  45 */     return this._zoneId;
/*     */   }
/*     */   
/*     */   public void setZoneId(String argZoneId) {
/*  49 */     if (changed(argZoneId, this._zoneId, "zoneId")) {
/*  50 */       this._zoneId = (argZoneId != null && MANAGE_CASE) ? argZoneId.toUpperCase() : argZoneId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDestinationZoneId() {
/*  55 */     return this._destinationZoneId;
/*     */   }
/*     */   
/*     */   public void setDestinationZoneId(String argDestinationZoneId) {
/*  59 */     if (changed(argDestinationZoneId, this._destinationZoneId, "destinationZoneId")) {
/*  60 */       this._destinationZoneId = (argDestinationZoneId != null && MANAGE_CASE) ? argDestinationZoneId.toUpperCase() : argDestinationZoneId;
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
/*     */   public String getTaxCalculationMode() {
/* 107 */     return this._taxCalculationMode;
/*     */   }
/*     */   
/*     */   public void setTaxCalculationMode(String argTaxCalculationMode) {
/* 111 */     if (changed(argTaxCalculationMode, this._taxCalculationMode, "taxCalculationMode")) {
/* 112 */       this._taxCalculationMode = argTaxCalculationMode;
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
/* 124 */     if (getZoneId() != null) {
/* 125 */       buf.append("zoneId").append("=").append(getZoneId()).append(" ");
/*     */     }
/* 127 */     if (getDestinationZoneId() != null) {
/* 128 */       buf.append("destinationZoneId").append("=").append(getDestinationZoneId()).append(" ");
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
/* 142 */     if (getTaxCalculationMode() != null) {
/* 143 */       buf.append("taxCalculationMode").append("=").append(getTaxCalculationMode()).append(" ");
/*     */     }
/*     */     
/* 146 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 150 */     AirportZoneDetailId id = new AirportZoneDetailId();
/* 151 */     id.setOrganizationId(getOrganizationId());
/* 152 */     id.setZoneId(getZoneId());
/* 153 */     id.setDestinationZoneId(getDestinationZoneId());
/* 154 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 158 */     setOrganizationId(((AirportZoneDetailId)argObjectId).getOrganizationId());
/* 159 */     setZoneId(((AirportZoneDetailId)argObjectId).getZoneId());
/* 160 */     setDestinationZoneId(((AirportZoneDetailId)argObjectId).getDestinationZoneId());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 164 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 168 */     StringBuilder buf = new StringBuilder(400);
/* 169 */     buf.append("<").append("dao").append(" name=\"AirportZoneDetail\" cmd=\"" + getObjectStateString() + "\">");
/* 170 */     getFieldsAsXml(buf);
/* 171 */     buf.append("</").append("dao").append(">");
/*     */     
/* 173 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 177 */     Map<String, String> values = super.getValues();
/* 178 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 179 */     if (this._zoneId != null) values.put("ZoneId", DaoUtils.getXmlSafeFieldValue(12, this._zoneId)); 
/* 180 */     if (this._destinationZoneId != null) values.put("DestinationZoneId", DaoUtils.getXmlSafeFieldValue(12, this._destinationZoneId)); 
/* 181 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 182 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 183 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 184 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 185 */     if (this._taxCalculationMode != null) values.put("TaxCalculationMode", DaoUtils.getXmlSafeFieldValue(12, this._taxCalculationMode)); 
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
/*     */         case "ZoneId":
/*     */           try {
/* 209 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 210 */             setZoneId((String)value);
/* 211 */           } catch (Exception ee) {
/* 212 */             throw new DtxException("An exception occurred while calling setZoneId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DestinationZoneId":
/*     */           try {
/* 218 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 219 */             setDestinationZoneId((String)value);
/* 220 */           } catch (Exception ee) {
/* 221 */             throw new DtxException("An exception occurred while calling setDestinationZoneId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
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
/*     */         case "TaxCalculationMode":
/*     */           try {
/* 263 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 264 */             setTaxCalculationMode((String)value);
/* 265 */           } catch (Exception ee) {
/* 266 */             throw new DtxException("An exception occurred while calling setTaxCalculationMode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\AirportZoneDetailDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */