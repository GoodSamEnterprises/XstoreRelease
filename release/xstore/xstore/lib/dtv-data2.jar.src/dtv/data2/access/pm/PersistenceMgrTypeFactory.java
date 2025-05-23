/*    */ package dtv.data2.access.pm;
/*    */ 
/*    */ import dtv.data2.access.IPersistenceMgrType;
/*    */ import dtv.data2.access.config.pmtype.PersistenceMgrTypeConfigHelper;
/*    */ import dtv.data2.access.config.pmtype.PersistenceMgrTypeDescriptor;
/*    */ import java.util.Collection;
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
/*    */ public class PersistenceMgrTypeFactory
/*    */ {
/*    */   private final PersistenceMgrTypeConfigHelper _configHelper;
/*    */   
/*    */   protected PersistenceMgrTypeFactory(PersistenceMgrTypeConfigHelper cfg) {
/* 23 */     this._configHelper = cfg;
/* 24 */     this._configHelper.initialize();
/*    */   }
/*    */   
/*    */   public Collection<PersistenceMgrTypeDescriptor> getPersistenceMgrtTypeDescriptors() {
/* 28 */     return this._configHelper.getDescriptors();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public PersistenceMgrTypeDescriptor getPersistenceMgrTypeDescriptor(IPersistenceMgrType argType) throws NoSuchDescriptorException {
/* 34 */     String typeName = argType.getName();
/*    */ 
/*    */     
/* 37 */     PersistenceMgrTypeDescriptor descriptor = this._configHelper.getDescriptor(typeName);
/*    */ 
/*    */     
/* 40 */     if (descriptor == null) {
/* 41 */       throw new NoSuchDescriptorException(typeName);
/*    */     }
/*    */ 
/*    */     
/* 45 */     return descriptor;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static class NoSuchDescriptorException
/*    */     extends RuntimeException
/*    */   {
/*    */     private static final long serialVersionUID = 1L;
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public NoSuchDescriptorException(String descriptorTypeName) {
/* 61 */       super("No such Persistence Manager Type Descriptor: '" + descriptorTypeName + "'");
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\pm\PersistenceMgrTypeFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */