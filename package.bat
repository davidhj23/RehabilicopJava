@RD /S /Q "D:\David\Desarrollo\DavidHenriquez\RehabilicopWorkSpace\Rehabilicop\src\main\resources\static\dist"
cd "D:\David\Desarrollo\DavidHenriquez\RehabilicopAngularClient"
call npm run build 
cd "D:\David\Desarrollo\DavidHenriquez\RehabilicopWorkSpace\Rehabilicop"
call gradle build