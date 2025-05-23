/*     */ package dtv.pos.framework.op;
/*     */ 
/*     */ import dtv.pos.common.FormKey;
/*     */ import dtv.pos.common.PromptKey;
/*     */ import dtv.pos.framework.action.type.XstDataActionKey;
/*     */ import dtv.pos.framework.form.config.FormViewConfig;
/*     */ import dtv.pos.framework.form.config.FormViewConfigHelper;
/*     */ import dtv.pos.framework.location.IRegion;
/*     */ import dtv.pos.framework.location.StoreLocationHelper;
/*     */ import dtv.pos.iframework.ILocationFactory;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.action.FormTabKey;
/*     */ import dtv.pos.iframework.action.IXstActionKey;
/*     */ import dtv.pos.iframework.action.IXstDataAction;
/*     */ import dtv.pos.iframework.event.IXstEvent;
/*     */ import dtv.pos.iframework.form.ICountryEditModel;
/*     */ import dtv.pos.iframework.form.IEditModel;
/*     */ import dtv.pos.iframework.op.IChangeCountryOp;
/*     */ import dtv.pos.iframework.op.IOpResponse;
/*     */ import dtv.pos.iframework.op.IOpState;
/*     */ import dtv.pos.iframework.op.IReversibleOp;
/*     */ import dtv.pos.iframework.ui.model.IFormModel;
/*     */ import dtv.pos.iframework.ui.model.IStationModel;
/*     */ import dtv.util.address.CountryCache;
/*     */ import dtv.util.address.ICountry;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import javax.inject.Inject;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractChangeCountryOp<EM extends IEditModel>
/*     */   extends AbstractFormOp<EM>
/*     */   implements IChangeCountryOp, IReversibleOp
/*     */ {
/*  40 */   private static final PromptKey COUNTRY_PROMPT = PromptKey.valueOf("PROMPT_COUNTRY_LIST");
/*  41 */   private static final PromptKey NO_COUNTRIES_PROMPT = PromptKey.valueOf("COUNTRY_LIST_NO_RESULTS");
/*     */   
/*  43 */   private static final IXstActionKey CHANGE_COUNTRY_ACTION = (IXstActionKey)XstDataActionKey.valueOf("CHANGE_COUNTRY");
/*     */ 
/*     */   
/*  46 */   private static final IXstActionKey CHANGE_COUNTRY_CANCEL = (IXstActionKey)XstDataActionKey.valueOf("CHANGE_COUNTRY_CANCEL");
/*  47 */   private final IOpState CHANGE_COUNTRY = new OpState("CHANGE_COUNTRY");
/*  48 */   private final IOpState AFTER_CHANGE_COUNTRY = new OpState("AFTER_CHANGE_COUNTRY");
/*     */   
/*     */   @Inject
/*     */   private FormViewConfigHelper _formConfigHelper;
/*     */   
/*     */   @Inject
/*     */   private ILocationFactory _locationFactory;
/*     */   
/*  56 */   private String _selectedCountry = null;
/*     */ 
/*     */ 
/*     */   
/*     */   public IOpResponse handleAfterChangeCountry(IXstEvent argEvent) {
/*  61 */     ICountry selectedCountry = (argEvent != null) ? (ICountry)argEvent.getData() : null;
/*     */ 
/*     */     
/*  64 */     ICountryEditModel cModel = (ICountryEditModel)getModel();
/*  65 */     String countryCode = (selectedCountry != null) ? selectedCountry.getCode() : getSelectedCountry();
/*     */     
/*  67 */     if (isCountryChangedExternally()) {
/*  68 */       countryCode = cModel.getCountry();
/*     */     }
/*     */     
/*  71 */     setSelectedCountry(countryCode);
/*     */     
/*  73 */     FormKey formKey = getFormKey();
/*     */     
/*  75 */     if (countryCode != null) {
/*  76 */       cModel.changeCountry(countryCode, !isCountryChangedExternally());
/*     */     }
/*     */     
/*  79 */     IStationModel sm = ((IModeController)this._modeProvider.get()).getStationModel();
/*  80 */     IFormModel oldForm = sm.getFormModel(sm.getPrimaryFormModelKey());
/*     */ 
/*     */     
/*  83 */     String currentTab = (oldForm.getSelectionModel() != null) ? oldForm.getSelectionModel().getSelectedTab() : null;
/*  84 */     FormTabKey requestedTabKey = (currentTab != null) ? FormTabKey.forName(currentTab) : null;
/*     */     
/*  86 */     cModel.setCountryChangedExternally(false);
/*  87 */     setOpState(this.AFTER_CHANGE_COUNTRY);
/*  88 */     return this.HELPER.getChangeFormResponse(formKey, (IEditModel)getModel(), getActionGroupKey(), isEditable(), requestedTabKey);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IOpResponse handleChangeCountry(IXstEvent argEvent) {
/*  95 */     ICountryEditModel model = (ICountryEditModel)getModel();
/*  96 */     Collection<IRegion> regions = StoreLocationHelper.getInstance().getRegions();
/*  97 */     List<ICountry> countries = new ArrayList<>();
/*     */     
/*  99 */     for (IRegion region : regions) {
/* 100 */       countries.addAll(Arrays.asList(region.getCountries()));
/*     */     }
/*     */ 
/*     */     
/* 104 */     ICountry current = CountryCache.makeCountry(model.getCountry(), null, 0);
/* 105 */     countries.remove(current);
/*     */     
/* 107 */     Collections.sort(countries, new Comparator<ICountry>()
/*     */         {
/*     */           public int compare(ICountry argCountryA, ICountry argCountryB) {
/* 110 */             return argCountryA.getCode().compareTo(argCountryB.getCode());
/*     */           }
/*     */         });
/*     */     
/* 114 */     setOpState(this.CHANGE_COUNTRY);
/*     */ 
/*     */     
/* 117 */     IOpResponse response = countries.isEmpty() ? this.HELPER.getPromptResponse(NO_COUNTRIES_PROMPT, new dtv.i18n.IFormattable[0]) : this.HELPER.getListPromptResponse(COUNTRY_PROMPT, countries.toArray(), new dtv.i18n.IFormattable[0]);
/*     */     
/* 119 */     return response;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IOpResponse handleOpReverse(IXstEvent argEvent) {
/* 125 */     setSelectedCountry((String)null);
/* 126 */     return this.HELPER.completeResponse();
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
/*     */   protected abstract FormKey getBaseFormKey();
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
/*     */   protected FormKey getFormKey() {
/* 151 */     String countryCode = getSelectedCountry();
/*     */     
/* 153 */     if (countryCode == null) {
/* 154 */       ICountryEditModel model = (ICountryEditModel)getModel();
/* 155 */       countryCode = model.getCountry();
/*     */     } 
/*     */ 
/*     */     
/* 159 */     if (countryCode == null) {
/* 160 */       countryCode = this._locationFactory.getStoreById(this._stationState.getRetailLocationId()).getCountry();
/*     */     }
/*     */     
/* 163 */     FormKey baseFormKey = getBaseFormKey();
/* 164 */     FormKey formKey = FormKey.valueOf(baseFormKey.toString() + "_" + countryCode);
/* 165 */     FormViewConfig formViewConfig = this._formConfigHelper.getFormViewConfig(formKey);
/*     */     
/* 167 */     if (formViewConfig == null)
/*     */     {
/* 169 */       formKey = baseFormKey;
/*     */     }
/*     */     
/* 172 */     return formKey;
/*     */   }
/*     */   
/*     */   protected String getSelectedCountry() {
/* 176 */     return this._selectedCountry;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse handleAfterDataAction(IXstEvent argEvent) {
/* 182 */     if (this.CHANGE_COUNTRY.equals(getOpState()) || isCountryChangedExternally()) {
/* 183 */       return handleAfterChangeCountry(argEvent);
/*     */     }
/*     */     
/* 186 */     return super.handleAfterDataAction(argEvent);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse handleDataAction(IXstDataAction argAction) {
/* 193 */     if (CHANGE_COUNTRY_ACTION.equals(argAction.getActionKey())) {
/* 194 */       return handleChangeCountry((IXstEvent)argAction);
/*     */     }
/* 196 */     if (this.CHANGE_COUNTRY.equals(getOpState()) && CHANGE_COUNTRY_CANCEL.equals(argAction.getActionKey())) {
/*     */ 
/*     */       
/* 199 */       setOpState(this.AFTER_REQUEST);
/* 200 */       return this.HELPER.getChangeFormResponse(getFormKey(), (IEditModel)getModel(), getActionGroupKey(), isEditable());
/*     */     } 
/*     */     
/* 203 */     return super.handleDataAction(argAction);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected IOpResponse handleInitialState() {
/* 210 */     setSelectedCountry((String)null);
/* 211 */     return super.handleInitialState();
/*     */   }
/*     */   
/*     */   protected void setSelectedCountry(String argCountry) {
/* 215 */     this._selectedCountry = argCountry;
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
/*     */   private final boolean isCountryChangedExternally() {
/* 230 */     if (getModel() instanceof ICountryEditModel) {
/* 231 */       ICountryEditModel cModel = (ICountryEditModel)getModel();
/* 232 */       return cModel.getCountryChangedExternally();
/*     */     } 
/*     */     
/* 235 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\op\AbstractChangeCountryOp.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */