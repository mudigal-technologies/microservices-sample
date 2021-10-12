#IL PROBLEMA DI CHEINSPEC È TUTTO QUI
#FROM digirolamo/microservices-sample:latest

#WORKDIR /usr/src/

#COPY package*.json ./

#RUN npm install

#COPY  --chown=www-data:www-data /html /usr/src/
#COPY . .

#EXPOSE 3000
#CMD [ "digirolamo/microservices-sample", "index.js" ]

#FROM node:latest
FROM digirolamo/microservices-sample:dockerImage

WORKDIR /usr/src/app

#COPY package*.json ./

#RUN npm install


COPY . .

EXPOSE 3000
#CMD [ "node", "index.js" ]
