package ec.com.uce.web.util;

public class ConstantesUtil {

	// Constantes Xml
	public static final String CODIFICACION_UTF_8 = "UTF-8";
	public static final String CONTENT_TYPE = "text/xml";
	public static final String CARACTER_ESPECIAL_SALTO_LINEA = "\n";
	public static final String CARACTER_ESPECIAL_TAB = "\t";
	public static final String CARACTER_ESPECIAL_RETORNO = "\r";
	public static final String CODIFICACION_ISO_8859_1 = "ISO-8859-1";
	public static final String DIRECTORIO_PLANTILLA_XHTML2FO = "/plantillas/xhtml2fo.xsl";
	public static final String VALOR_ANCHO_CODIGO_BARRAS_73 = "73%";
	public static final String PARAM_ACEPTABLE = "aceptable";
	public static final String SLASH = "/";

	// Constantes Documento Sri
	public static final String COMPROBANTE_XML = "comprobante";
	public static final String VERSION_XML = "1.0.0";

	// Constantes tecnica
	public static final String SET_JAXB_VALIDATION_EVENT_HANDLER = "set-jaxb-validation-event-handler";

	public final static String PLANTILLA_XHTML2FO = "xhtml2fo.xsl";

	// Servlets
	public final static String TIPO_COMPROBANTE_DESCARGAR = "tipoComprobanteDescargar";
	public final static String DESCARGADOR_SERVLET = "/descargador.jsf";
	public final static String TIPO_PDF = ".pdf";
	public final static String TIPO_XML = ".xml";
	public final static String TIPO_HTML = ".html";
	public final static String TIPO_XLS = ".xls";
	public final static String TIPO_DOC = ".doc";
	public final static String TIPO_PNG = ".png";
	public final static String TIPO_RAR = ".rar";
	public final static String TIPO_ZIP = ".zip";
	public final static String TIPO_TEXTO = ".txt";
	public final static String PLANTILLA_TIPO_PDF = "PDF";
	public final static String PLANTILLA_TIPO_EMAIL = "EMAIL";
	public final static String CONTENT_TYPE_PDF = "application/pdf";
	public final static String CONTENT_TYPE_XML = "text/xml";
	public final static String CONTENT_TYPE_HTML = "text/html";
	public final static String CONTENT_TYPE_EXCEL = "application/vnd.ms-excel";
	public final static String CONTENT_TYPE_WORD = "application/msword";
	public final static String CONTENT_DISPOSITION = "content-disposition";
	public final static String CONTENT_ATTACHMENT_FILE_NAME = "attachment; filename=";
	public final static String CONTENT_LENGTH = "content-length";
	public final static String ENCABEZADO_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
	public final static String ENCABEZADO_XML_STANDALONE = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
	public final static String ENCABEZADO_ISO_XML = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>";
	public final static String PATH_MARCA_AGUA_PDF = "/resources/img/fondo_imprimir.png";
	public final static String PATH_MARCA_AGUA_VACIO_PDF = "/resources/img/vacio.png";
	public final static String ANCHO_CODIGO_BARRAS = "widthCodigoBarras";
	public final static String NOMBRE_DEFAULT_LOGO_EMPRESA = "organizacion_no_disponible";

	public final static String INICIO_INFORMACION_ADICIONAL_HTML = "<html> <body> <p style=\"font-family: Verdana, Geneva, sans-serif;font-size: 10px; font-style: normal; line-height: normal; font-weight: bold; font-variant: normal; text-transform: none; color: #000; text-decoration: none;text-align:left;\">Informaci&#243;n Adicional</p>";
	public final static String INICIO_PARRAFO_INFORMACION_ADICIONAL_HTML = "<p style=\"font-family: Verdana, Geneva, sans-serif; font-size: 9px; font-style: normal; line-height: normal; font-weight: bold; font-variant: normal; text-transform: none; color: #000; text-decoration: none; line-height:12px;text-align:left;\">";
	public final static String FIN_PARRAFO_INFORMACION_ADICIONAL_HTML = "</p>";
	public final static String FIN_INFORMACION_ADICIONAL_HTML = "</body> </html>";

	// Errores al firmar
	public final static String ERROR_MENSAJE_AUTORIZACION = "ERROR";

	// Parametros de configuracion para el envio de e-mails
	public final static String PROTOCOLO_MAIL = "smtp";
	public final static String DEBUG_PROPERTY_MAIL = "mail.debug";
	public final static String AUTH_PROPERTY_MAIL = "mail.smtp.auth";
	public final static String STARTTLS_ENABLE_PROPERTY_MAIL = "mail.smtp.starttls.enable";
	public final static String HOST_PROPERTY_MAIL = "mail.smtp.host";
	public final static String PORT_PROPERTY_MAIL = "mail.smtp.port";
	public final static String IP_DNS_SERVER_MAIL = "ipDnsServerEmail";
	public final static String PUERTO_SERVER_MAIL = "puertoServerEmail";
	public final static String USUARIO_SERVER_MAIL = "usuarioServerEmail";
	public final static String CLAVE_SERVER_MAIL = "claveServerEmail";
	public final static String DESTINATARIOS_USUARIO_SISTEMA = "destinatariosUsuarioSistema";
	public final static String CODIFICACION_MAIL = "ISO-8859-1";
	public final static String FORMATO_MSJ_MAIL = "html";
	public final static String DIRECCION_EMAIL_PRINCIPAL = "emailPrincipal";

	// Comprobante autorizado en contingencia o en linea en el SRI
	public final static Long AUTORIZACION_LINEA = 0L;
	public final static Long AUTORIZACION_BATCH = 1L;
	public static final String PARAMETROS_DESCARGADOR_IDENTIFICADOR = "PARAMETROS_DESCARGADOR_IDENTIFICADOR";
	public static final String CONTENT_TYPE_IDENTIFICADOR = "CONTENT_TYPE_IDENTIFICADOR";
	public static final String CONTENIDO_BYTES_IDENTIFICADOR = "CONTENIDO_BYTES_IDENTIFICADOR";
	public static final String NOMBRE_ARCHIVO_IDENTIFICADOR = "NOMBRE_ARCHIVO_IDENTIFICADOR";

}
