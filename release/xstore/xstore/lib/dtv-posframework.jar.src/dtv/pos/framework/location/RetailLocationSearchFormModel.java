/*     */ package dtv.pos.framework.location;
/*     */ 
/*     */ import dtv.i18n.IFormattable;
/*     */ import dtv.pos.framework.form.BasicEditModel;
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
/*     */ public class RetailLocationSearchFormModel
/*     */   extends BasicEditModel
/*     */ {
/*     */   public static final String RETAIL_LOCATION_ID = "retailLocationId";
/*     */   public static final String ADDRESS = "address";
/*     */   public static final String CITY = "city";
/*     */   public static final String STATE = "state";
/*     */   public static final String POSTAL_CODE = "postalCode";
/*     */   public static final String COUNTRY = "country";
/*     */   public static final String PHONE_NUMBER = "phoneNumber";
/*     */   public static final String MANAGER_NAME = "managerName";
/*     */   public static final String DESCRIPTION = "description";
/*     */   private String retailLocationId_;
/*     */   private String address_;
/*     */   private String city_;
/*     */   private String state_;
/*     */   private String postalCode_;
/*     */   private String country_;
/*     */   private String phoneNumber_;
/*     */   private String managerName_;
/*     */   private String description_;
/*     */   
/*     */   public RetailLocationSearchFormModel() {
/*  39 */     this(FF.getTranslatable("_retailLocSearchFormTitle"), FF.getTranslatable("_retailLocSearchFormMsg"));
/*     */   }
/*     */   
/*     */   public RetailLocationSearchFormModel(IFormattable argModelName, IFormattable argModelDescription) {
/*  43 */     super(argModelName, argModelDescription);
/*     */     
/*  45 */     addField("retailLocationId", String.class);
/*  46 */     addField("address", String.class);
/*  47 */     addField("city", String.class);
/*  48 */     addField("state", String.class);
/*  49 */     addField("postalCode", String.class);
/*  50 */     addField("country", String.class);
/*  51 */     addField("phoneNumber", String.class);
/*  52 */     addField("managerName", String.class);
/*  53 */     addField("description", String.class);
/*     */     
/*  55 */     initializeFieldState();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAddress() {
/*  62 */     return this.address_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCity() {
/*  69 */     return this.city_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCountry() {
/*  76 */     return this.country_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescription() {
/*  83 */     return this.description_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getManagerName() {
/*  90 */     return this.managerName_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPhoneNumber() {
/*  97 */     return this.phoneNumber_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPostalCode() {
/* 104 */     return this.postalCode_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRetailLocationId() {
/* 111 */     return this.retailLocationId_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getState() {
/* 118 */     return this.state_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAddress(String argAddress) {
/* 125 */     this.address_ = argAddress;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCity(String argCity) {
/* 132 */     this.city_ = argCity;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCountry(String argCountry) {
/* 139 */     this.country_ = argCountry;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescription(String argDescription) {
/* 146 */     this.description_ = argDescription;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setManagerName(String argManagerName) {
/* 153 */     this.managerName_ = argManagerName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPhoneNumber(String argPhoneNumber) {
/* 160 */     this.phoneNumber_ = argPhoneNumber;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPostalCode(String argPostalCode) {
/* 167 */     this.postalCode_ = argPostalCode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationId(String argRetailLocationId) {
/* 174 */     this.retailLocationId_ = argRetailLocationId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setState(String argState) {
/* 181 */     this.state_ = argState;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\location\RetailLocationSearchFormModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */