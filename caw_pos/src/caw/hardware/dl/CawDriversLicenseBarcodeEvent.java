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
 * Req/Bug ID#          ddMMyy    Description
 * BZ26268              110220    Driver License and State ID scan for customer add/age prompts
 *===================================================================
 */

package caw.hardware.dl;

import java.util.*;

import dtv.hardware.dl.IDriversLicenseEvent;
import dtv.hardware.events.AbstractInputEvent;
import dtv.hardware.types.InputType;
import dtv.pos.iframework.hardware.Barcode;
import dtv.util.DateUtils;
import dtv.util.StringUtils;
import dtv.util.crypto.EncString;

/**
 *
 */
public class CawDriversLicenseBarcodeEvent extends AbstractInputEvent<Barcode> implements IDriversLicenseEvent {

    public CawDriversLicenseBarcodeEvent(Barcode argInput) {
        super(InputType.INPUT_DRIVERS_LICENSE, argInput);
        this.parseBarcode(argInput.getData());
    }

    private final String[] _data = new String[8];

    @Override
    public String getFirstName() {
        // @todo Auto-generated method stub
        return _data[0];
    }

    /* (non-Javadoc)
     * @see dtv.hardware.dl.IDriversLicenseEvent#getLastName()
     */
    @Override
    public String getLastName() {
        // @todo Auto-generated method stub
        return _data[1];
    }

    /* (non-Javadoc)
     * @see dtv.hardware.dl.IDriversLicenseEvent#getMiddleName()
     */
    @Override
    public String getMiddleName() {
        // @todo Auto-generated method stub
        return _data[2];
    }

    /* (non-Javadoc)
     * @see dtv.hardware.dl.IDriversLicenseEvent#getAddress1()
     */
    @Override
    public String getAddress1() {
        // @todo Auto-generated method stub
        return _data[3];
    }

    /* (non-Javadoc)
     * @see dtv.hardware.dl.IDriversLicenseEvent#getAddress2()
     */
    @Override
    public String getAddress2() {
        // @todo Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see dtv.hardware.dl.IDriversLicenseEvent#getCity()
     */
    @Override
    public String getCity() {
        // @todo Auto-generated method stub
        return _data[4];
    }

    /* (non-Javadoc)
     * @see dtv.hardware.dl.IDriversLicenseEvent#getState()
     */
    @Override
    public String getState() {
        // @todo Auto-generated method stub
        return _data[5];
    }

    /* (non-Javadoc)
     * @see dtv.hardware.dl.IDriversLicenseEvent#getPostalCode()
     */
    @Override
    public String getPostalCode() {
        // @todo Auto-generated method stub
        return formatPostalCode(_data[6]);
    }

    /* (non-Javadoc)
     * @see dtv.hardware.dl.IDriversLicenseEvent#getDob()
     */
    @Override
    public Date getDob() {
        // @todo Auto-generated method stub
        return DateUtils.parseDate(this._data[7], "MMddyyyy");
    }

    /* (non-Javadoc)
     * @see dtv.hardware.dl.IDriversLicenseEvent#getFirstName()
     */

    protected String formatPostalCode(String argPostalCode) {

        String formattedResult = argPostalCode;
        if (StringUtils.isNumber(argPostalCode) && argPostalCode.length() > 5) {
            formattedResult = argPostalCode.substring(0, 5) + "-" + argPostalCode.substring(5);
        }
        return formattedResult;
    }

    protected void parseBarcode(EncString argData) {

        String[] lines = EncString.getSensitiveData(argData).split("\n");
        String firstName = "DAC";
        String lastName = "DCS";
        String middleName = "DAD";
        String address = "DAG";
        String city = "DAI";
        String state = "DAJ";
        String postalCode = "DAK";
        String dateOfBirth = "DBB";
        ArrayList<String> list = new ArrayList<String>(
                Arrays.asList(firstName, lastName, address, city, state, postalCode, dateOfBirth, middleName));

        String threeCharacter = StringUtils.EMPTY;
        String value = StringUtils.EMPTY;
        for (String line : lines) {
            if (line.length() > 3) {
                threeCharacter = line.substring(0, 3);
                if (list.contains(threeCharacter)) {
                    value = line.substring(3, line.length());

                    list.remove(threeCharacter);

                    if (firstName.equals(threeCharacter)) {
                        _data[0] = value;
                    } else if (lastName.equals(threeCharacter)) {
                        _data[1] = value;
                    } else if (middleName.equals(threeCharacter)) {
                        _data[2] = value;
                    } else if (address.equals(threeCharacter)) {
                        _data[3] = value;
                    } else if (city.equals(threeCharacter)) {
                        _data[4] = value;
                    } else if (state.equals(threeCharacter)) {
                        _data[5] = value;
                    } else if (postalCode.equals(threeCharacter)) {
                        _data[6] = value;
                    } else if (dateOfBirth.equals(threeCharacter)) {
                        _data[7] = value;
                    }
                }
                if (list.isEmpty()) {
                    break;
                }
            }
        }
    }

}