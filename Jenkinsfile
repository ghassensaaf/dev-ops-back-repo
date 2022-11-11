pipeline {
  agent any

  stages {
    stage('Pull Git') {
      steps {
        echo 'Pulling ... ';
        git branch: 'ahmed', credentialsId: 'a9553f33-b2c3-4eff-94c1-a6dc9703d28d', url: 'https://github.com/ghassensaaf/dev-ops-back-repo.git';
      }
    }
    stage('MVN Package') {
      steps {
        sh 'mvn --version';
        sh 'java -version';
        sh 'mvn package -e';
      }
    }

    stage('DOCKER Compose') {
      steps {
        echo 'docker compose stage';
        sh 'docker-compose up -d'
      }
    }

    stage('SonarQube analysis ') {
    steps {
        sh 'mvn clean package sonar:sonar -Dsonar.login=admin -Dsonar.password=root'
    }
    }
  }
}