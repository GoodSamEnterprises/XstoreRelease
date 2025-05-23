/*     */ package dtv.pos.framework;
/*     */ 
/*     */ import dtv.data2.cache.CacheManager;
/*     */ import dtv.data2.replication.ReplicationStrategyHelper;
/*     */ import dtv.event.IEventor;
/*     */ import dtv.event.eventor.DefaultEventor;
/*     */ import dtv.hardware.startup.SplashPanel;
/*     */ import dtv.jmx.JmxAgentStartupHelper;
/*     */ import dtv.pos.LocationIdentification;
/*     */ import dtv.pos.Version;
/*     */ import dtv.pos.common.BusinessDateHelper;
/*     */ import dtv.pos.common.ConfigurationMgr;
/*     */ import dtv.pos.framework.appmanagement.ApplicationConfigHelper;
/*     */ import dtv.pos.framework.keycommands.VersionDebugger;
/*     */ import dtv.pos.framework.ui.component.XstAppFrame;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.XstApplication;
/*     */ import dtv.pos.iframework.event.IExitEvent;
/*     */ import dtv.pos.iframework.event.IExitListener;
/*     */ import dtv.pos.iframework.security.StationState;
/*     */ import dtv.pos.iframework.type.ExitType;
/*     */ import dtv.pos.iframework.type.IExitType;
/*     */ import dtv.pos.ui.PosRepaintManager;
/*     */ import dtv.pos.ui.UIResponsivenessMgr;
/*     */ import dtv.pos.ui.UIServices;
/*     */ import dtv.pos.ui.plaf.theme.DefaultPosMetalTheme;
/*     */ import dtv.test.ITestHarness;
/*     */ import dtv.ui.DtvUIManager;
/*     */ import dtv.ui.UIServices;
/*     */ import dtv.ui.context.Context;
/*     */ import dtv.ui.context.ContextChangeEvent;
/*     */ import dtv.util.ClassPathUtils;
/*     */ import dtv.util.DateUtils;
/*     */ import dtv.util.EndsWithNameFilter;
/*     */ import dtv.util.INameFilter;
/*     */ import dtv.util.LoggingThreadGroup;
/*     */ import dtv.util.NumberUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.config.ConfigException;
/*     */ import dtv.util.config.SystemPropertiesLoader;
/*     */ import dtv.util.crypto.DtvEncrypter;
/*     */ import dtv.xst.daocommon.LocaleInfo;
/*     */ import java.awt.Component;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.Window;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringWriter;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.UIManager;
/*     */ import javax.swing.plaf.metal.MetalLookAndFeel;
/*     */ import javax.swing.plaf.metal.MetalTheme;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.springframework.context.ConfigurableApplicationContext;
/*     */ import org.springframework.context.support.ClassPathXmlApplicationContext;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StationController
/*     */   extends XstApplication
/*     */ {
/*  74 */   private static final Logger _logger = Logger.getLogger(StationController.class);
/*     */   
/*     */   private static final String SPRING_DEFAULT_ACTIVE_PROFILES = "xstore,retail";
/*     */   
/*     */   private static XstAppFrame _appFrame;
/*     */   
/*     */   private static ModeController _currentMode;
/*     */   
/*     */   private static Map<ApplicationData, ModeController> _modeControllerMap;
/*     */   
/*  84 */   private static Map<String, Boolean> _modeStartupCompleteMap = new HashMap<>();
/*     */   private static IEventor _changeModeEventor;
/*     */   private static ConfigurableApplicationContext _springContext;
/*     */   public static final IExitListener _cacheDisposingExitListener;
/*     */   
/*     */   static {
/*  90 */     _cacheDisposingExitListener = (argEvent -> {
/*     */         
/*     */         try {
/*     */           CacheManager.getInstance().clear();
/*  94 */         } catch (Throwable ex) {
/*     */           _logger.error("Unable to dispose of cache properly.", ex);
/*     */         } 
/*     */       });
/*     */   }
/*  99 */   public static final IExitListener _loggingExitListener = (IExitListener)new IExitListener.IPrioritizedExitListener()
/*     */     {
/*     */       
/*     */       public void exiting(IExitEvent argEvent)
/*     */       {
/* 104 */         Logger adminLogger_ = Logger.getLogger("dtv.xstore.state.app.shutdown");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 111 */         if (ExitType.NORMAL == argEvent.getExitType()) {
/* 112 */           StationController._logger.info("The application has terminated normally.  " + argEvent.getMessage());
/*     */ 
/*     */           
/* 115 */           adminLogger_.info("Xstore register shutting down normally.");
/*     */         }
/*     */         else {
/*     */           
/* 119 */           StringBuilder systemoutErrorMessage = new StringBuilder();
/*     */           
/* 121 */           systemoutErrorMessage.append("The application has terminated abnormally...");
/* 122 */           if (argEvent.getMessage() != null) {
/* 123 */             systemoutErrorMessage.append(StringUtils.NEW_LINE).append("\tUser Message: ");
/* 124 */             systemoutErrorMessage.append(argEvent.getMessage());
/*     */           } 
/* 126 */           systemoutErrorMessage.append(StringUtils.NEW_LINE).append("\tError status: ");
/* 127 */           systemoutErrorMessage.append(argEvent.getExitType());
/* 128 */           StationController._logger.fatal(systemoutErrorMessage, argEvent.getThrowable());
/* 129 */           if (argEvent.getThrowable() instanceof StackOverflowError) {
/* 130 */             StringWriter sw = new StringWriter();
/* 131 */             PrintWriter pw = new PrintWriter(sw);
/* 132 */             argEvent.getThrowable().printStackTrace(pw);
/* 133 */             StationController._logger.fatal("STACK FOR PREVIOUS EXCEPTION:" + StringUtils.NEW_LINE + sw.getBuffer().toString());
/*     */           }
/* 135 */           else if (argEvent.getThrowable() != null) {
/* 136 */             StationController._logger.fatal("STACK TRACE", argEvent.getThrowable());
/*     */           } 
/* 138 */           Logger.getLogger(getClass().getName() + ".email").fatal("abnormal exit");
/*     */ 
/*     */           
/* 141 */           adminLogger_.fatal("Xstore register shutting down with abnormal exit.");
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/*     */       public int priority() {
/* 147 */         return Integer.MAX_VALUE;
/*     */       }
/*     */     };
/*     */   
/*     */   public static void dumpMemoryReport(String argMsg) {
/* 152 */     if (_logger.isInfoEnabled()) {
/* 153 */       StringBuilder sb = new StringBuilder();
/* 154 */       sb.append(argMsg);
/* 155 */       sb.append(':');
/* 156 */       sb.append("Memory max=");
/* 157 */       sb.append(Runtime.getRuntime().maxMemory());
/* 158 */       sb.append(";total=");
/* 159 */       long total = Runtime.getRuntime().totalMemory();
/* 160 */       sb.append(total);
/* 161 */       sb.append(";free=");
/* 162 */       long free = Runtime.getRuntime().freeMemory();
/* 163 */       sb.append(free);
/* 164 */       sb.append(";used=");
/* 165 */       sb.append(total - free);
/* 166 */       _logger.info(sb);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XstAppFrame getAppFrame() {
/* 174 */     return _appFrame;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void initGlobals() {
/* 179 */     ReplicationStrategyHelper.initialize();
/*     */ 
/*     */     
/* 182 */     LocaleInfo.setCurrencyFractionDigits(ConfigurationMgr.getLocalCurrencyScale());
/*     */ 
/*     */     
/* 185 */     _appFrame = (XstAppFrame)_springContext.getBean(XstAppFrame.class);
/* 186 */     _appFrame.setTitle(Version.getLongTitle());
/*     */ 
/*     */ 
/*     */     
/* 190 */     SplashPanel panel = SplashPanel.getSplashPanel().version(Version.getVersion());
/*     */     
/* 192 */     _appFrame.add((Component)panel, "INIT_BACKGROUND");
/*     */     
/* 194 */     _appFrame.addWindowListener(new WindowAdapter()
/*     */         {
/*     */           public void windowClosing(WindowEvent event) {
/* 197 */             if (Boolean.getBoolean("dtv.pos.ui.useFrame")) {
/* 198 */               XstApplication.annihilate();
/*     */             }
/*     */           }
/*     */         });
/*     */     
/* 203 */     PosRepaintManager.getInstance().setPaintingLimited(!Boolean.getBoolean("dtv.pos.disablePaintLimiting"));
/* 204 */     UIServices.listScreens();
/* 205 */     showFrame();
/*     */ 
/*     */     
/*     */     try {
/* 209 */       JmxAgentStartupHelper jmxStartUpHelper = (JmxAgentStartupHelper)_springContext.getBean(JmxAgentStartupHelper.class);
/* 210 */       (new Thread((Runnable)jmxStartUpHelper, "JMX Agent Startup")).start();
/*     */     }
/* 212 */     catch (NoSuchMethodError ex1) {
/* 213 */       _logger.warn("Error starting the JMX Agent.", ex1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/*     */     try {
/* 226 */       (new SystemPropertiesLoader()).loadSystemProperties();
/*     */     }
/* 228 */     catch (IOException ex) {
/* 229 */       Logger.getLogger(StationController.class).error("CAUGHT EXCEPTION", ex);
/*     */     } 
/* 231 */     new PosArgs(args);
/*     */ 
/*     */     
/*     */     try {
/* 235 */       DtvEncrypter.getInstance("config");
/*     */     }
/* 237 */     catch (Throwable ex) {
/* 238 */       Logger.getLogger(StationController.class).error("CAUGHT EXCEPTION", ex);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 244 */     System.setProperty("dtv.data2.access.DataModel.enableEventPostingForChanges", "true");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 250 */     long orgId = Long.parseLong(System.getProperty("dtv.location.organizationId"));
/* 251 */     long storeId = Long.parseLong(System.getProperty("dtv.location.storeNumber"));
/* 252 */     long workstationId = Long.parseLong(System.getProperty("dtv.location.terminalNumber"));
/* 253 */     ConfigPathRetriever configPathRetriever = new ConfigPathRetriever();
/*     */     
/* 255 */     boolean pathUpdated = false;
/*     */     
/* 257 */     pathUpdated = configPathRetriever.updateConfigPathFromServer(orgId, storeId, workstationId);
/*     */ 
/*     */ 
/*     */     
/* 261 */     if (pathUpdated) {
/* 262 */       annihilate((IExitType)ExitType.CONFIG_PATH_CHANGED_RESTART, "A new config path was obtained from Xcenter. Xstore is restarting in order to utilize the change.");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 271 */     LoggingThreadGroup loggingThreadGroup = new LoggingThreadGroup("dtv-main", Logger.getLogger("dtv.xstore.uncaught"));
/* 272 */     StartupWorker w = new StartupWorker();
/* 273 */     Thread t = new Thread((ThreadGroup)loggingThreadGroup, w, "startup");
/* 274 */     t.start();
/*     */   }
/*     */   
/*     */   public static void setAppFrame(XstAppFrame argAppFrame) {
/* 278 */     _appFrame = argAppFrame;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static synchronized void setCurrentMode(ApplicationData appData) {
/* 286 */     setCurrentMode(appData, true);
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
/*     */   public static void setGlobalContext(Context argContext, Object argConstraint) {
/* 305 */     _appFrame.handleContextChange(new ContextChangeEvent(new Object(), null, argContext));
/*     */     
/* 307 */     for (ModeController mode : _modeControllerMap.values()) {
/* 308 */       mode.getContextManager().setContext(argContext, argConstraint);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void showFrame() {
/* 314 */     if (!_appFrame.isVisible()) {
/* 315 */       UIServices.invoke(() -> {
/*     */             _appFrame.setVisible(true);
/*     */             
/*     */             _appFrame.show("INIT_BACKGROUND");
/*     */             
/*     */             String framePosition = System.getProperty("dtv.pos.framePosition");
/*     */             
/*     */             Rectangle rect = null;
/*     */             
/*     */             if (framePosition != null) {
/*     */               String[] parts = StringUtils.split(framePosition, ',');
/*     */               
/*     */               if (parts.length >= 4) {
/*     */                 try {
/*     */                   int x = Integer.parseInt(parts[0]);
/*     */                   
/*     */                   int y = Integer.parseInt(parts[1]);
/*     */                   
/*     */                   int width = Integer.parseInt(parts[2]);
/*     */                   int height = Integer.parseInt(parts[3]);
/*     */                   rect = new Rectangle(x, y, width, height);
/* 336 */                 } catch (NumberFormatException e) {
/*     */                   _logger.debug("CAUGHT EXCEPTION", e);
/*     */                 } 
/*     */               }
/*     */             } 
/*     */             if (rect == null) {
/*     */               UIServices.moveWindowToDefaultScreen(_appFrame.getFrameComponent());
/*     */             } else {
/*     */               Window window = _appFrame.getFrameComponent();
/*     */               UIServices.moveWindowToDefaultScreen(window, false);
/*     */               window.setSize(rect.getSize());
/*     */               window.setLocation(rect.x, rect.y);
/*     */               if (window instanceof JFrame) {
/*     */                 ((JFrame)window).setExtendedState(0);
/*     */               }
/*     */               window.validate();
/*     */             } 
/*     */           }true, false);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ModeController startApplication(ApplicationData app, boolean paused) {
/* 365 */     _changeModeEventor.post(IModeController.CHANGE_APPLICATION_MODE, app);
/*     */     
/* 367 */     ModeController mode = (ModeController)_springContext.getBean(ModeController.class);
/* 368 */     _modeControllerMap.put(app, mode);
/*     */ 
/*     */     
/*     */     try {
/* 372 */       mode.initController(app);
/* 373 */       mode.initStationView();
/* 374 */       mode.startController(paused);
/*     */     }
/* 376 */     catch (Throwable e) {
/* 377 */       handleStartupDisaster(e);
/* 378 */       return null;
/*     */     } 
/*     */     
/* 381 */     return mode;
/*     */   }
/*     */   
/*     */   static ApplicationData getStartupApplicationData() {
/* 385 */     return ApplicationConfigHelper.getInstance().getApplicationData(ConfigurationMgr.getStartupApplication());
/*     */   }
/*     */   
/*     */   static void handleStartupDisaster(Throwable ex) {
/* 389 */     String message = null;
/*     */     
/*     */     try {
/* 392 */       _logger.fatal("CAUGHT EXCEPTION", ex);
/*     */       
/* 394 */       StringBuilder sb = new StringBuilder();
/* 395 */       sb.append("A fatal error has prevented ").append(Version.getLongTitle())
/* 396 */         .append(" from starting.");
/* 397 */       sb.append(StringUtils.NEW_LINE + StringUtils.NEW_LINE + "Review the log for more information.");
/*     */       
/* 399 */       if (ex != null) {
/* 400 */         sb.append(StringUtils.NEW_LINE + StringUtils.NEW_LINE + "Cause:");
/* 401 */         sb.append(StringUtils.NEW_LINE + "     ").append(StringUtils.left(ex.getMessage(), 80));
/* 402 */         Throwable rootCause = getRootCause(ex);
/* 403 */         if (rootCause != null) {
/* 404 */           sb.append(StringUtils.NEW_LINE + "Root cause:");
/* 405 */           sb.append(StringUtils.NEW_LINE + "     ").append(StringUtils.left(rootCause.getMessage(), 80));
/*     */         } 
/*     */       } 
/*     */       
/* 409 */       message = sb.toString();
/*     */       
/* 411 */       if (!Boolean.getBoolean(StationController.class.getName() + ".quiet")) {
/* 412 */         JOptionPane.showMessageDialog(null, message, "Unable to start", 0);
/*     */       }
/*     */     } finally {
/*     */       
/* 416 */       annihilate((IExitType)ExitType.UNABLE_TO_START, message, ex);
/*     */     } 
/*     */   }
/*     */   
/*     */   static void startAllApplicationModes() {
/* 421 */     _modeControllerMap = new HashMap<>();
/* 422 */     List<ApplicationData> applications = ApplicationConfigHelper.getInstance().getAllApplicationData();
/*     */     
/* 424 */     if (applications == null || applications.isEmpty()) {
/* 425 */       handleStartupDisaster((Throwable)new ConfigException("There are no applications configured for this system!"));
/*     */     }
/*     */     
/* 428 */     ApplicationData startupApp = getStartupApplicationData();
/*     */ 
/*     */ 
/*     */     
/* 432 */     for (ApplicationData app : applications) {
/* 433 */       _modeStartupCompleteMap.put(app.getKey(), Boolean.valueOf(false));
/*     */       
/* 435 */       if (startupApp.equals(app)) {
/* 436 */         app.setPriority(1);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 441 */     Collections.sort(applications, (argApp1, argApp2) -> argApp1.getPriority() - argApp2.getPriority());
/*     */     
/* 443 */     for (ApplicationData app : applications) {
/* 444 */       _currentMode = startApplication(app, !app.equals(startupApp));
/*     */     }
/*     */   }
/*     */   
/*     */   private static Throwable getRootCause(Throwable argEx) {
/* 449 */     Throwable cause = argEx;
/* 450 */     Throwable nextCause = cause.getCause();
/* 451 */     while (nextCause != null && nextCause != cause) {
/* 452 */       cause = nextCause;
/* 453 */       nextCause = cause.getCause();
/*     */     } 
/* 455 */     return cause;
/*     */   }
/*     */   
/*     */   private static void setCurrentMode(ApplicationData argAppData, boolean argShowModeUI) {
/* 459 */     if (argAppData == null) {
/* 460 */       handleStartupDisaster(new Throwable("Cannot execute a null application!"));
/*     */     }
/*     */     
/* 463 */     _logger.debug("Station Controller: switching to [" + argAppData + "].");
/* 464 */     _currentMode = _modeControllerMap.get(argAppData);
/* 465 */     _changeModeEventor.post(IModeController.CHANGE_APPLICATION_MODE, argAppData);
/*     */     
/* 467 */     if (argShowModeUI) {
/* 468 */       _appFrame.show(_currentMode.getModeData().toString());
/*     */     }
/*     */     
/* 471 */     _currentMode.initOCP();
/*     */   }
/*     */ 
/*     */   
/*     */   static class StartupWorker
/*     */     implements Runnable
/*     */   {
/*     */     public void run() {
/*     */       try {
/* 480 */         if (StationController._logger.isInfoEnabled()) {
/* 481 */           StringBuilder sb = new StringBuilder(1024);
/* 482 */           sb.append("STARTING" + StringUtils.NEW_LINE);
/* 483 */           sb.append((new LocationIdentification()).getDescription());
/* 484 */           (new VersionDebugger()).fillPathPropertyInformation(sb);
/* 485 */           sb.append(StringUtils.NEW_LINE);
/* 486 */           StationController._logger.info(sb);
/*     */         } 
/*     */ 
/*     */         
/* 490 */         MetalLookAndFeel.setCurrentTheme((MetalTheme)new DefaultPosMetalTheme());
/*     */         try {
/* 492 */           UIManager.setLookAndFeel(UIManager.getLookAndFeel());
/*     */         }
/* 494 */         catch (Exception ex) {
/* 495 */           StationController._logger.warn("CAUGHT EXCEPTION", ex);
/*     */         } 
/*     */ 
/*     */         
/* 499 */         UIServices.setDefaultScreen(NumberUtils.getInteger("dtv.pos.screenNumber", Integer.valueOf(0)).intValue());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 505 */         DtvUIManager.install();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 514 */         String springProfiles = System.getProperty("spring.profiles.active");
/*     */         
/* 516 */         if (springProfiles == null) {
/* 517 */           System.setProperty("spring.profiles.active", "xstore,retail");
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 523 */         String[] files = ClassPathUtils.getDirectoryBasedConfigFileListRelativePaths("spring", (INameFilter)new EndsWithNameFilter(new String[] { ".xml" }));
/*     */ 
/*     */         
/* 526 */         StationController._springContext = (ConfigurableApplicationContext)new ClassPathXmlApplicationContext(files);
/* 527 */         StationController._springContext.registerShutdownHook();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 537 */         long orgId = Long.parseLong(System.getProperty("dtv.location.organizationId"));
/*     */         
/* 539 */         StationState stationState = (StationState)StationController._springContext.getBean(StationState.class);
/* 540 */         BusinessDateHelper businessDayHelper = (BusinessDateHelper)StationController._springContext.getBean(BusinessDateHelper.class);
/* 541 */         stationState.setBusinessDate(businessDayHelper.calculateInitialBusinessDate(stationState
/* 542 */               .getRetailLocationId(), stationState.getWorkstationId()));
/*     */         
/* 544 */         RetailLocationSynchronizer retailLocTillSync = new RetailLocationSynchronizer();
/* 545 */         retailLocTillSync.synchronizeRetailLocationInfo(orgId, stationState.getRetailLocationId(), stationState
/* 546 */             .getWorkstationId());
/*     */         
/* 548 */         StationController._changeModeEventor = (IEventor)new DefaultEventor(IModeController.APPLICATION_MODE_DESCRIPTOR);
/*     */         
/* 550 */         XstApplication.addExitListener(StationController._loggingExitListener);
/* 551 */         XstApplication.addExitListener(StationController._cacheDisposingExitListener);
/*     */         
/* 553 */         if (StationController._logger.isInfoEnabled()) {
/* 554 */           StringBuilder sb = new StringBuilder(1024);
/* 555 */           (new VersionDebugger()).getRuntimeInformation(sb).append(StringUtils.NEW_LINE);
/* 556 */           StationController._logger.info(sb);
/*     */         } 
/* 558 */         StationController.dumpMemoryReport("start");
/*     */         
/* 560 */         StationController.initGlobals();
/*     */         
/* 562 */         StationController.startAllApplicationModes();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 568 */         Thread.yield();
/* 569 */         UIResponsivenessMgr uirm = (UIResponsivenessMgr)StationController._springContext.getBean(UIResponsivenessMgr.class);
/* 570 */         uirm.setResponsive(true, 273L);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 578 */         ModeController startupModeController = (ModeController)StationController._modeControllerMap.get(StationController.getStartupApplicationData());
/*     */         
/* 580 */         startupModeController.getUiController().initialize();
/*     */         
/* 582 */         StationController.setCurrentMode(startupModeController.getModeData(), true);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 587 */         ITestHarness testHarness = (ITestHarness)StationController._springContext.getBean(ITestHarness.class);
/* 588 */         if (testHarness.isEnabled()) {
/* 589 */           testHarness.dispatchTestEvent();
/*     */         }
/* 591 */         if (StationController._logger.isInfoEnabled()) {
/* 592 */           StringBuilder sb = new StringBuilder(1024);
/* 593 */           sb.append("STARTED").append(StringUtils.NEW_LINE);
/*     */           try {
/* 595 */             String dateString = DateUtils.format((Date)stationState.getCurrentBusinessDate());
/* 596 */             System.setProperty("dtv.businessDate", dateString);
/* 597 */             sb.append("BusinessDate: ").append(dateString).append(StringUtils.NEW_LINE)
/* 598 */               .append(StringUtils.NEW_LINE);
/*     */           }
/* 600 */           catch (Throwable ex) {
/* 601 */             StationController._logger.error("CAUGHT EXCEPTION", ex);
/*     */           } 
/* 603 */           StationController._logger.info(sb);
/*     */         }
/*     */       
/* 606 */       } catch (Throwable ex) {
/* 607 */         StationController.handleStartupDisaster(ex);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\StationController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */