/*     */ package dtv.data2.access.query;
/*     */ 
/*     */ import dtv.data2.IPersistenceDefaults;
/*     */ import dtv.data2.access.impl.daogen.OrgHierarchyTables;
/*     */ import dtv.util.CompositeObject;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
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
/*     */ public class OrgHierarchySqlDecorator
/*     */   extends AbstractTargetedDataSqlDecorator
/*     */ {
/*     */   private static final String COL_ORG_CODE = "org_code";
/*     */   private static final String COL_ORG_VALUE = "org_value";
/*     */   private static final String NODE_FIELD_DELIM = "::";
/*     */   static final String NODE_FIELD_DELIM_EXT = ":";
/*     */   @Inject
/*     */   private IPersistenceDefaults _persistenceDefaults;
/*     */   
/*     */   protected final String getOrgHierarchyInArgs(List<CompositeObject.TwoPiece<String, String>> argOrgNodes) {
/*  48 */     String orgHierarchyInArgs = null;
/*     */     
/*  50 */     if (!argOrgNodes.isEmpty()) {
/*  51 */       List<String> orgHierPairs = new ArrayList<>(argOrgNodes.size());
/*     */       
/*  53 */       for (CompositeObject.TwoPiece<String, String> elem : argOrgNodes) {
/*  54 */         orgHierPairs.add((String)elem.a() + "::" + (String)elem.b());
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  60 */       orgHierarchyInArgs = SqlQueryBuilder.toSqlInClauseArgs(orgHierPairs);
/*     */     } 
/*  62 */     return orgHierarchyInArgs;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String getReplacementSql(String argTableName, Map<String, Object> argQueryParams) {
/*  68 */     List<CompositeObject.TwoPiece<String, String>> requestNodes = getRequestOrgNodes(argQueryParams);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  76 */     List<CompositeObject.TwoPiece<String, String>> orgNodes = CollectionUtils.isNotEmpty(requestNodes) ? requestNodes : this._persistenceDefaults.getOrgHierarchyAncestry();
/*     */     
/*  78 */     String orgHierInArgs = getOrgHierarchyInArgs(orgNodes);
/*     */     
/*  80 */     if (StringUtils.isEmpty(orgHierInArgs)) {
/*  81 */       return argTableName;
/*     */     }
/*     */     
/*  84 */     StringBuilder newSql = new StringBuilder();
/*  85 */     newSql.append("(SELECT * FROM ").append(argTableName).append(" WHERE (org_code||'::'||org_value) IN (");
/*     */ 
/*     */     
/*  88 */     newSql.append(orgHierInArgs);
/*  89 */     newSql.append("))");
/*     */     
/*  91 */     return newSql.toString();
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
/*     */   protected List<CompositeObject.TwoPiece<String, String>> getRequestOrgNodes(Map<String, Object> argParams) {
/* 103 */     if (argParams == null || argParams.isEmpty()) {
/* 104 */       return Collections.emptyList();
/*     */     }
/*     */     
/* 107 */     String orgCode = null;
/* 108 */     String orgValue = null;
/* 109 */     List<CompositeObject.TwoPiece<String, String>> orgNodes = Collections.emptyList();
/*     */     
/* 111 */     for (String key : argParams.keySet()) {
/* 112 */       if (key.toLowerCase().contains("orgcode")) {
/* 113 */         orgCode = (String)argParams.get(key); continue;
/*     */       } 
/* 115 */       if (key.toLowerCase().contains("orgvalue")) {
/* 116 */         orgValue = (String)argParams.get(key); continue;
/*     */       } 
/* 118 */       if (key.toLowerCase().contains("orgnodes")) {
/* 119 */         orgNodes = (List<CompositeObject.TwoPiece<String, String>>)argParams.get(key); continue;
/*     */       } 
/* 121 */       if (key.toLowerCase().contains("orgnodelist")) {
/*     */ 
/*     */ 
/*     */         
/* 125 */         List<String> orgNodeList = (List<String>)argParams.get(key);
/* 126 */         if (!CollectionUtils.isEmpty(orgNodeList)) {
/* 127 */           orgNodes = new ArrayList<>(orgNodeList.size());
/*     */           
/* 129 */           for (String orgNodePair : orgNodeList) {
/* 130 */             String[] orgNodeSplit = orgNodePair.split(":");
/* 131 */             if (orgNodeSplit != null && orgNodeSplit.length == 2) {
/* 132 */               orgNodes.add(CompositeObject.make(orgNodeSplit[0], orgNodeSplit[1]));
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 141 */     return (!StringUtils.isEmpty(orgCode) && !StringUtils.isEmpty(orgValue) && CollectionUtils.isEmpty(orgNodes)) ? 
/* 142 */       Collections.<CompositeObject.TwoPiece<String, String>>singletonList(CompositeObject.make(orgCode, orgValue)) : orgNodes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Collection<String> getTablesToDecorate() {
/* 149 */     return OrgHierarchyTables.getOrgHierarchyTables();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isDecoratable(String argSqlStatement, Map<String, Object> argQueryParams) {
/* 158 */     boolean superIsDecoratable = super.isDecoratable(argSqlStatement, argQueryParams);
/*     */     
/* 160 */     boolean ignorePresent = (argQueryParams != null && argQueryParams.containsKey("IGNORE_ORG_HIERARCHY_FILTERING"));
/*     */     
/* 162 */     return (superIsDecoratable && !ignorePresent);
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\query\OrgHierarchySqlDecorator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */