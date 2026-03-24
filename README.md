# AREP-exam-T2-proxy

## MathService 1
![alt text](assets/service1.png)

## MathService 2
![alt text](assets/service2.png)

## Proxy
![alt text](assets/apache.png)

El proxy apunta a cada una de las 2 instancias donde estan los servicios

![alt text](assets/proxy-url-servers.png)

Se configuran los CORS para que el proxy acepte las peticiones del front

![alt text](assets/cors.png)

Si ambos servidores estan corriendo, el servidor 1 responde

![alt text](assets/both-servers.png)

Si el servidor 1 se apaga, el proxy intenta llamarlo pero no respondera, por lo que luego llamara al servidor 2 respondiendo

![alt text](assets/server2.png)

Por ultimo, si ambos se apagan muestra un mensaje

![alt text](assets/no-servers.png)

## Apache
![alt text](assets/apache.png)

El front apunta a la instancia donde se encuentra el proxy

![alt text](assets/front-url-proxy.png)

Donde podemos evidenciar que el proxy responde

![alt text](assets/front-evidence.png)