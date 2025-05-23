/*     */ package dtv.xst.dao.ctl;
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
/*     */ public class IpCashDrawerDeviceId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1578154783L;
/*     */   private Long _retailLocationId;
/*     */   private String _cashDrawerId;
/*     */   
/*     */   public IpCashDrawerDeviceId() {}
/*     */   
/*     */   public IpCashDrawerDeviceId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/*  30 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  34 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public String getCashDrawerId() {
/*  38 */     return this._cashDrawerId;
/*     */   }
/*     */   
/*     */   public void setCashDrawerId(String argCashDrawerId) {
/*  42 */     this._cashDrawerId = (argCashDrawerId != null && MANAGE_CASE) ? argCashDrawerId.toUpperCase() : argCashDrawerId;
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
/*  57 */       setRetailLocationId(Long.valueOf(str));
/*  58 */       str = tokens[2];
/*     */       
/*  60 */       if ("null".equals(str)) {
/*  61 */         setCashDrawerId((String)null);
/*     */       } else {
/*     */         
/*  64 */         setCashDrawerId(str);
/*     */       }
/*     */     
/*  67 */     } catch (Exception ee) {
/*  68 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  74 */     if (this == ob) {
/*  75 */       return true;
/*     */     }
/*  77 */     if (!(ob instanceof IpCashDrawerDeviceId)) {
/*  78 */       return false;
/*     */     }
/*  80 */     IpCashDrawerDeviceId other = (IpCashDrawerDeviceId)ob;
/*  81 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  84 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/*  87 */       .equals(other._retailLocationId))) && ((this._cashDrawerId == null && other._cashDrawerId == null) || (this._cashDrawerId != null && this._cashDrawerId
/*     */ 
/*     */       
/*  90 */       .equals(other._cashDrawerId))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  96 */     return ((this._organizationId == null) ? 0 : this._organizationId
/*  97 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/*  98 */       .hashCode()) + ((this._cashDrawerId == null) ? 0 : this._cashDrawerId
/*  99 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 104 */     return "IpCashDrawerDevice";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 109 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 111 */     return buff.append(
/* 112 */         String.valueOf(this._organizationId))
/* 113 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 114 */       .append("::").append(this._cashDrawerId)
/* 115 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 119 */     if (this._retailLocationId == null) {
/* 120 */       return false;
/*     */     }
/* 122 */     if (this._cashDrawerId == null) {
/* 123 */       return false;
/*     */     }
/* 125 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\IpCashDrawerDeviceId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */