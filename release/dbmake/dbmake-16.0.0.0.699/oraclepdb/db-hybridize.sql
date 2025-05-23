SET SERVEROUTPUT ON SIZE 10000

SPOOL hybridize.log;

-- ***************************************************************************
-- This script "hybridizes" a database such that its schema will be compatible with application
-- clients running on two different versions of Xstore.
-- 
-- This is useful when an Xstore version upgrade is being implemented gradually, such that at any 
-- given time, some clients may be running under the old version of the application while others are
-- running under the new version.  Xcenter is the most common target for scripts of this kind, as it
-- generally must support all of an organization's Xstore clients simultaneously.
--
-- NOTE: Do NOT run an "upgrade" script against a database you wish instead to hybridize until such
-- time as all clients have been upgraded to the target Xstore version.
-- 
-- "Hybridize" scripts are less destructive than their "upgrade" counterparts.  Whereas the 
-- latter is free to remove all remnants of the legacy schema it upgrades, the former -- which must
-- still support clients compatible with that legacy schema -- cannot.  Table and column drops, for
-- example, are usually excluded from "hybridize" scripts or handled in some other non-destructive 
-- manner.  "Hybridize" scripts and "upgrade" scripts are therefore mutually exclusive during a 
-- phased upgrade process.
--
-- After an A-to-B upgrade process is complete, convert any A-and-B databases previously modified by
-- this script to their A-to-B final forms by running the following against them in the order 
-- specified:
-- (1) "unhybridize" A-and-B
--
-- Source version:  15.0.*
-- Target version:  16.0.0
-- DB platform:     Oracle 10g/11g/12c
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
PROMPT '*****        HYBRIDIZING         *****';
PROMPT '***** From:  15.0.*              *****';
PROMPT '*****   To:  15.0.*/16.0.0       *****';
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

BEGIN
  IF SP_TABLE_EXISTS('itm_tare_type') THEN
    EXECUTE IMMEDIATE 'UPDATE itm_item_options SET tare_value, tare_unit_of_measure_code = (SELECT tare, unit_of_measure_code FROM itm_tare_type WHERE organization_id = itm_item_options.organization_id AND tare_typecode = itm_item_options.tare_typecode)';
    dbms_output.put_line('moved tare values');
    
    EXECUTE IMMEDIATE 'DROP TABLE itm_tare_type';
    EXECUTE IMMEDIATE 'CREATE OR REPLACE VIEW itm_tare_type as
    select organization_id
      ,tare_typecode
      ,level_code as org_code
      ,level_value as org_value
      ,tare_value as tare
      ,tare_unit_of_measure_code as unit_of_measure_code
      ,create_date
      ,create_user_id
      ,update_date
      ,update_user_id
      ,record_state from itm_item_options';
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

CREATE OR REPLACE TRIGGER TRG_TRN_TRANS_TRANS_DATE
  BEFORE INSERT ON TRN_TRANS
  FOR EACH ROW
BEGIN
  IF :NEW.TRANS_DATE IS NULL THEN
    :NEW.TRANS_DATE := :NEW.BUSINESS_DATE;
  END IF;
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

-- /Increasing first_name, first_name2, last_name and last_name2 field length.'
-- [RXPS-24348]
DECLARE
    li_rowcnt       int;
BEGIN
    SELECT count(*) INTO li_rowcnt FROM ALL_TAB_COLS
    WHERE OWNER = UPPER('$(DbSchema)') AND TABLE_NAME = 'CRM_PARTY' AND COLUMN_NAME='FIRST_NAME' AND DATA_TYPE='VARCHAR2' AND DATA_LENGTH<254;
    
    IF li_rowcnt = 1 THEN
        EXECUTE IMMEDIATE 'ALTER TABLE dtv.crm_party MODIFY first_name varchar2(254)';
        DBMS_OUTPUT.PUT_LINE('     crm_party.first_name updated');
    END IF; 
END;

DECLARE
    li_rowcnt       int;
BEGIN
    SELECT count(*) INTO li_rowcnt FROM ALL_TAB_COLS
    WHERE OWNER = UPPER('$(DbSchema)') AND TABLE_NAME = 'CRM_PARTY' AND COLUMN_NAME='LAST_NAME' AND DATA_TYPE='VARCHAR2' AND DATA_LENGTH<254;
    
    IF li_rowcnt = 1 THEN
        EXECUTE IMMEDIATE 'ALTER TABLE dtv.crm_party MODIFY last_name varchar2(254)';
        DBMS_OUTPUT.PUT_LINE('     crm_party.last_name updated');
    END IF; 
END;

DECLARE
    li_rowcnt       int;
BEGIN
    SELECT count(*) INTO li_rowcnt FROM ALL_TAB_COLS
    WHERE OWNER = UPPER('$(DbSchema)') AND TABLE_NAME = 'CRM_PARTY' AND COLUMN_NAME='FIRST_NAME2' AND DATA_TYPE='VARCHAR2' AND DATA_LENGTH<254;
    
    IF li_rowcnt = 1 THEN
        EXECUTE IMMEDIATE 'ALTER TABLE dtv.crm_party MODIFY first_name2 varchar2(254)';
        DBMS_OUTPUT.PUT_LINE('     crm_party.first_name2 updated');
    END IF; 
END;

DECLARE
    li_rowcnt       int;
BEGIN
    SELECT count(*) INTO li_rowcnt FROM ALL_TAB_COLS
    WHERE OWNER = UPPER('$(DbSchema)') AND TABLE_NAME = 'CRM_PARTY' AND COLUMN_NAME='LAST_NAME2' AND DATA_TYPE='VARCHAR2' AND DATA_LENGTH<254;
    
    IF li_rowcnt = 1 THEN
        EXECUTE IMMEDIATE 'ALTER TABLE dtv.crm_party MODIFY last_name2 varchar2(254)';
        DBMS_OUTPUT.PUT_LINE('     crm_party.last_name2 updated');
    END IF; 
END;
/
-- [/RXPS-24348]

-- Keep at end of the script
drop procedure Create_Property_Table;
commit;
PROMPT '***************************************************************************';
PROMPT 'Database now hybridized to support clients running against the following versions:';
PROMPT '     15.0.*';
PROMPT '     16.0.0';
PROMPT 'Please run the corresponding un-hybridize script against this database once all';
PROMPT 'clients on earlier supported versions have been updated to the latest supported release.';
PROMPT '***************************************************************************';
/
