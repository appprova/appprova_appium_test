#!/bin/bash

function die {
    echo $1
    exit 1
}

pkg_root_dir=$(pwd)
app_filename="$pkg_root_dir/app/app.apk"
ls -1 $app_filename || die "Did not find app in $pkg_root_dir"

appium --session-override --pre-launch --app-pkg com.appprova.appprovaandr  --app-activity .activity.QuestionActivity_ --platform-name Android --app $app_filename
