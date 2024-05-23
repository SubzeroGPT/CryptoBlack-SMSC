CryptoBlack-SMSC-Client/
├── app/
│   └── src/
│       └── main/
│           └── java/
│               └── com/
│                   └── cryptoblack/
│                       └── smsc/
│                           ├── MainActivity.java
│                           └── VoIPSMSCService.java
└── build.gradle

plugins {
    id 'com.android.application'
}

android {
    compileSdkVersion 31
    defaultConfig {
        applicationId "com.cryptoblack.smsc"
        minSdkVersion 21
        targetSdkVersion 31
        versionCode 1
        versionName "1.0"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    implementation 'androidx.appcompat:appcompat:1.4.0'
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
}
