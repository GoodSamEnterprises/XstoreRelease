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
/*     */ public class InventoryCountSheetLineItemId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1408801485L;
/*     */   private Long _retailLocationId;
/*     */   private String _inventoryCountId;
/*     */   private Integer _countSheetNumber;
/*     */   private Integer _lineItemNumber;
/*     */   
/*     */   public InventoryCountSheetLineItemId() {}
/*     */   
/*     */   public InventoryCountSheetLineItemId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/*  32 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  36 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public String getInventoryCountId() {
/*  40 */     return this._inventoryCountId;
/*     */   }
/*     */   
/*     */   public void setInventoryCountId(String argInventoryCountId) {
/*  44 */     this._inventoryCountId = (argInventoryCountId != null && MANAGE_CASE) ? argInventoryCountId.toUpperCase() : argInventoryCountId;
/*     */   }
/*     */   
/*     */   public Integer getCountSheetNumber() {
/*  48 */     return this._countSheetNumber;
/*     */   }
/*     */   
/*     */   public void setCountSheetNumber(Integer argCountSheetNumber) {
/*  52 */     this._countSheetNumber = argCountSheetNumber;
/*     */   }
/*     */   
/*     */   public Integer getLineItemNumber() {
/*  56 */     return this._lineItemNumber;
/*     */   }
/*     */   
/*     */   public void setLineItemNumber(Integer argLineItemNumber) {
/*  60 */     this._lineItemNumber = argLineItemNumber;
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
/*  75 */       setRetailLocationId(Long.valueOf(str));
/*  76 */       str = tokens[2];
/*     */       
/*  78 */       if ("null".equals(str)) {
/*  79 */         setInventoryCountId((String)null);
/*     */       } else {
/*     */         
/*  82 */         setInventoryCountId(str);
/*     */       } 
/*  84 */       str = tokens[3];
/*     */       
/*  86 */       setCountSheetNumber(Integer.valueOf(str));
/*  87 */       str = tokens[4];
/*     */       
/*  89 */       setLineItemNumber(Integer.valueOf(str));
/*     */     }
/*  91 */     catch (Exception ee) {
/*  92 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  98 */     if (this == ob) {
/*  99 */       return true;
/*     */     }
/* 101 */     if (!(ob instanceof InventoryCountSheetLineItemId)) {
/* 102 */       return false;
/*     */     }
/* 104 */     InventoryCountSheetLineItemId other = (InventoryCountSheetLineItemId)ob;
/* 105 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 108 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/* 111 */       .equals(other._retailLocationId))) && ((this._inventoryCountId == null && other._inventoryCountId == null) || (this._inventoryCountId != null && this._inventoryCountId
/*     */ 
/*     */       
/* 114 */       .equals(other._inventoryCountId))) && ((this._countSheetNumber == null && other._countSheetNumber == null) || (this._countSheetNumber != null && this._countSheetNumber
/*     */ 
/*     */       
/* 117 */       .equals(other._countSheetNumber))) && ((this._lineItemNumber == null && other._lineItemNumber == null) || (this._lineItemNumber != null && this._lineItemNumber
/*     */ 
/*     */       
/* 120 */       .equals(other._lineItemNumber))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 126 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 127 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 128 */       .hashCode()) + ((this._inventoryCountId == null) ? 0 : this._inventoryCountId
/* 129 */       .hashCode()) + ((this._countSheetNumber == null) ? 0 : this._countSheetNumber
/* 130 */       .hashCode()) + ((this._lineItemNumber == null) ? 0 : this._lineItemNumber
/* 131 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 136 */     return "InventoryCountSheetLineItem";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 141 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 143 */     return buff.append(
/* 144 */         String.valueOf(this._organizationId))
/* 145 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 146 */       .append("::").append(this._inventoryCountId)
/* 147 */       .append("::").append(String.valueOf(this._countSheetNumber))
/* 148 */       .append("::").append(String.valueOf(this._lineItemNumber))
/* 149 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 153 */     if (this._retailLocationId == null) {
/* 154 */       return false;
/*     */     }
/* 156 */     if (this._inventoryCountId == null) {
/* 157 */       return false;
/*     */     }
/* 159 */     if (this._countSheetNumber == null) {
/* 160 */       return false;
/*     */     }
/* 162 */     if (this._lineItemNumber == null) {
/* 163 */       return false;
/*     */     }
/* 165 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\inv\InventoryCountSheetLineItemId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */