/*    */ package dtv.pos.framework.ui.model;
/*    */ 
/*    */ import dtv.data2x.DataServiceUtils;
/*    */ import dtv.pos.iframework.ui.model.IUIInputModel;
/*    */ import dtv.util.ObjectUtils;
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
/*    */ 
/*    */ public abstract class AbstractUIInputModel
/*    */   extends AbstractUIModel
/*    */   implements IUIInputModel
/*    */ {
/* 24 */   private static final Logger logger_ = Logger.getLogger(AbstractUIInputModel.class);
/*    */ 
/*    */   
/*    */   protected Object userInput_;
/*    */ 
/*    */   
/*    */   public Object getUserInput() {
/* 31 */     if (logger_.isDebugEnabled()) {
/* 32 */       logger_.debug("Returning user input:\n\t[" + DataServiceUtils.toObscuredString(this.userInput_, true) + "].");
/*    */     }
/* 34 */     return this.userInput_;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setUserInput(Object argUserInput) {
/* 41 */     if (!ObjectUtils.equivalent(argUserInput, this.userInput_)) {
/* 42 */       this.userInput_ = argUserInput;
/* 43 */       this.events_.post(SET_USER_INPUT, argUserInput);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void clearModelImpl() {
/* 50 */     setUserInput((Object)null);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\model\AbstractUIInputModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */