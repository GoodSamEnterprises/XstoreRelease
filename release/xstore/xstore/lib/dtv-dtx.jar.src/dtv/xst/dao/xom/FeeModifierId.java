/*     */ package dtv.xst.dao.xom;
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
/*     */ public class FeeModifierId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1974252637L;
/*     */   private String _orderId;
/*     */   private Integer _sequence;
/*     */   private Integer _modSequence;
/*     */   
/*     */   public FeeModifierId() {}
/*     */   
/*     */   public FeeModifierId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrderId() {
/*  31 */     return this._orderId;
/*     */   }
/*     */   
/*     */   public void setOrderId(String argOrderId) {
/*  35 */     this._orderId = (argOrderId != null && MANAGE_CASE) ? argOrderId.toUpperCase() : argOrderId;
/*     */   }
/*     */   
/*     */   public Integer getSequence() {
/*  39 */     return this._sequence;
/*     */   }
/*     */   
/*     */   public void setSequence(Integer argSequence) {
/*  43 */     this._sequence = argSequence;
/*     */   }
/*     */   
/*     */   public Integer getModSequence() {
/*  47 */     return this._modSequence;
/*     */   }
/*     */   
/*     */   public void setModSequence(Integer argModSequence) {
/*  51 */     this._modSequence = argModSequence;
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
/*  67 */         setOrderId((String)null);
/*     */       } else {
/*     */         
/*  70 */         setOrderId(str);
/*     */       } 
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       setSequence(Integer.valueOf(str));
/*  75 */       str = tokens[3];
/*     */       
/*  77 */       setModSequence(Integer.valueOf(str));
/*     */     }
/*  79 */     catch (Exception ee) {
/*  80 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  86 */     if (this == ob) {
/*  87 */       return true;
/*     */     }
/*  89 */     if (!(ob instanceof FeeModifierId)) {
/*  90 */       return false;
/*     */     }
/*  92 */     FeeModifierId other = (FeeModifierId)ob;
/*  93 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  96 */       .equals(other._organizationId))) && ((this._orderId == null && other._orderId == null) || (this._orderId != null && this._orderId
/*     */ 
/*     */       
/*  99 */       .equals(other._orderId))) && ((this._sequence == null && other._sequence == null) || (this._sequence != null && this._sequence
/*     */ 
/*     */       
/* 102 */       .equals(other._sequence))) && ((this._modSequence == null && other._modSequence == null) || (this._modSequence != null && this._modSequence
/*     */ 
/*     */       
/* 105 */       .equals(other._modSequence))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 111 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 112 */       .hashCode()) + ((this._orderId == null) ? 0 : this._orderId
/* 113 */       .hashCode()) + ((this._sequence == null) ? 0 : this._sequence
/* 114 */       .hashCode()) + ((this._modSequence == null) ? 0 : this._modSequence
/* 115 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 120 */     return "FeeModifier";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 125 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 127 */     return buff.append(
/* 128 */         String.valueOf(this._organizationId))
/* 129 */       .append("::").append(this._orderId)
/* 130 */       .append("::").append(String.valueOf(this._sequence))
/* 131 */       .append("::").append(String.valueOf(this._modSequence))
/* 132 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 136 */     if (this._orderId == null) {
/* 137 */       return false;
/*     */     }
/* 139 */     if (this._sequence == null) {
/* 140 */       return false;
/*     */     }
/* 142 */     if (this._modSequence == null) {
/* 143 */       return false;
/*     */     }
/* 145 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\FeeModifierId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */