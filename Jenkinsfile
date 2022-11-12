pipeline {
  agent any

  stages {
    stage('Pull Git') {
      steps {
        echo 'Pulling ... ';
        git branch: 'ahmed', credentialsId: 'a9553f33-b2c3-4eff-94c1-a6dc9703d28d', url: 'https://github.com/ghassensaaf/dev-ops-back-repo.git';
      }
    }
    stage('MVN Clean') {
      steps {
        sh 'mvn clean';
      }
    }

    stage('MVN Compile') {
      steps {
        sh 'mvn compile';
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

    stage('DOCKER Compose') {
      steps {
        echo 'docker compose stage';
        sh 'docker-compose up -d'
      }
    }
  }
}