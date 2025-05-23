/*     */ package dtv.xst.dao.cfg;
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
/*     */ public class XadminUserNodeId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 1176774532L;
/*     */   private String _userName;
/*     */   private String _orgScope;
/*     */   
/*     */   public XadminUserNodeId() {}
/*     */   
/*     */   public XadminUserNodeId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUserName() {
/*  30 */     return this._userName;
/*     */   }
/*     */   
/*     */   public void setUserName(String argUserName) {
/*  34 */     this._userName = (argUserName != null && MANAGE_CASE) ? argUserName.toUpperCase() : argUserName;
/*     */   }
/*     */   
/*     */   public String getOrgScope() {
/*  38 */     return this._orgScope;
/*     */   }
/*     */   
/*     */   public void setOrgScope(String argOrgScope) {
/*  42 */     this._orgScope = (argOrgScope != null && MANAGE_CASE) ? argOrgScope.toUpperCase() : argOrgScope;
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
/*  54 */       if ("null".equals(str)) {
/*  55 */         setUserName(null);
/*     */       } else {
/*     */         
/*  58 */         setUserName(str);
/*     */       } 
/*  60 */       str = tokens[1];
/*     */       
/*  62 */       if ("null".equals(str)) {
/*  63 */         setOrgScope(null);
/*     */       } else {
/*     */         
/*  66 */         setOrgScope(str);
/*     */       }
/*     */     
/*  69 */     } catch (Exception ee) {
/*  70 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  76 */     if (this == ob) {
/*  77 */       return true;
/*     */     }
/*  79 */     if (!(ob instanceof XadminUserNodeId)) {
/*  80 */       return false;
/*     */     }
/*  82 */     XadminUserNodeId other = (XadminUserNodeId)ob;
/*  83 */     return (((this._userName == null && other._userName == null) || (this._userName != null && this._userName
/*     */ 
/*     */       
/*  86 */       .equals(other._userName))) && ((this._orgScope == null && other._orgScope == null) || (this._orgScope != null && this._orgScope
/*     */ 
/*     */       
/*  89 */       .equals(other._orgScope))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  95 */     return ((this._userName == null) ? 0 : this._userName
/*  96 */       .hashCode()) + ((this._orgScope == null) ? 0 : this._orgScope
/*  97 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 102 */     return "XadminUserNode";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 107 */     StringBuilder buff = new StringBuilder(24);
/*     */     
/* 109 */     return buff.append(this._userName)
/*     */       
/* 111 */       .append("::").append(this._orgScope)
/* 112 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 116 */     if (this._userName == null) {
/* 117 */       return false;
/*     */     }
/* 119 */     if (this._orgScope == null) {
/* 120 */       return false;
/*     */     }
/* 122 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cfg\XadminUserNodeId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */