package ec.com.uce.web.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.entities.Catalogo;
import ec.com.uce.dione.entities.DetalleCatalogo;
import ec.com.uce.dione.entities.Menu;
import ec.com.uce.dione.entities.Rol;
import ec.com.uce.dione.entities.RolMenu;
import ec.com.uce.dione.entities.Usuario;
import ec.com.uce.dione.enumeration.EstadoEnum;
import ec.com.uce.ejb.dto.MenuDTO;
import ec.com.uce.ejb.service.CatalogoService;
import ec.com.uce.ejb.service.DetalleCatalogoService;
import ec.com.uce.ejb.service.UsuarioService;
import ec.com.uce.web.bean.UsuarioBean;
import ec.com.uce.web.util.HiperionMensajes;
import ec.com.uce.web.util.MessagesController;
import ec.com.uce.web.validator.ValidatorCedula;

@ManagedBean
@SessionScoped
public class UsuarioBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	@EJB
	private UsuarioService usuarioServicio;

	@EJB
	private CatalogoService catalogoService;

	@EJB
	private DetalleCatalogoService detalleCatalogoService;

	private List<SelectItem> rolesItems;

	private MenuModel menumodel = new DefaultMenuModel();
	List<Menu> menuList = new ArrayList<Menu>();
	List<Menu> menuSelectedList = new ArrayList<Menu>();
	List<MenuDTO> menuDTOList = new ArrayList<MenuDTO>();

	Logger log = Logger.getLogger(UsuarioBacking.class);

	@PostConstruct
	public void inicializar() throws DioneException {
		obtenerMenus();
	}

	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	/**
	 * 
	 * <b> Permite autenticar el usuario con la aplicacion </b>
	 * <p>
	 * [Author: Anita Carrera, Date: Dec 6, 2014]
	 * </p>
	 * 
	 * @param actionEvent
	 * @return
	 * @throws DioneException
	 */
	public String login(ActionEvent actionEvent) throws DioneException {
		menumodel = new DefaultMenuModel();
		menuList = new ArrayList<Menu>();

		try {
			String salida = HiperionMensajes.getInstancia().getString("valor.navigation.error");

			RequestContext context = RequestContext.getCurrentInstance();
			FacesMessage msg = null;
			boolean loggedIn;

			Usuario usuario;

			usuario = usuarioServicio.loginUser(usuarioBean.getNombreUsuario(), usuarioBean.getPassword());

			if (usuario != null) {
				loggedIn = true;
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuarioBean.getNombreUsuario());
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", usuarioBean.getNombreUsuario());
				salida = HiperionMensajes.getInstancia().getString("valor.navigation.main");
			} else {
				loggedIn = false;
				msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Invalid credentials");
			}

			// Consultar Roles por usuario
			List<Rol> roles = usuarioServicio.consultarRolByUsuario(usuario);
			// Consultar Menu por roles
			for (Rol rol : roles) {
				List<RolMenu> listRolMenus = usuarioServicio.consultarRolMenus(rol);
				for (RolMenu rolMenu : listRolMenus) {
					menuList.add(rolMenu.getMenu());
				}
			}

			// Agregar menus para el usuario
			List<Menu> listMenuPadres = new ArrayList<Menu>();
			for (Menu menuPadre : menuList) {
				if (menuPadre.getIdPadre() == null) {
					listMenuPadres.add(menuPadre);
				}
			}

			for (Menu menuPadre : listMenuPadres) {
				DefaultSubMenu firstSubmenu = new DefaultSubMenu(menuPadre.getNombreMenu());
				for (Menu menuHijos : menuList) {
					if (menuHijos.getIdPadre() == menuPadre.getIdMenu()) {
						DefaultMenuItem menuItem = new DefaultMenuItem(menuHijos.getNombreMenu());
						menuItem.setUrl(menuHijos.getUrl());

						firstSubmenu.addElement(menuItem);
					}
				}
				menumodel.addElement(firstSubmenu);
			}

			FacesContext.getCurrentInstance().addMessage(null, msg);
			context.addCallbackParam("loggedIn", loggedIn);

			usuarioBean.setSessionUser(usuario);

			return salida;

		} catch (DioneException e) {
			log.error("Error al momento de hacer login", e);
			throw new DioneException(e);
		}

	}

	/**
	 * 
	 * <b> Permite cargar la lista de menus para seleccionar. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 11/01/2015]
	 * </p>
	 * 
	 * @throws DioneException
	 */
	public void obtenerMenus() throws DioneException {
		menuDTOList = new ArrayList<MenuDTO>();

		try {
			List<Menu> menus = usuarioServicio.consultaMenus();

			for (Menu menu : menus) {

				MenuDTO menuDTO = new MenuDTO();

				menuDTO.setIdMenu(menu.getIdMenu());
				menuDTO.setNombreMenu(menu.getNombreMenu());
				menuDTO.setUrl(menu.getUrl());
				if (menu.getIdPadre() != null) {
					menuDTO.setIdPadre(menu.getIdPadre());
				}
				menuDTO.setEstadoMenu(menu.getEstadoMenu());
				menuDTOList.add(menuDTO);
			}

		} catch (DioneException e) {
			log.error("Error al momento de hacer login", e);
			throw new DioneException(e);
		}
	}

	/**
	 * 
	 * <b> Permite agregar los menu a usuario que se esta registrando. </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 11/01/2015]
	 * </p>
	 * 
	 */
	public void agregarMenus() {
		menuSelectedList = new ArrayList<Menu>();
		for (MenuDTO menuDTO : menuDTOList) {
			if (menuDTO.getSelected()) {
				Menu menu = new Menu();

				menu.setIdMenu(menuDTO.getIdMenu());
				menu.setNombreMenu(menuDTO.getNombreMenu());
				menu.setIdPadre(menuDTO.getIdPadre());
				menu.setUrl(menuDTO.getUrl());
				menu.setEstadoMenu(menuDTO.getEstadoMenu());

				menuSelectedList.add(menu);
			}
		}
	}

	/**
	 * 
	 * <b> Permite guardar usuarios en la base de datos </b>
	 * <p>
	 * [Author: Anita Carrera, Date: 10/01/2015]
	 * </p>
	 * 
	 * @throws DioneException
	 * 
	 */
	public void guardarUsuario() throws DioneException {
		try {
			
			ValidatorCedula validar = new ValidatorCedula();

			if (validar.validateCedula(usuarioBean.getIdentificacion())) {
				// Usuario
				Usuario usuario = new Usuario();
				usuario.setUsuario(usuarioBean.getNickname());
				usuario.setNombreUsuario(usuarioBean.getNombreApellido());
				usuario.setIdentificacionUsuario(usuarioBean.getIdentificacion());
				usuario.setClave(usuarioBean.getClave());
				usuario.setEmailUsuario(usuarioBean.getCorreo());
				usuario.setFechaCreacion(new Date());
				usuario.setEstado(EstadoEnum.A);

				Usuario usuarioCreacion = usuarioBean.getSessionUser();
				usuario.setIdUsuarioCreacion(usuarioCreacion.getIdUsuario());

				// Rol de usuario
				Integer idRol = Integer.parseInt(usuarioBean.getRol());
				DetalleCatalogo detalleCatalogo = detalleCatalogoService.consultarDetalleByCatalogoAndDetalle(HiperionMensajes.getInstancia()
						.getInteger("recursos.catalogoRoles"), idRol);
				Rol rol = new Rol();

				rol.setDescripcionRol(detalleCatalogo.getDescDetCatalogo());
				rol.setEstadoRol(EstadoEnum.A);
				rol.setNombreRol(detalleCatalogo.getDescDetCatalogo());

				usuarioServicio.guardarUsuario(usuario, rol, menuSelectedList);

				MessagesController.addInfo(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.exito.usuario"));

				menuSelectedList = new ArrayList<Menu>();
				usuarioBean.setNickname("");
				usuarioBean.setNombreApellido("");
				usuarioBean.setIdentificacion("");
				usuarioBean.setClave("");
				usuarioBean.setCorreo("");
				usuarioBean.setNickname("");
				usuarioBean.setRol(null);
			}else{
				MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensage.error.identificacionNoValido"));
			}
		} catch (DioneException e) {
			log.error("Error al momento de guardar el usuario", e);
			MessagesController.addError(null, HiperionMensajes.getInstancia().getString("hiperion.mensaje.error.save"));
			throw new DioneException(e);
		}
	}

	/**
	 * @return the menumodel
	 */
	public MenuModel getMenumodel() {
		return menumodel;
	}

	/**
	 * @param menumodel
	 *            the menumodel to set
	 */
	public void setMenumodel(MenuModel menumodel) {
		this.menumodel = menumodel;
	}

	/**
	 * @return the menuList
	 */
	public List<Menu> getMenuList() {
		return menuList;
	}

	/**
	 * @param menuList
	 *            the menuList to set
	 */
	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	/**
	 * @return the rolesItems
	 * @throws DioneException
	 */
	public List<SelectItem> getRolesItems() throws DioneException {
		this.rolesItems = new ArrayList<SelectItem>();
		Catalogo catalogo = catalogoService.consultarCatalogoById(HiperionMensajes.getInstancia().getLong(
				"recursos.catalogoRoles"));
		List<DetalleCatalogo> roles = catalogo.getDetalleCatalogos();

		for (DetalleCatalogo detalle : roles) {
			SelectItem selectItem = new SelectItem(detalle.getCodDetalleCatalogo(), detalle.getDescDetCatalogo());
			rolesItems.add(selectItem);
		}

		return rolesItems;
	}

	/**
	 * @param rolesItems
	 *            the rolesItems to set
	 */
	public void setRolesItems(List<SelectItem> rolesItems) {
		this.rolesItems = rolesItems;
	}

	/**
	 * @return the menuDTOList
	 */
	public List<MenuDTO> getMenuDTOList() {
		return menuDTOList;
	}

	/**
	 * @param menuDTOList
	 *            the menuDTOList to set
	 */
	public void setMenuDTOList(List<MenuDTO> menuDTOList) {
		this.menuDTOList = menuDTOList;
	}

}
