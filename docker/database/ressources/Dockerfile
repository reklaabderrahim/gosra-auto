FROM postgres:14.1
ENV TZ=Europe/Paris
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
COPY scripts/init.sql /docker-entrypoint-initdb.d/
