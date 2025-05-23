/*    */ package dtv.logbuilder;
/*    */ 
/*    */ import dtv.xst.dao.trl.IRetailTransactionLineItem;
/*    */ import java.util.Comparator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TLogLineItemComparator
/*    */   implements Comparator<Object>
/*    */ {
/*    */   public int compare(Object o1, Object o2) {
/* 23 */     IRetailTransactionLineItem line1 = (IRetailTransactionLineItem)o1;
/* 24 */     IRetailTransactionLineItem line2 = (IRetailTransactionLineItem)o2;
/*    */     
/* 26 */     return line1.getTLogSequence() - line2.getTLogSequence();
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\logbuilder\TLogLineItemComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */