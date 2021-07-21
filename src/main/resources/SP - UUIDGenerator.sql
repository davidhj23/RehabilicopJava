CREATE DEFINER=`root`@`localhost` PROCEDURE `UUIDGenerator`(n INT)
BEGIN
  
  DECLARE num INT;
  DECLARE counter INT;
  SET num = n;
  SET counter = 0;
  
  DROP TABLE IF EXISTS TempTable;  
  CREATE TEMPORARY TABLE TempTable (u BINARY(16)); 
  
  WHILE counter < num DO
    INSERT INTO TempTable (u) VALUES (UNHEX(REPLACE(UUID(),'-',''))); 
    SET counter = counter + 1;
  END WHILE;
  
  SELECT HEX(u) FROM TempTable; 
  
END