TPO PARADIGMA ORIENTADO A OBJETOS

Integrantes - Grupo 1:
Bruno Gustavo Ezequiel
Fernandez Jimena
Irigoyen, Ochoa Paloma 
Roubineau C. Augusto

Descripción
  Este proyecto es una aplicación orientada a objetos para la gestión de vehículos en una concesionaria. Permite a los usuarios realizar operaciones sobre diferentes tipos de vehículos, como registrar, actualizar y mostrar detalles específicos de cada vehículo, así como   gestionar las ventas de los mismos. La aplicación utiliza una clase abstracta Vehiculo que define las propiedades y métodos comunes a todos los tipos de vehículos, y varias clases específicas como Auto y Moto para manejar diferentes tipos de vehículos. Además, se        utiliza una clase Concecionaria para gestionar los vehículos y las ventas, y una interfaz IPlanPagos para definir y aplicar planes de pago en las ventas.

Clases y Funcionalidades

  Vehiculo:
    La clase Vehiculo es una clase abstracta que implementa la interfaz IDataTableRecord de Utils. Esta clase contiene los atributos y métodos básicos que todos los vehículos deben tener.

  Atributos:
    color: Color del vehículo.
    marca: Marca del vehículo.
    modelo: Modelo del vehículo.
    anio: Año de fabricación del vehículo.
    patente: Número de patente del vehículo.
    km: Kilometraje del vehículo.
    precio: Precio del vehículo.
  Métodos:
    Getters y Setters para cada uno de los atributos.
    Método abstracto mostrarDetalle(), que debe ser implementado por las subclases para mostrar los detalles específicos de cada tipo de vehículo.
    Método getDataTableRecord(), que devuelve una cadena con la información del vehículo en formato de registro de tabla de datos.

  Auto
    La clase Auto extiende Vehiculo e implementa las funcionalidades específicas de un automóvil.

  Atributos:
    chasis: Número de chasis del automóvil.
    cantidadDePuertas: Cantidad de puertas del automóvil.
  Métodos:
    getChasis(), setChasis(int chasis): Getters y Setters para el número de chasis.
    getCantidadDePuertas(), setCantidadDePuertas(int cantidadDePuertas): Getters y Setters para la cantidad de puertas.
    create(): Método estático para crear una instancia de Auto solicitando los datos al usuario mediante la clase InputFile.
    mostrarDetalle(): Implementación del método abstracto de Vehiculo para mostrar los detalles del automóvil.
    getDataTableRecord(): Implementación del método de IDataTableRecord para devolver una cadena con la información del automóvil en formato de registro de tabla de datos.
  Moto
    La clase Moto extiende Vehiculo e implementa las funcionalidades específicas de una motocicleta.

  Atributos:
    tipoMoto: Tipo de motocicleta (por ejemplo, deportiva, cruiser, etc.).
    cilindrada: Cilindrada de la motocicleta.
  Métodos:
    getCilindrada(), setCilindrada(int cilindrada): Getters y Setters para la cilindrada.
    getTipoMoto(), setTipoMoto(String tipoMoto): Getters y Setters para el tipo de motocicleta.
    create(): Método estático para crear una instancia de Moto solicitando los datos al usuario mediante la clase InputFile.
    mostrarDetalle(): Implementación del método abstracto de Vehiculo para mostrar los detalles de la motocicleta.
    getDataTableRecord(): Implementación del método de IDataTableRecord para devolver una cadena con la información de la motocicleta en formato de registro de tabla de datos.
  Concecionaria
    La clase Concecionaria gestiona los vehículos y las ventas de la concesionaria.

  Atributos:
    vehiculos: Conjunto de vehículos disponibles en la concesionaria.
    ventas: Conjunto de ventas realizadas por la concesionaria.
  Métodos:
    getVehiculos(): Devuelve el conjunto de vehículos disponibles.
    getVentas(): Devuelve el conjunto de ventas realizadas.
  Venta
    La clase Venta representa una transacción de venta en la concesionaria.

  Atributos:
    entregado: Indica si el vehículo ha sido entregado.
    metodoDePago: Método de pago utilizado en la venta.
    precioFinal: Precio final de la venta.
    vehiculo: Vehículo vendido.
    comprador: Nombre del comprador.
    vendedor: Nombre del vendedor.
    planCuotas: Arreglo de cuotas del plan de pago.
  Métodos:
    isEntregado(), setEntregado(boolean entregado): Getter y Setter para el estado de entrega del vehículo.
    getVehiculo(), setVehiculo(Vehiculo vehiculo): Getter y Setter para el vehículo.
    getComprador(), setComprador(String comprador): Getter y Setter para el nombre del comprador.
    getVendedor(), setVendedor(String vendedor): Getter y Setter para el nombre del vendedor.
    getMetodoDePago(), setMetodoDePago(String metodoDePago): Getter y Setter para el método de pago.
    getPrecioFinal(), setPrecioFinal(double precioFinal): Getter y Setter para el precio final.
    getPlanCuotas(), setPlanCuotas(Integer[] planCuotas): Getter y Setter para el plan de cuotas.
    create(List<Vehiculo> vehiculoList): Método estático para crear una instancia de Venta solicitando los datos necesarios al usuario.
    getDataTableRecord(): Implementación del método de IDataTableRecord para devolver una cadena con la información de la venta en formato de registro de tabla de datos.
    mostrarDetalle(): Muestra los detalles completos de la venta.
  IPlanPagos
    La interfaz IPlanPagos define los métodos necesarios para implementar planes de pago en las ventas de la concesionaria.

  Métodos:
    ejecutarPlanPagos(Venta venta): Aplica el plan de pagos a la venta proporcionada.
    condicion(Venta venta): Verifica si la venta cumple con las condiciones para aplicar el plan de pagos.
