# composite-key-embedded

Composite Primary Key - @EmbeddedID / @Embeddable - Mapper

When a database table contains a primary key made of 2 or more columns. We Use a class to represent the primary key. In this example, we are using @EmbeddedID / @Embeddable annotations in the Entity class. The Entity class this time has the primary key class that are a compound primary key. We created a separed class with only the columns that are primary key. This class named EntityPK is used in the JpaRepository implementation.

With this approach (@EmbeddedID / @Embeddable), we can use query method (we're using here). We CAN NOT use Oracle sequence . Using embedded annotation won't let us work with oracle Sequence for fields in the composite primary key.

We're using mapper from org.mapstruct. This helps us mappinng entity to DTO and so on. In the pom: org.mapstruct mapstruct 1.4.1.Final

The following plugin is useful to generate the mapper implementation during the build org.apache.maven.plugins maven-compiler-plugin 3.5.1 11 11 org.mapstruct mapstruct-processor 1.4.1.Final

Oracle database script: create table TB_ERROR_GAME ( GAME_ID NUMBER(4), GAME_PLATFORM NVARCHAR2(7), ERROR_SEQUENCE_NUMBER NUMBER(11),

ERROR_CODE NUMBER(3), ERROR_MESSAGE NVARCHAR2(255),

constraint ERROR_GAME_PK primary key (GAME_ID, GAME_PLATFORM, ERROR_SEQUENCE_NUMBER));
