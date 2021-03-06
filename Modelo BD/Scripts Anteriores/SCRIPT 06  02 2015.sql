/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     06/02/2015 11:12:40                          */
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
   ID_UNIDAD_COMPETENCIA INT4                 null,
   ELEMENTO_COMPETENCIA TEXT                 null,
   ELEMENTO_CUMPLIDO    BOOL                 null,
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
ID_UNIDAD_COMPETENCIA
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
/* Table: FORMACION_ACADEMICA                                   */
/*==============================================================*/
create table FORMACION_ACADEMICA (
   ID_F_ACADEMICA       SERIAL               not null,
   ID_DOCENTE           INT4                 null,
   INSTITUCION_ACA      TEXT                 null,
   TITULO               TEXT                 null,
   constraint PK_FORMACION_ACADEMICA primary key (ID_F_ACADEMICA)
);

/*==============================================================*/
/* Index: FORMACION_ACADEMICA_PK                                */
/*==============================================================*/
create unique index FORMACION_ACADEMICA_PK on FORMACION_ACADEMICA (
ID_F_ACADEMICA
);

/*==============================================================*/
/* Index: DOCENTE_FA_FK                                         */
/*==============================================================*/
create  index DOCENTE_FA_FK on FORMACION_ACADEMICA (
ID_DOCENTE
);

/*==============================================================*/
/* Table: FORMACION_CONTINUA                                    */
/*==============================================================*/
create table FORMACION_CONTINUA (
   ID_F_CONTINUA        SERIAL               not null,
   ID_DOCENTE           INT4                 null,
   INSTITUCION_CONTINUA TEXT                 null,
   CURSO                TEXT                 null,
   TIPO_DURACION        TEXT                 null,
   DURACION             TEXT                 null,
   constraint PK_FORMACION_CONTINUA primary key (ID_F_CONTINUA)
);

/*==============================================================*/
/* Index: FORMACION_CONTINUA_PK                                 */
/*==============================================================*/
create unique index FORMACION_CONTINUA_PK on FORMACION_CONTINUA (
ID_F_CONTINUA
);

/*==============================================================*/
/* Index: DOCENTE_FC_FK                                         */
/*==============================================================*/
create  index DOCENTE_FC_FK on FORMACION_CONTINUA (
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
/* Table: MENU                                                  */
/*==============================================================*/
create table MENU (
   ID_MENU              SERIAL               not null,
   ID_PADRE             INT4                 null,
   NOMBRE_MENU          TEXT                 null,
   URL                  TEXT                 null,
   ESTADO_MENU          TEXT                 null,
   constraint PK_MENU primary key (ID_MENU)
);

/*==============================================================*/
/* Index: MENU_PK                                               */
/*==============================================================*/
create unique index MENU_PK on MENU (
ID_MENU
);

/*==============================================================*/
/* Table: OBJETIVO                                              */
/*==============================================================*/
create table OBJETIVO (
   ID_OBJETIVO          SERIAL               not null,
   ID_SYLLABUS          INT4                 null,
   OBJETIVO             TEXT                 null,
   OBJETIVO_CUMPLIDO    BOOL                 null,
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
/* Table: RESULTADOS_APRENDIZAJE                                */
/*==============================================================*/
create table RESULTADOS_APRENDIZAJE (
   ID_RESULTADO         SERIAL               not null,
   ID_SYLLABUS          INT4                 null,
   RESULTADO_APRENDIZAJE TEXT                 null,
   INICIO               BOOL                 null,
   PROCESO              BOOL                 null,
   AVANCE               BOOL                 null,
   DOMINIO              BOOL                 null,
   constraint PK_RESULTADOS_APRENDIZAJE primary key (ID_RESULTADO)
);

/*==============================================================*/
/* Index: RESULTADOS_APRENDIZAJE_PK                             */
/*==============================================================*/
create unique index RESULTADOS_APRENDIZAJE_PK on RESULTADOS_APRENDIZAJE (
ID_RESULTADO
);

/*==============================================================*/
/* Index: SYLLABUS_RESULTADOS_FK                                */
/*==============================================================*/
create  index SYLLABUS_RESULTADOS_FK on RESULTADOS_APRENDIZAJE (
ID_SYLLABUS
);

/*==============================================================*/
/* Table: ROL                                                   */
/*==============================================================*/
create table ROL (
   ID_ROL               SERIAL               not null,
   ID_USUARIO           INT4                 null,
   NOMBRE_ROL           TEXT                 null,
   DESCRIPCION_ROL      TEXT                 null,
   ESTADO_ROL           TEXT                 null,
   constraint PK_ROL primary key (ID_ROL)
);

/*==============================================================*/
/* Index: ROL_PK                                                */
/*==============================================================*/
create unique index ROL_PK on ROL (
ID_ROL
);

/*==============================================================*/
/* Index: USUARIO_ROL_FK                                        */
/*==============================================================*/
create  index USUARIO_ROL_FK on ROL (
ID_USUARIO
);

/*==============================================================*/
/* Table: ROL_MENU                                              */
/*==============================================================*/
create table ROL_MENU (
   ID_MENU_ROL          SERIAL               not null,
   ID_MENU              INT4                 null,
   ID_ROL               INT4                 null,
   constraint PK_ROL_MENU primary key (ID_MENU_ROL)
);

/*==============================================================*/
/* Index: ROL_MENU_PK                                           */
/*==============================================================*/
create unique index ROL_MENU_PK on ROL_MENU (
ID_MENU_ROL
);

/*==============================================================*/
/* Index: ROL_MENUS_FK                                          */
/*==============================================================*/
create  index ROL_MENUS_FK on ROL_MENU (
ID_ROL
);

/*==============================================================*/
/* Index: MENU_ROLES_FK                                         */
/*==============================================================*/
create  index MENU_ROLES_FK on ROL_MENU (
ID_MENU
);

/*==============================================================*/
/* Table: SYLLABUS                                              */
/*==============================================================*/
create table SYLLABUS (
   ID_SYLLABUS          SERIAL               not null,
   ID_DOCENTE           INT4                 null,
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
/* Index: DOCENTE_SYLLABUS_FK                                   */
/*==============================================================*/
create  index DOCENTE_SYLLABUS_FK on SYLLABUS (
ID_DOCENTE
);

/*==============================================================*/
/* Table: UNIDAD_COMPETENCIA                                    */
/*==============================================================*/
create table UNIDAD_COMPETENCIA (
   ID_UNIDAD_COMPETENCIA SERIAL               not null,
   ID_SYLLABUS          INT4                 null,
   HORAS_COMPETENCIA    INT4                 null,
   UNIDAD_COMPETENCIA   TEXT                 null,
   constraint PK_UNIDAD_COMPETENCIA primary key (ID_UNIDAD_COMPETENCIA)
);

/*==============================================================*/
/* Index: UNIDAD_COMPETENCIA_PK                                 */
/*==============================================================*/
create unique index UNIDAD_COMPETENCIA_PK on UNIDAD_COMPETENCIA (
ID_UNIDAD_COMPETENCIA
);

/*==============================================================*/
/* Index: SYLLABUS_UNIDADES_FK                                  */
/*==============================================================*/
create  index SYLLABUS_UNIDADES_FK on UNIDAD_COMPETENCIA (
ID_SYLLABUS
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO (
   ID_USUARIO           SERIAL               not null,
   USUARIO              TEXT                 null,
   NOMBRE_USUARIO       TEXT                 null,
   CLAVE                TEXT                 null,
   IDENTIFICACION_USUARIO TEXT                 null,
   EMAIL_USUARIO        TEXT                 null,
   ESTADO               TEXT                 null,
   ID_USUARIO_CREACION  INT4                 null,
   FECHA_CREACION       DATE                 null,
   ID_USUARIO_ACTUALIZACION INT4                 null,
   FECHA_ACTUALIZACION  DATE                 null,
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
   add constraint FK_ELEMENTO_COMPETENC_UNIDAD_C foreign key (ID_UNIDAD_COMPETENCIA)
      references UNIDAD_COMPETENCIA (ID_UNIDAD_COMPETENCIA)
      on delete restrict on update restrict;

alter table ESCUELA_UCE
   add constraint FK_ESCUELA__DOCENTE_E_DOCENTE foreign key (ID_DOCENTE)
      references DOCENTE (ID_DOCENTE)
      on delete restrict on update restrict;

alter table FORMACION_ACADEMICA
   add constraint FK_FORMACIO_DOCENTE_F_DOCENTE foreign key (ID_DOCENTE)
      references DOCENTE (ID_DOCENTE)
      on delete restrict on update restrict;

alter table FORMACION_CONTINUA
   add constraint FK_FORMACIO_DOCENTE_F_DOCENTE foreign key (ID_DOCENTE)
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

alter table RESULTADOS_APRENDIZAJE
   add constraint FK_RESULTAD_SYLLABUS__SYLLABUS foreign key (ID_SYLLABUS)
      references SYLLABUS (ID_SYLLABUS)
      on delete restrict on update restrict;

alter table ROL
   add constraint FK_ROL_USUARIO_R_USUARIO foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO)
      on delete restrict on update restrict;

alter table ROL_MENU
   add constraint FK_ROL_MENU_MENU_ROLE_MENU foreign key (ID_MENU)
      references MENU (ID_MENU)
      on delete restrict on update restrict;

alter table ROL_MENU
   add constraint FK_ROL_MENU_ROL_MENUS_ROL foreign key (ID_ROL)
      references ROL (ID_ROL)
      on delete restrict on update restrict;

alter table SYLLABUS
   add constraint FK_SYLLABUS_DOCENTE_S_DOCENTE foreign key (ID_DOCENTE)
      references DOCENTE (ID_DOCENTE)
      on delete restrict on update restrict;

alter table SYLLABUS
   add constraint FK_SYLLABUS_MATERIA_S_MATERIA_ foreign key (ID_MATERIA_UCE)
      references MATERIA_UCE (ID_MATERIA_UCE)
      on delete restrict on update restrict;

alter table UNIDAD_COMPETENCIA
   add constraint FK_UNIDAD_C_SYLLABUS__SYLLABUS foreign key (ID_SYLLABUS)
      references SYLLABUS (ID_SYLLABUS)
      on delete restrict on update restrict;

