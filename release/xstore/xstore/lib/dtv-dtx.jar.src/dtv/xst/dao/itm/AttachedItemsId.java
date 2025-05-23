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
/*     */ public class AttachedItemsId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 719229020L;
/*     */   private String _attachedItemId;
/*     */   private String _soldItemId;
/*     */   private String _levelCode;
/*     */   private String _levelValue;
/*     */   
/*     */   public AttachedItemsId() {}
/*     */   
/*     */   public AttachedItemsId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAttachedItemId() {
/*  32 */     return this._attachedItemId;
/*     */   }
/*     */   
/*     */   public void setAttachedItemId(String argAttachedItemId) {
/*  36 */     this._attachedItemId = (argAttachedItemId != null && MANAGE_CASE) ? argAttachedItemId.toUpperCase() : argAttachedItemId;
/*     */   }
/*     */   
/*     */   public String getSoldItemId() {
/*  40 */     return this._soldItemId;
/*     */   }
/*     */   
/*     */   public void setSoldItemId(String argSoldItemId) {
/*  44 */     this._soldItemId = (argSoldItemId != null && MANAGE_CASE) ? argSoldItemId.toUpperCase() : argSoldItemId;
/*     */   }
/*     */   
/*     */   public String getLevelCode() {
/*  48 */     return this._levelCode;
/*     */   }
/*     */   
/*     */   public void setLevelCode(String argLevelCode) {
/*  52 */     this._levelCode = (argLevelCode != null && MANAGE_CASE) ? argLevelCode.toUpperCase() : argLevelCode;
/*     */   }
/*     */   
/*     */   public String getLevelValue() {
/*  56 */     return this._levelValue;
/*     */   }
/*     */   
/*     */   public void setLevelValue(String argLevelValue) {
/*  60 */     this._levelValue = (argLevelValue != null && MANAGE_CASE) ? argLevelValue.toUpperCase() : argLevelValue;
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
/*  72 */       if ("null".equals(str)) {
/*  73 */         setAttachedItemId((String)null);
/*     */       } else {
/*     */         
/*  76 */         setAttachedItemId(str);
/*     */       } 
/*  78 */       str = tokens[1];
/*     */       
/*  80 */       setOrganizationId(Long.valueOf(str));
/*  81 */       str = tokens[2];
/*     */       
/*  83 */       if ("null".equals(str)) {
/*  84 */         setSoldItemId((String)null);
/*     */       } else {
/*     */         
/*  87 */         setSoldItemId(str);
/*     */       } 
/*  89 */       str = tokens[3];
/*     */       
/*  91 */       if ("null".equals(str)) {
/*  92 */         setLevelCode((String)null);
/*     */       } else {
/*     */         
/*  95 */         setLevelCode(str);
/*     */       } 
/*  97 */       str = tokens[4];
/*     */       
/*  99 */       if ("null".equals(str)) {
/* 100 */         setLevelValue((String)null);
/*     */       } else {
/*     */         
/* 103 */         setLevelValue(str);
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
/* 116 */     if (!(ob instanceof AttachedItemsId)) {
/* 117 */       return false;
/*     */     }
/* 119 */     AttachedItemsId other = (AttachedItemsId)ob;
/* 120 */     return (((this._attachedItemId == null && other._attachedItemId == null) || (this._attachedItemId != null && this._attachedItemId
/*     */ 
/*     */       
/* 123 */       .equals(other._attachedItemId))) && ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 126 */       .equals(other._organizationId))) && ((this._soldItemId == null && other._soldItemId == null) || (this._soldItemId != null && this._soldItemId
/*     */ 
/*     */       
/* 129 */       .equals(other._soldItemId))) && ((this._levelCode == null && other._levelCode == null) || (this._levelCode != null && this._levelCode
/*     */ 
/*     */       
/* 132 */       .equals(other._levelCode))) && ((this._levelValue == null && other._levelValue == null) || (this._levelValue != null && this._levelValue
/*     */ 
/*     */       
/* 135 */       .equals(other._levelValue))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 141 */     return ((this._attachedItemId == null) ? 0 : this._attachedItemId
/* 142 */       .hashCode()) + ((this._organizationId == null) ? 0 : this._organizationId
/* 143 */       .hashCode()) + ((this._soldItemId == null) ? 0 : this._soldItemId
/* 144 */       .hashCode()) + ((this._levelCode == null) ? 0 : this._levelCode
/* 145 */       .hashCode()) + ((this._levelValue == null) ? 0 : this._levelValue
/* 146 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 151 */     return "AttachedItems";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 156 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 158 */     return buff.append(this._attachedItemId)
/*     */       
/* 160 */       .append("::").append(String.valueOf(this._organizationId))
/* 161 */       .append("::").append(this._soldItemId)
/* 162 */       .append("::").append(this._levelCode)
/* 163 */       .append("::").append(this._levelValue)
/* 164 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 168 */     if (this._attachedItemId == null) {
/* 169 */       return false;
/*     */     }
/* 171 */     if (this._soldItemId == null) {
/* 172 */       return false;
/*     */     }
/* 174 */     if (this._levelCode == null) {
/* 175 */       return false;
/*     */     }
/* 177 */     if (this._levelValue == null) {
/* 178 */       return false;
/*     */     }
/* 180 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\AttachedItemsId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */