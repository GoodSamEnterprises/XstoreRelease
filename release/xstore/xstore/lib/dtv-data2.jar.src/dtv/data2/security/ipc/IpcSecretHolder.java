/*    */ package dtv.data2.security.ipc;
/*    */ 
/*    */ import dtv.data2.access.DataFactory;
/*    */ import dtv.data2.access.IQueryKey;
/*    */ import dtv.data2.access.ObjectNotFoundException;
/*    */ import dtv.data2.access.QueryKey;
/*    */ import dtv.ipc.server.AbstractIpcSecretHolder;
/*    */ import dtv.ipc.server.DbPasswordLookupException;
/*    */ import dtv.util.DateUtils;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import oracle.retail.xstore.passwd.totp.TotpSecretGenerator;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IpcSecretHolder
/*    */   extends AbstractIpcSecretHolder
/*    */ {
/* 25 */   private static final Logger _logger = LogManager.getLogger();
/* 26 */   private static final IQueryKey<IpcPasswordResult> LOOKUP_PASSWORD = (IQueryKey<IpcPasswordResult>)new QueryKey("IPC.LOOKUP_PASSWORD", IpcPasswordResult.class);
/*    */   
/* 28 */   private static final IQueryKey<Object[]> INSERT_PASSWORD = (IQueryKey<Object[]>)new QueryKey("IPC.INSERT_PASSWORD", Object[].class);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected String lookupPasswordDb() throws DbPasswordLookupException {
/* 34 */     _logger.traceEntry();
/*    */     try {
/* 36 */       String password = ((IpcPasswordResult)DataFactory.getObjectByQuery(LOOKUP_PASSWORD, null).get(0)).getPassword();
/* 37 */       _logger.traceExit();
/* 38 */       return password;
/*    */     }
/* 40 */     catch (ObjectNotFoundException ex) {
/* 41 */       throw (DbPasswordLookupException)_logger.throwing(DbPasswordLookupException.forNotFound(ex));
/*    */     }
/* 43 */     catch (Exception ex) {
/* 44 */       throw (DbPasswordLookupException)_logger.throwing(DbPasswordLookupException.forNoDatabase(ex));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected String newPassword() {
/* 50 */     _logger.traceEntry();
/* 51 */     String pwd = (new TotpSecretGenerator()).generateTotpKey();
/* 52 */     Map<String, Object> params = new HashMap<>();
/* 53 */     params.put("argPassword", pwd);
/* 54 */     params.put("argCreateDate", DateUtils.getNewDate());
/* 55 */     params.put("argCreateUserId", "SYSTEM");
/*    */ 
/*    */     
/* 58 */     DataFactory.getObjectByQuery(INSERT_PASSWORD, params);
/* 59 */     _logger.traceExit();
/* 60 */     return pwd;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\security\ipc\IpcSecretHolder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */