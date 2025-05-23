/*    */ package dtv.data2.access;
/*    */ 
/*    */ import dtv.util.ClassPathUtils;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.Collections;
/*    */ import java.util.Comparator;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
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
/*    */ 
/*    */ 
/*    */ public class ConfigKeyedDataFilter
/*    */ {
/*    */   public <R extends IHasConfigElement> Collection<R> filterResults(Collection<R> argElementsToFilter) {
/* 31 */     final Map<String, Integer> prioritizedConfigElements = ClassPathUtils.getPrioritizedConfigPathElements();
/*    */     
/* 33 */     prioritizedConfigElements.put("*", Integer.valueOf(-2147483648));
/*    */     
/* 35 */     List<R> sortedResults = new ArrayList<>(argElementsToFilter);
/*    */     
/* 37 */     Collections.sort(sortedResults, new Comparator<R>()
/*    */         {
/*    */           public int compare(R argO1, R argO2)
/*    */           {
/* 41 */             Integer priority1 = (Integer)prioritizedConfigElements.get(argO1.getConfigElement());
/* 42 */             Integer priority2 = (Integer)prioritizedConfigElements.get(argO2.getConfigElement());
/* 43 */             priority1 = Integer.valueOf((priority1 == null) ? Integer.MIN_VALUE : priority1.intValue());
/* 44 */             priority2 = Integer.valueOf((priority2 == null) ? Integer.MIN_VALUE : priority2.intValue());
/* 45 */             return priority1.compareTo(priority2);
/*    */           }
/*    */         });
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 56 */     Map<IObjectId, R> filteredResults = new HashMap<>();
/*    */     
/* 58 */     for (IHasConfigElement iHasConfigElement : sortedResults) {
/* 59 */       IObjectId id = iHasConfigElement.getObjectId();
/*    */       
/* 61 */       if (id instanceof IHasConfigElement) {
/* 62 */         IHasConfigElement configId = (IHasConfigElement)id;
/* 63 */         configId.setConfigElement((String)null);
/*    */       } 
/*    */       
/* 66 */       filteredResults.put(id, (R)iHasConfigElement);
/*    */     } 
/*    */     
/* 69 */     return filteredResults.values();
/*    */   }
/*    */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\ConfigKeyedDataFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */