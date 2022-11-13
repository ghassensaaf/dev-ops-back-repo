# FROM node:16.13.1 as builder
# WORKDIR /app
# COPY . .
# RUN npm install
# RUN npm run build --prod
# $FROM nginx:alpine
# COPY --from=builder /app/dist/demo-app /usr/share/nginx/html
FROM node:16.13.1-alpine as builder

WORKDIR /app

COPY . .

RUN npm install

RUN npm run build