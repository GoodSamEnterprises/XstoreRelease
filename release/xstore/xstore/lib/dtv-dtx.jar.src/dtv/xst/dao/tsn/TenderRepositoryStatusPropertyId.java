/*     */ package dtv.xst.dao.tsn;
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
/*     */ public class TenderRepositoryStatusPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1660847333L;
/*     */   private Long _retailLocationId;
/*     */   private String _tenderRepositoryId;
/*     */   private String _propertyCode;
/*     */   
/*     */   public TenderRepositoryStatusPropertyId() {}
/*     */   
/*     */   public TenderRepositoryStatusPropertyId(String argObjectIdValue) {
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
/*     */   public String getTenderRepositoryId() {
/*  39 */     return this._tenderRepositoryId;
/*     */   }
/*     */   
/*     */   public void setTenderRepositoryId(String argTenderRepositoryId) {
/*  43 */     this._tenderRepositoryId = (argTenderRepositoryId != null && MANAGE_CASE) ? argTenderRepositoryId.toUpperCase() : argTenderRepositoryId;
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
/*  66 */       setRetailLocationId(Long.valueOf(str));
/*  67 */       str = tokens[2];
/*     */       
/*  69 */       if ("null".equals(str)) {
/*  70 */         setTenderRepositoryId((String)null);
/*     */       } else {
/*     */         
/*  73 */         setTenderRepositoryId(str);
/*     */       } 
/*  75 */       str = tokens[3];
/*     */       
/*  77 */       if ("null".equals(str)) {
/*  78 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  81 */         setPropertyCode(str);
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
/*  94 */     if (!(ob instanceof TenderRepositoryStatusPropertyId)) {
/*  95 */       return false;
/*     */     }
/*  97 */     TenderRepositoryStatusPropertyId other = (TenderRepositoryStatusPropertyId)ob;
/*  98 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 101 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 104 */       .equals(other._retailLocationId))) && ((this._tenderRepositoryId == null && other._tenderRepositoryId == null) || (this._tenderRepositoryId != null && this._tenderRepositoryId
/*     */ 
/*     */       
/* 107 */       .equals(other._tenderRepositoryId))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 110 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 116 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 117 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 118 */       .hashCode()) + ((this._tenderRepositoryId == null) ? 0 : this._tenderRepositoryId
/* 119 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 120 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 125 */     return "TenderRepositoryStatusProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 132 */     return buff.append(
/* 133 */         String.valueOf(this._organizationId))
/* 134 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 135 */       .append("::").append(this._tenderRepositoryId)
/* 136 */       .append("::").append(this._propertyCode)
/* 137 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 141 */     if (this._retailLocationId == null) {
/* 142 */       return false;
/*     */     }
/* 144 */     if (this._tenderRepositoryId == null) {
/* 145 */       return false;
/*     */     }
/* 147 */     if (this._propertyCode == null) {
/* 148 */       return false;
/*     */     }
/* 150 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\TenderRepositoryStatusPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */