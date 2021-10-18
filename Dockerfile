
#FROM digirolamo/microservices-sample:latest

#WORKDIR /usr/src/

#COPY package*.json ./

#RUN npm install

#COPY  --chown=www-data:www-data /html /usr/src/
#COPY . .

#EXPOSE 3000
#CMD [ "digirolamo/microservices-sample", "index.js" ]

FROM node:latest
#FROM digirolamo/microservices-sample:latest

WORKDIR /usr/src/app

#COPY package*.json ./
#COPY  --chown=www-data:www-data /Results
#RUN npm install
RUN chown -R /Results

#COPY --from=digirolamoluca/microservices-sample:latest somefile somefile

EXPOSE 3000
#CMD [ "node", "index.js" ]
