/*     */ package dtv.pos.framework.action.type;
/*     */ 
/*     */ import dtv.pos.iframework.action.IXstChainActionType;
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
/*     */ public class XstChainActionType
/*     */   implements IXstChainActionType
/*     */ {
/*  33 */   public static final XstChainActionType STACK = new XstChainActionType("STACK");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  38 */   public static final XstChainActionType START = new XstChainActionType("START");
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
/*  51 */   public static final XstChainActionType START_NEW_APP = new XstChainActionType("START_NEW_APP");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  56 */   public static final XstChainActionType SYSTEM = new XstChainActionType("SYSTEM");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  62 */   public static final XstChainActionType DEFAULT = START;
/*     */   
/*  64 */   private static final Logger logger_ = Logger.getLogger(XstChainActionType.class);
/*     */ 
/*     */   
/*     */   private static Map<String, XstChainActionType> values_;
/*     */ 
/*     */   
/*     */   private final String name_;
/*     */ 
/*     */   
/*     */   public static XstChainActionType forName(IConfigObject argName) {
/*  74 */     if (argName == null) {
/*  75 */       return null;
/*     */     }
/*  77 */     XstChainActionType found = values_.get(argName.toString().trim().toUpperCase());
/*  78 */     if (found == null) {
/*  79 */       logger_.warn("There is no instance of [" + XstChainActionType.class.getName() + "] named [" + argName + "] @@ " + argName
/*  80 */           .getSourceDescription());
/*  81 */       return DEFAULT;
/*     */     } 
/*  83 */     return found;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XstChainActionType forName(String name) {
/*  92 */     if (name == null) {
/*  93 */       return null;
/*     */     }
/*  95 */     XstChainActionType foundType = values_.get(name.trim().toUpperCase());
/*     */     
/*  97 */     if (foundType == null) {
/*  98 */       logger_.warn("Configuration setting [" + name + "] not supported!\nUsing default setting: [" + DEFAULT + "].");
/*     */       
/* 100 */       foundType = DEFAULT;
/*     */     } 
/* 102 */     return foundType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private XstChainActionType(String name) {
/* 113 */     this.name_ = name.trim().toUpperCase();
/*     */     
/* 115 */     if (values_ == null) {
/* 116 */       values_ = new HashMap<>();
/*     */     }
/* 118 */     values_.put(this.name_, this);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 123 */     return this.name_;
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
/*     */   public String toString() {
/* 137 */     return this.name_;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\type\XstChainActionType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */