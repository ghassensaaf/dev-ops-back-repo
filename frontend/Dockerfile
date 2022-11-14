# Stage 1: Compile and Build angular codebase

# Use official node image as the base image
FROM node:16.13.1-alpine as build

# Set the working directory
WORKDIR /usr/local/app

# Add the source code to app
COPY ./ /usr/local/app/

# Install all the dependencies
RUN npm ic

# Generate the build of the application
RUN npm install -g @angular/cli@7.3.10

CMD ng serve --host 0.0.0.0
