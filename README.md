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

Ya todo la base debería estar funcionando.


##Instrucciones de Configuración para Postgres##

1. Instalar el Postgres
2. En alguna carpeta fuera de donde clonaste este repo ejecutar desde la línea de comandos

        initdb data

3. En caso de que no tengas por default corriendo el Postgres en el puerto 5432 ejecutá también

        postgres –D data

4. Abrí el pgAdmin III
5. Click derecho a Login Roles > New Login Role
6. En la tab properties escribí "paw" como Role name
7. En la tab definition escribí dos veces "paw" como Password y dale OK
8. Click derecho a Databases > New Database
9. Completá el Name con "hotelapp" y dale OK
8. Ahora Tools > Restore
9. Seleccioná en Filename el archivo HotelDB.backup del repo y dale Restore

Ya todo la base debería estar funcionando. **El árbol del Postgre te debería quedar así.**

![ProjectTree](http://s23.postimg.org/dlv1856jv/Captura_de_pantalla_2014_08_30_a_las_20_46_28.png)

##Instrucciones de Configuración para RazorSQL##

Como no hay nada mejor que el Razor para manejar una base de datos, vamos a usar el Razor para conectarnos a la base de datos Postgres para poder consultarla y editarla.

1. Instalar el RazorSQL
2. Click to Connect to a Database
3. Add Connection Profile
4. Seleccioná PostgreSQL y dale Continue
5. Ponele el nombre que quieras a Profile Name y ahora completá estos datos

*Login*: paw

*Password*: paw

*Host*: localhost

*Port*: 5432

*Database Name*: hotelapp

Dale Connect y listo! Ya te deberías haber conectado a tu base Postgres desde el Razor.

**En caso de que agregués tablas o datos relevantes a la tabla siempre antes de comitear tenés que entrar a pgAdmin III, hacer un backup de la base y pushearla en el repo.**
