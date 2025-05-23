/*     */ package dtv.xst.dao.itm.impl;
/*     */ 
/*     */ import dtv.data2.access.IDataModel;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.ObjectManager;
/*     */ import dtv.data2.access.impl.AbstractDataModelWithPropertyImpl;
/*     */ import dtv.xst.dao.crm.IParty;
/*     */ import dtv.xst.dao.crm.PartyId;
/*     */ import dtv.xst.dao.itm.IItem;
/*     */ import dtv.xst.dao.itm.IWarranty;
/*     */ import dtv.xst.dao.itm.IWarrantyItem;
/*     */ import dtv.xst.dao.itm.IWarrantyModel;
/*     */ import dtv.xst.dao.itm.IWarrantyProperty;
/*     */ import dtv.xst.dao.itm.ItemId;
/*     */ import dtv.xst.dao.loc.RetailLocationId;
/*     */ import dtv.xst.dao.trl.ISaleReturnLineItem;
/*     */ import dtv.xst.dao.trl.IWarrantyLineItem;
/*     */ import dtv.xst.dao.trl.RetailTransactionLineItemId;
/*     */ import dtv.xst.dao.trn.PosTransactionId;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class WarrantyBaseModel
/*     */   extends AbstractDataModelWithPropertyImpl<IWarrantyProperty>
/*     */   implements IWarranty, IWarrantyModel
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private transient ObjectManager manager;
/*     */   private transient IParty customer;
/*     */   private transient IWarrantyItem warrantyPlan;
/*     */   private transient IWarrantyItem warrantyItem;
/*     */   private transient IWarrantyLineItem warrantyLineItem;
/*     */   private transient IItem coveredItem;
/*     */   private transient ISaleReturnLineItem coveredLineItem;
/*     */   
/*     */   public IItem getCoveredItem() {
/*  40 */     String coveredItemId = getCoveredItemId();
/*     */     
/*  42 */     if (this.coveredItem == null && coveredItemId != null) {
/*  43 */       ItemId itemId = new ItemId();
/*  44 */       itemId.setItemId(coveredItemId);
/*  45 */       this.coveredItem = (IItem)ObjectManager.getInstance().getManagedObject((IObjectId)itemId);
/*     */     } 
/*     */     
/*  48 */     return this.coveredItem;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ISaleReturnLineItem getCoveredLineItem() {
/*  54 */     Date coveredLineBusinessDate = getCoveredLineBusinessDate();
/*     */     
/*  56 */     if (this.coveredLineItem == null && coveredLineBusinessDate != null) {
/*  57 */       if (this.manager == null) {
/*  58 */         this.manager = ObjectManager.getInstance();
/*     */       }
/*  60 */       RetailTransactionLineItemId id = new RetailTransactionLineItemId();
/*     */       
/*  62 */       id.setBusinessDate(getCoveredLineBusinessDate());
/*  63 */       id.setRetailLocationId(Long.valueOf(getCoveredLineRtlLocId()));
/*  64 */       id.setWorkstationId(Long.valueOf(getCoveredLineWkstnId()));
/*  65 */       id.setTransactionSequence(Long.valueOf(getCoveredLineTransSeq()));
/*  66 */       id.setRetailTransactionLineItemSequence(Integer.valueOf(getCoveredLineTransLineItemSeq()));
/*     */       
/*  68 */       this.coveredLineItem = (ISaleReturnLineItem)this.manager.getManagedObject((IObjectId)id);
/*     */     } 
/*  70 */     return this.coveredLineItem;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IParty getCustomer() {
/*  76 */     long partyId = getPartyId();
/*     */     
/*  78 */     if (this.customer == null && partyId > 0L) {
/*  79 */       if (this.manager == null) {
/*  80 */         this.manager = ObjectManager.getInstance();
/*     */       }
/*  82 */       PartyId id = new PartyId();
/*  83 */       id.setPartyId(Long.valueOf(getPartyId()));
/*     */       
/*  85 */       this.customer = (IParty)this.manager.getManagedObject((IObjectId)id);
/*     */     } 
/*  87 */     return this.customer;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RetailLocationId getRetailLocationIdObject() {
/*  93 */     RetailLocationId id = new RetailLocationId();
/*  94 */     id.setRetailLocationId(Long.valueOf(getWarrantyLineRtlLocId()));
/*     */     
/*  96 */     return id;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PosTransactionId getWarrantyIssueTransactionId() {
/* 102 */     PosTransactionId id = null;
/*     */     
/* 104 */     if (getWarrantyIssueDate() != null) {
/* 105 */       id = new PosTransactionId();
/*     */       
/* 107 */       id.setBusinessDate(getWarrantyIssueDate());
/* 108 */       id.setRetailLocationId(Long.valueOf(getWarrantyLineRtlLocId()));
/* 109 */       id.setWorkstationId(Long.valueOf(getWarrantyLineWkstnId()));
/* 110 */       id.setTransactionSequence(Long.valueOf(getWarrantyLineTransSeq()));
/*     */     } 
/* 112 */     return id;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IWarrantyItem getWarrantyItem() {
/* 118 */     String warrantyItemId = getWarrantyItemId();
/*     */     
/* 120 */     if (this.warrantyItem == null && warrantyItemId != null) {
/* 121 */       ItemId itemId = new ItemId();
/* 122 */       itemId.setItemId(warrantyItemId);
/*     */       
/* 124 */       this
/* 125 */         .warrantyItem = (IWarrantyItem)ObjectManager.getInstance().getManagedObject((IObjectId)itemId);
/*     */     } 
/* 127 */     return this.warrantyItem;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IWarrantyLineItem getWarrantyLineItem() {
/* 133 */     Date warrantyLineBusinessDate = getWarrantyLineBusinessDate();
/*     */     
/* 135 */     if (this.warrantyLineItem == null && warrantyLineBusinessDate != null) {
/* 136 */       if (this.manager == null) {
/* 137 */         this.manager = ObjectManager.getInstance();
/*     */       }
/* 139 */       RetailTransactionLineItemId id = new RetailTransactionLineItemId();
/*     */       
/* 141 */       id.setBusinessDate(getWarrantyLineBusinessDate());
/* 142 */       id.setRetailLocationId(Long.valueOf(getWarrantyLineRtlLocId()));
/* 143 */       id.setWorkstationId(Long.valueOf(getWarrantyLineWkstnId()));
/* 144 */       id.setTransactionSequence(Long.valueOf(getWarrantyLineTransSeq()));
/* 145 */       id.setRetailTransactionLineItemSequence(Integer.valueOf(getWarrantyLineTransLineItemSeq()));
/*     */       
/* 147 */       this.warrantyLineItem = (IWarrantyLineItem)this.manager.getManagedObject((IObjectId)id);
/*     */     } 
/* 149 */     return this.warrantyLineItem;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public IWarrantyItem getWarrantyPlan() {
/* 155 */     String warrantyPlanId = getWarrantyPlanId();
/*     */     
/* 157 */     if (this.warrantyPlan == null && warrantyPlanId != null) {
/* 158 */       ItemId itemId = new ItemId();
/* 159 */       itemId.setItemId(warrantyPlanId);
/*     */       
/* 161 */       this
/* 162 */         .warrantyPlan = (IWarrantyItem)ObjectManager.getInstance().getManagedObject((IObjectId)itemId);
/*     */     } 
/* 164 */     return this.warrantyPlan;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCoveredItem(IItem argCoveredItem) {
/* 170 */     if (argCoveredItem != null) {
/* 171 */       ObjectManager.getInstance().manageObject((IDataModel)argCoveredItem);
/* 172 */       setCoveredItemId(argCoveredItem.getItemId());
/* 173 */       this.coveredItem = argCoveredItem;
/*     */     } else {
/*     */       
/* 176 */       setCoveredItemId((String)null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCoveredItemId(String argItemId) {
/* 183 */     this.coveredItem = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCoveredLineBusinessDate(Date argBusinessDate) {
/* 189 */     this.coveredLineItem = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCoveredLineItem(ISaleReturnLineItem argCoveredLineItem) {
/* 195 */     if (argCoveredLineItem != null) {
/* 196 */       setCoveredItem(argCoveredLineItem.getItem());
/* 197 */       setCoveredLineBusinessDate(argCoveredLineItem.getBusinessDate());
/* 198 */       setCoveredLineRtlLocId(argCoveredLineItem.getRetailLocationId());
/* 199 */       setCoveredLineWkstnId(argCoveredLineItem.getWorkstationId());
/* 200 */       setCoveredLineTransSeq(argCoveredLineItem.getTransactionSequence());
/* 201 */       setCoveredLineTransLineItemSeq(argCoveredLineItem.getRetailTransactionLineItemSequence());
/*     */       
/* 203 */       if (this.manager == null) {
/* 204 */         this.manager = ObjectManager.getInstance();
/*     */       }
/*     */       
/* 207 */       this.manager.manageObject((IDataModel)argCoveredLineItem);
/*     */     } else {
/*     */       
/* 210 */       setCoveredLineBusinessDate((Date)null);
/* 211 */       setCoveredLineRtlLocId(0L);
/* 212 */       setCoveredLineWkstnId(0L);
/* 213 */       setCoveredLineTransSeq(0L);
/* 214 */       setCoveredLineTransLineItemSeq(0);
/*     */     } 
/*     */     
/* 217 */     this.coveredLineItem = argCoveredLineItem;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCoveredLineRtlLocId(long argRetailLocId) {
/* 223 */     this.coveredLineItem = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCoveredLineTransLineItemSeq(int argLineItemSeq) {
/* 229 */     this.coveredLineItem = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCoveredLineTransSeq(long argTransSeq) {
/* 235 */     this.coveredLineItem = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCoveredLineWkstnId(long argWorkstationId) {
/* 241 */     this.coveredLineItem = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustomer(IParty argCustomer) {
/* 247 */     if (argCustomer != null) {
/* 248 */       setPartyId(argCustomer.getPartyId());
/* 249 */       setCustomerId(argCustomer.getCustomerId());
/*     */       
/* 251 */       if (this.manager == null) {
/* 252 */         this.manager = ObjectManager.getInstance();
/*     */       }
/* 254 */       this.manager.manageObject((IDataModel)argCustomer);
/*     */     } else {
/*     */       
/* 257 */       setPartyId(0L);
/* 258 */       setCustomerId(null);
/*     */     } 
/* 260 */     this.customer = argCustomer;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPartyId(long argPartyId) {
/* 266 */     this.customer = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWarrantyItem(IWarrantyItem argWarrantyItem) {
/* 272 */     if (argWarrantyItem != null) {
/* 273 */       ObjectManager.getInstance().manageObject((IDataModel)argWarrantyItem);
/* 274 */       setWarrantyItemId(argWarrantyItem.getItemId());
/* 275 */       this.warrantyItem = argWarrantyItem;
/*     */     } else {
/*     */       
/* 278 */       setWarrantyItemId((String)null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWarrantyItemId(String argItemId) {
/* 285 */     this.warrantyItem = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWarrantyLineBusinessDate(Date argBusinessDate) {
/* 291 */     this.warrantyLineItem = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWarrantyLineItem(IWarrantyLineItem argWarrantyLineItem) {
/* 297 */     if (argWarrantyLineItem != null) {
/* 298 */       setWarrantyItem((IWarrantyItem)argWarrantyLineItem.getItem());
/* 299 */       setWarrantyLineBusinessDate(argWarrantyLineItem.getBusinessDate());
/* 300 */       setWarrantyLineRtlLocId(argWarrantyLineItem.getRetailLocationId());
/* 301 */       setWarrantyLineWkstnId(argWarrantyLineItem.getWorkstationId());
/* 302 */       setWarrantyLineTransSeq(argWarrantyLineItem.getTransactionSequence());
/* 303 */       setWarrantyLineTransLineItemSeq(argWarrantyLineItem.getRetailTransactionLineItemSequence());
/*     */       
/* 305 */       if (this.manager == null) {
/* 306 */         this.manager = ObjectManager.getInstance();
/*     */       }
/*     */       
/* 309 */       this.manager.manageObject((IDataModel)argWarrantyLineItem);
/*     */     } else {
/*     */       
/* 312 */       setWarrantyLineBusinessDate((Date)null);
/* 313 */       setWarrantyLineRtlLocId(0L);
/* 314 */       setWarrantyLineWkstnId(0L);
/* 315 */       setWarrantyLineTransSeq(0L);
/* 316 */       setWarrantyLineTransLineItemSeq(0);
/*     */     } 
/*     */     
/* 319 */     this.warrantyLineItem = argWarrantyLineItem;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWarrantyLineRtlLocId(long argRetailLocId) {
/* 325 */     this.warrantyLineItem = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWarrantyLineTransLineItemSeq(int argLineItemSeq) {
/* 331 */     this.warrantyLineItem = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWarrantyLineTransSeq(long argWarrantyLineTransSeq) {
/* 337 */     this.warrantyLineItem = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWarrantyLineWkstnId(long argWorkstationId) {
/* 343 */     this.warrantyLineItem = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWarrantyPlan(IWarrantyItem argWarrantyPlan) {
/* 349 */     if (argWarrantyPlan != null) {
/* 350 */       ObjectManager.getInstance().manageObject((IDataModel)argWarrantyPlan);
/* 351 */       setWarrantyPlanId(argWarrantyPlan.getItemId());
/* 352 */       this.warrantyPlan = argWarrantyPlan;
/*     */     } else {
/*     */       
/* 355 */       setWarrantyPlanId((String)null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWarrantyPlanId(String argPlanId) {
/* 362 */     this.warrantyPlan = null;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\itm\impl\WarrantyBaseModel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */