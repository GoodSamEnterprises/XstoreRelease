/*    */ package dtv.xst.dao.cfg;
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
/*    */ public class XadminUserId
/*    */   extends AbstractObjectId
/*    */ {
/*    */   private static final long serialVersionUID = -91421086L;
/*    */   private String _userName;
/*    */   
/*    */   public XadminUserId() {}
/*    */   
/*    */   public XadminUserId(String argObjectIdValue) {
/* 23 */     setValue(argObjectIdValue);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getUserName() {
/* 29 */     return this._userName;
/*    */   }
/*    */   
/*    */   public void setUserName(String argUserName) {
/* 33 */     this._userName = (argUserName != null && MANAGE_CASE) ? argUserName.toUpperCase() : argUserName;
/*    */   }
/*    */   
/*    */   public void setValue(String argObjectIdValue) {
/* 37 */     String str = argObjectIdValue;
/* 38 */     if (StringUtils.isEmpty(str)) {
/* 39 */       throw new DtxException("argument passed to setValue() is null or empty - a valid value must be passed");
/*    */     }
/*    */     try {
/* 42 */       String[] tokens = str.split("::");
/* 43 */       str = tokens[0];
/*    */       
/* 45 */       if ("null".equals(str)) {
/* 46 */         setUserName(null);
/*    */       } else {
/*    */         
/* 49 */         setUserName(str);
/*    */       }
/*    */     
/* 52 */     } catch (Exception ee) {
/* 53 */       throw new DtxException("An exception occured while parsing object id string: " + argObjectIdValue, ee);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object ob) {
/* 59 */     if (this == ob) {
/* 60 */       return true;
/*    */     }
/* 62 */     if (!(ob instanceof XadminUserId)) {
/* 63 */       return false;
/*    */     }
/* 65 */     XadminUserId other = (XadminUserId)ob;
/* 66 */     return ((this._userName == null && other._userName == null) || (this._userName != null && this._userName
/*    */ 
/*    */       
/* 69 */       .equals(other._userName)));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 75 */     return (this._userName == null) ? 0 : this._userName
/* 76 */       .hashCode();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getDtxTypeName() {
/* 81 */     return "XadminUser";
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder buff = new StringBuilder(12);
/*    */     
/* 88 */     return buff.append(this._userName)
/*    */       
/* 90 */       .toString();
/*    */   }
/*    */   
/*    */   public boolean validate() {
/* 94 */     if (this._userName == null) {
/* 95 */       return false;
/*    */     }
/* 97 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cfg\XadminUserId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */