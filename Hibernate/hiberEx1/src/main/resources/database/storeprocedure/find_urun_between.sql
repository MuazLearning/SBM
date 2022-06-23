delimiter $$

CREATE PROCEDURE find_urun_between (min decimal, max decimal)

BEGIN
select * from hiberex1.urun where FIYAT between min and max;
END $$

call find_urun_between(1,5);