/*    */ package dtv.pos.framework.op.req;
/*    */ 
/*    */ import com.micros.xstore.config.form.FormType;
/*    */ import dtv.pos.common.FormKey;
/*    */ import dtv.pos.framework.form.FormAssembler;
/*    */ import dtv.pos.framework.form.config.FormViewConfig;
/*    */ import dtv.pos.framework.form.config.FormViewConfigHelper;
/*    */ import dtv.pos.iframework.form.FormLocationType;
/*    */ import dtv.pos.iframework.op.req.IFormReqHandler;
/*    */ import javax.inject.Inject;
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
/*    */ 
/*    */ public abstract class AbstractFormReqHandler
/*    */   implements IFormReqHandler
/*    */ {
/*    */   @Inject
/*    */   protected FormViewConfigHelper _formConfigHelper;
/*    */   @Inject
/*    */   protected FormAssembler _formAssembler;
/*    */   
/*    */   public FormLocationType getFormLocationFromConfiguration(FormKey argFormKey) {
/* 35 */     FormLocationType locType = null;
/*    */     
/* 37 */     if (this._formConfigHelper.isFormConfigurationExist(argFormKey)) {
/* 38 */       FormViewConfig cfg = this._formConfigHelper.getFormViewConfig(argFormKey);
/* 39 */       locType = cfg.getFormLocation();
/*    */     } else {
/*    */       
/* 42 */       FormType formType = this._formAssembler.getFormConfiguration(argFormKey.toString());
/* 43 */       locType = this._formAssembler.getFormLocationType(formType.getType());
/*    */     } 
/*    */     
/* 46 */     return locType;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\req\AbstractFormReqHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */