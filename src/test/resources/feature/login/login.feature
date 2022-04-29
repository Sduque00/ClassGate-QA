# language: es
Característica: Iniciar sesion
  Como usuario de la pagia del colegio
  Quiero ingresar a la plataforma de ClassGate
  Para validar el correcto funcionamiento

  @IniciarSesionAdministrador
  Esquema del escenario: Inicio de sesion administrador
    Dado que el administrador se encuentra en la pagina
    Cuando inicia sesion con sus credenciales
      | username | <username> |
      | password | <password> |
    Entonces el administrador podra ver su correo en la pagina web
    Ejemplos:
      | username                 | password  |
      | administrativo@gmail.com | 123456789 |

    @IniciarSesionMaestro
    Escenario: Inicio de sesion maestro
      Dado que el maestro se registro y se encuentra en el inicio de sesion
      Cuando llena el formulario y confirma la accion
      Entonces el maestro podra ver su correo en la pagina web

