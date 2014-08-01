jpaDemo
=======

JPA JSP Demo for New Hire Training

DB: Postgres 9.3.4
JDBC Driver: postgresql-9-3-1102.jdbc4.jar
JBoss EAP 6.1+

DB Schema
---------
```SQL
CREATE TABLE "User"
(
  "ID" integer NOT NULL DEFAULT nextval('"Roster_ID_seq"'::regclass),
  "fName" character(25) NOT NULL,
  "lName" character(25) NOT NULL,
  CONSTRAINT id PRIMARY KEY ("ID")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "User"
  OWNER TO postgres;
