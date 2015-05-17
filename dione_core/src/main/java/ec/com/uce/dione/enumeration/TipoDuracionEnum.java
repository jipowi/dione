/**
 * Ministerio de Educaci&oacute;n del Ecuador
 * 
 * Producto: Sistema de Gesti&oacute;n de Docentes
 * Creado:  25/09/2014
 * 
 * Todos los Derechos Reservados 2014
 */
package ec.com.uce.dione.enumeration;

/**
 * 
 * <b> Permite crear un catalogo para los tipos de duracion </b>
 * 
 * @author Anita Carrera
 * @version 1.0,Dec 2, 2014
 * @since JDK1.6
 */
public enum TipoDuracionEnum {
	A("ANIOS"), M("MESES"), D("DIAS"), H("HORAS");

	private String label;

	private TipoDuracionEnum(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
