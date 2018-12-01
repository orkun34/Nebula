FROM mysql
# Add a database
ENV MYSQL_DATABASE adventureworks
# Add the content of the sql-scripts/ directory to your image
# All scripts in docker-entrypoint-initdb.d/ are automatically
# executed during container startup
COPY ./db/adventureworks_productreview.sql/ /docker-entrypoint-initdb.d/