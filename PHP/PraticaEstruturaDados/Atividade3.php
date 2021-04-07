<?php
$carros = array(
    array("VW", "Gol", "Fox", "Virtus", "Polo"),
    array("GM", "Camaro", 'Cobalt', "Onix", "Montana"),
    array("Fiat", "Strada", "Uno", "Mobi", "Grand Siena"),
    array("Ford", "EcoSport", "Ka Sedan", "Fusion", "New Fiesta Hatch")
);
echo "Carro 4 da VW: " . $carros[0][4] . "</br>";
echo "Carro 1 da Fiat: " . $carros[2][1] . "</br>";
echo "Carro 2 da Ford: " . $carros[3][2];

?>