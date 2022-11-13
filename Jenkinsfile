pipeline {
  agent any

  stages {
    stage('Pull Git') {
      steps {
        echo 'Pulling ... ';
        git branch: 'emna', credentialsId: 'github', url: 'https://github.com/ghassensaaf/dev-ops-back-repo.git';
      }
    }
    stage('MVN Package') {
      steps {
    
        sh 'java -version';
     
      }
    }
  }
}
