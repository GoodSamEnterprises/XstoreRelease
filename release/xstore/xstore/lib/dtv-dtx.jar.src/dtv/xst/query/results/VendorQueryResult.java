/*    */ package dtv.xst.query.results;
/*    */ 
/*    */ import dtv.data2.access.AbstractQueryResult;
/*    */ import dtv.data2.access.IObjectId;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class VendorQueryResult
/*    */   extends AbstractQueryResult
/*    */ {
/*    */   private static final long serialVersionUID = 8675309L;
/*    */   private String vendorId_;
/*    */   private String description_;
/*    */   
/*    */   public String getDescription() {
/* 29 */     return this.description_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getVendorId() {
/* 38 */     return this.vendorId_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setDescription(String argDescription) {
/* 47 */     this.description_ = argDescription;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setVendorId(String argVendorId) {
/* 56 */     this.vendorId_ = argVendorId;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected IObjectId getObjectIdImpl() {
/* 62 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\query\results\VendorQueryResult.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */