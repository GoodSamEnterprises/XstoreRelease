/*    */ package dtv.pos.framework.worker;
/*    */ 
/*    */ import dtv.i18n.IFormattable;
/*    */ import dtv.pos.common.PromptKey;
/*    */ import dtv.pos.framework.op.OpState;
/*    */ import dtv.pos.framework.op.Operation;
/*    */ import dtv.pos.iframework.IBusyState;
/*    */ import dtv.pos.iframework.event.IXstEvent;
/*    */ import dtv.pos.iframework.op.IOpResponse;
/*    */ import dtv.pos.iframework.op.IOpState;
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
/*    */ import javax.inject.Inject;
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
/*    */ public class SimpleDoWorkOp
/*    */   extends Operation
/*    */   implements IWorkerOp
/*    */ {
/* 32 */   private static final Logger _logger = Logger.getLogger(SimpleDoWorkOp.class);
/* 33 */   private final IOpState SHOWING_PROMPT = (IOpState)new OpState("SHOWING_PROMPT");
/*    */   
/*    */   private List<IWorker> _workers;
/*    */   
/*    */   @Inject
/*    */   private IBusyState _busyState;
/*    */ 
/*    */   
/*    */   public IOpResponse handleOpExec(IXstEvent argEvent) {
/* 42 */     if (getOpState() == this.SHOWING_PROMPT) {
/* 43 */       return this.HELPER.silentErrorResponse();
/*    */     }
/*    */     
/* 46 */     return handleDoWork(argEvent);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setWorkers(List<IWorker> argWorker) {
/* 51 */     this._workers = new LinkedList<>(argWorker);
/*    */   }
/*    */   
/*    */   protected IOpResponse handleDoWork(IXstEvent argEvent) {
/* 55 */     if (this._workers == null) {
/* 56 */       _logger.warn(getClass().getName() + " is being run without any workers specified. This is probably a misconfiguration.::" + 
/*    */           
/* 58 */           getSourceDescription());
/* 59 */       return this.HELPER.completeResponse();
/*    */     } 
/*    */     
/* 62 */     for (Iterator<IWorker> iterator = this._workers.iterator(); iterator.hasNext(); ) {
/* 63 */       IWorker worker = iterator.next();
/*    */ 
/*    */ 
/*    */       
/* 67 */       boolean showBusyMessage = (worker.isLongRunning() && worker.isApplicable());
/*    */       
/* 69 */       if (showBusyMessage) {
/* 70 */         this._busyState.start(worker.getLongRunningMessage());
/*    */       }
/*    */       
/*    */       try {
/* 74 */         worker.performWork();
/*    */       }
/* 76 */       catch (WorkFailedException ex) {
/* 77 */         setOpState(this.SHOWING_PROMPT);
/* 78 */         return this.HELPER.getPromptResponse(PromptKey.valueOf("ERROR_WITH_INFO"), new IFormattable[] { ex.getMessageFormattable() });
/*    */       } 
/*    */       
/* 81 */       iterator.remove();
/*    */       
/* 83 */       if (showBusyMessage) {
/* 84 */         this._busyState.end();
/*    */       }
/*    */     } 
/*    */     
/* 88 */     return this.HELPER.completeResponse();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\worker\SimpleDoWorkOp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */