/*    */ package dtv.data2.dataloader.fileprocessing;
/*    */ 
/*    */ import dtv.data2.dataloader.config.DataLoaderConfig;
/*    */ import dtv.data2.dataloader.config.DataLoaderConfigHelper;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.Comparator;
/*    */ import java.util.List;
/*    */ import java.util.StringTokenizer;
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
/*    */ public class ParsingUtils
/*    */ {
/* 22 */   private static final ParsingUtils INSTANCE = new ParsingUtils();
/*    */   
/*    */   public static ParsingUtils getInstance() {
/* 25 */     return INSTANCE;
/*    */   }
/*    */   
/* 28 */   private final List<String> _actionTypesByLength = new ArrayList<>(DataLoaderConfig._actionTypes);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ParsingUtils() {
/* 34 */     Collections.sort(this._actionTypesByLength, new Comparator<String>()
/*    */         {
/*    */           public int compare(String argObj1, String argObj2)
/*    */           {
/* 38 */             return argObj2.length() - argObj1.length();
/*    */           }
/*    */         });
/*    */   }
/*    */ 
/*    */   
/*    */   public String determineDelimiter(String argFileLine) throws IllegalArgumentException {
/* 45 */     for (String actionType : this._actionTypesByLength) {
/* 46 */       if (argFileLine.startsWith(actionType)) {
/* 47 */         return String.valueOf(argFileLine.charAt(actionType.length()));
/*    */       }
/*    */     } 
/*    */     
/* 51 */     throw new IllegalArgumentException("Couldn't determine delimiter");
/*    */   }
/*    */ 
/*    */   
/*    */   public Instruction parseInstruction(String argLine) throws IllegalArgumentException {
/* 56 */     String delimiter = determineDelimiter(argLine);
/* 57 */     StringTokenizer tokens = new StringTokenizer(argLine, delimiter, false);
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 62 */     String action = tokens.nextToken();
/*    */ 
/*    */     
/* 65 */     String recordType = DataLoaderConfig.isRunSql(action) ? action : tokens.nextToken();
/*    */     
/* 67 */     if (!DataLoaderConfigHelper.getDataLoaderConfig().isValidActionType(action)) {
/* 68 */       String msg = "Unknown action: [" + action + "]";
/* 69 */       throw new IllegalArgumentException(msg);
/*    */     } 
/*    */     
/* 72 */     if (!DataLoaderConfigHelper.getDataLoaderConfig().isValidRecordType(recordType)) {
/* 73 */       String msg = "Unknown record type: [" + recordType + "]";
/* 74 */       throw new IllegalArgumentException(msg);
/*    */     } 
/*    */     
/* 77 */     return new Instruction(action, recordType);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public class Instruction
/*    */   {
/*    */     public final String action;
/*    */ 
/*    */     
/*    */     public final String recordType;
/*    */ 
/*    */ 
/*    */     
/*    */     public Instruction(String argAction, String argRecordType) {
/* 93 */       this.action = argAction;
/* 94 */       this.recordType = argRecordType;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\fileprocessing\ParsingUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */