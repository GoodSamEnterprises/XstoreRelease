/*    */ package dtv.pos.framework.op.req;
/*    */ 
/*    */ import dtv.pos.common.FormKey;
/*    */ import dtv.pos.iframework.action.DataActionGroupKey;
/*    */ import dtv.pos.iframework.action.FormTabKey;
/*    */ import dtv.pos.iframework.form.FormLocationType;
/*    */ import dtv.pos.iframework.form.IEditModel;
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
/*    */ public class ShowFormRequest
/*    */   extends AbstractFormRequest
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public ShowFormRequest(FormKey argFormKey, IEditModel argEditModel) {
/* 28 */     super(argFormKey, argEditModel, true, null, null, null);
/*    */   }
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
/*    */   public ShowFormRequest(FormKey argFormKey, IEditModel argModel, DataActionGroupKey actionGroup, boolean editable, FormLocationType argFormType) {
/* 43 */     super(argFormKey, argModel, editable, actionGroup, argFormType, null);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ShowFormRequest(FormKey argFormKey, IEditModel argModel, DataActionGroupKey actionGroup, boolean editable, FormLocationType argFormType, FormTabKey argTabKey) {
/* 49 */     super(argFormKey, argModel, editable, actionGroup, argFormType, argTabKey);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getRequestType() {
/* 55 */     return OpRequestType.SHOW_FORM.name();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\req\ShowFormRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */