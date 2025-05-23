/*    */ package dtv.pos.framework.keycommands;
/*    */ 
/*    */ import dtv.ipc.server.IpcRequest;
/*    */ import dtv.pos.framework.comm.TaskService;
/*    */ import dtv.util.StringUtils;
/*    */ import java.awt.Container;
/*    */ import java.awt.GridLayout;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import javax.swing.AbstractAction;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JComboBox;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JTextField;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MessageDebugger
/*    */   implements IKeyCommand
/*    */ {
/* 29 */   private static final TaskService service_ = new TaskService();
/*    */ 
/*    */ 
/*    */   
/*    */   public void execute() {
/* 34 */     JFrame frame = new JFrame("Message Tester");
/* 35 */     Container cp = frame.getContentPane();
/* 36 */     cp.setLayout(new GridLayout(5, 2, 3, 10));
/*    */     
/* 38 */     JLabel taskLabel = new JLabel("Task:");
/* 39 */     JLabel statusLabel = new JLabel("Status:");
/* 40 */     JLabel idLabel = new JLabel("ID:");
/* 41 */     JLabel actionLabel = new JLabel("Action:");
/*    */     
/* 43 */     final JComboBox<String> tasks = new JComboBox<>(new String[] { "", "NONE", "OPEN", "CLOSING", "INIT_STORE_CLOSE", "FINALIZE_STORE_CLOSE", "NOTIFY_MASTER_BACKUP_READY", "UPDATE_SOFTWARE", "PREPARE_POLLING_FILE", "CONSOLIDATE_LOGS", "UNZIP_DOWNLOAD_FILES", "DATALOADER", "REPORTS", "NOTIFY_MASTER_DB_BACKUP_READY", "CLEAR_UPDATE_FILES", "POLL", "PROCESS_DOWNLOADS", "BACKUP_DATABASE", "SERVER_BACKUP", "ARCHIVE_DATABASE" });
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 52 */     final JComboBox<String> statuses = new JComboBox<>(new String[] { "", "RUN", "SUCCESS", "WARNING", "ERROR" });
/*    */     
/* 54 */     final JTextField id = new JTextField();
/*    */     
/* 56 */     JButton sendMsg = new JButton(new AbstractAction()
/*    */         {
/*    */           private static final long serialVersionUID = 1L;
/*    */ 
/*    */           
/*    */           public void actionPerformed(ActionEvent event) {
/* 62 */             Map<String, String> params = new HashMap<>();
/* 63 */             params.put("task", (String)tasks.getSelectedItem());
/* 64 */             params.put("status", (String)statuses.getSelectedItem());
/* 65 */             params.put("id", StringUtils.nonNull(id.getText()).trim());
/*    */             
/* 67 */             IpcRequest request = new IpcRequest(null, params);
/* 68 */             MessageDebugger.service_.invoke(request);
/*    */           }
/*    */         });
/*    */     
/* 72 */     cp.add(taskLabel);
/* 73 */     cp.add(tasks);
/* 74 */     cp.add(statusLabel);
/* 75 */     cp.add(statuses);
/* 76 */     cp.add(idLabel);
/* 77 */     cp.add(id);
/* 78 */     cp.add(actionLabel);
/* 79 */     cp.add(sendMsg);
/*    */     
/* 81 */     frame.pack();
/* 82 */     frame.setVisible(true);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getCommand() {
/* 91 */     return "msg";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getHelpText() {
/* 97 */     return "test messages";
/*    */   }
/*    */ }


/* Location:              C:\WIP-Xstore_Delta-main\release\xstore\xstore\lib\dtv-posframework.jar!\dtv\pos\framework\keycommands\MessageDebugger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */