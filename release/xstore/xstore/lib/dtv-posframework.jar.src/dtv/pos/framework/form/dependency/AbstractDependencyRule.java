/*     */ package dtv.pos.framework.form.dependency;
/*     */ 
/*     */ import dtv.event.Event;
/*     */ import dtv.event.EventHandler;
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventAware;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.eventor.DefaultEventor;
/*     */ import dtv.pos.iframework.form.Cardinality;
/*     */ import dtv.pos.iframework.form.EditModelFieldChangeType;
/*     */ import dtv.pos.iframework.form.ICardinality;
/*     */ import dtv.pos.iframework.form.IEditModel;
/*     */ import dtv.pos.iframework.form.config.IFieldDependencyConfig;
/*     */ import dtv.pos.iframework.form.dependency.IDependencyRule;
/*     */ import dtv.pos.iframework.form.dependency.IMutableFieldDefinition;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import dtv.util.config.IConfigObject;
/*     */ import dtv.util.config.ParameterConfig;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractDependencyRule
/*     */   implements IDependencyRule, IEventSource
/*     */ {
/*  30 */   private static final Logger logger_ = Logger.getLogger(AbstractDependencyRule.class);
/*     */   
/*     */   protected IMutableFieldDefinition parentField_;
/*  33 */   protected Eventor events_ = null;
/*     */   
/*     */   private final IEventAware fieldChangeHandler_;
/*     */   
/*     */   private IFieldDependencyConfig config_;
/*     */   private IEditModel parentEditModel_;
/*     */   private ICardinality matchState_;
/*     */   private ICardinality noMatchState_;
/*  41 */   private final Set<String> codeSet_ = new HashSet<>();
/*     */ 
/*     */   
/*     */   private boolean notSetIsMatch_ = false;
/*     */   
/*     */   private boolean initialized_ = false;
/*     */ 
/*     */   
/*     */   public AbstractDependencyRule() {
/*  50 */     this.fieldChangeHandler_ = (IEventAware)createEditModelChangeHandler();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSourceDescription() {
/*  56 */     return this.config_.getSourceDescription();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initialize() {
/*  62 */     if (!this.initialized_) {
/*  63 */       if (this.config_ == null || this.parentEditModel_ == null || this.parentField_ == null) {
/*  64 */         throw new IllegalStateException();
/*     */       }
/*     */       
/*  67 */       this.parentEditModel_.registerFieldHandler(this.config_.getFieldRef(), this.fieldChangeHandler_, EditModelFieldChangeType.VALUE_CHANGED
/*  68 */           .toConstraint());
/*  69 */       for (ParameterConfig pc : this.config_.getRuleParams().getParameters()) {
/*  70 */         setParameter(pc.getName(), pc.getValue());
/*     */       }
/*  72 */       validateParameters();
/*  73 */       this.initialized_ = true;
/*     */     } 
/*     */     
/*  76 */     Object data = this.parentEditModel_.getValue(this.config_.getFieldRef());
/*  77 */     modelChange(data);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setConfig(IFieldDependencyConfig argConfig) {
/*  83 */     this.config_ = argConfig;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParentEditModel(IEditModel argParentEditModel) {
/*  89 */     this.parentEditModel_ = argParentEditModel;
/*  90 */     if (argParentEditModel != null) {
/*  91 */       this.events_ = (Eventor)new DefaultEventor((IEventSource)argParentEditModel);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParentField(IMutableFieldDefinition argParentField) {
/*  98 */     this.parentField_ = argParentField;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected BasicEventHandler createEditModelChangeHandler() {
/* 106 */     return new BasicEventHandler();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final Set<String> getCodeSet() {
/* 114 */     return Collections.unmodifiableSet(this.codeSet_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void handleMatch() {
/* 121 */     handleStateChange(this.noMatchState_, this.matchState_);
/* 122 */     this.parentField_.setCardinality(this.matchState_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void handleNoMatch() {
/* 129 */     handleStateChange(this.matchState_, this.noMatchState_);
/* 130 */     this.parentField_.setCardinality(this.noMatchState_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void handleNotSet() {
/* 137 */     if (this.notSetIsMatch_) {
/* 138 */       handleMatch();
/*     */     } else {
/*     */       
/* 141 */       handleNoMatch();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void handleStateChange(ICardinality oldState, ICardinality newState) {
/* 152 */     boolean wasAvailable = oldState.isAvailable();
/* 153 */     boolean isAvailable = newState.isAvailable();
/*     */ 
/*     */     
/* 156 */     if (wasAvailable != isAvailable) {
/* 157 */       if (wasAvailable)
/*     */       {
/* 159 */         this.parentField_.removeValue();
/*     */       }
/* 161 */       if (isAvailable)
/*     */       {
/* 163 */         this.parentField_.unremoveValue();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void modelChange(Object paramObject);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setParameter(String argName, IConfigObject argValue) {
/* 181 */     if ("code".equalsIgnoreCase(argName)) {
/* 182 */       this.codeSet_.add(argValue.toString());
/*     */     }
/* 184 */     else if ("noMatchState".equalsIgnoreCase(argName)) {
/* 185 */       this.noMatchState_ = (ICardinality)new Cardinality(argValue.toString());
/*     */     }
/* 187 */     else if ("matchState".equalsIgnoreCase(argName)) {
/* 188 */       this.matchState_ = (ICardinality)new Cardinality(argValue.toString());
/*     */     }
/* 190 */     else if ("notSetIsMatch".equalsIgnoreCase(argName)) {
/* 191 */       this.notSetIsMatch_ = ConfigUtils.toBoolean(argValue);
/*     */     } else {
/*     */       
/* 194 */       warnUnsupported(argName, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final void validateCardinalityParameters() {
/* 205 */     if (this.matchState_ == null) {
/* 206 */       throw new IllegalArgumentException("matchState must be specified");
/*     */     }
/*     */     
/* 209 */     if (this.noMatchState_ == null) {
/* 210 */       throw new IllegalArgumentException("noMatchState must be specified");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void validateParameters() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void warnUnsupported(String argName, IConfigObject argValue) {
/* 229 */     logger_.warn("unexpected param '" + argName + "'='" + argValue + "'");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected class BasicEventHandler
/*     */     extends EventHandler
/*     */   {
/*     */     protected final void handle(Event argEvent) {
/* 241 */       Object newValue = argEvent.getBaseEvent().getPayload();
/* 242 */       AbstractDependencyRule.this.modelChange(newValue);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\dependency\AbstractDependencyRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */