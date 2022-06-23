delimiter $$

CREATE PROCEDURE urun_findAll ()

BEGIN
    select * from urun;
END $$

call urun_findAll();