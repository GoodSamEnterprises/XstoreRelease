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
/*     */ public class AddressModifierPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1388957120L;
/*     */   private String _orderId;
/*     */   private Long _sequence;
/*     */   private String _propertyCode;
/*     */   
/*     */   public AddressModifierPropertyId() {}
/*     */   
/*     */   public AddressModifierPropertyId(String argObjectIdValue) {
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
/*     */   public Long getSequence() {
/*  39 */     return this._sequence;
/*     */   }
/*     */   
/*     */   public void setSequence(Long argSequence) {
/*  43 */     this._sequence = argSequence;
/*     */   }
/*     */   
/*     */   public String getPropertyCode() {
/*  47 */     return this._propertyCode;
/*     */   }
/*     */   
/*     */   public void setPropertyCode(String argPropertyCode) {
/*  51 */     this._propertyCode = (argPropertyCode != null && MANAGE_CASE) ? argPropertyCode.toUpperCase() : argPropertyCode;
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
/*  74 */       setSequence(Long.valueOf(str));
/*  75 */       str = tokens[3];
/*     */       
/*  77 */       if ("null".equals(str)) {
/*  78 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  81 */         setPropertyCode(str);
/*     */       }
/*     */     
/*  84 */     } catch (Exception ee) {
/*  85 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  91 */     if (this == ob) {
/*  92 */       return true;
/*     */     }
/*  94 */     if (!(ob instanceof AddressModifierPropertyId)) {
/*  95 */       return false;
/*     */     }
/*  97 */     AddressModifierPropertyId other = (AddressModifierPropertyId)ob;
/*  98 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 101 */       .equals(other._organizationId))) && ((this._orderId == null && other._orderId == null) || (this._orderId != null && this._orderId
/*     */ 
/*     */       
/* 104 */       .equals(other._orderId))) && ((this._sequence == null && other._sequence == null) || (this._sequence != null && this._sequence
/*     */ 
/*     */       
/* 107 */       .equals(other._sequence))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 110 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 116 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 117 */       .hashCode()) + ((this._orderId == null) ? 0 : this._orderId
/* 118 */       .hashCode()) + ((this._sequence == null) ? 0 : this._sequence
/* 119 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 120 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 125 */     return "AddressModifierProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 132 */     return buff.append(
/* 133 */         String.valueOf(this._organizationId))
/* 134 */       .append("::").append(this._orderId)
/* 135 */       .append("::").append(String.valueOf(this._sequence))
/* 136 */       .append("::").append(this._propertyCode)
/* 137 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 141 */     if (this._orderId == null) {
/* 142 */       return false;
/*     */     }
/* 144 */     if (this._sequence == null) {
/* 145 */       return false;
/*     */     }
/* 147 */     if (this._propertyCode == null) {
/* 148 */       return false;
/*     */     }
/* 150 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\AddressModifierPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */