<?php
$hora_total = @date('H-4:i:s');
$parte = explode(":", $hora_total);
$hora = $parte[0];
$minuto = $parte[1];
$segundo = $parte[2];
$dia = @date('d');
$mes = @date('m');
$ano = @date('Y');
?>
<!doctype html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Relogio</title>
    <style>
        body {
            width: 100%;
            height: 100%;
        }

        img {
            position: absolute;
        }

        .relogio {
            position: relative;
            width: 100vw;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;

        }


        label {
            z-index: 0;
            color: white;
        }

        .one {
            position: relative;
            top: -100px;
            z-index: 1;
            left: 2.5%;
        }

        .two {
            position: relative;
            top: 100px;
            z-index: 1;
            left: -2%;
        }

        #ponteiro1 {
            z-index: -1;
        }

        #ponteiro2 {
            z-index: 2;
        }

        #ponteiro3 {
            z-index: 3;
        }

        #ponteiro4 {
            z-index: 4;
        }

    </style>
</head>
<body onload="setInterval('relogio();',1000)">
<div name="relogio" class="relogio">
    <img src="imagens/fundo.png" id="ponteiro1">
    <img src="imagens/horas.png" id="ponteiro2">
    <img src="imagens/minutos.png" id="ponteiro3">
    <img src="imagens/segundos.png" id="ponteiro4">
    <label class="one"></label>
    <label class="two"></label>

</div>

<script>
    let segundo =<?php echo $segundo;?>;
    let minuto =<?php echo $minuto;?>;
    let hora =<?php echo $hora;?>;
    let dia = <?php echo $dia;?>;
    let mes = <?php echo $mes;?>;
    let ano = <?php echo $ano;?>;
    let divisor_hora;
    let divisor_minuto;
    let divisor_segundo;
    let ponteiro_segundos = document.querySelector("#ponteiro4");
    let ponteiro_minutos = document.querySelector("#ponteiro3");
    let ponteiro_horas = document.querySelector("#ponteiro2");
    let aux_seg;
    let deg_seg;
    let aux_min;
    let deg_min;
    let aux_hora;
    let deg_hora;


    function relogio() {

        if (segundo < 59)
            segundo += 1;

        else if (segundo == 59) {
            segundo = 0;

            if (minuto < 59)
                minuto += 1;

            else if (minuto == 59) {
                minuto = 0;


                if (hora < 23)
                    hora += 1;

                else if (hora == 23) {
                    dia += 1;
                    hora = 0;
                }
            }
        }

        aux_seg = segundo * 6;
        deg_seg = aux_seg + "deg";
        aux_min = minuto * 6;
        deg_min = aux_min + "deg";
        aux_hora = 30 * hora + minuto * 0.1;
        deg_hora = aux_hora + "deg";
        ponteiro_horas.style.transform = "rotate(" + deg_hora + ")";
        ponteiro_minutos.style.transform = "rotate(" + deg_min + ")";
        ponteiro_segundos.style.transform = "rotate(" + deg_seg + ")";

        divisor_hora = hora < 10 ? "0" : "";
        divisor_minuto = minuto < 10 ? "0" : "";
        divisor_segundo = segundo < 10 ? "0" : "";

        divisor_dia = dia < 10 ? "0" : "";
        divisor_mes = mes < 10 ? "0" : "";
        divisor_ano = ano < 10 ? "0" : "";

        document.querySelector(".one").innerHTML = (divisor_hora + hora + ":" + divisor_minuto + minuto + ":" + divisor_segundo + segundo);
        document.querySelector(".two").innerHTML = (divisor_dia + dia + "/" + divisor_mes + mes + "/" + divisor_ano + ano);

    }
</script>
</body>
</html>
