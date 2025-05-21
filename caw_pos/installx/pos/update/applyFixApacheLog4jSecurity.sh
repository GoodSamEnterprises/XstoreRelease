# 
#  CONFIDENTIAL AND PROPRIETARY SOURCE CODE. 
#  
#  Use and distribution of this code is subject to applicable 
#  licenses and the permission of the code owner.  This notice 
#  does not indicate the actual or intended publication of 
#  this source code.
#  
#  Portions developed for TNT Fireworks by BTM Global Consulting
#  LLC and are the property of TNT Fireworks.
#  
#  ===== BTM Modification ===========================================
#  Req/Bug ID#          ddMMyy    Description
#  BZ47846              231221    Security Alert CVE-2021-44228 and CVE-2021-45056
# == ================================================================
#
#!/bin/bash
TEMP_FOLDER="ROOT_FOLDER_TMP_LOG4J"
XSTORE_FOLDER="ROOT_FOLDER_XSTORE"
XENV_FOLDER="ROOT_FOLDER_ENVIRONMENT"
FILE_PID="*.pid"

xenv-wait-delete-pid(){
    sleep 60
    xenv-check-file-delete
}

xstore-wait-delete-pid(){
    sleep 60
    xstore-check-file-delete
}

xstore-pid-file-deleted(){
    #Copy new log4j library v2.16 to Xstore
    echo "Step 2: Copy new log4j library v2.16 to Xstore"
    cp $TEMP_FOLDER/log4j-1.2-api-2.16.0.jar $XSTORE_FOLDER/lib/ext/log4j-1.2-api-2.16.0.jar
    cp $TEMP_FOLDER/log4j-api-2.16.0.jar $XSTORE_FOLDER/lib/ext/log4j-api-2.16.0.jar
    cp $TEMP_FOLDER/log4j-core-2.16.0.jar $XSTORE_FOLDER/lib/ext/log4j-core-2.16.0.jar
    cp $TEMP_FOLDER/log4j-jcl-2.16.0.jar $XSTORE_FOLDER/lib/ext/log4j-jcl-2.16.0.jar
    cp $TEMP_FOLDER/log4j-jul-2.16.0.jar $XSTORE_FOLDER/lib/ext/log4j-jul-2.16.0.jar
    cp $TEMP_FOLDER/log4j-slf4j-impl-2.16.0.jar $XSTORE_FOLDER/lib/ext/log4j-slf4j-impl-2.16.0.jar


    #Remove the old log4j v2.11 library out of Xstore
    echo "Step 3: Remove the old log4j v2.11 library out of Xstore"
    rm -f $XSTORE_FOLDER/lib/ext/log4j-1.2-api-2.11.0.jar
    rm -f $XSTORE_FOLDER/lib/ext/log4j-api-2.11.0.jar
    rm -f $XSTORE_FOLDER/lib/ext/log4j-core-2.11.0.jar
    rm -f $XSTORE_FOLDER/lib/ext/log4j-jcl-2.11.0.jar
    rm -f $XSTORE_FOLDER/lib/ext/log4j-jul-2.11.0.jar
    rm -f $XSTORE_FOLDER/lib/ext/log4j-slf4j-impl-2.11.0.jar

}
xenv-pid-file-deleted(){
    #Copy new log4j library v2.16 to xenvironment
    echo "Copy new log4j library v2.16 to xenvironment"
    cp $TEMP_FOLDER/log4j-1.2-api-2.16.0.jar $XENV_FOLDER/lib/ext/log4j-1.2-api-2.16.0.jar
    cp $TEMP_FOLDER/log4j-api-2.16.0.jar $XENV_FOLDER/lib/ext/log4j-api-2.16.0.jar
    cp $TEMP_FOLDER/log4j-core-2.16.0.jar $XENV_FOLDER/lib/ext/log4j-core-2.16.0.jar
    cp $TEMP_FOLDER/log4j-jcl-2.16.0.jar $XENV_FOLDER/lib/ext/log4j-jcl-2.16.0.jar
    cp $TEMP_FOLDER/log4j-jul-2.16.0.jar $XENV_FOLDER/lib/ext/log4j-jul-2.16.0.jar
    cp $TEMP_FOLDER/log4j-slf4j-impl-2.16.0.jar $XENV_FOLDER/lib/ext/log4j-slf4j-impl-2.16.0.jar

    #Remove the old log4j v2.11 library out of xenvironment
    echo "Step 3: Remove the old log4j v2.11 library out of xenvironment"
    rm -f $XENV_FOLDER/lib/ext/log4j-1.2-api-2.11.0.jar
    rm -f $XENV_FOLDER/lib/ext/log4j-api-2.11.0.jar
    rm -f $XENV_FOLDER/lib/ext/log4j-core-2.11.0.jar
    rm -f $XENV_FOLDER/lib/ext/log4j-jcl-2.11.0.jar
    rm -f $XENV_FOLDER/lib/ext/log4j-jul-2.11.0.jar
    rm -f $XENV_FOLDER/lib/ext/log4j-slf4j-impl-2.11.0.jar

}

xstore-check-file-delete(){
    pid=$XSTORE_FOLDER/tmp/$FILE_PID
    if [ -f  "$pid"] ; then
        xstore-wait-delete-pid
    else
        echo "File $pid deleted"
        xstore-pid-file-deleted
    fi
}

xenv-check-file-delete(){
    pid=$XENV_FOLDER/tmp/$FILE_PID
    if [ -f  "$pid"] ; then
        xenv-wait-delete-pid
    else
        echo "File $pid deleted"
        xenv-pid-file-deleted
    fi
}

update-xstore(){
    echo "--------------------------------------------------"
    echo "Update the log4j 2.16 to the Xstore folder"
    echo "--------------------------------------------------"
    
    #Stop the Xstore application.
    echo "Step 1: Stop the Xstore application."
    
    rm -f $XSTORE_FOLDER/tmp/*.anchor
    
    xstore-check-file-delete
    
}

update-xenv(){
    echo "--------------------------------------------------"
    echo "Update the log4j 2.16 to the Xenvironment folder"
    echo "--------------------------------------------------"
    
    #Stop the xenvironment application.
    echo "Stop the xenvironment application."
    
    rm -f $XENV_FOLDER/tmp/*.anchor
    
    xenv-check-file-delete
}

end-script(){
    rm -f $TEMP_FOLDER/log4j-1.2-api-2.16.0.jar
    rm -f $TEMP_FOLDER/log4j-api-2.16.0.jar
    rm -f $TEMP_FOLDER/log4j-core-2.16.0.jar
    rm -f $TEMP_FOLDER/log4j-jcl-2.16.0.jar
    rm -f $TEMP_FOLDER/log4j-jul-2.16.0.jar
    rm -f $TEMP_FOLDER/log4j-slf4j-impl-2.16.0.jar
    rmdir $TEMP_FOLDER
    cd $XENV_FOLDER
    bash start_eng.sh start
    sleep 60
    cd ..
    rm -f $XSTORE_FOLDER/applyFixApacheLog4jSecurity.sh
    exit
}

end-script-without-start(){
    sleep 60
    exit
}

if [ -d "$TEMP_FOLDER" ]; then
    echo "--------------------------------------------------"
    echo "The $TEMP_FOLDER folder existed"
    echo "--------------------------------------------------"
    
    if [ -d "$XSTORE_FOLDER" ]; then
        echo "--------------------------------------------------"
        echo "The $XSTORE_FOLDER folder existed"
        echo "--------------------------------------------------"
        update-xstore
    fi
    
    if [ -d "$XENV_FOLDER" ]; then
        echo "--------------------------------------------------"
        echo "The $XENV_FOLDER folder existed"
        echo "--------------------------------------------------"
        update-xenv
    fi
    end-script
else 
    echo "--------------------------------------------------"
    echo "The $TEMP_FOLDER folder does not existed"
    echo "--------------------------------------------------"
    end-script-without-start
fi
