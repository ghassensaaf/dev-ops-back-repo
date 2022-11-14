pipeline {
  agent any

  stages {
    stage('Pull Git') {
      steps {
        echo 'Pulling ... ';
        git branch: 'emna', credentialsId: 'github', url: 'https://github.com/ghassensaaf/dev-ops-back-repo.git';
      }
    }
	  

		  	  stage('MVN Clean') {
      steps {
        sh 'mvn clean';
      }
    }
	  
         stage ('MVN compiler')
        {
         steps{
                sh 'mvn compile'
            }
        }
	    stage('MVN TEST') {
      steps {
        sh 'mvn test ';
      }
    }

  



	  
	 stage('SonarQube ') {
			steps {
				sh "mvn  sonar:sonar -Dsonar.projectKey=devops  -Dsonar.host.url=http://192.168.33.10:9000  -Dsonar.login=9c54388b097c42413bd59a7fea79f45388282879"
			}
		        post {
				always {
					jacoco execPattern: 'target/jacoco.exec'
				       }    
			    } 
		 }  
	  
	  
	  
	   stage ('Nexus') {
            steps {
            echo "Nexus";
                sh 'mvn clean deploy -DskipTests -Dmaven.install.skip=true';
            }
        }
	  


	/*  stage('Docker Build and Push') {
                       steps {
                               withDockerRegistry([credentialsId: "docker-hub", url: ""]) {
         			  sh 'printenv'
        			  sh 'docker build -t emnaa/emnaa .'
	 			  sh 'docker tag emnaa/emnaa emnaa/emnaa:latest'
         			  sh 'docker push emnaa/emnaa:latest'
         			}
     			  }
	  }/*
	  }
	  }
	 

	
     

    

  

	    




  
	
  
	
