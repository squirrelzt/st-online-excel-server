DROP TABLE IF EXISTS cell;
CREATE TABLE cell  (
  id int IDENTITY,
  sheet_id varchar(10),
  r varchar(10),
  c varchar(10),
  fa varchar(10),
  t varchar(10),
  m varchar(255),
  v varchar(255)
);

