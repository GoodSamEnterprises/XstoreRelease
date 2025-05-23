/*     */ package dtv.xst.dao._test;
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
/*     */ public class XunitResultPropertyId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1764812302L;
/*     */   private String _hostname;
/*     */   private Long _resultTimestamp;
/*     */   private String _propertyCode;
/*     */   
/*     */   public XunitResultPropertyId() {}
/*     */   
/*     */   public XunitResultPropertyId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getHostname() {
/*  31 */     return this._hostname;
/*     */   }
/*     */   
/*     */   public void setHostname(String argHostname) {
/*  35 */     this._hostname = (argHostname != null && MANAGE_CASE) ? argHostname.toUpperCase() : argHostname;
/*     */   }
/*     */   
/*     */   public Long getResultTimestamp() {
/*  39 */     return this._resultTimestamp;
/*     */   }
/*     */   
/*     */   public void setResultTimestamp(Long argResultTimestamp) {
/*  43 */     this._resultTimestamp = argResultTimestamp;
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
/*  67 */         setHostname((String)null);
/*     */       } else {
/*     */         
/*  70 */         setHostname(str);
/*     */       } 
/*  72 */       str = tokens[2];
/*     */       
/*  74 */       setResultTimestamp(Long.valueOf(str));
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
/*  94 */     if (!(ob instanceof XunitResultPropertyId)) {
/*  95 */       return false;
/*     */     }
/*  97 */     XunitResultPropertyId other = (XunitResultPropertyId)ob;
/*  98 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/* 101 */       .equals(other._organizationId))) && ((this._hostname == null && other._hostname == null) || (this._hostname != null && this._hostname
/*     */ 
/*     */       
/* 104 */       .equals(other._hostname))) && ((this._resultTimestamp == null && other._resultTimestamp == null) || (this._resultTimestamp != null && this._resultTimestamp
/*     */ 
/*     */       
/* 107 */       .equals(other._resultTimestamp))) && ((this._propertyCode == null && other._propertyCode == null) || (this._propertyCode != null && this._propertyCode
/*     */ 
/*     */       
/* 110 */       .equals(other._propertyCode))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 116 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 117 */       .hashCode()) + ((this._hostname == null) ? 0 : this._hostname
/* 118 */       .hashCode()) + ((this._resultTimestamp == null) ? 0 : this._resultTimestamp
/* 119 */       .hashCode()) + ((this._propertyCode == null) ? 0 : this._propertyCode
/* 120 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 125 */     return "XunitResultProperty";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 130 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 132 */     return buff.append(
/* 133 */         String.valueOf(this._organizationId))
/* 134 */       .append("::").append(this._hostname)
/* 135 */       .append("::").append(String.valueOf(this._resultTimestamp))
/* 136 */       .append("::").append(this._propertyCode)
/* 137 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 141 */     if (this._hostname == null) {
/* 142 */       return false;
/*     */     }
/* 144 */     if (this._resultTimestamp == null) {
/* 145 */       return false;
/*     */     }
/* 147 */     if (this._propertyCode == null) {
/* 148 */       return false;
/*     */     }
/* 150 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\_test\XunitResultPropertyId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */