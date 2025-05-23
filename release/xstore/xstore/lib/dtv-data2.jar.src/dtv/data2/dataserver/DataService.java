/*    */ package dtv.data2.dataserver;
/*    */ 
/*    */ import dtv.ipc.server.IIpcService;
/*    */ import dtv.ipc.server.IpcRequest;
/*    */ import java.util.Collections;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import org.apache.log4j.Logger;
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
/*    */ public class DataService
/*    */   extends InstructionProcessor
/*    */   implements IIpcService
/*    */ {
/* 25 */   private static final Logger _logger = Logger.getLogger(DataService.class);
/*    */   
/*    */   private static final Map<String, String> INSTR_MAP;
/*    */   
/*    */   static {
/* 30 */     Map<String, String> map = new HashMap<>();
/* 31 */     map.put("backup", "BACKUP");
/* 32 */     map.put("restore", "RESTORE");
/* 33 */     map.put("replaceTrainingId", "REPLACE_TRAINING_ID");
/* 34 */     map.put("testConnectionActive", "TEST_CONNECTION_ACTIVE");
/* 35 */     INSTR_MAP = Collections.unmodifiableMap(map);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Map<String, String> invoke(IpcRequest argRequest) {
/* 41 */     String methodName = argRequest.getMethod();
/* 42 */     String mapped = INSTR_MAP.get(methodName);
/*    */     
/* 44 */     if (mapped != null) {
/* 45 */       methodName = mapped;
/*    */     }
/*    */     
/* 48 */     _logger.info("***** START: DataService: Instruction [" + methodName + "]");
/*    */     
/* 50 */     Map<String, String> results = processInstruction(methodName, argRequest.getParams());
/* 51 */     _logger.info("***** END: DataService: Instruction [" + methodName + "]");
/* 52 */     return results;
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataserver\DataService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */