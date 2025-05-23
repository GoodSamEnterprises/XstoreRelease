/*     */ package dtv.pos.framework.form.dependency;
/*     */ 
/*     */ import dtv.event.Event;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.util.NumberUtils;
/*     */ import dtv.util.config.BigDecimalConfig;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import java.math.BigDecimal;
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
/*     */ public class GreaterThanDependencyRule
/*     */   extends AbstractDependencyRule
/*     */ {
/*  24 */   static final Logger logger_ = Logger.getLogger(GreaterThanDependencyRule.class);
/*     */   
/*  26 */   BigDecimal value_ = NumberUtils.ZERO;
/*     */ 
/*     */ 
/*     */   
/*     */   protected AbstractDependencyRule.BasicEventHandler createEditModelChangeHandler() {
/*  31 */     return new AbstractDependencyRule.BasicEventHandler() {
/*  32 */         private final EventHandler.SettledNotifier notification_ = new EventHandler.SettledNotifier()
/*     */           {
/*     */             public void queueSettled()
/*     */             {
/*  36 */               GreaterThanDependencyRule.null.this.running_ = false;
/*     */             }
/*     */           };
/*     */ 
/*     */         
/*     */         boolean running_ = false;
/*     */         
/*     */         protected EventHandler.SettledNotifier _event(Event argEvent) {
/*  44 */           if (!this.running_) {
/*  45 */             this.running_ = true;
/*  46 */             handle(argEvent);
/*     */             
/*  48 */             return this.notification_;
/*     */           } 
/*     */ 
/*     */           
/*  52 */           return null;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   protected void modelChange(Object argNewValue) {
/*     */     BigDecimal value;
/*  60 */     if (argNewValue == null) {
/*  61 */       handleNotSet();
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  67 */     if (argNewValue instanceof BigDecimal) {
/*  68 */       value = (BigDecimal)argNewValue;
/*     */     } else {
/*     */       
/*     */       try {
/*  72 */         value = new BigDecimal(argNewValue.toString());
/*     */       }
/*  74 */       catch (NumberFormatException ee) {
/*  75 */         logger_.info("user entered non-numeric. " + argNewValue);
/*  76 */         handleNotSet();
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/*  82 */     if (NumberUtils.isGreaterThan(value, this.value_)) {
/*  83 */       handleMatch();
/*     */     } else {
/*     */       
/*  86 */       handleNoMatch();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setParameter(String argName, IConfigObject argValue) {
/*  93 */     if ("value".equalsIgnoreCase(argName) && argValue instanceof BigDecimalConfig) {
/*  94 */       this.value_ = ((BigDecimalConfig)argValue).getBigDecimal();
/*     */     } else {
/*     */       
/*  97 */       super.setParameter(argName, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void validateParameters() {
/* 104 */     validateCardinalityParameters();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\dependency\GreaterThanDependencyRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */