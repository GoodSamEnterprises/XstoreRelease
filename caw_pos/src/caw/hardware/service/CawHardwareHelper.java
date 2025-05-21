/**
 * CONFIDENTIAL AND PROPRIETARY SOURCE CODE. 
 * 
 * Use and distribution of this code is subject to applicable 
 * licenses and the permission of the code owner.  This notice 
 * does not indicate the actual or intended publication of 
 * this source code.
 * 
 * Portions developed for Camping World by BTM Global Consulting
 * LLC and are the property of Camping World.
 * 
 * ===== BTM Modification ===========================================
 * Req/Bug ID#      ddMMyy    Description
 * BZ33595          151119    Scanner/Warranty prompt screen - scanner provides 1 successful beep but desire is to have triple error beep
 * BZ34287          161219    [Internal] Xstore show HDE when input sale receipt barcode manually
 *===================================================================
 */

package caw.hardware.service;

import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.log4j.Logger;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import com.zebra.jpos.serviceonscanner.directio.*;
import jpos.JposException;
import jpos.Scanner;
import caw.hardware.barcode.CawBarcodeScanner;
import caw.pos.common.CawConstants;

import dtv.barcode.BarcodeType;
import dtv.hardware.scanner.IDtvBarcodeScanner;
import dtv.hardware.types.HardwareFamilyType;
import dtv.hardware.types.HardwareType;
import dtv.pos.iframework.hardware.Barcode;
import dtv.util.StringUtils;

public class CawHardwareHelper {

    private static final Logger               logger   = Logger.getLogger(CawHardwareHelper.class);

    private static volatile CawHardwareHelper INSTANCE = null;

    private static Scanner                    scanner   = null;

    private static int                        scannerID = 0;

    public HardwareType<IDtvBarcodeScanner> _typeScanner = HardwareType
            .forUse(HardwareFamilyType.SCANNER, CawConstants.CAW_BARCODE_SCANNER); //BZ34287

    /**
    * @return the scanner
    */
    public Scanner getScanner() {
        return scanner;
    }

    /**
     * @param argScanner the scanner to set
     */
    public void setScanner(Scanner argScanner) {
        scanner = argScanner;
    }

    /**
     * @return the scannerID
     */
    public int getScannerID() {
        return scannerID;
    }

    /**
     * @param argScannerID the scannerID to set
     */
    public void setScannerID(int argScannerID) {
        scannerID = argScannerID;
    }

    public static CawHardwareHelper getInstance() {

        if (INSTANCE == null) {
            synchronized (CawHardwareHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CawHardwareHelper();
                }
            }
        }
        return INSTANCE;
    }

    /***
     * Get information with outXml scanner
     * @param scanner
     * @return
     */
    public String getScannerOutXml(Scanner scannerPrara) {

        String scannerOutXML = StringUtils.EMPTY;
        try {
            if (scannerPrara != null) {
                DirectIODeviceData params = new DirectIODeviceData();
                int opCode1 = DirectIOCommand.GET_SCANNERS;
                int[] intObj = null;
                scannerPrara.directIO(opCode1, intObj, params);
                if (params.status == DirectIOStatus.STATUS_SUCCESS) {
                    scannerOutXML = params.outXml;
                    logger.info("Info Scanner OutXML: " + scannerOutXML);
                }
            }
        } catch (JposException ex) {
            logger.error("getScannerOutXml error: " + ex.getMessage());
        }
        return scannerOutXML;
    }

    /**
     * Get scanner ID from outXml scanner
     * @param scannerOutxml
     * @return
     */
    public int getScannerIDFromScannerOutXml(String scannerOutxml) {

        Document xmlDoc = loadXML(scannerOutxml);
        int _scannerID = 0;
        String strScannerID = StringUtils.EMPTY;

        try {
            if (xmlDoc != null) {
                xmlDoc.getDocumentElement().normalize();
                NodeList nodeList = xmlDoc.getElementsByTagName(CawConstants.CAW_SCANNER_TAG);
                // nodeList is not iterable, so we are using for loop  
                int lastNodeScanners = nodeList.getLength() - 1; // get last scanner from OutXml
                Node node = nodeList.item(lastNodeScanners);
                logger.info("Scanner Name: " + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    logger.info("Model number: " + eElement.getElementsByTagName(CawConstants.CAW_SCANNER_MODELNUMBER)
                            .item(0).getTextContent());
                    strScannerID = eElement.getElementsByTagName(CawConstants.CAW_SCANNERID).item(0).getTextContent();
                    logger.info("Scanner ID: " + strScannerID);
                    if (!StringUtils.isEmpty(strScannerID)) {
                        _scannerID = Integer.parseInt(strScannerID);
                    }
                }
            }
        } catch (Exception ex) {
            logger.error("getScannerIDFromScannerOutXml error: " + ex.getMessage());
        }
        return _scannerID;
    }

    /**
     * Convert String to XML
     * @param xml
     * @return
     */
    public static Document loadXML(String xml) {

        try {
            if (!StringUtils.isEmpty(xml)) {
                DocumentBuilderFactory fctr = DocumentBuilderFactory.newInstance();
                DocumentBuilder bldr;
                bldr = fctr.newDocumentBuilder();
                InputSource insrc = new InputSource(new StringReader(xml));
                return bldr.parse(insrc);
            }
        } catch (Exception ex) {
            logger.error("loadXML error: " + ex.getMessage());
        }
        return null;
    }

    /**
     * Build request send three beep to scanner. 
     * @param scanner
     * @param scannerID
     * @param beepType
     * @return
     */
    public boolean sendBeepScanner(Scanner _scanner, int _scannerID, int beepValue) {

        try {
            if (_scanner != null && _scannerID > 0 && beepValue > 0) {
                String sSetAttribInXML = "<attrib_list>\r\n" + 
                        "  <attribute>\r\n" + 
                        "    <id>6000</id>\r\n" + 
                        "    <datatype>X</datatype>\r\n" + 
                        "    <value>" + beepValue + "</value>\r\n" + 
                        "  </attribute>\r\n" + 
                        "</attrib_list>";
                DirectIOData params = new DirectIOData();
                int opCode = DirectIOCommand.RSM_ATTR_SET;
                int[] scnID = new int[1];
                scnID[0] = _scannerID;
                params.inXML = sSetAttribInXML;
                _scanner.directIO(opCode, scnID, params);
                if (params.status == DirectIOStatus.STATUS_SUCCESS) {
                    return true;
                }
            }
        } catch (JposException ex) {
            logger.error("Send beep scanner error: " + ex.getMessage());
        }
        return false;
    }

    /* BEGIN BZ34287 */
    /***
     * Enter barcode receipt for return transaction in sale screen.
     * @param tranBarcode
     */
    public void enterBarcodeSaleReceipts(String tranBarcode) {
        if (_typeScanner != null) {
            CawBarcodeScanner barcodeScanner = new CawBarcodeScanner(_typeScanner);
            Barcode data = new Barcode(tranBarcode, BarcodeType.CODE93, _typeScanner);
            barcodeScanner.inputOccurred(data);
        }
    }
    /* END BZ34287 */
}
