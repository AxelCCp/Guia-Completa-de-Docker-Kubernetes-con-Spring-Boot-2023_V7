package ms.usuarios.server.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

//1.-FEIGN ORIGINAL
//CLASE53
//2.-SE CAMBIA FEIGN PARA CONECTAR LA IMAGEN DE DOCKER DE USUARIOS CON EL MICROSERVICIO CURSOS EN LOCAL.  
//CLASE 70
//3.-SE MODIFICA LA CONEXIÓN DE FEIGN. EL host.docker.internal SE USABA YA QUE USUARIOS LEVANTABA EN CONTENEDOR MIENTRAS QUE CURSOS LEVANTABA EN LOCAL. Y AHORA..
//..COMO LOS DOS MICROSERVICIOS VAN A LEVANTAR EN CONTENEDOR YA NO SE USA host.docker.internal ,  SINÓ QUE SE PONE EL NOMBRE QUE SE LE VA A PONER AL CONTENEDOR..
//..DEL MICROSERVICIO CURSOS. EN EL FEIGN DEL OTRO MICROSERVICIO SE HACE LO MISMO.
//CLASE 156
//4.-MODIFICA FEIGN YA Q SE VA A USAR SPRING CLOUD KUBERNETES.

//1
//@FeignClient(name="cursos", url="localhost:8002")   //PARA CONECTAR DIRECTAMENTE CON EL MICROSERVICIO.
//2
//@FeignClient(name="cursos", url="host.docker.internal:8002")
//3
//@FeignClient(name="cursos", url="cursos:8002")
//4
//@FeignClient(name="ms-cursos-server", url="localhost:8002")
//@FeignClient(name="ms-cursos-server", url="ms-cursos-server:8002")


@FeignClient(name="ms-cursos-server", url="${msvc.cursos.url}")
public interface ICursoFeignClient {
	
	@DeleteMapping("/eliminar-curso-usuario/{id}")
	public void eliminarCursoUsuario(@PathVariable Long id);
}
