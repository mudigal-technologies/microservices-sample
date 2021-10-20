
FROM node:latest 
#con FROM specifico l'immagine base da cui partire per costruirne una di nuova 

#WORKDIR /usr/src/app

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
#COPY  --chown=www-data:www-data  /Results /usr/src/app
#RUN npm install
#RUN chown 777 /microservices-sample/Results
#RUN chown 777 /Results/Linux_Baseline_report.html
#RUN chown -R tmp log

#COPY --from=digirolamoluca/microservices-sample:latest somefile somefile

EXPOSE 3000
#CMD [ "node", "index.js" ]
