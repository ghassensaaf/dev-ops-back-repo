pipeline {
  agent any

  stages {
    stage('Pull Git') {
      steps {
        echo 'Pulling ... ';
        git branch: 'ghassen', credentialsId: 'Github', url: 'https://github.com/ghassensaaf/dev-ops-back-repo.git';
      }
    }
    stage('MVN clean install') {
      steps {
        sh 'mvn --version';
        sh 'java -version';
        sh 'mvn clean install -e';
      }
    }
  }
}