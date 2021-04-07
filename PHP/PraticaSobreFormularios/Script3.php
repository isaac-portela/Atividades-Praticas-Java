<?php
$x = "a{i}";
for($i = 0, $impar = 1; $i < 1000; $i++, $impar+=2) {
    $x = "a{$i}";
    $$x = $impar;
}
for($i = 0; $i < 1000; $i++) {
    echo "a{$i}" ."= ". ${"a{$i}"}."<br>";
}

?>