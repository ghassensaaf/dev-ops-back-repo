pipeline {
  agent any

  stages {
    stage('Pull Git') {
      steps {
        echo 'Pulling ... ';
        git branch: 'emna', credentialsId: 'Github', url: 'https://github.com/ghassensaaf/dev-ops-back-repo.git';
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
