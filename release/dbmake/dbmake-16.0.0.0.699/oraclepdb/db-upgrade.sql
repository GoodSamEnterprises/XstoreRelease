SET SERVEROUTPUT ON SIZE 40000

SPOOL dbupdate.log;

-- ***************************************************************************
-- This script will upgrade a database from version <source> of the Xstore base schema to version
-- <target>.  If upgrading from a schema version earlier than <source>, multiple upgrade scripts may
-- have to be applied in ascending order by <target>.
--
-- This script should only be run against a database previously created and defined by platform-
-- and version-compatible "create" and "define" scripts.
--
-- For certain supported platforms, this script may be run repeatedly against a target compatible
-- database, including an already upgraded one, without error or data loss.  Please consult the 
-- Xstore R&D group for a listing of officially supported platforms for which this convenience is
-- provided.
--
-- Source version:  15.0.x
-- Target version:  16.0.0
-- DB platform:     Oracle 10g/11g/12c
-- ***************************************************************************
-- ***************************************************************************
-- ***************************************************************************
-- 15.0.x -> 16.0.0
-- ***************************************************************************
-- ***************************************************************************
alter session set current_schema=$(DbSchema);
BEGIN dbms_output.put_line('--- CREATING sp_column_exists --- '); END;
/
CREATE OR REPLACE function sp_column_exists (
 table_name     varchar2,
 column_name    varchar2
) return boolean is

 v_count integer;
 v_exists boolean;

begin

select decode(count(*),0,0,1) into v_count 
    from all_tab_columns
    where owner = upper('$(DbSchema)')
      and table_name = upper(sp_column_exists.table_name)
      and column_name = upper(sp_column_exists.column_name);

 if v_count = 1 then
   v_exists := true;
 else
   v_exists := false;
 end if;

 return v_exists;

end sp_column_exists;
/

BEGIN dbms_output.put_line('--- CREATING sp_table_exists --- '); END;
/
CREATE OR REPLACE function sp_table_exists (
  table_name varchar2
) return boolean is

  v_count integer;
  v_exists boolean;

begin

  select decode(count(*),0,0,1) into v_count 
    from all_tables 
    where owner = upper('$(DbSchema)')
      and table_name = upper(sp_table_exists.table_name);

  if v_count = 1 then
    v_exists := true;
  else
    v_exists := false;
  end if;

  return v_exists;

end sp_table_exists;
/

CREATE OR REPLACE PROCEDURE Create_Property_Table 
    -- Add the parameters for the stored procedure here
    (vtableName varchar2)
IS
    vsql varchar2(32000);
    vcolumns varchar2(32000);
    vpk varchar2(32000);
    vcnt number(10);

CURSOR mycur IS 
    SELECT col.column_name,data_type,char_length,data_precision,data_scale,data_default FROM ALL_CONSTRAINTS CONS, ALL_CONS_COLUMNS COLS,all_tab_columns col
    WHERE COLS.TABLE_NAME = vtableName AND CONS.CONSTRAINT_TYPE = 'P' AND CONS.CONSTRAINT_NAME = COLS.CONSTRAINT_NAME
    AND CONS.OWNER = COLS.OWNER and COLS.OWNER=COL.OWNER and COLS.TABLE_NAME=COL.TABLE_NAME and COLS.COLUMN_NAME=COL.COLUMN_NAME
    order by position;
BEGIN
    SELECT count(*) into vcnt FROM ALL_CONSTRAINTS CONS, ALL_CONS_COLUMNS COLS
    WHERE COLS.TABLE_NAME = vtableName AND CONS.CONSTRAINT_TYPE = 'P' AND CONS.CONSTRAINT_NAME = COLS.CONSTRAINT_NAME AND COLS.COLUMN_NAME='ORGANIZATION_ID';

    vpk := '';
    vsql := 'CREATE TABLE ' || vtableName || '_p ( ';
    vcolumns := '';

    IF SP_TABLE_EXISTS (vtableName || '_p') = true or SP_TABLE_EXISTS (vtableName) = false or upper(substr(vtableName,-2))='_P' or vcnt=0 then
        return;
    end if;

    FOR myval IN mycur
    LOOP
    
        vpk := vpk || myval.column_name || ',';

        vcolumns := vcolumns || myval.column_name || ' ' || myval.data_type;

        if myval.data_type LIKE '%CHAR%' then
            vcolumns := vcolumns || '(' || myval.char_length || ' char)';
        elsif myval.data_type='NUMBER' then
            vcolumns := vcolumns || '(' || myval.data_precision || ',' || myval.data_scale || ')';
        end if;

    if LENGTH(myval.data_default)>0 then
      vcolumns := vcolumns || ' DEFAULT ' || myval.data_default;
        end if;
        
        vcolumns := vcolumns || ' NOT NULL,';
    END LOOP;
--    close mycur;

    if LENGTH(vtableName) > 25 then
        vpk :=  'CONSTRAINT ' || 'pk' || REPLACE(vtableName,'_','') || 'p' || ' PRIMARY KEY (' || vpk || 'property_code) ';
    else
        vpk := 'CONSTRAINT pk_' || vtableName || '_p PRIMARY KEY (' || vpk || 'property_code)';
    end if;     
       
    vpk := vpk ||  '
    USING INDEX
TABLESPACE $(DbTblspace)_INDEX
)
TABLESPACE $(DbTblspace)_DATA
';


   EXECUTE IMMEDIATE vsql || vcolumns || 'property_code varchar2(30 char) NOT NULL,type varchar2(30 char),string_value varchar2(4000 char),date_value TIMESTAMP(6),decimal_value number(17,6),create_date TIMESTAMP(6),create_user_id varchar2(30 char),update_date TIMESTAMP(6),update_user_id varchar2(30 char),record_state varchar2(30 char),' || vpk;
   EXECUTE IMMEDIATE   'GRANT SELECT,INSERT,UPDATE,DELETE ON ' || vtableName || '_p' || ' TO posusers';
   EXECUTE IMMEDIATE   'GRANT SELECT,INSERT,UPDATE,DELETE ON ' || vtableName || '_p' || ' TO dbausers';
   
END;
/

PROMPT '**************************************';
PROMPT '* UPGRADE to release 16.0';
PROMPT '**************************************';
/

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
        Create_Property_Table('ITM_ITEM_RESTRICT_MAPPING');
        dbms_output.put_line('     itm_item_restrict_mapping_p created');
  END IF;
END;
/

BEGIN
  IF SP_TABLE_EXISTS ('com_button_grid_p') THEN
       dbms_output.put_line('     com_button_grid_p already exists');
  ELSE
        Create_Property_Table('COM_BUTTON_GRID');
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
       Create_Property_Table('COM_AIRPORT');
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

BEGIN
  IF SP_COLUMN_EXISTS('TRL_RTRANS_FLIGHT_INFO','FIRST_FLIGHT_SEAT_NUMBER') THEN
        dbms_output.put_line('     TRL_RTRANS_FLIGHT_INFO.FIRST_FLIGHT_SEAT_NUMBER already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE TRL_RTRANS_FLIGHT_INFO ADD FIRST_FLIGHT_SEAT_NUMBER VARCHAR2(4 char)';
        dbms_output.put_line('     TRL_RTRANS_FLIGHT_INFO.FIRST_FLIGHT_SEAT_NUMBER created');
  END IF;
END;
/

BEGIN
  IF SP_COLUMN_EXISTS('TRL_RTRANS_FLIGHT_INFO','FIRST_FLIGHT_SCHEDULED_DATE') THEN
        dbms_output.put_line('     TRL_RTRANS_FLIGHT_INFO.FIRST_FLIGHT_SCHEDULED_DATE already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE TRL_RTRANS_FLIGHT_INFO ADD FIRST_FLIGHT_SCHEDULED_DATE TIMESTAMP(6)';
        dbms_output.put_line('     TRL_RTRANS_FLIGHT_INFO.FIRST_FLIGHT_SCHEDULED_DATE created');
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
--[/RXPS-17100]

--[/RXPS-17107]
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
-- TABLE: CPAF_CARD_NETWORK
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
    CREATE_DATE        TIMESTAMP(6),
    CREATE_USER_ID     VARCHAR2(30 CHAR),
    UPDATE_DATE        TIMESTAMP(6),
    UPDATE_USER_ID     VARCHAR2(30 CHAR),
    RECORD_STATE       VARCHAR2(30 CHAR),
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

--[RXPS-15284]
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

BEGIN 
  IF SP_TABLE_EXISTS ('civc_taxfree_country_p') THEN
       dbms_output.put_line('     civc_taxfree_country_p already exists');
  ELSE
        Create_Property_Table('CIVC_TAXFREE_COUNTRY');
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

BEGIN 
  IF SP_TABLE_EXISTS ('civc_taxfree_card_range_p') THEN
       dbms_output.put_line('     civc_taxfree_card_range_p already exists');
  ELSE
        Create_Property_Table('CIVC_TAXFREE_CARD_RANGE');
        dbms_output.put_line('     civc_taxfree_card_range_p created');
  END IF;
END;
/

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
        Create_Property_Table('CTL_IP_CASHDRAWER_DEVICE');
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


--[RXPS-16698]
--
-- TABLE: CPAF_NFE
--
BEGIN
  IF SP_TABLE_EXISTS ('CPAF_NFE') THEN
     dbms_output.put_line('      CPAF_NFE already exists');
  ELSE
      EXECUTE IMMEDIATE 'CREATE TABLE CPAF_NFE(
    ORGANIZATION_ID    NUMBER(10, 0)      NOT NULL,
    RTL_LOC_ID         NUMBER(10, 0)      NOT NULL,
    ENVIRONMENT_ID     NUMBER(10, 0)      NOT NULL,
    TP_NF              NUMBER(10, 0)      NOT NULL,
    SERIES_ID          NUMBER(10, 0)      NOT NULL,
    NNF                NUMBER(10, 0)      NOT NULL,
    MODEL              VARCHAR2(2 CHAR)   NOT NULL,
    CUF                NUMBER(10, 0)      NULL,
    CNF                NUMBER(10, 0)      NULL,
    TRANS_TYPCODE      VARCHAR2(30 CHAR)  NULL,
    NATOP              VARCHAR2(60 CHAR)  NULL,
    INDPAG             NUMBER(10, 0)      NULL,
    ISSUE_DATE         TIMESTAMP(6)       NULL,
    SAI_ENT_DATETIME   TIMESTAMP(6)       NULL,
    CMUN_FG            VARCHAR2(7 CHAR)   NULL,
    TP_IMP             NUMBER(10, 0)      NULL,
    TP_EMIS            NUMBER(10, 0)      NULL,
    FIN_NFE            NUMBER(10, 0)      NULL,
    PROC_EMI           NUMBER(10, 0)      NULL,
    VER_PROC           VARCHAR2(20 CHAR)  NULL,
    CONT_DATETIME      TIMESTAMP(6)       NULL,
    CONT_XJUST         VARCHAR2(255 CHAR) NULL,
    PRODUCT_AMOUNT     NUMBER(17,6)       NULL,
    SERVICE_AMOUNT     NUMBER(17,6)       NULL,
    ICMS_BASIS         NUMBER(17,6)       NULL,
    ICMS_AMOUNT        NUMBER(17,6)       NULL,
    ICMS_ST_BASIS      NUMBER(17,6)       NULL,
    ICMS_ST_AMOUNT     NUMBER(17,6)       NULL,
    ISS_BASIS          NUMBER(17,6)       NULL,
    ISS_AMOUNT         NUMBER(17,6)       NULL,
    II_AMOUNT          NUMBER(17,6)       NULL,
    PIS_AMOUNT         NUMBER(17,6)       NULL,
    COFINS_AMOUNT      NUMBER(17,6)       NULL,
    ISS_PIS_AMOUNT     NUMBER(17,6)       NULL,
    ISS_COFINS_AMOUNT  NUMBER(17,6)       NULL,
    DISCOUNT_AMOUNT    NUMBER(17,6)       NULL,
    FREIGHT_AMOUNT     NUMBER(17,6)       NULL,
    INSURANCE_AMOUNT   NUMBER(17,6)       NULL,
    OTHER_AMOUNT       NUMBER(17,6)       NULL,
    TOTAL_AMOUNT       NUMBER(17,6)       NULL,
    INF_CPL            NCLOB              NULL,
    PROTOCOLO          VARCHAR2(30 CHAR)  NULL,
    CANC_PROTOCOLO     VARCHAR2(30 CHAR)  NULL,
    CHAVE_NFE          VARCHAR2(88 CHAR)  NULL,
    OLD_CHAVE_NFE      VARCHAR2(88 CHAR)  NULL,
    RECIBO             VARCHAR2(30 CHAR)  NULL,
    STAT_CODE          VARCHAR2(30 CHAR)  NULL,
    XML                NCLOB              NULL,
    DIG_VAL            VARCHAR2(30 CHAR)  NULL,
    ISS_SERVICE_DATE   VARCHAR2(10 CHAR)  NULL,
    CREATE_DATE        TIMESTAMP(6),
    CREATE_USER_ID     VARCHAR2(30 CHAR),
    UPDATE_DATE        TIMESTAMP(6),
    UPDATE_USER_ID     VARCHAR2(30 CHAR),
    RECORD_STATE       VARCHAR2(30 CHAR),
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
  ORGANIZATION_ID              NUMBER(10, 0)      NOT NULL,
  RTL_LOC_ID                   NUMBER(10, 0)      NOT NULL,
  ENVIRONMENT_ID               NUMBER(10, 0)      NOT NULL,
  TP_NF                        NUMBER(10, 0)      NOT NULL,
  SERIES_ID                    NUMBER(10, 0)      NOT NULL,
  NNF                          NUMBER(10, 0)      NOT NULL,
  MODEL                        VARCHAR2(2 CHAR)   NOT NULL,
  SEQUENCE                     NUMBER(10, 0)      NOT NULL,
  ITEM_ID                      VARCHAR2(60 CHAR)  NULL,
  ITEM_DESCRIPTION             VARCHAR2(254 CHAR) NULL,
  EAN                          VARCHAR2(14 CHAR)  NULL,
  NCM                          VARCHAR2(8 CHAR)   NULL,
  CEST                         VARCHAR2(18 CHAR)  NULL,
  EX_TIPI                      VARCHAR2(3 CHAR)   NULL,
  QUANTITY                     NUMBER(11,4)       NULL,
  UNIT_OF_MEASURE_CODE         VARCHAR2(30 CHAR)  NULL,
  TAXABLE_EAN                  VARCHAR2(14 CHAR)  NULL,
  TAXABLE_UNIT_OF_MEASURE_CODE VARCHAR2(30 CHAR)  NULL,
  IAT                          VARCHAR2(1 CHAR)   NULL,
  IPPT                         VARCHAR2(1 CHAR)   NULL,
  UNIT_PRICE                   NUMBER(17,6)       NULL,
  EXTENDED_AMOUNT              NUMBER(17,6)       NULL,
  TAXABLE_QUANTITY             NUMBER(11,4)       NULL,
  UNIT_TAXABLE_AMOUNT          NUMBER(17,6)       NULL,
  FREIGHT_AMOUNT               NUMBER(17,6)       NULL,
  INSURANCE_AMOUNT             NUMBER(17,6)       NULL,
  DISCOUNT_AMOUNT              NUMBER(17,6)       NULL,
  OTHER_AMOUNT                 NUMBER(17,6)       NULL,
  CFOP                         VARCHAR2(4 CHAR)   NULL,
  INF_AD_PROD                  VARCHAR2(500 CHAR) NULL,
  ICMS_CST                     VARCHAR2(3 CHAR)   NULL,
  ICMS_BASIS                   NUMBER(17,6)       NULL,
  ICMS_AMOUNT                  NUMBER(17,6)       NULL,
  ICMS_RATE                    NUMBER(5,2)        NULL,
  ICMS_ST_BASIS                NUMBER(17,6)       NULL,
  ICMS_ST_AMOUNT               NUMBER(17,6)       NULL,
  ICMS_ST_RATE                 NUMBER(5,2)        NULL,
  ISS_BASIS                    NUMBER(17,6)       NULL,
  ISS_AMOUNT                   NUMBER(17,6)       NULL,
  ISS_RATE                     NUMBER(5,2)        NULL,
  IPI_AMOUNT                   NUMBER(17,6)       NULL,
  IPI_RATE                     NUMBER(5,2)        NULL,
  II_AMOUNT                    NUMBER(17,6)       NULL,
  PIS_BASIS                    NUMBER(17,6)       NULL,
  PIS_AMOUNT                   NUMBER(17,6)       NULL,
  PIS_RATE                     NUMBER(17,6)       NULL,
  COFINS_BASIS                 NUMBER(17,6)       NULL,
  COFINS_AMOUNT                NUMBER(17,6)       NULL,
  COFINS_RATE                  NUMBER(17,6)       NULL,
  TAX_SITUATION_CODE           VARCHAR2(6 CHAR)   NULL,
  TAX_GROUP_ID                 VARCHAR2(120 CHAR) NULL,
  LOG_SEQUENCE                 NUMBER(10, 0)      NULL,
  REF_NFE                      VARCHAR2(88 CHAR)  NULL,
  IIS_CITY_CODE                VARCHAR2(7 CHAR)   NULL,
  IIS_SERVICE_CODE             VARCHAR2(5 CHAR)   NULL,
  IIS_ELIGIBLE_INDICATOR       VARCHAR2(2 CHAR)   NULL,
  IIS_INCENTIVE_INDICATOR      VARCHAR2(1 CHAR)   NULL,
  CREATE_DATE                  TIMESTAMP(6),
  CREATE_USER_ID               VARCHAR2(30 CHAR),
  UPDATE_DATE                  TIMESTAMP(6),
  UPDATE_USER_ID               VARCHAR2(30 CHAR),
  RECORD_STATE                 VARCHAR2(30 CHAR),
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
    ORGANIZATION_ID   NUMBER(10, 0)           NOT NULL,
    RTL_LOC_ID        NUMBER(10, 0)           NOT NULL,
    WKSTN_ID          NUMBER(10, 0)           NOT NULL,
    QUEUE_SEQ         NUMBER(10, 0)           NOT NULL,
    ENVIRONMENT_ID    NUMBER(10, 0)           NULL,
    TP_NF             NUMBER(10, 0)           NULL,
    SERIES_ID         NUMBER(10, 0)           NULL,
    NNF               NUMBER(10, 0)           NULL,
    CUF               NUMBER(10, 0)           NULL,
    CNF               NUMBER(10, 0)           NULL,
    USAGE_TYPE        VARCHAR2(30 CHAR)       NULL,
    TRANS_TYPCODE     VARCHAR2(30 CHAR)       NULL,
    NATOP             VARCHAR2(60 CHAR)       NULL,
    INDPAG            NUMBER(10, 0)           NULL,
    MODEL             VARCHAR2(2 CHAR)        NULL,
    ISSUE_DATE        TIMESTAMP(6)            NULL,
    SAI_ENT_DATETIME  TIMESTAMP(6)            NULL,
    CMUN_FG           VARCHAR2(7 CHAR)        NULL,
    TP_IMP            NUMBER(10, 0)           NULL,
    TP_EMIS           NUMBER(10, 0)           NULL,
    FIN_NFE           NUMBER(10, 0)           NULL,
    PROC_EMI          NUMBER(10, 0)           NULL,
    VER_PROC          VARCHAR2(20 CHAR)       NULL,
    CONT_DATETIME     TIMESTAMP(6)            NULL,
    CONT_XJUST        VARCHAR2(255 CHAR)      NULL,
    PRODUCT_AMOUNT    NUMBER(17,6)            NULL,
    SERVICE_AMOUNT    NUMBER(17,6)            NULL,
    ICMS_BASIS        NUMBER(17,6)            NULL,
    ICMS_AMOUNT       NUMBER(17,6)            NULL,
    ICMS_ST_BASIS     NUMBER(17,6)            NULL,
    ICMS_ST_AMOUNT    NUMBER(17,6)            NULL,
    ISS_BASIS         NUMBER(17,6)            NULL,
    ISS_AMOUNT        NUMBER(17,6)            NULL,
    II_AMOUNT         NUMBER(17,6)            NULL,
    PIS_AMOUNT        NUMBER(17,6)            NULL,
    COFINS_AMOUNT     NUMBER(17,6)            NULL,
    ISS_PIS_AMOUNT    NUMBER(17,6)            NULL,
    ISS_COFINS_AMOUNT NUMBER(17,6)            NULL,
    DISCOUNT_AMOUNT   NUMBER(17,6)            NULL,
    FREIGHT_AMOUNT    NUMBER(17,6)            NULL,
    INSURANCE_AMOUNT  NUMBER(17,6)            NULL,
    OTHER_AMOUNT      NUMBER(17,6)            NULL,
    TOTAL_AMOUNT      NUMBER(17,6)            NULL,
    INF_CPL           NCLOB                   NULL,
    PROTOCOLO         VARCHAR2(30 CHAR)       NULL,
    CANC_PROTOCOLO    VARCHAR2(30 CHAR)       NULL,
    CHAVE_NFE         VARCHAR2(88 CHAR)       NULL,
    OLD_CHAVE_NFE     VARCHAR2(88 CHAR)       NULL,
    RECIBO            VARCHAR2(30 CHAR)       NULL,
    STAT_CODE         VARCHAR2(30 CHAR)       NULL,
    XML               NCLOB                   NULL,
    RESPONSE_CODE     VARCHAR2(30 CHAR)       NULL,
    RESPONSE_TEXT     NCLOB                   NULL,
    DIG_VAL           VARCHAR2(30 CHAR)       NULL,
    ISS_SERVICE_DATE  VARCHAR2(10 CHAR)       NULL,
    CREATE_DATE       TIMESTAMP(6),
    CREATE_USER_ID    VARCHAR2(30 CHAR),
    UPDATE_DATE       TIMESTAMP(6),
    UPDATE_USER_ID    VARCHAR2(30 CHAR),
    RECORD_STATE      VARCHAR2(30 CHAR),
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
    QUANTITY                      NUMBER(11,4)       NULL,
    UNIT_OF_MEASURE_CODE          VARCHAR2(30 CHAR)  NULL,
    TAXABLE_EAN                   VARCHAR2(14 CHAR)  NULL,
    TAXABLE_UNIT_OF_MEASURE_CODE  VARCHAR2(30 CHAR)  NULL,
    IAT                           VARCHAR2(1 CHAR)   NULL,
    IPPT                          VARCHAR2(1 CHAR)   NULL,
    UNIT_PRICE                    NUMBER(17,6)       NULL,
    EXTENDED_AMOUNT               NUMBER(17,6)       NULL,
    TAXABLE_QUANTITY              NUMBER(11,4)       NULL,
    UNIT_TAXABLE_AMOUNT           NUMBER(17,6)       NULL,
    FREIGHT_AMOUNT                NUMBER(17,6)       NULL,
    INSURANCE_AMOUNT              NUMBER(17,6)       NULL,
    DISCOUNT_AMOUNT               NUMBER(17,6)       NULL,
    OTHER_AMOUNT                  NUMBER(17,6)       NULL,
    CFOP                          VARCHAR2(4 CHAR)   NULL,
    INF_AD_PROD                   VARCHAR2(500 CHAR) NULL,
    ICMS_CST                      VARCHAR2(3 CHAR)   NULL,
    ICMS_BASIS                    NUMBER(17,6)       NULL,
    ICMS_AMOUNT                   NUMBER(17,6)       NULL,
    ICMS_RATE                     NUMBER(5,2)        NULL,
    ICMS_ST_BASIS                 NUMBER(17,6)       NULL,
    ICMS_ST_AMOUNT                NUMBER(17,6)       NULL,
    ICMS_ST_RATE                  NUMBER(5,2)        NULL,
    ISS_BASIS                     NUMBER(17,6)       NULL,
    ISS_AMOUNT                    NUMBER(17,6)       NULL,
    ISS_RATE                      NUMBER(5,2)        NULL,
    IPI_AMOUNT                    NUMBER(17,6)       NULL,
    IPI_RATE                      NUMBER(5,2)        NULL,
    II_AMOUNT                     NUMBER(17,6)       NULL,
    PIS_BASIS                     NUMBER(17,6)       NULL,
    PIS_AMOUNT                    NUMBER(17,6)       NULL,
    PIS_RATE                      NUMBER(17,6)       NULL,
    COFINS_BASIS                  NUMBER(17,6)       NULL,
    COFINS_AMOUNT                 NUMBER(17,6)       NULL,
    COFINS_RATE                   NUMBER(17,6)       NULL,
    TAX_SITUATION_CODE            VARCHAR2(6 CHAR)   NULL,
    TAX_GROUP_ID                  VARCHAR2(120 CHAR) NULL,
    LOG_SEQUENCE                  NUMBER(10, 0)      NULL,
    REF_NFE                       VARCHAR2(88 CHAR)  NULL,
    IIS_CITY_CODE                 VARCHAR2(7 CHAR)   NULL,
    IIS_SERVICE_CODE              VARCHAR2(5 CHAR)   NULL,
    IIS_ELIGIBLE_INDICATOR        VARCHAR2(2 CHAR)   NULL,
    IIS_INCENTIVE_INDICATOR       VARCHAR2(1 CHAR)   NULL,
    CREATE_DATE                   TIMESTAMP(6),
    CREATE_USER_ID                VARCHAR2(30 CHAR),
    UPDATE_DATE                   TIMESTAMP(6),
    UPDATE_USER_ID                VARCHAR2(30 CHAR),
    RECORD_STATE                  VARCHAR2(30 CHAR),
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
    ORGANIZATION_ID        NUMBER(10, 0)        NOT NULL,
    TRANS_TYPCODE          VARCHAR2(30 CHAR)    NOT NULL,
    DESCRIPTION            VARCHAR2(60 CHAR)    NULL,
    NOTES                  VARCHAR2(2000 CHAR)  NULL,
    CFOP_SAME_UF           VARCHAR2(4 CHAR)     NULL,
    CFOP_OTHER_UF          VARCHAR2(4 CHAR)     NULL,
    CFOP_FOREIGN           VARCHAR2(4 CHAR)     NULL,
    FIN_NFE                NUMBER(10, 0)    DEFAULT 0,
    DISPLAY_ORDER          NUMBER(10, 0)        NULL,
    COMMENT_REQ_FLAG       NUMBER(1, 0)     DEFAULT 0,
    RULE_TYPE              VARCHAR2(30 CHAR)    NULL,
    DISALLOW_CANCEL_FLAG   NUMBER(1, 0)     DEFAULT 0,
    PRICING_TYPE           VARCHAR2(30 CHAR)    NULL,
    INITIAL_COMMENT        VARCHAR2(254 CHAR)   NULL,
    CREATE_DATE            TIMESTAMP(6),
    CREATE_USER_ID         VARCHAR2(30 CHAR),
    UPDATE_DATE            TIMESTAMP(6),
    UPDATE_USER_ID         VARCHAR2(30 CHAR),
    RECORD_STATE           VARCHAR2(30 CHAR),
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
    ORGANIZATION_ID        NUMBER(10, 0)        NOT NULL,
    TRANS_TYPCODE          VARCHAR2(30 CHAR)    NOT NULL,
    USAGE_TYPCODE          VARCHAR2(30 CHAR)    NOT NULL,
    UF                     VARCHAR2(2 CHAR)     NOT NULL,
    CREATE_DATE            TIMESTAMP(6)         NULL,
    CREATE_USER_ID         VARCHAR2(30 CHAR)    NULL,
    UPDATE_DATE            TIMESTAMP(6)         NULL,
    UPDATE_USER_ID         VARCHAR2(30 CHAR)    NULL,
    RECORD_STATE           VARCHAR2(30 CHAR)    NULL,
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
    ORGANIZATION_ID   NUMBER(10, 0)     NOT NULL,
    RTL_LOC_ID        NUMBER(10, 0)     NOT NULL,
    ENVIRONMENT_ID    NUMBER(10, 0)     NOT NULL,
    TP_NF             NUMBER(10, 0)     NOT NULL,
    SERIES_ID         NUMBER(10, 0)     NOT NULL,
    NNF               NUMBER(10, 0)     NOT NULL,
    MODEL             VARCHAR2(2 CHAR)  NOT NULL,
    BUSINESS_DATE     TIMESTAMP(6)      NOT NULL,  
    TRANS_WKSTN_ID    NUMBER(10, 0)     DEFAULT 1 NOT NULL,
    TRANS_SEQ         NUMBER(10, 0)     NOT NULL,
    CREATE_DATE       TIMESTAMP(6)      NULL,
    CREATE_USER_ID    VARCHAR2(30 CHAR) NULL,
    UPDATE_DATE       TIMESTAMP(6)      NULL,
    UPDATE_USER_ID    VARCHAR2(30 CHAR) NULL,
    RECORD_STATE      VARCHAR2(30 CHAR) NULL,  
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
    ORGANIZATION_ID      NUMBER(10, 0)       NOT NULL,
    TRANS_TYPCODE        VARCHAR2(30 CHAR)   NOT NULL,
    UF                   VARCHAR2(2 CHAR)    NOT NULL,
    DEST_UF              VARCHAR2(2 CHAR)    NOT NULL,
    TAX_GROUP_ID         VARCHAR2(120 CHAR)  NOT NULL,
    NEW_TAX_GROUP_ID     VARCHAR2(120 CHAR)  NULL,
    CREATE_DATE          TIMESTAMP(6)        NULL,
    CREATE_USER_ID       VARCHAR2(30 CHAR)   NULL,
    UPDATE_DATE          TIMESTAMP(6)        NULL,
    UPDATE_USER_ID       VARCHAR2(30 CHAR)   NULL,
    RECORD_STATE         VARCHAR2(30 CHAR)   NULL,
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
  ORGANIZATION_ID         NUMBER(10, 0)     NOT NULL,
  MUNICIPALITY_ID         NUMBER(10, 0)     NOT NULL,
  UF                      VARCHAR2(2 CHAR)  NULL,
  NAME                    VARCHAR2(72 CHAR) NULL,
  IBGE_CODE               VARCHAR2(7 CHAR)  NULL,
  POSTAL_CODE_START       VARCHAR2(8 CHAR)  NULL,
  POSTAL_CODE_END         VARCHAR2(8 CHAR)  NULL,
  PARENT_MUNICIPALITY_ID  NUMBER(10, 0)     NULL,
  LOC_IN_SIT              VARCHAR2(1 CHAR)  NULL,
  LOC_IN_TIPO_LOC         VARCHAR2(1 CHAR)  NULL,
  CREATE_DATE             TIMESTAMP(6),
  CREATE_USER_ID          VARCHAR2(30 CHAR),
  UPDATE_DATE             TIMESTAMP(6),
  UPDATE_USER_ID          VARCHAR2(30 CHAR),
  RECORD_STATE            VARCHAR2(30 CHAR),
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
  ORGANIZATION_ID    NUMBER(10, 0)      NOT NULL,
  RTL_LOC_ID         NUMBER(10, 0)      NOT NULL,
  ENVIRONMENT_ID     NUMBER(10, 0)      NOT NULL,
  TP_NF              NUMBER(10, 0)      NOT NULL,
  SERIES_ID          NUMBER(10, 0)      NOT NULL,
  NNF                NUMBER(10, 0)      NOT NULL,
  MODEL              VARCHAR2(2 CHAR)   NOT NULL,
  NAME               VARCHAR2(60 CHAR)  NULL,
  FANTASY_NAME       VARCHAR2(60 CHAR)  NULL,
  FEDERAL_TAX_ID     VARCHAR2(20 CHAR)  NULL,
  STATE_TAX_ID       VARCHAR2(20 CHAR)  NULL,
  CITY_TAX_ID        VARCHAR2(20 CHAR)  NULL,
  CRT                VARCHAR2(1 CHAR)   NULL, 
  STREET_NAME        VARCHAR2(60 CHAR)  NULL,
  STREET_NUM         VARCHAR2(60 CHAR)  NULL,
  COMPLEMENTO        VARCHAR2(60 CHAR)  NULL,
  NEIGHBORHOOD       VARCHAR2(60 CHAR)  NULL,
  CITY_CODE          VARCHAR2(7 CHAR)   NULL,
  CITY               VARCHAR2(60 CHAR)  NULL,
  STATE              VARCHAR2(2 CHAR)   NULL,
  POSTAL_CODE        VARCHAR2(8 CHAR)   NULL,
  COUNTRY_CODE       VARCHAR2(4 CHAR)   NULL,
  COUNTRY_NAME       VARCHAR2(60 CHAR)  NULL,
  TELEPHONE          VARCHAR2(14 CHAR)  NULL, 
  CREATE_DATE        TIMESTAMP(6),
  CREATE_USER_ID     VARCHAR2(30 CHAR),
  UPDATE_DATE        TIMESTAMP(6),
  UPDATE_USER_ID     VARCHAR2(30 CHAR),
  RECORD_STATE       VARCHAR2(30 CHAR),
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
  ORGANIZATION_ID    NUMBER(10, 0)      NOT NULL,
  RTL_LOC_ID         NUMBER(10, 0)      NOT NULL,
  WKSTN_ID           NUMBER(10, 0)      NOT NULL,
  QUEUE_SEQ          NUMBER(10, 0)      NOT NULL, 
  NAME               VARCHAR2(60 CHAR)  NULL,
  FANTASY_NAME       VARCHAR2(60 CHAR)  NULL,
  FEDERAL_TAX_ID     VARCHAR2(20 CHAR)  NULL,
  STATE_TAX_ID       VARCHAR2(20 CHAR)  NULL,
  CITY_TAX_ID        VARCHAR2(20 CHAR)  NULL,
  CRT                VARCHAR2(1 CHAR)   NULL, 
  STREET_NAME        VARCHAR2(60 CHAR)  NULL,
  STREET_NUM         VARCHAR2(60 CHAR)  NULL,
  COMPLEMENTO        VARCHAR2(60 CHAR)  NULL,
  NEIGHBORHOOD       VARCHAR2(60 CHAR)  NULL,
  CITY_CODE          VARCHAR2(7 CHAR)   NULL,
  CITY               VARCHAR2(60 CHAR)  NULL,
  STATE              VARCHAR2(2 CHAR)   NULL,
  POSTAL_CODE        VARCHAR2(8 CHAR)   NULL,
  COUNTRY_CODE       VARCHAR2(4 CHAR)   NULL,
  COUNTRY_NAME       VARCHAR2(60 CHAR)  NULL,
  TELEPHONE          VARCHAR2(14 CHAR)  NULL, 
  CREATE_DATE        TIMESTAMP(6),
  CREATE_USER_ID     VARCHAR2(30 CHAR),
  UPDATE_DATE        TIMESTAMP(6),
  UPDATE_USER_ID     VARCHAR2(30 CHAR),
  RECORD_STATE       VARCHAR2(30 CHAR),
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
  ORGANIZATION_ID    NUMBER(10, 0)      NOT NULL,
  RTL_LOC_ID         NUMBER(10, 0)      NOT NULL,
  ENVIRONMENT_ID     NUMBER(10, 0)      NOT NULL,
  TP_NF              NUMBER(10, 0)      NOT NULL,
  SERIES_ID          NUMBER(10, 0)      NOT NULL,
  NNF                NUMBER(10, 0)      NOT NULL,
  MODEL              VARCHAR2(2 CHAR)   NOT NULL,
  NAME               VARCHAR2(60 CHAR)  NULL,
  FEDERAL_TAX_ID     VARCHAR2(20 CHAR)  NULL,
  STATE_TAX_ID       VARCHAR2(20 CHAR)  NULL,
  STREET_NAME        VARCHAR2(60 CHAR)  NULL,
  STREET_NUM         VARCHAR2(60 CHAR)  NULL,
  COMPLEMENTO        VARCHAR2(60 CHAR)  NULL,
  NEIGHBORHOOD       VARCHAR2(60 CHAR)  NULL,
  CITY_CODE          VARCHAR2(7 CHAR)   NULL,
  CITY               VARCHAR2(60 CHAR)  NULL,
  STATE              VARCHAR2(2 CHAR)   NULL,
  POSTAL_CODE        VARCHAR2(8 CHAR)   NULL,
  COUNTRY_CODE       VARCHAR2(4 CHAR)   NULL,
  COUNTRY_NAME       VARCHAR2(60 CHAR)  NULL,
  TELEPHONE          VARCHAR2(14 CHAR)  NULL,
  EMAIL              VARCHAR2(60 CHAR)  NULL,
  CREATE_DATE        TIMESTAMP(6),
  CREATE_USER_ID     VARCHAR2(30 CHAR),
  UPDATE_DATE        TIMESTAMP(6),
  UPDATE_USER_ID     VARCHAR2(30 CHAR),
  RECORD_STATE       VARCHAR2(30 CHAR),
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
  ORGANIZATION_ID    NUMBER(10, 0)     NOT NULL,
  RTL_LOC_ID         NUMBER(10, 0)     NOT NULL,
  WKSTN_ID           NUMBER(10, 0)     NOT NULL,
  QUEUE_SEQ          NUMBER(10, 0)     NOT NULL,
  NAME               VARCHAR2(60 CHAR) NULL,
  FEDERAL_TAX_ID     VARCHAR2(20 CHAR) NULL,
  STATE_TAX_ID       VARCHAR2(20 CHAR) NULL,
  STREET_NAME        VARCHAR2(60 CHAR) NULL,
  STREET_NUM         VARCHAR2(60 CHAR) NULL,
  COMPLEMENTO        VARCHAR2(60 CHAR) NULL,
  NEIGHBORHOOD       VARCHAR2(60 CHAR) NULL,
  CITY_CODE          VARCHAR2(7 CHAR)  NULL,
  CITY               VARCHAR2(60 CHAR) NULL,
  STATE              VARCHAR2(2 CHAR)  NULL,
  POSTAL_CODE        VARCHAR2(8 CHAR)  NULL,
  COUNTRY_CODE       VARCHAR2(4 CHAR)  NULL,
  COUNTRY_NAME       VARCHAR2(60 CHAR) NULL,
  TELEPHONE          VARCHAR2(14 CHAR) NULL,
  EMAIL             VARCHAR2(60 CHAR)  NULL,
  CREATE_DATE        TIMESTAMP(6),
  CREATE_USER_ID     VARCHAR2(30 CHAR),
  UPDATE_DATE        TIMESTAMP(6),
  UPDATE_USER_ID     VARCHAR2(30 CHAR),
  RECORD_STATE       VARCHAR2(30 CHAR),
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
  ORGANIZATION_ID    NUMBER(10, 0)      NOT NULL,
  TRANS_TYPCODE      VARCHAR2(30 CHAR)  NOT NULL,
  TAX_LOC_ID         VARCHAR2(60 CHAR)  NOT NULL,
  TAX_GROUP_ID       VARCHAR2(120 CHAR) NOT NULL,
  TAX_AUTHORITY_ID   VARCHAR2(60 CHAR)  NOT NULL,
  CST                VARCHAR2(2 CHAR)   NULL,
  CREATE_DATE        TIMESTAMP(6),
  CREATE_USER_ID     VARCHAR2(30 CHAR),
  UPDATE_DATE        TIMESTAMP(6),
  UPDATE_USER_ID     VARCHAR2(30 CHAR),
  RECORD_STATE       VARCHAR2(30 CHAR),
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
  ORGANIZATION_ID         NUMBER(10, 0)           NOT NULL,
  RTL_LOC_ID              NUMBER(10, 0)           NOT NULL,
  WKSTN_ID                NUMBER(10, 0)           NOT NULL,
  QUEUE_SEQ               NUMBER(10, 0)           NOT NULL,
  SEQUENCE                NUMBER(10, 0)           NOT NULL,
  TNDR_ID                 VARCHAR2(60 CHAR)       NOT NULL,
  FISCAL_TENDER_ID        VARCHAR2(60 CHAR)       NOT NULL,
  AMOUNT                  NUMBER(17,6)            NULL,
  CARD_NETWORK_ID         VARCHAR2(30 CHAR)       NULL,
  CARD_TAX_ID             VARCHAR2(30 CHAR)       NULL,
  CARD_AUTH_NUMBER        VARCHAR2(254 CHAR)      NULL,
  CARD_TYPE               VARCHAR2(254 CHAR)      NULL,
  CARD_TRACE_NUMBER       VARCHAR2(254 CHAR)      NULL,
  CARD_INTEGRATION_MODE   VARCHAR2(30 CHAR)       NULL,
  CARD_INSTALLMENTS       NUMBER(10, 0)           DEFAULT 0,
  CREATE_DATE             TIMESTAMP(6),
  CREATE_USER_ID          VARCHAR2(30 CHAR),
  UPDATE_DATE             TIMESTAMP(6),
  UPDATE_USER_ID          VARCHAR2(30 CHAR),
  RECORD_STATE            VARCHAR2(30 CHAR),
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
  ORGANIZATION_ID         NUMBER(10, 0)     NOT NULL,
  RTL_LOC_ID              NUMBER(10, 0)     NOT NULL,
  ENVIRONMENT_ID          NUMBER(10, 0)     NOT NULL,
  TP_NF                   NUMBER(10, 0)     NOT NULL,
  SERIES_ID               NUMBER(10, 0)     NOT NULL,
  NNF                     NUMBER(10, 0)     NOT NULL,
  MODEL                   VARCHAR2(2 CHAR)  NOT NULL,
  SEQUENCE                NUMBER(10, 0)     NOT NULL,
  TNDR_ID                 VARCHAR2(60 CHAR) NOT NULL,
  FISCAL_TENDER_ID        VARCHAR2(60 CHAR) NOT NULL,
  AMOUNT                  NUMBER(17,6)      NULL,
  CARD_NETWORK_ID         VARCHAR2(30 CHAR) NULL,
  CARD_TAX_ID             VARCHAR2(30 CHAR) NULL,
  CARD_AUTH_NUMBER        VARCHAR2(254 CHAR) NULL,
  CARD_TYPE               VARCHAR2(254 CHAR) NULL,
  CARD_TRACE_NUMBER       VARCHAR2(254 CHAR) NULL,
  CARD_INTEGRATION_MODE   VARCHAR2(30 CHAR) NULL,
  CARD_INSTALLMENTS       NUMBER(10, 0)   DEFAULT 0,
  CREATE_DATE             TIMESTAMP(6),
  CREATE_USER_ID          VARCHAR2(30 CHAR),
  UPDATE_DATE             TIMESTAMP(6),
  UPDATE_USER_ID          VARCHAR2(30 CHAR),
  RECORD_STATE            VARCHAR2(30 CHAR),
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
    ORGANIZATION_ID    NUMBER(10, 0)   NOT NULL,
    RTL_LOC_ID         NUMBER(10, 0)   NOT NULL,
    WKSTN_ID           NUMBER(10, 0)   NOT NULL,
    QUEUE_SEQ          NUMBER(10, 0)   NOT NULL,
    SESSION_ID         NUMBER(10, 0)   NOT NULL,
    CODE_SATE          VARCHAR2(32 CHAR)   NULL,
    MESSAGE_SATE       VARCHAR2(254 CHAR)  NULL,
    CODE_ALERT         VARCHAR2(32 CHAR)   NULL,
    MESSAGE_ALERT      VARCHAR2(254 CHAR)  NULL,
    XML_STRING         NCLOB               NULL,
    TIME_STAMP         TIMESTAMP(6)        NULL,
    CHAVE              VARCHAR2(254 CHAR)  NULL,
    TOTAL_AMOUNT       NUMBER(17,6)        NULL,
    CPF_CNPJ_VALUE     VARCHAR2(32 CHAR)   NULL,
    SIGNATURE_QR_CODE  VARCHAR2(2000 CHAR) NULL,
    SUCCESS            NUMBER(1, 0)        NULL,
    TIMEOUT            NUMBER(1, 0)        NULL,
    CREATE_DATE        TIMESTAMP(6),
    CREATE_USER_ID     VARCHAR2(30 CHAR),
    UPDATE_DATE        TIMESTAMP(6),
    UPDATE_USER_ID     VARCHAR2(30 CHAR),
    RECORD_STATE       VARCHAR2(30 CHAR),
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

--[/RXPS-16698]

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

--[RXPS-19582]
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
  IF SP_COLUMN_EXISTS( 'trl_sale_tax_lineitm','orig_tax_group_id') THEN
        dbms_output.put_line('     trl_sale_tax_lineitm.orig_tax_group_id already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE trl_sale_tax_lineitm ADD orig_tax_group_id VARCHAR2(60 CHAR)';
        dbms_output.put_line('     trl_sale_tax_lineitm.orig_tax_group_id created');
  END IF;
END;
/
--[/RXPS-19582]

--[RXPS-21905]
BEGIN
  IF SP_COLUMN_EXISTS('tnd_tndr_options','assign_cash_drawer_req_flag') THEN
        dbms_output.put_line('     tnd_tndr_options.assign_cash_drawer_req_flag already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE tnd_tndr_options ADD assign_cash_drawer_req_flag NUMBER(1, 0) DEFAULT 0';
        EXECUTE IMMEDIATE 'UPDATE tnd_tndr_options SET assign_cash_drawer_req_flag = 0';
        dbms_output.put_line('     tnd_tndr_options.assign_cash_drawer_req_flag created');
  END IF;
END;
/
BEGIN
  IF SP_COLUMN_EXISTS('tnd_tndr_options','post_void_assign_drawer_flag') THEN
        dbms_output.put_line('     tnd_tndr_options.post_void_assign_drawer_flag already exists');
  ELSE
        EXECUTE IMMEDIATE 'ALTER TABLE tnd_tndr_options ADD post_void_assign_drawer_flag NUMBER(1, 0) DEFAULT 0';
        EXECUTE IMMEDIATE 'UPDATE tnd_tndr_options SET post_void_assign_drawer_flag = 0';
        dbms_output.put_line('     tnd_tndr_options.post_void_assign_drawer_flag created');
  END IF;
END;
/
--[/RXPS-21905]

--[RXPS-18210]
BEGIN
--
-- TABLE: TRL_RTRANS_SERIAL_EXCHANGE
--
  IF SP_TABLE_EXISTS ('TRL_RTRANS_SERIAL_EXCHANGE') THEN
       dbms_output.put_line('     TRL_RTRANS_SERIAL_EXCHANGE already exists');
  ELSE
        EXECUTE IMMEDIATE 'CREATE TABLE trl_rtrans_serial_exchange(
    organization_id        NUMBER(10, 0)    NOT NULL,
    rtl_loc_id             NUMBER(10, 0)    NOT NULL,
    business_date          TIMESTAMP(6)     NOT NULL,
    wkstn_id               NUMBER(19, 0)    NOT NULL,
    trans_seq              NUMBER(19, 0)    NOT NULL,
    rtrans_lineitm_seq     NUMBER(10, 0)    NOT NULL,
    item_id                VARCHAR2(60 char),
    orig_serial_nbr        VARCHAR2(60 char),
    new_serial_nbr         VARCHAR2(60 char),
    exchange_comment       VARCHAR2(254 char),
    exchange_reason_code   VARCHAR2(30 char),
    orig_lineitm_seq       NUMBER(10, 0),
    orig_rtl_loc_id        NUMBER(10, 0),
    orig_wkstn_id          NUMBER(19, 0),
    orig_business_date     TIMESTAMP(6),
    orig_trans_seq         NUMBER(19, 0),
    create_date            TIMESTAMP(6),
    create_user_id         VARCHAR2(30 char),
    update_date            TIMESTAMP(6),
    update_user_id         VARCHAR2(30 char),
    record_state           VARCHAR2(30 char),
    CONSTRAINT pk_trl_rtrans_serial_exchange PRIMARY KEY (organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq)
    USING INDEX
TABLESPACE $(DbTblspace)_INDEX
)
TABLESPACE $(DbTblspace)_DATA'
;

        dbms_output.put_line('     TRL_RTRANS_SERIAL_EXCHANGE created');

        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON TRL_RTRANS_SERIAL_EXCHANGE TO posusers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON TRL_RTRANS_SERIAL_EXCHANGE TO dbausers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
  END IF;

END;
/

BEGIN
  IF SP_TABLE_EXISTS ('TRL_RTRANS_SERIAL_EXCHANGE_P') THEN
       dbms_output.put_line('     TRL_RTRANS_SERIAL_EXCHANGE_P already exists');
  ELSE
        Create_Property_Table('TRL_RTRANS_SERIAL_EXCHANGE');
        dbms_output.put_line('     TRL_RTRANS_SERIAL_EXCHANGE_P created');
  END IF;
END;
/

--[/RXPS-18210]

--[RXPS-13349]
BEGIN
--
-- TABLE: SEC_PASSWORD
--
  IF SP_TABLE_EXISTS ('sec_password') THEN
       dbms_output.put_line('     sec_password already exists');
  ELSE
        EXECUTE IMMEDIATE 'CREATE TABLE sec_password(
    organization_id NUMBER(10, 0)      NOT NULL,
    password_id     NUMBER(10, 0)      NOT NULL,
    password        VARCHAR2(254 char),
    create_date     TIMESTAMP(6),
    create_user_id  VARCHAR2(30 char),
    update_date     TIMESTAMP(6),
    update_user_id  VARCHAR2(30 char),
    CONSTRAINT pk_sec_password PRIMARY KEY (organization_id, password_id)
    USING INDEX
TABLESPACE $(DbTblspace)_INDEX
)
TABLESPACE $(DbTblspace)_DATA'
;

        dbms_output.put_line('     sec_password created');

        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON sec_password TO posusers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
        EXECUTE IMMEDIATE 'GRANT SELECT, INSERT, UPDATE, DELETE ON sec_password TO dbausers';
            DBMS_OUTPUT.PUT_LINE('      Grant completed.');
  END IF;

END;
/

--[/RXPS-13349]

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
  v_version VARCHAR2(30 char);
BEGIN
  SELECT base_schema_version into v_version FROM $(DbSchema).ctl_version_history WHERE seq = (SELECT max(seq) FROM $(DbSchema).ctl_version_history);
  IF v_version > '16.0.0.0.650' THEN
    DBMS_OUTPUT.PUT_LINE('Primary Key Updates Already Completed');
  ELSE
    DBMS_OUTPUT.PUT_LINE('Updating Primary Keys...');
    DECLARE
      sqlfields VARCHAR2(1000);
      sqlfieldsas VARCHAR2(1000);
      sqlcomparefields VARCHAR2(1000);
      sqlstatement VARCHAR2(2000);
      CURSOR tabledata_cur IS
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
          -- build a string of char columns for i
          (SELECT
             LISTAGG('i.' || allcols.column_name, ', ') WITHIN GROUP (ORDER BY allcols.column_name)
           FROM 
             all_tab_columns allcols,
             all_cons_columns cols
           WHERE 
             outercons.constraint_name = cols.constraint_name AND
             outercons.owner = cols.owner AND
             cols.owner = allcols.owner AND
             cols.table_name = allcols.table_name AND
             cols.column_name = allcols.column_name) AS all_cols_i,
          -- build a string of char columns for i2
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
             cols.column_name = allcols.column_name) AS all_cols_i2,
          -- build a string of non-char columns
          (SELECT
             LISTAGG(allcols.column_name, ', ') WITHIN GROUP (ORDER BY allcols.column_name)
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
             LISTAGG('UPPER(' || allcols.column_name || ')', ', ') WITHIN GROUP (ORDER BY allcols.column_name)
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
          -- build a string of char columns wrapped in upper
          (SELECT
             LISTAGG('UPPER(' || allcols.column_name || ') AS ' || allcols.column_name, ', ') WITHIN GROUP (ORDER BY allcols.column_name)
           FROM 
             all_tab_columns allcols,
             all_cons_columns cols
           WHERE 
             outercons.constraint_name = cols.constraint_name AND
             outercons.owner = cols.owner AND
             cols.owner = allcols.owner AND
             cols.table_name = allcols.table_name AND
             cols.column_name = allcols.column_name AND
             allcols.data_type LIKE 'VARCHAR%') AS char_cols_upper_as,
          -- build a string of equals comparisons for character columns
          (SELECT
             LISTAGG('UPPER(i2.' || allcols.column_name || ') = i3.' || allcols.column_name, ' AND ') WITHIN GROUP (ORDER BY cols.column_name)
           FROM 
             all_tab_columns allcols,
             all_cons_columns cols
           WHERE 
             outercons.constraint_name = cols.constraint_name AND
             outercons.owner = cols.owner AND
             cols.owner = allcols.owner AND
             cols.table_name = allcols.table_name AND
             cols.column_name = allcols.column_name AND
             allcols.data_type LIKE 'VARCHAR%') AS char_cols_equals,
          -- build a string of equals comparisons for character columns
          (SELECT
             LISTAGG('i2.' || allcols.column_name || ' = i3.' || allcols.column_name, ' AND ') WITHIN GROUP (ORDER BY cols.column_name)
           FROM 
             all_tab_columns allcols,
             all_cons_columns cols
           WHERE 
             outercons.constraint_name = cols.constraint_name AND
             outercons.owner = cols.owner AND
             cols.owner = allcols.owner AND
             cols.table_name = allcols.table_name AND
             cols.column_name = allcols.column_name AND
             allcols.data_type LIKE 'VARCHAR%') AS nonchar_cols_equals             
        FROM
          all_constraints outercons
        WHERE 
          outercons.owner = UPPER('$(DbSchema)') AND
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
              outerallcols.data_type LIKE 'VARCHAR%');
      tabledata   tabledata_cur%ROWTYPE;
    BEGIN
      OPEN tabledata_cur;
      LOOP
            FETCH tabledata_cur INTO tabledata;
            EXIT WHEN tabledata_cur%NOTFOUND;
            sqlfields := CASE WHEN tabledata.nonchar_cols IS NOT NULL THEN tabledata.nonchar_cols || ', ' ELSE '' END || tabledata.char_cols_upper;
            sqlfieldsas := CASE WHEN tabledata.nonchar_cols IS NOT NULL THEN tabledata.nonchar_cols || ', ' ELSE '' END || tabledata.char_cols_upper_as;
            sqlcomparefields := CASE WHEN tabledata.nonchar_cols_equals IS NOT NULL THEN tabledata.nonchar_cols_equals || ' AND ' ELSE '' END || tabledata.char_cols_equals;
            sqlstatement := 'UPDATE ' || UPPER('$(DbSchema)')  || '.' || tabledata.table_name || ' i SET ' || tabledata.set_char_cols_upper || ' WHERE (' || tabledata.all_cols_i || ') IN (SELECT ' || tabledata.all_cols_i2 ||' FROM ' || tabledata.table_name || ' i2 INNER JOIN (SELECT ' || sqlfieldsas || ', COUNT(*) FROM ' || UPPER('$(DbSchema)')  || '.' || tabledata.table_name || ' GROUP BY ' || sqlfields || ' HAVING COUNT(*) < 2) i3 ON ' || sqlcomparefields || ')';

            EXECUTE IMMEDIATE '' || sqlstatement;
            DBMS_OUTPUT.PUT_LINE('Updated character keys on: ' || tabledata.table_name);
            COMMIT;
      END LOOP;
      CLOSE tabledata_cur;
    END;
  END IF;
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
-- 
-- VIEW: rpt_trl_sale_lineitm_view 
--
EXEC DBMS_OUTPUT.PUT_LINE('RPT_TRL_SALE_LINEITM_VIEW');

CREATE OR REPLACE VIEW rpt_trl_sale_lineitm_view
(ORGANIZATION_ID, RTL_LOC_ID, WKSTN_ID, TRANS_SEQ, RTRANS_LINEITM_SEQ, BUSINESS_DATE, BEGIN_DATETIME, END_DATETIME, TRANS_STATCODE, TRANS_TYPCODE, SESSION_ID, OPERATOR_PARTY_ID, CUST_PARTY_ID, ITEM_ID, DEPARTMENT_ID, QUANTITY, UNIT_PRICE, EXTENDED_AMT, VAT_AMT, RETURN_FLAG, NET_AMT, GROSS_AMT, SERIAL_NBR, SALE_LINEITM_TYPCODE, TAX_GROUP_ID, ORIGINAL_RTL_LOC_ID, ORIGINAL_WKSTN_ID, ORIGINAL_BUSINESS_DATE, ORIGINAL_TRANS_SEQ, ORIGINAL_RTRANS_LINEITM_SEQ, RETURN_REASCODE, RETURN_COMMENT, RETURN_TYPCODE, VOID_FLAG, VOID_LINEITM_REASCODE, BASE_EXTENDED_PRICE, RPT_BASE_UNIT_PRICE, EXCLUDE_FROM_NET_SALES_FLAG) AS
SELECT 
TRN.organization_id,
TRN.rtl_loc_id ,
TRN.wkstn_id ,
TRN.trans_seq ,
TSL.rtrans_lineitm_seq ,
TRN.business_date,
TRN.begin_datetime,
TRN.end_datetime,
TRN.trans_statcode,
TRN.trans_typcode,
TRN.session_id,
TRN.operator_party_id,
TRT.cust_party_id,
TSL.item_id,
TSL.merch_level_1,
TSL.quantity,
TSL.unit_price,
TSL.extended_amt,
TSL.vat_amt,
TSL.return_flag,
TSL.net_amt,
TSL.gross_amt,
TSL.serial_nbr,
TSL.sale_lineitm_typcode,
TSL.tax_group_id,
TSL.original_rtl_loc_id,
TSL.original_wkstn_id,
TSL.original_business_date,
TSL.original_trans_seq,
TSL.original_rtrans_lineitm_seq,
TSL.return_reascode,
TSL.return_comment,
TSL.return_typcode,
TRL.void_flag,
TRL.void_lineitm_reascode,
TSL.base_extended_price,
TSL.rpt_base_unit_price,
TSL.exclude_from_net_sales_flag
FROM  
trn_trans TRN, 
trl_sale_lineitm TSL, 
trl_rtrans_lineitm TRL, 
trl_rtrans TRT
WHERE
TRN.organization_id = TSL.organization_id AND
TRN.rtl_loc_id = TSL.rtl_loc_id AND
TRN.wkstn_id = TSL.wkstn_id AND
TRN.business_date = TSL.business_date AND
TRN.trans_seq = TSL.trans_seq AND
TSL.organization_id = TRL.organization_id AND
TSL.rtl_loc_id = TRL.rtl_loc_id AND
TSL.wkstn_id = TRL.wkstn_id AND
TSL.business_date = TRL.business_date AND
TSL.trans_seq = TRL.trans_seq AND
TSL.rtrans_lineitm_seq = TRL.rtrans_lineitm_seq AND
TSL.organization_id = TRT.organization_id AND
TSL.rtl_loc_id = TRT.rtl_loc_id AND
TSL.wkstn_id = TRT.wkstn_id AND
TSL.business_date = TRT.business_date AND
TSL.trans_seq = TRT.trans_seq AND
TRN.trans_statcode ='COMPLETE'
;
/

GRANT SELECT ON rpt_trl_sale_lineitm_view TO posusers
;
GRANT SELECT ON rpt_trl_sale_lineitm_view TO dbausers
;


--
-- VIEW: Test_Connection 
--
EXEC DBMS_OUTPUT.PUT_LINE('Test_Connection');

CREATE OR REPLACE VIEW Test_Connection(result)
AS
SELECT 1  from dual;

GRANT SELECT ON Test_Connection TO posusers;
GRANT SELECT ON Test_Connection TO dbausers;



/* 
 * VIEW: rpt_trl_stock_movement_view 
 */

EXEC DBMS_OUTPUT.PUT_LINE('RPT_TRL_STOCK_MOVEMENT_VIEW');

CREATE OR REPLACE VIEW RPT_TRL_STOCK_MOVEMENT_VIEW
AS
SELECT organization_id, rtl_loc_id, business_date, item_id, quantity, adjustment_flag
FROM
((SELECT tsl.organization_id as organization_id, tsl.rtl_loc_id as rtl_loc_id, tsl.business_date as business_date, tsl.item_id as item_id,
	quantity, case when return_flag = 0 then 1 else 0 end as adjustment_flag
	FROM rpt_trl_sale_lineitm_view tsl
	WHERE trans_seq NOT IN
          (SELECT voided_trans_id FROM trn_post_void_trans pvt
           WHERE pvt.organization_id = tsl.organization_id
           AND pvt.rtl_loc_id = tsl.rtl_loc_id
           AND pvt.wkstn_id = tsl.wkstn_id)
	AND sale_lineitm_typcode = 'SALE'
	AND tsl.void_flag = 0) 
UNION ALL
(SELECT inv_journal.organization_id, inv_journal.rtl_loc_id, inv_journal.business_date, inv_journal.inventory_item_id,
     quantity, case when action_code IN ('RECEIVING', 'INVENTORY_ADJUSTMENT', 'CYCLE_COUNT_ADJUSTMENT') then 0 else 1 end as adjustment_flag
FROM inv_inventory_journal inv_journal
WHERE action_code IN ('RECEIVING', 'SHIPPING', 'INVENTORY_ADJUSTMENT', 'CYCLE_COUNT_ADJUSTMENT')
      AND (source_bucket_id='ON_HAND' OR dest_bucket_id='ON_HAND')));
/

GRANT SELECT ON RPT_TRL_STOCK_MOVEMENT_VIEW TO posusers
;
GRANT SELECT ON RPT_TRL_STOCK_MOVEMENT_VIEW TO dbausers
;



-- 
-- SEQUENCE: ctl_version_history_sequence 
--

declare
    li_rowcnt   integer;
    
BEGIN
    select count(*)
      INTO li_rowcnt
      FROM DBA_SEQUENCES
      where SEQUENCE_OWNER = upper('$(DbSchema)')
     AND sequence_name = 'CTL_VERSION_HISTORY_SEQUENCE';
        
    IF li_rowcnt = 0 THEN
    
        EXECUTE IMMEDIATE 'CREATE SEQUENCE CTL_VERSION_HISTORY_SEQUENCE
            START WITH 41
            INCREMENT BY 1
            NOMINVALUE
            NOMAXVALUE
            CACHE 20
            NOORDER';
        DBMS_OUTPUT.PUT_LINE('Sequence created.');
    END IF;
END;
/


GRANT SELECT ON CTL_VERSION_HISTORY_SEQUENCE TO POSUSERS;
GRANT SELECT ON CTL_VERSION_HISTORY_SEQUENCE TO DBAUSERS;

-------------------------------------------------------------------------------------------------------------------
--
-- Procedure         : DATEADD
-- Description       : 
-- Version           : 16.0
-------------------------------------------------------------------------------------------------------------------
--                            CHANGE HISTORY                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- WHO DATE      DESCRIPTION                                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- ... .....         Initial Version
-- 
-------------------------------------------------------------------------------------------------------------------
EXEC DBMS_OUTPUT.PUT_LINE('DATEADD');

CREATE OR REPLACE FUNCTION DATEADD (as_DateFMT      varchar2,
                                        ai_interval    integer,
                                        as_Date        timestamp) RETURN TIMESTAMP
AUTHID CURRENT_USER 
IS
    ld_NewDate      timestamp;
    id_Date         timestamp;
   
BEGIN
    
    id_Date := as_Date;
   
    CASE UPPER(as_DateFMT)
        WHEN 'DAY' THEN
            ld_NewDate := id_Date + ai_interval;
        WHEN 'MONTH' THEN
            ld_NewDate := ADD_MONTHS(id_Date, ai_interval);
        WHEN 'YEAR' THEN
            ld_NewDate := ADD_MONTHS(id_Date, (ai_interval * 12));
        else
            ld_NewDate := NULL;
    END CASE;
    
    RETURN ld_NewDate;
END DATEADD;
/

GRANT EXECUTE ON DATEADD TO posusers;
GRANT EXECUTE ON DATEADD TO dbausers;

 -------------------------------------------------------------------------------------------------------------------
--
-- Procedure         : datepart
-- Description       : 
-- Version           : 16.0
-------------------------------------------------------------------------------------------------------------------
--                            CHANGE HISTORY                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- WHO DATE      DESCRIPTION                                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- ... .....         Initial Version
-- 
-------------------------------------------------------------------------------------------------------------------
EXEC DBMS_OUTPUT.PUT_LINE('DATEPART');

CREATE OR REPLACE FUNCTION datepart (as_DateFMT     varchar2,
                                        ad_Date         timestamp) RETURN INTEGER
AUTHID CURRENT_USER 
IS
    li_DatePart     integer;
    
BEGIN
    
    
    CASE UPPER(as_DateFMT)
        WHEN 'DD' THEN
            li_DatePart := to_number(to_char(ad_Date, 'DD'));
        WHEN 'DW' THEN
            li_DatePart := to_number(to_char(ad_Date, 'D'));
        WHEN 'DY' THEN
            li_DatePart := to_number(to_char(ad_Date, 'DDD'));
        else
            li_DatePart := NULL;
    END CASE;
    
    RETURN li_DatePart;
END datepart;
/

GRANT EXECUTE ON datepart TO posusers;
GRANT EXECUTE ON datepart TO dbausers;

 
-------------------------------------------------------------------------------------------------------------------
--
-- Procedure         : DAY
-- Description       : 
-- Version           : 16.0
-------------------------------------------------------------------------------------------------------------------
--                            CHANGE HISTORY                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- WHO DATE      DESCRIPTION                                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- ... .....         Initial Version
-- 
-------------------------------------------------------------------------------------------------------------------
EXEC DBMS_OUTPUT.PUT_LINE('DAY');

CREATE OR REPLACE FUNCTION DAY
 RETURN varchar2
AUTHID CURRENT_USER 
IS
BEGIN
    RETURN 'DAY';
END DAY;
/

GRANT EXECUTE ON DAY TO posusers;
GRANT EXECUTE ON DAY TO dbausers;

 
-- 
-- FUNCTION: fn_getsessionid 
--
EXEC DBMS_OUTPUT.PUT_LINE('FN_GETSESSIONID');

CREATE OR REPLACE FUNCTION FN_GETSESSIONID (orgId NUMBER, rtlLocId NUMBER, wkstnId NUMBER) RETURN NUMBER 
AUTHID CURRENT_USER 
IS
  v_sessionId NUMBER(10,0);
BEGIN
  SELECT Max(session_id)
    INTO v_sessionId 
    FROM tsn_session_wkstn 
    WHERE organization_id = orgId AND
          rtl_loc_id = rtlLocId AND
          wkstn_id = wkstnId AND
          attached_flag = '1';
 
  RETURN v_sessionId;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN RETURN 0;
    WHEN OTHERS THEN RETURN 0;
END fn_getSessionId;
/
GRANT EXECUTE ON fn_getsessionid TO posusers
;
GRANT EXECUTE ON fn_getsessionid TO dbausers
;
 
-------------------------------------------------------------------------------------------------------------------
--
-- Procedure         : GETDATE
-- Description       : 
-- Version           : 16.0
-------------------------------------------------------------------------------------------------------------------
--                            CHANGE HISTORY                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- WHO DATE      DESCRIPTION                                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- ... .....         Initial Version
-- 
-------------------------------------------------------------------------------------------------------------------
EXEC DBMS_OUTPUT.PUT_LINE('GETDATE');

CREATE OR REPLACE FUNCTION GETDATE 
 RETURN TIMESTAMP
AUTHID CURRENT_USER 
IS
BEGIN
    RETURN SYSDATE;
END GETDATE;
/

GRANT EXECUTE ON GETDATE TO posusers;
GRANT EXECUTE ON GETDATE TO dbausers;

 

-------------------------------------------------------------------------------------------------------------------
--
-- Procedure         : MONTH
-- Description       : 
-- Version           : 16.0
-------------------------------------------------------------------------------------------------------------------
--                            CHANGE HISTORY                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- WHO DATE      DESCRIPTION                                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- ... .....         Initial Version
-- 
-------------------------------------------------------------------------------------------------------------------
EXEC DBMS_OUTPUT.PUT_LINE('MONTH');

CREATE OR REPLACE FUNCTION MONTH
 RETURN varchar2
AUTHID CURRENT_USER 
IS
BEGIN
    RETURN 'MONTH';
END MONTH;
/

GRANT EXECUTE ON MONTH TO posusers;
GRANT EXECUTE ON MONTH TO dbausers;

 
-------------------------------------------------------------------------------------------------------------------
--
-- Procedure         : SP_EXPORT_DATABASE
-- Description       : This procedure is called on the local database to export all of the XStore objects.
-- Version           : 16.0
--
-------------------------------------------------------------------------------------------------------------------
--                            CHANGE HISTORY                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- WHO DATE      DESCRIPTION                                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- ... ..........         Initial Version
-- PGH 11/04/10     Converted to a function, so a return code can be sent back to Data Server.
-- BCW 09/11/15		Added reuse file to ADD_FILE.  This ability was added in 11g.
-------------------------------------------------------------------------------------------------------------------
EXEC DBMS_OUTPUT.PUT_LINE('SP_EXPORT_DATABASE');


CREATE OR REPLACE FUNCTION SP_EXPORT_DATABASE 
(  
    argExportPath          varchar2,                   -- Import Directory Name
    argBackupDataFile      varchar2,                   -- Dump File Name
    argOutputFile          varchar2,                   -- Log File Name
    argSourceOwner         varchar2                    -- Source Owner User Name
)
RETURN INTEGER
IS

--sqlStmt                 VARCHAR2(512);
--objectToDrop            VARCHAR2(128);
--ls_synonym_name         VARCHAR2(30);
--ls_owner                VARCHAR2(30);
--ls_object_type          VARCHAR2(30);
--ls_object_name          VARCHAR2(30);

-- Varaibles for the Datapump section
h1                      NUMBER;         -- Data Pump job handle
job_state               VARCHAR2(30);   -- To keep track of job state
ind                     NUMBER;        -- loop index
le                      ku$_LogEntry;   -- WIP and error messages
js                      ku$_JobStatus;  -- job status from get_status
jd                      ku$_JobDesc;    -- job description from get_status
sts                     ku$_Status;     -- status object returned by
rowcnt                  NUMBER; 

BEGIN
    --Enable Server Output
    DBMS_OUTPUT.ENABLE (500000);
    DBMS_OUTPUT.PUT_LINE (user || ' is starting SP_EXPORT_DATABASE.');
    sp_write_dbms_output_to_file('SP_EXPORT_DATABASE');

    --
    -- Checks to see if the Data Pump work table exists and drops it.
    --
    select count(*)
        into rowcnt
        from all_tables
        where table_name = 'XSTORE_EXPORT';
          
    IF rowcnt > 0 THEN
        EXECUTE IMMEDIATE 'DROP TABLE XSTORE_EXPORT';
    END IF;

    --
    -- Create a schema level export for the DTV objects
    --
    h1 := DBMS_DATAPUMP.OPEN('EXPORT', 'SCHEMA', NULL, 'XSTORE_EXPORT', 'LATEST');
    DBMS_DATAPUMP.METADATA_FILTER(h1, 'SCHEMA_EXPR', 'IN ('''|| argSourceOwner ||''')');

    --
    -- Adds the data and log files
    --
    DBMS_DATAPUMP.ADD_FILE(h1, argBackupDataFile, argExportPath, NULL, DBMS_DATAPUMP.KU$_FILE_TYPE_DUMP_FILE, 1);
    DBMS_DATAPUMP.ADD_FILE(h1, argOutputFile, argExportPath, NULL, DBMS_DATAPUMP.KU$_FILE_TYPE_LOG_FILE, 1);
    
    --
    -- Start the job. An exception will be generated if something is not set up
    -- properly.
    --
    DBMS_DATAPUMP.START_JOB(h1);

    --
    -- Waits until the job as completed
    --
    DBMS_DATAPUMP.WAIT_FOR_JOB (h1, job_state);

    dbms_output.put_line('Job has completed');
    dbms_output.put_line('Final job state = ' || job_state);

    dbms_datapump.detach(h1);
    
    DBMS_OUTPUT.PUT_LINE ('Ending SP_EXPORT_DATABASE...');
    sp_write_dbms_output_to_file('SP_EXPORT_DATABASE');
    DBMS_OUTPUT.DISABLE ();
    RETURN 0;
    
EXCEPTION
    WHEN OTHERS THEN
    BEGIN
        dbms_datapump.get_status(h1, 
                                    dbms_datapump.ku$_status_job_error, 
                                    -1, 
                                    job_state, 
                                    sts);
        js := sts.job_status;
        le := sts.error;
        IF le IS NOT NULL THEN
          ind := le.FIRST;
          WHILE ind IS NOT NULL LOOP
            dbms_output.put_line(le(ind).LogText);
            ind := le.NEXT(ind);
          END LOOP;
        END IF;
    
        DBMS_DATAPUMP.STOP_JOB (h1, -1, 0, 0);
        dbms_datapump.detach(h1);

        DBMS_OUTPUT.PUT_LINE ('Ending SP_EXPORT_DATABASE...');
        sp_write_dbms_output_to_file('SP_EXPORT_DATABASE');
        DBMS_OUTPUT.DISABLE ();
       return -1;
    END;
END;
/

GRANT EXECUTE ON SP_EXPORT_DATABASE TO dbausers;


-------------------------------------------------------------------------------------------------------------------
--
-- Procedure         : SP_IMPORT_DATABASE
-- Description       : This procedure is called on the local database to import all of the XStore objects onto a
--                      secondary register or for the local training databases.  It procedure will drop all of the 
--                      procedures, triggers, views, sequences and functions owned by the target owner.  If this a 
--                      production database the public synonyms are also dropped.
-- Version           : 16.0
--
-------------------------------------------------------------------------------------------------------------------
--                            CHANGE HISTORY                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- WHO DATE      DESCRIPTION                                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- ... ..........         Initial Version
-- PGH 03/17/2010   Added the two parameters and logic to drop public synonyms
-- PGH 03/26/2010   Rewritten the procedure to execute the datadump import via SQL calls instead of the command
--                  line utility.  The procedures now does pre, import and post steps.
-- PGH 08/30/2010	Add a line to ignore the ctl_replication_queue, because there are two copies of this table and
--					the synoym should not be owned by DTV.
-- BCW 09/08/2015	Changed the public synonyms to user synonyms.
-------------------------------------------------------------------------------------------------------------------
EXEC DBMS_OUTPUT.PUT_LINE('SP_IMPORT_DATABASE');

CREATE OR REPLACE FUNCTION SP_IMPORT_DATABASE 
(  
    argImportPath              varchar2,                   -- Import Directory Name
    argProd                    varchar2,                   -- Import Type: PRODUCTION / TRAINING
    argBackupDataFile          varchar2,                   -- Dump File Name
    argOutputFile              varchar2,                   -- Log File Name
    argSourceOwner             varchar2,                   -- Source Owner User Name
    argTargetOwner             varchar2,                   -- Target Owner User Name
    argSourceTablespace        varchar2,                   -- Source Data Tablespace Name
    argTargetTablespace        varchar2,                   -- Target Data Tablespace Name
    argSourceIndexTablespace   varchar2,                   -- Source Index Tablespace Name
    argTargetIndexTablespace   varchar2                    -- Target Index Tablespace Name
)
RETURN INTEGER
IS

sqlStmt                 VARCHAR2(512);
--objectToDrop            VARCHAR2(128);
ls_synonym_name         VARCHAR2(30);
--ls_owner                VARCHAR2(30);
ls_object_type          VARCHAR2(30);
ls_object_name          VARCHAR2(30);

-- Varaibles for the Datapump section
h1                      NUMBER;         -- Data Pump job handle
job_state               VARCHAR2(30);   -- To keep track of job state
ind                     NUMBER;        -- loop index
le                      ku$_LogEntry;   -- WIP and error messages
js                      ku$_JobStatus;  -- job status from get_status
jd                      ku$_JobDesc;    -- job description from get_status
sts                     ku$_Status;     -- status object returned by 
rowcnt                  NUMBER;


CURSOR OBJECT_LIST (v_owner  VARCHAR2) IS
SELECT object_type, object_name
  FROM all_objects
  WHERE object_type IN ('PROCEDURE', 'TRIGGER', 'VIEW', 'SEQUENCE', 'FUNCTION', 'TABLE', 'TYPE')
    AND object_name != 'SP_IMPORT_DATABASE'
    AND object_name != 'SP_WRITE_DBMS_OUTPUT_TO_FILE'
    AND object_name != 'CTL_REPLICATION_QUEUE'
    AND owner = v_owner;

CURSOR SYNONYM_LIST (v_owner   VARCHAR2) IS
SELECT synonym_name
  FROM all_synonyms
  WHERE owner = upper('$(DbUser)')
    AND table_name != 'SP_IMPORT_DATABASE'
    AND table_name != 'SP_WRITE_DBMS_OUTPUT_TO_FILE'
    AND table_owner = v_owner;
  
BEGIN

    -- Enable Server Output
    DBMS_OUTPUT.ENABLE (500000);
    DBMS_OUTPUT.PUT_LINE (user || ' is starting SP_IMPORT_DATABASE.');
    sp_write_dbms_output_to_file('SP_IMPORT_DATABASE');
    
    --
    -- Checks to see if the Data Pump work table exists and drops it.
    --
    select count(*)
        into rowcnt
        from all_tables
        where owner = upper('$(DbUser)')
          and table_name = 'XSTORE_IMPORT';
          
    IF rowcnt > 0 THEN
        EXECUTE IMMEDIATE 'DROP TABLE XSTORE_IMPORT';
    END IF;

    -- 
    -- Validate the first parameter is either 'PRODUCTION' OR 'TRAINING', if not raise an error
    --
    IF argProd != 'PRODUCTION' AND argProd != 'TRAINING' THEN
        dbms_output.put_line ('Parameter: argProd - Must be PRODUCTION OR TRAINING');
        Raise_application_error(-20001 , 'Parameter: argProd - Must be PRODUCTION OR TRAINING');
    END IF;

    --
    -- Drops all of the user's objects
    --
	BEGIN
    OPEN OBJECT_LIST (argTargetOwner);
      
    LOOP 
        FETCH OBJECT_LIST INTO ls_object_type, ls_object_name;
        EXIT WHEN OBJECT_LIST%NOTFOUND;
        
        -- Do not drop the tables, they will be dropped by datapump.
        IF ls_object_type != 'TABLE' THEN
            sqlstmt := 'DROP '|| ls_object_type ||' '|| argTargetOwner || '.' || ls_object_name;
            dbms_output.put_line (sqlstmt);
                
            IF sqlStmt IS NOT NULL THEN
                  EXECUTE IMMEDIATE sqlStmt;
            END IF;
        END IF;
        
    END LOOP;
    CLOSE OBJECT_LIST;
    sp_write_dbms_output_to_file('SP_IMPORT_DATABASE');
	EXCEPTION
		WHEN OTHERS THEN CLOSE OBJECT_LIST;
    END;  
      
    --
    -- If the production database
    --    - Drop the synonyms for the user's objects
    --
    IF upper(argProd) = 'PRODUCTION' THEN
		BEGIN
        OPEN SYNONYM_LIST (argTargetOwner);
      
    LOOP 
        FETCH SYNONYM_LIST INTO ls_synonym_name;
              
        EXIT WHEN SYNONYM_LIST%NOTFOUND;
                
        sqlstmt := 'DROP SYNONYM $(DbUser).'|| ls_synonym_name;
        dbms_output.put_line (sqlstmt);
                
        IF sqlStmt IS NOT NULL THEN
            EXECUTE IMMEDIATE sqlStmt;
        END IF;
        
    END LOOP;
        
    CLOSE SYNONYM_LIST;
    sp_write_dbms_output_to_file('SP_IMPORT_DATABASE');
	EXCEPTION
		WHEN OTHERS THEN CLOSE SYNONYM_LIST;
		END;
    END IF;

    --
    -- Import the schema objects using Datapump DBMS package
    -- This is a code block to handel exceptions from Datapump
    --

    BEGIN
            --
        -- Performs a schema level import for the Xstore objects
        --
        h1 := DBMS_DATAPUMP.OPEN('IMPORT','SCHEMA',NULL,'XSTORE_IMPORT','LATEST');
        DBMS_DATAPUMP.METADATA_FILTER(h1, 'SCHEMA_EXPR', 'IN ('''|| argSourceOwner || ''')');

        --
        -- Adds the data and log files
        --
        DBMS_DATAPUMP.ADD_FILE(h1, argBackupDataFile, argImportPath, NULL, DBMS_DATAPUMP.KU$_FILE_TYPE_DUMP_FILE);
        DBMS_DATAPUMP.ADD_FILE(h1, argOutputFile, argImportPath, NULL, DBMS_DATAPUMP.KU$_FILE_TYPE_LOG_FILE);
        
        --
        -- Parameters for the import
        --  1) Do not create user
        --  2) Drop table if they exists
        --  3) Exclude procedure SP_PREP_FOR_IMPORT
        --  4) If Training, exclude grants
        --  5) Remap Schema
        --  6) Remap Tablespace
        --
        --DBMS_DATAPUMP.SET_PARAMETER(h1, 'USER_METADATA', 0);
        DBMS_DATAPUMP.SET_PARAMETER(h1, 'TABLE_EXISTS_ACTION', 'REPLACE');
        DBMS_DATAPUMP.METADATA_REMAP(h1, 'REMAP_SCHEMA', argSourceOwner, argTargetOwner);
        DBMS_DATAPUMP.METADATA_FILTER(h1,'NAME_EXPR','!=''SP_IMPORT_DATABASE''', 'FUNCTION');
        DBMS_DATAPUMP.METADATA_FILTER(h1,'NAME_EXPR','!=''SP_WRITE_DBMS_OUTPUT_TO_FILE''', 'PROCEDURE');
        DBMS_DATAPUMP.METADATA_FILTER(h1,'NAME_EXPR','!=''$(DbUser)''', 'USER');
        DBMS_DATAPUMP.METADATA_FILTER(h1,'NAME_EXPR','!=''TRAINING''', 'USER');
        IF upper(argProd) = 'TRAINING' THEN
            DBMS_DATAPUMP.METADATA_FILTER(h1, 'EXCLUDE_PATH_EXPR', 'like''%GRANT%''');
        END IF;
        
        DBMS_DATAPUMP.METADATA_REMAP(h1, 'REMAP_TABLESPACE', argSourceTablespace, argTargetTablespace); 
        DBMS_DATAPUMP.METADATA_REMAP(h1, 'REMAP_TABLESPACE', argSourceIndexTablespace, argTargetIndexTablespace); 

        --
        -- Start the job. An exception will be generated if something is not set up
        -- properly.
        --
        DBMS_DATAPUMP.START_JOB(h1);

        --
        -- Waits until the job as completed
        --
        DBMS_DATAPUMP.WAIT_FOR_JOB (h1, job_state);

        dbms_output.put_line('Job has completed');
        dbms_output.put_line('Final job state = ' || job_state);

        dbms_datapump.detach(h1);
	    sp_write_dbms_output_to_file('SP_IMPORT_DATABASE');
    EXCEPTION
        WHEN OTHERS THEN
        BEGIN
            dbms_datapump.get_status(h1, 
                                        dbms_datapump.ku$_status_job_error, 
                                        -1, 
                                        job_state, 
                                        sts);
            js := sts.job_status;
            le := sts.error;
            IF le IS NOT NULL THEN
              ind := le.FIRST;
              WHILE ind IS NOT NULL LOOP
                dbms_output.put_line(le(ind).LogText);
                ind := le.NEXT(ind);
              END LOOP;
            END IF;
            
            DBMS_DATAPUMP.STOP_JOB (h1, -1, 0, 0);
            dbms_datapump.detach(h1);
		    sp_write_dbms_output_to_file('SP_IMPORT_DATABASE');
	        DBMS_OUTPUT.DISABLE ();
            --Raise_application_error(-20002 , 'Datapump: Data Import Failed');
            return -1;
        END;
    END;  
    
    --
    -- If the production database
    --    - Creates the need synonyms for the user's objects
    --
    IF upper(argProd) = 'PRODUCTION' THEN
		BEGIN
        OPEN OBJECT_LIST (argTargetOwner);
          
        LOOP 
            FETCH OBJECT_LIST INTO ls_object_type, ls_object_name;
            EXIT WHEN OBJECT_LIST%NOTFOUND;
                
            sqlstmt := 'CREATE OR REPLACE SYNONYM $(DbUser).'|| ls_object_name || ' for ' || argTargetOwner || '.' || ls_object_name;
            dbms_output.put_line (sqlstmt);
                
            IF sqlStmt IS NOT NULL THEN
                EXECUTE IMMEDIATE sqlStmt;
                dbms_output.put_line (sqlstmt);
            END IF;
                
        END LOOP;
            
        CLOSE OBJECT_LIST;
	    sp_write_dbms_output_to_file('SP_IMPORT_DATABASE');
		EXCEPTION
			WHEN OTHERS THEN CLOSE OBJECT_LIST;
		END;
    END IF;
    DBMS_OUTPUT.DISABLE ();

    return 0;
EXCEPTION
    WHEN OTHERS THEN
    BEGIN
        DBMS_OUTPUT.PUT_LINE('Error:');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        sp_write_dbms_output_to_file('SP_IMPORT_DATABASE');
        DBMS_OUTPUT.DISABLE ();
        RETURN -1;
    END;
END;
/

GRANT EXECUTE ON SP_IMPORT_DATABASE TO dbausers;


-- 
-- PROCEDURE: SP_INS_UPD_HOURLY_SALES 
--
EXEC DBMS_OUTPUT.PUT_LINE('sp_ins_upd_hourly_sales');

CREATE OR REPLACE PROCEDURE     sp_ins_upd_hourly_sales (
argOrganizationId IN NUMBER /*oragnization id*/,
argRtlLocId IN NUMBER /*retail location or store number*/,
argBusinessDate IN DATE /*business date*/,
argWkstnId IN NUMBER /*register*/,
argHour IN TIMESTAMP /*flash sales classification*/,
argQty IN NUMBER /*quantity*/,
argNetAmt IN NUMBER /*net amount*/,
argGrossAmt IN NUMBER /*gross amount*/,
argTransCount IN NUMBER /*transcation count*/,
argCurrencyId IN VARCHAR2
)
AUTHID CURRENT_USER 
IS
vcount int;
BEGIN 
select decode(instr(DBMS_UTILITY.format_call_stack,'SP_FLASH'),0,0,1) into vcount from dual;
 if vcount>0 then
  UPDATE rpt_sales_by_hour
     SET qty = coalesce(qty, 0) + argQty,
         trans_count = coalesce(trans_count, 0) + argTransCount,
         net_sales = coalesce(net_sales, 0) + argNetAmt,
         gross_sales = coalesce(gross_sales, 0) + argGrossAmt,
         update_date = systimestamp,
         update_user_id = user
   WHERE organization_id = argOrganizationId
     AND rtl_loc_id = argRtlLocId
     AND wkstn_id = argWkstnId
     AND business_date = argBusinessDate
     AND hour = extract (HOUR FROM argHour);

  IF sql%notfound THEN
    INSERT INTO rpt_sales_by_hour
      (organization_id, rtl_loc_id, wkstn_id, hour, qty, trans_count,
      net_sales, business_date, gross_sales, currency_id, create_date, create_user_id)
    VALUES (argOrganizationId, argRtlLocId, argWkstnId, extract (HOUR FROM argHour), argQty, 
      argTransCount, argNetAmt, argBusinessDate, argGrossAmt, argCurrencyId, systimestamp, user);
  END IF;
 else
  raise_application_error( -20001, 'Cannot be run directly.' );
 end if;
END;
/
GRANT EXECUTE ON SP_INS_UPD_HOURLY_SALES TO posusers
;
GRANT EXECUTE ON SP_INS_UPD_HOURLY_SALES TO dbausers
;


-- 
-- PROCEDURE: SP_INS_UPD_MERCHLVL1_SALES 
--
EXEC DBMS_OUTPUT.PUT_LINE('sp_ins_upd_merchlvl1_sales');

CREATE OR REPLACE PROCEDURE     sp_ins_upd_merchlvl1_sales (
argOrganizationId IN NUMBER /*organization id*/,
argRtlLocId IN NUMBER /*retail location or store number*/,
argBusinessDate IN DATE /*business date*/,
argWkstnId IN NUMBER /*register*/,
argDeptId IN VARCHAR2 /*flash sales classification*/,
argQty IN NUMBER /*quantity*/,
argNetAmt IN NUMBER /*net amount*/,
argGrossAmt IN NUMBER /*gross amount*/,
argCurrencyId IN VARCHAR2
)
AUTHID CURRENT_USER 
IS
vcount int;
BEGIN
select decode(instr(DBMS_UTILITY.format_call_stack,'SP_FLASH'),0,0,1) into vcount from dual;
 if vcount>0 then
  UPDATE rpt_merchlvl1_sales
     SET line_count = coalesce(line_count, 0) + argQty,
         line_amt = coalesce(line_amt, 0) + argNetAmt,
         gross_amt = gross_amt + argGrossAmt,
         update_date = systimestamp,
         update_user_id = user
   WHERE organization_id = argOrganizationId
     AND rtl_loc_id = argRtlLocId
     AND wkstn_id = argWkstnId
     AND business_date = argBusinessDate
     AND merch_level_1 = argDeptId;

  IF sql%notfound THEN
    INSERT INTO rpt_merchlvl1_sales (organization_id, rtl_loc_id, wkstn_id, merch_level_1, line_count, 
      line_amt, business_date, gross_amt, currency_id, create_date, create_user_id)
    VALUES (argOrganizationId, argRtlLocId, argWkstnId, argDeptId, argQty, 
      argNetAmt, argBusinessDate, argGrossAmt, argCurrencyId, systimestamp, user);
  END IF;
 else
  raise_application_error( -20001, 'Cannot be run directly.' );
 end if;
END;
/

GRANT EXECUTE ON SP_INS_UPD_MERCHLVL1_SALES TO posusers
;
GRANT EXECUTE ON SP_INS_UPD_MERCHLVL1_SALES TO dbausers
;


-------------------------------------------------------------------------------------------------------------------
--
-- Procedure         : SP_REPLACE_ORG_ID
-- Description       : 
-- Version           : 16.0
-------------------------------------------------------------------------------------------------------------------
--                            CHANGE HISTORY                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- WHO DATE      DESCRIPTION                                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- ... .....         Initial Version
-- PGH 09/22/10     Added a commit after each table is updated. 
-- BCW 09/18/15		Changed owner to the current schema.
-- BCW 09/24/15		Changed argNewOrgId from varchar2 to number.
-------------------------------------------------------------------------------------------------------------------

EXEC DBMS_OUTPUT.PUT_LINE('sp_replace_org_id');

CREATE OR REPLACE FUNCTION sp_replace_org_id
  (argNewOrgId IN number)
RETURN INTEGER
AUTHID CURRENT_USER 
IS
  v_sqlStmt varchar(500);
  v_tabName varchar(60);
  
  CURSOR rtlcur IS 
    SELECT col.table_name 
      FROM all_tab_columns col, all_tables tab
      WHERE tab.owner = upper('$(DbSchema)') AND 
            col.owner = upper('$(DbSchema)') AND 
            col.table_name = tab.table_name AND 
            col.column_name = 'ORGANIZATION_ID'
      ORDER BY col.table_name;
      
BEGIN

  DBMS_OUTPUT.PUT_LINE ('Starting sp_replace_org_id...');
  
  OPEN rtlcur;
  LOOP
    --DBMS_OUTPUT.PUT_LINE ('Starting Loop');

    FETCH rtlcur INTO v_tabName;
        EXIT WHEN rtlcur%NOTFOUND;
    
    v_sqlStmt := 'update $(DbSchema).'||v_tabName||' set organization_id = '||argNewOrgId;
    dbms_output.put_line (v_sqlstmt);
    
    IF v_sqlStmt IS NOT NULL THEN
      EXECUTE IMMEDIATE v_sqlStmt;
      
    END IF;
    
    COMMIT;
    
  END LOOP;
  CLOSE rtlcur;
  
  DBMS_OUTPUT.PUT_LINE ('Ending sp_replace_org_id...');
  
  RETURN 0;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error:');
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
        DBMS_OUTPUT.PUT_LINE ('Ending sp_replace_org_id...');
		CLOSE rtlcur;
        RETURN -1;
END;
/

GRANT EXECUTE ON SP_REPLACE_ORG_ID TO posusers
;
GRANT EXECUTE ON SP_REPLACE_ORG_ID TO dbausers
;

 
-------------------------------------------------------------------------------------------------------------------
--
-- Procedure         : YEAR
-- Description       : 
-- Version           : 16.0
-------------------------------------------------------------------------------------------------------------------
--                            CHANGE HISTORY                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- WHO DATE      DESCRIPTION                                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- ... .....         Initial Version
-- 
-------------------------------------------------------------------------------------------------------------------
EXEC DBMS_OUTPUT.PUT_LINE('YEAR');

CREATE OR REPLACE FUNCTION YEAR
 RETURN varchar2
AUTHID CURRENT_USER 
IS
BEGIN
    RETURN 'YEAR';
END YEAR;
/

GRANT EXECUTE ON YEAR TO posusers;
GRANT EXECUTE ON YEAR TO dbausers;

 
CREATE OR REPLACE FUNCTION fn_NLS_LOWER (argString varchar) RETURN VARCHAR 
AUTHID CURRENT_USER 
IS
BEGIN
   
   RETURN NLS_LOWER(argString);
END fn_NLS_LOWER;
/

GRANT EXECUTE ON fn_NLS_LOWER TO posusers;
GRANT EXECUTE ON fn_NLS_LOWER TO dbausers;

 
CREATE OR REPLACE FUNCTION fn_NLS_UPPER (argString varchar) RETURN VARCHAR 
AUTHID CURRENT_USER 
IS
BEGIN
   
   RETURN NLS_UPPER(argString);
END fn_NLS_UPPER;
/

GRANT EXECUTE ON fn_NLS_UPPER TO posusers;
GRANT EXECUTE ON fn_NLS_UPPER TO dbausers;

 
CREATE OR REPLACE FUNCTION fn_ParseDate (argDateString varchar) RETURN DATE 
AUTHID CURRENT_USER 
IS
BEGIN
   
   RETURN to_date(argDateString,'YYYY-MM-DD HH24:MI:SS');
END fn_ParseDate;
/

GRANT EXECUTE ON fn_ParseDate TO posusers;
GRANT EXECUTE ON fn_ParseDate TO dbausers;

create or replace type split_tbl as table of number(10,0);
 /

 create or replace function fn_integerListToTable
 (
     p_list varchar2,
     p_del varchar2 := ','
 ) return split_tbl pipelined
AUTHID CURRENT_USER 
 is
     l_idx    pls_integer;
     l_list    varchar2(32767):= p_list;
 --AA
--     l_value    varchar2(32767);
     
  begin
     loop
         l_idx :=instr(l_list,p_del);
         if l_idx > 0 then
             pipe row(substr(l_list,1,l_idx-1));
             l_list:= substr(l_list,l_idx+length(p_del));

         else
             pipe row(l_list);
             exit;
         end if;
     end loop;
     return;
 end fn_integerListToTable;
 /

GRANT EXECUTE ON split_tbl TO posusers
;
GRANT EXECUTE ON split_tbl TO dbausers
;
GRANT EXECUTE ON fn_integerListToTable TO posusers
;
GRANT EXECUTE ON fn_integerListToTable TO dbausers
;

 
create or replace type var_tbl as table of varchar2(4000 char);
 /

CREATE OR REPLACE function fn_nodesInHierarchy 
(
    v_orgId number, 
    v_orgCode VARCHAR2, 
    v_orgValue VARCHAR2
) return  var_tbl
AUTHID CURRENT_USER 
 as
 testtab var_tbl := var_tbl();
BEGIN
FOR rc IN
(select org_code || ':' || org_value as node from
    (SELECT org_code, org_value
    FROM loc_org_hierarchy
    WHERE organization_id = v_orgId
	START WITH org_code =v_orgCode AND org_value = v_orgValue
	CONNECT BY PRIOR parent_code = org_code AND PRIOR parent_value = org_value))
  LOOP
    testtab.EXTEND;
    testtab (testtab.COUNT) := rc.node;
  END LOOP;
  return testtab;
  END fn_nodesInHierarchy;
  /

GRANT EXECUTE ON var_tbl TO posusers
;
GRANT EXECUTE ON var_tbl TO dbausers
;
GRANT EXECUTE ON fn_nodesInHierarchy TO posusers
;
GRANT EXECUTE ON fn_nodesInHierarchy TO dbausers
;

 
CREATE OR REPLACE function fn_storesInHierarchy 
(
    v_orgId number, 
    v_orgCode VARCHAR2, 
    v_orgValue VARCHAR2
) return  split_tbl
AUTHID CURRENT_USER 
 as
 testtab split_tbl := split_tbl();
BEGIN
FOR rc IN
(select cast(org_value as number) org_value from
    (SELECT organization_id, org_code, org_value
    FROM loc_org_hierarchy
    WHERE organization_id = v_orgId
START WITH org_code =v_orgCode AND org_value = v_orgValue
CONNECT BY PRIOR org_code = parent_code AND PRIOR org_value = parent_value)
  WHERE org_code = 'STORE')
  LOOP
    testtab.EXTEND;
    testtab (testtab.COUNT) := rc.org_value;
  END LOOP;
  return testtab;
  END fn_storesInHierarchy;
  /

GRANT EXECUTE ON fn_storesInHierarchy TO posusers
;
GRANT EXECUTE ON fn_storesInHierarchy TO dbausers
;

 
/* 
 * PROCEDURE: sp_conv_to_unicode 
 */

-- =============================================
-- Author:        Brett C. White
-- Create date: 2/14/12
-- Description:    Converts all char2, varchar2, and clob fields into nchar2, nvarchar2, and nclob.
-- =============================================
CREATE OR REPLACE PROCEDURE sp_conv_to_unicode 
AUTHID CURRENT_USER 
IS
    v_csql varchar2(255);
    v_ttable varchar2(40);
    v_tcolumn varchar2(40);
    v_old varchar2(40);
BEGIN

	DECLARE CURSOR column_list is
    select 'ALTER TABLE ' || COL.table_name || ' MODIFY "' || column_name || '" N' || data_type
    || '(' || cast(data_length as varchar2(4)) || ')'
    from all_tab_columns COL
    inner join all_tables t on t.TABLE_NAME=COL.TABLE_NAME
    where DATA_TYPE in ('VARCHAR2','CHAR2')
	order by COL.table_name;

	BEGIN
	open column_list;
	LOOP
		FETCH column_list INTO v_csql;
		EXIT WHEN column_list%NOTFOUND;

        BEGIN
		    EXECUTE IMMEDIATE v_csql;
 --   		dbms_output.put_line(v_csql);
            EXCEPTION
            WHEN OTHERS THEN
            dbms_output.put_line(v_csql || ' failed');
        END;
	END LOOP;
	close column_list;
    END;

    DECLARE CURSOR text_list is
 	select COL.table_name,col.COLUMN_NAME
	from all_tab_columns COL
	inner join all_tables t on t.TABLE_NAME=COL.TABLE_NAME
	where DATA_TYPE in ('CLOB')
	order by COL.table_name;

	begin
	open text_list;
    LOOP
    	FETCH text_list INTO v_ttable,v_tcolumn;
        EXIT WHEN text_list%NOTFOUND;
		
		v_old := 'old_column';
	
		dbms_output.put_line('ALTER TABLE ' || v_ttable || ' RENAME COLUMN ' || v_tcolumn || ' TO ' || v_old);
		EXECUTE IMMEDIATE 'ALTER TABLE ' || v_ttable || ' RENAME COLUMN ' || v_tcolumn || ' TO ' || v_old;
		
		dbms_output.put_line('ALTER TABLE ' || v_ttable || ' ADD ' || v_tcolumn || ' NCLOB');
		EXECUTE IMMEDIATE 'ALTER TABLE ' || v_ttable || ' ADD ' || v_tcolumn || ' NCLOB';
		
		dbms_output.put_line('update ' || v_ttable || ' SET ' || v_tcolumn || ' = ' || v_old);
		EXECUTE IMMEDIATE 'update ' || v_ttable || ' SET ' || v_tcolumn || ' = ' || v_old;

		dbms_output.put_line('ALTER TABLE ' || v_ttable || ' DROP COLUMN ' || v_old);
		EXECUTE IMMEDIATE 'ALTER TABLE ' || v_ttable || ' DROP COLUMN ' || v_old;
	end LOOP;
	close text_list;
	EXCEPTION
		WHEN OTHERS THEN CLOSE text_list;
	end;
	dbms_output.put_line('PLEASE UPDATE THE STORED PROCEDURES MANUALLY!!!');
END;
/

GRANT EXECUTE ON sp_conv_to_unicode TO dbausers;

 
-- 
-- PROCEDURE: sp_fifo_detail 
--

CREATE OR REPLACE PROCEDURE sp_fifo_detail
   (merch_level_1_param		in varchar2, 
    merch_level_2_param	in varchar2, 
    merch_level_3_param			in varchar2, 
    merch_level_4_param		in varchar2,
    item_id_param           in varchar2,
    style_id_param          in varchar2,
    rtl_loc_id_param		in varchar2, 
    organization_id_param	in int,
    user_name_param         in varchar2,
    stock_val_date_param    in DATE)
AUTHID CURRENT_USER 
 IS

            organization_id			int;
            organization_id_a		int;
            item_id					VARCHAR2(60);
            item_id_a				VARCHAR2(60);
            description				VARCHAR2(254);
            description_a			VARCHAR2(254);
            style_id                VARCHAR2(60);
            style_id_a              VARCHAR2(254);
            style_desc              VARCHAR2(254);
            style_desc_a            VARCHAR2(254);
            rtl_loc_id				int;
            rtl_loc_id_a			int;
            store_name				VARCHAR2(254);
            store_name_a			VARCHAR2(254);
            invctl_document_id		VARCHAR2(30);
            invctl_document_id_a	VARCHAR2(30);
            invctl_document_nbr     int;
            invctl_document_nbr_a   int;
            create_date_timestamp	DATE;
            create_date_timestamp_a DATE;
            unit_count				DECIMAL(14,4);
            unit_count_a			DECIMAL(14,4);
            current_unit_count		DECIMAL(14,4);
            unit_cost				DECIMAL(17,6);
            unit_cost_a				DECIMAL(17,6);
            unitCount				DECIMAL(14,4);
            unitCount_a				DECIMAL(14,4);

            vcomment					VARCHAR2(254);

            current_item_id			VARCHAR2(60);
            current_rtl_loc_id		int;
            pending_unitCount		DECIMAL(14,4);
            
            vinsert					number(4,0);
            
  
  CURSOR tableCur IS 
      SELECT MAX(sla.organization_id), MAX(COALESCE(sla.unitcount,0)) + MAX(COALESCE(ts.quantity, 0)) AS quantity, 
                  sla.item_id, MAX(i.description), MAX(style.item_id), MAX(style.description), 
		          l.rtl_loc_id, MAX(l.store_name), doc.invctl_document_id, doc.invctl_document_line_nbr,
                  doc.create_date, MAX(COALESCE(doc.unit_count,0)), MAX(COALESCE(doc.unit_cost,0))
      FROM loc_rtl_loc l, (select column_value from table(fn_integerListToTable(rtl_loc_id_param))) fn, 
			(SELECT organization_id, item_id, COALESCE(SUM(unitcount),0) AS unitcount 
				FROM inv_stock_ledger_acct, (select column_value from table(fn_integerListToTable(rtl_loc_id_param))) fn
				WHERE fn.column_value = rtl_loc_id 
                AND bucket_id = 'ON_HAND'
				GROUP BY organization_id, item_id) sla
		    LEFT OUTER JOIN
            (SELECT itm_mov.organization_id, itm_mov.rtl_loc_id, itm_mov.item_id, 
	                SUM(COALESCE(quantity,0) * CASE WHEN adjustment_flag = 1 THEN 1 ELSE -1 END) AS quantity
	         FROM rpt_trl_stock_movement_view itm_mov
	         WHERE to_char(business_date) > to_char(stock_val_date_param)
	         GROUP BY itm_mov.organization_id, itm_mov.rtl_loc_id, itm_mov.item_id) ts
	         ON sla.organization_id = ts.organization_id
	            AND sla.item_id = ts.item_id
            LEFT OUTER JOIN (
                  SELECT id.organization_id, idl.inventory_item_id, idl.rtl_loc_id , id.invctl_document_id, 
                        idl.invctl_document_line_nbr, idl.create_date, COALESCE(idl.unit_count,0) AS unit_count, COALESCE(idl.unit_cost,0) AS unit_cost
                  FROM inv_invctl_document_lineitm idl, (select column_value from table(fn_integerListToTable(rtl_loc_id_param))) fn, inv_invctl_document id
                  WHERE idl.organization_id = id.organization_id AND idl.rtl_loc_id = id.rtl_loc_id AND 
                        idl.document_typcode = id.document_typcode AND idl.invctl_document_id = id.invctl_document_id AND 
                        idl.unit_count IS NOT NULL AND idl.unit_cost IS NOT NULL AND idl.create_date IS NOT NULL AND
                        id.document_subtypcode = 'ASN'
                        AND id.status_code IN ('CLOSED', 'OPEN', 'IN_PROCESS')
                        AND to_date(idl.create_date,'MM/DD/YYYY') <= to_date(stock_val_date_param,'MM/DD/YYYY')
                        AND fn.column_value = idl.rtl_loc_id 
                        AND idl.organization_id = organization_id_param
            ) doc
            ON sla.organization_id = doc.organization_id AND 
               sla.item_id = doc.inventory_item_id
            INNER JOIN itm_item i
            ON sla.item_id = i.item_id AND
               sla.organization_id = i.organization_id
            LEFT OUTER JOIN itm_item style
            ON i.parent_item_id = style.item_id AND
               i.organization_id = style.organization_id
      WHERE merch_level_1_param in (i.merch_level_1,'%') AND merch_level_2_param in (i.merch_level_2,'%') AND 
            merch_level_3_param IN (i.merch_level_3,'%') AND merch_level_4_param IN (i.merch_level_4,'%') AND
            item_id_param IN (i.item_id,'%') AND style_id_param IN (i.parent_item_id,'%') AND
            sla.organization_id = l.organization_id AND 
            fn.column_value = l.rtl_loc_id AND 
            doc.rtl_loc_id = l.rtl_loc_id AND 
            COALESCE(sla.unitcount,0) + COALESCE(ts.quantity, 0) > 0
      GROUP BY style.item_id, sla.item_id, doc.invctl_document_id, l.rtl_loc_id, doc.invctl_document_line_nbr, doc.create_date
      ORDER BY sla.item_id,doc.create_date DESC;

BEGIN      
	EXECUTE IMMEDIATE 'DELETE FROM rpt_fifo_detail WHERE user_name = ''' || user_name_param || '''';
    vcomment := '';
    current_item_id := '';
    pending_unitCount := 0;
    vinsert := 0;
    OPEN tableCur;
    FETCH tableCur INTO organization_id, unitcount, item_id, description, style_id, style_desc, rtl_loc_id, store_name, invctl_document_id, invctl_document_nbr, create_date_timestamp, unit_count, unit_cost;
    LOOP
    EXIT WHEN tableCur%NOTFOUND;
        IF current_item_id <> item_id THEN
            current_item_id := item_id;
            pending_unitCount := unitcount;
        END IF;
	   IF pending_unitCount > 0 Then
              IF pending_unitCount < unit_count Then
                  current_unit_count := pending_unitCount;
                  pending_unitCount := 0;
              ELSE
                  current_unit_count := unit_count ;
                  pending_unitCount := pending_unitCount - unit_count;
              END IF;
              vinsert := 1;
        ELSIF pending_unitCount < 0 Then
                 vinsert := 1;
        ELSE 
            vinsert := 0;
        END IF;

              organization_id_a := organization_id;
              unitcount_a := unitcount;
              item_id_a := item_id;
              description_a := description;
              style_id_a := style_id;
              style_desc_a := style_desc;
              rtl_loc_id_a := rtl_loc_id;
              store_name_a := store_name;
              invctl_document_id_a := invctl_document_id;
              invctl_document_nbr_a := invctl_document_nbr;
              create_date_timestamp_a := create_date_timestamp;
              unit_count_a := unit_count;
              unit_cost_a := unit_cost;

        FETCH tableCur INTO organization_id, unitcount, item_id, description, style_id, style_desc, rtl_loc_id, store_name, invctl_document_id, invctl_document_nbr, create_date_timestamp, unit_count, unit_cost;
	   IF (pending_unitCount >= 0 OR tableCur%NOTFOUND  OR item_id <> item_id_a) AND vinsert = 1 then
             vcomment := '';
              IF (item_id_a <> item_id AND pending_unitCount > 0) OR tableCur%NOTFOUND then
                  IF pending_unitCount > 0 Then
                        vcomment := '_rptLackDocStockVal';
                  END IF;
              END IF;

		  IF pending_unitCount < 0 Then
			   invctl_document_id_a := '_rptNoAvailDocStockVal';
			   unit_cost_a := null;
			   unit_count_a := null;
			   current_unit_count := null;
			   create_date_timestamp_a := null;
			   vcomment := '_rptLackDocStockVal';
		  END IF;

              INSERT INTO rpt_fifo_detail (organization_id, rtl_loc_id, item_id, invctl_doc_id, user_name, invctl_doc_create_date, description, store_name, 
                     unit_count, current_unit_count, unit_cost, unit_count_a, current_cost, "comment", pending_count, style_id, style_desc, invctl_doc_line_nbr)
              VALUES(organization_id_a, rtl_loc_id_a, item_id_a, invctl_document_id_a, user_name_param, create_date_timestamp_a, description_a, store_name_a,
					 unit_count_a, current_unit_count, unit_cost_a, unitcount_a, current_unit_count * unit_cost_a, vcomment, pending_unitCount, style_id_a, style_desc_a, invctl_document_nbr_a);
           END IF;
    END LOOP;
    CLOSE tableCur;
	EXCEPTION
		WHEN OTHERS THEN CLOSE tableCur;
END sp_fifo_detail;
/


GRANT EXECUTE ON sp_fifo_detail TO posusers;
GRANT EXECUTE ON sp_fifo_detail TO dbausers;

 
 

-- 
-- PROCEDURE: sp_fifo_summary 
--

CREATE OR REPLACE PROCEDURE sp_fifo_summary
   (merch_level_1_param		in varchar2, 
    merch_level_2_param	in varchar2, 
    merch_level_3_param			in varchar2, 
    merch_level_4_param		in varchar2,
    item_id_param           in varchar2,
    style_id_param          in varchar2,
    rtl_loc_id_param		in varchar2, 
    organization_id_param	in int,
    user_name_param         in varchar2,
    stock_val_date_param    in DATE)
AUTHID CURRENT_USER 
 IS

            organization_id			int;
            item_id					VARCHAR2(60);
            description				VARCHAR2(254);
            style_id                VARCHAR2(60);
            style_desc              VARCHAR2(254);
            rtl_loc_id				int;
            store_name				VARCHAR2(254);
            unit_count				DECIMAL(14,4);
            unit_cost				DECIMAL(17,6);
            vcomment				VARCHAR2(254);
  
  CURSOR tableCur IS 
      SELECT MAX(sla.organization_id), MAX(COALESCE(sla.unitcount,0)) + MAX(COALESCE(ts.quantity, 0)) AS quantity, sla.item_id, MAX(i.description), style.item_id, MAX(style.description), sla.rtl_loc_id, MAX(l.store_name),
      MAX(COALESCE(fifo_detail.unit_cost,0)), MAX(fifo_detail."comment")
      FROM loc_rtl_loc l, (select column_value from table(fn_integerListToTable(rtl_loc_id_param))) fn, inv_stock_ledger_acct sla
            LEFT OUTER JOIN
            (SELECT itm_mov.organization_id, itm_mov.rtl_loc_id, itm_mov.item_id, 
	                SUM(COALESCE(quantity,0) * CASE WHEN adjustment_flag = 1 THEN 1 ELSE -1 END) AS quantity
	         FROM rpt_trl_stock_movement_view itm_mov
	         WHERE to_char(business_date) > to_char(stock_val_date_param) 
	         GROUP BY itm_mov.organization_id, itm_mov.rtl_loc_id, itm_mov.item_id) ts
	         ON sla.organization_id = ts.organization_id
	            AND sla.rtl_loc_id = ts.rtl_loc_id
	            AND sla.item_id = ts.item_id
            LEFT OUTER JOIN (
                  SELECT organization_id, item_id, SUM(current_cost)/SUM(current_unit_count) as unit_cost, MAX("comment") as "comment"
                  FROM rpt_fifo_detail
			   GROUP BY organization_id, item_id ) fifo_detail
	   	  ON sla.organization_id = fifo_detail.organization_id AND 
		  	   sla.item_id = fifo_detail.item_id
	   	  INNER JOIN itm_item i
		  	ON sla.item_id = i.item_id AND
				 sla.organization_id = i.organization_id
	   		LEFT OUTER JOIN itm_item style
		  	ON i.parent_item_id = style.item_id AND 
				 i.organization_id = style.organization_id
	   	  WHERE merch_level_1_param in (i.merch_level_1,'%') AND merch_level_2_param in (i.merch_level_2,'%') AND 
			     merch_level_3_param IN (i.merch_level_3,'%') AND merch_level_4_param IN (i.merch_level_4,'%') AND
			     item_id_param IN (i.item_id,'%') AND style_id_param IN (i.parent_item_id,'%') AND
		    fn.column_value = sla.rtl_loc_id AND
		    sla.organization_id = l.organization_id AND 
		    sla.rtl_loc_id = l.rtl_loc_id AND
            sla.bucket_id = 'ON_HAND' AND
		    COALESCE(sla.unitcount,0) + COALESCE(ts.quantity, 0) <> 0
	  GROUP BY sla.rtl_loc_id, style.item_id, sla.item_id
	  ORDER BY sla.rtl_loc_id, sla.item_id DESC;

BEGIN      
    sp_fifo_detail (merch_level_1_param, merch_level_2_param, merch_level_3_param, merch_level_4_param, item_id_param, style_id_param, rtl_loc_id_param, organization_id_param, user_name_param, stock_val_date_param);
	EXECUTE IMMEDIATE 'DELETE FROM rpt_fifo WHERE user_name = ''' || user_name_param || '''';
    OPEN tableCur;
    LOOP
    FETCH tableCur INTO organization_id, unit_count, item_id, description, style_id, style_desc, rtl_loc_id, store_name, unit_cost, vcomment;
    EXIT WHEN tableCur%NOTFOUND;
	  IF unit_cost=0 then
        unit_count :=0;
      END IF;
       INSERT INTO rpt_fifo (organization_id, rtl_loc_id, store_name, item_id, user_name, description,  
		   style_id, style_desc, unit_count, unit_cost, "comment")
	   VALUES(organization_id, rtl_loc_id, store_name, item_id, user_name_param, description, 
	       style_id, style_desc, unit_count, unit_cost, vcomment); 
    END LOOP;
    CLOSE tableCur;
	EXCEPTION
		WHEN OTHERS THEN CLOSE tableCur;
END sp_fifo_summary;
/

GRANT EXECUTE ON sp_fifo_summary TO posusers;
GRANT EXECUTE ON sp_fifo_summary TO dbausers;

 
 

-------------------------------------------------------------------------------------------------------------------
--
-- Procedure         : sp_ins_upd_flash_sales
-- Description       : Loads data into the Report tables which are then used by the flash reports.
-- Version           : 16.0
-------------------------------------------------------------------------------------------------------------------
--                            CHANGE HISTORY                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- WHO DATE      DESCRIPTION                                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- ... .....     	Initial Version
-- 
-------------------------------------------------------------------------------------------------------------------
EXEC DBMS_OUTPUT.PUT_LINE('sp_ins_upd_flash_sales');

CREATE OR REPLACE PROCEDURE sp_ins_upd_flash_sales (
argOrganizationId   IN NUMBER   /*organization id*/,
argRtlLocId         IN NUMBER   /*retail location or store number*/,
argBusinessDate     IN DATE     /*business date*/,
argWkstnId          IN NUMBER   /*register*/,
argLineEnum         IN VARCHAR2 /*flash sales classification*/,
argQty              IN NUMBER   /*quantity*/,
argNetAmt           IN NUMBER   /*net amount*/,
argCurrencyId       IN VARCHAR2
)
AUTHID CURRENT_USER 
IS
vcount int;
BEGIN
select decode(instr(DBMS_UTILITY.format_call_stack,'SP_FLASH'),0,0,1) into vcount from dual;
 if vcount>0 then
  UPDATE rpt_flash_sales
     SET line_count = COALESCE(line_count, 0) + argQty,
         line_amt = COALESCE(line_amt, 0) + argNetAmt,
         update_date = systimestamp,
         update_user_id = USER
   WHERE organization_id = argOrganizationId
     AND rtl_loc_id = argRtlLocId
     AND wkstn_id = argWkstnId
     AND business_date = argBusinessDate
     AND line_enum = argLineEnum;

  IF SQL%NOTFOUND THEN
    INSERT INTO rpt_flash_sales (organization_id,
                                 rtl_loc_id,
                                 wkstn_id, 
                                 line_enum, 
                                 line_count,
                                 line_amt, 
                                 foreign_amt, 
                                 currency_id, 
                                 business_date, 
                                 create_date, 
                                 create_user_id)
    VALUES (argOrganizationId, 
            argRtlLocId, 
            argWkstnId, 
            argLineEnum, 
            argQty, 
            argNetAmt, 
            0, 
            argCurrencyId, 
            argBusinessDate, 
            systimestamp, 
            USER);
  END IF;
 else
  raise_application_error( -20001, 'Cannot be run directly.' );
 end if;
END;
/
GRANT EXECUTE ON sp_ins_upd_flash_sales TO posusers;
GRANT EXECUTE ON sp_ins_upd_flash_sales TO dbausers;



CREATE OR REPLACE FUNCTION sp_next_sequence_value (
  argOrganizationId      number,
  argRetailLocationId    number,
  argWorkstationId       number,
  argSequenceId          varchar2,
  argSequenceMode        varchar2,
  argIncrement           number,
  argIncrementalValue    number,
  argMaximumValue        number,
  argInitialValue        number)
return number
AUTHID CURRENT_USER 
IS
    vCurrentSequence number(10,0);
    vNextSequence number(10,0);
  BEGIN 
  LOCK TABLE com_sequence IN EXCLUSIVE MODE;
    
    SELECT t.sequence_nbr INTO vCurrentSequence
        FROM com_sequence t 
        WHERE t.organization_id = argOrganizationId
        AND t.rtl_loc_id = argRetailLocationId
        AND t.wkstn_id = argWorkstationId
        AND t.sequence_id = argSequenceId
        AND t.sequence_mode = argSequenceMode;
        
      vNextSequence := vCurrentSequence + argIncrementalValue;
      IF(vNextSequence > argMaximumValue)  then
        vNextSequence := argInitialValue + argIncrementalValue;
      end if;  
        -- handle initial value -1
      IF (argIncrement = '1')  then
        UPDATE com_sequence
        SET sequence_nbr = vNextSequence
        WHERE organization_id = argOrganizationId
        AND rtl_loc_id = argRetailLocationId
        AND wkstn_id = argWorkstationId
        AND sequence_id = argSequenceId
        AND sequence_mode = argSequenceMode;
      END if;
      return vNextSequence;
    exception
      when NO_DATA_FOUND 
      then 
      begin
      IF (argIncrement = '1')  then
        vNextSequence := argInitialValue + argIncrementalValue;
      ELSE
        vNextSequence := argInitialValue;
      END if;   
      INSERT INTO com_sequence (organization_id, rtl_loc_id, wkstn_id, sequence_id, sequence_mode, sequence_nbr) 
      VALUES (argOrganizationId, argRetailLocationId, argWorkstationId, argSequenceId, argSequenceMode, vNextSequence);
      return vNextSequence;
      end;
END sp_next_sequence_value;
/

GRANT EXECUTE ON sp_next_sequence_value TO posusers
;
GRANT EXECUTE ON sp_next_sequence_value TO dbausers
;


CREATE OR REPLACE PROCEDURE sp_set_sequence_value(
  argOrganizationId      number,
  argRetailLocationId    number,
  argWorkstationId       number,
  argSequenceId          varchar2,
  argSequenceMode        varchar2,
  argSequenceValue       number)
AUTHID CURRENT_USER 
IS
BEGIN
  LOCK TABLE com_sequence IN EXCLUSIVE MODE;
  
    UPDATE com_sequence 
        SET sequence_nbr = argSequenceValue
        WHERE organization_id = argOrganizationId
        AND rtl_loc_id = argRetailLocationId
        AND wkstn_id = argWorkstationId
        AND sequence_id = argSequenceId    
        And sequence_mode = argSequenceMode;
END sp_set_sequence_value;
/

GRANT EXECUTE ON sp_set_sequence_value TO posusers
;
GRANT EXECUTE ON sp_set_sequence_value TO dbausers
;

CREATE OR REPLACE PROCEDURE sp_tables_inmemory 
    (venable varchar2) -- Yes = enables in-memory in all tables.  No = disables in-memory in all tables.
AUTHID CURRENT_USER 
AS
vcount int;
CURSOR mycur IS 
  select table_name,owner from all_tables
  where owner=upper('$(DbSchema)')
  order by table_name asc;

BEGIN
    FOR myval IN mycur
    LOOP
		IF substr(upper(venable),1,1) in ('1','T','Y','E') or upper(venable)='ON' THEN
			EXECUTE IMMEDIATE 'alter table ' || myval.owner || '.' || myval.table_name || ' inmemory MEMCOMPRESS FOR QUERY HIGH';
		ELSE
			EXECUTE IMMEDIATE 'alter table ' || myval.owner || '.' || myval.table_name || ' no inmemory';
		END IF;
    END LOOP;
    IF substr(upper(venable),1,1) in ('1','T','Y','E') or upper(venable)='ON' THEN
            dbms_output.put_line('In-Memory option has been enabled on all tables.
Please run the following line to enable the In-Memory option on all new tables.
ALTER TABLESPACE $(DbTblspace)_DATA DEFAULT INMEMORY MEMCOMPRESS FOR QUERY HIGH;');
	ELSE
		dbms_output.put_line('In-Memory option has been disabled on all tables.
Please run the following line to disable the In-Memory option on all new tables.
ALTER TABLESPACE $(DbTblspace)_DATA DEFAULT NO INMEMORY;');
    END IF;
END;
/

GRANT EXECUTE ON sp_tables_inmemory TO dbausers;


-------------------------------------------------------------------------------------------------------------------
--
-- Procedure         : SP_WRITE_DBMS_OUTPUT_TO_FILE
-- Description       : 
-- Version           : 16.0
-------------------------------------------------------------------------------------------------------------------
--                            CHANGE HISTORY                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- WHO DATE      DESCRIPTION                                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- ... .....         Initial Version
-------------------------------------------------------------------------------------------------------------------

EXEC DBMS_OUTPUT.PUT_LINE('sp_write_dbms_output_to_file');

create or replace PROCEDURE sp_write_dbms_output_to_file(logname varchar) AS
   l_line VARCHAR2(255);
   l_done NUMBER;
   l_file utl_file.file_type;
   ext NUMBER;
BEGIN
   ext := INSTR(logname,'.', 1);
   if ext = 0 then
    l_file := utl_file.fopen('EXP_DIR', logname || '.log', 'A');
   else
    l_file := utl_file.fopen('EXP_DIR', logname, 'A');
   end if;
   LOOP
      dbms_output.get_line(l_line, l_done);
      EXIT WHEN l_done = 1;
      utl_file.put_line(l_file, substr(to_char(systimestamp,'YYYY-MM-DD HH24:MI:SS,FF'),1,23) || ' ' || l_line);
   END LOOP;
   utl_file.fflush(l_file);
   utl_file.fclose(l_file);
END sp_write_dbms_output_to_file;
/

GRANT EXECUTE ON sp_write_dbms_output_to_file TO posusers
;
GRANT EXECUTE ON sp_write_dbms_output_to_file TO dbausers
;

 
-------------------------------------------------------------------------------------------------------------------
--
-- Procedure         : SP_FLASH
-- Description       : Loads data into the Report tables which are then used by the flash reports.
-- Version           : 16.0
-------------------------------------------------------------------------------------------------------------------
--                            CHANGE HISTORY                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- WHO DATE      DESCRIPTION                                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- ... .....     	Initial Version
-- PGH  02/23/10    Removed the currencyid paramerer, then joining the loc_rtl_loc table to get the default
--                  currencyid for the location.  If the default is not set, defaulting to 'USD'. 
-- BCW  06/21/12	Updated per Emily Tan's instructions.
-- BCW  12/06/13    Replaced the sale cursor by writing the transaction line item directly into the rpt_sale_line table.
-------------------------------------------------------------------------------------------------------------------
EXEC DBMS_OUTPUT.PUT_LINE('SP_FLASH');


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
vAccountCredit			NUMBER (17,6);

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
vTndridProp				varchar2(60 char);
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
                                'TOTALTAX', 
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
                                        'TOTALTAX',
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
                                       'RETURNS', 
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
                                       'GROSSSALES', 
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
                                       'NETSALES', 
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
                                       'OVERRIDES', 
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
                                       'DISCOUNTS',
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

 
-------------------------------------------------------------------------------------------------------------------
--
-- Procedure         : SP_REPORT
-- Description       : This procedure is to be executed on the XCenter database to populate the flash report tables.
--                      It calls sp_flash for each record in the trn_trans table where the flash_sales_flag is zero
--                      to generate the data.  All of the report / business logic will be kept in sp_flash.
-- Version           : 16.0
-------------------------------------------------------------------------------------------------------------------
--                            CHANGE HISTORY                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- WHO DATE      DESCRIPTION                                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- ... .....         Initial Version
-- PGH 11/03/18   Changed the v_business_date paramter from timestamp(6) to date.
-- 
-------------------------------------------------------------------------------------------------------------------
EXEC DBMS_OUTPUT.PUT_LINE('SP_REPORT');


CREATE OR REPLACE PROCEDURE SP_REPORT (
	job_id			in number default 0,
	firstLoc_id		in number default 0,
	lastLoc_id		in number default 999999999,
	start_date		in DATE default to_date('01/01/1900','mm/dd/yyyy'),
	end_date		in DATE default to_date('12/31/9999','mm/dd/yyyy'),
	batch_count		in number default 9999999999,
	nologging		in number default 0)
AUTHID CURRENT_USER 
IS

  v_organization_id  NUMBER(10);
  v_rtl_loc_id NUMBER(10);
  v_wkstn_id NUMBER(20);
  v_business_date date;       -- Changed the parameter from timestamp(6) to date.
  v_trans_seq NUMBER(10);
  v_starttime DATE;
  v_sql	VARCHAR2(4000);

  CURSOR trans IS
   SELECT organization_id, 
          rtl_loc_id, 
          business_date, 
          wkstn_id, 
          trans_seq
   FROM trn_trans 
   WHERE flash_sales_flag = 0
   AND trans_typcode in ('RETAIL_SALE','POST_VOID')
   AND trans_statcode not like 'CANCEL%'
   AND rtl_loc_id between firstLoc_id AND lastLoc_id
   AND business_date between start_date AND end_date
   AND rownum<=batch_count
  ORDER BY business_date, rtl_loc_id;

BEGIN
    select sysdate into v_starttime from dual;
    if nologging=0 then
       insert into log_sp_report (job_id,loc_id,business_date,job_start,completed,expected)
      select job_id, rtl_loc_id, business_date, v_starttime, 0, COUNT(*)
      FROM trn_trans
      WHERE flash_sales_flag = 0
      AND trans_typcode in ('RETAIL_SALE','POST_VOID')
      AND trans_statcode not like 'CANCEL%'
      AND rtl_loc_id between firstLoc_id AND lastLoc_id
      AND business_date between start_date AND end_date
      AND rownum<=batch_count
  	  group by rtl_loc_id,business_date;
    end if;
    
    OPEN trans;
  
        LOOP
            FETCH trans INTO v_organization_id, 
                             v_rtl_loc_id, 
                             v_business_date, 
                             v_wkstn_id,
                             v_trans_seq;
       
            EXIT WHEN trans%NOTFOUND;

   			if nologging=0 then
			  update log_sp_report set start_dt = SYSDATE where loc_id = v_rtl_loc_id and business_date=v_business_date and job_start=v_starttime and job_id=job_id and start_dt is null;
			end if;

           sp_flash (v_organization_id, 
                      v_rtl_loc_id, 
                      v_business_date, 
                      v_wkstn_id,
                      v_trans_seq); 

  			if nologging=0 then
			  update log_sp_report set completed = completed + 1,end_dt = SYSDATE where loc_id = v_rtl_loc_id and business_date=v_business_date and job_start=v_starttime and job_id=job_id;
			end if;
        END LOOP;
    CLOSE trans;
	if nologging=0 then
		update log_sp_report set job_end = SYSDATE where job_start=v_starttime and job_id=job_id;
	end if;
	EXCEPTION
		WHEN OTHERS THEN CLOSE trans;
END SP_REPORT;
/

GRANT EXECUTE ON SP_REPORT TO posusers;
GRANT EXECUTE ON SP_REPORT TO dbausers;


-- 
-- TRIGGER: CTL_VERSION_HISTORY_SEQ_TRGR 
--

CREATE OR REPLACE TRIGGER CTL_VERSION_HISTORY_SEQ_TRGR
BEFORE INSERT
ON ctl_version_history
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
BEGIN
SELECT ctl_version_history_sequence.nextval INTO :NEW.seq FROM dual;
END;
/

-- 
-- TRIGGER: TRG_UPDATE_RETURN 
--

CREATE OR REPLACE TRIGGER TRG_UPDATE_RETURN
AFTER INSERT
ON trl_returned_item_journal
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW
DECLARE
  v_found_trans SMALLINT;
  v_found_lineitm SMALLINT;
BEGIN
  SELECT COUNT(*) INTO v_found_trans 
      FROM trn_trans 
      WHERE organization_id = :NEW.organization_id
      AND rtl_loc_id = :NEW.rtl_loc_id
      AND wkstn_id = :NEW.wkstn_id
      AND business_date = :NEW.business_date
      AND trans_seq = :NEW.trans_seq;
  IF v_found_trans > 0 THEN
     SELECT COUNT(*) INTO v_found_lineitm FROM trl_returned_item_count ric WHERE 
           organization_id = :NEW.organization_id AND
           rtl_loc_id = :NEW.rtl_loc_id AND
           wkstn_id = :NEW.wkstn_id AND
           business_date = :NEW.business_date AND
           trans_seq = :NEW.trans_seq AND
           rtrans_lineitm_seq = :NEW.rtrans_lineitm_seq;
    IF v_found_lineitm < 1 THEN
      INSERT INTO trl_returned_item_count
        (organization_id, rtl_loc_id, wkstn_id, business_date, trans_seq,
        rtrans_lineitm_seq, returned_count)
  VALUES(:NEW.organization_id,:NEW.rtl_loc_id,
        :NEW.wkstn_id,:NEW.business_date,:NEW.trans_seq,
        :NEW.rtrans_lineitm_seq,:NEW.returned_count);
    ELSE
      UPDATE trl_returned_item_count 
        SET
          returned_count = returned_count + :NEW.returned_count
        WHERE
          organization_id = :NEW.organization_id AND
          rtl_loc_id = :NEW.rtl_loc_id AND
          wkstn_id = :NEW.wkstn_id AND
          business_date = :NEW.business_date AND
          trans_seq = :NEW.trans_seq AND
          rtrans_lineitm_seq = :NEW.rtrans_lineitm_seq;
    END IF;
  END IF;
END;
/

SET SERVEROUTPUT ON SIZE 10000


-- ***************************************************************************
-- This script will apply after all schema artifacts have been upgraded to a given version.  It is
-- generally useful for performing conversions between legacy and modern representations of affected
-- data sets.
--
-- Source version:  15.0.x
-- Target version:  16.0.0
-- DB platform:     Oracle 10g/11g/12c
-- ***************************************************************************

-- LEAVE BLANK LINE BELOW

INSERT INTO ctl_version_history (
    organization_id, base_schema_version, customer_schema_version, base_schema_date, 
    create_user_id, create_date, update_user_id, update_date)
VALUES (
    $(OrgID), '16.0.0.0.699', '0.0.0 - 0.0', SYSDATE, 
    'Oracle', SYSDATE, 'Oracle', SYSDATE);

COMMIT;
declare
vcnt int;
begin
	select count(*) into vcnt from DBA_SYS_PRIVS where GRANTEE=upper('$(DbSchema)') and PRIVILEGE='CREATE ANY TRIGGER';

	if vcnt>0 then
		EXECUTE IMMEDIATE 'REVOKE CREATE ANY TRIGGER FROM $(DbSchema)';
	end if;

	select count(*) into vcnt from DBA_SYS_PRIVS where GRANTEE=upper('$(DbSchema)') and PRIVILEGE='CREATE PUBLIC SYNONYM';

	if vcnt>0 then
		EXECUTE IMMEDIATE 'REVOKE CREATE PUBLIC SYNONYM FROM $(DbSchema)';
	end if;

	select count(*) into vcnt from DBA_SYS_PRIVS where GRANTEE=upper('$(DbSchema)') and PRIVILEGE='CREATE ANY VIEW';

	if vcnt>0 then
		EXECUTE IMMEDIATE 'REVOKE CREATE ANY VIEW FROM $(DbSchema)';
	end if;

	select count(*) into vcnt from DBA_SYS_PRIVS where GRANTEE=upper('$(DbSchema)') and PRIVILEGE='CREATE ANY DIRECTORY';

	if vcnt>0 then
		EXECUTE IMMEDIATE 'REVOKE CREATE ANY DIRECTORY FROM $(DbSchema)';
	end if;

	select count(*) into vcnt from DBA_SYS_PRIVS where GRANTEE=upper('$(DbSchema)') and PRIVILEGE='CREATE ANY SEQUENCE';

	if vcnt>0 then
		EXECUTE IMMEDIATE 'REVOKE CREATE ANY SEQUENCE FROM $(DbSchema)';
	end if;

	select count(*) into vcnt from DBA_SYS_PRIVS where GRANTEE=upper('$(DbSchema)') and PRIVILEGE='CREATE ANY PROCEDURE';

	if vcnt>0 then
		EXECUTE IMMEDIATE 'REVOKE CREATE ANY PROCEDURE FROM $(DbSchema)';
	end if;

	select count(*) into vcnt from DBA_SYS_PRIVS where GRANTEE=upper('$(DbSchema)') and PRIVILEGE='CREATE ANY TABLE';

	if vcnt>0 then
		EXECUTE IMMEDIATE 'REVOKE CREATE ANY TABLE FROM $(DbSchema)';
	end if;

	select count(*) into vcnt from DBA_SYS_PRIVS where GRANTEE=upper('$(DbSchema)') and PRIVILEGE='CREATE ANY JOB';

	if vcnt>0 then
		EXECUTE IMMEDIATE 'REVOKE CREATE ANY JOB FROM $(DbSchema)';
	end if;

	select count(*) into vcnt from DBA_SYS_PRIVS where GRANTEE=upper('$(DbSchema)') and PRIVILEGE='DROP ANY TRIGGER';

	if vcnt>0 then
		EXECUTE IMMEDIATE 'REVOKE DROP ANY TRIGGER FROM $(DbSchema)';
	end if;

	select count(*) into vcnt from DBA_SYS_PRIVS where GRANTEE=upper('$(DbSchema)') and PRIVILEGE='DROP PUBLIC SYNONYM';

	if vcnt>0 then
		EXECUTE IMMEDIATE 'REVOKE DROP PUBLIC SYNONYM FROM $(DbSchema)';
	end if;

	select count(*) into vcnt from DBA_SYS_PRIVS where GRANTEE=upper('$(DbSchema)') and PRIVILEGE='DROP ANY VIEW';

	if vcnt>0 then
		EXECUTE IMMEDIATE 'REVOKE DROP ANY VIEW FROM $(DbSchema)';
	end if;

	select count(*) into vcnt from DBA_SYS_PRIVS where GRANTEE=upper('$(DbSchema)') and PRIVILEGE='DROP ANY DIRECTORY';

	if vcnt>0 then
		EXECUTE IMMEDIATE 'REVOKE DROP ANY DIRECTORY FROM $(DbSchema)';
	end if;

	select count(*) into vcnt from DBA_SYS_PRIVS where GRANTEE=upper('$(DbSchema)') and PRIVILEGE='DROP ANY SEQUENCE';

	if vcnt>0 then
		EXECUTE IMMEDIATE 'REVOKE DROP ANY SEQUENCE FROM $(DbSchema)';
	end if;

	select count(*) into vcnt from DBA_SYS_PRIVS where GRANTEE=upper('$(DbSchema)') and PRIVILEGE='DROP ANY PROCEDURE';

	if vcnt>0 then
		EXECUTE IMMEDIATE 'REVOKE DROP ANY PROCEDURE FROM $(DbSchema)';
	end if;

	select count(*) into vcnt from DBA_SYS_PRIVS where GRANTEE=upper('$(DbSchema)') and PRIVILEGE='DROP ANY TABLE';

	if vcnt>0 then
		EXECUTE IMMEDIATE 'REVOKE DROP ANY TABLE FROM $(DbSchema)';
	end if;

	select count(*) into vcnt from DBA_ROLE_PRIVS where GRANTEE=upper('$(DbSchema)') and GRANTED_ROLE='EXP_FULL_DATABASE';

	if vcnt>0 then
		EXECUTE IMMEDIATE 'REVOKE EXP_FULL_DATABASE FROM $(DbSchema)';
	end if;

	select count(*) into vcnt from DBA_SYS_PRIVS where GRANTEE=upper('$(DbSchema)') and PRIVILEGE='SELECT ANY DICTIONARY';

	if vcnt>0 then
		EXECUTE IMMEDIATE 'REVOKE SELECT ANY DICTIONARY FROM $(DbSchema)';
	end if;


	select count(*) into vcnt from DBA_SYS_PRIVS where GRANTEE=upper('$(DbSchema)') and PRIVILEGE='CREATE ANY SYNONYM';

	if vcnt>0 then
		EXECUTE IMMEDIATE 'REVOKE CREATE ANY SYNONYM FROM $(DbSchema)';
	end if;

	select count(*) into vcnt from DBA_SYS_PRIVS where GRANTEE=upper('$(DbSchema)') and PRIVILEGE='GRANT ANY PRIVILEGE';

	if vcnt>0 then
		EXECUTE IMMEDIATE 'GRANT CREATE TRIGGER TO $(DbSchema)';
		EXECUTE IMMEDIATE 'GRANT CREATE VIEW TO $(DbSchema)';
		EXECUTE IMMEDIATE 'GRANT CREATE SEQUENCE TO $(DbSchema)';
		EXECUTE IMMEDIATE 'GRANT CREATE PROCEDURE TO $(DbSchema)';
		EXECUTE IMMEDIATE 'GRANT CREATE TABLE TO $(DbSchema)';
		EXECUTE IMMEDIATE 'GRANT CREATE TYPE TO $(DbSchema)';
		EXECUTE IMMEDIATE 'GRANT CREATE JOB TO $(DbSchema)';
		EXECUTE IMMEDIATE 'GRANT CREATE SYNONYM TO $(DbUser)';
		EXECUTE IMMEDIATE 'GRANT UNLIMITED TABLESPACE TO $(DbUser)';
		EXECUTE IMMEDIATE 'GRANT UNLIMITED TABLESPACE TO dbauser';

		EXECUTE IMMEDIATE 'REVOKE GRANT ANY PRIVILEGE FROM $(DbSchema)';
	end if;
end;
/

SPOOL OFF;
