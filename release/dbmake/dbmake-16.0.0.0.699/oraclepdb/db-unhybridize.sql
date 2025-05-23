-- ***************************************************************************
-- This script "de-hybridizes" a previously "hybridized" script, discarding only those schema 
-- structure which were added during the hybridization process.  It is generally invoked once 
-- against any databases which, at one point, needed to simultaneously accommodate clients running 
-- on two versions of Xstore.
--
-- NOTE: This script only "undoes" any changes made explicitly and exclusively by a corresponding
-- "hybridize" script.  It does not perform any schema changes included in the standard "upgrade" 
-- script but excluded from the corresponding "hybridize" script.  To affect those conversion 
-- changes excluded from this script, run the full "upgrade" script after running this one.

-- If, for example, the A-to-B "upgrade" script drops table T but the A-and-B "hybridize" script 
-- retains T for cross-version compatibility, the A-and-B "unhybridize" script will not drop T.
-- To drop T from the A-and-B database, the A-to-B "upgrade" script will have to be invoked after 
-- the A-and-B "unhybridize" script.
--
-- Source version:  15.0.*
-- Target version:  16.0.0
-- DB platform:     Oracle 10g/11g/12c
-- ***************************************************************************
PROMPT '**************************************';
PROMPT '*****       UNHYBRIDIZING        *****';
PROMPT '***** From:  15.0.*              *****';
PROMPT '*****   To:  16.0.0		         *****';
PROMPT '**************************************';
/

alter session set current_schema=$(DbSchema);


PROMPT '**************************************';
PROMPT 'Finalizing release version 16.0.0';
PROMPT '**************************************';
/

BEGIN
  IF SP_COLUMN_EXISTS('itm_item_options','restriction_category') THEN
        dbms_output.put_line('     itm_item_options.restriction_category dropped');
        EXECUTE IMMEDIATE 'ALTER TABLE itm_item_options DROP COLUMN restriction_category';
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS('itm_item_restriction','dependent_flag') THEN
        dbms_output.put_line('     itm_item_restriction.dependent_flag dropped');
        EXECUTE IMMEDIATE 'ALTER TABLE itm_item_restriction DROP COLUMN dependent_flag';
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS('COM_FLIGHT_INFO','DESTINATION_COUNTRY') THEN
        dbms_output.put_line('     COM_FLIGHT_INFO.DESTINATION_COUNTRY dropped');
        EXECUTE IMMEDIATE 'ALTER TABLE COM_FLIGHT_INFO DROP COLUMN DESTINATION_COUNTRY';
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS('COM_FLIGHT_INFO','DESTINATION_EU_CODE') THEN
        dbms_output.put_line('     COM_FLIGHT_INFO.DESTINATION_EU_CODE dropped');
        EXECUTE IMMEDIATE 'ALTER TABLE COM_FLIGHT_INFO DROP COLUMN DESTINATION_EU_CODE';
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS('COM_FLIGHT_INFO','VIA_1_COUNTRY') THEN
        dbms_output.put_line('     COM_FLIGHT_INFO.VIA_1_COUNTRY dropped');
        EXECUTE IMMEDIATE 'ALTER TABLE COM_FLIGHT_INFO DROP COLUMN VIA_1_COUNTRY';
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS('COM_FLIGHT_INFO','VIA_1_EU_CODE') THEN
        dbms_output.put_line('     COM_FLIGHT_INFO.VIA_1_EU_CODE dropped');
        EXECUTE IMMEDIATE 'ALTER TABLE COM_FLIGHT_INFO DROP COLUMN VIA_1_EU_CODE';
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS('COM_FLIGHT_INFO','VIA_2_COUNTRY') THEN
        dbms_output.put_line('     COM_FLIGHT_INFO.VIA_2_COUNTRY dropped');
        EXECUTE IMMEDIATE 'ALTER TABLE COM_FLIGHT_INFO DROP COLUMN VIA_2_COUNTRY';
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS('COM_FLIGHT_INFO','VIA_2_EU_CODE') THEN
        dbms_output.put_line('     COM_FLIGHT_INFO.VIA_2_EU_CODE dropped');
        EXECUTE IMMEDIATE 'ALTER TABLE COM_FLIGHT_INFO DROP COLUMN VIA_2_EU_CODE';
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS('COM_FLIGHT_INFO','VIA_3_COUNTRY') THEN
        dbms_output.put_line('     COM_FLIGHT_INFO.VIA_3_COUNTRY dropped');
        EXECUTE IMMEDIATE 'ALTER TABLE COM_FLIGHT_INFO DROP COLUMN VIA_3_COUNTRY';
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS('COM_FLIGHT_INFO','VIA_3_EU_CODE') THEN
        dbms_output.put_line('     COM_FLIGHT_INFO.VIA_3_EU_CODE dropped');
        EXECUTE IMMEDIATE 'ALTER TABLE COM_FLIGHT_INFO DROP COLUMN VIA_3_EU_CODE';
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS('COM_FLIGHT_INFO','FINAL_FLIGHT_EU_CODE') THEN
        EXECUTE IMMEDIATE 'ALTER TABLE COM_FLIGHT_INFO DROP COLUMN FINAL_FLIGHT_EU_CODE';
        dbms_output.put_line('     COM_FLIGHT_INFO.FINAL_FLIGHT_EU_CODE dropped');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS('COM_FLIGHT_INFO','DESTINATION_AIRPORT_NAME') THEN
        EXECUTE IMMEDIATE 'ALTER TABLE COM_FLIGHT_INFO DROP COLUMN DESTINATION_AIRPORT_NAME';
        dbms_output.put_line('     COM_FLIGHT_INFO.DESTINATION_AIRPORT_NAME dropped');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS('COM_FLIGHT_INFO','EMPLOYEE_FLAG') THEN
        EXECUTE IMMEDIATE 'ALTER TABLE COM_FLIGHT_INFO DROP COLUMN EMPLOYEE_FLAG';
        dbms_output.put_line('     COM_FLIGHT_INFO.EMPLOYEE_FLAG dropped');
  END IF;
END;
/

BEGIN
  IF SP_TABLE_EXISTS ('COM_AIRPORT_ZONE_MAPPING') THEN
    EXECUTE IMMEDIATE 'DROP TABLE COM_AIRPORT_ZONE_MAPPING';
    dbms_output.put_line('     COM_AIRPORT_ZONE_MAPPING dropped');
  END IF;
END;
/

BEGIN
  IF SP_TABLE_EXISTS ('COM_AIRPORT_ZONE_MAPPING_P') THEN
    EXECUTE IMMEDIATE 'DROP TABLE COM_AIRPORT_ZONE_MAPPING_P';
    dbms_output.put_line('     COM_AIRPORT_ZONE_MAPPING_P dropped');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS('LOC_RTL_LOC','ZONE_ID') THEN
        EXECUTE IMMEDIATE 'ALTER TABLE LOC_RTL_LOC DROP COLUMN ZONE_ID';
        dbms_output.put_line('     LOC_RTL_LOC.ZONE_ID dropped');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS('itm_item_options','tare_typecode') THEN
        EXECUTE IMMEDIATE 'ALTER TABLE itm_item_options DROP COLUMN tare_typecode';
        dbms_output.put_line('     itm_item_options.tare_typecode dropped');
  END IF;
END;
/

BEGIN
  IF SP_TABLE_EXISTS ('itm_tare_type') THEN
    EXECUTE IMMEDIATE 'DROP TABLE itm_tare_type';
    dbms_output.put_line('     itm_tare_type dropped');
  END IF;
END;
/

BEGIN
  IF SP_TABLE_EXISTS ('itm_tare_type_p') THEN
    EXECUTE IMMEDIATE 'DROP TABLE itm_tare_type_p';
    dbms_output.put_line('     itm_tare_type_p dropped');
  END IF;
END;
/

DROP TRIGGER TRG_TRN_TRANS_TRANS_DATE;
/


BEGIN
  IF SP_COLUMN_EXISTS('trl_rtrans_flight_info','expiration_date') THEN
    EXECUTE IMMEDIATE 'ALTER TABLE trl_rtrans_flight_info DROP COLUMN expiration_date';
    dbms_output.put_line('     trl_rtrans_flight_info.expiration_date dropped');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS('trl_rtrans_flight_info','employee_flag') THEN
    EXECUTE IMMEDIATE 'ALTER TABLE trl_rtrans_flight_info DROP COLUMN employee_flag';
    dbms_output.put_line('     trl_rtrans_flight_info.employee_flag dropped');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS('com_flight_info','expiration_date') THEN
    EXECUTE IMMEDIATE 'ALTER TABLE com_flight_info DROP COLUMN expiration_date';
    dbms_output.put_line('     com_flight_info.expiration_date dropped');
  END IF;
END;
/


commit;

PROMPT '***************************************************************************';
PROMPT 'Database now un-hybridized to support clients running against the following versions:';
PROMPT '     16.0.0';
PROMPT 'This database is no longer compatible with clients running against legacy versions';
PROMPT 'previously supported while hybridized.  Please ensure that all clients are updated';
PROMPT 'to the appropriate release.';
PROMPT '***************************************************************************';
/
