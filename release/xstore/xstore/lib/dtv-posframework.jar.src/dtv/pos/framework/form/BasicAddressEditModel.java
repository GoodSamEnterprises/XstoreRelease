/*     */ package dtv.pos.framework.form;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.framework.location.CountryValueWrapper;
/*     */ import dtv.pos.framework.location.StateWrapperFactory;
/*     */ import dtv.pos.iframework.form.ICardinality;
/*     */ import dtv.pos.iframework.form.ICountryEditModel;
/*     */ import dtv.pos.iframework.form.IValueWrapperFactory;
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
/*     */ 
/*     */ public abstract class BasicAddressEditModel
/*     */   extends BasicEditModel
/*     */   implements ICountryEditModel, IHasAddressFields
/*     */ {
/*  29 */   public static final Logger _logger = Logger.getLogger(BasicAddressEditModel.class);
/*     */ 
/*     */   
/*  32 */   private final IValueWrapperFactory _countryWrapperFactory = ValueWrapperFactory.makeWrapperFactory((Class)CountryValueWrapper.class);
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private IAddressFieldServiceFactory _addressFieldFactory;
/*     */   
/*     */   private String _state;
/*     */   
/*     */   private String _country;
/*     */ 
/*     */   
/*     */   public BasicAddressEditModel(IFormattable argModelName, IFormattable argModelDescription) {
/*  44 */     super(argModelName, argModelDescription);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void changeCountry(String argCountry, boolean argResetRelevantFields) {
/*  50 */     if (argCountry != null) {
/*  51 */       setValue("country", argCountry);
/*  52 */       initializeCountryFields();
/*  53 */       if (argResetRelevantFields) {
/*     */ 
/*     */         
/*  56 */         setValue("address1", null);
/*  57 */         setValue("address2", null);
/*  58 */         setValue("address3", null);
/*  59 */         setValue("address4", null);
/*  60 */         setValue("apartment", null);
/*  61 */         setValue("postalCode", null);
/*  62 */         setValue("city", null);
/*  63 */         setValue("state", null);
/*  64 */         setValue("neighborhood", null);
/*  65 */         setValue("county", null);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public final String getAddress1() {
/*  71 */     return getAddressFieldValue("address1");
/*     */   }
/*     */   
/*     */   public final String getAddress2() {
/*  75 */     return getAddressFieldValue("address2");
/*     */   }
/*     */   
/*     */   public final String getAddress3() {
/*  79 */     return getAddressFieldValue("address3");
/*     */   }
/*     */   
/*     */   public final String getAddress4() {
/*  83 */     return getAddressFieldValue("address4");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAddressField(String argValue) {
/*  89 */     if ("city".equals(argValue)) {
/*  90 */       return "city";
/*     */     }
/*  92 */     if ("state".equals(argValue)) {
/*  93 */       return "state";
/*     */     }
/*  95 */     if ("postalCode".equals(argValue)) {
/*  96 */       return "postalCode";
/*     */     }
/*  98 */     if ("country".equals(argValue)) {
/*  99 */       return "country";
/*     */     }
/* 101 */     if ("neighborhood".equals(argValue)) {
/* 102 */       return "neighborhood";
/*     */     }
/* 104 */     if ("county".equals(argValue)) {
/* 105 */       return "county";
/*     */     }
/*     */     
/* 108 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAddressMode() {
/* 114 */     return "DEFAULT";
/*     */   }
/*     */   
/*     */   public final String getApartment() {
/* 118 */     return getAddressFieldValue("apartment");
/*     */   }
/*     */   
/*     */   public final String getCity() {
/* 122 */     return getAddressFieldValue("city");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getCountry() {
/* 129 */     return this._country;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getCountryChangedExternally() {
/* 135 */     return false;
/*     */   }
/*     */   
/*     */   public final String getCounty() {
/* 139 */     return getAddressFieldValue("county");
/*     */   }
/*     */   
/*     */   public final String getNeighborhood() {
/* 143 */     return getAddressFieldValue("neighborhood");
/*     */   }
/*     */   
/*     */   public final String getPostalCode() {
/* 147 */     return getAddressFieldValue("postalCode");
/*     */   }
/*     */   
/*     */   public final String getState() {
/* 151 */     return this._state;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void initializeCountryFields() {
/* 158 */     StateWrapperFactory stateWrapper = new StateWrapperFactory(getCountry());
/*     */     
/* 160 */     addField(EditModelField.makeFieldDef(this, "state", String.class, 2, null, ICardinality.OPTIONAL, null, null, (IValueWrapperFactory)stateWrapper, null));
/*     */ 
/*     */     
/* 163 */     addField(EditModelField.makeFieldDef(this, "country", String.class, 2, null, ICardinality.OPTIONAL, null, null, this._countryWrapperFactory, null));
/*     */ 
/*     */     
/* 166 */     this._addressFieldFactory.createAddressFieldService(getAddressMode()).registerModel(this, this);
/*     */   }
/*     */   
/*     */   public final void setAddress1(String argAddress1) {
/* 170 */     setValue("address1", argAddress1);
/*     */   }
/*     */   
/*     */   public final void setAddress2(String argAddress2) {
/* 174 */     setValue("address2", argAddress2);
/*     */   }
/*     */   
/*     */   public final void setAddress3(String argAddress3) {
/* 178 */     setValue("address3", argAddress3);
/*     */   }
/*     */   
/*     */   public final void setAddress4(String argAddress4) {
/* 182 */     setValue("address4", argAddress4);
/*     */   }
/*     */   
/*     */   public final void setApartment(String argApartment) {
/* 186 */     setValue("apartment", argApartment);
/*     */   }
/*     */   
/*     */   public final void setCity(String argCity) {
/* 190 */     setValue("city", argCity);
/*     */   }
/*     */   
/*     */   public final void setCountry(String argCountry) {
/* 194 */     this._country = argCountry;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCountryChangedExternally(boolean argChanged) {}
/*     */ 
/*     */   
/*     */   public final void setCounty(String argCounty) {
/* 202 */     setValue("county", argCounty);
/*     */   }
/*     */   
/*     */   public final void setNeighborhood(String argNeighborhood) {
/* 206 */     setValue("neighborhood", argNeighborhood);
/*     */   }
/*     */   
/*     */   public final void setPostalCode(String argPostalCode) {
/* 210 */     setValue("postalCode", argPostalCode);
/*     */   }
/*     */   
/*     */   public final void setState(String argState) {
/* 214 */     this._state = argState;
/*     */   }
/*     */   
/*     */   protected IAddressFieldServiceFactory getAddressFieldServiceFactory() {
/* 218 */     return this._addressFieldFactory;
/*     */   }
/*     */   
/*     */   protected String getAddressFieldValue(String argFieldKey) {
/* 222 */     return (getValue(argFieldKey) != null) ? getValue(argFieldKey).toString() : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isDynamicFieldCapable() {
/* 228 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\BasicAddressEditModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */