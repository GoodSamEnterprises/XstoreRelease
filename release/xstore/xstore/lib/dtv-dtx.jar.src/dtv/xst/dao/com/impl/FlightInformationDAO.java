/*     */ package dtv.xst.dao.com.impl;
/*     */ 
/*     */ import dtv.data2.access.DaoUtils;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.data2.access.impl.AbstractDAOImpl;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.xst.dao.com.FlightInformationId;
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
/*     */ public class FlightInformationDAO
/*     */   extends AbstractDAOImpl
/*     */ {
/*     */   private static final long serialVersionUID = 766554748L;
/*  23 */   private static final Logger _logger = Logger.getLogger(FlightInformationDAO.class);
/*     */   
/*     */   private Long _organizationId;
/*     */   private DtvDate _scheduledDateTime;
/*     */   private String _flightNumber;
/*     */   private String _originAirport;
/*     */   private DtvDate _createDate;
/*     */   private String _createUserId;
/*     */   private DtvDate _updateDate;
/*     */   private String _updateUserId;
/*     */   private String _destinationAirport;
/*     */   private String _via1Airport;
/*     */   private String _via2Airport;
/*     */   private String _via3Airport;
/*     */   
/*     */   public Long getOrganizationId() {
/*  39 */     return this._organizationId;
/*     */   }
/*     */   
/*     */   public void setOrganizationId(Long argOrganizationId) {
/*  43 */     if (changed(argOrganizationId, this._organizationId, "organizationId")) {
/*  44 */       this._organizationId = argOrganizationId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getScheduledDateTime() {
/*  49 */     return (Date)this._scheduledDateTime;
/*     */   }
/*     */   
/*     */   public void setScheduledDateTime(Date argScheduledDateTime) {
/*  53 */     if (changed(argScheduledDateTime, this._scheduledDateTime, "scheduledDateTime")) {
/*  54 */       this._scheduledDateTime = (argScheduledDateTime == null || argScheduledDateTime instanceof DtvDate) ? (DtvDate)argScheduledDateTime : new DtvDate(argScheduledDateTime);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getFlightNumber() {
/*  60 */     return this._flightNumber;
/*     */   }
/*     */   
/*     */   public void setFlightNumber(String argFlightNumber) {
/*  64 */     if (changed(argFlightNumber, this._flightNumber, "flightNumber")) {
/*  65 */       this._flightNumber = (argFlightNumber != null && MANAGE_CASE) ? argFlightNumber.toUpperCase() : argFlightNumber;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getOriginAirport() {
/*  70 */     return this._originAirport;
/*     */   }
/*     */   
/*     */   public void setOriginAirport(String argOriginAirport) {
/*  74 */     if (changed(argOriginAirport, this._originAirport, "originAirport")) {
/*  75 */       this._originAirport = (argOriginAirport != null && MANAGE_CASE) ? argOriginAirport.toUpperCase() : argOriginAirport;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getCreateDate() {
/*  80 */     return (Date)this._createDate;
/*     */   }
/*     */   
/*     */   public void setCreateDate(Date argCreateDate) {
/*  84 */     if (changed(argCreateDate, this._createDate, "createDate")) {
/*  85 */       this._createDate = (argCreateDate == null || argCreateDate instanceof DtvDate) ? (DtvDate)argCreateDate : new DtvDate(argCreateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateUserId() {
/*  91 */     return this._createUserId;
/*     */   }
/*     */   
/*     */   public void setCreateUserId(String argCreateUserId) {
/*  95 */     if (changed(argCreateUserId, this._createUserId, "createUserId")) {
/*  96 */       this._createUserId = argCreateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public Date getUpdateDate() {
/* 101 */     return (Date)this._updateDate;
/*     */   }
/*     */   
/*     */   public void setUpdateDate(Date argUpdateDate) {
/* 105 */     if (changed(argUpdateDate, this._updateDate, "updateDate")) {
/* 106 */       this._updateDate = (argUpdateDate == null || argUpdateDate instanceof DtvDate) ? (DtvDate)argUpdateDate : new DtvDate(argUpdateDate);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUpdateUserId() {
/* 112 */     return this._updateUserId;
/*     */   }
/*     */   
/*     */   public void setUpdateUserId(String argUpdateUserId) {
/* 116 */     if (changed(argUpdateUserId, this._updateUserId, "updateUserId")) {
/* 117 */       this._updateUserId = argUpdateUserId;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getDestinationAirport() {
/* 122 */     return this._destinationAirport;
/*     */   }
/*     */   
/*     */   public void setDestinationAirport(String argDestinationAirport) {
/* 126 */     if (changed(argDestinationAirport, this._destinationAirport, "destinationAirport")) {
/* 127 */       this._destinationAirport = argDestinationAirport;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getVia1Airport() {
/* 132 */     return this._via1Airport;
/*     */   }
/*     */   
/*     */   public void setVia1Airport(String argVia1Airport) {
/* 136 */     if (changed(argVia1Airport, this._via1Airport, "via1Airport")) {
/* 137 */       this._via1Airport = argVia1Airport;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getVia2Airport() {
/* 142 */     return this._via2Airport;
/*     */   }
/*     */   
/*     */   public void setVia2Airport(String argVia2Airport) {
/* 146 */     if (changed(argVia2Airport, this._via2Airport, "via2Airport")) {
/* 147 */       this._via2Airport = argVia2Airport;
/*     */     }
/*     */   }
/*     */   
/*     */   public String getVia3Airport() {
/* 152 */     return this._via3Airport;
/*     */   }
/*     */   
/*     */   public void setVia3Airport(String argVia3Airport) {
/* 156 */     if (changed(argVia3Airport, this._via3Airport, "via3Airport")) {
/* 157 */       this._via3Airport = argVia3Airport;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 164 */     StringBuilder buf = new StringBuilder(512);
/* 165 */     buf.append(super.toString()).append(" Id: ").append(getObjectId()).append(" Values: ");
/* 166 */     if (getOrganizationId() != null) {
/* 167 */       buf.append("organizationId").append("=").append(getOrganizationId()).append(" ");
/*     */     }
/* 169 */     if (getScheduledDateTime() != null) {
/* 170 */       buf.append("scheduledDateTime").append("=").append(getScheduledDateTime()).append(" ");
/*     */     }
/* 172 */     if (getFlightNumber() != null) {
/* 173 */       buf.append("flightNumber").append("=").append(getFlightNumber()).append(" ");
/*     */     }
/* 175 */     if (getOriginAirport() != null) {
/* 176 */       buf.append("originAirport").append("=").append(getOriginAirport()).append(" ");
/*     */     }
/* 178 */     if (getCreateDate() != null) {
/* 179 */       buf.append("createDate").append("=").append(getCreateDate()).append(" ");
/*     */     }
/* 181 */     if (getCreateUserId() != null) {
/* 182 */       buf.append("createUserId").append("=").append(getCreateUserId()).append(" ");
/*     */     }
/* 184 */     if (getUpdateDate() != null) {
/* 185 */       buf.append("updateDate").append("=").append(getUpdateDate()).append(" ");
/*     */     }
/* 187 */     if (getUpdateUserId() != null) {
/* 188 */       buf.append("updateUserId").append("=").append(getUpdateUserId()).append(" ");
/*     */     }
/* 190 */     if (getDestinationAirport() != null) {
/* 191 */       buf.append("destinationAirport").append("=").append(getDestinationAirport()).append(" ");
/*     */     }
/* 193 */     if (getVia1Airport() != null) {
/* 194 */       buf.append("via1Airport").append("=").append(getVia1Airport()).append(" ");
/*     */     }
/* 196 */     if (getVia2Airport() != null) {
/* 197 */       buf.append("via2Airport").append("=").append(getVia2Airport()).append(" ");
/*     */     }
/* 199 */     if (getVia3Airport() != null) {
/* 200 */       buf.append("via3Airport").append("=").append(getVia3Airport()).append(" ");
/*     */     }
/*     */     
/* 203 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public IObjectId getObjectId() {
/* 207 */     FlightInformationId id = new FlightInformationId();
/* 208 */     id.setOrganizationId(getOrganizationId());
/* 209 */     id.setScheduledDateTime(getScheduledDateTime());
/* 210 */     id.setFlightNumber(getFlightNumber());
/* 211 */     id.setOriginAirport(getOriginAirport());
/* 212 */     return (IObjectId)id;
/*     */   }
/*     */   
/*     */   public void setObjectId(IObjectId argObjectId) {
/* 216 */     setOrganizationId(((FlightInformationId)argObjectId).getOrganizationId());
/* 217 */     setScheduledDateTime(((FlightInformationId)argObjectId).getScheduledDateTime());
/* 218 */     setFlightNumber(((FlightInformationId)argObjectId).getFlightNumber());
/* 219 */     setOriginAirport(((FlightInformationId)argObjectId).getOriginAirport());
/*     */   }
/*     */   
/*     */   public String getImplementingClass() {
/* 223 */     return null;
/*     */   }
/*     */   
/*     */   public String toXmlString() {
/* 227 */     StringBuilder buf = new StringBuilder(600);
/* 228 */     buf.append("<").append("dao").append(" name=\"FlightInformation\" cmd=\"" + getObjectStateString() + "\">");
/* 229 */     getFieldsAsXml(buf);
/* 230 */     buf.append("</").append("dao").append(">");
/*     */     
/* 232 */     return buf.toString();
/*     */   }
/*     */   
/*     */   public Map<String, String> getValues() {
/* 236 */     Map<String, String> values = super.getValues();
/* 237 */     if (this._organizationId != null) values.put("OrganizationId", DaoUtils.getXmlSafeFieldValue(-5, this._organizationId)); 
/* 238 */     if (this._scheduledDateTime != null) values.put("ScheduledDateTime", DaoUtils.getXmlSafeFieldValue(91, this._scheduledDateTime)); 
/* 239 */     if (this._flightNumber != null) values.put("FlightNumber", DaoUtils.getXmlSafeFieldValue(12, this._flightNumber)); 
/* 240 */     if (this._originAirport != null) values.put("OriginAirport", DaoUtils.getXmlSafeFieldValue(12, this._originAirport)); 
/* 241 */     if (this._createDate != null) values.put("CreateDate", DaoUtils.getXmlSafeFieldValue(91, this._createDate)); 
/* 242 */     if (this._createUserId != null) values.put("CreateUserId", DaoUtils.getXmlSafeFieldValue(12, this._createUserId)); 
/* 243 */     if (this._updateDate != null) values.put("UpdateDate", DaoUtils.getXmlSafeFieldValue(91, this._updateDate)); 
/* 244 */     if (this._updateUserId != null) values.put("UpdateUserId", DaoUtils.getXmlSafeFieldValue(12, this._updateUserId)); 
/* 245 */     if (this._destinationAirport != null) values.put("DestinationAirport", DaoUtils.getXmlSafeFieldValue(12, this._destinationAirport)); 
/* 246 */     if (this._via1Airport != null) values.put("Via1Airport", DaoUtils.getXmlSafeFieldValue(12, this._via1Airport)); 
/* 247 */     if (this._via2Airport != null) values.put("Via2Airport", DaoUtils.getXmlSafeFieldValue(12, this._via2Airport)); 
/* 248 */     if (this._via3Airport != null) values.put("Via3Airport", DaoUtils.getXmlSafeFieldValue(12, this._via3Airport)); 
/* 249 */     return values;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setValues(Map<String, String> argValues) {
/* 254 */     super.setValues(argValues);
/* 255 */     for (Map.Entry<String, String> field : argValues.entrySet()) {
/*     */       
/* 257 */       String fieldName = field.getKey();
/* 258 */       String fieldValue = field.getValue();
/* 259 */       switch (fieldName) {
/*     */         
/*     */         case "OrganizationId":
/*     */           try {
/* 263 */             Object value = DaoUtils.getFieldValueForXmlString(-5, fieldValue);
/* 264 */             setOrganizationId((Long)value);
/* 265 */           } catch (Exception ee) {
/* 266 */             throw new DtxException("An exception occurred while calling setOrganizationId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "ScheduledDateTime":
/*     */           try {
/* 272 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 273 */             setScheduledDateTime((Date)value);
/* 274 */           } catch (Exception ee) {
/* 275 */             throw new DtxException("An exception occurred while calling setScheduledDateTime() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "FlightNumber":
/*     */           try {
/* 281 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 282 */             setFlightNumber((String)value);
/* 283 */           } catch (Exception ee) {
/* 284 */             throw new DtxException("An exception occurred while calling setFlightNumber() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "OriginAirport":
/*     */           try {
/* 290 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 291 */             setOriginAirport((String)value);
/* 292 */           } catch (Exception ee) {
/* 293 */             throw new DtxException("An exception occurred while calling setOriginAirport() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateDate":
/*     */           try {
/* 299 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 300 */             setCreateDate((Date)value);
/* 301 */           } catch (Exception ee) {
/* 302 */             throw new DtxException("An exception occurred while calling setCreateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "CreateUserId":
/*     */           try {
/* 308 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 309 */             setCreateUserId((String)value);
/* 310 */           } catch (Exception ee) {
/* 311 */             throw new DtxException("An exception occurred while calling setCreateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateDate":
/*     */           try {
/* 317 */             Object value = DaoUtils.getFieldValueForXmlString(91, fieldValue);
/* 318 */             setUpdateDate((Date)value);
/* 319 */           } catch (Exception ee) {
/* 320 */             throw new DtxException("An exception occurred while calling setUpdateDate() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "UpdateUserId":
/*     */           try {
/* 326 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 327 */             setUpdateUserId((String)value);
/* 328 */           } catch (Exception ee) {
/* 329 */             throw new DtxException("An exception occurred while calling setUpdateUserId() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "DestinationAirport":
/*     */           try {
/* 335 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 336 */             setDestinationAirport((String)value);
/* 337 */           } catch (Exception ee) {
/* 338 */             throw new DtxException("An exception occurred while calling setDestinationAirport() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Via1Airport":
/*     */           try {
/* 344 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 345 */             setVia1Airport((String)value);
/* 346 */           } catch (Exception ee) {
/* 347 */             throw new DtxException("An exception occurred while calling setVia1Airport() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Via2Airport":
/*     */           try {
/* 353 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 354 */             setVia2Airport((String)value);
/* 355 */           } catch (Exception ee) {
/* 356 */             throw new DtxException("An exception occurred while calling setVia2Airport() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */ 
/*     */         
/*     */         case "Via3Airport":
/*     */           try {
/* 362 */             Object value = DaoUtils.getFieldValueForXmlString(12, fieldValue);
/* 363 */             setVia3Airport((String)value);
/* 364 */           } catch (Exception ee) {
/* 365 */             throw new DtxException("An exception occurred while calling setVia3Airport() with " + fieldValue + " on: " + this + " " + ee.toString(), ee);
/*     */           } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\impl\FlightInformationDAO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */