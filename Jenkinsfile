#!/usr/bin/env groovy

pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "Maven"
    }

    stages {
        stage('git') {
            steps {

               git credentialsId: 'git-credentials', url: 'https://github.com/marouane-elm/Personnel-BTP.git'

            }


        }
        stage('build') {
            steps {
                bat 'mvn clean install -DskipTests'

            }

        }

        stage('docker build'){
            steps {
                bat 'docker build -t btp-personnal-microservice-image .'

            }
        }
        stage('run microservice container'){
            steps{
                bat 'docker run --network btpnetwork -p 8081:8081 --net btpnetwork --name btp-personnal-microservice btp-personnal-microservice-image:latest'
            }
        }
        }


        }