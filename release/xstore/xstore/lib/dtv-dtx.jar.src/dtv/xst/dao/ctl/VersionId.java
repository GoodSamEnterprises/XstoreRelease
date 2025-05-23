/*    */ package dtv.xst.dao.ctl;
/*    */ 
/*    */ import dtv.data2.access.AbstractObjectId;
/*    */ import dtv.data2.access.exception.DtxException;
/*    */ import dtv.util.StringUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class VersionId
/*    */   extends AbstractObjectId
/*    */ {
/*    */   private static final long serialVersionUID = 2016261304L;
/*    */   
/*    */   public VersionId() {}
/*    */   
/*    */   public VersionId(String argObjectIdValue) {
/* 23 */     setValue(argObjectIdValue);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setValue(String argObjectIdValue) {
/* 28 */     String str = argObjectIdValue;
/* 29 */     if (StringUtils.isEmpty(str)) {
/* 30 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*    */     }
/*    */     try {
/* 33 */       String[] tokens = str.split("::");
/* 34 */       str = tokens[0];
/*    */       
/* 36 */       setOrganizationId(Long.valueOf(str));
/*    */     }
/* 38 */     catch (Exception ee) {
/* 39 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object ob) {
/* 45 */     if (this == ob) {
/* 46 */       return true;
/*    */     }
/* 48 */     if (!(ob instanceof VersionId)) {
/* 49 */       return false;
/*    */     }
/* 51 */     VersionId other = (VersionId)ob;
/* 52 */     return ((this._organizationId == null && other._organizationId == null) || (this._organizationId != null && this._organizationId
/*    */ 
/*    */       
/* 55 */       .equals(other._organizationId)));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 61 */     return (this._organizationId == null) ? 0 : this._organizationId
/* 62 */       .hashCode();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getDtxTypeName() {
/* 67 */     return "Version";
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 72 */     StringBuilder buff = new StringBuilder(12);
/*    */     
/* 74 */     return buff.append(
/* 75 */         String.valueOf(this._organizationId))
/* 76 */       .toString();
/*    */   }
/*    */   
/*    */   public boolean validate() {
/* 80 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\ctl\VersionId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */