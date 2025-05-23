/*      */ package dtv.pos.framework.form.design;
/*      */ import dtv.pos.common.FormKey;
/*      */ import dtv.pos.framework.action.type.ActionType;
/*      */ import dtv.pos.framework.form.LayoutLocation;
/*      */ import dtv.pos.framework.form.component.FormPanel;
/*      */ import dtv.pos.framework.form.component.IMasterDetailFormPanel;
/*      */ import dtv.pos.framework.form.config.AbstractFormComponentConfig;
/*      */ import dtv.pos.framework.form.config.FormViewCellConfig;
/*      */ import dtv.pos.framework.form.config.FormViewPanelConfig;
/*      */ import dtv.pos.framework.form.config.FormViewSectionConfig;
/*      */ import dtv.pos.framework.form.config.FormViewSectionRefConfig;
/*      */ import dtv.pos.framework.form.design.dialog.BlockingMessageDialog;
/*      */ import dtv.pos.framework.form.design.dialog.EditRowColumnSizeDialog;
/*      */ import dtv.pos.framework.form.design.dialog.FormPreviewDialog;
/*      */ import dtv.pos.framework.form.design.dialog.InsertComponentDialog;
/*      */ import dtv.pos.framework.form.design.dialog.IntegerInputDialog;
/*      */ import dtv.pos.framework.form.design.dialog.ListSelectorFrame;
/*      */ import dtv.pos.framework.ui.config.ActionConfig;
/*      */ import dtv.pos.iframework.action.DataActionGroupKey;
/*      */ import dtv.pos.iframework.form.ILayoutLocation;
/*      */ import dtv.pos.iframework.form.config.IFormComponentConfig;
/*      */ import dtv.pos.iframework.form.config.IFormViewCellConfig;
/*      */ import dtv.pos.iframework.form.config.IFormViewConfig;
/*      */ import dtv.pos.iframework.form.config.IFormViewPanelConfig;
/*      */ import dtv.pos.iframework.form.config.IFormViewSectionConfig;
/*      */ import dtv.pos.iframework.form.design.model.ILayoutParameters;
/*      */ import dtv.pos.iframework.form.design.type.FormComponentType;
/*      */ import dtv.pos.iframework.form.design.type.FormPreviewType;
/*      */ import dtv.pos.iframework.ui.config.IViewComponentConfig;
/*      */ import dtv.pos.iframework.ui.model.IFormModel;
/*      */ import dtv.pos.ui.UIServices;
/*      */ import dtv.ui.UIServices;
/*      */ import java.awt.Component;
/*      */ import java.awt.Container;
/*      */ import java.awt.Point;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.io.File;
/*      */ import java.io.IOException;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JComponent;
/*      */ import javax.swing.JFileChooser;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JMenu;
/*      */ import javax.swing.JMenuItem;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JSplitPane;
/*      */ import javax.swing.JTabbedPane;
/*      */ import javax.swing.OverlayLayout;
/*      */ import javax.swing.event.ChangeEvent;
/*      */ import javax.swing.event.ChangeListener;
/*      */ import javax.swing.tree.DefaultMutableTreeNode;
/*      */ import javax.swing.tree.TreePath;
/*      */ 
/*      */ public class FormDesigner extends JPanel implements IFormDesigner, IFormComponentSelectionListener {
/*   62 */   protected static final Integer INT_ZERO = Integer.valueOf(0);
/*   63 */   protected static final Logger logger_ = Logger.getLogger(FormDesigner.class);
/*      */   
/*   65 */   protected static int threadIndex_ = 0;
/*      */   
/*      */   private static String initialForm_;
/*      */   
/*      */   private static int screenNumberCommandArg_;
/*   70 */   private static String saveToDir_ = "config/dtv/res/config/form"; private static final String SPRING_DEFAULT_ACTIVE_PROFILES = "retail,xstore,formDesigner"; private static final long serialVersionUID = 1L; private static ConfigurableApplicationContext _springContext; protected final IFormDesignerHost host_; protected JMenuItem addComponentPopupItem_; protected JTree componentTree_; protected JMenuItem deleteComponentPopupItem_; protected JMenuItem deletePanelPopupItem_; protected JScrollPane detailEditScrollPane_; protected FormDesignerDetailModel detailModel_; protected FormDesignerDetailView detailView_; protected JMenuItem editColumnWidthPopupItem_; protected JMenuItem editRowHeightPopupItem_; protected FormPanel<IFormModel> form_; protected JMenu formCellPopupMenu_; protected JComponent formComponent_; protected FormViewConfigHelper formHelper_; protected JSplitPane formHorizontalSplit_; protected FormKey formKey_; protected JPanel formPanel_; protected OverlayLayout formPanelLayout_; protected JMenu formPanelPopupMenu_; protected JScrollPane formScrollPane_; protected JLabel formSourceLabel_; protected GlassPanel glassPanel_; protected JSplitPane mainSplit_; protected JMenu menuColumn_; protected JMenuItem menuColumnDelete_; protected JMenuItem menuColumnEditWidth_; protected JMenuItem menuColumnInsert_; protected JMenu menuFile_; protected JMenuItem menuFileExit_; protected JMenuItem menuFileOpen_; protected JMenuItem menuFileSave_; protected JMenuItem menuFileSetSaveToDir_;
/*      */   protected JMenu menuInsert_;
/*      */   protected JMenuItem menuInsertColumn_;
/*      */   protected JMenuItem menuInsertComponent_;
/*      */   protected JMenuItem menuInsertPanel_;
/*      */   protected JMenuItem menuInsertSectionRef_;
/*      */   protected JMenuItem menuInsertSection_;
/*      */   protected JMenuItem menuInsertRow_;
/*      */   protected JMenu menuRow_;
/*      */   
/*      */   public static IFormDesigner getFormDesigner(IFormDesignerHost argHost, File argFormConfigDir, FormKey argFormKeyToEdit) {
/*   81 */     return new FormDesigner(argFormConfigDir, argHost, argFormKeyToEdit);
/*      */   }
/*      */   protected JMenuItem menuRowDelete_; protected JMenuItem menuRowEditHeight_; protected JMenuItem menuRowInsert_; protected List<JMenu> menus_; protected JMenu menuView_; protected JMenuItem menuViewPreview_; protected JCheckBoxMenuItem menuViewScrollable_; protected JButton openButton_; protected JButton saveButton_; protected JToolBar toolBar_; protected FormViewConfigTreeModel treeModel_; protected JScrollPane treeScrollPane_; protected boolean useFormScrollBars_; protected FormViewConfig viewConfig_; protected JLabel workingDirLabel_; protected JMenuItem deleteSectionPopupItem_; protected JMenuItem deleteSectionRefPopupItem_; protected JMenu sectionPopupMenu_; protected JMenu sectionRefPopupMenu_; protected ChangeListener tabChangeListener_;
/*      */   private final ActionListener deleteColumnAction_;
/*      */   
/*      */   public static void initGlobals() throws IOException {
/*   87 */     (new SystemPropertiesLoader()).loadSystemProperties();
/*      */     
/*   89 */     UIServices.setDesignModeScreenBounds();
/*   90 */     setLookAndFeel();
/*      */     
/*   92 */     springify();
/*      */   }
/*      */   private final ActionListener deleteComponentAction_; private final ActionListener deletePanelAction_; private final ActionListener deleteSectionAction_; private final ActionListener deleteSectionRefAction_; private final ActionListener deleteRowAction_; private final ActionListener editColumnWidthAction_; private final ActionListener editRowHeightAction_; private final ActionListener exitAction_; private final MouseListener formMouseListener_; private final ActionListener insertColumnAction_; private final ActionListener insertComponentAction_; private final ActionListener insertPanelAction_; private final ActionListener insertSectionRefAction_; private final ActionListener insertSectionAction_; private final ActionListener insertRowAction_; private final ActionListener openAction_; private final ActionListener previewAction_; private final ActionListener saveAction_; private final ChangeListener scrollableChangeAction_; private final ActionListener setSaveToDirAction_; private final MouseListener treeMouseListener_;
/*      */   private File workingDir_;
/*      */   
/*      */   public static void main(String[] args) {
/*      */     try {
/*   99 */       parseArgs(args);
/*  100 */       initGlobals();
/*  101 */       UIServices.setDefaultScreen(screenNumberCommandArg_);
/*  102 */       UIServices.setDesignModeScreenBounds();
/*  103 */       FormKey key = null;
/*  104 */       if (initialForm_ != null) {
/*  105 */         key = FormKey.valueOf(initialForm_);
/*      */       }
/*      */       
/*  108 */       FormDesignerHost frame = new FormDesignerHost();
/*  109 */       File saveToDir = new File(saveToDir_);
/*  110 */       if (!saveToDir.exists() || !saveToDir.canWrite()) {
/*  111 */         saveToDir = getSaveToDir(frame, new File("."));
/*      */       }
/*  113 */       frame.setFormDesigner(new FormDesigner(saveToDir, frame, key));
/*  114 */       frame.setVisible(true);
/*      */     
/*      */     }
/*  117 */     catch (UnsupportedOperationException ex) {
/*  118 */       logger_.info("User canceled out of initial form selection dialog", ex);
/*  119 */       System.exit(0);
/*      */     }
/*  121 */     catch (Throwable t) {
/*  122 */       logger_.fatal("CAUGHT EXCEPTION", t);
/*  123 */       System.exit(-1);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected static IFormComponentConfig<?> getAssociatedConfig(Component c) {
/*  129 */     if (!(c instanceof JComponent)) {
/*  130 */       return null;
/*      */     }
/*      */     
/*  133 */     JComponent jc = (JComponent)c;
/*      */ 
/*      */     
/*  136 */     IFormComponentConfig<?> config = (IFormComponentConfig)jc.getClientProperty(IFormComponent.CONFIG_PROPERTY_KEY);
/*  137 */     if (config != null) {
/*  138 */       return config;
/*      */     }
/*      */     
/*  141 */     if (c.getParent() == c) {
/*  142 */       return null;
/*      */     }
/*  144 */     return getAssociatedConfig(c.getParent());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected static File getSaveToDir(Frame parent, File saveToDir) throws UnsupportedOperationException {
/*  150 */     JFileChooser chooser = new JFileChooser(saveToDir);
/*  151 */     chooser.setDialogTitle("Select working directory (where you would like your changes saved)");
/*  152 */     chooser.setFileSelectionMode(1);
/*      */     while (true) {
/*  154 */       if (0 != chooser.showDialog(parent, "Select")) {
/*  155 */         throw new UnsupportedOperationException();
/*      */       }
/*      */       
/*  158 */       if (chooser.getSelectedFile().canWrite())
/*  159 */         return chooser.getSelectedFile(); 
/*      */     } 
/*      */   }
/*      */   private static void parseArgs(String[] args) {
/*  163 */     screenNumberCommandArg_ = 0;
/*      */     
/*      */     try {
/*  166 */       for (int i = 0; i < args.length; i++) {
/*  167 */         if (args[i].startsWith("-") || args[i].startsWith("/")) {
/*  168 */           switch (args[i].charAt(1)) {
/*      */             case 'f':
/*  170 */               initialForm_ = args[++i];
/*      */               break;
/*      */             
/*      */             case 'd':
/*  174 */               saveToDir_ = args[++i];
/*      */               break;
/*      */             
/*      */             case 's':
/*      */               try {
/*  179 */                 screenNumberCommandArg_ = Integer.parseInt(args[++i]);
/*      */               }
/*  181 */               catch (Exception ex) {
/*  182 */                 logger_.error("Problem parsing screen number '" + args[i] + "'");
/*      */               } 
/*      */               break;
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         }
/*      */       } 
/*  192 */     } catch (Exception ex) {
/*  193 */       logger_.error("CAUGHT EXCEPTION", ex);
/*      */     } 
/*      */   }
/*      */   
/*      */   private static void setLookAndFeel() {
/*  198 */     DtvUIManager.install();
/*  199 */     MetalLookAndFeel.setCurrentTheme((MetalTheme)new DefaultPosMetalTheme());
/*      */     try {
/*  201 */       UIManager.setLookAndFeel(UIManager.getLookAndFeel());
/*      */     }
/*  203 */     catch (Exception ex) {
/*  204 */       logger_.error("CAUGHT EXCEPTION", ex);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void springify() {
/*  212 */     String springProfiles = System.getProperty("spring.profiles.active");
/*      */     
/*  214 */     if (springProfiles == null) {
/*  215 */       System.setProperty("spring.profiles.active", "retail,xstore,formDesigner");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  221 */     String[] files = ClassPathUtils.getDirectoryBasedConfigFileListRelativePaths("spring", (INameFilter)new EndsWithNameFilter(new String[] { ".xml" }));
/*      */ 
/*      */     
/*  224 */     new ClassPathXmlApplicationContext(files);
/*      */   }
/*      */   
/*      */   protected FormDesigner(File argFormConfigDir, IFormDesignerHost argHost, FormKey argFormKey) {
/*      */     FormKey key;
/*  229 */     this.addComponentPopupItem_ = new JMenuItem();
/*  230 */     this.componentTree_ = new JTree();
/*  231 */     this.deleteComponentPopupItem_ = new JMenuItem();
/*  232 */     this.deletePanelPopupItem_ = new JMenuItem();
/*  233 */     this.detailEditScrollPane_ = new JScrollPane();
/*  234 */     this.detailModel_ = new FormDesignerDetailModel(this);
/*  235 */     this.detailView_ = new FormDesignerDetailView(this.detailModel_);
/*  236 */     this.editColumnWidthPopupItem_ = new JMenuItem();
/*  237 */     this.editRowHeightPopupItem_ = new JMenuItem();
/*  238 */     this.form_ = null;
/*  239 */     this.formCellPopupMenu_ = new JMenu();
/*  240 */     this.formComponent_ = new JLabel("FORM VIEW");
/*      */     
/*  242 */     this.formHorizontalSplit_ = new JSplitPane();
/*      */     
/*  244 */     this.formPanel_ = new JPanel();
/*  245 */     this.formPanelLayout_ = new OverlayLayout(this.formPanel_);
/*  246 */     this.formPanelPopupMenu_ = new JMenu();
/*  247 */     this.formScrollPane_ = new JScrollPane();
/*  248 */     this.formSourceLabel_ = new JLabel();
/*  249 */     this.glassPanel_ = new GlassPanel();
/*  250 */     this.mainSplit_ = new JSplitPane();
/*  251 */     this.menuColumn_ = new JMenu();
/*  252 */     this.menuColumnDelete_ = new JMenuItem();
/*  253 */     this.menuColumnEditWidth_ = new JMenuItem();
/*  254 */     this.menuColumnInsert_ = new JMenuItem();
/*  255 */     this.menuFile_ = new JMenu();
/*  256 */     this.menuFileExit_ = new JMenuItem();
/*  257 */     this.menuFileOpen_ = new JMenuItem();
/*  258 */     this.menuFileSave_ = new JMenuItem();
/*  259 */     this.menuFileSetSaveToDir_ = new JMenuItem();
/*  260 */     this.menuInsert_ = new JMenu();
/*  261 */     this.menuInsertColumn_ = new JMenuItem();
/*  262 */     this.menuInsertComponent_ = new JMenuItem();
/*  263 */     this.menuInsertPanel_ = new JMenuItem();
/*  264 */     this.menuInsertSectionRef_ = new JMenuItem();
/*  265 */     this.menuInsertSection_ = new JMenuItem();
/*  266 */     this.menuInsertRow_ = new JMenuItem();
/*  267 */     this.menuRow_ = new JMenu();
/*  268 */     this.menuRowDelete_ = new JMenuItem();
/*  269 */     this.menuRowEditHeight_ = new JMenuItem();
/*  270 */     this.menuRowInsert_ = new JMenuItem();
/*  271 */     this.menus_ = new ArrayList<>();
/*  272 */     this.menuView_ = new JMenu();
/*  273 */     this.menuViewPreview_ = new JMenuItem();
/*  274 */     this.menuViewScrollable_ = new JCheckBoxMenuItem();
/*  275 */     this.openButton_ = new JButton();
/*  276 */     this.saveButton_ = new JButton();
/*  277 */     this.toolBar_ = new JToolBar();
/*      */     
/*  279 */     this.treeScrollPane_ = new JScrollPane();
/*  280 */     this.useFormScrollBars_ = false;
/*      */     
/*  282 */     this.workingDirLabel_ = new JLabel();
/*  283 */     this.deleteSectionPopupItem_ = new JMenuItem();
/*  284 */     this.deleteSectionRefPopupItem_ = new JMenuItem();
/*  285 */     this.sectionPopupMenu_ = new JMenu();
/*  286 */     this.sectionRefPopupMenu_ = new JMenu();
/*      */     
/*  288 */     this.tabChangeListener_ = new ChangeListener()
/*      */       {
/*      */         public void stateChanged(ChangeEvent changeEvent)
/*      */         {
/*      */           try {
/*  293 */             FormDesigner.this.setSelectedFormComponent(null);
/*  294 */             if (FormDesigner.this.form_ instanceof IMasterDetailFormPanel) {
/*  295 */               FormPanel<IFormModel> p = ((IMasterDetailFormPanel)FormDesigner.this.form_).getSelectedFormPanel();
/*  296 */               if (p != null) {
/*  297 */                 FormDesigner.this.selectTreeNode(p.getConfig());
/*      */               }
/*      */             }
/*      */           
/*  301 */           } catch (Exception ex) {
/*  302 */             FormDesigner.logger_.error("CAUGHT EXCEPTION", ex);
/*      */           } 
/*      */         }
/*      */       };
/*      */     
/*  307 */     this.deleteColumnAction_ = new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e) {
/*  310 */           IFormViewPanelConfig<?> panelConfig = FormDesigner.this.getCurrentPanel();
/*  311 */           ILayoutParameters layout = panelConfig.getEditableLayoutParameters();
/*      */ 
/*      */ 
/*      */           
/*  315 */           IntegerInputDialog d = new IntegerInputDialog(FormDesigner.this.host_.getFrame(), "Select column position", "Select the column to delete.", FormDesigner.INT_ZERO, Integer.valueOf(layout.getColumnCount().intValue() - 1), FormDesigner.this.getCurrentColumn());
/*  316 */           d.setVisible(true);
/*  317 */           Integer delColumn = d.getValue();
/*  318 */           d.dispose();
/*  319 */           if (delColumn != null) {
/*  320 */             for (Object kid : panelConfig.getChildren()) {
/*  321 */               if (kid instanceof FormViewCellConfig) {
/*  322 */                 FormViewCellConfig cellConfig = (FormViewCellConfig)kid;
/*  323 */                 LayoutLocation layoutLocation = cellConfig.getEditableLayoutLocation();
/*  324 */                 Integer col = layoutLocation.getColumn();
/*  325 */                 if (layoutLocation.getColumn().compareTo(delColumn) >= 0) {
/*  326 */                   layoutLocation.setColumn(Integer.valueOf(col.intValue() - 1));
/*      */                   
/*      */                   continue;
/*      */                 } 
/*  330 */                 int colSpan = layoutLocation.getColumnSpan().intValue();
/*  331 */                 if (colSpan > 1) {
/*  332 */                   int colEnd = col.intValue() + colSpan - 1;
/*  333 */                   if (colEnd > delColumn.intValue()) {
/*  334 */                     int newSpan = colSpan - 1;
/*      */                     
/*  336 */                     if (newSpan > 0) {
/*  337 */                       layoutLocation.setColumnSpan(Integer.valueOf(newSpan));
/*      */                     }
/*      */                   } 
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */ 
/*      */             
/*  345 */             layout.deleteColumn(delColumn);
/*  346 */             FormDesigner.this.saveAndReload();
/*      */           } 
/*      */         }
/*      */       };
/*      */ 
/*      */     
/*  352 */     this.deleteComponentAction_ = new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e)
/*      */         {
/*  356 */           DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)FormDesigner.this.componentTree_.getSelectionPath().getLastPathComponent();
/*  357 */           Object o = selectedNode.getUserObject();
/*  358 */           if (o instanceof FormViewCellConfig) {
/*  359 */             FormViewCellConfig config = (FormViewCellConfig)o;
/*  360 */             int answer = JOptionPane.showConfirmDialog(FormDesigner.this, "Are you sure you want to delete \"" + FormDesigner.this
/*      */                 
/*  362 */                 .getDescription((AbstractFormComponentConfig)config) + "\"?", "Delete Cell", 0, 3);
/*      */ 
/*      */             
/*  365 */             if (answer == 0) {
/*  366 */               DefaultMutableTreeNode panelNode = (DefaultMutableTreeNode)selectedNode.getParent();
/*  367 */               FormViewPanelConfig panelConfig = (FormViewPanelConfig)panelNode.getUserObject();
/*  368 */               panelConfig.deleteChild((IViewComponentConfig)config);
/*  369 */               FormDesigner.this.saveAndReload();
/*      */             } 
/*      */           } 
/*      */         }
/*      */       };
/*      */     
/*  375 */     this.deletePanelAction_ = new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e)
/*      */         {
/*  379 */           DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)FormDesigner.this.componentTree_.getSelectionPath().getLastPathComponent();
/*  380 */           Object o = selectedNode.getUserObject();
/*  381 */           if (o instanceof FormViewPanelConfig) {
/*  382 */             FormViewPanelConfig config = (FormViewPanelConfig)o;
/*  383 */             int answer = JOptionPane.showConfirmDialog(FormDesigner.this, "Are you sure you want to delete \"" + FormDesigner.this
/*      */                 
/*  385 */                 .getDescription((AbstractFormComponentConfig)config) + "\"?", "Delete Panel", 0, 3);
/*      */ 
/*      */             
/*  388 */             if (answer == 0) {
/*  389 */               FormDesigner.this.viewConfig_.removeViewPanelConfig((IFormViewPanelConfig)config);
/*  390 */               FormDesigner.this.saveAndReload();
/*      */             } 
/*      */           } 
/*      */         }
/*      */       };
/*      */     
/*  396 */     this.deleteSectionAction_ = new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e)
/*      */         {
/*  400 */           DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)FormDesigner.this.componentTree_.getSelectionPath().getLastPathComponent();
/*  401 */           Object o = selectedNode.getUserObject();
/*  402 */           if (o instanceof FormViewSectionConfig) {
/*  403 */             FormViewSectionConfig config = (FormViewSectionConfig)o;
/*  404 */             int answer = JOptionPane.showConfirmDialog(FormDesigner.this, "Are you sure you want to delete \"" + config
/*      */                 
/*  406 */                 .getName() + "\"?", "Delete Section", 0, 3);
/*      */ 
/*      */             
/*  409 */             if (answer == 0) {
/*  410 */               FormDesigner.this.viewConfig_.removeViewSectionConfig((IFormViewSectionConfig)config);
/*  411 */               FormDesigner.this.saveAndReload();
/*      */             } 
/*      */           } 
/*      */         }
/*      */       };
/*      */     
/*  417 */     this.deleteSectionRefAction_ = new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e)
/*      */         {
/*  421 */           DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)FormDesigner.this.componentTree_.getSelectionPath().getLastPathComponent();
/*  422 */           Object o = selectedNode.getUserObject();
/*  423 */           if (o instanceof FormViewSectionRefConfig) {
/*  424 */             FormViewSectionRefConfig config = (FormViewSectionRefConfig)o;
/*  425 */             int answer = JOptionPane.showConfirmDialog(FormDesigner.this, "Are you sure you want to delete \"" + config
/*      */                 
/*  427 */                 .getName() + "\"?", "Delete Section Reference", 0, 3);
/*      */ 
/*      */             
/*  430 */             if (answer == 0) {
/*  431 */               DefaultMutableTreeNode panelNode = (DefaultMutableTreeNode)selectedNode.getParent();
/*  432 */               FormViewPanelConfig panelConfig = (FormViewPanelConfig)panelNode.getUserObject();
/*  433 */               panelConfig.deleteChild((IViewComponentConfig)config);
/*  434 */               FormDesigner.this.saveAndReload();
/*      */             } 
/*      */           } 
/*      */         }
/*      */       };
/*      */     
/*  440 */     this.deleteRowAction_ = new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e) {
/*  443 */           IFormViewPanelConfig<IFormViewCellConfig> panelConfig = FormDesigner.this.getCurrentPanel();
/*  444 */           ILayoutParameters layout = panelConfig.getEditableLayoutParameters();
/*      */ 
/*      */ 
/*      */           
/*  448 */           IntegerInputDialog d = new IntegerInputDialog(FormDesigner.this.host_.getFrame(), "Select row position", "Select the row to delete.", FormDesigner.INT_ZERO, Integer.valueOf(layout.getRowCount().intValue() - 1), FormDesigner.this.getCurrentRow());
/*  449 */           d.setVisible(true);
/*  450 */           Integer delRow = d.getValue();
/*  451 */           d.dispose();
/*  452 */           if (delRow != null) {
/*  453 */             Collection<IFormViewCellConfig> kids = panelConfig.getChildren();
/*  454 */             for (IFormViewCellConfig kid : kids) {
/*  455 */               ILayoutLocation location = kid.getEditableLayoutLocation();
/*  456 */               Integer row = location.getRow();
/*  457 */               if (location.getRow().compareTo(delRow) >= 0) {
/*  458 */                 location.setRow(Integer.valueOf(row.intValue() - 1));
/*      */                 
/*      */                 continue;
/*      */               } 
/*  462 */               int rowSpan = location.getRowSpan().intValue();
/*  463 */               if (rowSpan > 1) {
/*  464 */                 int rowEnd = row.intValue() + rowSpan - 1;
/*  465 */                 if (rowEnd > delRow.intValue()) {
/*  466 */                   int newSpan = rowSpan - 1;
/*      */                   
/*  468 */                   if (newSpan > 0) {
/*  469 */                     location.setRowSpan(Integer.valueOf(newSpan));
/*      */                   }
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */             
/*  475 */             layout.deleteRow(delRow);
/*  476 */             FormDesigner.this.saveAndReload();
/*      */           } 
/*      */         }
/*      */       };
/*      */ 
/*      */ 
/*      */     
/*  483 */     this.editColumnWidthAction_ = new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e)
/*      */         {
/*  487 */           DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)FormDesigner.this.componentTree_.getSelectionPath().getLastPathComponent();
/*  488 */           Object o = selectedNode.getUserObject();
/*  489 */           if (o instanceof FormViewCellConfig) {
/*  490 */             ILayoutParameters layout = FormDesigner.this.getCurrentPanelLayout();
/*      */ 
/*      */ 
/*      */             
/*  494 */             IntegerInputDialog columnDialog = new IntegerInputDialog(FormDesigner.this.host_.getFrame(), "Select column position", "Select the column whose height you wish to edit.", FormDesigner.INT_ZERO, Integer.valueOf(layout.getColumnCount().intValue() - 1), FormDesigner.this.getCurrentColumn());
/*  495 */             columnDialog.setVisible(true);
/*  496 */             Integer column = columnDialog.getValue();
/*  497 */             columnDialog.dispose();
/*      */             
/*  499 */             if (column == null) {
/*      */               return;
/*      */             }
/*      */             
/*  503 */             double[] columnSizes = layout.getColumnSizes();
/*      */ 
/*      */             
/*  506 */             EditRowColumnSizeDialog sizeDialog = new EditRowColumnSizeDialog(FormDesigner.this.host_.getFrame(), "Column " + column + " size", "Select the new row size.", columnSizes[column.intValue()]);
/*  507 */             sizeDialog.setVisible(true);
/*  508 */             Double selectedSize = sizeDialog.getValue();
/*      */             
/*  510 */             if (selectedSize == null) {
/*      */               return;
/*      */             }
/*      */             
/*  514 */             columnSizes[column.intValue()] = selectedSize.doubleValue();
/*  515 */             layout.setColumnSizes(columnSizes);
/*      */             
/*  517 */             FormDesigner.this.saveAndReload();
/*      */           } 
/*      */         }
/*      */       };
/*      */     
/*  522 */     this.editRowHeightAction_ = new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e)
/*      */         {
/*  526 */           DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)FormDesigner.this.componentTree_.getSelectionPath().getLastPathComponent();
/*  527 */           Object o = selectedNode.getUserObject();
/*  528 */           if (o instanceof FormViewCellConfig) {
/*  529 */             ILayoutParameters layout = FormDesigner.this.getCurrentPanelLayout();
/*      */ 
/*      */ 
/*      */             
/*  533 */             IntegerInputDialog rowDialog = new IntegerInputDialog(FormDesigner.this.host_.getFrame(), "Select row position", "Select the row whose height you wish to edit.", FormDesigner.INT_ZERO, Integer.valueOf(layout.getRowCount().intValue() - 1), FormDesigner.this.getCurrentRow());
/*  534 */             rowDialog.setVisible(true);
/*  535 */             Integer row = rowDialog.getValue();
/*  536 */             rowDialog.dispose();
/*      */             
/*  538 */             if (row == null) {
/*      */               return;
/*      */             }
/*      */             
/*  542 */             double[] rowSizes = layout.getRowSizes();
/*      */ 
/*      */             
/*  545 */             EditRowColumnSizeDialog sizeDialog = new EditRowColumnSizeDialog(FormDesigner.this.host_.getFrame(), "Row " + row + " size", "Select the new row size.", rowSizes[row.intValue()]);
/*  546 */             sizeDialog.setVisible(true);
/*  547 */             Double selectedSize = sizeDialog.getValue();
/*      */             
/*  549 */             if (selectedSize == null) {
/*      */               return;
/*      */             }
/*      */             
/*  553 */             rowSizes[row.intValue()] = selectedSize.doubleValue();
/*  554 */             layout.setRowSizes(rowSizes);
/*  555 */             FormDesigner.this.saveAndReload();
/*      */           } 
/*      */         }
/*      */       };
/*      */ 
/*      */     
/*  561 */     this.exitAction_ = new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e)
/*      */         {
/*  565 */           FormDesigner.this.host_.exit();
/*      */         }
/*      */       };
/*      */     
/*  569 */     this.formMouseListener_ = new MouseAdapter()
/*      */       {
/*      */         public void mouseClicked(MouseEvent e) {
/*  572 */           if (e.getButton() == 1) {
/*  573 */             Component c = FormDesigner.this.formComponent_.findComponentAt(e.getX(), e.getY());
/*  574 */             if (c instanceof JTabbedPane) {
/*  575 */               JTabbedPane tp = (JTabbedPane)c;
/*      */               
/*  577 */               Point p1 = tp.getLocationOnScreen();
/*  578 */               Component parent = tp.getParent();
/*  579 */               while (!(parent instanceof dtv.pos.ui.component.PosFormPanel)) {
/*  580 */                 parent = parent.getParent();
/*      */               }
/*  582 */               Point p2 = parent.getLocationOnScreen();
/*  583 */               int x = e.getX() + (int)p2.getX() - (int)p1.getX();
/*  584 */               int y = e.getY() + (int)p2.getY() - (int)p1.getY();
/*  585 */               int index = tp.indexAtLocation(x, y);
/*  586 */               if (index == -1) {
/*  587 */                 tp.setSelectedIndex(0);
/*  588 */                 c = tp.getComponent(0);
/*      */               } else {
/*      */                 
/*  591 */                 tp.setSelectedIndex(index);
/*  592 */                 c = tp.getComponent(index);
/*      */               } 
/*      */             } 
/*  595 */             final Component component = c;
/*  596 */             final IFormComponentConfig<?> config = FormDesigner.getAssociatedConfig(component);
/*  597 */             if (config != null) {
/*  598 */               UIServices.invoke(new Runnable()
/*      */                   {
/*      */                     public void run() {
/*  601 */                       FormDesigner.this.glassPanel_.setSelected(component);
/*  602 */                       FormDesigner.this.selectTreeNode(config);
/*      */                     }
/*      */                   });
/*      */             }
/*      */           } 
/*      */         }
/*      */ 
/*      */         
/*      */         public void mouseReleased(MouseEvent e) {
/*  611 */           if (e.getButton() == 3) {
/*  612 */             Component c = FormDesigner.this.formComponent_.findComponentAt(e.getX(), e.getY());
/*      */             
/*  614 */             IFormComponentConfig<?> config = FormDesigner.getAssociatedConfig(c);
/*  615 */             if (config instanceof FormViewCellConfig) {
/*  616 */               FormDesigner.this.formCellPopupMenu_.getPopupMenu().show(FormDesigner.this.glassPanel_, e.getX(), e.getY());
/*      */             }
/*      */           } 
/*      */         }
/*      */       };
/*      */     
/*  622 */     this.insertColumnAction_ = new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e) {
/*  625 */           IFormViewPanelConfig<?> panelConfig = FormDesigner.this.getCurrentPanel();
/*  626 */           ILayoutParameters layout = panelConfig.getEditableLayoutParameters();
/*      */ 
/*      */           
/*  629 */           IntegerInputDialog d = new IntegerInputDialog(FormDesigner.this.host_.getFrame(), "Select new column position", "Select the position for the new column.", FormDesigner.INT_ZERO, layout.getColumnCount(), FormDesigner.this.getCurrentColumn());
/*  630 */           d.setVisible(true);
/*  631 */           Integer newColumn = d.getValue();
/*  632 */           d.dispose();
/*  633 */           if (newColumn != null) {
/*  634 */             layout.insertColumn(newColumn);
/*  635 */             for (Object kid : panelConfig.getChildren()) {
/*  636 */               if (kid instanceof FormViewCellConfig) {
/*  637 */                 FormViewCellConfig cellConfig = (FormViewCellConfig)kid;
/*  638 */                 LayoutLocation layoutLocation = cellConfig.getEditableLayoutLocation();
/*  639 */                 Integer col = layoutLocation.getColumn();
/*  640 */                 if (col.compareTo(newColumn) >= 0) {
/*  641 */                   col = Integer.valueOf(col.intValue() + 1);
/*  642 */                   layoutLocation.setColumn(Integer.valueOf(col.intValue()));
/*      */                   
/*      */                   continue;
/*      */                 } 
/*  646 */                 int colSpan = layoutLocation.getColumnSpan().intValue();
/*  647 */                 if (colSpan > 1) {
/*  648 */                   int colEnd = col.intValue() + colSpan - 1;
/*  649 */                   if (colEnd > newColumn.intValue()) {
/*  650 */                     layoutLocation.setColumnSpan(Integer.valueOf(colSpan + 1));
/*      */                   }
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */ 
/*      */             
/*  657 */             FormDesigner.this.saveAndReload();
/*      */           } 
/*      */         }
/*      */       };
/*      */     
/*  662 */     this.insertComponentAction_ = new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e) {
/*  665 */           IFormViewPanelConfig<IFormViewCellConfig> panelConfig = FormDesigner.this.getCurrentPanel();
/*  666 */           ILayoutParameters l = panelConfig.getEditableLayoutParameters();
/*      */ 
/*      */ 
/*      */           
/*  670 */           InsertComponentDialog d = new InsertComponentDialog(FormDesigner.this.host_.getFrame(), FormDesigner.this.getCurrentRow(), FormDesigner.this.getCurrentColumn(), Integer.valueOf((l.getRowSizes()).length - 1), Integer.valueOf((l.getColumnSizes()).length - 1));
/*  671 */           d.setVisible(true);
/*  672 */           FormComponentType type = d.getSelectedType();
/*  673 */           if (type != null) {
/*  674 */             Integer row = d.getSelectedRow();
/*  675 */             Integer column = d.getSelectedColumn();
/*      */             
/*  677 */             panelConfig.addChild((IViewComponentConfig)FormFactory.getInstance().makeCell(type, row.intValue(), column.intValue()));
/*  678 */             FormDesigner.this.saveAndReload();
/*      */           } 
/*      */         }
/*      */       };
/*      */     
/*  683 */     this.insertPanelAction_ = new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e) {
/*  686 */           FormDesigner.this.viewConfig_.addViewPanelConfig(FormFactory.getInstance().makePanel());
/*  687 */           FormDesigner.this.saveAndReload();
/*      */         }
/*      */       };
/*      */     
/*  691 */     this.insertSectionRefAction_ = new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent argE)
/*      */         {
/*  695 */           IFormViewPanelConfig<IFormViewCellConfig> panelConfig = FormDesigner.this.getCurrentPanel();
/*  696 */           panelConfig.addChild((IViewComponentConfig)FormFactory.getInstance().makeSectionRef());
/*      */           
/*  698 */           FormDesigner.this.saveAndReload();
/*      */         }
/*      */       };
/*      */     
/*  702 */     this.insertSectionAction_ = new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e) {
/*  705 */           FormDesigner.this.viewConfig_.addViewSectionConfig(FormFactory.getInstance().makeSection());
/*  706 */           FormDesigner.this.saveAndReload();
/*      */         }
/*      */       };
/*      */     
/*  710 */     this.insertRowAction_ = new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e) {
/*  713 */           IFormViewPanelConfig<?> panelConfig = FormDesigner.this.getCurrentPanel();
/*  714 */           ILayoutParameters layout = panelConfig.getEditableLayoutParameters();
/*      */ 
/*      */           
/*  717 */           IntegerInputDialog d = new IntegerInputDialog(FormDesigner.this.host_.getFrame(), "Select new row position", "Select the position for the new row.", FormDesigner.INT_ZERO, layout.getRowCount(), FormDesigner.this.getCurrentRow());
/*  718 */           d.setVisible(true);
/*  719 */           Integer newRow = d.getValue();
/*  720 */           d.dispose();
/*  721 */           if (newRow != null) {
/*  722 */             layout.insertRow(newRow);
/*  723 */             for (Object kid : panelConfig.getChildren()) {
/*  724 */               if (kid instanceof FormViewCellConfig) {
/*  725 */                 FormViewCellConfig cellConfig = (FormViewCellConfig)kid;
/*  726 */                 LayoutLocation layoutLocation = cellConfig.getEditableLayoutLocation();
/*  727 */                 Integer row = layoutLocation.getRow();
/*  728 */                 if (row.compareTo(newRow) >= 0) {
/*  729 */                   layoutLocation.setRow(Integer.valueOf(row.intValue() + 1));
/*      */                   
/*      */                   continue;
/*      */                 } 
/*  733 */                 int rowSpan = layoutLocation.getRowSpan().intValue();
/*  734 */                 if (rowSpan > 1) {
/*  735 */                   int rowEnd = row.intValue() + rowSpan - 1;
/*  736 */                   if (rowEnd > newRow.intValue()) {
/*  737 */                     layoutLocation.setRowSpan(Integer.valueOf(rowSpan + 1));
/*      */                   }
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */ 
/*      */             
/*  744 */             FormDesigner.this.saveAndReload();
/*      */           } 
/*      */         }
/*      */       };
/*      */     
/*  749 */     this.openAction_ = new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e) {
/*  752 */           Thread t = new Thread()
/*      */             {
/*      */               public void run() {
/*  755 */                 FormKey key = FormDesigner.this.selectForm();
/*  756 */                 if (key != null) {
/*  757 */                   FormDesigner.this.setForm(key);
/*      */                 }
/*      */               }
/*      */             };
/*  761 */           t.setName("OpenFormThread-" + ++FormDesigner.threadIndex_);
/*  762 */           t.start();
/*      */         }
/*      */       };
/*      */     
/*  766 */     this.previewAction_ = new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e) {
/*  769 */           FormPreviewType type = FormPreviewType.forLocation(FormDesigner.this.viewConfig_.getFormLocation());
/*  770 */           if (type != null) {
/*  771 */             FormPanel<IFormModel> form = FormDesigner.this.formHelper_.assemble(FormDesigner.this.formKey_, false);
/*  772 */             JComponent formComponent = form.getDisplayComponent();
/*      */ 
/*      */             
/*  775 */             FormPreviewDialog d = new FormPreviewDialog(FormDesigner.this.host_.getFrame(), FormDesigner.this.formKey_.toString(), formComponent, type);
/*  776 */             d.setVisible(true);
/*  777 */             d.dispose();
/*      */           } 
/*      */         }
/*      */       };
/*      */     
/*  782 */     this.saveAction_ = new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e) {
/*  785 */           FormDesigner.this.saveAndReload();
/*      */         }
/*      */       };
/*      */     
/*  789 */     this.scrollableChangeAction_ = new ChangeListener()
/*      */       {
/*      */         public void stateChanged(ChangeEvent e) {
/*  792 */           boolean newValue = FormDesigner.this.menuViewScrollable_.isSelected();
/*  793 */           if (FormDesigner.this.useFormScrollBars_ != newValue) {
/*  794 */             FormDesigner.this.useFormScrollBars_ = newValue;
/*  795 */             FormDesigner.this.formHorizontalSplit_.remove(FormDesigner.this.formHorizontalSplit_.getTopComponent());
/*  796 */             if (newValue) {
/*  797 */               FormDesigner.this.formHorizontalSplit_.add(FormDesigner.this.formScrollPane_, "top");
/*  798 */               FormDesigner.this.formScrollPane_.getViewport().add(FormDesigner.this.formPanel_);
/*  799 */               FormDesigner.this.validate();
/*      */             } else {
/*      */               
/*  802 */               FormDesigner.this.formHorizontalSplit_.add(FormDesigner.this.formPanel_, "top");
/*  803 */               FormDesigner.this.validate();
/*      */             } 
/*      */           } 
/*      */         }
/*      */       };
/*      */     
/*  809 */     this.setSaveToDirAction_ = new ActionListener()
/*      */       {
/*      */         public void actionPerformed(ActionEvent e) {
/*      */           try {
/*  813 */             File dir = FormDesigner.this.getWorkingDir();
/*  814 */             dir = FormDesigner.getSaveToDir(FormDesigner.this.host_.getFrame(), dir);
/*  815 */             FormDesigner.this.setWorkingDir(dir);
/*      */           }
/*  817 */           catch (Exception ex) {
/*  818 */             FormDesigner.logger_.info("CAUGHT EXCEPTION", ex);
/*      */           } 
/*      */         }
/*      */       };
/*      */     
/*  823 */     this.treeMouseListener_ = new MouseAdapter()
/*      */       {
/*      */         public void mouseClicked(MouseEvent e) {
/*  826 */           TreePath p = FormDesigner.this.componentTree_.getClosestPathForLocation(e.getX(), e.getY());
/*  827 */           FormDesigner.this.componentTree_.setSelectionPath(p);
/*      */         }
/*      */ 
/*      */         
/*      */         public void mouseReleased(MouseEvent e) {
/*  832 */           if (e.getButton() == 3) {
/*  833 */             TreePath p = FormDesigner.this.componentTree_.getClosestPathForLocation(e.getX(), e.getY());
/*  834 */             FormDesigner.this.componentTree_.setSelectionPath(p);
/*      */ 
/*      */             
/*  837 */             DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)FormDesigner.this.componentTree_.getSelectionPath().getLastPathComponent();
/*  838 */             Object o = selectedNode.getUserObject();
/*  839 */             if (o instanceof FormViewCellConfig) {
/*  840 */               FormDesigner.this.formCellPopupMenu_.getPopupMenu().show(FormDesigner.this.componentTree_, e.getX(), e.getY());
/*      */             }
/*  842 */             else if (o instanceof FormViewPanelConfig) {
/*  843 */               FormDesigner.this.enableDisablePanelPopup();
/*  844 */               FormDesigner.this.formPanelPopupMenu_.getPopupMenu().show(FormDesigner.this.componentTree_, e.getX(), e.getY());
/*      */             
/*      */             }
/*  847 */             else if (o instanceof FormViewSectionConfig) {
/*  848 */               FormDesigner.this.enableDisableSectionPopup();
/*  849 */               FormDesigner.this.sectionPopupMenu_.getPopupMenu().show(FormDesigner.this.componentTree_, e.getX(), e.getY());
/*      */             }
/*  851 */             else if (o instanceof FormViewSectionRefConfig) {
/*  852 */               FormDesigner.this.sectionRefPopupMenu_.getPopupMenu().show(FormDesigner.this.componentTree_, e.getX(), e.getY());
/*      */             } 
/*      */           } 
/*      */         }
/*      */       };
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  861 */     this.host_ = argHost;
/*  862 */     setWorkingDir(argFormConfigDir);
/*      */     
/*  864 */     initFormHelper();
/*      */     
/*      */     try {
/*  867 */       initializeUi();
/*      */     }
/*  869 */     catch (Exception ex) {
/*  870 */       logger_.fatal("CAUGHT EXCEPTION", ex);
/*  871 */       System.exit(-1);
/*      */     } 
/*      */ 
/*      */     
/*  875 */     if (argFormKey == null) {
/*  876 */       key = selectForm();
/*      */     } else {
/*      */       
/*  879 */       key = argFormKey;
/*      */     } 
/*  881 */     if (key == null) {
/*  882 */       throw new UnsupportedOperationException();
/*      */     }
/*  884 */     setForm(key);
/*      */   }
/*      */ 
/*      */   
/*      */   public JPanel getDesignerPanel() {
/*  889 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   public JMenu[] getMenus() {
/*  894 */     return this.menus_.<JMenu>toArray(new JMenu[0]);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isDirty() {
/*  899 */     return this.formHelper_.isDirty();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void save() throws IOException {
/*  905 */     this.formHelper_.save(getWorkingDir());
/*      */   }
/*      */ 
/*      */   
/*      */   public void setDividerLocation(int argLocation) {
/*  910 */     this.formHorizontalSplit_.setDividerLocation(argLocation);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setPermission(FormDesignerPermission argPermission, boolean argEnabled) {}
/*      */ 
/*      */   
/*      */   public void setSelectedFormComponent(Component c) {
/*  918 */     this.glassPanel_.setSelected(c);
/*      */   }
/*      */   
/*      */   protected void enableDisablePanelPopup() {
/*  922 */     if ((this.viewConfig_.getViewPanelConfigs()).length > 1) {
/*  923 */       this.deletePanelPopupItem_.setEnabled(true);
/*      */     } else {
/*      */       
/*  926 */       this.deletePanelPopupItem_.setEnabled(false);
/*      */     } 
/*      */   }
/*      */   
/*      */   protected void enableDisableSectionPopup() {
/*  931 */     if ((this.viewConfig_.getViewSectionConfigs()).length > 1) {
/*  932 */       this.deleteSectionPopupItem_.setEnabled(true);
/*      */     } else {
/*      */       
/*  935 */       this.deleteSectionPopupItem_.setEnabled(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected Integer getCurrentColumn() {
/*  941 */     DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)this.componentTree_.getSelectionPath().getLastPathComponent();
/*  942 */     if (selectedNode == null) {
/*  943 */       return INT_ZERO;
/*      */     }
/*  945 */     Object o = selectedNode.getUserObject();
/*  946 */     if (o instanceof FormViewCellConfig) {
/*  947 */       FormViewCellConfig config = (FormViewCellConfig)o;
/*  948 */       return config.getEditableLayoutLocation().getColumn();
/*      */     } 
/*      */     
/*  951 */     return INT_ZERO;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected IFormViewPanelConfig<IFormViewCellConfig> getCurrentPanel() {
/*  958 */     DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)this.componentTree_.getSelectionPath().getLastPathComponent();
/*      */     
/*  960 */     Object o = selectedNode.getUserObject();
/*  961 */     if (o instanceof FormViewPanelConfig) {
/*  962 */       return (IFormViewPanelConfig<IFormViewCellConfig>)o;
/*      */     }
/*  964 */     if (o instanceof FormViewCellConfig) {
/*  965 */       DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode)selectedNode.getParent();
/*  966 */       o = parentNode.getUserObject();
/*  967 */       if (o instanceof FormViewPanelConfig) {
/*  968 */         return (IFormViewPanelConfig<IFormViewCellConfig>)o;
/*      */       }
/*      */     } 
/*  971 */     logger_.warn("returning first panel");
/*  972 */     o = this.viewConfig_.getViewPanelConfigs()[0];
/*  973 */     return (IFormViewPanelConfig<IFormViewCellConfig>)o;
/*      */   }
/*      */   
/*      */   protected ILayoutParameters getCurrentPanelLayout() {
/*  977 */     IFormViewPanelConfig<?> panelConfig = getCurrentPanel();
/*  978 */     return panelConfig.getEditableLayoutParameters();
/*      */   }
/*      */ 
/*      */   
/*      */   protected Integer getCurrentRow() {
/*  983 */     DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)this.componentTree_.getSelectionPath().getLastPathComponent();
/*      */     
/*  985 */     if (selectedNode == null) {
/*  986 */       return INT_ZERO;
/*      */     }
/*  988 */     Object o = selectedNode.getUserObject();
/*  989 */     if (o instanceof FormViewCellConfig) {
/*  990 */       FormViewCellConfig config = (FormViewCellConfig)o;
/*  991 */       return config.getEditableLayoutLocation().getRow();
/*      */     } 
/*      */     
/*  994 */     return INT_ZERO;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getDescription(AbstractFormComponentConfig argCell) {
/* 1000 */     StringBuffer stringValue = new StringBuffer();
/* 1001 */     stringValue.append(argCell.getType());
/* 1002 */     stringValue.append(" - ");
/* 1003 */     if (argCell.getResource() != null) {
/* 1004 */       stringValue.append(argCell.getResource());
/*      */     }
/* 1006 */     else if (argCell.getTextKey() != null) {
/* 1007 */       stringValue.append(argCell.getTextKey().getUnformattedData());
/*      */     } 
/* 1009 */     return stringValue.toString();
/*      */   }
/*      */   
/*      */   protected String getDescription(ActionConfig argAction) {
/* 1013 */     StringBuffer stringValue = new StringBuffer();
/* 1014 */     stringValue.append(ActionType.forActionKey(argAction.getKey()));
/* 1015 */     stringValue.append(" - ");
/* 1016 */     stringValue.append(argAction.getKey());
/* 1017 */     stringValue.append(" (");
/* 1018 */     if (argAction.getTextKey() == null) {
/* 1019 */       stringValue.append((String)null);
/*      */     } else {
/*      */       
/* 1022 */       stringValue.append(argAction.getTextKey().getUnformattedData());
/*      */     } 
/* 1024 */     stringValue.append(")");
/* 1025 */     return stringValue.toString();
/*      */   }
/*      */   
/*      */   protected File getWorkingDir() {
/* 1029 */     return this.workingDir_;
/*      */   }
/*      */   
/*      */   protected void initFormHelper() {
/* 1033 */     this.formHelper_ = new FormViewConfigHelper(getWorkingDir().getAbsolutePath());
/* 1034 */     InjectionHammer.forceAtInjectProcessing(this.formHelper_);
/* 1035 */     this.formHelper_.initialize();
/*      */   }
/*      */   
/*      */   protected TreePath matchPaths(TreePath oldPath, TreePath argPath) {
/* 1039 */     TreePath newPath = argPath;
/* 1040 */     for (int i = 1; i < oldPath.getPathCount(); i++) {
/* 1041 */       DefaultMutableTreeNode oldNode = (DefaultMutableTreeNode)oldPath.getPathComponent(i);
/* 1042 */       Object oldObject = oldNode.getUserObject();
/* 1043 */       DefaultMutableTreeNode newParentNode = (DefaultMutableTreeNode)newPath.getPathComponent(i - 1);
/*      */       
/* 1045 */       DefaultMutableTreeNode child = (DefaultMutableTreeNode)newParentNode.getFirstChild();
/* 1046 */       while (child != null) {
/* 1047 */         Object userObject = child.getUserObject();
/* 1048 */         if (userObject instanceof IHasEquivalence) {
/* 1049 */           if (((IHasEquivalence)userObject).isEquivalent(oldObject)) {
/*      */             break;
/*      */           }
/*      */         } else {
/*      */           
/* 1054 */           logger_.warn(((userObject == null) ? null : userObject.getClass().getName()) + " does not implement " + IHasEquivalence.class);
/*      */         } 
/*      */         
/* 1057 */         child = child.getNextSibling();
/*      */       } 
/* 1059 */       if (child == null) {
/*      */         break;
/*      */       }
/* 1062 */       newPath = newPath.pathByAddingChild(child);
/*      */     } 
/* 1064 */     return newPath;
/*      */   }
/*      */   
/*      */   protected void resetFormPanelContents() {
/* 1068 */     this.formPanel_.removeAll();
/*      */     
/* 1070 */     this.formPanel_.add(this.glassPanel_);
/* 1071 */     this.formPanel_.add(this.formComponent_);
/* 1072 */     this.formPanel_.validate();
/*      */     
/* 1074 */     this.glassPanel_.setAssociate(this.formComponent_);
/*      */   }
/*      */ 
/*      */   
/*      */   protected void saveAndReload() {
/* 1079 */     Runnable saveWorker = new Runnable()
/*      */       {
/*      */         public void run()
/*      */         {
/*      */           try {
/* 1084 */             if (FormDesigner.this.detailView_ != null && FormDesigner.this.detailView_.isEditing()) {
/* 1085 */               FormDesigner.this.detailView_.getCellEditor().stopCellEditing();
/*      */             }
/* 1087 */             int previousTabIndex = -1;
/* 1088 */             TreePath path = FormDesigner.this.componentTree_.getSelectionPath();
/* 1089 */             if (FormDesigner.this.form_ instanceof MasterDetailFormPanel) {
/* 1090 */               previousTabIndex = ((MasterDetailFormPanel)FormDesigner.this.form_).getSelectedIndex();
/*      */             }
/* 1092 */             FormDesigner.this.formHelper_.save(FormDesigner.this.getWorkingDir());
/*      */             
/* 1094 */             FormDesigner.this.initFormHelper();
/*      */             
/* 1096 */             FormDesigner.this.setForm(FormDesigner.this.formKey_);
/* 1097 */             if (FormDesigner.this.form_ instanceof IMasterDetailFormPanel) {
/* 1098 */               ((IMasterDetailFormPanel)FormDesigner.this.form_).setSelectedIndex(previousTabIndex);
/*      */             }
/* 1100 */             TreePath newPath = FormDesigner.this.matchPaths(path, FormDesigner.this.componentTree_.getSelectionPath());
/* 1101 */             UIServices.invoke(new FormDesigner.TreeSelectionWorker(newPath));
/*      */           }
/* 1103 */           catch (IOException ex) {
/* 1104 */             FormDesigner.logger_.error("CAUGHT EXCEPTION", ex);
/*      */           } 
/*      */         }
/*      */       };
/* 1108 */     BlockingMessageDialog d = new BlockingMessageDialog(this.host_.getFrame(), "Saving and Refreshing...", "Please wait while the form saves and refreshes.", saveWorker);
/*      */     
/* 1110 */     d.setVisible(true);
/* 1111 */     d.dispose();
/* 1112 */     System.gc();
/*      */   }
/*      */   
/*      */   protected DataActionGroupKey selectActionGroup() {
/* 1116 */     DataActionGroupKey[] keys = DataActionGroupKey.getInstances();
/* 1117 */     Arrays.sort((Object[])keys);
/* 1118 */     return (DataActionGroupKey)ListSelectorFrame.showDialog(this.host_.getFrame(), "Select group for new action:", (Object[])keys);
/*      */   }
/*      */   
/*      */   protected ActionType selectActionType() {
/* 1122 */     ActionType[] keys = ActionType.getInstances();
/* 1123 */     Arrays.sort((Object[])keys);
/* 1124 */     return (ActionType)ListSelectorFrame.showDialog(this.host_.getFrame(), "Select class for new action:", (Object[])keys);
/*      */   }
/*      */   
/*      */   protected FormKey selectForm() {
/* 1128 */     Collection<FormSelection> formKeys = new TreeSet<>();
/*      */     
/* 1130 */     for (IFormViewConfig formConfig : ((FormViewSetConfig)this.formHelper_.getRootConfig()).getChildren()) {
/* 1131 */       if (formConfig != null) {
/* 1132 */         formKeys.add(new FormSelection(formConfig));
/*      */         continue;
/*      */       } 
/* 1135 */       System.out.println("formconfig is null");
/*      */     } 
/*      */ 
/*      */     
/* 1139 */     FormSelection selected = (FormSelection)ListSelectorFrame.showDialog(this.host_.getFrame(), "Select Form from list:", formKeys
/* 1140 */         .toArray((Object[])new FormSelection[0]));
/*      */     
/* 1142 */     return (selected == null) ? null : selected.getFormKey();
/*      */   }
/*      */   
/*      */   protected void selectTreeNode(IFormComponentConfig<?> config) {
/*      */     DefaultMutableTreeNode node;
/* 1147 */     if (config instanceof FormViewCellConfig) {
/* 1148 */       node = this.treeModel_.getFormCellNode((IFormViewCellConfig)config);
/*      */     }
/* 1150 */     else if (config instanceof FormViewPanelConfig) {
/* 1151 */       node = this.treeModel_.getFormPanelNode((IFormViewPanelConfig)config);
/*      */     }
/* 1153 */     else if (config instanceof FormViewSectionConfig) {
/* 1154 */       node = this.treeModel_.getFormSectionNode((IFormViewSectionConfig)config);
/*      */     }
/* 1156 */     else if (config instanceof FormViewSectionRefConfig) {
/* 1157 */       node = this.treeModel_.getFormSectionRefNode((IFormViewSectionRefConfig)config);
/*      */     } else {
/*      */       
/* 1160 */       logger_.warn("UNEXPECTED CONFIG [" + config + "]");
/* 1161 */       node = null;
/*      */     } 
/* 1163 */     if (node != null) {
/* 1164 */       TreePath path = new TreePath((Object[])node.getPath());
/* 1165 */       this.componentTree_.setSelectionPath(path);
/* 1166 */       this.componentTree_.scrollPathToVisible(path);
/*      */     } 
/*      */   }
/*      */   
/*      */   protected void setForm(FormKey argFormKey) {
/* 1171 */     if (argFormKey != null) {
/* 1172 */       BlockingMessageDialog blockingMessageDialog = new BlockingMessageDialog(this.host_.getFrame(), "Loading...", "Please wait while the form loads.", new SetFormWorker(argFormKey));
/*      */       
/* 1174 */       blockingMessageDialog.setVisible(true);
/* 1175 */       blockingMessageDialog.dispose();
/*      */     } 
/*      */   }
/*      */   
/*      */   protected void setWorkingDir(File argDir) {
/* 1180 */     this.workingDir_ = argDir;
/* 1181 */     this.workingDirLabel_.setText("working directory: " + this.workingDir_.getAbsolutePath());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void initializeUi() throws Exception {
/* 1189 */     this.menuFile_.setText("File");
/*      */     
/* 1191 */     this.menuFileOpen_.setText("Open");
/* 1192 */     this.menuFileOpen_.addActionListener(this.openAction_);
/* 1193 */     this.menuFile_.add(this.menuFileOpen_);
/*      */     
/* 1195 */     this.menuFileSave_.setText("Save");
/* 1196 */     this.menuFileSave_.addActionListener(this.saveAction_);
/* 1197 */     this.menuFile_.add(this.menuFileSave_);
/*      */     
/* 1199 */     this.menuFileSetSaveToDir_.setText("Set working directory");
/* 1200 */     this.menuFileSetSaveToDir_.addActionListener(this.setSaveToDirAction_);
/* 1201 */     this.menuFile_.add(this.menuFileSetSaveToDir_);
/*      */     
/* 1203 */     this.menuFile_.addSeparator();
/*      */     
/* 1205 */     this.menuFileExit_.setText("Exit");
/* 1206 */     this.menuFileExit_.addActionListener(this.exitAction_);
/* 1207 */     this.menuFile_.add(this.menuFileExit_);
/*      */     
/* 1209 */     this.menus_.add(this.menuFile_);
/*      */ 
/*      */     
/* 1212 */     this.menuView_.setText("View");
/*      */     
/* 1214 */     this.menuViewPreview_.setText("Preview");
/* 1215 */     this.menuViewPreview_.addActionListener(this.previewAction_);
/* 1216 */     this.menuView_.add(this.menuViewPreview_);
/*      */     
/* 1218 */     this.menuView_.addSeparator();
/*      */     
/* 1220 */     this.menuViewScrollable_.setText("Scrollable Form");
/* 1221 */     this.menuViewScrollable_.addChangeListener(this.scrollableChangeAction_);
/* 1222 */     this.menuView_.add(this.menuViewScrollable_);
/*      */     
/* 1224 */     this.menus_.add(this.menuView_);
/*      */ 
/*      */     
/* 1227 */     this.menuInsert_.setText("Add");
/*      */     
/* 1229 */     this.menuInsertPanel_.setText("Panel");
/* 1230 */     this.menuInsertPanel_.addActionListener(this.insertPanelAction_);
/* 1231 */     this.menuInsert_.add(this.menuInsertPanel_);
/*      */     
/* 1233 */     this.menuInsertSection_.setText("Section");
/* 1234 */     this.menuInsertSection_.addActionListener(this.insertSectionAction_);
/* 1235 */     this.menuInsert_.add(this.menuInsertSection_);
/*      */     
/* 1237 */     this.menuInsertSectionRef_.setText("Section Reference");
/* 1238 */     this.menuInsertSectionRef_.addActionListener(this.insertSectionRefAction_);
/* 1239 */     this.menuInsert_.add(this.menuInsertSectionRef_);
/*      */     
/* 1241 */     this.menuInsertComponent_.setText("Component...");
/* 1242 */     this.menuInsertComponent_.addActionListener(this.insertComponentAction_);
/* 1243 */     this.menuInsert_.add(this.menuInsertComponent_);
/*      */     
/* 1245 */     this.menuInsertRow_.setText("Row...");
/* 1246 */     this.menuInsertRow_.addActionListener(this.insertRowAction_);
/* 1247 */     this.menuInsert_.add(this.menuInsertRow_);
/*      */     
/* 1249 */     this.menuInsertColumn_.setText("Column...");
/* 1250 */     this.menuInsertColumn_.addActionListener(this.insertColumnAction_);
/* 1251 */     this.menuInsert_.add(this.menuInsertColumn_);
/*      */     
/* 1253 */     this.menus_.add(this.menuInsert_);
/*      */ 
/*      */     
/* 1256 */     this.menuRow_.setText("Row");
/*      */     
/* 1258 */     this.menuRowInsert_.setText("Insert...");
/* 1259 */     this.menuRowInsert_.addActionListener(this.insertRowAction_);
/* 1260 */     this.menuRow_.add(this.menuRowInsert_);
/*      */     
/* 1262 */     this.menuRowDelete_.setText("Delete...");
/* 1263 */     this.menuRowDelete_.addActionListener(this.deleteRowAction_);
/* 1264 */     this.menuRow_.add(this.menuRowDelete_);
/*      */     
/* 1266 */     this.menuRowEditHeight_.setText("Edit Height...");
/* 1267 */     this.menuRowEditHeight_.addActionListener(this.editRowHeightAction_);
/* 1268 */     this.menuRow_.add(this.menuRowEditHeight_);
/*      */     
/* 1270 */     this.menus_.add(this.menuRow_);
/*      */ 
/*      */     
/* 1273 */     this.menuColumn_.setText("Column");
/*      */     
/* 1275 */     this.menuColumnInsert_.setText("Insert...");
/* 1276 */     this.menuColumnInsert_.addActionListener(this.insertColumnAction_);
/* 1277 */     this.menuColumn_.add(this.menuColumnInsert_);
/*      */     
/* 1279 */     this.menuColumnDelete_.setText("Delete...");
/* 1280 */     this.menuColumnDelete_.addActionListener(this.deleteColumnAction_);
/* 1281 */     this.menuColumn_.add(this.menuColumnDelete_);
/*      */     
/* 1283 */     this.menuColumnEditWidth_.setText("Edit Width...");
/* 1284 */     this.menuColumnEditWidth_.addActionListener(this.editColumnWidthAction_);
/* 1285 */     this.menuColumn_.add(this.menuColumnEditWidth_);
/*      */     
/* 1287 */     this.menus_.add(this.menuColumn_);
/*      */ 
/*      */     
/* 1290 */     this.toolBar_.setBorder((Border)null);
/* 1291 */     this.toolBar_.setBorderPainted(false);
/*      */     
/* 1293 */     this.openButton_.addActionListener(this.openAction_);
/* 1294 */     this.openButton_.setText("Open Form");
/* 1295 */     this.toolBar_.add(this.openButton_);
/*      */     
/* 1297 */     this.saveButton_.addActionListener(this.saveAction_);
/* 1298 */     this.saveButton_.setText("Save");
/* 1299 */     this.toolBar_.add(this.saveButton_);
/*      */     
/* 1301 */     this.toolBar_.add(this.workingDirLabel_);
/* 1302 */     this.toolBar_.add(new JLabel("  "));
/* 1303 */     this.toolBar_.add(this.formSourceLabel_);
/*      */ 
/*      */ 
/*      */     
/* 1307 */     this.deleteComponentPopupItem_.setText("Delete Component...");
/* 1308 */     this.deleteComponentPopupItem_.addActionListener(this.deleteComponentAction_);
/* 1309 */     this.formCellPopupMenu_.add(this.deleteComponentPopupItem_);
/*      */     
/* 1311 */     this.addComponentPopupItem_.setText("New Component...");
/* 1312 */     this.addComponentPopupItem_.addActionListener(this.insertComponentAction_);
/* 1313 */     this.formCellPopupMenu_.add(this.addComponentPopupItem_);
/*      */     
/* 1315 */     this.editColumnWidthPopupItem_.setText("Edit Column Width...");
/* 1316 */     this.editColumnWidthPopupItem_.addActionListener(this.editColumnWidthAction_);
/* 1317 */     this.formCellPopupMenu_.add(this.editColumnWidthPopupItem_);
/*      */     
/* 1319 */     this.editRowHeightPopupItem_.setText("Edit Row Height...");
/* 1320 */     this.editRowHeightPopupItem_.addActionListener(this.editRowHeightAction_);
/* 1321 */     this.formCellPopupMenu_.add(this.editRowHeightPopupItem_);
/*      */ 
/*      */     
/* 1324 */     this.deletePanelPopupItem_.setText("Delete Panel...");
/* 1325 */     this.deletePanelPopupItem_.addActionListener(this.deletePanelAction_);
/* 1326 */     this.formPanelPopupMenu_.add(this.deletePanelPopupItem_);
/*      */ 
/*      */     
/* 1329 */     this.deleteSectionPopupItem_.setText("Delete Section...");
/* 1330 */     this.deleteSectionPopupItem_.addActionListener(this.deleteSectionAction_);
/* 1331 */     this.sectionPopupMenu_.add(this.deleteSectionPopupItem_);
/*      */ 
/*      */     
/* 1334 */     this.deleteSectionRefPopupItem_.setText("Delete Section Reference...");
/* 1335 */     this.deleteSectionRefPopupItem_.addActionListener(this.deleteSectionRefAction_);
/* 1336 */     this.sectionRefPopupMenu_.add(this.deleteSectionRefPopupItem_);
/*      */ 
/*      */     
/* 1339 */     Container contentPane = this;
/* 1340 */     contentPane.setLayout(new BorderLayout());
/* 1341 */     contentPane.add(this.toolBar_, "North");
/* 1342 */     contentPane.add(this.mainSplit_, "Center");
/* 1343 */     this.mainSplit_.setDividerLocation(200);
/*      */ 
/*      */     
/* 1346 */     this.mainSplit_.add(this.treeScrollPane_, "left");
/* 1347 */     this.treeScrollPane_.getViewport().add(this.componentTree_);
/* 1348 */     this.componentTree_.addMouseListener(this.treeMouseListener_);
/* 1349 */     this.componentTree_.addTreeSelectionListener((TreeSelectionListener)this.detailModel_);
/*      */ 
/*      */     
/* 1352 */     this.mainSplit_.add(this.formHorizontalSplit_, "right");
/* 1353 */     this.formHorizontalSplit_.setOrientation(0);
/*      */ 
/*      */     
/* 1356 */     this.formHorizontalSplit_.add(this.formPanel_, "top");
/* 1357 */     this.formPanel_.setLayout(this.formPanelLayout_);
/* 1358 */     resetFormPanelContents();
/* 1359 */     this.glassPanel_.addMouseListener(this.formMouseListener_);
/*      */ 
/*      */     
/* 1362 */     this.detailEditScrollPane_.setVerticalScrollBarPolicy(22);
/* 1363 */     this.detailEditScrollPane_.setHorizontalScrollBarPolicy(30);
/* 1364 */     this.formHorizontalSplit_.add(this.detailEditScrollPane_, "bottom");
/* 1365 */     this.detailEditScrollPane_.getViewport().add(this.detailView_);
/*      */   }
/*      */   
/*      */   private static class FormSelection
/*      */     implements Comparable<FormSelection>
/*      */   {
/*      */     private final IFormViewConfig config_;
/*      */     
/*      */     FormSelection(IFormViewConfig argConfig) {
/* 1374 */       this.config_ = argConfig;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int compareTo(FormSelection argO) {
/* 1381 */       FormKey otherKey = argO.getFormKey();
/* 1382 */       if (otherKey == null || getFormKey() == null) return 1; 
/* 1383 */       return getFormKey().compareTo(otherKey);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(Object argObj) {
/* 1389 */       if (argObj == this) {
/* 1390 */         return true;
/*      */       }
/* 1392 */       if (!(argObj instanceof FormSelection)) {
/* 1393 */         return false;
/*      */       }
/* 1395 */       return this.config_.getFormKey().equals(((FormSelection)argObj).getFormKey());
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/* 1401 */       return this.config_.getFormKey().hashCode();
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1406 */       return "<html>" + getFormKey() + "  <small>" + this.config_.getSourceUrl() + "</small></html>";
/*      */     }
/*      */     
/*      */     FormKey getFormKey() {
/* 1410 */       return this.config_.getFormKey();
/*      */     }
/*      */   }
/*      */   
/*      */   private class SetFormWorker
/*      */     implements Runnable
/*      */   {
/*      */     private final FormKey key_;
/*      */     
/*      */     SetFormWorker(FormKey argKey) {
/* 1420 */       this.key_ = argKey;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void run() {
/*      */       try {
/* 1427 */         FormDesigner.this.formKey_ = this.key_;
/* 1428 */         FormDesigner.this.viewConfig_ = FormDesigner.this.formHelper_.getFormViewConfig(FormDesigner.this.formKey_);
/* 1429 */         if (FormDesigner.this.viewConfig_ == null) {
/* 1430 */           FormDesigner.this.viewConfig_ = FormFactory.getInstance().makeForm(FormDesigner.this.formKey_);
/* 1431 */           FormDesigner.this.formHelper_.addFormConfig((IFormViewConfig)FormDesigner.this.viewConfig_);
/* 1432 */           FormDesigner.this.formHelper_.save(FormDesigner.this.getWorkingDir());
/*      */           
/* 1434 */           FormDesigner.this.initFormHelper();
/*      */           
/* 1436 */           FormDesigner.this.viewConfig_ = FormDesigner.this.formHelper_.getFormViewConfig(FormDesigner.this.formKey_);
/*      */         } 
/* 1438 */         FormDesigner.this.componentTree_.setCellRenderer(new FormViewConfigTreeCellRenderer());
/* 1439 */         FormDesigner.this.componentTree_.setModel((TreeModel)(FormDesigner.this.treeModel_ = new FormViewConfigTreeModel((IFormViewConfig)FormDesigner.this.viewConfig_)));
/* 1440 */         FormDesigner.this.componentTree_.setSelectionRow(0);
/*      */         
/* 1442 */         FormDesigner.this.form_ = FormDesigner.this.formHelper_.assemble(FormDesigner.this.formKey_, true);
/* 1443 */         FormDesigner.this.formComponent_ = FormDesigner.this.form_.getDisplayComponent();
/* 1444 */         if (FormDesigner.this.form_ instanceof IMasterDetailFormPanel) {
/*      */           
/* 1446 */           ISingleSelectionModel tabSelectionModel = ((IMasterDetailFormPanel)FormDesigner.this.form_).getSelectionModel();
/* 1447 */           tabSelectionModel.addChangeListener(FormDesigner.this.tabChangeListener_);
/*      */         } 
/*      */         
/* 1450 */         if (FormDesigner.this.formComponent_ == null) {
/* 1451 */           FormDesigner.logger_.fatal("form not loaded");
/* 1452 */           System.exit(-1);
/*      */         } 
/* 1454 */         FormDesigner.this.formSourceLabel_.setText("source: " + FormDesigner.this.formHelper_.getSourceDescription(FormDesigner.this.formKey_));
/* 1455 */         FormDesigner.this.resetFormPanelContents();
/*      */       
/*      */       }
/* 1458 */       catch (Exception ex) {
/* 1459 */         FormDesigner.logger_.fatal("CAUGHT EXCEPTION", ex);
/* 1460 */         System.exit(-1);
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   private class TreeSelectionWorker
/*      */     implements Runnable
/*      */   {
/*      */     private final TreePath path_;
/*      */     
/*      */     public TreeSelectionWorker(TreePath argPath) {
/* 1471 */       this.path_ = argPath;
/*      */     }
/*      */ 
/*      */     
/*      */     public void run() {
/*      */       try {
/* 1477 */         FormDesigner.this.componentTree_.setSelectionPath(this.path_);
/*      */       }
/* 1479 */       catch (Exception ex) {
/* 1480 */         FormDesigner.logger_.error("CAUGHT EXCEPTION", ex);
/*      */       } 
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\form\design\FormDesigner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */