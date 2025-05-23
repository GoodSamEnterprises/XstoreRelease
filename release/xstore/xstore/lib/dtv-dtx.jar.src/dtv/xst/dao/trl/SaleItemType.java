/*     */ package dtv.xst.dao.trl;
/*     */ 
/*     */ import dtv.xst.dao.itm.IItem;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ public class SaleItemType
/*     */ {
/*  21 */   private static final Logger logger_ = Logger.getLogger(SaleItemType.class);
/*     */ 
/*     */   
/*  24 */   public static final SaleItemType SALE = new SaleItemType("SALE", true, new InclusionTester()
/*     */       {
/*     */         protected boolean isCompatibleImpl(IItem argItem)
/*     */         {
/*  28 */           return !argItem.getOptions().isItemNotAvailable();
/*     */         }
/*     */       });
/*     */ 
/*     */   
/*  33 */   public static final SaleItemType RETURN = new SaleItemType("RETURN", true, new InclusionTester()
/*     */       {
/*     */         protected boolean isCompatibleImpl(IItem argItem)
/*     */         {
/*  37 */           return !argItem.getOptions().getNotReturnable();
/*     */         }
/*     */       });
/*     */ 
/*     */   
/*  42 */   public static final SaleItemType LAYAWAY = new SaleItemType("LAYAWAY", false, new InclusionTester()
/*     */       {
/*     */         protected boolean isCompatibleImpl(IItem argItem)
/*     */         {
/*  46 */           return !argItem.getOptions().getDisallowLayaway();
/*     */         }
/*     */       })
/*     */     {
/*     */       public boolean allowsTransactionDiscount()
/*     */       {
/*  52 */         return false;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*  57 */   public static final SaleItemType SPECIAL_ORDER = new SaleItemType("SPECIAL_ORDER", false, new InclusionTester()
/*     */       {
/*     */         
/*     */         protected boolean isCompatibleImpl(IItem argItem)
/*     */         {
/*  62 */           return !argItem.getOptions().getDisallowSpecialOrder();
/*     */         }
/*     */       })
/*     */     {
/*     */       public boolean allowsTransactionDiscount()
/*     */       {
/*  68 */         return false;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*  73 */   public static final SaleItemType WORK_ORDER = new SaleItemType("WORK_ORDER", false, new InclusionTester()
/*     */       {
/*     */         protected boolean isCompatibleImpl(IItem argItem)
/*     */         {
/*  77 */           return !argItem.getOptions().getDisallowWorkOrder();
/*     */         }
/*     */       })
/*     */     {
/*     */       public boolean allowsTransactionDiscount()
/*     */       {
/*  83 */         return false;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*  88 */   public static final SaleItemType SEND_SALE = new SaleItemType("SEND_SALE", true, new InclusionTester()
/*     */       {
/*     */         protected boolean isCompatibleImpl(IItem argItem)
/*     */         {
/*  92 */           return !argItem.getOptions().getDisallowSendSale();
/*     */         }
/*     */       });
/*     */ 
/*     */   
/*  97 */   public static final SaleItemType ORDER = new SaleItemType("ORDER", false, new InclusionTester()
/*     */       {
/*     */         public boolean isCompatibleImpl(IItem argItem) {
/* 100 */           return !argItem.getOptions().getDisallowOrder();
/*     */         }
/*     */       });
/*     */ 
/*     */   
/*     */   private static Map<String, SaleItemType> values_;
/*     */   
/*     */   private final String name_;
/*     */   
/*     */   private final String translationKey_;
/*     */   private final IItemTester tester_;
/*     */   private final boolean isFinal_;
/*     */   
/*     */   public static SaleItemType forName(String argName) {
/* 114 */     if (argName == null) {
/* 115 */       return null;
/*     */     }
/* 117 */     SaleItemType found = values_.get(argName.trim().toUpperCase());
/* 118 */     if (found == null) {
/* 119 */       logger_.warn("There is no instance of [" + SaleItemType.class.getName() + "] named [" + argName + "].", new Throwable("STACK TRACE"));
/*     */     }
/*     */     
/* 122 */     return found;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SaleItemType[] getValues() {
/* 131 */     return (SaleItemType[])values_.values().toArray((Object[])new SaleItemType[values_.size()]);
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
/*     */   protected SaleItemType(String argName, boolean argIsFinal, IItemTester argTester) {
/* 148 */     String PREFIX_KEY = "_dtv.xst.dao.trl.SaleItemType.";
/*     */     
/* 150 */     this.name_ = argName;
/* 151 */     this.translationKey_ = "_dtv.xst.dao.trl.SaleItemType." + argName.trim().toUpperCase();
/* 152 */     this.isFinal_ = argIsFinal;
/* 153 */     this.tester_ = argTester;
/*     */     
/* 155 */     if (values_ == null) {
/* 156 */       values_ = new HashMap<>();
/*     */     }
/*     */     
/* 159 */     values_.put(this.name_, this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean allowsTransactionDiscount() {
/* 169 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 178 */     return this.name_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTranslationKey() {
/* 186 */     return this.translationKey_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCompatible(IItem argItem) {
/* 197 */     return this.tester_.isCompatible(argItem);
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
/*     */   public boolean isFinal() {
/* 209 */     return this.isFinal_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matches(String argName) {
/* 219 */     return this.name_.equalsIgnoreCase(argName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static interface IItemTester
/*     */   {
/*     */     boolean isCompatible(IItem param1IItem);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static abstract class InclusionTester
/*     */     implements IItemTester
/*     */   {
/*     */     public boolean isCompatible(IItem argItem) {
/* 245 */       return (argItem == null) ? false : isCompatibleImpl(argItem);
/*     */     }
/*     */     
/*     */     protected abstract boolean isCompatibleImpl(IItem param1IItem);
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\dao\trl\SaleItemType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */