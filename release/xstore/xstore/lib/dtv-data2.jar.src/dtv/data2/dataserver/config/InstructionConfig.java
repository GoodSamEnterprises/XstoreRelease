/*    */ package dtv.data2.dataserver.config;
/*    */ 
/*    */ import dtv.data2.dataserver.IDataServerAction;
/*    */ import dtv.util.config.AbstractParentConfig;
/*    */ import dtv.util.config.IConfigObject;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.apache.commons.lang3.builder.EqualsBuilder;
/*    */ import org.apache.commons.lang3.builder.HashCodeBuilder;
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
/*    */ public class InstructionConfig
/*    */   extends AbstractParentConfig
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private static final String NAME_TAG = "Name";
/* 29 */   private final List<IActionConfig> _actionConfigs = new ArrayList<>();
/* 30 */   private String _name = null;
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean equals(Object argObj) {
/* 35 */     if (argObj == this) {
/* 36 */       return true;
/*    */     }
/*    */     
/* 39 */     if (!(argObj instanceof InstructionConfig)) {
/* 40 */       return false;
/*    */     }
/*    */     
/* 43 */     InstructionConfig other = (InstructionConfig)argObj;
/* 44 */     return (new EqualsBuilder()).append(this._actionConfigs, other._actionConfigs).appendSuper(super.equals(argObj))
/* 45 */       .isEquals();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<IDataServerAction> getActions() throws Exception {
/* 55 */     List<IDataServerAction> actions = new ArrayList<>();
/*    */     
/* 57 */     for (IActionConfig actionConfig : this._actionConfigs) {
/* 58 */       actions.add(actionConfig.getAction());
/*    */     }
/*    */     
/* 61 */     return actions;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 69 */     return this._name;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 75 */     return (new HashCodeBuilder(17, 37)).append(this._actionConfigs).appendSuper(super.hashCode()).toHashCode();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 81 */     if ("Name".equalsIgnoreCase(argKey)) {
/* 82 */       this._name = argValue.toString();
/*    */     }
/* 84 */     else if (argValue instanceof IActionConfig) {
/* 85 */       IActionConfig actionConfig = (IActionConfig)argValue;
/* 86 */       this._actionConfigs.add(actionConfig);
/*    */     } 
/*    */     
/* 89 */     setClean();
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataserver\config\InstructionConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */