/*     */ package dtv.xst.dao.tsn;
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
/*     */ public class SessionWorkstationId
/*     */   extends AbstractObjectId
/*     */ {
/*     */   private static final long serialVersionUID = 597220525L;
/*     */   private Long _retailLocationId;
/*     */   private Long _sessionId;
/*     */   private Integer _sessionWorkstationSequenceNbr;
/*     */   
/*     */   public SessionWorkstationId() {}
/*     */   
/*     */   public SessionWorkstationId(String argObjectIdValue) {
/*  23 */     setValue(argObjectIdValue);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Long getRetailLocationId() {
/*  31 */     return this._retailLocationId;
/*     */   }
/*     */   
/*     */   public void setRetailLocationId(Long argRetailLocationId) {
/*  35 */     this._retailLocationId = argRetailLocationId;
/*     */   }
/*     */   
/*     */   public Long getSessionId() {
/*  39 */     return this._sessionId;
/*     */   }
/*     */   
/*     */   public void setSessionId(Long argSessionId) {
/*  43 */     this._sessionId = argSessionId;
/*     */   }
/*     */   
/*     */   public Integer getSessionWorkstationSequenceNbr() {
/*  47 */     return this._sessionWorkstationSequenceNbr;
/*     */   }
/*     */   
/*     */   public void setSessionWorkstationSequenceNbr(Integer argSessionWorkstationSequenceNbr) {
/*  51 */     this._sessionWorkstationSequenceNbr = argSessionWorkstationSequenceNbr;
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
/*  66 */       setRetailLocationId(Long.valueOf(str));
/*  67 */       str = tokens[2];
/*     */       
/*  69 */       setSessionId(Long.valueOf(str));
/*  70 */       str = tokens[3];
/*     */       
/*  72 */       setSessionWorkstationSequenceNbr(Integer.valueOf(str));
/*     */     }
/*  74 */     catch (Exception ee) {
/*  75 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object ob) {
/*  81 */     if (this == ob) {
/*  82 */       return true;
/*     */     }
/*  84 */     if (!(ob instanceof SessionWorkstationId)) {
/*  85 */       return false;
/*     */     }
/*  87 */     SessionWorkstationId other = (SessionWorkstationId)ob;
/*  88 */     return (((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*     */ 
/*     */       
/*  91 */       .equals(other._organizationId))) && ((this._retailLocationId == null && other._retailLocationId == null) || (this._retailLocationId != null && this._retailLocationId
/*     */ 
/*     */       
/*  94 */       .equals(other._retailLocationId))) && ((this._sessionId == null && other._sessionId == null) || (this._sessionId != null && this._sessionId
/*     */ 
/*     */       
/*  97 */       .equals(other._sessionId))) && ((this._sessionWorkstationSequenceNbr == null && other._sessionWorkstationSequenceNbr == null) || (this._sessionWorkstationSequenceNbr != null && this._sessionWorkstationSequenceNbr
/*     */ 
/*     */       
/* 100 */       .equals(other._sessionWorkstationSequenceNbr))));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 106 */     return ((this._organizationId == null) ? 0 : this._organizationId
/* 107 */       .hashCode()) + ((this._retailLocationId == null) ? 0 : this._retailLocationId
/* 108 */       .hashCode()) + ((this._sessionId == null) ? 0 : this._sessionId
/* 109 */       .hashCode()) + ((this._sessionWorkstationSequenceNbr == null) ? 0 : this._sessionWorkstationSequenceNbr
/* 110 */       .hashCode());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDtxTypeName() {
/* 115 */     return "SessionWorkstation";
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 120 */     StringBuilder buff = new StringBuilder(48);
/*     */     
/* 122 */     return buff.append(
/* 123 */         String.valueOf(this._organizationId))
/* 124 */       .append("::").append(String.valueOf(this._retailLocationId))
/* 125 */       .append("::").append(String.valueOf(this._sessionId))
/* 126 */       .append("::").append(String.valueOf(this._sessionWorkstationSequenceNbr))
/* 127 */       .toString();
/*     */   }
/*     */   
/*     */   public boolean validate() {
/* 131 */     if (this._retailLocationId == null) {
/* 132 */       return false;
/*     */     }
/* 134 */     if (this._sessionId == null) {
/* 135 */       return false;
/*     */     }
/* 137 */     if (this._sessionWorkstationSequenceNbr == null) {
/* 138 */       return false;
/*     */     }
/* 140 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\tsn\SessionWorkstationId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */