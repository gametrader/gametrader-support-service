#!/usr/bin/env bash
cd client
sed -i "s/gametrader-support-service-rest-client/gametrader-support-service-rest-client$1/" settings.gradle
./gradlew publish