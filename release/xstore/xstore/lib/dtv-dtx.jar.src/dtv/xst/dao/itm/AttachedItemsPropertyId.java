/*     */ package dtv.xst.dao.itm;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AttachedItemsPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -57756079L;
/*     */   private String _attachedItemId;
/*     */   private String _soldItemId;
/*     */   private String _levelCode;
/*     */   private String _levelValue;
/*     */   private String _propertyCode;
/*     */   
/*     */   public AttachedItemsPropertyId() {}
/*     */   
/*     */   public AttachedItemsPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAttachedItemId() {
/*  33 */     return this._attachedItemId;
/*     */   }
/*     */   
/*     */   public void setAttachedItemId(String argAttachedItemId) {
/*  37 */     this._attachedItemId = (argAttachedItemId != null && MANAGE_CASE) ? argAttachedItemId.toUpperCase() : argAttachedItemId;
/*     */   }
/*     */   
/*     */   public String getSoldItemId() {
/*  41 */     return this._soldItemId;
/*     */   }
/*     */   
/*     */   public void setSoldItemId(String argSoldItemId) {
/*  45 */     this._soldItemId = (argSoldItemId != null && MANAGE_CASE) ? argSoldItemId.toUpperCase() : argSoldItemId;
/*     */   }
/*     */   
/*     */   public String getLevelCode() {
/*  49 */     return this._levelCode;
/*     */   }
/*     */   
/*     */   public void setLevelCode(String argLevelCode) {
/*  53 */     this._levelCode = (argLevelCode != null && MANAGE_CASE) ? argLevelCode.toUpperCase() : argLevelCode;
/*     */   }
/*     */   
/*     */   public String getLevelValue() {
/*  57 */     return this._levelValue;
/*     */   }
/*     */   
/*     */   public void setLevelValue(String argLevelValue) {
/*  61 */     this._levelValue = (argLevelValue != null && MANAGE_CASE) ? argLevelValue.toUpperCase() : argLevelValue;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  65 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  69 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  73 */     String str = argObjectIdValue;
/*  74 */     if (StringUtils.isEmpty(str)) {
/*  75 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  78 */       String[] tokens = str.split("::");
/*  79 */       str = tokens[0];
/*     */       
/*  81 */       if ("null".equals(str)) {
/*  82 */         setAttachedItemId((String)null);
/*     */       } else {
/*     */         
/*  85 */         setAttachedItemId(str);
/*     */       } 
/*  87 */       str = tokens[1];
/*     */       
/*  89 */       setOrganizationId(Long.valueOf(str));
/*  90 */       str = tokens[2];
/*     */       
/*  92 */       if ("null".equals(str)) {
/*  93 */         setSoldItemId((String)null);
/*     */       } else {
/*     */         
/*  96 */         setSoldItemId(str);
/*     */       } 
/*  98 */       str = tokens[3];
/*     */       
/* 100 */       if ("null".equals(str)) {
/* 101 */         setLevelCode((String)null);
/*     */       } else {
/*     */         
/* 104 */         setLevelCode(str);
/*     */       } 
/* 106 */       str = tokens[4];
/*     */       
/* 108 */       if ("null".equals(str)) {
/* 109 */         setLevelValue((String)null);
/*     */       } else {
/*     */         
/* 112 */         setLevelValue(str);
/*     */       } 
/* 114 */       str = tokens[5];
/*     */       
/* 116 */       if ("null".equals(str)) {
/* 117 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 120 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 123 */     } catch (Exception ee) {
/* 124 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 130 */     if (this == ob) {
/* 131 */       return true;
/*     */     }
/* 133 */     if (!(ob instanceof AttachedItemsPropertyId)) {
/* 134 */       return false;
/*     */     }
/* 136 */     AttachedItemsPropertyId other = (AttachedItemsPropertyId)ob;
/* 137 */     return (((this._attachedItemId == null && other._attachedItemId == null) || (this._attachedItemId != null && this._attachedItemId
/*     */ 
/*     */       
/* 140 */       .equals(other._attachedItemId))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 143 */       .equals(other._organizationId))) && ((this._soldItemId == null && other._soldItemId == null) || (this._soldItemId != null && this._soldItemId
/*     */ 
/*     */       
/* 146 */       .equals(other._soldItemId))) && ((this._levelCode == null && other._levelCode == null) || (this._levelCode != null && this._levelCode
/*     */ 
/*     */       
/* 149 */       .equals(other._levelCode))) && ((this._levelValue == null && other._levelValue == null) || (this._levelValue != null && this._levelValue
/*     */ 
/*     */       
/* 152 */       .equals(other._levelValue))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 155 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 161 */     return ((this._attachedItemId == null) ? 0 : this._attachedItemId
/* 162 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 163 */       .hashCode()) + ((this._soldItemId == null) ? 0 : this._soldItemId
/* 164 */       .hashCode()) + ((this._levelCode == null) ? 0 : this._levelCode
/* 165 */       .hashCode()) + ((this._levelValue == null) ? 0 : this._levelValue
/* 166 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 167 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 172 */     return "AttachedItemsProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 177 */     StringBuilder buff = new StringBuilder(72);
/*     */     
/* 179 */     return buff.append(this._attachedItemId)
/*     */       
/* 181 */       .append("::").append(String.valueOf(this._organizationId))
/* 182 */       .append("::").append(this._soldItemId)
/* 183 */       .append("::").append(this._levelCode)
/* 184 */       .append("::").append(this._levelValue)
/* 185 */       .append("::").append(this._propertyCode)
/* 186 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 190 */     if (this._attachedItemId == null) {
/* 191 */       return false;
/*     */     }
/* 193 */     if (this._soldItemId == null) {
/* 194 */       return false;
/*     */     }
/* 196 */     if (this._levelCode == null) {
/* 197 */       return false;
/*     */     }
/* 199 */     if (this._levelValue == null) {
/* 200 */       return false;
/*     */     }
/* 202 */     if (this._propertyCode == null) {
/* 203 */       return false;
/*     */     }
/* 205 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\AttachedItemsPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */