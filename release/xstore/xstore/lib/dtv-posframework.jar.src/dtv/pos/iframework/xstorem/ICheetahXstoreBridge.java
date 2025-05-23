package dtv.pos.iframework.xstorem;

import com.micros_retail.xm.cheetah.data.Screen;
import com.micros_retail.xm.cheetah.data.field.Field;
import dtv.pos.common.PromptKey;
import dtv.pos.framework.IHasFlowEventListener;
import dtv.pos.framework.op.req.AbstractFormRequest;
import dtv.pos.iframework.IModeController;
import dtv.pos.iframework.action.IXstAction;
import dtv.pos.iframework.event.IXstEvent;
import dtv.pos.iframework.op.IOpResponse;
import dtv.pos.iframework.ui.config.IDataFieldConfig;
import dtv.xst.dao.trl.ISaleReturnLineItem;
import java.util.Map;

public interface ICheetahXstoreBridge extends IHasFlowEventListener {
  boolean clientHasPinPad();
  
  Screen fireEventAndWaitForCompletedScreen(IXstEvent paramIXstEvent);
  
  boolean getAndResetServerInitiatedClientUpdateFlag();
  
  Map<String, IDataFieldConfig> getDataFieldConfigByFieldId();
  
  String getFieldResourceId(String paramString);
  
  Map<String, Field> getFieldsByFieldId();
  
  String getInstallationToken();
  
  Screen getScreen();
  
  Map<String, IXstEvent> getServerCachedEventsMap();
  
  Map<String, Object> getServerCachedObjectsMap();
  
  void notifyRequestReady(IOpResponse paramIOpResponse);
  
  String putField(Field paramField, String paramString);
  
  String putLineItemInServerCachedObjectsMap(Object paramObject);
  
  String putLineItemModifierInServerCachedObjectsMap(Object paramObject);
  
  String putListFieldValueInServerCachedObjectsMap(Object paramObject);
  
  String putMenuActionInServerCachedEventsMap(IXstAction paramIXstAction);
  
  String putPromptActionInServerCachedEventsMap(IXstEvent paramIXstEvent);
  
  String putSaleReturnLineItemInServerCachedObjectsMap(ISaleReturnLineItem paramISaleReturnLineItem);
  
  PromptKey retrieveCurrentPromptKey();
  
  AbstractFormRequest retrieveFormRequestForSimpleForm();
  
  Object[] retrieveListPromptLineItems();
  
  void setInstallationToken(String paramString);
  
  void setModeController(IModeController paramIModeController);
  
  void setServerInitiatedClientUpdateFlag();
  
  void storeCurrentPromptKey(PromptKey paramPromptKey);
  
  void storeFormRequestForSimpleForm(AbstractFormRequest paramAbstractFormRequest);
  
  void storeListPromptLineItems(Object[] paramArrayOfObject);
  
  void undoReset();
}


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframework\xstorem\ICheetahXstoreBridge.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */