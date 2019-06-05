#!/usr/bin/env bash
cd /home/douser1/git/docker-spring-mongo-1/
changed=0
git remote update && git status -uno | grep -q 'Your branch is behind' && changed=1
if [ $changed = 1 ]; then
    git pull
    /usr/local/bin/docker-compose down
    /usr/local/bin/docker-compose up -d
    echo "Updated successfully";
else
    echo "Up-to-date"
fi
