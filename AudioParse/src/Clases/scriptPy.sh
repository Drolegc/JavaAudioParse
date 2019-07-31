#!/bin/bash

cd ~/Desktop/Python/
source env/bin/activate
cd parseAudio/

python3 parseAudio.py $1
