/*    */ package dtv.pos.framework.event;
/*    */ 
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
/*    */ public class XstEventMatcherComparator
/*    */   implements Comparator<IXstEventMatcher>
/*    */ {
/*    */   public int compare(IXstEventMatcher argO1, IXstEventMatcher argO2) {
/* 19 */     int p1 = argO1.priority();
/* 20 */     int p2 = argO2.priority();
/* 21 */     return (p1 < p2) ? -1 : ((p1 == p2) ? 0 : 1);
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\event\XstEventMatcherComparator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */