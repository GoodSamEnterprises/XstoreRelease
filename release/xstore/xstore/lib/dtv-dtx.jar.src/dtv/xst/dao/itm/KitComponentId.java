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
/*     */ 
/*     */ public class KitComponentId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 673268455L;
/*     */   private String _kitItemId;
/*     */   private String _componentItemId;
/*     */   private Long _sequenceNumber;
/*     */   
/*     */   public KitComponentId() {}
/*     */   
/*     */   public KitComponentId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getKitItemId() {
/*  31 */     return this._kitItemId;
/*     */   }
/*     */   
/*     */   public void setKitItemId(String argKitItemId) {
/*  35 */     this._kitItemId = (argKitItemId != null && MANAGE_CASE) ? argKitItemId.toUpperCase() : argKitItemId;
/*     */   }
/*     */   
/*     */   public String getComponentItemId() {
/*  39 */     return this._componentItemId;
/*     */   }
/*     */   
/*     */   public void setComponentItemId(String argComponentItemId) {
/*  43 */     this._componentItemId = (argComponentItemId != null && MANAGE_CASE) ? argComponentItemId.toUpperCase() : argComponentItemId;
/*     */   }
/*     */   
/*     */   public Long getSequenceNumber() {
/*  47 */     return this._sequenceNumber;
/*     */   }
/*     */   
/*     */   public void setSequenceNumber(Long argSequenceNumber) {
/*  51 */     this._sequenceNumber = argSequenceNumber;
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
/*  67 */         setKitItemId((String)null);
/*     */       } else {
/*     */         
/*  70 */         setKitItemId(str);
/*     */       } 
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setComponentItemId((String)null);
/*     */       } else {
/*     */         
/*  78 */         setComponentItemId(str);
/*     */       } 
/*  80 */       str = tokens[3];
/*     */       
/*  82 */       setSequenceNumber(Long.valueOf(str));
/*     */     }
/*  84 */     catch (Exception ee) {
/*  85 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  91 */     if (this == ob) {
/*  92 */       return true;
/*     */     }
/*  94 */     if (!(ob instanceof KitComponentId)) {
/*  95 */       return false;
/*     */     }
/*  97 */     KitComponentId other = (KitComponentId)ob;
/*  98 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 101 */       .equals(other._organizationId))) && ((this._kitItemId == null && other._kitItemId == null) || (this._kitItemId != null && this._kitItemId
/*     */ 
/*     */       
/* 104 */       .equals(other._kitItemId))) && ((this._componentItemId == null && other._componentItemId == null) || (this._componentItemId != null && this._componentItemId
/*     */ 
/*     */       
/* 107 */       .equals(other._componentItemId))) && ((this._sequenceNumber == null && other._sequenceNumber == null) || (this._sequenceNumber != null && this._sequenceNumber
/*     */ 
/*     */       
/* 110 */       .equals(other._sequenceNumber))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 116 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 117 */       .hashCode()) + ((this._kitItemId == null) ? 0 : this._kitItemId
/* 118 */       .hashCode()) + ((this._componentItemId == null) ? 0 : this._componentItemId
/* 119 */       .hashCode()) + ((this._sequenceNumber == null) ? 0 : this._sequenceNumber
/* 120 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 125 */     return "KitComponent";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 132 */     return buff.append(
/* 133 */         String.valueOf(this._organizationId))
/* 134 */       .append("::").append(this._kitItemId)
/* 135 */       .append("::").append(this._componentItemId)
/* 136 */       .append("::").append(String.valueOf(this._sequenceNumber))
/* 137 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 141 */     if (this._kitItemId == null) {
/* 142 */       return false;
/*     */     }
/* 144 */     if (this._componentItemId == null) {
/* 145 */       return false;
/*     */     }
/* 147 */     if (this._sequenceNumber == null) {
/* 148 */       return false;
/*     */     }
/* 150 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\KitComponentId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */