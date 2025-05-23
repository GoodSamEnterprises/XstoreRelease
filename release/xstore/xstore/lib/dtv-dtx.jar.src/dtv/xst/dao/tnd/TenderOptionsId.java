/*     */ package dtv.xst.dao.tnd;
/*     */ 
/*     */ import dtv.data2.access.AbstractObjectId;
/*     */ import dtv.data2.access.IHasConfigElement;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.exception.DtxException;
/*     */ import dtv.util.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TenderOptionsId
/*     */   extends AbstractObjectId
/*     */   implements IHasConfigElement
/*     */ {
/*     */   private static final long serialVersionUID = -1928444662L;
/*     */   private String _tenderId;
/*     */   private String _configElement;
/*     */   
/*     */   public IObjectId getObjectId() {
/*  21 */     return (IObjectId)this;
/*     */   }
/*     */ 
/*     */   
/*     */   public TenderOptionsId() {}
/*     */ 
/*     */   
/*     */   public TenderOptionsId(String argObjectIdValue) {
/*  29 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTenderId() {
/*  36 */     return this._tenderId;
/*     */   }
/*     */   
/*     */   public void setTenderId(String argTenderId) {
/*  40 */     this._tenderId = (argTenderId != null && MANAGE_CASE) ? argTenderId.toUpperCase() : argTenderId;
/*     */   }
/*     */   
/*     */   public String getConfigElement() {
/*  44 */     return this._configElement;
/*     */   }
/*     */   
/*     */   public void setConfigElement(String argConfigElement) {
/*  48 */     this._configElement = (argConfigElement != null && MANAGE_CASE) ? argConfigElement.toUpperCase() : argConfigElement;
/*     */   }
/*     */   
/*     */   public void setValue(String argObjectIdValue) {
/*  52 */     String str = argObjectIdValue;
/*  53 */     if (StringUtils.isEmpty(str)) {
/*  54 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*     */     }
/*     */     try {
/*  57 */       String[] tokens = str.split("::");
/*  58 */       str = tokens[0];
/*     */       
/*  60 */       setOrganizationId(Long.valueOf(str));
/*  61 */       str = tokens[1];
/*     */       
/*  63 */       if ("null".equals(str)) {
/*  64 */         setTenderId((String)null);
/*     */       } else {
/*     */         
/*  67 */         setTenderId(str);
/*     */       } 
/*  69 */       str = tokens[2];
/*     */       
/*  71 */       if ("null".equals(str)) {
/*  72 */         setConfigElement((String)null);
/*     */       } else {
/*     */         
/*  75 */         setConfigElement(str);
/*     */       }
/*     */     
/*  78 */     } catch (Exception ee) {
/*  79 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  85 */     if (this == ob) {
/*  86 */       return true;
/*     */     }
/*  88 */     if (!(ob instanceof TenderOptionsId)) {
/*  89 */       return false;
/*     */     }
/*  91 */     TenderOptionsId other = (TenderOptionsId)ob;
/*  92 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  95 */       .equals(other._organizationId))) && ((this._tenderId == null && other._tenderId == null) || (this._tenderId != null && this._tenderId
/*     */ 
/*     */       
/*  98 */       .equals(other._tenderId))) && ((this._configElement == null && other._configElement == null) || (this._configElement != null && this._configElement
/*     */ 
/*     */       
/* 101 */       .equals(other._configElement))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 107 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 108 */       .hashCode()) + ((this._tenderId == null) ? 0 : this._tenderId
/* 109 */       .hashCode()) + ((this._configElement == null) ? 0 : this._configElement
/* 110 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 115 */     return "TenderOptions";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 120 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 122 */     return buff.append(
/* 123 */         String.valueOf(this._organizationId))
/* 124 */       .append("::").append(this._tenderId)
/* 125 */       .append("::").append(this._configElement)
/* 126 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 130 */     if (this._tenderId == null) {
/* 131 */       return false;
/*     */     }
/* 133 */     if (this._configElement == null) {
/* 134 */       return false;
/*     */     }
/* 136 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tnd\TenderOptionsId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */