#FROM node:latest

WORKDIR /usr/src/web-application

COPY package*.json ./

RUN npm install


COPY . .

EXPOSE 3000
CMD [ "node", "index.js" ]
