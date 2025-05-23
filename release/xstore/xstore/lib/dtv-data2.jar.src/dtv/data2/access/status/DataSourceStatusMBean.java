/*     */ package dtv.data2.access.status;
/*     */ 
/*     */ import dtv.data2.access.config.pmtype.DataSourceLocationConfig;
/*     */ import dtv.data2.access.config.pmtype.PersistenceMgrTypeDescriptor;
/*     */ import dtv.data2.access.datasource.DataSourceDescriptor;
/*     */ import dtv.data2.access.datasource.DataSourceFactory;
/*     */ import dtv.data2.access.exception.FailoverException;
/*     */ import dtv.data2.access.impl.jdbc.JDBCDataSourceMgr;
/*     */ import dtv.data2.access.pm.PersistenceManagerStatus;
/*     */ import dtv.data2.access.pm.PersistenceMgrTypeFactory;
/*     */ import dtv.data2.replication.ReplicationStrategyHelper;
/*     */ import dtv.data2.replication.dtximpl.config.DtxReplicationConfigHelper;
/*     */ import dtv.data2.replication.dtximpl.config.DtxReplicationServiceConfig;
/*     */ import dtv.data2.replication.dtximpl.config.ServiceConditionConfig;
/*     */ import dtv.data2.replication.dtximpl.config.ServiceSubscriberConfig;
/*     */ import dtv.jmx.AbstractDtvMBean;
/*     */ import dtv.util.StringUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.inject.Inject;
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
/*     */ public class DataSourceStatusMBean
/*     */   extends AbstractDtvMBean
/*     */ {
/*     */   private static final String PM_TYPES = "Pm Type";
/*     */   private static final String DATASOURCES = "Datasources";
/*     */   private static final String DATASOURCE = "Datasource Name";
/*     */   private static final String SOURCE = "Source";
/*     */   private static final String ONLINE = "Online";
/*     */   private static final String OFFLINE = "Offline";
/*     */   private static final String DISABLED = "Disabled";
/*     */   private static final String ONLINE_LOOKUP = "Online Lookup:";
/*     */   private static final String ONLINE_PERSISTENCE = "Online Persistence:";
/*     */   private static final String OFFLINE_LOOKUP = "Offline Lookup:";
/*     */   private static final String OFFLINE_PERSISTENCE = "Offline Persistence:";
/*     */   private static final String REPLICATION = "Replication Status";
/*     */   private static final String PM_TYPE_STATUSES = "PM Statuses";
/*     */   private static final String CONNECTION_POOL_STATUS = "Connection Pool Status";
/*     */   private static final String REPLICATION_MASTER_SWITCH = "Replcation Master Switch (system property dtv.data2.replication.enabled): ";
/*     */   private static final String BR = "<br>";
/*  64 */   private Map<String, String> dataSourceStatuses_ = null;
/*     */ 
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private PersistenceMgrTypeFactory _persistenceMgrTypeFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDataSourceStatus() {
/*  75 */     this.dataSourceStatuses_ = new HashMap<>();
/*     */     
/*  77 */     StringBuilder doc = new StringBuilder(1024);
/*     */     
/*  79 */     dataSourceSummary(doc);
/*  80 */     connectionPoolSummary(doc);
/*  81 */     replicationStatus(doc);
/*     */     
/*  83 */     doc.append("<p align=\"center\">");
/*  84 */     doc.append(font(bold("PM Statuses"), 4));
/*  85 */     doc.append("</p>");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  90 */     tableHeader(doc, "Pm Type", "Datasources");
/*     */ 
/*     */     
/*  93 */     Collection<PersistenceMgrTypeDescriptor> pmTypes = this._persistenceMgrTypeFactory.getPersistenceMgrtTypeDescriptors();
/*     */     
/*  95 */     for (PersistenceMgrTypeDescriptor pm : pmTypes) {
/*     */ 
/*     */ 
/*     */       
/*  99 */       doc.append("<tr>").append("<td>").append(font(bold(pm.getName()))).append("</td>");
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 104 */       doc.append("<td><p>");
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 109 */       doc.append(font(bold("Online Lookup:"))).append("<br>");
/*     */       
/* 111 */       for (DataSourceLocationConfig onlineLookupLoc : pm.getOnlineLookupLocations()) {
/* 112 */         doc.append(
/* 113 */             font(onlineLookupLoc.getDataSourceName()) + " - " + 
/* 114 */             getDataSourceStatus(onlineLookupLoc.getDataSourceName())).append("<br>");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 120 */       doc.append(font(bold("Online Persistence:"))).append("<br>");
/*     */       
/* 122 */       for (DataSourceLocationConfig onlinePersistpLoc : pm.getOnlinePersistenceLocations()) {
/* 123 */         doc.append(
/* 124 */             font(onlinePersistpLoc.getDataSourceName()) + " - " + 
/* 125 */             getDataSourceStatus(onlinePersistpLoc.getDataSourceName())).append("<br>");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 131 */       doc.append(font(bold("Offline Lookup:"))).append("<br>");
/*     */       
/* 133 */       for (DataSourceLocationConfig offlineLookupLoc : pm.getOfflineLookupLocations()) {
/* 134 */         doc.append(
/* 135 */             font(offlineLookupLoc.getDataSourceName()) + " - " + 
/* 136 */             getDataSourceStatus(offlineLookupLoc.getDataSourceName())).append("<br>");
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 142 */       doc.append(font(bold("Offline Persistence:"))).append("<br>");
/*     */       
/* 144 */       for (DataSourceLocationConfig offlinePersistLoc : pm.getOfflinePersistenceLocations()) {
/* 145 */         doc.append(
/* 146 */             font(offlinePersistLoc.getDataSourceName()) + " - " + 
/* 147 */             getDataSourceStatus(offlinePersistLoc.getDataSourceName())).append("<br>");
/*     */       }
/* 149 */       if (pm.getOfflineLookupLocations().size() > 0) {
/* 150 */         trimBR(doc);
/*     */       }
/*     */       
/* 153 */       doc.append("</td></tr>");
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 159 */     tableFooter(doc);
/*     */     
/* 161 */     return doc.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void startMBean() {}
/*     */ 
/*     */ 
/*     */   
/*     */   private String bold(String argElement) {
/* 171 */     return "<strong>" + argElement + "</strong>";
/*     */   }
/*     */   
/*     */   private String color(String argElement, String argColor) {
/* 175 */     return "<font color=\"" + argColor + "\">" + argElement + "</font>";
/*     */   }
/*     */   
/*     */   private void connectionPoolSummary(StringBuilder argBuf) {
/* 179 */     StringBuilder doc = argBuf;
/*     */     
/* 181 */     doc.append("<p align=\"center\">");
/* 182 */     doc.append(font(bold("Connection Pool Status"), 4));
/* 183 */     doc.append("</p>");
/*     */     
/* 185 */     doc.append("<table width=\"400\" border=\"1\" cellspacing=\"0\" cellpadding=\"5\" align=\"center\">");
/* 186 */     doc.append("  <tr> ");
/* 187 */     doc.append("    <td>");
/*     */     
/* 189 */     StringBuilder stats = (new StringBuilder(2048)).append(JDBCDataSourceMgr.getInstance().toString());
/* 190 */     StringUtils.replaceAll(stats, "\n", "<br>");
/* 191 */     StringUtils.replaceAll(stats, "\t", "&nbsp;&nbsp;");
/* 192 */     doc.append(stats);
/*     */     
/* 194 */     doc.append("  </td></tr></table>");
/* 195 */     doc.append("<br>");
/*     */   }
/*     */   
/*     */   private void dataSourceSummary(StringBuilder argBuf) {
/* 199 */     StringBuilder doc = argBuf;
/*     */     
/* 201 */     doc.append("<p align=\"center\">");
/* 202 */     doc.append(font(bold("Datasources"), 4));
/* 203 */     doc.append("</p>");
/*     */     
/* 205 */     tableHeader(argBuf, "Datasource Name", "Source");
/*     */ 
/*     */     
/* 208 */     Collection<DataSourceDescriptor> datasourcesCollection = DataSourceFactory.getInstance().getDataSourceDescriptors();
/*     */ 
/*     */     
/* 211 */     List<DataSourceDescriptor> datasources = getSortedDatasourceList(datasourcesCollection);
/*     */     
/* 213 */     for (DataSourceDescriptor datasource : datasources) {
/* 214 */       doc.append("<tr>").append("<td>").append(font(bold(datasource.getName())));
/* 215 */       doc.append("<br>");
/* 216 */       doc.append(getDataSourceStatus(datasource.getName(), true));
/* 217 */       doc.append("</td>");
/*     */       
/* 219 */       doc.append("<td>");
/* 220 */       doc.append(font(datasource.getSourceDescription()));
/* 221 */       doc.append("</td></tr>");
/*     */     } 
/* 223 */     tableFooter(argBuf);
/* 224 */     doc.append("<br>");
/*     */   }
/*     */   
/*     */   private String font(String argElement) {
/* 228 */     return "<font face=\"Arial,  Helvetica,  sans-serif\">" + argElement + "</font>";
/*     */   }
/*     */   
/*     */   private String font(String argElement, int size) {
/* 232 */     return "<font face=\"Arial,  Helvetica,  sans-serif\" size=\"" + size + "\">" + argElement + "</font>";
/*     */   }
/*     */   
/*     */   private String getDataSourceStatus(String argDataSourceName) {
/* 236 */     return getDataSourceStatus(argDataSourceName, false);
/*     */   }
/*     */   
/*     */   private String getDataSourceStatus(String argDataSourceName, boolean argIncludeOfflineCause) {
/* 240 */     if (this.dataSourceStatuses_.containsKey(argDataSourceName)) {
/* 241 */       return this.dataSourceStatuses_.get(argDataSourceName);
/*     */     }
/*     */     
/* 244 */     String status = null;
/*     */     
/* 246 */     boolean enabled = false;
/* 247 */     boolean inError = false;
/* 248 */     String errorString = null;
/*     */     
/*     */     try {
/* 251 */       enabled = DataSourceFactory.getInstance().getDataSourceDescriptor(argDataSourceName).isEnabled();
/*     */     }
/* 253 */     catch (Exception ee) {
/* 254 */       inError = true;
/* 255 */       errorString = ee.toString();
/*     */     } 
/*     */     
/* 258 */     if (inError) {
/* 259 */       status = red(bold(errorString));
/*     */     }
/* 261 */     else if (!enabled) {
/* 262 */       status = grey(bold("Disabled"));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 269 */     else if (PersistenceManagerStatus.ONLINE == StatusMgr.getInstance()
/* 270 */       .getDataSourceStatus(argDataSourceName)) {
/*     */       
/* 272 */       status = green(bold("Online"));
/*     */     } else {
/*     */       
/* 275 */       status = red(bold("Offline"));
/*     */       
/* 277 */       if (argIncludeOfflineCause) {
/* 278 */         FailoverException ee = StatusMgr.getInstance().getOfflineCause(argDataSourceName);
/*     */         
/* 280 */         String cause = (ee != null) ? ee.toString() : "UNKNOWN";
/*     */         
/* 282 */         status = status + font(" - Offline Cause: " + cause);
/* 283 */         return status;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 288 */     this.dataSourceStatuses_.put(argDataSourceName, status);
/* 289 */     return status;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private List<DataSourceDescriptor> getSortedDatasourceList(Collection<DataSourceDescriptor> argDatasourceCollection) {
/* 295 */     List<DataSourceDescriptor> list = new ArrayList<>(argDatasourceCollection.size());
/*     */     
/* 297 */     for (DataSourceDescriptor dsd : argDatasourceCollection) {
/* 298 */       list.add(dsd);
/*     */     }
/*     */     
/* 301 */     Collections.sort(list, new Comparator<DataSourceDescriptor>()
/*     */         {
/*     */           
/*     */           public int compare(DataSourceDescriptor arg1, DataSourceDescriptor arg2)
/*     */           {
/* 306 */             if (arg1.isEnabled() != arg2.isEnabled()) {
/* 307 */               if (arg1.isEnabled()) {
/* 308 */                 return -1;
/*     */               }
/*     */               
/* 311 */               return 1;
/*     */             } 
/*     */ 
/*     */             
/* 315 */             return arg1.getName().compareTo(arg2.getName());
/*     */           }
/*     */         });
/*     */     
/* 319 */     return list;
/*     */   }
/*     */   
/*     */   private String green(String argElement) {
/* 323 */     return color(argElement, "#00CC00");
/*     */   }
/*     */   
/*     */   private String grey(String argElement) {
/* 327 */     return color(argElement, "#999999");
/*     */   }
/*     */   
/*     */   private String red(String argElement) {
/* 331 */     return color(argElement, "#FF0000");
/*     */   }
/*     */   
/*     */   private void replicationStatus(StringBuilder argBuf) {
/* 335 */     StringBuilder doc = argBuf;
/*     */     
/* 337 */     doc.append("<p align=\"center\">");
/*     */     
/* 339 */     doc.append(font(bold("Replication Status"), 4)).append("<br>");
/*     */     
/* 341 */     boolean on = ReplicationStrategyHelper.isReplicationEnabled();
/*     */     
/* 343 */     doc.append(font(bold("Replcation Master Switch (system property dtv.data2.replication.enabled): "), 2));
/* 344 */     doc.append("<b>" + (on ? green("" + on) : red("" + on)) + "</b>").append("<br>");
/* 345 */     doc.append("Replication Queue Datasource: <b>" + 
/*     */         
/* 347 */         DtxReplicationConfigHelper.getReplicationQueueConfig().getDataSource() + "</b>").append("<br>");
/*     */     
/* 349 */     doc.append("</p>");
/*     */     
/* 351 */     if (on && 
/* 352 */       ReplicationStrategyHelper.getReplicationStategy() instanceof dtv.data2.replication.dtximpl.DtxReplicationStrategy) {
/* 353 */       doc.append("<table width=\"400\" border=\"1\" cellspacing=\"0\" cellpadding=\"5\" align=\"center\">");
/* 354 */       doc.append("  <tr> ");
/* 355 */       doc.append("    <td>");
/*     */       
/* 357 */       DtxReplicationServiceConfig[] serviceConfigs = DtxReplicationConfigHelper.getServiceConfigs();
/* 358 */       StringBuilder serviceReportBuilder = new StringBuilder(2048);
/*     */       
/* 360 */       for (DtxReplicationServiceConfig config : serviceConfigs) {
/* 361 */         if (config.isEnabled()) {
/* 362 */           serviceReportBuilder.append("Service: " + config.getName() + " enabled: " + config.isEnabled() + "<br>");
/*     */ 
/*     */           
/* 365 */           if (config.getConditions() != null && config.getConditions().size() > 0) {
/* 366 */             for (ServiceConditionConfig conditionConfig : config.getConditions()) {
/* 367 */               serviceReportBuilder.append(" APPLICABLE when condition is met: " + conditionConfig + "<br>");
/*     */             }
/*     */           }
/*     */           
/* 371 */           serviceReportBuilder
/* 372 */             .append(" APPLICABLE for objects whose class begins with on of the following patterns: <br>");
/*     */           
/* 374 */           for (ServiceSubscriberConfig subscriber : config.getSubscribers()) {
/* 375 */             serviceReportBuilder.append(" " + subscriber + "<br>");
/*     */           }
/*     */           
/* 378 */           serviceReportBuilder.append("<br><br>");
/*     */         } 
/*     */       } 
/*     */       
/* 382 */       doc.append(font(serviceReportBuilder.toString()));
/* 383 */       doc.append("  </td></tr></table>");
/*     */     } 
/*     */     
/* 386 */     doc.append("<br>");
/*     */   }
/*     */   
/*     */   private void tableFooter(StringBuilder argDoc) {
/* 390 */     argDoc.append("  </table>");
/*     */   }
/*     */   
/*     */   private void tableHeader(StringBuilder argDoc, String argCol1, String argCol2) {
/* 394 */     argDoc.append("<table width=\"400\" border=\"1\" cellspacing=\"0\" cellpadding=\"5\" align=\"center\">");
/* 395 */     argDoc.append("  <tr bgcolor=\"#CCCCCC\"> ");
/* 396 */     argDoc.append("    <td>").append(font(bold(argCol1))).append("</td>");
/* 397 */     argDoc.append("    <td>").append(font(bold(argCol2))).append("</td>");
/* 398 */     argDoc.append("  </tr>");
/*     */   }
/*     */   
/*     */   private void trimBR(StringBuilder argDoc) {
/* 402 */     argDoc.setLength(argDoc.length() - "<br>".length());
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\status\DataSourceStatusMBean.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */