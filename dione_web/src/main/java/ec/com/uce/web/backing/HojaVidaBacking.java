package ec.com.uce.web.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import ec.com.uce.dione.enumeration.TipoDuracionEnum;
import ec.com.uce.web.bean.HojaVidaBean;

@ManagedBean
@SessionScoped
public class HojaVidaBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{hojaVidaBean}")
	private HojaVidaBean hojaVidaBean;

	private List<SelectItem> tipoDuracionList;

	/**
	 * @return the hojaVidaBean
	 */
	public HojaVidaBean getHojaVidaBean() {
		return hojaVidaBean;
	}

	/**
	 * @param hojaVidaBean
	 *            the hojaVidaBean to set
	 */
	public void setHojaVidaBean(HojaVidaBean hojaVidaBean) {
		this.hojaVidaBean = hojaVidaBean;
	}

	public List<SelectItem> getTipoDuracionList() {
		if (this.tipoDuracionList == null) {
			this.tipoDuracionList = new ArrayList<SelectItem>();

			SelectItem anios = new SelectItem(TipoDuracionEnum.A, TipoDuracionEnum.A.getLabel());
			this.tipoDuracionList.add(anios);
			SelectItem meses = new SelectItem(TipoDuracionEnum.M, TipoDuracionEnum.M.getLabel());
			this.tipoDuracionList.add(meses);
			SelectItem dias = new SelectItem(TipoDuracionEnum.D, TipoDuracionEnum.D.getLabel());
			this.tipoDuracionList.add(dias);
			SelectItem horas = new SelectItem(TipoDuracionEnum.H, TipoDuracionEnum.H.getLabel());
			this.tipoDuracionList.add(horas);

		}
		return this.tipoDuracionList;
	}

}
