/*    */ package dtv.pos.framework.ui.menu;
/*    */ 
/*    */ import dtv.pos.framework.ModeController;
/*    */ import dtv.pos.framework.StationController;
/*    */ import dtv.pos.framework.action.IXstActionFactory;
/*    */ import dtv.pos.iframework.IModeController;
/*    */ import dtv.pos.iframework.ui.model.IStationModel;
/*    */ import dtv.util.config.reload.NamedXmlConfigReloader;
/*    */ import java.lang.reflect.Field;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.List;
/*    */ import java.util.Map;
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
/*    */ public class MenuConfigReloader
/*    */   extends NamedXmlConfigReloader
/*    */ {
/* 31 */   private static final Logger _logger = Logger.getLogger(MenuConfigReloader.class);
/*    */ 
/*    */   
/*    */   @Inject
/*    */   private IMenuFactory _menuFactory;
/*    */   
/*    */   @Inject
/*    */   private IXstActionFactory _actionFactory;
/*    */   
/*    */   @Inject
/*    */   private Provider<IModeController> _modeProvider;
/*    */ 
/*    */   
/*    */   protected String getConfigName() {
/* 45 */     throw new UnsupportedOperationException();
/*    */   }
/*    */ 
/*    */   
/*    */   protected List<String> getConfigNames() {
/* 50 */     List<String> result = new ArrayList<>(2);
/* 51 */     result.add("MenuConfig");
/* 52 */     result.add("ActionConfig");
/* 53 */     return result;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected List<ModeController> getModeControllers() {
/* 62 */     ArrayList<ModeController> result = new ArrayList<>();
/*    */     try {
/* 64 */       Field instanceMapField = StationController.class.getDeclaredField("_modeControllerMap");
/* 65 */       instanceMapField.setAccessible(true);
/* 66 */       Map<?, ?> instanceMap = (Map<?, ?>)instanceMapField.get((Object)null);
/*    */       
/* 68 */       Collection<?> values = instanceMap.values();
/* 69 */       result.ensureCapacity(values.size());
/* 70 */       for (Object o : values) {
/* 71 */         result.add((ModeController)o);
/*    */       }
/*    */     }
/* 74 */     catch (Exception ex) {
/* 75 */       _logger.error("CAUGHT EXCEPTION", ex);
/*    */     } 
/* 77 */     return result;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void reloadConfig() {
/* 86 */     IModeController currentStationController = (IModeController)this._modeProvider.get();
/*    */     
/* 88 */     for (ModeController modeController : getModeControllers()) {
/* 89 */       this._actionFactory.init();
/* 90 */       this._menuFactory.init();
/* 91 */       IStationModel stationModel = modeController.getStationModel();
/* 92 */       stationModel.getMenuModel().refreshMenu();
/* 93 */       stationModel.setMenuModel(stationModel.getMenuModel());
/*    */     } 
/*    */     
/* 96 */     StationController.setCurrentMode(currentStationController.getModeData());
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\menu\MenuConfigReloader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */