/*     */ package dtv.pos.iframework.ui;
/*     */ 
/*     */ import dtv.event.EventEnum;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ public final class ActionDisplayType
/*     */   extends EventEnum
/*     */ {
/*  23 */   private static final Logger logger_ = Logger.getLogger(ActionDisplayType.class);
/*     */ 
/*     */   
/*  26 */   public static final ActionDisplayType BUTTON = new ActionDisplayType("BUTTON", false);
/*  27 */   public static final ActionDisplayType BUTTON_EXCLUSIVE = new ActionDisplayType("BUTTON_EXCLUSIVE", false);
/*  28 */   public static final ActionDisplayType LIST = new ActionDisplayType("LIST", true);
/*  29 */   public static final ActionDisplayType ICON_LIST = new ActionDisplayType("ICON_LIST", true);
/*  30 */   public static final ActionDisplayType POPUP = new ActionDisplayType("POPUP", true);
/*     */   
/*  32 */   public static final ActionDisplayType DEFAULT = BUTTON;
/*     */ 
/*     */   
/*     */   private static Map<String, ActionDisplayType> values_;
/*     */ 
/*     */   
/*     */   private final String _name;
/*     */ 
/*     */   
/*     */   private final boolean _isPopupType;
/*     */ 
/*     */   
/*     */   public static ActionDisplayType forName(IConfigObject argName) {
/*  45 */     if (argName == null) {
/*  46 */       return null;
/*     */     }
/*     */     
/*  49 */     ActionDisplayType found = values_.get(argName.toString().trim().toUpperCase());
/*     */     
/*  51 */     if (found == null) {
/*  52 */       logger_.warn("There is no instance of [" + ActionDisplayType.class.getName() + "] named [" + argName + "]:" + argName
/*  53 */           .getSourceDescription());
/*     */     }
/*     */     
/*  56 */     return found;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ActionDisplayType forName(String argName) {
/*  66 */     if (argName == null) {
/*  67 */       return null;
/*     */     }
/*  69 */     ActionDisplayType found = values_.get(argName.trim().toUpperCase());
/*  70 */     if (found == null) {
/*  71 */       logger_.warn("There is no instance of [" + ActionDisplayType.class.getName() + "] named [" + argName + "].", new Throwable("STACK TRACE"));
/*     */     }
/*     */     
/*  74 */     return found;
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
/*     */ 
/*     */   
/*     */   private ActionDisplayType(String argName, boolean argIsPopupType) {
/*  89 */     super(argName);
/*  90 */     this._name = argName.trim().toUpperCase();
/*  91 */     this._isPopupType = argIsPopupType;
/*     */     
/*  93 */     if (values_ == null) {
/*  94 */       values_ = new HashMap<>();
/*     */     }
/*     */     
/*  97 */     values_.put(this._name, this);
/*     */   }
/*     */   
/*     */   public String getName() {
/* 101 */     return this._name;
/*     */   }
/*     */   
/*     */   public boolean isPopupType() {
/* 105 */     return this._isPopupType;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\iframewor\\ui\ActionDisplayType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */