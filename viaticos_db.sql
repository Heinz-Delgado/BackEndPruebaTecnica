Pasos para restaurar la base de datos

1. Levanta una base de datos con nombre viaticos_db.
2. Copiar el texto que se encuenta en la parte inferior.
3. Realizar los cambios respectivos en la configuracion de acuerdo
   a su usuario y contraseña del gestor de base de datos que use.

-- Tabla de facturas
CREATE TABLE facturas (
    fac_id SERIAL PRIMARY KEY,
    fac_fecha_factura DATE NOT NULL,
    fac_detalle VARCHAR(255) NOT NULL,
    fac_nombre_establecimiento VARCHAR(100) NOT NULL,
    fac_identificacion_establecimiento VARCHAR(20) NOT NULL,
    fac_numero_factura VARCHAR(50) NOT NULL,
    fac_subtotal NUMERIC(10,2) NOT NULL,
    fac_iva NUMERIC(10,2) NOT NULL,
    fac_total NUMERIC(10,2) NOT NULL,
    fac_numero_invitados INT NOT NULL
);

-- Tabla de invitados asociados a una factura
CREATE TABLE invitados (
    inv_id SERIAL PRIMARY KEY,
    inv_factura_id INT NOT NULL,
    inv_nombre VARCHAR(100) NOT NULL,
    inv_cargo VARCHAR(100) NOT NULL,
    FOREIGN KEY (inv_factura_id) REFERENCES facturas(fac_id)
);


