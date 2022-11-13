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
        sh 'java -version';
        sh 'mvn clean ';
      }
    }
    stage('MVN TEST') {
      steps {
        sh 'mvn test ';
      }
    }

    stage('MVN COMPILE') {
      steps {
        sh 'mvn compile ';
      }
    }
    stage('DEPLOY DOCKER IMAGE TO NEXUS') {
      steps {
        sh 'mvn compile jib:build -DsendCredentialsOverHttp=true -Djib.httpTimeout=0 -e -X';
      }
    }
    stage('MVN DEPLOY') {
      steps {
        sh 'mvn deploy -Dmaven.test.skip=true';
      }
    }

    stage('MVN SONARCUBE') {
      steps {
        sh 'mvn package sonar:sonar -Dsonar.login=admin -Dsonar.password=Za3maettal3ou';
      }
    }

    stage('DOCKER Compose') {
      steps {
        echo 'docker compose stage';
        sh 'docker-compose up -d --force-recreate'
      }
    }
  }
}