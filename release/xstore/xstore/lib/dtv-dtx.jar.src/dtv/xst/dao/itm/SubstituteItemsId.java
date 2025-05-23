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
/*     */ public class SubstituteItemsId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 453630758L;
/*     */   private String _primaryItemId;
/*     */   private String _substituteItemId;
/*     */   private String _levelCode;
/*     */   private String _levelValue;
/*     */   
/*     */   public SubstituteItemsId() {}
/*     */   
/*     */   public SubstituteItemsId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPrimaryItemId() {
/*  32 */     return this._primaryItemId;
/*     */   }
/*     */   
/*     */   public void setPrimaryItemId(String argPrimaryItemId) {
/*  36 */     this._primaryItemId = (argPrimaryItemId != null && MANAGE_CASE) ? argPrimaryItemId.toUpperCase() : argPrimaryItemId;
/*     */   }
/*     */   
/*     */   public String getSubstituteItemId() {
/*  40 */     return this._substituteItemId;
/*     */   }
/*     */   
/*     */   public void setSubstituteItemId(String argSubstituteItemId) {
/*  44 */     this._substituteItemId = (argSubstituteItemId != null && MANAGE_CASE) ? argSubstituteItemId.toUpperCase() : argSubstituteItemId;
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
/*  72 */       setOrganizationId(Long.valueOf(str));
/*  73 */       str = tokens[1];
/*     */       
/*  75 */       if ("null".equals(str)) {
/*  76 */         setPrimaryItemId((String)null);
/*     */       } else {
/*     */         
/*  79 */         setPrimaryItemId(str);
/*     */       } 
/*  81 */       str = tokens[2];
/*     */       
/*  83 */       if ("null".equals(str)) {
/*  84 */         setSubstituteItemId((String)null);
/*     */       } else {
/*     */         
/*  87 */         setSubstituteItemId(str);
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
/* 116 */     if (!(ob instanceof SubstituteItemsId)) {
/* 117 */       return false;
/*     */     }
/* 119 */     SubstituteItemsId other = (SubstituteItemsId)ob;
/* 120 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 123 */       .equals(other._organizationId))) && ((this._primaryItemId == null && other._primaryItemId == null) || (this._primaryItemId != null && this._primaryItemId
/*     */ 
/*     */       
/* 126 */       .equals(other._primaryItemId))) && ((this._substituteItemId == null && other._substituteItemId == null) || (this._substituteItemId != null && this._substituteItemId
/*     */ 
/*     */       
/* 129 */       .equals(other._substituteItemId))) && ((this._levelCode == null && other._levelCode == null) || (this._levelCode != null && this._levelCode
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
/* 141 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 142 */       .hashCode()) + ((this._primaryItemId == null) ? 0 : this._primaryItemId
/* 143 */       .hashCode()) + ((this._substituteItemId == null) ? 0 : this._substituteItemId
/* 144 */       .hashCode()) + ((this._levelCode == null) ? 0 : this._levelCode
/* 145 */       .hashCode()) + ((this._levelValue == null) ? 0 : this._levelValue
/* 146 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 151 */     return "SubstituteItems";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 156 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 158 */     return buff.append(
/* 159 */         String.valueOf(this._organizationId))
/* 160 */       .append("::").append(this._primaryItemId)
/* 161 */       .append("::").append(this._substituteItemId)
/* 162 */       .append("::").append(this._levelCode)
/* 163 */       .append("::").append(this._levelValue)
/* 164 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 168 */     if (this._primaryItemId == null) {
/* 169 */       return false;
/*     */     }
/* 171 */     if (this._substituteItemId == null) {
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


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\SubstituteItemsId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */