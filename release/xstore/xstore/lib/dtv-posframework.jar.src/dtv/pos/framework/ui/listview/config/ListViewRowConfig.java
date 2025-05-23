/*     */ package dtv.pos.framework.ui.listview.config;
/*     */ 
/*     */ import dtv.pos.framework.security.SecurityUtil;
/*     */ import dtv.pos.framework.ui.config.AbstractUIConfig;
/*     */ import dtv.pos.iframework.security.AccessType;
/*     */ import dtv.pos.iframework.security.ISecuredObjectID;
/*     */ import dtv.pos.iframework.security.SecuredObjectID;
/*     */ import dtv.pos.iframework.security.StationState;
/*     */ import dtv.ui.IViewRowRenderer;
/*     */ import dtv.util.config.ClassConfig;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.inject.Inject;
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
/*     */ public class ListViewRowConfig
/*     */   extends AbstractUIConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public static final String MAIN_TAG = "Row";
/*     */   private static final String RENDERER_CLASS_TAG = "RendererClass";
/*     */   private static final String ACL_TAG = "SecuredObject";
/*  35 */   private static final Logger logger_ = Logger.getLogger(ListViewRowConfig.class);
/*     */   
/*  37 */   private final List<ListViewColumnConfig> columns_ = new ArrayList<>();
/*     */   
/*     */   private IViewRowRenderer renderer_;
/*     */   private ClassConfig<? extends IViewRowRenderer> rendererClass_;
/*  41 */   private final List<SecuredObjectID> securedObjectIds_ = new ArrayList<>();
/*     */   
/*     */   @Inject
/*     */   private SecurityUtil _securityUtil;
/*     */   
/*     */   @Inject
/*     */   private StationState _stationState;
/*     */ 
/*     */   
/*     */   public ListViewRowConfig() {
/*  51 */     InjectionHammer.forceAtInjectProcessing(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ListViewColumnConfig> getColumns() {
/*  59 */     return this.columns_;
/*     */   }
/*     */   
/*     */   public IViewRowRenderer getRenderer() {
/*  63 */     if (this.renderer_ == null && this.rendererClass_ != null) {
/*     */       try {
/*  65 */         this.renderer_ = this.rendererClass_.getValue().newInstance();
/*     */       }
/*  67 */       catch (Exception ex) {
/*  68 */         logger_.error("CAUGHT EXCEPTION", ex);
/*     */       } 
/*     */     }
/*  71 */     return this.renderer_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/*  82 */     if (argKey.equalsIgnoreCase("Column")) {
/*  83 */       this.columns_.add((ListViewColumnConfig)argValue);
/*     */     }
/*  85 */     else if (argKey.equalsIgnoreCase("RendererClass")) {
/*  86 */       setRenderer(argValue);
/*     */     }
/*  88 */     else if ("SecuredObject".equalsIgnoreCase(argKey)) {
/*  89 */       this.securedObjectIds_.add(SecuredObjectID.forName(argValue));
/*     */     } else {
/*     */       
/*  92 */       super.setConfigObject(argKey, argValue);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean validateSecurity() {
/*  97 */     if (this.securedObjectIds_.size() == 0) {
/*  98 */       return true;
/*     */     }
/*     */     
/* 101 */     SecuredObjectID[] acls = this.securedObjectIds_.<SecuredObjectID>toArray(new SecuredObjectID[0]);
/*     */     
/* 103 */     for (SecuredObjectID acl : acls) {
/*     */       
/* 105 */       if (!this._securityUtil.getAcl((ISecuredObjectID)acl).getAccessLevel(AccessType.READ, this._stationState.getSystemUser()).isGranted()) {
/* 106 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 110 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setRenderer(IConfigObject argRendererClass) {
/* 116 */     ClassConfig<?> cc = ConfigUtils.toClassConfig(argRendererClass);
/* 117 */     this.rendererClass_ = (ClassConfig)cc;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framewor\\ui\listview\config\ListViewRowConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */