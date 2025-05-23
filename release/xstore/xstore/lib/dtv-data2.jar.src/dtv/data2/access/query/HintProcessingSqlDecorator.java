/*     */ package dtv.data2.access.query;
/*     */ 
/*     */ import dtv.data2.access.IObjectId;
/*     */ import dtv.data2.access.impl.IPersistenceStrategy;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.lang3.ArrayUtils;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
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
/*     */ public class HintProcessingSqlDecorator
/*     */   implements ISqlQueryDecorator
/*     */ {
/*  24 */   private static final Logger _logger = LogManager.getLogger(HintProcessingSqlDecorator.class);
/*     */   
/*     */   private static final String DEFAULT_HINT_BEGIN = "/*";
/*     */   
/*     */   private static final String DEFAULT_HINT_END = "*/";
/*     */   
/*  30 */   private static final char[] NON_ALPHANUMERIC_ID_CHARS = new char[] { '.', '_', '?', '#', '$' };
/*     */   
/*     */   private final Map<String, String> _patterns;
/*     */   private final String _hintEnd;
/*     */   private final String _hintBegin;
/*     */   
/*     */   public HintProcessingSqlDecorator(Map<String, String> argPatterns) {
/*  37 */     this(argPatterns, "/*", "*/");
/*     */   }
/*     */   
/*     */   public HintProcessingSqlDecorator(Map<String, String> argPatterns, String argHintBegin, String argHintEnd) {
/*  41 */     this._patterns = argPatterns;
/*  42 */     this._hintBegin = argHintBegin;
/*  43 */     this._hintEnd = argHintEnd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String decorateSql(String argSqlStatement, IPersistenceStrategy argTargetStrategy, IObjectId argObjId) {
/*  50 */     return replaceHints(argSqlStatement);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String decorateSql(String argSqlStatement, IPersistenceStrategy argTargetStrategy, Map<String, Object> argParams) {
/*  57 */     return replaceHints(argSqlStatement);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected char getEnclosingChar(char argChar) {
/*  66 */     switch (argChar) {
/*     */       case '(':
/*  68 */         return ')';
/*     */     } 
/*  70 */     return argChar;
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
/*     */   protected int[] getTargetBounds(CharSequence argChars, int argStartSeq) {
/*  84 */     int begin = -1;
/*     */     
/*  86 */     int end = argChars.length();
/*     */     
/*  88 */     StringBuilder seekStack = new StringBuilder();
/*  89 */     for (int i = argStartSeq; i < argChars.length(); i++) {
/*  90 */       char currentChar = argChars.charAt(i);
/*     */ 
/*     */       
/*  93 */       if (begin == -1) {
/*  94 */         if (Character.isWhitespace(currentChar)) {
/*     */           continue;
/*     */         }
/*     */         
/*  98 */         begin = i;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 103 */       boolean isQuote = isQuote(currentChar);
/* 104 */       boolean isOpeningParenthese = isOpeningParenthese(currentChar);
/* 105 */       if (seekStack.length() > 0 || isQuote || isOpeningParenthese) {
/* 106 */         char nextExpectedColsure = (seekStack.length() == 0) ? '0' : seekStack.charAt(seekStack.length() - 1);
/* 107 */         if (isOpeningParenthese || (isQuote && nextExpectedColsure != currentChar))
/*     */         {
/* 109 */           seekStack.append(getEnclosingChar(currentChar));
/*     */         }
/* 111 */         else if (nextExpectedColsure == currentChar)
/*     */         {
/* 113 */           seekStack.deleteCharAt(seekStack.length() - 1);
/*     */ 
/*     */         
/*     */         }
/*     */ 
/*     */       
/*     */       }
/* 120 */       else if (!isIdentifierCharacter(currentChar)) {
/* 121 */         end = i;
/*     */         break;
/*     */       } 
/*     */       continue;
/*     */     } 
/* 126 */     (new int[2])[0] = begin; (new int[2])[1] = end; return (begin == -1 || seekStack.length() > 0) ? null : new int[2];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isIdentifierCharacter(char argChar) {
/* 135 */     if (Character.isLetterOrDigit(argChar) || ArrayUtils.contains(NON_ALPHANUMERIC_ID_CHARS, argChar)) {
/* 136 */       return true;
/*     */     }
/* 138 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isOpeningParenthese(char argChar) {
/* 147 */     if (argChar == '(') {
/* 148 */       return true;
/*     */     }
/* 150 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isQuote(char argChar) {
/* 159 */     if (argChar == '\'' || argChar == '"') {
/* 160 */       return true;
/*     */     }
/* 162 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String replaceHints(String argInput) {
/* 171 */     int searchIndex = 0;
/* 172 */     StringBuilder queryString = new StringBuilder(argInput);
/* 173 */     boolean replacementsMade = false;
/* 174 */     while (searchIndex < queryString.length() && (
/* 175 */       searchIndex = queryString.indexOf(this._hintBegin, searchIndex)) != -1) {
/*     */       
/* 177 */       int commentStartIndex = searchIndex;
/* 178 */       int commentContentStartIndex = commentStartIndex + this._hintBegin.length();
/* 179 */       int commentContentEndIndex = queryString.indexOf(this._hintEnd, commentContentStartIndex);
/* 180 */       int commentEndIndex = commentContentEndIndex + this._hintEnd.length();
/*     */ 
/*     */       
/* 183 */       boolean replacementMade = false;
/* 184 */       if (commentContentEndIndex != -1) {
/*     */         
/* 186 */         String hint = queryString.substring(commentContentStartIndex, commentContentEndIndex).trim();
/* 187 */         _logger.debug("Found hint [{}] in Query [{}]", hint, argInput);
/*     */ 
/*     */         
/* 190 */         String pattern = this._patterns.get(hint);
/* 191 */         if (pattern != null) {
/*     */ 
/*     */           
/* 194 */           int[] bounds = getTargetBounds(queryString, commentEndIndex);
/* 195 */           if (bounds != null) {
/* 196 */             String content = queryString.substring(bounds[0], bounds[1]);
/* 197 */             queryString.replace(bounds[0], bounds[1], String.format(pattern, new Object[] { content }));
/* 198 */             queryString.delete(commentStartIndex, commentEndIndex);
/* 199 */             replacementMade = true;
/*     */           } else {
/*     */             
/* 202 */             _logger.warn("Could not find substitution target following pattern[{}] in Query [{}]", hint, argInput);
/*     */           }
/*     */         
/*     */         } else {
/*     */           
/* 207 */           _logger.debug("Could not find substitution sequence for hint pattern [{}] in Query [{}]", hint, argInput);
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 212 */         _logger.warn("Could not find end of comment sequence in Query [{}]", argInput);
/*     */       } 
/*     */ 
/*     */       
/* 216 */       if (!replacementMade) {
/* 217 */         searchIndex++;
/*     */         continue;
/*     */       } 
/* 220 */       replacementsMade = true;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 225 */     return replacementsMade ? queryString.toString() : argInput;
/*     */   }
/*     */ }


/* Location:              C:\Base_Xstore_workspace_code\release\xstore\xstore\lib\dtv-data2.jar!\dtv\data2\access\query\HintProcessingSqlDecorator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */