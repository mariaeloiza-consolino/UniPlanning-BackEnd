FROM ubuntu:24.04

ENV DEBIAN_FRONTEND=noninteractive

RUN apt-get update && apt-get install -y \
    git \
    git-lfs \
    openjdk-21-jdk \
    maven \
    mysql-server \
    && rm -rf /var/lib/apt/lists/*

RUN echo "CREATE USER 'Maria'@'localhost' IDENTIFIED BY 'Elo201205!'; \
        GRANT ALL PRIVILEGES ON *.* TO 'Maria'@'localhost' WITH GRANT OPTION; \
        CREATE DATABASE Uniplanning; \
        FLUSH PRIVILEGES;" > /tmp/script.sql

RUN service mysql start && \
    sleep 5 && \
    mysql -uroot < /tmp/script.sql && \
    service mysql stop

WORKDIR /workspaces

CMD [ "bash" ]