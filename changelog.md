1) Crea un GreeterController que reciba un nombre como request y devuelva un saludo a dicho nombre
(TODO, pending)

2) Caso de uso registrar un estudiante
   Diseña el test unitario y la implementación que satisfaga el caso de uso de Registrar un nuevo estudiante en la plataforma.

3) Crea un nuevo endpoint que reciba la peticion de registrar un nuevo estudiante (o utiliza uno existente) de modo que la comunicación con el application service se realice vía RegisterUserRequest, y si añades la validación del nombre (limite de 40 caracteres) y email vía Value Object

4) Siguiendo el ejemplo de este repositorio, crea un nuevo ObjectMother para la entidad Student y los Value Objects que estimes necesarios para poder mejorar nuestros tests unitarios.

5) Implementa el repositorio de Video para MySql aprovechando la configuración para Hibernate que hemos visto anteriormente de modo que podamos buscar un video concreto por su ID.

6) Siguiendo con los ejemplos vistos en este repositorio, crea la aplicación de Mooc Frontend y prepara las configuraciones mínimamente necesarias para poder levantarla.

7) En el mismo repo crea el test para validar la correcta integración con la persistencia en memoria que nos permita almacenar nuevos estudiantes, una vez lo tengas listo.

8) Mejora el test de integración de Curso o Estudiante añadiendo su propio data provider. (TODO)

9)  Crea un evento de dominio que se publique cada vez que un nuevo estudiante se registra en la aplicación de Mooc, de modo que otras piezas de la aplicación puedan reaccionar a dicho evento. (TODO)

