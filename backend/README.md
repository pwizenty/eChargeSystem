# eChargeSystem
## Installationsanleitung

Start der MongoDB unter Localhost:27017: 
```
docker run -p 27017:27017 --name echarge-mongo -d mongo:latest
```

Jar Datei erstellen:
````
mvn clean install
````

Jar Datei ausführen:
```
java -jar target/<Name des Jar-Datei>
```

Die Dokumentation der REST-Schnittstellen ist unter folgender URL zu finden:

[Dokumentation Rest API ChargingPointService](http://localhost:8081//swagger-ui.html)

[Dokumentation Rest API EnvironmentInfoService](http://localhost:8082//swagger-ui.html)

[Dokumentation Rest API UserManagementService](http://localhost:8083//swagger-ui.html)