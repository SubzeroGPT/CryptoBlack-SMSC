CryptoBlack-SMSC-Server/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── cryptoblack/
│                   └── smsc/
│                       └── VoIPSMSCService.java
└── build.gradle

plugins {
    id 'java'
}

group 'com.cryptoblack'
version '1.0-SNAPSHOT'

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.eclipse.jetty:jetty-server:11.0.7'
    implementation 'com.google.code.gson:gson:2.8.8'
}

test {
    useJUnitPlatform()
}
