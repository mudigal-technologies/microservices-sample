/*FROM node:latest

WORKDIR /usr/src/app

COPY package*.json ./

RUN npm install
RUN curl -fsSLO  https://get.docker/builds/Linux/x86_64/docker-17.04.0-ce.tgz  \
  && tar xzvf docker-17.04.0-ce.tgz \
  && mv docker/docker /usr/local/bin \
  && rm -r docker docker-17.04.0-ce.tgz

COPY . .

EXPOSE 3000
CMD [ "node", "index.js" ]
*/

# Dockerfile for the main wordpress container 
# Change the version if you want more up-to-date wordpress installation. 4.8 = mid-2017
FROM wordpress:4.8-php7.1-apache

COPY  --chown=www-data:www-data /html /usr/src/wordpress
