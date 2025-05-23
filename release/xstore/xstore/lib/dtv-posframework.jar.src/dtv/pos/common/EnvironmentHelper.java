/*     */ package dtv.pos.common;
/*     */ 
/*     */ import dtv.data2.dataserver.config.ConfigHelper;
/*     */ import dtv.ipc.client.Client;
/*     */ import dtv.pos.framework.systemcycle.UpdateProcessor;
/*     */ import dtv.pos.iframework.assistance.ITrainingModeHelper;
/*     */ import dtv.util.jaxb.JaxbHelper;
/*     */ import dtv.util.spring.IgnoreSingletonValidation;
/*     */ import dtv.util.xenvironment.PendingUpdateData;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.time.LocalDateTime;
/*     */ import java.time.ZoneId;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.TreeSet;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import javax.inject.Inject;
/*     */ import javax.inject.Provider;
/*     */ import javax.xml.bind.JAXBException;
/*     */ import org.apache.commons.lang3.builder.ToStringBuilder;
/*     */ import org.apache.log4j.Level;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.apache.log4j.Priority;
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
/*     */ public class EnvironmentHelper
/*     */ {
/*  56 */   private static final Pattern SEPARATOR = Pattern.compile("=");
/*  57 */   private static final Logger _logger = Logger.getLogger(EnvironmentHelper.class);
/*     */ 
/*     */   
/*     */   private static Collection<Character> COMMENT_CHARACTERS;
/*     */ 
/*     */   
/*     */   private static final String DESKTOP = "DESKTOP";
/*     */ 
/*     */   
/*     */   private File _closeMarkerDirectory;
/*     */ 
/*     */   
/*     */   private ConfigHelper _configHelper;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private ITrainingModeHelper _trainingModeHelper;
/*     */ 
/*     */   
/*     */   private String _version;
/*     */ 
/*     */   
/*     */   @Inject
/*     */   private UpdateProcessor _updateProcessor;
/*     */   
/*     */   @IgnoreSingletonValidation(justification = "This provider serves as a factory, creating a new Client on every call.")
/*     */   @Inject
/*     */   private Provider<Client> _ipcClientProvider;
/*     */ 
/*     */   
/*     */   public String getAddress(boolean argIncludePort) {
/*  88 */     String address = this._configHelper.getEnvironmentOptions().getAddress();
/*     */     
/*  90 */     if (argIncludePort) {
/*  91 */       address = address + ":" + getPort();
/*     */     }
/*     */     
/*  94 */     return address;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getEnvironmentVersion() {
/* 103 */     return this._version;
/*     */   }
/*     */   
/*     */   public File getPasswordsFileDest() {
/* 107 */     return new File(this._configHelper.getEnvironmentOptions().getPasswordLocation());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPort() {
/* 116 */     return this._configHelper.getEnvironmentOptions().getPort().intValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public LocalDateTime getUpdateGraceExpiryTime() throws IOException, JAXBException {
/* 121 */     return getPeriodExpiryTime(ConfigurationMgr.getUpdateGracePeriod());
/*     */   }
/*     */ 
/*     */   
/*     */   public LocalDateTime getUpdateRequiredExpiryTime() throws IOException, JAXBException {
/* 126 */     return getPeriodExpiryTime(ConfigurationMgr.getUpdateRequiredPeriod());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasUpdateGracePeriodExpired() {
/*     */     try {
/* 137 */       if (isUpdatePending() && 
/* 138 */         LocalDateTime.now(ZoneId.systemDefault()).isAfter(getPeriodExpiryTime(ConfigurationMgr.getUpdateGracePeriod()))) {
/* 139 */         this._updateProcessor.startIfNeeded();
/* 140 */         return true;
/*     */       }
/*     */     
/* 143 */     } catch (IOException|JAXBException e) {
/* 144 */       _logger.error("CAUGHT EXCEPTION", e);
/*     */     } 
/* 146 */     return false;
/*     */   }
/*     */   
/*     */   public boolean hasUpdateRequiredPeriodExpired() {
/*     */     try {
/* 151 */       return (isUpdatePending() && 
/* 152 */         LocalDateTime.now(ZoneId.systemDefault()).isAfter(getPeriodExpiryTime(ConfigurationMgr.getUpdateRequiredPeriod())));
/*     */     }
/* 154 */     catch (IOException|JAXBException e) {
/* 155 */       _logger.error("CAUGHT EXCEPTION", e);
/* 156 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void init() {
/* 161 */     Set<Character> tempSet = new TreeSet<>();
/* 162 */     tempSet.add(Character.valueOf('#'));
/* 163 */     COMMENT_CHARACTERS = Collections.unmodifiableSet(tempSet);
/* 164 */     this._configHelper = ConfigHelper.getInstance();
/* 165 */     this._closeMarkerDirectory = new File(this._configHelper.getEnvironmentOptions().getCloseMarkerLocation());
/*     */     
/* 167 */     this._version = readVersionPropertiesFile();
/*     */     
/* 169 */     isStoreClosing();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnvironmentEnabled() {
/* 178 */     return this._configHelper.getEnvironmentOptions().isEnabled();
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
/*     */   public boolean isStoreClosing() {
/* 191 */     return (!this._trainingModeHelper.isTrainingMode() && checkMarker(getCloseMarkerFilter()));
/*     */   }
/*     */   
/*     */   public boolean isUpdatePending() {
/* 195 */     return getUpdateMarkerFile().toFile().exists();
/*     */   }
/*     */   
/*     */   public void notifyReadyForUpdate() {
/* 199 */     Client ipcClient = (Client)this._ipcClientProvider.get();
/* 200 */     ipcClient.setHostString(this._configHelper.getEnvironmentOptions().getAddress() + ':' + this._configHelper
/* 201 */         .getEnvironmentOptions().getPort() + "/xstore");
/* 202 */     ipcClient.setMethod(this._configHelper.getEnvironmentOptions().getApplyUpdatesMethodName());
/*     */ 
/*     */ 
/*     */     
/* 206 */     String formFactor = (System.getProperty("dtv.location.device.formfactor") == null) ? "DESKTOP" : System.getProperty("dtv.location.device.formfactor");
/*     */     
/* 208 */     Map<String, String> paramMap = new HashMap<>();
/* 209 */     paramMap.put("dtv.location.device.formfactor", formFactor);
/* 210 */     ipcClient.setParameterMap(paramMap);
/*     */     
/* 212 */     ipcClient.call();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void storeIsClosing() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 228 */     return (new ToStringBuilder(this)).append("class", getClass().getName())
/* 229 */       .append("passwordLocation", this._configHelper.getEnvironmentOptions().getPasswordLocation())
/* 230 */       .append("versionLocation", this._configHelper.getEnvironmentOptions().getVersionLocation())
/* 231 */       .appendSuper(super.toString()).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean checkMarker(FileFilter argFileFilter) {
/* 242 */     if (isEnvironmentEnabled()) {
/*     */       File[] files;
/*     */       
/*     */       try {
/* 246 */         files = this._closeMarkerDirectory.listFiles(argFileFilter);
/*     */ 
/*     */ 
/*     */       
/*     */       }
/* 251 */       catch (SecurityException ex) {
/* 252 */         _logger.error("Unable to read environment close marker directory", ex);
/* 253 */         return false;
/*     */       } 
/*     */       
/* 256 */       if (files == null) {
/* 257 */         _logger.error("Unable to retrieve directory listing for file [" + this._closeMarkerDirectory + ']');
/* 258 */         return false;
/*     */       } 
/* 260 */       if (files.length > 0)
/*     */       {
/* 262 */         return true;
/*     */       }
/*     */     } 
/* 265 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FileFilter getCloseMarkerFilter() {
/* 274 */     return new MarkerFilter();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private LocalDateTime getPeriodExpiryTime(int argPeriodInSeconds) throws IOException, JAXBException {
/* 280 */     PendingUpdateData data = (PendingUpdateData)JaxbHelper.unmarshalXml(PendingUpdateData.class, getUpdateMarkerFile().toFile());
/*     */     
/* 282 */     return LocalDateTime.parse(data.getGracePeriodStartTime()).plusSeconds(argPeriodInSeconds);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Path getUpdateMarkerFile() {
/* 290 */     return Paths.get(this._configHelper.getEnvironmentOptions().getCloseMarkerLocation(), new String[] { this._configHelper
/* 291 */           .getEnvironmentOptions().getUpdatesPendingMarkerFileName() });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String readVersionPropertiesFile() {
/* 302 */     File file = new File(this._configHelper.getEnvironmentOptions().getVersionLocation());
/*     */     
/* 304 */     if (!file.exists()) {
/* 305 */       Level level = isEnvironmentEnabled() ? Level.ERROR : Level.DEBUG;
/* 306 */       _logger.log((Priority)level, "Failed to load environment version file [" + file.getAbsolutePath() + "] because it does not exist");
/*     */     }
/*     */     else {
/*     */       
/* 310 */       try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
/* 311 */         for (String line = reader.readLine(); line != null; line = reader.readLine()) {
/* 312 */           String lineTrimmed = line.trim();
/*     */ 
/*     */           
/* 315 */           if (!lineTrimmed.isEmpty() && !COMMENT_CHARACTERS.contains(Character.valueOf(lineTrimmed.charAt(0)))) {
/*     */ 
/*     */ 
/*     */             
/* 319 */             String[] parts = SEPARATOR.split(line, 2);
/*     */             
/* 321 */             if (parts.length != 0) {
/*     */ 
/*     */ 
/*     */               
/* 325 */               String key = parts[0].trim();
/* 326 */               if ("environment.longversion".equals(key))
/* 327 */                 return (parts.length > 1) ? parts[1].trim() : ""; 
/*     */             } 
/*     */           } 
/*     */         } 
/* 331 */       } catch (FileNotFoundException e) {
/* 332 */         _logger.error("File not found loading environment properties file: [" + file + ']', e);
/*     */       }
/* 334 */       catch (IOException ex) {
/* 335 */         _logger.error("I/O error loading environment properties file [" + file + ']', ex);
/*     */       } 
/*     */     } 
/* 338 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class MarkerFilter
/*     */     implements FileFilter
/*     */   {
/* 349 */     private static final Pattern DEFAULT_PATTERN = Pattern.compile("^.*(reg|sys)close.*(\\.xst)$");
/* 350 */     private static final Logger filterLogger_ = Logger.getLogger(MarkerFilter.class);
/* 351 */     private final Pattern _pattern = DEFAULT_PATTERN;
/*     */ 
/*     */     
/*     */     public final boolean accept(File pathname) {
/*     */       String path;
/* 356 */       if (this._pattern == null) {
/* 357 */         return true;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 364 */         path = pathname.getCanonicalPath();
/*     */       }
/* 366 */       catch (IOException ex) {
/* 367 */         filterLogger_.error("IOException parsing file path for file [" + pathname + ']', ex);
/* 368 */         return false;
/*     */       } 
/*     */ 
/*     */       
/* 372 */       Matcher matcher = this._pattern.matcher(path);
/* 373 */       return matcher.matches();
/*     */     }
/*     */     
/*     */     private MarkerFilter() {}
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\common\EnvironmentHelper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */