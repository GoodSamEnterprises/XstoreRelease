/*     */ package dtv.data2.dataloader.fileprocessing;
/*     */ 
/*     */ import dtv.data2.dataloader.DataLoaderException;
/*     */ import dtv.data2.dataloader.config.DataLoaderConfigHelper;
/*     */ import dtv.util.DateUtils;
/*     */ import dtv.util.StringUtils;
/*     */ import dtv.util.xml.DomUtils;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DataFileHeaderProcessor
/*     */ {
/*     */   public static final String HEADER_VERSION_1 = "@HEADER";
/*     */   public static final String HEADER_VERSION_2 = "<Header";
/*     */   private static final String LINE_COUNT_FIELD = "LINE_COUNT=";
/*     */   
/*     */   public HeaderLine extractHeaderLine(File argFile) {
/*  47 */     HeaderLine headerLine = null;
/*     */     
/*  49 */     String encoding = DataLoaderConfigHelper.getDataLoaderConfig().getCharacterEncoding();
/*  50 */     try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(argFile), encoding))) {
/*     */       String line;
/*     */ 
/*     */ 
/*     */       
/*  55 */       while (reader.ready() && (line = reader.readLine()) != null) {
/*  56 */         if (StringUtils.isEmpty(line) || line.trim().startsWith("#")) {
/*     */           continue;
/*     */         }
/*     */         
/*  60 */         if (isHeaderLine(line)) {
/*  61 */           headerLine = processHeader(line);
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*  66 */     } catch (IOException iOException) {}
/*     */ 
/*     */ 
/*     */     
/*  70 */     return headerLine;
/*     */   }
/*     */   
/*     */   public boolean isHeaderLine(String argFileLine) {
/*  74 */     return (isHeaderVersion1(argFileLine) || isHeaderVersion2(argFileLine));
/*     */   }
/*     */   
/*     */   public boolean isHeaderVersion1(String argFileLine) {
/*  78 */     return argFileLine.startsWith("@HEADER");
/*     */   }
/*     */   
/*     */   public boolean isHeaderVersion2(String argFileLine) {
/*  82 */     return argFileLine.startsWith("<Header");
/*     */   }
/*     */   
/*     */   public HeaderLine processHeader(String argFileLine) {
/*  86 */     if (isHeaderVersion1(argFileLine)) {
/*  87 */       return processHeaderVersion1(argFileLine);
/*     */     }
/*  89 */     if (isHeaderVersion2(argFileLine)) {
/*  90 */       return processHeaderVersion2(argFileLine);
/*     */     }
/*     */     
/*  93 */     throw new DataLoaderException("file line does not appear to be a header. [" + argFileLine + "]");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Boolean getAttributeBooleanValue(Element argElement, String argAttributeName) throws Exception {
/*  99 */     String attribute = DomUtils.getAttributeValue(argElement, argAttributeName);
/*     */     
/* 101 */     if (!attribute.isEmpty()) {
/* 102 */       return Boolean.valueOf(Boolean.parseBoolean(attribute));
/*     */     }
/*     */     
/* 105 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Integer getAttributeIntValue(Element argElement, String argAttributeName) throws Exception {
/* 111 */     String attribute = DomUtils.getAttributeValue(argElement, argAttributeName);
/*     */     
/* 113 */     if (!attribute.isEmpty()) {
/* 114 */       return Integer.valueOf(attribute);
/*     */     }
/*     */     
/* 117 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private String getAttributeValue(Element argElement, String argAttributeName) {
/* 122 */     String attribute = DomUtils.getAttributeValue(argElement, argAttributeName);
/* 123 */     if (!attribute.isEmpty()) {
/* 124 */       return attribute;
/*     */     }
/*     */     
/* 127 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private HeaderLine processHeaderVersion1(String argFileLine) {
/*     */     try {
/* 134 */       if (argFileLine.indexOf("LINE_COUNT=") == -1) {
/* 135 */         throw new DataLoaderException("No Line Count specified in header.");
/*     */       }
/*     */       
/* 138 */       int LINE_COUNT_START = argFileLine.indexOf("LINE_COUNT=") + "LINE_COUNT=".length();
/*     */       
/* 140 */       StringBuilder lineCountString = new StringBuilder(4);
/*     */       
/* 142 */       int index = LINE_COUNT_START;
/*     */       
/* 144 */       while (index < argFileLine.length()) {
/* 145 */         char currentChar = argFileLine.charAt(index);
/* 146 */         if (Character.isDigit(currentChar)) {
/* 147 */           lineCountString.append(currentChar);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 152 */           index++;
/*     */         } 
/*     */       } 
/* 155 */       if (lineCountString.length() == 0) {
/* 156 */         throw new DataLoaderException("No Line Count specified in header.");
/*     */       }
/*     */       
/* 159 */       int lineCount = Integer.parseInt(lineCountString.toString());
/* 160 */       HeaderLine headerLine = new HeaderLine();
/* 161 */       headerLine.setDeclaredLineCount(Integer.valueOf(lineCount));
/* 162 */       return headerLine;
/*     */ 
/*     */     
/*     */     }
/* 166 */     catch (Exception ex) {
/* 167 */       String msg = "Current datafile header specifies invalid header. Header: [" + argFileLine + "]";
/* 168 */       throw new DataLoaderException(msg, ex);
/*     */     } 
/*     */   }
/*     */   
/*     */   private HeaderLine processHeaderVersion2(String argFileLine) {
/*     */     try {
/* 174 */       Document doc = DomUtils.parseXml(argFileLine, new DomUtils.ParseOption[0]);
/* 175 */       Element headerElement = doc.getDocumentElement();
/*     */       
/* 177 */       HeaderLine headerLine = new HeaderLine();
/* 178 */       headerLine.setDeclaredLineCount(getAttributeIntValue(headerElement, "line_count"));
/* 179 */       headerLine.setDownloadId(getAttributeValue(headerElement, "download_id"));
/* 180 */       headerLine.setApplicationDate(DateUtils.parseDate(getAttributeValue(headerElement, "application_date")));
/* 181 */       headerLine.setTargetOrgNode(getAttributeValue(headerElement, "target_org_node"));
/* 182 */       headerLine.setDeploymentName(getAttributeValue(headerElement, "deployment_name"));
/* 183 */       headerLine.setDownloadTime(getAttributeValue(headerElement, "download_time"));
/* 184 */       headerLine.setApplyImmediately(getAttributeBooleanValue(headerElement, "apply_immediately"));
/* 185 */       return headerLine;
/*     */     }
/* 187 */     catch (Exception ex) {
/* 188 */       String msg = "Current datafile header specifies invalid header. Header: [" + argFileLine + "]";
/* 189 */       throw new DataLoaderException(msg, ex);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\dataloader\fileprocessing\DataFileHeaderProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */