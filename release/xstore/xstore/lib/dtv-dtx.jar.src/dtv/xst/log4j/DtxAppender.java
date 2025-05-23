/*     */ package dtv.xst.log4j;
/*     */ 
/*     */ import dtv.data2.access.DataFactory;
/*     */ import dtv.data2.access.IEventLogWriter;
/*     */ import dtv.data2.access.exception.PersistenceException;
/*     */ import dtv.util.DateUtils;
/*     */ import dtv.util.DtvDate;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.xst.dao.ctl.IEventLogEntry;
/*     */ import java.util.Date;
/*     */ import org.apache.logging.log4j.Level;
/*     */ import org.apache.logging.log4j.ThreadContext;
/*     */ import org.apache.logging.log4j.core.Filter;
/*     */ import org.apache.logging.log4j.core.LogEvent;
/*     */ import org.apache.logging.log4j.core.appender.AbstractAppender;
/*     */ import org.apache.logging.log4j.core.appender.AppenderLoggingException;
/*     */ import org.apache.logging.log4j.core.config.plugins.Plugin;
/*     */ import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
/*     */ import org.apache.logging.log4j.core.config.plugins.PluginElement;
/*     */ import org.apache.logging.log4j.core.config.plugins.PluginFactory;
/*     */ import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
/*     */ import org.apache.logging.log4j.core.layout.PatternLayout;
/*     */ import org.apache.logging.log4j.status.StatusLogger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Plugin(name = "DtxAppender", category = "Core", elementType = "appender", printObject = true)
/*     */ public final class DtxAppender
/*     */   extends AbstractAppender
/*     */   implements IEventLogWriter
/*     */ {
/*  36 */   private static final StatusLogger LOG = StatusLogger.getLogger();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final PatternLayout _layout;
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean _guaranteedDelivery;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @PluginFactory
/*     */   public static DtxAppender createAppender(@PluginAttribute("name") @Required(message = "No name provided for DtxAppender") String argName, @PluginElement("Filter") Filter argFilter, @PluginAttribute("guaranteedDelivery") boolean argGuaranteedDelivery) {
/*  52 */     return new DtxAppender(argName, argFilter, argGuaranteedDelivery);
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
/*     */   protected DtxAppender(String argName, Filter argFilter, boolean argGuaranteedDelivery) {
/*  67 */     super(argName, argFilter, null);
/*  68 */     this._guaranteedDelivery = argGuaranteedDelivery;
/*  69 */     this._layout = PatternLayout.createDefaultLayout();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void append(LogEvent argEvent) {
/*     */     try {
/*  77 */       String message = this._layout.toSerializable(argEvent);
/*  78 */       if (message.endsWith("\r\n")) {
/*  79 */         message = message.substring(0, message.length() - 2);
/*     */       }
/*  81 */       else if (message.endsWith("\n")) {
/*  82 */         message = message.substring(0, message.length() - 1);
/*     */       } 
/*     */       
/*  85 */       long orgId = Long.parseLong(System.getProperty("dtv.location.organizationId"));
/*  86 */       long storeId = Long.parseLong(System.getProperty("dtv.location.storeNumber"));
/*     */       
/*  88 */       String workstationIdString = ThreadContext.get("wkstn_id");
/*  89 */       if (StringUtils.isEmpty(workstationIdString)) {
/*  90 */         workstationIdString = System.getProperty("dtv.location.terminalNumber");
/*     */       }
/*  92 */       long workstationId = Long.parseLong(workstationIdString);
/*     */ 
/*     */       
/*  95 */       writeEventLog(orgId, storeId, workstationId, argEvent.getLoggerName(), argEvent.getLevel().toString(), message, (Date)new DtvDate(argEvent
/*  96 */             .getTimeMillis()), argEvent.getThreadName(), argEvent
/*  97 */           .getSource().toString(), this._guaranteedDelivery);
/*     */     }
/*  99 */     catch (Exception ex) {
/* 100 */       if (!ignoreExceptions()) {
/* 101 */         throw new AppenderLoggingException(ex);
/*     */       }
/* 103 */       LOG.catching(Level.DEBUG, ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeEventLog(long argOrganizationId, long argRtlLocId, long argWkstnId, String argLoggerCategory, String argLogLevel, String argLogMessage, Date argLogTimestamp, String argThreadName, String argSourceInfo, boolean argCriticalToDeliver) {
/* 112 */     IEventLogEntry logEntry = (IEventLogEntry)DataFactory.createObject(IEventLogEntry.class);
/*     */ 
/*     */     
/* 115 */     logEntry.setOrganizationId(argOrganizationId);
/* 116 */     logEntry.setRetailLocationId(argRtlLocId);
/* 117 */     logEntry.setWorkstationId(argWkstnId);
/* 118 */     logEntry.setLoggerCategory(argLoggerCategory);
/* 119 */     logEntry.setLogLevel(argLogLevel);
/* 120 */     logEntry.setLogMessage(argLogMessage);
/* 121 */     logEntry.setLogTimestamp(argLogTimestamp);
/* 122 */     logEntry.setThreadName(argThreadName);
/* 123 */     logEntry.setSource(StringUtils.right(argSourceInfo, 254));
/* 124 */     logEntry.setCriticalToDeliver(argCriticalToDeliver);
/*     */ 
/*     */     
/* 127 */     Long operatorPartyId = parseLong("dtv.pos.operatorPartyId");
/* 128 */     if (operatorPartyId != null) {
/* 129 */       logEntry.setOperatorPartyId(operatorPartyId.longValue());
/*     */     }
/* 131 */     Date businessDate = parseDate("dtv.businessDate");
/* 132 */     if (businessDate != null) {
/* 133 */       logEntry.setBusinessDate(businessDate);
/*     */     } else {
/*     */       
/* 136 */       logEntry.setBusinessDate(DateUtils.clearTime(DateUtils.getNewDate()));
/*     */     } 
/*     */     try {
/* 139 */       DataFactory.makePersistent(logEntry);
/*     */     }
/* 141 */     catch (PersistenceException e) {
/* 142 */       LOG.log(ignoreExceptions() ? Level.DEBUG : Level.ERROR, "Failed to persist logging event.", (Throwable)e);
/*     */     } 
/*     */   }
/*     */   
/*     */   private Date parseDate(String argSystemPropertyKey) {
/* 147 */     Date result = null;
/* 148 */     String systemPropertyValue = System.getProperty(argSystemPropertyKey);
/*     */     
/* 150 */     if (!StringUtils.isEmpty(systemPropertyValue)) {
/*     */       try {
/* 152 */         result = DateUtils.parseDate(systemPropertyValue);
/*     */       }
/* 154 */       catch (Exception ee) {
/* 155 */         LOG.log(ignoreExceptions() ? Level.DEBUG : Level.WARN, "Could not parse sys prop [key: " + argSystemPropertyKey + ", value: " + systemPropertyValue + "] as a Date.", ee);
/*     */       } 
/*     */     }
/*     */     
/* 159 */     return result;
/*     */   }
/*     */   
/*     */   private Long parseLong(String argSystemPropertyKey) {
/* 163 */     Long result = null;
/* 164 */     String systemPropertyValue = System.getProperty(argSystemPropertyKey);
/*     */     
/* 166 */     if (!StringUtils.isEmpty(systemPropertyValue)) {
/*     */       try {
/* 168 */         result = Long.valueOf(systemPropertyValue);
/* 169 */         if (result.longValue() == 0L) {
/* 170 */           result = null;
/*     */         }
/*     */       }
/* 173 */       catch (Exception ee) {
/* 174 */         LOG.log(ignoreExceptions() ? Level.DEBUG : Level.WARN, "Could not parse sys prop [key: " + argSystemPropertyKey + ", value: " + systemPropertyValue + "] as a Long.", ee);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 179 */     return result;
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-dtx.jar!\dtv\xst\log4j\DtxAppender.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */