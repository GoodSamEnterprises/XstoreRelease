/*     */ package dtv.data2.access.impl.daogen;
/*     */ 
/*     */ import dtv.util.FileUtils;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.io.RandomAccessFile;
/*     */ import java.util.concurrent.Callable;
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
/*     */ public class DtjCleaner
/*     */   implements Callable<Void>
/*     */ {
/*     */   private static final String HEADER = "//DTJ-START $Header";
/*     */   private static final String FOOTER = "//DTJ-END $Header";
/*     */   private final File rootDir_;
/*     */   
/*     */   public static void main(String[] args) {
/*  29 */     int status = process(args);
/*  30 */     System.exit(status);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int process(String[] args) {
/*     */     try {
/*  41 */       switch (args.length) {
/*     */         case 0:
/*  43 */           showUsage(System.out);
/*  44 */           return 1;
/*     */         case 1:
/*  46 */           (new DtjCleaner(new File(args[0]))).call();
/*  47 */           return 0;
/*     */       } 
/*  49 */       showUsage(System.err);
/*  50 */       return 1;
/*     */     
/*     */     }
/*  53 */     catch (Throwable ex) {
/*  54 */       System.err.println("CAUGHT EXCEPTION");
/*  55 */       ex.printStackTrace();
/*  56 */       return 2;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void showUsage(PrintStream out) {
/*  61 */     out.println("USAGE: to recursively process *.dtj under <config-directory>, pass the location as an argument, e.g.");
/*  62 */     out.println("\t" + DtjCleaner.class.getName() + " <config-directory>");
/*  63 */     out.println("The exising files will be renamed with a .bak extension.");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DtjCleaner(File argRootDir) {
/*  69 */     this.rootDir_ = argRootDir;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Void call() throws IOException {
/*  76 */     processDir(this.rootDir_);
/*  77 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void processDir(File dir) throws IOException {
/*  83 */     System.out.println("traversing " + dir);
/*  84 */     for (File f : dir.listFiles()) {
/*  85 */       if (!f.isDirectory()) {
/*  86 */         if (f.getAbsolutePath().toLowerCase().endsWith(".dtj")) {
/*  87 */           processDtj(f);
/*     */         }
/*     */       } else {
/*     */         
/*  91 */         processDir(f);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void processDtj(File argF) throws IOException {
/*  99 */     boolean needsHeader = true;
/* 100 */     int headerLinesToRemove = 0;
/* 101 */     boolean needsFooter = true;
/* 102 */     RandomAccessFile raf = new RandomAccessFile(argF, "r");
/* 103 */     String line = raf.readLine();
/* 104 */     if (line.startsWith("//DTJ-START $Header") && line.indexOf('$', "//DTJ-START $Header".length()) > -1) {
/* 105 */       needsHeader = false;
/*     */     } else {
/*     */       
/* 108 */       line = line.trim();
/* 109 */       while (line != null && line.length() == 0) {
/* 110 */         headerLinesToRemove++;
/* 111 */         line = raf.readLine();
/* 112 */         if (line != null) {
/* 113 */           line = line.trim();
/*     */         }
/*     */       } 
/* 116 */       if (line == null) {
/* 117 */         raf.close();
/*     */         return;
/*     */       } 
/* 120 */       line = line.toUpperCase();
/* 121 */       if ((line.startsWith("//$ID") || line.startsWith("// $ID")) && 
/* 122 */         line.endsWith("$")) {
/* 123 */         headerLinesToRemove++;
/*     */       }
/*     */     } 
/*     */     
/* 127 */     long fromEnd = raf.length() - 50L;
/* 128 */     if (fromEnd < 0L) {
/* 129 */       fromEnd = 0L;
/*     */     }
/* 131 */     raf.seek(fromEnd);
/* 132 */     byte[] buff = new byte[50];
/* 133 */     raf.readFully(buff);
/* 134 */     String tail = (new String(buff, "UTF-8")).trim();
/* 135 */     if (tail.endsWith("$") && tail.lastIndexOf("//DTJ-END $Header", 48) > -1) {
/* 136 */       needsFooter = false;
/*     */     }
/* 138 */     raf.close();
/* 139 */     if (!needsHeader && !needsFooter) {
/*     */       return;
/*     */     }
/* 142 */     File newFile = new File(argF.getAbsolutePath() + ".tmp");
/* 143 */     System.out.println("writing " + newFile);
/* 144 */     BufferedWriter w = new BufferedWriter(FileUtils.getFileWriter(newFile));
/* 145 */     BufferedReader r = new BufferedReader(FileUtils.getFileReader(argF));
/* 146 */     if (needsHeader) {
/* 147 */       w.write("//DTJ-START $Header");
/* 148 */       w.write("$");
/* 149 */       w.newLine();
/*     */     } 
/* 151 */     while ((line = r.readLine()) != null) {
/* 152 */       if (headerLinesToRemove > 0) {
/* 153 */         headerLinesToRemove--;
/*     */         continue;
/*     */       } 
/* 156 */       w.write(line);
/* 157 */       w.newLine();
/*     */     } 
/*     */     
/* 160 */     r.close();
/* 161 */     if (needsFooter) {
/* 162 */       w.write("//DTJ-END $Header");
/* 163 */       w.write("$");
/* 164 */       w.newLine();
/*     */     } 
/* 166 */     w.close();
/* 167 */     File bakFile = new File(argF.getAbsolutePath() + ".bak");
/* 168 */     bakFile.delete();
/* 169 */     argF.renameTo(bakFile);
/* 170 */     newFile.renameTo(argF);
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\impl\daogen\DtjCleaner.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */