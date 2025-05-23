-- ***************************************************************************
-- This script will create an Xstore database compatible with DB platform <platform> and, where 
-- applicable, create/assign the appropriate users, roles, and platform-specific options for it.
--
-- This script does not define any schematics for the new database.  To identify an Xstore-compatible
-- schema for it, run the "new" script designated for the desired application version.
--
-- Platform:  Microsoft SQL Server 2008/2012
-- ***************************************************************************

-- **************************************
PRINT '* PROLOGUE';
-- **************************************
USE master;
GO

-- **************************************
PRINT '* CREATE XSTORE DB';
-- **************************************
GO
DECLARE 
  @dbName nvarchar(30),
  @dbPath nvarchar(128);

SET @dbName = N'$(DbName)';
SET @dbPath = N'$(DbDataFilePath)\';

-- **************************************
PRINT '     - Name: ' + @dbName;
PRINT '     - Path: ' + @dbPath;
-- **************************************

IF DB_ID(@dbName) IS NULL BEGIN
  DECLARE 
    @dataName nvarchar(48),
    @dataFile nvarchar(128),
    @logName nvarchar(48),
    @logFile nvarchar(128),
    @sql nvarchar(512);
    
  SET @dataName = @dbName + '_data';
  SET @dataFile = @dbPath + @dataName + '.mdf';
  SET @logName = @dbName + '_log';
  SET @logFile = @dbPath + @logName + '.ldf';
  
  SET @sql = N'CREATE DATABASE ' + @dbName + ' ON (
      NAME = ' + @dataName + ',
      FILENAME = ''' + @dataFile + ''',
      SIZE = 8,
      FILEGROWTH = 10%)
    LOG ON (
      NAME = ' + @logName + ',
      FILENAME = ''' + @logFile + ''',
      SIZE = 9, 
      FILEGROWTH = 10%)';
  EXEC (@sql);
END

-- **************************************
PRINT '* CONFIGURE XSTORE DB';
-- **************************************
execute('ALTER DATABASE ' + @dbName + ' SET TORN_PAGE_DETECTION ON;')
execute('ALTER DATABASE ' + @dbName + ' SET AUTO_CREATE_STATISTICS ON;')
execute('ALTER DATABASE ' + @dbName + ' SET AUTO_UPDATE_STATISTICS ON;')
-- **************************************
--PRINT '     - Settings:';
--EXEC sp_dboption @dbName;
GO

-- **************************************
PRINT '* EPILOGUE';
-- **************************************
-- **************************************
PRINT '     - Close SQL Server security loopholes';
-- **************************************
EXEC sp_configure 'show advanced options', 1;
RECONFIGURE;
EXEC sp_configure 'xp_cmdshell', 0;
EXEC sp_configure 'Ad Hoc Distributed Queries', 0;
GO

