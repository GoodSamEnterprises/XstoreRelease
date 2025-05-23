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
/*     */ public class ItemRestrictGS1PropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1621268661L;
/*     */   private String _itemId;
/*     */   private String _fieldId;
/*     */   private String _startValue;
/*     */   private String _propertyCode;
/*     */   
/*     */   public ItemRestrictGS1PropertyId() {}
/*     */   
/*     */   public ItemRestrictGS1PropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getItemId() {
/*  32 */     return this._itemId;
/*     */   }
/*     */   
/*     */   public void setItemId(String argItemId) {
/*  36 */     this._itemId = (argItemId != null && MANAGE_CASE) ? argItemId.toUpperCase() : argItemId;
/*     */   }
/*     */   
/*     */   public String getFieldId() {
/*  40 */     return this._fieldId;
/*     */   }
/*     */   
/*     */   public void setFieldId(String argFieldId) {
/*  44 */     this._fieldId = (argFieldId != null && MANAGE_CASE) ? argFieldId.toUpperCase() : argFieldId;
/*     */   }
/*     */   
/*     */   public String getStartValue() {
/*  48 */     return this._startValue;
/*     */   }
/*     */   
/*     */   public void setStartValue(String argStartValue) {
/*  52 */     this._startValue = (argStartValue != null && MANAGE_CASE) ? argStartValue.toUpperCase() : argStartValue;
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
/*  76 */         setItemId((String)null);
/*     */       } else {
/*     */         
/*  79 */         setItemId(str);
/*     */       } 
/*  81 */       str = tokens[2];
/*     */       
/*  83 */       if ("null".equals(str)) {
/*  84 */         setFieldId((String)null);
/*     */       } else {
/*     */         
/*  87 */         setFieldId(str);
/*     */       } 
/*  89 */       str = tokens[3];
/*     */       
/*  91 */       if ("null".equals(str)) {
/*  92 */         setStartValue((String)null);
/*     */       } else {
/*     */         
/*  95 */         setStartValue(str);
/*     */       } 
/*  97 */       str = tokens[4];
/*     */       
/*  99 */       if ("null".equals(str)) {
/* 100 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 103 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 106 */     } catch (Exception ee) {
/* 107 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 113 */     if (this == ob) {
/* 114 */       return true;
/*     */     }
/* 116 */     if (!(ob instanceof ItemRestrictGS1PropertyId)) {
/* 117 */       return false;
/*     */     }
/* 119 */     ItemRestrictGS1PropertyId other = (ItemRestrictGS1PropertyId)ob;
/* 120 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 123 */       .equals(other._organizationId))) && ((this._itemId == null && other._itemId == null) || (this._itemId != null && this._itemId
/*     */ 
/*     */       
/* 126 */       .equals(other._itemId))) && ((this._fieldId == null && other._fieldId == null) || (this._fieldId != null && this._fieldId
/*     */ 
/*     */       
/* 129 */       .equals(other._fieldId))) && ((this._startValue == null && other._startValue == null) || (this._startValue != null && this._startValue
/*     */ 
/*     */       
/* 132 */       .equals(other._startValue))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 135 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 141 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 142 */       .hashCode()) + ((this._itemId == null) ? 0 : this._itemId
/* 143 */       .hashCode()) + ((this._fieldId == null) ? 0 : this._fieldId
/* 144 */       .hashCode()) + ((this._startValue == null) ? 0 : this._startValue
/* 145 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 146 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 151 */     return "ItemRestrictGS1Property";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 156 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 158 */     return buff.append(
/* 159 */         String.valueOf(this._organizationId))
/* 160 */       .append("::").append(this._itemId)
/* 161 */       .append("::").append(this._fieldId)
/* 162 */       .append("::").append(this._startValue)
/* 163 */       .append("::").append(this._propertyCode)
/* 164 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 168 */     if (this._itemId == null) {
/* 169 */       return false;
/*     */     }
/* 171 */     if (this._fieldId == null) {
/* 172 */       return false;
/*     */     }
/* 174 */     if (this._startValue == null) {
/* 175 */       return false;
/*     */     }
/* 177 */     if (this._propertyCode == null) {
/* 178 */       return false;
/*     */     }
/* 180 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\ItemRestrictGS1PropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */