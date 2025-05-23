/*    */ package dtv.xst.daocommon;
/*    */ 
/*    */ import dtv.data2.access.IDataModel;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.Comparator;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UnfilteredLineItemFilter
/*    */   implements ILineItemFilter
/*    */ {
/* 19 */   private Comparator<IDataModel> lineItemComparator_ = null;
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<? extends IDataModel> filter(List<? extends IDataModel> argTranLineItems) {
/* 25 */     List<? extends IDataModel> list = argTranLineItems;
/* 26 */     if (this.lineItemComparator_ != null) {
/* 27 */       list = new ArrayList<>(argTranLineItems);
/* 28 */       Collections.sort(list, this.lineItemComparator_);
/*    */     } 
/* 30 */     return list;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void setItemSortComparator(Comparator<IDataModel> argNewComparator) {
/* 36 */     this.lineItemComparator_ = argNewComparator;
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\daocommon\UnfilteredLineItemFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */