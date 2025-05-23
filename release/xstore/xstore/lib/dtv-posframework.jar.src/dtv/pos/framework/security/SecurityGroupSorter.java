/*    */ package dtv.pos.framework.security;
/*    */ 
/*    */ import dtv.xst.dao.sec.IGroup;
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
/*    */ 
/*    */ public class SecurityGroupSorter
/*    */   implements Comparator<IGroup>
/*    */ {
/*    */   public int compare(IGroup argO1, IGroup argO2) {
/* 24 */     return (argO1.getGroupRank() != argO2.getGroupRank()) ? (argO1
/* 25 */       .getGroupRank() - argO2.getGroupRank()) : (argO1
/* 26 */       .getBitmapPosition() - argO2.getBitmapPosition());
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\security\SecurityGroupSorter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */