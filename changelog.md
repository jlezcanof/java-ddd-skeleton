1) Crea un GreeterController que reciba un nombre como request y devuelva un saludo a dicho nombre
(TODO, pending)

2) Caso de uso registrar un estudiante
   Diseña el test unitario y la implementación que satisfaga el caso de uso de Registrar un nuevo estudiante en la plataforma.

3) Crea un nuevo endpoint que reciba la peticion de registrar un nuevo estudiante (o utiliza uno existente) de modo que la comunicación con el application service se realice vía RegisterUserRequest, y si añades la validación del nombre (TODO limite de 36 caracteres) y email vía Value Object.

4) Siguiendo el ejemplo de este repositorio, crea un nuevo ObjectMother para la entidad Student y los Value Objects que estimes necesarios para poder mejorar nuestros tests unitarios.

5) Implementa el repositorio de Video para MySql aprovechando la configuración para Hibernate que hemos visto anteriormente de modo que podamos buscar un video concreto por su ID.

6) Siguiendo con los ejemplos vistos en este repositorio, crea la aplicación de Mooc Frontend y prepara las configuraciones mínimamente necesarias para poder levantarla.

7) En el mismo repo crea el test para validar la correcta integración con la persistencia en memoria que nos permita almacenar nuevos estudiantes.

8) Mejora el test de integración de Curso o Estudiante añadiendo su propio data provider. (TODO)

9)  Crea un evento de dominio que se publique cada vez que un nuevo estudiante se registra en la aplicación de Mooc, de modo que otras piezas de la aplicación puedan reaccionar a dicho evento.

10) Tal como hemos visto en el caso del backend del Mooc en el repo, prepara el comando necesario para recuperar en el backend del Backoffice los eventos que se hayan almacenado en BD.

11) Crea un publicador en memoria en el repo utilizado en el curso que actúe a modo de fallback cuando el EventBus de MySql falle.

12) Actualmente la clase RabbitMqEventBusShould solamente comprueba si se publica y consume correctamente un evento.

Se puede agregar casos de test para los siguientes escenarios:

Comprobar si se dispara una exception al consumir eventos no existentes
Comprobar si se reintenta un evento
Comprobar se se envia la dead letter despues de reintentar varias veces.
TODO

13) Crear comando para registrar estudiante (CreateStudentCommand)

14) Crea el módulo relativo al contador de videos, el cual contiene el caso de uso de obtener total de videos de un curso.

15) Formulario registrar estudiante: crea el formulario necesario para registrar un nuevo estudiante en el sistema.

16) Crear proyeccion de videos en el backoffice: prepara la infraestructura necesaria para poder contar con una proyección de los videos que se añadan desde el contexto de Mooc y acceder a ella vía controller. (mirar el problema de mapeo con backofficeVideo TODO)

17) Añade lo necesario para poder filtrar Videos vía Controller (Quizás tengas que crear el Controller si no existe aún en el repositorio).

18) Integra el repositorio de Cursos con Elasticsearch en el contexto de Mooc del repositorio para que podamos disponer también de esta integración además de la existente con MySql.
pendiente upgradear libreria elastic search a 7.x

19) Añade cualquiera de las alternativas de cache que hemos visto en la lección a la consulta del listado de Cursos en el Backoffice:
    - crear cache control y etag como ejemplo en videos get controller
    alternativas: etag, expires, last-modified, cache-control

   beneficio: la peticion mas rapida es la que no se hace

   alternativa servidor revers proxy:
   ejemplos: varnish, akamai, fastly, cloudfront, cloudfare
   beneficio: cualquier ya se beneficia

   complicado de debugar un problema de caches

   validar caches es un problema en la programacion (cache de servidor como proxy reverso)
   https://www.baeldung.com/etags-for-rest-with-spring



