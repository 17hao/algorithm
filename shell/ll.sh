#!/bin/bash

# useage: ./ll.sh problem_num
for i in `find src/leetcode -name "*$1*"`; do
    ls -l $i
done