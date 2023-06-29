package ms.usuarios.server.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="ms-cursos-server")
public interface ICursoFeignClient {
	
	@DeleteMapping("/eliminar-curso-usuario/{id}")
	public void eliminarCursoUsuario(@PathVariable Long id);
}
