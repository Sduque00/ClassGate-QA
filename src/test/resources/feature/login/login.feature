# language: es
Característica: Iniciar sesion
  Como usuario de la pagia del colegio
  Quiero ingresar a la plataforma de ClassGate
  Para validar el correcto funcionamiento

  @IniciarSesion
  Esquema del escenario: Inicio de sesion
    Dado que el usuario se encuentra en la pagina
    Cuando inicia sesion con sus credenciales
      | username | <username> |
      | password | <password> |
    Entonces el usuario podra ver su correo en la pagina web
    Ejemplos:
      | username                 | password  |
      | administrativo@gmail.com | 123456789 |
      | maestro@gmail.com        | 123456789 |
      | acudiente@gmail.com      | 123456789 |

