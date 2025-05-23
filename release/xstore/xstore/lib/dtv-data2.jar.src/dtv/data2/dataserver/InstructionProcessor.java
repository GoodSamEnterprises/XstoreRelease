/*     */ package dtv.data2.dataserver;
/*     */ 
/*     */ import dtv.data2.SQLExceptionScrubber;
/*     */ import dtv.data2.dataserver.config.ConfigHelper;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InstructionProcessor
/*     */ {
/*     */   public static final String RESPONSE_TEXT_KEY = "responseText";
/*     */   public static final String PROCESSING_TIME_KEY = "processingTime";
/*     */   public static final String SUCCESSFUL_KEY = "successful";
/*     */   public static final String RESPONSE_TEXT_SUCCESS = "OK";
/*  26 */   private static String DIRECT_REPLACE_PREFIX = "$arg";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Map<String, String> getDirectReplaceFormattedParams(Map<String, String> argParams) {
/*  34 */     Map<String, String> formattedParams = new HashMap<>();
/*  35 */     if (argParams == null) {
/*  36 */       return formattedParams;
/*     */     }
/*  38 */     for (String key : argParams.keySet()) {
/*     */       
/*  40 */       String formattedKey = key.startsWith(DIRECT_REPLACE_PREFIX) ? key : (DIRECT_REPLACE_PREFIX + StringUtils.ensureFirstUpperCase(key));
/*     */       
/*  42 */       if (argParams.containsKey(key)) {
/*  43 */         formattedParams.put(formattedKey, argParams.get(key));
/*     */       }
/*     */     } 
/*     */     
/*  47 */     return formattedParams;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, String> processInstruction(String argInstructionKey, Map<String, String> argParameters) {
/*  58 */     Map<String, String> results = new HashMap<>();
/*  59 */     long totalProcessingTime = 0L;
/*     */     
/*     */     try {
/*  62 */       List<IDataServerAction> actions = ConfigHelper.getInstance().getActions(argInstructionKey);
/*  63 */       Collections.sort(actions);
/*     */       
/*  65 */       for (IDataServerAction action : actions) {
/*  66 */         ActionResult result = action.process(argParameters);
/*  67 */         totalProcessingTime += result.getProcessingTime();
/*     */         
/*  69 */         if (!result.isSuccess())
/*     */         {
/*     */           
/*  72 */           throw result.getRootError();
/*     */         }
/*     */       }
/*     */     
/*  76 */     } catch (Throwable th) {
/*  77 */       results.put("successful", Boolean.FALSE.toString());
/*     */ 
/*     */       
/*  80 */       results.put("responseText", SQLExceptionScrubber.scrub(th.toString()));
/*  81 */       results.put("processingTime", String.valueOf(totalProcessingTime));
/*  82 */       return results;
/*     */     } 
/*     */     
/*  85 */     results.put("successful", Boolean.TRUE.toString());
/*  86 */     results.put("responseText", "OK");
/*  87 */     results.put("processingTime", String.valueOf(totalProcessingTime));
/*     */     
/*  89 */     return results;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, String> processInstruction(String argInstructionType, Map<String, String> argParameters, Map<String, String> argDirectReplaceParams) {
/* 103 */     Map<String, String> params = new HashMap<>();
/* 104 */     params.putAll(argParameters);
/* 105 */     params.putAll(getDirectReplaceFormattedParams(argDirectReplaceParams));
/*     */     
/* 107 */     return processInstruction(argInstructionType, params);
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataserver\InstructionProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */