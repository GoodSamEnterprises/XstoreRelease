/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.AirportId;
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
/*     */ public class AirportDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 672986283L;
/*  23 */   private static final Logger _logger = Logger.getLogger(AirportDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private String _airportCode;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _zoneId;
/*     */   private String _airportName;
/*     */   private String _countryCode;
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
/*     */   public String getAirportCode() {
/*  46 */     return this._airportCode;
/*     */   }
/*     */   
/*     */   public void setAirportCode(String argAirportCode) {
/*  50 */     if (changed(argAirportCode, this._airportCode, "airportCode")) {
/*  51 */       this._airportCode = (argAirportCode != null && MANAGE_CASE) ? argAirportCode.toUpperCase() : argAirportCode;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  56 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  60 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  61 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  67 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  71 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  72 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/*  77 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/*  81 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/*  82 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/*  88 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/*  92 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/*  93 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getZoneId() {
/*  98 */     return this._zoneId;
/*     */   }
/*     */   
/*     */   public void setZoneId(String argZoneId) {
/* 102 */     if (changed(argZoneId, this._zoneId, "zoneId")) {
/* 103 */       this._zoneId = argZoneId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getAirportName() {
/* 108 */     return this._airportName;
/*     */   }
/*     */   
/*     */   public void setAirportName(String argAirportName) {
/* 112 */     if (changed(argAirportName, this._airportName, "airportName")) {
/* 113 */       this._airportName = argAirportName;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getCountryCode() {
/* 118 */     return this._countryCode;
/*     */   }
/*     */   
/*     */   public void setCountryCode(String argCountryCode) {
/* 122 */     if (changed(argCountryCode, this._countryCode, "countryCode")) {
/* 123 */       this._countryCode = argCountryCode;
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
/* 135 */     if (getAirportCode() != null) {
/* 136 */       buf.append("airportCode").append("=").append(getAirportCode()).append(" ");
/*     */     }
/* 138 */     if (getCreateDate() != null) {
/* 139 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 141 */     if (getCreateUserId() != null) {
/* 142 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 144 */     if (getUpdateDate() != null) {
/* 145 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 147 */     if (getUpdateUserId() != null) {
/* 148 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 150 */     if (getZoneId() != null) {
/* 151 */       buf.append("zoneId").append("=").append(getZoneId()).append(" ");
/*     */     }
/* 153 */     if (getAirportName() != null) {
/* 154 */       buf.append("airportName").append("=").append(getAirportName()).append(" ");
/*     */     }
/* 156 */     if (getCountryCode() != null) {
/* 157 */       buf.append("countryCode").append("=").append(getCountryCode()).append(" ");
/*     */     }
/*     */     
/* 160 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 164 */     AirportId id = new AirportId();
/* 165 */     id.setOrganizationId(getOrganizationId());
/* 166 */     id.setAirportCode(getAirportCode());
/* 167 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 171 */     setOrganizationId(((AirportId)argObjectId).getOrganizationId());
/* 172 */     setAirportCode(((AirportId)argObjectId).getAirportCode());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 176 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 180 */     StringBuilder buf = new StringBuilder(450);
/* 181 */     buf.append("<").append("dao").append(" name=\"Airport\" cmd=\"" + getObjectStateString() + "\">");
/* 182 */     getFieldsAsXml(buf);
/* 183 */     buf.append("</").append("dao").append(">");
/*     */     
/* 185 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 189 */     Map<String, String> values = super.getValues();
/* 190 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 191 */     if (this._airportCode != null) values.put("AirportCode", DaoUtils.getXmlSafeFieldValue(12, this._airportCode)); 
/* 192 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 193 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 194 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 195 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 196 */     if (this._zoneId != null) values.put("ZoneId", DaoUtils.getXmlSafeFieldValue(12, this._zoneId)); 
/* 197 */     if (this._airportName != null) values.put("AirportName", DaoUtils.getXmlSafeFieldValue(12, this._airportName)); 
/* 198 */     if (this._countryCode != null) values.put("CountryCode", DaoUtils.getXmlSafeFieldValue(12, this._countryCode)); 
/* 199 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 204 */     super.setValues(argValues);
/* 205 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 207 */       String fieldName = field.getKey();
/* 208 */       String fieldValue = field.getValue();
/* 209 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 213 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 214 */             setOrganizationId((Long)value);
/* 215 */           } catch (Exception ee) {
/* 216 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AirportCode":
/*     */           try {
/* 222 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 223 */             setAirportCode((String)value);
/* 224 */           } catch (Exception ee) {
/* 225 */             throw new DtxException("An exception occurred while calling setAirportCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 231 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 232 */             setCreateDate((Date)value);
/* 233 */           } catch (Exception ee) {
/* 234 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 240 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 241 */             setCreateUserId((String)value);
/* 242 */           } catch (Exception ee) {
/* 243 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 249 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 250 */             setUpdateDate((Date)value);
/* 251 */           } catch (Exception ee) {
/* 252 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 258 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 259 */             setUpdateUserId((String)value);
/* 260 */           } catch (Exception ee) {
/* 261 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ZoneId":
/*     */           try {
/* 267 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 268 */             setZoneId((String)value);
/* 269 */           } catch (Exception ee) {
/* 270 */             throw new DtxException("An exception occurred while calling setZoneId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "AirportName":
/*     */           try {
/* 276 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 277 */             setAirportName((String)value);
/* 278 */           } catch (Exception ee) {
/* 279 */             throw new DtxException("An exception occurred while calling setAirportName() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CountryCode":
/*     */           try {
/* 285 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 286 */             setCountryCode((String)value);
/* 287 */           } catch (Exception ee) {
/* 288 */             throw new DtxException("An exception occurred while calling setCountryCode() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\AirportDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */