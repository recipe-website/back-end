* entity - pojedynczy wpis w bazie danych
* Uruchomienie bazy danych- w cmd w folderze docker wpisać:
  * docker compose -f doc.yml --env-file env_test up --force-recreate --build
* Swagger - graficzny interfejs do testowania API 
  * uruchomienie: http://localhost:8080/swagger-ui/4.15.5/index.html w przeglądarce
* Konfiguracja application.properties:
  * wkleić plik w src/main/resources(z zawartością xd)