/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     12/8/2014 5:18:43 PM                         */
/*==============================================================*/


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
   ID_USUARIO_ACTUALIZACION INT4                 not null,
   FECHA_CREACION       DATE                 not null,
   FECHA_ACTUALIZACION  DATE                 not null,
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

alter table DETALLE_CATALOGO
   add constraint FK_DETALLE__CATALOGO__CATALOGO foreign key (ID_CATALOGO)
      references CATALOGO (ID_CATALOGO)
      on delete restrict on update restrict;

