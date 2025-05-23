/*     */ package dtv.pos.framework.ui.model;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.i18n.config.IFormattableConfig;
/*     */ import dtv.pos.framework.ui.config.IconGroupConfig;
/*     */ import dtv.pos.framework.ui.config.ViewComponentConfig;
/*     */ import dtv.pos.framework.ui.context.ComponentPropertySetConfig;
/*     */ import dtv.pos.framework.ui.context.ComponentPropertySetConfigHelper;
/*     */ import dtv.pos.iframework.ui.config.IViewComponentConfig;
/*     */ import dtv.ui.ComponentID;
/*     */ import dtv.ui.ComponentPropertySet;
/*     */ import dtv.ui.StringObjectPair;
/*     */ import dtv.ui.context.Context;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.inject.Inject;
/*     */ import javax.swing.ImageIcon;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InfoMetaDataManager
/*     */ {
/*  34 */   public static final ComponentID MESSAGE_AREA_TABS_ID = new ComponentID("MessageAreaTabs");
/*     */   
/*  36 */   private static final Logger _logger = Logger.getLogger(InfoMetaDataManager.class);
/*     */   
/*     */   private Set<String> _tabSets;
/*  39 */   private Map<String, List<InfoMetaData>> _tabSetMetaData = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private ComponentPropertySetConfigHelper _propertySetHelper;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InfoMetaDataManager(Set<String> argTabSets) {
/*  51 */     this._tabSets = argTabSets;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<InfoMetaData> getMetaDataList(Context argContext) {
/*  59 */     ComponentPropertySet tabSetProps = argContext.getPropertySet(MESSAGE_AREA_TABS_ID);
/*  60 */     return getMetaDataList(tabSetProps.getName());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<InfoMetaData> getMetaDataList(String argTabSetName) {
/*  69 */     List<InfoMetaData> metaData = this._tabSetMetaData.get(argTabSetName);
/*  70 */     return metaData;
/*     */   }
/*     */   
/*     */   public void init() {
/*  74 */     for (String tabSetName : this._tabSets) {
/*     */       
/*  76 */       ComponentPropertySet propSet = this._propertySetHelper.getComponentPropertySetConfig(tabSetName).getPropertySet();
/*  77 */       StringObjectPair[] properties = propSet.getAll();
/*  78 */       Arrays.sort((Object[])properties);
/*  79 */       List<InfoMetaData> mdList = new ArrayList<>();
/*     */       
/*  81 */       for (StringObjectPair tab : properties) {
/*  82 */         String tabId = tab.getValue().toString();
/*  83 */         InfoMetaData metaData = getMetaData(tabId);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  88 */         if (metaData != null) {
/*  89 */           mdList.add(metaData);
/*     */         } else {
/*     */           
/*  92 */           _logger.debug("The tab [" + tabId + "] is configured in the tab set [" + tabSetName + "] but the tab definition was not found on the current config path.");
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/*  97 */       this._tabSetMetaData.put(tabSetName, mdList);
/*     */     } 
/*     */   }
/*     */   
/*     */   private InfoMetaData getMetaData(String argTabId) {
/* 102 */     ComponentPropertySetConfig tabConfig = this._propertySetHelper.getComponentPropertySetConfig(argTabId);
/*     */     
/* 104 */     if (tabConfig != null) {
/* 105 */       ComponentPropertySet tabDef = tabConfig.getPropertySet();
/* 106 */       ViewComponentConfig<?> componentConfig = (ViewComponentConfig)tabDef.get("tab");
/* 107 */       IFormattable title = ((IFormattableConfig)tabDef.get("tabTitle")).getFormattable();
/* 108 */       IconGroupConfig iconConfig = (IconGroupConfig)tabDef.get("tabIcon");
/* 109 */       InfoMetaData metaData = new InfoMetaData(argTabId, title, iconConfig.getIcon(), (IViewComponentConfig)componentConfig);
/* 110 */       return metaData;
/*     */     } 
/*     */     
/* 113 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public class InfoMetaData
/*     */   {
/*     */     private String _id;
/*     */     private IFormattable _title;
/*     */     private ImageIcon _icon;
/*     */     private IViewComponentConfig<?> _componentConfig;
/*     */     
/*     */     private InfoMetaData(String argId, IFormattable argTitle, ImageIcon argIcon, IViewComponentConfig<?> argComponentConfig) {
/* 125 */       this._id = argId;
/* 126 */       this._componentConfig = argComponentConfig;
/* 127 */       this._title = argTitle;
/* 128 */       this._icon = argIcon;
/*     */     }
/*     */     
/*     */     public IViewComponentConfig<?> getComponentConfig() {
/* 132 */       return this._componentConfig;
/*     */     }
/*     */     
/*     */     public ImageIcon getIcon() {
/* 136 */       return this._icon;
/*     */     }
/*     */     
/*     */     public String getIconKey() {
/* 140 */       return this._icon.getDescription();
/*     */     }
/*     */     
/*     */     public String getInfoId() {
/* 144 */       return this._id;
/*     */     }
/*     */     
/*     */     public IFormattable getTitle() {
/* 148 */       return this._title;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\model\InfoMetaDataManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */