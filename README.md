Laboratorio PAW 2C 2014
===

##Instrucciones de Configuración para Eclipse##

1. Instalar el Eclipse
2. Instalar el plugin m2e para Eclipse desde Help > Install New Software
3. Instalar el plugin de Jetty para Eclipse desde Help > Eclipse Marketplace
4. Desde el Eclipse: Open Perspective > Git > Clone a Git Repository
5. Completar los datos para clonar este repo
6. Seleccionar el repositorio, click derecho > Import Projects > Import Existing Project
7. Ahora en la perspectiva Java, seleccionar la carpeta del projecto, click derecho > Maven > Update Project

Ya todo debería estar funcionando. Para probarlo, seleccionar la carpeta del projecto, click derecho > Run As > Maven Install

**El árbol del projecto te debería quedar así:**

![ProjectTree](http://i57.tinypic.com/205z77s.png)

Si no obtuvimos ningún error en el *maven install*, seleccionar la carpeta del projecto, click derecho > Run As > Run with Jetty. 

Y listo!

**Por favor, antes de comitear, siempre hacer un maven clean.**
