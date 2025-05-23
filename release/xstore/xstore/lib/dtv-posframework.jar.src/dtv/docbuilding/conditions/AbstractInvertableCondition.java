/*     */ package dtv.docbuilding.conditions;
/*     */ 
/*     */ import dtv.docbuilding.trace.ITracer;
/*     */ import dtv.pos.framework.systemcycle.TransDateProvider;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.config.ConfigException;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import java.math.BigDecimal;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractInvertableCondition
/*     */   implements IDocBuilderCondition
/*     */ {
/*  27 */   private static final Logger logger_ = Logger.getLogger(AbstractInvertableCondition.class);
/*     */   
/*  29 */   private static final boolean isInfoEnabled_ = logger_.isInfoEnabled();
/*     */   
/*     */   private boolean inverted_ = false;
/*     */   
/*     */   private String sourceDescription_;
/*     */   
/*     */   @Inject
/*     */   protected TransDateProvider _transDateProvider;
/*     */ 
/*     */   
/*     */   public final boolean conditionMet(Object argSource) {
/*  40 */     InjectionHammer.forceAtInjectProcessing(this);
/*     */     
/*     */     try {
/*  43 */       boolean met = conditionMetImpl(argSource);
/*     */       
/*  45 */       if (this.inverted_) {
/*  46 */         met = !met;
/*     */       }
/*     */       
/*  49 */       if (isInfoEnabled_) {
/*  50 */         logger_.info(getClass().getName() + "-->" + met + " (config=" + getSourceDescription() + "}");
/*     */       }
/*     */       
/*  53 */       return met;
/*     */     }
/*  55 */     catch (Exception ex) {
/*  56 */       logger_.warn("CAUGHT EXCEPTION with config='" + 
/*  57 */           getSourceDescription() + "', source='" + 
/*  58 */           ObjectUtils.getClassNameFromObject(argSource) + "':'" + argSource + "'... returning false", ex);
/*     */       
/*  60 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSourceDescription() {
/*  66 */     return this.sourceDescription_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParameter(String argName, Object argValue) {
/*  75 */     if ("inverted".equalsIgnoreCase(argName)) {
/*  76 */       this.inverted_ = toBooleanParameter(argValue);
/*     */     } else {
/*     */       
/*  79 */       logger_.warn("condition [" + getClass().getName() + "] does not support parameter named [" + argName + "] of type [" + 
/*  80 */           ObjectUtils.getClassNameFromObject(argValue) + "] in config='" + 
/*  81 */           getSourceDescription() + "'");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSourceDescription(String argSourceDescription) {
/*  87 */     this.sourceDescription_ = argSourceDescription;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void trace(ITracer argTracer) {
/*  93 */     argTracer.attr("CONDITION (" + getClass().getName() + ")");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract boolean conditionMetImpl(Object paramObject);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final BigDecimal toBigDecimalParameter(Object argValue) {
/* 105 */     if (argValue instanceof BigDecimal) {
/* 106 */       return (BigDecimal)argValue;
/*     */     }
/*     */     
/* 109 */     return new BigDecimal(argValue.toString());
/*     */   }
/*     */   
/*     */   protected final boolean toBooleanParameter(Object argValue) {
/* 113 */     if (argValue instanceof Boolean) {
/* 114 */       return ((Boolean)argValue).booleanValue();
/*     */     }
/*     */     
/* 117 */     return Boolean.valueOf(argValue.toString()).booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   protected final Class<?> toClassParameter(Object argValue) {
/* 122 */     if (argValue instanceof Class) {
/* 123 */       return (Class)argValue;
/*     */     }
/*     */     
/*     */     try {
/* 127 */       return Class.forName(argValue.toString());
/*     */     }
/* 129 */     catch (ClassNotFoundException ex) {
/* 130 */       throw new ConfigException(ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected final int toIntParameter(Object argValue) {
/* 136 */     if (argValue instanceof Integer) {
/* 137 */       return ((Integer)argValue).intValue();
/*     */     }
/*     */     
/* 140 */     return Integer.parseInt(argValue.toString());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void warn(Throwable argThrowable) {
/* 145 */     logger_.error("CAUGHT EXCEPTION with config='" + getSourceDescription() + "'", argThrowable);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\docbuilding\conditions\AbstractInvertableCondition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */