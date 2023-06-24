# Proyecto OO2-24

---

## Pasos a seguir:

1. **Clonar el proyecto** desde el repositorio (Desde la branch main).

---

2. Ejecutar el script SQL con la siguiente línea: `create schema bd_oo2_24`. Esto creará el esquema de base de datos necesario.

---

3. En la primera ejecución, asegúrate de que la propiedad `spring.jpa.hibernate.ddl-auto` en el archivo de configuración `app properties` esté configurada como `create-drop`. Esto permitirá que Hibernate cree las tablas en la base de datos y las elimine al cerrar la aplicación.

---

4. Después de la primera ejecución, cambia la propiedad `spring.jpa.hibernate.ddl-auto` a `update` en el archivo de configuración. Esto actualizará el esquema de la base de datos existente en lugar de eliminarlo y recrearlo.

---

5. Para registrar nuevos usuarios, accede a la ruta `/register` en la aplicación. Alternativamente, en la página de inicio de sesión, hay un botón que redirecciona automáticamente a la página de registro. Si deseas tener un rol de administrador, ingresa la contraseña `unlaAdmin1234*` en el campo `adminPassword`.

---

6. ¡Ahora puedes utilizar la plataforma normalmente!

---



