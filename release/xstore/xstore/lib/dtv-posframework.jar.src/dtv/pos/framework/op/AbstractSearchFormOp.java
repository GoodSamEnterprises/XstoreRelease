/*     */ package dtv.pos.framework.op;
/*     */ 
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.IQueryResult;
/*     */ import dtv.data2.access.IQueryResultList;
/*     */ import dtv.data2.access.ObjectNotFoundException;
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.pos.common.FormKey;
/*     */ import dtv.pos.common.PromptKey;
/*     */ import dtv.pos.framework.action.type.XstDataActionKey;
/*     */ import dtv.pos.iframework.action.DataActionGroupKey;
/*     */ import dtv.pos.iframework.action.IXstActionKey;
/*     */ import dtv.pos.iframework.action.IXstDataAction;
/*     */ import dtv.pos.iframework.event.IXstEvent;
/*     */ import dtv.pos.iframework.form.IEditModel;
/*     */ import dtv.pos.iframework.op.IOpResponse;
/*     */ import dtv.pos.iframework.op.IOpState;
/*     */ import dtv.util.IKeyedValue;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.ConfigUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
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
/*     */ 
/*     */ 
/*     */ public abstract class AbstractSearchFormOp<QR extends IQueryResult, M extends IDataModel, EM extends IEditModel>
/*     */   extends AbstractChangeCountryOp<EM>
/*     */ {
/*     */   private static final String PARAM_CLEAR_ON_RETRY = "CLEAR_ON_RETRY";
/*     */   private static final String PARAM_SHOW_LIST_IF_ONE = "ShowListIfOne";
/*  47 */   private static final Logger logger_ = Logger.getLogger(AbstractSearchFormOp.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean _searchCancelled = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  61 */   protected final IOpState SHOWING_ERROR_PROMPT = new OpState("SHOWING_ERROR_PROMPT");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  66 */   protected final IOpState SHOWING_LIST = new OpState("SHOWING_LIST");
/*     */ 
/*     */   
/*     */   private boolean _clearOnRetry = false;
/*     */ 
/*     */   
/*     */   private boolean _showListIfOne;
/*     */ 
/*     */   
/*     */   public AbstractSearchFormOp() {
/*  76 */     this._showListIfOne = ConfigurationMgr.showListsIfOne();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canceling() {
/*  82 */     return (getOpState() != this.SHOWING_LIST);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParameter(String argName, String argValue) {
/*  88 */     if ("ShowListIfOne".equalsIgnoreCase(argName)) {
/*  89 */       this._showListIfOne = ConfigUtils.toBoolean(argValue).booleanValue();
/*     */     }
/*  91 */     else if ("CLEAR_ON_RETRY".equalsIgnoreCase(argName)) {
/*  92 */       this._clearOnRetry = ConfigUtils.toBoolean(argValue).booleanValue();
/*     */     } else {
/*     */       
/*  95 */       super.setParameter(argName, argValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean displaySearchResultsAsFullScreen() {
/* 106 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected DataActionGroupKey getActionGroupKey() {
/* 112 */     return DataActionGroupKey.DEFAULT;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected FormKey getBaseFormKey() {
/* 118 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected PromptKey getNoCriteriaPrompt() {
/* 127 */     return PromptKey.valueOf("GENERIC_NO_SEARCH_CRITERIA");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract PromptKey getNoResultsPromptKey();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected PromptKey getNoSecurityAccess() {
/* 144 */     return PromptKey.valueOf("LIMITED_ACCESS_SECURITY");
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
/*     */   protected IOpResponse getSearchResultsPrompt(List<QR> argResults, IFormattable argMessage) {
/* 157 */     PromptKey promptKey = getSearchResultsPromptKey();
/* 158 */     List<IFormattable> promptArgs = getSearchResultsPromptArgs(argResults, argMessage);
/*     */     
/* 160 */     return this.HELPER.getListPromptResponse(promptKey, argResults.toArray(), null, 
/* 161 */         displaySearchResultsAsFullScreen(), promptArgs.<IFormattable>toArray(new IFormattable[0]));
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
/*     */   protected List<IFormattable> getSearchResultsPromptArgs(List<QR> argSearchResults, IFormattable argDefault) {
/* 173 */     String dataSourceName = ((IQueryResult)argSearchResults.get(0)).getDataSource();
/* 174 */     IFormattable message = argDefault;
/*     */     
/* 176 */     if (dataSourceName != null) {
/* 177 */       message = this._formattables.getLiteral(dataSourceName);
/*     */     }
/*     */     
/* 180 */     List<IFormattable> args = new ArrayList<>();
/* 181 */     args.add(message);
/*     */     
/* 183 */     return args;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract PromptKey getSearchResultsPromptKey();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected M getSelectedResult() {
/* 195 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse handleAfterDataAction(IXstEvent argEvent) {
/* 201 */     if (getOpState() == this.SHOWING_ERROR_PROMPT) {
/* 202 */       setOpState(null);
/*     */     }
/* 204 */     return super.handleAfterDataAction(argEvent);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse handleBeforeDataAction(IXstEvent argAction) {
/* 211 */     return (getSelectedResult() != null) ? this.HELPER.completeResponse() : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse handleDataAction(IXstDataAction argAction) {
/* 217 */     IXstActionKey actionKey = argAction.getActionKey();
/*     */     
/* 219 */     if (actionKey == XstDataActionKey.ACCEPT) {
/* 220 */       if (getOpState() == this.SHOWING_LIST) {
/* 221 */         return handleListSelection((IXstEvent)argAction);
/*     */       }
/* 223 */       if (getOpState() == this.SHOWING_ERROR_PROMPT) {
/*     */         try {
/* 225 */           if (this._clearOnRetry) {
/* 226 */             EM model = getModel();
/* 227 */             model.revertChanges();
/*     */           }
/*     */         
/* 230 */         } catch (Exception ex) {
/* 231 */           logger_.warn("CAUGHT EXCEPTION", ex);
/*     */         } 
/*     */         
/* 234 */         setOpState(null);
/* 235 */         return null;
/*     */       } 
/*     */     } 
/*     */     
/* 239 */     return super.handleDataAction(argAction);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse handleExit() {
/* 245 */     if (getOpState() == this.SHOWING_LIST) {
/*     */ 
/*     */       
/* 248 */       this._searchCancelled = true;
/*     */ 
/*     */       
/* 251 */       if (this._clearOnRetry) {
/* 252 */         setOpState(null);
/* 253 */         return handleOpExec((IXstEvent)null);
/*     */       } 
/*     */       
/* 256 */       return handleInitialState();
/*     */     } 
/*     */     
/* 259 */     return this.HELPER.silentErrorResponse();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse handleFormResponse(IXstEvent argEvent) {
/* 267 */     return handleSearch(getModel().getChanges());
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
/*     */   protected IOpResponse handleListSelection(IXstEvent argEvent) {
/* 279 */     Object selectedResult = argEvent.getData();
/*     */     
/* 281 */     if (selectedResult instanceof IQueryResult) {
/* 282 */       return handleSetSelection((QR)selectedResult);
/*     */     }
/*     */ 
/*     */     
/* 286 */     setOpState(this.AFTER_REQUEST);
/* 287 */     return handleOpExec((IXstEvent)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse handleNoResultFound() {
/* 297 */     setOpState(this.SHOWING_ERROR_PROMPT);
/* 298 */     return this.HELPER.getPromptResponse(getNoResultsPromptKey(), null, getFormKey(), new IFormattable[0]);
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
/*     */   protected IOpResponse handleSearch(Collection<IKeyedValue<String, ?>> argFields) {
/* 310 */     PromptKey noCriteriaPrompt = getNoCriteriaPrompt();
/* 311 */     boolean criteriaRequired = requireCriteria();
/*     */     
/* 313 */     if (criteriaRequired && noCriteriaPrompt == null) {
/* 314 */       logger_.error("MUST IMPLEMENT getNoCriteriaPrompt() OR OVERRIDE requireCriteria() TO RETURN false");
/* 315 */       return this.HELPER.errorNotifyResponse();
/*     */     } 
/*     */ 
/*     */     
/* 319 */     boolean continueSearch = false;
/*     */     
/* 321 */     if (!criteriaRequired) {
/* 322 */       continueSearch = true;
/*     */     } else {
/*     */       
/* 325 */       for (IKeyedValue<String, ?> field : argFields) {
/* 326 */         if (StringUtils.nonNull(field.getValue()).trim().length() != 0) {
/* 327 */           continueSearch = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 334 */     if (!continueSearch && criteriaRequired) {
/* 335 */       setOpState(this.SHOWING_ERROR_PROMPT);
/* 336 */       return this.HELPER.getPromptResponse(noCriteriaPrompt, null, getFormKey(), new IFormattable[0]);
/*     */     } 
/*     */ 
/*     */     
/* 340 */     IQueryResultList<QR> res = null;
/* 341 */     boolean limitReached = false;
/*     */     
/*     */     try {
/* 344 */       res = runQueryWrapResults(argFields);
/*     */       
/* 346 */       if (res != null) {
/* 347 */         limitReached = res.isQueryLimitReached();
/*     */       }
/*     */     }
/* 350 */     catch (ObjectNotFoundException objectNotFoundException) {}
/*     */ 
/*     */ 
/*     */     
/* 354 */     if (logger_.isDebugEnabled()) {
/* 355 */       logger_.debug("found " + ((res == null) ? "0" : Integer.valueOf(res.size())) + " items:" + res);
/*     */     }
/*     */ 
/*     */     
/* 359 */     if (res == null || res.isEmpty()) {
/* 360 */       return handleNoResultFound();
/*     */     }
/*     */     
/* 363 */     if (res.size() == 1 && !showListIfOne()) {
/* 364 */       return handleSetSelection((QR)res.get(0));
/*     */     }
/*     */ 
/*     */     
/* 368 */     setOpState(this.SHOWING_LIST);
/* 369 */     String limitMessageKey = limitReached ? "_queryLimitShort" : "";
/* 370 */     IFormattable limitMessage = this._formattables.getSimpleFormattable(limitMessageKey);
/* 371 */     return getSearchResultsPrompt((List<QR>)res, limitMessage);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse handleSetSelection(QR argSelected) {
/* 382 */     IOpResponse response = this.HELPER.completeResponse();
/*     */ 
/*     */     
/* 385 */     M loadedObject = retrieveResult(argSelected.getObjectId());
/*     */ 
/*     */     
/* 388 */     if (loadedObject == null) {
/* 389 */       return this.HELPER.getErrorResponse(this._formattables.getSimpleFormattable("_abstractSearchItemNotFound"));
/*     */     }
/*     */ 
/*     */     
/* 393 */     setSelectedResult(loadedObject);
/*     */     
/* 395 */     return response;
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
/*     */   protected boolean hasEverBeenCancelled(boolean argReset) {
/* 408 */     boolean hasBeenCancelled = this._searchCancelled;
/*     */     
/* 410 */     if (hasBeenCancelled && argReset) {
/* 411 */       this._searchCancelled = false;
/*     */     }
/*     */     
/* 414 */     return hasBeenCancelled;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean requireCriteria() {
/* 423 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected M retrieveResult(IObjectId argObjectId) {
/*     */     try {
/* 434 */       return (M)DataFactory.getObjectById(argObjectId);
/*     */     }
/* 436 */     catch (ObjectNotFoundException ex) {
/* 437 */       logger_.debug(ex);
/* 438 */       return null;
/*     */     } 
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
/*     */   protected abstract IQueryResultList<QR> runQueryWrapResults(Collection<IKeyedValue<String, ?>> paramCollection);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void setSelectedResult(M paramM);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean showListIfOne() {
/* 470 */     return this._showListIfOne;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\AbstractSearchFormOp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */