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
        sh 'sudo chmod 666 /var/run/docker.sock';
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
        sh 'docker-compose up -d'
      }
    }
  }
}