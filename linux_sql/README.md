# Linux Cluster Monitoring Agent
# Introduction
Linux clustering agent is a minimum viable product that aims to record hardware specifications of nodes and resources used by each node in the cluster.
This project creates a psql instance using docker, then bash scripts are used to run commands to fetch hardware specifications and memory usage by the nodes. The data obtained by bash scripts are inserted into the PostgreSQL database by establishing a PostgreSQL database connection. Then, the bash script containing resource usage information is scheduled to run after every minute with the help of crontab to get the real-time records. This project is designed for the Jarvis Cluster Administration team to track and allocate the resources among different nodes. The technologies used for the development of projects are bash scripts, Linux command line interface, PostgreSQL database, git, crontab, and docker.
# Quick Start
- Start pql instance  ./scripts/psql_docker.sh start|stop|create db_username db_password
    - `Run command as`: bash ./scripts/psql_docker.sh start "postgres" "password"
- Create tables using ddl.sql
    - `Run command as`: psql -h localhost -U postgres -d host_agent -f linux_sql/ddl.sql
- Insert hardware specifications using host_info.sh
    - `Run command as`:bash host_info.sh "localhost" 5432 "host_agent" "postgres" "password"
- Insert resource usage information using host_info.sh
    - `Run command as`:bash host_usage.sh "localhost" 5432 "host_agent" "postgres" "password"
- Use Crontab to automate script : crontab -e
    - `Type` * * * * * *  bash /home/centos/dev/jarvis_data_eng_Lovepreet/linux_sql/scripts/host_usage.sh localhost 5432 host_agent postgres password > /tmp/host_usage.log

# Implemenation
1. Set up linux server Centos7 using GCP and create a vm instance.
2. Then, create a psql instance in docker and install psql CLI tool
3. Configure postgresql and create new database named host_agent
4. Write queries in ddl.sql file to create tables host_info and host_usage if it does not exist
5. Create host_info.sh script to collect and insert hardware specifications into the database
6. Create host_usage.sh script to collect and insert resource usage into the database
7. Run host_info.sh once and automate host_usage.sh using crontab to execute the query after every minute to obtain real time data usage.

## Architecture
![pic.png](assets%2Fpic.png)
## Scripts
- **psql_docker.sh**
    - `Usage`: This script creates, starts, or stops a  psql instance in docker.
- **host_info.sh**
    - `Usage`: This script collects hardware specifications in respective environment variables and inserts data into the host_info table.
- **host_usage.sh**
    -  `Usage`:This script collects resource usage in respective environment variables and inserts data into the host_usage table
- **crontab**
    - `Usage`: Crontab is a job scheduler that automated host_usage.sh to run every minute to collect real-time resource usage.
- **ddl.sql**
    - `Usage`: This file creates tables named host_info and host_usage if it does not exist on the system to save time and increase code reusability.

## Database Modeling
- `host_info`:
    - Assign CLI arguments to variables
    - Parse host hardware specifications using bash commands
    - Store the values of each specification in variables
    - Use these variables to make insert statement
    - Execute the script using cli tool
- `host_usage`:
    - Assign CLI arguments to variables
    - Parse host resource information using bash commands
    - Store the host memory usage values in variables
    - Use these variables to make insert statement
    - Execute the script using cli tool

# Test
The scripts were tested on psql cli tool. The Bash -x command expands the output and prints each line in the terminal to track the exact location of the error.

# Deployment
The application was deployed on the Jarvis remote desktop using the Crontab scheduler that automated the host_usage script every minute. The psql client using Docker was created and configured with PostgreSQL to establish a database connection and to store data. All the scripts were pushed to GitHub and git was used for version control. 
# Improvements
- Handle hardware updates
- Handle git rollbacks and commits
- Troubleshoot errors