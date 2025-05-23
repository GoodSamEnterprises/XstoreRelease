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
/*     */ 
/*     */ public class FulfillmentModifierId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -914701643L;
/*     */   private String _orderId;
/*     */   private Integer _sequence;
/*     */   
/*     */   public FulfillmentModifierId() {}
/*     */   
/*     */   public FulfillmentModifierId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrderId() {
/*  30 */     return this._orderId;
/*     */   }
/*     */   
/*     */   public void setOrderId(String argOrderId) {
/*  34 */     this._orderId = (argOrderId != null && MANAGE_CASE) ? argOrderId.toUpperCase() : argOrderId;
/*     */   }
/*     */   
/*     */   public Integer getSequence() {
/*  38 */     return this._sequence;
/*     */   }
/*     */   
/*     */   public void setSequence(Integer argSequence) {
/*  42 */     this._sequence = argSequence;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  46 */     String str = argObjectIdValue;
/*  47 */     if (StringUtils.isEmpty(str)) {
/*  48 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  51 */       String[] tokens = str.split("::");
/*  52 */       str = tokens[0];
/*     */       
/*  54 */       setOrganizationId(Long.valueOf(str));
/*  55 */       str = tokens[1];
/*     */       
/*  57 */       if ("null".equals(str)) {
/*  58 */         setOrderId((String)null);
/*     */       } else {
/*     */         
/*  61 */         setOrderId(str);
/*     */       } 
/*  63 */       str = tokens[2];
/*     */       
/*  65 */       setSequence(Integer.valueOf(str));
/*     */     }
/*  67 */     catch (Exception ee) {
/*  68 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  74 */     if (this == ob) {
/*  75 */       return true;
/*     */     }
/*  77 */     if (!(ob instanceof FulfillmentModifierId)) {
/*  78 */       return false;
/*     */     }
/*  80 */     FulfillmentModifierId other = (FulfillmentModifierId)ob;
/*  81 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  84 */       .equals(other._organizationId))) && ((this._orderId == null && other._orderId == null) || (this._orderId != null && this._orderId
/*     */ 
/*     */       
/*  87 */       .equals(other._orderId))) && ((this._sequence == null && other._sequence == null) || (this._sequence != null && this._sequence
/*     */ 
/*     */       
/*  90 */       .equals(other._sequence))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  96 */     return ((this._organizationId == null) ? 0 : this._organizationId
/*  97 */       .hashCode()) + ((this._orderId == null) ? 0 : this._orderId
/*  98 */       .hashCode()) + ((this._sequence == null) ? 0 : this._sequence
/*  99 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 104 */     return "FulfillmentModifier";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 109 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 111 */     return buff.append(
/* 112 */         String.valueOf(this._organizationId))
/* 113 */       .append("::").append(this._orderId)
/* 114 */       .append("::").append(String.valueOf(this._sequence))
/* 115 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 119 */     if (this._orderId == null) {
/* 120 */       return false;
/*     */     }
/* 122 */     if (this._sequence == null) {
/* 123 */       return false;
/*     */     }
/* 125 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\FulfillmentModifierId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */