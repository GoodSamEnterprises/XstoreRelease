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
/*     */ 
/*     */ public class XunitResultId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1359557351L;
/*     */   private String _hostname;
/*     */   private Long _resultTimestamp;
/*     */   
/*     */   public XunitResultId() {}
/*     */   
/*     */   public XunitResultId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getHostname() {
/*  30 */     return this._hostname;
/*     */   }
/*     */   
/*     */   public void setHostname(String argHostname) {
/*  34 */     this._hostname = (argHostname != null && MANAGE_CASE) ? argHostname.toUpperCase() : argHostname;
/*     */   }
/*     */   
/*     */   public Long getResultTimestamp() {
/*  38 */     return this._resultTimestamp;
/*     */   }
/*     */   
/*     */   public void setResultTimestamp(Long argResultTimestamp) {
/*  42 */     this._resultTimestamp = argResultTimestamp;
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
/*  58 */         setHostname((String)null);
/*     */       } else {
/*     */         
/*  61 */         setHostname(str);
/*     */       } 
/*  63 */       str = tokens[2];
/*     */       
/*  65 */       setResultTimestamp(Long.valueOf(str));
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
/*  77 */     if (!(ob instanceof XunitResultId)) {
/*  78 */       return false;
/*     */     }
/*  80 */     XunitResultId other = (XunitResultId)ob;
/*  81 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  84 */       .equals(other._organizationId))) && ((this._hostname == null && other._hostname == null) || (this._hostname != null && this._hostname
/*     */ 
/*     */       
/*  87 */       .equals(other._hostname))) && ((this._resultTimestamp == null && other._resultTimestamp == null) || (this._resultTimestamp != null && this._resultTimestamp
/*     */ 
/*     */       
/*  90 */       .equals(other._resultTimestamp))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  96 */     return ((this._organizationId == null) ? 0 : this._organizationId
/*  97 */       .hashCode()) + ((this._hostname == null) ? 0 : this._hostname
/*  98 */       .hashCode()) + ((this._resultTimestamp == null) ? 0 : this._resultTimestamp
/*  99 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 104 */     return "XunitResult";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 109 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 111 */     return buff.append(
/* 112 */         String.valueOf(this._organizationId))
/* 113 */       .append("::").append(this._hostname)
/* 114 */       .append("::").append(String.valueOf(this._resultTimestamp))
/* 115 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 119 */     if (this._hostname == null) {
/* 120 */       return false;
/*     */     }
/* 122 */     if (this._resultTimestamp == null) {
/* 123 */       return false;
/*     */     }
/* 125 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\_test\XunitResultId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */