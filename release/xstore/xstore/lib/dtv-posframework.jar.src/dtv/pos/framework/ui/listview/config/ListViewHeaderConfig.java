/*     */ package dtv.pos.framework.ui.listview.config;
/*     */ 
/*     */ import dtv.pos.common.ViewElementType;
/*     */ import dtv.pos.framework.ui.config.AbstractUIConfig;
/*     */ import dtv.pos.framework.ui.listview.DefaultViewElement;
/*     */ import dtv.pos.framework.ui.listview.IViewElement;
/*     */ import dtv.pos.iframework.action.IXstAction;
/*     */ import dtv.pos.iframework.ui.IViewElementType;
/*     */ import dtv.util.config.ClassConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ 
/*     */ 
/*     */ public class ListViewHeaderConfig
/*     */   extends AbstractUIConfig
/*     */   implements IListViewElementConfig
/*     */ {
/*     */   public static final String MAIN_TAG = "Header";
/*  32 */   private static final Logger logger_ = Logger.getLogger(ListViewHeaderConfig.class);
/*     */   
/*     */   private static final long serialVersionUID = 1L;
/*     */   private static final String TYPE_TAG = "Type";
/*     */   private static final String RENDERER_CLASS_TAG = "RendererClass";
/*  37 */   private final List<ListViewRowConfig> rows_ = new ArrayList<>();
/*     */   
/*     */   private IViewElementType type_;
/*     */   private ClassConfig<IViewElement> rendererClass_;
/*     */   IViewElement renderer_;
/*     */   
/*     */   public void clearRenderer() {
/*  44 */     this.renderer_ = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IXstAction getHiddenButtonAction() {
/*  50 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getIconKey() {
/*  56 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IViewElement getRenderer() {
/*  62 */     if (this.renderer_ == null) {
/*     */       try {
/*  64 */         this
/*  65 */           .renderer_ = (this.rendererClass_ == null) ? (IViewElement)new DefaultViewElement(true) : this.rendererClass_.getValue().newInstance();
/*     */       }
/*  67 */       catch (Throwable ex) {
/*  68 */         logger_.error("CAUGHT EXCEPTION", ex);
/*  69 */         this.renderer_ = (IViewElement)new DefaultViewElement(true);
/*     */       } finally {
/*     */         
/*  72 */         this.renderer_.setConfig(this);
/*     */       } 
/*     */     }
/*     */     
/*  76 */     return this.renderer_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ListViewRowConfig> getRows() {
/*  82 */     return this.rows_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IViewElementType getType() {
/*  88 */     return this.type_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  95 */     if ("Row".equalsIgnoreCase(argKey)) {
/*  96 */       this.rows_.add((ListViewRowConfig)argValue);
/*     */     }
/*  98 */     else if ("name".equalsIgnoreCase(argKey) || "Type".equalsIgnoreCase(argKey)) {
/*  99 */       this.type_ = ViewElementType.valueOf(argValue.toString());
/*     */     }
/* 101 */     else if ("RendererClass".equalsIgnoreCase(argKey)) {
/* 102 */       ClassConfig<?> value = ConfigUtils.toClassConfig(argValue);
/* 103 */       this.rendererClass_ = (ClassConfig)value;
/*     */     } else {
/*     */       
/* 106 */       super.setConfigObject(argKey, argValue);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\listview\config\ListViewHeaderConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */