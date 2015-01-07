/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     05/01/2015 11:49:21                          */
/*==============================================================*/


/*==============================================================*/
/* Table: BIBLIOGRAFIA                                          */
/*==============================================================*/
create table BIBLIOGRAFIA (
   ID_BIBLIOGRAFIA      SERIAL               not null,
   ID_SYLLABUS          INT4                 null,
   BIBLIOGRAFIA         TEXT                 null,
   constraint PK_BIBLIOGRAFIA primary key (ID_BIBLIOGRAFIA)
);

/*==============================================================*/
/* Index: BIBLIOGRAFIA_PK                                       */
/*==============================================================*/
create unique index BIBLIOGRAFIA_PK on BIBLIOGRAFIA (
ID_BIBLIOGRAFIA
);

/*==============================================================*/
/* Index: SYLLABUS_BIBLIOGRAFIA_FK                              */
/*==============================================================*/
create  index SYLLABUS_BIBLIOGRAFIA_FK on BIBLIOGRAFIA (
ID_SYLLABUS
);

/*==============================================================*/
/* Table: CATALOGO                                              */
/*==============================================================*/
create table CATALOGO (
   ID_CATALOGO          SERIAL               not null,
   DESCRIPCION_CATALOGO TEXT                 null,
   constraint PK_CATALOGO primary key (ID_CATALOGO)
);

/*==============================================================*/
/* Index: CATALOGO_PK                                           */
/*==============================================================*/
create unique index CATALOGO_PK on CATALOGO (
ID_CATALOGO
);

/*==============================================================*/
/* Table: COMPETENCIA                                           */
/*==============================================================*/
create table COMPETENCIA (
   ID_COMPETENCIA       SERIAL               not null,
   ID_SYLLABUS          INT4                 null,
   COMPETENCIA          TEXT                 null,
   constraint PK_COMPETENCIA primary key (ID_COMPETENCIA)
);

/*==============================================================*/
/* Index: COMPETENCIA_PK                                        */
/*==============================================================*/
create unique index COMPETENCIA_PK on COMPETENCIA (
ID_COMPETENCIA
);

/*==============================================================*/
/* Index: SYLLABUS_COMPETENCIAS_FK                              */
/*==============================================================*/
create  index SYLLABUS_COMPETENCIAS_FK on COMPETENCIA (
ID_SYLLABUS
);

/*==============================================================*/
/* Table: DETALLE_CATALOGO                                      */
/*==============================================================*/
create table DETALLE_CATALOGO (
   ID_DETALLE_CATALOGO  SERIAL               not null,
   ID_CATALOGO          INT4                 null,
   COD_DETALLE_CATALOGO TEXT                 null,
   COD_DEP_CATALOGO     TEXT                 null,
   DESC_DET_CATALOGO    TEXT                 null,
   constraint PK_DETALLE_CATALOGO primary key (ID_DETALLE_CATALOGO)
);

/*==============================================================*/
/* Index: DETALLE_CATALOGO_PK                                   */
/*==============================================================*/
create unique index DETALLE_CATALOGO_PK on DETALLE_CATALOGO (
ID_DETALLE_CATALOGO
);

/*==============================================================*/
/* Index: CATALOGO_DETALLE_FK                                   */
/*==============================================================*/
create  index CATALOGO_DETALLE_FK on DETALLE_CATALOGO (
ID_CATALOGO
);

/*==============================================================*/
/* Table: DOCENTE                                               */
/*==============================================================*/
create table DOCENTE (
   ID_DOCENTE           SERIAL               not null,
   NOMBRES_DOCENTE      TEXT                 null,
   APELLIDOS_DOCENTE    TEXT                 null,
   CEDULA_DOCENTE       TEXT                 null,
   DIRECCION_DOCENTE    TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 null,
   ESTADO               TEXT                 not null,
   constraint PK_DOCENTE primary key (ID_DOCENTE)
);

/*==============================================================*/
/* Index: DOCENTE_PK                                            */
/*==============================================================*/
create unique index DOCENTE_PK on DOCENTE (
ID_DOCENTE
);

/*==============================================================*/
/* Table: ELEMENTO_COMPETENCIA                                  */
/*==============================================================*/
create table ELEMENTO_COMPETENCIA (
   ID_ELEMENTO_COMPETENCIA SERIAL               not null,
   ID_COMPETENCIA       INT4                 null,
   ELEMENTO_COMPETENCIA TEXT                 null,
   constraint PK_ELEMENTO_COMPETENCIA primary key (ID_ELEMENTO_COMPETENCIA)
);

/*==============================================================*/
/* Index: ELEMENTO_COMPETENCIA_PK                               */
/*==============================================================*/
create unique index ELEMENTO_COMPETENCIA_PK on ELEMENTO_COMPETENCIA (
ID_ELEMENTO_COMPETENCIA
);

/*==============================================================*/
/* Index: COMPETENCIA_ELEMENTOS_FK                              */
/*==============================================================*/
create  index COMPETENCIA_ELEMENTOS_FK on ELEMENTO_COMPETENCIA (
ID_COMPETENCIA
);

/*==============================================================*/
/* Table: ESCUELA                                               */
/*==============================================================*/
create table ESCUELA (
   ID_ESCUELA           SERIAL               not null,
   ESCUELA              TEXT                 null,
   constraint PK_ESCUELA primary key (ID_ESCUELA)
);

/*==============================================================*/
/* Index: ESCUELA_PK                                            */
/*==============================================================*/
create unique index ESCUELA_PK on ESCUELA (
ID_ESCUELA
);

/*==============================================================*/
/* Table: ESCUELA_UCE                                           */
/*==============================================================*/
create table ESCUELA_UCE (
   ID_ESCUELA_UCE       SERIAL               not null,
   ID_DOCENTE           INT4                 null,
   ESCUELA_UCE          TEXT                 null,
   constraint PK_ESCUELA_UCE primary key (ID_ESCUELA_UCE)
);

/*==============================================================*/
/* Index: ESCUELA_UCE_PK                                        */
/*==============================================================*/
create unique index ESCUELA_UCE_PK on ESCUELA_UCE (
ID_ESCUELA_UCE
);

/*==============================================================*/
/* Index: DOCENTE_ESCUELA_FK                                    */
/*==============================================================*/
create  index DOCENTE_ESCUELA_FK on ESCUELA_UCE (
ID_DOCENTE
);

/*==============================================================*/
/* Table: MATERIA                                               */
/*==============================================================*/
create table MATERIA (
   ID_MATERIA           SERIAL               not null,
   ID_ESCUELA           INT4                 null,
   MATERIA              TEXT                 null,
   constraint PK_MATERIA primary key (ID_MATERIA)
);

/*==============================================================*/
/* Index: MATERIA_PK                                            */
/*==============================================================*/
create unique index MATERIA_PK on MATERIA (
ID_MATERIA
);

/*==============================================================*/
/* Index: ESCUELA_MATERIA_FK                                    */
/*==============================================================*/
create  index ESCUELA_MATERIA_FK on MATERIA (
ID_ESCUELA
);

/*==============================================================*/
/* Table: MATERIA_UCE                                           */
/*==============================================================*/
create table MATERIA_UCE (
   ID_MATERIA_UCE       SERIAL               not null,
   ID_ESCUELA_UCE       INT4                 null,
   MATERIA_UCE          TEXT                 null,
   constraint PK_MATERIA_UCE primary key (ID_MATERIA_UCE)
);

/*==============================================================*/
/* Index: MATERIA_UCE_PK                                        */
/*==============================================================*/
create unique index MATERIA_UCE_PK on MATERIA_UCE (
ID_MATERIA_UCE
);

/*==============================================================*/
/* Index: ESCUELA_ASIGNATURA_FK                                 */
/*==============================================================*/
create  index ESCUELA_ASIGNATURA_FK on MATERIA_UCE (
ID_ESCUELA_UCE
);

/*==============================================================*/
/* Table: OBJETIVO                                              */
/*==============================================================*/
create table OBJETIVO (
   ID_OBJETIVO          SERIAL               not null,
   ID_SYLLABUS          INT4                 null,
   OBJETIVO             TEXT                 null,
   constraint PK_OBJETIVO primary key (ID_OBJETIVO)
);

/*==============================================================*/
/* Index: OBJETIVO_PK                                           */
/*==============================================================*/
create unique index OBJETIVO_PK on OBJETIVO (
ID_OBJETIVO
);

/*==============================================================*/
/* Index: SYLLABUS_OBJETIVOS_FK                                 */
/*==============================================================*/
create  index SYLLABUS_OBJETIVOS_FK on OBJETIVO (
ID_SYLLABUS
);

/*==============================================================*/
/* Table: RECURSOS_DIDACTICOS                                   */
/*==============================================================*/
create table RECURSOS_DIDACTICOS (
   ID_RECURSO           SERIAL               not null,
   ID_SYLLABUS          INT4                 null,
   RECURSO              TEXT                 null,
   constraint PK_RECURSOS_DIDACTICOS primary key (ID_RECURSO)
);

/*==============================================================*/
/* Index: RECURSOS_DIDACTICOS_PK                                */
/*==============================================================*/
create unique index RECURSOS_DIDACTICOS_PK on RECURSOS_DIDACTICOS (
ID_RECURSO
);

/*==============================================================*/
/* Index: SYLLABUS_RECURSOS_FK                                  */
/*==============================================================*/
create  index SYLLABUS_RECURSOS_FK on RECURSOS_DIDACTICOS (
ID_SYLLABUS
);

/*==============================================================*/
/* Table: SYLLABUS                                              */
/*==============================================================*/
create table SYLLABUS (
   ID_SYLLABUS          SERIAL               not null,
   ID_MATERIA_UCE       INT4                 null,
   NUM_HORAS_CLASE      INT4                 null,
   PREREQUISITO         TEXT                 null,
   COREQUISITO          TEXT                 null,
   DESCRIPCION_ASIGNATURA TEXT                 null,
   METODOLOGIA          TEXT                 null,
   constraint PK_SYLLABUS primary key (ID_SYLLABUS)
);

/*==============================================================*/
/* Index: SYLLABUS_PK                                           */
/*==============================================================*/
create unique index SYLLABUS_PK on SYLLABUS (
ID_SYLLABUS
);

/*==============================================================*/
/* Index: MATERIA_SYLLABUS_FK                                   */
/*==============================================================*/
create  index MATERIA_SYLLABUS_FK on SYLLABUS (
ID_MATERIA_UCE
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO (
   ID_USUARIO           SERIAL               not null,
   USUARIO              TEXT                 null,
   CLAVE                TEXT                 null,
   EMAIL_USUARIO        TEXT                 null,
   TELEFONO             TEXT                 null,
   ID_USUARIO_CREACION  INT4                 not null,
   ID_USUARIO_ACTUALIZACION INT4                 not null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 not null,
   ESTADO               TEXT                 not null,
   constraint PK_USUARIO primary key (ID_USUARIO)
);

/*==============================================================*/
/* Index: USUARIO_PK                                            */
/*==============================================================*/
create unique index USUARIO_PK on USUARIO (
ID_USUARIO
);

alter table BIBLIOGRAFIA
   add constraint FK_BIBLIOGR_SYLLABUS__SYLLABUS foreign key (ID_SYLLABUS)
      references SYLLABUS (ID_SYLLABUS)
      on delete restrict on update restrict;

alter table COMPETENCIA
   add constraint FK_COMPETEN_SYLLABUS__SYLLABUS foreign key (ID_SYLLABUS)
      references SYLLABUS (ID_SYLLABUS)
      on delete restrict on update restrict;

alter table DETALLE_CATALOGO
   add constraint FK_DETALLE__CATALOGO__CATALOGO foreign key (ID_CATALOGO)
      references CATALOGO (ID_CATALOGO)
      on delete restrict on update restrict;

alter table ELEMENTO_COMPETENCIA
   add constraint FK_ELEMENTO_COMPETENC_COMPETEN foreign key (ID_COMPETENCIA)
      references COMPETENCIA (ID_COMPETENCIA)
      on delete restrict on update restrict;

alter table ESCUELA_UCE
   add constraint FK_ESCUELA__DOCENTE_E_DOCENTE foreign key (ID_DOCENTE)
      references DOCENTE (ID_DOCENTE)
      on delete restrict on update restrict;

alter table MATERIA
   add constraint FK_MATERIA_ESCUELA_M_ESCUELA foreign key (ID_ESCUELA)
      references ESCUELA (ID_ESCUELA)
      on delete restrict on update restrict;

alter table MATERIA_UCE
   add constraint FK_MATERIA__ESCUELA_A_ESCUELA_ foreign key (ID_ESCUELA_UCE)
      references ESCUELA_UCE (ID_ESCUELA_UCE)
      on delete restrict on update restrict;

alter table OBJETIVO
   add constraint FK_OBJETIVO_SYLLABUS__SYLLABUS foreign key (ID_SYLLABUS)
      references SYLLABUS (ID_SYLLABUS)
      on delete restrict on update restrict;

alter table RECURSOS_DIDACTICOS
   add constraint FK_RECURSOS_SYLLABUS__SYLLABUS foreign key (ID_SYLLABUS)
      references SYLLABUS (ID_SYLLABUS)
      on delete restrict on update restrict;

alter table SYLLABUS
   add constraint FK_SYLLABUS_MATERIA_S_MATERIA_ foreign key (ID_MATERIA_UCE)
      references MATERIA_UCE (ID_MATERIA_UCE)
      on delete restrict on update restrict;
