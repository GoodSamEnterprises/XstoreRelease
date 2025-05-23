/*    */ package dtv.data2.dataserver.config;
/*    */ 
/*    */ import dtv.data2.dataserver.CommandAction;
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
/*    */ public class CommandActionConfig
/*    */   extends AbstractActionConfig<CommandAction>
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public CommandActionConfig() {
/* 24 */     super(CommandAction.class);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getType() {
/* 30 */     return "Command";
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataserver\config\CommandActionConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */