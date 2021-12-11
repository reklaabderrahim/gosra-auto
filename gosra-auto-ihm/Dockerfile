FROM node:16.13.1-alpine AS builder

WORKDIR /opt/web
COPY package.json package-lock.json ./
RUN npm ci

ENV PATH="./node_modules/.bin:$PATH"

COPY . ./
RUN npm run build-prod
#RUN mkdir -p dist/gosra-auto-ihm
#RUN echo "Hello, World" > dist/gosra-auto-ihm/index.html

FROM nginx:1.17-alpine
COPY nginx.conf /etc/nginx/conf.d/default.conf
COPY --from=builder /opt/web/dist/gosra-auto-ihm /usr/share/nginx/html
