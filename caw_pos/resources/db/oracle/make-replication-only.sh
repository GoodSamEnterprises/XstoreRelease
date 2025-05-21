#!/bin/bash

DBSQLDIR=resources/db/oracle
export NLS_LANG=.AL32UTF8

echo EXECUTE: replication clean.sql
sqlplus "/ as sysdba" @$DBSQLDIR/replication/clean.sql
if [ $? != 0 ]; then
  echo :: FAILURE :: replication :: clean.sql
  exit 1
fi

echo EXECUTE: clean_users_roles.sql
sqlplus "/ as sysdba" @$DBSQLDIR/local/clean_users_roles.sql
if [ $? != 0 ]; then
  echo :: FAILURE :: clean_users_roles.sql
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

