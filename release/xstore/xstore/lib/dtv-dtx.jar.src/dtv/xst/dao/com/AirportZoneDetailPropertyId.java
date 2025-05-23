/*     */ package dtv.xst.dao.com;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AirportZoneDetailPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1683060707L;
/*     */   private String _zoneId;
/*     */   private String _destinationZoneId;
/*     */   private String _propertyCode;
/*     */   
/*     */   public AirportZoneDetailPropertyId() {}
/*     */   
/*     */   public AirportZoneDetailPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getZoneId() {
/*  31 */     return this._zoneId;
/*     */   }
/*     */   
/*     */   public void setZoneId(String argZoneId) {
/*  35 */     this._zoneId = (argZoneId != null && MANAGE_CASE) ? argZoneId.toUpperCase() : argZoneId;
/*     */   }
/*     */   
/*     */   public String getDestinationZoneId() {
/*  39 */     return this._destinationZoneId;
/*     */   }
/*     */   
/*     */   public void setDestinationZoneId(String argDestinationZoneId) {
/*  43 */     this._destinationZoneId = (argDestinationZoneId != null && MANAGE_CASE) ? argDestinationZoneId.toUpperCase() : argDestinationZoneId;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  47 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  51 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  55 */     String str = argObjectIdValue;
/*  56 */     if (StringUtils.isEmpty(str)) {
/*  57 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  60 */       String[] tokens = str.split("::");
/*  61 */       str = tokens[0];
/*     */       
/*  63 */       setOrganizationId(Long.valueOf(str));
/*  64 */       str = tokens[1];
/*     */       
/*  66 */       if ("null".equals(str)) {
/*  67 */         setZoneId((String)null);
/*     */       } else {
/*     */         
/*  70 */         setZoneId(str);
/*     */       } 
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setDestinationZoneId((String)null);
/*     */       } else {
/*     */         
/*  78 */         setDestinationZoneId(str);
/*     */       } 
/*  80 */       str = tokens[3];
/*     */       
/*  82 */       if ("null".equals(str)) {
/*  83 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  86 */         setPropertyCode(str);
/*     */       }
/*     */     
/*  89 */     } catch (Exception ee) {
/*  90 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  96 */     if (this == ob) {
/*  97 */       return true;
/*     */     }
/*  99 */     if (!(ob instanceof AirportZoneDetailPropertyId)) {
/* 100 */       return false;
/*     */     }
/* 102 */     AirportZoneDetailPropertyId other = (AirportZoneDetailPropertyId)ob;
/* 103 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 106 */       .equals(other._organizationId))) && ((this._zoneId == null && other._zoneId == null) || (this._zoneId != null && this._zoneId
/*     */ 
/*     */       
/* 109 */       .equals(other._zoneId))) && ((this._destinationZoneId == null && other._destinationZoneId == null) || (this._destinationZoneId != null && this._destinationZoneId
/*     */ 
/*     */       
/* 112 */       .equals(other._destinationZoneId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 115 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 122 */       .hashCode()) + ((this._zoneId == null) ? 0 : this._zoneId
/* 123 */       .hashCode()) + ((this._destinationZoneId == null) ? 0 : this._destinationZoneId
/* 124 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 125 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 130 */     return "AirportZoneDetailProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 135 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 137 */     return buff.append(
/* 138 */         String.valueOf(this._organizationId))
/* 139 */       .append("::").append(this._zoneId)
/* 140 */       .append("::").append(this._destinationZoneId)
/* 141 */       .append("::").append(this._propertyCode)
/* 142 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 146 */     if (this._zoneId == null) {
/* 147 */       return false;
/*     */     }
/* 149 */     if (this._destinationZoneId == null) {
/* 150 */       return false;
/*     */     }
/* 152 */     if (this._propertyCode == null) {
/* 153 */       return false;
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\AirportZoneDetailPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */