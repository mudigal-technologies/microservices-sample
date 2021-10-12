FROM digirolamo/microservices-sample:0cc475b

WORKDIR /usr/src/app

#COPY package*.json ./

#RUN npm install


COPY . .

EXPOSE 3000
CMD [ "digirolamo/microservices-sample", "index.js" ]
