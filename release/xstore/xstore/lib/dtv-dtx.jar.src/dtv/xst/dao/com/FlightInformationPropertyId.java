/*     */ package dtv.xst.dao.com;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FlightInformationPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1397966735L;
/*     */   private DtvDate _scheduledDateTime;
/*     */   private String _flightNumber;
/*     */   private String _originAirport;
/*     */   private String _propertyCode;
/*     */   
/*     */   public FlightInformationPropertyId() {}
/*     */   
/*     */   public FlightInformationPropertyId(String argObjectIdValue) {
/*  25 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getScheduledDateTime() {
/*  34 */     return (Date)this._scheduledDateTime;
/*     */   }
/*     */   
/*     */   public void setScheduledDateTime(Date argScheduledDateTime) {
/*  38 */     this._scheduledDateTime = (argScheduledDateTime == null || argScheduledDateTime instanceof DtvDate) ? (DtvDate)argScheduledDateTime : new DtvDate(argScheduledDateTime);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getFlightNumber() {
/*  43 */     return this._flightNumber;
/*     */   }
/*     */   
/*     */   public void setFlightNumber(String argFlightNumber) {
/*  47 */     this._flightNumber = (argFlightNumber != null && MANAGE_CASE) ? argFlightNumber.toUpperCase() : argFlightNumber;
/*     */   }
/*     */   
/*     */   public String getOriginAirport() {
/*  51 */     return this._originAirport;
/*     */   }
/*     */   
/*     */   public void setOriginAirport(String argOriginAirport) {
/*  55 */     this._originAirport = (argOriginAirport != null && MANAGE_CASE) ? argOriginAirport.toUpperCase() : argOriginAirport;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  59 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  63 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  67 */     String str = argObjectIdValue;
/*  68 */     if (StringUtils.isEmpty(str)) {
/*  69 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  72 */       String[] tokens = str.split("::");
/*  73 */       str = tokens[0];
/*     */       
/*  75 */       setOrganizationId(Long.valueOf(str));
/*  76 */       str = tokens[1];
/*     */       
/*  78 */       if ("null".equals(str)) {
/*  79 */         setScheduledDateTime((Date)null);
/*     */       } else {
/*     */         
/*  82 */         setScheduledDateTime((Date)new DtvDate());
/*  83 */         this._scheduledDateTime.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/*  85 */       str = tokens[2];
/*     */       
/*  87 */       if ("null".equals(str)) {
/*  88 */         setFlightNumber((String)null);
/*     */       } else {
/*     */         
/*  91 */         setFlightNumber(str);
/*     */       } 
/*  93 */       str = tokens[3];
/*     */       
/*  95 */       if ("null".equals(str)) {
/*  96 */         setOriginAirport((String)null);
/*     */       } else {
/*     */         
/*  99 */         setOriginAirport(str);
/*     */       } 
/* 101 */       str = tokens[4];
/*     */       
/* 103 */       if ("null".equals(str)) {
/* 104 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 107 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 110 */     } catch (Exception ee) {
/* 111 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 117 */     if (this == ob) {
/* 118 */       return true;
/*     */     }
/* 120 */     if (!(ob instanceof FlightInformationPropertyId)) {
/* 121 */       return false;
/*     */     }
/* 123 */     FlightInformationPropertyId other = (FlightInformationPropertyId)ob;
/* 124 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 127 */       .equals(other._organizationId))) && ((this._scheduledDateTime == null && other._scheduledDateTime == null) || (this._scheduledDateTime != null && this._scheduledDateTime
/*     */ 
/*     */       
/* 130 */       .equals(other._scheduledDateTime))) && ((this._flightNumber == null && other._flightNumber == null) || (this._flightNumber != null && this._flightNumber
/*     */ 
/*     */       
/* 133 */       .equals(other._flightNumber))) && ((this._originAirport == null && other._originAirport == null) || (this._originAirport != null && this._originAirport
/*     */ 
/*     */       
/* 136 */       .equals(other._originAirport))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 139 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 145 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 146 */       .hashCode()) + ((this._scheduledDateTime == null) ? 0 : this._scheduledDateTime
/* 147 */       .hashCode()) + ((this._flightNumber == null) ? 0 : this._flightNumber
/* 148 */       .hashCode()) + ((this._originAirport == null) ? 0 : this._originAirport
/* 149 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 150 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 155 */     return "FlightInformationProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 160 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 162 */     return buff.append(
/* 163 */         String.valueOf(this._organizationId))
/* 164 */       .append("::").append((this._scheduledDateTime == null) ? "null" : String.valueOf(this._scheduledDateTime.getTimeSerializable()))
/* 165 */       .append("::").append(this._flightNumber)
/* 166 */       .append("::").append(this._originAirport)
/* 167 */       .append("::").append(this._propertyCode)
/* 168 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 172 */     if (this._scheduledDateTime == null) {
/* 173 */       return false;
/*     */     }
/* 175 */     if (this._flightNumber == null) {
/* 176 */       return false;
/*     */     }
/* 178 */     if (this._originAirport == null) {
/* 179 */       return false;
/*     */     }
/* 181 */     if (this._propertyCode == null) {
/* 182 */       return false;
/*     */     }
/* 184 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\FlightInformationPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */