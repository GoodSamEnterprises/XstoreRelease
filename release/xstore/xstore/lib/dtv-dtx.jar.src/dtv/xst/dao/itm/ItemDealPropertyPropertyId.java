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
/*     */ public class ItemDealPropertyPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -940445911L;
/*     */   private String _itemId;
/*     */   private String _itemDealPropertyCode;
/*     */   private DtvDate _effectiveDate;
/*     */   private String _propertyCode;
/*     */   
/*     */   public ItemDealPropertyPropertyId() {}
/*     */   
/*     */   public ItemDealPropertyPropertyId(String argObjectIdValue) {
/*  25 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemId() {
/*  34 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  38 */     this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
/*     */   }
/*     */   
/*     */   public String getItemDealPropertyCode() {
/*  42 */     return this._itemDealPropertyCode;
/*     */   }
/*     */   
/*     */   public void setItemDealPropertyCode(String argItemDealPropertyCode) {
/*  46 */     this._itemDealPropertyCode = (argItemDealPropertyCode != null && MANAGE_CASE) ? argItemDealPropertyCode.toUpperCase() : argItemDealPropertyCode;
/*     */   }
/*     */   
/*     */   public Date getEffectiveDate() {
/*  50 */     return (Date)this._effectiveDate;
/*     */   }
/*     */   
/*     */   public void setEffectiveDate(Date argEffectiveDate) {
/*  54 */     this._effectiveDate = (argEffectiveDate == null || argEffectiveDate instanceof DtvDate) ? (DtvDate)argEffectiveDate : new DtvDate(argEffectiveDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPropertyCode() {
/*  59 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  63 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  67 */     String str = argObjectIdValue;
/*  68 */     if (StringUtils.isEmpty(str)) {
/*  69 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  72 */       String[] tokens = str.split("::");
/*  73 */       str = tokens[0];
/*     */       
/*  75 */       setOrganizationId(Long.valueOf(str));
/*  76 */       str = tokens[1];
/*     */       
/*  78 */       if ("null".equals(str)) {
/*  79 */         setItemId((String)null);
/*     */       } else {
/*     */         
/*  82 */         setItemId(str);
/*     */       } 
/*  84 */       str = tokens[2];
/*     */       
/*  86 */       if ("null".equals(str)) {
/*  87 */         setItemDealPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  90 */         setItemDealPropertyCode(str);
/*     */       } 
/*  92 */       str = tokens[3];
/*     */       
/*  94 */       if ("null".equals(str)) {
/*  95 */         setEffectiveDate((Date)null);
/*     */       } else {
/*     */         
/*  98 */         setEffectiveDate((Date)new DtvDate());
/*  99 */         this._effectiveDate.setTimeFromSerialization(Long.parseLong(str));
/*     */       } 
/* 101 */       str = tokens[4];
/*     */       
/* 103 */       if ("null".equals(str)) {
/* 104 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 107 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 110 */     } catch (Exception ee) {
/* 111 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 117 */     if (this == ob) {
/* 118 */       return true;
/*     */     }
/* 120 */     if (!(ob instanceof ItemDealPropertyPropertyId)) {
/* 121 */       return false;
/*     */     }
/* 123 */     ItemDealPropertyPropertyId other = (ItemDealPropertyPropertyId)ob;
/* 124 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 127 */       .equals(other._organizationId))) && ((this._itemId == null && other._itemId == null) || (this._itemId != null && this._itemId
/*     */ 
/*     */       
/* 130 */       .equals(other._itemId))) && ((this._itemDealPropertyCode == null && other._itemDealPropertyCode == null) || (this._itemDealPropertyCode != null && this._itemDealPropertyCode
/*     */ 
/*     */       
/* 133 */       .equals(other._itemDealPropertyCode))) && ((this._effectiveDate == null && other._effectiveDate == null) || (this._effectiveDate != null && this._effectiveDate
/*     */ 
/*     */       
/* 136 */       .equals(other._effectiveDate))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 139 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 145 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 146 */       .hashCode()) + ((this._itemId == null) ? 0 : this._itemId
/* 147 */       .hashCode()) + ((this._itemDealPropertyCode == null) ? 0 : this._itemDealPropertyCode
/* 148 */       .hashCode()) + ((this._effectiveDate == null) ? 0 : this._effectiveDate
/* 149 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 150 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 155 */     return "ItemDealPropertyProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 160 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 162 */     return buff.append(
/* 163 */         String.valueOf(this._organizationId))
/* 164 */       .append("::").append(this._itemId)
/* 165 */       .append("::").append(this._itemDealPropertyCode)
/* 166 */       .append("::").append((this._effectiveDate == null) ? "null" : String.valueOf(this._effectiveDate.getTimeSerializable()))
/* 167 */       .append("::").append(this._propertyCode)
/* 168 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 172 */     if (this._itemId == null) {
/* 173 */       return false;
/*     */     }
/* 175 */     if (this._itemDealPropertyCode == null) {
/* 176 */       return false;
/*     */     }
/* 178 */     if (this._effectiveDate == null) {
/* 179 */       return false;
/*     */     }
/* 181 */     if (this._propertyCode == null) {
/* 182 */       return false;
/*     */     }
/* 184 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\ItemDealPropertyPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */