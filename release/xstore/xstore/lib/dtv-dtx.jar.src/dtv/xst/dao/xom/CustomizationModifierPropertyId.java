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
/*     */ public class CustomizationModifierPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -947792993L;
/*     */   private String _orderId;
/*     */   private Integer _sequence;
/*     */   private Integer _modSequence;
/*     */   private String _propertyCode;
/*     */   
/*     */   public CustomizationModifierPropertyId() {}
/*     */   
/*     */   public CustomizationModifierPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getOrderId() {
/*  32 */     return this._orderId;
/*     */   }
/*     */   
/*     */   public void setOrderId(String argOrderId) {
/*  36 */     this._orderId = (argOrderId != null && MANAGE_CASE) ? argOrderId.toUpperCase() : argOrderId;
/*     */   }
/*     */   
/*     */   public Integer getSequence() {
/*  40 */     return this._sequence;
/*     */   }
/*     */   
/*     */   public void setSequence(Integer argSequence) {
/*  44 */     this._sequence = argSequence;
/*     */   }
/*     */   
/*     */   public Integer getModSequence() {
/*  48 */     return this._modSequence;
/*     */   }
/*     */   
/*     */   public void setModSequence(Integer argModSequence) {
/*  52 */     this._modSequence = argModSequence;
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
/*  76 */         setOrderId((String)null);
/*     */       } else {
/*     */         
/*  79 */         setOrderId(str);
/*     */       } 
/*  81 */       str = tokens[2];
/*     */       
/*  83 */       setSequence(Integer.valueOf(str));
/*  84 */       str = tokens[3];
/*     */       
/*  86 */       setModSequence(Integer.valueOf(str));
/*  87 */       str = tokens[4];
/*     */       
/*  89 */       if ("null".equals(str)) {
/*  90 */         setPropertyCode((String)null);
/*     */       } else {
/*     */         
/*  93 */         setPropertyCode(str);
/*     */       }
/*     */     
/*  96 */     } catch (Exception ee) {
/*  97 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/* 103 */     if (this == ob) {
/* 104 */       return true;
/*     */     }
/* 106 */     if (!(ob instanceof CustomizationModifierPropertyId)) {
/* 107 */       return false;
/*     */     }
/* 109 */     CustomizationModifierPropertyId other = (CustomizationModifierPropertyId)ob;
/* 110 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 113 */       .equals(other._organizationId))) && ((this._orderId == null && other._orderId == null) || (this._orderId != null && this._orderId
/*     */ 
/*     */       
/* 116 */       .equals(other._orderId))) && ((this._sequence == null && other._sequence == null) || (this._sequence != null && this._sequence
/*     */ 
/*     */       
/* 119 */       .equals(other._sequence))) && ((this._modSequence == null && other._modSequence == null) || (this._modSequence != null && this._modSequence
/*     */ 
/*     */       
/* 122 */       .equals(other._modSequence))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 125 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 131 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 132 */       .hashCode()) + ((this._orderId == null) ? 0 : this._orderId
/* 133 */       .hashCode()) + ((this._sequence == null) ? 0 : this._sequence
/* 134 */       .hashCode()) + ((this._modSequence == null) ? 0 : this._modSequence
/* 135 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 136 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 141 */     return "CustomizationModifierProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 146 */     StringBuilder buff = new StringBuilder(60);
/*     */     
/* 148 */     return buff.append(
/* 149 */         String.valueOf(this._organizationId))
/* 150 */       .append("::").append(this._orderId)
/* 151 */       .append("::").append(String.valueOf(this._sequence))
/* 152 */       .append("::").append(String.valueOf(this._modSequence))
/* 153 */       .append("::").append(this._propertyCode)
/* 154 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 158 */     if (this._orderId == null) {
/* 159 */       return false;
/*     */     }
/* 161 */     if (this._sequence == null) {
/* 162 */       return false;
/*     */     }
/* 164 */     if (this._modSequence == null) {
/* 165 */       return false;
/*     */     }
/* 167 */     if (this._propertyCode == null) {
/* 168 */       return false;
/*     */     }
/* 170 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\xom\CustomizationModifierPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */