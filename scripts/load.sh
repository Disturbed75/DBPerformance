#!/bin/sh


echo "========== RUNNING CONCURRENCY = 6 =========="
siege -d1 -t20s -c6 http://127.0.0.1:8081/test-data
