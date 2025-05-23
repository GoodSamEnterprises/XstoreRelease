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
/*     */ public class InventoryCountSheetId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1369888788L;
/*     */   private Long _retailLocationId;
/*     */   private String _inventoryCountId;
/*     */   private Integer _countSheetNumber;
/*     */   
/*     */   public InventoryCountSheetId() {}
/*     */   
/*     */   public InventoryCountSheetId(String argObjectIdValue) {
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
/*     */   public String getInventoryCountId() {
/*  39 */     return this._inventoryCountId;
/*     */   }
/*     */   
/*     */   public void setInventoryCountId(String argInventoryCountId) {
/*  43 */     this._inventoryCountId = (argInventoryCountId != null && MANAGE_CASE) ? argInventoryCountId.toUpperCase() : argInventoryCountId;
/*     */   }
/*     */   
/*     */   public Integer getCountSheetNumber() {
/*  47 */     return this._countSheetNumber;
/*     */   }
/*     */   
/*     */   public void setCountSheetNumber(Integer argCountSheetNumber) {
/*  51 */     this._countSheetNumber = argCountSheetNumber;
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
/*  70 */         setInventoryCountId((String)null);
/*     */       } else {
/*     */         
/*  73 */         setInventoryCountId(str);
/*     */       } 
/*  75 */       str = tokens[3];
/*     */       
/*  77 */       setCountSheetNumber(Integer.valueOf(str));
/*     */     }
/*  79 */     catch (Exception ee) {
/*  80 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  86 */     if (this == ob) {
/*  87 */       return true;
/*     */     }
/*  89 */     if (!(ob instanceof InventoryCountSheetId)) {
/*  90 */       return false;
/*     */     }
/*  92 */     InventoryCountSheetId other = (InventoryCountSheetId)ob;
/*  93 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  96 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/*  99 */       .equals(other._retailLocationId))) && ((this._inventoryCountId == null && other._inventoryCountId == null) || (this._inventoryCountId != null && this._inventoryCountId
/*     */ 
/*     */       
/* 102 */       .equals(other._inventoryCountId))) && ((this._countSheetNumber == null && other._countSheetNumber == null) || (this._countSheetNumber != null && this._countSheetNumber
/*     */ 
/*     */       
/* 105 */       .equals(other._countSheetNumber))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 111 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 112 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 113 */       .hashCode()) + ((this._inventoryCountId == null) ? 0 : this._inventoryCountId
/* 114 */       .hashCode()) + ((this._countSheetNumber == null) ? 0 : this._countSheetNumber
/* 115 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 120 */     return "InventoryCountSheet";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 125 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 127 */     return buff.append(
/* 128 */         String.valueOf(this._organizationId))
/* 129 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 130 */       .append("::").append(this._inventoryCountId)
/* 131 */       .append("::").append(String.valueOf(this._countSheetNumber))
/* 132 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 136 */     if (this._retailLocationId == null) {
/* 137 */       return false;
/*     */     }
/* 139 */     if (this._inventoryCountId == null) {
/* 140 */       return false;
/*     */     }
/* 142 */     if (this._countSheetNumber == null) {
/* 143 */       return false;
/*     */     }
/* 145 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\InventoryCountSheetId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */