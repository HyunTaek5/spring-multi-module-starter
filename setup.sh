#!/bin/bash

echo Project Name? "It will be directory name."
# shellcheck disable=SC2162
read projectName

# shellcheck disable=SC2103
cd ..
cp -r spring-starter "$projectName"

# shellcheck disable=SC2164
cd "$projectName"
rm -rf .git
git init