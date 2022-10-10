pipeline {
    agent any

    stages {
        stage('git') {
            steps {
                git branch: 'moemen', credentialsId: '386f4251-25ab-4961-9254-90abf6072f77', url: 'https://github.com/ghassensaaf/dev-ops-back-repo.git'
            }
        }
        
        stage('MavenPackage') {
            steps {
               sh 'mvn package'
            }
        }
    }
}