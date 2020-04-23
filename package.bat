@RD /S /Q "D:\David\Desarrollo\DavidHenriquez\WorkSpace\Rehabilicop\src\main\resources\static\dist"
cd "D:\David\Desarrollo\DavidHenriquez\RehabilicopAngularClient"
call npm run build 
cd "D:\David\Desarrollo\DavidHenriquez\Workspace\Rehabilicop"
call gradle build