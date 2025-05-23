/*     */ package dtv.pos.framework.action.access;
/*     */ 
/*     */ import dtv.pos.framework.scope.TransactionScope;
/*     */ import dtv.pos.framework.systemcycle.TransDateProvider;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.visibilityrules.AccessLevel;
/*     */ import dtv.pos.iframework.visibilityrules.IAccessLevel;
/*     */ import dtv.pos.iframework.visibilityrules.ILineItemTester;
/*     */ import dtv.pos.iframework.visibilityrules.IVisibilityRule;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.spring.IgnoreSingletonValidation;
/*     */ import dtv.util.temp.InjectionHammer;
/*     */ import dtv.xst.dao.trl.IRetailTransaction;
/*     */ import dtv.xst.dao.trl.IRetailTransactionLineItem;
/*     */ import dtv.xst.dao.trl.IRetailTransactionLineItemModel;
/*     */ import dtv.xst.dao.trn.IPosTransaction;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import javax.inject.Inject;
/*     */ import javax.inject.Provider;
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
/*     */ public abstract class AbstractVisibilityRule
/*     */   implements IVisibilityRule
/*     */ {
/*     */   private static final String PARAM_GROUP = "group";
/*     */   private static final String PARAM_GRANTER = "granter";
/*  43 */   private static final List<? extends IRetailTransactionLineItem> noLineItems_ = Collections.emptyList();
/*  44 */   private static final Logger logger_ = Logger.getLogger(AbstractVisibilityRule.class);
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
/*     */   protected static boolean testLineItems(Collection<? extends IRetailTransactionLineItem> argLines, ILineItemTester argTester, Class<? extends IRetailTransactionLineItemModel> argTargetLineItem, boolean argStopOnTrue, boolean argStopOnFalse) {
/*  66 */     boolean holder = false;
/*     */     
/*  68 */     for (IRetailTransactionLineItem line : argLines) {
/*  69 */       if (argTargetLineItem.isInstance(line) && !line.getVoid()) {
/*  70 */         holder = argTester.testLineItem(line);
/*     */         
/*  72 */         if (holder && argStopOnTrue) {
/*  73 */           return true;
/*     */         }
/*  75 */         if (!holder && argStopOnFalse) {
/*  76 */           return false;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  81 */     return argTester.evaluateEndOfList();
/*     */   }
/*     */   
/*  84 */   private String sourceDescription_ = null;
/*  85 */   private int group_ = 0;
/*     */ 
/*     */   
/*     */   private boolean granter_ = false;
/*     */   
/*     */   private boolean invert_ = false;
/*     */   
/*     */   @Inject
/*     */   @IgnoreSingletonValidation(justification = "This will be accessed from session-bound thread on mobile. The provider will return the appropriate mode controller.")
/*     */   private Provider<TransactionScope> _transactionScope;
/*     */   
/*     */   @Inject
/*     */   @IgnoreSingletonValidation(justification = "This will be accessed from session-bound thread on mobile. The provider will return the appropriate mode controller.")
/*     */   protected Provider<IModeController> _modeProvider;
/*     */   
/*     */   @Inject
/*     */   @IgnoreSingletonValidation(justification = "This will be accessed from session-bound thread on mobile. The provider will return the appropriate instance.")
/*     */   private Provider<TransDateProvider> _transDateProvider;
/*     */ 
/*     */   
/*     */   public AbstractVisibilityRule() {
/* 106 */     InjectionHammer.forceAtInjectProcessing(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IAccessLevel checkVisibility() throws Exception {
/* 115 */     IAccessLevel accLevel = checkVisibilityImpl();
/* 116 */     return this.invert_ ? AccessLevel.getInvertedLevel(accLevel) : accLevel;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(IVisibilityRule argOther) {
/* 122 */     return getGroup() - argOther.getGroup();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getGroup() {
/* 128 */     return this.group_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSourceDescription() {
/* 134 */     return this.sourceDescription_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isGranter() {
/* 140 */     return this.granter_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void setParameter(String argName, IConfigObject argValue) {
/* 150 */     setParameter(argName, argValue.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParameter(String argName, String argValue) {
/* 156 */     if ("inverted".equalsIgnoreCase(argName) || "invert".equalsIgnoreCase(argName)) {
/* 157 */       boolean invert = ConfigUtils.toBoolean(argValue).booleanValue();
/*     */       
/* 159 */       if (invert && !isInvertable()) {
/* 160 */         logger_.warn("This visibility rule is not invertable!");
/*     */       } else {
/*     */         
/* 163 */         this.invert_ = invert;
/*     */       }
/*     */     
/* 166 */     } else if ("group".equalsIgnoreCase(argName)) {
/* 167 */       this.group_ = ConfigUtils.toInt(argValue);
/*     */     }
/* 169 */     else if ("granter".equalsIgnoreCase(argName)) {
/* 170 */       this.granter_ = ConfigUtils.toBoolean(argValue).booleanValue();
/*     */     } else {
/*     */       
/* 173 */       logger_.warn("Unexpected parameter for [" + getClass().getName() + "]: [" + argName + "]=[" + argValue
/* 174 */           .toString() + "] @@ " + getSourceDescription());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSourceDescription(String argSourceDescription) {
/* 181 */     this.sourceDescription_ = argSourceDescription;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final List<? extends IRetailTransactionLineItem> getCurrentLineItems() {
/* 200 */     IPosTransaction tran = getCurrentPosTransaction();
/* 201 */     return (tran == null) ? noLineItems_ : tran.getRetailTransactionLineItems();
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
/*     */   protected final List<? extends IRetailTransactionLineItem> getCurrentLineItemsByTypeCode(String argTypeCode) {
/* 213 */     IPosTransaction tran = getCurrentPosTransaction();
/* 214 */     return (tran == null) ? noLineItems_ : tran.getLineItemsByTypeCode(argTypeCode);
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
/*     */   
/*     */   protected final <T extends IRetailTransactionLineItem> List<T> getCurrentLineItemsByTypeCode(String argTypeCode, Class<T> argInterface) {
/* 230 */     IPosTransaction tran = getCurrentPosTransaction();
/* 231 */     return (tran == null) ? (List)noLineItems_ : tran.getLineItemsByTypeCode(argTypeCode, argInterface);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final IPosTransaction getCurrentPosTransaction() {
/* 240 */     return ((TransactionScope)this._transactionScope.get()).getTransaction();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final IRetailTransaction getCurrentRetailTransaction() {
/* 250 */     IPosTransaction tran = getCurrentPosTransaction();
/* 251 */     return (tran instanceof IRetailTransaction) ? (IRetailTransaction)tran : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isInvertable() {
/* 262 */     return true;
/*     */   }
/*     */   
/*     */   protected final TransDateProvider transDateProvider() {
/* 266 */     return (TransDateProvider)this._transDateProvider.get();
/*     */   }
/*     */   
/*     */   protected abstract IAccessLevel checkVisibilityImpl() throws Exception;
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\action\access\AbstractVisibilityRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */