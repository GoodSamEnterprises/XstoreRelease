/*     */ package dtv.xst.dao.inv;
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
/*     */ public class InventoryLocationAvailabilityId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -274556660L;
/*     */   private Long _retailLocationId;
/*     */   private String _locationId;
/*     */   private String _availabilityCode;
/*     */   
/*     */   public InventoryLocationAvailabilityId() {}
/*     */   
/*     */   public InventoryLocationAvailabilityId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/*  31 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  35 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public String getLocationId() {
/*  39 */     return this._locationId;
/*     */   }
/*     */   
/*     */   public void setLocationId(String argLocationId) {
/*  43 */     this._locationId = (argLocationId != null && MANAGE_CASE) ? argLocationId.toUpperCase() : argLocationId;
/*     */   }
/*     */   
/*     */   public String getAvailabilityCode() {
/*  47 */     return this._availabilityCode;
/*     */   }
/*     */   
/*     */   public void setAvailabilityCode(String argAvailabilityCode) {
/*  51 */     this._availabilityCode = (argAvailabilityCode != null && MANAGE_CASE) ? argAvailabilityCode.toUpperCase() : argAvailabilityCode;
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
/*  66 */       setRetailLocationId(Long.valueOf(str));
/*  67 */       str = tokens[2];
/*     */       
/*  69 */       if ("null".equals(str)) {
/*  70 */         setLocationId((String)null);
/*     */       } else {
/*     */         
/*  73 */         setLocationId(str);
/*     */       } 
/*  75 */       str = tokens[3];
/*     */       
/*  77 */       if ("null".equals(str)) {
/*  78 */         setAvailabilityCode((String)null);
/*     */       } else {
/*     */         
/*  81 */         setAvailabilityCode(str);
/*     */       }
/*     */     
/*  84 */     } catch (Exception ee) {
/*  85 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  91 */     if (this == ob) {
/*  92 */       return true;
/*     */     }
/*  94 */     if (!(ob instanceof InventoryLocationAvailabilityId)) {
/*  95 */       return false;
/*     */     }
/*  97 */     InventoryLocationAvailabilityId other = (InventoryLocationAvailabilityId)ob;
/*  98 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 101 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 104 */       .equals(other._retailLocationId))) && ((this._locationId == null && other._locationId == null) || (this._locationId != null && this._locationId
/*     */ 
/*     */       
/* 107 */       .equals(other._locationId))) && ((this._availabilityCode == null && other._availabilityCode == null) || (this._availabilityCode != null && this._availabilityCode
/*     */ 
/*     */       
/* 110 */       .equals(other._availabilityCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 116 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 117 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 118 */       .hashCode()) + ((this._locationId == null) ? 0 : this._locationId
/* 119 */       .hashCode()) + ((this._availabilityCode == null) ? 0 : this._availabilityCode
/* 120 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 125 */     return "InventoryLocationAvailability";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 132 */     return buff.append(
/* 133 */         String.valueOf(this._organizationId))
/* 134 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 135 */       .append("::").append(this._locationId)
/* 136 */       .append("::").append(this._availabilityCode)
/* 137 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 141 */     if (this._retailLocationId == null) {
/* 142 */       return false;
/*     */     }
/* 144 */     if (this._locationId == null) {
/* 145 */       return false;
/*     */     }
/* 147 */     if (this._availabilityCode == null) {
/* 148 */       return false;
/*     */     }
/* 150 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\InventoryLocationAvailabilityId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */