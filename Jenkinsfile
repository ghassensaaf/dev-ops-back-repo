pipeline {
  agent any

  stages {
    stage('Pull Git') {
      steps {
        echo 'Pulling ... ';
        git branch: 'emna', credentialsId: 'github', url: 'https://github.com/ghassensaaf/dev-ops-back-repo.git';
      }
    }
	  
  /*  stage('Maven SonarQube') {
      steps {
          sh 'mvn clean package sonar:sonar -Dsonar.login=admin -Dsonar.password=emna22448208.'
      }
    }	  
	   stage('Docker compose') {
      		      steps {
         parallel(
           "Docker compose": {
               sh 'docker-compose up '
           },
           "Delete running containers": {
		       sh 'sleep 2m '
               sh 'docker rm -f ci-spring ci-db ci-angular '
           }
         )
       }
  }
	   */
}
}
