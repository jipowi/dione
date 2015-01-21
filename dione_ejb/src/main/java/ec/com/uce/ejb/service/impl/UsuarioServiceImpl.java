package ec.com.uce.ejb.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.uce.dione.comun.DioneException;
import ec.com.uce.dione.dao.MenuDao;
import ec.com.uce.dione.dao.RolDao;
import ec.com.uce.dione.dao.RolMenuDao;
import ec.com.uce.dione.dao.UsuarioDao;
import ec.com.uce.dione.entities.Menu;
import ec.com.uce.dione.entities.Rol;
import ec.com.uce.dione.entities.RolMenu;
import ec.com.uce.dione.entities.Usuario;
import ec.com.uce.dione.enumeration.EstadoEnum;
import ec.com.uce.ejb.service.UsuarioService;

@Stateless
public class UsuarioServiceImpl implements UsuarioService {

	// @EJB(lookup =
	// "java:global/hiperion_core-1.0/UsuarioDaoImpl!ec.com.avila.hiperion.dao.UsuarioDao")
	@EJB
	private UsuarioDao usuarioDao;

	@EJB
	private RolDao rolDao;

	@EJB
	private MenuDao menuDao;
	
	@EJB
	private RolMenuDao rolMenuDao;
	

	public void guardarUsuario(Usuario usuario, Rol rol, List<Menu> menus) throws DioneException {
		
		usuarioDao.persist(usuario);
		rol.setUsuario(usuario);
		rol.setEstadoRol(EstadoEnum.A);
		rol.setDescripcionRol(rol.getDescripcionRol());
		rolDao.persist(rol);
		
		for(Menu menu: menus){
			RolMenu rolMenu = new RolMenu();
			menu.getEstadoMenu();
			rolMenu.setMenu(menu);
			rolMenu.setRol(rol);
			rolMenuDao.persist(rolMenu);
		}
		
	}

	public List<Usuario> consultarUsuarios() throws DioneException {
		return usuarioDao.findAll();
	}

	public Usuario loginUser(String nombreUsuario, String clave) throws DioneException {
		return usuarioDao.loginUser(nombreUsuario, clave);
	}

	public void modificarUsuario(Usuario usuario) throws DioneException {
		usuarioDao.modificarUsuario(usuario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.UsuarioService#consultarRolByUsuario(ec.com.avila.hiperion.emision.entities.Usuario)
	 */
	@Override
	public List<Rol> consultarRolByUsuario(Usuario usuario) throws DioneException {
		return rolDao.consultarRolByUsuario(usuario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.UsuarioService#consultarMenuByRol(ec.com.avila.hiperion.emision.entities.Rol)
	 */
	@Override
	public List<RolMenu> consultarRolMenus(Rol rol) throws DioneException {
		return menuDao.consultarMenuByRol(rol);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.UsuarioService#consultarMenu(java.lang.Integer)
	 */
	@Override
	public Menu consultarMenu(Integer idMenu) throws DioneException {
		return menuDao.findById(new Long(idMenu));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.UsuarioService#consultarRoles()
	 */
	@Override
	public List<Rol> consultarRoles() throws DioneException {
		return rolDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.UsuarioService#consultaMenus()
	 */
	@Override
	public List<Menu> consultaMenus() throws DioneException {
		return menuDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ec.com.avila.hiperion.servicio.UsuarioService#consultarRolById()
	 */
	@Override
	public Rol consultarRolById(Long idRol) throws DioneException {
		return rolDao.findById(idRol);
	}
}
