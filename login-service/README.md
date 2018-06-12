First we must generate a KeyStore file. To do that execute the following command:

    keytool -genkeypair -alias jwt-oh -keyalg RSA -keypass jwtohpassword -keystore jwt.jks -storepass jwtohpassword
    
(if you're under Windows go your Java install dir and there you'll find a jar named keytool)

The command will generate a file called jwt.jks which contains the Public and Private keys.

It is recommended to migrate to PKCS12. To do that execute the following command:

    keytool -importkeystore -srckeystore jwt.jks -destkeystore jwt.p12 -deststoretype pkcs12
    
Now let's export the public key:

    keytool -list -rfc --keystore jwt.jks | openssl x509 -inform pem -pubkey
    
For deleting keystore
    
    keytool -delete -noprompt -alias jwt-oh  -keystore jwt.jks -storepass store-jwt-oh-password