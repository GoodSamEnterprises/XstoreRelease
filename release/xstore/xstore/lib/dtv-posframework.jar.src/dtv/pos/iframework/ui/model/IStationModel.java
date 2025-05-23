/*    */ package dtv.pos.iframework.ui.model;
/*    */ 
/*    */ import dtv.event.EventEnum;
/*    */ import dtv.event.IEventSource;
/*    */ import dtv.pos.common.FormKey;
/*    */ import dtv.pos.framework.ApplicationData;
/*    */ import dtv.pos.iframework.IModel;
/*    */ import dtv.pos.iframework.action.IXstAction;
/*    */ import dtv.pos.iframework.form.IEditModel;
/*    */ import dtv.pos.iframework.form.IListEditModel;
/*    */ import dtv.pos.iframework.type.ModelKey;
/*    */ import dtv.ui.model.ICombinedListModel;
/*    */ import java.util.Collection;
/*    */ import javax.swing.JFormattedTextField;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface IStationModel
/*    */   extends IModel, IEventSource
/*    */ {
/*    */   public static final String FORM_SET = "FORM_SET";
/* 39 */   public static final EventEnum SET_MENU_MODEL = new EventEnum("setMenuModel");
/* 40 */   public static final EventEnum SET_TEXT_PROMPT_MODEL = new EventEnum("setTextPromptModel");
/* 41 */   public static final EventEnum SET_LONG_TEXT_PROMPT_MODEL = new EventEnum("setLongTextPromptModel");
/* 42 */   public static final EventEnum SET_LIST_PROMPT_MODEL = new EventEnum("setListPromptModel");
/* 43 */   public static final EventEnum SET_NOTIFY_PROMPT_MODEL = new EventEnum("setNotifyPromptModel");
/* 44 */   public static final EventEnum SET_PROMPT_ACTION_MODEL = new EventEnum("setPromptActionModel");
/* 45 */   public static final EventEnum SET_CURRENT_LIST_MODEL = new EventEnum("setCurrentListModel");
/* 46 */   public static final EventEnum SET_LIST_MODEL = new EventEnum("setListModel");
/* 47 */   public static final EventEnum SET_PRIMARY_FORM_MODEL_KEY = new EventEnum("setPfMk");
/* 48 */   public static final EventEnum SET_HELP_MODEL = new EventEnum("setHelpModel");
/* 49 */   public static final EventEnum SET_MESSAGE_MODEL = new EventEnum("setMessageModel");
/*    */   
/*    */   void clearModel();
/*    */   
/*    */   String getActiveFormKey();
/*    */   
/*    */   String getActivePromptKey();
/*    */   
/*    */   Collection<IXstAction> getAppChangeActions();
/*    */   
/*    */   String getApplicationKey();
/*    */   
/*    */   ICombinedListModel<Object> getCurrentListModel();
/*    */   
/*    */   ModelKey<? extends IListEditModel<Object>> getCurrentListModelKey();
/*    */   
/*    */   IEditModel getEditModel(FormKey paramFormKey);
/*    */   
/*    */   Collection<IXstAction> getFormActions(FormKey paramFormKey);
/*    */   
/*    */   IFormModel getFormModel(FormKey paramFormKey);
/*    */   
/*    */   IHelpModel getHelpModel();
/*    */   
/*    */   ICombinedListModel<?> getListModel(String paramString);
/*    */   
/*    */   IListPromptModel<?> getListPromptModel();
/*    */   
/*    */   ITextPromptModel getLongTextPromptModel();
/*    */   
/*    */   IMenuModel getMenuModel();
/*    */   
/*    */   IMessageModel getMessageModel();
/*    */   
/*    */   <M extends IListEditModel<Object>> M getModel(ModelKey<M> paramModelKey);
/*    */   
/*    */   <M extends IListEditModel<Object>> M getModel(ModelKey<M> paramModelKey, boolean paramBoolean);
/*    */   
/*    */   INotifyPromptModel getNotifyPromptModel();
/*    */   
/*    */   FormKey getPrimaryFormModelKey();
/*    */   
/*    */   IPromptActionModel getPromptActionModel();
/*    */   
/*    */   JFormattedTextField.AbstractFormatter getTextFormatter();
/*    */   
/*    */   ITextPromptModel getTextPromptModel();
/*    */   
/*    */   void initialize(ApplicationData paramApplicationData);
/*    */   
/*    */   void setActiveFormKey(String paramString);
/*    */   
/*    */   void setActivePromptKey(String paramString);
/*    */   
/*    */   void setCurrentListModel(ModelKey<? extends IListEditModel<Object>> paramModelKey);
/*    */   
/*    */   void setHelpModel(IHelpModel paramIHelpModel);
/*    */   
/*    */   <M extends IListEditModel<Object>> void setListModel(ModelKey<M> paramModelKey, M paramM);
/*    */   
/*    */   void setListPromptModel(IListPromptModel<?> paramIListPromptModel);
/*    */   
/*    */   void setLongTextPromptModel(ITextPromptModel paramITextPromptModel);
/*    */   
/*    */   void setMenuModel(IMenuModel paramIMenuModel);
/*    */   
/*    */   void setMessageModel(IMessageModel paramIMessageModel);
/*    */   
/*    */   void setNotifyPromptModel(INotifyPromptModel paramINotifyPromptModel);
/*    */   
/*    */   void setPrimaryFormModelKey(FormKey paramFormKey);
/*    */   
/*    */   void setPromptActionModel(IPromptActionModel paramIPromptActionModel);
/*    */   
/*    */   void setTextPromptModel(ITextPromptModel paramITextPromptModel);
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\model\IStationModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */