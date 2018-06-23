# Android application skeleton #
Skeleton for android app. It provides minimal configuration to start developing android app.

## Keystore configuration ##
Rename file `keystore-template.properties` to `keystore.properties` and provide your own credentials and keystore file.

## Endpoints configuration ##
Server endpoints are set in app `build.gradle` file. Separate flavours are added for staging and production server. Endpoints addresses are accesible via `BuildConfig.API_URL` const.
