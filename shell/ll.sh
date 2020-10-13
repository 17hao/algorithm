#!/bin/bash

# useage: ./ll.sh problem_num
for i in `find src -name "*$1*"`; do
    ls -l $i | awk '{print $6 "-" $7 "-" $8 "    " $9}'
done