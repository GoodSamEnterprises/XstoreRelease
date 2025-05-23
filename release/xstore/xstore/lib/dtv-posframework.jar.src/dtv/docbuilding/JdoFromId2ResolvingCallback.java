/*    */ package dtv.docbuilding;
/*    */ 
/*    */ import dtv.data2.access.DataFactory;
/*    */ import dtv.data2.access.IObjectId;
/*    */ import dtv.data2.access.IPersistenceMgrType;
/*    */ import dtv.data2.access.ObjectNotFoundException;
/*    */ import dtv.data2.access.pm.PersistenceManagerType;
/*    */ import dtv.util.IMethodChainCallback;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JdoFromId2ResolvingCallback
/*    */   implements IMethodChainCallback
/*    */ {
/* 21 */   private static final JdoFromId2ResolvingCallback INSTANCE = new JdoFromId2ResolvingCallback();
/* 22 */   private static final Logger logger_ = Logger.getLogger(JdoFromId2ResolvingCallback.class);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static JdoFromId2ResolvingCallback getInstance() {
/* 30 */     return INSTANCE;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Object resolve(Object argValue, String argParameter) {
/*    */     try {
/* 41 */       if (argParameter != null) {
/* 42 */         PersistenceManagerType persistenceManagerType = PersistenceManagerType.forName(argParameter);
/* 43 */         return DataFactory.getObjectById((IObjectId)argValue, (IPersistenceMgrType)persistenceManagerType);
/*    */       } 
/*    */       
/* 46 */       return DataFactory.getObjectById((IObjectId)argValue);
/*    */     
/*    */     }
/* 49 */     catch (ObjectNotFoundException ex) {
/* 50 */       logger_.info("Error attempting to retreive data object from id: '" + argValue, (Throwable)ex);
/*    */     }
/* 52 */     catch (Exception ex) {
/* 53 */       logger_.warn("Error attempting to retreive jdo from id: '" + argValue + "' with persistencemanager type: '" + argParameter + "'", ex);
/*    */     } 
/*    */     
/* 56 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\JdoFromId2ResolvingCallback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */