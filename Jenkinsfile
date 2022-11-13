pipeline {
  agent any

  stages {
    stage('Pull Git') {
      steps {
        echo 'Pulling ... ';
        git branch: 'emna', credentialsId: 'github', url: 'https://github.com/ghassensaaf/dev-ops-back-repo.git';
      }
    }
  stage('Build Artifact - Maven') {
			steps {
				sh "mvn clean package -DskipTests=true"
				archive 'target/*.jar'
			      }
		}
	  
	  stage('SonarQube + JacOcO Analysis') {
			steps {
				sh "mvn  sonar:sonar -Dsonar.projectKey=devops  -Dsonar.host.url=http://192.168.33.10:9000  -Dsonar.login=jenkins"
			}
		        post {
				always {
					jacoco execPattern: 'target/jacoco.exec'
				       }    
			    } 
		 }   
	  
  /* stage('Maven SonarQube') {
      steps {
          sh 'mvn clean package sonar:sonar -Dsonar.login=admin -Dsonar.password=emna22448208.'
      }
    }	 */
	  stage('DOCKER Compose') {
      steps {
        echo 'docker compose stage';
        sh 'docker-compose up -d'
      }
    }
	 
  }
}

