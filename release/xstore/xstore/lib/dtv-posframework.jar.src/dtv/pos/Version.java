/*     */ package dtv.pos;
/*     */ 
/*     */ import dtv.pos.framework.version.UniversalVersion;
/*     */ import dtv.pos.framework.version.VersionFormatter;
/*     */ import dtv.pos.framework.version.VersionHelper;
/*     */ import dtv.util.DateUtils;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.swing.JOptionPane;
/*     */ import org.apache.log4j.Logger;
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
/*     */ public abstract class Version
/*     */ {
/*     */   private static final String APP_SHORT_TITLE = "Xstore";
/*     */   private static final String APP_LONG_TITLE = "Oracle Retail Xstore Point of Service";
/*     */   private static final String VERSION = "16.0.5.0.38";
/*     */   private static final String VERSION_IMPL = ".pos.Version";
/*     */   private static final String CUST_ID_PROP = "dtv.CustomerId";
/*  32 */   private static String BUILD_DATE = "2019-03-25T20:15:33-0400";
/*  33 */   private static String releaseVersion_ = null;
/*     */   
/*  35 */   private static Version instance_ = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getBaseVersion() {
/*  42 */     return "16.0.5.0.38";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date getBuildDate() {
/*  50 */     return DateUtils.parseIso(BUILD_DATE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Date getCustomerBuildDate() {
/*  58 */     return getVersionInstance().getCustomerBuildDateImpl();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getCustomerVersion() {
/*  66 */     return getVersionInstance().getCustomerVersionImpl();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<String> getHashCodes() {
/*  73 */     return getVersionInstance().hashCodes();
/*     */   }
/*     */   
/*     */   public static String getLongTitle() {
/*  77 */     return "Oracle Retail Xstore Point of Service";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getPatchVersion() {
/*  85 */     return getVersionInstance().getPatchVersionImpl();
/*     */   }
/*     */   
/*     */   public static String getReleaseVersion() {
/*  89 */     if (releaseVersion_ == null) {
/*  90 */       synchronized (Version.class) {
/*  91 */         UniversalVersion version = VersionHelper.getAppVersion(true);
/*  92 */         releaseVersion_ = VersionFormatter.createStandardFormatter().format(version);
/*     */       } 
/*     */     }
/*  95 */     return releaseVersion_;
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
/*     */   public static String getShortBaseVersion() {
/* 107 */     String[] versionParts = "16.0.5.0.38".split("\\.");
/* 108 */     String[] shortVersionParts = new String[4];
/*     */     
/* 110 */     shortVersionParts[0] = versionParts[0];
/* 111 */     shortVersionParts[1] = versionParts[1];
/* 112 */     shortVersionParts[2] = versionParts[2];
/* 113 */     shortVersionParts[3] = versionParts[4];
/*     */     
/* 115 */     String shortVersion = String.join(".", (CharSequence[])shortVersionParts);
/*     */     
/* 117 */     return shortVersion;
/*     */   }
/*     */   
/*     */   public static String getShortTitle() {
/* 121 */     return "Xstore";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static String getTitle() {
/* 130 */     return getShortTitle();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getVersion() {
/* 138 */     return getReleaseVersion();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/* 147 */     String message = "The " + getShortTitle() + " version is " + getBaseVersion() + " built " + getBuildDate() + ".";
/*     */     try {
/* 149 */       JOptionPane.showMessageDialog(null, message, getLongTitle() + " version", 1);
/*     */     
/*     */     }
/* 152 */     catch (Throwable ex) {
/* 153 */       System.out.println(message);
/*     */     } 
/* 155 */     System.exit(0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static Version getInstance() {
/* 161 */     if (instance_ == null) {
/* 162 */       String customerId = System.getProperty("dtv.CustomerId");
/*     */       
/* 164 */       if (customerId != null) {
/* 165 */         String impl = customerId.toLowerCase() + ".pos.Version";
/*     */         try {
/* 167 */           instance_ = (Version)Version.class.getClassLoader().loadClass(impl).newInstance();
/*     */         }
/* 169 */         catch (ClassNotFoundException ex) {
/*     */ 
/*     */           
/* 172 */           Logger logger_ = Logger.getLogger(Version.class);
/* 173 */           logger_.error("Unable to find version class of type '" + impl + "' from overlay.");
/* 174 */           instance_ = new BaseVersionImpl();
/*     */         }
/* 176 */         catch (Exception ex) {
/* 177 */           Logger logger_ = Logger.getLogger(Version.class);
/* 178 */           logger_.error("Unable to instantiate version class from overlay", ex);
/* 179 */           instance_ = new BaseVersionImpl();
/*     */         } 
/*     */       } else {
/*     */         
/* 183 */         instance_ = new BaseVersionImpl();
/*     */       } 
/*     */     } 
/*     */     
/* 187 */     return instance_;
/*     */   }
/*     */   
/*     */   private static Version getVersionInstance() {
/* 191 */     return VersionHolder.versionInstance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> hashCodes() {
/* 199 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract Date getCustomerBuildDateImpl();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract String getCustomerVersionImpl();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract String getPatchVersionImpl();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class BaseVersionImpl
/*     */     extends Version
/*     */   {
/*     */     public List<String> hashCodes() {
/* 226 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected Date getCustomerBuildDateImpl() {
/* 232 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected String getCustomerVersionImpl() {
/* 238 */       return "?.?.?";
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected String getPatchVersionImpl() {
/* 244 */       return "?.?";
/*     */     }
/*     */   }
/*     */   
/*     */   private static class VersionHolder
/*     */   {
/* 250 */     private static final Version versionInstance = Version.getInstance();
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\Version.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */