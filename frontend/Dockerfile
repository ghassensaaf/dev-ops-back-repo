#stage 1
FROM node:16.13.1-alpine as builder
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build --prod
#stage 2
FROM nginx:alpine
COPY --from=builder /app/dist/demo-app /usr/share/nginx/html