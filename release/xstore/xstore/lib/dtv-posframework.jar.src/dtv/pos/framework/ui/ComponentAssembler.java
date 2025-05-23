/*     */ package dtv.pos.framework.ui;
/*     */ 
/*     */ import dtv.i18n.OutputContextType;
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.pos.framework.ui.component.ISubstitutedComponent;
/*     */ import dtv.pos.framework.ui.component.IXstViewComponentFactory;
/*     */ import dtv.pos.framework.ui.component.SecondaryComponentRegistry;
/*     */ import dtv.pos.framework.ui.component.XstViewComponentFactory;
/*     */ import dtv.pos.framework.ui.config.IRootComponentConfig;
/*     */ import dtv.pos.framework.ui.config.ViewComponentConfig;
/*     */ import dtv.pos.iframework.ui.IComponentRegistry;
/*     */ import dtv.pos.iframework.ui.config.IViewComponentConfig;
/*     */ import dtv.pos.ui.component.ISecondaryComponent;
/*     */ import dtv.ui.swing.DtvTabbedPane;
/*     */ import dtv.util.CompositeObject;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JLayeredPane;
/*     */ import javax.swing.JTabbedPane;
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
/*     */ 
/*     */ public class ComponentAssembler
/*     */   implements IComponentAssembler
/*     */ {
/*  36 */   private static final Logger logger_ = Logger.getLogger(ComponentAssembler.class);
/*     */ 
/*     */ 
/*     */   
/*     */   private static IComponentAssembler INSTANCE;
/*     */ 
/*     */ 
/*     */   
/*     */   public static IComponentAssembler getInstance() {
/*  45 */     if (INSTANCE == null) {
/*  46 */       INSTANCE = new ComponentAssembler();
/*     */     }
/*  48 */     return INSTANCE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent assemble(IRootComponentConfig argRoot) {
/*  59 */     return assemble(argRoot, (IComponentRegistry)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent assemble(IRootComponentConfig argRoot, IComponentRegistry argRegistry) {
/*     */     try {
/*  73 */       return (JComponent)assembleImpl(argRoot.getMainComponent(), argRegistry).a();
/*     */     }
/*  75 */     catch (Exception ex) {
/*  76 */       logger_.error("Exception assembling component from config", ex);
/*  77 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public JComponent assemble(IViewComponentConfig argComponent, IComponentRegistry argRegistry) {
/*     */     try {
/*  85 */       return (JComponent)assembleImpl(argComponent, argRegistry).a();
/*     */     }
/*  87 */     catch (Exception ex) {
/*  88 */       logger_.error("Exception assembling component from config", ex);
/*  89 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected CompositeObject.TwoPiece<JComponent, ViewComponentConfig> assembleImpl(IViewComponentConfig argConfig, IComponentRegistry argRegistry) {
/*  96 */     IViewComponentConfig config = argConfig;
/*  97 */     IXstViewComponentFactory viewFactory = XstViewComponentFactory.getInstance();
/*  98 */     JComponent component = viewFactory.createComponent(config, false);
/*     */ 
/*     */     
/* 101 */     if (component instanceof ISubstitutedComponent) {
/* 102 */       config = ((ISubstitutedComponent)component).getNewConfig();
/* 103 */       component = viewFactory.createComponent(config, false);
/*     */     } 
/*     */ 
/*     */     
/* 107 */     if (argRegistry != null && !StringUtils.isEmpty(component.getName())) {
/* 108 */       argRegistry.registerNamedComponent(component, component.getName());
/*     */     }
/*     */ 
/*     */     
/* 112 */     if (component instanceof ISecondaryComponent) {
/* 113 */       SecondaryComponentRegistry.register((ISecondaryComponent)component);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 118 */     if (config.getChildren() != null) {
/* 119 */       Collection children = config.getChildren();
/*     */       
/* 121 */       for (Iterator<ViewComponentConfig> iter = children.iterator(); iter.hasNext(); ) {
/* 122 */         ViewComponentConfig cfg = iter.next();
/* 123 */         CompositeObject.TwoPiece<JComponent, ViewComponentConfig> sub = assembleImpl((IViewComponentConfig)cfg, argRegistry);
/* 124 */         JComponent child = (JComponent)sub.a();
/* 125 */         cfg = (ViewComponentConfig)sub.b();
/*     */         
/* 127 */         if (child != null) {
/* 128 */           String location = cfg.getLayoutLocation();
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 133 */           if (cfg.getLayoutLayer() != null && component instanceof JLayeredPane) {
/* 134 */             ((JLayeredPane)component).setLayer(child, cfg.getLayoutLayer().intValue());
/*     */           }
/*     */ 
/*     */           
/* 138 */           if (location != null) {
/* 139 */             component.add(child, location); continue;
/*     */           } 
/* 141 */           if (cfg.getIconGroupConfig().getIconConfig() != null) {
/* 142 */             component.add(child, cfg.getIconGroupConfig().getIcon());
/* 143 */             if (component instanceof JTabbedPane && cfg.getTitle() != null) {
/* 144 */               int tabIndex = ((JTabbedPane)component).getTabCount() - 1;
/* 145 */               String title = cfg.getTitle().toString(OutputContextType.VIEW);
/*     */               
/* 147 */               if (ConfigurationMgr.isTextAllCapsOnTabHeaders() && title != null) {
/* 148 */                 title = title.toUpperCase();
/*     */               }
/*     */               
/* 151 */               ((JTabbedPane)component).setTitleAt(tabIndex, title);
/*     */             } 
/*     */             
/* 154 */             if (component instanceof DtvTabbedPane) {
/* 155 */               int tabIndex = ((DtvTabbedPane)component).getTabCount() - 1;
/*     */               
/* 157 */               ((DtvTabbedPane)component).setScaleConfig(tabIndex, cfg.getIconGroupConfig().getScaleConfig());
/*     */             } 
/*     */             continue;
/*     */           } 
/* 161 */           component.add(child);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 169 */     return CompositeObject.make(component, config);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\ComponentAssembler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */