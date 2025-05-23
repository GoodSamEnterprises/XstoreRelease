

-- set database options
EXEC sp_configure 'show advanced options', 1;
RECONFIGURE;
EXEC sp_configure 'fill factor', 80;
EXEC sp_configure 'show advanced options', 0;
RECONFIGURE;

DECLARE
  @dbName nvarchar(30);

SELECT @dbName = DB_NAME();

IF OBJECT_ID('rpl_replication_data') IS NULL
BEGIN
PRINT 'Create the rpl_replication_data table.'
exec('CREATE TABLE [dbo].[rpl_replication_data](
    [organization_id]         int             NOT NULL,
    [rtl_loc_id]              int             NOT NULL,
    [wkstn_id]                bigint          NOT NULL,
    [timestamp_str]           nchar(24)        NOT NULL,
    [publish_status]          nvarchar(32)	  NULL,
    [payload]                 text			  NULL,
    [payload_summary]         nvarchar(254)	  NULL,
    [error_details]           text			  NULL,
    [orig_arrival_timestamp]  datetime		  NULL,
    [reprocess_user_id]       nvarchar(20)	  NULL,
    [reprocess_timestamp]     datetime		  NULL,
    [reprocess_attempts]      int			  NULL,
    [create_date]             datetime		  NULL,
    [create_user_id]          nvarchar(30)	  NULL,
    [update_date]             datetime		  NULL,
    [update_user_id]          nvarchar(30)	  NULL,
    CONSTRAINT [PK_rpl_replication_data] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [timestamp_str], [wkstn_id]) WITH (FILLFACTOR = 80)
)');
END

/* 
 * INDEX: [idx_repl_data_timestamp_str] 
 */
IF NOT EXISTS (SELECT * FROM sys.indexes WHERE object_id = OBJECT_ID('rpl_replication_data') AND name = 'idx_repl_data_timestamp_str')
    exec('CREATE INDEX idx_repl_data_timestamp_str ON rpl_replication_data(timestamp_str) WITH (FILLFACTOR = 80)');


/* 
 * INDEX: [idx_repl_data_org_ps] 
 */
IF NOT EXISTS (SELECT * FROM sys.indexes WHERE object_id = OBJECT_ID('rpl_replication_data') AND name = 'idx_repl_data_org_ps')
    exec('CREATE INDEX idx_repl_data_org_ps ON rpl_replication_data(ORGANIZATION_ID, publish_status) WITH (FILLFACTOR = 80)');


/* 
 * INDEX: [idx_repl_data_date_ps] 
 */
IF NOT EXISTS (SELECT * FROM sys.indexes WHERE object_id = OBJECT_ID('rpl_replication_data') AND name = 'idx_repl_data_date_ps')
    exec('CREATE INDEX idx_repl_data_date_ps ON rpl_replication_data(update_date, publish_status) WITH (FILLFACTOR = 80)');
GO

IF OBJECT_ID('poll_file_status') IS NULL
BEGIN
PRINT 'Create the poll_file_status table.'
exec('CREATE TABLE [dbo].[poll_file_status](
    [organization_id]         int           NOT NULL,
    [file_name]               nvarchar(254)  NOT NULL,
    [timestamp_str]           nchar(24)      NULL,
    [create_date]             datetime      NULL,
    [create_user_id]          nvarchar(30)   NULL,
    [update_date]             datetime      NULL,
    [update_user_id]          nvarchar(30)   NULL,
    CONSTRAINT [PK_poll_file_status] PRIMARY KEY CLUSTERED ([organization_id], [file_name]) WITH (FILLFACTOR = 80)
)');
END

IF OBJECT_ID('rpl_cleanup_log') IS NULL
BEGIN
PRINT 'Create the rpl_cleanup_log table.'
exec('CREATE TABLE [dbo].[rpl_cleanup_log](
	[deleted_records]	int			NOT NULL,
	[start_time]		datetime	NOT NULL,
	[end_time]			datetime	NOT NULL,
	[table_name]	 nvarchar(20)	NOT NULL,
    CONSTRAINT [PK_rpl_cleanup_log] PRIMARY KEY CLUSTERED ([start_time],[table_name]) WITH (FILLFACTOR = 80)
)');
END

IF OBJECT_ID('trn_poslog_work_item') IS NULL
BEGIN
PRINT 'Create the trn_poslog_work_item table.'
exec('CREATE TABLE [dbo].[trn_poslog_work_item](
    [organization_id]    int            NOT NULL,
    [rtl_loc_id]         int            NOT NULL,
    [business_date]      datetime       NOT NULL,
    [wkstn_id]           bigint         NOT NULL,
    [trans_seq]          bigint         NOT NULL,
    [service_id]         nvarchar(60)    NOT NULL,
    [work_status]        nvarchar(200)   NULL,
    [error_details]      text           NULL,
    [create_date]        datetime       NULL,
    [create_user_id]     nvarchar(30)    NULL,
    [update_date]        datetime       NULL,
    [update_user_id]     nvarchar(30)    NULL,
    CONSTRAINT [pk_trn_poslog_work_item] PRIMARY KEY CLUSTERED ([organization_id], [rtl_loc_id], [business_date], [wkstn_id], [trans_seq], [service_id]) WITH (FILLFACTOR = 80)
)');
END

PRINT 'sp_Replication_Cleanup';

IF OBJECT_ID('sp_Replication_Cleanup') IS NOT NULL
  exec('DROP PROCEDURE sp_Replication_Cleanup;');

  
exec('CREATE PROCEDURE sp_Replication_Cleanup (@ai_delay int = 3)
AS
BEGIN
-------------------------------------------------------------------------------------------------------------------
--                     
-- Procedure         : sp_Replication_Cleanup (@ai_delay int)
-- Parameters    : @ai_delay
-- Description       : 
-- Version           : 6.0
-------------------------------------------------------------------------------------------------------------------
--                            CHANGE HISTORY                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- WHO DATE      DESCRIPTION                                                                                     --
-------------------------------------------------------------------------------------------------------------------
    SET NOCOUNT ON;
    Declare @li_cnt     int,
      @ld_start   datetime,
      @ld_end     datetime

    SET @ld_start=GETDATE();

    SELECT @li_cnt=COUNT(*) FROM RPL_REPLICATION_DATA WHERE PUBLISH_STATUS=''COMPLETE'' AND update_date < @ld_start-@ai_delay;

    WHILE (SELECT COUNT(*) FROM RPL_REPLICATION_DATA WHERE PUBLISH_STATUS=''COMPLETE'' AND update_date < @ld_start-@ai_delay)>0
     DELETE TOP(5000) FROM RPL_REPLICATION_DATA WITH(TABLOCK) WHERE PUBLISH_STATUS=''COMPLETE'' AND update_date < @ld_start-@ai_delay;

    SET @ld_end=GETDATE();

    INSERT INTO rpl_cleanup_log (deleted_records,start_time,end_time,table_name) VALUES(@li_cnt,@ld_start,@ld_end,''RPL_REPLICATION_DATA'');

    SET @ld_start=GETDATE();

    SELECT @li_cnt=COUNT(*) FROM trn_poslog_work_item WHERE WORK_STATUS=''COMPLETE'' AND update_date < @ld_start-@ai_delay;

    WHILE (SELECT COUNT(*) FROM trn_poslog_work_item WHERE WORK_STATUS=''COMPLETE'' AND update_date < @ld_start-@ai_delay)>0
     DELETE TOP(5000) FROM trn_poslog_work_item WITH(TABLOCK) WHERE WORK_STATUS=''COMPLETE'' AND update_date < @ld_start-@ai_delay;

    SET @ld_end=GETDATE();

    INSERT INTO rpl_cleanup_log (deleted_records,start_time,end_time,table_name) VALUES(@li_cnt,@ld_start,@ld_end,''trn_poslog_work_item'');

END');

PRINT 'sp_shrink';


IF OBJECT_ID('sp_shrink') IS NOT NULL
  exec('DROP PROCEDURE sp_shrink;');

  
exec('CREATE PROCEDURE sp_shrink (@ai_free_space  int = 10)
AS
BEGIN
-------------------------------------------------------------------------------------------------------------------
--                     
-- Procedure         : sp_shrink (ai_free_space int)
-- Parameters    : ai_free_space
-- Description       : 
-- Version           : 6.0
-------------------------------------------------------------------------------------------------------------------
--                            CHANGE HISTORY                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- WHO DATE      DESCRIPTION                                                                                     --
-------------------------------------------------------------------------------------------------------------------
  DECLARE
    @ls_owner_nm      sysname,
    @ls_table_nm      sysname,
    @ls_index_nm      sysname,
    @li_index_id      integer,
    @li_fillfactor      integer,
    @ls_domain        nchar(3),
    @ls_sqlcmd        nvarchar(256);
    
  DECLARE Table_List CURSOR FOR
    SELECT schema_name(schema_id), object_name (object_id)
      FROM sys.tables
      WHERE type = ''U''
  
  --
  -- Loop through the tables and rebuild the indexes with 100% fill factor
  --
  OPEN Table_List

  FETCH NEXT
  FROM Table_List
  INTO @ls_owner_nm, @ls_table_nm

  WHILE @@FETCH_STATUS = 0
  BEGIN
    SET @ls_sqlcmd = ''ALTER INDEX ALL  on ['' + @ls_owner_nm + ''].['' + @ls_table_nm + ''] REBUILD WITH (FILLFACTOR=100)'';  -- Online only works with Enterprise Edition
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
  print ''Free Space%: '' + str(@ai_free_space);
  DBCC SHRINKDATABASE (0, @ai_free_space);

  DECLARE Index_List CURSOR FOR
    SELECT schema_name(t.schema_id), object_name(i.object_id), i.index_id, i.name
      FROM sys.indexes i
      JOIN sys.tables t on i.object_id = t.object_id
      WHERE t.type = ''U''
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
    set @li_fillfactor = 80;    -- non-clustered indexes
    
    SET @ls_sqlcmd = ''ALTER INDEX ['' + @ls_index_nm + '']  on ['' + @ls_owner_nm + ''].['' + @ls_table_nm + ''] REBUILD WITH (FILLFACTOR='' + ltrim(str(@li_fillfactor)) + '')'';  -- Online only works with Enterprise Edition
    --print @ls_sqlcmd;
    exec (@ls_sqlcmd);

    FETCH NEXT
    FROM Index_List
    INTO @ls_owner_nm, @ls_table_nm, @li_index_id, @ls_index_nm
  END;
  
  CLOSE Index_List;
  DEALLOCATE Index_List;
END');


PRINT 'sp_defrag_indexes';

IF OBJECT_ID('sp_defrag_indexes') IS NOT NULL
  exec('DROP PROCEDURE sp_defrag_indexes;')

  
exec('CREATE PROCEDURE sp_defrag_indexes (@minfrag int = 10,
                      @minindexpages int = 1)
AS
BEGIN
-------------------------------------------------------------------------------------------------------------------
--                                                                                                               --
-- Procedure         : sp_defrag_indexes (@minfrag int, @minindexpage int)                     --
-- Parameters    : minfrag - The minum about a fragmentation allowed in the database.  Tables with less than
--                               the amont specified will not be reorganized.
--                   : minindexpages - The minum number of pages in the indexes for a reorganized to be performed --
-- Description       : Reorganizes the tables that are fragmented with the respective minimume fragmentation 
-- Version           : 6.0                                                                                       --
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

  DECLARE @ls_version     nvarchar(128),
      @li_version     integer,
      @li_pos       integer,
      @table_nm     nvarchar (128),
      @index_nm     nvarchar(128),
      @objectid     INT,
      @indexid      INT,
      @part_nbr     int,
      @index_typ      nvarchar(60),
      @index_depth    int,
      @page_cnt     int,
      @frag       DECIMAL,
      @dbname       sysname,
      @ls_sqlcmd      nvarchar(128)

  --check to verify the version, this procedure is using the DMV views introduced in 2005
  --check this is being run in a user database
  SET @ls_version = CONVERT(varchar(128), SERVERPROPERTY (''ProductVersion''))
  SET @li_pos = CHARINDEX(''.'', @ls_version) - 1
  SET @li_version = CONVERT(int, SUBSTRING(@ls_version, 1, @li_pos))
  IF @li_version < 9
  BEGIN
    PRINT ''Wrong Version, this procedure requires SQL SERVER 2005 or greater''
    RETURN
  END

  SELECT @dbname = db_name()
  IF @dbname IN (''master'', ''msdb'', ''model'', ''tempdb'')
  BEGIN
    PRINT ''This procedure should not be run in system databases.''
    RETURN
  END

  --begin Stage 1: Find the indexes with fragmentation
  -- Declare cursor 
  DECLARE FindIDXFrag CURSOR FOR
  SELECT object_name(i.object_id) as ''Table Name'', 
      i.name as ''Index Name'',
      i.object_id,
      i.index_id,
      partition_number,
      index_type_desc,
      index_depth,
      avg_fragmentation_in_percent,
      page_count
    FROM sys.dm_db_index_physical_stats(db_id(), NULL, NULL, NULL , NULL) ips
    JOIN sys.indexes i on i.object_id = ips.object_id and i.index_id = ips.index_id
    where index_type_desc in (''CLUSTERED INDEX'', ''NONCLUSTERED INDEX'')
      --and avg_fragmentation_in_percent > @minfrag
      and page_count > @minindexpages

  ---- Report the ouput of showcontig for results checking
  -- SELECT * FROM #fraglist order by 1

  -- Write to output start time for information purposes
  PRINT ''Started defragmenting indexes at '' + CONVERT(VARCHAR,GETDATE())
  PRINT ''REORGANIZING:''

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
          PRINT ''Index '' + @index_nm + '' on '' + @table_nm + '' Rebuilt'';
--          SET @ls_sqlcmd = ''ALTER INDEX ['' + @index_nm + ''] on ['' + @table_nm + ''] REBUILD WITH ONLINE=ON'';  -- Online only works with Enterprise Edition
          SET @ls_sqlcmd = ''ALTER INDEX ['' + @index_nm + ''] on ['' + @table_nm + ''] REBUILD WITH (FILLFACTOR = 80)'';
          print @ls_sqlcmd;
          exec (@ls_sqlcmd);
        END;
      ELSE
        BEGIN
          PRINT ''Index '' + @index_nm + '' on '' + @table_nm + '' Reorganized'';
          SET @ls_sqlcmd = ''ALTER INDEX ['' + @index_nm + ''] on ['' + @table_nm + ''] REORGANIZE'';
          --print @ls_sqlcmd;
          exec (@ls_sqlcmd);
          SET @ls_sqlcmd = ''UPDATE STATISTICS ['' + @table_nm + ''] ['' + @index_nm + '']'';
          --print @ls_sqlcmd;
          exec (@ls_sqlcmd);
        END;
    END;
    ELSE
      BEGIN
        PRINT ''Index '' + @index_nm + '' on '' + @table_nm + '' Statistics Updated'';
        SET @ls_sqlcmd = ''UPDATE STATISTICS ['' + @table_nm + ''] ['' + @index_nm + '']'';
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
  PRINT ''Finished defragmenting indexes at '' + CONVERT(VARCHAR,GETDATE());
END');

PRINT 'sp_dbMaintenance';


IF OBJECT_ID('sp_dbMaintenance') IS NOT NULL
  exec('DROP PROCEDURE sp_dbMaintenance;');


exec('CREATE PROCEDURE sp_dbMaintenance
AS
-------------------------------------------------------------------------------------------------------------------
--                                                                                                               --
-- Procedure         : sp_dbMaintenance
-- Description       : Performs standard maitntenance to a SQL Server database
--            1) Check recovery model and last backup
--            2) Index Reorganize
--            3) CheckDB
-- Version           : 6.0                                                                                       --
-------------------------------------------------------------------------------------------------------------------
--                            CHANGE HISTORY                                                                     --
-------------------------------------------------------------------------------------------------------------------
-- WHO DATE      DESCRIPTION                                                                                     --
-- ST  01/30/07  Initially created
-- PGH 02/11/10  Rewriten for 2005 / 2008
-------------------------------------------------------------------------------------------------------------------
DECLARE @dbName       sysname,
    @dbRecovery     nvarchar(60),
    @LastFullBackup   datetime,
    @LastTransBackup  datetime,
    @MinFragmentation decimal
--    @dbBk       nvarchar(255),
--    @logBk        nvarchar(255),
--    @doBk       bit

BEGIN
  -- config
  SET @MinFragmentation = 30 --Percent
--  SET @dbBk = ''c:\xstoredb\backup\xstoreDb.bk'' -- db back up destinataion
--  SET @logBk = ''c:\xstoredb\backup\xstoreLog.bk''  -- log file back up destination
--  SET @doBK = 0 -- set to true for backup
  -- end config

  SET @dbName = db_name();
  SELECT @dbRecovery = recovery_model_desc FROM SYS.DATABASES WHERE NAME =DB_NAME();
  SELECT @LastFullBackup = max(backup_finish_date) from msdb..backupset
    WHERE type = ''D''
      AND database_name = DB_NAME();
  SELECT @LastTransBackup = max(backup_finish_date) from msdb..backupset
    WHERE type = ''L''
      AND database_name = DB_NAME();
      
  --
  -- 1) Check Backup Status
  --
  
  PRINT '''';
  PRINT '' Database Backup Info:'';
  PRINT ''    Database Name:     '' + db_name();
  PRINT ''    Recovery Mode:     '' + @dbRecovery;
  PRINT ''    Last Full Backup:  '' + COALESCE(cast(@LastFullBackup as nvarchar), '' '');
  PRINT ''     Last Trans Backup: '' + COALESCE(cast(@LastTransBackup as nvarchar), '' '');
  PRINT '''';

  SELECT  CASE df.data_space_id
        WHEN 0 THEN ''LOG''
        ELSE  ds.name
      END AS [FileGroupName],
      df.name AS [FileName], 
      df.physical_name AS [PhysicalName], 
      round((cast(df.size as decimal) / 128) , 2) AS [Size], 
      round((FILEPROPERTY(df.name, ''SpaceUsed'')/ 128.0),2) AS [SpaceUsed],  --Changed from Available Space to Used Space
      cast(ROUND(((FILEPROPERTY(df.name, ''SpaceUsed'')/ 128.0) / (cast(df.size as decimal) / 128)) * 100, 0) as int)
        AS [SpaceUsedPCT],
      CASE is_percent_growth
      WHEN 0 THEN growth / 128
      ELSE growth
    END AS [Growth],
    CASE is_percent_growth
      WHEN 0 THEN ''MB''
      ELSE ''PCT''
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

  PRINT ''Reorganizing Indexes''
  EXEC sp_defrag_indexes @MinFragmentation

  -- 3) Update the stats
  --PRINT ''Updating Statistics''
  --EXEC sp_updatestats -- with default parameters runs stats for sample rows on all tables
  

  -- 3) Check DB
  PRINT ''CheckDB'';
  DBCC CHECKDB WITH NO_INFOMSGS;

  -- 5) Backup Database
  --IF @doBk = 1
  --  BEGIN
  --    BACKUP DATABASE @dbName TO DISK = @dbBk
  --    BACKUP LOG @dbName TO DISK = @logBk
  --  END
END');

PRINT 'Xcenter Replication Cleanup job'

exec('/****** Object:  Job [Xcenter Replication Cleanup] ******/
IF  EXISTS (SELECT job_id FROM msdb.dbo.sysjobs_view WHERE name = N''Xcenter Replication Cleanup'')
BEGIN
    declare @jobid nvarchar(254);
    SELECT @jobid=job_id FROM msdb.dbo.sysjobs_view WHERE name = N''Xcenter Replication Cleanup''
    EXEC msdb.dbo.sp_delete_job @job_id=@jobid, @delete_unused_schedule=0
END');

exec('/****** Object:  Job [Xcenter Replication Cleanup] ******/
BEGIN TRANSACTION
DECLARE @ReturnCode INT
SELECT @ReturnCode = 0

/****** Object:  JobCategory [[Uncategorized (Local)]]] ******/
IF NOT EXISTS (SELECT name FROM msdb.dbo.syscategories WHERE name=N''[Uncategorized (Local)]'' AND category_class=1)
BEGIN
EXEC @ReturnCode = msdb.dbo.sp_add_category @class=N''JOB'', @type=N''LOCAL'', @name=N''[Uncategorized (Local)]''
IF (@@ERROR <> 0 OR @ReturnCode <> 0) GOTO QuitWithRollback
END

DECLARE @jobId BINARY(16),
     @db_name nvarchar(128);
	 set @db_name = db_name();
EXEC @ReturnCode =  msdb.dbo.sp_add_job @job_name=N''Xcenter Replication Cleanup'', 
    @enabled=1, 
    @notify_level_eventlog=0, 
    @notify_level_email=0, 
    @notify_level_netsend=0, 
    @notify_level_page=0, 
    @delete_level=0, 
    @description=N''No description available.'', 
    @category_name=N''[Uncategorized (Local)]'', 
    @owner_login_name=N''sa'', @job_id = @jobId OUTPUT
IF (@@ERROR <> 0 OR @ReturnCode <> 0) GOTO QuitWithRollback

/****** Object:  Step [Remove Completed Records] ******/
EXEC @ReturnCode = msdb.dbo.sp_add_jobstep @job_id=@jobId, @step_name=N''Remove Completed Records'', 
    @step_id=1, 
    @cmdexec_success_code=0, 
    @on_success_action=1, 
    @on_success_step_id=0, 
    @on_fail_action=2, 
    @on_fail_step_id=0, 
    @retry_attempts=0, 
    @retry_interval=0, 
    @os_run_priority=0, @subsystem=N''TSQL'', 
    @command=N''EXEC sp_Replication_Cleanup'', 
    @database_name=@db_name, 
    @flags=0
IF (@@ERROR <> 0 OR @ReturnCode <> 0) GOTO QuitWithRollback

EXEC @ReturnCode = msdb.dbo.sp_update_job @job_id = @jobId, @start_step_id = 1
IF (@@ERROR <> 0 OR @ReturnCode <> 0) GOTO QuitWithRollback

/****** Object:  Schedule [Nightly at Midnight.] ******/
EXEC @ReturnCode = msdb.dbo.sp_add_jobschedule @job_id=@jobId, @name=N''Nightly at Midnight.'', 
    @enabled=1, 
    @freq_type=4, 
    @freq_interval=1, 
    @freq_subday_type=1, 
    @freq_subday_interval=0, 
    @freq_relative_interval=0, 
    @freq_recurrence_factor=0, 
    @active_start_date=20120831, 
    @active_end_date=99991231, 
    @active_start_time=0, 
    @active_end_time=235959
IF (@@ERROR <> 0 OR @ReturnCode <> 0) GOTO QuitWithRollback

/****** Object:  Target Server [local] ******/
EXEC @ReturnCode = msdb.dbo.sp_add_jobserver @job_id = @jobId, @server_name = N''(local)''
IF (@@ERROR <> 0 OR @ReturnCode <> 0) GOTO QuitWithRollback

COMMIT TRANSACTION
return;
QuitWithRollback:
    IF (@@TRANCOUNT > 0) ROLLBACK TRANSACTION');

