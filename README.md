# M.C.D
Calculadora de Máximo Común divisor sin limite de números que muestra procedimiento y combinación lineal

Este programa está basado en el algoritmo de Euclides, el cual permite calcular el máximo común divisor de dos números, también es utilizado para
la encriptación gracias a su algoritmo más avanzado con el que se puede expresar el resultado como una combinación lineal. Este programa se encarga
de realizar los cálculos apropiados y mostrarle al usuario el proceso para llegar al resultado; Es capaz de soportar números grandes y calcular una
gran cantidad de ellos, sin limitaciones.

El programa está diseñado para un fácil uso y entendimiento del mismo, tiene una interfaz sencilla que consta de dos espacios para escribir y un 
solo botón. Luego tiene 3 cuadros de texto que es donde aparecerá la información y procedimiento.

En el primero espacio es donde se debe indicar la cantidad de números que se desea ingresar, es lógico pues que no permite caracteres diferentes a 
los números naturales positivos. Pues con este valor es con el que el programa trabajara el manejo de los números a los quese desea calcular su MCD.

Luego de indicar la cantidad de números se deben ingresar en continuidad y separados por una coma (“,”) los números. Si se realiza mal el proceso el 
programa le indicara cual puede ser el error que haya cometido. 

Cuando se oprime el boton el programa realiza las operaciones por separado, tomando los números ingresados y ordenándolos para su correcta ejecución. 
Luego con ayuda del algoritmo de Euclides calcula el Máximo Común Divisor entre pares de números, este resultado lo compara con el siguiente número y
así sucesivamente hasta evaluarlos todos. En el cuadrante uno(naranja) mostrara el proceso de cálculo del M.C.D y en el cuadrante tres(rojo) el proceso
de despeje. En el segundo cuadrante (azul) es donde se expresarán los números por separado en combinación lineal. Primero mostrando los dos números mas
grandes, luego su resultado lo compara con el tercero si lo hay y así sucesivamente. Si el procedimiento es muy largo se habilita una barra para bajar
o subir en el texto de cada cuadro.

Por último el resultado del M.C.D de los números se mostrará en el mismo espacio donde se notifican los errores. Pero esta vez en color azul, para una 
mejor distinción. El cuadrante verde (cuarto) es una imagen alusiva a una calculadora. 

Se recuerda que no hay problema con la cantidad de números, y es capaz de soporta números grandes. No hay que preocuparse por el orden de los números. 
Lo único a lo que hay que poner atención es que se pongan la cantidad correcta de números que se escogen en el primer cuadro para poner texto, pues de
lo contrario el programa no iniciara su proceso.
