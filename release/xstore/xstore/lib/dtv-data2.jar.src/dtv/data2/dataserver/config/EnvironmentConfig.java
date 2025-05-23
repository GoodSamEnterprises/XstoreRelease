/*    */ package dtv.data2.dataserver.config;
/*    */ 
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ public class EnvironmentConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private static final String INSTRUCTION_TAG = "Instruction";
/*    */   private static final String OPTIONS_TAG = "Options";
/* 27 */   private final Map<String, InstructionConfig> _instructionConfigMap = new HashMap<>();
/*    */   
/* 29 */   private final Map<String, OptionsConfig> _optionsConfigMap = new HashMap<>();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public InstructionConfig getInstructionConfig(String argName) {
/* 37 */     return this._instructionConfigMap.get(argName);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public OptionsConfig getOptionsConfig(String argName) {
/* 46 */     return this._optionsConfigMap.get(argName);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 52 */     if ("Instruction".equalsIgnoreCase(argKey) && argValue instanceof InstructionConfig) {
/* 53 */       InstructionConfig config = (InstructionConfig)argValue;
/* 54 */       this._instructionConfigMap.put(config.getName(), config);
/*    */     }
/* 56 */     else if ("Options".equalsIgnoreCase(argKey) && argValue instanceof OptionsConfig) {
/* 57 */       OptionsConfig config = (OptionsConfig)argValue;
/* 58 */       OptionsConfig replaced = this._optionsConfigMap.put(config.getName(), config);
/*    */       
/* 60 */       if (replaced != null)
/*    */       {
/*    */         
/* 63 */         config.cascadeValues((IConfigObject)replaced);
/*    */       }
/*    */     } 
/*    */     
/* 67 */     setClean();
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataserver\config\EnvironmentConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */