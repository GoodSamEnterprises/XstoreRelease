/*     */ package dtv.pos.framework.keycommands;
/*     */ 
/*     */ import dtv.pos.common.ViewElementType;
/*     */ import dtv.pos.framework.ui.component.XstList;
/*     */ import dtv.pos.framework.ui.model.DefaultListInputModel;
/*     */ import dtv.pos.framework.version.SchemaVersionScope;
/*     */ import dtv.pos.framework.version.VersionHelper;
/*     */ import dtv.pos.iframework.IModeController;
/*     */ import dtv.pos.iframework.ui.IViewElementType;
/*     */ import dtv.pos.iframework.ui.IXstViewComponent;
/*     */ import dtv.pos.iframework.ui.RendererDef;
/*     */ import dtv.ui.UIResourceManager;
/*     */ import dtv.ui.model.ICombinedListModel;
/*     */ import dtv.util.StringUtils;
/*     */ import java.awt.GraphicsEnvironment;
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Properties;
/*     */ import java.util.Set;
/*     */ import java.util.StringTokenizer;
/*     */ import java.util.TreeSet;
/*     */ import javax.inject.Inject;
/*     */ import javax.inject.Provider;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.KeyStroke;
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
/*     */ public class VersionDebugger
/*     */   implements IKeyCommand, IHotKeyCommand
/*     */ {
/*  43 */   private static final Logger logger_ = Logger.getLogger(VersionDebugger.class);
/*  44 */   private static final String SEPARATOR = StringUtils.NEW_LINE + StringUtils.fill("*", 20) + StringUtils.NEW_LINE;
/*  45 */   private static List<SystemProperty> SYSTEM_PROPERTIES = null;
/*     */   
/*     */   @Inject
/*     */   private Provider<IModeController> _modeProvider;
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/*  52 */     StringBuilder sb = new StringBuilder(2048);
/*  53 */     VersionDebugger debugger = new VersionDebugger();
/*  54 */     debugger.getRuntimeInformation(sb);
/*  55 */     System.out.println(sb);
/*     */   }
/*     */   
/*     */   private static List<SystemProperty> getPathProperties() {
/*  59 */     String[] pathPropKeys = { "dtv.base.config.path", "dtv.config.path", "dtv.system.properties.locations", "java.class.path", "java.library.path" };
/*     */     
/*  61 */     List<SystemProperty> pathProperties = new ArrayList<>();
/*     */     
/*  63 */     for (String key : pathPropKeys) {
/*  64 */       String value = System.getProperty(key);
/*     */       
/*  66 */       if (value != null) {
/*  67 */         pathProperties.add(new SystemProperty(key, value));
/*     */       }
/*     */     } 
/*     */     
/*  71 */     return pathProperties;
/*     */   }
/*     */ 
/*     */   
/*     */   private static List<SystemProperty> getSystemProperties() {
/*  76 */     if (SYSTEM_PROPERTIES == null) {
/*     */       try {
/*  78 */         SYSTEM_PROPERTIES = loadSystemProperties();
/*     */       }
/*  80 */       catch (Throwable ex) {
/*  81 */         logger_.error(ex);
/*     */       } 
/*     */     }
/*     */     
/*  85 */     return SYSTEM_PROPERTIES;
/*     */   }
/*     */ 
/*     */   
/*     */   private static List<Object> getVersionInfo() {
/*  90 */     List<Object> versions = new ArrayList();
/*  91 */     versions.add(VersionHelper.getInstance().getAppVersionInfo());
/*     */ 
/*     */     
/*  94 */     versions.add(VersionHelper.getInstance().getSchemaVersionInfo(SchemaVersionScope.LOCAL));
/*  95 */     versions.add(VersionHelper.getInstance().getSchemaVersionInfo(SchemaVersionScope.STORE));
/*  96 */     versions.add(VersionHelper.getInstance().getSchemaVersionInfo(SchemaVersionScope.CENTRAL));
/*     */     
/*  98 */     return versions;
/*     */   }
/*     */ 
/*     */   
/*     */   private static List<SystemProperty> loadSystemProperties() {
/* 103 */     Set<SystemProperty> properties = new TreeSet<>();
/* 104 */     Properties props = System.getProperties();
/*     */ 
/*     */ 
/*     */     
/* 108 */     for (Object o : props.keySet()) {
/* 109 */       String key = (String)o;
/* 110 */       String value = (String)props.get(key);
/* 111 */       properties.add(new SystemProperty(key, value));
/*     */     } 
/*     */     
/* 114 */     return new ArrayList<>(properties);
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
/*     */   public void displayRuntimeInformation() {
/* 131 */     IXstViewComponent versionDialog = new VersionList(getVersionInfo(), ViewElementType.valueOf("VERSIONS"));
/*     */     
/* 133 */     ((IModeController)this._modeProvider
/* 134 */       .get())
/* 135 */       .getUiController()
/* 136 */       .showDialog(versionDialog, VersionHelper.getInstance().getAppVersionInfo().toString(), null, true, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void execute() {
/* 143 */     boolean shouldLog = true;
/*     */     
/* 145 */     if (!GraphicsEnvironment.isHeadless()) {
/*     */       try {
/* 147 */         displayRuntimeInformation();
/* 148 */         shouldLog = false;
/*     */       }
/* 150 */       catch (Throwable ex) {
/* 151 */         logger_.error("CAUGHT EXCEPTION", ex);
/*     */       } 
/*     */     }
/*     */     
/* 155 */     if (shouldLog) {
/*     */       
/* 157 */       StringBuilder sb = new StringBuilder(2048);
/* 158 */       getRuntimeInformation(sb);
/* 159 */       logger_.info(sb);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void fillPathPropertyInformation(StringBuilder argBuilder) {
/* 168 */     argBuilder.append(SEPARATOR);
/* 169 */     argBuilder.append("PATH PROPERTIES");
/* 170 */     argBuilder.append(SEPARATOR);
/*     */     
/* 172 */     for (SystemProperty o : getPathProperties()) {
/* 173 */       StringUtils.appendLine(argBuilder, StringUtils.nonNull(o));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void fillSystemPropertyInformation(StringBuilder argBuilder) {
/* 179 */     for (SystemProperty o : getSystemProperties()) {
/* 180 */       StringUtils.appendLine(argBuilder, StringUtils.nonNull(o));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCommand() {
/* 187 */     return "v";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getHelpText() {
/* 193 */     return "displays version information";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public KeyStroke getKeyStroke() {
/* 199 */     return KeyStroke.getKeyStroke(86, 8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StringBuilder getRuntimeInformation(StringBuilder argSb) {
/* 209 */     argSb.append(SEPARATOR);
/* 210 */     argSb.append("VERSION INFORMATION");
/* 211 */     argSb.append(SEPARATOR);
/*     */     
/* 213 */     if (getVersionInfo() != null) {
/* 214 */       for (Object o : getVersionInfo()) {
/* 215 */         StringUtils.appendLine(argSb, StringUtils.nonNull(o));
/*     */       }
/*     */     }
/*     */     
/* 219 */     StringUtils.appendLine(argSb);
/*     */     
/* 221 */     return argSb;
/*     */   }
/*     */   
/*     */   private static class SystemProperty implements Comparable<SystemProperty> {
/*     */     private final String name_;
/*     */     private final List<String> values_;
/*     */     private String toString_;
/*     */     
/*     */     private static String getValueSeparator(String argName) {
/* 230 */       if ("java.class.path".equals(argName) || "java.library.path".equals(argName)) {
/* 231 */         return File.pathSeparator;
/*     */       }
/* 233 */       return ";";
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private static List<String> toValueList(String argSeparator, String argValues) {
/* 239 */       List<String> valueList = new ArrayList<>();
/* 240 */       StringTokenizer st = new StringTokenizer(argValues, argSeparator);
/*     */       
/* 242 */       while (st.hasMoreTokens()) {
/* 243 */         valueList.add(st.nextToken());
/*     */       }
/*     */       
/* 246 */       return valueList;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     SystemProperty(String argName, List<String> argValues) {
/* 257 */       this.name_ = argName;
/* 258 */       this.values_ = argValues;
/*     */     }
/*     */ 
/*     */     
/*     */     SystemProperty(String argName, String argValues) {
/* 263 */       this(argName, toValueList(getValueSeparator(argName), argValues));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int compareTo(SystemProperty argObj) {
/* 269 */       return this.name_.compareTo(argObj.name_);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 275 */       if (this.toString_ == null) {
/* 276 */         StringBuilder sb = new StringBuilder();
/* 277 */         sb.append(this.name_);
/* 278 */         sb.append(" = ");
/*     */         
/* 280 */         for (int i = 0; i < this.values_.size(); i++) {
/* 281 */           sb.append((i == 0) ? this.values_.get(i) : (StringUtils.NEW_LINE + "     " + (String)this.values_.get(i)));
/*     */         }
/*     */         
/* 284 */         this.toString_ = sb.toString();
/*     */       } 
/*     */       
/* 287 */       return this.toString_;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class VersionList
/*     */     implements IXstViewComponent
/*     */   {
/*     */     private final XstList list_;
/*     */     
/*     */     private static ICombinedListModel<Object> getListModel(List<Object> argData) {
/* 297 */       DefaultListInputModel defaultListInputModel = new DefaultListInputModel();
/* 298 */       defaultListInputModel.getSelectionModel().setSelectionMode(0);
/* 299 */       defaultListInputModel.getModel().setElements(argData);
/*     */       
/* 301 */       return (ICombinedListModel<Object>)defaultListInputModel;
/*     */     }
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
/*     */     public VersionList(List<Object> argData, IViewElementType argListType) {
/* 315 */       this.list_ = new XstList(getListModel(argData));
/*     */       
/* 317 */       RendererDef def = new RendererDef(argListType);
/* 318 */       this.list_.setColumnHeaderRendererDef(def);
/* 319 */       this.list_.setCellRendererDef(def);
/*     */       
/* 321 */       this.list_.getModel().getSelectionModel().selectFirst();
/* 322 */       this.list_.getDisplayComponent().setPreferredSize(
/* 323 */           UIResourceManager.getInstance().getDimension("_sizeVersionPopup"));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public JComponent getDisplayComponent() {
/* 329 */       return this.list_.getDisplayComponent();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public JComponent getFocusComponent() {
/* 335 */       return this.list_.getFocusComponent();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\keycommands\VersionDebugger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */