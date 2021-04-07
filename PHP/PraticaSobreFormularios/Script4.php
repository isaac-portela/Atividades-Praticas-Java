<?php
$variaveislAmbiente = array("AUTH_TYPE", "CONTENT_LENGHT", "CONTENT_TYPE", "GATEWAY_INTERFACE", "
HTTP_ACCEPT HTTP_USER_AGENT", "PATH_INFO", "QUERY_STRING", "REQUEST_METHOD", "REMOTE_HOST", "REMOTE_ADDR", "REMOTE_USER", "
REMOTE_INDENT", "SERVER_SOFTWARE", "SERVER_NAME", "SERVER_PROTOCOL", "SERVER_POR", "SCRIPT_NAME");

foreach ($variaveislAmbiente as $variavel) {
    echo "<strong>" . $variavel . ": " . "</strong>" . getenv($variavel) . "<br>" . "<br>";

}
?>