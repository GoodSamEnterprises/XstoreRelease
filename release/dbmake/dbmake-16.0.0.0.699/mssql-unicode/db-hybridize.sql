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
-- DB platform:     Microsoft SQL Server 2008/2012
-- ***************************************************************************

-- ***************************************************************************
-- ***************************************************************************
-- CLOSE SECURITY LOOPHOLES 
-- ***************************************************************************
-- ***************************************************************************
EXEC sp_configure 'show advanced options', 1;
RECONFIGURE;
EXEC sp_configure 'fill factor', 80;
EXEC sp_configure 'xp_cmdshell', 0;
EXEC sp_configure 'disallow results from triggers', 1;
EXEC sp_configure 'Ad Hoc Distributed Queries', 0;
EXEC sp_configure 'show advanced options', 0;
RECONFIGURE;
-- ***************************************************************************
-- ***************************************************************************

PRINT '**************************************';
PRINT '*****        HYBRIDIZING         *****';
PRINT '***** From:  15.0.*              *****';
PRINT '*****   To:  15.0.*/16.0.0       *****';
PRINT '**************************************';
GO

IF  OBJECT_ID('Create_Property_Table') is not null
       DROP PROCEDURE Create_Property_Table
GO

CREATE PROCEDURE Create_Property_Table 
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
IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'tare_value' AND object_id = OBJECT_ID('itm_item_options'))
  ALTER TABLE itm_item_options ADD tare_value decimal(11, 4) null;
GO

IF NOT EXISTS (SELECT 1 FROM sys.columns WHERE name = 'tare_unit_of_measure_code' AND object_id = OBJECT_ID('itm_item_options'))
  ALTER TABLE itm_item_options ADD tare_unit_of_measure_code nvarchar(30) null;
GO

IF EXISTS (SELECT * FROM sys.tables WHERE object_id = OBJECT_ID('itm_tare_type'))
BEGIN
    exec('UPDATE itm_item_options
    SET tare_value                = (SELECT tare FROM itm_tare_type WHERE organization_id = itm_item_options.organization_id AND tare_typecode = itm_item_options.tare_typecode),
        tare_unit_of_measure_code = (SELECT unit_of_measure_code FROM itm_tare_type WHERE organization_id = itm_item_options.organization_id AND tare_typecode = itm_item_options.tare_typecode)');
    
    DROP TABLE itm_tare_type;
END
GO

IF EXISTS (SELECT * FROM sys.views WHERE name = 'itm_tare_type')
    DROP VIEW itm_tare_type;
GO

CREATE VIEW itm_tare_type AS
SELECT [organization_id]
      ,[tare_typecode]
      ,[tare_value] as tare
      ,[tare_unit_of_measure_code] as unit_of_measure_code
      ,[level_code] as org_code
      ,[level_value] as org_value
      ,[create_date]
      ,[create_user_id]
      ,[update_date]
      ,[update_user_id]
      ,[record_state]
      FROM itm_item_options;
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

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'destination_airport' AND object_id = OBJECT_ID('trl_rtrans_flight_info') AND max_length>3 ) AND NOT EXISTS (SELECT 1 FROM trl_rtrans_flight_info WHERE LEN(destination_airport)>3)
  ALTER TABLE trl_rtrans_flight_info ALTER COLUMN destination_airport nvarchar(3) NULL;
GO

IF EXISTS (SELECT 1 FROM sys.columns WHERE name = 'origin_airport' AND object_id = OBJECT_ID('trl_rtrans_flight_info') AND max_length>3 ) AND NOT EXISTS (SELECT 1 FROM trl_rtrans_flight_info WHERE LEN(origin_airport)>3)
  ALTER TABLE trl_rtrans_flight_info ALTER COLUMN origin_airport nvarchar(3) NULL;
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

IF EXISTS (Select * From sysobjects Where name = 'trg_trn_trans_trans_date' and type = 'TR')
  DROP TRIGGER trg_trn_trans_trans_date;
GO
 
CREATE TRIGGER trg_trn_trans_trans_date
   ON trn_trans AFTER INSERT
AS 
BEGIN
  SET NOCOUNT ON;
  UPDATE t 
     SET t.trans_date = i.business_date 
    FROM trn_trans t 
    INNER JOIN inserted i
        ON t.organization_id = i.organization_id
       AND t.rtl_loc_id = i.rtl_loc_id
       AND t.business_date = i.business_date
       AND t.wkstn_id = i.wkstn_id
       AND t.trans_seq = i.trans_seq
   WHERE i.trans_date is null;
END
GO


-- Keep at end of the script
IF  OBJECT_ID('Create_Property_Table') is not null
       DROP PROCEDURE Create_Property_Table
GO

PRINT '***************************************************************************';
PRINT 'Database now hybridized to support clients running against the following versions:';
PRINT '    15.0.*';
PRINT '    16.0.0';
PRINT 'Please run the corresponding un-hybridize script against this database once all';
PRINT 'clients on earlier supported versions have been updated to the latest supported release.';
PRINT '***************************************************************************';
-- LEAVE BLANK LINE BELOW
