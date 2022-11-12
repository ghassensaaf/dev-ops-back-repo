pipeline {
  agent any

  stages {
    stage('Pull Git') {
      steps {
        echo 'Pulling ... ';
        git branch: 'ghassen', credentialsId: 'Github', url: 'https://github.com/ghassensaaf/dev-ops-back-repo.git';
      }
    }
    stage('MVN CLEAN') {
      steps {
        sh 'mvn --version';
        sh 'java -version';
        sh 'mvn clean ';
      }
    }
    stage('MVN COMPILE') {
      steps {
        sh 'mvn compile ';
      }
    }
    stage('MVN COMPILE JIB') {
      steps {
        sh 'mvn compile jib:build -DsendCredentialsOverHttp=true -Djib.httpTimeout=0';
      }
    }
    stage('MVN SONARCUBE') {
      steps {
        sh 'mvn clean package sonar:sonar -Dsonar.login=admin -Dsonar.password=Za3maettal3ou';
      }
    }
    stage('DOCKER Compose') {
      steps {
        echo 'docker compose stage';
        sh 'docker-compose up -d'
      }
    }
  }
}