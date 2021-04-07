<?php

echo "<style>
    h2{
        text-align: center;
        font-size: 20px;
        font-weight: normal;
    }
    a{
            text-decoration: none;
           color: blue;
    }
    
</style>";


$link = "br.cefetmg.decom.www";
$array = explode(".", $link);
$linkFuncional = "";
for ($i = count($array) - 1; $i >= 0; $i--) {
    if ($i == 0) {
        $linkFuncional .= $array[$i];
    } else {
        $linkFuncional .= $array[$i] . ".";
    }
}

$ancora = "<a href="."http://". $linkFuncional.">$linkFuncional</a>";
echo "<h2>" . "link: " . $ancora . "</h2>";
?>

