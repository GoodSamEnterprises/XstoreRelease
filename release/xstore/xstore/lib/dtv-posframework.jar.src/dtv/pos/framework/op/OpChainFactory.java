/*     */ package dtv.pos.framework.op;
/*     */ import com.micros.xstore.config.IConfigMgr;
/*     */ import com.micros.xstore.config.common.Parameter;
/*     */ import com.micros.xstore.config.impl.ConfigLoadingException;
/*     */ import com.micros.xstore.config.impl.LocatableObject;
/*     */ import com.micros.xstore.config.opchain.ChoiceConditionType;
/*     */ import com.micros.xstore.config.opchain.OpChainChildTypeEnum;
/*     */ import com.micros.xstore.config.opchain.OpChainChoiceType;
/*     */ import com.micros.xstore.config.opchain.OpChainRouteType;
/*     */ import com.micros.xstore.config.opchain.OpChainSet;
/*     */ import com.micros.xstore.config.opchain.OpChainType;
/*     */ import com.micros.xstore.config.opchain.OperationType;
/*     */ import com.micros.xstore.config.opchain.PromptOpType;
/*     */ import com.micros.xstore.config.opchain.ValidationOpType;
/*     */ import com.micros.xstore.config.opchain.WorkerOpType;
/*     */ import dtv.pos.common.DozerFactoryWrapperBean;
/*     */ import dtv.pos.common.OpChainKey;
/*     */ import dtv.pos.framework.action.type.XstChainActionType;
/*     */ import dtv.pos.framework.op.xflow.StubPlaceholderOp;
/*     */ import dtv.pos.framework.ui.context.UIContextDescriptor;
/*     */ import dtv.pos.framework.validation.ValidationRuleList;
/*     */ import dtv.pos.framework.validation.ValidationRuleListFactory;
/*     */ import dtv.pos.framework.worker.IWorkerOp;
/*     */ import dtv.pos.framework.worker.WorkerList;
/*     */ import dtv.pos.framework.worker.WorkerLocator;
/*     */ import dtv.pos.iframework.op.IOpChain;
/*     */ import dtv.pos.iframework.op.IOpChainFactory;
/*     */ import dtv.pos.iframework.op.IOperation;
/*     */ import dtv.pos.iframework.op.IPromptOp;
/*     */ import dtv.pos.iframework.op.IValidationOp;
/*     */ import dtv.pos.iframework.ui.context.IUIContextDescriptor;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.inject.Inject;
/*     */ import javax.inject.Provider;
/*     */ import javax.xml.bind.JAXBElement;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.springframework.beans.factory.NoSuchBeanDefinitionException;
/*     */ 
/*     */ public class OpChainFactory implements IOpChainFactory {
/*  44 */   private static final Logger logger_ = Logger.getLogger(OpChainFactory.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  54 */   private static final Map<OpChainChildTypeEnum, Class<? extends IOperation>> _opElementToInterfaceMap = new HashMap<>(); private final OpChainConfigReloader _opChainConfigReloader; protected Map<OpChainKey, OpChainType> _chainConfigMap; private final IConfigMgr<OpChainSet> _configMgr; @Inject
/*     */   private Map<String, OpClassReplacement> _opReplacements;
/*     */   
/*     */   static {
/*  58 */     _opElementToInterfaceMap.put(OpChainChildTypeEnum.PROMPT_OP, IPromptOp.class);
/*  59 */     _opElementToInterfaceMap.put(OpChainChildTypeEnum.VALIDATION_OP, IValidationOp.class);
/*  60 */     _opElementToInterfaceMap.put(OpChainChildTypeEnum.WORKER_OP, IWorkerOp.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private DozerFactoryWrapperBean _dozer;
/*     */ 
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private ValidationRuleListFactory _validationRuleListLocator;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private WorkerLocator _workerLocator;
/*     */ 
/*     */   
/*     */   @IgnoreSingletonValidation(justification = "will always be from a session thread on mobile")
/*     */   @Inject
/*     */   private Provider<IOpChain> _defaultOpChainProvider;
/*     */ 
/*     */ 
/*     */   
/*     */   protected OpChainFactory(IConfigMgr<OpChainSet> argConfigMgr) {
/*  86 */     this._configMgr = argConfigMgr;
/*  87 */     this._opChainConfigReloader = new OpChainConfigReloader();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOpChain getCancelDeniedChain() {
/*  98 */     return getOpChain(OpChainKey.valueOf("CANCEL_DENIED"));
/*     */   }
/*     */   
/*     */   public String getConfigurationInformation() {
/* 102 */     return (new OpChainConfigReporter(this._chainConfigMap)).getReport();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IOpChain getOpChain(OpChainKey argKey) {
/* 108 */     this._opChainConfigReloader.reloadIfNeeded();
/*     */     
/* 110 */     if (logger_.isDebugEnabled()) {
/* 111 */       logger_.debug("Getting an op chain for " + argKey);
/*     */     }
/*     */     
/* 114 */     OpChainType chainConfig = this._chainConfigMap.get(argKey);
/*     */     
/* 116 */     if (chainConfig == null) {
/* 117 */       logger_.warn("No chain available for " + argKey);
/* 118 */       return null;
/*     */     } 
/*     */     
/* 121 */     return buildOpChainFromConfig(chainConfig);
/*     */   }
/*     */   
/*     */   public void init() {
/*     */     try {
/* 126 */       OpChainSet chainSet = (OpChainSet)this._configMgr.getResolvedConfigs();
/* 127 */       this._chainConfigMap = new HashMap<>();
/*     */       
/* 129 */       for (OpChainType chain : chainSet.getOpChains()) {
/* 130 */         OpChainKey chainKey = OpChainKey.valueOf(chain.getName());
/* 131 */         this._chainConfigMap.put(chainKey, chain);
/*     */       }
/*     */     
/* 134 */     } catch (ConfigLoadingException ex) {
/* 135 */       logger_.error("Failed to successfully load OpChainConfig.xml files.", (Throwable)ex);
/* 136 */       throw new ConfigException(ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isValidChain(OpChainKey argChainKey) {
/* 143 */     this._opChainConfigReloader.reloadIfNeeded();
/* 144 */     return this._chainConfigMap.containsKey(argChainKey);
/*     */   }
/*     */   
/*     */   protected IOpChain buildOpChainFromConfig(OpChainType argChainConfig) {
/* 148 */     IOpChain result = (IOpChain)this._defaultOpChainProvider.get();
/* 149 */     long t1 = System.currentTimeMillis();
/* 150 */     result.setSourceDescription(argChainConfig.getSourceDescription());
/*     */ 
/*     */     
/* 153 */     if (!StringUtils.isEmpty(argChainConfig.getSignal())) {
/* 154 */       String[] signals = argChainConfig.getSignal().split(",");
/* 155 */       List<String> signalList = new ArrayList<>();
/*     */       
/* 157 */       for (String signal : signals) {
/* 158 */         signalList.add(signal.trim());
/*     */       }
/*     */       
/* 161 */       result.setSignals(signalList);
/*     */     } 
/*     */     
/* 164 */     result.setChainKey(OpChainKey.valueOf(argChainConfig.getName()));
/*     */     
/* 166 */     if (!StringUtils.isEmpty(argChainConfig.getContextKey())) {
/* 167 */       result.setContextDescriptor((IUIContextDescriptor)new UIContextDescriptor(argChainConfig.getContextKey()));
/*     */     }
/*     */ 
/*     */     
/* 171 */     int rollbackLevel = (argChainConfig.getRollbackLevel() == null) ? -1 : argChainConfig.getRollbackLevel().intValue();
/* 172 */     result.setRollbackLevel(rollbackLevel);
/*     */ 
/*     */     
/* 175 */     OpChainKey rollbackChainKey = (argChainConfig.getRollbackChainKey() == null) ? null : OpChainKey.valueOf(argChainConfig.getRollbackChainKey());
/* 176 */     result.setRollbackChainKey(rollbackChainKey);
/*     */     
/* 178 */     for (JAXBElement<? extends LocatableObject> element : (Iterable<JAXBElement<? extends LocatableObject>>)argChainConfig
/* 179 */       .getOpChainReferencesAndOpChainLinksAndOperations()) {
/* 180 */       OperationType operationType1; OpChainRouteType chainRoute; OperationType operationType2; ValidationOpType validationOpType; PromptOpType promptOpType; WorkerOpType opType; IOpFactory<OpChainRouteType, OpChainRouteOp> iOpFactory2; IOpFactory<OperationType, IOperation> opfactory; IOpFactory<ValidationOpType, IValidationOp> iOpFactory1; IOpFactory<PromptOpType, IPromptOp> iOpFactory; IOpFactory<WorkerOpType, IWorkerOp> opFactory; LocatableObject opConfig = element.getValue();
/* 181 */       OpChainChildTypeEnum childType = OpChainChildTypeEnum.fromValue(element.getName().getLocalPart());
/* 182 */       IOperation op = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 190 */       if (opConfig instanceof OperationType) {
/* 191 */         OperationType operationType = (OperationType)opConfig;
/*     */         
/* 193 */         if (operationType.getClazz() != null && this._opReplacements != null && this._opReplacements
/* 194 */           .containsKey(operationType.getClazz().getName())) {
/* 195 */           String replacement = ((OpClassReplacement)this._opReplacements.get(operationType.getClazz().getName())).getReplacementClassName();
/*     */           
/*     */           try {
/* 198 */             Class<?> replacementClass = Class.forName(replacement);
/*     */             
/* 200 */             logger_.info("Replacing operation class [" + operationType.getClazz().getName() + "] with class [" + replacement + "], as specified by opReplacements configuration.");
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 205 */             OperationType clonedOpConfig = (OperationType)this._dozer.getMapper().map(operationType, operationType.getClass());
/* 206 */             clonedOpConfig.setClazz(replacementClass);
/* 207 */             operationType1 = clonedOpConfig;
/*     */ 
/*     */             
/* 210 */             Class<? extends IOperation> originalClass = _opElementToInterfaceMap.get(childType);
/*     */             
/* 212 */             if (originalClass != null && !originalClass.isAssignableFrom(replacementClass)) {
/* 213 */               childType = OpChainChildTypeEnum.OP;
/*     */             }
/*     */           }
/* 216 */           catch (ClassNotFoundException ex) {
/* 217 */             logger_.error("The operation class [" + operationType.getClazz().getName() + "] is configured to be replaced by the operation class [" + replacement + "], which could not be found.", ex);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 224 */       switch (childType) {
/*     */         case OP_CHAIN_LINK:
/* 226 */           chainRoute = (OpChainRouteType)operationType1;
/* 227 */           chainRoute.setChainType(XstChainActionType.START.toString());
/* 228 */           iOpFactory2 = new RouteOpFactory();
/* 229 */           op = (IOperation)iOpFactory2.createOp(chainRoute);
/*     */           break;
/*     */ 
/*     */         
/*     */         case OP_CHAIN_REFERENCE:
/*     */         case OP_CHAIN_ROUTE:
/* 235 */           chainRoute = (OpChainRouteType)operationType1;
/* 236 */           iOpFactory2 = new RouteOpFactory();
/* 237 */           op = (IOperation)iOpFactory2.createOp(chainRoute);
/*     */           break;
/*     */ 
/*     */         
/*     */         case OPERATION:
/*     */         case OP:
/* 243 */           operationType2 = operationType1;
/* 244 */           opfactory = new OpFactory<>();
/* 245 */           op = opfactory.createOp(operationType2);
/*     */           break;
/*     */ 
/*     */         
/*     */         case VALIDATION_OP:
/* 250 */           validationOpType = (ValidationOpType)operationType1;
/* 251 */           iOpFactory1 = new ValidationOpFactory<>();
/* 252 */           op = (IOperation)iOpFactory1.createOp(validationOpType);
/*     */           break;
/*     */ 
/*     */         
/*     */         case PROMPT_OP:
/* 257 */           promptOpType = (PromptOpType)operationType1;
/* 258 */           iOpFactory = new PromptOpFactory<>();
/* 259 */           op = (IOperation)iOpFactory.createOp(promptOpType);
/*     */           break;
/*     */ 
/*     */         
/*     */         case WORKER_OP:
/* 264 */           opType = (WorkerOpType)operationType1;
/* 265 */           opFactory = new WorkerOpFactory<>();
/* 266 */           op = (IOperation)opFactory.createOp(opType);
/*     */           break;
/*     */ 
/*     */         
/*     */         default:
/* 271 */           throw new UnsupportedOperationException(childType + " is not a supported OpChain child element type.");
/*     */       } 
/*     */ 
/*     */       
/* 275 */       if (op != null) {
/* 276 */         StubPlaceholderOp stubPlaceholderOp; if (op.getClass().getAnnotation(StubbedOperation.class) != null) {
/* 277 */           stubPlaceholderOp = new StubPlaceholderOp(op);
/*     */         }
/* 279 */         result.addOp((IOperation)stubPlaceholderOp);
/*     */       } 
/*     */     } 
/*     */     
/* 283 */     long t2 = System.currentTimeMillis();
/*     */     
/* 285 */     if (logger_.isDebugEnabled()) {
/* 286 */       logger_.debug("THE CONSTRUCTION TIME IS " + (t2 - t1) + " for chain: " + argChainConfig.getName());
/*     */     }
/*     */     
/* 289 */     return result;
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
/*     */ 
/*     */   
/*     */   protected class OpChainConfigReloader
/*     */     extends NamedXmlConfigReloader
/*     */   {
/*     */     protected String getConfigName() {
/* 313 */       return "OpChainConfig";
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void reloadConfig() {
/* 319 */       OpChainFactory.this.init();
/*     */     }
/*     */   }
/*     */   
/*     */   protected class OpFactory<C extends OperationType, T extends IOperation>
/*     */     implements IOpFactory<C, T> {
/*     */     public T createOp(C argOpConfig) {
/*     */       IOperation iOperation;
/* 327 */       T op = null;
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 332 */         Class<T> opClass = (argOpConfig.getClazz() != null) ? argOpConfig.getClazz() : getDefaultOpClass();
/* 333 */         iOperation = (IOperation)opClass.newInstance();
/*     */         
/* 335 */         iOperation.setSourceDescription(argOpConfig.getSourceDescription());
/* 336 */         iOperation.setRequired(argOpConfig.getRequired().booleanValue());
/* 337 */         iOperation.setBreakPoint(argOpConfig.getBreakpoint().booleanValue());
/* 338 */         iOperation.setLongRunning(argOpConfig.getLongRunning().booleanValue());
/*     */         
/* 340 */         if (!StringUtils.isEmpty(argOpConfig.getContextKey())) {
/* 341 */           iOperation.setContextDescriptor((IUIContextDescriptor)new UIContextDescriptor(argOpConfig.getContextKey()));
/*     */         }
/*     */         
/* 344 */         for (Parameter paramConfig : argOpConfig.getParameters()) {
/*     */           try {
/* 346 */             iOperation.setParameter(paramConfig.getName(), paramConfig.getValue());
/*     */           }
/* 348 */           catch (Exception ex) {
/* 349 */             OpChainFactory.logger_.error("CAUGHT EXCEPTION", ex);
/*     */           }
/*     */         
/*     */         } 
/* 353 */       } catch (ReflectiveOperationException ex) {
/* 354 */         OpChainFactory.logger_.error("An error occurred reflectively instantiating and manipulating the operation [" + argOpConfig
/* 355 */             .getClazz() + "].", ex);
/*     */       } 
/*     */       
/* 358 */       return (T)iOperation;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected Class<T> getDefaultOpClass() {
/* 368 */       return null;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected class PromptOpFactory<C extends PromptOpType, T extends IPromptOp>
/*     */     extends ValidationOpFactory<C, T>
/*     */   {
/*     */     public T createOp(C argOpConfig) {
/* 378 */       IPromptOp iPromptOp = (IPromptOp)super.createOp(argOpConfig);
/*     */       
/* 380 */       if (argOpConfig.getKey() != null) {
/* 381 */         iPromptOp.setPromptKey(argOpConfig.getKey());
/*     */       }
/*     */       
/* 384 */       return (T)iPromptOp;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected Class<T> getDefaultOpClass() {
/* 391 */       return (Class)PromptOp.class;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected class RouteOpFactory
/*     */     implements IOpFactory<OpChainRouteType, OpChainRouteOp>
/*     */   {
/*     */     public OpChainRouteOp createOp(OpChainRouteType argOpConfig) {
/* 401 */       List<OpChainChoice> choices = new ArrayList<>();
/*     */ 
/*     */       
/* 404 */       List<OpChainChoiceType> choiceConfigs = new ArrayList<>(argOpConfig.getChoices());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 410 */       if (argOpConfig.getChainKey() != null) {
/* 411 */         OpChainChoiceType choiceType = new OpChainChoiceType();
/* 412 */         choiceType.setChainKey(argOpConfig.getChainKey());
/* 413 */         choiceType.setChainType(argOpConfig.getChainType());
/* 414 */         choiceType.setCondition(argOpConfig.getCondition());
/* 415 */         choiceType.setFile(argOpConfig.getFile());
/* 416 */         choiceType.setLineNumber(argOpConfig.getLineNumber());
/* 417 */         choiceType.setColumnNumber(argOpConfig.getColumnNumber());
/*     */ 
/*     */         
/* 420 */         choiceConfigs.add(0, choiceType);
/*     */       } 
/*     */       
/* 423 */       for (OpChainChoiceType choiceConfig : choiceConfigs) {
/* 424 */         OpChainType choiceChain = OpChainFactory.this._chainConfigMap.get(OpChainKey.valueOf(choiceConfig.getChainKey()));
/*     */         
/* 426 */         if (choiceChain == null) {
/* 427 */           OpChainFactory.logger_.warn("An op chain route was configured for the chain key [" + choiceConfig.getChainKey() + "] but the chain does not exist. The chain will not be considered for routing. " + choiceConfig
/*     */               
/* 429 */               .getSourceDescription() + ".");
/*     */           
/*     */           continue;
/*     */         } 
/* 433 */         OpChainChoice choice = new OpChainChoice(OpChainKey.valueOf(choiceConfig.getChainKey()));
/* 434 */         choices.add(choice);
/*     */ 
/*     */         
/* 437 */         if (argOpConfig.getChainType() != null) {
/* 438 */           choice.setChainType(XstChainActionType.forName(argOpConfig.getChainType()));
/*     */         }
/*     */ 
/*     */         
/* 442 */         if (choiceConfig.getChainType() != null) {
/* 443 */           choice.setChainType(XstChainActionType.forName(choiceConfig.getChainType()));
/*     */         }
/*     */ 
/*     */         
/* 447 */         ChoiceConditionType conditionConfig = null;
/*     */         
/* 449 */         if (choiceConfig.getCondition() != null) {
/*     */ 
/*     */           
/* 452 */           conditionConfig = new ChoiceConditionType();
/* 453 */           conditionConfig.setFile(choiceConfig.getFile());
/* 454 */           conditionConfig.setLineNumber(choiceConfig.getLineNumber());
/* 455 */           conditionConfig.setColumnNumber(choiceConfig.getColumnNumber());
/* 456 */           String value = choiceConfig.getCondition();
/*     */ 
/*     */           
/* 459 */           if (value.startsWith("!")) {
/*     */             
/* 461 */             value = value.substring(1);
/* 462 */             Parameter parameter = new Parameter();
/* 463 */             parameter.setName("Invert");
/* 464 */             parameter.setValue("true");
/* 465 */             conditionConfig.getParameters().add(parameter);
/*     */           } 
/*     */           
/*     */           try {
/* 469 */             conditionConfig.setClazz(Class.forName(value));
/*     */           }
/* 471 */           catch (ClassNotFoundException ex) {
/* 472 */             OpChainFactory.logger_.error("The class [" + value + "] was configured for a run chain condition, but the class was not found.", ex);
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/* 477 */           conditionConfig = choiceConfig.getConditionElement();
/*     */         } 
/*     */ 
/*     */         
/* 481 */         if (conditionConfig != null) {
/*     */           try {
/* 483 */             RunChainCondition condition = conditionConfig.getClazz().newInstance();
/*     */             
/* 485 */             for (Parameter parameter : conditionConfig.getParameters()) {
/* 486 */               condition.setParameter(parameter.getName(), parameter.getValue());
/*     */             }
/*     */             
/* 489 */             choice.setRunCondition(condition);
/*     */           }
/* 491 */           catch (Exception ex) {
/* 492 */             OpChainFactory.logger_.error("An exception was caught attempting to instantiate the RunChainCondition class [" + conditionConfig
/* 493 */                 .getClazz() + "].", ex);
/*     */           } 
/*     */         }
/*     */       } 
/*     */       
/* 498 */       OpChainRouteOp op = new OpChainRouteOp(choices);
/* 499 */       op.setSourceDescription(argOpConfig.getSourceDescription());
/* 500 */       return op;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected class ValidationOpFactory<C extends ValidationOpType, T extends IValidationOp>
/*     */     extends OpFactory<C, T>
/*     */   {
/*     */     public T createOp(C argOpConfig) {
/* 509 */       IValidationOp iValidationOp = (IValidationOp)super.createOp(argOpConfig);
/* 510 */       String validationsBean = argOpConfig.getValidationsBean();
/*     */       
/* 512 */       if (validationsBean != null && !validationsBean.trim().isEmpty()) {
/*     */         try {
/* 514 */           ValidationRuleList ruleList = OpChainFactory.this._validationRuleListLocator.getRuleList(validationsBean);
/* 515 */           iValidationOp.setValidationRules(ruleList.getRules());
/*     */         }
/* 517 */         catch (NoSuchBeanDefinitionException ex) {
/* 518 */           OpChainFactory.logger_.error("Validation rules bean was specified with the bean name [" + validationsBean + "], but no such Spring bean defined! [" + argOpConfig
/* 519 */               .getSourceDescription() + "].", (Throwable)ex);
/*     */         } 
/*     */       }
/*     */       
/* 523 */       return (T)iValidationOp;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected Class<T> getDefaultOpClass() {
/* 530 */       return (Class)ValidationWithoutPromptOp.class;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected class WorkerOpFactory<C extends WorkerOpType, T extends IWorkerOp>
/*     */     extends OpFactory<C, T>
/*     */   {
/*     */     public T createOp(C argOpConfig) {
/* 539 */       IWorkerOp iWorkerOp = (IWorkerOp)super.createOp(argOpConfig);
/* 540 */       String workersBean = argOpConfig.getWorkersBean();
/*     */       
/* 542 */       if (workersBean != null && !workersBean.trim().isEmpty()) {
/*     */         try {
/* 544 */           WorkerList workerList = OpChainFactory.this._workerLocator.getWorkerList(workersBean);
/* 545 */           iWorkerOp.setWorkers(workerList.getWorkers());
/*     */         }
/* 547 */         catch (NoSuchBeanDefinitionException ex) {
/* 548 */           OpChainFactory.logger_.error("Workers bean was specified with the bean name [" + workersBean + "], but no such Spring bean is defined! [" + argOpConfig
/*     */               
/* 550 */               .getSourceDescription() + "].", (Throwable)ex);
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 555 */         OpChainFactory.logger_.warn("An operation was specified as a worker operation, but no workers bean was specified [" + argOpConfig
/* 556 */             .getSourceDescription() + "].");
/*     */       } 
/*     */       
/* 559 */       return (T)iWorkerOp;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected Class<T> getDefaultOpClass() {
/* 566 */       return (Class)SimpleDoWorkOp.class;
/*     */     }
/*     */   }
/*     */   
/*     */   protected static interface IOpFactory<C extends LocatableObject, T extends IOperation> {
/*     */     T createOp(C param1C);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\OpChainFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */