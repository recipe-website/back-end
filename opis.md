* entity - pojedynczy wpis w bazie danych
* Uruchomienie bazy danych- w cmd w folderze docker wpisać:
  * docker compose -f doc.yml --env-file env_test up --force-recreate --build
* Swagger - graficzny interfejs do testowania API 
  * uruchomienie: http://localhost:8080/swagger.html w przeglądarce
* Konfiguracja application.properties:
  * wkleić plik w src/main/resources(z zawartością xd)
* Uruchomienie front-endu:
  * W folderze front-end/front-end uruchomić komendę(w cmd): npm run dev
  * http://localhost:5173/ - adres strony