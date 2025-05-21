#!/bin/bash

DBSQLDIR=resources/db/oracle
export NLS_LANG=.AL32UTF8

echo EXECUTE: clean.sql
sqlplus "/ as sysdba" @$DBSQLDIR/local/clean.sql
if [ $? != 0 ]; then
  echo :: FAILURE :: clean.sql
  exit 1
fi

echo EXECUTE: replication clean.sql
sqlplus "/ as sysdba" @$DBSQLDIR/replication/clean.sql
if [ $? != 0 ]; then
  echo :: FAILURE :: replication :: clean.sql
  exit 1
fi

echo EXECUTE: training clean.sql
sqlplus "/ as sysdba" @$DBSQLDIR/training/clean.sql
if [ $? != 0 ]; then
  echo :: FAILURE :: training :: clean.sql
  exit 1
fi

echo EXECUTE: clean_users_roles.sql
sqlplus "/ as sysdba" @$DBSQLDIR/local/clean_users_roles.sql
if [ $? != 0 ]; then
  echo :: FAILURE :: clean_users_roles.sql
  exit 1
fi

echo EXECUTE: db-create.sql
sqlplus "/ as sysdba" @$DBSQLDIR/local/db-create.sql
if [ $? != 0 ]; then
  echo :: FAILURE :: db-create.sql
  exit 1
fi

echo EXECUTE: baseSchema.sql
sqlplus dtv/dtv @$DBSQLDIR/local/baseSchema.sql
if [ $? != 0 ]; then
  echo :: FAILURE :: baseSchema.sql
  exit 1
fi

echo EXECUTE: db-update.sql
sqlplus dtv/dtv @$DBSQLDIR/local/db-update.sql
if [ $? != 0 ]; then
  echo :: FAILURE :: db-update.sql
  exit 1
fi

if [ "$1" == "TEST" ]; then
	echo EXECUTE: testData.sql
	sqlplus dtv/dtv @$DBSQLDIR/local/testData.sql
	if [ $? != 0 ]; then
	  echo :: FAILURE :: testData.sql
	  exit 1
	fi
else
	echo Received an environment type of $1.  Test data will not be loaded.
fi

echo EXECUTE: Synonyms.sql
sqlplus pos/pos @$DBSQLDIR/local/Synonyms.sql
if [ $? != 0 ]; then
  echo :: FAILURE :: Synonyms.sql
  exit 1
fi

echo EXECUTE: DBAUserSynonyms.sql
sqlplus dbauser/dbauser @$DBSQLDIR/local/DBAUserSynonyms.sql
if [ $? != 0 ]; then
  echo :: FAILURE :: DBAUserSynonyms.sql
  exit 1
fi

echo EXECUTE: replication db-create.sql
sqlplus "/ as sysdba" @$DBSQLDIR/replication/db-create.sql
if [ $? != 0 ]; then
  echo :: FAILURE :: replication :: db-create.sql
  exit 1
fi

echo EXECUTE: xstore-replication-db-define.sql
sqlplus "/ as sysdba" @$DBSQLDIR/replication/xstore-replication-db-define.sql
if [ $? != 0 ]; then
  echo :: FAILURE :: replication :: xstore-replication-db-define.sql
  exit 1
fi

echo EXECUTE: training db-create.sql
sqlplus "/ as sysdba" @$DBSQLDIR/training/db-create.sql
if [ $? != 0 ]; then
  echo :: FAILURE :: training :: db-createg.sql
  exit 1
fi

echo EXECUTE: baseSchema.sql
sqlplus training/training @$DBSQLDIR/training/baseSchema.sql
if [ $? != 0 ]; then
  echo :: FAILURE :: training :: baseSchema.sql
  exit 1
fi

echo EXECUTE: db-update.sql
sqlplus training/training @$DBSQLDIR/training/db-update.sql
if [ $? != 0 ]; then
  echo :: FAILURE :: training :: db-update.sql
  exit 1
fi

if [ "$1" == "TEST" ]; then
echo EXECUTE: testData.sql
	sqlplus training/training @$DBSQLDIR/training/testData.sql
	if [ $? != 0 ]; then
	  echo :: FAILURE :: training :: testData.sql
	  exit 1
	fi
else
	echo Received an environment type of $1.  Test data will not be loaded.
fi
