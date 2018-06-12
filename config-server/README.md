For using cryptographically strong keys you ‘Java Cryptography Extension (JCE) Unlimited Strength Jurisdiction Policy Files’. 
You need to install it manually for all versions before **10**.
Readme of **10** version says:  
>The default JCE policy files bundled in this Java Runtime Environment allow for "unlimited" cryptographic strengths.  

To create keystore run next command:

    keytool -genkeypair -alias config-server-key -keyalg RSA -keysize 4096 -sigalg SHA512withRSA -keypass ohConfigServerKeyPass -keystore config-server.jks -storepass ohConfigServerKeyStorePass
    
Several path combinations are available, where label is a branch or tag or commit name (not required)
    
    /{application}/{profile}[/{label}]
    /{application}-{profile}.yml
    /{label}/{application}-{profile}.yml
    /{application}-{profile}.properties
    /{label}/{application}-{profile}.properties
    
Curl queries:
*   get configuration

    
    curl http://{username}:{password}@localhost:8888/{query}

*   encrypt data

    
    curl -X POST --data-urlencode {data} http://{username}:{password}@localhost:8888/encrypt
    
*   encrypt data
    
        
    curl -X POST --data-urlencode {data} http://{username}:{password}@localhost:8888/decrypt