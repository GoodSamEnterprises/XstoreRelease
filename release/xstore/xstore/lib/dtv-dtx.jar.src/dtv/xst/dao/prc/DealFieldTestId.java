/*     */ package dtv.xst.dao.prc;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DealFieldTestId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1604134528L;
/*     */   private String _dealId;
/*     */   private Integer _ordinal;
/*     */   private Integer _itemConditionGroup;
/*     */   private Integer _itemConditionSeq;
/*     */   
/*     */   public DealFieldTestId() {}
/*     */   
/*     */   public DealFieldTestId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDealId() {
/*  32 */     return this._dealId;
/*     */   }
/*     */   
/*     */   public void setDealId(String argDealId) {
/*  36 */     this._dealId = (argDealId != null && MANAGE_CASE) ? argDealId.toUpperCase() : argDealId;
/*     */   }
/*     */   
/*     */   public Integer getOrdinal() {
/*  40 */     return this._ordinal;
/*     */   }
/*     */   
/*     */   public void setOrdinal(Integer argOrdinal) {
/*  44 */     this._ordinal = argOrdinal;
/*     */   }
/*     */   
/*     */   public Integer getItemConditionGroup() {
/*  48 */     return this._itemConditionGroup;
/*     */   }
/*     */   
/*     */   public void setItemConditionGroup(Integer argItemConditionGroup) {
/*  52 */     this._itemConditionGroup = argItemConditionGroup;
/*     */   }
/*     */   
/*     */   public Integer getItemConditionSeq() {
/*  56 */     return this._itemConditionSeq;
/*     */   }
/*     */   
/*     */   public void setItemConditionSeq(Integer argItemConditionSeq) {
/*  60 */     this._itemConditionSeq = argItemConditionSeq;
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
/*  76 */         setDealId((String)null);
/*     */       } else {
/*     */         
/*  79 */         setDealId(str);
/*     */       } 
/*  81 */       str = tokens[2];
/*     */       
/*  83 */       setOrdinal(Integer.valueOf(str));
/*  84 */       str = tokens[3];
/*     */       
/*  86 */       setItemConditionGroup(Integer.valueOf(str));
/*  87 */       str = tokens[4];
/*     */       
/*  89 */       setItemConditionSeq(Integer.valueOf(str));
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
/* 101 */     if (!(ob instanceof DealFieldTestId)) {
/* 102 */       return false;
/*     */     }
/* 104 */     DealFieldTestId other = (DealFieldTestId)ob;
/* 105 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 108 */       .equals(other._organizationId))) && ((this._dealId == null && other._dealId == null) || (this._dealId != null && this._dealId
/*     */ 
/*     */       
/* 111 */       .equals(other._dealId))) && ((this._ordinal == null && other._ordinal == null) || (this._ordinal != null && this._ordinal
/*     */ 
/*     */       
/* 114 */       .equals(other._ordinal))) && ((this._itemConditionGroup == null && other._itemConditionGroup == null) || (this._itemConditionGroup != null && this._itemConditionGroup
/*     */ 
/*     */       
/* 117 */       .equals(other._itemConditionGroup))) && ((this._itemConditionSeq == null && other._itemConditionSeq == null) || (this._itemConditionSeq != null && this._itemConditionSeq
/*     */ 
/*     */       
/* 120 */       .equals(other._itemConditionSeq))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 126 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 127 */       .hashCode()) + ((this._dealId == null) ? 0 : this._dealId
/* 128 */       .hashCode()) + ((this._ordinal == null) ? 0 : this._ordinal
/* 129 */       .hashCode()) + ((this._itemConditionGroup == null) ? 0 : this._itemConditionGroup
/* 130 */       .hashCode()) + ((this._itemConditionSeq == null) ? 0 : this._itemConditionSeq
/* 131 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 136 */     return "DealFieldTest";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 141 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 143 */     return buff.append(
/* 144 */         String.valueOf(this._organizationId))
/* 145 */       .append("::").append(this._dealId)
/* 146 */       .append("::").append(String.valueOf(this._ordinal))
/* 147 */       .append("::").append(String.valueOf(this._itemConditionGroup))
/* 148 */       .append("::").append(String.valueOf(this._itemConditionSeq))
/* 149 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 153 */     if (this._dealId == null) {
/* 154 */       return false;
/*     */     }
/* 156 */     if (this._ordinal == null) {
/* 157 */       return false;
/*     */     }
/* 159 */     if (this._itemConditionGroup == null) {
/* 160 */       return false;
/*     */     }
/* 162 */     if (this._itemConditionSeq == null) {
/* 163 */       return false;
/*     */     }
/* 165 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\prc\DealFieldTestId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */