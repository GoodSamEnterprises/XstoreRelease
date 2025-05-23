/*    */ package dtv.pos.framework.op.req;
/*    */ 
/*    */ import dtv.pos.common.FormKey;
/*    */ import dtv.pos.iframework.action.DataActionGroupKey;
/*    */ import dtv.pos.iframework.action.FormTabKey;
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
/*    */ public class ChangeFormRequest
/*    */   extends AbstractFormRequest
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public ChangeFormRequest(FormKey formKey, boolean editable) {
/* 22 */     this(formKey, null, editable, null, null);
/*    */   }
/*    */   
/*    */   public ChangeFormRequest(FormKey formKey, DataActionGroupKey actionGroup) {
/* 26 */     this(formKey, null, (actionGroup == DataActionGroupKey.EDIT), actionGroup, null);
/*    */   }
/*    */   
/*    */   public ChangeFormRequest(FormKey formKey, IEditModel model, boolean editable) {
/* 30 */     this(formKey, model, editable, null, null);
/*    */   }
/*    */ 
/*    */   
/*    */   public ChangeFormRequest(FormKey formKey, IEditModel model, boolean editable, DataActionGroupKey actionGroup) {
/* 35 */     this(formKey, model, editable, actionGroup, null);
/*    */   }
/*    */ 
/*    */   
/*    */   public ChangeFormRequest(FormKey formKey, IEditModel model, boolean editable, DataActionGroupKey actionGroup, FormTabKey argTabKey) {
/* 40 */     super(formKey, model, editable, actionGroup, null, argTabKey);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getRequestType() {
/* 46 */     return OpRequestType.CHANGE_FORM.name();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\req\ChangeFormRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */