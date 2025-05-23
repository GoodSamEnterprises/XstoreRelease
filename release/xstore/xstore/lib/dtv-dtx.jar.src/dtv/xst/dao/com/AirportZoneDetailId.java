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
/*     */ 
/*     */ public class AirportZoneDetailId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1260580392L;
/*     */   private String _zoneId;
/*     */   private String _destinationZoneId;
/*     */   
/*     */   public AirportZoneDetailId() {}
/*     */   
/*     */   public AirportZoneDetailId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getZoneId() {
/*  30 */     return this._zoneId;
/*     */   }
/*     */   
/*     */   public void setZoneId(String argZoneId) {
/*  34 */     this._zoneId = (argZoneId != null && MANAGE_CASE) ? argZoneId.toUpperCase() : argZoneId;
/*     */   }
/*     */   
/*     */   public String getDestinationZoneId() {
/*  38 */     return this._destinationZoneId;
/*     */   }
/*     */   
/*     */   public void setDestinationZoneId(String argDestinationZoneId) {
/*  42 */     this._destinationZoneId = (argDestinationZoneId != null && MANAGE_CASE) ? argDestinationZoneId.toUpperCase() : argDestinationZoneId;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  46 */     String str = argObjectIdValue;
/*  47 */     if (StringUtils.isEmpty(str)) {
/*  48 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  51 */       String[] tokens = str.split("::");
/*  52 */       str = tokens[0];
/*     */       
/*  54 */       setOrganizationId(Long.valueOf(str));
/*  55 */       str = tokens[1];
/*     */       
/*  57 */       if ("null".equals(str)) {
/*  58 */         setZoneId((String)null);
/*     */       } else {
/*     */         
/*  61 */         setZoneId(str);
/*     */       } 
/*  63 */       str = tokens[2];
/*     */       
/*  65 */       if ("null".equals(str)) {
/*  66 */         setDestinationZoneId((String)null);
/*     */       } else {
/*     */         
/*  69 */         setDestinationZoneId(str);
/*     */       }
/*     */     
/*  72 */     } catch (Exception ee) {
/*  73 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  79 */     if (this == ob) {
/*  80 */       return true;
/*     */     }
/*  82 */     if (!(ob instanceof AirportZoneDetailId)) {
/*  83 */       return false;
/*     */     }
/*  85 */     AirportZoneDetailId other = (AirportZoneDetailId)ob;
/*  86 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  89 */       .equals(other._organizationId))) && ((this._zoneId == null && other._zoneId == null) || (this._zoneId != null && this._zoneId
/*     */ 
/*     */       
/*  92 */       .equals(other._zoneId))) && ((this._destinationZoneId == null && other._destinationZoneId == null) || (this._destinationZoneId != null && this._destinationZoneId
/*     */ 
/*     */       
/*  95 */       .equals(other._destinationZoneId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 101 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 102 */       .hashCode()) + ((this._zoneId == null) ? 0 : this._zoneId
/* 103 */       .hashCode()) + ((this._destinationZoneId == null) ? 0 : this._destinationZoneId
/* 104 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 109 */     return "AirportZoneDetail";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 114 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 116 */     return buff.append(
/* 117 */         String.valueOf(this._organizationId))
/* 118 */       .append("::").append(this._zoneId)
/* 119 */       .append("::").append(this._destinationZoneId)
/* 120 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 124 */     if (this._zoneId == null) {
/* 125 */       return false;
/*     */     }
/* 127 */     if (this._destinationZoneId == null) {
/* 128 */       return false;
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\com\AirportZoneDetailId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */