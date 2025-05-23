/*    */ package dtv.pos.framework.keycommands;
/*    */ 
/*    */ import dtv.pos.iframework.IModeController;
/*    */ import javax.inject.Inject;
/*    */ import javax.inject.Provider;
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
/*    */ public class OpChainDebugger
/*    */   implements IKeyCommand
/*    */ {
/* 22 */   private static final Logger logger = Logger.getLogger(OpChainDebugger.class);
/*    */   
/*    */   @Inject
/*    */   private Provider<IModeController> _modeProvider;
/*    */ 
/*    */   
/*    */   public void execute() {
/* 29 */     if (logger.isInfoEnabled()) {
/* 30 */       logger.info(execute(new StringBuffer(1024)));
/*    */     }
/*    */   }
/*    */   
/*    */   public StringBuffer execute(StringBuffer sbuff) {
/* 35 */     StringBuilder sb = new StringBuilder();
/*    */     
/*    */     try {
/* 38 */       ((IModeController)this._modeProvider.get()).getDebugInfo(sb);
/*    */     }
/* 40 */     catch (Exception ex) {
/* 41 */       logger.error("CAUGHT EXCEPTION", ex);
/*    */     } 
/*    */     
/* 44 */     return sbuff.append(sb);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getCommand() {
/* 49 */     return "opchain";
/*    */   }
/*    */ 
/*    */   
/*    */   public String getHelpText() {
/* 54 */     return "displays information about the current op chain processor";
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\keycommands\OpChainDebugger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */