<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="TestSuiteSummary">
    <html>
      <head>
        <style>
          span { font-family:'Verdana'; color:white; }
          table,th,td { border:1px solid black; border-collapse:collapse; font-family:'Verdana'; }
          th,td { padding:5px; }
        </style>
      </head>
      <body bgcolor="#0061aa">
        <p>
          <span style="font-size: 200%">XFG-Unit Testsuite Summary</span>
        </p>
        <p>
          <span style="font-size: 150%">
            Successful:
            <xsl:value-of select="@Successful" />
            of
            <xsl:value-of select="@Total" />
          </span>
        </p>
        <p>
         <span style="font-size: 150%">
           Total Time:
           <xsl:value-of select="@TotalTime" />
          </span>
        </p>
        <br />
        <xsl:for-each select="TestSuite">
          <xsl:variable name="failed" select="boolean(@Successful != @Total)" />
          <p>
            <span style="font-size: 120%"> Testsuite </span>
            <span style="font-size: 120%">
              <xsl:value-of select="@FileName" />
            </span>
          </p>
          <p>
            <span style="font-size: 120%">
              Successful:
              <xsl:value-of select="@Successful" />
              of
              <xsl:value-of select="@Total" />
            </span>
            
          </p>
          <p>
            <span style="font-size: 120%">
              Test suite total time:
              <xsl:value-of select="@TotalSuiteTime" />
            </span>
            
          </p>
          <table style="background: white" border="1">
            <tr>
              <th style="text-align:left">Testcase</th>
              <th style="text-align:left">Start-Time</th>
              <th style="text-align:left">End-Time</th>
              <th style="text-align:center">Duration</th>
              <th style="text-align:left">Success</th>
              <xsl:if test="$failed='true'">
                <th style="text-align:left">Error-Text</th>
                <th style="text-align:left">Error-Position</th>
              </xsl:if>
            </tr>
            <xsl:for-each select="TestCase">
              <tr>
                <td>
                  <xsl:value-of select="@Description" />
                </td>
                <td>
                  <xsl:value-of select="StartTime" />
                </td>
                <td>
                  <xsl:value-of select="EndTime" />
                </td>
                <td>
                  <xsl:value-of select="Duration" />
                </td>
                <xsl:if test="Success='true'">
                  <td bgcolor="#01DF01">
                    <xsl:value-of select="Success" />
                  </td>
                </xsl:if>
                <xsl:if test="Success='false'">
                  <td bgcolor="#DC143C">
                    <xsl:value-of select="Success" />
                  </td>
                </xsl:if>
                <xsl:if test="$failed='true'">
                  <td>
                    <xsl:value-of select="ErrorText" />
                  </td>
                  <td>
                    <xsl:value-of select="ErrorPosition" />
                  </td>
                </xsl:if>
              </tr>
            </xsl:for-each>
          </table>
          <br />
          <br />
        </xsl:for-each>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>