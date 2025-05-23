/*     */ package dtv.data2.replication.dtximpl;
/*     */ 
/*     */ import dtv.data2.access.query.QueryRequest;
/*     */ import dtv.data2.replication.ReplicationException;
/*     */ import dtv.data2.replication.dtximpl.condition.AbstractReplicationCondition;
/*     */ import dtv.data2.replication.dtximpl.config.ServiceSubscriberConfig;
/*     */ import dtv.data2.replication.dtximpl.dispatcher.IDtxReplicationDispatcher;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.commons.lang3.builder.ToStringBuilder;
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
/*     */ public class DtxReplicationService
/*     */ {
/*     */   private static final String SUBSCRIBE_TO_ALL = "*";
/*  32 */   private final List<AbstractReplicationCondition> conditions_ = new ArrayList<>(2);
/*     */   
/*     */   private String serviceName_;
/*     */   
/*     */   private String currentDataSource_;
/*     */   private IDtxReplicationDispatcher dispatcher_;
/*     */   private List<ServiceSubscriberConfig> subscribers_;
/*  39 */   private long subscribersExpireAfter_ = 0L;
/*     */ 
/*     */   
/*     */   private boolean subscribersExpireImmediately_ = false;
/*     */ 
/*     */   
/*     */   private boolean subscribersNeverExpire_ = false;
/*     */ 
/*     */   
/*     */   private boolean enabled_ = true;
/*     */ 
/*     */   
/*     */   public void addCondition(AbstractReplicationCondition argCondition) {
/*  52 */     this.conditions_.add(argCondition);
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
/*     */ 
/*     */   
/*     */   public IDtxReplicationDispatcher.DispatchResult dispatch(ReplicationTransaction argReplicationTransaction) {
/*  71 */     if (argReplicationTransaction == null) {
/*  72 */       throw new ReplicationException("dispatch cannot accept NULL argReplicationLog on service: " + 
/*  73 */           getServiceName());
/*     */     }
/*     */     
/*  76 */     if (!getEnabled()) {
/*  77 */       return IDtxReplicationDispatcher.DispatchResult.DISPATCH_OFFLINE_FAILURE;
/*     */     }
/*     */     
/*  80 */     if (this.dispatcher_ == null) {
/*  81 */       throw new ReplicationException("Attempt was made to dispatch replication data while service: " + 
/*  82 */           getServiceName() + " has no dispatcher assigned.");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  87 */     return this.dispatcher_.dispatch(argReplicationTransaction);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCurrentDataSource() {
/*  97 */     return this.currentDataSource_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getEnabled() {
/* 106 */     return this.enabled_;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getServiceName() {
/* 130 */     return this.serviceName_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ServiceSubscriberConfig> getSubscribers() {
/* 139 */     return this.subscribers_;
/*     */   }
/*     */   
/*     */   public long getSubscribersExpireAfter() {
/* 143 */     return this.subscribersExpireAfter_;
/*     */   }
/*     */   
/*     */   public boolean getSubscribersExpireImmediately() {
/* 147 */     return this.subscribersExpireImmediately_;
/*     */   }
/*     */   
/*     */   public boolean getSubscribersNeverExpire() {
/* 151 */     return this.subscribersNeverExpire_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isApplicable(Object argToTest) {
/* 161 */     if (!getEnabled()) {
/* 162 */       return false;
/*     */     }
/*     */     
/* 165 */     String persistableId = null;
/*     */     
/* 167 */     if (argToTest instanceof QueryRequest) {
/* 168 */       persistableId = ((QueryRequest)argToTest).getQueryKey();
/*     */     }
/* 170 */     else if (argToTest instanceof String) {
/* 171 */       persistableId = argToTest.toString();
/*     */     } else {
/*     */       
/* 174 */       persistableId = argToTest.getClass().getName();
/*     */     } 
/*     */     
/* 177 */     boolean applicable = false;
/* 178 */     boolean excluded = false;
/*     */     
/* 180 */     for (ServiceSubscriberConfig subscriber : this.subscribers_) {
/* 181 */       if ("*".equalsIgnoreCase(subscriber.getSubscriberName()) || persistableId
/* 182 */         .startsWith(subscriber.getSubscriberName())) {
/*     */         
/* 184 */         if (!subscriber.isExcluded()) {
/* 185 */           applicable = true;
/*     */           continue;
/*     */         } 
/* 188 */         excluded = true;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/* 194 */     if (applicable && !excluded) {
/*     */ 
/*     */ 
/*     */       
/* 198 */       for (AbstractReplicationCondition c : this.conditions_) {
/* 199 */         if (!c.isCurrentlyMet(this, argToTest)) {
/* 200 */           return false;
/*     */         }
/*     */       } 
/* 203 */       return true;
/*     */     } 
/*     */     
/* 206 */     return false;
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
/*     */   public boolean isTargeted(String argDataSourceName) {
/* 218 */     return (this.dispatcher_ != null && this.dispatcher_.isTargeted(argDataSourceName));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCurrentDataSource(String argCurrentDataSource) {
/* 228 */     this.currentDataSource_ = argCurrentDataSource;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDestination(IDtxReplicationDispatcher argDispatcher) {
/* 237 */     if (argDispatcher == null) {
/* 238 */       throw new ReplicationException("addDispatcher cannot accept NULL argDispatcher");
/*     */     }
/* 240 */     this.dispatcher_ = argDispatcher;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEnabled(boolean argEnabled) {
/* 249 */     this.enabled_ = argEnabled;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setServiceName(String argServiceName) {
/* 258 */     this.serviceName_ = argServiceName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSubscribers(List<ServiceSubscriberConfig> argSubscribers) {
/* 267 */     this.subscribers_ = argSubscribers;
/*     */   }
/*     */   
/*     */   public void setSubscribersExpireAfter(long argSubscribersExpireAfter) {
/* 271 */     this.subscribersExpireAfter_ = argSubscribersExpireAfter;
/*     */   }
/*     */   
/*     */   public void setSubscribersExpireImmediately(boolean argSubscribersExpireImmediately) {
/* 275 */     this.subscribersExpireImmediately_ = argSubscribersExpireImmediately;
/*     */   }
/*     */   
/*     */   public void setSubscribersNeverExpire(boolean argSubscribersNeverExpire) {
/* 279 */     this.subscribersNeverExpire_ = argSubscribersNeverExpire;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 285 */     return (new ToStringBuilder(this)).append(this.serviceName_).toString();
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\replication\dtximpl\DtxReplicationService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */