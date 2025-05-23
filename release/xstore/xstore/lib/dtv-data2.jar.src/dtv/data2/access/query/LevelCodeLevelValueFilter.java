/*     */ package dtv.data2.access.query;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.IOverridableOrgHierarchyResult;
/*     */ import dtv.data2.access.IQueryResult;
/*     */ import dtv.util.CompositeObject;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.inject.Inject;
/*     */ import org.apache.commons.collections.CollectionUtils;
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
/*     */ public class LevelCodeLevelValueFilter
/*     */   implements IResultFilter
/*     */ {
/*     */   @Inject
/*     */   private IPersistenceDefaults _persistenceDefaults;
/*     */   
/*     */   public Collection<? extends IQueryResult> filter(List<? extends IQueryResult> argResultsToFilter, Map<String, Object> argQueryParams) {
/*  35 */     final Map<String, Integer> prioritizedOrgNodes = new HashMap<>();
/*     */     
/*  37 */     List<IOverridableOrgHierarchyResult> sortedResults = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  44 */     if (argResultsToFilter.isEmpty() || 
/*  45 */       !(argResultsToFilter.get(0) instanceof IOverridableOrgHierarchyResult))
/*     */     {
/*  47 */       return argResultsToFilter;
/*     */     }
/*     */ 
/*     */     
/*  51 */     for (IQueryResult result : argResultsToFilter) {
/*  52 */       sortedResults.add((IOverridableOrgHierarchyResult)result);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  59 */     int priority = 1;
/*     */     
/*  61 */     if (argQueryParams.containsKey("orgNodeList")) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  66 */       List<String> orgNodeList = (List<String>)argQueryParams.get("orgNodeList");
/*     */       
/*  68 */       if (!CollectionUtils.isEmpty(orgNodeList)) {
/*  69 */         for (String orgNode : orgNodeList) {
/*  70 */           prioritizedOrgNodes.put(orgNode, Integer.valueOf(priority));
/*  71 */           priority++;
/*     */         } 
/*     */       }
/*     */     } else {
/*     */       
/*  76 */       for (CompositeObject.TwoPiece<String, String> orgNode : (Iterable<CompositeObject.TwoPiece<String, String>>)this._persistenceDefaults.getOrgHierarchyAncestry()) {
/*  77 */         String nodeString = (String)orgNode.a() + ":" + (String)orgNode.b();
/*  78 */         prioritizedOrgNodes.put(nodeString, Integer.valueOf(priority));
/*  79 */         priority++;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  85 */     Collections.sort(sortedResults, new Comparator<IOverridableOrgHierarchyResult>()
/*     */         {
/*     */           public int compare(IOverridableOrgHierarchyResult argO1, IOverridableOrgHierarchyResult argO2) {
/*  88 */             String nodeString1 = argO1.getLevelCode() + ":" + argO1.getLevelValue();
/*  89 */             String nodeString2 = argO2.getLevelCode() + ":" + argO2.getLevelValue();
/*  90 */             Integer priority1 = (Integer)prioritizedOrgNodes.get(nodeString1);
/*  91 */             Integer priority2 = (Integer)prioritizedOrgNodes.get(nodeString2);
/*  92 */             priority1 = Integer.valueOf((priority1 == null) ? Integer.MIN_VALUE : priority1.intValue());
/*  93 */             priority2 = Integer.valueOf((priority2 == null) ? Integer.MIN_VALUE : priority2.intValue());
/*     */ 
/*     */             
/*  96 */             return -priority1.compareTo(priority2);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 103 */     Map<IObjectId, IOverridableOrgHierarchyResult> filteredResults = new HashMap<>();
/*     */     
/* 105 */     for (IOverridableOrgHierarchyResult result : sortedResults) {
/* 106 */       filteredResults.put(result.getFilteringObjectId(), result);
/*     */     }
/*     */     
/* 109 */     return (Collection)filteredResults.values();
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\query\LevelCodeLevelValueFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */