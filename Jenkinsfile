pipeline {
    agent any

    stages {
        stage('git') {
            steps {
                git branch: 'moemen2', credentialsId: '9154784c-eb82-4f58-9606-8fd50e25cf28', url: 'https://github.com/ghassensaaf/dev-ops-back-repo.git'
            }
        }
        
        stage('MavenClean') {
            steps {
               sh 'mvn clean'
            }
        }
        stage('MavenCompile') {
            steps {
               sh 'mvn compile'
            }
        }
        stage('MVN DEPLOY') {
            steps {
                sh 'mvn clean deploy -Dmaven.test.skip=true';
            }
        }
        stage('Maven SonarQube') {
            steps {
               sh 'mvn clean package sonar:sonar -Dsonar.login=admin -Dsonar.password=root'
            }
        }
        stage('docker compose'){
            steps{
                echo 'docker compose stage';
                sh 'docker-compose up -d';
            }
        }
    }
}