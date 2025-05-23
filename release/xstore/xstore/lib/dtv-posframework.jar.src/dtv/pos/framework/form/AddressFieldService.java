/*     */ package dtv.pos.framework.form;
/*     */ 
/*     */ import dtv.event.Eventor;
/*     */ import dtv.event.IEventSource;
/*     */ import dtv.event.eventor.DefaultEventor;
/*     */ import dtv.pos.iframework.form.IEditModel;
/*     */ import dtv.pos.iframework.form.IEditModelField;
/*     */ import dtv.util.ObjectUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.address.AddressService;
/*     */ import dtv.util.address.IAddressServiceConstants;
/*     */ import dtv.util.address.IAddressServiceInstance;
/*     */ import dtv.util.address.IState;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AddressFieldService
/*     */   implements IAddressFieldService
/*     */ {
/*  30 */   private static final Logger logger_ = Logger.getLogger(AddressFieldService.class);
/*     */   private IAddressServiceInstance service_;
/*     */   
/*     */   private static IAddressServiceInstance getAddressServiceInstance(String argMode, List<String> argSettings, AddressService argAddressService) {
/*  34 */     byte[] settings = new byte[argSettings.size()];
/*  35 */     int index = 0;
/*     */     try {
/*  37 */       for (String setting : argSettings) {
/*  38 */         Field f = ObjectUtils.getDeclaredFieldIgnoreCase(IAddressServiceConstants.class, setting);
/*  39 */         settings[index] = f.getByte(null);
/*  40 */         index++;
/*     */       }
/*     */     
/*  43 */     } catch (Exception ex) {
/*  44 */       logger_.fatal("Invalid settings", ex);
/*     */     } 
/*     */     
/*  47 */     return argAddressService.getAddressServiceInstance(argMode, settings);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final Map<String, EditModelFieldDefinitionData> _editModelFieldDefinitionData;
/*     */   
/*     */   private String currentField_;
/*     */   
/*     */   private boolean listenersEnabled_;
/*     */   
/*  58 */   protected Eventor events_ = (Eventor)new DefaultEventor((IEventSource)this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AddressFieldService(IAddressServiceInstance argServiceInstance) {
/*  66 */     this.service_ = argServiceInstance;
/*  67 */     this._editModelFieldDefinitionData = new HashMap<>();
/*  68 */     this.listenersEnabled_ = true;
/*     */     
/*  70 */     if (this.service_ != null) {
/*  71 */       this.service_.registerListener(new String[] { "country", "state", "postalCode", "city" }, this);
/*     */     }
/*     */   }
/*     */   
/*     */   public AddressFieldService(String argMode, List<String> argSettings, AddressService argAddressService) {
/*  76 */     this(getAddressServiceInstance(argMode, argSettings, argAddressService));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyChangedField(String argField, String argNewValue) {
/*  82 */     if (!argField.equals(this.currentField_) && this._editModelFieldDefinitionData.get(argField) != null) {
/*  83 */       EditModelFieldDefinitionData data = this._editModelFieldDefinitionData.get(argField);
/*  84 */       data.getParentModel().setValue(data.getFieldDefinition().getFieldKey(), argNewValue);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyFieldChanged(String argFieldKey, Object argNewValue) {
/*  91 */     notifyFieldChangedImpl(argFieldKey, argNewValue, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyInvalidField(String argField, String argInvalidData) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerField(IEditModel argParentModel, IEditModelField argFieldDef, String argServiceKey) {
/* 104 */     EditModelFieldDefinitionData data = new EditModelFieldDefinitionData(argParentModel, argFieldDef);
/* 105 */     this._editModelFieldDefinitionData.put(argServiceKey, data);
/*     */ 
/*     */ 
/*     */     
/* 109 */     if (!argFieldDef.isReadOnly()) {
/* 110 */       notifyFieldChangedImpl(argServiceKey, argParentModel.getValue(argFieldDef.getFieldKey()), false);
/*     */     }
/*     */     
/* 113 */     switch (argServiceKey) {
/*     */       case "country":
/* 115 */         argFieldDef.setEnumeratedPossibleValues(Arrays.asList(this.service_.getArrayForField("country")));
/*     */         break;
/*     */       
/*     */       case "state":
/* 119 */         if (this.service_.getCountry() != null) {
/* 120 */           List<Object> tempList = Arrays.asList(this.service_.getArrayForField("state"));
/* 121 */           argFieldDef.setEnumeratedPossibleValues(tempList);
/*     */         } 
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void registerModel(IEditModel argParentModel, IHasAddressFields argOwner) {
/* 129 */     registerModelImpl(argParentModel, argOwner.getAddressField("city"), "city");
/*     */     
/* 131 */     registerModelImpl(argParentModel, argOwner.getAddressField("state"), "state");
/*     */     
/* 133 */     registerModelImpl(argParentModel, argOwner.getAddressField("postalCode"), "postalCode");
/*     */     
/* 135 */     registerModelImpl(argParentModel, argOwner.getAddressField("country"), "country");
/*     */     
/* 137 */     registerModelImpl(argParentModel, argOwner.getAddressField("neighborhood"), "neighborhood");
/*     */     
/* 139 */     registerModelImpl(argParentModel, argOwner.getAddressField("county"), "county");
/*     */   }
/*     */ 
/*     */   
/*     */   protected IAddressServiceInstance getAddressService() {
/* 144 */     return this.service_;
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
/*     */   protected void notifyFieldChangedImpl(String argFieldKey, Object argNewValue, boolean argApplySettings) {
/* 159 */     if (this.listenersEnabled_) {
/*     */       try {
/* 161 */         this.listenersEnabled_ = false;
/* 162 */         this.currentField_ = argFieldKey;
/* 163 */         String oldValue = this.service_.getField(this.currentField_);
/* 164 */         String newValue = (argNewValue == null) ? null : argNewValue.toString();
/*     */         
/* 166 */         if (!StringUtils.equivalentIgnoreCase(oldValue, newValue)) {
/* 167 */           this.service_.setField(argFieldKey, newValue, argApplySettings);
/*     */           
/* 169 */           if ("country".equals(this.currentField_) && this._editModelFieldDefinitionData.get("state") != null) {
/* 170 */             List<Object> tempList = Arrays.asList(this.service_.getArrayForField("state"));
/*     */             
/* 172 */             String currentState = this.service_.getField("state");
/* 173 */             ((EditModelFieldDefinitionData)this._editModelFieldDefinitionData.get("state")).getFieldDefinition()
/* 174 */               .setEnumeratedPossibleValues(tempList);
/*     */             
/* 176 */             checkOldStateValue(currentState, tempList);
/*     */           } 
/*     */         } 
/*     */       } finally {
/*     */         
/* 181 */         this.currentField_ = null;
/* 182 */         this.listenersEnabled_ = true;
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   protected void registerModelImpl(IEditModel argParentModel, String argFieldName, String argFieldKey) {
/* 188 */     if (argFieldName != null) {
/* 189 */       argParentModel.registerFieldService(argFieldName, this, argFieldKey);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void checkOldStateValue(String currentState, List<Object> tempList) {
/*     */     try {
/* 198 */       if (!StringUtils.isEmpty(currentState) && tempList != null) {
/* 199 */         for (Object state : tempList) {
/* 200 */           if (state == null) {
/*     */             continue;
/*     */           }
/*     */           
/* 204 */           if (state instanceof IState) {
/* 205 */             if (currentState.equals(((IState)state).getCode())) {
/* 206 */               this.service_.setField("state", currentState, true);
/*     */               break;
/*     */             } 
/*     */             continue;
/*     */           } 
/* 211 */           logger_.warn("Unexpected class type of " + state.getClass().getName());
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */     }
/* 217 */     catch (Exception e) {
/* 218 */       logger_.error("Unexpected error checking the old state value.", e);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected class EditModelFieldDefinitionData
/*     */   {
/*     */     private IEditModelField _fieldDefinition;
/*     */     private IEditModel _parentModel;
/*     */     
/*     */     public EditModelFieldDefinitionData(IEditModel argParentModel, IEditModelField argFieldDef) {
/* 228 */       this._parentModel = argParentModel;
/* 229 */       this._fieldDefinition = argFieldDef;
/*     */     }
/*     */     
/*     */     public IEditModelField getFieldDefinition() {
/* 233 */       return this._fieldDefinition;
/*     */     }
/*     */     
/*     */     public IEditModel getParentModel() {
/* 237 */       return this._parentModel;
/*     */     }
/*     */     
/*     */     public void setFieldDefinition(IEditModelField argFieldDefinition) {
/* 241 */       this._fieldDefinition = argFieldDefinition;
/*     */     }
/*     */     
/*     */     public void setParentModel(IEditModel argParentModel) {
/* 245 */       this._parentModel = argParentModel;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\AddressFieldService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */