/*     */ package dtv.xst.dao.itm;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class KitComponentPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1373131300L;
/*     */   private String _kitItemId;
/*     */   private String _componentItemId;
/*     */   private Long _sequenceNumber;
/*     */   private String _propertyCode;
/*     */   
/*     */   public KitComponentPropertyId() {}
/*     */   
/*     */   public KitComponentPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getKitItemId() {
/*  32 */     return this._kitItemId;
/*     */   }
/*     */   
/*     */   public void setKitItemId(String argKitItemId) {
/*  36 */     this._kitItemId = (argKitItemId != null && MANAGE_CASE) ? argKitItemId.toUpperCase() : argKitItemId;
/*     */   }
/*     */   
/*     */   public String getComponentItemId() {
/*  40 */     return this._componentItemId;
/*     */   }
/*     */   
/*     */   public void setComponentItemId(String argComponentItemId) {
/*  44 */     this._componentItemId = (argComponentItemId != null && MANAGE_CASE) ? argComponentItemId.toUpperCase() : argComponentItemId;
/*     */   }
/*     */   
/*     */   public Long getSequenceNumber() {
/*  48 */     return this._sequenceNumber;
/*     */   }
/*     */   
/*     */   public void setSequenceNumber(Long argSequenceNumber) {
/*  52 */     this._sequenceNumber = argSequenceNumber;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  56 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  60 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  64 */     String str = argObjectIdValue;
/*  65 */     if (StringUtils.isEmpty(str)) {
/*  66 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  69 */       String[] tokens = str.split("::");
/*  70 */       str = tokens[0];
/*     */       
/*  72 */       setOrganizationId(Long.valueOf(str));
/*  73 */       str = tokens[1];
/*     */       
/*  75 */       if ("null".equals(str)) {
/*  76 */         setKitItemId((String)null);
/*     */       } else {
/*     */         
/*  79 */         setKitItemId(str);
/*     */       } 
/*  81 */       str = tokens[2];
/*     */       
/*  83 */       if ("null".equals(str)) {
/*  84 */         setComponentItemId((String)null);
/*     */       } else {
/*     */         
/*  87 */         setComponentItemId(str);
/*     */       } 
/*  89 */       str = tokens[3];
/*     */       
/*  91 */       setSequenceNumber(Long.valueOf(str));
/*  92 */       str = tokens[4];
/*     */       
/*  94 */       if ("null".equals(str)) {
/*  95 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  98 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 101 */     } catch (Exception ee) {
/* 102 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 108 */     if (this == ob) {
/* 109 */       return true;
/*     */     }
/* 111 */     if (!(ob instanceof KitComponentPropertyId)) {
/* 112 */       return false;
/*     */     }
/* 114 */     KitComponentPropertyId other = (KitComponentPropertyId)ob;
/* 115 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 118 */       .equals(other._organizationId))) && ((this._kitItemId == null && other._kitItemId == null) || (this._kitItemId != null && this._kitItemId
/*     */ 
/*     */       
/* 121 */       .equals(other._kitItemId))) && ((this._componentItemId == null && other._componentItemId == null) || (this._componentItemId != null && this._componentItemId
/*     */ 
/*     */       
/* 124 */       .equals(other._componentItemId))) && ((this._sequenceNumber == null && other._sequenceNumber == null) || (this._sequenceNumber != null && this._sequenceNumber
/*     */ 
/*     */       
/* 127 */       .equals(other._sequenceNumber))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 130 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 136 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 137 */       .hashCode()) + ((this._kitItemId == null) ? 0 : this._kitItemId
/* 138 */       .hashCode()) + ((this._componentItemId == null) ? 0 : this._componentItemId
/* 139 */       .hashCode()) + ((this._sequenceNumber == null) ? 0 : this._sequenceNumber
/* 140 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 141 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 146 */     return "KitComponentProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 151 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 153 */     return buff.append(
/* 154 */         String.valueOf(this._organizationId))
/* 155 */       .append("::").append(this._kitItemId)
/* 156 */       .append("::").append(this._componentItemId)
/* 157 */       .append("::").append(String.valueOf(this._sequenceNumber))
/* 158 */       .append("::").append(this._propertyCode)
/* 159 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 163 */     if (this._kitItemId == null) {
/* 164 */       return false;
/*     */     }
/* 166 */     if (this._componentItemId == null) {
/* 167 */       return false;
/*     */     }
/* 169 */     if (this._sequenceNumber == null) {
/* 170 */       return false;
/*     */     }
/* 172 */     if (this._propertyCode == null) {
/* 173 */       return false;
/*     */     }
/* 175 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\KitComponentPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */