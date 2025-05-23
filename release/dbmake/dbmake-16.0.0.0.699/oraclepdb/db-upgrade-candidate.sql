-- ***************************************************************************
-- This script is a "staging area" for database schema changes proposed by development and subject
-- to review and acceptance/rejection/modification by the DBA.
--
-- Developers should manually apply this script to their local environments to enable them to run
-- Xstore against recently implemented changes while the schema modification review process is
-- pending/underway.  Published builds, however, must always incorporate the approved schema changes
-- represented in the companion script db-upgrade.sql.
--
-- For any SQL statement X included here, the following must be true:
--
-- *** X converts one or more schema artifacts from a <source>-compatible form to a <target>-
--     compatible form, where <source> and <target> represent a legacy Xstore release version and a
--     more modern release version, respectively.
--
-- *** If X is modified or rejected by the DBA, the developer adding X to this script is responsible
--     for updating the relevant programmatic artifacts and pre-defined data depending on the
--     modified/rejected changes.
--
-- *** If X is associated with a new or enhanced Xstore feature, it should be annotated with its
--     corresponding JIRA story as follows:
--          <SQL statement>     -- [<JIRA story>]
--     e.g. ALTER TABLE some_table ADD some_col varchar2(30);      -- [XSTORE-278754]
--
--     Multiple SQL statements can be associated with a single activity using a start/end notation:
--          -- [<JIRA story>]
--          <SQL Statement 1>
--          <SQL Statement n>
--          -- [/<JIRA story>]
--
--     e.g. -- [XSTORE-278754]
--          ALTER TABLE some_table ADD some_col varchar2(30);
--          ALTER TABLE some_table ADD some_other_col varchar2(30);
--          -- [/XSTORE-278754]
--
--     The word "General" may be substituted for a JIRA story for schema changes that do not
--     correspond to a new/enhanced feature (e.g. dropping obsolete tables/columns).
--
-- *** To facilitate ongoing review and incorporation of the contents of this script into its
--     production-caliber counterpart, X should always be added to the end of this script, even
--     if it pertains to an activity with related schema changes represented earlier.
--
-- *** Unlike the case with the production db-upgrade.sql script, developers don't need to make any
--     accommodation to ensure that X may be executed repeatedly without error.  This applies
--     primarily to "not exists" checks wrapping statements creating tables and adding columns; it
--     is not necessary to add them here.
--
--     X, however, must successfully run at least once, meaning that some clerical boilerplate might
--     be needed for certain operations (e.g. changing a primary key, dropping a column with a
--     default constraint).  A failure to run X must also not prevent the execution of subsequent
--     statements in this script.
--
-- Source version:  15.0.x
-- Target version:  16.0.0
-- DB platform:     Oracle 10g/11g/12c
-- ***************************************************************************

--[RXPS-14786]
BEGIN
  IF SP_COLUMN_EXISTS( 'com_button_grid','sort_order') THEN
        dbms_output.put_line('     com_button_grid.sort_order already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE com_button_grid ADD sort_order NUMBER(10,0) DEFAULT 0 NOT NULL';
        EXECUTE IMMEDIATE 'ALTER TABLE com_button_grid DROP PRIMARY KEY DROP INDEX';
        EXECUTE IMMEDIATE 'ALTER TABLE com_button_grid ADD CONSTRAINT pk_com_button_grid PRIMARY KEY (organization_id, level_code, level_value, grid_id, row_id, column_id, component_id, sort_order) USING INDEX TABLESPACE $(DbTblspace)_index';
        dbms_output.put_line('     com_button_grid.sort_order created');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS( 'com_button_grid','action_idx') THEN
        dbms_output.put_line('     com_button_grid.action_idx already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE com_button_grid ADD action_idx NUMBER(10,0)';
        dbms_output.put_line('     com_button_grid.action_idx created');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS( 'com_button_grid','animation_idx') THEN
        dbms_output.put_line('     com_button_grid.animation_idx already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE com_button_grid ADD animation_idx NUMBER(10,0)';
        dbms_output.put_line('     com_button_grid.animation_idx created');
  END IF;
END;
/
--[/RXPS-14786]

--[RXPS-16239, RXPS-16539]
BEGIN
  IF SP_COLUMN_EXISTS( 'tsn_tndr_control_trans','safe_bag_id') THEN
        dbms_output.put_line('     tsn_tndr_control_trans.safe_bag_id already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE tsn_tndr_control_trans ADD safe_bag_id VARCHAR2(60 char)';
        dbms_output.put_line('     tsn_tndr_control_trans.safe_bag_id created');
  END IF;
END;
/
--[/RXPS-16239, RXPS-16539]

--[RXPS-15284]
BEGIN
  IF SP_COLUMN_EXISTS( 'civc_invoice','ext_invoice_id') THEN
        dbms_output.put_line('     civc_invoice.ext_invoice_id already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE civc_invoice ADD ext_invoice_id VARCHAR2(60 char)';
        dbms_output.put_line('     civc_invoice.ext_invoice_id created');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS( 'civc_invoice','gross_amt') THEN
        dbms_output.put_line('     civc_invoice.gross_amt already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE civc_invoice ADD gross_amt NUMBER(17, 6)';
        dbms_output.put_line('     civc_invoice.gross_amt created');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS( 'civc_invoice','refund_amt') THEN
        dbms_output.put_line('     civc_invoice.refund_amt already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE civc_invoice ADD refund_amt NUMBER(17, 6)';
        dbms_output.put_line('     civc_invoice.refund_amt created');
  END IF;
END;
/
--[/RXPS-15284]

--[RXPS-16187]
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
  IF SP_COLUMN_EXISTS( 'itm_item_restriction','sale_lineitm_typecode') THEN
        dbms_output.put_line('     itm_item_restriction.sale_lineitm_typecode already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE itm_item_restriction ADD sale_lineitm_typecode VARCHAR2(30 char) DEFAULT ''ANY'' NOT NULL';
        EXECUTE IMMEDIATE 'ALTER TABLE itm_item_restriction ADD property_name VARCHAR2(30 char) DEFAULT ''DEFAULT'' NOT NULL';
        EXECUTE IMMEDIATE 'ALTER TABLE itm_item_restriction DROP PRIMARY KEY DROP INDEX';
        EXECUTE IMMEDIATE 'ALTER TABLE itm_item_restriction ADD CONSTRAINT pk_itm_item_restriction PRIMARY KEY (organization_id, restriction_category, restriction_code, effective_date, sale_lineitm_typecode, property_name) USING INDEX TABLESPACE $(DbTblspace)_index';

        dbms_output.put_line('     itm_item_restriction.sale_lineitm_typecode created');
        dbms_output.put_line('     itm_item_restriction.property_name created');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS( 'itm_item_restriction_p','sale_lineitm_typecode') THEN
        dbms_output.put_line('     itm_item_restriction_p.sale_lineitm_typecode already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE itm_item_restriction_p ADD sale_lineitm_typecode VARCHAR2(30 char) DEFAULT ''ANY'' NOT NULL';
        EXECUTE IMMEDIATE 'ALTER TABLE itm_item_restriction_p ADD property_name VARCHAR2(30 char) DEFAULT ''DEFAULT'' NOT NULL';
        EXECUTE IMMEDIATE 'ALTER TABLE itm_item_restriction_p DROP PRIMARY KEY DROP INDEX';
        EXECUTE IMMEDIATE 'ALTER TABLE itm_item_restriction_p ADD CONSTRAINT pk_itm_item_restriction_p PRIMARY KEY (organization_id, restriction_category, restriction_code, effective_date, sale_lineitm_typecode, property_name, property_code) USING INDEX TABLESPACE $(DbTblspace)_index';

        dbms_output.put_line('     itm_item_restriction_p.sale_lineitm_typecode created');
        dbms_output.put_line('     itm_item_restriction_p.property_name created');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS( 'itm_item_restrict_calendar','exemption_flag') THEN
        dbms_output.put_line('     itm_item_restrict_calendar.exemption_flag already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE itm_item_restrict_calendar ADD exemption_flag NUMBER(1, 0) DEFAULT 0';
        dbms_output.put_line('     itm_item_restrict_calendar.exemption_flag created');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS( 'itm_item_restrict_calendar','sale_lineitm_typecode') THEN
        dbms_output.put_line('     itm_item_restrict_calendar.sale_lineitm_typecode already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE itm_item_restrict_calendar ADD sale_lineitm_typecode VARCHAR2(30 char) DEFAULT ''ANY'' NOT NULL';
        EXECUTE IMMEDIATE 'ALTER TABLE itm_item_restrict_calendar DROP PRIMARY KEY DROP INDEX';
        EXECUTE IMMEDIATE 'ALTER TABLE itm_item_restrict_calendar ADD CONSTRAINT pk_itm_item_restriction_cal PRIMARY KEY (organization_id, restriction_category, restriction_code, effective_date, day_code, start_time, sale_lineitm_typecode) USING INDEX TABLESPACE $(DbTblspace)_index';
        dbms_output.put_line('     itm_item_restrict_calendar.sale_lineitm_typecode created');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS( 'itm_item_restrict_calendar_p','sale_lineitm_typecode') THEN
        dbms_output.put_line('     itm_item_restrict_calendar_p.sale_lineitm_typecode already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE itm_item_restrict_calendar_p ADD sale_lineitm_typecode VARCHAR2(30 char) DEFAULT ''ANY'' NOT NULL';
        EXECUTE IMMEDIATE 'ALTER TABLE itm_item_restrict_calendar_p DROP PRIMARY KEY DROP INDEX';
        EXECUTE IMMEDIATE 'ALTER TABLE itm_item_restrict_calendar_p ADD CONSTRAINT pk_itm_item_restriction_cal_p PRIMARY KEY (organization_id, restriction_category, restriction_code, effective_date, day_code, start_time, sale_lineitm_typecode, property_code) USING INDEX TABLESPACE $(DbTblspace)_index';
        dbms_output.put_line('     itm_item_restrict_calendar_p.sale_lineitm_typecode created');
  END IF;
END;
/

--
-- TABLE: itm_item_restrict_mapping
--
BEGIN
  IF SP_TABLE_EXISTS ('itm_item_restrict_mapping') THEN
       dbms_output.put_line('     itm_item_restrict_mapping already exists - updateing org_code and org_value');
       EXECUTE IMMEDIATE 'ALTER TABLE itm_item_restrict_mapping MODIFY org_code VARCHAR2(30 char) DEFAULT ''*''';
       EXECUTE IMMEDIATE 'ALTER TABLE itm_item_restrict_mapping MODIFY org_value VARCHAR2(60 char) DEFAULT ''*''';
  ELSE
        EXECUTE IMMEDIATE 'CREATE TABLE itm_item_restrict_mapping(
    organization_id         NUMBER(10, 0)         NOT NULL,
    merch_hierarchy_level   VARCHAR2(60 char)     NOT NULL,
    merch_hierarchy_id      VARCHAR2(60 char)     NOT NULL,
    restriction_category    VARCHAR2(30 char)     NOT NULL,
    org_code                VARCHAR2(30 char)     DEFAULT ''*'' NOT NULL,
    org_value               VARCHAR2(60 char)     DEFAULT ''*'' NOT NULL,
    create_date             TIMESTAMP(6),
    create_user_id          VARCHAR2(30 char),
    update_date             TIMESTAMP(6),
    update_user_id          VARCHAR2(30 char),
    record_state            VARCHAR2(30 char),
    CONSTRAINT pk_itm_item_restrict_map PRIMARY KEY (organization_id, merch_hierarchy_level, merch_hierarchy_id, restriction_category)
    USING INDEX
TABLESPACE $(DbTblspace)_INDEX
)
TABLESPACE $(DbTblspace)_DATA'
;
        dbms_output.put_line('     itm_item_restrict_mapping created');

        EXECUTE IMMEDIATE 'CREATE INDEX idx_itm_itm_restrctmap_orgnode ON itm_item_restrict_mapping(org_code, org_value)
TABLESPACE $(DbTblspace)_INDEX'
;

        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON itm_item_restrict_mapping TO posusers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON itm_item_restrict_mapping TO dbausers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
  END IF;
END;
/

BEGIN
  IF SP_TABLE_EXISTS ('itm_item_restrict_mapping_p') THEN
       dbms_output.put_line('     itm_item_restrict_mapping_p already exists');
  ELSE
        Create_Property_Table('itm_item_restrict_mapping');
        dbms_output.put_line('     itm_item_restrict_mapping_p created');
  END IF;
END;
/

BEGIN
  IF SP_TABLE_EXISTS ('com_button_grid_p') THEN
       dbms_output.put_line('     com_button_grid_p already exists');
  ELSE
        Create_Property_Table('com_button_grid');
        dbms_output.put_line('     com_button_grid_p created');
  END IF;
END;
/
--[/RXPS-16187]

--[RXPS-17100]
BEGIN
--
-- TABLE: com_airport
--
  IF SP_TABLE_EXISTS ('COM_AIRPORT') THEN
       dbms_output.put_line('     com_airport already exists');
  ELSE
        EXECUTE IMMEDIATE 'CREATE TABLE com_airport(
    organization_id         NUMBER(10, 0)       NOT NULL,
    airport_code            VARCHAR2(3 char)    NOT NULL,
    airport_name            VARCHAR2(254 char)  NOT NULL,
    country_code            VARCHAR2(2 char)    NOT NULL,
    zone_id                 VARCHAR2(30 char)   NOT NULL,
    create_date             TIMESTAMP(6),
    create_user_id          VARCHAR2(30 char),
    update_date             TIMESTAMP(6),
    update_user_id          VARCHAR2(30 char),
    record_state            VARCHAR2(30 char),
    CONSTRAINT pk_com_airport PRIMARY KEY (organization_id, airport_code)
    USING INDEX
TABLESPACE $(DbTblspace)_INDEX
)
TABLESPACE $(DbTblspace)_DATA'
;

        dbms_output.put_line('     com_airport created');

        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON COM_AIRPORT TO posusers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON COM_AIRPORT TO dbausers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
  END IF;

END;
/

BEGIN
  IF SP_TABLE_EXISTS ('com_airport_p') THEN
       dbms_output.put_line('     com_airport_p already exists');
  ELSE
       Create_Property_Table('com_airport');
       dbms_output.put_line('     com_airport_p created');
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
  IF SP_COLUMN_EXISTS('TRL_RTRANS_FLIGHT_INFO','FIRST_FLIGHT_NUMBER') THEN
        dbms_output.put_line('     TRL_RTRANS_FLIGHT_INFO.FIRST_FLIGHT_NUMBER already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE TRL_RTRANS_FLIGHT_INFO ADD FIRST_FLIGHT_NUMBER VARCHAR2(30 char)';
        dbms_output.put_line('     TRL_RTRANS_FLIGHT_INFO.FIRST_FLIGHT_NUMBER created');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS('TRL_RTRANS_FLIGHT_INFO','FIRST_DESTINATION_AIRPORT') THEN
        dbms_output.put_line('     TRL_RTRANS_FLIGHT_INFO.FIRST_DESTINATION_AIRPORT already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE TRL_RTRANS_FLIGHT_INFO ADD FIRST_DESTINATION_AIRPORT VARCHAR2(3 char)';
        dbms_output.put_line('     TRL_RTRANS_FLIGHT_INFO.FIRST_DESTINATION_AIRPORT created');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS('TRL_RTRANS_FLIGHT_INFO','FIRST_ORIGIN_AIRPORT') THEN
        dbms_output.put_line('     TRL_RTRANS_FLIGHT_INFO.FIRST_ORIGIN_AIRPORT already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE TRL_RTRANS_FLIGHT_INFO ADD FIRST_ORIGIN_AIRPORT VARCHAR2(3 char)';
        dbms_output.put_line('     TRL_RTRANS_FLIGHT_INFO.FIRST_ORIGIN_AIRPORT created');
  END IF;
END;
/

--New Columns to identify the user for resumen transactions operations
BEGIN
  IF SP_COLUMN_EXISTS('TRL_RTRANS_FLIGHT_INFO','FIRST_FLIGHT_SEAT_NUMBER') THEN
        dbms_output.put_line('     TRL_RTRANS_FLIGHT_INFO.FIRST_FLIGHT_SEAT_NUMBER already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE TRL_RTRANS_FLIGHT_INFO ADD FIRST_FLIGHT_SEAT_NUMBER VARCHAR2(4 char)';
        dbms_output.put_line('     TRL_RTRANS_FLIGHT_INFO.FIRST_FLIGHT_SEAT_NUMBER created');
  END IF;
END;
/

--New Columns to identify the user for resumen transactions operations
BEGIN
  IF SP_COLUMN_EXISTS('TRL_RTRANS_FLIGHT_INFO','FIRST_FLIGHT_SCHEDULED_DATE') THEN
        dbms_output.put_line('     TRL_RTRANS_FLIGHT_INFO.FIRST_FLIGHT_SCHEDULED_DATE already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE TRL_RTRANS_FLIGHT_INFO ADD FIRST_FLIGHT_SCHEDULED_DATE TIMESTAMP(6)';
        dbms_output.put_line('     TRL_RTRANS_FLIGHT_INFO.FIRST_FLIGHT_SCHEDULED_DATE created');
  END IF;
END;
/


--Drop com_airport_zone_mapping
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

--drop zone_id column from rtl_loc_id
BEGIN
  IF SP_COLUMN_EXISTS('LOC_RTL_LOC','ZONE_ID') THEN
        EXECUTE IMMEDIATE 'ALTER TABLE LOC_RTL_LOC DROP COLUMN ZONE_ID';
        dbms_output.put_line('     LOC_RTL_LOC.ZONE_ID dropped');
  END IF;
END;
/
--[/RXPS-17100]

--[/RXPS-17107]
--Add new columnd to identify departure airport
BEGIN
  IF SP_COLUMN_EXISTS('COM_FLIGHT_INFO','ORIGIN_AIRPORT') THEN
        dbms_output.put_line('     COM_FLIGHT_INFO.ORIGIN_AIRPORT already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE COM_FLIGHT_INFO ADD ORIGIN_AIRPORT VARCHAR2(3 char) DEFAULT '' '' NOT NULL';

        EXECUTE IMMEDIATE 'ALTER TABLE COM_FLIGHT_INFO DROP CONSTRAINT pk_com_flight_info';
        dbms_output.put_line('     COM_FLIGHT_INFO drop primary key');

        EXECUTE IMMEDIATE 'ALTER TABLE COM_FLIGHT_INFO ADD CONSTRAINT pk_com_flight_info PRIMARY KEY (organization_id, scheduled_date_time, origin_airport, flight_number)';
        dbms_output.put_line('     COM_FLIGHT_INFO recreate primary key');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS('COM_FLIGHT_INFO_P','ORIGIN_AIRPORT') THEN
        dbms_output.put_line('     COM_FLIGHT_INFO_P.ORIGIN_AIRPORT already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE COM_FLIGHT_INFO_P ADD ORIGIN_AIRPORT VARCHAR2(3 char) DEFAULT '' '' NOT NULL';

        EXECUTE IMMEDIATE 'ALTER TABLE COM_FLIGHT_INFO_P DROP CONSTRAINT pk_com_flight_info_p';
        dbms_output.put_line('     COM_FLIGHT_INFO_P drop primary key');

        EXECUTE IMMEDIATE 'ALTER TABLE COM_FLIGHT_INFO_P ADD CONSTRAINT pk_com_flight_info_p PRIMARY KEY (organization_id, scheduled_date_time, origin_airport, flight_number, property_code)';
        dbms_output.put_line('     COM_FLIGHT_INFO_P recreate primary key');
  END IF;
END;
/
--[/RXPS-17107]

--[RXPS-18272]
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

BEGIN
  IF SP_COLUMN_EXISTS( 'itm_item_options','tare_value') THEN
        dbms_output.put_line('     itm_item_options.tare_value already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE itm_item_options ADD tare_value NUMBER(11, 4) NULL';
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS( 'itm_item_options','tare_unit_of_measure_code') THEN
        dbms_output.put_line('     itm_item_options.tare_unit_of_measure_code already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE itm_item_options ADD tare_unit_of_measure_code VARCHAR2(30 char) NULL';
  END IF;
END;
/
--[/RXPS-18272]

--[RXPS-16911]
BEGIN
  IF SP_COLUMN_EXISTS( 'itm_kit_component','seq_nbr') THEN
        dbms_output.put_line('     itm_kit_component.seq_nbr already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE itm_kit_component ADD seq_nbr NUMBER(10,0) DEFAULT 1 NOT NULL';
        dbms_output.put_line('     itm_kit_component.seq_nbr created');

		EXECUTE IMMEDIATE 'ALTER TABLE itm_kit_component DROP CONSTRAINT pk_itm_kit_component';
        dbms_output.put_line('     itm_kit_component drop primary key');

        EXECUTE IMMEDIATE 'ALTER TABLE itm_kit_component ADD CONSTRAINT pk_itm_kit_component PRIMARY KEY (organization_id, kit_item_id, component_item_id, seq_nbr)';
        dbms_output.put_line('     itm_kit_component recreate primary key');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS( 'itm_kit_component_p','seq_nbr') THEN
        dbms_output.put_line('     itm_kit_component_p.seq_nbr already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE itm_kit_component_p ADD seq_nbr NUMBER(10,0) DEFAULT 1 NOT NULL';
        dbms_output.put_line('     itm_kit_component_p.seq_nbr created');

        EXECUTE IMMEDIATE 'ALTER TABLE itm_kit_component_p DROP CONSTRAINT pk_itm_kit_component_p';
        dbms_output.put_line('     itm_kit_component_p drop primary key');

        EXECUTE IMMEDIATE 'ALTER TABLE itm_kit_component_p ADD CONSTRAINT pk_itm_kit_component_p PRIMARY KEY (organization_id, kit_item_id, component_item_id, seq_nbr, property_code)';
        dbms_output.put_line('     itm_kit_component_p recreate primary key');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS( 'trl_kit_component_mod','seq_nbr') THEN
        dbms_output.put_line('     trl_kit_component_mod.seq_nbr already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE trl_kit_component_mod ADD seq_nbr NUMBER(10,0) DEFAULT 1 NOT NULL';
        dbms_output.put_line('     trl_kit_component_mod.seq_nbr created');

        EXECUTE IMMEDIATE 'ALTER TABLE trl_kit_component_mod DROP CONSTRAINT pk_trl_kit_component_mod';
        dbms_output.put_line('     trl_kit_component_mod drop primary key');

        EXECUTE IMMEDIATE 'ALTER TABLE trl_kit_component_mod ADD CONSTRAINT pk_trl_kit_component_mod PRIMARY KEY (organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq, component_item_id, seq_nbr)';
        dbms_output.put_line('     trl_kit_component_mod recreate primary key');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS( 'trl_kit_component_mod_p','seq_nbr') THEN
        dbms_output.put_line('     trl_kit_component_mod_p.seq_nbr already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE trl_kit_component_mod_p ADD seq_nbr NUMBER(10,0) DEFAULT 1 NOT NULL';
        dbms_output.put_line('     trl_kit_component_mod_p.seq_nbr created');

		EXECUTE IMMEDIATE 'ALTER TABLE trl_kit_component_mod_p DROP CONSTRAINT pk_trl_kit_component_mod_p';
        dbms_output.put_line('     trl_kit_component_mod_p drop primary key');

        EXECUTE IMMEDIATE 'ALTER TABLE trl_kit_component_mod_p ADD CONSTRAINT pk_trl_kit_component_mod_p PRIMARY KEY (organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq, component_item_id, seq_nbr, property_code)';
        dbms_output.put_line('     trl_kit_component_mod_p recreate primary key');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS( 'trl_kit_component_mod','serial_nbr') THEN
        dbms_output.put_line('     trl_kit_component_mod.serial_nbr already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE trl_kit_component_mod ADD serial_nbr VARCHAR2(60 char)';
        dbms_output.put_line('     trl_kit_component_mod.serial_nbr created');
  END IF;
END;
/
--[/RXPS-16911]

--[RXPS-18536]
--
-- TABLE: PAF_CARD_NETWORK
--
BEGIN
  IF SP_TABLE_EXISTS ('CPAF_CARD_NETWORK') THEN
       dbms_output.put_line('      CPAF_CARD_NETWORK already exists');
  ELSE
        EXECUTE IMMEDIATE 'CREATE TABLE CPAF_CARD_NETWORK(
    ORGANIZATION_ID    NUMBER(10, 0)      NOT NULL,
    NETWORK_NAME       VARCHAR2(254 CHAR) NOT NULL,
    NETWORK_ID         VARCHAR2(30 CHAR),
    TAX_ID             VARCHAR2(30 CHAR),
    CONSTRAINT PK_CPAF_CARD_NETWORK PRIMARY KEY (ORGANIZATION_ID, NETWORK_NAME)
    USING INDEX
TABLESPACE $(DbTblspace)_INDEX
)
TABLESPACE $(DbTblspace)_DATA'
;
        dbms_output.put_line('      CPAF_CARD_NETWORK created');

        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_CARD_NETWORK TO posusers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_CARD_NETWORK TO dbausers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_CARD_NETWORK','NETWORK_ID') THEN
        dbms_output.put_line('     CPAF_CARD_NETWORK.NETWORK_ID already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_CARD_NETWORK ADD NETWORK_ID VARCHAR2(30 CHAR)';
        dbms_output.put_line('     CPAF_CARD_NETWORK.NETWORK_ID created');
  END IF;
END;
/
BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_CARD_NETWORK','TAX_ID') THEN
        dbms_output.put_line('     CPAF_CARD_NETWORK.TAX_ID already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_CARD_NETWORK ADD TAX_ID VARCHAR2(30 CHAR)';
        dbms_output.put_line('     CPAF_CARD_NETWORK.TAX_ID created');
  END IF;
END;
/


BEGIN
  IF SP_TABLE_EXISTS ('CPAF_CARD_NETWORK_P') THEN
       dbms_output.put_line('     CPAF_CARD_NETWORK_P already exists');
  ELSE
        Create_Property_Table('CPAF_CARD_NETWORK');
        dbms_output.put_line('     CPAF_CARD_NETWORK_P created');
  END IF;
END;
/

--[/RXPS-18536]

--[RXPS-17100]
--Standarizing field sizes
DECLARE
  v_count       int;
BEGIN
  SELECT char_length INTO v_count FROM dba_tab_columns WHERE table_name = UPPER('com_flight_info') AND column_name=UPPER('destination_airport') AND OWNER=UPPER('$(DbSchema)');

  IF v_count>3 THEN
    SELECT DECODE(COUNT(*),0,0,1) INTO v_count FROM com_flight_info WHERE length(destination_airport)> 3;
    IF v_count=0 THEN
      EXECUTE IMMEDIATE 'ALTER TABLE com_flight_info MODIFY destination_airport VARCHAR2(3 char)';
      dbms_output.put_line('     com_flight_info.destination_airport column size reduced');
    ELSE
      dbms_output.put_line('     com_flight_info.destination_airport value to large to reduce size');
    END IF;
  END IF;
END;
/

DECLARE
  v_count       int;
BEGIN
  SELECT char_length INTO v_count FROM dba_tab_columns WHERE table_name = UPPER('com_flight_info') AND column_name=UPPER('via_1_airport') AND OWNER=UPPER('$(DbSchema)');

  IF v_count>3 THEN
    SELECT DECODE(COUNT(*),0,0,1) INTO v_count FROM com_flight_info WHERE length(via_1_airport)> 3;
    IF v_count=0 THEN
      EXECUTE IMMEDIATE 'ALTER TABLE com_flight_info MODIFY via_1_airport VARCHAR2(3 char)';
      dbms_output.put_line('     com_flight_info.via_1_airport column size reduced');
    ELSE
      dbms_output.put_line('     com_flight_info.via_1_airport value to large to reduce size');
    END IF;
  END IF;
END;
/

DECLARE
  v_count       int;
BEGIN
  SELECT char_length INTO v_count FROM dba_tab_columns WHERE table_name = UPPER('com_flight_info') AND column_name=UPPER('via_2_airport') AND OWNER=UPPER('$(DbSchema)');

  IF v_count>3 THEN
    SELECT DECODE(COUNT(*),0,0,1) INTO v_count FROM com_flight_info WHERE length(via_2_airport)> 3;
    IF v_count=0 THEN
      EXECUTE IMMEDIATE 'ALTER TABLE com_flight_info MODIFY via_2_airport VARCHAR2(3 char)';
      dbms_output.put_line('     com_flight_info.via_2_airport column size reduced');
    ELSE
      dbms_output.put_line('     com_flight_info.via_2_airport value to large to reduce size');
    END IF;
  END IF;
END;
/

DECLARE
  v_count       int;
BEGIN
  SELECT char_length INTO v_count FROM dba_tab_columns WHERE table_name = UPPER('com_flight_info') AND column_name=UPPER('via_3_airport') AND OWNER=UPPER('$(DbSchema)');

  IF v_count>3 THEN
    SELECT DECODE(COUNT(*),0,0,1) INTO v_count FROM com_flight_info WHERE length(via_3_airport)> 3;
    IF v_count=0 THEN
      EXECUTE IMMEDIATE 'ALTER TABLE com_flight_info MODIFY via_3_airport VARCHAR2(3 char)';
      dbms_output.put_line('     com_flight_info.via_3_airport column size reduced');
    ELSE
      dbms_output.put_line('     com_flight_info.via_3_airport value to large to reduce size');
    END IF;
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

DECLARE
  v_count       int;
BEGIN
  SELECT char_length INTO v_count FROM dba_tab_columns WHERE table_name = UPPER('trl_rtrans_flight_info') AND column_name=UPPER('destination_airport') AND OWNER=UPPER('$(DbSchema)');

  IF v_count>3 THEN
    SELECT DECODE(COUNT(*),0,0,1) INTO v_count FROM trl_rtrans_flight_info WHERE length(destination_airport)> 3;
    IF v_count=0 THEN
      EXECUTE IMMEDIATE 'ALTER TABLE trl_rtrans_flight_info MODIFY destination_airport VARCHAR2(3 char)';
      dbms_output.put_line('     trl_rtrans_flight_info.destination_airport column size reduced');
    ELSE
      dbms_output.put_line('     trl_rtrans_flight_info.destination_airport value to large to reduce size');
    END IF;
  END IF;
END;
/

DECLARE
  v_count       int;
BEGIN
  SELECT char_length INTO v_count FROM dba_tab_columns WHERE table_name = UPPER('trl_rtrans_flight_info') AND column_name=UPPER('origin_airport') AND OWNER=UPPER('$(DbSchema)');

  IF v_count>3 THEN
    SELECT DECODE(COUNT(*),0,0,1) INTO v_count FROM trl_rtrans_flight_info WHERE length(origin_airport)> 3;
    IF v_count=0 THEN
      EXECUTE IMMEDIATE 'ALTER TABLE trl_rtrans_flight_info MODIFY origin_airport VARCHAR2(3 char)';
      dbms_output.put_line('     trl_rtrans_flight_info.origin_airport column size reduced');
    ELSE
      dbms_output.put_line('     trl_rtrans_flight_info.origin_airport value to large to reduce size');
    END IF;
  END IF;
END;
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
  IF SP_COLUMN_EXISTS('loc_rtl_loc','airport_code') THEN
        dbms_output.put_line('     loc_rtl_loc.airport_code already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE loc_rtl_loc ADD airport_code VARCHAR2(3 char)';
        dbms_output.put_line('     loc_rtl_loc.airport_code created');
  END IF;
END;
/
--[/RXPS-17100]

--[RXPS-15284] - Tax Free integration
--
-- TABLE: civc_taxfree_country
--
BEGIN
  IF SP_TABLE_EXISTS ('civc_taxfree_country') THEN
       DBMS_OUTPUT.PUT_LINE('     civc_taxfree_country already exists');
  ELSE
       EXECUTE IMMEDIATE 'CREATE TABLE CIVC_TAXFREE_COUNTRY(
    ORGANIZATION_ID    NUMBER(10, 0)    NOT NULL,
    RTL_LOC_ID         NUMBER(10, 0)    NOT NULL,
    WKSTN_ID           NUMBER(19, 0)    NOT NULL,
    ISO3NUM_CODE       VARCHAR2(3 CHAR) NOT NULL,
    ISO2ALP_CODE       VARCHAR2(2 CHAR),
    NAME               VARCHAR2(150 CHAR),
    PHONE_PREFIX       VARCHAR2(4 CHAR),
    PASSPORT_CODE      VARCHAR2(10 CHAR),
    VOID_FLAG          NUMBER(1, 0) DEFAULT 0,
    BLOCKED_FLAG       NUMBER(1, 0) DEFAULT 0,
    CREATE_DATE        TIMESTAMP(6),
    CREATE_USER_ID     VARCHAR2(30 CHAR),
    UPDATE_DATE        TIMESTAMP(6),
    UPDATE_USER_ID     VARCHAR2(30 CHAR),
    RECORD_STATE       VARCHAR2(30 CHAR),
    CONSTRAINT pk_civc_taxfree_country PRIMARY KEY (ORGANIZATION_ID, RTL_LOC_ID, WKSTN_ID, ISO3NUM_CODE)
    USING INDEX
  TABLESPACE $(DbTblspace)_INDEX
  )
  TABLESPACE $(DbTblspace)_DATA'
;

    DBMS_OUTPUT.PUT_LINE('     civc_taxfree_country created');

    EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON civc_taxfree_country TO posusers';
    DBMS_OUTPUT.PUT_LINE('      Grant completed.');
    EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON civc_taxfree_country TO dbausers';
    DBMS_OUTPUT.PUT_LINE('      Grant completed.');
  END IF;
END;
/

--
-- TABLE: civc_taxfree_country_p
--
BEGIN
  IF SP_TABLE_EXISTS ('civc_taxfree_country_p') THEN
       dbms_output.put_line('     civc_taxfree_country_p already exists');
  ELSE
        Create_Property_Table('civc_taxfree_country');
        dbms_output.put_line('     civc_taxfree_country_p created');
  END IF;
END;
/

--
-- TABLE: civc_taxfree_card_range
--
BEGIN
  IF SP_TABLE_EXISTS ('civc_taxfree_card_range') THEN
       DBMS_OUTPUT.PUT_LINE('     civc_taxfree_card_range already exists');
  ELSE
       EXECUTE IMMEDIATE 'CREATE TABLE CIVC_TAXFREE_CARD_RANGE(
    ORGANIZATION_ID    NUMBER(10, 0)    NOT NULL,
    RTL_LOC_ID         NUMBER(10, 0)    NOT NULL,
    WKSTN_ID           NUMBER(19, 0)    NOT NULL,
    RANGE_START        VARCHAR2(8 CHAR) NOT NULL,
    RANGE_END          VARCHAR2(8 CHAR),
    CREATE_DATE        TIMESTAMP(6),
    CREATE_USER_ID     VARCHAR2(30 CHAR),
    UPDATE_DATE        TIMESTAMP(6),
    UPDATE_USER_ID     VARCHAR2(30 CHAR),
    RECORD_STATE       VARCHAR2(30 CHAR),
    CONSTRAINT pk_civc_taxfree_card_range PRIMARY KEY (ORGANIZATION_ID, RTL_LOC_ID, WKSTN_ID, RANGE_START)
    USING INDEX
  TABLESPACE $(DbTblspace)_INDEX
  )
  TABLESPACE $(DbTblspace)_DATA'
;
    DBMS_OUTPUT.PUT_LINE('     civc_taxfree_card_range created');

    EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON civc_taxfree_card_range TO posusers';
    DBMS_OUTPUT.PUT_LINE('      Grant completed.');
    EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON civc_taxfree_card_range TO dbausers';
    DBMS_OUTPUT.PUT_LINE('      Grant completed.');
  END IF;
END;
/

--
-- TABLE: civc_taxfree_card_range_p
--
BEGIN
  IF SP_TABLE_EXISTS ('civc_taxfree_card_range_p') THEN
       dbms_output.put_line('     civc_taxfree_card_range_p already exists');
  ELSE
        Create_Property_Table('civc_taxfree_card_range');
        dbms_output.put_line('     civc_taxfree_card_range_p created');
  END IF;
END;
/

-- Update civc_invoice
BEGIN
  IF SP_COLUMN_EXISTS( 'civc_invoice','invoice_date') THEN
        dbms_output.put_line('     civc_invoice.invoice_date already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE civc_invoice ADD invoice_date TIMESTAMP(6)';
        dbms_output.put_line('     civc_invoice.invoice_date created');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS( 'civc_invoice','ext_invoice_barcode') THEN
        dbms_output.put_line('     civc_invoice.ext_invoice_barcode already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE civc_invoice ADD ext_invoice_barcode VARCHAR2(60 CHAR)';
        dbms_output.put_line('     civc_invoice.ext_invoice_barcode created');
  END IF;
END;
/
--[/RXPS-15284]

--[RXPS-19733]
BEGIN 
  IF SP_TABLE_EXISTS ('ctl_ip_cashdrawer_device') THEN
       DBMS_OUTPUT.PUT_LINE('     ctl_ip_cashdrawer_device already exists');
  ELSE
       EXECUTE IMMEDIATE 'CREATE TABLE ctl_ip_cashdrawer_device(
    organization_id     NUMBER(10, 0)      NOT NULL,
    rtl_loc_id          NUMBER(10, 0)      NOT NULL,
    cash_drawer_id      VARCHAR2(60 CHAR)  NOT NULL,
    drawer_status       VARCHAR2(40 CHAR),
    product_name        VARCHAR2(80 CHAR),
    description         VARCHAR2(80 CHAR),
    serial_number       VARCHAR2(40 CHAR),
    ip_address          VARCHAR2(16 CHAR),
    tcp_port            NUMBER(10, 0),
    mac_address         VARCHAR2(20 CHAR),
    subnet_mask         VARCHAR2(16 CHAR),
    gateway             VARCHAR2(16 CHAR),
    dns_hostname        VARCHAR2(16 CHAR),
    dhcp_flag           NUMBER(1, 0)         DEFAULT 0,
    firmware_version    VARCHAR2(20 CHAR),
    kup                 VARCHAR2(1024 CHAR),
    kup_update_date     TIMESTAMP(6),
    beep_on_open_flag   NUMBER(1, 0)         DEFAULT 0,
    beep_long_open_flag NUMBER(1, 0)         DEFAULT 0,
    create_date        TIMESTAMP(6),
    create_user_id     VARCHAR2(30 CHAR),
    update_date        TIMESTAMP(6),
    update_user_id     VARCHAR2(30 CHAR),
    record_state       VARCHAR2(30 CHAR),
    CONSTRAINT pk_ctl_ip_cashdrawer_device PRIMARY KEY (organization_id, rtl_loc_id, cash_drawer_id)
    USING INDEX
  TABLESPACE $(DbTblspace)_INDEX
  )
  TABLESPACE $(DbTblspace)_DATA'
;
    DBMS_OUTPUT.PUT_LINE('     ctl_ip_cashdrawer_device created');

    EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON ctl_ip_cashdrawer_device TO posusers';
    DBMS_OUTPUT.PUT_LINE('      Grant completed.');
    EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON ctl_ip_cashdrawer_device TO dbausers';
    DBMS_OUTPUT.PUT_LINE('      Grant completed.');
  END IF;
END;
/

BEGIN 
  IF SP_TABLE_EXISTS ('ctl_ip_cashdrawer_device_p') THEN
       dbms_output.put_line('     ctl_ip_cashdrawer_device_p already exists');
  ELSE
        Create_Property_Table('ctl_ip_cashdrawer_device');
        dbms_output.put_line('    ctl_ip_cashdrawer_device_p created');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS( 'tsn_session','cash_drawer_id') THEN
        dbms_output.put_line('     tsn_session.cash_drawer_id already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE tsn_session ADD cash_drawer_id VARCHAR2(60 CHAR)';
        dbms_output.put_line('     tsn_session.cash_drawer_id created');
  END IF;
END;
/
--[/RXPS-19733]

--[/RXPS-21041]
BEGIN
  IF SP_COLUMN_EXISTS( 'trl_sale_tax_lineitm','tax_override_comment') THEN
        dbms_output.put_line('     trl_sale_tax_lineitm.tax_override_comment already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE trl_sale_tax_lineitm ADD tax_override_comment VARCHAR2(255 CHAR)';
        dbms_output.put_line('     trl_sale_tax_lineitm.tax_override_comment created');
  END IF;
END;
/
--[/RXPS-21041]

--[RXPS-17705]
BEGIN
  IF SP_COLUMN_EXISTS( 'trn_trans','trans_date') THEN
        dbms_output.put_line('     trn_trans.trans_date already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE trn_trans ADD trans_date TIMESTAMP(6) NULL';
        EXECUTE IMMEDIATE 'CREATE INDEX idx_trn_trans05 ON trn_trans(trans_date) TABLESPACE $(DbTblspace)_index';
  END IF;
  EXECUTE IMMEDIATE 'UPDATE trn_trans SET trans_date = TRUNC(begin_datetime,''DD'') WHERE trans_date IS NULL';
END;
/

BEGIN
  IF SP_COLUMN_EXISTS( 'rpt_sale_line','trans_date') THEN
        dbms_output.put_line('     rpt_sale_line.trans_date already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE rpt_sale_line ADD trans_date TIMESTAMP(6) NULL';
        EXECUTE IMMEDIATE 'CREATE INDEX idx_rpt_sale_line04 ON rpt_sale_line(trans_date) TABLESPACE $(DbTblspace)_index';
  END IF;
  EXECUTE IMMEDIATE 'UPDATE rpt_sale_line SET trans_date = TRUNC(trans_timestamp,''DD'') WHERE trans_date IS NULL';
END;
/
--[/RXPS-17705]

CREATE OR REPLACE PROCEDURE sp_flash 
  (argOrganizationId    IN NUMBER, 
   argRetailLocationId  IN NUMBER, 
   argBusinessDate      IN DATE, 
   argWrkstnId          IN NUMBER, 
   argTransSeq          IN NUMBER) 
AUTHID CURRENT_USER 
IS

myerror exception;
myreturn exception;

-- Arguments
pvOrganizationId        NUMBER(10);
pvRetailLocationId      NUMBER(10); 
pvBusinessDate          DATE;
pvWrkstnId              NUMBER(20,0);
pvTransSeq              NUMBER(20,0);

-- Quantities
vActualQuantity         NUMBER (11,2);
vGrossQuantity          NUMBER (11,2);
vQuantity               NUMBER (11,2);
vTotQuantity            NUMBER (11,2);

-- Amounts
vNetAmount              NUMBER (17,6);
vGrossAmount            NUMBER (17,6);
vTotGrossAmt            NUMBER (17,6);
vTotNetAmt              NUMBER (17,6);
vDiscountAmt            NUMBER (17,6);
vOverrideAmt            NUMBER (17,6);
vPaidAmt                NUMBER (17,6);
vTenderAmt              NUMBER (17,6);
vForeign_amt            NUMBER (17,6);
vLayawayPrice           NUMBER(17,6);
vUnitPrice              NUMBER (17,6);
vAccountCredit      NUMBER (17,6);

-- Non Physical Items
vNonPhys                VARCHAR2(30 char);
vNonPhysSaleType        VARCHAR2(30 char);
vNonPhysType            VARCHAR2(30 char);
vNonPhysPrice           NUMBER (17,6);
vNonPhysQuantity        NUMBER (11,2);

-- Status codes
vTransStatcode          VARCHAR2(30 char);
vTransTypcode           VARCHAR2(30 char);
vSaleLineItmTypcode     VARCHAR2(30 char);
vTndrStatcode           VARCHAR2(60 char);
vLineitemStatcode       VARCHAR2(30 char);

-- others
vTransTimeStamp         TIMESTAMP;
vTransDate              TIMESTAMP;
vTransCount             NUMBER(10);
vTndrCount              NUMBER(10);
vPostVoidFlag           NUMBER(1);
vReturnFlag             NUMBER(1);
vTaxTotal               NUMBER (17,6);
vPaid                   VARCHAR2(30 char);
vLineEnum               VARCHAR2(150 char);
vTndrId                 VARCHAR2(60 char);
vItemId                 VARCHAR2(60 char);
vRtransLineItmSeq       NUMBER(10);
vDepartmentId           VARCHAR2(90 char);
vTndridProp       varchar2(60 char);
vCurrencyId             VARCHAR2(3 char);

vSerialNbr              VARCHAR2(60 char);
vPriceModAmt            NUMBER(17,6);
vPriceModReascode       VARCHAR2(60 char);
vNonPhysExcludeFlag     NUMBER(1);
vCustPartyId            VARCHAR2(60 char);
vCustLastName           VARCHAR2(90 char);
vCustFirstName          VARCHAR2(90 char);
vItemDesc               VARCHAR2(254 char);
vBeginTimeInt           NUMBER(10);

-- counts
vRowCnt                 NUMBER(10);
vCntTrans               NUMBER(10);
vCntTndrCtl             NUMBER(10);
vCntPostVoid            NUMBER(10);
vCntRevTrans            NUMBER(10);
vCntNonPhysItm          NUMBER(10);
vCntNonPhys             NUMBER(10);
vCntCust                NUMBER(10);
vCntItem                NUMBER(10);
vCntParty               NUMBER(10);

-- cursors

CURSOR tenderCursor IS 
    SELECT t.amt, t.foreign_amt, t.tndr_id, t.tndr_statcode, tr.string_value 
        FROM TTR_TNDR_LINEITM t 
        inner join TRL_RTRANS_LINEITM r ON t.organization_id=r.organization_id
                                       AND t.rtl_loc_id=r.rtl_loc_id
                                       AND t.wkstn_id=r.wkstn_id
                                       AND t.trans_seq=r.trans_seq
                                       AND t.business_date=r.business_date
                                       AND t.rtrans_lineitm_seq=r.rtrans_lineitm_seq
    left outer join trl_rtrans_lineitm_p tr on tr.organization_id=r.organization_id
                    and tr.rtl_loc_id=r.rtl_loc_id
                    and tr.wkstn_id=r.wkstn_id
                    and tr.trans_seq=r.trans_seq
                    and tr.business_date=r.business_date
                    and tr.rtrans_lineitm_seq=r.rtrans_lineitm_seq
                    and lower(property_code) = 'tender_id'
        WHERE t.organization_id = pvOrganizationId
          AND t.rtl_loc_id = pvRetailLocationId
          AND t.wkstn_id = pvWrkstnId
          AND t.trans_seq = pvTransSeq
          AND t.business_date = pvBusinessDate
          AND r.void_flag = 0
      AND t.tndr_id <> 'ACCOUNT_CREDIT';

CURSOR postVoidTenderCursor IS 
    SELECT t.amt, t.foreign_amt, t.tndr_id, t.tndr_statcode, tr.string_value 
        FROM TTR_TNDR_LINEITM t 
        inner join TRL_RTRANS_LINEITM r ON t.organization_id=r.organization_id
                                       AND t.rtl_loc_id=r.rtl_loc_id
                                       AND t.wkstn_id=r.wkstn_id
                                       AND t.trans_seq=r.trans_seq
                                       AND t.business_date=r.business_date
                                       AND t.rtrans_lineitm_seq=r.rtrans_lineitm_seq
    left outer join trl_rtrans_lineitm_p tr on tr.organization_id=r.organization_id
                    and tr.rtl_loc_id=r.rtl_loc_id
                    and tr.wkstn_id=r.wkstn_id
                    and tr.trans_seq=r.trans_seq
                    and tr.business_date=r.business_date
                    and tr.rtrans_lineitm_seq=r.rtrans_lineitm_seq
                    and lower(property_code) = 'tender_id'
        WHERE t.organization_id = pvOrganizationId
          AND t.rtl_loc_id = pvRetailLocationId
          AND t.wkstn_id = pvWrkstnId
          AND t.trans_seq = pvTransSeq
          AND t.business_date = pvBusinessDate
          AND r.void_flag = 0
      AND t.tndr_id <> 'ACCOUNT_CREDIT';

CURSOR saleCursor IS
       select rsl.item_id,
       sale_lineitm_typcode,
       actual_quantity,
       unit_price,
       case vPostVoidFlag when 1 then -1 else 1 end * coalesce(gross_amt,0),
       case when return_flag=vPostVoidFlag then 1 else -1 end * coalesce(gross_quantity,0),
       merch_level_1,
       case vPostVoidFlag when 1 then -1 else 1 end * coalesce(net_amt,0),
       case when return_flag=vPostVoidFlag then 1 else -1 end * coalesce(quantity,0),
     return_flag 
       from rpt_sale_line rsl
     left join itm_non_phys_item inp on rsl.item_id=inp.item_id and rsl.organization_id=inp.organization_id
       WHERE rsl.organization_id = pvOrganizationId
          AND rtl_loc_id = pvRetailLocationId
          AND wkstn_id = pvWrkstnId
          AND business_date = pvBusinessDate
          AND trans_seq = pvTransSeq
      and QUANTITY <> 0
      and sale_lineitm_typcode <> 'ONHOLD'
      and coalesce(exclude_from_net_sales_flag,0)=0;

-- Declarations end 

BEGIN
    -- initializations of args
    pvOrganizationId      := argOrganizationId;
    pvRetailLocationId    := argRetailLocationId;
    pvWrkstnId            := argWrkstnId;
    pvBusinessDate        := argBusinessDate;
    pvTransSeq            := argTransSeq;

    BEGIN
    SELECT tt.trans_statcode,
           tt.trans_typcode, 
           tt.begin_datetime, 
           tt.trans_date,
           tt.taxtotal, 
           tt.post_void_flag, 
           tt.begin_time_int,
           coalesce(t.currency_id, rl.currency_id)
        INTO vTransStatcode, 
             vTransTypcode, 
             vTransTimeStamp, 
             vTransDate,
             vTaxTotal, 
             vPostVoidFlag, 
             vBeginTimeInt,
             vCurrencyID
        FROM TRN_TRANS tt  
            LEFT JOIN loc_rtl_loc rl on tt.organization_id = rl.organization_id and tt.rtl_loc_id = rl.rtl_loc_id
      LEFT JOIN (select max(currency_id) currency_id,ttl.organization_id,ttl.rtl_loc_id,ttl.wkstn_id,ttl.business_date,ttl.trans_seq
      from ttr_tndr_lineitm ttl
      inner join tnd_tndr tnd on ttl.organization_id=tnd.organization_id and ttl.tndr_id=tnd.tndr_id
      group by ttl.organization_id,ttl.rtl_loc_id,ttl.wkstn_id,ttl.business_date,ttl.trans_seq) t ON
      tt.organization_id = t.organization_id
          AND tt.rtl_loc_id = t.rtl_loc_id
          AND tt.wkstn_id = t.wkstn_id
          AND tt.business_date = t.business_date
          AND tt.trans_seq = t.trans_seq
        WHERE tt.organization_id = pvOrganizationId
          AND tt.rtl_loc_id = pvRetailLocationId
          AND tt.wkstn_id = pvWrkstnId
          AND tt.business_date = pvBusinessDate
          AND tt.trans_seq = pvTransSeq;
    EXCEPTION
        WHEN no_data_found THEN
        NULL;
    END;
    
    vCntTrans := SQL%ROWCOUNT;
    
    IF vCntTrans = 1 THEN 
    
    -- so update the column on trn trans
        UPDATE TRN_TRANS SET flash_sales_flag = 1
            WHERE organization_id = pvOrganizationId
            AND rtl_loc_id = pvRetailLocationId
            AND wkstn_id = pvWrkstnId
            AND trans_seq = pvTransSeq
            AND business_date = pvBusinessDate;
    ELSE
        -- /* Invalid transaction */
        raise myerror;
        
    END IF;

    vTransCount := 1; -- /* initializing the transaction count */

  select count(*) into vCntTrans from rpt_sale_line
    WHERE organization_id = pvOrganizationId
    AND rtl_loc_id = pvRetailLocationId
    AND wkstn_id = pvWrkstnId
    AND trans_seq = pvTransSeq
    AND business_date = pvBusinessDate;

  IF vCntTrans = 0 AND vPostVoidFlag = 1 THEN
    insert into rpt_sale_line
    (organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq,
    quantity, actual_quantity, gross_quantity, unit_price, net_amt, gross_amt, item_id, 
    item_desc, merch_level_1, serial_nbr, return_flag, override_amt, trans_timestamp, trans_date,
    discount_amt, cust_party_id, last_name, first_name, trans_statcode, sale_lineitm_typcode, begin_time_int, exclude_from_net_sales_flag)
    select tsl.organization_id, tsl.rtl_loc_id, tsl.business_date, tsl.wkstn_id, tsl.trans_seq, tsl.rtrans_lineitm_seq,
    tsl.net_quantity, tsl.quantity, tsl.gross_quantity, tsl.unit_price, tsl.net_amt, tsl.gross_amt,    tsl.item_id,
    i.DESCRIPTION, coalesce(tsl.merch_level_1,i.MERCH_LEVEL_1,'DEFAULT'), tsl.serial_nbr, tsl.return_flag, coalesce(o.override_amt,0), vTransTimeStamp, vTransDate,
    coalesce(d.discount_amt,0), tr.cust_party_id, cust.last_name, cust.first_name, 'VOID', tsl.sale_lineitm_typcode, vBeginTimeInt, tsl.exclude_from_net_sales_flag
    from trl_sale_lineitm tsl
    inner join trl_rtrans_lineitm r
    on tsl.organization_id=r.organization_id
    and tsl.rtl_loc_id=r.rtl_loc_id
    and tsl.wkstn_id=r.wkstn_id
    and tsl.trans_seq=r.trans_seq
    and tsl.business_date=r.business_date
    and tsl.rtrans_lineitm_seq=r.rtrans_lineitm_seq
    and r.rtrans_lineitm_typcode = 'ITEM'
    left join xom_order_mod xom
    on tsl.organization_id=xom.organization_id
    and tsl.rtl_loc_id=xom.rtl_loc_id
    and tsl.wkstn_id=xom.wkstn_id
    and tsl.trans_seq=xom.trans_seq
    and tsl.business_date=xom.business_date
    and tsl.rtrans_lineitm_seq=xom.rtrans_lineitm_seq
    left join xom_order_line xol
    on xom.organization_id=xol.organization_id
    and xom.order_id=xol.order_id
    and xom.detail_seq=xol.detail_seq
    left join itm_item i
    on tsl.organization_id=i.ORGANIZATION_ID
    and tsl.item_id=i.ITEM_ID
    left join (select extended_amt override_amt,organization_id,rtl_loc_id,business_date,wkstn_id,trans_seq,rtrans_lineitm_seq
      FROM trl_rtl_price_mod
      WHERE void_flag = 0 and rtl_price_mod_reascode='PRICE_OVERRIDE') o
    on tsl.organization_id = o.organization_id 
      AND tsl.rtl_loc_id = o.rtl_loc_id
      AND tsl.business_date = o.business_date 
      AND tsl.wkstn_id = o.wkstn_id 
      AND tsl.trans_seq = o.trans_seq
      AND tsl.rtrans_lineitm_seq = o.rtrans_lineitm_seq
    left join (select sum(extended_amt) discount_amt,organization_id,rtl_loc_id,business_date,wkstn_id,trans_seq,rtrans_lineitm_seq
      FROM trl_rtl_price_mod
      WHERE void_flag = 0 and rtl_price_mod_reascode in ('LINE_ITEM_DISCOUNT', 'TRANSACTION_DISCOUNT', 'GROUP_DISCOUNT', 'NEW_PRICE_RULE', 'DEAL')
      group by organization_id,rtl_loc_id,business_date,wkstn_id,trans_seq,rtrans_lineitm_seq) d
    on tsl.organization_id = d.organization_id 
      AND tsl.rtl_loc_id = d.rtl_loc_id
      AND tsl.business_date = d.business_date 
      AND tsl.wkstn_id = d.wkstn_id 
      AND tsl.trans_seq = d.trans_seq
      AND tsl.rtrans_lineitm_seq = d.rtrans_lineitm_seq
    left join trl_rtrans tr
    on tsl.organization_id = tr.organization_id 
      AND tsl.rtl_loc_id = tr.rtl_loc_id
      AND tsl.business_date = tr.business_date 
      AND tsl.wkstn_id = tr.wkstn_id 
      AND tsl.trans_seq = tr.trans_seq
    left join crm_party cust
    on tsl.organization_id = cust.organization_id 
      AND tr.cust_party_id = cust.party_id
    where tsl.organization_id = pvOrganizationId
    and tsl.rtl_loc_id = pvRetailLocationId
    and tsl.wkstn_id = pvWrkstnId
    and tsl.business_date = pvBusinessDate
    and tsl.trans_seq = pvTransSeq
    and r.void_flag=0
    and ((tsl.SALE_LINEITM_TYPCODE <> 'ORDER'and (xom.detail_type IS NULL OR xol.status_code = 'FULFILLED') )
    or (tsl.SALE_LINEITM_TYPCODE = 'ORDER' and xom.detail_type in ('FEE', 'PAYMENT') ));
    raise myreturn;
  END IF;

    -- collect transaction data
    IF ABS(vTaxTotal) > 0 AND vTransTypcode <> 'POST_VOID' AND vPostVoidFlag = 0 AND vTransStatcode = 'COMPLETE' THEN
      
        sp_ins_upd_flash_sales (pvOrganizationId, 
                                pvRetailLocationId, 
                                vTransDate,
                                pvWrkstnId, 
                                'TotalTax', 
                                1, 
                                vTaxTotal, 
                                vCurrencyId);
      
    END IF;

    IF vTransTypcode = 'TENDER_CONTROL' AND vPostVoidFlag = 0 THEN    -- process for paid in paid out 
    
        BEGIN
        SELECT  typcode, amt INTO vPaid, vPaidAmt 
            FROM TSN_TNDR_CONTROL_TRANS 
            WHERE typcode LIKE 'PAID%'
              AND organization_id = pvOrganizationId
              AND rtl_loc_id = pvRetailLocationId
              AND wkstn_id = pvWrkstnId
              AND trans_seq = pvTransSeq
              AND business_date = pvBusinessDate;
           EXCEPTION
        WHEN no_data_found THEN
            NULL;
        END;


        vCntTndrCtl := SQL%ROWCOUNT;
    
        IF vCntTndrCtl = 1 THEN   
            
                IF vTransStatcode = 'COMPLETE' THEN
                        -- it is paid in or paid out
                    IF vPaid = 'PAID_IN' OR vPaid = 'PAIDIN' THEN
                        vLineEnum := 'paidin';
                    ELSE
                        vLineEnum := 'paidout';
                    END IF; 
                        -- update flash sales                 
                        sp_ins_upd_flash_sales (pvOrganizationId, 
                                               pvRetailLocationId, 
                                               vTransDate,
                                               pvWrkstnId, 
                                               vLineEnum, 
                                               1, 
                                               vPaidAmt, 
                                               vCurrencyId);
                END IF;
        END IF;
    END IF;
  
  -- collect tenders  data
  IF vPostVoidFlag = 0 AND vTransTypcode <> 'POST_VOID' THEN
  BEGIN
    OPEN tenderCursor;
    LOOP
        FETCH tenderCursor INTO vTenderAmt, vForeign_amt, vTndrid, vTndrStatcode, vTndridProp; 
        EXIT WHEN tenderCursor%NOTFOUND;
  
        IF vTndrStatcode <> 'Change' THEN
            vTndrCount := 1;-- only for original tenders
        ELSE 
            vTndrCount := 0;
        END IF;

        if vTndridProp IS NOT NULL THEN
           vTndrid := vTndridProp;
    end if;

       IF vLineEnum = 'paidout' THEN
            vTenderAmt := vTenderAmt * -1;
            vForeign_amt := vForeign_amt * -1;
        END IF;

        -- update flash
        IF vTransStatcode = 'COMPLETE' THEN
            sp_ins_upd_flash_sales (pvOrganizationId, 
                                    pvRetailLocationId, 
                                    vTransDate, 
                                    pvWrkstnId, 
                                    vTndrid, 
                                    vTndrCount, 
                                    vTenderAmt, 
                                    vCurrencyId);
        END IF;

        IF vTenderAmt > 0 AND vTransStatcode = 'COMPLETE' THEN
            sp_ins_upd_flash_sales (pvOrganizationId, 
                                    pvRetailLocationId, 
                                    vTransDate, 
                                    pvWrkstnId,
                                    'TendersTakenIn', 
                                    1, 
                                    vTenderAmt, 
                                    vCurrencyId);
        ELSE
            sp_ins_upd_flash_sales (pvOrganizationId, 
                                    pvRetailLocationId, 
                                    vTransDate, 
                                    pvWrkstnId, 
                                    'TendersRefunded', 
                                    1, 
                                    vTenderAmt, 
                                    vCurrencyId);
        END IF;
    END LOOP;
    CLOSE tenderCursor;
  EXCEPTION
    WHEN OTHERS THEN CLOSE tenderCursor;
  END;
  END IF;
  
  -- collect post void info
  IF vTransTypcode = 'POST_VOID' OR vPostVoidFlag = 1 THEN
      vTransCount := -1; /* reversing the count */
      IF vPostVoidFlag = 0 THEN
        vPostVoidFlag := 1;
      
            /* NOTE: From now on the parameter value carries the original post voided
                information rather than the current transaction information in 
                case of post void trans type. This will apply for sales data 
                processing.
            */
            BEGIN
            SELECT voided_org_id, voided_rtl_store_id, voided_wkstn_id, voided_business_date, voided_trans_id 
              INTO pvOrganizationId, pvRetailLocationId, pvWrkstnId, pvBusinessDate, pvTransSeq
              FROM TRN_POST_VOID_TRANS 
              WHERE organization_id = pvOrganizationId
                AND rtl_loc_id = pvRetailLocationId
                AND wkstn_id = pvWrkstnId
                AND business_date = pvBusinessDate
                AND trans_seq = pvTransSeq;
            EXCEPTION
                WHEN no_data_found THEN
                NULL;
            END;

            vCntPostVoid := SQL%ROWCOUNT;

            IF vCntPostVoid = 0 THEN      
              
                raise myerror; -- don't know the original post voided record
            END IF;

      select count(*) into vCntPostVoid from rpt_sale_line
      WHERE organization_id = pvOrganizationId
      AND rtl_loc_id = pvRetailLocationId
      AND wkstn_id = pvWrkstnId
      AND trans_seq = pvTransSeq
      AND business_date = pvBusinessDate
      AND trans_statcode = 'VOID';

      IF vCntPostVoid > 0 THEN
                raise myerror; -- record already exists
      END IF;
      END IF;
    -- updating for postvoid
     UPDATE rpt_sale_line
       SET trans_statcode='VOID'
       WHERE organization_id = pvOrganizationId
         AND rtl_loc_id = pvRetailLocationId
         AND wkstn_id = pvWrkstnId
         AND business_date = pvBusinessDate
         AND trans_seq = pvTransSeq; 
        
      BEGIN
      SELECT typcode, amt INTO vPaid, vPaidAmt
        FROM TSN_TNDR_CONTROL_TRANS 
        WHERE typcode LIKE 'PAID%'
          AND organization_id = pvOrganizationId
          AND rtl_loc_id = pvRetailLocationId
          AND wkstn_id = pvWrkstnId
          AND trans_seq = pvTransSeq
          AND business_date = pvBusinessDate;
      EXCEPTION WHEN no_data_found THEN
          NULL;
      END;


      IF SQL%FOUND AND vTransStatcode = 'COMPLETE' THEN
        -- it is paid in or paid out
        IF vPaid = 'PAID_IN' OR vPaid = 'PAIDIN' THEN
            vLineEnum := 'paidin';
        ELSE
            vLineEnum := 'paidout';
        END IF;
        vPaidAmt := vPaidAmt * -1 ;

        -- update flash sales                 
        sp_ins_upd_flash_sales (pvOrganizationId, 
                                pvRetailLocationId, 
                                vTransDate,
                                pvWrkstnId, 
                                vLineEnum, 
                                -1, 
                                vPaidAmt, 
                                vCurrencyId);
      END IF;
    
        BEGIN
        SELECT taxtotal INTO vTaxTotal
          FROM TRN_TRANS 
          WHERE organization_id = pvOrganizationId
            AND rtl_loc_id = pvRetailLocationId
            AND wkstn_id = pvWrkstnId
            AND business_date = pvBusinessDate
            AND trans_seq = pvTransSeq;
        EXCEPTION WHEN no_data_found THEN
            NULL;
        END;
        
        vCntRevTrans := SQL%ROWCOUNT;
        
        IF vCntRevTrans = 1 THEN    
            IF ABS(vTaxTotal) > 0 AND vTransStatcode = 'COMPLETE' THEN
                vTaxTotal := vTaxTotal * -1 ;
                sp_ins_upd_flash_sales (pvOrganizationId,
                                        pvRetailLocationId,
                                        vTransDate,
                                        pvWrkstnId,
                                        'TotalTax',
                                        -1,
                                        vTaxTotal, 
                                        vCurrencyId);
            END IF;
        END IF;

        -- reverse tenders
  BEGIN
        OPEN postVoidTenderCursor;
        
        LOOP
            FETCH postVoidTenderCursor INTO vTenderAmt, vForeign_amt, vTndrid, vTndrStatcode, vTndridProp;
            EXIT WHEN postVoidTenderCursor%NOTFOUND;
          
            IF vTndrStatcode <> 'Change' THEN
              vTndrCount := -1 ; -- only for original tenders
            ELSE 
              vTndrCount := 0 ;
            END IF;
          
      if vTndridProp IS NOT NULL THEN
         vTndrid := vTndridProp;
      end if;

            -- update flash
            vTenderAmt := vTenderAmt * -1;

            IF vTransStatcode = 'COMPLETE' THEN
                sp_ins_upd_flash_sales (pvOrganizationId, 
                                        pvRetailLocationId, 
                                        vTransDate, 
                                        pvWrkstnId, 
                                        vTndrid, 
                                        vTndrCount, 
                                        vTenderAmt, 
                                        vCurrencyId);
            END IF;
            
            IF vTenderAmt < 0 AND vTransStatcode = 'COMPLETE' THEN
                sp_ins_upd_flash_sales (pvOrganizationId, 
                                        pvRetailLocationId, 
                                        vTransDate, 
                                        pvWrkstnId,
                                        'TendersTakenIn',
                                        -1, 
                                        vTenderAmt, 
                                        vCurrencyId);
            ELSE
                sp_ins_upd_flash_sales (pvOrganizationId, 
                                        pvRetailLocationId, 
                                        vTransDate, 
                                        pvWrkstnId,
                                        'TendersRefunded',
                                        -1, 
                                        vTenderAmt, 
                                        vCurrencyId);
            END IF;
        END LOOP;
        
        CLOSE postVoidTenderCursor;
    EXCEPTION
      WHEN OTHERS THEN CLOSE postVoidTenderCursor;
  END;
  END IF;
  
  -- collect sales data
          

IF vPostVoidFlag = 0 and vTransTypcode <> 'POST_VOID' THEN -- dont do it for rpt sale line
        -- sale item insert
         insert into rpt_sale_line
        (organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq,
        quantity, actual_quantity, gross_quantity, unit_price, net_amt, gross_amt, item_id, 
        item_desc, merch_level_1, serial_nbr, return_flag, override_amt, trans_timestamp, trans_date,
        discount_amt, cust_party_id, last_name, first_name, trans_statcode, sale_lineitm_typcode, begin_time_int, exclude_from_net_sales_flag)
        select tsl.organization_id, tsl.rtl_loc_id, tsl.business_date, tsl.wkstn_id, tsl.trans_seq, tsl.rtrans_lineitm_seq,
        tsl.net_quantity, tsl.quantity, tsl.gross_quantity, tsl.unit_price, tsl.net_amt, tsl.gross_amt,    tsl.item_id,
        i.DESCRIPTION, coalesce(tsl.merch_level_1,i.MERCH_LEVEL_1,'DEFAULT'), tsl.serial_nbr, tsl.return_flag, coalesce(o.override_amt,0), vTransTimeStamp, vTransDate,
        coalesce(d.discount_amt,0), tr.cust_party_id, cust.last_name, cust.first_name, vTransStatcode, tsl.sale_lineitm_typcode, vBeginTimeInt, tsl.exclude_from_net_sales_flag
        from trl_sale_lineitm tsl
        inner join trl_rtrans_lineitm r
        on tsl.organization_id=r.organization_id
        and tsl.rtl_loc_id=r.rtl_loc_id
        and tsl.wkstn_id=r.wkstn_id
        and tsl.trans_seq=r.trans_seq
        and tsl.business_date=r.business_date
        and tsl.rtrans_lineitm_seq=r.rtrans_lineitm_seq
        and r.rtrans_lineitm_typcode = 'ITEM'
        left join xom_order_mod xom
            on tsl.organization_id=xom.organization_id
            and tsl.rtl_loc_id=xom.rtl_loc_id
            and tsl.wkstn_id=xom.wkstn_id
            and tsl.trans_seq=xom.trans_seq
            and tsl.business_date=xom.business_date
            and tsl.rtrans_lineitm_seq=xom.rtrans_lineitm_seq
        left join xom_order_line xol
            on xom.organization_id=xol.organization_id
            and xom.order_id=xol.order_id
            and xom.detail_seq=xol.detail_seq
        left join itm_item i
        on tsl.organization_id=i.ORGANIZATION_ID
        and tsl.item_id=i.ITEM_ID
        left join (select extended_amt override_amt,organization_id,rtl_loc_id,business_date,wkstn_id,trans_seq,rtrans_lineitm_seq
            FROM trl_rtl_price_mod
            WHERE void_flag = 0 and rtl_price_mod_reascode='PRICE_OVERRIDE') o
        on tsl.organization_id = o.organization_id 
            AND tsl.rtl_loc_id = o.rtl_loc_id
            AND tsl.business_date = o.business_date 
            AND tsl.wkstn_id = o.wkstn_id 
            AND tsl.trans_seq = o.trans_seq
            AND tsl.rtrans_lineitm_seq = o.rtrans_lineitm_seq
        left join (select sum(extended_amt) discount_amt,organization_id,rtl_loc_id,business_date,wkstn_id,trans_seq,rtrans_lineitm_seq
            FROM trl_rtl_price_mod
            WHERE void_flag = 0 and rtl_price_mod_reascode in ('LINE_ITEM_DISCOUNT', 'TRANSACTION_DISCOUNT', 'GROUP_DISCOUNT', 'NEW_PRICE_RULE', 'DEAL')
            group by organization_id,rtl_loc_id,business_date,wkstn_id,trans_seq,rtrans_lineitm_seq) d
        on tsl.organization_id = d.organization_id 
            AND tsl.rtl_loc_id = d.rtl_loc_id
            AND tsl.business_date = d.business_date 
            AND tsl.wkstn_id = d.wkstn_id 
            AND tsl.trans_seq = d.trans_seq
            AND tsl.rtrans_lineitm_seq = d.rtrans_lineitm_seq
        left join trl_rtrans tr
        on tsl.organization_id = tr.organization_id 
            AND tsl.rtl_loc_id = tr.rtl_loc_id
            AND tsl.business_date = tr.business_date 
            AND tsl.wkstn_id = tr.wkstn_id 
            AND tsl.trans_seq = tr.trans_seq
        left join crm_party cust
        on tsl.organization_id = cust.organization_id 
            AND tr.cust_party_id = cust.party_id
        where tsl.organization_id = pvOrganizationId
        and tsl.rtl_loc_id = pvRetailLocationId
        and tsl.wkstn_id = pvWrkstnId
        and tsl.business_date = pvBusinessDate
        and tsl.trans_seq = pvTransSeq
        and r.void_flag=0
        and ((tsl.SALE_LINEITM_TYPCODE <> 'ORDER'and (xom.detail_type IS NULL OR xol.status_code = 'FULFILLED') )
             or (tsl.SALE_LINEITM_TYPCODE = 'ORDER' and xom.detail_type in ('FEE', 'PAYMENT') ));

END IF;
    
        IF vTransStatcode = 'COMPLETE' THEN -- process only completed transaction for flash sales tables
        BEGIN
    SELECT sum(t.amt) into vAccountCredit
    FROM xom_order_mod xo
    inner join ttr_tndr_lineitm t
    on xo.organization_id=t.organization_id
    and xo.rtl_loc_id=t.rtl_loc_id
    and xo.business_date=t.business_date
    and xo.wkstn_id=t.wkstn_id
    and xo.trans_seq=t.trans_seq
    where t.organization_id = pvOrganizationId
    and t.rtl_loc_id = pvRetailLocationId
    and t.wkstn_id = pvWrkstnId
    and t.business_date = pvBusinessDate
    and t.trans_seq = pvTransSeq
    and t.tndr_id = 'ACCOUNT_CREDIT';
       EXCEPTION WHEN no_data_found THEN
          NULL;
        END;
 
        BEGIN
       select sum(case vPostVoidFlag when 0 then -1 else 1 end * coalesce(quantity,0)),sum(case vPostVoidFlag when 1 then -1 else 1 end * coalesce(net_amt,0))
        INTO vQuantity,vNetAmount
        from rpt_sale_line rsl
    left join itm_non_phys_item inp on rsl.item_id=inp.item_id and rsl.organization_id=inp.organization_id
        where rsl.organization_id = pvOrganizationId
            and rtl_loc_id = pvRetailLocationId
            and wkstn_id = pvWrkstnId
            and business_date = pvBusinessDate
            and trans_seq= pvTransSeq
            and return_flag=1
      and coalesce(exclude_from_net_sales_flag,0)=0;
        EXCEPTION WHEN no_data_found THEN
          NULL;
        END;
        
            IF ABS(vNetAmount) > 0 OR ABS(vQuantity) > 0 THEN
                -- populate now to flash tables
                -- returns
                sp_ins_upd_flash_sales(pvOrganizationId, 
                                       pvRetailLocationId, 
                                       vTransDate, 
                                       pvWrkstnId, 
                                       'Returns', 
                                       vQuantity, 
                                       vNetAmount, 
                                       vCurrencyId);
            END IF;
            
        select sum(case when return_flag=vPostVoidFlag then 1 else -1 end * coalesce(gross_quantity,0)),
        sum(case when return_flag=vPostVoidFlag then 1 else -1 end * coalesce(quantity,0)),
        sum(case vPostVoidFlag when 1 then -1 else 1 end * coalesce(gross_amt,0)),
        sum(case vPostVoidFlag when 1 then -1 else 1 end * coalesce(net_amt,0)),
        sum(case vPostVoidFlag when 1 then 1 else -1 end * coalesce(override_amt,0)),
        sum(case vPostVoidFlag when 1 then 1 else -1 end * coalesce(discount_amt,0))
        into vGrossQuantity,vQuantity,vGrossAmount,vNetAmount,vOverrideAmt,vDiscountAmt
        from rpt_sale_line rsl
    left join itm_non_phys_item inp on rsl.item_id=inp.item_id and rsl.organization_id=inp.organization_id
        where rsl.organization_id = pvOrganizationId
            and rtl_loc_id = pvRetailLocationId
            and wkstn_id = pvWrkstnId
            and business_date = pvBusinessDate
            and trans_seq= pvTransSeq
      and QUANTITY <> 0
      and sale_lineitm_typcode <> 'ONHOLD'
      and coalesce(exclude_from_net_sales_flag,0)=0;
      
            -- Gross sales
            IF ABS(vGrossAmount) >0 and vGrossAmount <> coalesce(vAccountCredit,0) THEN
                sp_ins_upd_flash_sales(pvOrganizationId,
                                       pvRetailLocationId,
                                       vTransDate, 
                                       pvWrkstnId, 
                                       'GrossSales', 
                                       vGrossQuantity, 
                                       vGrossAmount, 
                                       vCurrencyId);
            END IF;
      
            -- Net Sales update
            IF ABS(vNetAmount) > 0 and vGrossAmount <> coalesce(vAccountCredit,0) THEN
                sp_ins_upd_flash_sales(pvOrganizationId,
                                       pvRetailLocationId,
                                       vTransDate, 
                                       pvWrkstnId, 
                                       'NetSales', 
                                       vQuantity, 
                                       vNetAmount, 
                                       vCurrencyId);
            END IF;
        
            -- Discounts
            IF ABS(vOverrideAmt) > 0 THEN
                sp_ins_upd_flash_sales(pvOrganizationId,
                                       pvRetailLocationId,
                                       vTransDate, 
                                       pvWrkstnId, 
                                       'Overrides', 
                                       vQuantity, 
                                       vOverrideAmt, 
                                       vCurrencyId);
            END IF; 
  
            -- Discounts  
            IF ABS(vDiscountAmt) > 0 THEN 
                sp_ins_upd_flash_sales(pvOrganizationId,
                                       pvRetailLocationId,
                                       vTransDate,
                                       pvWrkstnId,
                                       'Discounts',
                                       vQuantity, 
                                       vDiscountAmt, 
                                       vCurrencyId);
            END IF;
      
   
        -- Hourly sales updates (add for all the line items in the transaction)
            vTotQuantity := COALESCE(vTotQuantity,0) + vQuantity;
            vTotNetAmt := COALESCE(vTotNetAmt,0) + vNetAmount;
            vTotGrossAmt := COALESCE(vTotGrossAmt,0) + vGrossAmount;
    
  BEGIN
    OPEN saleCursor;
      
    LOOP  
        FETCH saleCursor INTO vItemId, 
                              vSaleLineitmTypcode, 
                              vActualQuantity,
                              vUnitPrice, 
                              vGrossAmount, 
                              vGrossQuantity, 
                              vDepartmentId, 
                              vNetAmount, 
                              vQuantity,
                vReturnFlag;
    
        EXIT WHEN saleCursor%NOTFOUND;
      
            BEGIN
            SELECT non_phys_item_typcode INTO vNonPhysType
              FROM ITM_NON_PHYS_ITEM 
              WHERE item_id = vItemId 
                AND organization_id = pvOrganizationId  ;
            EXCEPTION WHEN no_data_found THEN
                NULL;
            END;
      
            vCntNonPhysItm := SQL%ROWCOUNT;
            
            IF vCntNonPhysItm = 1 THEN  
                -- check for layaway or sp. order payment / deposit
                IF vPostVoidFlag <> vReturnFlag THEN 
                    vNonPhysPrice := vUnitPrice * -1;
                    vNonPhysQuantity := vActualQuantity * -1;
                ELSE
                    vNonPhysPrice := vUnitPrice;
                    vNonPhysQuantity := vActualQuantity;
                END IF;
      
                IF vNonPhysType = 'LAYAWAY_DEPOSIT' THEN 
                    vNonPhys := 'LayawayDeposits';
                ELSIF vNonPhysType = 'LAYAWAY_PAYMENT' THEN
                    vNonPhys := 'LayawayPayments';
                ELSIF vNonPhysType = 'SP_ORDER_DEPOSIT' THEN
                    vNonPhys := 'SpOrderDeposits';
                ELSIF vNonPhysType = 'SP_ORDER_PAYMENT' THEN
                    vNonPhys := 'SpOrderPayments';
             ELSIF vNonPhysType = 'PRESALE_DEPOSIT' THEN
        vNonPhys := 'PresaleDeposits';
          ELSIF vNonPhysType = 'PRESALE_PAYMENT' THEN
        vNonPhys := 'PresalePayments';
                ELSE 
                    vNonPhys := 'NonMerchandise';
                    vNonPhysPrice := vGrossAmount;
                    vNonPhysQuantity := vGrossQuantity;
                END IF; 
                -- update flash sales for non physical payments / deposits
                sp_ins_upd_flash_sales (pvOrganizationId,
                                        pvRetailLocationId,
                                        vTransDate,
                                        pvWrkstnId,
                                        vNonPhys,
                                        vNonPhysQuantity, 
                                        vNonphysPrice, 
                                        vCurrencyId);
            ELSE
                vNonPhys := ''; -- reset 
            END IF;
    
            -- process layaways and special orders (not sales)
            IF vSaleLineitmTypcode = 'LAYAWAY' OR vSaleLineitmTypcode = 'SPECIAL_ORDER' THEN
                IF (NOT (vNonPhys = 'LayawayDeposits' 
                      OR vNonPhys = 'LayawayPayments' 
                      OR vNonPhys = 'SpOrderDeposits' 
                      OR vNonPhys = 'SpOrderPayments'
          OR vNonPhys = 'PresaleDeposits'
          OR vNonPhys = 'PresalePayments')) 
                    AND ((vLineitemStatcode IS NULL) OR (vLineitemStatcode <> 'CANCEL')) THEN
                    
                    vNonPhysSaleType := 'SpOrderItems';
                  
                    IF vSaleLineitmTypcode = 'LAYAWAY' THEN
                        vNonPhysSaleType := 'LayawayItems';
            ELSIF vSaleLineitmTypcode = 'PRESALE' THEN
            vNonPhysSaleType := 'PresaleItems';

                    END IF;
                  
                    -- update flash sales for layaway items
                    vLayawayPrice := vUnitPrice * COALESCE(vActualQuantity,0);
                    sp_ins_upd_flash_sales (pvOrganizationId,
                                            pvRetailLocationId,
                                            vTransDate,
                                            pvWrkstnId,
                                            vNonPhys,
                                            vActualQuantity, 
                                            vLayawayPrice, 
                                            vCurrencyId);
                END IF;
            END IF;
            -- end flash sales update
            -- department sales
            sp_ins_upd_merchlvl1_sales(pvOrganizationId, 
                                  pvRetailLocationId, 
                                  vTransDate, 
                                  pvWrkstnId, 
                                  vDepartmentId, 
                                  vQuantity, 
                                  vNetAmount, 
                                  vGrossAmount, 
                                  vCurrencyId);
    END LOOP;
    CLOSE saleCursor;
  EXCEPTION
    WHEN OTHERS THEN CLOSE saleCursor;
  END;
    END IF; 
  
  
    -- update hourly sales
    IF (ABS(vTotNetAmt) > 0 OR ABS(vTotGrossAmt) > 0 OR ABS(vTotquantity) > 0) AND (vTransStatcode = 'COMPLETE') THEN
        Sp_Ins_Upd_Hourly_Sales(pvOrganizationId, 
                                pvRetailLocationId, 
                                vTransDate, 
                                pvWrkstnId, 
                                vTransTimeStamp, 
                                vTotquantity, 
                                vTotNetAmt, 
                                vTotGrossAmt, 
                                vTransCount, 
                                vCurrencyId);
    END IF;
  
    COMMIT;
  
    EXCEPTION
        --WHEN NO_DATA_FOUND THEN
        --    vRowCnt := 0;            
        WHEN myerror THEN
            rollback;
        WHEN myreturn THEN
            commit;
        WHEN others THEN
            DBMS_OUTPUT.PUT_LINE('ERROR NUM: ' || to_char(sqlcode));
            DBMS_OUTPUT.PUT_LINE('ERROR TXT: ' || SQLERRM);
            rollback;
--    END;
END sp_flash;
/

GRANT EXECUTE ON sp_flash TO posusers;
GRANT EXECUTE ON sp_flash TO dbausers;
--[/RXPS-17705]

--[RXPS-16698]

--
-- TABLE: CPAF_NFE
--

BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE') THEN
       dbms_output.put_line('      CPAF_NFE already exists');
  ELSE
        EXECUTE IMMEDIATE 'CREATE TABLE CPAF_NFE(
  ORGANIZATION_ID  NUMBER(10, 0)   NOT NULL,
  RTL_LOC_ID  NUMBER(10, 0)   NOT NULL,
  ENVIRONMENT_ID   NUMBER(10, 0)   NOT NULL,
  TP_NF            NUMBER(10, 0)   NOT NULL,
  SERIES_ID        NUMBER(10, 0)   NOT NULL,
  NNF              NUMBER(10, 0)   NOT NULL,
  MODEL            VARCHAR2(2 CHAR)    NOT NULL,
  CUF              NUMBER(10, 0)           NULL,
  CNF              NUMBER(10, 0)           NULL,
  TRANS_TYPCODE    VARCHAR2(30 CHAR)  NULL,
  NATOP            VARCHAR2(60 CHAR) NULL,
  INDPAG           NUMBER(10, 0)           NULL,
  ISSUE_DATE       TIMESTAMP(6)      NULL,
  SAI_ENT_DATETIME TIMESTAMP(6)      NULL,
  CMUN_FG          VARCHAR2(7 CHAR)   NULL,
  TP_IMP           NUMBER(10, 0)           NULL,
  TP_EMIS          NUMBER(10, 0)           NULL,
  FIN_NFE          NUMBER(10, 0)           NULL,
  PROC_EMI         NUMBER(10, 0)           NULL,
  VER_PROC         VARCHAR2(20 CHAR)  NULL,
  CONT_DATETIME    TIMESTAMP(6)      NULL,
  CONT_XJUST       VARCHAR2(255 CHAR) NULL,
  PRODUCT_AMOUNT   NUMBER(17,6) NULL,
  SERVICE_AMOUNT   NUMBER(17,6) NULL,
  ICMS_BASIS       NUMBER(17,6) NULL,
  ICMS_AMOUNT      NUMBER(17,6) NULL,
  ICMS_ST_BASIS    NUMBER(17,6) NULL,
  ICMS_ST_AMOUNT   NUMBER(17,6) NULL,
  ISS_BASIS        NUMBER(17,6) NULL,
  ISS_AMOUNT       NUMBER(17,6) NULL,
  II_AMOUNT        NUMBER(17,6) NULL,
  PIS_AMOUNT       NUMBER(17,6) NULL,
  COFINS_AMOUNT    NUMBER(17,6) NULL,
  ISS_PIS_AMOUNT       NUMBER(17,6) NULL,
  ISS_COFINS_AMOUNT    NUMBER(17,6) NULL,
  DISCOUNT_AMOUNT  NUMBER(17,6) NULL,
  FREIGHT_AMOUNT   NUMBER(17,6) NULL,
  INSURANCE_AMOUNT NUMBER(17,6) NULL,
  OTHER_AMOUNT     NUMBER(17,6) NULL,
  TOTAL_AMOUNT     NUMBER(17,6) NULL,
  INF_CPL          NCLOB  NULL,
  PROTOCOLO        VARCHAR2(30 CHAR)  NULL,
  CANC_PROTOCOLO   VARCHAR2(30 CHAR)  NULL,
  CHAVE_NFE        VARCHAR2(88 CHAR)  NULL,
  OLD_CHAVE_NFE    VARCHAR2(88 CHAR)  NULL,
  RECIBO           VARCHAR2(30 CHAR)  NULL,
  STAT_CODE        VARCHAR2(30 CHAR)  NULL,
  XML              NCLOB  NULL,
  DIG_VAL          VARCHAR2(30 CHAR)  NULL,  
  ISS_SERVICE_DATE VARCHAR2(10 CHAR)  NULL,  
  CREATE_DATE      TIMESTAMP(6)      NULL,
  CREATE_USER_ID   VARCHAR2(30 CHAR)  NULL,
  UPDATE_DATE      TIMESTAMP(6)      NULL,
  UPDATE_USER_ID   VARCHAR2(30 CHAR)  NULL,
  RECORD_STATE     VARCHAR2(30 CHAR)  NULL,
    CONSTRAINT PK_CPAF_NFE PRIMARY KEY (ORGANIZATION_ID, RTL_LOC_ID, ENVIRONMENT_ID, TP_NF, SERIES_ID, NNF, MODEL)
    USING INDEX
TABLESPACE $(DbTblspace)_INDEX
)
TABLESPACE $(DbTblspace)_DATA'
;
        dbms_output.put_line('      CPAF_NFE created');

        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE TO posusers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE TO dbausers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFE','ISS_SERVICE_DATE') THEN
        dbms_output.put_line('     CPAF_NFE.ISS_SERVICE_DATE already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFE ADD ISS_SERVICE_DATE VARCHAR2(10 CHAR)';
        dbms_output.put_line('     CPAF_NFE.ISS_SERVICE_DATE created');
  END IF;
END;

BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFE','SERVICE_AMOUNT') THEN
        dbms_output.put_line('     CPAF_NFE.SERVICE_AMOUNT already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFE ADD SERVICE_AMOUNT NUMBER(17,6)';
        dbms_output.put_line('     CPAF_NFE.SERVICE_AMOUNT created');
  END IF;
END;
BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFE','ISS_BASIS') THEN
        dbms_output.put_line('     CPAF_NFE.ISS_BASIS already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFE ADD ISS_BASIS NUMBER(17,6)';
        dbms_output.put_line('     CPAF_NFE.ISS_BASIS created');
  END IF;
END;
BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFE','ISS_AMOUNT') THEN
        dbms_output.put_line('     CPAF_NFE.ISS_AMOUNT already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFE ADD ISS_AMOUNT NUMBER(17,6)';
        dbms_output.put_line('     CPAF_NFE.ISS_AMOUNT created');
  END IF;
END;
BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFE','ISS_PIS_AMOUNT') THEN
        dbms_output.put_line('     CPAF_NFE.ISS_PIS_AMOUNT already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFE ADD ISS_PIS_AMOUNT NUMBER(17,6)';
        dbms_output.put_line('     CPAF_NFE.ISS_PIS_AMOUNT created');
  END IF;
END;
BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFE','ISS_COFINS_AMOUNT') THEN
        dbms_output.put_line('     CPAF_NFE.ISS_COFINS_AMOUNT already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFE ADD ISS_COFINS_AMOUNT NUMBER(17,6)';
        dbms_output.put_line('     CPAF_NFE.ISS_COFINS_AMOUNT created');
  END IF;
END;

/

BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_P') THEN
       dbms_output.put_line('     CPAF_NFE_P already exists');
  ELSE
        Create_Property_Table('CPAF_NFE');
        dbms_output.put_line('     CPAF_NFE_P created');
  END IF;
END;
/

--
-- TABLE: CPAF_NFE_ITEM
--
BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_ITEM') THEN
       dbms_output.put_line('      CPAF_NFE_ITEM already exists');
  ELSE
        EXECUTE IMMEDIATE 'CREATE TABLE CPAF_NFE_ITEM(
  ORGANIZATION_ID              NUMBER(10, 0)   NOT NULL,
  RTL_LOC_ID                   NUMBER(10, 0)   NOT NULL,  
  ENVIRONMENT_ID               NUMBER(10, 0)   NOT NULL,
  TP_NF                        NUMBER(10, 0)   NOT NULL,
  SERIES_ID                    NUMBER(10, 0)   NOT NULL,
  NNF                          NUMBER(10, 0)   NOT NULL,
  MODEL                        VARCHAR2(2 CHAR)    NOT NULL,
  SEQUENCE                     NUMBER(10, 0)   NOT NULL,
  ITEM_ID                      VARCHAR2(60 CHAR)   NULL,
  ITEM_DESCRIPTION             VARCHAR2(254 CHAR)  NULL,
  EAN                          VARCHAR2(14 CHAR)   NULL,
  NCM                          VARCHAR2(8 CHAR)    NULL,
  CEST                         VARCHAR2(18 CHAR)   NULL,
  EX_TIPI                      VARCHAR2(3 CHAR)    NULL,
  QUANTITY                     NUMBER(11,4)    NULL,
  UNIT_OF_MEASURE_CODE         VARCHAR2(30 CHAR)   NULL,
  TAXABLE_EAN                  VARCHAR2(14 CHAR)   NULL,
  TAXABLE_UNIT_OF_MEASURE_CODE VARCHAR2(30 CHAR)   NULL,
  IAT                          VARCHAR2(1 CHAR)    NULL,
  IPPT                         VARCHAR2(1 CHAR)    NULL,
  UNIT_PRICE                   NUMBER(17,6)    NULL,
  EXTENDED_AMOUNT              NUMBER(17,6)    NULL,
  TAXABLE_QUANTITY             NUMBER(11,4)    NULL,
  UNIT_TAXABLE_AMOUNT          NUMBER(17,6)    NULL,
  FREIGHT_AMOUNT               NUMBER(17,6)    NULL,
  INSURANCE_AMOUNT             NUMBER(17,6)    NULL,
  DISCOUNT_AMOUNT              NUMBER(17,6)    NULL,
  OTHER_AMOUNT                 NUMBER(17,6)    NULL,
  CFOP                         VARCHAR2(4 CHAR)    NULL,
  INF_AD_PROD                  VARCHAR2(500 CHAR)  NULL,
  ICMS_CST                     VARCHAR2(3 CHAR)    NULL,
  ICMS_BASIS                   NUMBER(17,6)    NULL,
  ICMS_AMOUNT                  NUMBER(17,6)    NULL,
  ICMS_RATE                    NUMBER(5,2)     NULL,
  ICMS_ST_BASIS                NUMBER(17,6)    NULL,
  ICMS_ST_AMOUNT               NUMBER(17,6)    NULL,
  ICMS_ST_RATE                 NUMBER(5,2)     NULL,
  ISS_BASIS                    NUMBER(17,6)    NULL,
  ISS_AMOUNT                   NUMBER(17,6)    NULL,
  ISS_RATE                     NUMBER(5,2)     NULL,
  IPI_AMOUNT                   NUMBER(17,6)    NULL,
  IPI_RATE                     NUMBER(5,2)     NULL,
  II_AMOUNT                    NUMBER(17,6)    NULL,
  PIS_BASIS                    NUMBER(17,6)    NULL,  
  PIS_AMOUNT                 NUMBER(17,6)    NULL,
  PIS_RATE                     NUMBER(17,6)    NULL,
  COFINS_BASIS                 NUMBER(17,6)    NULL,
  COFINS_AMOUNT                NUMBER(17,6)    NULL,
  COFINS_RATE                  NUMBER(17,6)    NULL,
  TAX_SITUATION_CODE           VARCHAR2(6 CHAR)    NULL,
  TAX_GROUP_ID                 VARCHAR2(120 CHAR)  NULL,
  LOG_SEQUENCE           NUMBER(10, 0)  NULL,
  REF_NFE                      VARCHAR2(88 CHAR)  NULL,
  IIS_CITY_CODE                      VARCHAR2(7 CHAR)  NULL,
  IIS_SERVICE_CODE                      VARCHAR2(5 CHAR)  NULL,
  IIS_ELIGIBLE_INDICATOR                      VARCHAR2(2 CHAR)  NULL,
  IIS_INCENTIVE_INDICATOR                      VARCHAR2(1 CHAR)  NULL,
  CREATE_DATE                  TIMESTAMP(6)    NULL,
  CREATE_USER_ID               VARCHAR2(30 CHAR)   NULL,
  UPDATE_DATE                  TIMESTAMP(6)    NULL,
  UPDATE_USER_ID               VARCHAR2(30 CHAR)   NULL,
  RECORD_STATE                 VARCHAR2(30 CHAR)   NULL,
    CONSTRAINT PK_CPAF_NFE_ITEM PRIMARY KEY (ORGANIZATION_ID, RTL_LOC_ID, ENVIRONMENT_ID, TP_NF, SERIES_ID, NNF, MODEL, SEQUENCE)
    USING INDEX
TABLESPACE $(DbTblspace)_INDEX
)
TABLESPACE $(DbTblspace)_DATA'
;
        dbms_output.put_line('      CPAF_NFE_ITEM created');

        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE_ITEM TO posusers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE_ITEM TO dbausers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFE_ITEM','ISS_BASIS') THEN
        dbms_output.put_line('     CPAF_NFE_ITEM.ISS_BASIS already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFE_ITEM ADD ISS_BASIS NUMBER(17,6)';
        dbms_output.put_line('     CPAF_NFE_ITEM.ISS_BASIS created');
  END IF;
END;
BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFE_ITEM','ISS_AMOUNT') THEN
        dbms_output.put_line('     CPAF_NFE_ITEM.ISS_AMOUNT already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFE_ITEM ADD ISS_AMOUNT NUMBER(17,6)';
        dbms_output.put_line('     CPAF_NFE_ITEM.ISS_AMOUNT created');
  END IF;
END;
BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFE_ITEM','ISS_RATE') THEN
        dbms_output.put_line('     CPAF_NFE_ITEM.ISS_RATE already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFE_ITEM ADD ISS_RATE NUMBER(17,6)';
        dbms_output.put_line('     CPAF_NFE_ITEM.ISS_RATE created');
  END IF;
END;

BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFE_ITEM','IIS_CITY_CODE') THEN
        dbms_output.put_line('     CPAF_NFE_ITEM.IIS_CITY_CODE already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFE_ITEM ADD IIS_CITY_CODE VARCHAR2(7 CHAR)';
        dbms_output.put_line('     CPAF_NFE_ITEM.IIS_CITY_CODE created');
  END IF;
END;
BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFE_ITEM','IIS_SERVICE_CODE') THEN
        dbms_output.put_line('     CPAF_NFE_ITEM.IIS_SERVICE_CODE already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFE_ITEM ADD IIS_SERVICE_CODE VARCHAR2(5 CHAR)';
        dbms_output.put_line('     CPAF_NFE_ITEM.IIS_SERVICE_CODE created');
  END IF;
END;
BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFE_ITEM','IIS_ELIGIBLE_INDICATOR') THEN
        dbms_output.put_line('     CPAF_NFE_ITEM.IIS_ELIGIBLE_INDICATOR already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFE_ITEM ADD IIS_ELIGIBLE_INDICATOR VARCHAR2(2 CHAR)';
        dbms_output.put_line('     CPAF_NFE_ITEM.IIS_ELIGIBLE_INDICATOR created');
  END IF;
END;
BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFE_ITEM','IIS_INCENTIVE_INDICATOR') THEN
        dbms_output.put_line('     CPAF_NFE_ITEM.IIS_INCENTIVE_INDICATOR already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFE_ITEM ADD IIS_INCENTIVE_INDICATOR VARCHAR2(1 CHAR)';
        dbms_output.put_line('     CPAF_NFE_ITEM.IIS_INCENTIVE_INDICATOR created');
  END IF;
END;


BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFE_ITEM','REF_NFE') THEN
        dbms_output.put_line('     CPAF_NFE_ITEM.REF_NFE already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFE_ITEM ADD REF_NFE VARCHAR2(88 CHAR)';
        dbms_output.put_line('     CPAF_NFE_ITEM.REF_NFE created');
  END IF;
END;

BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_ITEM_P') THEN
       dbms_output.put_line('     CPAF_NFE_ITEM_P already exists');
  ELSE
        Create_Property_Table('CPAF_NFE_ITEM');
        dbms_output.put_line('     CPAF_NFE_ITEM_P created');
  END IF;
END;
/

--
-- TABLE: CPAF_NFE_RESEND_QUEUE
--
BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_RESEND_QUEUE') THEN
       dbms_output.put_line('      CPAF_NFE_RESEND_QUEUE already exists');
  ELSE
        EXECUTE IMMEDIATE 'CREATE TABLE CPAF_NFE_RESEND_QUEUE(
  ORGANIZATION_ID  NUMBER(10, 0)           NOT NULL,
  RTL_LOC_ID       NUMBER(10, 0)   NOT NULL, 
  WKSTN_ID         NUMBER(10, 0)           NOT NULL,
  CHAVE_NFE        VARCHAR2(88 CHAR)  NOT NULL,
  COPIES           NUMBER(10, 0)           NULL,
  REQUESTING_USER  VARCHAR2(20 CHAR)  NULL,
  EMAIL_ADDRESS    VARCHAR2(30 CHAR)  NULL,  
  CREATE_DATE      TIMESTAMP(6)      NULL,
  CREATE_USER_ID   VARCHAR2(30 CHAR)  NULL,
  UPDATE_DATE      TIMESTAMP(6)      NULL,
  UPDATE_USER_ID   VARCHAR2(30 CHAR)  NULL,
  RECORD_STATE     VARCHAR2(30 CHAR)  NULL,
    CONSTRAINT PK_CPAF_NFE_RESEND_QUEUE PRIMARY KEY (ORGANIZATION_ID, RTL_LOC_ID, WKSTN_ID, CHAVE_NFE)
    USING INDEX
TABLESPACE $(DbTblspace)_INDEX
)
TABLESPACE $(DbTblspace)_DATA'
;
        dbms_output.put_line('      CPAF_NFE_RESEND_QUEUE created');

        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE_RESEND_QUEUE TO posusers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE_RESEND_QUEUE TO dbausers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
  END IF;
END;
/

BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_RESEND_QUEUE_P') THEN
       dbms_output.put_line('     CPAF_NFE_RESEND_QUEUE_P already exists');
  ELSE
        Create_Property_Table('CPAF_NFE_RESEND_QUEUE');
        dbms_output.put_line('     CPAF_NFE_RESEND_QUEUE_P created');
  END IF;
END;
/

--
-- TABLE: CPAF_NFE_QUEUE
--
BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_QUEUE') THEN
       dbms_output.put_line('      CPAF_NFE_QUEUE already exists');
  ELSE
        EXECUTE IMMEDIATE 'CREATE TABLE CPAF_NFE_QUEUE(
  ORGANIZATION_ID  NUMBER(10, 0)           NOT NULL,
  RTL_LOC_ID       NUMBER(10, 0)           NOT NULL,
  WKSTN_ID         NUMBER(10, 0)           NOT NULL,
  QUEUE_SEQ        NUMBER(10, 0)           NOT NULL,
  ENVIRONMENT_ID   NUMBER(10, 0)           NULL,
  TP_NF            NUMBER(10, 0)           NULL,
  SERIES_ID        NUMBER(10, 0)           NULL,
  NNF              NUMBER(10, 0)           NULL,
  CUF              NUMBER(10, 0)           NULL,
  CNF              NUMBER(10, 0)           NULL,
  USAGE_TYPE       VARCHAR2(30 CHAR)       NULL,
  TRANS_TYPCODE    VARCHAR2(30 CHAR)       NULL,
  NATOP          VARCHAR2(60 CHAR)        NULL,  
  INDPAG           NUMBER(10, 0)           NULL,
  MODEL            VARCHAR2(2 CHAR)   NULL,
  ISSUE_DATE       TIMESTAMP(6)      NULL,
  SAI_ENT_DATETIME TIMESTAMP(6)      NULL,
  CMUN_FG          VARCHAR2(7 CHAR)   NULL,
  TP_IMP           NUMBER(10, 0)           NULL,
  TP_EMIS          NUMBER(10, 0)           NULL,
  FIN_NFE          NUMBER(10, 0)           NULL,
  PROC_EMI         NUMBER(10, 0)           NULL,
  VER_PROC         VARCHAR2(20 CHAR)  NULL,
  CONT_DATETIME    TIMESTAMP(6)      NULL,
  CONT_XJUST       VARCHAR2(255 CHAR) NULL,
  PRODUCT_AMOUNT   NUMBER(17,6) NULL,
  SERVICE_AMOUNT   NUMBER(17,6) NULL,
  ICMS_BASIS       NUMBER(17,6) NULL,
  ICMS_AMOUNT      NUMBER(17,6) NULL,
  ICMS_ST_BASIS    NUMBER(17,6) NULL,
  ICMS_ST_AMOUNT   NUMBER(17,6) NULL,
  ISS_BASIS    NUMBER(17,6) NULL,
  ISS_AMOUNT   NUMBER(17,6) NULL,
  II_AMOUNT        NUMBER(17,6) NULL,
  PIS_AMOUNT       NUMBER(17,6) NULL,
  COFINS_AMOUNT    NUMBER(17,6) NULL,
  ISS_PIS_AMOUNT       NUMBER(17,6) NULL,
  ISS_COFINS_AMOUNT    NUMBER(17,6) NULL,
  DISCOUNT_AMOUNT  NUMBER(17,6) NULL,
  FREIGHT_AMOUNT   NUMBER(17,6) NULL,
  INSURANCE_AMOUNT NUMBER(17,6) NULL,
  OTHER_AMOUNT     NUMBER(17,6) NULL,
  TOTAL_AMOUNT     NUMBER(17,6) NULL,
  INF_CPL          NCLOB  NULL,
  PROTOCOLO        VARCHAR2(30 CHAR)  NULL,
  CANC_PROTOCOLO   VARCHAR2(30 CHAR)  NULL,
  CHAVE_NFE        VARCHAR2(88 CHAR)  NULL,
  OLD_CHAVE_NFE    VARCHAR2(88 CHAR)  NULL,
  RECIBO           VARCHAR2(30 CHAR)  NULL,
  STAT_CODE        VARCHAR2(30 CHAR)  NULL,
  XML              NCLOB  NULL,
  RESPONSE_CODE    VARCHAR2(30 CHAR)  NULL,
  RESPONSE_TEXT    NCLOB  NULL,
  DIG_VAL          VARCHAR2(30 CHAR)  NULL,  
  ISS_SERVICE_DATE VARCHAR2(10 CHAR)  NULL,
  CREATE_DATE      TIMESTAMP(6)      NULL,
  CREATE_USER_ID   VARCHAR2(30 CHAR)  NULL,
  UPDATE_DATE      TIMESTAMP(6)      NULL,
  UPDATE_USER_ID   VARCHAR2(30 CHAR)  NULL,
  RECORD_STATE     VARCHAR2(30 CHAR)  NULL,
    CONSTRAINT PK_CPAF_NFE_QUEUE PRIMARY KEY (ORGANIZATION_ID, RTL_LOC_ID, WKSTN_ID, QUEUE_SEQ)
    USING INDEX
TABLESPACE $(DbTblspace)_INDEX
)
TABLESPACE $(DbTblspace)_DATA'
;
        dbms_output.put_line('      CPAF_NFE_QUEUE created');

        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE_QUEUE TO posusers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE_QUEUE TO dbausers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFE_QUEUE','ISS_SERVICE_DATE') THEN
        dbms_output.put_line('     CPAF_NFE_QUEUE.ISS_SERVICE_DATE already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFE_QUEUE ADD ISS_SERVICE_DATE VARCHAR2(10 CHAR)';
        dbms_output.put_line('     CPAF_NFE_QUEUE.ISS_SERVICE_DATE created');
  END IF;
END;

BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFE_QUEUE','SERVICE_AMOUNT') THEN
        dbms_output.put_line('     CPAF_NFE_QUEUE.SERVICE_AMOUNT already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFE_QUEUE ADD SERVICE_AMOUNT NUMBER(17,6)';
        dbms_output.put_line('     CPAF_NFE_QUEUE.SERVICE_AMOUNT created');
  END IF;
END;
BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFE_QUEUE','ISS_BASIS') THEN
        dbms_output.put_line('     CPAF_NFE_QUEUE.ISS_BASIS already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFE_QUEUE ADD ISS_BASIS NUMBER(17,6)';
        dbms_output.put_line('     CPAF_NFE_QUEUE.ISS_BASIS created');
  END IF;
END;
BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFE_QUEUE','ISS_AMOUNT') THEN
        dbms_output.put_line('     CPAF_NFE_QUEUE.ISS_AMOUNT already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFE_QUEUE ADD ISS_AMOUNT NUMBER(17,6)';
        dbms_output.put_line('     CPAF_NFE_QUEUE.ISS_AMOUNT created');
  END IF;
END;
BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFE_QUEUE','ISS_PIS_AMOUNT') THEN
        dbms_output.put_line('     CPAF_NFE_QUEUE.ISS_PIS_AMOUNT already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFE_QUEUE ADD ISS_PIS_AMOUNT NUMBER(17,6)';
        dbms_output.put_line('     CPAF_NFE_QUEUE.ISS_PIS_AMOUNT created');
  END IF;
END;
BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFE_QUEUE','ISS_COFINS_AMOUNT') THEN
        dbms_output.put_line('     CPAF_NFE_QUEUE.ISS_COFINS_AMOUNT already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFE_QUEUE ADD ISS_COFINS_AMOUNT NUMBER(17,6)';
        dbms_output.put_line('     CPAF_NFE_QUEUE.ISS_COFINS_AMOUNT created');
  END IF;
END;

/

BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_QUEUE_P') THEN
       dbms_output.put_line('     CPAF_NFE_QUEUE_P already exists');
  ELSE
        Create_Property_Table('CPAF_NFE_QUEUE');
        dbms_output.put_line('     CPAF_NFE_QUEUE_P created');
  END IF;
END;
/

--
-- TABLE: CPAF_NFE_QUEUE_LOG
--
BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_QUEUE_LOG') THEN
       dbms_output.put_line('      CPAF_NFE_QUEUE_LOG already exists');
  ELSE
        EXECUTE IMMEDIATE 'CREATE TABLE CPAF_NFE_QUEUE_LOG(
  ORGANIZATION_ID               NUMBER(10, 0)           NOT NULL,
  RTL_LOC_ID                    NUMBER(10, 0)           NOT NULL,
  WKSTN_ID                      NUMBER(10, 0)           NOT NULL,  
  QUEUE_SEQ                     NUMBER(10, 0)           NOT NULL,
  SEQUENCE                      NUMBER(10, 0)           NOT NULL,
  STAT_CODE                     VARCHAR2(30 CHAR)  NULL,
  RESPONSE_CODE                 VARCHAR2(30 CHAR)  NULL,
  RESPONSE_TEXT                 NCLOB  NULL,
  SOURCE                        VARCHAR2(255 CHAR) NULL,
  CREATE_DATE                   TIMESTAMP(6)      NULL,
  CREATE_USER_ID                VARCHAR2(30 CHAR)  NULL,
  UPDATE_DATE                   TIMESTAMP(6)      NULL,
  UPDATE_USER_ID                VARCHAR2(30 CHAR)  NULL,
  RECORD_STATE                  VARCHAR2(30 CHAR)  NULL,
    CONSTRAINT PK_CPAF_NFE_QUEUE_LOG PRIMARY KEY (ORGANIZATION_ID, RTL_LOC_ID, WKSTN_ID, QUEUE_SEQ, SEQUENCE)
    USING INDEX
TABLESPACE $(DbTblspace)_INDEX
)
TABLESPACE $(DbTblspace)_DATA'
;
        dbms_output.put_line('      CPAF_NFE_QUEUE_LOG created');

        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE_QUEUE_LOG TO posusers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE_QUEUE_LOG TO dbausers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
  END IF;
END;
/

BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_QUEUE_LOG_P') THEN
       dbms_output.put_line('     CPAF_NFE_QUEUE_LOG_P already exists');
  ELSE
        Create_Property_Table('CPAF_NFE_QUEUE_LOG');
        dbms_output.put_line('     CPAF_NFE_QUEUE_LOG_P created');
  END IF;
END;
/


--
-- TABLE: CPAF_NFE_QUEUE_ITEM
--
BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_QUEUE_ITEM') THEN
       dbms_output.put_line('      CPAF_NFE_QUEUE_ITEM already exists');
  ELSE
        EXECUTE IMMEDIATE 'CREATE TABLE CPAF_NFE_QUEUE_ITEM(
  ORGANIZATION_ID               NUMBER(10, 0)  NOT NULL,
  RTL_LOC_ID                    NUMBER(10, 0)  NOT NULL,
  WKSTN_ID                      NUMBER(10, 0)  NOT NULL,
  QUEUE_SEQ                     NUMBER(10, 0)  NOT NULL,
  SEQUENCE                      NUMBER(10, 0)  NOT NULL,
  ITEM_ID                       VARCHAR2(60 CHAR)  NULL,
  ITEM_DESCRIPTION              VARCHAR2(254 CHAR) NULL,
  EAN                           VARCHAR2(14 CHAR)  NULL,
  NCM                           VARCHAR2(8 CHAR)   NULL,
  CEST                          VARCHAR2(18 CHAR)  NULL,
  EX_TIPI                       VARCHAR2(3 CHAR)   NULL,
  QUANTITY                      NUMBER(11,4)   NULL,
  UNIT_OF_MEASURE_CODE          VARCHAR2(30 CHAR)  NULL,
  TAXABLE_EAN                   VARCHAR2(14 CHAR)  NULL,
  TAXABLE_UNIT_OF_MEASURE_CODE  VARCHAR2(30 CHAR)  NULL,
  IAT                           VARCHAR2(1 CHAR)   NULL,
  IPPT                          VARCHAR2(1 CHAR)   NULL,
  UNIT_PRICE                    NUMBER(17,6)   NULL,
  EXTENDED_AMOUNT               NUMBER(17,6)   NULL,
  TAXABLE_QUANTITY              NUMBER(11,4)   NULL,
  UNIT_TAXABLE_AMOUNT           NUMBER(17,6)   NULL,
  FREIGHT_AMOUNT                NUMBER(17,6)   NULL,
  INSURANCE_AMOUNT              NUMBER(17,6)   NULL,
  DISCOUNT_AMOUNT               NUMBER(17,6)   NULL,
  OTHER_AMOUNT                  NUMBER(17,6)   NULL,
  CFOP                          VARCHAR2(4 CHAR)   NULL,
  INF_AD_PROD                   VARCHAR2(500 CHAR) NULL,
  ICMS_CST                      VARCHAR2(3 CHAR)   NULL,
  ICMS_BASIS                    NUMBER(17,6)   NULL,
  ICMS_AMOUNT                   NUMBER(17,6)   NULL,
  ICMS_RATE                     NUMBER(5,2)    NULL,
  ICMS_ST_BASIS                 NUMBER(17,6)   NULL,
  ICMS_ST_AMOUNT                NUMBER(17,6)   NULL,
  ICMS_ST_RATE                  NUMBER(5,2)    NULL,
  ISS_BASIS                    NUMBER(17,6)    NULL,
  ISS_AMOUNT                   NUMBER(17,6)    NULL,
  ISS_RATE                     NUMBER(5,2)     NULL,
  IPI_AMOUNT                    NUMBER(17,6)   NULL,
  IPI_RATE                      NUMBER(5,2)    NULL,
  II_AMOUNT                 NUMBER(17,6)   NULL,
  PIS_BASIS                     NUMBER(17,6)   NULL,  
  PIS_AMOUNT                  NUMBER(17,6)   NULL,
  PIS_RATE                      NUMBER(17,6)   NULL,
  COFINS_BASIS                  NUMBER(17,6)   NULL,
  COFINS_AMOUNT                 NUMBER(17,6)   NULL,
  COFINS_RATE                   NUMBER(17,6)   NULL,
  TAX_SITUATION_CODE            VARCHAR2(6 CHAR)   NULL,
  TAX_GROUP_ID                  VARCHAR2(120 CHAR) NULL,
  LOG_SEQUENCE                  NUMBER(10, 0)  NULL,
  REF_NFE                       VARCHAR2(88 CHAR)  NULL,
  IIS_CITY_CODE                      VARCHAR2(7 CHAR)  NULL,
  IIS_SERVICE_CODE                      VARCHAR2(5 CHAR)  NULL,
  IIS_ELIGIBLE_INDICATOR                      VARCHAR2(2 CHAR)  NULL,
  IIS_INCENTIVE_INDICATOR                      VARCHAR2(1 CHAR)  NULL,
  CREATE_DATE                   TIMESTAMP(6)   NULL,
  CREATE_USER_ID                VARCHAR2(30 CHAR)  NULL,
  UPDATE_DATE                   TIMESTAMP(6)   NULL,
  UPDATE_USER_ID                VARCHAR2(30 CHAR)  NULL,
  RECORD_STATE                  VARCHAR2(30 CHAR)  NULL,
    CONSTRAINT PK_CPAF_NFE_QUEUE_ITEM PRIMARY KEY (ORGANIZATION_ID, RTL_LOC_ID, WKSTN_ID, QUEUE_SEQ, SEQUENCE)
    USING INDEX
TABLESPACE $(DbTblspace)_INDEX
)
TABLESPACE $(DbTblspace)_DATA'
;
        dbms_output.put_line('      CPAF_NFE_QUEUE_ITEM created');

        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE_QUEUE_ITEM TO posusers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE_QUEUE_ITEM TO dbausers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
  END IF;
END;
/


BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFE_QUEUE_ITEM','ISS_BASIS') THEN
        dbms_output.put_line('     CPAF_NFE_QUEUE_ITEM.ISS_BASIS already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFE_QUEUE_ITEM ADD ISS_BASIS NUMBER(17,6)';
        dbms_output.put_line('     CPAF_NFE_QUEUE_ITEM.ISS_BASIS created');
  END IF;
END;
BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFE_QUEUE_ITEM','ISS_AMOUNT') THEN
        dbms_output.put_line('     CPAF_NFE_QUEUE_ITEM.ISS_AMOUNT already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFE_QUEUE_ITEM ADD ISS_AMOUNT NUMBER(17,6)';
        dbms_output.put_line('     CPAF_NFE_QUEUE_ITEM.ISS_AMOUNT created');
  END IF;
END;
BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFE_QUEUE_ITEM','ISS_RATE') THEN
        dbms_output.put_line('     CPAF_NFE_QUEUE_ITEM.ISS_RATE already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFE_QUEUE_ITEM ADD ISS_RATE NUMBER(17,6)';
        dbms_output.put_line('     CPAF_NFE_QUEUE_ITEM.ISS_RATE created');
  END IF;
END;

BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFE_QUEUE_ITEM','IIS_CITY_CODE') THEN
        dbms_output.put_line('     CPAF_NFE_QUEUE_ITEM.IIS_CITY_CODE already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFE_QUEUE_ITEM ADD IIS_CITY_CODE VARCHAR2(7 CHAR)';
        dbms_output.put_line('     CPAF_NFE_QUEUE_ITEM.IIS_CITY_CODE created');
  END IF;
END;
BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFE_QUEUE_ITEM','IIS_SERVICE_CODE') THEN
        dbms_output.put_line('     CPAF_NFE_QUEUE_ITEM.IIS_SERVICE_CODE already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFE_QUEUE_ITEM ADD IIS_SERVICE_CODE VARCHAR2(5 CHAR)';
        dbms_output.put_line('     CPAF_NFE_QUEUE_ITEM.IIS_SERVICE_CODE created');
  END IF;
END;
BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFE_QUEUE_ITEM','IIS_ELIGIBLE_INDICATOR') THEN
        dbms_output.put_line('     CPAF_NFE_QUEUE_ITEM.IIS_ELIGIBLE_INDICATOR already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFE_QUEUE_ITEM ADD IIS_ELIGIBLE_INDICATOR VARCHAR2(2 CHAR)';
        dbms_output.put_line('     CPAF_NFE_QUEUE_ITEM.IIS_ELIGIBLE_INDICATOR created');
  END IF;
END;
BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFE_QUEUE_ITEM','IIS_INCENTIVE_INDICATOR') THEN
        dbms_output.put_line('     CPAF_NFE_QUEUE_ITEM.IIS_INCENTIVE_INDICATOR already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFE_QUEUE_ITEM ADD IIS_INCENTIVE_INDICATOR VARCHAR2(1 CHAR)';
        dbms_output.put_line('     CPAF_NFE_QUEUE_ITEM.IIS_INCENTIVE_INDICATOR created');
  END IF;
END;




BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFE_QUEUE_ITEM','REF_NFE') THEN
        dbms_output.put_line('     CPAF_NFE_QUEUE_ITEM.REF_NFE already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFE_QUEUE_ITEM ADD REF_NFE VARCHAR2(88 CHAR)';
        dbms_output.put_line('     CPAF_NFE_QUEUE_ITEM.REF_NFE created');
  END IF;
END;

BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_QUEUE_ITEM_P') THEN
       dbms_output.put_line('     CPAF_NFE_QUEUE_ITEM_P already exists');
  ELSE
        Create_Property_Table('CPAF_NFE_QUEUE_ITEM');
        dbms_output.put_line('     CPAF_NFE_QUEUE_ITEM_P created');
  END IF;
END;
/


--
-- TABLE: CPAF_NFE_QUEUE_TRANS
--
BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_QUEUE_TRANS') THEN
       dbms_output.put_line('      CPAF_NFE_QUEUE_TRANS already exists');
  ELSE
        EXECUTE IMMEDIATE 'CREATE TABLE CPAF_NFE_QUEUE_TRANS(
  ORGANIZATION_ID               NUMBER(10, 0)           NOT NULL,
    RTL_LOC_ID                    NUMBER(10, 0)           NOT NULL,
    WKSTN_ID                      NUMBER(10, 0)           NOT NULL,
    BUSINESS_DATE                 TIMESTAMP(6)            NOT NULL,
    TRANS_SEQ                     NUMBER(10, 0)           NOT NULL,
    TRANS_WKSTN_ID                NUMBER(10, 0)           DEFAULT 1 NOT NULL,
    QUEUE_SEQ                     NUMBER(10, 0)           NOT NULL,
    INACTIVE_FLAG                 NUMBER(1,0)             DEFAULT 0 NOT NULL,
    CREATE_DATE                   TIMESTAMP(6)      NULL,
    CREATE_USER_ID                VARCHAR2(30 CHAR)  NULL,
    UPDATE_DATE                   TIMESTAMP(6)      NULL,
    UPDATE_USER_ID                VARCHAR2(30 CHAR)  NULL,
    RECORD_STATE                  VARCHAR2(30 CHAR)  NULL,
    CONSTRAINT PK_CPAF_NFE_QUEUE_TRANS PRIMARY KEY (ORGANIZATION_ID, RTL_LOC_ID, WKSTN_ID, BUSINESS_DATE, TRANS_SEQ, TRANS_WKSTN_ID, QUEUE_SEQ)
    USING INDEX
TABLESPACE $(DbTblspace)_INDEX
)
TABLESPACE $(DbTblspace)_DATA'
;
        dbms_output.put_line('      CPAF_NFE_QUEUE_TRANS created');

        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE_QUEUE_TRANS TO posusers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE_QUEUE_TRANS TO dbausers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
  END IF;
END;
/

BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_QUEUE_TRANS_P') THEN
       dbms_output.put_line('     CPAF_NFE_QUEUE_TRANS_P already exists');
  ELSE
        Create_Property_Table('CPAF_NFE_QUEUE_TRANS');
        dbms_output.put_line('     CPAF_NFE_QUEUE_TRANS_P created');
  END IF;
END;
/

--
-- TABLE: CPAF_NFE_TRANS_TYPE
--
BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_TRANS_TYPE') THEN
       dbms_output.put_line('      CPAF_NFE_TRANS_TYPE already exists');
  ELSE
        EXECUTE IMMEDIATE 'CREATE TABLE CPAF_NFE_TRANS_TYPE(
    ORGANIZATION_ID        NUMBER(10, 0)             NOT NULL,
    TRANS_TYPCODE          VARCHAR2(30 CHAR)   NOT NULL,
    DESCRIPTION            VARCHAR2(60 CHAR)  NULL,
    NOTES                  VARCHAR2(2000 CHAR)   NULL,
    CFOP_SAME_UF           VARCHAR2(4 CHAR)     NULL,
    CFOP_OTHER_UF          VARCHAR2(4 CHAR)     NULL,
    CFOP_FOREIGN           VARCHAR2(4 CHAR)     NULL,
    FIN_NFE                NUMBER(10, 0)     DEFAULT 0,
    DISPLAY_ORDER          NUMBER(10, 0)             NULL,
    COMMENT_REQ_FLAG       NUMBER(1, 0)     DEFAULT 0,
    RULE_TYPE          VARCHAR2(30 CHAR)    NULL,
    DISALLOW_CANCEL_FLAG   NUMBER(1, 0)     DEFAULT 0,
    PRICING_TYPE           VARCHAR2(30 CHAR)    NULL,
    INITIAL_COMMENT        VARCHAR2(254 CHAR)    NULL,
    CREATE_DATE            TIMESTAMP(6)        NULL,
    CREATE_USER_ID         VARCHAR2(30 CHAR)    NULL,
    UPDATE_DATE            TIMESTAMP(6)        NULL,
    UPDATE_USER_ID         VARCHAR2(30 CHAR)    NULL,
    RECORD_STATE                 VARCHAR2(30 CHAR)  NULL,
    CONSTRAINT PK_CPAF_NFE_TRANS_TYPE PRIMARY KEY (ORGANIZATION_ID, TRANS_TYPCODE)
    USING INDEX
TABLESPACE $(DbTblspace)_INDEX
)
TABLESPACE $(DbTblspace)_DATA'
;
        dbms_output.put_line('      CPAF_NFE_TRANS_TYPE created');

        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE_TRANS_TYPE TO posusers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE_TRANS_TYPE TO dbausers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFE_TRANS_TYPE','FIN_NFE') THEN
        dbms_output.put_line('     CPAF_NFE_TRANS_TYPE.FIN_NFE already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFE_TRANS_TYPE ADD FIN_NFE NUMBER(10, 0) DEFAULT 0';
        dbms_output.put_line('     CPAF_NFE_TRANS_TYPE.FIN_NFE created');
  END IF;
END;



BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_TRANS_TYPE_P') THEN
       dbms_output.put_line('     CPAF_NFE_TRANS_TYPE_P already exists');
  ELSE
        Create_Property_Table('CPAF_NFE_TRANS_TYPE');
        dbms_output.put_line('     CPAF_NFE_TRANS_TYPE_P created');
  END IF;
END;
/

--
-- TABLE: CPAF_NFE_TRANS_TYPE_USE
--
BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_TRANS_TYPE_USE') THEN
       dbms_output.put_line('      CPAF_NFE_TRANS_TYPE_USE already exists');
  ELSE
        EXECUTE IMMEDIATE 'CREATE TABLE CPAF_NFE_TRANS_TYPE_USE(
    ORGANIZATION_ID        NUMBER(10, 0)             NOT NULL,
    TRANS_TYPCODE          VARCHAR2(30 CHAR)    NOT NULL,
    USAGE_TYPCODE          VARCHAR2(30 CHAR)    NOT NULL,
    UF                     VARCHAR2(2 CHAR)     NOT NULL,
    CREATE_DATE            TIMESTAMP(6)        NULL,
    CREATE_USER_ID         VARCHAR2(30 CHAR)    NULL,
    UPDATE_DATE            TIMESTAMP(6)        NULL,
    UPDATE_USER_ID         VARCHAR2(30 CHAR)   NULL,
    RECORD_STATE                 VARCHAR2(30 CHAR)  NULL,
    CONSTRAINT PK_CPAF_NFE_TRANS_TYPE_USE PRIMARY KEY (ORGANIZATION_ID, TRANS_TYPCODE, USAGE_TYPCODE, UF)
    USING INDEX
TABLESPACE $(DbTblspace)_INDEX
)
TABLESPACE $(DbTblspace)_DATA'
;
        dbms_output.put_line('      CPAF_NFE_TRANS_TYPE_USE created');

        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE_TRANS_TYPE_USE TO posusers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE_TRANS_TYPE_USE TO dbausers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
  END IF;
END;
/

BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_TRANS_TYPE_USE_P') THEN
       dbms_output.put_line('     CPAF_NFE_TRANS_TYPE_USE_P already exists');
  ELSE
        Create_Property_Table('CPAF_NFE_TRANS_TYPE_USE');
        dbms_output.put_line('     CPAF_NFE_TRANS_TYPE_USE_P created');
  END IF;
END;
/

--
-- TABLE: CPAF_NFE_TRANS
--
BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_TRANS') THEN
       dbms_output.put_line('      CPAF_NFE_TRANS already exists');
  ELSE
        EXECUTE IMMEDIATE 'CREATE TABLE CPAF_NFE_TRANS(
ORGANIZATION_ID               NUMBER(10, 0)           NOT NULL,
    RTL_LOC_ID                    NUMBER(10, 0)           NOT NULL,
    ENVIRONMENT_ID                NUMBER(10, 0)           NOT NULL,
    TP_NF                         NUMBER(10, 0)           NOT NULL,
  SERIES_ID                     NUMBER(10, 0)           NOT NULL,
  NNF                           NUMBER(10, 0)           NOT NULL,
  MODEL            VARCHAR2(2 CHAR)    NOT NULL,
  BUSINESS_DATE                 TIMESTAMP(6)      NOT NULL,  
  TRANS_WKSTN_ID          NUMBER(10, 0)           DEFAULT 1 NOT NULL,
  TRANS_SEQ                     NUMBER(10, 0)           NOT NULL,
  CREATE_DATE           TIMESTAMP(6)      NULL,
    CREATE_USER_ID                VARCHAR2(30 CHAR)  NULL,
    UPDATE_DATE                   TIMESTAMP(6)      NULL,
    UPDATE_USER_ID                VARCHAR2(30 CHAR)  NULL,
    RECORD_STATE                  VARCHAR2(30 CHAR)  NULL,  
    CONSTRAINT PK_CPAF_NFE_TRANS PRIMARY KEY (ORGANIZATION_ID, RTL_LOC_ID, ENVIRONMENT_ID, TP_NF, SERIES_ID, NNF, MODEL, BUSINESS_DATE, TRANS_WKSTN_ID, TRANS_SEQ)
    USING INDEX
TABLESPACE $(DbTblspace)_INDEX
)
TABLESPACE $(DbTblspace)_DATA'
;
        dbms_output.put_line('      CPAF_NFE_TRANS created');

        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE_TRANS TO posusers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE_TRANS TO dbausers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
  END IF;
END;
/

BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_TRANS_P') THEN
       dbms_output.put_line('     CPAF_NFE_TRANS_P already exists');
  ELSE
        Create_Property_Table('CPAF_NFE_TRANS');
        dbms_output.put_line('     CPAF_NFE_TRANS_P created');
  END IF;
END;
/

--
-- TABLE: CPAF_NFE_TRANS_TAX
--
BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_TRANS_TAX') THEN
       dbms_output.put_line('      CPAF_NFE_TRANS_TAX already exists');
  ELSE
        EXECUTE IMMEDIATE 'CREATE TABLE CPAF_NFE_TRANS_TAX(
ORGANIZATION_ID               NUMBER(10, 0)           NOT NULL,
  TRANS_TYPCODE               VARCHAR2(30 CHAR)  NOT NULL,
  UF                        VARCHAR2(2 CHAR)  NOT NULL,
  DEST_UF                     VARCHAR2(2 CHAR)  NOT NULL,
  TAX_GROUP_ID                VARCHAR2(120 CHAR)  NOT NULL, 
  NEW_TAX_GROUP_ID              VARCHAR2(120 CHAR)  NULL, 
  CREATE_DATE           TIMESTAMP(6)      NULL,
    CREATE_USER_ID                VARCHAR2(30 CHAR)  NULL,
    UPDATE_DATE                   TIMESTAMP(6)      NULL,
    UPDATE_USER_ID                VARCHAR2(30 CHAR)  NULL,
    RECORD_STATE                  VARCHAR2(30 CHAR)  NULL,
    CONSTRAINT PK_CPAF_NFE_TRANS_TAX PRIMARY KEY (ORGANIZATION_ID, TRANS_TYPCODE, UF, DEST_UF, TAX_GROUP_ID)
    USING INDEX
TABLESPACE $(DbTblspace)_INDEX
)
TABLESPACE $(DbTblspace)_DATA'
;
        dbms_output.put_line('      CPAF_NFE_TRANS_TAX created');

        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE_TRANS_TAX TO posusers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE_TRANS_TAX TO dbausers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
  END IF;
END;
/

BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_TRANS_TAX_P') THEN
       dbms_output.put_line('     CPAF_NFE_TRANS_TAX_P already exists');
  ELSE
        Create_Property_Table('CPAF_NFE_TRANS_TAX');
        dbms_output.put_line('     CPAF_NFE_TRANS_TAX_P created');
  END IF;
END;
/

--
-- TABLE: CPAF_ADDRESS_MUNI
--
BEGIN
  IF SP_TABLE_EXISTS ('CPAF_ADDRESS_MUNI') THEN
       dbms_output.put_line('      CPAF_ADDRESS_MUNI already exists');
  ELSE
        EXECUTE IMMEDIATE 'CREATE TABLE CPAF_ADDRESS_MUNI(
ORGANIZATION_ID              NUMBER(10, 0)           NOT NULL,
  MUNICIPALITY_ID              NUMBER(10, 0)           NOT NULL,  
  UF                       VARCHAR2(2 CHAR)  NULL,
  NAME                     VARCHAR2(72 CHAR)  NULL,
  IBGE_CODE                  VARCHAR2(7 CHAR)  NULL,
  POSTAL_CODE_START            VARCHAR2(8 CHAR)          NULL,  
  POSTAL_CODE_END              VARCHAR2(8 CHAR)          NULL,  
  PARENT_MUNICIPALITY_ID       NUMBER(10, 0)           NULL,
  LOC_IN_SIT                 VARCHAR2(1 CHAR)          NULL,  
  LOC_IN_TIPO_LOC              VARCHAR2(1 CHAR)          NULL,      
  CREATE_DATE           TIMESTAMP(6)      NULL,
    CREATE_USER_ID                VARCHAR2(30 CHAR)  NULL,
    UPDATE_DATE                   TIMESTAMP(6)      NULL,
    UPDATE_USER_ID                VARCHAR2(30 CHAR)  NULL,
    RECORD_STATE                  VARCHAR2(30 CHAR)  NULL,
    CONSTRAINT PK_CPAF_ADDRESS_MUNI PRIMARY KEY (ORGANIZATION_ID, MUNICIPALITY_ID)
    USING INDEX
TABLESPACE $(DbTblspace)_INDEX
)
TABLESPACE $(DbTblspace)_DATA'
;
        dbms_output.put_line('      CPAF_ADDRESS_MUNI created');

        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_ADDRESS_MUNI TO posusers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_ADDRESS_MUNI TO dbausers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
  END IF;
END;
/

BEGIN
  IF SP_TABLE_EXISTS ('CPAF_ADDRESS_MUNI_P') THEN
       dbms_output.put_line('     CPAF_ADDRESS_MUNI_P already exists');
  ELSE
        Create_Property_Table('CPAF_ADDRESS_MUNI');
        dbms_output.put_line('     CPAF_ADDRESS_MUNI_P created');
  END IF;
END;
/

--
-- TABLE: CPAF_NFE_ISSUER
--
BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_ISSUER') THEN
       dbms_output.put_line('      CPAF_NFE_ISSUER already exists');
  ELSE
        EXECUTE IMMEDIATE 'CREATE TABLE CPAF_NFE_ISSUER(
ORGANIZATION_ID             NUMBER(10, 0)           NOT NULL,
  RTL_LOC_ID              NUMBER(10, 0)           NOT NULL,
  ENVIRONMENT_ID              NUMBER(10, 0)           NOT NULL,
  TP_NF                 NUMBER(10, 0)           NOT NULL,
  SERIES_ID                 NUMBER(10, 0)           NOT NULL,
  NNF                 NUMBER(10, 0)           NOT NULL, 
  MODEL            VARCHAR2(2 CHAR)    NOT NULL,
  NAME                    VARCHAR2(60 CHAR)  NULL,
  FANTASY_NAME              VARCHAR2(60 CHAR)  NULL,
  FEDERAL_TAX_ID              VARCHAR2(20 CHAR)  NULL,
  STATE_TAX_ID              VARCHAR2(20 CHAR)  NULL,
  CITY_TAX_ID              VARCHAR2(20 CHAR)  NULL,
  CRT                     VARCHAR2(1 CHAR)  NULL, 
  STREET_NAME                 VARCHAR2(60 CHAR)  NULL,
  STREET_NUM                  VARCHAR2(60 CHAR)  NULL,
  COMPLEMENTO                 VARCHAR2(60 CHAR)  NULL,
  NEIGHBORHOOD              VARCHAR2(60 CHAR)  NULL,
  CITY_CODE                 VARCHAR2(7 CHAR)  NULL,
  CITY                    VARCHAR2(60 CHAR)  NULL,
  STATE                   VARCHAR2(2 CHAR)  NULL,
  POSTAL_CODE                 VARCHAR2(8 CHAR)  NULL,
  COUNTRY_CODE              VARCHAR2(4 CHAR)  NULL,
  COUNTRY_NAME              VARCHAR2(60 CHAR)  NULL,
  TELEPHONE                 VARCHAR2(14 CHAR)  NULL,  
  CREATE_DATE           TIMESTAMP(6)      NULL,
    CREATE_USER_ID                VARCHAR2(30 CHAR)  NULL,
    UPDATE_DATE                   TIMESTAMP(6)      NULL,
    UPDATE_USER_ID                VARCHAR2(30 CHAR)  NULL,
    RECORD_STATE                  VARCHAR2(30 CHAR)  NULL,
    CONSTRAINT PK_CPAF_NFE_ISSUER PRIMARY KEY (ORGANIZATION_ID, RTL_LOC_ID, ENVIRONMENT_ID, TP_NF, SERIES_ID, NNF, MODEL)
    USING INDEX
TABLESPACE $(DbTblspace)_INDEX
)
TABLESPACE $(DbTblspace)_DATA'
;
        dbms_output.put_line('      CPAF_NFE_ISSUER created');

        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE_ISSUER TO posusers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE_ISSUER TO dbausers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
  END IF;
END;
/

BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_ISSUER_P') THEN
       dbms_output.put_line('     CPAF_NFE_ISSUER_P already exists');
  ELSE
        Create_Property_Table('CPAF_NFE_ISSUER');
        dbms_output.put_line('     CPAF_NFE_ISSUER_P created');
  END IF;
END;
/

--
-- TABLE: CPAF_NFE_QUEUE_ISSUER
--
BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_QUEUE_ISSUER') THEN
       dbms_output.put_line('      CPAF_NFE_QUEUE_ISSUER already exists');
  ELSE
        EXECUTE IMMEDIATE 'CREATE TABLE CPAF_NFE_QUEUE_ISSUER(
ORGANIZATION_ID             NUMBER(10, 0)           NOT NULL,
  RTL_LOC_ID              NUMBER(10, 0)           NOT NULL,
  WKSTN_ID                  NUMBER(10, 0)           NOT NULL,
  QUEUE_SEQ               NUMBER(10, 0)           NOT NULL, 
  NAME                    VARCHAR2(60 CHAR)  NULL,
  FANTASY_NAME              VARCHAR2(60 CHAR)  NULL,
  FEDERAL_TAX_ID              VARCHAR2(20 CHAR)  NULL,
  STATE_TAX_ID              VARCHAR2(20 CHAR)  NULL,
  CITY_TAX_ID              VARCHAR2(20 CHAR)  NULL,
  CRT                     VARCHAR2(1 CHAR)  NULL, 
  STREET_NAME                 VARCHAR2(60 CHAR)  NULL,
  STREET_NUM                  VARCHAR2(60 CHAR)  NULL,
  COMPLEMENTO                 VARCHAR2(60 CHAR)  NULL,
  NEIGHBORHOOD              VARCHAR2(60 CHAR)  NULL,
  CITY_CODE                 VARCHAR2(7 CHAR)  NULL,
  CITY                    VARCHAR2(60 CHAR)  NULL,
  STATE                   VARCHAR2(2 CHAR)  NULL,
  POSTAL_CODE                 VARCHAR2(8 CHAR)  NULL,
  COUNTRY_CODE              VARCHAR2(4 CHAR)  NULL,
  COUNTRY_NAME              VARCHAR2(60 CHAR)  NULL,
  TELEPHONE                 VARCHAR2(14 CHAR)  NULL,  
  CREATE_DATE           TIMESTAMP(6)      NULL,
    CREATE_USER_ID                VARCHAR2(30 CHAR)  NULL,
    UPDATE_DATE                   TIMESTAMP(6)      NULL,
    UPDATE_USER_ID                VARCHAR2(30 CHAR)  NULL,
    RECORD_STATE                  VARCHAR2(30 CHAR)  NULL,
    CONSTRAINT PK_CPAF_NFE_QUEUE_ISSUER PRIMARY KEY (ORGANIZATION_ID, RTL_LOC_ID, WKSTN_ID, QUEUE_SEQ)
    USING INDEX
TABLESPACE $(DbTblspace)_INDEX
)
TABLESPACE $(DbTblspace)_DATA'
;
        dbms_output.put_line('      CPAF_NFE_QUEUE_ISSUER created');

        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE_QUEUE_ISSUER TO posusers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE_QUEUE_ISSUER TO dbausers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
  END IF;
END;
/

BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_QUEUE_ISSUER_P') THEN
       dbms_output.put_line('     CPAF_NFE_QUEUE_ISSUER_P already exists');
  ELSE
        Create_Property_Table('CPAF_NFE_QUEUE_ISSUER');
        dbms_output.put_line('     CPAF_NFE_QUEUE_ISSUER_P created');
  END IF;
END;
/

--
-- TABLE: CPAF_NFE_DEST
--
BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_DEST') THEN
       dbms_output.put_line('      CPAF_NFE_DEST already exists');
  ELSE
        EXECUTE IMMEDIATE 'CREATE TABLE CPAF_NFE_DEST(
ORGANIZATION_ID             NUMBER(10, 0)           NOT NULL,
  RTL_LOC_ID              NUMBER(10, 0)           NOT NULL,
  ENVIRONMENT_ID              NUMBER(10, 0)           NOT NULL,
  TP_NF                 NUMBER(10, 0)           NOT NULL,
  SERIES_ID                 NUMBER(10, 0)           NOT NULL,
  NNF                 NUMBER(10, 0)           NOT NULL, 
  MODEL            VARCHAR2(2 CHAR)    NOT NULL,
  NAME                    VARCHAR2(60 CHAR)  NULL,
  FEDERAL_TAX_ID              VARCHAR2(20 CHAR)  NULL,
  STATE_TAX_ID              VARCHAR2(20 CHAR)  NULL,
  STREET_NAME                 VARCHAR2(60 CHAR)  NULL,
  STREET_NUM                  VARCHAR2(60 CHAR)  NULL,
  COMPLEMENTO                 VARCHAR2(60 CHAR)  NULL,
  NEIGHBORHOOD              VARCHAR2(60 CHAR)  NULL,
  CITY_CODE                 VARCHAR2(7 CHAR)  NULL,
  CITY                    VARCHAR2(60 CHAR)  NULL,
  STATE                   VARCHAR2(2 CHAR)  NULL,
  POSTAL_CODE                 VARCHAR2(8 CHAR)  NULL,
  COUNTRY_CODE              VARCHAR2(4 CHAR)  NULL,
  COUNTRY_NAME              VARCHAR2(60 CHAR)  NULL,
  TELEPHONE                 VARCHAR2(14 CHAR)  NULL,
  EMAIL                   VARCHAR2(60 CHAR)  NULL,  
  CREATE_DATE           TIMESTAMP(6)      NULL,
    CREATE_USER_ID                VARCHAR2(30 CHAR)  NULL,
    UPDATE_DATE                   TIMESTAMP(6)      NULL,
    UPDATE_USER_ID                VARCHAR2(30 CHAR)  NULL,
    RECORD_STATE                  VARCHAR2(30 CHAR)  NULL,
    CONSTRAINT PK_CPAF_NFE_DEST PRIMARY KEY (ORGANIZATION_ID, RTL_LOC_ID, ENVIRONMENT_ID, TP_NF, SERIES_ID, NNF, MODEL)
    USING INDEX
TABLESPACE $(DbTblspace)_INDEX
)
TABLESPACE $(DbTblspace)_DATA'
;
        dbms_output.put_line('      CPAF_NFE_DEST created');

        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE_DEST TO posusers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE_DEST TO dbausers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
  END IF;
END;
/

BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_DEST_P') THEN
       dbms_output.put_line('     CPAF_NFE_DEST_P already exists');
  ELSE
        Create_Property_Table('CPAF_NFE_DEST');
        dbms_output.put_line('     CPAF_NFE_DEST_P created');
  END IF;
END;
/

--
-- TABLE: CPAF_NFE_QUEUE_DEST
--
BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_QUEUE_DEST') THEN
       dbms_output.put_line('      CPAF_NFE_QUEUE_DEST already exists');
  ELSE
        EXECUTE IMMEDIATE 'CREATE TABLE CPAF_NFE_QUEUE_DEST(
ORGANIZATION_ID             NUMBER(10, 0)           NOT NULL,
  RTL_LOC_ID              NUMBER(10, 0)           NOT NULL,
  WKSTN_ID              NUMBER(10, 0)           NOT NULL,
  QUEUE_SEQ                 NUMBER(10, 0)           NOT NULL, 
  NAME                    VARCHAR2(60 CHAR)  NULL,
  FEDERAL_TAX_ID              VARCHAR2(20 CHAR)  NULL,
  STATE_TAX_ID              VARCHAR2(20 CHAR)  NULL,
  STREET_NAME                 VARCHAR2(60 CHAR)  NULL,
  STREET_NUM                  VARCHAR2(60 CHAR)  NULL,
  COMPLEMENTO                 VARCHAR2(60 CHAR)  NULL,
  NEIGHBORHOOD              VARCHAR2(60 CHAR)  NULL,
  CITY_CODE                 VARCHAR2(7 CHAR)  NULL,
  CITY                    VARCHAR2(60 CHAR)  NULL,
  STATE                   VARCHAR2(2 CHAR)  NULL,
  POSTAL_CODE                 VARCHAR2(8 CHAR)  NULL,
  COUNTRY_CODE              VARCHAR2(4 CHAR)  NULL,
  COUNTRY_NAME              VARCHAR2(60 CHAR)  NULL,
  TELEPHONE                 VARCHAR2(14 CHAR)  NULL,
  EMAIL                   VARCHAR2(60 CHAR)  NULL,   
  CREATE_DATE           TIMESTAMP(6)      NULL,
    CREATE_USER_ID                VARCHAR2(30 CHAR)  NULL,
    UPDATE_DATE                   TIMESTAMP(6)      NULL,
    UPDATE_USER_ID                VARCHAR2(30 CHAR)  NULL,
    RECORD_STATE                  VARCHAR2(30 CHAR)  NULL,
    CONSTRAINT PK_CPAF_NFE_QUEUE_DEST PRIMARY KEY (ORGANIZATION_ID, RTL_LOC_ID, WKSTN_ID, QUEUE_SEQ)
    USING INDEX
TABLESPACE $(DbTblspace)_INDEX
)
TABLESPACE $(DbTblspace)_DATA'
;
        dbms_output.put_line('      CPAF_NFE_QUEUE_DEST created');

        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE_QUEUE_DEST TO posusers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE_QUEUE_DEST TO dbausers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
  END IF;
END;
/

BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_QUEUE_DEST_P') THEN
       dbms_output.put_line('     CPAF_NFE_QUEUE_DEST_P already exists');
  ELSE
        Create_Property_Table('CPAF_NFE_QUEUE_DEST');
        dbms_output.put_line('     CPAF_NFE_QUEUE_DEST_P created');
  END IF;
END;
/

--
-- TABLE: CPAF_NFE_TAX_CST
--
BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_TAX_CST') THEN
       dbms_output.put_line('      CPAF_NFE_TAX_CST already exists');
  ELSE
        EXECUTE IMMEDIATE 'CREATE TABLE CPAF_NFE_TAX_CST(
ORGANIZATION_ID               NUMBER(10, 0)  NOT NULL,
  TRANS_TYPCODE                 VARCHAR2(30 CHAR)  NOT NULL,
  TAX_LOC_ID                  VARCHAR2(60 CHAR)  NOT NULL,
  TAX_GROUP_ID                  VARCHAR2(120 CHAR) NOT NULL,
  TAX_AUTHORITY_ID              VARCHAR2(60 CHAR)  NOT NULL,
    CST                           VARCHAR2(2 CHAR)   NULL,
    CREATE_DATE           TIMESTAMP(6)   NULL,
    CREATE_USER_ID                VARCHAR2(30 CHAR)  NULL,
    UPDATE_DATE                   TIMESTAMP(6)   NULL,
    UPDATE_USER_ID                VARCHAR2(30 CHAR)  NULL,
    RECORD_STATE                  VARCHAR2(30 CHAR)  NULL,
    CONSTRAINT PK_CPAF_NFE_TAX_CST PRIMARY KEY (ORGANIZATION_ID, TRANS_TYPCODE, TAX_LOC_ID, TAX_GROUP_ID, TAX_AUTHORITY_ID)
    USING INDEX
TABLESPACE $(DbTblspace)_INDEX
)
TABLESPACE $(DbTblspace)_DATA'
;
        dbms_output.put_line('      CPAF_NFE_TAX_CST created');

        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE_TAX_CST TO posusers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFE_TAX_CST TO dbausers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
  END IF;
END;
/

BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE_TAX_CST_P') THEN
       dbms_output.put_line('     CPAF_NFE_TAX_CST_P already exists');
  ELSE
        Create_Property_Table('CPAF_NFE_TAX_CST');
        dbms_output.put_line('     CPAF_NFE_TAX_CST_P created');
  END IF;
END;
/

--
-- TABLE: CPAF_NFCE_QUEUE_TENDER
--
BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFCE_QUEUE_TENDER') THEN
       dbms_output.put_line('      CPAF_NFCE_QUEUE_TENDER already exists');
  ELSE
        EXECUTE IMMEDIATE 'CREATE TABLE CPAF_NFCE_QUEUE_TENDER(
ORGANIZATION_ID               NUMBER(10, 0)           NOT NULL,
  RTL_LOC_ID                    NUMBER(10, 0)           NOT NULL,
  WKSTN_ID                      NUMBER(10, 0)           NOT NULL,  
  QUEUE_SEQ                     NUMBER(10, 0)           NOT NULL,
  SEQUENCE                      NUMBER(10, 0)           NOT NULL,
  TNDR_ID                     VARCHAR2(60 CHAR)       NOT NULL,
  FISCAL_TENDER_ID              VARCHAR2(60 CHAR)       NOT NULL,
  AMOUNT                      NUMBER(17,6)   NULL,
  CARD_NETWORK_ID         VARCHAR2(30 CHAR) NULL,
  CARD_TAX_ID             VARCHAR2(30 CHAR) NULL,
  CARD_AUTH_NUMBER        VARCHAR2(254 CHAR) NULL,
  CARD_TYPE               VARCHAR2(254 CHAR) NULL,
  CARD_TRACE_NUMBER       VARCHAR2(254 CHAR) NULL,
  CARD_INTEGRATION_MODE   VARCHAR2(30 CHAR) NULL,
  CARD_INSTALLMENTS       NUMBER(10, 0) DEFAULT 0,   
    CREATE_DATE           TIMESTAMP(6)   NULL,
    CREATE_USER_ID                VARCHAR2(30 CHAR)  NULL,
    UPDATE_DATE                   TIMESTAMP(6)   NULL,
    UPDATE_USER_ID                VARCHAR2(30 CHAR)  NULL,
    RECORD_STATE                  VARCHAR2(30 CHAR)  NULL,  
    CONSTRAINT PK_CPAF_NFCE_QUEUE_TENDER PRIMARY KEY (ORGANIZATION_ID, RTL_LOC_ID, WKSTN_ID, QUEUE_SEQ, SEQUENCE, TNDR_ID)
    USING INDEX
TABLESPACE $(DbTblspace)_INDEX
)
TABLESPACE $(DbTblspace)_DATA'
;
        dbms_output.put_line('      CPAF_NFCE_QUEUE_TENDER created');

        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFCE_QUEUE_TENDER TO posusers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFCE_QUEUE_TENDER TO dbausers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFCE_QUEUE_TENDER','CARD_INSTALLMENTS') THEN
        dbms_output.put_line('     CPAF_NFCE_QUEUE_TENDER.CARD_INSTALLMENTS already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFCE_QUEUE_TENDER ADD CARD_INSTALLMENTS NUMBER(10, 0) DEFAULT 0';
        dbms_output.put_line('     CPAF_NFCE_QUEUE_TENDER.CARD_INSTALLMENTS created');
  END IF;
END;

BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFCE_QUEUE_TENDER','CARD_NETWORK_ID') THEN
        dbms_output.put_line('     CPAF_NFCE_QUEUE_TENDER.CARD_NETWORK_ID already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFCE_QUEUE_TENDER ADD CARD_NETWORK_ID VARCHAR2(30 CHAR)';
        dbms_output.put_line('     CPAF_NFCE_QUEUE_TENDER.CARD_NETWORK_ID created');
  END IF;
END;

BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFCE_QUEUE_TENDER','CARD_TAX_ID') THEN
        dbms_output.put_line('     CPAF_NFCE_QUEUE_TENDER.CARD_TAX_ID already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFCE_QUEUE_TENDER ADD CARD_TAX_ID VARCHAR2(30 CHAR)';
        dbms_output.put_line('     CPAF_NFCE_QUEUE_TENDER.CARD_TAX_ID created');
  END IF;
END;

BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFCE_QUEUE_TENDER','CARD_AUTH_NUMBER') THEN
        dbms_output.put_line('     CPAF_NFCE_QUEUE_TENDER.CARD_AUTH_NUMBER already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFCE_QUEUE_TENDER ADD CARD_AUTH_NUMBER VARCHAR2(254 CHAR)';
        dbms_output.put_line('     CPAF_NFCE_QUEUE_TENDER.CARD_AUTH_NUMBER created');
  END IF;
END;

BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFCE_QUEUE_TENDER','CARD_TYPE') THEN
        dbms_output.put_line('     CPAF_NFCE_QUEUE_TENDER.CARD_TYPE already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFCE_QUEUE_TENDER ADD CARD_TYPE VARCHAR2(254 CHAR)';
        dbms_output.put_line('     CPAF_NFCE_QUEUE_TENDER.CARD_TYPE created');
  END IF;
END;

BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFCE_QUEUE_TENDER','CARD_TRACE_NUMBER') THEN
        dbms_output.put_line('     CPAF_NFCE_QUEUE_TENDER.CARD_TRACE_NUMBER already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFCE_QUEUE_TENDER ADD CARD_TRACE_NUMBER VARCHAR2(254 CHAR)';
        dbms_output.put_line('     CPAF_NFCE_QUEUE_TENDER.CARD_TRACE_NUMBER created');
  END IF;
END;

BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFCE_QUEUE_TENDER','CARD_INTEGRATION_MODE') THEN
        dbms_output.put_line('     CPAF_NFCE_QUEUE_TENDER.CARD_INTEGRATION_MODE already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFCE_QUEUE_TENDER ADD CARD_INTEGRATION_MODE VARCHAR2(30 CHAR)';
        dbms_output.put_line('     CPAF_NFCE_QUEUE_TENDER.CARD_INTEGRATION_MODE created');
  END IF;
END;
/

BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFCE_QUEUE_TENDER_P') THEN
       dbms_output.put_line('     CPAF_NFCE_QUEUE_TENDER_P already exists');
  ELSE
        Create_Property_Table('CPAF_NFCE_QUEUE_TENDER');
        dbms_output.put_line('     CPAF_NFCE_QUEUE_TENDER_P created');
  END IF;
END;
/

--
-- TABLE: CPAF_NFCE_TENDER
--
BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFCE_TENDER') THEN
       dbms_output.put_line('      CPAF_NFCE_TENDER already exists');
  ELSE
        EXECUTE IMMEDIATE 'CREATE TABLE CPAF_NFCE_TENDER(
ORGANIZATION_ID              NUMBER(10, 0)   NOT NULL,
  RTL_LOC_ID                   NUMBER(10, 0)   NOT NULL,  
  ENVIRONMENT_ID               NUMBER(10, 0)   NOT NULL,
  TP_NF                        NUMBER(10, 0)   NOT NULL,
  SERIES_ID                    NUMBER(10, 0)   NOT NULL,
  NNF                          NUMBER(10, 0)   NOT NULL,
  MODEL            VARCHAR2(2 CHAR)    NOT NULL,
  SEQUENCE                     NUMBER(10, 0)   NOT NULL,
  TNDR_ID                     VARCHAR2(60 CHAR)       NOT NULL,
  FISCAL_TENDER_ID              VARCHAR2(60 CHAR)       NOT NULL,
  AMOUNT                      NUMBER(17,6)   NULL, 
  CARD_NETWORK_ID         VARCHAR2(30 CHAR) NULL,
  CARD_TAX_ID             VARCHAR2(30 CHAR) NULL,
  CARD_AUTH_NUMBER        VARCHAR2(254 CHAR) NULL,
  CARD_TYPE               VARCHAR2(254 CHAR) NULL,
  CARD_TRACE_NUMBER       VARCHAR2(254 CHAR) NULL,
  CARD_INTEGRATION_MODE   VARCHAR2(30 CHAR) NULL,  
  CARD_INSTALLMENTS       NUMBER(10, 0)   DEFAULT 0,
    CREATE_DATE           TIMESTAMP(6)   NULL,
    CREATE_USER_ID                VARCHAR2(30 CHAR)  NULL,
    UPDATE_DATE                   TIMESTAMP(6)   NULL,
    UPDATE_USER_ID                VARCHAR2(30 CHAR)  NULL,
    RECORD_STATE                  VARCHAR2(30 CHAR)  NULL,  
    CONSTRAINT PK_CPAF_NFCE_TENDER PRIMARY KEY (ORGANIZATION_ID, RTL_LOC_ID, ENVIRONMENT_ID, TP_NF, SERIES_ID, NNF, MODEL, SEQUENCE, TNDR_ID)
    USING INDEX
TABLESPACE $(DbTblspace)_INDEX
)
TABLESPACE $(DbTblspace)_DATA'
;
        dbms_output.put_line('      CPAF_NFCE_TENDER created');

        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFCE_TENDER TO posusers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_NFCE_TENDER TO dbausers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFCE_TENDER','CARD_INSTALLMENTS') THEN
        dbms_output.put_line('     CPAF_NFCE_TENDER.CARD_INSTALLMENTS already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFCE_TENDER ADD CARD_INSTALLMENTS NUMBER(10, 0) DEFAULT 0';
        dbms_output.put_line('     CPAF_NFCE_TENDER.CARD_INSTALLMENTS created');
  END IF;
END;

BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFCE_TENDER','CARD_NETWORK_ID') THEN
        dbms_output.put_line('     CPAF_NFCE_TENDER.CARD_NETWORK_ID already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFCE_TENDER ADD CARD_NETWORK_ID VARCHAR2(30 CHAR)';
        dbms_output.put_line('     CPAF_NFCE_TENDER.CARD_NETWORK_ID created');
  END IF;
END;

BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFCE_TENDER','CARD_TAX_ID') THEN
        dbms_output.put_line('     CPAF_NFCE_TENDER.CARD_TAX_ID already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFCE_TENDER ADD CARD_TAX_ID VARCHAR2(30 CHAR)';
        dbms_output.put_line('     CPAF_NFCE_TENDER.CARD_TAX_ID created');
  END IF;
END;

BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFCE_TENDER','CARD_AUTH_NUMBER') THEN
        dbms_output.put_line('     CPAF_NFCE_TENDER.CARD_AUTH_NUMBER already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFCE_TENDER ADD CARD_AUTH_NUMBER VARCHAR2(254 CHAR)';
        dbms_output.put_line('     CPAF_NFCE_TENDER.CARD_AUTH_NUMBER created');
  END IF;
END;

BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFCE_TENDER','CARD_TYPE') THEN
        dbms_output.put_line('     CPAF_NFCE_TENDER.CARD_TYPE already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFCE_TENDER ADD CARD_TYPE VARCHAR2(254 CHAR)';
        dbms_output.put_line('     CPAF_NFCE_TENDER.CARD_TYPE created');
  END IF;
END;

BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFCE_TENDER','CARD_TRACE_NUMBER') THEN
        dbms_output.put_line('     CPAF_NFCE_TENDER.CARD_TRACE_NUMBER already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFCE_TENDER ADD CARD_TRACE_NUMBER VARCHAR2(254 CHAR)';
        dbms_output.put_line('     CPAF_NFCE_TENDER.CARD_TRACE_NUMBER created');
  END IF;
END;

BEGIN
  IF SP_COLUMN_EXISTS( 'CPAF_NFCE_TENDER','CARD_INTEGRATION_MODE') THEN
        dbms_output.put_line('     CPAF_NFCE_TENDER.CARD_INTEGRATION_MODE already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE CPAF_NFCE_TENDER ADD CARD_INTEGRATION_MODE VARCHAR2(30 CHAR)';
        dbms_output.put_line('     CPAF_NFCE_TENDER.CARD_INTEGRATION_MODE created');
  END IF;
END;
/

BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFCE_TENDER_P') THEN
       dbms_output.put_line('     CPAF_NFCE_TENDER_P already exists');
  ELSE
        Create_Property_Table('CPAF_NFCE_TENDER');
        dbms_output.put_line('     CPAF_NFCE_TENDER_P created');
  END IF;
END;
/

--
-- TABLE: CPAF_SAT_RESPONSE
--
BEGIN
  IF SP_TABLE_EXISTS ('CPAF_SAT_RESPONSE') THEN
       dbms_output.put_line('      CPAF_SAT_RESPONSE already exists');
  ELSE
        EXECUTE IMMEDIATE 'CREATE TABLE CPAF_SAT_RESPONSE(
ORGANIZATION_ID           NUMBER(10, 0)   NOT NULL,
    RTL_LOC_ID                  NUMBER(10, 0)   NOT NULL,
    WKSTN_ID                    NUMBER(10, 0)   NOT NULL,
    QUEUE_SEQ                 NUMBER(10, 0)   NOT NULL,
    SESSION_ID                NUMBER(10, 0)   NOT NULL,
    CODE_SATE                 VARCHAR2(32 CHAR)   NULL,
    MESSAGE_SATE              VARCHAR2(254 CHAR)  NULL,
    CODE_ALERT                VARCHAR2(32 CHAR)   NULL,
    MESSAGE_ALERT             VARCHAR2(254 CHAR)  NULL,
    XML_STRING                NCLOB       NULL,
    TIME_STAMP                TIMESTAMP(6)    NULL,
    CHAVE                     VARCHAR2(254 CHAR)  NULL,
    TOTAL_AMOUNT              NUMBER(17,6)  NULL,
    CPF_CNPJ_VALUE            VARCHAR2(32 CHAR)   NULL,
    SIGNATURE_QR_CODE         VARCHAR2(2000 CHAR) NULL,
    SUCCESS                   NUMBER(1, 0)    NULL,
    TIMEOUT                   NUMBER(1, 0)    NULL,
    CREATE_DATE         TIMESTAMP(6)    NULL,
  CREATE_USER_ID              VARCHAR2(30 CHAR)   NULL,
  UPDATE_DATE                 TIMESTAMP(6)    NULL,
  UPDATE_USER_ID              VARCHAR2(30 CHAR)   NULL,
  RECORD_STATE                VARCHAR2(30 CHAR)   NULL,
    CONSTRAINT PK_CPAF_SAT_RESPONSE PRIMARY KEY (ORGANIZATION_ID, RTL_LOC_ID, WKSTN_ID, QUEUE_SEQ, SESSION_ID)
    USING INDEX
TABLESPACE $(DbTblspace)_INDEX
)
TABLESPACE $(DbTblspace)_DATA'
;
        dbms_output.put_line('      CPAF_SAT_RESPONSE created');

        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_SAT_RESPONSE TO posusers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON CPAF_SAT_RESPONSE TO dbausers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
  END IF;
END;
/

BEGIN
  IF SP_TABLE_EXISTS ('CPAF_SAT_RESPONSE_P') THEN
       dbms_output.put_line('     CPAF_SAT_RESPONSE_P already exists');
  ELSE
        Create_Property_Table('CPAF_SAT_RESPONSE');
        dbms_output.put_line('     CPAF_SAT_RESPONSE_P created');
  END IF;
END;
/

--[RXPS-16698]

--[RXPS-21357]
BEGIN
  IF SP_COLUMN_EXISTS( 'xom_item_mod','image_url') THEN
        dbms_output.put_line('     xom_item_mod.image_url already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE xom_item_mod ADD image_url VARCHAR2(254 CHAR)';
        dbms_output.put_line('     xom_item_mod.image_url created');
  END IF;
END;
/
--[/RXPS-21357]

--[/RXPS-19582]
BEGIN
  IF SP_COLUMN_EXISTS( 'trl_sale_tax_lineitm','orig_tax_amount') THEN
    EXECUTE IMMEDIATE 'ALTER TABLE trl_sale_tax_lineitm DROP COLUMN orig_tax_amount';
    dbms_output.put_line('     trl_sale_tax_lineitm.orig_tax_amount created');
  END IF;
END;
/
BEGIN
  IF SP_COLUMN_EXISTS( 'trl_sale_tax_lineitm','orig_taxable_amount') THEN
        dbms_output.put_line('     trl_sale_tax_lineitm.orig_taxable_amount already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE trl_sale_tax_lineitm ADD orig_taxable_amount NUMBER(17,6)';
        dbms_output.put_line('     trl_sale_tax_lineitm.orig_taxable_amount created');
  END IF;
END;
/
BEGIN
  IF SP_COLUMN_EXISTS( 'trl_sale_tax_lineitm','orig_tax_group_id ') THEN
        dbms_output.put_line('     trl_sale_tax_lineitm.orig_tax_group_id  already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE trl_sale_tax_lineitm ADD orig_tax_group_id  VARCHAR2(60 CHAR)';
        dbms_output.put_line('     trl_sale_tax_lineitm.orig_tax_group_id  created');
  END IF;
END;
/
--[/RXPS-19582]

--[RXPS-21905]
BEGIN
  IF SP_COLUMN_EXISTS('tnd_tndr_options','assign_cash_drawer_req_flag')
        dbms_output.put_line('     tnd_tndr_options.assign_cash_drawer_req_flag already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE tnd_tndr_options ADD assign_cash_drawer_req_flag NUMBER(1, 0) DEFAULT 0';
        EXECUTE IMMEDIATE 'UPDATE tnd_tndr_options SET assign_cash_drawer_req_flag = 0';
        dbms_output.put_line('     tnd_tndr_options.assign_cash_drawer_req_flag created');
  END IF;
END;
/
BEGIN
  IF SP_COLUMN_EXISTS('tnd_tndr_options','post_void_assign_drawer_flag')
        dbms_output.put_line('     tnd_tndr_options.post_void_assign_drawer_flag already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE tnd_tndr_options ADD post_void_assign_drawer_flag NUMBER(1, 0) DEFAULT 0';
        EXECUTE IMMEDIATE 'UPDATE tnd_tndr_options SET post_void_assign_drawer_flag = 0';
        dbms_output.put_line('     tnd_tndr_options.post_void_assign_drawer_flag created');
  END IF;
END;
/
--[/RXPS-21905]

--[RXPS-20569]
DECLARE
  v_count       int;
BEGIN
  SELECT DECODE(COUNT(*),0,0,1) INTO v_count FROM crm_party_id_xref;
    
  IF v_count > 0 THEN
      DELETE FROM crm_party_id_xref
        WHERE alternate_id_owner='XSTORE_LEGACY';
        
      INSERT INTO crm_party_id_xref(organization_id, party_id, alternate_id_owner, alternate_id, create_date, create_user_id)
        SELECT t1.organization_id, t1.party_id, 'XSTORE_LEGACY', t1.cust_id, getDate(), t1.create_user_id
        FROM crm_party t1, crm_party_id_xref t2
        WHERE t1.party_id=t2.party_id AND t2.alternate_id_owner='RELATE';
    
      EXECUTE IMMEDIATE 'UPDATE crm_party t1
        SET cust_id = (SELECT t2.alternate_id
          FROM crm_party_id_xref t2
          WHERE t1.party_id=t2.party_id AND t2.alternate_id_owner=''RELATE''), update_date=getDate()
        WHERE EXISTS(
        SELECT 1
          FROM crm_party_id_xref t2
          WHERE t2.party_id=t1.party_id AND t2.alternate_id_owner=''RELATE'')';
  END IF;
END;
/
--[/RXPS-20569]

--[RXPS-23870]
DECLARE
  sqlfields VARCHAR2(1000);
  sqlstatement VARCHAR2(2000);
BEGIN
    FOR tabledata IN (
        SELECT 
        -- just the table name
        outercons.table_name,
        -- build a string of upper set statements
        (SELECT
          LISTAGG('i.' || allcols.column_name || ' = UPPER(i.' || allcols.column_name || ')', ', ') WITHIN GROUP (ORDER BY allcols.column_name) 
         FROM 
           all_tab_columns allcols,
           all_cons_columns cols
         WHERE 
           outercons.constraint_name = cols.constraint_name AND
           outercons.owner = cols.owner AND
           cols.owner = allcols.owner AND
           cols.table_name = allcols.table_name AND
           cols.column_name = allcols.column_name AND
           allcols.data_type LIKE 'VARCHAR%') as set_char_cols_upper,
        -- build a string of non-char columns
        (SELECT
           LISTAGG('i2.' || allcols.column_name, ', ') WITHIN GROUP (ORDER BY allcols.column_name)
         FROM 
           all_tab_columns allcols,
           all_cons_columns cols
         WHERE 
           outercons.constraint_name = cols.constraint_name AND
           outercons.owner = cols.owner AND
           cols.owner = allcols.owner AND
           cols.table_name = allcols.table_name AND
           cols.column_name = allcols.column_name AND
           allcols.data_type NOT LIKE 'VARCHAR%') AS nonchar_cols,
        -- build a string of char columns wrapped in upper
        (SELECT
           LISTAGG('UPPER(i2.' || allcols.column_name || ')', ', ') WITHIN GROUP (ORDER BY allcols.column_name)
         FROM 
           all_tab_columns allcols,
           all_cons_columns cols
         WHERE 
           outercons.constraint_name = cols.constraint_name AND
           outercons.owner = cols.owner AND
           cols.owner = allcols.owner AND
           cols.table_name = allcols.table_name AND
           cols.column_name = allcols.column_name AND
           allcols.data_type LIKE 'VARCHAR%') AS char_cols_upper,
        -- build a string of equals comparisons for all key columns
        (SELECT
           LISTAGG('i.' || cols.column_name || ' = i2.' || cols.column_name, ' AND ') WITHIN GROUP (ORDER BY cols.column_name)
         FROM 
           all_cons_columns cols
         WHERE 
           outercons.constraint_name = cols.constraint_name AND
           outercons.owner = cols.owner) AS all_cols_equals              
      FROM
        all_constraints outercons
      WHERE 
        outercons.owner = USER AND
        outercons.constraint_type = 'P' AND
        EXISTS 
          (SELECT 
             * 
           FROM all_tab_columns outerallcols,
             all_cons_columns outercols
          WHERE
            outercons.constraint_name = outercols.constraint_name AND
            outercons.owner = outercols.owner AND
            outerallcols.owner = outercols.owner AND
            outerallcols.table_name = outercols.table_name AND
            outerallcols.column_name = outercols.column_name AND
            outerallcols.data_type LIKE 'VARCHAR%')
    )
  LOOP
    sqlfields := CASE WHEN tabledata.nonchar_cols IS NOT NULL THEN tabledata.nonchar_cols ELSE '' END || CASE WHEN tabledata.nonchar_cols IS NOT NULL THEN ', ' ELSE '' END || tabledata.char_cols_upper;
    sqlstatement := 'UPDATE ' || tabledata.table_name || ' i SET ' || tabledata.set_char_cols_upper || ' WHERE EXISTS (SELECT ' || sqlfields || ', COUNT(*) FROM ' || tabledata.table_name || ' i2 WHERE ' || tabledata.all_cols_equals || ' GROUP BY ' || sqlfields || ' HAVING COUNT(*) < 2)';
  
    EXECUTE IMMEDIATE '' || sqlstatement;
    dbms_output.put_line('Updated character keys on: ' || tabledata.table_name);
commit;  
  END LOOP;
END;
/

BEGIN
  FOR i IN (SELECT null FROM user_triggers WHERE trigger_name = UPPER('$(DbUser)_TRIGGER')) LOOP
    EXECUTE IMMEDIATE 'drop trigger trigger UPPER(''$(DbUser)_TRIGGER'')';
  END LOOP;
END;
/

--[/RXPS-23870]

--[RXPS-24193]
DECLARE
  v_count       int;
BEGIN
  SELECT char_length INTO v_count FROM dba_tab_columns WHERE table_name = UPPER('trl_voucher_sale_lineitm') AND column_name=UPPER('orig_stan') AND OWNER=UPPER('$(DbSchema)');
  IF v_count=12 THEN
    EXECUTE IMMEDIATE 'ALTER TABLE trl_voucher_sale_lineitm MODIFY orig_stan VARCHAR2(30 char)';
    dbms_output.put_line('     trl_voucher_sale_lineitm.orig_stan column size increased');
  END IF;
END;
/

DECLARE
  v_count       int;
BEGIN
  SELECT char_length INTO v_count FROM dba_tab_columns WHERE table_name = UPPER('ttr_credit_debit_tndr_lineitm') AND column_name=UPPER('orig_stan') AND OWNER=UPPER('$(DbSchema)');
  IF v_count=12 THEN
    EXECUTE IMMEDIATE 'ALTER TABLE ttr_credit_debit_tndr_lineitm MODIFY orig_stan VARCHAR2(30 char)';
    dbms_output.put_line('     ttr_credit_debit_tndr_lineitm.orig_stan column size increased');
  END IF;
END;
/

DECLARE
  v_count       int;
BEGIN
  SELECT char_length INTO v_count FROM dba_tab_columns WHERE table_name = UPPER('ttr_voucher_tndr_lineitm') AND column_name=UPPER('orig_stan') AND OWNER=UPPER('$(DbSchema)');
  IF v_count=12 THEN
    EXECUTE IMMEDIATE 'ALTER TABLE ttr_voucher_tndr_lineitm MODIFY orig_stan VARCHAR2(30 char)';
    dbms_output.put_line('     ttr_voucher_tndr_lineitm.orig_stan column size increased');
  END IF;
END;
/
--[/RXPS-24193]

-- Keep at end of the script
drop procedure Create_Property_Table;

commit;
--SPOOL OFF;
-- LEAVE BLANK LINE BELOW