/*     */ package dtv.xst.dao.cat.impl;
/*     */ 
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*     */ import dtv.xst.dao.cat.ICustomerAccount;
/*     */ import dtv.xst.dao.cat.ICustomerAccountJournal;
/*     */ import dtv.xst.dao.cat.ICustomerAccountModel;
/*     */ import dtv.xst.dao.cat.ICustomerAccountNote;
/*     */ import dtv.xst.dao.cat.ICustomerAccountProperty;
/*     */ import dtv.xst.dao.crm.IParty;
/*     */ import dtv.xst.dao.crm.PartyId;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class CustomerAccountBaseModel
/*     */   extends AbstractDataModelWithPropertyImpl<ICustomerAccountProperty>
/*     */   implements ICustomerAccount, ICustomerAccountModel
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private transient IParty party_;
/*     */   
/*     */   public void addCustomerAccountNote(ICustomerAccountNote argCustomerAccountNote) {
/*  30 */     synchronized (this) {
/*  31 */       argCustomerAccountNote.setNoteSequence((getCustAccountNotes().size() + 1));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<? extends ICustomerAccountJournal> getLatestJournals() {
/*  41 */     List<ICustomerAccountJournal> journals = new ArrayList<>(getJournals());
/*     */     
/*  43 */     journals.sort((a, b) -> (int)(b.getJournalSequence() - a.getJournalSequence()));
/*  44 */     return journals;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IParty getParty() {
/*  50 */     if (this.party_ == null && getDAO_().getPartyId() != null) {
/*  51 */       PartyId id = new PartyId();
/*  52 */       id.setPartyId(getDAO_().getPartyId());
/*     */       
/*  54 */       this.party_ = (IParty)DataFactory.getObjectByIdNoThrow((IObjectId)id);
/*     */     } 
/*     */     
/*  57 */     return this.party_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRetailLocationAddress1() {
/*  66 */     return (getRetailLocation() == null) ? null : getRetailLocation().getAddress1();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRetailLocationAddress2() {
/*  75 */     return (getRetailLocation() == null) ? null : getRetailLocation().getAddress2();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRetailLocationAddress3() {
/*  84 */     return (getRetailLocation() == null) ? null : getRetailLocation().getAddress3();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRetailLocationAddress4() {
/*  93 */     return (getRetailLocation() == null) ? null : getRetailLocation().getAddress4();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRetailLocationApartment() {
/* 102 */     return (getRetailLocation() == null) ? null : getRetailLocation().getApartment();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRetailLocationCity() {
/* 111 */     return (getRetailLocation() == null) ? null : getRetailLocation().getCity();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRetailLocationCountry() {
/* 120 */     return (getRetailLocation() == null) ? null : getRetailLocation().getCountry();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRetailLocationPostalCode() {
/* 129 */     return (getRetailLocation() == null) ? null : getRetailLocation().getPostalCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRetailLocationState() {
/* 138 */     return (getRetailLocation() == null) ? null : getRetailLocation().getState();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRetailLocationStoreManager() {
/* 147 */     return (getRetailLocation() == null) ? null : getRetailLocation().getStoreManager();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRetailLocationStoreName() {
/* 156 */     return (getRetailLocation() == null) ? null : getRetailLocation().getStoreName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRetailLocationTelephone1() {
/* 165 */     return (getRetailLocation() == null) ? null : getRetailLocation().getTelephone1();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRetailLocationTelephone2() {
/* 174 */     return (getRetailLocation() == null) ? null : getRetailLocation().getTelephone2();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRetailLocationTelephone3() {
/* 183 */     return (getRetailLocation() == null) ? null : getRetailLocation().getTelephone3();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRetailLocationTelephone4() {
/* 192 */     return (getRetailLocation() == null) ? null : getRetailLocation().getTelephone4();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void restoreFromJournal(ICustomerAccountJournal argJournal) {
/* 198 */     if (argJournal != null) {
/* 199 */       setAccountBalance(argJournal.getAccountBalance());
/* 200 */       setCustIdentityTypeCode(argJournal.getCustIdentityTypeCode());
/* 201 */       setPartyId(argJournal.getPartyId());
/* 202 */       setRetailLocationId(argJournal.getRetailLocationId());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void saveToJournal(ICustomerAccountJournal argJournal) {
/* 209 */     if (argJournal != null) {
/* 210 */       argJournal.setAccountBalance(getAccountBalance());
/* 211 */       argJournal.setCustIdentityTypeCode(getCustIdentityTypeCode());
/* 212 */       argJournal.setPartyId(getPartyId());
/* 213 */       argJournal.setRetailLocationId(getRetailLocationId());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParty(IParty argParty) {
/* 220 */     this.party_ = argParty;
/*     */     
/* 222 */     if (argParty != null) {
/* 223 */       getDAO_().setPartyId(Long.valueOf(argParty.getPartyId()));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationAddress1(String argAddress1) {
/* 233 */     if (getRetailLocation() != null) {
/* 234 */       getRetailLocation().setAddress1(argAddress1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationAddress2(String argAddress2) {
/* 244 */     if (getRetailLocation() != null) {
/* 245 */       getRetailLocation().setAddress2(argAddress2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationAddress3(String argAddress3) {
/* 255 */     if (getRetailLocation() != null) {
/* 256 */       getRetailLocation().setAddress3(argAddress3);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationAddress4(String argAddress4) {
/* 266 */     if (getRetailLocation() != null) {
/* 267 */       getRetailLocation().setAddress4(argAddress4);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationApartment(String argApartment) {
/* 277 */     if (getRetailLocation() != null) {
/* 278 */       getRetailLocation().setApartment(argApartment);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationCity(String argCity) {
/* 288 */     if (getRetailLocation() != null) {
/* 289 */       getRetailLocation().setCity(argCity);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationCountry(String argCountry) {
/* 299 */     if (getRetailLocation() != null) {
/* 300 */       getRetailLocation().setCountry(argCountry);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationPostalCode(String argPostalCode) {
/* 310 */     if (getRetailLocation() != null) {
/* 311 */       getRetailLocation().setPostalCode(argPostalCode);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationState(String argState) {
/* 321 */     if (getRetailLocation() != null) {
/* 322 */       getRetailLocation().setState(argState);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationStoreManager(String argStoreManager) {
/* 332 */     if (getRetailLocation() != null) {
/* 333 */       getRetailLocation().setStoreManager(argStoreManager);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationStoreName(String argStoreName) {
/* 343 */     if (getRetailLocation() != null) {
/* 344 */       getRetailLocation().setStoreName(argStoreName);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationTelephone1(String argTelephone1) {
/* 354 */     if (getRetailLocation() != null) {
/* 355 */       getRetailLocation().setTelephone1(argTelephone1);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationTelephone2(String argTelephone2) {
/* 365 */     if (getRetailLocation() != null) {
/* 366 */       getRetailLocation().setTelephone2(argTelephone2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationTelephone3(String argTelephone3) {
/* 376 */     if (getRetailLocation() != null) {
/* 377 */       getRetailLocation().setTelephone3(argTelephone3);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRetailLocationTelephone4(String argTelephone4) {
/* 387 */     if (getRetailLocation() != null) {
/* 388 */       getRetailLocation().setTelephone4(argTelephone4);
/*     */     }
/*     */   }
/*     */   
/*     */   private CustomerAccountDAO getDAO_() {
/* 393 */     return (CustomerAccountDAO)this._daoImpl;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\cat\impl\CustomerAccountBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */