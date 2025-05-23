--------------------------------------------------------------------------------
-- This script will drop a database.
--
-- Product:         XStore
-- Version:         16.0.0
-- DB platform:     Microsoft SQL Server 2008/2012
-- $Name$
--------------------------------------------------------------------------------

USE master;
GO

ALTER DATABASE [$(DbName)] SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
GO

DROP database [$(DbName)];
GO

