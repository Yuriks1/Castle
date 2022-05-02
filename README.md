##  Castle Native Application Using MongoDB

How to use :

```
    docker volume create castle
   ```
```
    docker network create castle
 ```
```
    docker run -d --name castle --network castle -v castle:/data/db -p 27017:27017 mongo
   ```

```
   ./mvnw package -Dpackaging=docker-native
 ```
