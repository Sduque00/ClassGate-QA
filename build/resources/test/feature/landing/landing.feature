# language: es
Característica: Visualizar Landing
  Como usuario de la pagina del colegio
  Quiero ingresar a la plataforma de ClassGate
  Para visualizar las caracteristicas de la herramienta

  @LandingPage
  Escenario: Visualizar landing
    Dado que el usuario ingresa a la plataforma
    Cuando busca la informacion de la herramienta
    Entonces el usuario podrá leer la informacion

  @MuestraSoftware
  Escenario: Muestra del software
    Dado que el usuario ha ingresado a la plataforma
    Cuando busca la informacion del software
    Entonces el usuario podrá ver el funcionamiento