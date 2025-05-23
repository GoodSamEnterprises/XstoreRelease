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
-- DB platform:     Microsoft SQL Server 2008/2012
-- ***************************************************************************

-- ***************************************************************************
-- ***************************************************************************
-- 15.0.x -> 16.0.0
-- ***************************************************************************
-- ***************************************************************************
-- ***************************************************************************
PRINT '**************************************';
PRINT '* UPGRADE to release 16.0';
PRINT '**************************************';

IF  OBJECT_ID('Create_Property_Table') is not null
       DROP PROCEDURE Create_Property_Table
GO

CREATE PROCEDURE Create_Property_Table 
	-- Add the parameters for the stored procedure here
	@tableName nvarchar(30)
AS
BEGIN
	declare	@sql nvarchar(max),
			@column nvarchar(30),
			@pk nvarchar(max),
			@datatype nvarchar(10),
			@maxlen nvarchar(4),
			@prec nvarchar(3),
			@scale nvarchar(3),
			@deflt nvarchar(50);
	SET NOCOUNT ON;

	IF OBJECT_ID(@tableName + '_p') IS NOT NULL or OBJECT_ID(@tableName) IS NULL or RIGHT(@tableName,2)='_p' or NOT EXISTS (SELECT 1 FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS AS C JOIN INFORMATION_SCHEMA.KEY_COLUMN_USAGE AS K 
	ON C.TABLE_NAME = K.TABLE_NAME AND C.CONSTRAINT_CATALOG = K.CONSTRAINT_CATALOG AND C.CONSTRAINT_SCHEMA = K.CONSTRAINT_SCHEMA AND C.CONSTRAINT_NAME = K.CONSTRAINT_NAME
	WHERE C.CONSTRAINT_TYPE = 'PRIMARY KEY' and K.TABLE_NAME = @tableName and K.COLUMN_NAME = 'organization_id')
		return;

	set @pk = '';
	set @sql='CREATE TABLE dbo.' + @tableName + '_p (
	'
    declare mycur CURSOR Fast_Forward FOR 
	SELECT COL.COLUMN_NAME,DATA_TYPE,CHARACTER_MAXIMUM_LENGTH,NUMERIC_PRECISION,NUMERIC_SCALE,replace(replace(COLUMN_DEFAULT,'(',''),')','') FROM INFORMATION_SCHEMA.TABLE_CONSTRAINTS AS C JOIN INFORMATION_SCHEMA.KEY_COLUMN_USAGE AS K 
	ON C.TABLE_NAME = K.TABLE_NAME AND C.CONSTRAINT_CATALOG = K.CONSTRAINT_CATALOG AND C.CONSTRAINT_SCHEMA = K.CONSTRAINT_SCHEMA AND C.CONSTRAINT_NAME = K.CONSTRAINT_NAME
	join INFORMATION_SCHEMA.COLUMNS col ON C.TABLE_NAME=col.TABLE_NAME and K.COLUMN_NAME=COL.COLUMN_NAME
	WHERE C.CONSTRAINT_TYPE = 'PRIMARY KEY' and K.TABLE_NAME = @tableName
	order by K.ORDINAL_POSITION

	open mycur;

	while 1=1
	BEGIN
		FETCH NEXT FROM mycur INTO @column,@datatype,@maxlen,@prec,@scale,@deflt;
		IF @@FETCH_STATUS <> 0
			BREAK;

			set @pk=@pk + @column + ','

		set @sql=@sql + @column + ' ' + @datatype

		if @datatype='varchar' or @datatype='nvarchar' or @datatype='char' or @datatype='nchar'
			set @sql=@sql + '(' + @maxlen + ')'
		else if @datatype='numeric' or @datatype='decimal'
			set @sql=@sql + '(' + @prec + ',' + @scale + ')'

		if LEN(@deflt)>0
			set @sql=@sql + ' DEFAULT ' + @deflt

		set @sql=@sql + ' NOT NULL,
	'
	END
	close mycur
	deallocate mycur

	set @sql=@sql +	'property_code nvarchar(30) NOT NULL,
    type nvarchar(30) NULL,
    string_value nvarchar(max) NULL,
    date_value datetime NULL,
    decimal_value decimal(17,6)	NULL,
    create_date datetime NULL,
    create_user_id nvarchar(30) NULL,
    update_date datetime NULL,
    update_user_id nvarchar(30) NULL,
    record_state nvarchar(30) NULL,
	'

	if LEN('pk_'+ @tableName + '_p')>30
		set @sql=@sql + 'CONSTRAINT ' + REPLACE('pk_'+ @tableName + '_p','_','') + ' PRIMARY KEY CLUSTERED (' + @pk + 'property_code) WITH (FILLFACTOR = 80))'
	else
		set @sql=@sql + 'CONSTRAINT pk_'+ @tableName + '_p PRIMARY KEY CLUSTERED (' + @pk + 'property_code) WITH (FILLFACTOR = 80))'

	print @tableName + '_p'
	exec(@sql);
END
GO

--[RXPS-14786]
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'sort_order' AND object_id = OBJECT_ID('com_button_grid'))
BEGIN
  ALTER TABLE com_button_grid DROP CONSTRAINT pk_com_button_grid;
  
  ALTER TABLE com_button_grid ADD sort_order int NOT NULL DEFAULT 0;
  
  ALTER TABLE com_button_grid ADD CONSTRAINT pk_com_button_grid 
    PRIMARY KEY CLUSTERED (organization_id, level_code, level_value, grid_id, row_id, column_id, component_id, sort_order) WITH (FILLFACTOR = 80);
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'action_idx' AND object_id = OBJECT_ID('com_button_grid'))
  ALTER TABLE com_button_grid ADD action_idx int null;
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'animation_idx' AND object_id = OBJECT_ID('com_button_grid'))
  ALTER TABLE com_button_grid ADD animation_idx int null;
GO
--[/RXPS-14786]

--[RXPS-16239, RXPS-16539]
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'safe_bag_id' AND object_id = OBJECT_ID('tsn_tndr_control_trans'))
  ALTER TABLE tsn_tndr_control_trans ADD safe_bag_id nvarchar(60) null;
GO
--[/RXPS-16239, RXPS-16539]

--[RXPS-15284]
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'ext_invoice_id' AND object_id = OBJECT_ID('civc_invoice'))
  ALTER TABLE civc_invoice ADD ext_invoice_id nvarchar(60) null;
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'gross_amt' AND object_id = OBJECT_ID('civc_invoice'))
  ALTER TABLE civc_invoice ADD gross_amt decimal(17, 6) null;
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'refund_amt' AND object_id = OBJECT_ID('civc_invoice'))
  ALTER TABLE civc_invoice ADD refund_amt decimal(17, 6) null;
GO
--[/RXPS-15284]

--[RXPS-16187]
IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'restriction_category' AND object_id = OBJECT_ID('itm_item_options'))
BEGIN
  ALTER TABLE itm_item_options DROP COLUMN restriction_category;
  PRINT 'itm_item_options.restriction_category dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'dependent_flag' AND object_id = OBJECT_ID('itm_item_restriction'))
BEGIN
  ALTER TABLE itm_item_restriction DROP COLUMN dependent_flag;
  PRINT 'itm_item_restriction.dependent_flag dropped'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'sale_lineitm_typecode' AND object_id = OBJECT_ID('itm_item_restriction'))
BEGIN
  ALTER TABLE itm_item_restriction DROP CONSTRAINT pk_itm_item_restriction;

  ALTER TABLE itm_item_restriction ADD sale_lineitm_typecode nvarchar(30) NOT NULL DEFAULT 'ANY';
  ALTER TABLE itm_item_restriction ADD property_name nvarchar(30) NOT NULL DEFAULT 'DEFAULT';

  ALTER TABLE itm_item_restriction ADD CONSTRAINT pk_itm_item_restriction
  PRIMARY KEY CLUSTERED (organization_id, restriction_category, restriction_code, effective_date, sale_lineitm_typecode, property_name) WITH (FILLFACTOR = 80);

  PRINT 'itm_item_restriction.sale_lineitm_typecode created'
  PRINT 'itm_item_restriction.property_name created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'sale_lineitm_typecode' AND object_id = OBJECT_ID('itm_item_restriction_p'))
BEGIN
  ALTER TABLE itm_item_restriction_p DROP CONSTRAINT pk_itm_item_restriction_p;

  ALTER TABLE itm_item_restriction_p ADD sale_lineitm_typecode nvarchar(30) NOT NULL DEFAULT 'ANY';
  ALTER TABLE itm_item_restriction_p ADD property_name nvarchar(30) NOT NULL DEFAULT 'DEFAULT';

  ALTER TABLE itm_item_restriction_p ADD CONSTRAINT pk_itm_item_restriction_p
  PRIMARY KEY CLUSTERED (organization_id, restriction_category, restriction_code, effective_date, sale_lineitm_typecode, property_name, property_code) WITH (FILLFACTOR = 80);

  PRINT 'itm_item_restriction_p.sale_lineitm_typecode created'
  PRINT 'itm_item_restriction_p.property_name created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'sale_lineitm_typecode' AND object_id = OBJECT_ID('itm_item_restrict_calendar'))
BEGIN
  ALTER TABLE itm_item_restrict_calendar DROP CONSTRAINT pk_itm_item_restriction_cal;

  ALTER TABLE itm_item_restrict_calendar ADD sale_lineitm_typecode nvarchar(30) NOT NULL DEFAULT 'ANY';
  ALTER TABLE itm_item_restrict_calendar ADD exemption_flag bit NOT NULL DEFAULT 0;

  ALTER TABLE itm_item_restrict_calendar ADD CONSTRAINT pk_itm_item_restriction_cal
  PRIMARY KEY CLUSTERED (organization_id, restriction_category, restriction_code, effective_date, day_code, start_time, sale_lineitm_typecode) WITH (FILLFACTOR = 80);

  PRINT 'itm_item_restrict_calendar.sale_lineitm_typecode created'
  PRINT 'itm_item_restrict_calendar.exemption_flag created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'sale_lineitm_typecode' AND object_id = OBJECT_ID('itm_item_restrict_calendar_p'))
BEGIN
  ALTER TABLE itm_item_restrict_calendar_p DROP CONSTRAINT pkitmitemrestrictcalendarp;

  ALTER TABLE itm_item_restrict_calendar_p ADD sale_lineitm_typecode nvarchar(30) NOT NULL DEFAULT 'ANY';

  ALTER TABLE itm_item_restrict_calendar_p ADD CONSTRAINT pkitmitemrestrictcalendarp
  PRIMARY KEY CLUSTERED (organization_id, restriction_category, restriction_code, effective_date, day_code, start_time, sale_lineitm_typecode) WITH (FILLFACTOR = 80);

  PRINT 'itm_item_restrict_calendar_p.sale_lineitm_typecode created'
  PRINT 'itm_item_restrict_calendar_p.exemption_flag created'
END
GO


/* 
 * TABLE: [dbo].[itm_item_restrict_mapping] 
 */
IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('itm_item_restrict_mapping'))
BEGIN
  CREATE TABLE [dbo].[itm_item_restrict_mapping](
    [organization_id]           int            NOT NULL,
    [merch_hierarchy_level]     nvarchar(60)    NOT NULL,
    [merch_hierarchy_id]        nvarchar(60)    NOT NULL,
    [restriction_category]      nvarchar(30)    NOT NULL,
    [org_code]                  nvarchar(30)    DEFAULT '*' NOT NULL,
    [org_value]                 nvarchar(60)    DEFAULT '*' NOT NULL,
    [create_date]               datetime       NULL,
    [create_user_id]            nvarchar(30)    NULL,
    [update_date]               datetime       NULL,
    [update_user_id]            nvarchar(30)    NULL,
    [record_state]              nvarchar(30)    NULL,
    CONSTRAINT [pk_itm_item_restrict_map] PRIMARY KEY CLUSTERED ([organization_id], [merch_hierarchy_level], [merch_hierarchy_id], [restriction_category]) WITH (FILLFACTOR = 80)
)

  CREATE INDEX idx_itm_itm_restrctmap_orgnode ON itm_item_restrict_mapping (org_code,org_value) WITH (FILLFACTOR = 80)
  PRINT 'itm_item_restrict_mapping created'
END
go

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('itm_item_restrict_mapping_p'))
BEGIN
  exec Create_Property_Table itm_item_restrict_mapping;
  PRINT 'itm_item_restrict_mapping_p created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('com_button_grid_p'))
BEGIN
  exec Create_Property_Table com_button_grid;
  PRINT 'com_button_grid_p created'
END
GO
--[/RXPS-16187]

--[RXPS-17100]
--
-- TABLE:  [dbo].[com_airport]
--
IF NOT EXISTS (SELECT 1 FROM sys.objects where object_id = OBJECT_ID('com_airport'))
BEGIN
  CREATE TABLE [dbo].[com_airport] (
    organization_id         int           NOT NULL,
    airport_code            nvarchar(3)    NOT NULL,
    airport_name            nvarchar(254)  NOT NULL,
    country_code            nvarchar(2)    NOT NULL,
    zone_id                 nvarchar(30)   NOT NULL,
    create_date             datetime      NULL,
    create_user_id          nvarchar(30)   NULL,
    update_date             datetime      NULL,
    update_user_id          nvarchar(30)   NULL,
    record_state            nvarchar(30)   NULL,
    CONSTRAINT [pk_com_airport] PRIMARY KEY CLUSTERED ([organization_id], [airport_code]) WITH (FILLFACTOR = 80)
   )
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('com_airport_p'))
BEGIN
  exec Create_Property_Table com_airport;
  PRINT 'com_airport_p created'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'destination_country' AND object_id = OBJECT_ID('com_flight_info'))
BEGIN
  ALTER TABLE com_flight_info DROP COLUMN destination_country;
  PRINT 'com_flight_info.destination_country dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'destination_eu_code' AND object_id = OBJECT_ID('com_flight_info'))
BEGIN
  ALTER TABLE com_flight_info DROP COLUMN destination_eu_code;
  PRINT 'com_flight_info.destination_eu_code dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'via_1_country' AND object_id = OBJECT_ID('com_flight_info'))
BEGIN
  ALTER TABLE com_flight_info DROP COLUMN via_1_country;
  PRINT 'com_flight_info.via_1_country dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'via_1_eu_code' AND object_id = OBJECT_ID('com_flight_info'))
BEGIN
  ALTER TABLE com_flight_info DROP COLUMN via_1_eu_code;
  PRINT 'com_flight_info.via_1_eu_code dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'via_2_country' AND object_id = OBJECT_ID('com_flight_info'))
BEGIN
  ALTER TABLE com_flight_info DROP COLUMN via_2_country;
  PRINT 'com_flight_info.via_2_country dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'via_2_eu_code' AND object_id = OBJECT_ID('com_flight_info'))
BEGIN
  ALTER TABLE com_flight_info DROP COLUMN via_2_eu_code;
  PRINT 'com_flight_info.via_2_eu_code dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'via_3_country' AND object_id = OBJECT_ID('com_flight_info'))
BEGIN
  ALTER TABLE com_flight_info DROP COLUMN via_3_country;
  PRINT 'com_flight_info.via_3_country dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'via_3_eu_code' AND object_id = OBJECT_ID('com_flight_info'))
BEGIN
  ALTER TABLE com_flight_info DROP COLUMN via_3_eu_code;
  PRINT 'com_flight_info.via_3_eu_code dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'final_flight_eu_code' AND object_id = OBJECT_ID('com_flight_info'))
BEGIN
  ALTER TABLE com_flight_info DROP COLUMN final_flight_eu_code;
  PRINT 'com_flight_info.final_flight_eu_code dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'destination_airport_name' AND object_id = OBJECT_ID('com_flight_info'))
BEGIN
  ALTER TABLE com_flight_info DROP COLUMN destination_airport_name;
  PRINT 'com_flight_info.destination_airport_name dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'employee_flag' AND object_id = OBJECT_ID('com_flight_info'))
BEGIN
  DECLARE @ConstraintName nvarchar(200)
  SELECT @ConstraintName = Name FROM SYS.DEFAULT_CONSTRAINTS WHERE PARENT_OBJECT_ID = OBJECT_ID('com_flight_info')
  AND PARENT_COLUMN_ID = (SELECT column_id FROM sys.columns WHERE NAME = N'employee_flag' AND object_id = OBJECT_ID(N'com_flight_info'))
  IF @ConstraintName IS NOT NULL
    EXEC('ALTER TABLE com_flight_info DROP CONSTRAINT ' + @ConstraintName)
    ALTER TABLE com_flight_info DROP COLUMN employee_flag;
    PRINT 'com_flight_info.employee_flag dropped'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'first_flight_number' AND object_id = OBJECT_ID('trl_rtrans_flight_info'))
BEGIN
  ALTER TABLE trl_rtrans_flight_info ADD first_flight_number nvarchar(30) null;
  PRINT 'trl_rtrans_flight_info.first_flight_number added'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'first_destination_airport' AND object_id = OBJECT_ID('trl_rtrans_flight_info'))
BEGIN
  ALTER TABLE trl_rtrans_flight_info ADD first_destination_airport nvarchar(3) null;
  PRINT 'trl_rtrans_flight_info.first_destination_airport added'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'first_origin_airport' AND object_id = OBJECT_ID('trl_rtrans_flight_info'))
BEGIN
  ALTER TABLE trl_rtrans_flight_info ADD first_origin_airport nvarchar(3) null;
  PRINT 'trl_rtrans_flight_info.first_origin_airport added'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'first_flight_seat_number' AND object_id = OBJECT_ID('trl_rtrans_flight_info'))
BEGIN
  ALTER TABLE trl_rtrans_flight_info ADD first_flight_seat_number nvarchar(4) null;
  PRINT 'trl_rtrans_flight_info.first_flight_seat_number added'
END
GO
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'first_flight_scheduled_date' AND object_id = OBJECT_ID('trl_rtrans_flight_info'))
BEGIN
  ALTER TABLE trl_rtrans_flight_info ADD first_flight_scheduled_date datetime null;
  PRINT 'trl_rtrans_flight_info.first_flight_scheduled_date added'
END
GO

IF EXISTS (SELECT 1 FROM sys.sysobjects where id = OBJECT_ID(N'com_airport_zone_mapping'))
BEGIN
  DROP TABLE com_airport_zone_mapping
  PRINT 'com_airport_zone_mapping dropped'
END

IF EXISTS (SELECT 1 FROM sys.sysobjects where id = OBJECT_ID(N'com_airport_zone_mapping_p'))
BEGIN
  DROP TABLE com_airport_zone_mapping_p
  PRINT 'com_airport_zone_mapping_p dropped'
END

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'zone_id' AND object_id = OBJECT_ID('loc_rtl_loc'))
BEGIN
  ALTER TABLE loc_rtl_loc DROP COLUMN zone_id;
  PRINT 'loc_rtl_loc.zone_id dropped'
END
GO
--[/RXPS-17100]

--[/RXPS-17107]
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'ORIGIN_AIRPORT' AND object_id = OBJECT_ID('COM_FLIGHT_INFO'))
BEGIN
  ALTER TABLE COM_FLIGHT_INFO ADD ORIGIN_AIRPORT nvarchar(3) DEFAULT '' NOT NULL
  PRINT 'COM_FLIGHT_INFO.ORIGIN_AIRPORT added'

  ALTER TABLE COM_FLIGHT_INFO DROP CONSTRAINT pk_com_flight_info
  PRINT 'Drop current primary key'

  ALTER TABLE COM_FLIGHT_INFO ADD CONSTRAINT pk_com_flight_info PRIMARY KEY (organization_id, scheduled_date_time, origin_airport, flight_number)
  Print 'New primary key'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'ORIGIN_AIRPORT' AND object_id = OBJECT_ID('COM_FLIGHT_INFO_P'))
BEGIN
  ALTER TABLE COM_FLIGHT_INFO_P ADD ORIGIN_AIRPORT nvarchar(3) DEFAULT '' NOT NULL
  PRINT 'COM_FLIGHT_INFO_P.ORIGIN_AIRPORT added'

  ALTER TABLE COM_FLIGHT_INFO_P DROP CONSTRAINT pk_com_flight_info_p
  PRINT 'Drop current primary key'

  ALTER TABLE COM_FLIGHT_INFO_P ADD CONSTRAINT pk_com_flight_info_p PRIMARY KEY (organization_id, scheduled_date_time, origin_airport, flight_number, property_code)
  Print 'New primary key'
END
GO
--[/RXPS-17107]

--[RXPS-18272]
IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'tare_typecode' AND object_id = OBJECT_ID('itm_item_options'))
BEGIN
  ALTER TABLE itm_item_options DROP COLUMN tare_typecode;
  PRINT 'itm_item_options.tare_typecode dropped'
END

IF EXISTS (SELECT 1 FROM sys.columns where object_id = OBJECT_ID('itm_tare_type'))
BEGIN
  DROP TABLE itm_tare_type
  PRINT 'itm_tare_type dropped'
END

IF EXISTS (SELECT 1 FROM sys.columns where object_id = OBJECT_ID('itm_tare_type_p'))
BEGIN
  DROP TABLE itm_tare_type_p
  PRINT 'itm_tare_type dropped_p'
END

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'tare_value' AND object_id = OBJECT_ID('itm_item_options'))
  ALTER TABLE itm_item_options ADD tare_value decimal(11, 4) null;
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'tare_unit_of_measure_code' AND object_id = OBJECT_ID('itm_item_options'))
  ALTER TABLE itm_item_options ADD tare_unit_of_measure_code nvarchar(30) null;
GO
--[/RXPS-18272]

--[RXPS-19611]
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'serial_nbr' AND object_id = OBJECT_ID('trl_kit_component_mod'))
BEGIN
  ALTER TABLE trl_kit_component_mod ADD serial_nbr nvarchar(60) NULL;
  PRINT 'trl_kit_component_mod.serial_nbr created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'seq_nbr' AND object_id = OBJECT_ID('itm_kit_component'))
BEGIN
  ALTER TABLE itm_kit_component DROP CONSTRAINT pk_itm_kit_component;
  PRINT 'itm_kit_component primary key dropped'

  ALTER TABLE itm_kit_component ADD seq_nbr int NOT NULL DEFAULT 1;
  PRINT 'itm_kit_component.seq_nbr created'

  ALTER TABLE itm_kit_component ADD CONSTRAINT pk_itm_kit_component
    PRIMARY KEY CLUSTERED (organization_id, kit_item_id, component_item_id, seq_nbr) WITH (FILLFACTOR = 80)
  PRINT 'Primary key created itm_kit_component'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'seq_nbr' AND object_id = OBJECT_ID('itm_kit_component_p'))
BEGIN
  ALTER TABLE itm_kit_component_p DROP CONSTRAINT pk_itm_kit_component_p;
  PRINT 'itm_kit_component_p primary key dropped'

  ALTER TABLE itm_kit_component_p ADD seq_nbr int NOT NULL DEFAULT 1;
  PRINT 'itm_kit_component_p.seq_nbr created'

  ALTER TABLE itm_kit_component_p ADD CONSTRAINT pk_itm_kit_component_p
    PRIMARY KEY CLUSTERED (organization_id, kit_item_id, component_item_id, seq_nbr, property_code) WITH (FILLFACTOR = 80)
  PRINT 'Primary key created itm_kit_component_p'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'seq_nbr' AND object_id = OBJECT_ID('trl_kit_component_mod'))
BEGIN
  ALTER TABLE trl_kit_component_mod DROP CONSTRAINT pk_trl_kit_component_mod;
  PRINT 'trl_kit_component_mod primary key dropped'
  ALTER TABLE trl_kit_component_mod ADD seq_nbr int NOT NULL DEFAULT 1;
  PRINT 'trl_kit_component_mod.seq_nbr created'
  ALTER TABLE trl_kit_component_mod ADD CONSTRAINT pk_trl_kit_component_mod
    PRIMARY KEY CLUSTERED (organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq, component_item_id, seq_nbr) WITH (FILLFACTOR = 80);
  PRINT 'Primary key created trl_kit_component_mod'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'seq_nbr' AND object_id = OBJECT_ID('trl_kit_component_mod_p'))
BEGIN
  ALTER TABLE trl_kit_component_mod_p DROP CONSTRAINT pk_trl_kit_component_mod_p;
  PRINT 'trl_kit_component_mod_p primary key dropped'
  ALTER TABLE trl_kit_component_mod_p ADD seq_nbr int NOT NULL DEFAULT 1;
  PRINT 'trl_kit_component_mod_p.seq_nbr created'
  ALTER TABLE trl_kit_component_mod_p ADD CONSTRAINT pk_trl_kit_component_mod_p
    PRIMARY KEY CLUSTERED (organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq, component_item_id, seq_nbr, property_code) WITH (FILLFACTOR = 80);
  PRINT 'Primary key created trl_kit_component_mod_p'
END
GO
--[/RXPS-19611]

--[RXPS-18536]
PRINT 'CPAF_CARD_NETWORK'
IF NOT EXISTS (SELECT 1 FROM sys.objects where object_id = OBJECT_ID('cpaf_card_network'))
CREATE TABLE cpaf_card_network (
    [organization_id]  int          NOT NULL,
    [network_name]     nvarchar(254) NOT NULL,
    [network_id]       nvarchar(30)  NULL,
    [tax_id]           nvarchar(30)  NULL,
    [create_date]      datetime     NULL,
    [create_user_id]   nvarchar(30)  NULL,
    [update_date]      datetime     NULL,
    [update_user_id]   nvarchar(30)  NULL,
    [record_state]     nvarchar(30)  NULL,
    CONSTRAINT [pk_cpaf_card_network]
    PRIMARY KEY CLUSTERED (organization_id, network_name) WITH (FILLFACTOR = 80)
)
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_card_network_p'))
BEGIN
  exec Create_Property_Table cpaf_card_network;
  PRINT 'cpaf_card_network_p created'
END
GO
--[/RXPS-18536]

--[RXPS-17100]
IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'destination_airport' AND object_id = OBJECT_ID('com_flight_info') AND max_length>3 ) AND NOT EXISTS (SELECT 1 FROM com_flight_info WHERE LEN(destination_airport)>3)
  ALTER TABLE com_flight_info ALTER COLUMN destination_airport nvarchar(3) NULL;
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'via_1_airport' AND object_id = OBJECT_ID('com_flight_info') AND max_length>3 ) AND NOT EXISTS (SELECT 1 FROM com_flight_info WHERE LEN(via_1_airport)>3)
  ALTER TABLE com_flight_info ALTER COLUMN via_1_airport nvarchar(3) NULL;
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'via_2_airport' AND object_id = OBJECT_ID('com_flight_info') AND max_length>3 ) AND NOT EXISTS (SELECT 1 FROM com_flight_info WHERE LEN(via_2_airport)>3)
  ALTER TABLE com_flight_info ALTER COLUMN via_2_airport nvarchar(3) NULL;
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'via_3_airport' AND object_id = OBJECT_ID('com_flight_info') AND max_length>3 ) AND NOT EXISTS (SELECT 1 FROM com_flight_info WHERE LEN(via_3_airport)>3)
  ALTER TABLE com_flight_info ALTER COLUMN via_3_airport nvarchar(3) NULL;
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'expiration_date' AND object_id = OBJECT_ID('com_flight_info'))
BEGIN
  ALTER TABLE com_flight_info DROP COLUMN expiration_date;
  PRINT 'com_flight_info.expiration_date dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'destination_airport' AND object_id = OBJECT_ID('trl_rtrans_flight_info') AND max_length>3 ) AND NOT EXISTS (SELECT 1 FROM trl_rtrans_flight_info WHERE LEN(destination_airport)>3)
  ALTER TABLE trl_rtrans_flight_info ALTER COLUMN destination_airport nvarchar(3) NULL;
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'origin_airport' AND object_id = OBJECT_ID('trl_rtrans_flight_info') AND max_length>3 ) AND NOT EXISTS (SELECT 1 FROM trl_rtrans_flight_info WHERE LEN(origin_airport)>3)
  ALTER TABLE trl_rtrans_flight_info ALTER COLUMN origin_airport nvarchar(3) NULL;
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'expiration_date' AND object_id = OBJECT_ID('trl_rtrans_flight_info'))
BEGIN
  ALTER TABLE trl_rtrans_flight_info DROP COLUMN expiration_date;
  PRINT 'trl_rtrans_flight_info.expiration_date dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'employee_flag' AND object_id = OBJECT_ID('trl_rtrans_flight_info'))
BEGIN
  DECLARE @ConstraintName nvarchar(200)
  SELECT @ConstraintName = Name FROM SYS.DEFAULT_CONSTRAINTS WHERE PARENT_OBJECT_ID = OBJECT_ID('trl_rtrans_flight_info')
  AND PARENT_COLUMN_ID = (SELECT column_id FROM sys.columns WHERE NAME = N'employee_flag' AND object_id = OBJECT_ID(N'trl_rtrans_flight_info'))
  IF @ConstraintName IS NOT NULL
    EXEC('ALTER TABLE trl_rtrans_flight_info DROP CONSTRAINT ' + @ConstraintName)
    ALTER TABLE trl_rtrans_flight_info DROP COLUMN employee_flag;
    PRINT 'trl_rtrans_flight_info.employee_flag dropped'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'airport_code' AND object_id = OBJECT_ID('loc_rtl_loc'))
BEGIN
  ALTER TABLE loc_rtl_loc ADD airport_code nvarchar(3) null;
  PRINT 'loc_rtl_loc.airport_code added'
END
GO
--[/RXPS-17100]

--[RXPS-15284]
IF NOT EXISTS (SELECT 1 FROM sys.objects where object_id = OBJECT_ID('civc_taxfree_country'))
BEGIN
  CREATE TABLE [dbo].[civc_taxfree_country](
    [organization_id]  int             NOT NULL,
    [rtl_loc_id]       int             NOT NULL,
    [wkstn_id]         bigint          NOT NULL,
    [iso3num_code]     nvarchar(3)      NOT NULL,
    [iso2alp_code]     nvarchar(2)      NULL,
    [name]             nvarchar(150)    NULL,
    [phone_prefix]     nvarchar(4)      NULL,
    [passport_code]    nvarchar(10)     NULL,
    [void_flag]        bit             DEFAULT 0 NULL,
    [blocked_flag]     bit             DEFAULT 0 NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   nvarchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   nvarchar(30)     NULL,
    [record_state]     nvarchar(30)     NULL,
    CONSTRAINT [pk_civc_taxfree_country] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [iso3num_code]) WITH (FILLFACTOR = 80)
  )
  PRINT 'civc_taxfree_country created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('civc_taxfree_country_p'))
BEGIN
  exec Create_Property_Table civc_taxfree_country;
  PRINT 'civc_taxfree_country_p created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects where object_id = OBJECT_ID('civc_taxfree_card_range'))
BEGIN
  CREATE TABLE [dbo].[civc_taxfree_card_range](
    [organization_id]  int             NOT NULL,
    [rtl_loc_id]       int             NOT NULL,
    [wkstn_id]         bigint          NOT NULL,
    [range_start]      nvarchar(8)      NOT NULL,
    [range_end]        nvarchar(8)      NULL,
    [create_date]      datetime        NULL,
    [create_user_id]   nvarchar(30)     NULL,
    [update_date]      datetime        NULL,
    [update_user_id]   nvarchar(30)     NULL,
    [record_state]     nvarchar(30)     NULL,
    CONSTRAINT [pk_civc_taxfree_card_range] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [range_start]) WITH (FILLFACTOR = 80)
  )
  PRINT 'civc_taxfree_card_range created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('civc_taxfree_card_range_p'))
BEGIN
  exec Create_Property_Table civc_taxfree_card_range;
  PRINT 'civc_taxfree_card_range_p created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'invoice_date' AND object_id = OBJECT_ID('civc_invoice'))
BEGIN
  ALTER TABLE civc_invoice ADD invoice_date datetime NULL;
  PRINT 'civc_invoice.invoice_date created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'ext_invoice_barcode' AND object_id = OBJECT_ID('civc_invoice'))
BEGIN
  ALTER TABLE civc_invoice ADD ext_invoice_barcode nvarchar(60) NULL;
  PRINT 'civc_invoice.ext_invoice_barcode created'
END
GO
--[/RXPS-15284]

--[]
--Begin Misalignement of table structure between Oracle and Sql Server script for table itm_item_p
IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'expiration_date' AND object_id = OBJECT_ID('itm_item_p'))
BEGIN
  ALTER TABLE itm_item_p DROP COLUMN expiration_date;
  PRINT 'itm_item_p.expiration_date dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'org_code' AND object_id = OBJECT_ID('itm_item_p'))
BEGIN
  DECLARE @ConstraintName nvarchar(200)
  SELECT @ConstraintName = Name FROM SYS.DEFAULT_CONSTRAINTS WHERE PARENT_OBJECT_ID = OBJECT_ID('itm_item_p')
  AND PARENT_COLUMN_ID = (SELECT column_id FROM sys.columns WHERE NAME = N'org_code' AND object_id = OBJECT_ID(N'itm_item_p'))
  IF @ConstraintName IS NOT NULL
    EXEC('ALTER TABLE itm_item_p DROP CONSTRAINT ' + @ConstraintName)

  DROP INDEX itm_item_p.idx_itm_item_prop_orgnode;
  ALTER TABLE itm_item_p DROP COLUMN org_code;
  PRINT 'itm_item_p.org_code dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'org_value' AND object_id = OBJECT_ID('itm_item_p'))
BEGIN
	DECLARE @ConstraintName nvarchar(200)
  SELECT @ConstraintName = Name FROM SYS.DEFAULT_CONSTRAINTS WHERE PARENT_OBJECT_ID = OBJECT_ID('itm_item_p')
  AND PARENT_COLUMN_ID = (SELECT column_id FROM sys.columns WHERE NAME = N'org_value' AND object_id = OBJECT_ID(N'itm_item_p'))
  IF @ConstraintName IS NOT NULL
    EXEC('ALTER TABLE itm_item_p DROP CONSTRAINT ' + @ConstraintName)

  ALTER TABLE itm_item_p DROP COLUMN org_value;
  PRINT 'itm_item_p.org_value dropped'
END
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'effective_date' AND object_id = OBJECT_ID('itm_item_p'))
BEGIN
  ALTER TABLE itm_item_p DROP CONSTRAINT pk_itm_item_p;
  PRINT 'itm_item_p primary key dropped'
  ALTER TABLE itm_item_p DROP COLUMN effective_date;
  PRINT 'itm_item_p.effective_date dropped'
  ALTER TABLE itm_item_p ADD CONSTRAINT pk_itm_item_p
    PRIMARY KEY CLUSTERED ([organization_id], [item_id], [property_code]) WITH (FILLFACTOR = 80);
  PRINT 'Primary key created itm_item_p'
END
GO
--End Misalignement of table structure between Oracle and Sql Server script for table
--[/]

--[RXPS-19733]
IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('ctl_ip_cashdrawer_device'))
BEGIN
  CREATE TABLE [dbo].[ctl_ip_cashdrawer_device](
      [organization_id]     int             NOT NULL,
      [rtl_loc_id]          int             NOT NULL,
      [cash_drawer_id]      nvarchar(60)     NOT NULL,
      [drawer_status]       nvarchar(40),
      [product_name]        nvarchar(80),
      [description]         nvarchar(80),
      [serial_number]       nvarchar(40),
      [ip_address]          nvarchar(16),
      [tcp_port]            int,
      [mac_address]         nvarchar(20),
      [subnet_mask]         nvarchar(16),
      [gateway]             nvarchar(16),
      [dns_hostname]        nvarchar(16), 
      [dhcp_flag]           bit             DEFAULT ((0)) NULL,
      [firmware_version]    nvarchar(20),
      [kup]                 nvarchar(1024), 
      [kup_update_date]     datetime,
      [beep_on_open_flag]   bit             DEFAULT ((0)) NULL,
      [beep_long_open_flag] bit             DEFAULT ((0)) NULL,
      [create_date]         datetime        NULL,
      [create_user_id]      nvarchar(30)     NULL,
      [update_date]         datetime        NULL,
      [update_user_id]      nvarchar(30)     NULL,
      [record_state]        nvarchar(30)     NULL,
      CONSTRAINT [pk_ctl_ip_cashdrawer_device] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [cash_drawer_id]) WITH (FILLFACTOR = 80)
  )
  PRINT 'ctl_ip_cashdrawer_device created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'cash_drawer_id' AND object_id = OBJECT_ID('tsn_session'))
BEGIN
  ALTER TABLE tsn_session ADD cash_drawer_id nvarchar(60);
  PRINT 'tsn_session.cash_drawer_id added'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('ctl_ip_cashdrawer_device_p'))
BEGIN
  exec Create_Property_Table ctl_ip_cashdrawer_device;
  PRINT 'ctl_ip_cashdrawer_device_p created'
END
GO
--[/RXPS-19733]

--[/RXPS-21041]
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'tax_override_comment' AND object_id = OBJECT_ID('trl_sale_tax_lineitm'))
BEGIN
  ALTER TABLE trl_sale_tax_lineitm ADD tax_override_comment nvarchar(255);
  PRINT 'trl_sale_tax_lineitm.tax_override_comment added'
END
GO
--[/RXPS-21041]

--[RXPS-17705]
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'trans_date' AND object_id = OBJECT_ID('trn_trans'))
BEGIN
    ALTER TABLE trn_trans ADD trans_date datetime NULL;
    PRINT 'trn_trans.trans_date created';
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.indexes WHERE name = 'idx_trn_trans05' AND object_id = OBJECT_ID('trn_trans'))
BEGIN
    CREATE INDEX idx_trn_trans05 ON trn_trans(trans_date)  WITH (FILLFACTOR = 80);
    PRINT 'trn_trans.idx_trn_trans05 created';
    UPDATE trn_trans SET trans_date =  CONVERT(DATETIME, CONVERT(date,begin_datetime)) WHERE trans_date IS NULL;
    PRINT 'Updated trn_trans.trans_date using information from trn_trans.begin_datetime';
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'trans_date' AND object_id = OBJECT_ID('rpt_sale_line'))
BEGIN
    ALTER TABLE rpt_sale_line ADD trans_date datetime NULL;
    PRINT 'rpt_sale_line.trans_date created';
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.indexes WHERE name = 'idx_rpt_sale_line04' AND object_id = OBJECT_ID('rpt_sale_line'))
BEGIN
    CREATE INDEX idx_rpt_sale_line04 ON rpt_sale_line(trans_date)  WITH (FILLFACTOR = 80);
    PRINT 'rpt_sale_line.idx_rpt_sale_line04 created';
    UPDATE rpt_sale_line SET trans_date =  CONVERT(DATETIME, CONVERT(date,trans_timestamp)) WHERE trans_date IS NULL;
    PRINT 'Updated rpt_sale_line.trans_date using information from rpt_sale_line.trans_timestamp';
END
GO
--[/RXPS-17705]

--[RXPS-16698]
IF NOT EXISTS (SELECT 1 FROM sys.objects where object_id = OBJECT_ID('cpaf_nfe'))
BEGIN
CREATE TABLE [dbo].[cpaf_nfe](
  [organization_id]   INT        NOT NULL,
  [rtl_loc_id]        INT        NOT NULL,
  [environment_id]    INT        NOT NULL,
  [tp_nf]             INT        NOT NULL,
  [series_id]         INT        NOT NULL,
  [nnf]               INT        NOT NULL,
  [model]             nvarchar(2) NOT NULL,
  [cuf]               INT            NULL,
  [cnf]               INT            NULL,
  [trans_typcode]     nvarchar(30)    NULL,
  [natop]             nvarchar(60)    NULL,
  [indpag]            INT            NULL,
  [issue_date]        DATETIME       NULL,
  [sai_ent_datetime]  DATETIME       NULL,
  [cmun_fg]           nvarchar(7)     NULL,
  [tp_imp]            INT            NULL,
  [tp_emis]           INT            NULL,
  [fin_nfe]           INT            NULL,
  [proc_emi]          INT            NULL,
  [ver_proc]          nvarchar(20)    NULL,
  [cont_datetime]     DATETIME       NULL,
  [cont_xjust]        nvarchar(255)   NULL,
  [product_amount]    DECIMAL(17,6)  NULL,
  [service_amount]    DECIMAL(17,6)  NULL,
  [icms_basis]        DECIMAL(17,6)  NULL,
  [icms_amount]       DECIMAL(17,6)  NULL,
  [icms_st_basis]     DECIMAL(17,6)  NULL,
  [icms_st_amount]    DECIMAL(17,6)  NULL,
  [iss_basis]         DECIMAL(17,6)  NULL,
  [iss_amount]        DECIMAL(17,6)  NULL,
  [ii_amount]         DECIMAL(17,6)  NULL,
  [pis_amount]        DECIMAL(17,6)  NULL,
  [cofins_amount]     DECIMAL(17,6)  NULL,
  [iss_pis_amount]    DECIMAL(17,6) NULL,
  [iss_cofins_amount] DECIMAL(17,6) NULL,
  [discount_amount]   DECIMAL(17,6)  NULL,
  [freight_amount]    DECIMAL(17,6)  NULL,
  [insurance_amount]  DECIMAL(17,6)  NULL,
  [other_amount]      DECIMAL(17,6)  NULL,
  [total_amount]      DECIMAL(17,6)  NULL,
  [inf_cpl]           nvarchar(MAX)   NULL,
  [protocolo]         nvarchar(30)    NULL,
  [canc_protocolo]    nvarchar(30)    NULL,
  [chave_nfe]         nvarchar(88)    NULL,
  [old_chave_nfe]     nvarchar(88)    NULL,
  [recibo]            nvarchar(30)    NULL,
  [stat_code]         nvarchar(30)    NULL,
  [xml]               nvarchar(MAX)   NULL,
  [dig_val]           nvarchar(30)    NULL,
  [iss_service_date]  nvarchar(10)    NULL,
  [create_date]       DATETIME       NULL,
  [create_user_id]    nvarchar(30)    NULL,
  [update_date]       DATETIME       NULL,
  [update_user_id]    nvarchar(30)    NULL,
  [record_state]      nvarchar(30)    NULL,
  CONSTRAINT [pk_cpaf_nfe] 
  PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [environment_id], [tp_nf], [series_id], [nnf], [model]) WITH (FILLFACTOR = 80)
  )
  PRINT 'cpaf_nfe created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe;
  PRINT 'cpaf_nfe_p created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects where object_id = OBJECT_ID('cpaf_nfe_item'))
BEGIN
CREATE TABLE [dbo].[cpaf_nfe_item](
  [organization_id]              INT        NOT NULL,
  [rtl_loc_id]                   INT        NOT NULL,
  [environment_id]               INT        NOT NULL,
  [tp_nf]                        INT        NOT NULL,
  [series_id]                    INT        NOT NULL,
  [nnf]                          INT        NOT NULL,
  [model]                        nvarchar(2) NOT NULL,
  [sequence]                     INT        NOT NULL,
  [item_id]                      nvarchar(60)   NULL,
  [item_description]             nvarchar(254)  NULL,
  [ean]                          nvarchar(14)   NULL,
  [ncm]                          nvarchar(8)    NULL,
  [cest]                         nvarchar(18)   NULL,
  [ex_tipi]                      nvarchar(3)    NULL,
  [quantity]                     DECIMAL(11,4) NULL,
  [unit_of_measure_code]         nvarchar(30)   NULL,
  [taxable_ean]                  nvarchar(14)   NULL,
  [taxable_unit_of_measure_code] nvarchar(30)   NULL,
  [iat]                          nvarchar(1)    NULL,
  [ippt]                         nvarchar(1)    NULL,
  [unit_price]                   DECIMAL(17,6) NULL,
  [extended_amount]              DECIMAL(17,6) NULL,
  [taxable_quantity]             DECIMAL(11,4) NULL,
  [unit_taxable_amount]          DECIMAL(17,6) NULL,
  [freight_amount]               DECIMAL(17,6) NULL,
  [insurance_amount]             DECIMAL(17,6) NULL,
  [discount_amount]              DECIMAL(17,6) NULL,
  [other_amount]                 DECIMAL(17,6) NULL,
  [cfop]                         nvarchar(4)    NULL,
  [inf_ad_prod]                  nvarchar(500)  NULL,
  [icms_cst]                     nvarchar(3)    NULL,
  [icms_basis]                   DECIMAL(17,6) NULL,
  [icms_amount]                  DECIMAL(17,6) NULL,
  [icms_rate]                    DECIMAL(5,2)  NULL,
  [icms_st_basis]                DECIMAL(17,6) NULL,
  [icms_st_amount]               DECIMAL(17,6) NULL,
  [icms_st_rate]                 DECIMAL(5,2)  NULL,
  [iss_basis]                    DECIMAL(17,6) NULL,
  [iss_amount]                   DECIMAL(17,6) NULL,
  [iss_rate]                     DECIMAL(5,2)  NULL,
  [ipi_amount]                   DECIMAL(17,6) NULL,
  [ipi_rate]                     DECIMAL(5,2)  NULL,
  [ii_amount]                    DECIMAL(17,6) NULL,
  [pis_basis]                    DECIMAL(17,6) NULL,
  [pis_amount]                   DECIMAL(17,6) NULL,
  [pis_rate]                     DECIMAL(17,6) NULL,
  [cofins_basis]                 DECIMAL(17,6) NULL,
  [cofins_amount]                DECIMAL(17,6) NULL,
  [cofins_rate]                  DECIMAL(17,6) NULL,
  [tax_situation_code]           nvarchar(6)    NULL,
  [tax_group_id]                 nvarchar(120)  NULL,
  [log_sequence]                 INT           NULL,
  [ref_nfe]                      nvarchar(88)   NULL,
  [iis_city_code]                nvarchar(7)    NULL,
  [iis_service_code]             nvarchar(5)    NULL,
  [iis_eligible_indicator]       nvarchar(2)    NULL,
  [iis_incentive_indicator]      nvarchar(1)    NULL,
  [create_date]                  DATETIME      NULL,
  [create_user_id]               nvarchar(30)   NULL,
  [update_date]                  DATETIME      NULL,
  [update_user_id]               nvarchar(30)   NULL,
  [record_state]                 nvarchar(30)   NULL,
  CONSTRAINT [pk_cpaf_nfe_item]
  PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [environment_id], [tp_nf], [series_id], [nnf], [model], [sequence]) WITH (FILLFACTOR = 80)
)
  PRINT 'cpaf_nfe_item created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_item_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe_item;
  PRINT 'cpaf_nfe_item_p created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects where object_id = OBJECT_ID('cpaf_nfe_resend_queue'))
BEGIN
CREATE TABLE [dbo].[cpaf_nfe_resend_queue](
  [organization_id]  INT         NOT NULL,
  [rtl_loc_id]       INT         NOT NULL,
  [wkstn_id]         INT         NOT NULL,
  [chave_nfe]        nvarchar(88) NOT NULL,
  [copies]           INT         NULL,
  [requesting_user]  nvarchar(20) NULL,
  [email_address]    nvarchar(30) NULL,
  [create_date]      DATETIME    NULL,
  [create_user_id]   nvarchar(30) NULL,
  [update_date]      DATETIME    NULL,
  [update_user_id]   nvarchar(30) NULL,
  [record_state]     nvarchar(30) NULL,
  CONSTRAINT [pk_cpaf_nfe_resend_queue]
  PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [chave_nfe]) WITH (FILLFACTOR = 80)
)
  PRINT 'cpaf_nfe_resend_queue created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_resend_queue_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe_resend_queue;
  PRINT 'cpaf_nfe_resend_queue_p created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects where object_id = OBJECT_ID('cpaf_nfe_queue'))
BEGIN
CREATE TABLE [dbo].[cpaf_nfe_queue](
  [organization_id]   INT           NOT NULL,
  [rtl_loc_id]        INT           NOT NULL,
  [wkstn_id]          INT           NOT NULL,
  [queue_seq]         INT           NOT NULL,
  [environment_id]    INT           NULL,
  [tp_nf]             INT           NULL,
  [series_id]         INT           NULL,
  [nnf]               INT           NULL,
  [cuf]               INT           NULL,
  [cnf]               INT           NULL,
  [usage_type]        nvarchar(30)   NULL,
  [trans_typcode]     nvarchar(30)   NULL,
  [natop]             nvarchar(60)   NULL,
  [indpag]            INT           NULL,
  [model]             nvarchar(2)    NULL,
  [issue_date]        DATETIME      NULL,
  [sai_ent_datetime]  DATETIME      NULL,
  [cmun_fg]           nvarchar(7)    NULL,
  [tp_imp]            INT           NULL,
  [tp_emis]           INT           NULL,
  [fin_nfe]           INT           NULL,
  [proc_emi]          INT           NULL,
  [ver_proc]          nvarchar(20)   NULL,
  [cont_datetime]     DATETIME      NULL,
  [cont_xjust]        nvarchar(255)  NULL,
  [product_amount]    DECIMAL(17,6) NULL,
  [service_amount]    DECIMAL(17,6) NULL,
  [icms_basis]        DECIMAL(17,6) NULL,
  [icms_amount]       DECIMAL(17,6) NULL,
  [icms_st_basis]     DECIMAL(17,6) NULL,
  [icms_st_amount]    DECIMAL(17,6) NULL,
  [iss_basis]         DECIMAL(17,6) NULL,
  [iss_amount]        DECIMAL(17,6) NULL,
  [ii_amount]         DECIMAL(17,6) NULL,
  [pis_amount]        DECIMAL(17,6) NULL,
  [cofins_amount]     DECIMAL(17,6) NULL,
  [iss_pis_amount]    DECIMAL(17,6) NULL,
  [iss_cofins_amount] DECIMAL(17,6) NULL,
  [discount_amount]   DECIMAL(17,6) NULL,
  [freight_amount]    DECIMAL(17,6) NULL,
  [insurance_amount]  DECIMAL(17,6) NULL,
  [other_amount]      DECIMAL(17,6) NULL,
  [total_amount]      DECIMAL(17,6) NULL,
  [inf_cpl]           nvarchar(MAX)  NULL,
  [protocolo]         nvarchar(30)   NULL,
  [canc_protocolo]    nvarchar(30)   NULL,
  [chave_nfe]         nvarchar(88)   NULL,
  [old_chave_nfe]     nvarchar(88)   NULL,
  [recibo]            nvarchar(30)   NULL,
  [stat_code]         nvarchar(30)   NULL,
  [xml]               nvarchar(MAX)  NULL,
  [response_code]     nvarchar(30)   NULL,
  [response_text]     nvarchar(MAX)  NULL,
  [dig_val]           nvarchar(30)   NULL,
  [iss_service_date]  nvarchar(10)   NULL,
  [create_date]       DATETIME      NULL,
  [create_user_id]    nvarchar(30)   NULL,
  [update_date]       DATETIME      NULL,
  [update_user_id]    nvarchar(30)   NULL,
  [record_state]      nvarchar(30)   NULL,
  CONSTRAINT [pk_cpaf_nfe_queue] 
  PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [queue_seq]) WITH (FILLFACTOR = 80)
)
  PRINT 'cpaf_nfe_queue created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_queue_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe_queue;
  PRINT 'cpaf_nfe_queue_p created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects where object_id = OBJECT_ID('cpaf_nfe_queue_log'))
BEGIN
CREATE TABLE [dbo].[cpaf_nfe_queue_log](
  [organization_id]  INT          NOT NULL,
  [rtl_loc_id]       INT          NOT NULL,
  [wkstn_id]         INT          NOT NULL,
  [queue_seq]        INT          NOT NULL,
  [sequence]         INT          NOT NULL,
  [stat_code]        nvarchar(30)  NULL,
  [response_code]    nvarchar(30)  NULL,
  [response_text]    nvarchar(MAX) NULL,
  [source]           nvarchar(255) NULL,
  [create_date]      DATETIME     NULL,
  [create_user_id]   nvarchar(30)  NULL,
  [update_date]      DATETIME     NULL,
  [update_user_id]   nvarchar(30)  NULL,
  [record_state]     nvarchar(30)  NULL,
  CONSTRAINT [pk_cpaf_nfe_queue_log] 
  PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [queue_seq], [sequence])  WITH (FILLFACTOR = 80) 
)
  PRINT 'cpaf_nfe_queue_log created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_queue_log_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe_queue_log;
  PRINT 'cpaf_nfe_queue_log_p created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects where object_id = OBJECT_ID('cpaf_nfe_queue_item'))
BEGIN
CREATE TABLE [dbo].[cpaf_nfe_queue_item](
  [organization_id]               INT           NOT NULL,
  [rtl_loc_id]                    INT           NOT NULL,
  [wkstn_id]                      INT           NOT NULL,
  [queue_seq]                     INT           NOT NULL,
  [sequence]                      INT           NOT NULL,
  [item_id]                       nvarchar(60)   NULL,
  [item_description]              nvarchar(254)  NULL,
  [ean]                           nvarchar(14)   NULL,
  [ncm]                           nvarchar(8)    NULL,
  [cest]                          nvarchar(18)   NULL,
  [ex_tipi]                       nvarchar(3)    NULL,
  [quantity]                      DECIMAL(11,4) NULL,
  [unit_of_measure_code]          nvarchar(30)   NULL,
  [taxable_ean]                   nvarchar(14)   NULL,
  [taxable_unit_of_measure_code]  nvarchar(30)   NULL,
  [iat]                           nvarchar(1)    NULL,
  [ippt]                          nvarchar(1)    NULL,
  [unit_price]                    DECIMAL(17,6) NULL,
  [extended_amount]               DECIMAL(17,6) NULL,
  [taxable_quantity]              DECIMAL(11,4) NULL,
  [unit_taxable_amount]           DECIMAL(17,6) NULL,
  [freight_amount]                DECIMAL(17,6) NULL,
  [insurance_amount]              DECIMAL(17,6) NULL,
  [discount_amount]               DECIMAL(17,6) NULL,
  [other_amount]                  DECIMAL(17,6) NULL,
  [cfop]                          nvarchar(4)    NULL,
  [inf_ad_prod]                   nvarchar(500)  NULL,
  [icms_cst]                      nvarchar(3)    NULL,
  [icms_basis]                    DECIMAL(17,6) NULL,
  [icms_amount]                   DECIMAL(17,6) NULL,
  [icms_rate]                     DECIMAL(5,2)  NULL,
  [icms_st_basis]                 DECIMAL(17,6) NULL,
  [icms_st_amount]                DECIMAL(17,6) NULL,
  [icms_st_rate]                  DECIMAL(5,2)  NULL,
  [iss_basis]                     DECIMAL(17,6) NULL,
  [iss_amount]                    DECIMAL(17,6) NULL,
  [iss_rate]                      DECIMAL(5,2)  NULL,
  [ipi_amount]                    DECIMAL(17,6) NULL,
  [ipi_rate]                      DECIMAL(5,2)  NULL,
  [ii_amount]                     DECIMAL(17,6) NULL,
  [pis_basis]                     DECIMAL(17,6) NULL,
  [pis_amount]                    DECIMAL(17,6) NULL,
  [pis_rate]                      DECIMAL(17,6) NULL,
  [cofins_basis]                  DECIMAL(17,6) NULL,
  [cofins_amount]                 DECIMAL(17,6) NULL,
  [cofins_rate]                   DECIMAL(17,6) NULL,
  [tax_situation_code]            nvarchar(6)    NULL,
  [tax_group_id]                  nvarchar(120)  NULL,
  [log_sequence]                  INT           NULL,
  [ref_nfe]                       nvarchar(88)   NULL,
  [iis_city_code]                 nvarchar(7)    NULL,
  [iis_service_code]              nvarchar(5)    NULL,
  [iis_eligible_indicator]        nvarchar(2)    NULL,
  [iis_incentive_indicator]       nvarchar(1)    NULL,
  [create_date]                   DATETIME      NULL,
  [create_user_id]                nvarchar(30)   NULL,
  [update_date]                   DATETIME      NULL,
  [update_user_id]                nvarchar(30)   NULL,
  [record_state]                  nvarchar(30)   NULL,
  CONSTRAINT [pk_cpaf_nfe_queue_item]
  PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [queue_seq], [sequence]) WITH (FILLFACTOR = 80)
)
  PRINT 'cpaf_nfe_queue_item created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_queue_item_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe_queue_item;
  PRINT 'cpaf_nfe_queue_item_p created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects where object_id = OBJECT_ID('cpaf_nfe_queue_trans'))
BEGIN
CREATE TABLE [dbo].[cpaf_nfe_queue_trans](
  [organization_id]  INT         NOT NULL,
  [rtl_loc_id]       INT         NOT NULL,
  [wkstn_id]         INT         NOT NULL,
  [business_date]    DATETIME    NOT NULL,
  [trans_seq]        INT         NOT NULL,
  [trans_wkstn_id]   INT         NOT NULL DEFAULT (1),
  [queue_seq]        INT         NOT NULL,
  [inactive_flag]    INT         NOT NULL DEFAULT (0),
  [create_date]      DATETIME    NULL,
  [create_user_id]   nvarchar(30) NULL,
  [update_date]      DATETIME    NULL,
  [update_user_id]   nvarchar(30) NULL,
  [record_state]     nvarchar(30) NULL,
  PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [business_date], [trans_seq], [trans_wkstn_id], [queue_seq]) WITH (FILLFACTOR = 80)
)
  PRINT 'cpaf_nfe_queue_trans created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_queue_trans_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe_queue_trans;
  PRINT 'cpaf_nfe_queue_trans_p created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects where object_id = OBJECT_ID('cpaf_nfe_queue_issuer'))
BEGIN
CREATE TABLE [dbo].[cpaf_nfe_queue_issuer](
  [organization_id]  INT         NOT NULL,
  [rtl_loc_id]       INT         NOT NULL,
  [wkstn_id]         INT         NOT NULL,
  [queue_seq]        INT         NOT NULL,
  [name]             nvarchar(60) NULL,
  [fantasy_name]     nvarchar(60) NULL,
  [federal_tax_id]   nvarchar(20) NULL,
  [state_tax_id]     nvarchar(20) NULL,
  [city_tax_id]      nvarchar(20) NULL,
  [crt]              nvarchar(1)  NULL,
  [street_name]      nvarchar(60) NULL,
  [street_num]       nvarchar(60) NULL,
  [complemento]      nvarchar(60) NULL,
  [neighborhood]     nvarchar(60) NULL,
  [city_code]        nvarchar(7)  NULL,
  [city]             nvarchar(60) NULL,
  [state]            nvarchar(2)  NULL,
  [postal_code]      nvarchar(8)  NULL,
  [country_code]     nvarchar(4)  NULL,
  [country_name]     nvarchar(60) NULL,
  [telephone]        nvarchar(14) NULL,
  [create_date]      DATETIME    NULL,
  [create_user_id]   nvarchar(30) NULL,
  [update_date]      DATETIME    NULL,
  [update_user_id]   nvarchar(30) NULL,
  [record_state]     nvarchar(30) NULL,
  CONSTRAINT [pk_cpaf_nfe_queue_issuer] 
  PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [queue_seq]) WITH (FILLFACTOR = 80)
)
  PRINT 'cpaf_nfe_queue_issuer created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_queue_issuer_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe_queue_issuer;
  PRINT 'cpaf_nfe_queue_issuer_p created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects where object_id = OBJECT_ID('cpaf_nfe_queue_dest'))
BEGIN
CREATE TABLE [dbo].[cpaf_nfe_queue_dest](
  [organization_id]  INT          NOT NULL,
  [rtl_loc_id]       INT          NOT NULL,
  [wkstn_id]         INT          NOT NULL,
  [queue_seq]        INT          NOT NULL,
  [name]             nvarchar(60)  NULL,
  [federal_tax_id]   nvarchar(20)  NULL,
  [state_tax_id]     nvarchar(20)  NULL,
  [street_name]      nvarchar(60)  NULL,
  [street_num]       nvarchar(60)  NULL,
  [complemento]      nvarchar(60)  NULL,
  [neighborhood]     nvarchar(60)  NULL,
  [city_code]        nvarchar(7)   NULL,
  [city]             nvarchar(60)  NULL,
  [state]            nvarchar(2)   NULL,
  [postal_code]      nvarchar(8)   NULL,
  [country_code]     nvarchar(4)   NULL,
  [country_name]     nvarchar(60)  NULL,
  [telephone]        nvarchar(14)  NULL,
  [email]            nvarchar(60)  NULL,
  [create_date]      DATETIME     NULL,
  [create_user_id]   nvarchar(30)  NULL,
  [update_date]      DATETIME     NULL,
  [update_user_id]   nvarchar(30)  NULL,
  [record_state]     nvarchar(30)  NULL,
  CONSTRAINT [pk_cpaf_nfe_queue_dest]
  PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [queue_seq]) WITH (FILLFACTOR = 80)
)
  PRINT 'cpaf_nfe_queue_dest created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_queue_dest_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe_queue_dest;
  PRINT 'cpaf_nfe_queue_dest_p created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects where object_id = OBJECT_ID('cpaf_nfe_trans_type'))
BEGIN
CREATE TABLE [dbo].[cpaf_nfe_trans_type](
  [organization_id]      INT            NOT NULL,
  [trans_typcode]        nvarchar(30)    NOT NULL,
  [description]          nvarchar(60)    NULL,
  [notes]                nvarchar(MAX)   NULL,
  [cfop_same_uf]         nvarchar(4)     NULL,
  [cfop_other_uf]        nvarchar(4)     NULL,
  [cfop_foreign]         nvarchar(4)     NULL,
  [fin_nfe]              INT            NULL  DEFAULT(0),
  [display_order]        INT            NULL,
  [comment_req_flag]     BIT            NULL  DEFAULT(0),
  [rule_type]            nvarchar(30)    NULL  DEFAULT(0),
  [disallow_cancel_flag] BIT            NULL  DEFAULT(0),
  [pricing_type]         nvarchar(30)    NULL,
  [initial_comment]      nvarchar(254)   NULL,
  [create_date]          DATETIME       NULL,
  [create_user_id]       nvarchar(30)    NULL,
  [update_date]          DATETIME       NULL,
  [update_user_id]       nvarchar(30)    NULL,
  [record_state]         nvarchar(30)    NULL,
  CONSTRAINT [pk_cpaf_nfe_trans_type]
  PRIMARY KEY CLUSTERED ([organization_id], [trans_typcode]) WITH (FILLFACTOR = 80)
)
  PRINT 'cpaf_nfe_trans_type created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_trans_type_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe_trans_type;
  PRINT 'cpaf_nfe_trans_type_p created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects where object_id = OBJECT_ID('cpaf_nfe_trans_type_use'))
BEGIN
CREATE TABLE [dbo].[cpaf_nfe_trans_type_use](
  [organization_id]      INT            NOT NULL,
  [trans_typcode]        nvarchar(30)    NOT NULL,
  [usage_typcode]        nvarchar(30)    NOT NULL,
  [uf]                   nvarchar(2)     NOT NULL,
  [create_date]          DATETIME       NULL,
  [create_user_id]       nvarchar(30)    NULL,
  [update_date]          DATETIME       NULL,
  [update_user_id]       nvarchar(30)    NULL,
  [record_state]         nvarchar(30)    NULL,
  CONSTRAINT [pk_cpaf_nfe_trans_type_use]
  PRIMARY KEY CLUSTERED ([organization_id], [trans_typcode], [usage_typcode], [uf]) WITH (FILLFACTOR = 80)
)
  PRINT 'cpaf_nfe_trans_type_use created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_trans_type_use_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe_trans_type_use;
  PRINT 'cpaf_nfe_trans_type_use_p created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects where object_id = OBJECT_ID('cpaf_nfe_trans'))
BEGIN
CREATE TABLE [dbo].[cpaf_nfe_trans](
  [organization_id]      INT           NOT NULL,
  [rtl_loc_id]           INT           NOT NULL,
  [environment_id]       INT           NOT NULL,
  [tp_nf]                INT           NOT NULL,
  [series_id]            INT           NOT NULL,
  [nnf]                  INT           NOT NULL,
  [model]                nvarchar(2)    NOT NULL,
  [business_date]        DATETIME      NOT NULL,
  [trans_wkstn_id]       INT           NOT NULL DEFAULT (1),
  [trans_seq]            INT           NOT NULL,
  [create_date]          DATETIME      NULL,
  [create_user_id]       nvarchar(30)   NULL,
  [update_date]          DATETIME      NULL,
  [update_user_id]       nvarchar(30)   NULL,
  [record_state]         nvarchar(30)   NULL,
  CONSTRAINT [pk_cpaf_nfe_trans]
  PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [environment_id], [tp_nf], [series_id], [nnf], [model], [business_date], [trans_wkstn_id], [trans_seq]) WITH (FILLFACTOR = 80)
)
  PRINT 'cpaf_nfe_trans created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_trans_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe_trans;
  PRINT 'cpaf_nfe_trans_p created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects where object_id = OBJECT_ID('cpaf_nfe_issuer'))
BEGIN
CREATE TABLE [dbo].[cpaf_nfe_issuer](
  [organization_id]      INT          NOT NULL,
  [rtl_loc_id]           INT          NOT NULL,
  [environment_id]       INT          NOT NULL,
  [tp_nf]                INT          NOT NULL,
  [series_id]            INT          NOT NULL,
  [nnf]                  INT          NOT NULL,
  [model]                nvarchar(2)   NOT NULL,
  [name]                 nvarchar(60)  NULL,
  [fantasy_name]         nvarchar(60)  NULL,
  [federal_tax_id]       nvarchar(20)  NULL,
  [state_tax_id]         nvarchar(20)  NULL,
  [city_tax_id]          nvarchar(20)  NULL,
  [crt]                  nvarchar(1)   NULL,
  [street_name]          nvarchar(60)  NULL,
  [street_num]           nvarchar(60)  NULL,
  [complemento]          nvarchar(60)  NULL,
  [neighborhood]         nvarchar(60)  NULL,
  [city_code]            nvarchar(7)   NULL,
  [city]                 nvarchar(60)  NULL,
  [state]                nvarchar(2)   NULL,
  [postal_code]          nvarchar(8)   NULL,
  [country_code]         nvarchar(4)   NULL,
  [country_name]         nvarchar(60)  NULL,
  [telephone]            nvarchar(14)  NULL,
  [create_date]          DATETIME     NULL,
  [create_user_id]       nvarchar(30)  NULL,
  [update_date]          DATETIME     NULL,
  [update_user_id]       nvarchar(30)  NULL,
  [record_state]         nvarchar(30)  NULL,
  CONSTRAINT [pk_cpaf_nfe_issuer]
  PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [environment_id], [tp_nf], [series_id], [nnf], [model]) WITH (FILLFACTOR = 80)
)
  PRINT 'cpaf_nfe_issuer created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_issuer_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe_issuer;
  PRINT 'cpaf_nfe_issuer_p created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects where object_id = OBJECT_ID('cpaf_nfe_dest'))
BEGIN
CREATE TABLE [dbo].[cpaf_nfe_dest](
  [organization_id]      INT          NOT NULL,
  [rtl_loc_id]           INT          NOT NULL,
  [environment_id]       INT          NOT NULL,
  [tp_nf]                INT          NOT NULL,
  [series_id]            INT          NOT NULL,
  [nnf]                  INT          NOT NULL,
  [model]                nvarchar(2)   NOT NULL,
  [name]                 nvarchar(60)  NULL,
  [federal_tax_id]       nvarchar(20)  NULL,
  [state_tax_id]         nvarchar(20)  NULL,
  [street_name]          nvarchar(60)  NULL,
  [street_num]           nvarchar(60)  NULL,
  [complemento]          nvarchar(60)  NULL,
  [neighborhood]         nvarchar(60)  NULL,
  [city_code]            nvarchar(7)   NULL,
  [city]                 nvarchar(60)  NULL,
  [state]                nvarchar(2)   NULL,
  [postal_code]          nvarchar(8)   NULL,
  [country_code]         nvarchar(4)   NULL,
  [country_name]         nvarchar(60)  NULL,
  [telephone]            nvarchar(14)  NULL,
  [email]                nvarchar(60)  NULL,
  [create_date]          DATETIME     NULL,
  [create_user_id]       nvarchar(30)  NULL,
  [update_date]          DATETIME     NULL,
  [update_user_id]       nvarchar(30)  NULL,
  [record_state]         nvarchar(30)  NULL,
  CONSTRAINT [pk_cpaf_nfe_dest]
  PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [environment_id], [tp_nf], [series_id], [nnf], [model]) WITH (FILLFACTOR = 80)
)
  PRINT 'cpaf_nfe_dest created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_dest_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe_dest;
  PRINT 'cpaf_nfe_dest_p created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects where object_id = OBJECT_ID('cpaf_address_muni'))
BEGIN
CREATE TABLE [dbo].[cpaf_address_muni](
  [organization_id]         INT         NOT NULL,
  [municipality_id]         INT         NOT NULL,
  [uf]                      nvarchar(2)  NULL,
  [name]                    nvarchar(72) NULL,
  [ibge_code]               nvarchar(7)  NULL,
  [postal_code_start]       nvarchar(8)  NULL,
  [postal_code_end]         nvarchar(8)  NULL,
  [parent_municipality_id]  INT         NULL,
  [loc_in_sit]              nvarchar(1)  NULL,
  [loc_in_tipo_loc]         nvarchar(1)  NULL,
  [create_date]             DATETIME    NULL,
  [create_user_id]          nvarchar(30) NULL,
  [update_date]             DATETIME    NULL,
  [update_user_id]          nvarchar(30) NULL,
  [record_state]            nvarchar(30) NULL,
  CONSTRAINT [pk_cpaf_address_muni]
  PRIMARY KEY CLUSTERED ([organization_id], [municipality_id]) WITH (FILLFACTOR = 80)
)
  PRINT 'cpaf_address_muni created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_address_muni_p'))
BEGIN
  exec Create_Property_Table cpaf_address_muni;
  PRINT 'cpaf_address_muni_p created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects where object_id = OBJECT_ID('cpaf_nfe_trans_tax'))
BEGIN
CREATE TABLE [dbo].[cpaf_nfe_trans_tax](
  [organization_id]     INT          NOT NULL,
  [trans_typcode]       nvarchar(30)  NOT NULL,
  [uf]                  nvarchar(2)   NOT NULL,
  [dest_uf]             nvarchar(2)   NOT NULL,
  [tax_group_id]        nvarchar(120) NOT NULL,
  [new_tax_group_id]    nvarchar(120) NULL,
  [create_date]         DATETIME     NULL,
  [create_user_id]      nvarchar(30)  NULL,
  [update_date]         DATETIME     NULL,
  [update_user_id]      nvarchar(30)  NULL,
  [record_state]        nvarchar(30)  NULL,
  CONSTRAINT [pk_cpaf_nfe_trans_tax]
  PRIMARY KEY CLUSTERED ([organization_id], [trans_typcode], [uf], [dest_uf], [tax_group_id]) WITH (FILLFACTOR = 80)
)
  PRINT 'cpaf_nfe_trans_tax created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_trans_tax_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe_trans_tax;
  PRINT 'cpaf_nfe_trans_tax_p created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects where object_id = OBJECT_ID('cpaf_nfe_tax_cst'))
BEGIN
CREATE TABLE [dbo].[cpaf_nfe_tax_cst](
  [organization_id]     INT          NOT NULL,
  [trans_typcode]       nvarchar(30)  NOT NULL,
  [tax_loc_id]          nvarchar(30)  NOT NULL,
  [tax_group_id]        nvarchar(120) NOT NULL,
  [tax_authority_id]    nvarchar(60)  NOT NULL,
  [cst]                 nvarchar(2)   NULL,
  [create_date]         DATETIME     NULL,
  [create_user_id]      nvarchar(30)  NULL,
  [update_date]         DATETIME     NULL,
  [update_user_id]      nvarchar(30)  NULL,
  [record_state]        nvarchar(30)  NULL,
  CONSTRAINT [pk_cpaf_nfe_tax_cst]
  PRIMARY KEY CLUSTERED ([organization_id], [trans_typcode], [tax_loc_id], [tax_group_id], [tax_authority_id]) WITH (FILLFACTOR = 80)
)
  PRINT 'cpaf_nfe_tax_cst created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfe_tax_cst_p'))
BEGIN
  exec Create_Property_Table cpaf_nfe_tax_cst;
  PRINT 'cpaf_nfe_tax_cst_p created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects where object_id = OBJECT_ID('cpaf_nfce_queue_tender'))
BEGIN
CREATE TABLE [dbo].[cpaf_nfce_queue_tender](
  [organization_id]       INT           NOT NULL,
  [rtl_loc_id]            INT           NOT NULL,
  [wkstn_id]              INT           NOT NULL,
  [queue_seq]             INT           NOT NULL,
  [sequence]              INT           NOT NULL,
  [tndr_id]               nvarchar(60)   NOT NULL,
  [fiscal_tender_id]      nvarchar(60)   NOT NULL,
  [amount]                DECIMAL(17,6) NULL,
  [card_network_id]       nvarchar(30)   NULL,
  [card_tax_id]           nvarchar(30)   NULL,
  [card_auth_number]      nvarchar(254)  NULL,
  [card_type]             nvarchar(254)  NULL,
  [card_trace_number]     nvarchar(254)  NULL,
  [card_integration_mode] nvarchar(30)   NULL,
  [card_installments]     INT DEFAULT 0,
  [create_date]           DATETIME      NULL,
  [create_user_id]        nvarchar(30)   NULL,
  [update_date]           DATETIME      NULL,
  [update_user_id]        nvarchar(30)   NULL,
  [record_state]          nvarchar(30)   NULL,
  CONSTRAINT [pk_cpaf_nfce_queue_tender] 
  PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [queue_seq], [sequence], [tndr_id]) WITH (FILLFACTOR = 80)
)
  PRINT 'cpaf_nfce_queue_tender created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfce_queue_tender_p'))
BEGIN
  exec Create_Property_Table cpaf_nfce_queue_tender;
  PRINT 'cpaf_nfce_queue_tender_p created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects where object_id = OBJECT_ID('cpaf_nfce_tender'))
BEGIN
CREATE TABLE [dbo].[cpaf_nfce_tender](
  [organization_id]  INT           NOT NULL,
  [rtl_loc_id]       INT           NOT NULL,
  [environment_id]   INT           NOT NULL,
  [tp_nf]            INT           NOT NULL,
  [series_id]        INT           NOT NULL,
  [nnf]              INT           NOT NULL,
  [model]            nvarchar(2)    NOT NULL,
  [sequence]         INT           NOT NULL,
  [tndr_id]          nvarchar(60)   NOT NULL,
  [fiscal_tender_id] nvarchar(60 )  NOT NULL,
  [amount]           DECIMAL(17,6) NULL,
  [card_network_id]         nvarchar(30)   NULL,
  [card_tax_id]             nvarchar(30)   NULL,
  [card_auth_number]        nvarchar(254)  NULL,
  [card_type]               nvarchar(254)  NULL,
  [card_trace_number]       nvarchar(254)  NULL,
  [card_integration_mode]   nvarchar(30)   NULL,
  [card_installments]       INT DEFAULT 0,
  [create_date]      DATETIME      NULL,
  [create_user_id]   nvarchar(30)   NULL,
  [update_date]      DATETIME      NULL,
  [update_user_id]   nvarchar(30)   NULL,
  [record_state]     nvarchar(30)   NULL,
  CONSTRAINT [pk_cpaf_nfce_tender]
  PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [environment_id], [tp_nf], [series_id], [nnf], [model], [sequence], [tndr_id]) WITH (FILLFACTOR = 80)
)
  PRINT 'cpaf_nfce_tender created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_nfce_tender_p'))
BEGIN
  exec Create_Property_Table cpaf_nfce_tender;
  PRINT 'cpaf_nfce_tender_p created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects where object_id = OBJECT_ID('cpaf_sat_response'))
BEGIN
CREATE TABLE [dbo].[cpaf_sat_response](
  [organization_id]   INT           NOT NULL,
  [rtl_loc_id]        INT           NOT NULL,
  [wkstn_id]          INT           NOT NULL,
  [queue_seq]         INT           NOT NULL,
  [session_id]        INT           NOT NULL,
  [code_sate]         nvarchar(32)   NULL,
  [message_sate]      nvarchar(254)  NULL,
  [code_alert]        nvarchar(32)   NULL,
  [message_alert]     nvarchar(254)  NULL,
  [xml_string]        nvarchar(MAX)  NULL,
  [time_stamp]        DATETIME      NULL,
  [chave]             nvarchar(254)  NULL,
  [total_amount]      DECIMAL(17,6) NULL,
  [cpf_cnpj_value]    nvarchar(32)   NULL,
  [signature_QR_code] nvarchar(MAX)  NULL,
  [success]           BIT           NULL,
  [timeout]           BIT           NULL,
  [create_date]       DATETIME      NULL,
  [create_user_id]    nvarchar(30)   NULL,
  [update_date]       DATETIME      NULL,
  [update_user_id]    nvarchar(30)   NULL,
  [record_state]      nvarchar(30)   NULL,
  CONSTRAINT [pk_cpaf_sat_response] 
  PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [queue_seq], [session_id]) WITH (FILLFACTOR = 80)
)
  PRINT 'cpaf_sat_response created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('cpaf_sat_response_p'))
BEGIN
  exec Create_Property_Table cpaf_sat_response;
  PRINT 'cpaf_sat_response_p created'
END
GO

--[/RXPS-16698]

--[RXPS-21357]

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'image_url' AND object_id = OBJECT_ID('xom_item_mod'))
BEGIN
  ALTER TABLE xom_item_mod ADD image_url nvarchar(254) NULL;
  PRINT 'xom_item_mod.image_url created'
END
GO

--[/RXPS-21357]

--[RXPS-19582]
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'orig_taxable_amount' AND object_id = OBJECT_ID('trl_sale_tax_lineitm'))
BEGIN
  ALTER TABLE trl_sale_tax_lineitm ADD orig_taxable_amount decimal(17, 6);
  PRINT 'trl_sale_tax_lineitm.orig_taxable_amount added'
END
GO
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'orig_tax_group_id' AND object_id = OBJECT_ID('trl_sale_tax_lineitm'))
BEGIN
  ALTER TABLE trl_sale_tax_lineitm ADD orig_tax_group_id nvarchar(60);
  PRINT 'trl_sale_tax_lineitm.orig_tax_group_id added'
END
GO
--[/RXPS-19582]

--[RXPS-21905]
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'assign_cash_drawer_req_flag' AND object_id = OBJECT_ID('tnd_tndr_options'))
BEGIN
  EXEC('ALTER TABLE tnd_tndr_options ADD assign_cash_drawer_req_flag bit default ((0)) null');
  EXEC('UPDATE tnd_tndr_options SET assign_cash_drawer_req_flag = 0');
  PRINT 'tnd_tndr_options.assign_cash_drawer_req_flag added'
END
GO
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'post_void_assign_drawer_flag' AND object_id = OBJECT_ID('tnd_tndr_options'))
BEGIN
  EXEC('ALTER TABLE tnd_tndr_options ADD post_void_assign_drawer_flag bit default ((0)) null');
  EXEC('UPDATE tnd_tndr_options SET post_void_assign_drawer_flag = 0');
  PRINT 'tnd_tndr_options.post_void_assign_drawer_flag added'
END
GO
--[/RXPS-21905]

--[RXPS-18210]
IF NOT EXISTS (SELECT 1 FROM sys.objects where object_id = OBJECT_ID('trl_rtrans_serial_exchange'))
BEGIN
CREATE TABLE [dbo].[trl_rtrans_serial_exchange](
  [organization_id]          int               NOT NULL,
  [rtl_loc_id]               int               NOT NULL,
  [business_date]            datetime          NOT NULL,
  [wkstn_id]                 bigint            NOT NULL,
  [trans_seq]                bigint            NOT NULL,
  [rtrans_lineitm_seq]       int               NOT NULL,
  [item_id]                  nvarchar(60)       NULL,
  [orig_serial_nbr]          nvarchar(60)       NULL,
  [new_serial_nbr]           nvarchar(60)       NULL,
  [exchange_comment]         nvarchar(254)      NULL,
  [exchange_reason_code]     nvarchar(30)       NULL,
  [orig_lineitm_seq]         int               NULL,
  [orig_rtl_loc_id]          int               NULL,
  [orig_wkstn_id]            bigint            NULL,
  [orig_business_date]       datetime          NULL,
  [orig_trans_seq]           bigint            NULL,
  [create_date]              datetime          NULL,
  [create_user_id]           nvarchar(30)       NULL,
  [update_date]              datetime          NULL,
  [update_user_id]           nvarchar(30)       NULL,
  [record_state]             nvarchar(30)       NULL,
  CONSTRAINT [pk_trl_rtrans_serial_exchange] 
  PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [wkstn_id], [business_date], [trans_seq], [rtrans_lineitm_seq]) WITH (FILLFACTOR = 80)
)
  PRINT 'trl_rtrans_serial_exchange created'
END
GO

IF NOT EXISTS (SELECT 1 FROM sys.objects WHERE object_id = OBJECT_ID('trl_rtrans_serial_exchange_p'))
BEGIN
  exec Create_Property_Table trl_rtrans_serial_exchange;
  PRINT 'trl_rtrans_serial_exchange_p created'
END
GO

--[/RXPS-18210]


--[RXPS-13349]
IF NOT EXISTS (SELECT * FROM sysobjects WHERE name = 'sec_password' AND OBJECTPROPERTY(id, 'IsUserTable') = 1)
CREATE TABLE sec_password (
  [organization_id]  INT           NOT NULL,
  [password_id]      INT           NOT NULL,
  [password]         nvarchar(254)  NULL,
  [create_date]      DATETIME      NULL,
  [create_user_id]   nvarchar(30)   NULL,
  [update_date]      DATETIME      NULL,
  [update_user_id]   nvarchar(30)   NULL,
  [record_state]     nvarchar(30)   NULL,
  CONSTRAINT [pk_sec_password]
    PRIMARY KEY CLUSTERED (organization_id, password_id) WITH (FILLFACTOR = 80)
);
GO
--[/RXPS-13349]

--[RXPS-20569]
IF EXISTS (SELECT * FROM crm_party_id_xref)
BEGIN
  DELETE FROM crm_party_id_xref
  WHERE alternate_id_owner='XSTORE_LEGACY'

  INSERT INTO crm_party_id_xref(organization_id, party_id, alternate_id_owner, alternate_id, create_date, create_user_id)
  SELECT t1.organization_id, t1.party_id, 'XSTORE_LEGACY', t1.cust_id, getDate(), t1.create_user_id
  FROM crm_party t1, crm_party_id_xref t2
  WHERE t1.party_id=t2.party_id AND t2.alternate_id_owner='RELATE'

  UPDATE crm_party
  SET cust_id=alternate_id, update_date=getDate()
  FROM crm_party_id_xref
  WHERE crm_party.party_id=crm_party_id_xref.party_id AND crm_party_id_xref.alternate_id_owner='RELATE'
END
--[/RXPS-20569]

--[RXPS-24193]
IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'orig_stan' AND object_id = OBJECT_ID('trl_voucher_sale_lineitm') AND max_length=12)
  ALTER TABLE trl_voucher_sale_lineitm ALTER COLUMN orig_stan nvarchar(30) NULL;
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'orig_stan' AND object_id = OBJECT_ID('ttr_credit_debit_tndr_lineitm') AND max_length=12)
  ALTER TABLE ttr_credit_debit_tndr_lineitm ALTER COLUMN orig_stan nvarchar(30) NULL;
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'orig_stan' AND object_id = OBJECT_ID('ttr_voucher_tndr_lineitm') AND max_length=12)
  ALTER TABLE ttr_voucher_tndr_lineitm ALTER COLUMN orig_stan nvarchar(30) NULL;
GO
--[/RXPS-24193]

-- Keep at end of the script
IF  OBJECT_ID('Create_Property_Table') is not null
       DROP PROCEDURE Create_Property_Table
GO

-- LEAVE BLANK LINE BELOW
/* 
 * VIEW: Dual 
 */
 
IF  EXISTS (SELECT * FROM sys.views WHERE object_id = OBJECT_ID(N'Dual'))
    DROP VIEW Dual
GO

CREATE VIEW Dual(dummy)
AS
SELECT 'X'
GO

/* 
 * VIEW: Test_Connection 
 */
 
IF  EXISTS (SELECT * FROM sys.views WHERE object_id = OBJECT_ID(N'Test_Connection'))
    DROP VIEW Test_Connection
GO

CREATE VIEW Test_Connection(result)
AS
SELECT 1
GO

/* 
 * VIEW: [dbo].[rpt_trl_sale_lineitm_view] 
 */

IF EXISTS (Select * From information_schema.views Where table_name = 'rpt_trl_sale_lineitm_view')
  DROP VIEW rpt_trl_sale_lineitm_view;
GO

CREATE VIEW rpt_trl_sale_lineitm_view
AS
  SELECT trn.organization_id,
         trn.rtl_loc_id ,
         trn.wkstn_id ,
         trn.trans_seq ,
         tsl.rtrans_lineitm_seq ,
         trn.business_date,
         trn.begin_datetime,
         trn.end_datetime,
         trn.trans_statcode,
         trn.trans_typcode,
         trn.session_id,
         trn.operator_party_id,
         trt.cust_party_id,
         tsl.item_id,
         tsl.merch_level_1,
         tsl.quantity,
         tsl.unit_price,
         tsl.extended_amt,
         tsl.vat_amt,
         tsl.return_flag,
         tsl.net_amt,
         tsl.gross_amt,
         tsl.serial_nbr,
         tsl.sale_lineitm_typcode,
         tsl.tax_group_id,
         tsl.original_rtl_loc_id,
         tsl.original_wkstn_id,
         tsl.original_business_date,
         tsl.original_trans_seq,
         tsl.original_rtrans_lineitm_seq,
         tsl.return_reascode,
         tsl.return_comment,
         tsl.return_typcode,
         trl.void_flag,
         trl.void_lineitm_reascode,
         tsl.base_extended_price,
         tsl.rpt_base_unit_price,
         tsl.exclude_from_net_sales_flag
    FROM  
         trn_trans AS trn, 
         trl_sale_lineitm AS tsl, 
         trl_rtrans_lineitm AS trl, 
         trl_rtrans AS trt     
    WHERE 
          trn.organization_id = tsl.organization_id 
      AND trn.rtl_loc_id = tsl.rtl_loc_id
      AND trn.wkstn_id = tsl.wkstn_id 
      AND trn.business_date = tsl.business_date
      AND trn.trans_seq = tsl.trans_seq
      AND tsl.organization_id = trl.organization_id
      AND tsl.rtl_loc_id = trl.rtl_loc_id
      AND tsl.wkstn_id = trl.wkstn_id
      AND tsl.business_date = trl.business_date
      AND tsl.trans_seq = trl.trans_seq
      AND tsl.rtrans_lineitm_seq = trl.rtrans_lineitm_seq
      AND tsl.organization_id = trt.organization_id
      AND tsl.rtl_loc_id = trt.rtl_loc_id
      AND tsl.wkstn_id = trt.wkstn_id
      AND tsl.business_date = trt.business_date
      AND tsl.trans_seq = trt.trans_seq
      AND trn.trans_statcode = 'COMPLETE';
GO
/* 
 * VIEW: [dbo].[rpt_trl_stock_movement_view] 
 */

IF EXISTS (Select * From information_schema.views Where table_name = 'rpt_trl_stock_movement_view')
  DROP VIEW rpt_trl_stock_movement_view;
GO

CREATE VIEW rpt_trl_stock_movement_view
AS
SELECT itm_mov.organization_id, itm_mov.rtl_loc_id, itm_mov.business_date, itm_mov.item_id, 
      itm_mov.quantity, itm_mov.adjustment_flag
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
      AND (source_bucket_id='ON_HAND' OR dest_bucket_id='ON_HAND'))) itm_mov 

GO

/* 
 * FUNCTION: [dbo].[fn_integerListToTable] 
 */

PRINT 'dbo.fn_integerListToTable';

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[fn_integerListToTable]') AND type in (N'FN', N'IF', N'TF', N'FS', N'FT'))
	DROP FUNCTION [dbo].[fn_integerListToTable]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO


CREATE FUNCTION [dbo].[fn_integerListToTable] (@list nvarchar(MAX))
   RETURNS @tbl TABLE (number int NOT NULL) AS
BEGIN
   DECLARE @pos        int,
           @nextpos    int,
           @valuelen   int

   SELECT @pos = 0, @nextpos = 1

   WHILE @nextpos > 0
   BEGIN
      SELECT @nextpos = charindex(',', @list, @pos + 1)
      SELECT @valuelen = CASE WHEN @nextpos > 0
                              THEN @nextpos
                              ELSE len(@list) + 1
                         END - @pos - 1
      INSERT @tbl (number)
         VALUES (convert(int, substring(@list, @pos + 1, @valuelen)))
      SELECT @pos = @nextpos
   END
   RETURN
END


GO


IF EXISTS (SELECT * FROM sys.objects WHERE name = 'fn_nodesInHierarchy')
DROP FUNCTION dbo.fn_nodesInHierarchy
GO

Create FUNCTION fn_nodesInHierarchy (@vorgId INT, @vorgCode NVARCHAR(30), @vorgValue NVARCHAR(60))
RETURNS TABLE
AS
RETURN (
  WITH Nodes AS (
    SELECT organization_id, org_code, org_value, parent_code, parent_value
    FROM loc_org_hierarchy chain
    WHERE organization_id = @vorgId
      AND org_code = @vorgCode
      AND org_value = @vorgValue
    UNION ALL
    SELECT node.organization_id, node.org_code, node.org_value, node.parent_code, node.parent_value
    FROM loc_org_hierarchy node
    INNER JOIN Nodes s
      ON node.organization_id = s.organization_id
      AND node.org_code = s.parent_code
      AND node.org_value = s.parent_value
    WHERE node.organization_id = @vorgId
  )
  SELECT org_code + ':' + org_value as node
  FROM Nodes
  union
  select @vorgCode + ':' + @vorgValue as node
)
GO
IF EXISTS (SELECT * FROM sys.objects WHERE name = 'fn_storesInHierarchy')
DROP FUNCTION dbo.fn_storesInHierarchy
GO

CREATE FUNCTION dbo.fn_storesInHierarchy (@vorgId INT, @vorgCode NVARCHAR(30), @vorgValue NVARCHAR(60))
RETURNS TABLE
AS
RETURN (
  WITH Stores AS (
    SELECT organization_id, org_code, org_value
    FROM loc_org_hierarchy chain
    WHERE organization_id = @vorgId
      AND org_code = @vorgCode
      AND org_value = @vorgValue
    UNION ALL
    SELECT node.organization_id, node.org_code, node.org_value
    FROM loc_org_hierarchy node
    INNER JOIN Stores s
      ON node.organization_id = s.organization_id
      AND node.parent_code = s.org_code
      AND node.parent_value = s.org_value
    WHERE node.organization_id = @vorgId
  )
  SELECT org_value
  FROM Stores
  WHERE org_code = 'STORE'
)
GO
/* 
 * PROCEDURE: [dbo].[sp_conv_to_unicode] 
 */

IF EXISTS (Select * From sysobjects Where name = 'sp_conv_to_unicode' and type = 'P')
  DROP PROCEDURE sp_conv_to_unicode;
GO

-- =============================================
-- Author:		Brett C. White
-- Create date: 2/14/12
-- Description:	Converts all char, nvarchar, and text fields into nchar, nvarchar, and ntext.
-- =============================================
CREATE PROCEDURE sp_conv_to_unicode 
AS
BEGIN
	begin try
	create table indexlist(
		tablename	     nvarchar(max),
		indexname	     nvarchar(max),
		sql			nvarchar(max),
		is_pk		bit,
		mult			float
	)
	end try
	begin catch
	   declare @rsql0 nvarchar(max)

	   declare icur0 CURSOR FAST_FORWARD for
	   select sql from indexlist order by is_pk desc,tablename asc

	   OPEN icur0

	   WHILE 1=1
	   BEGIN
	    FETCH NEXT FROM icur0 INTO @rsql0
	    if @@FETCH_STATUS <> 0
		    break;
	    begin try
		   print @rsql0
		   exec(@rsql0)
		   delete from indexlist where sql=@rsql0
	    end try
	    begin catch
	    end catch
	   END
	   close icur0;
	   deallocate icur0;
	end catch

	declare @ctable nvarchar(max),@csql nvarchar(max),@oldtable nvarchar(max),@isql nvarchar(max),@default nvarchar(max),@ccolumn nvarchar(max),@mult float,@error nvarchar(max);

	declare column_list CURSOR FAST_FORWARD for
	select COL.table_name,name,COLUMN_NAME,'ALTER TABLE [' + COL.table_name + '] ALTER COLUMN [' + column_name + '] n' + data_type
	+ '(' + case when(character_maximum_length=-1 or character_maximum_length>=4000) then 'max' else cast(character_maximum_length as nvarchar(5)) end + ') '
	+ case when(is_nullable='no') then ' NOT NULL' else ' NULL' end
	+ case when(name is not null) then '; ALTER TABLE [' + COL.table_name + '] ADD ' + case when(isnull(is_system_named,1)=0) then 'CONSTRAINT [' + name + ']' else '' end + ' DEFAULT ' + definition + ' FOR [' + COLUMN_NAME + ']' else '' end
	from INFORMATION_SCHEMA.columns COL
	inner join INFORMATION_SCHEMA.TABLES t on t.TABLE_NAME=COL.TABLE_NAME
	left join sys.default_constraints on parent_object_id = OBJECT_ID(COL.table_name) and COL_NAME(parent_object_id, parent_column_id) = column_name
	where data_type in ('varchar','char') and TABLE_TYPE like '%table%'
	order by COL.table_name,ORDINAL_POSITION

	open column_list;

	while 1=1
	BEGIN
		FETCH NEXT FROM column_list INTO @ctable,@default,@ccolumn,@csql
		if @@FETCH_STATUS <> 0
		BEGIN
			break;
		END
		declare @iname nvarchar(max),@icolumn nvarchar(max),@itype tinyint,@PK bit,@old nvarchar(max),@oldPK bit,@unique bit,@is_included bit,@ref nvarchar(max),@fktable nvarchar(max),@fill_factor nvarchar(10)

		SET @old=null
		-- Find all Foreign Keys from this table or references this table
		if exists(SELECT 1 from sysobjects f
			 inner join sysobjects c on  f.parent_obj = c.id
			 inner join sysforeignkeys r on f.id =  r.constid
			 inner join sysobjects p on r.rkeyid = p.id
			 inner  join syscolumns rc on r.rkeyid = rc.id and r.rkey = rc.colid
			 INNER JOIN INFORMATION_SCHEMA.COLUMNS col ON rc.name=col.COLUMN_NAME and c.name=col.TABLE_NAME
			 where f.type = 'F' and (p.name=@ctable or c.name=@ctable) and DATA_TYPE in ('varchar','char'))
		BEGIN
			    declare index_list CURSOR FAST_FORWARD for
				    select c.name,f.name,'alter table [' + c.name + '] WITH CHECK ADD CONSTRAINT [' + f.name
					+ '] FOREIGN KEY (' + fc.name + ISNULL(',' + fc2.name,'') + ISNULL(',' + fc3.name,'') + ISNULL(',' + fc4.name,'')
					+ ISNULL(',' + fc5.name,'') + ISNULL(',' + fc6.name,'') + ISNULL(',' + fc7.name,'') + ISNULL(',' + fc8.name,'')
					+ ISNULL(',' + fc9.name,'') + ISNULL(',' + fc10.name,'') + ISNULL(',' + fc11.name,'') + ISNULL(',' + fc12.name,'')
					+ ISNULL(',' + fc13.name,'') + ISNULL(',' + fc14.name,'') + ISNULL(',' + fc15.name,'') + ISNULL(',' + fc16.name,'') + ')'
					+ ' REFERENCES [' + p.name + '] (' + rc.name + ISNULL(',' + rc2.name,'') + ISNULL(',' + rc3.name,'') + ISNULL(',' + rc4.name,'')
				    + ISNULL(',' + rc5.name,'') + ISNULL(',' + rc6.name,'') + ISNULL(',' + rc7.name,'') + ISNULL(',' + rc8.name,'')
				    + ISNULL(',' + rc9.name,'') + ISNULL(',' + rc10.name,'') + ISNULL(',' + rc11.name,'') + ISNULL(',' + rc12.name,'') 
				    + ISNULL(',' + rc13.name,'') + ISNULL(',' + rc14.name,'') + ISNULL(',' + rc15.name,'') + ISNULL(',' + rc16.name,'') + ')'
				    + CASE WHEN(UPDATE_RULE<>'NO ACTION') then ' ON UPDATE ' + UPDATE_RULE else '' end
				    + CASE WHEN(DELETE_RULE<>'NO ACTION') then ' ON DELETE ' + DELETE_RULE else '' end
				    from sysobjects f
				    inner join sysobjects c on  f.parent_obj = c.id
				    inner join INFORMATION_SCHEMA.REFERENTIAL_CONSTRAINTS IC on f.name=IC.CONSTRAINT_NAME
				    inner join sysreferences r on f.id =  r.constid
				    inner join sysobjects p on r.rkeyid = p.id
				    inner join syscolumns rc on r.rkeyid = rc.id and r.rkey1 = rc.colid
				    inner join syscolumns fc on r.fkeyid = fc.id and r.fkey1 = fc.colid
				    left join syscolumns rc2 on r.rkeyid = rc2.id and r.rkey2 = rc2.colid
				    left join syscolumns rc3 on r.rkeyid = rc3.id and r.rkey3 = rc3.colid
				    left join syscolumns rc4 on r.rkeyid = rc4.id and r.rkey4 = rc4.colid
				    left join syscolumns rc5 on r.rkeyid = rc5.id and r.rkey5 = rc5.colid
				    left join syscolumns rc6 on r.rkeyid = rc6.id and r.rkey6 = rc6.colid
				    left join syscolumns rc7 on r.rkeyid = rc7.id and r.rkey7 = rc7.colid
				    left join syscolumns rc8 on r.rkeyid = rc8.id and r.rkey8 = rc8.colid
				    left join syscolumns rc9 on r.rkeyid = rc9.id and r.rkey9 = rc9.colid
				    left join syscolumns rc10 on r.rkeyid = rc10.id and r.rkey10 = rc10.colid
				    left join syscolumns rc11 on r.rkeyid = rc11.id and r.rkey11 = rc11.colid
				    left join syscolumns rc12 on r.rkeyid = rc12.id and r.rkey12 = rc12.colid
				    left join syscolumns rc13 on r.rkeyid = rc13.id and r.rkey13 = rc13.colid
				    left join syscolumns rc14 on r.rkeyid = rc14.id and r.rkey14 = rc14.colid
				    left join syscolumns rc15 on r.rkeyid = rc15.id and r.rkey15 = rc15.colid
				    left join syscolumns rc16 on r.rkeyid = rc16.id and r.rkey16 = rc16.colid
				    left join syscolumns fc2 on r.fkeyid = fc2.id and r.fkey2 = fc2.colid
				    left join syscolumns fc3 on r.fkeyid = fc3.id and r.fkey3 = fc3.colid
				    left join syscolumns fc4 on r.fkeyid = fc4.id and r.fkey4 = fc4.colid
				    left join syscolumns fc5 on r.fkeyid = fc5.id and r.fkey5 = fc5.colid
				    left join syscolumns fc6 on r.fkeyid = fc6.id and r.fkey6 = fc6.colid
				    left join syscolumns fc7 on r.fkeyid = fc7.id and r.fkey7 = fc7.colid
				    left join syscolumns fc8 on r.fkeyid = fc8.id and r.fkey8 = fc8.colid
				    left join syscolumns fc9 on r.fkeyid = fc9.id and r.fkey9 = fc9.colid
				    left join syscolumns fc10 on r.fkeyid = fc10.id and r.fkey10 = fc10.colid
				    left join syscolumns fc11 on r.fkeyid = fc11.id and r.fkey11 = fc11.colid
				    left join syscolumns fc12 on r.fkeyid = fc12.id and r.fkey12 = fc12.colid
				    left join syscolumns fc13 on r.fkeyid = fc13.id and r.fkey13 = fc13.colid
				    left join syscolumns fc14 on r.fkeyid = fc14.id and r.fkey14 = fc14.colid
				    left join syscolumns fc15 on r.fkeyid = fc15.id and r.fkey15 = fc15.colid
				    left join syscolumns fc16 on r.fkeyid = fc16.id and r.fkey16 = fc16.colid
				 where f.type =  'F' and p.name=@ctable or c.name=@ctable
				 ORDER BY f.name
 
		    open index_list;
		    while 1=1
		    BEGIN
			    FETCH NEXT FROM index_list INTO @fktable,@iname,@isql
			    if @@FETCH_STATUS <> 0 break;
				    
			    insert into indexlist (tablename,indexname,sql) values(@fktable,@iname,@isql)

			    print 'ALTER TABLE [' + @fktable + '] DROP CONSTRAINT [' + @iname + ']'
			    exec('ALTER TABLE [' + @fktable + '] DROP CONSTRAINT [' + @iname + ']');
		    END
		    close index_list
		    deallocate index_list
		END
		  -- Find all check constraints.
		  declare index_list CURSOR FAST_FORWARD for
		  SELECT  cc.CONSTRAINT_NAME,CHECK_CLAUSE 
		  FROM INFORMATION_SCHEMA.CHECK_CONSTRAINTS cc 
		  INNER JOIN INFORMATION_SCHEMA.CONSTRAINT_COLUMN_USAGE c ON cc.CONSTRAINT_NAME = c.CONSTRAINT_NAME 
		  INNER JOIN INFORMATION_SCHEMA.COLUMNS col ON c.COLUMN_NAME=col.COLUMN_NAME and c.TABLE_NAME=col.TABLE_NAME
		  where DATA_TYPE in ('varchar','char') and c.TABLE_NAME=@ctable

		  open index_list;
		  while 1=1
		  BEGIN
			  FETCH NEXT FROM index_list INTO @iname,@icolumn
			  if @@FETCH_STATUS <> 0
			  break;
			  insert into indexlist (tablename,indexname,sql) values(@ctable,@iname,'ALTER TABLE [' + @ctable + ']  WITH CHECK ADD  CONSTRAINT [' + @iname + '] CHECK  (' + @icolumn + ')')
		    
			  print 'ALTER TABLE [' + @ctable + '] DROP CONSTRAINT [' + @iname + ']' 
			  exec('ALTER TABLE [' + @ctable + '] DROP CONSTRAINT [' + @iname + ']');
		  END
		  close index_list
		  deallocate index_list
		  
		set @old = null;
		-- Find all primary keys and indexes that have char and/or nvarchar columns.
		if not exists (select 1 from indexlist where tablename=@ctable and is_pk is not null) and exists(SELECT 1 FROM sys.indexes ind 
			INNER JOIN sys.index_columns ic ON ind.object_id = ic.object_id and ind.index_id = ic.index_id  
			INNER JOIN sys.columns col ON ic.object_id = col.object_id and ic.column_id = col.column_id  
			INNER JOIN sys.tables t ON ind.object_id = t.object_id  
			INNER JOIN INFORMATION_SCHEMA.COLUMNS cl on t.name=cl.TABLE_NAME and col.name=cl.COLUMN_NAME  
			WHERE ind.type in (1, 2) and is_disabled=0 and t.name=@ctable and data_type in ('varchar','char'))
		BEGIN
			declare char_index CURSOR FAST_FORWARD for
			SELECT distinct ind.name FROM sys.indexes ind 
			INNER JOIN sys.index_columns ic ON ind.object_id = ic.object_id and ind.index_id = ic.index_id  
			INNER JOIN sys.columns col ON ic.object_id = col.object_id and ic.column_id = col.column_id  
			INNER JOIN sys.tables t ON ind.object_id = t.object_id  
			INNER JOIN INFORMATION_SCHEMA.COLUMNS cl on t.name=cl.TABLE_NAME and col.name=cl.COLUMN_NAME  
			WHERE ind.type in (1, 2) and is_disabled=0 and t.name=@ctable and data_type in ('varchar','char')

			open char_index
			WHILE 1=1
			BEGIN
			    FETCH NEXT FROM char_index INTO @iname
			    if @@FETCH_STATUS<>0
				    break;
			    declare index_list CURSOR FAST_FORWARD for
			    SELECT col.name,ind.type,ind.is_primary_key,ind.is_unique,is_included_column,fill_factor  
			    FROM sys.indexes ind 
			    INNER JOIN sys.index_columns ic ON ind.object_id = ic.object_id and ind.index_id = ic.index_id  
			    INNER JOIN sys.columns col ON ic.object_id = col.object_id and ic.column_id = col.column_id  
			    INNER JOIN sys.tables t ON ind.object_id = t.object_id  
			    WHERE ind.name=@iname and t.name=@ctable
			    ORDER BY ic.key_ordinal
    			
			    open index_list;
			    while 1=1
			    BEGIN
				    FETCH NEXT FROM index_list INTO @icolumn,@itype,@PK,@unique,@is_included,@fill_factor
				    if @@FETCH_STATUS <> 0
				    BEGIN
					    if not exists(select 1 from indexlist where indexname=@old and tablename=@ctable and is_pk is not null)
					    begin
						   SET @isql=@isql + ') WITH (FILLFACTOR = ' + @fill_factor + ')'
						   SELECT @mult=1-((SUM(max_length)-450.0)/450.0) --Shrink column length to keep key size under 900
						   FROM sys.indexes ind 
						   INNER JOIN sys.index_columns ic ON ind.object_id = ic.object_id and ind.index_id = ic.index_id  
						   INNER JOIN sys.columns col ON ic.object_id = col.object_id and ic.column_id = col.column_id  
						   INNER JOIN sys.tables t ON ind.object_id = t.object_id  
						   WHERE ind.type in (1, 2) and is_disabled=0 and is_included_column=0 and ind.name=@old
						   group BY ind.name
						   if (@mult>1)
	   						   insert into indexlist (tablename,indexname,sql,is_pk) values(@ctable,@old,@isql,@oldPK)
	   					   else
	   					   begin
	   						   if(@mult<.10) SET @mult=.10
	   						   insert into indexlist (tablename,indexname,sql,is_pk,mult) values(@ctable,@old,@isql,@oldPK,@mult)
	   					   end
	   					   
	   					   if @oldPK=1
							 BEGIN TRY
								 exec('ALTER TABLE [' + @ctable + '] DROP CONSTRAINT [' + @old + ']');
								 print 'ALTER TABLE [' + @ctable + '] DROP CONSTRAINT [' + @old + ']'
							 END TRY
							 BEGIN CATCH
								 print 'ERROR: ALTER TABLE [' + @ctable + '] DROP CONSTRAINT [' + @old + '] failed: ' + error_message()
							 END CATCH
							 else
							 BEGIN TRY
								 exec('DROP INDEX [' + @ctable + '].[' + @old + ']');
								 print 'DROP INDEX [' + @ctable + '].[' + @old + ']'
							 END TRY
							 BEGIN CATCH
								 BEGIN TRY
									SET @error=error_message()
									exec('ALTER TABLE [' + @ctable + '] DROP CONSTRAINT [' + @old + ']');
									print 'ALTER TABLE [' + @ctable + '] DROP CONSTRAINT [' + @old + ']'
								 END TRY
								 BEGIN CATCH
	   								print 'ERROR: DROP INDEX [' + @ctable + '].[' + @old + ']' + ' failed: ' + @error
	   								delete from indexlist where sql=@isql
								 END CATCH
							 END CATCH
	   				    end
					    set @mult = null;
					    break;
				    END
				    if @old is not null and @old<>@iname
				    BEGIN
					    if not exists(select 1 from indexlist where indexname=@old and tablename=@ctable and is_pk is not null)
					    begin
						   SET @isql=@isql + ') WITH (FILLFACTOR = ' + @fill_factor + ')'
						   SELECT @mult=1-((SUM(max_length)-450.0)/450.0) --Shrink column length to keep key size under 900
						   FROM sys.indexes ind 
						   INNER JOIN sys.index_columns ic ON ind.object_id = ic.object_id and ind.index_id = ic.index_id  
						   INNER JOIN sys.columns col ON ic.object_id = col.object_id and ic.column_id = col.column_id  
						   INNER JOIN sys.tables t ON ind.object_id = t.object_id  
						   WHERE ind.type in (1, 2) and is_disabled=0 and is_included_column=0 and ind.name=@old
						   group BY ind.name
    					    
						   if (@mult>1)
	   						   insert into indexlist (tablename,indexname,sql,is_pk) values(@ctable,@old,@isql,@oldPK)
	   					   else
	   					   begin
	   						   if(@mult<.10) SET @mult=.10
	   						   insert into indexlist (tablename,indexname,sql,is_pk,mult) values(@ctable,@old,@isql,@oldPK,@mult)
	   					   end

	   					   if @oldPK=1
							 BEGIN TRY
								 exec('ALTER TABLE [' + @ctable + '] DROP CONSTRAINT [' + @old + ']');
								 print 'ALTER TABLE [' + @ctable + '] DROP CONSTRAINT [' + @old + ']'
							 END TRY
							 BEGIN CATCH
								 print 'ERROR: ALTER TABLE [' + @ctable + '] DROP CONSTRAINT [' + @old + '] failed: ' + error_message()
							 END CATCH
							 else
							 BEGIN TRY
								 exec('DROP INDEX [' + @ctable + '].[' + @old + ']');
								 print 'DROP INDEX [' + @ctable + '].[' + @old + ']'
							 END TRY
							 BEGIN CATCH
								 BEGIN TRY
									SET @error=error_message()
									exec('ALTER TABLE [' + @ctable + '] DROP CONSTRAINT [' + @old + ']');
									print 'ALTER TABLE [' + @ctable + '] DROP CONSTRAINT [' + @old + ']'
								 END TRY
								 BEGIN CATCH
	   								print 'ERROR: DROP INDEX [' + @ctable + '].[' + @old + ']' + ' failed: ' + @error
	   								delete from indexlist where sql=@isql
								 END CATCH
							 END CATCH
	   				    end
					    set @mult = null;

					    if @PK=1
					    begin
						    SET @isql='ALTER TABLE [' + @ctable + '] ADD CONSTRAINT [' + @iname + '] PRIMARY KEY '
						    if @itype=1
							    SET @isql=@isql + ' CLUSTERED '
						    SET @isql=@isql + '('
					    end
					    else
					    BEGIN
						    SET @isql='CREATE '
						    if @unique=1
							    SET @isql=@isql + ' UNIQUE '
						    SET @isql=@isql + 'INDEX [' + @iname + '] ON [' + @ctable + '] ('
					    END
					    SET @oldPK=@PK
					    SET @old=@iname
				    END
				    ELSE IF @old is null
				    BEGIN
					    SET @old=@iname
					    SET @oldPK=@PK
    					
					    if @PK=1
					    begin
						    SET @isql='ALTER TABLE [' + @ctable + '] ADD CONSTRAINT [' + @iname + '] PRIMARY KEY '
						    if @itype=1
							    SET @isql=@isql + ' CLUSTERED '
						    SET @isql=@isql + '('
					    end
					    else
					    BEGIN
						    SET @isql='CREATE '
						    if @unique=1
							    SET @isql=@isql + ' UNIQUE '
						    SET @isql=@isql + 'INDEX [' + @iname + '] ON [' + @ctable + '] ('
					    END
				    END
				    ELSE IF @is_included=1 AND CHARINDEX(') INCLUDE (',@isql)=0
					    SET @isql=@isql + ') INCLUDE (';
				    ELSE
					    SET @isql=@isql + ','
    				
				    SET @isql=@isql + '[' + @icolumn + ']'
			    END
			    close index_list
			    deallocate index_list
			END
		     close char_index
		     deallocate char_index
		END
		-- Find statistics
		  declare stat_list CURSOR FAST_FORWARD for
		  select name, user_created, stats_id from sys.stats where object_id=OBJECT_ID(@ctable)
		  declare @user_created bit,@stats_id int;
		  open stat_list;
		  while 1=1
		  BEGIN
			  FETCH NEXT FROM stat_list INTO @iname,@user_created,@stats_id
			  if @@FETCH_STATUS <> 0
				break;
			  if @user_created=0
				continue;
			declare @columns nvarchar(max);
			set @columns='';
			declare scolumns cursor fast_forward for
			select col.name from sys.stats_columns sc
			INNER JOIN sys.columns col ON sc.object_id = col.object_id and sc.column_id = col.column_id  
			where sc.object_id=OBJECT_ID(@ctable) and stats_id=@stats_id order by stats_column_id

			open scolumns;
			while 1=1
			BEGIN
			    FETCH NEXT FROM scolumns INTO @icolumn
			    if @@FETCH_STATUS <> 0
				   break;
			    set @columns = @columns + @icolumn + ','
			END
			close scolumns
			deallocate scolumns
			insert into indexlist (tablename,indexname,sql) values(@ctable,@iname,'CREATE STATISTICS [' + @iname + '] ON [' + @ctable + '] (' + left(@columns,len(@columns)-1) + ')')
		    
			print 'DROP STATISTICS [' + @ctable + '].[' + @iname + ']' 
			exec('DROP STATISTICS [' + @ctable + '].[' + @iname + ']');
		  END
		  close stat_list
		  deallocate stat_list
		-- Calculate new char lengths for key columns that index key is over 900 not including include columns
		if exists(select 1 from indexlist where tablename=@ctable AND CHARINDEX(@ccolumn,sql,1)>0 and mult is not null and (CHARINDEX('INCLUDE (',sql,1)=0 or CHARINDEX(@ccolumn,sql,1)<CHARINDEX('INCLUDE (',sql,1)))
		begin
		  select top 1 @mult=ABS(mult) from indexlist where tablename=@ctable AND CHARINDEX(@ccolumn,sql)>0 and mult is not null;
		  SELECT @csql=REPLACE(@csql,cast(max_length as nvarchar(5)),cast(round(max_length*@mult,0) as varchar(5))) FROM sys.columns where object_id=object_id(@ctable) and name=@ccolumn and max_length>50
		end
		-- Drop default constraints.
		if @default is not null
		BEGIN
			print 'ALTER TABLE [' + @ctable + '] DROP CONSTRAINT [' + @default + ']'
			exec('ALTER TABLE [' + @ctable + '] DROP CONSTRAINT [' + @default + ']')
		END
		-- Convert the columns to unicode and add back the default constraints.
		begin try
		    exec(@csql)
		    print @csql
		end try
		begin catch
	   		print 'ERROR: ' + @csql + ' failed: ' + error_message()
		end catch
	END 
	
	-- Re-create the indexes, keys, and constraints
	declare @rsql nvarchar(max)

	declare icur CURSOR FAST_FORWARD for
	select sql from indexlist order by is_pk desc,tablename asc

	OPEN icur

	WHILE 1=1
	BEGIN
		FETCH NEXT FROM icur INTO @rsql
		if @@FETCH_STATUS <> 0
			break;
		begin try
		    exec(@rsql)
		    print @rsql
		    delete from indexlist where sql=@rsql
		end try
		begin catch
		    print 'ERROR: ' + @rsql + ' failed: ' + error_message()
		end catch
	END
	close icur
	deallocate icur
	
	if not exists(select 1 from indexlist)
	   drop table indexlist
	close column_list
	deallocate column_list
	
	-- Convert to Text columns to NText
	declare @ttable nvarchar(max),@tcolumn nvarchar(max);

	declare text_list CURSOR FAST_FORWARD for
	select COL.table_name,col.COLUMN_NAME
	from INFORMATION_SCHEMA.columns COL
	inner join INFORMATION_SCHEMA.TABLES t on t.TABLE_NAME=COL.TABLE_NAME
	left join sys.default_constraints on parent_object_id = OBJECT_ID(COL.table_name) and COL_NAME(parent_object_id, parent_column_id) = column_name
	where data_type in ('text') and TABLE_TYPE like '%table%'
	order by COL.table_name,ORDINAL_POSITION

	open text_list

	while 1=1
	begin
		FETCH NEXT FROM text_list INTO @ttable,@tcolumn
		if @@FETCH_STATUS <> 0
			break;
		
		SET @old=@tcolumn + '_old'
		SET @oldtable=@ttable + '.' + @tcolumn

		print 'sp_rename ' + @oldtable + ',' + @old + ', ''COLUMN''';
		EXEC sp_rename @oldtable, @old, 'COLUMN';
		
		print 'ALTER TABLE ' + @ttable + ' ADD ' + @tcolumn + ' NTEXT NULL'
		EXEC('ALTER TABLE ' + @ttable + ' ADD ' + @tcolumn + ' NTEXT NULL')
		
		print 'UPDATE ' + @ttable + ' SET ' + @tcolumn + ' = ' + @old
		EXEC('UPDATE ' + @ttable + ' SET ' + @tcolumn + ' = ' + @old)

		print 'ALTER TABLE ' + @ttable + ' DROP COLUMN ' + @old
		exec('ALTER TABLE ' + @ttable + ' DROP COLUMN ' + @old)
	end
	close text_list
	deallocate text_list
	
	PRINT 'PLEASE UPDATE THE STORED PROCEDURES, FUNCTIONS, AND TRIGGERS MANUALLY!!!'
END
GO
PRINT 'dbo.sp_defrag_indexes';
GO

IF OBJECT_ID('dbo.sp_defrag_indexes') IS NOT NULL
	DROP PROCEDURE dbo.sp_defrag_indexes;
GO
	
CREATE PROCEDURE dbo.sp_defrag_indexes (@minfrag int = 10,
					  					@minindexpages int = 1)
AS
BEGIN
-------------------------------------------------------------------------------------------------------------------
--                                                                                                               --
-- Procedure         : sp_defrag_indexes (@minfrag int, @minindexpage int)										 --
-- Parameters		 : minfrag - The minum about a fragmentation allowed in the database.  Tables with less than
--                               the amont specified will not be reorganized.
--                   : minindexpages - The minum number of pages in the indexes for a reorganized to be performed --
-- Description       : Reorganizes the tables that are fragmented with the respective minimume fragmentation 
-- Version           : 16.0                                                                                       --
-------------------------------------------------------------------------------------------------------------------
--                            CHANGE HISTORY                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- WHO DATE      DESCRIPTION                                                                                     --
-- ST  01/30/07  Initially created
-- PGH 11/07/09  Rewriten for 2005 / 2008
-- BCW 12/02/11  Added fill factor to rebuild
-------------------------------------------------------------------------------------------------------------------
-- Declare variables

	SET NOCOUNT ON
	SET QUOTED_IDENTIFIER ON

	DECLARE @ls_version		 nvarchar(128),
			@li_version			integer,
			@li_pos				integer,
			@table_nm		 nvarchar (128),
			@index_nm		 nvarchar(128),
			@objectid			INT,
			@indexid			INT,
			@part_nbr			int,
			@index_typ		 nvarchar(60),
			@index_depth		int,
			@page_cnt			int,
			@frag				DECIMAL,
			@dbname				sysname,
			@ls_sqlcmd			nvarchar(128)

	--check to verify the version, this procedure is using the DMV views introduced in 2005
	--check this is being run in a user database
	SET @ls_version = CONVERT(varchar(128), SERVERPROPERTY ('ProductVersion'))
	SET @li_pos = CHARINDEX('.', @ls_version) - 1
	SET @li_version = CONVERT(int, SUBSTRING(@ls_version, 1, @li_pos))
	IF @li_version < 9
	BEGIN
		PRINT 'Wrong Version, this procedure requires SQL SERVER 2005 or greater'
		RETURN
	END

	SELECT @dbname = db_name()
	IF @dbname IN ('master', 'msdb', 'model', 'tempdb')
	BEGIN
		PRINT 'This procedure should not be run in system databases.'
		RETURN
	END

	--begin Stage 1: Find the indexes with fragmentation
	-- Declare cursor 
	DECLARE FindIDXFrag CURSOR FOR
	SELECT object_name(i.object_id) as 'Table Name', 
			i.name as 'Index Name',
			i.object_id,
			i.index_id,
			partition_number,
			index_type_desc,
			index_depth,
			avg_fragmentation_in_percent,
			page_count
		FROM sys.dm_db_index_physical_stats(db_id(), NULL, NULL, NULL , NULL) ips
		JOIN sys.indexes i on i.object_id = ips.object_id and i.index_id = ips.index_id
		where index_type_desc in ('CLUSTERED INDEX', 'NONCLUSTERED INDEX')
		  --and avg_fragmentation_in_percent > @minfrag
		  and page_count > @minindexpages

	---- Report the ouput of showcontig for results checking
	-- SELECT * FROM #fraglist order by 1

	-- Write to output start time for information purposes
	PRINT 'Started defragmenting indexes at ' + CONVERT(VARCHAR,GETDATE())
	PRINT 'REORGANIZING:'

	-- Open the cursor
	OPEN FindIDXFrag

	-- Loop through the indexes
	FETCH NEXT
	FROM FindIDXFrag
	INTO @table_nm,
		@index_nm,
		@objectid,
		@indexid,
		@part_nbr,
		@index_typ,
		@index_depth,
		@frag,
		@page_cnt

	WHILE @@FETCH_STATUS = 0
	BEGIN

		IF @frag > @minfrag
		BEGIN 
			IF @frag > 50
				BEGIN
					PRINT 'Index ' + @index_nm + ' on ' + @table_nm + ' Rebuilt';
--					SET @ls_sqlcmd = 'ALTER INDEX [' + @index_nm + '] on [' + @table_nm + '] REBUILD WITH ONLINE=ON';  -- Online only works with Enterprise Edition
					SET @ls_sqlcmd = 'ALTER INDEX [' + @index_nm + '] on [' + @table_nm + '] REBUILD WITH (FILLFACTOR = 80)';
					print @ls_sqlcmd;
					exec (@ls_sqlcmd);
				END;
			ELSE
				BEGIN
					PRINT 'Index ' + @index_nm + ' on ' + @table_nm + ' Reorganized';
					SET @ls_sqlcmd = 'ALTER INDEX [' + @index_nm + '] on [' + @table_nm + '] REORGANIZE';
					--print @ls_sqlcmd;
					exec (@ls_sqlcmd);
					SET @ls_sqlcmd = 'UPDATE STATISTICS [' + @table_nm + '] [' + @index_nm + ']';
					--print @ls_sqlcmd;
					exec (@ls_sqlcmd);
				END;
		END;
		ELSE
			BEGIN
				PRINT 'Index ' + @index_nm + ' on ' + @table_nm + ' Statistics Updated';
				SET @ls_sqlcmd = 'UPDATE STATISTICS [' + @table_nm + '] [' + @index_nm + ']';
				--print @ls_sqlcmd;
				exec (@ls_sqlcmd);
			END;
		
		FETCH NEXT
		FROM FindIDXFrag
			INTO  @table_nm,
				@index_nm,
				@objectid,
				@indexid,
				@part_nbr,
				@index_typ,
				@index_depth,
				@frag,
				@page_cnt;
		
	END;

	-- Close and deallocate the cursor
	CLOSE FindIDXFrag;
	DEALLOCATE FindIDXFrag;

	-- move back to full mode 
	-- alter database xstore set recovery full

	-- Report on finish time for information purposes
	PRINT 'Finished defragmenting indexes at ' + CONVERT(VARCHAR,GETDATE());
END
GO
/* 
 * PROCEDURE: [dbo].[sp_fifo_detail] 
 */

PRINT 'dbo.sp_fifo_detail';

IF EXISTS (Select * From sysobjects Where name = 'sp_fifo_detail' and type = 'P')
  DROP PROCEDURE sp_fifo_detail;
GO

CREATE PROCEDURE [dbo].[sp_fifo_detail] 
    @merch_level_1_param nvarchar(60), 
    @merch_level_2_param nvarchar(60), 
    @merch_level_3_param nvarchar(60), 
    @merch_level_4_param nvarchar(60),
    @item_id_param          nvarchar(60),
    @style_id_param         nvarchar(60),
    @rtl_loc_id_param	 nvarchar(MAX), 
    @organization_id_param	int,
    @user_name_param	 nvarchar(30),
    @stock_val_date_param   DATETIME
 
 AS
BEGIN

  --TRUNCATE TABLE rpt_fifo_detail;
  DELETE FROM rpt_fifo_detail WHERE user_name = @user_name_param

  DECLARE 
            @organization_id		 int,
            @organization_id_a		 int,
            @item_id				 nvarchar(60),
            @item_id_a				 nvarchar(60),
            @description			 nvarchar(254),
            @description_a			 nvarchar(254),
            @style_id				 nvarchar(60),
            @style_id_a				 nvarchar(60),
            @style_desc			     nvarchar(254),
            @style_desc_a			 nvarchar(254),
            @rtl_loc_id				 int,
            @rtl_loc_id_a			 int,
            @store_name				 nvarchar(254),
            @store_name_a			 nvarchar(254),
            @invctl_document_id		 nvarchar(30),
            @invctl_document_id_a	 nvarchar(30),
            @invctl_document_nbr	 int,
            @invctl_document_nbr_a	 int,
            @create_date_timestamp	 DATETIME,
            @create_date_timestamp_a DATETIME,
            @unit_count				 DECIMAL(14,4),
            @unit_count_a			 DECIMAL(14,4),
            @current_unit_count		 DECIMAL(14,4),
            @unit_cost				 DECIMAL(17,6),
            @unit_cost_a			 DECIMAL(17,6),
            @unitCount				 DECIMAL(14,4),
            @unitCount_a			 DECIMAL(14,4),

            @comment				 nvarchar(254),

            @current_item_id		 nvarchar(60),
            @pending_unitCount		 DEC(14,4),
            
            @insert					 smallint;
  
  DECLARE tableCur CURSOR READ_ONLY FOR 
      SELECT MAX(sla.organization_id), MAX(COALESCE(sla.unitcount,0)) + MAX(COALESCE(ts.quantity, 0)) AS quantity, 
                  sla.item_id, MAX(i.description), MAX(style.item_id), MAX(style.description), 
		          l.rtl_loc_id, MAX(l.store_name), doc.invctl_document_id, doc.invctl_document_line_nbr,
                  doc.create_date, MAX(COALESCE(doc.unit_count,0)), MAX(COALESCE(doc.unit_cost,0))
      FROM loc_rtl_loc l, fn_integerListToTable(@rtl_loc_id_param) fn, 
			(SELECT organization_id, item_id, COALESCE(SUM(unitcount),0) AS unitcount 
				FROM inv_stock_ledger_acct, fn_integerListToTable(@rtl_loc_id_param) fn
				WHERE fn.number = rtl_loc_id 
                    AND bucket_id = 'ON_HAND'
				GROUP BY organization_id, item_id) sla
		    LEFT OUTER JOIN
            (SELECT itm_mov.organization_id, itm_mov.rtl_loc_id, itm_mov.item_id, 
	                SUM(COALESCE(quantity,0) * CASE WHEN adjustment_flag = 1 THEN 1 ELSE -1 END) AS quantity
	         FROM rpt_trl_stock_movement_view itm_mov
	         WHERE CONVERT(char(10),business_date,120) > CONVERT(char(10),@stock_val_date_param,120)
	         GROUP BY itm_mov.organization_id, itm_mov.rtl_loc_id, itm_mov.item_id) ts
	         ON sla.organization_id = ts.organization_id
	            AND sla.item_id = ts.item_id
            LEFT OUTER JOIN (
                  SELECT id.organization_id, idl.inventory_item_id, idl.rtl_loc_id , id.invctl_document_id, 
                        idl.invctl_document_line_nbr, idl.create_date, COALESCE(idl.unit_count,0) AS unit_count, COALESCE(idl.unit_cost,0) AS unit_cost
                  FROM inv_invctl_document_lineitm idl, fn_integerListToTable(@rtl_loc_id_param) fn, inv_invctl_document id
                  WHERE idl.organization_id = id.organization_id AND idl.rtl_loc_id = id.rtl_loc_id AND 
                        idl.document_typcode = id.document_typcode AND idl.invctl_document_id = id.invctl_document_id AND 
                        idl.unit_count IS NOT NULL AND idl.unit_cost IS NOT NULL AND idl.create_date IS NOT NULL AND
                        id.document_subtypcode = 'ASN'
                        AND id.status_code IN ('CLOSED', 'OPEN', 'IN_PROCESS')
                        AND CAST(FLOOR(CAST(idl.create_date AS FLOAT)) AS DATETIME) <= @stock_val_date_param
                        AND fn.number = idl.rtl_loc_id 
                        AND @organization_id_param = idl.organization_id
            ) doc
            on sla.organization_id = doc.organization_id AND 
               sla.item_id = doc.inventory_item_id
            INNER JOIN itm_item i
            ON sla.item_id = i.item_id AND
               sla.organization_id = i.organization_id
            LEFT OUTER JOIN itm_item style
            ON i.parent_item_id = style.item_id AND
               i.organization_id = style.organization_id
      WHERE @merch_level_1_param in (i.merch_level_1,'%') AND @merch_level_2_param in (i.merch_level_2,'%') AND 
            @merch_level_3_param IN (i.merch_level_3,'%') AND @merch_level_4_param IN (i.merch_level_4,'%') AND
            @item_id_param IN (i.item_id,'%') AND @style_id_param IN (i.parent_item_id,'%') AND
            sla.organization_id = l.organization_id AND 
            fn.number = l.rtl_loc_id AND 
            doc.rtl_loc_id = l.rtl_loc_id AND 
            COALESCE(sla.unitcount,0) + COALESCE(ts.quantity, 0) <> 0
      GROUP BY style.item_id, sla.item_id, doc.invctl_document_id, l.rtl_loc_id, doc.invctl_document_line_nbr, doc.create_date
      ORDER BY sla.item_id,doc.create_date DESC;
      
  BEGIN
    SET @comment = '';
    SET @current_item_id = '';
    SET @pending_unitCount = 0;
    SET @insert = 0;
    OPEN tableCur;
    FETCH tableCur INTO @organization_id, @unitcount, @item_id, @description, @style_id, @style_desc, @rtl_loc_id, @store_name, @invctl_document_id, @invctl_document_nbr,@create_date_timestamp, @unit_count, @unit_cost;
    WHILE @@FETCH_STATUS = 0 
    BEGIN
      IF @current_item_id <> @item_id
      BEGIN
        SET @current_item_id = @item_id;
        SET @pending_unitCount = @unitcount;
      END
		IF @pending_unitCount > 0
		BEGIN
		  IF @pending_unitCount < @unit_count
		  BEGIN
			SET @current_unit_count = @pending_unitCount;
			SET @pending_unitCount = 0;
		  END 
		  ELSE
		  BEGIN
			SET @current_unit_count = @unit_count ;
			SET @pending_unitCount = @pending_unitCount - @unit_count;
		  END
		  SET @insert = 1;
		END
		ELSE IF @pending_unitCount < 0
		   SET @insert = 1;
		ELSE
		   SET @insert = 0;
	      
		SET @organization_id_a = @organization_id
		SET @unitcount_a = @unitcount;
		SET @item_id_a = @item_id;
		SET @description_a = @description;
		SET @style_id_a = @style_id;
		SET @style_desc_a = @style_desc;
		SET @rtl_loc_id_a = @rtl_loc_id;
		SET @store_name_a = @store_name;
		SET @invctl_document_id_a = @invctl_document_id;
		SET @invctl_document_nbr_a = @invctl_document_nbr;
		SET @create_date_timestamp_a = @create_date_timestamp;
		SET @unit_count_a = @unit_count;
		SET @unit_cost_a = @unit_cost;
	  
		FETCH tableCur INTO @organization_id, @unitcount, @item_id, @description, @style_id, @style_desc, @rtl_loc_id, @store_name, @invctl_document_id, @invctl_document_nbr, @create_date_timestamp, @unit_count, @unit_cost;
		IF (@pending_unitCount >= 0 OR @@FETCH_STATUS < 0  OR @item_id <> @item_id_a) AND @insert = 1
		BEGIN
		  SET @comment = '';
		  IF ((@item_id_a <> @item_id AND @pending_unitCount > 0) OR @@FETCH_STATUS < 0)
		  BEGIN
			 IF @pending_unitCount > 0
			 BEGIN
			   SET @comment = '_rptLackDocStockVal';
			 END
		  END
		  IF @pending_unitCount < 0
			 BEGIN
			   SET @invctl_document_id_a = '_rptNoAvailDocStockVal';
			   SET @unit_cost_a = null;
			   SET @unit_count_a = null;
			   SET @current_unit_count = null;
			   SET @create_date_timestamp_a = null;
			   SET @comment = '_rptLackDocStockVal';
			 END
		  INSERT INTO rpt_fifo_detail (organization_id, rtl_loc_id, item_id, invctl_doc_id, user_name, invctl_doc_create_date, description, store_name, 
				 unit_count, current_unit_count, unit_cost, unit_count_a, current_cost, comment, pending_count, style_id, style_desc, invctl_doc_line_nbr)
		  VALUES(@organization_id_a, @rtl_loc_id_a, @item_id_a, @invctl_document_id_a, @user_name_param, @create_date_timestamp_a, @description_a, @store_name_a,
				 @unit_count_a, @current_unit_count, @unit_cost_a, @unitcount_a, @current_unit_count * @unit_cost_a, @comment, @pending_unitCount, @style_id_a, @style_desc_a, @invctl_document_nbr_a);
		END
    END
    CLOSE tableCur;
    DEALLOCATE tableCur;
  END
END
GO
/* 
 * PROCEDURE: [dbo].[sp_fifo_summary] 
 */

PRINT 'dbo.sp_fifo_summary';

IF EXISTS (Select * From sysobjects Where name = 'sp_fifo_summary' and type = 'P')
  DROP PROCEDURE sp_fifo_summary;
GO

CREATE PROCEDURE [dbo].[sp_fifo_summary] 
    @merch_level_1_param nvarchar(60), 
    @merch_level_2_param nvarchar(60), 
    @merch_level_3_param nvarchar(60), 
    @merch_level_4_param nvarchar(60),
    @item_id_param          nvarchar(60),
    @style_id_param         nvarchar(60),
    @rtl_loc_id_param	 nvarchar(MAX), 
    @organization_id_param	int,
    @user_name_param        nvarchar(30),
    @stock_val_date_param   DATETIME
 
AS
BEGIN
  --TRUNCATE TABLE rpt_fifo;
  DELETE FROM rpt_fifo WHERE user_name = @user_name_param
  EXEC sp_fifo_detail @merch_level_1_param, @merch_level_2_param, @merch_level_3_param, @merch_level_4_param, @item_id_param, @style_id_param, @rtl_loc_id_param, @organization_id_param, @user_name_param, @stock_val_date_param
  
  DECLARE 
      @organization_id		 int,
      @unit_count			 DECIMAL(14,4),
      @item_id				 nvarchar(60),
      @description			 nvarchar(254),
      @style_id				 nvarchar(60),
      @style_desc			 nvarchar(254),
      @rtl_loc_id			 int,
      @store_name			 nvarchar(254),
      @unit_cost			 DECIMAL(17,6),
      @comment				 nvarchar(254)
  
  DECLARE tableCur CURSOR READ_ONLY FOR 
  
	  SELECT MAX(sla.organization_id), MAX(COALESCE(sla.unitcount,0)) + MAX(COALESCE(ts.quantity, 0)) AS quantity, 
	      sla.item_id, MAX(i.description), style.item_id, MAX(style.description), sla.rtl_loc_id, 
	      MAX(l.store_name), MAX(COALESCE(fifo_detail.unit_cost,0)), MAX(fifo_detail.comment)
	  FROM loc_rtl_loc l, fn_integerListToTable(@rtl_loc_id_param) fn, inv_stock_ledger_acct sla
	  	  
	  LEFT OUTER JOIN
	  (SELECT itm_mov.organization_id, itm_mov.rtl_loc_id, itm_mov.item_id, 
			SUM(COALESCE(quantity,0) * CASE WHEN adjustment_flag = 1 THEN 1 ELSE -1 END) AS quantity
	   FROM rpt_trl_stock_movement_view itm_mov
	   WHERE CONVERT(char(10),business_date,120) > CONVERT(CHAR(10),@stock_val_date_param,120) 
	   GROUP BY itm_mov.organization_id, itm_mov.rtl_loc_id, itm_mov.item_id) ts
	   ON sla.organization_id = ts.organization_id
     		AND sla.rtl_loc_id = ts.rtl_loc_id
			AND sla.item_id = ts.item_id
	  LEFT OUTER JOIN (
			SELECT organization_id, item_id, SUM(current_cost)/SUM(current_unit_count) as unit_cost, MAX(comment) as comment
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
	  WHERE @merch_level_1_param in (i.merch_level_1,'%') AND @merch_level_2_param in (i.merch_level_2,'%') AND 
            @merch_level_3_param IN (i.merch_level_3,'%') AND @merch_level_4_param IN (i.merch_level_4,'%') AND
            @item_id_param IN (i.item_id,'%') AND @style_id_param IN (i.parent_item_id,'%') AND
		    fn.number = sla.rtl_loc_id AND
		    sla.organization_id = l.organization_id AND 
		    sla.rtl_loc_id = l.rtl_loc_id AND
              sla.bucket_id = 'ON_HAND' AND
		    COALESCE(sla.unitcount,0) + COALESCE(ts.quantity, 0) <> 0
	  GROUP BY sla.rtl_loc_id, style.item_id, sla.item_id
	  ORDER BY sla.rtl_loc_id, sla.item_id DESC;

  BEGIN
    OPEN tableCur;
    FETCH tableCur INTO @organization_id, @unit_count, @item_id, @description, @style_id, @style_desc, @rtl_loc_id, @store_name, @unit_cost, @comment;
    WHILE @@FETCH_STATUS = 0 
    BEGIN
       IF @unit_cost = 0
         SET @unit_count = 0
       INSERT INTO rpt_fifo (organization_id, rtl_loc_id, store_name, item_id, user_name, description,  
		   style_id, style_desc, unit_count, unit_cost, comment)
	   VALUES(@organization_id, @rtl_loc_id, @store_name, @item_id, @user_name_param, @description, 
	       @style_id, @style_desc, @unit_count, @unit_cost, @comment); 
	   FETCH tableCur INTO @organization_id, @unit_count, @item_id, @description, @style_id, @style_desc, @rtl_loc_id, @store_name, @unit_cost, @comment;
    END
    CLOSE tableCur;
    DEALLOCATE tableCur;
  END
END
GO
/* 
 * PROCEDURE: [dbo].[sp_ins_upd_flash_sales] 
 */

IF EXISTS (Select * From sysobjects Where name = 'sp_ins_upd_flash_sales' and type = 'P')
  DROP PROCEDURE sp_ins_upd_flash_sales;
GO

CREATE PROCEDURE dbo.sp_ins_upd_flash_sales (
    @argOrgId int,
    @argRtlLocId int,
    @argBusinessDate datetime,
    @argWkstnId bigint,
    @pLineEnum nvarchar(254),
    @argQty decimal(11, 2),
    @argNetAmt decimal(17, 6),
    @vCurrencyId nvarchar(3) = 'USD')
AS
if CONTEXT_INFO()=0x0111001101110000010111110110011001101100011000010111001101101000
begin
  UPDATE rpt_flash_sales
    SET line_count = line_count + @argQty,
        line_amt = line_amt + @argNetAmt,
        update_date = getdate(),
        update_user_id = user
    WHERE organization_id = @argOrgId
      AND rtl_loc_id = @argRtlLocId
      AND wkstn_id = @argWkstnId
      AND business_date = @argBusinessDate
      AND line_enum = @pLineEnum;
    
  IF @@ROWCOUNT = 0  
    INSERT INTO rpt_flash_sales 
        (organization_id, rtl_loc_id, wkstn_id, line_enum, line_count, line_amt, foreign_amt, 
        business_date, currency_id, create_date, create_user_id)
      VALUES 
        (@argOrgId, @argRtlLocId, @argWkstnId, @pLineEnum, @argQty, @argNetAmt, 0, @argBusinessDate, 
        @vCurrencyId, getdate(), user);
end
else
	raiserror('Cannot be run directly.',10,1)
GO
/* 
 * PROCEDURE: [dbo].[sp_ins_upd_hourly_sales] 
 */

IF EXISTS (Select * From sysobjects Where name = 'sp_ins_upd_hourly_sales' and type = 'P')
  DROP PROCEDURE sp_ins_upd_hourly_sales;
GO

CREATE PROCEDURE dbo.sp_ins_upd_hourly_sales (
    @argOrgId int,
    @argRtlLocId int,
    @argBusinessDate datetime,
    @argWkstnId bigint,
    @argHour datetime,
    @argQty decimal(11, 2),
    @argNetAmt decimal(17, 6),
    @argGrossAmt decimal(17, 6),
    @argTransCount int,
    @argCurrencyId nvarchar(3) = 'USD')
AS
if CONTEXT_INFO()=0x0111001101110000010111110110011001101100011000010111001101101000
begin
  UPDATE rpt_sales_by_hour
    SET qty = qty + @argQty,
        trans_count = trans_count + @argTransCount,
        net_sales = net_sales + @argNetAmt,
        gross_sales = gross_sales + @argGrossAmt,
        update_date = getdate(),
        update_user_id = user
    WHERE organization_id = @argOrgId
      AND rtl_loc_id = @argRtlLocId
      AND wkstn_id = @argWkstnId
      AND business_date = @argBusinessDate
      AND hour = datepart(hh, @argHour);
                
IF @@ROWCOUNT = 0  
  INSERT INTO rpt_sales_by_hour (organization_id, rtl_loc_id, wkstn_id, hour, qty, trans_count,
      net_sales, business_date, gross_sales, currency_id, create_date, create_user_id)
    VALUES 
      (@argOrgId, @argRtlLocId, @argWkstnId, datepart(hh, @argHour), @argQty, @argTransCount, 
      @argNetAmt ,@argBusinessDate, @argGrossAmt, @argCurrencyId, getdate(), user);
end
else
	raiserror('Cannot be run directly.',10,1)
GO
/* 
 * PROCEDURE: [dbo].[sp_ins_upd_merchlvl1_sales] 
 */

IF EXISTS (Select * From sysobjects Where name = 'sp_ins_upd_merchlvl1_sales' and type = 'P')
  DROP PROCEDURE sp_ins_upd_merchlvl1_sales;
GO

CREATE PROCEDURE dbo.sp_ins_upd_merchlvl1_sales (
    @argOrgId int,
    @argRtlLocId int,
    @argBusinessDate datetime,
    @argWkstnId bigint,
    @pDeptId nvarchar(254),
    @argQty decimal(11, 2),
    @argNetAmt decimal(17, 6),
    @argGrossAmt decimal(17, 6),
    @argCurrencyId nvarchar(3) = 'USD')
AS
if CONTEXT_INFO()=0x0111001101110000010111110110011001101100011000010111001101101000
begin
  UPDATE rpt_merchlvl1_sales
    SET line_count = line_count + @argQty,
        line_amt = line_amt + @argNetAmt,
        gross_amt = gross_amt + @argGrossAmt,
        update_date = getdate(),
        update_user_id = user
    WHERE organization_id = @argOrgId
      AND rtl_loc_id = @argRtlLocId
      AND wkstn_id = @argWkstnId
      AND business_date = @argBusinessDate
      AND merch_level_1 = @pDeptId;
        
  IF @@ROWCOUNT = 0  
    INSERT INTO rpt_merchlvl1_sales (organization_id, rtl_loc_id, wkstn_id, merch_level_1, line_count, 
        line_amt, business_date, gross_amt, currency_id, create_date, create_user_id)
    VALUES 
        (@argOrgId, @argRtlLocId, @argWkstnId, @pDeptId, @argQty, 
        @argNetAmt ,@argBusinessDate, @argGrossAmt, @argCurrencyId, getdate(), user);
end
else
	raiserror('Cannot be run directly.',10,1)
GO
IF EXISTS (Select * From sysobjects Where name = 'sp_next_sequence_value' and type = 'P')
  DROP PROCEDURE sp_next_sequence_value;
GO

CREATE PROCEDURE dbo.sp_next_sequence_value(
  @argOrganizationId      int,
  @argRetailLocationId    int,
  @argWorkstationId       int,
  @argSequenceId          nvarchar(255),
  @argSequenceMode        nvarchar(60),
  @argIncrement           bit,
  @argIncrementalValue    int,
  @argMaximumValue        int,
  @argInitialValue        int,
  @argSequenceValue       int OUTPUT)
AS
BEGIN 
  SET TRANSACTION ISOLATION LEVEL SERIALIZABLE
  BEGIN TRANSACTION
    DECLARE @vCurrentSequence int;
    SELECT @vCurrentSequence = t.sequence_nbr
        FROM com_sequence t WITH(TABLOCKX HOLDLOCK)
        WHERE t.organization_id = @argOrganizationId
        AND t.rtl_loc_id = @argRetailLocationId
        AND t.wkstn_id = @argWorkstationId
        AND t.sequence_id = @argSequenceId
        AND t.sequence_mode = @argSequenceMode
        
    IF @vCurrentSequence IS NOT NULL
    BEGIN
      SET @argSequenceValue = @vCurrentSequence + @argIncrementalValue
      IF(@argSequenceValue > @argMaximumValue) 
        SET @argSequenceValue = @argInitialValue + @argIncrementalValue
        
        -- handle initial value -1
      IF (@argIncrement = '1') 
      BEGIN
        UPDATE com_sequence
        SET sequence_nbr = @argSequenceValue
        WHERE organization_id = @argOrganizationId
        AND rtl_loc_id = @argRetailLocationId
        AND wkstn_id = @argWorkstationId
        AND sequence_id = @argSequenceId
        AND sequence_mode = @argSequenceMode
      END
    END
    ELSE 
    BEGIN
    
      IF (@argIncrement = '1')
        SET @argSequenceValue = @argInitialValue + @argIncrementalValue
      ELSE
        SET @argSequenceValue = @argInitialValue
      
      INSERT INTO com_sequence (organization_id, rtl_loc_id, wkstn_id, sequence_id, sequence_mode, sequence_nbr) 
      VALUES (@argOrganizationId, @argRetailLocationId, @argWorkstationId, @argSequenceId, @argSequenceMode, @argSequenceValue)
    END
  COMMIT TRANSACTION
  RETURN @argSequenceValue
END
GO
PRINT 'sp_replace_org_id';
GO
IF EXISTS (Select * From sysobjects Where name = 'sp_replace_org_id' and type = 'P')
  DROP PROCEDURE sp_replace_org_id;
GO

CREATE PROCEDURE dbo.sp_replace_org_id (
    @argNewOrgId int)
AS
-------------------------------------------------------------------------------------------------------------------
-- Procedure         :  sp_replace_org_id
-- Description       :  This procedure is designed to run in only the training database.  This will change the
--						organization_id on all table to the value passed into the procedure.
-- Version           :  16.0
-------------------------------------------------------------------------------------------------------------------
--                            CHANGE HISTORY                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- WHO DATE      DESCRIPTION                                                                                     --
--               Initially created
-- PGH 08/12/10  Change the cursor to read only and added a secion to skrink the transaction log.
-- BCW 09/24/15  Changed argNewOrgId from nvarchar to int.
-------------------------------------------------------------------------------------------------------------------
  DECLARE @returnValue	int,
		@sql		 nvarchar(500),
		@tableName	 nvarchar(60),
		@LogFile		sysname
  
  DECLARE tableCur CURSOR READ_ONLY FOR 
    SELECT col.table_name 
      FROM information_schema.columns col, information_schema.tables tab
      WHERE col.table_name = tab.table_name AND 
            tab.table_type = 'BASE TABLE' AND 
            col.column_name = 'organization_id';
 
  BEGIN
    SET @returnValue = 0;
    
    OPEN tableCur;
    WHILE 1 = 1 BEGIN
      FETCH tableCur INTO @tableName;
      IF @@FETCH_STATUS <> 0
        BREAK;

      BEGIN TRY
		
        SET @sql = 'UPDATE ' + @tableName + ' SET organization_id = ' + cast(@argNewOrgId as nvarchar(10));
        PRINT @sql;
        EXEC (@sql);
        
      END TRY
      BEGIN CATCH
        DECLARE @errorMessage nvarchar(4000);
        DECLARE @errorSeverity int;
        DECLARE @errorState int;

        SELECT @errorMessage = ERROR_MESSAGE(),
               @errorSeverity = ERROR_SEVERITY(),
               @errorState = ERROR_STATE();
 
        SET @returnValue = -1;
          
        RAISERROR (@errorMessage, @errorSeverity, @errorState);
      END CATCH
    END
      
    CLOSE tableCur;
    DEALLOCATE tableCur;

	DECLARE LogFileCur CURSOR READ_ONLY FOR 
   		select name 
			from sys.database_files 
			where type = 1;
 
    OPEN LogFileCur;
	WHILE 1 = 1 BEGIN
      FETCH LogFileCur INTO @LogFile;
      IF @@FETCH_STATUS <> 0
        BREAK;
	
		DBCC SHRINKFILE (@LogFile , 0, TRUNCATEONLY);
    END
      
    CLOSE LogFileCur;
    DEALLOCATE LogFileCur;

    RETURN @returnValue;
  END
GO
/* 
 * PROCEDURE: [dbo].[sp_replace_value] 
 */

IF EXISTS (Select * From sysobjects Where name = 'sp_replace_value' and type = 'P')
  DROP PROCEDURE sp_replace_value;
GO

CREATE PROCEDURE dbo.sp_replace_value (
    @argOrgId int,
    @argColumnName nvarchar(60),
    @argNewValue nvarchar(256))
AS
  DECLARE @sql nvarchar(500);
  DECLARE @tableName nvarchar(60);
  
  DECLARE tableCursor CURSOR FOR
    SELECT col.table_name
      FROM information_schema.columns col, information_schema.tables tab
      WHERE col.table_name = tab.table_name 
        AND tab.table_type = 'BASE TABLE' 
        AND col.column_name = @argColumnName;

  BEGIN
    OPEN tableCursor;
    WHILE 1 = 1
    BEGIN
      FETCH tableCursor INTO @tableName;
      
      IF @@FETCH_STATUS <> 0
        BREAK;
        
      SET @sql = 'UPDATE ' + @tableName + ' SET ' + @argColumnName + ' = ''' + @argNewValue + ''' WHERE organization_id = ' + @argOrgId;
      EXEC (@sql);
    END
    CLOSE tableCursor;
    DEALLOCATE tableCursor;
  END
GO
IF EXISTS (Select * From sysobjects Where name = 'sp_set_sequence_value' and type = 'P')
  DROP PROCEDURE sp_set_sequence_value;
GO

CREATE PROCEDURE dbo.sp_set_sequence_value(
  @argOrganizationId      int,
  @argRetailLocationId    int,
  @argWorkstationId       int,
  @argSequenceId          nvarchar(255),
  @argSequenceMode        nvarchar(60),
  @argSequenceValue       int)
AS
BEGIN
  SET TRANSACTION ISOLATION LEVEL SERIALIZABLE
  BEGIN TRANSACTION
    UPDATE com_sequence WITH(TABLOCKX HOLDLOCK)
        SET sequence_nbr = @argSequenceValue
        WHERE organization_id = @argOrganizationId
        AND rtl_loc_id = @argRetailLocationId
        AND wkstn_id = @argWorkstationId
        AND sequence_id = @argSequenceId    
        And sequence_mode = @argSequenceMode
  COMMIT TRANSACTION
END
GO
PRINT 'dbo.sp_shrink';
GO

IF OBJECT_ID('dbo.sp_shrink') IS NOT NULL
	DROP PROCEDURE dbo.sp_shrink;
GO
	
CREATE PROCEDURE dbo.sp_shrink (--@as_db_name	 nvarchar = 'xstore',
					  			  @ai_free_space	int	= 10)
AS
BEGIN
-------------------------------------------------------------------------------------------------------------------
--                     
-- Procedure         : sp_shrink (as_db_name nvarchar, ai_free_space int)
-- Parameters		 : as_db_name
-- Description       : 
-- Version           : 16.0
-------------------------------------------------------------------------------------------------------------------
--                            CHANGE HISTORY                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- WHO DATE      DESCRIPTION                                                                                     --
-------------------------------------------------------------------------------------------------------------------
	DECLARE
		@ls_owner_nm			sysname,
		@ls_table_nm			sysname,
		@ls_index_nm			sysname,
		@li_index_id			integer,
		@li_fillfactor			integer,
		@ls_domain			 nchar(3),
		@ls_sqlcmd			 nvarchar(256);
		
	DECLARE Table_List CURSOR FOR
		SELECT schema_name(schema_id), object_name (object_id)
			FROM sys.tables
			WHERE type = 'U'
	
	--
	-- Loop through the tables and rebuild the indexes with 100% fill factor
	--
	OPEN Table_List

	FETCH NEXT
	FROM Table_List
	INTO @ls_owner_nm, @ls_table_nm

	WHILE @@FETCH_STATUS = 0
	BEGIN
		SET @ls_sqlcmd = 'ALTER INDEX ALL  on [' + @ls_owner_nm + '].[' + @ls_table_nm + '] REBUILD WITH (FILLFACTOR=100)';  -- Online only works with Enterprise Edition
		--print @ls_sqlcmd;
		exec (@ls_sqlcmd);

		FETCH NEXT
		FROM Table_List
		INTO @ls_owner_nm, @ls_table_nm
	END;
	
	CLOSE Table_List;
	DEALLOCATE Table_List;

	--
	-- Shrink the database to the desired size
	--
	print 'Free Space%: ' + str(@ai_free_space);
	DBCC SHRINKDATABASE (0, @ai_free_space);

	DECLARE Index_List CURSOR FOR
		SELECT schema_name(t.schema_id), object_name(i.object_id), i.index_id, i.name
			FROM sys.indexes i
			JOIN sys.tables t on i.object_id = t.object_id
			WHERE t.type = 'U'
			  and i.index_id > 0
	
	--
	-- Loop through the indexes and rebuild the indexes
	--
	OPEN Index_List

	FETCH NEXT
	FROM Index_List
	INTO @ls_owner_nm, @ls_table_nm, @li_index_id, @ls_index_nm

	WHILE @@FETCH_STATUS = 0
	BEGIN

		set @ls_domain = substring(@ls_table_nm, 1, 3);
		--print 'Domain: ' + @ls_domain;
		--print 'Table: ' + @ls_table_nm;
		--print 'Index: ' + @ls_index_nm;
		IF @ls_domain in ('TND', 'COM', 'DSC', 'LOC', 'TAX', 'CRM', 'DOC', 'HRS', 'SCH', 'SEC') -- Non-Transaction tables
			set @li_fillfactor = 100;
		ELSE								-- transaction tables
			IF @li_index_id < 2
				set @li_fillfactor = 90;		-- clustered / heap indexes
			ELSE
				set @li_fillfactor = 95;		-- non-clustered indexes
		
		SET @ls_sqlcmd = 'ALTER INDEX [' + @ls_index_nm + ']  on [' + @ls_owner_nm + '].[' + @ls_table_nm + '] REBUILD WITH (FILLFACTOR=' + ltrim(str(@li_fillfactor)) + ')';  -- Online only works with Enterprise Edition
		--print @ls_sqlcmd;
		exec (@ls_sqlcmd);

		FETCH NEXT
		FROM Index_List
		INTO @ls_owner_nm, @ls_table_nm, @li_index_id, @ls_index_nm
	END;
	
	CLOSE Index_List;
	DEALLOCATE Index_List;
END;
GO
/* 
 * PROCEDURE: [dbo].[sp_shrinkLog] 
 */

IF EXISTS (Select * From sysobjects Where name = 'sp_shrinkLog' and type = 'P')
  DROP PROCEDURE sp_shrinkLog;
GO

CREATE PROCEDURE sp_shrinkLog (
    @argDbName AS nvarchar(255), 
    @argNewSize AS int)
AS
  DECLARE @fileId AS int;
  DECLARE @serverVersion AS sql_variant;
  DECLARE logCursor CURSOR FOR 
    SELECT fileid FROM sysfiles 
      WHERE (status & 0x40) = 0x040;
  
  OPEN logCursor;
  
  FETCH NEXT FROM logCursor INTO @fileId;
  
  WHILE @@FETCH_STATUS = 0 BEGIN
    IF @argNewSize = 0  OR (SELECT size * 8 /1024 FROM sysfiles WHERE fileId=2) > @argNewSize
      DBCC SHRINKFILE (@fileId) -- default shrink
    ELSE
      DBCC SHRINKFILE (@fileId, @argNewSize);
  
    FETCH NEXT FROM logCursor INTO @fileId;
  END
  
  CLOSE logCursor;
  DEALLOCATE logCursor;
  
--
-- FB: 205359 - Removing the Backup Log because it was removed in SQL Server 2008
--
--  SELECT @serverVersion = SERVERPROPERTY('productversion');
--  
--  IF SUBSTRING(CONVERT(varchar(max), @serverVersion), 1, 2) = '10'       -- SQL Server 2008
--    BACKUP LOG @argDbName TO DISK = 'NUL:';    
--  ELSE                                          -- SQL Server 2005
--    BACKUP LOG @argDbName WITH TRUNCATE_ONLY;     
GO
/* 
 * PROCEDURE: [dbo].[sp_xstoreOrgCopy] 
 */

IF EXISTS (Select * From sysobjects Where name = 'sp_xstoreOrgCopy' and type = 'P')
  DROP PROCEDURE sp_xstoreOrgCopy;
GO

CREATE PROCEDURE dbo.sp_xstoreOrgCopy (
    @pSrcOrgId int,
    @pDstOrgId int,
    @pOption nvarchar(25) = NULL)
AS
  IF (@pSrcOrgId = @pDstOrgId) 
  BEGIN
    RAISERROR('Source cannot be the same as destination', 16, 1);
    RETURN(1);
  END
  
  DECLARE @tableName  nvarchar(255);
  DECLARE @deleteStr  nvarchar(255);
  DECLARE @insertStmt nvarchar(4000);
  DECLARE @selectStmt nvarchar(4000);
  DECLARE @colName    nvarchar(255);
  DECLARE @dataType   nvarchar(30);
  DECLARE @value      nvarchar(255);
  DECLARE @optDeletes int;
  DECLARE @optInserts int;
  DECLARE @optExec    int;

  IF LOWER(@pOption) = 'delete'
    SELECT @optDeletes = 1, @optInserts = 0, @optExec = 0;
  ELSE IF LOWER(@pOption) = 'insert'
    SELECT @optDeletes = 0, @optInserts = 1, @optExec = 0;
  ELSE IF LOWER(@pOption) = 'exec'
    SELECT @optDeletes = 1, @optInserts = 1, @optExec = 1;
  ELSE 
    SELECT @optDeletes = 1, @optInserts = 1, @optExec = 0;

  -- get a cursor of all tables that have a column named 'organization_id'  
  DECLARE tableCur CURSOR FOR
    SELECT DISTINCT tab.name 
      FROM sysobjects tab 
        INNER JOIN syscolumns col ON tab.id = col.id 
      WHERE tab.type = 'U' AND col.name = 'organization_id' ORDER BY tab.name;
  
  OPEN tableCur;

  WHILE 1 = 1 
  BEGIN
    FETCH NEXT FROM tableCur INTO @tableName;

    IF @@FETCH_STATUS <> 0 
      BREAK;

    IF @optDeletes <> 0 
      BEGIN
        SET @deleteStr = 'DELETE FROM ' + @tableName + ' WHERE organization_id = ' + CAST(@pDstOrgId AS nvarchar) + ';'
        PRINT (@deleteStr);
        IF @optExec <> 0 EXEC (@deleteStr);
      END

    IF @optInserts <> 0 
      BEGIN
        SET @insertStmt = 'INSERT INTO ' + @tableName + ' (organization_id';
        SET @selectStmt = 'SELECT ' + CAST(@pDstOrgId AS nvarchar);
    
        DECLARE colCur CURSOR FOR 
          SELECT column_name, data_type 
            FROM information_schema.columns 
           WHERE table_name = @tableName 
             AND data_type <> 'uniqueidentifier'
             AND column_name NOT IN ('organization_id', 'create_date', 'create_user_id', 'update_date', 'update_user_id', 
                                     'PROCESSED_DATE', 'PROCESSED_ID', 'record_state', 'record_timestamp', 'dss_timestamp');
        OPEN colCur;
     
        WHILE 1 = 1
          BEGIN
            FETCH NEXT FROM colCur INTO @colName, @dataType;
    
            IF @@FETCH_STATUS <> 0
              BREAK;
            
            SET @insertStmt = @insertStmt + ', ' + @colName;
            SET @selectStmt = @selectStmt + ', ';
            
            IF @colName LIKE '%_org_id'
              BEGIN
                SET @selectStmt = @selectStmt + CONVERT(varchar, @pDstOrgId);
              END
            ELSE
              BEGIN
                SET @selectStmt = @selectStmt + @colName;
              END
          END
    
        SET @insertStmt = @insertStmt + ') (' + @selectStmt + ' FROM ' + @tableName 
              + ' WHERE organization_id = ' + CAST(@pSrcOrgId AS nvarchar) + ');'
        
        PRINT (@insertStmt);
        IF @optExec <> 0 EXEC (@insertStmt);
          
        CLOSE colCur;
        DEALLOCATE colCur;
      END
  END

  CLOSE tableCur;
  DEALLOCATE tableCur;
  GO
GO
/* 
 * PROCEDURE: [dbo].[sp_xstore_delete_all] 
 */

IF EXISTS (Select * From sysobjects Where name = 'sp_xstore_delete_all' and type = 'P')
  DROP PROCEDURE sp_xstore_delete_all;
GO

CREATE PROCEDURE dbo.sp_xstore_delete_all
AS
  DECLARE @tableName nvarchar(255);
  DECLARE @sql nvarchar(255);
  DECLARE tableCursor CURSOR FAST_FORWARD FOR
    SELECT table_name
    FROM information_schema.tables
    WHERE table_schema = 'dbo' AND table_type = 'BASE TABLE'
    ORDER BY table_name;
    
  OPEN tableCursor;

  WHILE 1 = 1
  BEGIN
    FETCH NEXT FROM tableCursor INTO @tableName;
    IF @@FETCH_STATUS <> 0 BREAK;
    
    SET @sql = 'TRUNCATE TABLE dbo.' + @tableName;
    PRINT @sql;
    EXEC(@sql);
  END

  CLOSE tableCursor;
  DEALLOCATE tableCursor;
GO
/* 
 * PROCEDURE: [dbo].[sp_xstore_list_all] 
 */

IF EXISTS (Select * From sysobjects Where name = 'sp_xstore_list_all' and type = 'P')
  DROP PROCEDURE sp_xstore_list_all;
GO

CREATE PROCEDURE dbo.sp_xstore_list_all
AS
  CREATE TABLE
  #t
  (
    tableName nvarchar(100),
    tableRowCount int
  );
  
  DECLARE @tableName nvarchar(255);
  DECLARE tableCursor CURSOR FOR
    SELECT name FROM sysobjects WHERE type = 'u' ORDER BY name;
  
  OPEN tableCursor;
  
  WHILE 1 = 1 BEGIN
    FETCH NEXT FROM tableCursor INTO @tableName;
    
    IF @@FETCH_STATUS <> 0
      BREAK;
  
    INSERT INTO #t (tableName, tableRowCount)
      EXEC ('SELECT ''' + @tableName + ''', COUNT(*) FROM [' + @tableName + '] WITH (NOLOCK)');
  END
  
  CLOSE tableCursor;
  DEALLOCATE tableCursor;
  SELECT * FROM #t ORDER BY tableRowCount DESC;
  DROP TABLE #t;
GO

/* 
 * FUNCTION: [dbo].[fn_NLS_LOWER] 
 */

PRINT 'fn_NLS_LOWER';

IF EXISTS (SELECT * FROM sys.objects WHERE name = 'fn_NLS_LOWER')
	DROP FUNCTION dbo.fn_NLS_LOWER
GO

CREATE FUNCTION fn_NLS_LOWER (@argString nvarchar(MAX))
RETURNS nvarchar(MAX)
AS
BEGIN
	RETURN LOWER(@argString)
END
GO
/* 
 * FUNCTION: [dbo].[fn_NLS_UPPER] 
 */

PRINT 'fn_NLS_UPPER';

IF EXISTS (SELECT * FROM sys.objects WHERE name = 'fn_NLS_UPPER')
	DROP FUNCTION dbo.fn_NLS_UPPER
GO

CREATE FUNCTION fn_NLS_UPPER (@argString nvarchar(MAX))
RETURNS nvarchar(MAX)
AS
BEGIN
	RETURN UPPER(@argString)
END
GO
/* 
 * FUNCTION: [dbo].[fn_ParseDate] 
 */

PRINT 'dbo.fn_ParseDate';

IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[fn_ParseDate]') AND type in (N'FN', N'IF', N'TF', N'FS', N'FT'))
	DROP FUNCTION [dbo].[fn_ParseDate]
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO


CREATE FUNCTION fn_ParseDate (@argDateString nvarchar(24))
RETURNS datetime
AS
BEGIN
	-- Declare the return variable here
	DECLARE @vs_year nvarchar(4),
	 @vs_month nvarchar(2), 
	 @vs_day nvarchar(2), 
	 @vs_hour nvarchar(2)='00', 
	 @vs_minute nvarchar(2)='00', 
	 @vs_second nvarchar(2)='00', 
	 @vs_ms nvarchar(4)='000'

	SET @vs_year = LEFT(@argDateString,4)
	SET @argDateString = RIGHT(@argDateString,len(@argDateString)-5)
	SET @vs_month = LEFT(@argDateString,2)
	SET @argDateString = RIGHT(@argDateString,len(@argDateString)-3)
	SET @vs_day = LEFT(@argDateString,2)
	if len(@argDateString)>5
	begin
		SET @argDateString = RIGHT(@argDateString,len(@argDateString)-3)
		SET @vs_hour = LEFT(@argDateString,2)
		if len(@argDateString)>4
		begin
			SET @argDateString = RIGHT(@argDateString,len(@argDateString)-3)
			SET @vs_minute = LEFT(@argDateString,2)
			if len(@argDateString)>4
			begin
				SET @argDateString = RIGHT(@argDateString,len(@argDateString)-3)
				SET @vs_second = LEFT(@argDateString,2)
				if len(@argDateString)>3
					SET @vs_ms = RIGHT(@argDateString,len(@argDateString)-3)
			end
		end
	end
	-- Return the result of the function
	RETURN convert(datetime,@vs_year + '-' + @vs_month + '-' + @vs_day + ' ' + @vs_hour + ':' + @vs_minute + ':' + @vs_second + '.' + @vs_ms,120)

END
GO

PRINT 'dbo.sp_dbMaintenance';
GO

IF OBJECT_ID('dbo.sp_dbMaintenance') IS NOT NULL
	DROP PROCEDURE dbo.sp_dbMaintenance;
GO

CREATE PROCEDURE dbo.sp_dbMaintenance
AS
-------------------------------------------------------------------------------------------------------------------
--                                                                                                               --
-- Procedure         : sp_dbMaintenance
-- Description       : Performs standard maitntenance to a SQL Server database
--						1) Check recovery model and last backup
--						2) Index Reorganize
--						3) CheckDB
-- Version           : 16.0                                                                                       --
-------------------------------------------------------------------------------------------------------------------
--                            CHANGE HISTORY                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- WHO DATE      DESCRIPTION                                                                                     --
-- ST  01/30/07  Initially created
-- PGH 02/11/10  Rewriten for 2005 / 2008
-------------------------------------------------------------------------------------------------------------------
DECLARE @dbName				sysname,
		@dbRecovery		 nvarchar(60),
		@LastFullBackup		datetime,
		@LastTransBackup	datetime,
		@MinFragmentation	decimal
--		@dbBk			 nvarchar(255),
--		@logBk			 nvarchar(255),
--		@doBk				bit

BEGIN
	-- config
	SET @MinFragmentation = 30 --Percent
--	SET @dbBk = 'c:\xstoredb\backup\xstoreDb.bk' -- db back up destinataion
--	SET @logBk = 'c:\xstoredb\backup\xstoreLog.bk'  -- log file back up destination
--	SET @doBK = 0 -- set to true for backup
	-- end config

	SET @dbName = db_name();
	SELECT @dbRecovery = recovery_model_desc FROM SYS.DATABASES WHERE NAME =DB_NAME();
	SELECT @LastFullBackup = max(backup_finish_date) from msdb..backupset
		WHERE type = 'D'
		  AND database_name = DB_NAME();
	SELECT @LastTransBackup = max(backup_finish_date) from msdb..backupset
		WHERE type = 'L'
		  AND database_name = DB_NAME();
		  
	--
	-- 1) Check Backup Status
	--
	
	PRINT '';
	PRINT ' Database Backup Info:';
	PRINT '		Database Name:	   ' + db_name();
	PRINT '		Recovery Mode:	   ' + @dbRecovery;
	PRINT '		Last Full Backup:  ' + COALESCE(cast(@LastFullBackup as nvarchar), ' ');
	PRINT '     Last Trans Backup: ' + COALESCE(cast(@LastTransBackup as nvarchar), ' ');
	PRINT '';

	SELECT  CASE df.data_space_id
				WHEN 0 THEN 'LOG'
				ELSE  ds.name
			END AS [FileGroupName],
			df.name AS [FileName], 
			df.physical_name AS [PhysicalName], 
			round((cast(df.size as decimal) / 128) , 2) AS [Size], 
			round((FILEPROPERTY(df.name, 'SpaceUsed')/ 128.0),2) AS [SpaceUsed],	--Changed from Available Space to Used Space
			cast(ROUND(((FILEPROPERTY(df.name, 'SpaceUsed')/ 128.0) / (cast(df.size as decimal) / 128)) * 100, 0) as int)
				AS [SpaceUsedPCT],
			CASE is_percent_growth
			WHEN 0 THEN growth / 128
			ELSE growth
		END AS [Growth],
		CASE is_percent_growth
			WHEN 0 THEN 'MB'
			ELSE 'PCT'
		END AS [Growth Type],
		CASE df.max_size
			WHEN -1 THEN df.max_size
			ELSE max_size / 128
		END AS [Max Growth Size],					
		state_desc
	FROM sys.database_files df
	LEFT JOIN sys.data_spaces ds on ds.data_space_id = df.data_space_id;
	
	--
	-- 2) Index Reorganize
	--
	
	PRINT 'Reorganizing Indexes'
	EXEC dbo.sp_defrag_indexes @MinFragmentation
	
	-- 3) Update the stats
	--PRINT 'Updating Statistics'
	--EXEC sp_updatestats -- with default parameters runs stats for sample rows on all tables
	

	-- 3) Check DB
	PRINT 'CheckDB';
	DBCC CHECKDB WITH NO_INFOMSGS;

	-- 5) Backup Database
	--IF @doBk = 1
	--	BEGIN
	--		BACKUP DATABASE @dbName TO DISK = @dbBk
	--		BACKUP LOG @dbName TO DISK = @logBk
	--	END
END
GO
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
-- BCW  03/07/12	Updated per Padma Golli's instructions.
-- BCW  06/21/12	Updated per Emily Tan's instructions.
-- BCW	12/05/13	Replaced the sale cursor by writing the transaction line item directly into the rpt_sale_line table.
-------------------------------------------------------------------------------------------------------------------
PRINT 'dbo.sp_flash';

IF EXISTS (Select * From sysobjects Where name = 'sp_flash' and type = 'P')
  DROP PROCEDURE sp_flash;
GO

CREATE PROCEDURE dbo.sp_flash (
@argOrganizationId int,  /*organization id*/
@argRetailLocationId int,  /*retail location or store number*/
@argBusinessDate datetime,  /*business date*/
@argWrkstnId bigint,  /*register*/
@argTransSeq bigint)  /*trans sequence*/
as

declare @old_context_info varbinary(128)=context_info();
SET CONTEXT_INFO 0x0111001101110000010111110110011001101100011000010111001101101000

declare -- Quantities
@vActualQuantity decimal(11, 2),
@vGrossQuantity decimal(11, 2),
@vQuantity decimal(11, 2),
@vTotQuantity decimal(11, 2)

declare -- Amounts
@vNetAmount decimal(17, 6),
@vGrossAmount decimal(17, 6),
@vTotGrossAmt decimal(17, 6),
@vTotNetAmt decimal(17, 6),
@vDiscountAmt decimal(17, 6),
@vOverrideAmt decimal(17, 6),
@vPaidAmt decimal(17, 6),
@vTenderAmt decimal(17, 6),
@vForeign_amt decimal(17, 6),
@vLayawayPrice decimal(17, 6),
@vUnitPrice decimal(17, 6),
@vAccountCredit decimal(17, 6)

declare -- Non Physical Items
@vNonPhys nvarchar(30),
@vNonPhysSaleType nvarchar(30),
@vNonPhysType nvarchar(30),
@vNonPhysPrice decimal(17, 6),
@vNonPhysQuantity decimal(11, 2)

declare -- Status codes
@vTransStatcode nvarchar(30),
@vTransTypcode nvarchar(30),
@vSaleLineItmTypcode nvarchar(30),
@vTndrStatcode nvarchar(60),
@vLineitemStatcode nvarchar(30)

declare -- others
@vTransTimeStamp datetime,
@vTransDate datetime,
@vTransCount int,
@vTndrCount int,
@vPostVoidFlag bit,
@vReturnFlag bit,
@vTaxTotal decimal(17, 6),
@vPaid nvarchar(30),
@vLineEnum nvarchar(150),
@vTndrId nvarchar(60),
@vItemId nvarchar(60),
@vRtransLineItmSeq int,
@vDepartmentId nvarchar(90),
@vTndridProp nvarchar(60),
@vCurrencyId nvarchar(3)

declare
@vSerialNbr nvarchar(60),
@vPriceModAmt decimal(17, 6),
@vPriceModReascode nvarchar(60),
@vNonPhysExcludeFlag bit,
@vCustPartyId nvarchar(60),
@vCustLastName nvarchar(90),
@vCustFirstName nvarchar(90),
@vItemDesc nvarchar(120),
@vBeginTimeInt int


select @vTransStatcode = trans_statcode,
@vTransTypcode = trans_typcode,
@vTransTimeStamp = begin_datetime,
@vTransDate = trans_date,
@vTaxTotal = taxtotal,
@vPostVoidFlag = post_void_flag,
@vBeginTimeInt = begin_time_int
from trn_trans with (nolock)
where organization_id = @argOrganizationId
and rtl_loc_id = @argRetailLocationId
and wkstn_id = @argWrkstnId
and business_date = @argBusinessDate
and trans_seq = @argTransSeq

if @@rowcount = 0 
  return  /* Invalid transaction */

select @vCurrencyId = max(currency_id)
from ttr_tndr_lineitm ttl with (nolock)
inner join tnd_tndr tnd with (nolock) on ttl.organization_id=tnd.organization_id and ttl.tndr_id=tnd.tndr_id
where ttl.organization_id = @argOrganizationId
and rtl_loc_id = @argRetailLocationId
and wkstn_id = @argWrkstnId
and business_date = @argBusinessDate
and trans_seq = @argTransSeq

if @vCurrencyId is null
select @vCurrencyId = max(currency_id)
from loc_rtl_loc with (nolock)
where organization_id = @argOrganizationId
and rtl_loc_id = @argRetailLocationId

-- Sundar commented the following as rpt sale line has to capture all the transactions
-- if @vTransStatcode != 'COMPLETE' and @vTransStatcode != 'SUSPEND' 
--  return

set @vTransCount = 1 /* initializing the transaction count */


-- update trans
update trn_trans set flash_sales_flag = 1
where organization_id = @argOrganizationId
and rtl_loc_id = @argRetailLocationId 
and wkstn_id = @argWrkstnId 
and trans_seq = @argTransSeq
and business_date = @argBusinessDate

-- BCW Added code to only update post voids if the original transaction 
if @vPostVoidFlag=1 and not exists(select 1 from rpt_sale_line where organization_id = @argOrganizationId
          and rtl_loc_id = @argRetailLocationId
          and wkstn_id = @argWrkstnId
          and trans_seq = @argTransSeq
          and business_date = @argBusinessDate)
      begin
       insert into rpt_sale_line WITH(ROWLOCK)
      (organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq,
      quantity, actual_quantity, gross_quantity, unit_price, net_amt, gross_amt, item_id, 
      item_desc, merch_level_1, serial_nbr, return_flag, override_amt, trans_timestamp, trans_date,
      discount_amt, cust_party_id, last_name, first_name, trans_statcode, sale_lineitm_typcode, begin_time_int,
      currency_id, exclude_from_net_sales_flag)
      select tsl.organization_id, tsl.rtl_loc_id, tsl.business_date, tsl.wkstn_id, tsl.trans_seq, tsl.rtrans_lineitm_seq,
      tsl.net_quantity, tsl.quantity, tsl.gross_quantity, tsl.unit_price, tsl.net_amt, tsl.gross_amt, tsl.item_id,
      i.DESCRIPTION, coalesce(tsl.merch_level_1,i.MERCH_LEVEL_1,N'DEFAULT'), tsl.serial_nbr, tsl.return_flag, coalesce(o.override_amt,0), @vTransTimeStamp, @vTransDate, 
      coalesce(d.discount_amt,0), tr.cust_party_id, cust.last_name, cust.first_name, 'VOID', tsl.sale_lineitm_typcode, 
      @vBeginTimeInt, @vCurrencyId, tsl.exclude_from_net_sales_flag
      from trl_sale_lineitm tsl with (nolock) 
      inner join trl_rtrans_lineitm r with (nolock)
      on tsl.organization_id=r.organization_id
      and tsl.rtl_loc_id=r.rtl_loc_id
      and tsl.wkstn_id=r.wkstn_id
      and tsl.trans_seq=r.trans_seq
      and tsl.business_date=r.business_date
      and tsl.rtrans_lineitm_seq=r.rtrans_lineitm_seq
      and r.rtrans_lineitm_typcode = N'ITEM'
      left join xom_order_mod xom  with (nolock)
      on tsl.organization_id=xom.organization_id
      and tsl.rtl_loc_id=xom.rtl_loc_id
      and tsl.wkstn_id=xom.wkstn_id
      and tsl.trans_seq=xom.trans_seq
      and tsl.business_date=xom.business_date
      and tsl.rtrans_lineitm_seq=xom.rtrans_lineitm_seq
      left join xom_order_line xol  with (nolock)
      on xom.organization_id=xol.organization_id
      and xom.order_id=xol.order_id
      and xom.detail_seq=xol.detail_seq
      left join itm_item i
      on tsl.organization_id=i.ORGANIZATION_ID
      and tsl.item_id=i.ITEM_ID
      left join (select extended_amt override_amt,organization_id,rtl_loc_id,business_date,wkstn_id,trans_seq,rtrans_lineitm_seq
        FROM trl_rtl_price_mod with(nolock)
        WHERE void_flag = 0 and rtl_price_mod_reascode=N'PRICE_OVERRIDE') o
      on tsl.organization_id = o.organization_id 
        AND tsl.rtl_loc_id = o.rtl_loc_id
        AND tsl.business_date = o.business_date 
        AND tsl.wkstn_id = o.wkstn_id 
        AND tsl.trans_seq = o.trans_seq
        AND tsl.rtrans_lineitm_seq = o.rtrans_lineitm_seq
      left join (select sum(extended_amt) discount_amt,organization_id,rtl_loc_id,business_date,wkstn_id,trans_seq,rtrans_lineitm_seq
        FROM trl_rtl_price_mod with(nolock)
        WHERE void_flag = 0 and rtl_price_mod_reascode in (N'LINE_ITEM_DISCOUNT', N'TRANSACTION_DISCOUNT',N'GROUP_DISCOUNT', N'NEW_PRICE_RULE', N'DEAL')
        group by organization_id,rtl_loc_id,business_date,wkstn_id,trans_seq,rtrans_lineitm_seq) d
      on tsl.organization_id = d.organization_id 
        AND tsl.rtl_loc_id = d.rtl_loc_id
        AND tsl.business_date = d.business_date 
        AND tsl.wkstn_id = d.wkstn_id 
        AND tsl.trans_seq = d.trans_seq
        AND tsl.rtrans_lineitm_seq = d.rtrans_lineitm_seq
      left join trl_rtrans tr with(nolock)
      on tsl.organization_id = tr.organization_id 
        AND tsl.rtl_loc_id = tr.rtl_loc_id
        AND tsl.business_date = tr.business_date 
        AND tsl.wkstn_id = tr.wkstn_id 
        AND tsl.trans_seq = tr.trans_seq
      left join crm_party cust with(nolock)
      on tsl.organization_id = cust.organization_id 
        AND tr.cust_party_id = cust.party_id
      where tsl.organization_id = @argOrganizationId
      and tsl.rtl_loc_id = @argRetailLocationId
      and tsl.wkstn_id = @argWrkstnId
      and tsl.business_date = @argBusinessDate
      and tsl.trans_seq = @argTransSeq
      and r.void_flag=0
      and ((tsl.SALE_LINEITM_TYPCODE <> N'ORDER'and (xom.detail_type IS NULL OR xol.status_code = N'FULFILLED') )
      or (tsl.SALE_LINEITM_TYPCODE = N'ORDER' and xom.detail_type in (N'FEE', N'PAYMENT') ))
  return;
  end

-- collect transaction data
if abs(@vTaxTotal) > 0 and (@vTransTypcode <> 'POST_VOID' and @vPostVoidFlag = 0) and @vTransStatcode = 'COMPLETE'
  exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
  @argWrkstnId,'TOTALTAX', 1, @vTaxTotal, @vCurrencyId          

IF @vTransTypcode = 'TENDER_CONTROL' and @vPostVoidFlag = 0
  -- process for paid in paid out 
  begin 
    select @vPaid = typcode,@vPaidAmt = amt 
    from tsn_tndr_control_trans with (nolock)  
    where typcode like 'PAID%'
          and organization_id = @argOrganizationId
          and rtl_loc_id = @argRetailLocationId
          and wkstn_id = @argWrkstnId
          and trans_seq = @argTransSeq
          and business_date = @argBusinessDate
            
    IF @@rowcount = 1
      -- it is paid in or paid out
      begin 
        if @vPaid = 'PAID_IN' or @vPaid = 'PAIDIN'
          set @vLineEnum = 'paidin'
        else
          set @vLineEnum = 'paidout'
        -- update flash sales
        if @vTransStatcode = 'COMPLETE'                
          exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
          @argWrkstnId,@vLineEnum, 1, @vPaidAmt, @vCurrencyId

      end 
  end
-- collect tenders  data
if @vPostVoidFlag = 0 and @vTransTypcode <> 'POST_VOID'
  begin

    declare tenderCursor cursor for 
    select t.amt, t.foreign_amt, t.tndr_id, t.tndr_statcode,tr.string_value
    from ttr_tndr_lineitm t with (nolock) 
    inner join trl_rtrans_lineitm r with (nolock)
    on t.organization_id=r.organization_id
    and t.rtl_loc_id=r.rtl_loc_id
    and t.wkstn_id=r.wkstn_id
    and t.trans_seq=r.trans_seq
    and t.business_date=r.business_date
    and t.rtrans_lineitm_seq=r.rtrans_lineitm_seq
  left outer join trl_rtrans_lineitm_p tr with (nolock)
    on tr.organization_id=r.organization_id
    and tr.rtl_loc_id=r.rtl_loc_id
    and tr.wkstn_id=r.wkstn_id
    and tr.trans_seq=r.trans_seq
    and tr.business_date=r.business_date
    and tr.rtrans_lineitm_seq=r.rtrans_lineitm_seq
  and property_code = 'tender_id'
    where t.organization_id = @argOrganizationId
    and t.rtl_loc_id = @argRetailLocationId 
    and t.wkstn_id = @argWrkstnId 
    and t.trans_seq = @argTransSeq
    and t.business_date = @argBusinessDate
    and r.void_flag = 0
  and t.tndr_id <> 'ACCOUNT_CREDIT'

    open tenderCursor
    while 1=1 
      begin
        fetch next from tenderCursor into @vTenderAmt,@vForeign_amt,@vTndrid,@vTndrStatcode,@vTndridProp             
        if @@fetch_status <> 0 
          BREAK
        if @vTndrStatcode <> 'Change'
          set @vTndrCount = 1  -- only for original tenders
        else 
          set @vTndrCount = 0

         if @vTndridProp IS NOT NULL
           set @vTndrid = @vTndridProp
          
        if @vLineEnum = 'paidout'
          begin
            set @vTenderAmt = coalesce(@vTenderAmt, 0) * -1
            set @vForeign_amt = coalesce(@vForeign_amt, 0) * -1
          end

        -- update flash
        if @vTransStatcode = 'COMPLETE'                
          exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
          @argWrkstnId,@vTndrid,@vTndrCount,@vTenderAmt,@vCurrencyId
    
        if @vTenderAmt > 0 and @vTransStatcode = 'COMPLETE'                
          exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
          @argWrkstnId,'TendersTakenIn', 1,@vTenderAmt,@vCurrencyId
        else
          exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
          @argWrkstnId,'TendersRefunded', 1,@vTenderAmt,@vCurrencyId
    
      end
    close tenderCursor
    deallocate tendercursor
  end

-- collect post void info
if @vTransTypcode = 'POST_VOID' or @vPostVoidFlag = 1
  begin

    set @vTransCount = -1 /* reversing the count */
    if @vPostVoidFlag = 0
      begin
        set @vPostVoidFlag = 1
        -- get the original post voided transaction and set it as original parameters
        select  @argOrganizationId = voided_org_id,
          @argRetailLocationId = voided_rtl_store_id, 
          @argWrkstnId = voided_wkstn_id, 
          @argBusinessDate = voided_business_date, 
          @argTransSeq = voided_trans_id 
        from trn_post_void_trans with (nolock)
        where organization_id = @argOrganizationId
        and rtl_loc_id = @argRetailLocationId
        and wkstn_id = @argWrkstnId
        and business_date = @argBusinessDate
        and trans_seq = @argTransSeq
    
        /* NOTE: From now on the parameter value carries the original post voided
           information rather than the current transaction information in 
           case of post void trans type. This will apply for sales data 
           processing.
        */
              
        if @@rowcount = 0 
           return -- don't know the original post voided record

    if exists(select 1 from rpt_sale_line where organization_id = @argOrganizationId
          and rtl_loc_id = @argRetailLocationId
          and wkstn_id = @argWrkstnId
          and trans_seq = @argTransSeq
          and business_date = @argBusinessDate
      and trans_statcode = 'VOID')
      return;
      end
    -- update the rpt sale line for post void
   update rpt_sale_line
    set trans_statcode='VOID'
    where organization_id = @argOrganizationId
    and rtl_loc_id = @argRetailLocationId
    and wkstn_id = @argWrkstnId
    and business_date = @argBusinessDate
    and trans_seq = @argTransSeq        

    -- reverse padin paidout
    select @vPaid = typcode,@vPaidAmt = amt 
    from tsn_tndr_control_trans with (nolock)  
    where typcode like 'PAID%'
          and organization_id = @argOrganizationId
          and rtl_loc_id = @argRetailLocationId
          and wkstn_id = @argWrkstnId
          and trans_seq = @argTransSeq
          and business_date = @argBusinessDate
            
    IF @@rowcount = 1
      -- it is paid in or paid out
      begin 
        if @vPaid = 'PAID_IN' or @vPaid = 'PAIDIN'
          set @vLineEnum = 'paidin'
        else
          set @vLineEnum = 'paidout'
        set @vPaidAmt = @vPaidAmt * -1
        -- update flash sales  
        if @vTransStatcode = 'COMPLETE'                                
          exec sp_ins_upd_flash_sales @argOrganizationId, @argRetailLocationId, @vTransDate,
          @argWrkstnId, @vLineEnum, -1, @vPaidAmt, @vCurrencyId 

      end 
    -- reverse tax
    select @vTaxTotal=taxtotal from trn_trans with (nolock)
    where organization_id = @argOrganizationId
    and rtl_loc_id = @argRetailLocationId
    and wkstn_id = @argWrkstnId
    and business_date = @argBusinessDate
    and trans_seq = @argTransSeq
    

    if abs(@vTaxTotal) > 0 and @vTransStatcode = 'COMPLETE'
      begin
        set @vTaxTotal = @vTaxTotal * -1
        exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
        @argWrkstnId,'TOTALTAX',-1,@vTaxTotal,@vCurrencyId
      end

    -- reverse tenders
    declare postVoidTenderCursor cursor for 
    select t.amt, t.foreign_amt, t.tndr_id, t.tndr_statcode,tr.string_value
    from ttr_tndr_lineitm t with (nolock) 
    inner join trl_rtrans_lineitm r with (nolock)
    on t.organization_id=r.organization_id
    and t.rtl_loc_id=r.rtl_loc_id
    and t.wkstn_id=r.wkstn_id
    and t.trans_seq=r.trans_seq
    and t.business_date=r.business_date
    and t.rtrans_lineitm_seq=r.rtrans_lineitm_seq
  left outer join trl_rtrans_lineitm_p tr with (nolock)
    on tr.organization_id=r.organization_id
    and tr.rtl_loc_id=r.rtl_loc_id
    and tr.wkstn_id=r.wkstn_id
    and tr.trans_seq=r.trans_seq
    and tr.business_date=r.business_date
    and tr.rtrans_lineitm_seq=r.rtrans_lineitm_seq
  and property_code = 'tender_id'
    where t.organization_id = @argOrganizationId
    and t.rtl_loc_id = @argRetailLocationId 
    and t.wkstn_id = @argWrkstnId 
    and t.trans_seq = @argTransSeq
    and t.business_date = @argBusinessDate
    and r.void_flag = 0
  and t.tndr_id <> 'ACCOUNT_CREDIT'

    open postVoidTenderCursor
    while 1=1 
      begin
        fetch next from postVoidTenderCursor into @vTenderAmt,@vForeign_amt,@vTndrid,@vTndrStatcode,@vTndridProp            
        if @@fetch_status <> 0 
                     BREAK
        if @vTndrStatcode <> 'Change'
          set @vTndrCount = -1  -- only for original tenders
        else 
          set @vTndrCount = 0

         if @vTndridProp IS NOT NULL
           set @vTndrid = @vTndridProp

        -- update flash
        set @vTenderAmt = @vTenderAmt * -1
 
       if @vTransStatcode = 'COMPLETE'
          exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
          @argWrkstnId,@vTndrid,@vTndrCount,@vTenderAmt,@vCurrencyId

        if @vTenderAmt < 0 and @vTransStatcode = 'COMPLETE'
          exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
          @argWrkstnId,'TendersTakenIn',-1,@vTenderAmt,@vCurrencyId
        else
          exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
          @argWrkstnId,'TendersRefunded',-1,@vTenderAmt,@vCurrencyId
  
      end
    close postVoidTenderCursor
    deallocate postVoidTenderCursor
  end

-- collect sales data
      if @vPostVoidFlag = 0 and @vTransTypcode <> 'POST_VOID' -- dont do it for rpt sale line
      begin
         insert into rpt_sale_line WITH(ROWLOCK)
        (organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq, rtrans_lineitm_seq,
        quantity, actual_quantity, gross_quantity, unit_price, net_amt, gross_amt, item_id, 
        item_desc, merch_level_1, serial_nbr, return_flag, override_amt, trans_timestamp, trans_date,
        discount_amt, cust_party_id, last_name, first_name, trans_statcode, sale_lineitm_typcode, 
        begin_time_int,currency_id, exclude_from_net_sales_flag)
    select tsl.organization_id, tsl.rtl_loc_id, tsl.business_date, tsl.wkstn_id, tsl.trans_seq, tsl.rtrans_lineitm_seq,
    tsl.net_quantity, tsl.quantity, tsl.gross_quantity, tsl.unit_price, tsl.net_amt, tsl.gross_amt, tsl.item_id,
    i.DESCRIPTION, coalesce(tsl.merch_level_1,i.MERCH_LEVEL_1,N'DEFAULT'), tsl.serial_nbr, tsl.return_flag, coalesce(o.override_amt,0), @vTransTimeStamp, @vTransDate,
    coalesce(d.discount_amt,0), tr.cust_party_id, cust.last_name, cust.first_name, @vTransStatcode, tsl.sale_lineitm_typcode, 
    @vBeginTimeInt, @vCurrencyId, tsl.exclude_from_net_sales_flag
    from trl_sale_lineitm tsl with (nolock) 
    inner join trl_rtrans_lineitm r with (nolock)
    on tsl.organization_id=r.organization_id
    and tsl.rtl_loc_id=r.rtl_loc_id
    and tsl.wkstn_id=r.wkstn_id
    and tsl.trans_seq=r.trans_seq
    and tsl.business_date=r.business_date
    and tsl.rtrans_lineitm_seq=r.rtrans_lineitm_seq
    and r.rtrans_lineitm_typcode = N'ITEM'
    left join xom_order_mod xom  with (nolock)
    on tsl.organization_id=xom.organization_id
    and tsl.rtl_loc_id=xom.rtl_loc_id
    and tsl.wkstn_id=xom.wkstn_id
    and tsl.trans_seq=xom.trans_seq
    and tsl.business_date=xom.business_date
    and tsl.rtrans_lineitm_seq=xom.rtrans_lineitm_seq
    left join xom_order_line xol  with (nolock)
    on xom.organization_id=xol.organization_id
    and xom.order_id=xol.order_id
    and xom.detail_seq=xol.detail_seq
    left join itm_item i
    on tsl.organization_id=i.ORGANIZATION_ID
    and tsl.item_id=i.ITEM_ID
    left join (select extended_amt override_amt,organization_id,rtl_loc_id,business_date,wkstn_id,trans_seq,rtrans_lineitm_seq
      FROM trl_rtl_price_mod with(nolock)
      WHERE void_flag = 0 and rtl_price_mod_reascode=N'PRICE_OVERRIDE') o
    on tsl.organization_id = o.organization_id 
      AND tsl.rtl_loc_id = o.rtl_loc_id
      AND tsl.business_date = o.business_date 
      AND tsl.wkstn_id = o.wkstn_id 
      AND tsl.trans_seq = o.trans_seq
      AND tsl.rtrans_lineitm_seq = o.rtrans_lineitm_seq
    left join (select sum(extended_amt) discount_amt,organization_id,rtl_loc_id,business_date,wkstn_id,trans_seq,rtrans_lineitm_seq
      FROM trl_rtl_price_mod with(nolock)
      WHERE void_flag = 0 and rtl_price_mod_reascode in (N'LINE_ITEM_DISCOUNT', N'TRANSACTION_DISCOUNT',N'GROUP_DISCOUNT', N'NEW_PRICE_RULE', N'DEAL')
      group by organization_id,rtl_loc_id,business_date,wkstn_id,trans_seq,rtrans_lineitm_seq) d
    on tsl.organization_id = d.organization_id 
      AND tsl.rtl_loc_id = d.rtl_loc_id
      AND tsl.business_date = d.business_date 
      AND tsl.wkstn_id = d.wkstn_id 
      AND tsl.trans_seq = d.trans_seq
      AND tsl.rtrans_lineitm_seq = d.rtrans_lineitm_seq
    left join trl_rtrans tr with(nolock)
    on tsl.organization_id = tr.organization_id 
      AND tsl.rtl_loc_id = tr.rtl_loc_id
      AND tsl.business_date = tr.business_date 
      AND tsl.wkstn_id = tr.wkstn_id 
      AND tsl.trans_seq = tr.trans_seq
    left join crm_party cust with(nolock)
    on tsl.organization_id = cust.organization_id 
      AND tr.cust_party_id = cust.party_id
    where tsl.organization_id = @argOrganizationId
    and tsl.rtl_loc_id = @argRetailLocationId
    and tsl.wkstn_id = @argWrkstnId
    and tsl.business_date = @argBusinessDate
    and tsl.trans_seq = @argTransSeq
    and r.void_flag=0
    and ((tsl.SALE_LINEITM_TYPCODE <> N'ORDER'and (xom.detail_type IS NULL OR xol.status_code = N'FULFILLED') )
    or (tsl.SALE_LINEITM_TYPCODE = N'ORDER' and xom.detail_type in (N'FEE', N'PAYMENT') ))
   end
    
    if @vTransStatcode = 'COMPLETE' -- only when complete populate flash sales
    begin 
    -- account credit on an order
    SELECT @vAccountCredit = sum(t.amt) 
    FROM xom_order_mod xo
    inner join ttr_tndr_lineitm t
    on xo.organization_id=t.organization_id
    and xo.rtl_loc_id=t.rtl_loc_id
    and xo.business_date=t.business_date
    and xo.wkstn_id=t.wkstn_id
    and xo.trans_seq=t.trans_seq
    where t.organization_id = @argOrganizationId
    and t.rtl_loc_id = @argRetailLocationId
    and t.wkstn_id = @argWrkstnId
    and t.business_date = @argBusinessDate
    and t.trans_seq = @argTransSeq
    and t.tndr_id = 'ACCOUNT_CREDIT'
     
        -- returns
    select @vQuantity=sum(case @vPostVoidFlag when 0 then -1 else 1 end * coalesce(quantity,0)),@vNetAmount=sum(case @vPostVoidFlag when 1 then -1 else 1 end * coalesce(net_amt,0)) 
    from rpt_sale_line rsl with(nolock)
    where rsl.organization_id = @argOrganizationId
      and rtl_loc_id = @argRetailLocationId
      and wkstn_id = @argWrkstnId
      and business_date = @argBusinessDate
      and trans_seq= @argTransSeq
      and return_flag=1
      and coalesce(exclude_from_net_sales_flag,0)=0
 
      if abs(@vQuantity)>0 or abs(@vNetAmount)>0
        -- populate now to flash tables
        exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
        @argWrkstnId,'Returns',@vQuantity, @vNetAmount, @vCurrencyId

    select @vGrossQuantity=sum(case when return_flag=@vPostVoidFlag then 1 else -1 end * coalesce(gross_quantity,0)),
    @vQuantity=sum(case when return_flag=@vPostVoidFlag then 1 else -1 end * coalesce(quantity,0)),
    @vGrossAmount=sum(case @vPostVoidFlag when 1 then -1 else 1 end * coalesce(gross_amt,0)),
    @vNetAmount=sum(case @vPostVoidFlag when 1 then -1 else 1 end * coalesce(net_amt,0)),
    @vOverrideAmt=sum(case @vPostVoidFlag when 1 then 1 else -1 end * coalesce(override_amt,0)),
    @vDiscountAmt=sum(case @vPostVoidFlag when 1 then 1 else -1 end * coalesce(discount_amt,0)) 
    from rpt_sale_line rsl with(nolock)
    where rsl.organization_id = @argOrganizationId
      and rtl_loc_id = @argRetailLocationId
      and wkstn_id = @argWrkstnId
      and business_date = @argBusinessDate
      and trans_seq= @argTransSeq
      AND QUANTITY <> 0
      AND sale_lineitm_typcode <> 'ONHOLD'
      and coalesce(exclude_from_net_sales_flag,0)=0

      -- Gross Sales update  
      if abs(@vGrossAmount) > 0 and @vGrossAmount <> coalesce(@vAccountCredit,0)
        exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
        @argWrkstnId,'GROSSSALES',@vGrossQuantity, @vGrossAmount, @vCurrencyId
      -- Net Sales update
      if abs(@vNetAmount) > 0 and @vGrossAmount <> coalesce(@vAccountCredit,0)
        exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
        @argWrkstnId,'NETSALES',@vQuantity, @vNetAmount, @vCurrencyId  
      -- Discounts
      if abs(@vOverrideAmt) > 0
        exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
        @argWrkstnId,'OVERRIDES',@vQuantity, @vOverrideAmt, @vCurrencyId  
      -- Discounts  
      if abs(@vDiscountAmt) > 0
        exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
        @argWrkstnId,'DISCOUNTS',@vQuantity, @vDiscountAmt, @vCurrencyId  

    -- Hourly sales updates (add for all the line items in the transaction)
      set @vTotQuantity = coalesce(@vTotQuantity, 0) + @vQuantity
      set @vTotNetAmt = coalesce(@vTotNetAmt, 0) + @vNetAmount
      set @vTotGrossAmt = coalesce(@vTotGrossAmt, 0) + @vGrossAmount

      -- non merchandise
      -- Non Merchandise (returns after processing)
    declare saleCursor cursor fast_forward for
    select rsl.item_id,sale_lineitm_typcode,actual_quantity,unit_price,case @vPostVoidFlag when 1 then -1 else 1 end * coalesce(gross_amt,0),case when return_flag=@vPostVoidFlag then 1 else -1 end * coalesce(gross_quantity,0),merch_level_1,case @vPostVoidFlag when 1 then -1 else 1 end * coalesce(net_amt,0),case when return_flag=@vPostVoidFlag then 1 else -1 end * coalesce(quantity,0),return_flag
    from rpt_sale_line rsl with(nolock)
    where rsl.organization_id = @argOrganizationId
      and rtl_loc_id = @argRetailLocationId
      and wkstn_id = @argWrkstnId
      and business_date = @argBusinessDate
      and trans_seq= @argTransSeq
      AND QUANTITY <> 0
      AND sale_lineitm_typcode <> 'ONHOLD'
      and coalesce(exclude_from_net_sales_flag,0)=0

    open saleCursor

    while 1=1
    begin

    fetch from saleCursor into @vItemId,@vSaleLineItmTypcode,@vActualQuantity,@vUnitPrice,@vGrossAmount,@vGrossQuantity,@vDepartmentId,@vNetAmount,@vQuantity,@vReturnFlag;
    if @@FETCH_STATUS <> 0
    break;

      select @vNonPhysType = non_phys_item_typcode from itm_non_phys_item with (nolock)
      where item_id = @vItemId and organization_id = @argOrganizationId    
      IF @@rowcount = 1
        begin      
        -- check for layaway or sp. order payment / deposit
          if @vPostVoidFlag <> @vReturnFlag
            begin
              set @vNonPhysPrice = @vUnitPrice * -1
              set @vNonPhysQuantity = @vActualQuantity * -1
            end
          else
            begin
              set @vNonPhysPrice = @vUnitPrice
              set @vNonPhysQuantity = @vActualQuantity
            end
        
          if @vNonPhysType = 'LAYAWAY_DEPOSIT'
            set @vNonPhys = 'LayawayDeposits'
          else if @vNonPhysType = 'LAYAWAY_PAYMENT'
            set @vNonPhys = 'LayawayPayments'
          else if @vNonPhysType = 'SP_ORDER_DEPOSIT'
            set @vNonPhys = 'SpOrderDeposits'        
          else if @vNonPhysType = 'SP_ORDER_PAYMENT'
            set @vNonPhys = 'SpOrderPayments'        
          else if @vNonPhysType = 'PRESALE_DEPOSIT'
            set @vNonPhys = 'PresaleDeposits'
          else if @vNonPhysType = 'PRESALE_PAYMENT'
            set @vNonPhys = 'PresalePayments'
          else 
            begin
              set @vNonPhys = 'NonMerchandise'
              set @vNonPhysPrice = @vGrossAmount
              set @vNonPhysQuantity = @vGrossQuantity
            end
          -- update flash sales for non physical payments / deposits
          exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
          @argWrkstnId,@vNonPhys,@vNonPhysQuantity, @vNonphysPrice, @vCurrencyId
        end  
      else
      set @vNonPhys = '' -- reset 

      -- process layaways and special orders (not sales)
      if @vSaleLineitmTypcode = 'LAYAWAY' or @vSaleLineitmTypcode = 'SPECIAL_ORDER'
        begin
          if (not (@vNonPhys = 'LayawayDeposits' or @vNonPhys = 'LayawayPayments' 
            or @vNonPhys = 'SpOrderDeposits' or @vNonPhys = 'SpOrderPayments' 
            or @vNonPhys = 'PresaleDeposits' or @vNonPhys = 'PresalePayments')) 
            and ((@vLineitemStatcode is null) or (@vLineitemStatcode <> 'CANCEL'))
            begin
            
              set @vNonPhysSaleType = 'SpOrderItems'
              if @vSaleLineitmTypcode = 'LAYAWAY'
                set @vNonPhysSaleType = 'LayawayItems'
              else if @vSaleLineitmTypcode = 'PRESALE'
                set @vNonPhysSaleType = 'PresaleItems'
              
              -- update flash sales for layaway items
              set @vLayawayPrice = @vUnitPrice * coalesce(@vActualQuantity, 0)
              exec sp_ins_upd_flash_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
              @argWrkstnId,@vNonPhys,@vActualQuantity, @vLayawayPrice, @vCurrencyId
            end  
        end
      -- end flash sales update
      -- department sales
      exec sp_ins_upd_merchlvl1_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
      @argWrkstnId,@vDepartmentId,@vQuantity,@vNetAmount,@vGrossAmount,@vCurrencyId      
    end -- sale cursor ends
  close saleCursor
  deallocate saleCursor 
  end -- only when transaction is complete populate flash sales ends

-- update hourly sales
if (abs(@vTotNetAmt) > 0 or abs(@vTotGrossAmt) > 0 or abs(@vTotquantity) > 0)
   exec sp_ins_upd_hourly_sales @argOrganizationId,@argRetailLocationId,@vTransDate,
   @argWrkstnId,@vTransTimeStamp,@vTotquantity,@vTotNetAmt,@vTotGrossAmt,@vTransCount,@vCurrencyId 
if @old_context_info is null
	SET CONTEXT_INFO 0x
else
	SET CONTEXT_INFO @old_context_info
GO
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
-- PGH 04/25/11		Added the options FAST_FORWARD READ_ONLY to the main cursor to improve performance.
-- BCW 12/05/13		Added optional parameters and logging.
-------------------------------------------------------------------------------------------------------------------
PRINT 'dbo.sp_report';

IF EXISTS (Select * From sysobjects Where name = 'sp_report' and type = 'P')
  DROP PROCEDURE sp_report;
GO

CREATE PROCEDURE sp_report
(
	@job_id			INT			=0,
	@firstLoc_id	INT			=0,
	@lastLoc_id		INT			=999999999,
	@start_date		DATETIME	='1/1/1900',
	@end_date		DATETIME	='12/31/9999',
	@batch_count	INT			=-1,
	@nologging		BIT			=0
)
AS
  DECLARE -- Keys
      @vOrganizationId		int,
      @vRetailLocationId	int,
      @vBusinessDate		datetime,
      @vWrkstnId			bigint,
      @vTransSeq			bigint,
	  @starttime			DATETIME,
	  @sql				 nvarchar(MAX);

set @starttime=GETDATE()

  DECLARE @staging TABLE (
    organization_id  INT       NOT NULL,
    rtl_loc_id       INT       NOT NULL,
    business_date    DATETIME  NOT NULL,
    wkstn_id         BIGINT    NOT NULL,
    trans_seq        BIGINT    NOT NULL
  )

if OBJECT_ID('log_sp_report') IS NULL
	SET @nologging=1

SET @sql = 'SELECT '

if @batch_count > -1
	SET @sql = @sql + ' top(' + cast(@batch_count as nvarchar(10)) + ') '
SET @sql = @sql + 'organization_id, 
          rtl_loc_id, 
          business_date, 
          wkstn_id, 
          trans_seq
   FROM trn_trans with (READPAST)
   WHERE flash_sales_flag = 0
   AND trans_typcode in (''RETAIL_SALE'',''POST_VOID'')
   AND trans_statcode not like ''CANCEL%'''

if @firstLoc_id <> 0 OR @lastLoc_id <> 999999999
	SET @sql = @sql + ' AND rtl_loc_id between ' + cast(@firstLoc_id as nvarchar(10)) + ' AND ' + cast(@lastLoc_id as varchar(10))

if @start_date <> '1/1/1900' OR @end_date <> '12/31/9999'
	SET @sql = @sql + ' AND business_date between ''' + cast(@start_date as nvarchar(19)) + ''' AND ''' + cast(@end_date as varchar(19)) + ''''

if @nologging = 0
SET @sql = @sql + ' ORDER BY business_date, rtl_loc_id';

INSERT @staging (organization_id, rtl_loc_id, business_date, wkstn_id, trans_seq) exec(@sql)

  DECLARE cur_main CURSOR FAST_FORWARD FOR
  SELECT organization_id, 
          rtl_loc_id, 
          business_date, 
          wkstn_id, 
          trans_seq
   FROM @staging

  if @nologging=0
	  insert into log_sp_report WITH(ROWLOCK) (job_id,loc_id,business_date,job_start,completed,expected)
	  select @job_id, rtl_loc_id, business_date, @starttime, 0, COUNT(*)
	  from @staging
	  group by rtl_loc_id,business_date

  OPEN cur_main;

  WHILE 1 = 1 BEGIN
    FETCH FROM cur_main 
      INTO @vOrganizationId,
           @vRetailLocationId, 
           @vBusinessDate, 
           @vWrkstnId, 
           @vTransSeq;
  
	IF @@FETCH_STATUS <> 0 
      BREAK;

	if @nologging=0
		update log_sp_report WITH(ROWLOCK) set start_dt = GETDATE() where loc_id = @vRetailLocationId and business_date=@vBusinessDate and job_start=@starttime and job_id=@job_id and start_dt is null

	EXEC sp_flash @vOrganizationId,
				  @vRetailLocationId, 
				  @vBusinessDate, 
				  @vWrkstnId, 
				  @vTransSeq;

	if @nologging=0
		update log_sp_report WITH(ROWLOCK) set completed = completed + 1,end_dt = GETDATE() where loc_id = @vRetailLocationId and business_date=@vBusinessDate and job_start=@starttime and job_id=@job_id

  END;
  CLOSE cur_main;
  DEALLOCATE cur_main;

if @nologging=0
	update log_sp_report WITH(ROWLOCK) set job_end = GETDATE() where job_start=@starttime and job_id=@job_id
GO
/* 
 * TRIGGER: [dbo].[trg_insert_trl_returned_item_journal] 
 */

IF EXISTS (Select * From sysobjects Where name = 'trg_insert_trl_returned_item_journal' and type = 'TR')
  DROP TRIGGER trg_insert_trl_returned_item_journal;
GO

CREATE TRIGGER trg_insert_trl_returned_item_journal
    ON trl_returned_item_journal
    AFTER INSERT
AS
  BEGIN
    DECLARE @new_organization_id int,
            @new_rtl_loc_id int,
            @new_wkstn_id bigint,
            @new_business_date datetime,
            @new_trans_seq bigint,
            @new_rtrans_lineitm_seq int,
            @new_returned_count decimal(11, 2);

    SELECT @new_organization_id = organization_id,
           @new_rtl_loc_id = rtl_loc_id,
           @new_wkstn_id = wkstn_id,
           @new_business_date = business_date,
           @new_trans_seq = trans_seq,    
           @new_rtrans_lineitm_seq = rtrans_lineitm_seq,
           @new_returned_count = returned_count
      FROM inserted;

    IF EXISTS (
        Select 1 From trn_trans trans
          Where trans.organization_id = @new_organization_id
            And trans.rtl_loc_id = @new_rtl_loc_id
            And trans.wkstn_id = @new_wkstn_id
            And trans.business_date = @new_business_date
            And trans.trans_seq = @new_trans_seq) 
    BEGIN
      IF EXISTS (
          Select 1 From trl_returned_item_count With (NOLOCK) 
            Where organization_id = @new_organization_id 
              And rtl_loc_id = @new_rtl_loc_id 
              And wkstn_id = @new_wkstn_id 
              And business_date = @new_business_date 
              And trans_seq = @new_trans_seq 
              And rtrans_lineitm_seq = @new_rtrans_lineitm_seq)
      BEGIN
        UPDATE trl_returned_item_count 
          SET returned_count = returned_count + @new_returned_count
          WHERE organization_id = @new_organization_id 
            AND rtl_loc_id = @new_rtl_loc_id 
            AND wkstn_id = @new_wkstn_id 
            AND business_date = @new_business_date 
            AND trans_seq = @new_trans_seq 
            AND rtrans_lineitm_seq = @new_rtrans_lineitm_seq;
      END
    ELSE
      BEGIN
        INSERT INTO trl_returned_item_count
            (organization_id, rtl_loc_id, wkstn_id, business_date, trans_seq, rtrans_lineitm_seq, returned_count)
          VALUES
            (@new_organization_id, @new_rtl_loc_id, @new_wkstn_id, @new_business_date, 
            @new_trans_seq, @new_rtrans_lineitm_seq, @new_returned_count);
      END
    END
  END
GO
-- ***************************************************************************
-- This script will apply after all schema artifacts have been upgraded to a given version.  It is
-- generally useful for performing conversions between legacy and modern representations of affected
-- data sets.
--
-- Source version:  15.0.x
-- Target version:  16.0.0
-- DB platform:     Microsoft SQL Server 2008/2012
-- ***************************************************************************

-- LEAVE BLANK LINE BELOW

INSERT INTO ctl_version_history (
    organization_id, base_schema_version, customer_schema_version, base_schema_date, 
    create_user_id, create_date, update_user_id, update_date)
VALUES (
    $(OrgID), '16.0.0.0.699', '0.0.0 - 0.0', getDate(), 
    'Oracle', getDate(), 'Oracle', getDate());

GO
