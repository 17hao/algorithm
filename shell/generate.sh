#!/bin/bash

# generate README.md
# format: leetcode xxx(problem number) github-link

files=$(ls ../src/leetcode/first)
prefix='https://github.com/17hao/algorithm/blob/master/src/leetcode/first/'

readme=../README.md

echo "" > $readme

n=0

for i in $files; do
    ((n++))
    num=$(echo $i | cut -f 2 -d _)
    echo "leetcode [$num](${prefix}$i)&emsp;&emsp;" >> $readme
    if ((n%6==0)); then
        echo "<br>" >> $readme
    fi
done;

echo "total: $n"
