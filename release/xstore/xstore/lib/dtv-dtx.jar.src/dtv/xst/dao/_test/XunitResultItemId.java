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
/*     */ public class XunitResultItemId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = -1907652660L;
/*     */   private String _hostname;
/*     */   private Long _resultTimestamp;
/*     */   private Long _resultItemSequence;
/*     */   
/*     */   public XunitResultItemId() {}
/*     */   
/*     */   public XunitResultItemId(String argObjectIdValue) {
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
/*     */   public Long getResultItemSequence() {
/*  47 */     return this._resultItemSequence;
/*     */   }
/*     */   
/*     */   public void setResultItemSequence(Long argResultItemSequence) {
/*  51 */     this._resultItemSequence = argResultItemSequence;
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
/*  77 */       setResultItemSequence(Long.valueOf(str));
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
/*  89 */     if (!(ob instanceof XunitResultItemId)) {
/*  90 */       return false;
/*     */     }
/*  92 */     XunitResultItemId other = (XunitResultItemId)ob;
/*  93 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  96 */       .equals(other._organizationId))) && ((this._hostname == null && other._hostname == null) || (this._hostname != null && this._hostname
/*     */ 
/*     */       
/*  99 */       .equals(other._hostname))) && ((this._resultTimestamp == null && other._resultTimestamp == null) || (this._resultTimestamp != null && this._resultTimestamp
/*     */ 
/*     */       
/* 102 */       .equals(other._resultTimestamp))) && ((this._resultItemSequence == null && other._resultItemSequence == null) || (this._resultItemSequence != null && this._resultItemSequence
/*     */ 
/*     */       
/* 105 */       .equals(other._resultItemSequence))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 111 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 112 */       .hashCode()) + ((this._hostname == null) ? 0 : this._hostname
/* 113 */       .hashCode()) + ((this._resultTimestamp == null) ? 0 : this._resultTimestamp
/* 114 */       .hashCode()) + ((this._resultItemSequence == null) ? 0 : this._resultItemSequence
/* 115 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 120 */     return "XunitResultItem";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 125 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 127 */     return buff.append(
/* 128 */         String.valueOf(this._organizationId))
/* 129 */       .append("::").append(this._hostname)
/* 130 */       .append("::").append(String.valueOf(this._resultTimestamp))
/* 131 */       .append("::").append(String.valueOf(this._resultItemSequence))
/* 132 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 136 */     if (this._hostname == null) {
/* 137 */       return false;
/*     */     }
/* 139 */     if (this._resultTimestamp == null) {
/* 140 */       return false;
/*     */     }
/* 142 */     if (this._resultItemSequence == null) {
/* 143 */       return false;
/*     */     }
/* 145 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\_test\XunitResultItemId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */