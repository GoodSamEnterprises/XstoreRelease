/*     */ package dtv.pos.framework.ui.view;
/*     */ 
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.ui.IXstViewComponent;
/*     */ import dtv.pos.ui.component.PosTransparentPanel;
/*     */ import dtv.ui.ComponentID;
/*     */ import dtv.ui.ComponentPropertySet;
/*     */ import dtv.ui.IComponent;
/*     */ import dtv.ui.IRenderer;
/*     */ import dtv.ui.context.ContextChangeEvent;
/*     */ import dtv.ui.context.DefaultContextChangeListener;
/*     */ import dtv.ui.context.IContextChangeListener;
/*     */ import dtv.ui.renderer.PaintRenderer;
/*     */ import dtv.ui.renderer.ShadowRenderer;
/*     */ import dtv.ui.swing.DtvPanel;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Graphics;
/*     */ import javax.inject.Inject;
/*     */ import javax.inject.Provider;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.JComponent;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PopupView
/*     */   implements IXstViewComponent, IContextChangeListener, IComponent
/*     */ {
/*  33 */   private static final Logger _logger = Logger.getLogger(PopupView.class);
/*  34 */   private static final IRenderer DEFAULT_BACKGROUND_RENDERER = (IRenderer)new PaintRenderer(Color.WHITE);
/*  35 */   private static final IRenderer DEFAULT_SHADOW_RENDERER = (IRenderer)new ShadowRenderer("WHITE");
/*     */   
/*     */   private final JComponent _panel;
/*     */   
/*     */   private IContextChangeListener _listener;
/*  40 */   private ComponentPropertySet _properties = new ComponentPropertySet();
/*  41 */   private ComponentID _id = DtvPanel.CONTEXT_PANEL_ID;
/*     */   
/*     */   @Inject
/*     */   private Provider<IModeController> _modeProvider;
/*     */   
/*     */   public PopupView() {
/*  47 */     InjectionHammer.forceAtInjectProcessing(this);
/*     */     
/*  49 */     this._panel = (JComponent)new PopupPanel();
/*  50 */     ((IModeController)this._modeProvider.get()).getContextManager().addContextChangeListener(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public JComponent getDisplayComponent() {
/*  55 */     return this._panel;
/*     */   }
/*     */ 
/*     */   
/*     */   public JComponent getFocusComponent() {
/*  60 */     return this._panel;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ComponentID getID() {
/*  66 */     return this._id;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ComponentPropertySet getPropertySet() {
/*  72 */     return this._properties;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handleContextChange(ContextChangeEvent argEvent) {
/*  78 */     if (this._listener == null) {
/*  79 */       this._listener = (IContextChangeListener)new DefaultContextChangeListener(this);
/*     */     }
/*     */     
/*  82 */     this._listener.handleContextChange(argEvent);
/*     */     
/*  84 */     if (_logger.isDebugEnabled()) {
/*  85 */       _logger.debug("Handling context change for tab pane [" + this + "]: " + argEvent);
/*     */     }
/*     */     
/*  88 */     this._panel.revalidate();
/*  89 */     this._panel.repaint();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public class PopupPanel
/*     */     extends PosTransparentPanel
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public PopupPanel() {
/* 110 */       setBorder(BorderFactory.createLineBorder(IXstViewComponent.UIRM.getRGBColor("_colorBorder")));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void paint(Graphics g) {
/* 116 */       paintBackground(g);
/* 117 */       paintShadows(g);
/* 118 */       super.paint(g);
/*     */     }
/*     */     
/*     */     public void paintBackground(Graphics g) {
/* 122 */       IRenderer renderer = IRenderer.getRendererForProperty(PopupView.this._properties, "background");
/*     */       
/* 124 */       if (renderer.equals(IRenderer.NULL_RENDERER)) {
/* 125 */         renderer = PopupView.DEFAULT_BACKGROUND_RENDERER;
/*     */       }
/*     */       
/* 128 */       renderer.paint(g, (Component)this, null, 0, 0, getWidth(), getHeight(), null);
/*     */     }
/*     */     
/*     */     protected void paintShadows(Graphics g) {
/* 132 */       IRenderer shadowRenderer = PopupView.this._properties.getRenderer("shadow");
/*     */       
/* 134 */       if (shadowRenderer.equals(IRenderer.NULL_RENDERER)) {
/* 135 */         shadowRenderer = PopupView.DEFAULT_SHADOW_RENDERER;
/*     */       }
/*     */       
/* 138 */       shadowRenderer.paint(g, (Component)this, null, 1, 1, getWidth(), getHeight(), null);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\view\PopupView.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */