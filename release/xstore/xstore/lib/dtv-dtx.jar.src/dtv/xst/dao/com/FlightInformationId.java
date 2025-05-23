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
/*     */ 
/*     */ public class FlightInformationId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 766554748L;
/*     */   private DtvDate _scheduledDateTime;
/*     */   private String _flightNumber;
/*     */   private String _originAirport;
/*     */   
/*     */   public FlightInformationId() {}
/*     */   
/*     */   public FlightInformationId(String argObjectIdValue) {
/*  25 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Date getScheduledDateTime() {
/*  33 */     return (Date)this._scheduledDateTime;
/*     */   }
/*     */   
/*     */   public void setScheduledDateTime(Date argScheduledDateTime) {
/*  37 */     this._scheduledDateTime = (argScheduledDateTime == null || argScheduledDateTime instanceof DtvDate) ? (DtvDate)argScheduledDateTime : new DtvDate(argScheduledDateTime);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getFlightNumber() {
/*  42 */     return this._flightNumber;
/*     */   }
/*     */   
/*     */   public void setFlightNumber(String argFlightNumber) {
/*  46 */     this._flightNumber = (argFlightNumber != null && MANAGE_CASE) ? argFlightNumber.toUpperCase() : argFlightNumber;
/*     */   }
/*     */   
/*     */   public String getOriginAirport() {
/*  50 */     return this._originAirport;
/*     */   }
/*     */   
/*     */   public void setOriginAirport(String argOriginAirport) {
/*  54 */     this._originAirport = (argOriginAirport != null && MANAGE_CASE) ? argOriginAirport.toUpperCase() : argOriginAirport;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  58 */     String str = argObjectIdValue;
/*  59 */     if (StringUtils.isEmpty(str)) {
/*  60 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  63 */       String[] tokens = str.split("::");
/*  64 */       str = tokens[0];
/*     */       
/*  66 */       setOrganizationId(Long.valueOf(str));
/*  67 */       str = tokens[1];
/*     */       
/*  69 */       if ("null".equals(str)) {
/*  70 */         setScheduledDateTime((Date)null);
/*     */       } else {
/*     */         
/*  73 */         setScheduledDateTime((Date)new DtvDate());
/*  74 */         this._scheduledDateTime.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/*  76 */       str = tokens[2];
/*     */       
/*  78 */       if ("null".equals(str)) {
/*  79 */         setFlightNumber((String)null);
/*     */       } else {
/*     */         
/*  82 */         setFlightNumber(str);
/*     */       } 
/*  84 */       str = tokens[3];
/*     */       
/*  86 */       if ("null".equals(str)) {
/*  87 */         setOriginAirport((String)null);
/*     */       } else {
/*     */         
/*  90 */         setOriginAirport(str);
/*     */       }
/*     */     
/*  93 */     } catch (Exception ee) {
/*  94 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 100 */     if (this == ob) {
/* 101 */       return true;
/*     */     }
/* 103 */     if (!(ob instanceof FlightInformationId)) {
/* 104 */       return false;
/*     */     }
/* 106 */     FlightInformationId other = (FlightInformationId)ob;
/* 107 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 110 */       .equals(other._organizationId))) && ((this._scheduledDateTime == null && other._scheduledDateTime == null) || (this._scheduledDateTime != null && this._scheduledDateTime
/*     */ 
/*     */       
/* 113 */       .equals(other._scheduledDateTime))) && ((this._flightNumber == null && other._flightNumber == null) || (this._flightNumber != null && this._flightNumber
/*     */ 
/*     */       
/* 116 */       .equals(other._flightNumber))) && ((this._originAirport == null && other._originAirport == null) || (this._originAirport != null && this._originAirport
/*     */ 
/*     */       
/* 119 */       .equals(other._originAirport))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 125 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 126 */       .hashCode()) + ((this._scheduledDateTime == null) ? 0 : this._scheduledDateTime
/* 127 */       .hashCode()) + ((this._flightNumber == null) ? 0 : this._flightNumber
/* 128 */       .hashCode()) + ((this._originAirport == null) ? 0 : this._originAirport
/* 129 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 134 */     return "FlightInformation";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 139 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 141 */     return buff.append(
/* 142 */         String.valueOf(this._organizationId))
/* 143 */       .append("::").append((this._scheduledDateTime == null) ? "null" : String.valueOf(this._scheduledDateTime.getTimeSerializable()))
/* 144 */       .append("::").append(this._flightNumber)
/* 145 */       .append("::").append(this._originAirport)
/* 146 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 150 */     if (this._scheduledDateTime == null) {
/* 151 */       return false;
/*     */     }
/* 153 */     if (this._flightNumber == null) {
/* 154 */       return false;
/*     */     }
/* 156 */     if (this._originAirport == null) {
/* 157 */       return false;
/*     */     }
/* 159 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\FlightInformationId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */