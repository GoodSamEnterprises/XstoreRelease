/*     */ package dtv.data2.dataserver.config;
/*     */ 
/*     */ import dtv.data2.dataserver.IDataServerAction;
/*     */ import dtv.util.IHasParameters;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import org.apache.commons.lang3.builder.EqualsBuilder;
/*     */ import org.apache.commons.lang3.builder.HashCodeBuilder;
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
/*     */ public abstract class AbstractActionConfig<C extends IDataServerAction>
/*     */   extends AbstractParameterizedConfig
/*     */   implements IActionConfig
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  28 */   private static final Logger _logger = Logger.getLogger(AbstractActionConfig.class);
/*     */   
/*     */   private static final String ORDER_TAG = "Order";
/*     */   
/*     */   private static final String VALUE_TAG = "Value";
/*     */   
/*     */   private final Class<? extends C> _actionClass;
/*     */   
/*     */   private int _order;
/*     */   
/*     */   private String _value;
/*     */ 
/*     */   
/*     */   public AbstractActionConfig(Class<? extends C> argActionClass) {
/*  42 */     this._actionClass = argActionClass;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object argObj) {
/*  48 */     if (argObj == null) {
/*  49 */       return false;
/*     */     }
/*     */     
/*  52 */     if (!(argObj instanceof AbstractActionConfig)) {
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     AbstractActionConfig other = (AbstractActionConfig)argObj;
/*  57 */     return (new EqualsBuilder()).append(getType(), other.getType()).append(getValue(), other.getValue())
/*  58 */       .append(getOrder(), other.getOrder()).append(getParameters(), other.getParameters())
/*  59 */       .appendSuper(super.equals(other)).isEquals();
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
/*     */   public C getAction() throws Exception {
/*     */     try {
/*  72 */       IDataServerAction iDataServerAction = (IDataServerAction)this._actionClass.newInstance();
/*  73 */       iDataServerAction.setOrder(getOrder());
/*  74 */       iDataServerAction.setValue(getValue());
/*  75 */       addParameters((IHasParameters)iDataServerAction);
/*     */       
/*  77 */       return (C)iDataServerAction;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*  83 */     catch (InstantiationException iEx) {
/*  84 */       _logger.error("An error occurred instantiating the action [" + toString() + "]", iEx);
/*  85 */       throw iEx;
/*     */     }
/*  87 */     catch (IllegalAccessException iaEx) {
/*  88 */       _logger.error("Appropriate access was not obtained to instantiate the action [" + toString() + "]", iaEx);
/*     */       
/*  90 */       throw iaEx;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getOrder() {
/*  95 */     return this._order;
/*     */   }
/*     */   
/*     */   public String getValue() {
/*  99 */     return this._value;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 105 */     return (new HashCodeBuilder(17, 37)).append(getType()).append(getOrder()).append(getValue())
/* 106 */       .append(getParameters()).appendSuper(super.hashCode()).toHashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfigObject(String argKey, IConfigObject argValue) {
/* 112 */     if ("Order".equalsIgnoreCase(argKey)) {
/* 113 */       this._order = ConfigUtils.toInt(argValue);
/*     */     }
/* 115 */     else if ("Value".equalsIgnoreCase(argKey)) {
/* 116 */       this._value = argValue.toString();
/*     */     } else {
/*     */       
/* 119 */       super.setConfigObject(argKey, argValue);
/*     */     } 
/*     */     
/* 122 */     setClean();
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataserver\config\AbstractActionConfig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */