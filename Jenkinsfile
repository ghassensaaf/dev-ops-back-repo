pipeline {
  agent any
  tools {
    maven 'Maven 3.2.1' 
  }
  stages {
    stage('Pull Git') {
      steps {
        echo 'Pulling ... ';
        git branch: 'ghassen', credentialsId: 'Github', url: 'https://github.com/ghassensaaf/dev-ops-back-repo.git';
      }
    }
    stage('MVN Package') {
      steps {
        sh 'mvn --version';
        sh 'java -version';
        sh 'mvn package -e';
      }
    }
  }
}