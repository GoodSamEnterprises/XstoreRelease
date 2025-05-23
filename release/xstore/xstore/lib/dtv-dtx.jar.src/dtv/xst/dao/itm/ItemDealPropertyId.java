/*     */ package dtv.xst.dao.itm;
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
/*     */ public class ItemDealPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1662263604L;
/*     */   private String _itemId;
/*     */   private String _itemDealPropertyCode;
/*     */   private DtvDate _effectiveDate;
/*     */   
/*     */   public ItemDealPropertyId() {}
/*     */   
/*     */   public ItemDealPropertyId(String argObjectIdValue) {
/*  25 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemId() {
/*  33 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  37 */     this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
/*     */   }
/*     */   
/*     */   public String getItemDealPropertyCode() {
/*  41 */     return this._itemDealPropertyCode;
/*     */   }
/*     */   
/*     */   public void setItemDealPropertyCode(String argItemDealPropertyCode) {
/*  45 */     this._itemDealPropertyCode = (argItemDealPropertyCode != null && MANAGE_CASE) ? argItemDealPropertyCode.toUpperCase() : argItemDealPropertyCode;
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/*  49 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/*  53 */     this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */   }
/*     */ 
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
/*  70 */         setItemId((String)null);
/*     */       } else {
/*     */         
/*  73 */         setItemId(str);
/*     */       } 
/*  75 */       str = tokens[2];
/*     */       
/*  77 */       if ("null".equals(str)) {
/*  78 */         setItemDealPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  81 */         setItemDealPropertyCode(str);
/*     */       } 
/*  83 */       str = tokens[3];
/*     */       
/*  85 */       if ("null".equals(str)) {
/*  86 */         setEffectiveDate((Date)null);
/*     */       } else {
/*     */         
/*  89 */         setEffectiveDate((Date)new DtvDate());
/*  90 */         this._effectiveDate.setTimeFromSerialization(Long.parseLong(str));
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
/* 103 */     if (!(ob instanceof ItemDealPropertyId)) {
/* 104 */       return false;
/*     */     }
/* 106 */     ItemDealPropertyId other = (ItemDealPropertyId)ob;
/* 107 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 110 */       .equals(other._organizationId))) && ((this._itemId == null && other._itemId == null) || (this._itemId != null && this._itemId
/*     */ 
/*     */       
/* 113 */       .equals(other._itemId))) && ((this._itemDealPropertyCode == null && other._itemDealPropertyCode == null) || (this._itemDealPropertyCode != null && this._itemDealPropertyCode
/*     */ 
/*     */       
/* 116 */       .equals(other._itemDealPropertyCode))) && ((this._effectiveDate == null && other._effectiveDate == null) || (this._effectiveDate != null && this._effectiveDate
/*     */ 
/*     */       
/* 119 */       .equals(other._effectiveDate))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 125 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 126 */       .hashCode()) + ((this._itemId == null) ? 0 : this._itemId
/* 127 */       .hashCode()) + ((this._itemDealPropertyCode == null) ? 0 : this._itemDealPropertyCode
/* 128 */       .hashCode()) + ((this._effectiveDate == null) ? 0 : this._effectiveDate
/* 129 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 134 */     return "ItemDealProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 139 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 141 */     return buff.append(
/* 142 */         String.valueOf(this._organizationId))
/* 143 */       .append("::").append(this._itemId)
/* 144 */       .append("::").append(this._itemDealPropertyCode)
/* 145 */       .append("::").append((this._effectiveDate == null) ? "null" : String.valueOf(this._effectiveDate.getTimeSerializable()))
/* 146 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 150 */     if (this._itemId == null) {
/* 151 */       return false;
/*     */     }
/* 153 */     if (this._itemDealPropertyCode == null) {
/* 154 */       return false;
/*     */     }
/* 156 */     if (this._effectiveDate == null) {
/* 157 */       return false;
/*     */     }
/* 159 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\ItemDealPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */