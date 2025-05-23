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
/*     */ public class ItemRestrictGS1Id
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1589828438L;
/*     */   private String _itemId;
/*     */   private String _fieldId;
/*     */   private String _startValue;
/*     */   
/*     */   public ItemRestrictGS1Id() {}
/*     */   
/*     */   public ItemRestrictGS1Id(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemId() {
/*  31 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  35 */     this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
/*     */   }
/*     */   
/*     */   public String getFieldId() {
/*  39 */     return this._fieldId;
/*     */   }
/*     */   
/*     */   public void setFieldId(String argFieldId) {
/*  43 */     this._fieldId = (argFieldId != null && MANAGE_CASE) ? argFieldId.toUpperCase() : argFieldId;
/*     */   }
/*     */   
/*     */   public String getStartValue() {
/*  47 */     return this._startValue;
/*     */   }
/*     */   
/*     */   public void setStartValue(String argStartValue) {
/*  51 */     this._startValue = (argStartValue != null && MANAGE_CASE) ? argStartValue.toUpperCase() : argStartValue;
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
/*  67 */         setItemId((String)null);
/*     */       } else {
/*     */         
/*  70 */         setItemId(str);
/*     */       } 
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       if ("null".equals(str)) {
/*  75 */         setFieldId((String)null);
/*     */       } else {
/*     */         
/*  78 */         setFieldId(str);
/*     */       } 
/*  80 */       str = tokens[3];
/*     */       
/*  82 */       if ("null".equals(str)) {
/*  83 */         setStartValue((String)null);
/*     */       } else {
/*     */         
/*  86 */         setStartValue(str);
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
/*  99 */     if (!(ob instanceof ItemRestrictGS1Id)) {
/* 100 */       return false;
/*     */     }
/* 102 */     ItemRestrictGS1Id other = (ItemRestrictGS1Id)ob;
/* 103 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 106 */       .equals(other._organizationId))) && ((this._itemId == null && other._itemId == null) || (this._itemId != null && this._itemId
/*     */ 
/*     */       
/* 109 */       .equals(other._itemId))) && ((this._fieldId == null && other._fieldId == null) || (this._fieldId != null && this._fieldId
/*     */ 
/*     */       
/* 112 */       .equals(other._fieldId))) && ((this._startValue == null && other._startValue == null) || (this._startValue != null && this._startValue
/*     */ 
/*     */       
/* 115 */       .equals(other._startValue))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 121 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 122 */       .hashCode()) + ((this._itemId == null) ? 0 : this._itemId
/* 123 */       .hashCode()) + ((this._fieldId == null) ? 0 : this._fieldId
/* 124 */       .hashCode()) + ((this._startValue == null) ? 0 : this._startValue
/* 125 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 130 */     return "ItemRestrictGS1";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 135 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 137 */     return buff.append(
/* 138 */         String.valueOf(this._organizationId))
/* 139 */       .append("::").append(this._itemId)
/* 140 */       .append("::").append(this._fieldId)
/* 141 */       .append("::").append(this._startValue)
/* 142 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 146 */     if (this._itemId == null) {
/* 147 */       return false;
/*     */     }
/* 149 */     if (this._fieldId == null) {
/* 150 */       return false;
/*     */     }
/* 152 */     if (this._startValue == null) {
/* 153 */       return false;
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\ItemRestrictGS1Id.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */