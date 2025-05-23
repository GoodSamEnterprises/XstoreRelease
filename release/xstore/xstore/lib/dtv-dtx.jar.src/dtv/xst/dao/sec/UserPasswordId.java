/*     */ package dtv.xst.dao.sec;
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
/*     */ public class UserPasswordId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 613376934L;
/*     */   private String _user;
/*     */   private Long _sequence;
/*     */   
/*     */   public UserPasswordId() {}
/*     */   
/*     */   public UserPasswordId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUser() {
/*  30 */     return this._user;
/*     */   }
/*     */   
/*     */   public void setUser(String argUser) {
/*  34 */     this._user = (argUser != null && MANAGE_CASE) ? argUser.toUpperCase() : argUser;
/*     */   }
/*     */   
/*     */   public Long getSequence() {
/*  38 */     return this._sequence;
/*     */   }
/*     */   
/*     */   public void setSequence(Long argSequence) {
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
/*  58 */         setUser((String)null);
/*     */       } else {
/*     */         
/*  61 */         setUser(str);
/*     */       } 
/*  63 */       str = tokens[2];
/*     */       
/*  65 */       setSequence(Long.valueOf(str));
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
/*  77 */     if (!(ob instanceof UserPasswordId)) {
/*  78 */       return false;
/*     */     }
/*  80 */     UserPasswordId other = (UserPasswordId)ob;
/*  81 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  84 */       .equals(other._organizationId))) && ((this._user == null && other._user == null) || (this._user != null && this._user
/*     */ 
/*     */       
/*  87 */       .equals(other._user))) && ((this._sequence == null && other._sequence == null) || (this._sequence != null && this._sequence
/*     */ 
/*     */       
/*  90 */       .equals(other._sequence))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  96 */     return ((this._organizationId == null) ? 0 : this._organizationId
/*  97 */       .hashCode()) + ((this._user == null) ? 0 : this._user
/*  98 */       .hashCode()) + ((this._sequence == null) ? 0 : this._sequence
/*  99 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 104 */     return "UserPassword";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 109 */     StringBuilder buff = new StringBuilder(36);
/*     */     
/* 111 */     return buff.append(
/* 112 */         String.valueOf(this._organizationId))
/* 113 */       .append("::").append(this._user)
/* 114 */       .append("::").append(String.valueOf(this._sequence))
/* 115 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 119 */     if (this._user == null) {
/* 120 */       return false;
/*     */     }
/* 122 */     if (this._sequence == null) {
/* 123 */       return false;
/*     */     }
/* 125 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\sec\UserPasswordId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */