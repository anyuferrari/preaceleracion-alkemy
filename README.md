# preaceleracion-alkemy
Repositorio creado para la preaceleración de Alkemy


# Devoluciones
## Semana 1
No hace falta que llames "Entity" a cada entidad , al estar dentro del package "entity" se sobreentiende que estamos hablando de entidades, queda redundante. Al renombrar las clases quitandole el "Entity" hace que La anotacion @Table este de mas. Esto es porque la anotacion @Entity ya te crea una tabla automáticamente en la base de datos con el nombre que vos le pongas a la clase de java. Si vos queres crear una tabla con el mismo nombre que la entidad, con la anotacion @Entity ya basta. Si vos queres crear una entidad y a la tabla ponerle un nombre diferente esta bien usar la anotacion @Table, pero este no es el caso. Hablando del @GeneratedValue en el ID: En todas las bases de datos, especialmente en MySQL se suele usar GenerationType.IDENTITY en vez de GenerationType.SEQUENCE, funciona mucho mejor y ademas de que SEQUENCE te crea una tabla extra. El SEQUENCE se suele usar en ORACLE DATABASE porque IDENTITY rompe en esta base. En la clase PaisEntity, el campo "continenteId" estaria sobrando en este caso. Cuando creas el campo ContienenteEntity le estas especificando en el @JoinColumn("continente_id") y eso te crea automaticamente el campo genero_id en la base. Por ende no haria falta ponerlo nuevamente. 
