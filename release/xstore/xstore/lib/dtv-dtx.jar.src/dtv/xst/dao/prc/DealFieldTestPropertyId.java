/*     */ package dtv.xst.dao.prc;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DealFieldTestPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 190421877L;
/*     */   private String _dealId;
/*     */   private Integer _ordinal;
/*     */   private Integer _itemConditionGroup;
/*     */   private Integer _itemConditionSeq;
/*     */   private String _propertyCode;
/*     */   
/*     */   public DealFieldTestPropertyId() {}
/*     */   
/*     */   public DealFieldTestPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDealId() {
/*  33 */     return this._dealId;
/*     */   }
/*     */   
/*     */   public void setDealId(String argDealId) {
/*  37 */     this._dealId = (argDealId != null && MANAGE_CASE) ? argDealId.toUpperCase() : argDealId;
/*     */   }
/*     */   
/*     */   public Integer getOrdinal() {
/*  41 */     return this._ordinal;
/*     */   }
/*     */   
/*     */   public void setOrdinal(Integer argOrdinal) {
/*  45 */     this._ordinal = argOrdinal;
/*     */   }
/*     */   
/*     */   public Integer getItemConditionGroup() {
/*  49 */     return this._itemConditionGroup;
/*     */   }
/*     */   
/*     */   public void setItemConditionGroup(Integer argItemConditionGroup) {
/*  53 */     this._itemConditionGroup = argItemConditionGroup;
/*     */   }
/*     */   
/*     */   public Integer getItemConditionSeq() {
/*  57 */     return this._itemConditionSeq;
/*     */   }
/*     */   
/*     */   public void setItemConditionSeq(Integer argItemConditionSeq) {
/*  61 */     this._itemConditionSeq = argItemConditionSeq;
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
/*  81 */       setOrganizationId(Long.valueOf(str));
/*  82 */       str = tokens[1];
/*     */       
/*  84 */       if ("null".equals(str)) {
/*  85 */         setDealId((String)null);
/*     */       } else {
/*     */         
/*  88 */         setDealId(str);
/*     */       } 
/*  90 */       str = tokens[2];
/*     */       
/*  92 */       setOrdinal(Integer.valueOf(str));
/*  93 */       str = tokens[3];
/*     */       
/*  95 */       setItemConditionGroup(Integer.valueOf(str));
/*  96 */       str = tokens[4];
/*     */       
/*  98 */       setItemConditionSeq(Integer.valueOf(str));
/*  99 */       str = tokens[5];
/*     */       
/* 101 */       if ("null".equals(str)) {
/* 102 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/* 105 */         setPropertyCode(str);
/*     */       }
/*     */     
/* 108 */     } catch (Exception ee) {
/* 109 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 115 */     if (this == ob) {
/* 116 */       return true;
/*     */     }
/* 118 */     if (!(ob instanceof DealFieldTestPropertyId)) {
/* 119 */       return false;
/*     */     }
/* 121 */     DealFieldTestPropertyId other = (DealFieldTestPropertyId)ob;
/* 122 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 125 */       .equals(other._organizationId))) && ((this._dealId == null && other._dealId == null) || (this._dealId != null && this._dealId
/*     */ 
/*     */       
/* 128 */       .equals(other._dealId))) && ((this._ordinal == null && other._ordinal == null) || (this._ordinal != null && this._ordinal
/*     */ 
/*     */       
/* 131 */       .equals(other._ordinal))) && ((this._itemConditionGroup == null && other._itemConditionGroup == null) || (this._itemConditionGroup != null && this._itemConditionGroup
/*     */ 
/*     */       
/* 134 */       .equals(other._itemConditionGroup))) && ((this._itemConditionSeq == null && other._itemConditionSeq == null) || (this._itemConditionSeq != null && this._itemConditionSeq
/*     */ 
/*     */       
/* 137 */       .equals(other._itemConditionSeq))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 140 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 146 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 147 */       .hashCode()) + ((this._dealId == null) ? 0 : this._dealId
/* 148 */       .hashCode()) + ((this._ordinal == null) ? 0 : this._ordinal
/* 149 */       .hashCode()) + ((this._itemConditionGroup == null) ? 0 : this._itemConditionGroup
/* 150 */       .hashCode()) + ((this._itemConditionSeq == null) ? 0 : this._itemConditionSeq
/* 151 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 152 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 157 */     return "DealFieldTestProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 162 */     StringBuilder buff = new StringBuilder(72);
/*     */     
/* 164 */     return buff.append(
/* 165 */         String.valueOf(this._organizationId))
/* 166 */       .append("::").append(this._dealId)
/* 167 */       .append("::").append(String.valueOf(this._ordinal))
/* 168 */       .append("::").append(String.valueOf(this._itemConditionGroup))
/* 169 */       .append("::").append(String.valueOf(this._itemConditionSeq))
/* 170 */       .append("::").append(this._propertyCode)
/* 171 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 175 */     if (this._dealId == null) {
/* 176 */       return false;
/*     */     }
/* 178 */     if (this._ordinal == null) {
/* 179 */       return false;
/*     */     }
/* 181 */     if (this._itemConditionGroup == null) {
/* 182 */       return false;
/*     */     }
/* 184 */     if (this._itemConditionSeq == null) {
/* 185 */       return false;
/*     */     }
/* 187 */     if (this._propertyCode == null) {
/* 188 */       return false;
/*     */     }
/* 190 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\prc\DealFieldTestPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */