# language: es
  Característica: Dado que soy Acudiente
    Cuando quiero registrarme en la plataforma
    Entonces selecciono el formulario de registro e ingreso los datos requeridos: Nombre Acudiente*, Correo*, Dirección*, Celular*
    Entonces la institución ya puede inscribir al estudiante.

  Escenario: Registro de Acudiente
    Dado Que soy un acudiente y deseo registrarme en la plataforma
    Cuando selecciono el formulario de registro e ingreso los campos: Nombre Acudiente, Correo, Direccion y Celular
    Entonces la institucion me asigna un nombre de usuario(correo electronico) y contraseña (identificacion)

