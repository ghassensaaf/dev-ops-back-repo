pipeline {
    agent any

    stages {
        stage('git') {
            steps {
                git branch: 'moemen2', credentialsId: '9154784c-eb82-4f58-9606-8fd50e25cf28', url: 'https://github.com/ghassensaaf/dev-ops-back-repo.git'
            }
        }
        
        stage('MavenPackage') {
            steps {
               sh 'mvn package'
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