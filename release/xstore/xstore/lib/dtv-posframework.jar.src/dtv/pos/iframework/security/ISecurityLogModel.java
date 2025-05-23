/*    */ package dtv.pos.iframework.security;
/*    */ 
/*    */ import dtv.logbuilder.model.IAuthModel;
/*    */ import dtv.logbuilder.model.IOverrideModel;
/*    */ import dtv.util.TypeSafeMapKey;
/*    */ import dtv.xst.daocommon.ISystemUser;
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
/*    */ public interface ISecurityLogModel
/*    */   extends IAuthModel, IOverrideModel
/*    */ {
/* 21 */   public static final TypeSafeMapKey<ISecurityLogModel> PROP_SECURITY_LOG_MODEL = new TypeSafeMapKey("SecurityLogModel", ISecurityLogModel.class);
/*    */   
/*    */   ProcessingStep getProcessingStep();
/*    */   
/*    */   ISystemUser getTempSystemUser();
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\security\ISecurityLogModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */