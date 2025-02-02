-- Eliminar la base de datos si ya existe
DROP DATABASE IF EXISTS apiRestaurantes;

-- Crear la base de datos
CREATE DATABASE apiRestaurantes;

-- Usar la base de datos
USE apiRestaurantes;

-- Crear la tabla Restaurante
CREATE TABLE Restaurante (
                             idrestaurante INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                             nombre VARCHAR(100) NOT NULL,
                             descripcion TEXT,
                             tipoCocina VARCHAR(50),
                             tieneTerraza BOOLEAN DEFAULT FALSE,
                             ciudad VARCHAR(100)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1;

-- Insertar datos iniciales en la tabla Restaurante
INSERT INTO Restaurante (nombre, descripcion, tipoCocina, tieneTerraza, ciudad)
VALUES
    ('Restaurante La Terraza', 'Un restaurante con terraza y vistas al mar.', 'Mediterránea', TRUE, 'Barcelona'),
    ('Restaurante El Fogón', 'Cocina tradicional española en un ambiente acogedor.', 'Española', FALSE, 'Madrid'),
    ('Restaurante Sushi Palace', 'El mejor sushi de la ciudad.', 'Japonesa', TRUE, 'Valencia');

-- Crear la tabla Mesa
CREATE TABLE Mesa (
                      idmesa INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                      capacidad INT NOT NULL,
                      precioReserva DECIMAL(10, 2) NOT NULL,
                      incluyeMenuEspecial BOOLEAN DEFAULT FALSE,
                      reservada BOOLEAN DEFAULT FALSE,
                      idrestaurante INT,
                      FOREIGN KEY (idrestaurante) REFERENCES Restaurante(idrestaurante)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1;

-- Insertar datos iniciales en la tabla Mesa
INSERT INTO Mesa (capacidad, precioReserva, incluyeMenuEspecial, reservada, idrestaurante)
VALUES
    (4, 50.00, TRUE, FALSE, 1),  -- Mesa para 4 personas en Restaurante La Terraza
    (2, 30.00, FALSE, TRUE, 1),   -- Mesa para 2 personas en Restaurante La Terraza (reservada)
    (6, 80.00, TRUE, FALSE, 2),   -- Mesa para 6 personas en Restaurante El Fogón
    (2, 25.00, FALSE, FALSE, 3),  -- Mesa para 2 personas en Restaurante Sushi Palace
    (4, 60.00, TRUE, FALSE, 3);   -- Mesa para 4 personas en Restaurante Sushi Palace